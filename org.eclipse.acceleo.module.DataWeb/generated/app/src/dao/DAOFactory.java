package dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Collection;
import model.Cliente;
import model.Cuenta;
import model.Transaccion;
import model.Empleado;
import model.Prestamo;
import model.TarjetaCredito;

/**
 * Factoría para la creación y obtención de DAOs
 * Implementa el patrón Factory y Singleton
 */
public class DAOFactory {
    private static Map<Class<?>, IDAO<?, ?>> daoMap = new HashMap<>();
    private static boolean initialized = false;
    private static boolean initializing = false;
    
    /**
     * Inicializa todos los DAOs del sistema
     */
    public static synchronized void initialize() {
        if (!initialized && !initializing) {
            initializing = true;
            System.out.println("Inicializando DAOFactory...");
            
            // Primero registramos todos los DAOs
            daoMap.put(Cliente.class, ClienteDAO.getInstance());
            daoMap.put(Cuenta.class, CuentaDAO.getInstance());
            daoMap.put(Transaccion.class, TransaccionDAO.getInstance());
            daoMap.put(Empleado.class, EmpleadoDAO.getInstance());
            daoMap.put(Prestamo.class, PrestamoDAO.getInstance());
            daoMap.put(TarjetaCredito.class, TarjetaCreditoDAO.getInstance());
            
            // Marcamos como inicializado antes de configurar relaciones
            initialized = true;
            
            // Después configuramos las relaciones entre entidades
            ((CuentaDAO) daoMap.get(Cuenta.class)).setupRelationships();
            ((TransaccionDAO) daoMap.get(Transaccion.class)).setupRelationships();
            ((PrestamoDAO) daoMap.get(Prestamo.class)).setupRelationships();
            ((TarjetaCreditoDAO) daoMap.get(TarjetaCredito.class)).setupRelationships();
            
            initializing = false;
            System.out.println("DAOFactory inicializado correctamente");
        }
    }
    
    /**
     * Obtiene el DAO para una clase de entidad específica
     * @param <T> Tipo de entidad
     * @param entityClass Clase de la entidad
     * @return DAO correspondiente a la entidad
     */
    @SuppressWarnings("unchecked")
    public static <T> IDAO<T, ?> getDAO(Class<T> entityClass) {
        if (!initialized && !initializing) {
            initialize();
        }
        
        IDAO<?, ?> dao = daoMap.get(entityClass);
        if (dao == null) {
            throw new IllegalArgumentException("No se ha encontrado un DAO para la clase " + entityClass.getName());
        }
        
        return (IDAO<T, ?>) dao;
    }
    
    /**
     * Obtiene todos los DAOs registrados
     * @return Colección con todos los DAOs
     */
    public static Collection<IDAO<?, ?>> getAllDAOs() {
        if (!initialized && !initializing) {
            initialize();
        }
        
        return daoMap.values();
    }
    
    /**
     * Obtiene directamente un DAO sin verificar inicialización (para uso interno)
     * @param <T> Tipo de entidad
     * @param entityClass Clase de la entidad
     * @return DAO correspondiente a la entidad
     */
    @SuppressWarnings("unchecked")
    static <T> IDAO<T, ?> getDAODirect(Class<T> entityClass) {
        IDAO<?, ?> dao = daoMap.get(entityClass);
        if (dao == null) {
            throw new IllegalArgumentException("No se ha encontrado un DAO para la clase " + entityClass.getName());
        }
        
        return (IDAO<T, ?>) dao;
    }
    
    /**
     * Reinicia todos los DAOs
     * Útil para pruebas y simulaciones
     */
    public static synchronized void reset() {
        System.out.println("Reiniciando DAOFactory...");
        daoMap.clear();
        initialized = false;
        initializing = false;
    }
}
