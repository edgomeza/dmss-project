package view;

import java.util.Scanner;
import auth.AuthManager;
import auth.Usuario;
import view.util.ConsoleUtils;
import config.AppConfig;

/**
 * Vista para el inicio de sesión de usuarios
 */
public class LoginView {
    private Scanner scanner;
    private AuthManager authManager;
    
    /**
     * Constructor
     */
    public LoginView() {
        scanner = new Scanner(System.in);
        authManager = AuthManager.getInstance();
    }
    
    /**
     * Muestra la pantalla de inicio de sesión
     * @return true si el inicio de sesión fue exitoso, false en caso contrario
     */
    public boolean mostrar() {
        ConsoleUtils.limpiarPantalla();
        ConsoleUtils.mostrarTitulo("Inicio de Sesión");
        
        // Mostrar usuarios disponibles
        System.out.println("Usuarios disponibles:");
        System.out.println("- admin/admin (Administrador - puede elegir rol)");
        System.out.println("- bibliotecario/bibliotecario (Rol: Bibliotecario - rol fijo)");
        System.out.println("- estudiante/estudiante (Rol: Estudiante - rol fijo)");
        ConsoleUtils.mostrarLinea();
        
        // Si ya hay un usuario autenticado
        if (authManager.isAuthenticated()) {
            Usuario usuario = authManager.getUsuarioActual();
            ConsoleUtils.mostrarInfo("Sesión activa: " + usuario.getNombre() + " (" + usuario.getRolActivo() + ")");
            
            System.out.println("\nOpciones:");
            System.out.println("1. Continuar con la sesión actual");
            if (authManager.puedeElegirRol()) {
                System.out.println("2. Cambiar de rol");
                System.out.println("3. Cerrar sesión");
            } else {
                System.out.println("2. Cerrar sesión");
            }
            
            int maxOpcion = authManager.puedeElegirRol() ? 3 : 2;
            int opcion = ConsoleUtils.leerOpcion(scanner, 1, maxOpcion);
            
            switch (opcion) {
                case 1:
                    return true;
                case 2:
                    if (authManager.puedeElegirRol()) {
                        mostrarMenuCambioRol();
                        return true;
                    } else {
                        // Cerrar sesión
                        authManager.logout();
                        ConsoleUtils.mostrarExito("Sesión cerrada correctamente");
                        ConsoleUtils.pausar(scanner);
                        return false;
                    }
                case 3:
                    if (authManager.puedeElegirRol()) {
                        authManager.logout();
                        ConsoleUtils.mostrarExito("Sesión cerrada correctamente");
                        ConsoleUtils.pausar(scanner);
                        return false;
                    }
                    break;
            }
        }
        
        // Solicitar credenciales
        String username = ConsoleUtils.leerString(scanner, "Nombre de usuario", null, "");
        String password = ConsoleUtils.leerString(scanner, "Contraseña", null, "");
        
        // Intentar inicio de sesión
        if (authManager.login(username, password)) {
            ConsoleUtils.mostrarExito("Inicio de sesión exitoso");
            Usuario usuario = authManager.getUsuarioActual();
            ConsoleUtils.mostrarInfo("Bienvenido, " + usuario.getNombre() + " (" + usuario.getRolActivo() + ")");
            
            // Solo el administrador puede elegir rol
            if (authManager.puedeElegirRol() && usuario.getRoles().size() > 1) {
                ConsoleUtils.mostrarInfo("Como administrador, puedes elegir con qué rol trabajar");
                ConsoleUtils.pausar(scanner);
                mostrarMenuCambioRol();
            } else {
                ConsoleUtils.mostrarInfo("Rol asignado: " + usuario.getRolActivo());
                ConsoleUtils.pausar(scanner);
            }
            
            AppConfig.getInstance().setSessionValue("lastLogin", usuario.getUltimoAcceso());
            return true;
        } else {
            ConsoleUtils.mostrarError("Credenciales incorrectas o usuario inactivo");
            ConsoleUtils.pausar(scanner);
            return false;
        }
    }
    
    /**
     * Muestra el menú para cambiar de rol (solo para administradores)
     */
    private void mostrarMenuCambioRol() {
        if (!authManager.isAuthenticated() || !authManager.puedeElegirRol()) {
            ConsoleUtils.mostrarError("No tiene permisos para cambiar de rol");
            ConsoleUtils.pausar(scanner);
            return;
        }
        
        ConsoleUtils.limpiarPantalla();
        ConsoleUtils.mostrarTitulo("Selección de Rol (Solo Administrador)");
        
        Usuario usuario = authManager.getUsuarioActual();
        String[] roles = usuario.getRoles().toArray(new String[0]);
        
        System.out.println("Rol actual: " + usuario.getRolActivo());
        System.out.println("\nComo administrador, puedes trabajar con cualquier rol:");
        System.out.println("(Esto te permite ver el sistema desde la perspectiva de cada usuario)\n");
        
        for (int i = 0; i < roles.length; i++) {
            String descripcion = "";
            // Añadir descripciones según el rol
            switch(roles[i]) {
                case "Administrador":
                    descripcion = " - Acceso total al sistema";
                    break;
                case "Bibliotecario":
                    descripcion = " - Gestión de libros y préstamos";
                    break;
                case "Estudiante":
                    descripcion = " - Consulta de libros disponibles";
                    break;
                default:
                    descripcion = " - Sin descripción";
            }
            ConsoleUtils.mostrarElementoLista(i + 1, roles[i] + descripcion);
        }
        
        int opcion = ConsoleUtils.leerOpcion(scanner, 1, roles.length);
        
        if (opcion > 0 && opcion <= roles.length) {
            String nuevoRol = roles[opcion - 1];
            usuario.setRolActivo(nuevoRol);
            ConsoleUtils.mostrarExito("Trabajando ahora como: " + nuevoRol);
            
            if (!nuevoRol.equals(authManager.getRolAdministrador())) {
                ConsoleUtils.mostrarInfo("Nota: Estás viendo el sistema desde la perspectiva de " + nuevoRol);
            }
        }
        
        ConsoleUtils.pausar(scanner);
    }
}
