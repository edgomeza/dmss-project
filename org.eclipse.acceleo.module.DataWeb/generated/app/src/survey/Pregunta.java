package survey;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa una pregunta de encuesta o cuestionario
 */
public class Pregunta implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public enum TipoPregunta {
        OPCION_MULTIPLE,
        VERDADERO_FALSO,
        RESPUESTA_CORTA,
        RESPUESTA_LARGA,
        ESCALA
    }
    
    private int id;
    private String texto;
    private TipoPregunta tipo;
    private boolean obligatoria;
    private List<String> opciones;
    private String respuestaCorrecta; // Para preguntas evaluables
    private int puntuacion; // Para preguntas evaluables
    
    /**
     * Constructor por defecto
     */
    public Pregunta() {
        this.opciones = new ArrayList<>();
        this.obligatoria = true;
        this.puntuacion = 1;
    }
    
    /**
     * Constructor con parámetros principales
     * @param id ID de la pregunta
     * @param texto Texto de la pregunta
     * @param tipo Tipo de pregunta
     */
    public Pregunta(int id, String texto, TipoPregunta tipo) {
        this();
        this.id = id;
        this.texto = texto;
        this.tipo = tipo;
    }
    
    // Getters y Setters
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getTexto() {
        return texto;
    }
    
    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    public TipoPregunta getTipo() {
        return tipo;
    }
    
    public void setTipo(TipoPregunta tipo) {
        this.tipo = tipo;
    }
    
    public boolean isObligatoria() {
        return obligatoria;
    }
    
    public void setObligatoria(boolean obligatoria) {
        this.obligatoria = obligatoria;
    }
    
    public List<String> getOpciones() {
        return opciones;
    }
    
    public void addOpcion(String opcion) {
        opciones.add(opcion);
    }
    
    public void removeOpcion(String opcion) {
        opciones.remove(opcion);
    }
    
    public String getRespuestaCorrecta() {
        return respuestaCorrecta;
    }
    
    public void setRespuestaCorrecta(String respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }
    
    public int getPuntuacion() {
        return puntuacion;
    }
    
    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
    
    /**
     * Evalúa si una respuesta es correcta (para preguntas evaluables)
     * @param respuesta Respuesta a evaluar
     * @return true si la respuesta es correcta, false en caso contrario
     */
    public boolean evaluarRespuesta(String respuesta) {
        if (respuestaCorrecta == null) {
            return false; // No se puede evaluar
        }
        
        if (tipo == TipoPregunta.VERDADERO_FALSO) {
            return respuesta.equalsIgnoreCase(respuestaCorrecta);
        } else if (tipo == TipoPregunta.OPCION_MULTIPLE) {
            return respuesta.equals(respuestaCorrecta);
        } else if (tipo == TipoPregunta.RESPUESTA_CORTA) {
            return respuesta.trim().equalsIgnoreCase(respuestaCorrecta.trim());
        }
        
        return false;
    }
    
    @Override
    public String toString() {
        return "Pregunta{" +
                "id=" + id +
                ", texto='" + texto + '\'' +
                ", tipo=" + tipo +
                ", obligatoria=" + obligatoria +
                ", opciones=" + opciones.size() +
                '}';
    }
}
