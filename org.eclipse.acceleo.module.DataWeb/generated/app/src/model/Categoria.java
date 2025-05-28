package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 * Clase modelo para la entidad Categoria
 * Representa CATEGORIAS en la base de datos
 */
public class Categoria implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    
    // Atributos
    private Integer id_categoria;
    private String nombre_categoria;
    private String descripcion;
    
    // Referencias a otras entidades
    
    /**
     * Constructor por defecto
     * Inicializa los valores por defecto para todos los campos
     */
    public Categoria() {
        // Inicialización de valores por defecto
        this.id_categoria = 0;
        this.nombre_categoria = "";
        this.descripcion = "";
    }
    
    /**
     * Constructor con todos los atributos (sin referencias)
     */
    public Categoria(Integer id_categoria, String nombre_categoria, String descripcion) {
        this.id_categoria = id_categoria;
        this.nombre_categoria = nombre_categoria;
        this.descripcion = descripcion;
        
        // Validamos los datos
        validarDatos();
    }
    
    // Getters y setters
    /**
     * Obtiene el valor de id_categoria
     * Este es el identificador principal de la entidad
     * @return El valor de id_categoria
     */
    public Integer getId_categoria() {
        return id_categoria;
    }
    
    /**
     * Establece el valor de id_categoria
     * Este es el identificador principal de la entidad
     * @param id_categoria Nuevo valor
     *      */
    public void setId_categoria(Integer id_categoria) {
        
        this.id_categoria = id_categoria;
    }
    
    /**
     * Obtiene el valor de nombre_categoria
     * 
     * @return El valor de nombre_categoria
     */
    public String getNombre_categoria() {
        return nombre_categoria;
    }
    
    /**
     * Establece el valor de nombre_categoria
     * 
     * @param nombre_categoria Nuevo valor
     *      * @throws ValidacionException Si el valor es null
     */
    public void setNombre_categoria(String nombre_categoria) {
        // Validación básica para strings
        if (nombre_categoria == null) {
            throw new ValidacionException("El atributo nombre_categoria no puede ser null");
        }
        
        this.nombre_categoria = nombre_categoria;
    }
    
    /**
     * Obtiene el valor de descripcion
     * 
     * @return El valor de descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }
    
    /**
     * Establece el valor de descripcion
     * 
     * @param descripcion Nuevo valor
     *      * @throws ValidacionException Si el valor es null
     */
    public void setDescripcion(String descripcion) {
        // Validación básica para strings
        if (descripcion == null) {
            throw new ValidacionException("El atributo descripcion no puede ser null");
        }
        
        this.descripcion = descripcion;
    }
    
    
    // Getters y setters para las referencias
    
    /**
     * Valida los datos de la entidad
     * @throws ValidacionException Si algún dato no cumple con las restricciones
     */
    public void validarDatos() throws ValidacionException {
        // Validaciones generales
        if (id_categoria <= 0) {
            throw new ValidacionException("El identificador id_categoria debe ser mayor que cero");
        }
        if (nombre_categoria == null) {
            throw new ValidacionException("El atributo nombre_categoria no puede ser null");
        }
        if (descripcion == null) {
            throw new ValidacionException("El atributo descripcion no puede ser null");
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
        
        Categoria other = (Categoria) obj;
        
        // Comparación por identificador primario
        return             this.id_categoria == other.id_categoria
;
    }
    
    /**
     * Calcula el código hash de esta entidad
     * @return Código hash basado en los atributos de la entidad
     */
    @Override
    public int hashCode() {
        return Objects.hash(id_categoria);
    }
    
    /**
     * Crea una copia profunda de esta entidad
     * @return Copia de la entidad
     */
    @Override
    public Categoria clone() {
        try {
            Categoria clone = (Categoria) super.clone();
            
            // No es necesario clonar tipos primitivos o String (son inmutables)
            
            // Clonar referencias si es necesario
            
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Error al clonar Categoria", e);
        }
    }
    
    /**
     * Genera una representación en texto de la entidad
     * @return Representación textual de la entidad
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Categoria {");
        
        // Incluimos todos los atributos
        sb.append(" id_categoria=").append(id_categoria);
        sb.append(",");
        sb.append(" nombre_categoria=").append(nombre_categoria);
        sb.append(",");
        sb.append(" descripcion=").append(descripcion);
        
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
	    sb.append("Categoria #").append(getId_categoria());
	    
	    // Añadimos 1-3 atributos representativos
	    sb.append(": ");
	    sb.append(getNombre_categoria());
	    sb.append(" - ");
	    sb.append(getDescripcion());
	    
	    return sb.toString();
	}
}
