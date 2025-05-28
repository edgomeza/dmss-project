package view;

import java.util.Scanner;
import java.io.IOException;
import dao.DAOFactory;
import view.util.ConsoleUtils;
import auth.AuthManager;
import auth.Usuario;
import config.AppConfig;
import view.admin.AdminMenuView;
import view.settings.ConfiguracionView;

/**
 * Menú principal de la aplicación
 * Punto de entrada para la interfaz de usuario en consola
 */
public class MenuPrincipal {
    private Scanner scanner;
    private AuthManager authManager;
    private AppConfig appConfig;
    
    /**
     * Constructor
     * Inicializa los componentes necesarios
     */
    public MenuPrincipal() {
        scanner = new Scanner(System.in);
        authManager = AuthManager.getInstance();
        appConfig = AppConfig.getInstance();
        
        // Inicializamos el DAOFactory para cargar los datos
        DAOFactory.initialize();
    }
    
    /**
     * Muestra el menú principal y gestiona la navegación
     */
    public void mostrarMenu() {
        boolean salir = false;
        boolean primeraVez = true;
        
        while (!salir) {
            // Primera ejecución o no hay usuario autenticado, mostrar login
            if (primeraVez || !authManager.isAuthenticated()) {
                primeraVez = false;
                LoginView loginView = new LoginView();
                boolean loginExitoso = loginView.mostrar();
                
                if (!loginExitoso && !authManager.isAuthenticated()) {
                    // Si no se pudo iniciar sesión y no había sesión previa, mostrar opciones limitadas
                    salir = mostrarMenuInvitado();
                    continue;
                }
            }
            
            mostrarCabecera();
            mostrarOpciones();
            
            int opcion = ConsoleUtils.leerOpcion(scanner, 0, 7);
            
            switch (opcion) {
			    case 0:
			        salir = true;
			        mostrarMensajeDespedida();
			        break;
			    case 1:
			        if (authManager.isAuthenticated()) {
			            String rolActivo = authManager.getUsuarioActual().getRolActivo();
			            mostrarMenuRolDirecto(rolActivo);
			        } else {
			            ConsoleUtils.mostrarError("Debe iniciar sesión primero");
			            ConsoleUtils.pausar(scanner);
			        }
			        break;
			    case 2:
			        new EncuestaView().mostrar();
			        break;
			    case 3:
			        // Verificar en tiempo real si es administrador
			        if (authManager.isAuthenticated() && authManager.esAdministrador()) {
			            new AdminMenuView().mostrar();
			        } else {
			            // Dashboard para usuarios no admin
			            new DashboardView().mostrar();
			        }
			        break;
			    case 4:
			        // Verificar en tiempo real si es administrador
			        if (authManager.isAuthenticated() && authManager.esAdministrador()) {
			            new DashboardView().mostrar();
			        } else {
			            // Configuración para usuarios no admin
			            new ConfiguracionView().mostrar();
			        }
			        break;
			    case 5:
			        // Verificar en tiempo real si es administrador
			        if (authManager.isAuthenticated() && authManager.esAdministrador()) {
			            new ConfiguracionView().mostrar();
			        } else {
			            // Cerrar sesión para usuarios no admin
			            authManager.logout();
			            ConsoleUtils.mostrarExito("Sesión cerrada correctamente");
			            ConsoleUtils.pausar(scanner);
			            primeraVez = true;
			        }
			        break;
			    case 6:
			        // Verificar en tiempo real si es administrador
			        if (authManager.isAuthenticated() && authManager.esAdministrador()) {
			            // Cerrar sesión para admin
			            authManager.logout();
			            ConsoleUtils.mostrarExito("Sesión cerrada correctamente");
			            ConsoleUtils.pausar(scanner);
			            primeraVez = true;
			        } else {
			            // Información de la aplicación para usuarios no admin
			            mostrarInformacionApp();
			        }
			        break;
			    case 7:
			        // Solo disponible para administradores
			        if (authManager.isAuthenticated() && authManager.esAdministrador()) {
			            // Información de la aplicación para admin
			            mostrarInformacionApp();
			        } else {
			            ConsoleUtils.mostrarError("Opción no válida.");
			            ConsoleUtils.pausar(scanner);
			        }
			        break;
			    default:
			        ConsoleUtils.mostrarError("Opción no válida.");
			        ConsoleUtils.pausar(scanner);
			        break;
			}
        }
    }
    
