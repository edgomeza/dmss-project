package survey;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Clase que representa una encuesta
 */
public class Encuesta implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int id;
    private String titulo;
    private String descripcion;
    private String creador;
    private String fechaCreacion;
    private String fechaCierre;
    private boolean activa;
    private List<String> rolesPermitidos;
    private List<Pregunta> preguntas;
    
    /**
     * Constructor por defecto
     */
    public Encuesta() {
        this.rolesPermitidos = new ArrayList<>();
        this.preguntas = new ArrayList<>();
        this.activa = true;
        this.fechaCreacion = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }
    
    /**
     * Constructor con parámetros principales
     * @param id ID de la encuesta
     * @param titulo Título de la encuesta
     * @param descripcion Descripción de la encuesta
     * @param creador Usuario creador
     */
    public Encuesta(int id, String titulo, String descripcion, String creador) {
        this();
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.creador = creador;
    }
    
    // Getters y Setters
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getCreador() {
        return creador;
    }
    
    public void setCreador(String creador) {
        this.creador = creador;
    }
    
    public String getFechaCreacion() {
        return fechaCreacion;
    }
    
    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    
    public String getFechaCierre() {
        return fechaCierre;
    }
    
    public void setFechaCierre(String fechaCierre) {
        this.fechaCierre = fechaCierre;
    }
    
    public boolean isActiva() {
        return activa;
    }
    
    public void setActiva(boolean activa) {
        this.activa = activa;
    }
    
    public List<String> getRolesPermitidos() {
        return rolesPermitidos;
    }
    
    public void addRolPermitido(String rol) {
        if (!rolesPermitidos.contains(rol)) {
            rolesPermitidos.add(rol);
        }
    }
    
    public void removeRolPermitido(String rol) {
        rolesPermitidos.remove(rol);
    }
    
    public List<Pregunta> getPreguntas() {
        return preguntas;
    }
    
    public void addPregunta(Pregunta pregunta) {
        preguntas.add(pregunta);
    }
    
    public void removePregunta(Pregunta pregunta) {
        preguntas.remove(pregunta);
    }
    
    /**
     * Verifica si un rol específico tiene acceso a esta encuesta
     * @param rol Rol a verificar
     * @return true si el rol tiene acceso, false en caso contrario
     */
    public boolean tieneAcceso(String rol) {
        return rolesPermitidos.isEmpty() || rolesPermitidos.contains(rol);
    }
    
    @Override
    public String toString() {
        return "Encuesta{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", creador='" + creador + '\'' +
                ", fechaCreacion='" + fechaCreacion + '\'' +
                ", activa=" + activa +
                ", preguntas=" + preguntas.size() +
                '}';
    }
}
