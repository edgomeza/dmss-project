package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 * Clase modelo para la entidad Libro
 * Representa LIBROS en la base de datos
 */
public class Libro implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    
    // Atributos
    private Integer id_libro;
    private String titulo;
    private String autor;
    private Integer añoPublicacion;
    private boolean disponible;
    
    // Referencias a otras entidades
    private Categoria pertenece_categoria;
    
    /**
     * Constructor por defecto
     * Inicializa los valores por defecto para todos los campos
     */
    public Libro() {
        // Inicialización de valores por defecto
        this.id_libro = 0;
        this.titulo = "";
        this.autor = "";
        this.añoPublicacion = 0;
        this.disponible = false;
    }
    
    /**
     * Constructor con todos los atributos (sin referencias)
     */
    public Libro(Integer id_libro, String titulo, String autor, Integer añoPublicacion, boolean disponible) {
        this.id_libro = id_libro;
        this.titulo = titulo;
        this.autor = autor;
        this.añoPublicacion = añoPublicacion;
        this.disponible = disponible;
        
        // Validamos los datos
        validarDatos();
    }
    
    // Getters y setters
    /**
     * Obtiene el valor de id_libro
     * Este es el identificador principal de la entidad
     * @return El valor de id_libro
     */
    public Integer getId_libro() {
        return id_libro;
    }
    
    /**
     * Establece el valor de id_libro
     * Este es el identificador principal de la entidad
     * @param id_libro Nuevo valor
     *      */
    public void setId_libro(Integer id_libro) {
        
        this.id_libro = id_libro;
    }
    
    /**
     * Obtiene el valor de titulo
     * 
     * @return El valor de titulo
     */
    public String getTitulo() {
        return titulo;
    }
    
    /**
     * Establece el valor de titulo
     * 
     * @param titulo Nuevo valor
     *      * @throws ValidacionException Si el valor es null
     */
    public void setTitulo(String titulo) {
        // Validación básica para strings
        if (titulo == null) {
            throw new ValidacionException("El atributo titulo no puede ser null");
        }
        
        this.titulo = titulo;
    }
    
    /**
     * Obtiene el valor de autor
     * 
     * @return El valor de autor
     */
    public String getAutor() {
        return autor;
    }
    
    /**
     * Establece el valor de autor
     * 
     * @param autor Nuevo valor
     *      * @throws ValidacionException Si el valor es null
     */
    public void setAutor(String autor) {
        // Validación básica para strings
        if (autor == null) {
            throw new ValidacionException("El atributo autor no puede ser null");
        }
        
        this.autor = autor;
    }
    
    /**
     * Obtiene el valor de añoPublicacion
     * 
     * @return El valor de añoPublicacion
     */
    public Integer getAñoPublicacion() {
        return añoPublicacion;
    }
    
    /**
     * Establece el valor de añoPublicacion
     * 
     * @param añoPublicacion Nuevo valor
     *      */
    public void setAñoPublicacion(Integer añoPublicacion) {
        
        this.añoPublicacion = añoPublicacion;
    }
    
    /**
     * Obtiene el valor de disponible
     * 
     * @return El valor de disponible
     */
    public boolean getDisponible() {
        return disponible;
    }
    
    /**
     * Establece el valor de disponible
     * 
     * @param disponible Nuevo valor
     *      */
    public void setDisponible(boolean disponible) {
        
        this.disponible = disponible;
    }
    
    
    // Getters y setters para las referencias
    /**
     * Obtiene la referencia a pertenece_categoria (Categoria)
     * @return La entidad Categoria referenciada
     */
    public Categoria getPertenece_categoria() {
        return pertenece_categoria;
    }
    
    /**
     * Establece la referencia a pertenece_categoria (Categoria)
     * @param pertenece_categoria Nueva entidad referenciada
     */
    public void setPertenece_categoria(Categoria pertenece_categoria) {
        this.pertenece_categoria = pertenece_categoria;
    }
    
    
    /**
     * Valida los datos de la entidad
     * @throws ValidacionException Si algún dato no cumple con las restricciones
     */
    public void validarDatos() throws ValidacionException {
        // Validaciones generales
        if (id_libro <= 0) {
            throw new ValidacionException("El identificador id_libro debe ser mayor que cero");
        }
        if (titulo == null) {
            throw new ValidacionException("El atributo titulo no puede ser null");
        }
        if (autor == null) {
            throw new ValidacionException("El atributo autor no puede ser null");
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
        
        Libro other = (Libro) obj;
        
        // Comparación por identificador primario
        return             this.id_libro == other.id_libro
;
    }
    
    /**
     * Calcula el código hash de esta entidad
     * @return Código hash basado en los atributos de la entidad
     */
    @Override
    public int hashCode() {
        return Objects.hash(id_libro);
    }
    
    /**
     * Crea una copia profunda de esta entidad
     * @return Copia de la entidad
     */
    @Override
    public Libro clone() {
        try {
            Libro clone = (Libro) super.clone();
            
            // No es necesario clonar tipos primitivos o String (son inmutables)
            
            // Clonar referencias si es necesario
            if (this.pertenece_categoria != null && this.pertenece_categoria instanceof Cloneable) {
                try {
                    // Intentamos clonar usando el método clone()
                    clone.pertenece_categoria = (Categoria) this.pertenece_categoria.clone();
                } catch (Exception e) {
                    // Si no se puede clonar, asignamos la referencia original
                    clone.pertenece_categoria = this.pertenece_categoria;
                }
            }
            
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Error al clonar Libro", e);
        }
    }
    
    /**
     * Genera una representación en texto de la entidad
     * @return Representación textual de la entidad
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Libro {");
        
        // Incluimos todos los atributos
        sb.append(" id_libro=").append(id_libro);
        sb.append(",");
        sb.append(" titulo=").append(titulo);
        sb.append(",");
        sb.append(" autor=").append(autor);
        sb.append(",");
        sb.append(" añoPublicacion=").append(añoPublicacion);
        sb.append(",");
        sb.append(" disponible=").append(disponible);
        
        // Incluimos las referencias, solo mostrando sus IDs
        sb.append(", pertenece_categoria=");
        if (pertenece_categoria != null) {
            sb.append(pertenece_categoria.getId_categoria());
        } else {
            sb.append("null");
        }
        
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
	    sb.append("Libro #").append(getId_libro());
	    
	    // Añadimos 1-3 atributos representativos
	    sb.append(": ");
	    sb.append(getTitulo());
	    sb.append(" - ");
	    sb.append(getAutor());
	    
	    return sb.toString();
	}
}
