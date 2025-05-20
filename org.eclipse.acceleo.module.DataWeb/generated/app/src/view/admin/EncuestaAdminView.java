package view.admin;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import view.util.ConsoleUtils;
import survey.*;
import auth.AuthManager;

/**
 * Vista para la administración de encuestas
 */
public class EncuestaAdminView {
    private Scanner scanner;
    private SurveyManager surveyManager;
    
    /**
     * Constructor
     */
    public EncuestaAdminView() {
        scanner = new Scanner(System.in);
        surveyManager = SurveyManager.getInstance();
    }
    
    /**
     * Muestra el menú principal de administración de encuestas
     */
    public void mostrar() {
        boolean salir = false;
        
        while (!salir) {
            ConsoleUtils.limpiarPantalla();
            ConsoleUtils.mostrarTitulo("Administración de Encuestas y Cuestionarios");
            
            System.out.println("1. Listar encuestas y cuestionarios");
            System.out.println("2. Crear nueva encuesta");
            System.out.println("3. Crear nuevo cuestionario evaluable");
            System.out.println("4. Ver resultados de encuestas");
            System.out.println("5. Aprobar respuestas pendientes");
            System.out.println("0. Volver al menú principal");
            
            int opcion = ConsoleUtils.leerOpcion(scanner, 0, 5);
            
            switch (opcion) {
                case 0:
                    salir = true;
                    break;
                case 1:
                    listarEncuestas();
                    break;
                case 2:
                    crearEncuesta(false);
                    break;
                case 3:
                    crearEncuesta(true);
                    break;
                case 4:
                    verResultados();
                    break;
                case 5:
                    aprobarRespuestas();
                    break;
                default:
                    ConsoleUtils.mostrarError("Opción inválida");
                    ConsoleUtils.pausar(scanner);
                    break;
            }
        }
    }
    
    /**
     * Muestra el listado de encuestas con opciones para editar/eliminar
     */
    private void listarEncuestas() {
        ConsoleUtils.limpiarPantalla();
        ConsoleUtils.mostrarTitulo("Listado de Encuestas y Cuestionarios");
        
        List<Encuesta> encuestas = surveyManager.getEncuestas();
        
        if (encuestas.isEmpty()) {
            ConsoleUtils.mostrarAdvertencia("No hay encuestas ni cuestionarios registrados");
            ConsoleUtils.pausar(scanner);
            return;
        }
        
        for (int i = 0; i < encuestas.size(); i++) {
            Encuesta encuesta = encuestas.get(i);
            String tipo = (encuesta instanceof Cuestionario) ? "Cuestionario" : "Encuesta";
            String estado = encuesta.isActiva() ? "Activa" : "Inactiva";
            
            System.out.println((i + 1) + ". [" + tipo + "] " + encuesta.getTitulo() + " (" + estado + ")");
        }
        
        ConsoleUtils.mostrarLinea();
        System.out.println("\nOpciones:");
        System.out.println("1. Ver/Editar encuesta");
        System.out.println("2. Eliminar encuesta");
        System.out.println("0. Volver");
        
        int opcion = ConsoleUtils.leerOpcion(scanner, 0, 2);
        
        if (opcion == 0) {
            return;
        }
        
        int indice = ConsoleUtils.leerEntero(scanner, "Seleccione el número de la encuesta", 
                valor -> valor >= 1 && valor <= encuestas.size(), null);
        
        if (indice >= 1 && indice <= encuestas.size()) {
            Encuesta encuesta = encuestas.get(indice - 1);
            
            if (opcion == 1) {
                editarEncuesta(encuesta);
            } else if (opcion == 2) {
                eliminarEncuesta(encuesta);
            }
        }
    }
    
