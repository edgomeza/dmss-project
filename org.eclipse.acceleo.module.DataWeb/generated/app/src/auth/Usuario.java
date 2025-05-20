package auth;

import java.util.HashSet;
import java.util.Set;
import java.io.Serializable;

/**
 * Clase que representa un usuario del sistema
 */
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String username;
    private String password;
    private String nombre;
    private String email;
    private String rolActivo;
    private Set<String> roles;
    private boolean activo;
    private String ultimoAcceso;
    
    /**
     * Constructor por defecto
     */
    public Usuario() {
        this.roles = new HashSet<>();
        this.activo = true;
    }
    
    /**
     * Constructor con parámetros principales
     * @param username Nombre de usuario
     * @param password Contraseña
     * @param nombre Nombre completo
     * @param email Correo electrónico
     */
    public Usuario(String username, String password, String nombre, String email) {
        this();
        this.username = username;
        this.password = password;
        this.nombre = nombre;
        this.email = email;
    }
    
    // Getters y Setters
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getRolActivo() {
        return rolActivo;
    }
    
    public void setRolActivo(String rolActivo) {
        this.rolActivo = rolActivo;
    }
    
    public Set<String> getRoles() {
        return roles;
    }
    
    public void addRol(String rol) {
        this.roles.add(rol);
        if (this.rolActivo == null) {
            this.rolActivo = rol;
        }
    }
    
    public void removeRol(String rol) {
        this.roles.remove(rol);
        if (rol.equals(this.rolActivo)) {
            this.rolActivo = this.roles.isEmpty() ? null : this.roles.iterator().next();
        }
    }
    
    public boolean isActivo() {
        return activo;
    }
    
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    public String getUltimoAcceso() {
        return ultimoAcceso;
    }
    
    public void setUltimoAcceso(String ultimoAcceso) {
        this.ultimoAcceso = ultimoAcceso;
    }
    
    /**
     * Verifica si el usuario tiene un rol específico
     * @param rol Rol a verificar
     * @return true si el usuario tiene el rol, false en caso contrario
     */
    public boolean tieneRol(String rol) {
        return roles.contains(rol);
    }
    
    @Override
    public String toString() {
        return "Usuario{" +
                "username='" + username + '\'' +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", rolActivo='" + rolActivo + '\'' +
                ", roles=" + roles +
                ", activo=" + activo +
                '}';
    }
}
