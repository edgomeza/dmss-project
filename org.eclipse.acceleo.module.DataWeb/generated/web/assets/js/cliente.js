/**
 * Gestor específico para la entidad Cliente
 */

class ClienteManager extends CRUDManager {
    constructor() {
        super('cliente');
    }

    /**
     * Obtiene la configuración de campos de la entidad
     */
    getEntityFields() {
        return [
            {
                name: 'id_cliente',
                label: 'Id_cliente',
                type: 'number',
                isPrimary: true,
                required: false,
                sortable: true,
                showInTable: true
            }
,            {
                name: 'dni',
                label: 'Dni',
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
                name: 'apellidos',
                label: 'Apellidos',
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
                name: 'telefono',
                label: 'Telefono',
                type: 'text',
                isPrimary: false,
                required: true,
                sortable: true,
                showInTable: true
            }
,            {
                name: 'fecha_registro',
                label: 'Fecha_registro',
                type: 'date',
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
     * Formatea valores específicos para Cliente
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
     * Validaciones específicas para Cliente
     */
    validateField(fieldName, value) {
        if (fieldName === 'id_cliente') {
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
        // Acciones específicas para Cliente después de cargar datos
        console.log(`Cargados ${entities.length} registros de Cliente`);
    }

    /**
     * Preparar datos antes de enviar al servidor
     */
    prepareDataForSave(data) {
        // Transformaciones específicas para Cliente antes de guardar
        if (data.hasOwnProperty('id_cliente')) {
            data['id_cliente'] = parseInt(data['id_cliente']) || 0;
        }
        if (data.hasOwnProperty('activo')) {
            data['activo'] = data['activo'] === 'true' || data['activo'] === true;
        }
        
        return data;
    }

    /**
     * Obtiene filtros personalizados específicos para Cliente
     */
    getCustomFilters() {
        return {
            // Filtros específicos para Cliente
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
     * Configuración de exportación para Cliente
     */
    getExportConfig() {
        return {
            filename: 'cliente_export',
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
    // Solo inicializar si estamos en una página de Cliente
    const entityElement = document.querySelector('[data-entity="cliente"]');
    if (entityElement) {
        window.entityManager = new ClienteManager();
        window.crudManager = window.entityManager; // Alias para funciones globales
        window.entityManager.init();
    }
});

// Exportar la clase para uso en otros módulos
if (typeof module !== 'undefined' && module.exports) {
    module.exports = ClienteManager;
}
