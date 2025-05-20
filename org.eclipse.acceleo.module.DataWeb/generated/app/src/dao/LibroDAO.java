package dao;

import model.Libro;
// Importación de modelos relacionados
import model.Categoria;
import dao.CategoriaDAO;
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
 * Implementación de DAO para la entidad Libro
 * Proporciona métodos para realizar operaciones CRUD y consultas más complejas
 */
public class LibroDAO implements IDAO<Libro, Integer> {
    private static LibroDAO instance;
    private Map<Integer, Libro> data;
    private int nextId = 1; // Para generar IDs automáticamente
    
    /**
     * Constructor privado para aplicar el patrón Singleton
     */
    private LibroDAO() {
        data = new HashMap<>();
        initData();
    }
    
    /**
     * Obtiene la instancia única del DAO
     * @return Instancia del DAO de Libro
     */
    public static LibroDAO getInstance() {
        if (instance == null) {
            instance = new LibroDAO();
        }
        return instance;
    }
    
    /**
     * Inicializa datos de prueba para la aplicación
     */
    private void initData() {
        System.out.println("Inicializando datos de prueba para Libro...");
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
            Libro entity = new Libro();
            
            // Generamos valores para cada atributo según su tipo
            entity.setId_libro(i);
            entity.setTitulo(nombresPosibles[rand.nextInt(nombresPosibles.length)] + " " + i);
            entity.setAutor("autor_" + i);
            entity.setAñoPublicacion(rand.nextInt(1000) + 1);
            entity.setDisponible(rand.nextBoolean());
            
            // Guardamos la entidad en el mapa
            data.put(entity.getId_libro(), entity);
            
            // Actualizamos el contador de ID para la próxima entidad
            if (entity.getId_libro() >= nextId) {
                nextId = entity.getId_libro() + 1;
            }
        }
        
        System.out.println("Se han creado " + numInstancias + " instancias de prueba para Libro");
    }

    /**
     * Configura las relaciones con otras entidades
     * Se debe llamar después de que todas las entidades estén inicializadas
     */
    public void setupRelationships() {
        System.out.println("Configurando relaciones para Libro...");
        Random rand = new Random();
        
        try {
            // Obtener instancias de la entidad referenciada
            CategoriaDAO pertenece_categoriaDAO = (CategoriaDAO) DAOFactory.getDAO(Categoria.class);
            List<Categoria> pertenece_categoriaList = pertenece_categoriaDAO.findAll();
            
            if (pertenece_categoriaList.isEmpty()) {
                System.out.println("Advertencia: No hay entidades Categoria disponibles para establecer relaciones");
                return;
            }
            
            // Asignar aleatoriamente entidades relacionadas
            for (Libro entity : data.values()) {
                // Determinar si asignamos una relación (80% de probabilidad)
                if (rand.nextDouble() < 0.8) {
                    Categoria related = pertenece_categoriaList.get(rand.nextInt(pertenece_categoriaList.size()));
                    entity.setPertenece_categoria(related);
                }
            }
            System.out.println("Relaciones pertenece_categoria configuradas correctamente");
        } catch (Exception e) {
            System.err.println("Error al configurar relaciones pertenece_categoria: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Busca una entidad por su identificador
     * @param id Identificador de la entidad
     * @return Entidad encontrada o null si no existe
     */
    @Override
	public Libro findById(Integer id) {
	    return data.get(id);
	}
    
    /**
     * Obtiene todas las entidades
     * @return Lista con todas las entidades
     */
    @Override
    public List<Libro> findAll() {
        return new ArrayList<>(data.values());
    }
    
    /**
     * Guarda una nueva entidad
     * @param entity Entidad a guardar
     * @return La entidad guardada
     */
    @Override
    public Libro save(Libro entity) {
        // Si es una entidad nueva y tiene ID numérico, asignarle uno automáticamente
        if (entity.getId_libro() == 0) {
            entity.setId_libro(nextId++);
        }
        
        data.put(entity.getId_libro(), entity);
        System.out.println("Libro guardado: " + entity);
        return entity;
    }
    
    /**
     * Actualiza una entidad existente
     * @param entity Entidad a actualizar
     * @return true si se actualizó correctamente, false si no existe
     */
    @Override
    public boolean update(Libro entity) {
        if (data.containsKey(entity.getId_libro())) {
            data.put(entity.getId_libro(), entity);
            System.out.println("Libro actualizado: " + entity);
            return true;
        }
        System.out.println("Error al actualizar: No existe Libro con id " + entity.getId_libro());
        return false;
    }
    
    /**
     * Elimina una entidad por su identificador
     * @param id Identificador de la entidad a eliminar
     * @return true si se eliminó correctamente, false si no existía
     */
    @Override
	public boolean delete(Integer id) {
	    Libro removed = data.remove(id);
	    if (removed != null) {
	        System.out.println("Libro con id " + id + " eliminado correctamente");
	        return true;
	    } else {
	        System.out.println("No se encontró Libro con id " + id + " para eliminar");
	        return false;
	    }
	}
    
    /**
     * Elimina todas las entidades
     */
    @Override
    public void deleteAll() {
        data.clear();
        System.out.println("Todas las entidades Libro han sido eliminadas");
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
    public List<Libro> findByFilter(Predicate<Libro> filter) {
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
    public List<Libro> getPage(int pageNumber, int pageSize) {
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
    public List<Libro> getFilteredPage(Predicate<Libro> filter, int pageNumber, int pageSize) {
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
    public int countByFilter(Predicate<Libro> filter) {
        return (int) data.values().stream()
                .filter(filter)
                .count();
    }
    
    // Métodos específicos para búsquedas por atributos
    
    /**
     * Busca entidades por el atributo titulo
     * @param value Valor a buscar
     * @return Lista de entidades que coinciden con el valor
     */
    public List<Libro> findByTitulo(String value) {
        return findByFilter(entity -> {
            return entity.getTitulo() != null && 
                   entity.getTitulo().toLowerCase().contains(value.toLowerCase());
        });
    }
    
    /**
     * Busca entidades por el atributo autor
     * @param value Valor a buscar
     * @return Lista de entidades que coinciden con el valor
     */
    public List<Libro> findByAutor(String value) {
        return findByFilter(entity -> {
            return entity.getAutor() != null && 
                   entity.getAutor().toLowerCase().contains(value.toLowerCase());
        });
    }
    
    /**
     * Busca entidades por el atributo añoPublicacion
     * @param value Valor a buscar
     * @return Lista de entidades que coinciden con el valor
     */
    public List<Libro> findByAñoPublicacion(int value) {
        return findByFilter(entity -> {
            return entity.getAñoPublicacion() == value;
        });
    }
    
    /**
     * Busca entidades por el atributo disponible
     * @param value Valor a buscar
     * @return Lista de entidades que coinciden con el valor
     */
    public List<Libro> findByDisponible(boolean value) {
        return findByFilter(entity -> {
            return entity.getDisponible() == value;
        });
    }
    
    
    // Métodos para búsqueda por relaciones
    
    /**
     * Busca entidades por su relación con Categoria
     * @param categoriaId ID de la entidad Categoria relacionada
     * @return Lista de entidades relacionadas con la Categoria especificada
     */
	public List<Libro> findByPertenece_categoria(Integer refId) {
	    return findByFilter(entity -> 
	        entity.getPertenece_categoria() != null && 
	        entity.getPertenece_categoria().getId_categoria() != null && 
	        entity.getPertenece_categoria().getId_categoria() == refId
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
    public Optional<Libro> findFirst(Predicate<Libro> filter) {
        return data.values().stream()
                .filter(filter)
                .findFirst();
    }
}
