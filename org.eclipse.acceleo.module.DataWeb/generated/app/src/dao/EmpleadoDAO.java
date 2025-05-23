package dao;

import model.Empleado;
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
 * Implementación de DAO para la entidad Empleado
 * Proporciona métodos para realizar operaciones CRUD y consultas más complejas
 */
public class EmpleadoDAO implements IDAO<Empleado, Integer> {
    private static EmpleadoDAO instance;
    private Map<Integer, Empleado> data;
    private int nextId = 1; // Para generar IDs automáticamente
    
    /**
     * Constructor privado para aplicar el patrón Singleton
     */
    private EmpleadoDAO() {
        data = new HashMap<>();
        initData();
    }
    
    /**
     * Obtiene la instancia única del DAO
     * @return Instancia del DAO de Empleado
     */
    public static EmpleadoDAO getInstance() {
        if (instance == null) {
            instance = new EmpleadoDAO();
        }
        return instance;
    }
    
    /**
     * Inicializa datos de prueba para la aplicación
     */
    private void initData() {
        System.out.println("Inicializando datos de prueba para Empleado...");
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
            Empleado entity = new Empleado();
            
            // Generamos valores para cada atributo según su tipo
            entity.setId_empleado(i);
            entity.setCodigo_empleado("codigo_empleado_" + i);
            entity.setNombre(nombresPosibles[rand.nextInt(nombresPosibles.length)] + " " + i);
            entity.setPuesto("puesto_" + i);
            entity.setDepartamento("departamento_" + i);
            entity.setEmail("email_" + i);
            entity.setActivo(rand.nextBoolean());
            
            // Guardamos la entidad en el mapa
            data.put(entity.getId_empleado(), entity);
            
            // Actualizamos el contador de ID para la próxima entidad
            if (entity.getId_empleado() >= nextId) {
                nextId = entity.getId_empleado() + 1;
            }
        }
        
        System.out.println("Se han creado " + numInstancias + " instancias de prueba para Empleado");
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
	public Empleado findById(Integer id) {
	    return data.get(id);
	}
    
    /**
     * Obtiene todas las entidades
     * @return Lista con todas las entidades
     */
    @Override
    public List<Empleado> findAll() {
        return new ArrayList<>(data.values());
    }
    
    /**
     * Guarda una nueva entidad
     * @param entity Entidad a guardar
     * @return La entidad guardada
     */
    @Override
    public Empleado save(Empleado entity) {
        // Si es una entidad nueva y tiene ID numérico, asignarle uno automáticamente
        if (entity.getId_empleado() == 0) {
            entity.setId_empleado(nextId++);
        }
        
        data.put(entity.getId_empleado(), entity);
        System.out.println("Empleado guardado: " + entity);
        return entity;
    }
    
    /**
     * Actualiza una entidad existente
     * @param entity Entidad a actualizar
     * @return true si se actualizó correctamente, false si no existe
     */
    @Override
    public boolean update(Empleado entity) {
        if (data.containsKey(entity.getId_empleado())) {
            data.put(entity.getId_empleado(), entity);
            System.out.println("Empleado actualizado: " + entity);
            return true;
        }
        System.out.println("Error al actualizar: No existe Empleado con id " + entity.getId_empleado());
        return false;
    }
    
    /**
     * Elimina una entidad por su identificador
     * @param id Identificador de la entidad a eliminar
     * @return true si se eliminó correctamente, false si no existía
     */
    @Override
	public boolean delete(Integer id) {
	    Empleado removed = data.remove(id);
	    if (removed != null) {
	        System.out.println("Empleado con id " + id + " eliminado correctamente");
	        return true;
	    } else {
	        System.out.println("No se encontró Empleado con id " + id + " para eliminar");
	        return false;
	    }
	}
    
    /**
     * Elimina todas las entidades
     */
    @Override
    public void deleteAll() {
        data.clear();
        System.out.println("Todas las entidades Empleado han sido eliminadas");
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
    public List<Empleado> findByFilter(Predicate<Empleado> filter) {
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
    public List<Empleado> getPage(int pageNumber, int pageSize) {
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
    public List<Empleado> getFilteredPage(Predicate<Empleado> filter, int pageNumber, int pageSize) {
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
    public int countByFilter(Predicate<Empleado> filter) {
        return (int) data.values().stream()
                .filter(filter)
                .count();
    }
    
    // Métodos específicos para búsquedas por atributos
    
    /**
     * Busca entidades por el atributo codigo_empleado
     * @param value Valor a buscar
     * @return Lista de entidades que coinciden con el valor
     */
    public List<Empleado> findByCodigo_empleado(String value) {
        return findByFilter(entity -> {
            return entity.getCodigo_empleado() != null && 
                   entity.getCodigo_empleado().toLowerCase().contains(value.toLowerCase());
        });
    }
    
    /**
     * Busca entidades por el atributo nombre
     * @param value Valor a buscar
     * @return Lista de entidades que coinciden con el valor
     */
    public List<Empleado> findByNombre(String value) {
        return findByFilter(entity -> {
            return entity.getNombre() != null && 
                   entity.getNombre().toLowerCase().contains(value.toLowerCase());
        });
    }
    
    /**
     * Busca entidades por el atributo puesto
     * @param value Valor a buscar
     * @return Lista de entidades que coinciden con el valor
     */
    public List<Empleado> findByPuesto(String value) {
        return findByFilter(entity -> {
            return entity.getPuesto() != null && 
                   entity.getPuesto().toLowerCase().contains(value.toLowerCase());
        });
    }
    
    /**
     * Busca entidades por el atributo departamento
     * @param value Valor a buscar
     * @return Lista de entidades que coinciden con el valor
     */
    public List<Empleado> findByDepartamento(String value) {
        return findByFilter(entity -> {
            return entity.getDepartamento() != null && 
                   entity.getDepartamento().toLowerCase().contains(value.toLowerCase());
        });
    }
    
    /**
     * Busca entidades por el atributo email
     * @param value Valor a buscar
     * @return Lista de entidades que coinciden con el valor
     */
    public List<Empleado> findByEmail(String value) {
        return findByFilter(entity -> {
            return entity.getEmail() != null && 
                   entity.getEmail().toLowerCase().contains(value.toLowerCase());
        });
    }
    
    /**
     * Busca entidades por el atributo activo
     * @param value Valor a buscar
     * @return Lista de entidades que coinciden con el valor
     */
    public List<Empleado> findByActivo(boolean value) {
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
    public Optional<Empleado> findFirst(Predicate<Empleado> filter) {
        return data.values().stream()
                .filter(filter)
                .findFirst();
    }
}