    /**
     * Muestra un menú limitado para usuarios no autenticados
     * @return true si se debe salir de la aplicación, false en caso contrario
     */
    private boolean mostrarMenuInvitado() {
        ConsoleUtils.limpiarPantalla();
        ConsoleUtils.mostrarTitulo("Biblioteca Universitaria");
        System.out.println("Sistema de gestión de biblioteca universitaria\n");
        ConsoleUtils.mostrarLinea();
        
        System.out.println("\nMenú de invitado:");
        System.out.println("1. Iniciar sesión");
        System.out.println("2. Información de la aplicación");
        System.out.println("0. Salir");
        
        int opcion = ConsoleUtils.leerOpcion(scanner, 0, 2);
        
        switch (opcion) {
            case 0:
                mostrarMensajeDespedida();
                return true;
            case 1:
                LoginView loginView = new LoginView();
                return !loginView.mostrar(); // Si el login falla, volver a mostrar menú invitado
            case 2:
                mostrarInformacionApp();
                return false;
            default:
                return false;
        }
    }
    
    /**
     * Muestra la cabecera del menú principal
     */
    private void mostrarCabecera() {
        ConsoleUtils.limpiarPantalla();
        ConsoleUtils.mostrarTitulo("Biblioteca Universitaria");
        
        if (authManager.isAuthenticated()) {
            Usuario usuario = authManager.getUsuarioActual();
            System.out.println("Bienvenido/a, " + usuario.getNombre() + " (" + usuario.getRolActivo() + ")");
            
            // Mostrar último acceso si está disponible
            String ultimoAcceso = appConfig.getSessionValue("lastLogin");
            if (ultimoAcceso != null) {
                System.out.println("Último acceso: " + ultimoAcceso);
            }
        }
        
        System.out.println("Sistema de gestión de biblioteca universitaria");
        ConsoleUtils.mostrarLinea();
    }
    
    /**
	 * Muestra las opciones disponibles en el menú principal
	 */
	private void mostrarOpciones() {
	    System.out.println("\nMenú principal:");
	    System.out.println("1. Acceder como " + (authManager.isAuthenticated() ? authManager.getUsuarioActual().getRolActivo() : "usuario"));
	    System.out.println("2. Encuestas y cuestionarios");
	    
	    // Verificar en tiempo real si el usuario actual es administrador
	    boolean esAdminActual = authManager.isAuthenticated() && authManager.esAdministrador();
	    
	    if (esAdminActual) {
	        System.out.println("3. Administración");
	        System.out.println("4. Dashboard");
	        System.out.println("5. Configuración");
	        System.out.println("6. Cerrar sesión");
	        System.out.println("7. Acerca de la aplicación");
	        System.out.println("0. Salir");
	    } else {
	        System.out.println("3. Dashboard");
	        System.out.println("4. Configuración");
	        System.out.println("5. Cerrar sesión");
	        System.out.println("6. Acerca de la aplicación");
	        System.out.println("0. Salir");
	    }
	    
	    ConsoleUtils.mostrarLinea();
	    System.out.print("\nSeleccione una opción: ");
	}
    
    /**
     * Obtiene el ID de un rol por su nombre
     * @param rolNombre Nombre del rol
     * @return ID del rol, o -1 si no se encuentra
     */
    private int obtenerIdRol(String rolNombre) {
        if ("Administrador".equals(rolNombre)) {
            return 1;
        }
        if ("Bibliotecario".equals(rolNombre)) {
            return 2;
        }
        if ("Estudiante".equals(rolNombre)) {
            return 3;
        }
        return -1;
    }
    
    /**
     * Muestra el menú correspondiente al rol seleccionado
     * @param rolId Identificador del rol seleccionado
     */
    private void mostrarMenuRol(int rolId) {
        // En lugar de usar referencias específicas a cada MenuRol, usamos una lógica más genérica
        try {
            // Obtener el nombre del rol
            String rolNombre = obtenerNombreRol(rolId);
            if (rolNombre == null) {
                ConsoleUtils.mostrarError("Rol no válido");
                ConsoleUtils.pausar(scanner);
                return;
            }
            
            // Usar reflexión para crear la instancia del MenuRol adecuado
            String className = "view.MenuRol" + rolNombre;
            try {
                Class<?> menuClass = Class.forName(className);
                Object menuInstance = menuClass.getDeclaredConstructor().newInstance();
                
                // Invocar el método mostrarMenu() en la instancia creada
                menuClass.getMethod("mostrarMenu").invoke(menuInstance);
            } catch (ClassNotFoundException e) {
                // Si la clase no existe, mostramos un mensaje más amigable
                ConsoleUtils.mostrarError("La vista para el rol '" + rolNombre + "' no está disponible");
                ConsoleUtils.pausar(scanner);
            } catch (Exception e) {
                ConsoleUtils.mostrarError("Error al cargar la vista: " + e.getMessage());
                ConsoleUtils.pausar(scanner);
            }
        } catch (Exception e) {
            ConsoleUtils.mostrarError("No se puede mostrar el menú para el rol seleccionado: " + e.getMessage());
            ConsoleUtils.pausar(scanner);
        }
    }
    
