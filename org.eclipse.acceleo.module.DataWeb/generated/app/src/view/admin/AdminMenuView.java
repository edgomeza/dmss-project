package view.admin;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
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
	    if (!authManager.esAdministrador()) {
	        ConsoleUtils.mostrarError("Acceso denegado. Se requiere el rol con permisos de administrador.");
	        ConsoleUtils.pausar(scanner);
	        return;
	    }
	    
	    boolean salir = false;
	    
	    while (!salir) {
	        ConsoleUtils.limpiarPantalla();
	        ConsoleUtils.mostrarTitulo("Panel de Administración");
	        
	        // Mostrar información del rol administrador actual
	        String rolAdmin = authManager.getRolAdministrador();
	        System.out.println("Rol administrador identificado: " + rolAdmin);
	        System.out.println("Acceso a todas las funcionalidades del sistema");
	        
	        ConsoleUtils.mostrarLinea();
	        
	        System.out.println("1. Gestión de usuarios");
	        System.out.println("2. Gestión de encuestas y cuestionarios");
	        System.out.println("3. Gestión de entidades");
	        System.out.println("4. Configuración del sistema");
	        System.out.println("5. Estadísticas y reportes");
	        System.out.println("6. Información de roles y permisos");
	        System.out.println("0. Volver al menú principal");
	        
	        int opcion = ConsoleUtils.leerOpcion(scanner, 0, 6);
	        
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
	            case 6:
	                mostrarInformacionRoles();
	                break;
	        }
	    }
	}

	/**
	 * Muestra información detallada sobre roles y permisos
	 */
	private void mostrarInformacionRoles() {
	    ConsoleUtils.limpiarPantalla();
	    ConsoleUtils.mostrarTitulo("Información de Roles y Permisos");
	    
	    System.out.println("Análisis automático de roles del sistema:\n");
	    
	    String[] headers = {"Rol", "Páginas", "Tipo", "Descripción"};
	    List<String[]> data = new ArrayList<>();
	    
	    String tipoRolAdministrador = (13 == 13) ? "Administrador" : "Usuario";
	    data.add(new String[]{"Administrador", "13", tipoRolAdministrador, "Acceso total al sistema"});
	    String tipoRolBibliotecario = (9 == 13) ? "Administrador" : "Usuario";
	    data.add(new String[]{"Bibliotecario", "9", tipoRolBibliotecario, "Gestión de libros y préstamos"});
	    String tipoRolEstudiante = (4 == 13) ? "Administrador" : "Usuario";
	    data.add(new String[]{"Estudiante", "4", tipoRolEstudiante, "Consulta de libros disponibles"});
	    
	    ConsoleUtils.mostrarTabla(headers, data);
	    
	    System.out.println("\nDetalle de páginas por rol:");
	    System.out.println("\nAdministrador:");
	    System.out.println("  - Biblioteca Universitaria - Inicio (PaginaHome)");
	    System.out.println("  - Información Biblioteca (PaginaContenido)");
	    System.out.println("  - Detalle de Categoría (PaginaDetalle)");
	    System.out.println("  - Índice de Categorías (PaginaIndicePaginada)");
	    System.out.println("  - Crear Nueva Categoría (PaginaCreacion)");
	    System.out.println("  - Actualizar Categoría (PaginaActualizacion)");
	    System.out.println("  - Eliminar Categoría (PaginaBorrado)");
	    System.out.println("  - Listado de Usuarios (PaginaIndicePaginada)");
	    System.out.println("  - Listado de Préstamos (PaginaIndiceFiltros)");
	    System.out.println("  - Búsqueda Avanzada de Libros (PaginaIndicePaginadaFiltrada)");
	    System.out.println("  - Registrar Préstamo (PaginaCreacion)");
	    System.out.println("  - Actualizar Préstamo (PaginaActualizacion)");
	    System.out.println("  - Eliminar Préstamo (PaginaBorrado)");
	    System.out.println("\nBibliotecario:");
	    System.out.println("  - Biblioteca Universitaria - Inicio (PaginaHome)");
	    System.out.println("  - Información Biblioteca (PaginaContenido)");
	    System.out.println("  - Detalle de Categoría (PaginaDetalle)");
	    System.out.println("  - Índice de Categorías (PaginaIndicePaginada)");
	    System.out.println("  - Búsqueda Avanzada de Libros (PaginaIndicePaginadaFiltrada)");
	    System.out.println("  - Listado de Préstamos (PaginaIndiceFiltros)");
	    System.out.println("  - Registrar Préstamo (PaginaCreacion)");
	    System.out.println("  - Actualizar Préstamo (PaginaActualizacion)");
	    System.out.println("  - Eliminar Préstamo (PaginaBorrado)");
	    System.out.println("\nEstudiante:");
	    System.out.println("  - Biblioteca Universitaria - Inicio (PaginaHome)");
	    System.out.println("  - Información Biblioteca (PaginaContenido)");
	    System.out.println("  - Índice de Categorías (PaginaIndicePaginada)");
	    System.out.println("  - Búsqueda Avanzada de Libros (PaginaIndicePaginadaFiltrada)");
	    
	    ConsoleUtils.pausar(scanner);
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
        
        System.out.println("1. Libro");
        System.out.println("2. Categoria");
        System.out.println("3. Usuario");
        System.out.println("4. Prestamo");
        
        System.out.println("0. Volver");
        
        int opcion = ConsoleUtils.leerOpcion(scanner, 0, 4);
        
        if (opcion == 0) {
            return;
        } else if (opcion >= 1 && opcion <= 4) {
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
