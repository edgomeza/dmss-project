package model;

/**
 * Excepción personalizada para errores de validación en los modelos
 */
public class ValidacionException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    
    public ValidacionException(String mensaje) {
        super(mensaje);
    }
    
    public ValidacionException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
