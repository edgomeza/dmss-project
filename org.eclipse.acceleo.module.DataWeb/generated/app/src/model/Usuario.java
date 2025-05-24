package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 * Clase modelo para la entidad Usuario
 * Representa USUARIOS en la base de datos
 */
public class Usuario implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    
    // Atributos
    private Integer id_usuario;
    private String nombre_usuario;
    private String email;
    private boolean activo;
    
    // Referencias a otras entidades
    
    /**
     * Constructor por defecto
     * Inicializa los valores por defecto para todos los campos
     */
    public Usuario() {
        // Inicialización de valores por defecto
        this.id_usuario = 0;
        this.nombre_usuario = "";
        this.email = "";
        this.activo = false;
    }
    
    /**
     * Constructor con todos los atributos (sin referencias)
     */
    public Usuario(Integer id_usuario, String nombre_usuario, String email, boolean activo) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.email = email;
        this.activo = activo;
        
        // Validamos los datos
        validarDatos();
    }
    
    // Getters y setters
    /**
     * Obtiene el valor de id_usuario
     * Este es el identificador principal de la entidad
     * @return El valor de id_usuario
     */
    public Integer getId_usuario() {
        return id_usuario;
    }
    
    /**
     * Establece el valor de id_usuario
     * Este es el identificador principal de la entidad
     * @param id_usuario Nuevo valor
     *      */
    public void setId_usuario(Integer id_usuario) {
        
        this.id_usuario = id_usuario;
    }
    
    /**
     * Obtiene el valor de nombre_usuario
     * 
     * @return El valor de nombre_usuario
     */
    public String getNombre_usuario() {
        return nombre_usuario;
    }
    
    /**
     * Establece el valor de nombre_usuario
     * 
     * @param nombre_usuario Nuevo valor
     *      * @throws ValidacionException Si el valor es null
     */
    public void setNombre_usuario(String nombre_usuario) {
        // Validación básica para strings
        if (nombre_usuario == null) {
            throw new ValidacionException("El atributo nombre_usuario no puede ser null");
        }
        
        this.nombre_usuario = nombre_usuario;
    }
    
    /**
     * Obtiene el valor de email
     * 
     * @return El valor de email
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * Establece el valor de email
     * 
     * @param email Nuevo valor
     *      * @throws ValidacionException Si el valor es null
     */
    public void setEmail(String email) {
        // Validación básica para strings
        if (email == null) {
            throw new ValidacionException("El atributo email no puede ser null");
        }
        
        this.email = email;
    }
    
    /**
     * Obtiene el valor de activo
     * 
     * @return El valor de activo
     */
    public boolean getActivo() {
        return activo;
    }
    
    /**
     * Establece el valor de activo
     * 
     * @param activo Nuevo valor
     *      */
    public void setActivo(boolean activo) {
        
        this.activo = activo;
    }
    
    
    // Getters y setters para las referencias
    
    /**
     * Valida los datos de la entidad
     * @throws ValidacionException Si algún dato no cumple con las restricciones
     */
    public void validarDatos() throws ValidacionException {
        // Validaciones generales
        if (id_usuario <= 0) {
            throw new ValidacionException("El identificador id_usuario debe ser mayor que cero");
        }
        if (nombre_usuario == null) {
            throw new ValidacionException("El atributo nombre_usuario no puede ser null");
        }
        if (email == null) {
            throw new ValidacionException("El atributo email no puede ser null");
        }
        
        // Validaciones específicas de campos tipo fecha
    }
    
    /**
     * Verifica si esta entidad es igual a otro objeto
     * @param obj Objeto a comparar
     * @return true si son iguales, false en caso contrario
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Usuario other = (Usuario) obj;
        
        // Comparación por identificador primario
        return             this.id_usuario == other.id_usuario
;
    }
    
    /**
     * Calcula el código hash de esta entidad
     * @return Código hash basado en los atributos de la entidad
     */
    @Override
    public int hashCode() {
        return Objects.hash(id_usuario);
    }
    
    /**
     * Crea una copia profunda de esta entidad
     * @return Copia de la entidad
     */
    @Override
    public Usuario clone() {
        try {
            Usuario clone = (Usuario) super.clone();
            
            // No es necesario clonar tipos primitivos o String (son inmutables)
            
            // Clonar referencias si es necesario
            
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Error al clonar Usuario", e);
        }
    }
    
    /**
     * Genera una representación en texto de la entidad
     * @return Representación textual de la entidad
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Usuario {");
        
        // Incluimos todos los atributos
        sb.append(" id_usuario=").append(id_usuario);
        sb.append(",");
        sb.append(" nombre_usuario=").append(nombre_usuario);
        sb.append(",");
        sb.append(" email=").append(email);
        sb.append(",");
        sb.append(" activo=").append(activo);
        
        // Incluimos las referencias, solo mostrando sus IDs
        
        sb.append("}");
        return sb.toString();
    }
    
    /**
	 * Convierte la entidad a un formato adecuado para mostrar al usuario
	 * @return Cadena de texto con la información principal de la entidad
	 */
	public String toDisplayString() {
	    StringBuilder sb = new StringBuilder();
	    
	    // Mostramos el identificador y algunos atributos clave para identificación
	    sb.append("Usuario #").append(getId_usuario());
	    
	    // Añadimos 1-3 atributos representativos
	    sb.append(": ");
	    sb.append(getNombre_usuario());
	    sb.append(" - ");
	    sb.append(getEmail());
	    
	    return sb.toString();
	}
}
