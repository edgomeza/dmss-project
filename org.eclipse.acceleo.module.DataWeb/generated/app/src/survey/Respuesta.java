package survey;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase que representa una respuesta a una encuesta o cuestionario
 */
public class Respuesta implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int id;
    private int encuestaId;
    private String usuario;
    private String fechaRespuesta;
    private Map<Integer, String> respuestas; // preguntaId -> respuesta
    private boolean completada;
    private boolean aprobada; // Para respuestas que requieren revisión
    
    /**
     * Constructor por defecto
     */
    public Respuesta() {
        this.respuestas = new HashMap<>();
        this.fechaRespuesta = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        this.completada = false;
        this.aprobada = false;
    }
    
    /**
     * Constructor con parámetros principales
     * @param id ID de la respuesta
     * @param encuestaId ID de la encuesta
     * @param usuario Usuario que responde
     */
    public Respuesta(int id, int encuestaId, String usuario) {
        this();
        this.id = id;
        this.encuestaId = encuestaId;
        this.usuario = usuario;
    }
    
    // Getters y Setters
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getEncuestaId() {
        return encuestaId;
    }
    
    public void setEncuestaId(int encuestaId) {
        this.encuestaId = encuestaId;
    }
    
    public String getUsuario() {
        return usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    public String getFechaRespuesta() {
        return fechaRespuesta;
    }
    
    public void setFechaRespuesta(String fechaRespuesta) {
        this.fechaRespuesta = fechaRespuesta;
    }
    
    public Map<Integer, String> getRespuestas() {
        return respuestas;
    }
    
    public void setRespuesta(int preguntaId, String respuesta) {
        this.respuestas.put(preguntaId, respuesta);
    }
    
    public String getRespuesta(int preguntaId) {
        return this.respuestas.get(preguntaId);
    }
    
    public boolean isCompletada() {
        return completada;
    }
    
    public void setCompletada(boolean completada) {
        this.completada = completada;
    }
    
    public boolean isAprobada() {
        return aprobada;
    }
    
    public void setAprobada(boolean aprobada) {
        this.aprobada = aprobada;
    }
    
    /**
     * Calcula el porcentaje de respuestas completadas
     * @param totalPreguntas Número total de preguntas en la encuesta
     * @return Porcentaje de completado (0-100)
     */
    public int calcularPorcentajeCompletado(int totalPreguntas) {
        if (totalPreguntas == 0) {
            return 0;
        }
        return (int) (((double) respuestas.size() / totalPreguntas) * 100);
    }
    
    @Override
    public String toString() {
        return "Respuesta{" +
                "id=" + id +
                ", encuestaId=" + encuestaId +
                ", usuario='" + usuario + '\'' +
                ", fechaRespuesta='" + fechaRespuesta + '\'' +
                ", respuestas=" + respuestas.size() +
                ", completada=" + completada +
                ", aprobada=" + aprobada +
                '}';
    }
}
