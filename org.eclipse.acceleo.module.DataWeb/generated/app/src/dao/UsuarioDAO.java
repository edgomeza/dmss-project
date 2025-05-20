package dao;

import model.Usuario;
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
 * Implementación de DAO para la entidad Usuario
 * Proporciona métodos para realizar operaciones CRUD y consultas más complejas
 */
public class UsuarioDAO implements IDAO<Usuario, Integer> {
    private static UsuarioDAO instance;
    private Map<Integer, Usuario> data;
    private int nextId = 1; // Para generar IDs automáticamente
    
    /**
     * Constructor privado para aplicar el patrón Singleton
     */
    private UsuarioDAO() {
        data = new HashMap<>();
        initData();
    }
    
    /**
     * Obtiene la instancia única del DAO
     * @return Instancia del DAO de Usuario
     */
    public static UsuarioDAO getInstance() {
        if (instance == null) {
            instance = new UsuarioDAO();
        }
        return instance;
    }
    
    /**
     * Inicializa datos de prueba para la aplicación
     */
    private void initData() {
        System.out.println("Inicializando datos de prueba para Usuario...");
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
            Usuario entity = new Usuario();
            
            // Generamos valores para cada atributo según su tipo
            entity.setId_usuario(i);
            entity.setNombre_usuario(nombresPosibles[rand.nextInt(nombresPosibles.length)] + " " + i);
            entity.setEmail("email_" + i);
            entity.setActivo(rand.nextBoolean());
            
            // Guardamos la entidad en el mapa
            data.put(entity.getId_usuario(), entity);
            
            // Actualizamos el contador de ID para la próxima entidad
            if (entity.getId_usuario() >= nextId) {
                nextId = entity.getId_usuario() + 1;
            }
        }
        
        System.out.println("Se han creado " + numInstancias + " instancias de prueba para Usuario");
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
	public Usuario findById(Integer id) {
	    return data.get(id);
	}
    
    /**
     * Obtiene todas las entidades
     * @return Lista con todas las entidades
     */
    @Override
    public List<Usuario> findAll() {
        return new ArrayList<>(data.values());
    }
    
    /**
     * Guarda una nueva entidad
     * @param entity Entidad a guardar
     * @return La entidad guardada
     */
    @Override
    public Usuario save(Usuario entity) {
        // Si es una entidad nueva y tiene ID numérico, asignarle uno automáticamente
        if (entity.getId_usuario() == 0) {
            entity.setId_usuario(nextId++);
        }
        
        data.put(entity.getId_usuario(), entity);
        System.out.println("Usuario guardado: " + entity);
        return entity;
    }
    
    /**
     * Actualiza una entidad existente
     * @param entity Entidad a actualizar
     * @return true si se actualizó correctamente, false si no existe
     */
    @Override
    public boolean update(Usuario entity) {
        if (data.containsKey(entity.getId_usuario())) {
            data.put(entity.getId_usuario(), entity);
            System.out.println("Usuario actualizado: " + entity);
            return true;
        }
        System.out.println("Error al actualizar: No existe Usuario con id " + entity.getId_usuario());
        return false;
    }
    
    /**
     * Elimina una entidad por su identificador
     * @param id Identificador de la entidad a eliminar
     * @return true si se eliminó correctamente, false si no existía
     */
    @Override
	public boolean delete(Integer id) {
	    Usuario removed = data.remove(id);
	    if (removed != null) {
	        System.out.println("Usuario con id " + id + " eliminado correctamente");
	        return true;
	    } else {
	        System.out.println("No se encontró Usuario con id " + id + " para eliminar");
	        return false;
	    }
	}
    
    /**
     * Elimina todas las entidades
     */
    @Override
    public void deleteAll() {
        data.clear();
        System.out.println("Todas las entidades Usuario han sido eliminadas");
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
    public List<Usuario> findByFilter(Predicate<Usuario> filter) {
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
    public List<Usuario> getPage(int pageNumber, int pageSize) {
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
    public List<Usuario> getFilteredPage(Predicate<Usuario> filter, int pageNumber, int pageSize) {
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
    public int countByFilter(Predicate<Usuario> filter) {
        return (int) data.values().stream()
                .filter(filter)
                .count();
    }
    
    // Métodos específicos para búsquedas por atributos
    
    /**
     * Busca entidades por el atributo nombre_usuario
     * @param value Valor a buscar
     * @return Lista de entidades que coinciden con el valor
     */
    public List<Usuario> findByNombre_usuario(String value) {
        return findByFilter(entity -> {
            return entity.getNombre_usuario() != null && 
                   entity.getNombre_usuario().toLowerCase().contains(value.toLowerCase());
        });
    }
    
    /**
     * Busca entidades por el atributo email
     * @param value Valor a buscar
     * @return Lista de entidades que coinciden con el valor
     */
    public List<Usuario> findByEmail(String value) {
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
    public List<Usuario> findByActivo(boolean value) {
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
    public Optional<Usuario> findFirst(Predicate<Usuario> filter) {
        return data.values().stream()
                .filter(filter)
                .findFirst();
    }
}
