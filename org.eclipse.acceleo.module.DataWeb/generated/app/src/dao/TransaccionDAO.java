package dao;

import model.Transaccion;
// Importación de modelos relacionados
import model.Cuenta;
import dao.CuentaDAO;
import model.Cuenta;
import dao.CuentaDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Optional;
import java.util.Random;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Implementación de DAO para la entidad Transaccion
 * Proporciona métodos para realizar operaciones CRUD y consultas más complejas
 */
public class TransaccionDAO implements IDAO<Transaccion, Integer> {
    private static TransaccionDAO instance;
    private Map<Integer, Transaccion> data;
    private int nextId = 1; // Para generar IDs automáticamente
    
    /**
     * Constructor privado para aplicar el patrón Singleton
     */
    private TransaccionDAO() {
        data = new HashMap<>();
        initData();
    }
    
    /**
     * Obtiene la instancia única del DAO
     * @return Instancia del DAO de Transaccion
     */
    public static TransaccionDAO getInstance() {
        if (instance == null) {
            instance = new TransaccionDAO();
        }
        return instance;
    }
    
    /**
     * Inicializa datos de prueba para la aplicación
     */
    private void initData() {
        System.out.println("Inicializando datos de prueba para Transaccion...");
        Random rand = new Random();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = new Date();
        
        // Valores de ejemplo para los diferentes tipos de datos
        String[] nombresPosibles = {"Principal", "Secundario", "Premium", "Regular", "Especial", "Básico", "Avanzado", "Estándar"};
        String[] descripcionesPosibles = {"Descripción detallada sobre este elemento", 
                                        "Información básica y generalizada", 
                                        "Datos principales y características específicas", 
                                        "Detalles técnicos y especificaciones",
                                        "Información complementaria sobre el elemento"};
        String[] estadosPosibles = {"Activo", "Inactivo", "Pendiente", "En proceso", "Completado", "Cancelado"};
        
        // Crear entre 5 y 15 instancias de ejemplo
        int numInstancias = rand.nextInt(10) + 5;
        for (int i = 1; i <= numInstancias; i++) {
            Transaccion entity = new Transaccion();
            
            // Generamos valores para cada atributo según su tipo
            entity.setId_transaccion(i);
			// Generamos fechas aleatorias con nombres únicos
			long offset_fecha_transaccion = (long) (rand.nextDouble() * 395) - 365;
			Date date_fecha_transaccion = new Date(currentDate.getTime() + offset_fecha_transaccion * 24 * 60 * 60 * 1000);
			entity.setFecha_transaccion(dateFormat.format(date_fecha_transaccion));
            entity.setTipo_transaccion("tipo_transaccion_" + i);
            entity.setMonto(Math.round(rand.nextDouble() * 10000.0) / 100.0); // Dos decimales
            entity.setDescripcion(descripcionesPosibles[rand.nextInt(descripcionesPosibles.length)]);
            entity.setEstado(estadosPosibles[rand.nextInt(estadosPosibles.length)]);
            
            // Guardamos la entidad en el mapa
            data.put(entity.getId_transaccion(), entity);
            
            // Actualizamos el contador de ID para la próxima entidad
            if (entity.getId_transaccion() >= nextId) {
                nextId = entity.getId_transaccion() + 1;
            }
        }
        
        System.out.println("Se han creado " + numInstancias + " instancias de prueba para Transaccion");
    }

