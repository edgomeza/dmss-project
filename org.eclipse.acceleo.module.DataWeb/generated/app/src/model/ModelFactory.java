package model;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Factoría para la creación de instancias de modelos
 * Implementa el patrón Factory para centralizar la creación de objetos
 */
public class ModelFactory {
    private static final Map<String, Object> instances = new HashMap<>();
    private static final Map<String, Supplier<?>> builders = new HashMap<>();
    
    static {
        // Registramos los proveedores para cada tipo de modelo
        builders.put(Cliente.class.getName(), Cliente::new);
        builders.put(Cuenta.class.getName(), Cuenta::new);
        builders.put(Transaccion.class.getName(), Transaccion::new);
        builders.put(Empleado.class.getName(), Empleado::new);
        builders.put(Prestamo.class.getName(), Prestamo::new);
        builders.put(TarjetaCredito.class.getName(), TarjetaCredito::new);
    }
    
    /**
     * Obtiene una instancia del modelo especificado
     * Si no existe, la crea y almacena
     * @param <T> Tipo de modelo
     * @param modelClass Clase del modelo
     * @return Instancia del modelo
     * @throws RuntimeException si no se puede crear la instancia
     */
    @SuppressWarnings("unchecked")
    public static <T> T getModel(Class<T> modelClass) {
        String className = modelClass.getName();
        if (!instances.containsKey(className)) {
            try {
                // Verificar si tenemos un builder registrado
                if (builders.containsKey(className)) {
                    instances.put(className, builders.get(className).get());
                } else {
                    // Fallback a la creación por reflexión
                    instances.put(className, modelClass.getDeclaredConstructor().newInstance());
                }
            } catch (Exception e) {
                throw new RuntimeException("Error al crear instancia de " + className, e);
            }
        }
        return (T) instances.get(className);
    }
    
    /**
     * Crea una nueva instancia del modelo sin almacenarla
     * @param <T> Tipo de modelo
     * @param modelClass Clase del modelo
     * @return Nueva instancia del modelo
     * @throws RuntimeException si no se puede crear la instancia
     */
    @SuppressWarnings("unchecked")
    public static <T> T createModel(Class<T> modelClass) {
        String className = modelClass.getName();
        try {
            // Verificar si tenemos un builder registrado
            if (builders.containsKey(className)) {
                return (T) builders.get(className).get();
            } else {
                // Fallback a la creación por reflexión
                return modelClass.getDeclaredConstructor().newInstance();
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al crear instancia de " + className, e);
        }
    }
    
    /**
     * Registra un proveedor personalizado para un tipo de modelo
     * @param <T> Tipo de modelo
     * @param modelClass Clase del modelo
     * @param builder Proveedor de instancias
     */
    public static <T> void registerBuilder(Class<T> modelClass, Supplier<T> builder) {
        builders.put(modelClass.getName(), builder);
    }
    
    /**
     * Elimina una instancia almacenada
     * @param <T> Tipo de modelo
     * @param modelClass Clase del modelo
     */
    public static <T> void removeModel(Class<T> modelClass) {
        instances.remove(modelClass.getName());
    }
    
    /**
     * Limpia todas las instancias almacenadas
     */
    public static void clearModels() {
        instances.clear();
    }
}
