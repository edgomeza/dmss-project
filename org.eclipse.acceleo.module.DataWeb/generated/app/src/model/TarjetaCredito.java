package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 * Clase modelo para la entidad TarjetaCredito
 * Representa TARJETAS_CREDITO en la base de datos
 */
public class TarjetaCredito implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    
    // Atributos
    private String numero_tarjeta;
    private double limite_credito;
    private double saldo_actual;
    private String fecha_vencimiento;
    private boolean activa;
    
    // Referencias a otras entidades
    private Cliente cliente_propietario;
    
    /**
     * Constructor por defecto
     * Inicializa los valores por defecto para todos los campos
     */
    public TarjetaCredito() {
        // Inicialización de valores por defecto
        this.numero_tarjeta = "";
        this.limite_credito = 0.0;
        this.saldo_actual = 0.0;
        this.fecha_vencimiento = "";
        this.activa = false;
    }
    
    /**
     * Constructor con todos los atributos (sin referencias)
     */
    public TarjetaCredito(String numero_tarjeta, double limite_credito, double saldo_actual, String fecha_vencimiento, boolean activa) {
        this.numero_tarjeta = numero_tarjeta;
        this.limite_credito = limite_credito;
        this.saldo_actual = saldo_actual;
        this.fecha_vencimiento = fecha_vencimiento;
        this.activa = activa;
        
        // Validamos los datos
        validarDatos();
    }
    
    // Getters y setters
    /**
     * Obtiene el valor de numero_tarjeta
     * Este es el identificador principal de la entidad
     * @return El valor de numero_tarjeta
     */
    public String getNumero_tarjeta() {
        return numero_tarjeta;
    }
    
    /**
     * Establece el valor de numero_tarjeta
     * Este es el identificador principal de la entidad
     * @param numero_tarjeta Nuevo valor
     *      * @throws ValidacionException Si el valor es null o vacío
     */
    public void setNumero_tarjeta(String numero_tarjeta) {
        // Validación básica para strings
        if (numero_tarjeta == null) {
            throw new ValidacionException("El atributo numero_tarjeta no puede ser null");
        }
        if (numero_tarjeta.trim().isEmpty()) {
            throw new ValidacionException("El identificador numero_tarjeta no puede estar vacío");
        }
        
        this.numero_tarjeta = numero_tarjeta;
    }
    
    /**
     * Obtiene el valor de limite_credito
     * 
     * @return El valor de limite_credito
     */
    public double getLimite_credito() {
        return limite_credito;
    }
    
    /**
     * Establece el valor de limite_credito
     * 
     * @param limite_credito Nuevo valor
     *      */
    public void setLimite_credito(double limite_credito) {
        
        this.limite_credito = limite_credito;
    }
    
    /**
     * Obtiene el valor de saldo_actual
     * 
     * @return El valor de saldo_actual
     */
    public double getSaldo_actual() {
        return saldo_actual;
    }
    
    /**
     * Establece el valor de saldo_actual
     * 
     * @param saldo_actual Nuevo valor
     *      */
    public void setSaldo_actual(double saldo_actual) {
        
        this.saldo_actual = saldo_actual;
    }
    
    /**
     * Obtiene el valor de fecha_vencimiento
     * 
     * @return El valor de fecha_vencimiento
     */
    public String getFecha_vencimiento() {
        return fecha_vencimiento;
    }
    
    /**
     * Establece el valor de fecha_vencimiento
     * 
     * @param fecha_vencimiento Nuevo valor
     *      * @throws ValidacionException Si el valor es null
     */
    public void setFecha_vencimiento(String fecha_vencimiento) {
        // Validación básica para strings
        if (fecha_vencimiento == null) {
            throw new ValidacionException("El atributo fecha_vencimiento no puede ser null");
        }
        
        this.fecha_vencimiento = fecha_vencimiento;
    }
    
    /**
     * Obtiene el valor de activa
     * 
     * @return El valor de activa
     */
    public boolean getActiva() {
        return activa;
    }
    
    /**
     * Establece el valor de activa
     * 
     * @param activa Nuevo valor
     *      */
    public void setActiva(boolean activa) {
        
        this.activa = activa;
    }
    
    
    // Getters y setters para las referencias
    /**
     * Obtiene la referencia a cliente_propietario (Cliente)
     * @return La entidad Cliente referenciada
     */
    public Cliente getCliente_propietario() {
        return cliente_propietario;
    }
    
    /**
     * Establece la referencia a cliente_propietario (Cliente)
     * @param cliente_propietario Nueva entidad referenciada
     */
    public void setCliente_propietario(Cliente cliente_propietario) {
        this.cliente_propietario = cliente_propietario;
    }
    
    
    /**
     * Valida los datos de la entidad
     * @throws ValidacionException Si algún dato no cumple con las restricciones
     */
    public void validarDatos() throws ValidacionException {
        // Validaciones generales
        if (numero_tarjeta == null) {
            throw new ValidacionException("El atributo numero_tarjeta no puede ser null");
        }
        if (numero_tarjeta.trim().isEmpty()) {
            throw new ValidacionException("El identificador numero_tarjeta no puede estar vacío");
        }
        if (fecha_vencimiento == null) {
            throw new ValidacionException("El atributo fecha_vencimiento no puede ser null");
        }
        
        // Validaciones específicas de campos tipo fecha
        if (!fecha_vencimiento.isEmpty()) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                dateFormat.setLenient(false);
                dateFormat.parse(fecha_vencimiento);
            } catch (ParseException e) {
                throw new ValidacionException("El formato de fecha_vencimiento no es válido. Use formato yyyy-MM-dd");
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
        
        TarjetaCredito other = (TarjetaCredito) obj;
        
        // Comparación por identificador primario
        return             Objects.equals(this.numero_tarjeta, other.numero_tarjeta)
;
    }
    
    /**
     * Calcula el código hash de esta entidad
     * @return Código hash basado en los atributos de la entidad
     */
    @Override
    public int hashCode() {
        return Objects.hash(numero_tarjeta);
    }
    
    /**
     * Crea una copia profunda de esta entidad
     * @return Copia de la entidad
     */
    @Override
    public TarjetaCredito clone() {
        try {
            TarjetaCredito clone = (TarjetaCredito) super.clone();
            
            // No es necesario clonar tipos primitivos o String (son inmutables)
            
            // Clonar referencias si es necesario
            if (this.cliente_propietario != null && this.cliente_propietario instanceof Cloneable) {
                try {
                    // Intentamos clonar usando el método clone()
                    clone.cliente_propietario = (Cliente) this.cliente_propietario.clone();
                } catch (Exception e) {
                    // Si no se puede clonar, asignamos la referencia original
                    clone.cliente_propietario = this.cliente_propietario;
                }
            }
            
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Error al clonar TarjetaCredito", e);
        }
    }
    
    /**
     * Genera una representación en texto de la entidad
     * @return Representación textual de la entidad
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TarjetaCredito {");
        
        // Incluimos todos los atributos
        sb.append(" numero_tarjeta=").append(numero_tarjeta);
        sb.append(",");
        sb.append(" limite_credito=").append(limite_credito);
        sb.append(",");
        sb.append(" saldo_actual=").append(saldo_actual);
        sb.append(",");
        sb.append(" fecha_vencimiento=").append(fecha_vencimiento);
        sb.append(",");
        sb.append(" activa=").append(activa);
        
        // Incluimos las referencias, solo mostrando sus IDs
        sb.append(", cliente_propietario=");
        if (cliente_propietario != null) {
            sb.append(cliente_propietario.getId_cliente());
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
	    sb.append("TarjetaCredito #").append(getNumero_tarjeta());
	    
	    // Añadimos 1-3 atributos representativos
	    sb.append(": ");
	    sb.append(getFecha_vencimiento());
	    
	    return sb.toString();
	}
}