    /**
     * Configura las relaciones con otras entidades
     * Se debe llamar después de que todas las entidades estén inicializadas
     */
    public void setupRelationships() {
        System.out.println("Configurando relaciones para Transaccion...");
        Random rand = new Random();
        
        try {
            // Obtener instancias de la entidad referenciada
            CuentaDAO cuenta_origenDAO = (CuentaDAO) DAOFactory.getDAO(Cuenta.class);
            List<Cuenta> cuenta_origenList = cuenta_origenDAO.findAll();
            
            if (cuenta_origenList.isEmpty()) {
                System.out.println("Advertencia: No hay entidades Cuenta disponibles para establecer relaciones");
                return;
            }
            
            // Asignar aleatoriamente entidades relacionadas
            for (Transaccion entity : data.values()) {
                // Determinar si asignamos una relación (80% de probabilidad)
                if (rand.nextDouble() < 0.8) {
                    Cuenta related = cuenta_origenList.get(rand.nextInt(cuenta_origenList.size()));
                    entity.setCuenta_origen(related);
                }
            }
            System.out.println("Relaciones cuenta_origen configuradas correctamente");
        } catch (Exception e) {
            System.err.println("Error al configurar relaciones cuenta_origen: " + e.getMessage());
            e.printStackTrace();
        }
        try {
            // Obtener instancias de la entidad referenciada
            CuentaDAO cuenta_destinoDAO = (CuentaDAO) DAOFactory.getDAO(Cuenta.class);
            List<Cuenta> cuenta_destinoList = cuenta_destinoDAO.findAll();
            
            if (cuenta_destinoList.isEmpty()) {
                System.out.println("Advertencia: No hay entidades Cuenta disponibles para establecer relaciones");
                return;
            }
            
            // Asignar aleatoriamente entidades relacionadas
            for (Transaccion entity : data.values()) {
                // Determinar si asignamos una relación (80% de probabilidad)
                if (rand.nextDouble() < 0.8) {
                    Cuenta related = cuenta_destinoList.get(rand.nextInt(cuenta_destinoList.size()));
                    entity.setCuenta_destino(related);
                }
            }
            System.out.println("Relaciones cuenta_destino configuradas correctamente");
        } catch (Exception e) {
            System.err.println("Error al configurar relaciones cuenta_destino: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Busca una entidad por su identificador
     * @param id Identificador de la entidad
     * @return Entidad encontrada o null si no existe
     */
    @Override
	public Transaccion findById(Integer id) {
	    return data.get(id);
	}
    
    /**
     * Obtiene todas las entidades
     * @return Lista con todas las entidades
     */
    @Override
    public List<Transaccion> findAll() {
        return new ArrayList<>(data.values());
    }
    
    /**
     * Guarda una nueva entidad
     * @param entity Entidad a guardar
     * @return La entidad guardada
     */
    @Override
    public Transaccion save(Transaccion entity) {
        // Si es una entidad nueva y tiene ID numérico, asignarle uno automáticamente
        if (entity.getId_transaccion() == 0) {
            entity.setId_transaccion(nextId++);
        }
        
        data.put(entity.getId_transaccion(), entity);
        System.out.println("Transaccion guardado: " + entity);
        return entity;
    }
    
    /**
     * Actualiza una entidad existente
     * @param entity Entidad a actualizar
     * @return true si se actualizó correctamente, false si no existe
     */
    @Override
    public boolean update(Transaccion entity) {
        if (data.containsKey(entity.getId_transaccion())) {
            data.put(entity.getId_transaccion(), entity);
            System.out.println("Transaccion actualizado: " + entity);
            return true;
        }
        System.out.println("Error al actualizar: No existe Transaccion con id " + entity.getId_transaccion());
        return false;
    }
    
    /**
     * Elimina una entidad por su identificador
     * @param id Identificador de la entidad a eliminar
     * @return true si se eliminó correctamente, false si no existía
     */
    @Override
	public boolean delete(Integer id) {
	    Transaccion removed = data.remove(id);
	    if (removed != null) {
	        System.out.println("Transaccion con id " + id + " eliminado correctamente");
	        return true;
	    } else {
	        System.out.println("No se encontró Transaccion con id " + id + " para eliminar");
	        return false;
	    }
	}
    
    /**
     * Elimina todas las entidades
     */
    @Override
    public void deleteAll() {
        data.clear();
        System.out.println("Todas las entidades Transaccion han sido eliminadas");
    }
    
    /**
     * Cuenta el número total de entidades
     * @return Número total de entidades
     */
    @Override
    public int count() {
        return data.size();
    }
    
    /**
     * Busca entidades que cumplan con un criterio personalizado
     * @param filter Predicado que define el criterio de búsqueda
     * @return Lista de entidades que cumplen el criterio
     */
    public List<Transaccion> findByFilter(Predicate<Transaccion> filter) {
        return data.values().stream()
                .filter(filter)
                .collect(Collectors.toList());
    }
    
    /**
     * Obtiene una página de entidades
     * @param pageNumber Número de página (empezando en 1)
     * @param pageSize Tamaño de la página
     * @return Lista de entidades en la página especificada
     */
    public List<Transaccion> getPage(int pageNumber, int pageSize) {
        if (pageNumber < 1 || pageSize < 1) {
            throw new IllegalArgumentException("El número de página y el tamaño deben ser mayores que 0");
        }
        
        return data.values().stream()
                .skip((long) (pageNumber - 1) * pageSize)
                .limit(pageSize)
                .collect(Collectors.toList());
    }
    
    /**
     * Obtiene una página de entidades filtradas
     * @param filter Predicado que define el criterio de filtrado
     * @param pageNumber Número de página (empezando en 1)
     * @param pageSize Tamaño de la página
     * @return Lista de entidades filtradas en la página especificada
     */
    public List<Transaccion> getFilteredPage(Predicate<Transaccion> filter, int pageNumber, int pageSize) {
        if (pageNumber < 1 || pageSize < 1) {
            throw new IllegalArgumentException("El número de página y el tamaño deben ser mayores que 0");
        }
        
        return data.values().stream()
                .filter(filter)
                .skip((long) (pageNumber - 1) * pageSize)
                .limit(pageSize)
                .collect(Collectors.toList());
    }
    
    /**
     * Cuenta el número de entidades que cumplen un criterio
     * @param filter Predicado que define el criterio
     * @return Número de entidades que cumplen el criterio
     */
    public int countByFilter(Predicate<Transaccion> filter) {
        return (int) data.values().stream()
                .filter(filter)
                .count();
    }
    
    // Métodos específicos para búsquedas por atributos
    
    /**
     * Busca entidades por el atributo fecha_transaccion
     * @param value Valor a buscar
     * @return Lista de entidades que coinciden con el valor
     */
    public List<Transaccion> findByFecha_transaccion(String value) {
        return findByFilter(entity -> {
            return entity.getFecha_transaccion() != null && 
                   entity.getFecha_transaccion().toLowerCase().contains(value.toLowerCase());
        });
    }
    
    /**
     * Busca entidades por el atributo tipo_transaccion
     * @param value Valor a buscar
     * @return Lista de entidades que coinciden con el valor
     */
    public List<Transaccion> findByTipo_transaccion(String value) {
        return findByFilter(entity -> {
            return entity.getTipo_transaccion() != null && 
                   entity.getTipo_transaccion().toLowerCase().contains(value.toLowerCase());
        });
    }
    
    /**
     * Busca entidades por el atributo monto
     * @param value Valor a buscar
     * @return Lista de entidades que coinciden con el valor
     */
    public List<Transaccion> findByMonto(double value) {
        return findByFilter(entity -> {
            return entity.getMonto() == value;
        });
    }
    
    /**
     * Busca entidades por el atributo descripcion
     * @param value Valor a buscar
     * @return Lista de entidades que coinciden con el valor
     */
    public List<Transaccion> findByDescripcion(String value) {
        return findByFilter(entity -> {
            return entity.getDescripcion() != null && 
                   entity.getDescripcion().toLowerCase().contains(value.toLowerCase());
        });
    }
    
    /**
     * Busca entidades por el atributo estado
     * @param value Valor a buscar
     * @return Lista de entidades que coinciden con el valor
     */
    public List<Transaccion> findByEstado(String value) {
        return findByFilter(entity -> {
            return entity.getEstado() != null && 
                   entity.getEstado().toLowerCase().contains(value.toLowerCase());
        });
    }
    
    
    // Métodos para búsqueda por relaciones
    
    /**
     * Busca entidades por su relación con Cuenta
     * @param cuentaId ID de la entidad Cuenta relacionada
     * @return Lista de entidades relacionadas con la Cuenta especificada
     */
	public List<Transaccion> findByCuenta_origen(String refId) {
	    return findByFilter(entity -> 
	        entity.getCuenta_origen() != null && 
	        entity.getCuenta_origen().getNumero_cuenta() != null && 
	        entity.getCuenta_origen().getNumero_cuenta().equals(refId)
	    );
	}
    
    /**
     * Busca entidades por su relación con Cuenta
     * @param cuentaId ID de la entidad Cuenta relacionada
     * @return Lista de entidades relacionadas con la Cuenta especificada
     */
	public List<Transaccion> findByCuenta_destino(String refId) {
	    return findByFilter(entity -> 
	        entity.getCuenta_destino() != null && 
	        entity.getCuenta_destino().getNumero_cuenta() != null && 
	        entity.getCuenta_destino().getNumero_cuenta().equals(refId)
	    );
	}
    
    
    /**
     * Verifica si existe una entidad con el ID especificado
     * @param id ID a verificar
     * @return true si existe, false en caso contrario
     */
    public boolean existsById(int id) {
        return data.containsKey(id);
    }
    
    /**
     * Encuentra la primera entidad que cumple un criterio o devuelve Optional vacío
     * @param filter Predicado que define el criterio
     * @return Optional con la entidad encontrada o vacío
     */
    public Optional<Transaccion> findFirst(Predicate<Transaccion> filter) {
        return data.values().stream()
                .filter(filter)
                .findFirst();
    }
}
