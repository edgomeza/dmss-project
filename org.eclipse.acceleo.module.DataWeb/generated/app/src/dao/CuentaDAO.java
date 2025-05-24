package dao;

import model.Cuenta;
// Importación de modelos relacionados
import model.Cliente;
import dao.ClienteDAO;
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
 * Implementación de DAO para la entidad Cuenta
 * Proporciona métodos para realizar operaciones CRUD y consultas más complejas
 */
public class CuentaDAO implements IDAO<Cuenta, String> {
    private static CuentaDAO instance;
    private Map<String, Cuenta> data;
    private int nextId = 1; // Para generar IDs automáticamente
    
    /**
     * Constructor privado para aplicar el patrón Singleton
     */
    private CuentaDAO() {
        data = new HashMap<>();
        initData();
    }
    
    /**
     * Obtiene la instancia única del DAO
     * @return Instancia del DAO de Cuenta
     */
    public static CuentaDAO getInstance() {
        if (instance == null) {
            instance = new CuentaDAO();
        }
        return instance;
    }
    
    /**
     * Inicializa datos de prueba para la aplicación
     */
    private void initData() {
        System.out.println("Inicializando datos de prueba para Cuenta...");
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
            Cuenta entity = new Cuenta();
            
            // Generamos valores para cada atributo según su tipo
            entity.setNumero_cuenta("Cuenta_" + i);
            entity.setTipo_cuenta("tipo_cuenta_" + i);
            entity.setSaldo(Math.round(rand.nextDouble() * 10000.0) / 100.0); // Dos decimales
			// Generamos fechas aleatorias con nombres únicos
			long offset_fecha_apertura = (long) (rand.nextDouble() * 395) - 365;
			Date date_fecha_apertura = new Date(currentDate.getTime() + offset_fecha_apertura * 24 * 60 * 60 * 1000);
			entity.setFecha_apertura(dateFormat.format(date_fecha_apertura));
            entity.setActiva(rand.nextBoolean());
            
            // Guardamos la entidad en el mapa
            data.put(entity.getNumero_cuenta(), entity);
            
            // Actualizamos el contador de ID para la próxima entidad
        }
        