    /**
     * Crea una nueva encuesta o cuestionario
     * @param esCuestionario true para crear un cuestionario, false para encuesta
     */
    private void crearEncuesta(boolean esCuestionario) {
        ConsoleUtils.limpiarPantalla();
        String tipo = esCuestionario ? "Cuestionario" : "Encuesta";
        ConsoleUtils.mostrarTitulo("Crear Nuevo " + tipo);
        
        String titulo = ConsoleUtils.leerString(scanner, "Título", texto -> !texto.isEmpty(), null);
        String descripcion = ConsoleUtils.leerString(scanner, "Descripción", null, "");
        
        Encuesta encuesta;
        if (esCuestionario) {
            Cuestionario cuestionario = new Cuestionario();
            cuestionario.setTitulo(titulo);
            cuestionario.setDescripcion(descripcion);
            
            int tiempoLimite = ConsoleUtils.leerEntero(scanner, "Tiempo límite (minutos)", 
                    valor -> valor > 0, 30);
            int puntuacionMinima = ConsoleUtils.leerEntero(scanner, "Puntuación mínima para aprobar (%)", 
                    valor -> valor > 0 && valor <= 100, 60);
            boolean mostrarResultados = ConsoleUtils.leerBooleano(scanner, 
                    "¿Mostrar resultados inmediatamente?", true);
            
            cuestionario.setTiempoLimite(tiempoLimite);
            cuestionario.setPuntuacionMinima(puntuacionMinima);
            cuestionario.setMostrarResultadosInmediatos(mostrarResultados);
            
            encuesta = cuestionario;
        } else {
            encuesta = new Encuesta();
            encuesta.setTitulo(titulo);
            encuesta.setDescripcion(descripcion);
        }
        
        // Establecer creador
        String creador = AuthManager.getInstance().getUsuarioActual().getUsername();
        encuesta.setCreador(creador);
        
        // Añadir roles permitidos
        boolean limitarRoles = ConsoleUtils.leerBooleano(scanner, "¿Limitar acceso por roles?", false);
        if (limitarRoles) {
            // Obtener roles del sistema
            String[] roles = {"Administrador"}; // Aquí habría que obtener los roles del sistema
            
            for (String rol : roles) {
                boolean permitir = ConsoleUtils.leerBooleano(scanner, "¿Permitir acceso a " + rol + "?", false);
                if (permitir) {
                    encuesta.addRolPermitido(rol);
                }
            }
        }
        
        // Añadir preguntas
        boolean salir = false;
        while (!salir) {
            ConsoleUtils.mostrarSubtitulo("Añadir Preguntas");
            System.out.println("Preguntas actuales: " + encuesta.getPreguntas().size());
            
            System.out.println("\n1. Añadir pregunta de opción múltiple");
            System.out.println("2. Añadir pregunta verdadero/falso");
            System.out.println("3. Añadir pregunta de respuesta corta");
            System.out.println("4. Añadir pregunta de respuesta larga");
            System.out.println("5. Guardar " + tipo);
            System.out.println("0. Cancelar");
            
            int opcion = ConsoleUtils.leerOpcion(scanner, 0, 5);
            
            switch (opcion) {
                case 0:
                    // Cancelar
                    ConsoleUtils.mostrarInfo("Operación cancelada");
                    return;
                case 5:
                    // Guardar
                    if (encuesta.getPreguntas().isEmpty()) {
                        ConsoleUtils.mostrarError("Debe añadir al menos una pregunta");
                    } else {
                        salir = true;
                    }
                    break;
                default:
                    // Añadir pregunta
                    if (opcion >= 1 && opcion <= 4) {
                        añadirPregunta(encuesta, opcion, esCuestionario);
                    }
                    break;
            }
        }
        
        // Guardar encuesta
        surveyManager.guardarEncuesta(encuesta);
        ConsoleUtils.mostrarExito(tipo + " creado correctamente");
        ConsoleUtils.pausar(scanner);
    }
    
