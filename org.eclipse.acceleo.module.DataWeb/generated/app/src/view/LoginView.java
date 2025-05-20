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
        
        // Si ya hay un usuario autenticado, ofrecer cerrar sesión
        if (authManager.isAuthenticated()) {
            Usuario usuario = authManager.getUsuarioActual();
            ConsoleUtils.mostrarInfo("Has iniciado sesión como " + usuario.getNombre() + 
                                     " (" + usuario.getUsername() + ")");
            ConsoleUtils.mostrarInfo("Rol actual: " + usuario.getRolActivo());
            
            System.out.println("\nOpciones:");
            System.out.println("1. Continuar con la sesión actual");
            System.out.println("2. Cambiar de rol");
            System.out.println("3. Cerrar sesión");
            
            int opcion = ConsoleUtils.leerOpcion(scanner, 1, 3);
            
            switch (opcion) {
                case 1:
                    return true;
                case 2:
                    mostrarMenuCambioRol();
                    return true;
                case 3:
                    authManager.logout();
                    ConsoleUtils.mostrarExito("Sesión cerrada correctamente");
                    ConsoleUtils.pausar(scanner);
                    // Continuar con el inicio de sesión
                    break;
                default:
                    return false;
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
            ConsoleUtils.pausar(scanner);
            
            // Si el usuario tiene múltiples roles, mostrar selección
            if (usuario.getRoles().size() > 1) {
                mostrarMenuCambioRol();
            }
            
            // Guardar preferencias de usuario
            AppConfig.getInstance().setSessionValue("lastLogin", usuario.getUltimoAcceso());
            return true;
        } else {
            ConsoleUtils.mostrarError("Credenciales incorrectas o usuario inactivo");
            ConsoleUtils.pausar(scanner);
            return false;
        }
    }
    
    /**
     * Muestra el menú para cambiar de rol
     */
    private void mostrarMenuCambioRol() {
        if (!authManager.isAuthenticated()) {
            return;
        }
        
        ConsoleUtils.limpiarPantalla();
        ConsoleUtils.mostrarTitulo("Cambio de Rol");
        
        Usuario usuario = authManager.getUsuarioActual();
        String[] roles = usuario.getRoles().toArray(new String[0]);
        
        System.out.println("Rol actual: " + usuario.getRolActivo());
        System.out.println("\nSeleccione un nuevo rol:");
        
        for (int i = 0; i < roles.length; i++) {
            ConsoleUtils.mostrarElementoLista(i + 1, roles[i]);
        }
        
        int opcion = ConsoleUtils.leerOpcion(scanner, 1, roles.length);
        
        if (opcion > 0 && opcion <= roles.length) {
            String nuevoRol = roles[opcion - 1];
            usuario.setRolActivo(nuevoRol);
            ConsoleUtils.mostrarExito("Rol cambiado a: " + nuevoRol);
        }
        
        ConsoleUtils.pausar(scanner);
    }
}
