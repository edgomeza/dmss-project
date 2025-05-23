/**
 * Gestor específico para la entidad Empleado
 */

class EmpleadoManager extends CRUDManager {
    constructor() {
        super('empleado');
    }

    /**
     * Obtiene la configuración de campos de la entidad
     */
    getEntityFields() {
        return [
            {
                name: 'id_empleado',
                label: 'Id_empleado',
                type: 'number',
                isPrimary: true,
                required: false,
                sortable: true,
                showInTable: true
            }
,            {
                name: 'codigo_empleado',
                label: 'Codigo_empleado',
                type: 'text',
                isPrimary: false,
                required: true,
                sortable: true,
                showInTable: true
            }
,            {
                name: 'nombre',
                label: 'Nombre',
                type: 'text',
                isPrimary: false,
                required: true,
                sortable: true,
                showInTable: true
            }
,            {
                name: 'puesto',
                label: 'Puesto',
                type: 'text',
                isPrimary: false,
                required: true,
                sortable: true,
                showInTable: true
            }
,            {
                name: 'departamento',
                label: 'Departamento',
                type: 'text',
                isPrimary: false,
                required: true,
                sortable: true,
                showInTable: true
            }
,            {
                name: 'email',
                label: 'Email',
                type: 'email',
                isPrimary: false,
                required: true,
                sortable: true,
                showInTable: true
            }
,            {
                name: 'activo',
                label: 'Activo',
                type: 'boolean',
                isPrimary: false,
                required: true,
                sortable: true,
                showInTable: true
            }
        ];
    }

    /**
     * Formatea valores específicos para Empleado
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
     * Validaciones específicas para Empleado
     */
    validateField(fieldName, value) {
        if (fieldName === 'id_empleado') {
            const numValue = parseInt(value);
            if (isNaN(numValue) || numValue < 0) {
                return {
                    isValid: false,
                    message: 'Debe ser un número entero positivo'
                };
            }
        }
        if (fieldName === 'email') {
            const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
            if (value && !emailRegex.test(value)) {
                return {
                    isValid: false,
                    message: 'Debe ser un email válido'
                };
            }
        }
        
        return { isValid: true };
    }

    /**
     * Acciones adicionales después de cargar datos
     */
    onDataLoaded(entities) {
        // Acciones específicas para Empleado después de cargar datos
        console.log(`Cargados ${entities.length} registros de Empleado`);
    }

    /**
     * Preparar datos antes de enviar al servidor
     */
    prepareDataForSave(data) {
        // Transformaciones específicas para Empleado antes de guardar
        if (data.hasOwnProperty('id_empleado')) {
            data['id_empleado'] = parseInt(data['id_empleado']) || 0;
        }
        if (data.hasOwnProperty('activo')) {
            data['activo'] = data['activo'] === 'true' || data['activo'] === true;
        }
        
        return data;
    }

    /**
     * Obtiene filtros personalizados específicos para Empleado
     */
    getCustomFilters() {
        return {
            // Filtros específicos para Empleado
            'activo': {
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
     * Configuración de exportación para Empleado
     */
    getExportConfig() {
        return {
            filename: 'empleado_export',
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
    // Solo inicializar si estamos en una página de Empleado
    const entityElement = document.querySelector('[data-entity="empleado"]');
    if (entityElement) {
        window.entityManager = new EmpleadoManager();
        window.crudManager = window.entityManager; // Alias para funciones globales
        window.entityManager.init();
    }
});

// Exportar la clase para uso en otros módulos
if (typeof module !== 'undefined' && module.exports) {
    module.exports = EmpleadoManager;
}
