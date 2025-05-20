package view;

import java.util.Scanner;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import view.util.ConsoleUtils;
import dao.DAOFactory;
import dao.IDAO;
import auth.AuthManager;
import survey.SurveyManager;
import survey.Encuesta;
import survey.Respuesta;

/**
 * Vista del dashboard con resúmenes y estadísticas
 */
public class DashboardView {
    private Scanner scanner;
    private AuthManager authManager;
    
    /**
     * Constructor
     */
    public DashboardView() {
        scanner = new Scanner(System.in);
        authManager = AuthManager.getInstance();
    }
    
    /**
     * Muestra el dashboard con estadísticas y resúmenes
     */
    public void mostrar() {
        if (!authManager.isAuthenticated()) {
            ConsoleUtils.mostrarError("Debe iniciar sesión para acceder al dashboard");
            ConsoleUtils.pausar(scanner);
            return;
        }
        
        ConsoleUtils.limpiarPantalla();
        ConsoleUtils.mostrarTitulo("Dashboard");
        
        // Mostrar información del usuario
        String usuario = authManager.getUsuarioActual().getNombre();
        String rol = authManager.getUsuarioActual().getRolActivo();
        System.out.println("Usuario: " + usuario);
        System.out.println("Rol actual: " + rol);
        
        // Mostrar estadísticas de encuestas
        mostrarEstadisticasEncuestas();
        
        // Mostrar estadísticas de entidades
        mostrarEstadisticasEntidades();
        
        // Mostrar acciones rápidas
        mostrarAccionesRapidas();
        
        // Esperar a que el usuario pulse Enter
        ConsoleUtils.pausar(scanner);
    }
    
    /**
     * Muestra estadísticas relacionadas con encuestas y cuestionarios
     */
    private void mostrarEstadisticasEncuestas() {
        ConsoleUtils.mostrarSubtitulo("Estadísticas de Encuestas y Cuestionarios");
        
        SurveyManager surveyManager = SurveyManager.getInstance();
        List<Encuesta> encuestas = surveyManager.getEncuestas();
        
        int totalEncuestas = 0;
        int totalCuestionarios = 0;
        int totalRespuestas = 0;
        int misTotalRespuestas = 0;
        String username = authManager.getUsuarioActual().getUsername();
        
        for (Encuesta encuesta : encuestas) {
            if (encuesta.getClass().getSimpleName().equals("Encuesta")) {
                totalEncuestas++;
            } else {
                totalCuestionarios++;
            }
            
            List<Respuesta> respuestas = surveyManager.getRespuestas(encuesta.getId());
            totalRespuestas += respuestas.size();
            
            for (Respuesta respuesta : respuestas) {
                if (respuesta.getUsuario().equals(username)) {
                    misTotalRespuestas++;
                }
            }
        }
        
        // Mostrar tarjetas con estadísticas
        System.out.println("┌─────────────────────────┐  ┌─────────────────────────┐  ┌─────────────────────────┐");
        System.out.println("│  Total Encuestas: " + String.format("%-5d", totalEncuestas) + "  │  │  Total Cuestionarios: " + 
                          String.format("%-2d", totalCuestionarios) + "  │  │  Total Respuestas: " + String.format("%-4d", totalRespuestas) + "  │");
        System.out.println("└─────────────────────────┘  └─────────────────────────┘  └─────────────────────────┘");
        
        // Encuestas pendientes
        int encuestasPendientes = 0;
        for (Encuesta encuesta : encuestas) {
            if (encuesta.isActiva()) {
                boolean respondida = false;
                List<Respuesta> respuestas = surveyManager.getRespuestas(encuesta.getId());
                
                for (Respuesta respuesta : respuestas) {
                    if (respuesta.getUsuario().equals(username) && respuesta.isCompletada()) {
                        respondida = true;
                        break;
                    }
                }
                
                if (!respondida) {
                    encuestasPendientes++;
                }
            }
        }
        
        if (encuestasPendientes > 0) {
            ConsoleUtils.mostrarAdvertencia("Tienes " + encuestasPendientes + " encuestas pendientes por responder");
        }
    }
    
    /**
     * Muestra estadísticas relacionadas con las entidades del sistema
     */
    private void mostrarEstadisticasEntidades() {
        ConsoleUtils.mostrarSubtitulo("Estadísticas de Entidades");
        
        // Obtener conteo de entidades
        Map<String, Integer> conteoEntidades = new HashMap<>();
        
        // En lugar de usar entidades específicas, utilizamos las entidades genéricas del modelo
        // Esto evita errores cuando las entidades específicas no están disponibles
        try {
            // Para cada entidad en el modelo, obtenemos su conteo y lo mostramos
            for (Object dao : DAOFactory.getAllDAOs()) {
                if (dao instanceof IDAO) {
                    IDAO<?, ?> idao = (IDAO<?, ?>) dao;
                    String nombreEntidad = dao.getClass().getSimpleName().replace("DAO", "");
                    conteoEntidades.put(nombreEntidad, idao.count());
                }
            }
        } catch (Exception e) {
            ConsoleUtils.mostrarAdvertencia("No se pudieron cargar las estadísticas de entidades: " + e.getMessage());
        }
        
        // Si no hay entidades registradas, mostramos un mensaje general
        if (conteoEntidades.isEmpty()) {
            System.out.println("No hay información de entidades disponible");
        } else {
            // Mostrar estadísticas en una tabla
            System.out.println("┌─────────────────────────┬───────────┐");
            System.out.println("│ Entidad                 │ Registros │");
            System.out.println("├─────────────────────────┼───────────┤");
            
            for (Map.Entry<String, Integer> entry : conteoEntidades.entrySet()) {
                System.out.println("│ " + entry.getKey() + String.format("%-" + (23 - entry.getKey().length()) + "s", " ") + 
                                  "│ " + String.format("%-9d", entry.getValue()) + "│");
            }
            
            System.out.println("└─────────────────────────┴───────────┘");
        }
    }
    
    /**
     * Muestra acciones rápidas disponibles para el usuario
     */
    private void mostrarAccionesRapidas() {
        ConsoleUtils.mostrarSubtitulo("Acciones Rápidas");
        
        System.out.println("1. Responder encuestas pendientes");
        System.out.println("2. Ver mis respuestas anteriores");
        
        if (authManager.tieneRol("Administrador")) {
            System.out.println("3. Crear nueva encuesta");
            System.out.println("4. Administrar usuarios");
        }
        
        System.out.println("0. Volver al menú principal");
        
        int opcion = ConsoleUtils.leerOpcion(scanner, 0, authManager.tieneRol("Administrador") ? 4 : 2);
        
        switch (opcion) {
            case 0:
                // Volver al menú principal
                break;
            case 1:
                new EncuestaView().mostrar();
                break;
            case 2:
                // Implementar vista directa a mis respuestas
                ConsoleUtils.mostrarInfo("Funcionalidad no implementada directamente. Use el menú de encuestas.");
                ConsoleUtils.pausar(scanner);
                break;
            case 3:
                if (authManager.tieneRol("Administrador")) {
                    // Implementar acceso directo a crear encuesta
                    ConsoleUtils.mostrarInfo("Funcionalidad no implementada directamente. Use el menú de administración.");
                    ConsoleUtils.pausar(scanner);
                }
                break;
            case 4:
                if (authManager.tieneRol("Administrador")) {
                    // Implementar acceso directo a administrar usuarios
                    ConsoleUtils.mostrarInfo("Funcionalidad no implementada directamente. Use el menú de administración.");
                    ConsoleUtils.pausar(scanner);
                }
                break;
        }
    }
}
