package dao;

import model.Prestamo;
// Importación de modelos relacionados
import model.Usuario;
import dao.UsuarioDAO;
import model.Libro;
import dao.LibroDAO;
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
			// Generamos fechas aleatorias con nombres únicos
			long offset_fechaPrestamo = (long) (rand.nextDouble() * 395) - 365;
			Date date_fechaPrestamo = new Date(currentDate.getTime() + offset_fechaPrestamo * 24 * 60 * 60 * 1000);
			entity.setFechaPrestamo(dateFormat.format(date_fechaPrestamo));
			// Generamos fechas aleatorias con nombres únicos
			long offset_fechaDevolucion = (long) (rand.nextDouble() * 395) - 365;
			Date date_fechaDevolucion = new Date(currentDate.getTime() + offset_fechaDevolucion * 24 * 60 * 60 * 1000);
			entity.setFechaDevolucion(dateFormat.format(date_fechaDevolucion));
            
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
            UsuarioDAO prestamo_usuarioDAO = (UsuarioDAO) DAOFactory.getDAO(Usuario.class);
            List<Usuario> prestamo_usuarioList = prestamo_usuarioDAO.findAll();
            
            if (prestamo_usuarioList.isEmpty()) {
                System.out.println("Advertencia: No hay entidades Usuario disponibles para establecer relaciones");
                return;
            }
            
            // Asignar aleatoriamente entidades relacionadas
            for (Prestamo entity : data.values()) {
                // Determinar si asignamos una relación (80% de probabilidad)
                if (rand.nextDouble() < 0.8) {
                    Usuario related = prestamo_usuarioList.get(rand.nextInt(prestamo_usuarioList.size()));
                    entity.setPrestamo_usuario(related);
                }
            }
            System.out.println("Relaciones prestamo_usuario configuradas correctamente");
        } catch (Exception e) {
            System.err.println("Error al configurar relaciones prestamo_usuario: " + e.getMessage());
            e.printStackTrace();
        }
        try {
            // Obtener instancias de la entidad referenciada
            LibroDAO prestamo_libroDAO = (LibroDAO) DAOFactory.getDAO(Libro.class);
            List<Libro> prestamo_libroList = prestamo_libroDAO.findAll();
            
            if (prestamo_libroList.isEmpty()) {
                System.out.println("Advertencia: No hay entidades Libro disponibles para establecer relaciones");
                return;
            }
            
            // Asignar aleatoriamente entidades relacionadas
            for (Prestamo entity : data.values()) {
                // Determinar si asignamos una relación (80% de probabilidad)
                if (rand.nextDouble() < 0.8) {
                    Libro related = prestamo_libroList.get(rand.nextInt(prestamo_libroList.size()));
                    entity.setPrestamo_libro(related);
                }
            }
            System.out.println("Relaciones prestamo_libro configuradas correctamente");
        } catch (Exception e) {
            System.err.println("Error al configurar relaciones prestamo_libro: " + e.getMessage());
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
     * Busca entidades por el atributo fechaPrestamo
     * @param value Valor a buscar
     * @return Lista de entidades que coinciden con el valor
     */
    public List<Prestamo> findByFechaPrestamo(String value) {
        return findByFilter(entity -> {
            return entity.getFechaPrestamo() != null && 
                   entity.getFechaPrestamo().toLowerCase().contains(value.toLowerCase());
        });
    }
    
    /**
     * Busca entidades por el atributo fechaDevolucion
     * @param value Valor a buscar
     * @return Lista de entidades que coinciden con el valor
     */
    public List<Prestamo> findByFechaDevolucion(String value) {
        return findByFilter(entity -> {
            return entity.getFechaDevolucion() != null && 
                   entity.getFechaDevolucion().toLowerCase().contains(value.toLowerCase());
        });
    }
    
    
    // Métodos para búsqueda por relaciones
    
    /**
     * Busca entidades por su relación con Usuario
     * @param usuarioId ID de la entidad Usuario relacionada
     * @return Lista de entidades relacionadas con la Usuario especificada
     */
	public List<Prestamo> findByPrestamo_usuario(Integer refId) {
	    return findByFilter(entity -> 
	        entity.getPrestamo_usuario() != null && 
	        entity.getPrestamo_usuario().getId_usuario() != null && 
	        entity.getPrestamo_usuario().getId_usuario() == refId
	    );
	}
    
    /**
     * Busca entidades por su relación con Libro
     * @param libroId ID de la entidad Libro relacionada
     * @return Lista de entidades relacionadas con la Libro especificada
     */
	public List<Prestamo> findByPrestamo_libro(Integer refId) {
	    return findByFilter(entity -> 
	        entity.getPrestamo_libro() != null && 
	        entity.getPrestamo_libro().getId_libro() != null && 
	        entity.getPrestamo_libro().getId_libro() == refId
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
