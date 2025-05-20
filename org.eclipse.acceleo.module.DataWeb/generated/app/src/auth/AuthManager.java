package auth;

import java.util.HashMap;
import java.util.Map;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import view.util.ConsoleUtils;

/**
 * Gestor de autenticación y autorización
 * Implementa el patrón Singleton
 */
public class AuthManager {
    private static AuthManager instance;
    private Map<String, Usuario> usuarios;
    private Usuario usuarioActual;
    private static final String DATA_FILE = "usuarios.dat";
    
    /**
     * Constructor privado (Singleton)
     */
    private AuthManager() {
        usuarios = new HashMap<>();
        cargarUsuarios();
        
        // Si no hay usuarios, crear el administrador por defecto
        if (usuarios.isEmpty()) {
            crearUsuarioAdmin();
        }
    }
    
    /**
     * Obtiene la instancia única del gestor
     * @return Instancia del gestor de autenticación
     */
    public static synchronized AuthManager getInstance() {
        if (instance == null) {
            instance = new AuthManager();
        }
        return instance;
    }
    
    /**
     * Crea el usuario administrador por defecto
     */
    private void crearUsuarioAdmin() {
        Usuario admin = new Usuario("admin", "admin", "Administrador", "admin@example.com");
        admin.addRol("Administrador");
        admin.addRol("Administrador");
        admin.addRol("Bibliotecario");
        admin.addRol("Estudiante");
        usuarios.put(admin.getUsername(), admin);
        guardarUsuarios();
        System.out.println("Usuario administrador creado con credenciales: admin/admin");
    }
    
    /**
     * Intenta autenticar a un usuario
     * @param username Nombre de usuario
     * @param password Contraseña
     * @return true si la autenticación es correcta, false en caso contrario
     */
    public boolean login(String username, String password) {
        Usuario usuario = usuarios.get(username);
        if (usuario != null && usuario.getPassword().equals(password) && usuario.isActivo()) {
            usuarioActual = usuario;
            usuario.setUltimoAcceso(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            guardarUsuarios();
            return true;
        }
        return false;
    }
    
    /**
     * Cierra la sesión del usuario actual
     */
    public void logout() {
        usuarioActual = null;
    }
    
    /**
     * Obtiene el usuario actualmente autenticado
     * @return Usuario actual o null si no hay sesión
     */
    public Usuario getUsuarioActual() {
        return usuarioActual;
    }
    
    /**
     * Verifica si hay un usuario autenticado
     * @return true si hay un usuario con sesión, false en caso contrario
     */
    public boolean isAuthenticated() {
        return usuarioActual != null;
    }
    
    /**
     * Verifica si el usuario actual tiene un rol específico
     * @param rol Rol a verificar
     * @return true si el usuario tiene el rol, false en caso contrario
     */
    public boolean tieneRol(String rol) {
        return isAuthenticated() && usuarioActual.tieneRol(rol);
    }
    
    /**
     * Cambia el rol activo del usuario actual
     * @param rol Nuevo rol activo
     * @return true si se cambió correctamente, false si el usuario no tiene ese rol
     */
    public boolean cambiarRolActivo(String rol) {
        if (isAuthenticated() && usuarioActual.tieneRol(rol)) {
            usuarioActual.setRolActivo(rol);
            return true;
        }
        return false;
    }
    
    /**
     * Registra un nuevo usuario
     * @param usuario Usuario a registrar
     * @return true si se registró correctamente, false si ya existe
     */
    public boolean registrarUsuario(Usuario usuario) {
        if (usuarios.containsKey(usuario.getUsername())) {
            return false;
        }
        
        usuarios.put(usuario.getUsername(), usuario);
        guardarUsuarios();
        return true;
    }
    
    /**
     * Actualiza un usuario existente
     * @param usuario Usuario a actualizar
     * @return true si se actualizó correctamente, false si no existe
     */
    public boolean actualizarUsuario(Usuario usuario) {
        if (!usuarios.containsKey(usuario.getUsername())) {
            return false;
        }
        
        usuarios.put(usuario.getUsername(), usuario);
        guardarUsuarios();
        return true;
    }
    
    /**
     * Elimina un usuario
     * @param username Nombre del usuario a eliminar
     * @return true si se eliminó correctamente, false si no existe
     */
    public boolean eliminarUsuario(String username) {
        if (!usuarios.containsKey(username)) {
            return false;
        }
        
        usuarios.remove(username);
        guardarUsuarios();
        return true;
    }
    
    /**
     * Obtiene un usuario por su nombre
     * @param username Nombre del usuario
     * @return Usuario o null si no existe
     */
    public Usuario getUsuario(String username) {
        return usuarios.get(username);
    }
    
    /**
     * Obtiene todos los usuarios registrados
     * @return Mapa de usuarios (username -> Usuario)
     */
    public Map<String, Usuario> getUsuarios() {
        return new HashMap<>(usuarios);
    }
    
    /**
     * Carga los usuarios desde archivo
     */
    @SuppressWarnings("unchecked")
    private void cargarUsuarios() {
        try {
            File file = new File(DATA_FILE);
            if (file.exists()) {
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
                usuarios = (Map<String, Usuario>) in.readObject();
                in.close();
                System.out.println("Usuarios cargados correctamente desde " + DATA_FILE);
            }
        } catch (Exception e) {
            System.err.println("Error al cargar usuarios: " + e.getMessage());
            usuarios = new HashMap<>();
        }
    }
    
    /**
     * Guarda los usuarios en archivo
     */
    private void guardarUsuarios() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(DATA_FILE));
            out.writeObject(usuarios);
            out.close();
        } catch (Exception e) {
            System.err.println("Error al guardar usuarios: " + e.getMessage());
        }
    }
}
