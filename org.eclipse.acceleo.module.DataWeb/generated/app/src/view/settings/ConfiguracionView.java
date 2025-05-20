package view.settings;

import java.util.Scanner;
import view.util.ConsoleUtils;
import config.AppConfig;
import auth.AuthManager;

/**
 * Vista para la configuración de la aplicación
 */
public class ConfiguracionView {
    private Scanner scanner;
    private AppConfig appConfig;
    private AuthManager authManager;
    
    /**
     * Constructor
     */
    public ConfiguracionView() {
        scanner = new Scanner(System.in);
        appConfig = AppConfig.getInstance();
        authManager = AuthManager.getInstance();
    }
    
    /**
     * Muestra la pantalla de configuración
     */
    public void mostrar() {
        boolean salir = false;
        
        while (!salir) {
            ConsoleUtils.limpiarPantalla();
            ConsoleUtils.mostrarTitulo("Configuración");
            
            System.out.println("1. Apariencia");
            System.out.println("2. Preferencias de visualización");
            
            if (authManager.isAuthenticated()) {
                System.out.println("3. Perfil de usuario");
                System.out.println("4. Cambiar rol activo");
            }
            
            System.out.println("0. Volver al menú principal");
            
            int maxOpcion = authManager.isAuthenticated() ? 4 : 2;
            int opcion = ConsoleUtils.leerOpcion(scanner, 0, maxOpcion);
            
            switch (opcion) {
                case 0:
                    salir = true;
                    break;
                case 1:
                    configurarApariencia();
                    break;
                case 2:
                    configurarPreferencias();
                    break;
                case 3:
                    if (authManager.isAuthenticated()) {
                        configurarPerfil();
                    }
                    break;
                case 4:
                    if (authManager.isAuthenticated()) {
                        cambiarRol();
                    }
                    break;
            }
        }
    }
    
    /**
     * Configura las opciones de apariencia
     */
    private void configurarApariencia() {
        ConsoleUtils.limpiarPantalla();
        ConsoleUtils.mostrarTitulo("Configuración de Apariencia");
        
        boolean modoOscuro = appConfig.isDarkModeEnabled();
        System.out.println("Modo oscuro: " + (modoOscuro ? "Activado" : "Desactivado"));
        
        boolean cambiar = ConsoleUtils.leerBooleano(scanner, "¿Desea cambiar el modo de visualización?", false);
        
        if (cambiar) {
            appConfig.setDarkMode(!modoOscuro);
            appConfig.saveConfiguration();
            
            if (appConfig.isDarkModeEnabled()) {
                ConsoleUtils.mostrarExito("Modo oscuro activado");
            } else {
                ConsoleUtils.mostrarExito("Modo claro activado");
            }
        }
        
        ConsoleUtils.pausar(scanner);
    }
    
    /**
     * Configura las preferencias de visualización
     */
    private void configurarPreferencias() {
        ConsoleUtils.limpiarPantalla();
        ConsoleUtils.mostrarTitulo("Preferencias de Visualización");
        
        int tamanioPaginacion = appConfig.getPaginationSize();
        System.out.println("Elementos por página: " + tamanioPaginacion);
        
        String formatoFecha = appConfig.getProperty("display.dateFormat", "yyyy-MM-dd");
        System.out.println("Formato de fecha: " + formatoFecha);
        
        boolean mostrarColores = Boolean.parseBoolean(appConfig.getProperty("display.showColors", "true"));
        System.out.println("Mostrar colores: " + (mostrarColores ? "Sí" : "No"));
        
        System.out.println("\nSeleccione qué desea configurar:");
        System.out.println("1. Elementos por página");
        System.out.println("2. Formato de fecha");
        System.out.println("3. Mostrar colores");
        System.out.println("0. Volver");
        
        int opcion = ConsoleUtils.leerOpcion(scanner, 0, 3);
        
        switch (opcion) {
            case 0:
                return;
            case 1:
                int nuevoTamanio = ConsoleUtils.leerEntero(scanner, "Nuevo tamaño de paginación", 
                        valor -> valor > 0 && valor <= 50, tamanioPaginacion);
                appConfig.setPaginationSize(nuevoTamanio);
                ConsoleUtils.mostrarExito("Tamaño de paginación actualizado a " + nuevoTamanio);
                break;
            case 2:
                System.out.println("Formatos disponibles:");
                System.out.println("1. yyyy-MM-dd (por defecto)");
                System.out.println("2. dd/MM/yyyy");
                System.out.println("3. MM/dd/yyyy");
                
                int formatoOpcion = ConsoleUtils.leerOpcion(scanner, 1, 3);
                String nuevoFormato = formatoFecha;
                
                switch (formatoOpcion) {
                    case 1:
                        nuevoFormato = "yyyy-MM-dd";
                        break;
                    case 2:
                        nuevoFormato = "dd/MM/yyyy";
                        break;
                    case 3:
                        nuevoFormato = "MM/dd/yyyy";
                        break;
                }
                
                appConfig.setProperty("display.dateFormat", nuevoFormato);
                ConsoleUtils.mostrarExito("Formato de fecha actualizado a " + nuevoFormato);
                break;
            case 3:
                boolean nuevoValor = ConsoleUtils.leerBooleano(scanner, "¿Desea mostrar colores?", mostrarColores);
                appConfig.setProperty("display.showColors", String.valueOf(nuevoValor));
                ConsoleUtils.mostrarExito("Configuración de colores actualizada");
                break;
        }
        
        appConfig.saveConfiguration();
        ConsoleUtils.pausar(scanner);
    }
    
