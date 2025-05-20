package survey;

import java.io.*;
import java.util.*;

/**
 * Gestor centralizado para encuestas y cuestionarios
 * Implementa patrón Singleton
 */
public class SurveyManager {
    private static SurveyManager instance;
    
    private Map<Integer, Encuesta> encuestas;
    private Map<Integer, Map<Integer, Respuesta>> respuestas; // encuestaId -> (respuestaId -> Respuesta)
    private int nextEncuestaId;
    private int nextRespuestaId;
    private int nextPreguntaId;
    
    private static final String DATA_FILE = "encuestas.dat";
    
    /**
     * Constructor privado (Singleton)
     */
    private SurveyManager() {
        encuestas = new HashMap<>();
        respuestas = new HashMap<>();
        nextEncuestaId = 1;
        nextRespuestaId = 1;
        nextPreguntaId = 1;
        cargarDatos();
    }
    
    /**
     * Obtiene la instancia única del gestor
     * @return Instancia del gestor de encuestas
     */
    public static synchronized SurveyManager getInstance() {
        if (instance == null) {
            instance = new SurveyManager();
        }
        return instance;
    }
    
    /**
     * Obtiene todas las encuestas
     * @return Lista de encuestas
     */
    public List<Encuesta> getEncuestas() {
        return new ArrayList<>(encuestas.values());
    }
    
    /**
     * Obtiene las encuestas accesibles para un rol específico
     * @param rol Rol a verificar acceso
     * @return Lista de encuestas accesibles
     */
    public List<Encuesta> getEncuestasParaRol(String rol) {
        List<Encuesta> result = new ArrayList<>();
        
        for (Encuesta encuesta : encuestas.values()) {
            if (encuesta.tieneAcceso(rol)) {
                result.add(encuesta);
            }
        }
        
        return result;
    }
    
    /**
     * Obtiene una encuesta por su ID
     * @param id ID de la encuesta
     * @return Encuesta o null si no existe
     */
    public Encuesta getEncuesta(int id) {
        return encuestas.get(id);
    }
    
    /**
     * Guarda una nueva encuesta
     * @param encuesta Encuesta a guardar
     * @return ID asignado a la encuesta
     */
    public int guardarEncuesta(Encuesta encuesta) {
        if (encuesta.getId() == 0) {
            encuesta.setId(nextEncuestaId++);
        }
        
        encuestas.put(encuesta.getId(), encuesta);
        guardarDatos();
        return encuesta.getId();
    }
    
    /**
     * Elimina una encuesta y sus respuestas
     * @param id ID de la encuesta a eliminar
     * @return true si se eliminó correctamente, false si no existía
     */
    public boolean eliminarEncuesta(int id) {
        if (!encuestas.containsKey(id)) {
            return false;
        }
        
        encuestas.remove(id);
        respuestas.remove(id);
        guardarDatos();
        return true;
    }
    
    /**
     * Obtiene todas las respuestas para una encuesta
     * @param encuestaId ID de la encuesta
     * @return Lista de respuestas
     */
    public List<Respuesta> getRespuestas(int encuestaId) {
        Map<Integer, Respuesta> respuestasEncuesta = respuestas.get(encuestaId);
        if (respuestasEncuesta == null) {
            return new ArrayList<>();
        }
        
        return new ArrayList<>(respuestasEncuesta.values());
    }
    
    /**
     * Obtiene una respuesta específica
     * @param encuestaId ID de la encuesta
     * @param respuestaId ID de la respuesta
     * @return Respuesta o null si no existe
     */
    public Respuesta getRespuesta(int encuestaId, int respuestaId) {
        Map<Integer, Respuesta> respuestasEncuesta = respuestas.get(encuestaId);
        if (respuestasEncuesta == null) {
            return null;
        }
        
        return respuestasEncuesta.get(respuestaId);
    }
    
    /**
     * Guarda una respuesta
     * @param respuesta Respuesta a guardar
     * @return ID asignado a la respuesta
     */
    public int guardarRespuesta(Respuesta respuesta) {
        if (respuesta.getId() == 0) {
            respuesta.setId(nextRespuestaId++);
        }
        
        Map<Integer, Respuesta> respuestasEncuesta = respuestas.computeIfAbsent(
            respuesta.getEncuestaId(), k -> new HashMap<>());
        
        respuestasEncuesta.put(respuesta.getId(), respuesta);
        guardarDatos();
        return respuesta.getId();
    }
    
    /**
     * Elimina una respuesta
     * @param encuestaId ID de la encuesta
     * @param respuestaId ID de la respuesta
     * @return true si se eliminó correctamente, false si no existía
     */
    public boolean eliminarRespuesta(int encuestaId, int respuestaId) {
        Map<Integer, Respuesta> respuestasEncuesta = respuestas.get(encuestaId);
        if (respuestasEncuesta == null) {
            return false;
        }
        
        boolean result = respuestasEncuesta.remove(respuestaId) != null;
        if (result) {
            guardarDatos();
        }
        return result;
    }
    
