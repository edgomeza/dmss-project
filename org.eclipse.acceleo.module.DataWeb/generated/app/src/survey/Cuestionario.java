package survey;

import java.io.Serializable;

/**
 * Clase que representa un cuestionario evaluable
 * Extiende la funcionalidad de Encuesta para incluir aspectos evaluables
 */
public class Cuestionario extends Encuesta implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int tiempoLimite; // en minutos
    private int puntuacionMinima; // para aprobar
    private boolean mostrarResultadosInmediatos;
    private boolean aleatorio;
    
    /**
     * Constructor por defecto
     */
    public Cuestionario() {
        super();
        this.tiempoLimite = 30;
        this.puntuacionMinima = 60;
        this.mostrarResultadosInmediatos = true;
        this.aleatorio = false;
    }
    
    /**
     * Constructor con parámetros principales
     * @param id ID del cuestionario
     * @param titulo Título del cuestionario
     * @param descripcion Descripción del cuestionario
     * @param creador Usuario creador
     */
    public Cuestionario(int id, String titulo, String descripcion, String creador) {
        super(id, titulo, descripcion, creador);
        this.tiempoLimite = 30;
        this.puntuacionMinima = 60;
        this.mostrarResultadosInmediatos = true;
        this.aleatorio = false;
    }
    
    // Getters y Setters adicionales
    
    public int getTiempoLimite() {
        return tiempoLimite;
    }
    
    public void setTiempoLimite(int tiempoLimite) {
        this.tiempoLimite = tiempoLimite;
    }
    
    public int getPuntuacionMinima() {
        return puntuacionMinima;
    }
    
    public void setPuntuacionMinima(int puntuacionMinima) {
        this.puntuacionMinima = puntuacionMinima;
    }
    
    public boolean isMostrarResultadosInmediatos() {
        return mostrarResultadosInmediatos;
    }
    
    public void setMostrarResultadosInmediatos(boolean mostrarResultadosInmediatos) {
        this.mostrarResultadosInmediatos = mostrarResultadosInmediatos;
    }
    
    public boolean isAleatorio() {
        return aleatorio;
    }
    
    public void setAleatorio(boolean aleatorio) {
        this.aleatorio = aleatorio;
    }
    
    /**
     * Calcula la puntuación máxima posible del cuestionario
     * @return Puntuación máxima
     */
    public int calcularPuntuacionMaxima() {
        int total = 0;
        for (Pregunta pregunta : getPreguntas()) {
            total += pregunta.getPuntuacion();
        }
        return total;
    }
    
    /**
     * Evalúa las respuestas de un usuario y calcula su puntuación
     * @param respuesta Respuesta a evaluar
     * @return Puntuación obtenida
     */
    public int evaluarRespuesta(Respuesta respuesta) {
        int puntuacion = 0;
        
        for (Pregunta pregunta : getPreguntas()) {
            String respuestaUser = respuesta.getRespuesta(pregunta.getId());
            if (respuestaUser != null && pregunta.evaluarRespuesta(respuestaUser)) {
                puntuacion += pregunta.getPuntuacion();
            }
        }
        
        return puntuacion;
    }
    
    /**
     * Determina si una puntuación es suficiente para aprobar
     * @param puntuacion Puntuación a evaluar
     * @return true si aprueba, false en caso contrario
     */
    public boolean esAprobado(int puntuacion) {
        int maximo = calcularPuntuacionMaxima();
        if (maximo == 0) {
            return false;
        }
        
        double porcentaje = ((double) puntuacion / maximo) * 100;
        return porcentaje >= puntuacionMinima;
    }
    
    @Override
    public String toString() {
        return "Cuestionario{" +
                "id=" + getId() +
                ", titulo='" + getTitulo() + '\'' +
                ", creador='" + getCreador() + '\'' +
                ", tiempoLimite=" + tiempoLimite +
                ", puntuacionMinima=" + puntuacionMinima +
                ", preguntas=" + getPreguntas().size() +
                '}';
    }
}