    /**
     * Configura el perfil del usuario actual
     */
    private void configurarPerfil() {
        if (!authManager.isAuthenticated()) {
            ConsoleUtils.mostrarError("Debe iniciar sesión para configurar el perfil");
            ConsoleUtils.pausar(scanner);
            return;
        }
        
        ConsoleUtils.limpiarPantalla();
        ConsoleUtils.mostrarTitulo("Perfil de Usuario");
        
        auth.Usuario usuario = authManager.getUsuarioActual();
        
        System.out.println("Nombre de usuario: " + usuario.getUsername());
        System.out.println("Nombre: " + usuario.getNombre());
        System.out.println("Email: " + usuario.getEmail());
        System.out.println("Rol activo: " + usuario.getRolActivo());
        System.out.println("Roles asignados: " + String.join(", ", usuario.getRoles()));
        
        System.out.println("\nSeleccione qué desea modificar:");
        System.out.println("1. Nombre");
        System.out.println("2. Email");
        System.out.println("3. Contraseña");
        System.out.println("0. Volver");
        
        int opcion = ConsoleUtils.leerOpcion(scanner, 0, 3);
        
        switch (opcion) {
            case 0:
                return;
            case 1:
                String nuevoNombre = ConsoleUtils.leerString(scanner, "Nuevo nombre", 
                        valor -> !valor.isEmpty(), usuario.getNombre());
                
                usuario.setNombre(nuevoNombre);
                authManager.actualizarUsuario(usuario);
                ConsoleUtils.mostrarExito("Nombre actualizado correctamente");
                break;
            case 2:
                String nuevoEmail = ConsoleUtils.leerString(scanner, "Nuevo email", 
                        valor -> !valor.isEmpty() && valor.contains("@"), usuario.getEmail());
                
                usuario.setEmail(nuevoEmail);
                authManager.actualizarUsuario(usuario);
                ConsoleUtils.mostrarExito("Email actualizado correctamente");
                break;
            case 3:
                String passwordActual = ConsoleUtils.leerString(scanner, "Contraseña actual", null, "");
                
                if (passwordActual.equals(usuario.getPassword())) {
                    String nuevaPassword = ConsoleUtils.leerString(scanner, "Nueva contraseña", 
                            valor -> !valor.isEmpty(), "");
                    String confirmacion = ConsoleUtils.leerString(scanner, "Confirmar contraseña", 
                            valor -> !valor.isEmpty(), "");
                    
                    if (nuevaPassword.equals(confirmacion)) {
                        usuario.setPassword(nuevaPassword);
                        authManager.actualizarUsuario(usuario);
                        ConsoleUtils.mostrarExito("Contraseña actualizada correctamente");
                    } else {
                        ConsoleUtils.mostrarError("Las contraseñas no coinciden");
                    }
                } else {
                    ConsoleUtils.mostrarError("Contraseña actual incorrecta");
                }
                break;
        }
        
        ConsoleUtils.pausar(scanner);
    }
    
    /**
     * Permite cambiar el rol activo del usuario
     */
    private void cambiarRol() {
        if (!authManager.isAuthenticated()) {
            ConsoleUtils.mostrarError("Debe iniciar sesión para cambiar de rol");
            ConsoleUtils.pausar(scanner);
            return;
        }
        
        ConsoleUtils.limpiarPantalla();
        ConsoleUtils.mostrarTitulo("Cambiar Rol Activo");
        
        auth.Usuario usuario = authManager.getUsuarioActual();
        String rolActual = usuario.getRolActivo();
        
        System.out.println("Rol actual: " + rolActual);
        System.out.println("\nRoles disponibles:");
        
        String[] roles = usuario.getRoles().toArray(new String[0]);
        for (int i = 0; i < roles.length; i++) {
            String indicador = roles[i].equals(rolActual) ? " (actual)" : "";
            System.out.println((i + 1) + ". " + roles[i] + indicador);
        }
        
        int opcion = ConsoleUtils.leerEntero(scanner, "\nSeleccione un rol", 
                valor -> valor >= 1 && valor <= roles.length, 1);
        
        String nuevoRol = roles[opcion - 1];
        if (!nuevoRol.equals(rolActual)) {
            usuario.setRolActivo(nuevoRol);
            authManager.actualizarUsuario(usuario);
            ConsoleUtils.mostrarExito("Rol cambiado a: " + nuevoRol);
        } else {
            ConsoleUtils.mostrarInfo("No se ha realizado ningún cambio");
        }
        
        ConsoleUtils.pausar(scanner);
    }
}