    /**
     * Obtiene el siguiente ID disponible para una pregunta
     * @return ID para nueva pregunta
     */
    public int getNextPreguntaId() {
        return nextPreguntaId++;
    }
    
    /**
     * Carga los datos desde archivo
     */
    @SuppressWarnings("unchecked")
    private void cargarDatos() {
        try {
            File file = new File(DATA_FILE);
            if (file.exists()) {
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
                encuestas = (Map<Integer, Encuesta>) in.readObject();
                respuestas = (Map<Integer, Map<Integer, Respuesta>>) in.readObject();
                nextEncuestaId = in.readInt();
                nextRespuestaId = in.readInt();
                nextPreguntaId = in.readInt();
                in.close();
                System.out.println("Datos de encuestas cargados correctamente desde " + DATA_FILE);
            } else {
                // Crear datos de ejemplo si no existe el archivo
                crearDatosEjemplo();
            }
        } catch (Exception e) {
            System.err.println("Error al cargar datos de encuestas: " + e.getMessage());
            // Crear datos de ejemplo si hay error
            crearDatosEjemplo();
        }
    }
    
    /**
     * Guarda los datos en archivo
     */
    private void guardarDatos() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(DATA_FILE));
            out.writeObject(encuestas);
            out.writeObject(respuestas);
            out.writeInt(nextEncuestaId);
            out.writeInt(nextRespuestaId);
            out.writeInt(nextPreguntaId);
            out.close();
        } catch (Exception e) {
            System.err.println("Error al guardar datos de encuestas: " + e.getMessage());
        }
    }
    
    /**
     * Crea datos de ejemplo para demostración
     */
    private void crearDatosEjemplo() {
        System.out.println("Creando datos de ejemplo para encuestas...");
        
        // Encuesta de ejemplo
        Encuesta encuesta = new Encuesta(nextEncuestaId++, "Satisfacción del Usuario", 
                "Encuesta para evaluar la satisfacción con nuestra aplicación", "admin");
        
        Pregunta p1 = new Pregunta(nextPreguntaId++, "¿Cómo calificaría la facilidad de uso de la aplicación?", 
                Pregunta.TipoPregunta.OPCION_MULTIPLE);
        p1.addOpcion("Muy fácil");
        p1.addOpcion("Fácil");
        p1.addOpcion("Regular");
        p1.addOpcion("Difícil");
        p1.addOpcion("Muy difícil");
        
        Pregunta p2 = new Pregunta(nextPreguntaId++, "¿Encontró útil la documentación proporcionada?", 
                Pregunta.TipoPregunta.VERDADERO_FALSO);
        
        Pregunta p3 = new Pregunta(nextPreguntaId++, "¿Qué características nuevas le gustaría ver en la aplicación?", 
                Pregunta.TipoPregunta.RESPUESTA_LARGA);
        
        encuesta.addPregunta(p1);
        encuesta.addPregunta(p2);
        encuesta.addPregunta(p3);
        
        encuestas.put(encuesta.getId(), encuesta);
        
        // Cuestionario de ejemplo
        Cuestionario cuestionario = new Cuestionario(nextEncuestaId++, "Evaluación de Conocimientos de Java", 
                "Cuestionario para evaluar conocimientos básicos de Java", "admin");
        cuestionario.setTiempoLimite(15);
        
        Pregunta q1 = new Pregunta(nextPreguntaId++, "¿Cuál es la palabra clave para definir una clase en Java?", 
                Pregunta.TipoPregunta.RESPUESTA_CORTA);
        q1.setRespuestaCorrecta("class");
        
        Pregunta q2 = new Pregunta(nextPreguntaId++, "¿Java es un lenguaje orientado a objetos?", 
                Pregunta.TipoPregunta.VERDADERO_FALSO);
        q2.setRespuestaCorrecta("true");
        
        Pregunta q3 = new Pregunta(nextPreguntaId++, "¿Cuál NO es un tipo primitivo en Java?", 
                Pregunta.TipoPregunta.OPCION_MULTIPLE);
        q3.addOpcion("int");
        q3.addOpcion("boolean");
        q3.addOpcion("String");
        q3.addOpcion("char");
        q3.setRespuestaCorrecta("String");
        q3.setPuntuacion(2);
        
        cuestionario.addPregunta(q1);
        cuestionario.addPregunta(q2);
        cuestionario.addPregunta(q3);
        
        encuestas.put(cuestionario.getId(), cuestionario);
        
        guardarDatos();
    }
}
