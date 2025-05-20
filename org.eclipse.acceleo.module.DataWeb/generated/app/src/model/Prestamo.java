package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 * Clase modelo para la entidad Prestamo
 * Representa PRESTAMOS en la base de datos
 */
public class Prestamo implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    
    // Atributos
    private Integer id_prestamo;
    private String fechaPrestamo;
    private String fechaDevolucion;
    
    // Referencias a otras entidades
    private Usuario prestamo_usuario;
    private Libro prestamo_libro;
    
    /**
     * Constructor por defecto
     * Inicializa los valores por defecto para todos los campos
     */
    public Prestamo() {
        // Inicialización de valores por defecto
        this.id_prestamo = 0;
        this.fechaPrestamo = "";
        this.fechaDevolucion = "";
    }
    
    /**
     * Constructor con todos los atributos (sin referencias)
     */
    public Prestamo(Integer id_prestamo, String fechaPrestamo, String fechaDevolucion) {
        this.id_prestamo = id_prestamo;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        
        // Validamos los datos
        validarDatos();
    }
    
    // Getters y setters
    /**
     * Obtiene el valor de id_prestamo
     * Este es el identificador principal de la entidad
     * @return El valor de id_prestamo
     */
    public Integer getId_prestamo() {
        return id_prestamo;
    }
    
    /**
     * Establece el valor de id_prestamo
     * Este es el identificador principal de la entidad
     * @param id_prestamo Nuevo valor
     *      */
    public void setId_prestamo(Integer id_prestamo) {
        
        this.id_prestamo = id_prestamo;
    }
    
    /**
     * Obtiene el valor de fechaPrestamo
     * 
     * @return El valor de fechaPrestamo
     */
    public String getFechaPrestamo() {
        return fechaPrestamo;
    }
    
    /**
     * Establece el valor de fechaPrestamo
     * 
     * @param fechaPrestamo Nuevo valor
     *      * @throws ValidacionException Si el valor es null
     */
    public void setFechaPrestamo(String fechaPrestamo) {
        // Validación básica para strings
        if (fechaPrestamo == null) {
            throw new ValidacionException("El atributo fechaPrestamo no puede ser null");
        }
        
        this.fechaPrestamo = fechaPrestamo;
    }
    
    /**
     * Obtiene el valor de fechaDevolucion
     * 
     * @return El valor de fechaDevolucion
     */
    public String getFechaDevolucion() {
        return fechaDevolucion;
    }
    
    /**
     * Establece el valor de fechaDevolucion
     * 
     * @param fechaDevolucion Nuevo valor
     *      * @throws ValidacionException Si el valor es null
     */
    public void setFechaDevolucion(String fechaDevolucion) {
        // Validación básica para strings
        if (fechaDevolucion == null) {
            throw new ValidacionException("El atributo fechaDevolucion no puede ser null");
        }
        
        this.fechaDevolucion = fechaDevolucion;
    }
    
    
    // Getters y setters para las referencias
    /**
     * Obtiene la referencia a prestamo_usuario (Usuario)
     * @return La entidad Usuario referenciada
     */
    public Usuario getPrestamo_usuario() {
        return prestamo_usuario;
    }
    
    /**
     * Establece la referencia a prestamo_usuario (Usuario)
     * @param prestamo_usuario Nueva entidad referenciada
     */
    public void setPrestamo_usuario(Usuario prestamo_usuario) {
        this.prestamo_usuario = prestamo_usuario;
    }
    
    /**
     * Obtiene la referencia a prestamo_libro (Libro)
     * @return La entidad Libro referenciada
     */
    public Libro getPrestamo_libro() {
        return prestamo_libro;
    }
    
    /**
     * Establece la referencia a prestamo_libro (Libro)
     * @param prestamo_libro Nueva entidad referenciada
     */
    public void setPrestamo_libro(Libro prestamo_libro) {
        this.prestamo_libro = prestamo_libro;
    }
    
    
    /**
     * Valida los datos de la entidad
     * @throws ValidacionException Si algún dato no cumple con las restricciones
     */
    public void validarDatos() throws ValidacionException {
        // Validaciones generales
        if (id_prestamo <= 0) {
            throw new ValidacionException("El identificador id_prestamo debe ser mayor que cero");
        }
        if (fechaPrestamo == null) {
            throw new ValidacionException("El atributo fechaPrestamo no puede ser null");
        }
        if (fechaDevolucion == null) {
            throw new ValidacionException("El atributo fechaDevolucion no puede ser null");
        }
        
        // Validaciones específicas de campos tipo fecha
        if (!fechaPrestamo.isEmpty()) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                dateFormat.setLenient(false);
                dateFormat.parse(fechaPrestamo);
            } catch (ParseException e) {
                throw new ValidacionException("El formato de fechaPrestamo no es válido. Use formato yyyy-MM-dd");
            }
        }
        if (!fechaDevolucion.isEmpty()) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                dateFormat.setLenient(false);
                dateFormat.parse(fechaDevolucion);
            } catch (ParseException e) {
                throw new ValidacionException("El formato de fechaDevolucion no es válido. Use formato yyyy-MM-dd");
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
        
        Prestamo other = (Prestamo) obj;
        
        // Comparación por identificador primario
        return             this.id_prestamo == other.id_prestamo
;
    }
    
    /**
     * Calcula el código hash de esta entidad
     * @return Código hash basado en los atributos de la entidad
     */
    @Override
    public int hashCode() {
        return Objects.hash(id_prestamo);
    }
    
    /**
     * Crea una copia profunda de esta entidad
     * @return Copia de la entidad
     */
    @Override
    public Prestamo clone() {
        try {
            Prestamo clone = (Prestamo) super.clone();
            
            // No es necesario clonar tipos primitivos o String (son inmutables)
            
            // Clonar referencias si es necesario
            if (this.prestamo_usuario != null && this.prestamo_usuario instanceof Cloneable) {
                try {
                    // Intentamos clonar usando el método clone()
                    clone.prestamo_usuario = (Usuario) this.prestamo_usuario.clone();
                } catch (Exception e) {
                    // Si no se puede clonar, asignamos la referencia original
                    clone.prestamo_usuario = this.prestamo_usuario;
                }
            }
            if (this.prestamo_libro != null && this.prestamo_libro instanceof Cloneable) {
                try {
                    // Intentamos clonar usando el método clone()
                    clone.prestamo_libro = (Libro) this.prestamo_libro.clone();
                } catch (Exception e) {
                    // Si no se puede clonar, asignamos la referencia original
                    clone.prestamo_libro = this.prestamo_libro;
                }
            }
            
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Error al clonar Prestamo", e);
        }
    }
    
    /**
     * Genera una representación en texto de la entidad
     * @return Representación textual de la entidad
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Prestamo {");
        
        // Incluimos todos los atributos
        sb.append(" id_prestamo=").append(id_prestamo);
        sb.append(",");
        sb.append(" fechaPrestamo=").append(fechaPrestamo);
        sb.append(",");
        sb.append(" fechaDevolucion=").append(fechaDevolucion);
        
        // Incluimos las referencias, solo mostrando sus IDs
        sb.append(", prestamo_usuario=");
        if (prestamo_usuario != null) {
            sb.append(prestamo_usuario.getId_usuario());
        } else {
            sb.append("null");
        }
        sb.append(", prestamo_libro=");
        if (prestamo_libro != null) {
            sb.append(prestamo_libro.getId_libro());
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
	    sb.append("Prestamo #").append(getId_prestamo());
	    
	    // Añadimos 1-3 atributos representativos
	    sb.append(": ");
	    sb.append(getFechaPrestamo());
	    sb.append(" - ");
	    sb.append(getFechaDevolucion());
	    
	    return sb.toString();
	}
}