    /**
     * Añade una nueva pregunta a una encuesta
     * @param encuesta Encuesta a la que añadir la pregunta
     * @param tipoPregunta Tipo de pregunta (1-4)
     * @param esCuestionario true si es un cuestionario evaluable
     */
    private void añadirPregunta(Encuesta encuesta, int tipoPregunta, boolean esCuestionario) {
        ConsoleUtils.mostrarSubtitulo("Nueva Pregunta");
        
        String texto = ConsoleUtils.leerString(scanner, "Texto de la pregunta", 
                texto2 -> !texto2.isEmpty(), null);
        
        Pregunta.TipoPregunta tipo;
        switch (tipoPregunta) {
            case 1:
                tipo = Pregunta.TipoPregunta.OPCION_MULTIPLE;
                break;
            case 2:
                tipo = Pregunta.TipoPregunta.VERDADERO_FALSO;
                break;
            case 3:
                tipo = Pregunta.TipoPregunta.RESPUESTA_CORTA;
                break;
            case 4:
            default:
                tipo = Pregunta.TipoPregunta.RESPUESTA_LARGA;
                break;
        }
        
        Pregunta pregunta = new Pregunta(surveyManager.getNextPreguntaId(), texto, tipo);
        
        boolean obligatoria = ConsoleUtils.leerBooleano(scanner, "¿Es obligatoria?", true);
        pregunta.setObligatoria(obligatoria);
        
        // Añadir opciones si es de opción múltiple
        if (tipo == Pregunta.TipoPregunta.OPCION_MULTIPLE) {
            boolean finOpciones = false;
            List<String> opciones = new ArrayList<>();
            
            while (!finOpciones) {
                String opcion = ConsoleUtils.leerString(scanner, "Añadir opción (vacío para terminar)", 
                        null, "");
                
                if (opcion.isEmpty()) {
                    if (opciones.size() < 2) {
                        ConsoleUtils.mostrarError("Debe añadir al menos 2 opciones");
                    } else {
                        finOpciones = true;
                        for (String op : opciones) {
                            pregunta.addOpcion(op);
                        }
                    }
                } else {
                    opciones.add(opcion);
                    ConsoleUtils.mostrarInfo("Opción añadida: " + opcion);
                }
            }
        }
        
        // Si es cuestionario, pedir respuesta correcta
        if (esCuestionario) {
            if (tipo == Pregunta.TipoPregunta.OPCION_MULTIPLE) {
                ConsoleUtils.mostrarSubtitulo("Seleccione la respuesta correcta");
                
                List<String> opciones = pregunta.getOpciones();
                for (int i = 0; i < opciones.size(); i++) {
                    System.out.println((i + 1) + ". " + opciones.get(i));
                }
                
                int indice = ConsoleUtils.leerEntero(scanner, "Opción correcta", 
                        valor -> valor >= 1 && valor <= opciones.size(), 1);
                
                pregunta.setRespuestaCorrecta(String.valueOf(indice - 1));
            } else if (tipo == Pregunta.TipoPregunta.VERDADERO_FALSO) {
                boolean correcta = ConsoleUtils.leerBooleano(scanner, "¿La respuesta correcta es Verdadero?", true);
                pregunta.setRespuestaCorrecta(String.valueOf(correcta));
            } else if (tipo == Pregunta.TipoPregunta.RESPUESTA_CORTA) {
                String respuesta = ConsoleUtils.leerString(scanner, "Respuesta correcta", 
                        texto2 -> !texto2.isEmpty(), null);
                pregunta.setRespuestaCorrecta(respuesta);
            }
            
            int puntuacion = ConsoleUtils.leerEntero(scanner, "Puntuación de la pregunta", 
                    valor -> valor > 0, 1);
            pregunta.setPuntuacion(puntuacion);
        }
        
        encuesta.addPregunta(pregunta);
        ConsoleUtils.mostrarExito("Pregunta añadida correctamente");
    }
    
