package config;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;

/**
 * Configuración global de la aplicación
 * Implementa patrón Singleton para acceso centralizado
 */
public class AppConfig {
    private static AppConfig instance;
    private Properties properties;
    private Map<String, Object> sessionData;
    private static final String CONFIG_FILE = "app.properties";
    
    private AppConfig() {
        properties = new Properties();
        sessionData = new HashMap<>();
        
        // Cargar configuración si existe
        try {
            File configFile = new File(CONFIG_FILE);
            if (configFile.exists()) {
                properties.load(new FileInputStream(configFile));
                System.out.println("Configuración cargada desde " + CONFIG_FILE);
            } else {
                // Configuración por defecto
                initDefaultConfiguration();
                saveConfiguration();
                System.out.println("Configuración por defecto creada en " + CONFIG_FILE);
            }
        } catch (IOException e) {
            System.err.println("Error al cargar la configuración: " + e.getMessage());
            // Configuración por defecto si hay error
            initDefaultConfiguration();
        }
    }
    
    /**
     * Inicializa la configuración con valores por defecto
     */
    private void initDefaultConfiguration() {
        // Configuración general
        properties.setProperty("app.name", "Biblioteca Universitaria");
        properties.setProperty("app.version", "1.0.0");
        properties.setProperty("app.theme", "light");
        properties.setProperty("app.language", "es");
        
        // Configuración de presentación
        properties.setProperty("display.paginationSize", "5");
        properties.setProperty("display.showColors", "true");
        properties.setProperty("display.dateFormat", "yyyy-MM-dd");
    }
    
    /**
     * Guarda la configuración en disco
     */
    public void saveConfiguration() {
        try {
            properties.store(new FileOutputStream(CONFIG_FILE), "Configuración de Biblioteca Universitaria");
        } catch (IOException e) {
            System.err.println("Error al guardar la configuración: " + e.getMessage());
        }
    }
    
    /**
     * Obtiene la instancia única de configuración
     * @return Instancia de AppConfig
     */
    public static synchronized AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }
    
    /**
     * Obtiene una propiedad de configuración
     * @param key Clave de la propiedad
     * @param defaultValue Valor por defecto si no existe
     * @return Valor de la propiedad
     */
    public String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }
    
    /**
     * Establece una propiedad de configuración
     * @param key Clave de la propiedad
     * @param value Valor de la propiedad
     */
    public void setProperty(String key, String value) {
        properties.setProperty(key, value);
    }
    
    /**
     * Almacena un valor en la sesión actual
     * @param key Clave del valor
     * @param value Valor a almacenar
     */
    public void setSessionValue(String key, Object value) {
        sessionData.put(key, value);
    }
    
    /**
     * Obtiene un valor de la sesión actual
     * @param key Clave del valor
     * @return Valor almacenado o null si no existe
     */
    @SuppressWarnings("unchecked")
    public <T> T getSessionValue(String key) {
        return (T) sessionData.get(key);
    }
    
    /**
     * Limpia todos los datos de la sesión
     */
    public void clearSession() {
        sessionData.clear();
    }
    
    /**
     * Activa o desactiva el modo oscuro
     * @param enabled true para activar, false para desactivar
     */
    public void setDarkMode(boolean enabled) {
        properties.setProperty("app.theme", enabled ? "dark" : "light");
    }
    
    /**
     * Comprueba si el modo oscuro está activado
     * @return true si está activo, false en caso contrario
     */
    public boolean isDarkModeEnabled() {
        return "dark".equals(properties.getProperty("app.theme", "light"));
    }
    
    /**
     * Establece el tamaño de paginación para listados
     * @param size Número de elementos por página
     */
    public void setPaginationSize(int size) {
        properties.setProperty("display.paginationSize", String.valueOf(size));
    }
    
    /**
     * Obtiene el tamaño de paginación configurado
     * @return Número de elementos por página
     */
    public int getPaginationSize() {
        try {
            return Integer.parseInt(properties.getProperty("display.paginationSize", "5"));
        } catch (NumberFormatException e) {
            return 5; // Valor por defecto si hay error
        }
    }
}
