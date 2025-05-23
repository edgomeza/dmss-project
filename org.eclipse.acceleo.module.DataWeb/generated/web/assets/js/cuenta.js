/**
 * Gestor específico para la entidad Cuenta
 */

class CuentaManager extends CRUDManager {
    constructor() {
        super('cuenta');
    }

    /**
     * Obtiene la configuración de campos de la entidad
     */
    getEntityFields() {
        return [
            {
                name: 'numero_cuenta',
                label: 'Numero_cuenta',
                type: 'text',
                isPrimary: true,
                required: false,
                sortable: true,
                showInTable: true
            }
,            {
                name: 'tipo_cuenta',
                label: 'Tipo_cuenta',
                type: 'text',
                isPrimary: false,
                required: true,
                sortable: true,
                showInTable: true
            }
,            {
                name: 'saldo',
                label: 'Saldo',
                type: 'decimal',
                isPrimary: false,
                required: true,
                sortable: true,
                showInTable: true
            }
,            {
                name: 'fecha_apertura',
                label: 'Fecha_apertura',
                type: 'date',
                isPrimary: false,
                required: true,
                sortable: true,
                showInTable: true
            }
,            {
                name: 'activa',
                label: 'Activa',
                type: 'boolean',
                isPrimary: false,
                required: true,
                sortable: true,
                showInTable: true
            }
,
            {
                name: 'cliente_titular_ID',
                label: 'Cliente_titular',
                type: 'reference',
                isPrimary: false,
                required: true,
                sortable: true,
                showInTable: true,
                referenceEntity: 'cliente'
            }
        ];
    }

    /**
     * Formatea valores específicos para Cuenta
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
     * Validaciones específicas para Cuenta
     */
    validateField(fieldName, value) {
        if (fieldName === 'saldo') {
            const numValue = parseFloat(value);
            if (isNaN(numValue) || numValue < 0) {
                return {
                    isValid: false,
                    message: 'Debe ser un número positivo'
                };
            }
        }
        
        return { isValid: true };
    }

    /**
     * Acciones adicionales después de cargar datos
     */
    onDataLoaded(entities) {
        // Acciones específicas para Cuenta después de cargar datos
        console.log(`Cargados ${entities.length} registros de Cuenta`);
    }

    /**
     * Preparar datos antes de enviar al servidor
     */
    prepareDataForSave(data) {
        // Transformaciones específicas para Cuenta antes de guardar
        if (data.hasOwnProperty('saldo')) {
            data['saldo'] = parseFloat(data['saldo']) || 0;
        }
        if (data.hasOwnProperty('activa')) {
            data['activa'] = data['activa'] === 'true' || data['activa'] === true;
        }
        
        return data;
    }

    /**
     * Obtiene filtros personalizados específicos para Cuenta
     */
    getCustomFilters() {
        return {
            // Filtros específicos para Cuenta
            'activa': {
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
     * Configuración de exportación para Cuenta
     */
    getExportConfig() {
        return {
            filename: 'cuenta_export',
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
    // Solo inicializar si estamos en una página de Cuenta
    const entityElement = document.querySelector('[data-entity="cuenta"]');
    if (entityElement) {
        window.entityManager = new CuentaManager();
        window.crudManager = window.entityManager; // Alias para funciones globales
        window.entityManager.init();
    }
});

// Exportar la clase para uso en otros módulos
if (typeof module !== 'undefined' && module.exports) {
    module.exports = CuentaManager;
}