    /**
     * Edita una encuesta existente
     * @param encuesta Encuesta a editar
     */
    private void editarEncuesta(Encuesta encuesta) {
        boolean salir = false;
        
        while (!salir) {
            ConsoleUtils.limpiarPantalla();
            ConsoleUtils.mostrarTitulo("Editar " + 
                    (encuesta instanceof Cuestionario ? "Cuestionario" : "Encuesta"));
            
            boolean esCuestionario = encuesta instanceof Cuestionario;
            
            System.out.println("Título: " + encuesta.getTitulo());
            System.out.println("Descripción: " + encuesta.getDescripcion());
            System.out.println("Creador: " + encuesta.getCreador());
            System.out.println("Estado: " + (encuesta.isActiva() ? "Activo" : "Inactivo"));
            System.out.println("Fecha creación: " + encuesta.getFechaCreacion());
            
            if (esCuestionario) {
                Cuestionario cuestionario = (Cuestionario) encuesta;
                System.out.println("Tiempo límite: " + cuestionario.getTiempoLimite() + " minutos");
                System.out.println("Puntuación mínima: " + cuestionario.getPuntuacionMinima() + "%");
            }
            
            ConsoleUtils.mostrarLinea();
            System.out.println("\nPreguntas (" + encuesta.getPreguntas().size() + "):");
            List<Pregunta> preguntas = encuesta.getPreguntas();
            
            for (int i = 0; i < preguntas.size(); i++) {
                Pregunta p = preguntas.get(i);
                System.out.println((i + 1) + ". [" + p.getTipo() + "] " + p.getTexto());
            }
            
            ConsoleUtils.mostrarLinea();
            System.out.println("\nOpciones:");
            System.out.println("1. Editar datos básicos");
            System.out.println("2. Añadir pregunta");
            System.out.println("3. Editar pregunta");
            System.out.println("4. Eliminar pregunta");
            System.out.println("5. Activar/Desactivar");
            System.out.println("6. Gestionar roles permitidos");
            System.out.println("0. Volver");
            
            int opcion = ConsoleUtils.leerOpcion(scanner, 0, 6);
            
            switch (opcion) {
                case 0:
                    salir = true;
                    break;
                case 1:
                    editarDatosBasicos(encuesta);
                    break;
                case 2:
                    añadirPregunta(encuesta, 
                        ConsoleUtils.leerEntero(scanner, "Tipo de pregunta (1-4)", valor -> valor >= 1 && valor <= 4, 1), 
                        esCuestionario);
                    surveyManager.guardarEncuesta(encuesta);
                    break;
                case 3:
                    // Editar pregunta se implementaría aquí
                    ConsoleUtils.mostrarInfo("Funcionalidad no implementada");
                    ConsoleUtils.pausar(scanner);
                    break;
                case 4:
                    eliminarPregunta(encuesta);
                    break;
                case 5:
                    encuesta.setActiva(!encuesta.isActiva());
                    surveyManager.guardarEncuesta(encuesta);
                    ConsoleUtils.mostrarExito(encuesta.isActiva() ? "Activada" : "Desactivada");
                    ConsoleUtils.pausar(scanner);
                    break;
                case 6:
                    // Gestionar roles permitidos se implementaría aquí
                    ConsoleUtils.mostrarInfo("Funcionalidad no implementada");
                    ConsoleUtils.pausar(scanner);
                    break;
            }
        }
    }
    