    /**
     * Obtiene el nombre de un rol por su ID
     * @param rolId ID del rol
     * @return Nombre del rol, o null si no se encuentra
     */
    private String obtenerNombreRol(int rolId) {
        if (1 == rolId) {
            return "Administrador";
        }
        if (2 == rolId) {
            return "Bibliotecario";
        }
        if (3 == rolId) {
            return "Estudiante";
        }
        return null;
    }

	/**
	 * Muestra el menú correspondiente al rol especificado
	 * @param rolNombre Nombre del rol
	 */
	private void mostrarMenuRolDirecto(String rolNombre) {
	    try {
	        // Crear instancia del menú específico del rol
	        switch(rolNombre) {
	            case "Administrador":
	                new MenuAdministrador().mostrarMenu();
	                break;
	            case "Bibliotecario":
	                new MenuBibliotecario().mostrarMenu();
	                break;
	            case "Estudiante":
	                new MenuEstudiante().mostrarMenu();
	                break;
	            default:
	                ConsoleUtils.mostrarError("Vista no disponible para el rol: " + rolNombre);
	                ConsoleUtils.pausar(scanner);
	        }
	    } catch (Exception e) {
	        ConsoleUtils.mostrarError("Error al cargar la vista: " + e.getMessage());
	        ConsoleUtils.pausar(scanner);
	    }
	}

    
    /**
     * Muestra información sobre la aplicación
     */
    private void mostrarInformacionApp() {
	    ConsoleUtils.limpiarPantalla();
	    ConsoleUtils.mostrarTitulo("Acerca de Biblioteca Universitaria");
	    
	    System.out.println("Sistema de gestión de biblioteca universitaria");
	    System.out.println("\nVersión: " + appConfig.getProperty("app.version", "1.0.0"));
	    System.out.println("Desarrollado como parte del proyecto de generación de aplicaciones");
	    
	    System.out.println("\nFuncionalidades principales:");
	    System.out.println("- Sistema de gestión de roles y usuarios");
	    System.out.println("- Gestión CRUD completa para entidades");
	    System.out.println("- Sistema de encuestas y cuestionarios evaluables");
	    System.out.println("- Filtrado, ordenación y búsqueda avanzada");
	    System.out.println("- Notificaciones y alertas");
	    System.out.println("- Estadísticas y reportes");
	    
	    System.out.println("\nRoles disponibles (ordenados por permisos):");
	    // Ordenar roles por número de permisos
	    String indicadorAdminAdministrador = (13 == 13) ? " (Administrador)" : "";
	    System.out.println("- Administrador (13 páginas)" + indicadorAdminAdministrador);
	    String indicadorAdminBibliotecario = (9 == 13) ? " (Administrador)" : "";
	    System.out.println("- Bibliotecario (9 páginas)" + indicadorAdminBibliotecario);
	    String indicadorAdminEstudiante = (4 == 13) ? " (Administrador)" : "";
	    System.out.println("- Estudiante (4 páginas)" + indicadorAdminEstudiante);
	    
	    System.out.println("\nRedes sociales:");
	    System.out.println("- TWITTER: @BibliotecaUniv");
	    System.out.println("- FACEBOOK: @BibliotecaUniversitaria");
	    System.out.println("- INSTAGRAM: @biblioteca_univ");
	    
	    ConsoleUtils.pausar(scanner);
	}
    
    /**
     * Muestra un mensaje de despedida al salir de la aplicación
     */
    private void mostrarMensajeDespedida() {
        ConsoleUtils.limpiarPantalla();
        ConsoleUtils.mostrarTitulo("¡Hasta pronto!");
        System.out.println("Gracias por utilizar Biblioteca Universitaria");
        System.out.println("\nPresione Enter para finalizar...");
        scanner.nextLine();
    }
}