        System.out.println("Se han creado " + numInstancias + " instancias de prueba para Cuenta");
    }

    /**
     * Configura las relaciones con otras entidades
     * Se debe llamar después de que todas las entidades estén inicializadas
     */
    public void setupRelationships() {
        System.out.println("Configurando relaciones para Cuenta...");
        Random rand = new Random();
        
        try {
            // Obtener instancias de la entidad referenciada
            ClienteDAO cliente_titularDAO = (ClienteDAO) DAOFactory.getDAO(Cliente.class);
            List<Cliente> cliente_titularList = cliente_titularDAO.findAll();
            
            if (cliente_titularList.isEmpty()) {
                System.out.println("Advertencia: No hay entidades Cliente disponibles para establecer relaciones");
                return;
            }
            
            // Asignar aleatoriamente entidades relacionadas
            for (Cuenta entity : data.values()) {
                // Determinar si asignamos una relación (80% de probabilidad)
                if (rand.nextDouble() < 0.8) {
                    Cliente related = cliente_titularList.get(rand.nextInt(cliente_titularList.size()));
                    entity.setCliente_titular(related);
                }
            }
            System.out.println("Relaciones cliente_titular configuradas correctamente");
        } catch (Exception e) {
            System.err.println("Error al configurar relaciones cliente_titular: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Busca una entidad por su identificador
     * @param id Identificador de la entidad
     * @return Entidad encontrada o null si no existe
     */
    @Override
	public Cuenta findById(String id) {
	    return data.get(id);
	}
    
    /**
     * Obtiene todas las entidades
     * @return Lista con todas las entidades
     */
    @Override
    public List<Cuenta> findAll() {
        return new ArrayList<>(data.values());
    }
    
    /**
     * Guarda una nueva entidad
     * @param entity Entidad a guardar
     * @return La entidad guardada
     */
    @Override
    public Cuenta save(Cuenta entity) {
        // Si es una entidad nueva y tiene ID numérico, asignarle uno automáticamente
        
        data.put(entity.getNumero_cuenta(), entity);
        System.out.println("Cuenta guardado: " + entity);
        return entity;
    }
    
    /**
     * Actualiza una entidad existente
     * @param entity Entidad a actualizar
     * @return true si se actualizó correctamente, false si no existe
     */
    @Override
    public boolean update(Cuenta entity) {
        if (data.containsKey(entity.getNumero_cuenta())) {
            data.put(entity.getNumero_cuenta(), entity);
            System.out.println("Cuenta actualizado: " + entity);
            return true;
        }
        System.out.println("Error al actualizar: No existe Cuenta con id " + entity.getNumero_cuenta());
        return false;
    }
    
    /**
     * Elimina una entidad por su identificador
     * @param id Identificador de la entidad a eliminar
     * @return true si se eliminó correctamente, false si no existía
     */
    @Override
	public boolean delete(String id) {
	    Cuenta removed = data.remove(id);
	    if (removed != null) {
	        System.out.println("Cuenta con id " + id + " eliminado correctamente");
	        return true;
	    } else {
	        System.out.println("No se encontró Cuenta con id " + id + " para eliminar");
	        return false;
	    }
	}
    
    /**
     * Elimina todas las entidades
     */
    @Override
    public void deleteAll() {
        data.clear();
        System.out.println("Todas las entidades Cuenta han sido eliminadas");
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
    public List<Cuenta> findByFilter(Predicate<Cuenta> filter) {
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
    public List<Cuenta> getPage(int pageNumber, int pageSize) {
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
    public List<Cuenta> getFilteredPage(Predicate<Cuenta> filter, int pageNumber, int pageSize) {
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
    public int countByFilter(Predicate<Cuenta> filter) {
        return (int) data.values().stream()
                .filter(filter)
                .count();
    }
    
    // Métodos específicos para búsquedas por atributos
    
    /**
     * Busca entidades por el atributo tipo_cuenta
     * @param value Valor a buscar
     * @return Lista de entidades que coinciden con el valor
     */
    public List<Cuenta> findByTipo_cuenta(String value) {
        return findByFilter(entity -> {
            return entity.getTipo_cuenta() != null && 
                   entity.getTipo_cuenta().toLowerCase().contains(value.toLowerCase());
        });
    }
    
    /**
     * Busca entidades por el atributo saldo
     * @param value Valor a buscar
     * @return Lista de entidades que coinciden con el valor
     */
    public List<Cuenta> findBySaldo(double value) {
        return findByFilter(entity -> {
            return entity.getSaldo() == value;
        });
    }
    
    /**
     * Busca entidades por el atributo fecha_apertura
     * @param value Valor a buscar
     * @return Lista de entidades que coinciden con el valor
     */
    public List<Cuenta> findByFecha_apertura(String value) {
        return findByFilter(entity -> {
            return entity.getFecha_apertura() != null && 
                   entity.getFecha_apertura().toLowerCase().contains(value.toLowerCase());
        });
    }
    
    /**
     * Busca entidades por el atributo activa
     * @param value Valor a buscar
     * @return Lista de entidades que coinciden con el valor
     */
    public List<Cuenta> findByActiva(boolean value) {
        return findByFilter(entity -> {
            return entity.getActiva() == value;
        });
    }
    
    
    // Métodos para búsqueda por relaciones
    
    /**
     * Busca entidades por su relación con Cliente
     * @param clienteId ID de la entidad Cliente relacionada
     * @return Lista de entidades relacionadas con la Cliente especificada
     */
	public List<Cuenta> findByCliente_titular(Integer refId) {
	    return findByFilter(entity -> 
	        entity.getCliente_titular() != null && 
	        entity.getCliente_titular().getId_cliente() != null && 
	        entity.getCliente_titular().getId_cliente() == refId
	    );
	}
    
    
    /**
     * Verifica si existe una entidad con el ID especificado
     * @param id ID a verificar
     * @return true si existe, false en caso contrario
     */
    public boolean existsById(String id) {
        return data.containsKey(id);
    }
    
    /**
     * Encuentra la primera entidad que cumple un criterio o devuelve Optional vacío
     * @param filter Predicado que define el criterio
     * @return Optional con la entidad encontrada o vacío
     */
    public Optional<Cuenta> findFirst(Predicate<Cuenta> filter) {
        return data.values().stream()
                .filter(filter)
                .findFirst();
    }
}
