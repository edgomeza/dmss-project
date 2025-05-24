package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 * Clase modelo para la entidad Transaccion
 * Representa TRANSACCIONES en la base de datos
 */
public class Transaccion implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    
    // Atributos
    private Integer id_transaccion;
    private String fecha_transaccion;
    private String tipo_transaccion;
    private double monto;
    private String descripcion;
    private String estado;
    
    // Referencias a otras entidades
    private Cuenta cuenta_origen;
    private Cuenta cuenta_destino;
    
    /**
     * Constructor por defecto
     * Inicializa los valores por defecto para todos los campos
     */
    public Transaccion() {
        // Inicialización de valores por defecto
        this.id_transaccion = 0;
        this.fecha_transaccion = "";
        this.tipo_transaccion = "";
        this.monto = 0.0;
        this.descripcion = "";
        this.estado = "";
    }
    
    /**
     * Constructor con todos los atributos (sin referencias)
     */
    public Transaccion(Integer id_transaccion, String fecha_transaccion, String tipo_transaccion, double monto, String descripcion, String estado) {
        this.id_transaccion = id_transaccion;
        this.fecha_transaccion = fecha_transaccion;
        this.tipo_transaccion = tipo_transaccion;
        this.monto = monto;
        this.descripcion = descripcion;
        this.estado = estado;
        
        // Validamos los datos
        validarDatos();
    }
    
    // Getters y setters
    /**
     * Obtiene el valor de id_transaccion
     * Este es el identificador principal de la entidad
     * @return El valor de id_transaccion
     */
    public Integer getId_transaccion() {
        return id_transaccion;
    }
    
    /**
     * Establece el valor de id_transaccion
     * Este es el identificador principal de la entidad
     * @param id_transaccion Nuevo valor
     *      */
    public void setId_transaccion(Integer id_transaccion) {
        
        this.id_transaccion = id_transaccion;
    }
    
    /**
     * Obtiene el valor de fecha_transaccion
     * 
     * @return El valor de fecha_transaccion
     */
    public String getFecha_transaccion() {
        return fecha_transaccion;
    }
    
    /**
     * Establece el valor de fecha_transaccion
     * 
     * @param fecha_transaccion Nuevo valor
     *      * @throws ValidacionException Si el valor es null
     */
    public void setFecha_transaccion(String fecha_transaccion) {
        // Validación básica para strings
        if (fecha_transaccion == null) {
            throw new ValidacionException("El atributo fecha_transaccion no puede ser null");
        }
        
        this.fecha_transaccion = fecha_transaccion;
    }
    
    /**
     * Obtiene el valor de tipo_transaccion
     * 
     * @return El valor de tipo_transaccion
     */
    public String getTipo_transaccion() {
        return tipo_transaccion;
    }
    
    /**
     * Establece el valor de tipo_transaccion
     * 
     * @param tipo_transaccion Nuevo valor
     *      * @throws ValidacionException Si el valor es null
     */
    public void setTipo_transaccion(String tipo_transaccion) {
        // Validación básica para strings
        if (tipo_transaccion == null) {
            throw new ValidacionException("El atributo tipo_transaccion no puede ser null");
        }
        
        this.tipo_transaccion = tipo_transaccion;
    }
    
    /**
     * Obtiene el valor de monto
     * 
     * @return El valor de monto
     */
    public double getMonto() {
        return monto;
    }
    
    /**
     * Establece el valor de monto
     * 
     * @param monto Nuevo valor
     *      */
    public void setMonto(double monto) {
        
        this.monto = monto;
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
    
    /**
     * Obtiene el valor de estado
     * 
     * @return El valor de estado
     */
    public String getEstado() {
        return estado;
    }
    
    /**
     * Establece el valor de estado
     * 
     * @param estado Nuevo valor
     *      * @throws ValidacionException Si el valor es null
     */
    public void setEstado(String estado) {
        // Validación básica para strings
        if (estado == null) {
            throw new ValidacionException("El atributo estado no puede ser null");
        }
        
        this.estado = estado;
    }
    
    
    // Getters y setters para las referencias
    /**
     * Obtiene la referencia a cuenta_origen (Cuenta)
     * @return La entidad Cuenta referenciada
     */
    public Cuenta getCuenta_origen() {
        return cuenta_origen;
    }
    
    /**
     * Establece la referencia a cuenta_origen (Cuenta)
     * @param cuenta_origen Nueva entidad referenciada
     */
    public void setCuenta_origen(Cuenta cuenta_origen) {
        this.cuenta_origen = cuenta_origen;
    }
    
    /**
     * Obtiene la referencia a cuenta_destino (Cuenta)
     * @return La entidad Cuenta referenciada
     */
    public Cuenta getCuenta_destino() {
        return cuenta_destino;
    }
    
    /**
     * Establece la referencia a cuenta_destino (Cuenta)
     * @param cuenta_destino Nueva entidad referenciada
     */
    public void setCuenta_destino(Cuenta cuenta_destino) {
        this.cuenta_destino = cuenta_destino;
    }
    
    
    /**
     * Valida los datos de la entidad
     * @throws ValidacionException Si algún dato no cumple con las restricciones
     */
    public void validarDatos() throws ValidacionException {
        // Validaciones generales
        if (id_transaccion <= 0) {
            throw new ValidacionException("El identificador id_transaccion debe ser mayor que cero");
        }
        if (fecha_transaccion == null) {
            throw new ValidacionException("El atributo fecha_transaccion no puede ser null");
        }
        if (tipo_transaccion == null) {
            throw new ValidacionException("El atributo tipo_transaccion no puede ser null");
        }
        if (monto < 0) {
            throw new ValidacionException("El valor de monto no puede ser negativo");
        }
        if (descripcion == null) {
            throw new ValidacionException("El atributo descripcion no puede ser null");
        }
        if (estado == null) {
            throw new ValidacionException("El atributo estado no puede ser null");
        }
        
        // Validaciones específicas de campos tipo fecha
        if (!fecha_transaccion.isEmpty()) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                dateFormat.setLenient(false);
                dateFormat.parse(fecha_transaccion);
            } catch (ParseException e) {
                throw new ValidacionException("El formato de fecha_transaccion no es válido. Use formato yyyy-MM-dd");
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
        
        Transaccion other = (Transaccion) obj;
        
        // Comparación por identificador primario
        return             this.id_transaccion == other.id_transaccion
;
    }
    
    /**
     * Calcula el código hash de esta entidad
     * @return Código hash basado en los atributos de la entidad
     */
    @Override
    public int hashCode() {
        return Objects.hash(id_transaccion);
    }
    
    /**
     * Crea una copia profunda de esta entidad
     * @return Copia de la entidad
     */
    @Override
    public Transaccion clone() {
        try {
            Transaccion clone = (Transaccion) super.clone();
            
            // No es necesario clonar tipos primitivos o String (son inmutables)
            
            // Clonar referencias si es necesario
            if (this.cuenta_origen != null && this.cuenta_origen instanceof Cloneable) {
                try {
                    // Intentamos clonar usando el método clone()
                    clone.cuenta_origen = (Cuenta) this.cuenta_origen.clone();
                } catch (Exception e) {
                    // Si no se puede clonar, asignamos la referencia original
                    clone.cuenta_origen = this.cuenta_origen;
                }
            }
            if (this.cuenta_destino != null && this.cuenta_destino instanceof Cloneable) {
                try {
                    // Intentamos clonar usando el método clone()
                    clone.cuenta_destino = (Cuenta) this.cuenta_destino.clone();
                } catch (Exception e) {
                    // Si no se puede clonar, asignamos la referencia original
                    clone.cuenta_destino = this.cuenta_destino;
                }
            }
            
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Error al clonar Transaccion", e);
        }
    }
    
    /**
     * Genera una representación en texto de la entidad
     * @return Representación textual de la entidad
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Transaccion {");
        
        // Incluimos todos los atributos
        sb.append(" id_transaccion=").append(id_transaccion);
        sb.append(",");
        sb.append(" fecha_transaccion=").append(fecha_transaccion);
        sb.append(",");
        sb.append(" tipo_transaccion=").append(tipo_transaccion);
        sb.append(",");
        sb.append(" monto=").append(monto);
        sb.append(",");
        sb.append(" descripcion=").append(descripcion);
        sb.append(",");
        sb.append(" estado=").append(estado);
        
        // Incluimos las referencias, solo mostrando sus IDs
        sb.append(", cuenta_origen=");
        if (cuenta_origen != null) {
            sb.append(cuenta_origen.getNumero_cuenta());
        } else {
            sb.append("null");
        }
        sb.append(", cuenta_destino=");
        if (cuenta_destino != null) {
            sb.append(cuenta_destino.getNumero_cuenta());
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
	    sb.append("Transaccion #").append(getId_transaccion());
	    
	    // Añadimos 1-3 atributos representativos
	    sb.append(": ");
	    sb.append(getFecha_transaccion());
	    sb.append(" - ");
	    sb.append(getTipo_transaccion());
	    sb.append(" - ");
	    sb.append(getDescripcion());
	    
	    return sb.toString();
	}
}
