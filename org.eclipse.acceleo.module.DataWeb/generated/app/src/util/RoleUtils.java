package util;

/**
 * Utilidades para gestión de roles
 * Generado automáticamente basándose en la configuración del sistema
 */
public class RoleUtils {
    
    /**
     * Identifica automáticamente el rol administrador
     * basándose en el número de páginas accesibles
     * @return Nombre del rol con más permisos
     */
    public static String getAdminRole() {
        // Identificación automática basada en permisos
        return "Administrador"; // El rol con más permisos
    }
    
    /**
     * Obtiene el número de permisos de cada rol
     * @param roleName Nombre del rol
     * @return Número de páginas accesibles, o -1 si el rol no existe
     */
    public static int getRolePermissions(String roleName) {
        switch(roleName) {
            case "Administrador":
                return 13;
            case "Bibliotecario":
                return 9;
            case "Estudiante":
                return 4;
            default:
                return -1;
        }
    }
    
    /**
     * Verifica si un rol es el administrador del sistema
     * @param roleName Nombre del rol a verificar
     * @return true si es el rol administrador
     */
    public static boolean isAdminRole(String roleName) {
        return getAdminRole().equals(roleName);
    }
    
    /**
     * Obtiene todos los nombres de roles ordenados por permisos (descendente)
     * @return Array de nombres de roles
     */
    public static String[] getAllRolesSortedByPermissions() {
        return new String[]{
            "Administrador"
,             "Bibliotecario"
,             "Estudiante"
        };
    }
}