    /**
     * Edita los datos básicos de una encuesta
     * @param encuesta Encuesta a editar
     */
    private void editarDatosBasicos(Encuesta encuesta) {
        ConsoleUtils.mostrarSubtitulo("Editar Datos Básicos");
        
        String titulo = ConsoleUtils.leerString(scanner, "Título", null, encuesta.getTitulo());
        String descripcion = ConsoleUtils.leerString(scanner, "Descripción", null, encuesta.getDescripcion());
        
        encuesta.setTitulo(titulo);
        encuesta.setDescripcion(descripcion);
        
        if (encuesta instanceof Cuestionario) {
            Cuestionario cuestionario = (Cuestionario) encuesta;
            
            int tiempoLimite = ConsoleUtils.leerEntero(scanner, "Tiempo límite (minutos)", 
                    valor -> valor > 0, cuestionario.getTiempoLimite());
            int puntuacionMinima = ConsoleUtils.leerEntero(scanner, "Puntuación mínima para aprobar (%)", 
                    valor -> valor > 0 && valor <= 100, cuestionario.getPuntuacionMinima());
            
            cuestionario.setTiempoLimite(tiempoLimite);
            cuestionario.setPuntuacionMinima(puntuacionMinima);
        }
        
        surveyManager.guardarEncuesta(encuesta);
        ConsoleUtils.mostrarExito("Datos actualizados correctamente");
        ConsoleUtils.pausar(scanner);
    }
    
    /**
     * Elimina una pregunta de una encuesta
     * @param encuesta Encuesta de la que eliminar la pregunta
     */
    private void eliminarPregunta(Encuesta encuesta) {
        ConsoleUtils.mostrarSubtitulo("Eliminar Pregunta");
        
        List<Pregunta> preguntas = encuesta.getPreguntas();
        
        if (preguntas.isEmpty()) {
            ConsoleUtils.mostrarAdvertencia("No hay preguntas para eliminar");
            ConsoleUtils.pausar(scanner);
            return;
        }
        
        for (int i = 0; i < preguntas.size(); i++) {
            Pregunta p = preguntas.get(i);
            System.out.println((i + 1) + ". " + p.getTexto());
        }
        
        int indice = ConsoleUtils.leerEntero(scanner, "Seleccione la pregunta a eliminar", 
                valor -> valor >= 1 && valor <= preguntas.size(), null);
        
        if (indice >= 1 && indice <= preguntas.size()) {
            boolean confirmacion = ConsoleUtils.leerBooleano(scanner, 
                    "¿Está seguro de eliminar esta pregunta?", false);
            
            if (confirmacion) {
                Pregunta p = preguntas.get(indice - 1);
                encuesta.removePregunta(p);
                surveyManager.guardarEncuesta(encuesta);
                ConsoleUtils.mostrarExito("Pregunta eliminada correctamente");
            } else {
                ConsoleUtils.mostrarInfo("Operación cancelada");
            }
        }
        
        ConsoleUtils.pausar(scanner);
    }
    
    /**
     * Elimina una encuesta
     * @param encuesta Encuesta a eliminar
     */
    private void eliminarEncuesta(Encuesta encuesta) {
        ConsoleUtils.mostrarSubtitulo("Eliminar " + 
                (encuesta instanceof Cuestionario ? "Cuestionario" : "Encuesta"));
        
        System.out.println("Título: " + encuesta.getTitulo());
        System.out.println("Descripción: " + encuesta.getDescripcion());
        System.out.println("Preguntas: " + encuesta.getPreguntas().size());
        
        ConsoleUtils.mostrarAdvertencia("Esta operación no se puede deshacer");
        boolean confirmacion = ConsoleUtils.leerBooleano(scanner, 
                "¿Está seguro de eliminar esta encuesta y todas sus respuestas?", false);
        
        if (confirmacion) {
            surveyManager.eliminarEncuesta(encuesta.getId());
            ConsoleUtils.mostrarExito("Encuesta eliminada correctamente");
        } else {
            ConsoleUtils.mostrarInfo("Operación cancelada");
        }
        
        ConsoleUtils.pausar(scanner);
    }
    
