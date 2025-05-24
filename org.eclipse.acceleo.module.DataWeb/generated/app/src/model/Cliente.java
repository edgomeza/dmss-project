package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 * Clase modelo para la entidad Cliente
 * Representa CLIENTES en la base de datos
 */
public class Cliente implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    
    // Atributos
    private Integer id_cliente;
    private String dni;
    private String nombre;
    private String apellidos;
    private String email;
    private String telefono;
    private String fecha_registro;
    private boolean activo;
    
    // Referencias a otras entidades
    
    /**
     * Constructor por defecto
     * Inicializa los valores por defecto para todos los campos
     */
    public Cliente() {
        // Inicialización de valores por defecto
        this.id_cliente = 0;
        this.dni = "";
        this.nombre = "";
        this.apellidos = "";
        this.email = "";
        this.telefono = "";
        this.fecha_registro = "";
        this.activo = false;
    }
    
    /**
     * Constructor con todos los atributos (sin referencias)
     */
    public Cliente(Integer id_cliente, String dni, String nombre, String apellidos, String email, String telefono, String fecha_registro, boolean activo) {
        this.id_cliente = id_cliente;
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
        this.fecha_registro = fecha_registro;
        this.activo = activo;
        
        // Validamos los datos
        validarDatos();
    }
    
    // Getters y setters
    /**
     * Obtiene el valor de id_cliente
     * Este es el identificador principal de la entidad
     * @return El valor de id_cliente
     */
    public Integer getId_cliente() {
        return id_cliente;
    }
    
    /**
     * Establece el valor de id_cliente
     * Este es el identificador principal de la entidad
     * @param id_cliente Nuevo valor
     *      */
    public void setId_cliente(Integer id_cliente) {
        
        this.id_cliente = id_cliente;
    }
    
    /**
     * Obtiene el valor de dni
     * 
     * @return El valor de dni
     */
    public String getDni() {
        return dni;
    }
    
    /**
     * Establece el valor de dni
     * 
     * @param dni Nuevo valor
     *      * @throws ValidacionException Si el valor es null
     */
    public void setDni(String dni) {
        // Validación básica para strings
        if (dni == null) {
            throw new ValidacionException("El atributo dni no puede ser null");
        }
        
        this.dni = dni;
    }
    
    /**
     * Obtiene el valor de nombre
     * 
     * @return El valor de nombre
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Establece el valor de nombre
     * 
     * @param nombre Nuevo valor
     *      * @throws ValidacionException Si el valor es null
     */
    public void setNombre(String nombre) {
        // Validación básica para strings
        if (nombre == null) {
            throw new ValidacionException("El atributo nombre no puede ser null");
        }
        
        this.nombre = nombre;
    }
    
    /**
     * Obtiene el valor de apellidos
     * 
     * @return El valor de apellidos
     */
    public String getApellidos() {
        return apellidos;
    }
    
    /**
     * Establece el valor de apellidos
     * 
     * @param apellidos Nuevo valor
     *      * @throws ValidacionException Si el valor es null
     */
    public void setApellidos(String apellidos) {
        // Validación básica para strings
        if (apellidos == null) {
            throw new ValidacionException("El atributo apellidos no puede ser null");
        }
        
        this.apellidos = apellidos;
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
     * Obtiene el valor de telefono
     * 
     * @return El valor de telefono
     */
    public String getTelefono() {
        return telefono;
    }
    
    /**
     * Establece el valor de telefono
     * 
     * @param telefono Nuevo valor
     *      * @throws ValidacionException Si el valor es null
     */
    public void setTelefono(String telefono) {
        // Validación básica para strings
        if (telefono == null) {
            throw new ValidacionException("El atributo telefono no puede ser null");
        }
        
        this.telefono = telefono;
    }
    
    /**
     * Obtiene el valor de fecha_registro
     * 
     * @return El valor de fecha_registro
     */
    public String getFecha_registro() {
        return fecha_registro;
    }
    
    /**
     * Establece el valor de fecha_registro
     * 
     * @param fecha_registro Nuevo valor
     *      * @throws ValidacionException Si el valor es null
     */
    public void setFecha_registro(String fecha_registro) {
        // Validación básica para strings
        if (fecha_registro == null) {
            throw new ValidacionException("El atributo fecha_registro no puede ser null");
        }
        
        this.fecha_registro = fecha_registro;
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
        if (id_cliente <= 0) {
            throw new ValidacionException("El identificador id_cliente debe ser mayor que cero");
        }
        if (dni == null) {
            throw new ValidacionException("El atributo dni no puede ser null");
        }
        if (nombre == null) {
            throw new ValidacionException("El atributo nombre no puede ser null");
        }
        if (apellidos == null) {
            throw new ValidacionException("El atributo apellidos no puede ser null");
        }
        if (email == null) {
            throw new ValidacionException("El atributo email no puede ser null");
        }
        if (telefono == null) {
            throw new ValidacionException("El atributo telefono no puede ser null");
        }
        if (fecha_registro == null) {
            throw new ValidacionException("El atributo fecha_registro no puede ser null");
        }
        
        // Validaciones específicas de campos tipo fecha
        if (!fecha_registro.isEmpty()) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                dateFormat.setLenient(false);
                dateFormat.parse(fecha_registro);
            } catch (ParseException e) {
                throw new ValidacionException("El formato de fecha_registro no es válido. Use formato yyyy-MM-dd");
            }
        }
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
        
        Cliente other = (Cliente) obj;
        
        // Comparación por identificador primario
        return             this.id_cliente == other.id_cliente
;
    }
    
    /**
     * Calcula el código hash de esta entidad
     * @return Código hash basado en los atributos de la entidad
     */
    @Override
    public int hashCode() {
        return Objects.hash(id_cliente);
    }
    
    /**
     * Crea una copia profunda de esta entidad
     * @return Copia de la entidad
     */
    @Override
    public Cliente clone() {
        try {
            Cliente clone = (Cliente) super.clone();
            
            // No es necesario clonar tipos primitivos o String (son inmutables)
            
            // Clonar referencias si es necesario
            
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Error al clonar Cliente", e);
        }
    }
    
    /**
     * Genera una representación en texto de la entidad
     * @return Representación textual de la entidad
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente {");
        
        // Incluimos todos los atributos
        sb.append(" id_cliente=").append(id_cliente);
        sb.append(",");
        sb.append(" dni=").append(dni);
        sb.append(",");
        sb.append(" nombre=").append(nombre);
        sb.append(",");
        sb.append(" apellidos=").append(apellidos);
        sb.append(",");
        sb.append(" email=").append(email);
        sb.append(",");
        sb.append(" telefono=").append(telefono);
        sb.append(",");
        sb.append(" fecha_registro=").append(fecha_registro);
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
	    sb.append("Cliente #").append(getId_cliente());
	    
	    // Añadimos 1-3 atributos representativos
	    sb.append(": ");
	    sb.append(getDni());
	    sb.append(" - ");
	    sb.append(getNombre());
	    sb.append(" - ");
	    sb.append(getApellidos());
	    
	    return sb.toString();
	}
}
