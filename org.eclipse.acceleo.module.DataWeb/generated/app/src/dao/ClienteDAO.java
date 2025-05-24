package dao;

import model.Cliente;
// Importación de modelos relacionados
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
 * Implementación de DAO para la entidad Cliente
 * Proporciona métodos para realizar operaciones CRUD y consultas más complejas
 */
public class ClienteDAO implements IDAO<Cliente, Integer> {
    private static ClienteDAO instance;
    private Map<Integer, Cliente> data;
    private int nextId = 1; // Para generar IDs automáticamente
    
    /**
     * Constructor privado para aplicar el patrón Singleton
     */
    private ClienteDAO() {
        data = new HashMap<>();
        initData();
    }
    
    /**
     * Obtiene la instancia única del DAO
     * @return Instancia del DAO de Cliente
     */
    public static ClienteDAO getInstance() {
        if (instance == null) {
            instance = new ClienteDAO();
        }
        return instance;
    }
    
    /**
     * Inicializa datos de prueba para la aplicación
     */
    private void initData() {
        System.out.println("Inicializando datos de prueba para Cliente...");
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
            Cliente entity = new Cliente();
            
            // Generamos valores para cada atributo según su tipo
            entity.setId_cliente(i);
            entity.setDni("dni_" + i);
            entity.setNombre(nombresPosibles[rand.nextInt(nombresPosibles.length)] + " " + i);
            entity.setApellidos("apellidos_" + i);
            entity.setEmail("email_" + i);
            entity.setTelefono("telefono_" + i);
			// Generamos fechas aleatorias con nombres únicos
			long offset_fecha_registro = (long) (rand.nextDouble() * 395) - 365;
			Date date_fecha_registro = new Date(currentDate.getTime() + offset_fecha_registro * 24 * 60 * 60 * 1000);
			entity.setFecha_registro(dateFormat.format(date_fecha_registro));
            entity.setActivo(rand.nextBoolean());
            
            // Guardamos la entidad en el mapa
            data.put(entity.getId_cliente(), entity);
            
            // Actualizamos el contador de ID para la próxima entidad
            if (entity.getId_cliente() >= nextId) {
                nextId = entity.getId_cliente() + 1;
            }
        }
        
        System.out.println("Se han creado " + numInstancias + " instancias de prueba para Cliente");
    }

    /**
     * Configura las relaciones con otras entidades
     * Se debe llamar después de que todas las entidades estén inicializadas
     */
    public void setupRelationships() {
    }
    
    /**
     * Busca una entidad por su identificador
     * @param id Identificador de la entidad
     * @return Entidad encontrada o null si no existe
     */
    @Override
	public Cliente findById(Integer id) {
	    return data.get(id);
	}
    
    /**
     * Obtiene todas las entidades
     * @return Lista con todas las entidades
     */
    @Override
    public List<Cliente> findAll() {
        return new ArrayList<>(data.values());
    }
    
    /**
     * Guarda una nueva entidad
     * @param entity Entidad a guardar
     * @return La entidad guardada
     */
    @Override
    public Cliente save(Cliente entity) {
        // Si es una entidad nueva y tiene ID numérico, asignarle uno automáticamente
        if (entity.getId_cliente() == 0) {
            entity.setId_cliente(nextId++);
        }
        
        data.put(entity.getId_cliente(), entity);
        System.out.println("Cliente guardado: " + entity);
        return entity;
    }
    
    /**
     * Actualiza una entidad existente
     * @param entity Entidad a actualizar
     * @return true si se actualizó correctamente, false si no existe
     */
    @Override
    public boolean update(Cliente entity) {
        if (data.containsKey(entity.getId_cliente())) {
            data.put(entity.getId_cliente(), entity);
            System.out.println("Cliente actualizado: " + entity);
            return true;
        }
        System.out.println("Error al actualizar: No existe Cliente con id " + entity.getId_cliente());
        return false;
    }
    
    /**
     * Elimina una entidad por su identificador
     * @param id Identificador de la entidad a eliminar
     * @return true si se eliminó correctamente, false si no existía
     */
    @Override
	public boolean delete(Integer id) {
	    Cliente removed = data.remove(id);
	    if (removed != null) {
	        System.out.println("Cliente con id " + id + " eliminado correctamente");
	        return true;
	    } else {
	        System.out.println("No se encontró Cliente con id " + id + " para eliminar");
	        return false;
	    }
	}
    
    /**
     * Elimina todas las entidades
     */
    @Override
    public void deleteAll() {
        data.clear();
        System.out.println("Todas las entidades Cliente han sido eliminadas");
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
    public List<Cliente> findByFilter(Predicate<Cliente> filter) {
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
    public List<Cliente> getPage(int pageNumber, int pageSize) {
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
    public List<Cliente> getFilteredPage(Predicate<Cliente> filter, int pageNumber, int pageSize) {
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
    public int countByFilter(Predicate<Cliente> filter) {
        return (int) data.values().stream()
                .filter(filter)
                .count();
    }
    
    // Métodos específicos para búsquedas por atributos
    
    /**
     * Busca entidades por el atributo dni
     * @param value Valor a buscar
     * @return Lista de entidades que coinciden con el valor
     */
    public List<Cliente> findByDni(String value) {
        return findByFilter(entity -> {
            return entity.getDni() != null && 
                   entity.getDni().toLowerCase().contains(value.toLowerCase());
        });
    }
    
    /**
     * Busca entidades por el atributo nombre
     * @param value Valor a buscar
     * @return Lista de entidades que coinciden con el valor
     */
    public List<Cliente> findByNombre(String value) {
        return findByFilter(entity -> {
            return entity.getNombre() != null && 
                   entity.getNombre().toLowerCase().contains(value.toLowerCase());
        });
    }
    
    /**
     * Busca entidades por el atributo apellidos
     * @param value Valor a buscar
     * @return Lista de entidades que coinciden con el valor
     */
    public List<Cliente> findByApellidos(String value) {
        return findByFilter(entity -> {
            return entity.getApellidos() != null && 
                   entity.getApellidos().toLowerCase().contains(value.toLowerCase());
        });
    }
    
    /**
     * Busca entidades por el atributo email
     * @param value Valor a buscar
     * @return Lista de entidades que coinciden con el valor
     */
    public List<Cliente> findByEmail(String value) {
        return findByFilter(entity -> {
            return entity.getEmail() != null && 
                   entity.getEmail().toLowerCase().contains(value.toLowerCase());
        });
    }
    
    /**
     * Busca entidades por el atributo telefono
     * @param value Valor a buscar
     * @return Lista de entidades que coinciden con el valor
     */
    public List<Cliente> findByTelefono(String value) {
        return findByFilter(entity -> {
            return entity.getTelefono() != null && 
                   entity.getTelefono().toLowerCase().contains(value.toLowerCase());
        });
    }
    
    /**
     * Busca entidades por el atributo fecha_registro
     * @param value Valor a buscar
     * @return Lista de entidades que coinciden con el valor
     */
    public List<Cliente> findByFecha_registro(String value) {
        return findByFilter(entity -> {
            return entity.getFecha_registro() != null && 
                   entity.getFecha_registro().toLowerCase().contains(value.toLowerCase());
        });
    }
    
    /**
     * Busca entidades por el atributo activo
     * @param value Valor a buscar
     * @return Lista de entidades que coinciden con el valor
     */
    public List<Cliente> findByActivo(boolean value) {
        return findByFilter(entity -> {
            return entity.getActivo() == value;
        });
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
    public Optional<Cliente> findFirst(Predicate<Cliente> filter) {
        return data.values().stream()
                .filter(filter)
                .findFirst();
    }
}
