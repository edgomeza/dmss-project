package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 * Clase modelo para la entidad Empleado
 * Representa EMPLEADOS en la base de datos
 */
public class Empleado implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    
    // Atributos
    private Integer id_empleado;
    private String codigo_empleado;
    private String nombre;
    private String puesto;
    private String departamento;
    private String email;
    private boolean activo;
    
    // Referencias a otras entidades
    
    /**
     * Constructor por defecto
     * Inicializa los valores por defecto para todos los campos
     */
    public Empleado() {
        // Inicialización de valores por defecto
        this.id_empleado = 0;
        this.codigo_empleado = "";
        this.nombre = "";
        this.puesto = "";
        this.departamento = "";
        this.email = "";
        this.activo = false;
    }
    
    /**
     * Constructor con todos los atributos (sin referencias)
     */
    public Empleado(Integer id_empleado, String codigo_empleado, String nombre, String puesto, String departamento, String email, boolean activo) {
        this.id_empleado = id_empleado;
        this.codigo_empleado = codigo_empleado;
        this.nombre = nombre;
        this.puesto = puesto;
        this.departamento = departamento;
        this.email = email;
        this.activo = activo;
        
        // Validamos los datos
        validarDatos();
    }
    
    // Getters y setters
    /**
     * Obtiene el valor de id_empleado
     * Este es el identificador principal de la entidad
     * @return El valor de id_empleado
     */
    public Integer getId_empleado() {
        return id_empleado;
    }
    
    /**
     * Establece el valor de id_empleado
     * Este es el identificador principal de la entidad
     * @param id_empleado Nuevo valor
     *      */
    public void setId_empleado(Integer id_empleado) {
        
        this.id_empleado = id_empleado;
    }
    
    /**
     * Obtiene el valor de codigo_empleado
     * 
     * @return El valor de codigo_empleado
     */
    public String getCodigo_empleado() {
        return codigo_empleado;
    }
    
    /**
     * Establece el valor de codigo_empleado
     * 
     * @param codigo_empleado Nuevo valor
     *      * @throws ValidacionException Si el valor es null
     */
    public void setCodigo_empleado(String codigo_empleado) {
        // Validación básica para strings
        if (codigo_empleado == null) {
            throw new ValidacionException("El atributo codigo_empleado no puede ser null");
        }
        
        this.codigo_empleado = codigo_empleado;
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
     * Obtiene el valor de puesto
     * 
     * @return El valor de puesto
     */
    public String getPuesto() {
        return puesto;
    }
    
    /**
     * Establece el valor de puesto
     * 
     * @param puesto Nuevo valor
     *      * @throws ValidacionException Si el valor es null
     */
    public void setPuesto(String puesto) {
        // Validación básica para strings
        if (puesto == null) {
            throw new ValidacionException("El atributo puesto no puede ser null");
        }
        
        this.puesto = puesto;
    }
    
    /**
     * Obtiene el valor de departamento
     * 
     * @return El valor de departamento
     */
    public String getDepartamento() {
        return departamento;
    }
    
    /**
     * Establece el valor de departamento
     * 
     * @param departamento Nuevo valor
     *      * @throws ValidacionException Si el valor es null
     */
    public void setDepartamento(String departamento) {
        // Validación básica para strings
        if (departamento == null) {
            throw new ValidacionException("El atributo departamento no puede ser null");
        }
        
        this.departamento = departamento;
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
        if (id_empleado <= 0) {
            throw new ValidacionException("El identificador id_empleado debe ser mayor que cero");
        }
        if (codigo_empleado == null) {
            throw new ValidacionException("El atributo codigo_empleado no puede ser null");
        }
        if (nombre == null) {
            throw new ValidacionException("El atributo nombre no puede ser null");
        }
        if (puesto == null) {
            throw new ValidacionException("El atributo puesto no puede ser null");
        }
        if (departamento == null) {
            throw new ValidacionException("El atributo departamento no puede ser null");
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
        
        Empleado other = (Empleado) obj;
        
        // Comparación por identificador primario
        return             this.id_empleado == other.id_empleado
;
    }
    
    /**
     * Calcula el código hash de esta entidad
     * @return Código hash basado en los atributos de la entidad
     */
    @Override
    public int hashCode() {
        return Objects.hash(id_empleado);
    }
    
    /**
     * Crea una copia profunda de esta entidad
     * @return Copia de la entidad
     */
    @Override
    public Empleado clone() {
        try {
            Empleado clone = (Empleado) super.clone();
            
            // No es necesario clonar tipos primitivos o String (son inmutables)
            
            // Clonar referencias si es necesario
            
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Error al clonar Empleado", e);
        }
    }
    
    /**
     * Genera una representación en texto de la entidad
     * @return Representación textual de la entidad
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empleado {");
        
        // Incluimos todos los atributos
        sb.append(" id_empleado=").append(id_empleado);
        sb.append(",");
        sb.append(" codigo_empleado=").append(codigo_empleado);
        sb.append(",");
        sb.append(" nombre=").append(nombre);
        sb.append(",");
        sb.append(" puesto=").append(puesto);
        sb.append(",");
        sb.append(" departamento=").append(departamento);
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
	    sb.append("Empleado #").append(getId_empleado());
	    
	    // Añadimos 1-3 atributos representativos
	    sb.append(": ");
	    sb.append(getCodigo_empleado());
	    sb.append(" - ");
	    sb.append(getNombre());
	    sb.append(" - ");
	    sb.append(getPuesto());
	    
	    return sb.toString();
	}
}