    /**
     * Muestra los resultados de las encuestas y cuestionarios
     */
    private void verResultados() {
        ConsoleUtils.limpiarPantalla();
        ConsoleUtils.mostrarTitulo("Resultados de Encuestas y Cuestionarios");
        
        List<Encuesta> encuestas = surveyManager.getEncuestas();
        
        if (encuestas.isEmpty()) {
            ConsoleUtils.mostrarAdvertencia("No hay encuestas ni cuestionarios registrados");
            ConsoleUtils.pausar(scanner);
            return;
        }
        
        for (int i = 0; i < encuestas.size(); i++) {
            Encuesta encuesta = encuestas.get(i);
            List<Respuesta> respuestas = surveyManager.getRespuestas(encuesta.getId());
            String tipo = (encuesta instanceof Cuestionario) ? "Cuestionario" : "Encuesta";
            
            System.out.println((i + 1) + ". [" + tipo + "] " + encuesta.getTitulo() + 
                              " - Respuestas: " + respuestas.size());
        }
        
        int indice = ConsoleUtils.leerEntero(scanner, "\nSeleccione una encuesta para ver resultados", 
                valor -> valor >= 1 && valor <= encuestas.size(), null);
        
        if (indice >= 1 && indice <= encuestas.size()) {
            Encuesta encuesta = encuestas.get(indice - 1);
            mostrarResultadosEncuesta(encuesta);
        }
    }
    
    /**
     * Muestra los resultados detallados de una encuesta
     * @param encuesta Encuesta a mostrar
     */
    private void mostrarResultadosEncuesta(Encuesta encuesta) {
        ConsoleUtils.limpiarPantalla();
        ConsoleUtils.mostrarTitulo("Resultados: " + encuesta.getTitulo());
        
        List<Respuesta> respuestas = surveyManager.getRespuestas(encuesta.getId());
        
        if (respuestas.isEmpty()) {
            ConsoleUtils.mostrarAdvertencia("No hay respuestas para esta encuesta");
            ConsoleUtils.pausar(scanner);
            return;
        }
        
        System.out.println("Total de respuestas: " + respuestas.size());
        System.out.println("Respuestas completadas: " + 
                          respuestas.stream().filter(Respuesta::isCompletada).count());
        
        boolean esCuestionario = encuesta instanceof Cuestionario;
        
        if (esCuestionario) {
            Cuestionario cuestionario = (Cuestionario) encuesta;
            int totalCorrectas = 0;
            int totalPuntuacion = 0;
            
            for (Respuesta r : respuestas) {
                if (r.isCompletada()) {
                    int puntuacion = cuestionario.evaluarRespuesta(r);
                    totalPuntuacion += puntuacion;
                    if (cuestionario.esAprobado(puntuacion)) {
                        totalCorrectas++;
                    }
                }
            }
            
            double aprobados = respuestas.isEmpty() ? 0 : 
                              (double) totalCorrectas / respuestas.stream().filter(Respuesta::isCompletada).count() * 100;
            double promedio = respuestas.isEmpty() ? 0 : 
                             (double) totalPuntuacion / respuestas.stream().filter(Respuesta::isCompletada).count();
            
            System.out.println("Porcentaje de aprobados: " + String.format("%.2f", aprobados) + "%");
            System.out.println("Puntuación promedio: " + String.format("%.2f", promedio) + 
                              " de " + cuestionario.calcularPuntuacionMaxima());
        }
        
        ConsoleUtils.mostrarLinea();
        System.out.println("\nDetalle de resultados por pregunta:");
        
        List<Pregunta> preguntas = encuesta.getPreguntas();
        
        for (int i = 0; i < preguntas.size(); i++) {
            Pregunta pregunta = preguntas.get(i);
            System.out.println("\n" + (i + 1) + ". " + pregunta.getTexto());
            
            if (pregunta.getTipo() == Pregunta.TipoPregunta.OPCION_MULTIPLE) {
                // Para opción múltiple mostrar estadísticas por opción
                List<String> opciones = pregunta.getOpciones();
                int[] conteoOpciones = new int[opciones.size()];
                
                for (Respuesta r : respuestas) {
                    String resp = r.getRespuesta(pregunta.getId());
                    if (resp != null) {
                        try {
                            int opcion = Integer.parseInt(resp);
                            if (opcion >= 0 && opcion < conteoOpciones.length) {
                                conteoOpciones[opcion]++;
                            }
                        } catch (NumberFormatException e) {
                            // Ignorar respuestas inválidas
                        }
                    }
                }
                
                for (int j = 0; j < opciones.size(); j++) {
                    double porcentaje = respuestas.isEmpty() ? 0 : 
                                       (double) conteoOpciones[j] / respuestas.size() * 100;
                    System.out.println("   " + opciones.get(j) + ": " + 
                                      conteoOpciones[j] + " (" + String.format("%.2f", porcentaje) + "%)");
                }
            } else if (pregunta.getTipo() == Pregunta.TipoPregunta.VERDADERO_FALSO) {
                // Para verdadero/falso mostrar conteo de cada respuesta
                int verdadero = 0;
                int falso = 0;
                
                for (Respuesta r : respuestas) {
                    String resp = r.getRespuesta(pregunta.getId());
                    if ("true".equals(resp)) {
                        verdadero++;
                    } else if ("false".equals(resp)) {
                        falso++;
                    }
                }
                
                double porcVerdadero = respuestas.isEmpty() ? 0 : (double) verdadero / respuestas.size() * 100;
                double porcFalso = respuestas.isEmpty() ? 0 : (double) falso / respuestas.size() * 100;
                
                System.out.println("   Verdadero: " + verdadero + " (" + String.format("%.2f", porcVerdadero) + "%)");
                System.out.println("   Falso: " + falso + " (" + String.format("%.2f", porcFalso) + "%)");
            } else {
                // Para respuestas de texto, mostrar algunas respuestas de ejemplo
                System.out.println("   Algunas respuestas:");
                int mostrados = 0;
                
                for (Respuesta r : respuestas) {
                    String resp = r.getRespuesta(pregunta.getId());
                    if (resp != null && !resp.isEmpty()) {
                        System.out.println("   - " + resp);
                        mostrados++;
                        if (mostrados >= 3) {
                            break;
                        }
                    }
                }
                
                if (mostrados == 0) {
                    System.out.println("   (No hay respuestas para esta pregunta)");
                }
            }
        }
        
        ConsoleUtils.pausar(scanner);
    }
    
