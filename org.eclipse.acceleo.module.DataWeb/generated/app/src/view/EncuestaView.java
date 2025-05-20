package view;

import java.util.List;
import java.util.Scanner;
import view.util.ConsoleUtils;
import survey.*;
import auth.AuthManager;
import auth.Usuario;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Vista para responder encuestas y cuestionarios
 */
public class EncuestaView {
    private Scanner scanner;
    private SurveyManager surveyManager;
    private AuthManager authManager;
    private Timer temporizador;
    private boolean tiempoAgotado;
    
    /**
     * Constructor
     */
    public EncuestaView() {
        scanner = new Scanner(System.in);
        surveyManager = SurveyManager.getInstance();
        authManager = AuthManager.getInstance();
        temporizador = null;
        tiempoAgotado = false;
    }
    
    /**
     * Muestra la lista de encuestas disponibles para el usuario
     */
    public void mostrar() {
        if (!authManager.isAuthenticated()) {
            ConsoleUtils.mostrarError("Debe iniciar sesión para acceder a las encuestas");
            ConsoleUtils.pausar(scanner);
            return;
        }
        
        boolean salir = false;
        
        while (!salir) {
            ConsoleUtils.limpiarPantalla();
            ConsoleUtils.mostrarTitulo("Encuestas y Cuestionarios");
            
            Usuario usuario = authManager.getUsuarioActual();
            String rolActual = usuario.getRolActivo();
            
            List<Encuesta> encuestas = surveyManager.getEncuestasParaRol(rolActual);
            
            if (encuestas.isEmpty()) {
                ConsoleUtils.mostrarAdvertencia("No hay encuestas disponibles para su rol actual");
                ConsoleUtils.pausar(scanner);
                return;
            }
            
            System.out.println("Encuestas disponibles para el rol: " + rolActual + "\n");
            
            for (int i = 0; i < encuestas.size(); i++) {
                Encuesta encuesta = encuestas.get(i);
                if (encuesta.isActiva()) {
                    String tipo = (encuesta instanceof Cuestionario) ? "Cuestionario" : "Encuesta";
                    System.out.println((i + 1) + ". [" + tipo + "] " + encuesta.getTitulo());
                }
            }
            
            ConsoleUtils.mostrarLinea();
            System.out.println("\nOpciones:");
            System.out.println("1. Responder una encuesta");
            System.out.println("2. Ver mis respuestas");
            System.out.println("0. Volver al menú principal");
            
            int opcion = ConsoleUtils.leerOpcion(scanner, 0, 2);
            
            switch (opcion) {
                case 0:
                    salir = true;
                    break;
                case 1:
                    int indice = ConsoleUtils.leerEntero(scanner, "Seleccione el número de la encuesta", 
                            valor -> valor >= 1 && valor <= encuestas.size(), null);
                    
                    if (indice >= 1 && indice <= encuestas.size()) {
                        Encuesta encuesta = encuestas.get(indice - 1);
                        responderEncuesta(encuesta);
                    }
                    break;
                case 2:
                    verMisRespuestas();
                    break;
            }
        }
    }
    
