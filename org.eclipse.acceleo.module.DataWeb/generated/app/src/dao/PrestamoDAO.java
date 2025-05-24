package dao;

import model.Prestamo;
// Importación de modelos relacionados
import model.Cliente;
import dao.ClienteDAO;
import model.Empleado;
import dao.EmpleadoDAO;
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
 * Implementación de DAO para la entidad Prestamo
 * Proporciona métodos para realizar operaciones CRUD y consultas más complejas
 */
public class PrestamoDAO implements IDAO<Prestamo, Integer> {
    private static PrestamoDAO instance;
    private Map<Integer, Prestamo> data;
    private int nextId = 1; // Para generar IDs automáticamente
    
    /**
     * Constructor privado para aplicar el patrón Singleton
     */
    private PrestamoDAO() {
        data = new HashMap<>();
        initData();
    }
    
    /**
     * Obtiene la instancia única del DAO
     * @return Instancia del DAO de Prestamo
     */
    public static PrestamoDAO getInstance() {
        if (instance == null) {
            instance = new PrestamoDAO();
        }
        return instance;
    }
    
    /**
     * Inicializa datos de prueba para la aplicación
     */
    private void initData() {
        System.out.println("Inicializando datos de prueba para Prestamo...");
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
            Prestamo entity = new Prestamo();
            
            // Generamos valores para cada atributo según su tipo
            entity.setId_prestamo(i);
            entity.setMonto_solicitado(Math.round(rand.nextDouble() * 10000.0) / 100.0); // Dos decimales
            entity.setTasa_interes(Math.round(rand.nextDouble() * 10000.0) / 100.0); // Dos decimales
            entity.setPlazo_meses(rand.nextInt(1000) + 1);
            entity.setEstado_prestamo(estadosPosibles[rand.nextInt(estadosPosibles.length)]);
			// Generamos fechas aleatorias con nombres únicos
			long offset_fecha_solicitud = (long) (rand.nextDouble() * 395) - 365;
			Date date_fecha_solicitud = new Date(currentDate.getTime() + offset_fecha_solicitud * 24 * 60 * 60 * 1000);
			entity.setFecha_solicitud(dateFormat.format(date_fecha_solicitud));
			// Generamos fechas aleatorias con nombres únicos
			long offset_fecha_aprobacion = (long) (rand.nextDouble() * 395) - 365;
			Date date_fecha_aprobacion = new Date(currentDate.getTime() + offset_fecha_aprobacion * 24 * 60 * 60 * 1000);
			entity.setFecha_aprobacion(dateFormat.format(date_fecha_aprobacion));
            
            // Guardamos la entidad en el mapa
            data.put(entity.getId_prestamo(), entity);
            
            // Actualizamos el contador de ID para la próxima entidad
            if (entity.getId_prestamo() >= nextId) {
                nextId = entity.getId_prestamo() + 1;
            }
        }
        
