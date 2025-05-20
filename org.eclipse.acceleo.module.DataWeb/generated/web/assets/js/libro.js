/**
 * Gestor específico para la entidad Libro
 */

class LibroManager extends CRUDManager {
    constructor() {
        super('libro');
    }

    /**
     * Obtiene la configuración de campos de la entidad
     */
    getEntityFields() {
        return [
            {
                name: 'id_libro',
                label: 'Id_libro',
                type: 'number',
                isPrimary: true,
                required: false,
                sortable: true,
                showInTable: true
            }
,            {
                name: 'titulo',
                label: 'Titulo',
                type: 'text',
                isPrimary: false,
                required: true,
                sortable: true,
                showInTable: true
            }
,            {
                name: 'autor',
                label: 'Autor',
                type: 'text',
                isPrimary: false,
                required: true,
                sortable: true,
                showInTable: true
            }
,            {
                name: 'añoPublicacion',
                label: 'AñoPublicacion',
                type: 'number',
                isPrimary: false,
                required: true,
                sortable: true,
                showInTable: true
            }
,            {
                name: 'disponible',
                label: 'Disponible',
                type: 'boolean',
                isPrimary: false,
                required: true,
                sortable: true,
                showInTable: true
            }
,
            {
                name: 'pertenece_categoria_ID',
                label: 'Pertenece_categoria',
                type: 'reference',
                isPrimary: false,
                required: true,
                sortable: true,
                showInTable: true,
                referenceEntity: 'categoria'
            }
        ];
    }

    /**
     * Formatea valores específicos para Libro
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
     * Validaciones específicas para Libro
     */
    validateField(fieldName, value) {
        if (fieldName === 'id_libro') {
            const numValue = parseInt(value);
            if (isNaN(numValue) || numValue < 0) {
                return {
                    isValid: false,
                    message: 'Debe ser un número entero positivo'
                };
            }
        }
        if (fieldName === 'añoPublicacion') {
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
        // Acciones específicas para Libro después de cargar datos
        console.log(`Cargados ${entities.length} registros de Libro`);
    }

    /**
     * Preparar datos antes de enviar al servidor
     */
    prepareDataForSave(data) {
        // Transformaciones específicas para Libro antes de guardar
        if (data.hasOwnProperty('id_libro')) {
            data['id_libro'] = parseInt(data['id_libro']) || 0;
        }
        if (data.hasOwnProperty('añoPublicacion')) {
            data['añoPublicacion'] = parseInt(data['añoPublicacion']) || 0;
        }
        if (data.hasOwnProperty('disponible')) {
            data['disponible'] = data['disponible'] === 'true' || data['disponible'] === true;
        }
        
        return data;
    }

    /**
     * Obtiene filtros personalizados específicos para Libro
     */
    getCustomFilters() {
        return {
            // Filtros específicos para Libro
            'disponible': {
                type: 'select',
                options: [
                    { value: '', label: 'Todos' },
                    { value: 'true', label: 'Sí' },
                    { value: 'false', label: 'No' }
                ]
            },
        };
    }

    /**
     * Configuración de exportación para Libro
     */
    getExportConfig() {
        return {
            filename: 'libro_export',
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
    // Solo inicializar si estamos en una página de Libro
    const entityElement = document.querySelector('[data-entity="libro"]');
    if (entityElement) {
        window.entityManager = new LibroManager();
        window.crudManager = window.entityManager; // Alias para funciones globales
        window.entityManager.init();
    }
});

// Exportar la clase para uso en otros módulos
if (typeof module !== 'undefined' && module.exports) {
    module.exports = LibroManager;
}
