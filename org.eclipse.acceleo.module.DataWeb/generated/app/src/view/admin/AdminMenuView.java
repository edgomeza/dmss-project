package view.admin;

import java.util.Scanner;
import view.util.ConsoleUtils;
import auth.AuthManager;
import survey.SurveyManager;

/**
 * Vista para el menú de administración
 */
public class AdminMenuView {
    private Scanner scanner;
    private AuthManager authManager;
    
    /**
     * Constructor
     */
    public AdminMenuView() {
        scanner = new Scanner(System.in);
        authManager = AuthManager.getInstance();
    }
    
    /**
     * Muestra el menú de administración
     */
    public void mostrar() {
        if (!authManager.tieneRol("Administrador")) {
            ConsoleUtils.mostrarError("Acceso denegado. Se requiere rol de Administrador.");
            ConsoleUtils.pausar(scanner);
            return;
        }
        
        boolean salir = false;
        
        while (!salir) {
            ConsoleUtils.limpiarPantalla();
            ConsoleUtils.mostrarTitulo("Panel de Administración");
            
            System.out.println("1. Gestión de usuarios");
            System.out.println("2. Gestión de encuestas y cuestionarios");
            System.out.println("3. Gestión de entidades");
            System.out.println("4. Configuración del sistema");
            System.out.println("5. Estadísticas y reportes");
            System.out.println("0. Volver al menú principal");
            
            int opcion = ConsoleUtils.leerOpcion(scanner, 0, 5);
            
            switch (opcion) {
                case 0:
                    salir = true;
                    break;
                case 1:
                    gestionUsuarios();
                    break;
                case 2:
                    new EncuestaAdminView().mostrar();
                    break;
                case 3:
                    gestionEntidades();
                    break;
                case 4:
                    configuracionSistema();
                    break;
                case 5:
                    estadisticas();
                    break;
            }
        }
    }
    
    /**
     * Muestra el menú de gestión de usuarios
     */
    private void gestionUsuarios() {
        ConsoleUtils.limpiarPantalla();
        ConsoleUtils.mostrarTitulo("Gestión de Usuarios");
        
        System.out.println("1. Listar usuarios");
        System.out.println("2. Crear nuevo usuario");
        System.out.println("3. Editar usuario");
        System.out.println("4. Eliminar usuario");
        System.out.println("5. Gestión de roles");
        System.out.println("0. Volver");
        
        int opcion = ConsoleUtils.leerOpcion(scanner, 0, 5);
        
        switch (opcion) {
            case 0:
                break;
            default:
                ConsoleUtils.mostrarInfo("Funcionalidad no implementada");
                ConsoleUtils.pausar(scanner);
                break;
        }
    }
    
    /**
     * Muestra el menú de gestión de entidades
     */
    private void gestionEntidades() {
        ConsoleUtils.limpiarPantalla();
        ConsoleUtils.mostrarTitulo("Gestión de Entidades");
        
        System.out.println("Seleccione una entidad:");
        
        System.out.println("1. Cliente");
        System.out.println("2. Cuenta");
        System.out.println("3. Transaccion");
        System.out.println("4. Empleado");
        System.out.println("5. Prestamo");
        System.out.println("6. TarjetaCredito");
        
        System.out.println("0. Volver");
        
        int opcion = ConsoleUtils.leerOpcion(scanner, 0, 6);
        
        if (opcion == 0) {
            return;
        } else if (opcion >= 1 && opcion <= 6) {
            ConsoleUtils.mostrarInfo("Funcionalidad no implementada directamente. Utilice la navegación por roles.");
            ConsoleUtils.pausar(scanner);
        }
    }
    
    /**
     * Muestra el menú de configuración del sistema
     */
    private void configuracionSistema() {
        ConsoleUtils.limpiarPantalla();
        ConsoleUtils.mostrarTitulo("Configuración del Sistema");
        
        System.out.println("1. Importar datos");
        System.out.println("2. Exportar datos");
        System.out.println("3. Reiniciar sistema");
        System.out.println("4. Configuración de seguridad");
        System.out.println("0. Volver");
        
        int opcion = ConsoleUtils.leerOpcion(scanner, 0, 4);
        
        switch (opcion) {
            case 0:
                break;
            default:
                ConsoleUtils.mostrarInfo("Funcionalidad no implementada");
                ConsoleUtils.pausar(scanner);
                break;
        }
    }
    
    /**
     * Muestra el menú de estadísticas y reportes
     */
    private void estadisticas() {
        ConsoleUtils.limpiarPantalla();
        ConsoleUtils.mostrarTitulo("Estadísticas y Reportes");
        
        System.out.println("1. Estadísticas de usuarios");
        System.out.println("2. Estadísticas de encuestas");
        System.out.println("3. Estadísticas de entidades");
        System.out.println("4. Generar informe completo");
        System.out.println("0. Volver");
        
        int opcion = ConsoleUtils.leerOpcion(scanner, 0, 4);
        
        switch (opcion) {
            case 0:
                break;
            case 2:
                // Esta funcionalidad sí está implementada en la vista de administración de encuestas
                new EncuestaAdminView().mostrar();
                break;
            default:
                ConsoleUtils.mostrarInfo("Funcionalidad no implementada");
                ConsoleUtils.pausar(scanner);
                break;
        }
    }
}
