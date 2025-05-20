package dao;

import java.util.List;

/**
 * Interfaz genérica para los Data Access Objects (DAO)
 * @param <T> Tipo de entidad a gestionar
 * @param <ID> Tipo de identificador de la entidad
 */
public interface IDAO<T, ID> {
    /**
     * Busca una entidad por su identificador
     * @param id Identificador de la entidad
     * @return Entidad encontrada o null si no existe
     */
    T findById(ID id);
    
    /**
     * Obtiene todas las entidades
     * @return Lista con todas las entidades
     */
    List<T> findAll();
    
    /**
     * Guarda una nueva entidad
     * @param entity Entidad a guardar
     * @return La entidad guardada
     */
    T save(T entity);
    
    /**
     * Actualiza una entidad existente
     * @param entity Entidad a actualizar
     * @return true si se actualizó correctamente, false si no existe
     */
    boolean update(T entity);
    
    /**
     * Elimina una entidad por su identificador
     * @param id Identificador de la entidad a eliminar
     * @return true si se eliminó correctamente, false si no existía
     */
    boolean delete(ID id);
    
    /**
     * Elimina todas las entidades
     */
    void deleteAll();
    
    /**
     * Cuenta el número total de entidades
     * @return Número total de entidades
     */
    int count();
}