    /**
     * Muestra la interfaz para responder una encuesta o cuestionario
     * @param encuesta Encuesta a responder
     */
    private void responderEncuesta(Encuesta encuesta) {
        if (encuesta == null || !encuesta.isActiva()) {
            ConsoleUtils.mostrarError("La encuesta seleccionada no está disponible");
            ConsoleUtils.pausar(scanner);
            return;
        }
        
        ConsoleUtils.limpiarPantalla();
        ConsoleUtils.mostrarTitulo(encuesta.getTitulo());
        
        System.out.println(encuesta.getDescripcion());
        
        // Verificar si el usuario ya ha completado esta encuesta
        String username = authManager.getUsuarioActual().getUsername();
        List<Respuesta> respuestasUsuario = surveyManager.getRespuestas(encuesta.getId());
        boolean yaRespondida = false;
        
        for (Respuesta r : respuestasUsuario) {
            if (r.getUsuario().equals(username) && r.isCompletada()) {
                yaRespondida = true;
                break;
            }
        }
        
        if (yaRespondida) {
            ConsoleUtils.mostrarAdvertencia("Usted ya ha completado esta encuesta");
            ConsoleUtils.pausar(scanner);
            return;
        }
        
        // Si es un cuestionario, iniciar temporizador
        boolean esCuestionario = encuesta instanceof Cuestionario;
        int tiempoLimite = 0;
        
        if (esCuestionario) {
            Cuestionario cuestionario = (Cuestionario) encuesta;
            tiempoLimite = cuestionario.getTiempoLimite();
            System.out.println("\nTiempo límite: " + tiempoLimite + " minutos");
            
            // Iniciar temporizador
            iniciarTemporizador(tiempoLimite);
        }
        
        ConsoleUtils.pausar(scanner);
        
        // Crear respuesta
        Respuesta respuesta = new Respuesta();
        respuesta.setEncuestaId(encuesta.getId());
        respuesta.setUsuario(username);
        
        // Guardar respuesta incompleta para poder continuarla después
        int idRespuesta = surveyManager.guardarRespuesta(respuesta);
        
        // Mostrar preguntas
        List<Pregunta> preguntas = encuesta.getPreguntas();
        int totalPreguntas = preguntas.size();
        int preguntasRespondidas = 0;
        
        for (int i = 0; i < preguntas.size() && !tiempoAgotado; i++) {
            Pregunta pregunta = preguntas.get(i);
            
            ConsoleUtils.limpiarPantalla();
            if (esCuestionario) {
                ConsoleUtils.mostrarTitulo(encuesta.getTitulo() + " - Tiempo restante: variable minutos");
            } else {
                ConsoleUtils.mostrarTitulo(encuesta.getTitulo());
            }
            
            // Mostrar progreso
            int porcentaje = (int) (((double) i / totalPreguntas) * 100);
            System.out.println("Progreso: " + i + " de " + totalPreguntas + " preguntas (" + porcentaje + "%)");
            
            System.out.println("\nPregunta " + (i + 1) + ":");
            System.out.println(pregunta.getTexto());
            
            if (pregunta.isObligatoria()) {
                System.out.println("(Obligatoria)");
            }
            
            String respuestaTexto = "";
            
            switch (pregunta.getTipo()) {
                case OPCION_MULTIPLE:
                    List<String> opciones = pregunta.getOpciones();
                    for (int j = 0; j < opciones.size(); j++) {
                        System.out.println((j + 1) + ". " + opciones.get(j));
                    }
                    
                    int opcion = ConsoleUtils.leerEntero(scanner, "Seleccione una opción", 
                            valor -> valor >= 1 && valor <= opciones.size(), null);
                    
                    if (opcion >= 1 && opcion <= opciones.size()) {
                        respuestaTexto = String.valueOf(opcion - 1);
                    }
                    break;
                    
                case VERDADERO_FALSO:
                    System.out.println("1. Verdadero");
                    System.out.println("2. Falso");
                    
                    int vf = ConsoleUtils.leerEntero(scanner, "Seleccione una opción", 
                            valor -> valor >= 1 && valor <= 2, null);
                    
                    if (vf == 1) {
                        respuestaTexto = "true";
                    } else if (vf == 2) {
                        respuestaTexto = "false";
                    }
                    break;
                    
                case RESPUESTA_CORTA:
                    respuestaTexto = ConsoleUtils.leerString(scanner, "Su respuesta", 
                            texto -> !pregunta.isObligatoria() || !texto.isEmpty(), "");
                    break;
                    
                case RESPUESTA_LARGA:
                    System.out.println("Escriba su respuesta (línea vacía para terminar):");
                    StringBuilder sb = new StringBuilder();
                    String linea;
                    
                    do {
                        linea = scanner.nextLine();
                        if (!linea.isEmpty()) {
                            sb.append(linea).append("\n");
                        }
                    } while (!linea.isEmpty());
                    
                    respuestaTexto = sb.toString().trim();
                    
                    if (pregunta.isObligatoria() && respuestaTexto.isEmpty()) {
                        System.out.println("La respuesta es obligatoria. Por favor, proporcione una respuesta.");
                        i--; // Repetir pregunta
                        continue;
                    }
                    break;
            }
            
            // Guardar respuesta
            if (!respuestaTexto.isEmpty() || !pregunta.isObligatoria()) {
                respuesta.setRespuesta(pregunta.getId(), respuestaTexto);
                preguntasRespondidas++;
                
                // Actualizar respuesta parcial en la base de datos
                surveyManager.guardarRespuesta(respuesta);
            } else {
                System.out.println("La respuesta es obligatoria. Por favor, proporcione una respuesta.");
                i--; // Repetir pregunta
                ConsoleUtils.pausar(scanner);
            }
            
            // Si se agotó el tiempo, salir del bucle
            if (tiempoAgotado) {
                ConsoleUtils.mostrarAdvertencia("\n¡Tiempo agotado! No se pueden responder más preguntas.");
                break;
            }
        }
        
        // Detener temporizador si estaba activo
        if (temporizador != null) {
            temporizador.cancel();
            temporizador = null;
        }
        
        // Marcar como completada si se respondieron todas las preguntas o si se agotó el tiempo
        boolean completada = preguntasRespondidas == totalPreguntas || tiempoAgotado;
        respuesta.setCompletada(completada);
        
        // Si es encuesta normal, aprobar automáticamente
        if (!esCuestionario) {
            respuesta.setAprobada(true);
        }
        
        // Guardar respuesta final
        surveyManager.guardarRespuesta(respuesta);
        
        ConsoleUtils.limpiarPantalla();
        ConsoleUtils.mostrarTitulo("Encuesta Completada");
        
        int porcentajeCompletado = respuesta.calcularPorcentajeCompletado(totalPreguntas);
        System.out.println("Has respondido " + preguntasRespondidas + " de " + totalPreguntas + 
                           " preguntas (" + porcentajeCompletado + "%)");
        
        if (completada) {
            ConsoleUtils.mostrarExito("¡Encuesta completada con éxito!");
            
            // Si es cuestionario y están habilitados los resultados inmediatos, mostrar resultados
            if (esCuestionario) {
                Cuestionario cuestionario = (Cuestionario) encuesta;
                if (cuestionario.isMostrarResultadosInmediatos()) {
                    int puntuacion = cuestionario.evaluarRespuesta(respuesta);
                    int maximo = cuestionario.calcularPuntuacionMaxima();
                    double porcentaje = maximo > 0 ? ((double) puntuacion / maximo) * 100 : 0;
                    boolean aprobado = cuestionario.esAprobado(puntuacion);
                    
                    System.out.println("\nResultados del cuestionario:");
                    System.out.println("Puntuación obtenida: " + puntuacion + " de " + maximo + 
                                       " (" + String.format("%.2f", porcentaje) + "%)");
                    System.out.println("Resultado: " + (aprobado ? "APROBADO" : "NO APROBADO"));
                    
                    if (!aprobado) {
                        System.out.println("Puntuación mínima requerida: " + cuestionario.getPuntuacionMinima() + "%");
                    }
                } else {
                    System.out.println("\nLos resultados serán revisados por un administrador.");
                }
            }
        } else {
            ConsoleUtils.mostrarAdvertencia("Encuesta incompleta. Puedes continuarla más tarde.");
        }
        
        ConsoleUtils.pausar(scanner);
    }
    
