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
    private double monto_solicitado;
    private double tasa_interes;
    private Integer plazo_meses;
    private String estado_prestamo;
    private String fecha_solicitud;
    private String fecha_aprobacion;
    
    // Referencias a otras entidades
    private Cliente cliente_solicitante;
    private Empleado empleado_aprobador;
    
    /**
     * Constructor por defecto
     * Inicializa los valores por defecto para todos los campos
     */
    public Prestamo() {
        // Inicialización de valores por defecto
        this.id_prestamo = 0;
        this.monto_solicitado = 0.0;
        this.tasa_interes = 0.0;
        this.plazo_meses = 0;
        this.estado_prestamo = "";
        this.fecha_solicitud = "";
        this.fecha_aprobacion = "";
    }
    
    /**
     * Constructor con todos los atributos (sin referencias)
     */
    public Prestamo(Integer id_prestamo, double monto_solicitado, double tasa_interes, Integer plazo_meses, String estado_prestamo, String fecha_solicitud, String fecha_aprobacion) {
        this.id_prestamo = id_prestamo;
        this.monto_solicitado = monto_solicitado;
        this.tasa_interes = tasa_interes;
        this.plazo_meses = plazo_meses;
        this.estado_prestamo = estado_prestamo;
        this.fecha_solicitud = fecha_solicitud;
        this.fecha_aprobacion = fecha_aprobacion;
        
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
     * Obtiene el valor de monto_solicitado
     * 
     * @return El valor de monto_solicitado
     */
    public double getMonto_solicitado() {
        return monto_solicitado;
    }
    
    /**
     * Establece el valor de monto_solicitado
     * 
     * @param monto_solicitado Nuevo valor
     *      */
    public void setMonto_solicitado(double monto_solicitado) {
        
        this.monto_solicitado = monto_solicitado;
    }
    
    /**
     * Obtiene el valor de tasa_interes
     * 
     * @return El valor de tasa_interes
     */
    public double getTasa_interes() {
        return tasa_interes;
    }
    
    /**
     * Establece el valor de tasa_interes
     * 
     * @param tasa_interes Nuevo valor
     *      */
    public void setTasa_interes(double tasa_interes) {
        
        this.tasa_interes = tasa_interes;
    }
    
    /**
     * Obtiene el valor de plazo_meses
     * 
     * @return El valor de plazo_meses
     */
    public Integer getPlazo_meses() {
        return plazo_meses;
    }
    
    /**
     * Establece el valor de plazo_meses
     * 
     * @param plazo_meses Nuevo valor
     *      */
    public void setPlazo_meses(Integer plazo_meses) {
        
        this.plazo_meses = plazo_meses;
    }
    
    /**
     * Obtiene el valor de estado_prestamo
     * 
     * @return El valor de estado_prestamo
     */
    public String getEstado_prestamo() {
        return estado_prestamo;
    }
    
    /**
     * Establece el valor de estado_prestamo
     * 
     * @param estado_prestamo Nuevo valor
     *      * @throws ValidacionException Si el valor es null
     */
    public void setEstado_prestamo(String estado_prestamo) {
        // Validación básica para strings
        if (estado_prestamo == null) {
            throw new ValidacionException("El atributo estado_prestamo no puede ser null");
        }
        
        this.estado_prestamo = estado_prestamo;
    }
    
    /**
     * Obtiene el valor de fecha_solicitud
     * 
     * @return El valor de fecha_solicitud
     */
    public String getFecha_solicitud() {
        return fecha_solicitud;
    }
    
    /**
     * Establece el valor de fecha_solicitud
     * 
     * @param fecha_solicitud Nuevo valor
     *      * @throws ValidacionException Si el valor es null
     */
    public void setFecha_solicitud(String fecha_solicitud) {
        // Validación básica para strings
        if (fecha_solicitud == null) {
            throw new ValidacionException("El atributo fecha_solicitud no puede ser null");
        }
        
        this.fecha_solicitud = fecha_solicitud;
    }
    
    /**
     * Obtiene el valor de fecha_aprobacion
     * 
     * @return El valor de fecha_aprobacion
     */
    public String getFecha_aprobacion() {
        return fecha_aprobacion;
    }
    
    /**
     * Establece el valor de fecha_aprobacion
     * 
     * @param fecha_aprobacion Nuevo valor
     *      * @throws ValidacionException Si el valor es null
     */
    public void setFecha_aprobacion(String fecha_aprobacion) {
        // Validación básica para strings
        if (fecha_aprobacion == null) {
            throw new ValidacionException("El atributo fecha_aprobacion no puede ser null");
        }
        
        this.fecha_aprobacion = fecha_aprobacion;
    }
    
    
    // Getters y setters para las referencias
    /**
     * Obtiene la referencia a cliente_solicitante (Cliente)
     * @return La entidad Cliente referenciada
     */
    public Cliente getCliente_solicitante() {
        return cliente_solicitante;
    }
    
    /**
     * Establece la referencia a cliente_solicitante (Cliente)
     * @param cliente_solicitante Nueva entidad referenciada
     */
    public void setCliente_solicitante(Cliente cliente_solicitante) {
        this.cliente_solicitante = cliente_solicitante;
    }
    
    /**
     * Obtiene la referencia a empleado_aprobador (Empleado)
     * @return La entidad Empleado referenciada
     */
    public Empleado getEmpleado_aprobador() {
        return empleado_aprobador;
    }
    
    /**
     * Establece la referencia a empleado_aprobador (Empleado)
     * @param empleado_aprobador Nueva entidad referenciada
     */
    public void setEmpleado_aprobador(Empleado empleado_aprobador) {
        this.empleado_aprobador = empleado_aprobador;
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
        if (monto_solicitado < 0) {
            throw new ValidacionException("El valor de monto_solicitado no puede ser negativo");
        }
        if (estado_prestamo == null) {
            throw new ValidacionException("El atributo estado_prestamo no puede ser null");
        }
        if (fecha_solicitud == null) {
            throw new ValidacionException("El atributo fecha_solicitud no puede ser null");
        }
        if (fecha_aprobacion == null) {
            throw new ValidacionException("El atributo fecha_aprobacion no puede ser null");
        }
        
        // Validaciones específicas de campos tipo fecha
        if (!fecha_solicitud.isEmpty()) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                dateFormat.setLenient(false);
                dateFormat.parse(fecha_solicitud);
            } catch (ParseException e) {
                throw new ValidacionException("El formato de fecha_solicitud no es válido. Use formato yyyy-MM-dd");
            }
        }
        if (!fecha_aprobacion.isEmpty()) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                dateFormat.setLenient(false);
                dateFormat.parse(fecha_aprobacion);
            } catch (ParseException e) {
                throw new ValidacionException("El formato de fecha_aprobacion no es válido. Use formato yyyy-MM-dd");
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
            if (this.cliente_solicitante != null && this.cliente_solicitante instanceof Cloneable) {
                try {
                    // Intentamos clonar usando el método clone()
                    clone.cliente_solicitante = (Cliente) this.cliente_solicitante.clone();
                } catch (Exception e) {
                    // Si no se puede clonar, asignamos la referencia original
                    clone.cliente_solicitante = this.cliente_solicitante;
                }
            }
            if (this.empleado_aprobador != null && this.empleado_aprobador instanceof Cloneable) {
                try {
                    // Intentamos clonar usando el método clone()
                    clone.empleado_aprobador = (Empleado) this.empleado_aprobador.clone();
                } catch (Exception e) {
                    // Si no se puede clonar, asignamos la referencia original
                    clone.empleado_aprobador = this.empleado_aprobador;
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
        sb.append(" monto_solicitado=").append(monto_solicitado);
        sb.append(",");
        sb.append(" tasa_interes=").append(tasa_interes);
        sb.append(",");
        sb.append(" plazo_meses=").append(plazo_meses);
        sb.append(",");
        sb.append(" estado_prestamo=").append(estado_prestamo);
        sb.append(",");
        sb.append(" fecha_solicitud=").append(fecha_solicitud);
        sb.append(",");
        sb.append(" fecha_aprobacion=").append(fecha_aprobacion);
        
        // Incluimos las referencias, solo mostrando sus IDs
        sb.append(", cliente_solicitante=");
        if (cliente_solicitante != null) {
            sb.append(cliente_solicitante.getId_cliente());
        } else {
            sb.append("null");
        }
        sb.append(", empleado_aprobador=");
        if (empleado_aprobador != null) {
            sb.append(empleado_aprobador.getId_empleado());
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
	    sb.append(getEstado_prestamo());
	    sb.append(" - ");
	    sb.append(getFecha_solicitud());
	    sb.append(" - ");
	    sb.append(getFecha_aprobacion());
	    
	    return sb.toString();
	}
}