    /**
     * Muestra la pantalla para aprobar respuestas pendientes
     */
    private void aprobarRespuestas() {
        ConsoleUtils.limpiarPantalla();
        ConsoleUtils.mostrarTitulo("Aprobar Respuestas Pendientes");
        
        List<Encuesta> encuestas = surveyManager.getEncuestas();
        List<Respuesta> pendientes = new ArrayList<>();
        
        // Recolectar todas las respuestas pendientes de aprobación
        for (Encuesta encuesta : encuestas) {
            List<Respuesta> respuestas = surveyManager.getRespuestas(encuesta.getId());
            for (Respuesta respuesta : respuestas) {
                if (respuesta.isCompletada() && !respuesta.isAprobada()) {
                    pendientes.add(respuesta);
                }
            }
        }
        
        if (pendientes.isEmpty()) {
            ConsoleUtils.mostrarInfo("No hay respuestas pendientes de aprobación");
            ConsoleUtils.pausar(scanner);
            return;
        }
        
        System.out.println("Hay " + pendientes.size() + " respuestas pendientes de aprobación\n");
        
        for (int i = 0; i < pendientes.size(); i++) {
            Respuesta respuesta = pendientes.get(i);
            Encuesta encuesta = surveyManager.getEncuesta(respuesta.getEncuestaId());
            
            System.out.println((i + 1) + ". " + encuesta.getTitulo() + " - " + 
                              respuesta.getUsuario() + " (" + respuesta.getFechaRespuesta() + ")");
        }
        
        int indice = ConsoleUtils.leerEntero(scanner, "\nSeleccione una respuesta para revisar", 
                valor -> valor >= 1 && valor <= pendientes.size(), null);
        
        if (indice >= 1 && indice <= pendientes.size()) {
            Respuesta respuesta = pendientes.get(indice - 1);
            revisarRespuesta(respuesta);
        }
    }
    