        System.out.println("Se han creado " + numInstancias + " instancias de prueba para Prestamo");
    }

    /**
     * Configura las relaciones con otras entidades
     * Se debe llamar después de que todas las entidades estén inicializadas
     */
    public void setupRelationships() {
        System.out.println("Configurando relaciones para Prestamo...");
        Random rand = new Random();
        
        try {
            // Obtener instancias de la entidad referenciada
            ClienteDAO cliente_solicitanteDAO = (ClienteDAO) DAOFactory.getDAO(Cliente.class);
            List<Cliente> cliente_solicitanteList = cliente_solicitanteDAO.findAll();
            
            if (cliente_solicitanteList.isEmpty()) {
                System.out.println("Advertencia: No hay entidades Cliente disponibles para establecer relaciones");
                return;
            }
            
            // Asignar aleatoriamente entidades relacionadas
            for (Prestamo entity : data.values()) {
                // Determinar si asignamos una relación (80% de probabilidad)
                if (rand.nextDouble() < 0.8) {
                    Cliente related = cliente_solicitanteList.get(rand.nextInt(cliente_solicitanteList.size()));
                    entity.setCliente_solicitante(related);
                }
            }
            System.out.println("Relaciones cliente_solicitante configuradas correctamente");
        } catch (Exception e) {
            System.err.println("Error al configurar relaciones cliente_solicitante: " + e.getMessage());
            e.printStackTrace();
        }
        try {
            // Obtener instancias de la entidad referenciada
            EmpleadoDAO empleado_aprobadorDAO = (EmpleadoDAO) DAOFactory.getDAO(Empleado.class);
            List<Empleado> empleado_aprobadorList = empleado_aprobadorDAO.findAll();
            
            if (empleado_aprobadorList.isEmpty()) {
                System.out.println("Advertencia: No hay entidades Empleado disponibles para establecer relaciones");
                return;
            }
            
            // Asignar aleatoriamente entidades relacionadas
            for (Prestamo entity : data.values()) {
                // Determinar si asignamos una relación (80% de probabilidad)
                if (rand.nextDouble() < 0.8) {
                    Empleado related = empleado_aprobadorList.get(rand.nextInt(empleado_aprobadorList.size()));
                    entity.setEmpleado_aprobador(related);
                }
            }
            System.out.println("Relaciones empleado_aprobador configuradas correctamente");
        } catch (Exception e) {
            System.err.println("Error al configurar relaciones empleado_aprobador: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Busca una entidad por su identificador
     * @param id Identificador de la entidad
     * @return Entidad encontrada o null si no existe
     */
    @Override
	public Prestamo findById(Integer id) {
	    return data.get(id);
	}
    
    /**
     * Obtiene todas las entidades
     * @return Lista con todas las entidades
     */
    @Override
    public List<Prestamo> findAll() {
        return new ArrayList<>(data.values());
    }
    
    /**
     * Guarda una nueva entidad
     * @param entity Entidad a guardar
     * @return La entidad guardada
     */
    @Override
    public Prestamo save(Prestamo entity) {
        // Si es una entidad nueva y tiene ID numérico, asignarle uno automáticamente
        if (entity.getId_prestamo() == 0) {
            entity.setId_prestamo(nextId++);
        }
        
        data.put(entity.getId_prestamo(), entity);
        System.out.println("Prestamo guardado: " + entity);
        return entity;
    }
    
    /**
     * Actualiza una entidad existente
     * @param entity Entidad a actualizar
     * @return true si se actualizó correctamente, false si no existe
     */
    @Override
    public boolean update(Prestamo entity) {
        if (data.containsKey(entity.getId_prestamo())) {
            data.put(entity.getId_prestamo(), entity);
            System.out.println("Prestamo actualizado: " + entity);
            return true;
        }
        System.out.println("Error al actualizar: No existe Prestamo con id " + entity.getId_prestamo());
        return false;
    }
    
    /**
     * Elimina una entidad por su identificador
     * @param id Identificador de la entidad a eliminar
     * @return true si se eliminó correctamente, false si no existía
     */
    @Override
	public boolean delete(Integer id) {
	    Prestamo removed = data.remove(id);
	    if (removed != null) {
	        System.out.println("Prestamo con id " + id + " eliminado correctamente");
	        return true;
	    } else {
	        System.out.println("No se encontró Prestamo con id " + id + " para eliminar");
	        return false;
	    }
	}
    
    /**
     * Elimina todas las entidades
     */
    @Override
    public void deleteAll() {
        data.clear();
        System.out.println("Todas las entidades Prestamo han sido eliminadas");
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
    public List<Prestamo> findByFilter(Predicate<Prestamo> filter) {
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
    public List<Prestamo> getPage(int pageNumber, int pageSize) {
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
    public List<Prestamo> getFilteredPage(Predicate<Prestamo> filter, int pageNumber, int pageSize) {
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
    public int countByFilter(Predicate<Prestamo> filter) {
        return (int) data.values().stream()
                .filter(filter)
                .count();
    }
    
    // Métodos específicos para búsquedas por atributos
    
    /**
     * Busca entidades por el atributo monto_solicitado
     * @param value Valor a buscar
     * @return Lista de entidades que coinciden con el valor
     */
    public List<Prestamo> findByMonto_solicitado(double value) {
        return findByFilter(entity -> {
            return entity.getMonto_solicitado() == value;
        });
    }
    
    /**
     * Busca entidades por el atributo tasa_interes
     * @param value Valor a buscar
     * @return Lista de entidades que coinciden con el valor
     */
    public List<Prestamo> findByTasa_interes(double value) {
        return findByFilter(entity -> {
            return entity.getTasa_interes() == value;
        });
    }
    
    /**
     * Busca entidades por el atributo plazo_meses
     * @param value Valor a buscar
     * @return Lista de entidades que coinciden con el valor
     */
    public List<Prestamo> findByPlazo_meses(int value) {
        return findByFilter(entity -> {
            return entity.getPlazo_meses() == value;
        });
    }
    
    /**
     * Busca entidades por el atributo estado_prestamo
     * @param value Valor a buscar
     * @return Lista de entidades que coinciden con el valor
     */
    public List<Prestamo> findByEstado_prestamo(String value) {
        return findByFilter(entity -> {
            return entity.getEstado_prestamo() != null && 
                   entity.getEstado_prestamo().toLowerCase().contains(value.toLowerCase());
        });
    }
    
    /**
     * Busca entidades por el atributo fecha_solicitud
     * @param value Valor a buscar
     * @return Lista de entidades que coinciden con el valor
     */
    public List<Prestamo> findByFecha_solicitud(String value) {
        return findByFilter(entity -> {
            return entity.getFecha_solicitud() != null && 
                   entity.getFecha_solicitud().toLowerCase().contains(value.toLowerCase());
        });
    }
    
    /**
     * Busca entidades por el atributo fecha_aprobacion
     * @param value Valor a buscar
     * @return Lista de entidades que coinciden con el valor
     */
    public List<Prestamo> findByFecha_aprobacion(String value) {
        return findByFilter(entity -> {
            return entity.getFecha_aprobacion() != null && 
                   entity.getFecha_aprobacion().toLowerCase().contains(value.toLowerCase());
        });
    }
    
    
    // Métodos para búsqueda por relaciones
    
    /**
     * Busca entidades por su relación con Cliente
     * @param clienteId ID de la entidad Cliente relacionada
     * @return Lista de entidades relacionadas con la Cliente especificada
     */
	public List<Prestamo> findByCliente_solicitante(Integer refId) {
	    return findByFilter(entity -> 
	        entity.getCliente_solicitante() != null && 
	        entity.getCliente_solicitante().getId_cliente() != null && 
	        entity.getCliente_solicitante().getId_cliente() == refId
	    );
	}
    
    /**
     * Busca entidades por su relación con Empleado
     * @param empleadoId ID de la entidad Empleado relacionada
     * @return Lista de entidades relacionadas con la Empleado especificada
     */
	public List<Prestamo> findByEmpleado_aprobador(Integer refId) {
	    return findByFilter(entity -> 
	        entity.getEmpleado_aprobador() != null && 
	        entity.getEmpleado_aprobador().getId_empleado() != null && 
	        entity.getEmpleado_aprobador().getId_empleado() == refId
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
    public Optional<Prestamo> findFirst(Predicate<Prestamo> filter) {
        return data.values().stream()
                .filter(filter)
                .findFirst();
    }
}