    /**
     * Inicia un temporizador para limitar el tiempo de respuesta
     * @param minutos Tiempo límite en minutos
     */
    private void iniciarTemporizador(int minutos) {
        tiempoAgotado = false;
        
        if (temporizador != null) {
            temporizador.cancel();
        }
        
        temporizador = new Timer();
        temporizador.schedule(new TimerTask() {
            @Override
            public void run() {
                tiempoAgotado = true;
                System.out.println("\n¡TIEMPO AGOTADO! Presione Enter para continuar...");
            }
        }, minutos * 60 * 1000);
    }
    
    /**
     * Muestra las respuestas del usuario actual
     */
    private void verMisRespuestas() {
        ConsoleUtils.limpiarPantalla();
        ConsoleUtils.mostrarTitulo("Mis Respuestas");
        
        String username = authManager.getUsuarioActual().getUsername();
        List<Encuesta> encuestas = surveyManager.getEncuestas();
        
        boolean hayRespuestas = false;
        
        for (Encuesta encuesta : encuestas) {
            List<Respuesta> respuestas = surveyManager.getRespuestas(encuesta.getId());
            
            for (Respuesta respuesta : respuestas) {
                if (respuesta.getUsuario().equals(username)) {
                    hayRespuestas = true;
                    
                    String estado = respuesta.isCompletada() 
                                   ? (respuesta.isAprobada() ? "Aprobada" : "Pendiente de aprobación") 
                                   : "Incompleta";
                    
                    System.out.println("\n" + encuesta.getTitulo());
                    System.out.println("Fecha: " + respuesta.getFechaRespuesta());
                    System.out.println("Estado: " + estado);
                    
                    // Si es cuestionario y está completado, mostrar puntuación
                    if (encuesta instanceof Cuestionario && respuesta.isCompletada()) {
                        Cuestionario cuestionario = (Cuestionario) encuesta;
                        int puntuacion = cuestionario.evaluarRespuesta(respuesta);
                        int maximo = cuestionario.calcularPuntuacionMaxima();
                        double porcentaje = maximo > 0 ? ((double) puntuacion / maximo) * 100 : 0;
                        boolean aprobado = cuestionario.esAprobado(puntuacion);
                        
                        System.out.println("Puntuación: " + puntuacion + " de " + maximo + 
                                           " (" + String.format("%.2f", porcentaje) + "%)");
                        System.out.println("Resultado: " + (aprobado ? "APROBADO" : "NO APROBADO"));
                    }
                    
                    ConsoleUtils.mostrarLinea();
                }
            }
        }
        
        if (!hayRespuestas) {
            ConsoleUtils.mostrarInfo("No has respondido ninguna encuesta aún");
        }
        
        ConsoleUtils.pausar(scanner);
    }
}