    /**
     * Muestra los detalles de una respuesta para su revisión y aprobación
     * @param respuesta Respuesta a revisar
     */
    private void revisarRespuesta(Respuesta respuesta) {
        Encuesta encuesta = surveyManager.getEncuesta(respuesta.getEncuestaId());
        
        ConsoleUtils.limpiarPantalla();
        ConsoleUtils.mostrarTitulo("Revisar Respuesta: " + encuesta.getTitulo());
        
        System.out.println("Usuario: " + respuesta.getUsuario());
        System.out.println("Fecha: " + respuesta.getFechaRespuesta());
        System.out.println("Estado: " + (respuesta.isAprobada() ? "Aprobada" : "Pendiente"));
        
        ConsoleUtils.mostrarLinea();
        System.out.println("\nRespuestas:");
        
        for (Pregunta pregunta : encuesta.getPreguntas()) {
            String resp = respuesta.getRespuesta(pregunta.getId());
            System.out.println("\nPregunta: " + pregunta.getTexto());
            
            if (resp != null) {
                if (pregunta.getTipo() == Pregunta.TipoPregunta.OPCION_MULTIPLE) {
                    try {
                        int opcion = Integer.parseInt(resp);
                        if (opcion >= 0 && opcion < pregunta.getOpciones().size()) {
                            System.out.println("Respuesta: " + pregunta.getOpciones().get(opcion));
                        } else {
                            System.out.println("Respuesta: (Inválida)");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Respuesta: (Inválida)");
                    }
                } else if (pregunta.getTipo() == Pregunta.TipoPregunta.VERDADERO_FALSO) {
                    System.out.println("Respuesta: " + ("true".equals(resp) ? "Verdadero" : "Falso"));
                } else {
                    System.out.println("Respuesta: " + resp);
                }
                
                // Si es cuestionario, mostrar corrección
                if (encuesta instanceof Cuestionario && pregunta.getRespuestaCorrecta() != null) {
                    boolean correcta = pregunta.evaluarRespuesta(resp);
                    System.out.println("Evaluación: " + (correcta ? "Correcta" : "Incorrecta"));
                }
            } else {
                System.out.println("Respuesta: (No respondida)");
            }
        }
        
        // Mostrar puntuación total si es un cuestionario
        if (encuesta instanceof Cuestionario) {
            Cuestionario cuestionario = (Cuestionario) encuesta;
            int puntuacion = cuestionario.evaluarRespuesta(respuesta);
            int maximo = cuestionario.calcularPuntuacionMaxima();
            boolean aprobado = cuestionario.esAprobado(puntuacion);
            
            ConsoleUtils.mostrarLinea();
            System.out.println("\nPuntuación: " + puntuacion + " de " + maximo + 
                              " (" + String.format("%.2f", (double) puntuacion / maximo * 100) + "%)");
            System.out.println("Resultado: " + (aprobado ? "Aprobado" : "No aprobado"));
        }
        
        ConsoleUtils.mostrarLinea();
        System.out.println("\nOpciones:");
        System.out.println("1. Aprobar respuesta");
        System.out.println("2. Rechazar respuesta");
        System.out.println("0. Volver");
        
        int opcion = ConsoleUtils.leerOpcion(scanner, 0, 2);
        
        if (opcion == 1) {
            respuesta.setAprobada(true);
            surveyManager.guardarRespuesta(respuesta);
            ConsoleUtils.mostrarExito("Respuesta aprobada correctamente");
        } else if (opcion == 2) {
            // Aquí se podría implementar un rechazo con comentarios
            respuesta.setAprobada(false);
            surveyManager.guardarRespuesta(respuesta);
            ConsoleUtils.mostrarInfo("Respuesta marcada como no aprobada");
        }
        
        ConsoleUtils.pausar(scanner);
    }
}
