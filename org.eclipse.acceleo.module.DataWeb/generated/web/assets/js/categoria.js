/**
 * Gestor específico para la entidad Categoria
 */

class CategoriaManager extends CRUDManager {
    constructor() {
        super('categoria');
    }

    /**
     * Obtiene la configuración de campos de la entidad
     */
    getEntityFields() {
        return [
            {
                name: 'id_categoria',
                label: 'Id_categoria',
                type: 'number',
                isPrimary: true,
                required: false,
                sortable: true,
                showInTable: true
            }
,            {
                name: 'nombre_categoria',
                label: 'Nombre_categoria',
                type: 'text',
                isPrimary: false,
                required: true,
                sortable: true,
                showInTable: true
            }
,            {
                name: 'descripcion',
                label: 'Descripcion',
                type: 'text',
                isPrimary: false,
                required: true,
                sortable: true,
                showInTable: true
            }
        ];
    }

    /**
     * Formatea valores específicos para Categoria
     */
    formatFieldValue(value, field) {
        // Formateo específico para esta entidad
        
        // Si es una referencia, mostrar con badge
        if (field.type === 'reference' && value) {
            return `<span class="badge badge-info">${value}</span>`;
        }
        
        // Usar el formateo del padre por defecto
        return super.formatFieldValue(value, field);
    }

    /**
     * Validaciones específicas para Categoria
     */
    validateField(fieldName, value) {
        if (fieldName === 'id_categoria') {
            const numValue = parseInt(value);
            if (isNaN(numValue) || numValue < 0) {
                return {
                    isValid: false,
                    message: 'Debe ser un número entero positivo'
                };
            }
        }
        
        return { isValid: true };
    }

    /**
     * Acciones adicionales después de cargar datos
     */
    onDataLoaded(entities) {
        // Acciones específicas para Categoria después de cargar datos
        console.log(`Cargados ${entities.length} registros de Categoria`);
    }

    /**
     * Preparar datos antes de enviar al servidor
     */
    prepareDataForSave(data) {
        // Transformaciones específicas para Categoria antes de guardar
        if (data.hasOwnProperty('id_categoria')) {
            data['id_categoria'] = parseInt(data['id_categoria']) || 0;
        }
        
        return data;
    }

    /**
     * Obtiene filtros personalizados específicos para Categoria
     */
    getCustomFilters() {
        return {
            // Filtros específicos para Categoria
        };
    }

    /**
     * Configuración de exportación para Categoria
     */
    getExportConfig() {
        return {
            filename: 'categoria_export',
            columns: this.getEntityFields().filter(f => f.showInTable).map(f => ({
                key: f.name,
                header: f.label
            }))
        };
    }
}

// Configuración global para esta entidad
window.entityManager = null;

// Inicializar cuando el DOM esté listo
document.addEventListener('DOMContentLoaded', function() {
    // Solo inicializar si estamos en una página de Categoria
    const entityElement = document.querySelector('[data-entity="categoria"]');
    if (entityElement) {
        window.entityManager = new CategoriaManager();
        window.crudManager = window.entityManager; // Alias para funciones globales
        window.entityManager.init();
    }
});

// Exportar la clase para uso en otros módulos
if (typeof module !== 'undefined' && module.exports) {
    module.exports = CategoriaManager;
}
