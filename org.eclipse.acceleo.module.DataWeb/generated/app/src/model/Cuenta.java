package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 * Clase modelo para la entidad Cuenta
 * Representa CUENTAS en la base de datos
 */
public class Cuenta implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    
    // Atributos
    private String numero_cuenta;
    private String tipo_cuenta;
    private double saldo;
    private String fecha_apertura;
    private boolean activa;
    
    // Referencias a otras entidades
    private Cliente cliente_titular;
    
    /**
     * Constructor por defecto
     * Inicializa los valores por defecto para todos los campos
     */
    public Cuenta() {
        // Inicialización de valores por defecto
        this.numero_cuenta = "";
        this.tipo_cuenta = "";
        this.saldo = 0.0;
        this.fecha_apertura = "";
        this.activa = false;
    }
    
    /**
     * Constructor con todos los atributos (sin referencias)
     */
    public Cuenta(String numero_cuenta, String tipo_cuenta, double saldo, String fecha_apertura, boolean activa) {
        this.numero_cuenta = numero_cuenta;
        this.tipo_cuenta = tipo_cuenta;
        this.saldo = saldo;
        this.fecha_apertura = fecha_apertura;
        this.activa = activa;
        
        // Validamos los datos
        validarDatos();
    }
    
    // Getters y setters
    /**
     * Obtiene el valor de numero_cuenta
     * Este es el identificador principal de la entidad
     * @return El valor de numero_cuenta
     */
    public String getNumero_cuenta() {
        return numero_cuenta;
    }
    
    /**
     * Establece el valor de numero_cuenta
     * Este es el identificador principal de la entidad
     * @param numero_cuenta Nuevo valor
     *      * @throws ValidacionException Si el valor es null o vacío
     */
    public void setNumero_cuenta(String numero_cuenta) {
        // Validación básica para strings
        if (numero_cuenta == null) {
            throw new ValidacionException("El atributo numero_cuenta no puede ser null");
        }
        if (numero_cuenta.trim().isEmpty()) {
            throw new ValidacionException("El identificador numero_cuenta no puede estar vacío");
        }
        
        this.numero_cuenta = numero_cuenta;
    }
    
    /**
     * Obtiene el valor de tipo_cuenta
     * 
     * @return El valor de tipo_cuenta
     */
    public String getTipo_cuenta() {
        return tipo_cuenta;
    }
    
    /**
     * Establece el valor de tipo_cuenta
     * 
     * @param tipo_cuenta Nuevo valor
     *      * @throws ValidacionException Si el valor es null
     */
    public void setTipo_cuenta(String tipo_cuenta) {
        // Validación básica para strings
        if (tipo_cuenta == null) {
            throw new ValidacionException("El atributo tipo_cuenta no puede ser null");
        }
        
        this.tipo_cuenta = tipo_cuenta;
    }
    
    /**
     * Obtiene el valor de saldo
     * 
     * @return El valor de saldo
     */
    public double getSaldo() {
        return saldo;
    }
    
    /**
     * Establece el valor de saldo
     * 
     * @param saldo Nuevo valor
     *      */
    public void setSaldo(double saldo) {
        
        this.saldo = saldo;
    }
    
    /**
     * Obtiene el valor de fecha_apertura
     * 
     * @return El valor de fecha_apertura
     */
    public String getFecha_apertura() {
        return fecha_apertura;
    }
    
    /**
     * Establece el valor de fecha_apertura
     * 
     * @param fecha_apertura Nuevo valor
     *      * @throws ValidacionException Si el valor es null
     */
    public void setFecha_apertura(String fecha_apertura) {
        // Validación básica para strings
        if (fecha_apertura == null) {
            throw new ValidacionException("El atributo fecha_apertura no puede ser null");
        }
        
        this.fecha_apertura = fecha_apertura;
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
     * Obtiene la referencia a cliente_titular (Cliente)
     * @return La entidad Cliente referenciada
     */
    public Cliente getCliente_titular() {
        return cliente_titular;
    }
    
    /**
     * Establece la referencia a cliente_titular (Cliente)
     * @param cliente_titular Nueva entidad referenciada
     */
    public void setCliente_titular(Cliente cliente_titular) {
        this.cliente_titular = cliente_titular;
    }
    
    
    /**
     * Valida los datos de la entidad
     * @throws ValidacionException Si algún dato no cumple con las restricciones
     */
    public void validarDatos() throws ValidacionException {
        // Validaciones generales
        if (numero_cuenta == null) {
            throw new ValidacionException("El atributo numero_cuenta no puede ser null");
        }
        if (numero_cuenta.trim().isEmpty()) {
            throw new ValidacionException("El identificador numero_cuenta no puede estar vacío");
        }
        if (tipo_cuenta == null) {
            throw new ValidacionException("El atributo tipo_cuenta no puede ser null");
        }
        if (fecha_apertura == null) {
            throw new ValidacionException("El atributo fecha_apertura no puede ser null");
        }
        
        // Validaciones específicas de campos tipo fecha
        if (!fecha_apertura.isEmpty()) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                dateFormat.setLenient(false);
                dateFormat.parse(fecha_apertura);
            } catch (ParseException e) {
                throw new ValidacionException("El formato de fecha_apertura no es válido. Use formato yyyy-MM-dd");
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
        
        Cuenta other = (Cuenta) obj;
        
        // Comparación por identificador primario
        return             Objects.equals(this.numero_cuenta, other.numero_cuenta)
;
    }
    
    /**
     * Calcula el código hash de esta entidad
     * @return Código hash basado en los atributos de la entidad
     */
    @Override
    public int hashCode() {
        return Objects.hash(numero_cuenta);
    }
    
    /**
     * Crea una copia profunda de esta entidad
     * @return Copia de la entidad
     */
    @Override
    public Cuenta clone() {
        try {
            Cuenta clone = (Cuenta) super.clone();
            
            // No es necesario clonar tipos primitivos o String (son inmutables)
            
            // Clonar referencias si es necesario
            if (this.cliente_titular != null && this.cliente_titular instanceof Cloneable) {
                try {
                    // Intentamos clonar usando el método clone()
                    clone.cliente_titular = (Cliente) this.cliente_titular.clone();
                } catch (Exception e) {
                    // Si no se puede clonar, asignamos la referencia original
                    clone.cliente_titular = this.cliente_titular;
                }
            }
            
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Error al clonar Cuenta", e);
        }
    }
    
    /**
     * Genera una representación en texto de la entidad
     * @return Representación textual de la entidad
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cuenta {");
        
        // Incluimos todos los atributos
        sb.append(" numero_cuenta=").append(numero_cuenta);
        sb.append(",");
        sb.append(" tipo_cuenta=").append(tipo_cuenta);
        sb.append(",");
        sb.append(" saldo=").append(saldo);
        sb.append(",");
        sb.append(" fecha_apertura=").append(fecha_apertura);
        sb.append(",");
        sb.append(" activa=").append(activa);
        
        // Incluimos las referencias, solo mostrando sus IDs
        sb.append(", cliente_titular=");
        if (cliente_titular != null) {
            sb.append(cliente_titular.getId_cliente());
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
	    sb.append("Cuenta #").append(getNumero_cuenta());
	    
	    // Añadimos 1-3 atributos representativos
	    sb.append(": ");
	    sb.append(getTipo_cuenta());
	    sb.append(" - ");
	    sb.append(getFecha_apertura());
	    
	    return sb.toString();
	}
}
