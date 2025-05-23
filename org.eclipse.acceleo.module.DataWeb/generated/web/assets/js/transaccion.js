/**
 * Gestor específico para la entidad Transaccion
 */

class TransaccionManager extends CRUDManager {
    constructor() {
        super('transaccion');
    }

    /**
     * Obtiene la configuración de campos de la entidad
     */
    getEntityFields() {
        return [
            {
                name: 'id_transaccion',
                label: 'Id_transaccion',
                type: 'number',
                isPrimary: true,
                required: false,
                sortable: true,
                showInTable: true
            }
,            {
                name: 'fecha_transaccion',
                label: 'Fecha_transaccion',
                type: 'date',
                isPrimary: false,
                required: true,
                sortable: true,
                showInTable: true
            }
,            {
                name: 'tipo_transaccion',
                label: 'Tipo_transaccion',
                type: 'text',
                isPrimary: false,
                required: true,
                sortable: true,
                showInTable: true
            }
,            {
                name: 'monto',
                label: 'Monto',
                type: 'decimal',
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
,            {
                name: 'estado',
                label: 'Estado',
                type: 'text',
                isPrimary: false,
                required: true,
                sortable: true,
                showInTable: true
            }
,
            {
                name: 'cuenta_origen_ID',
                label: 'Cuenta_origen',
                type: 'reference',
                isPrimary: false,
                required: true,
                sortable: true,
                showInTable: true,
                referenceEntity: 'cuenta'
            }
,            {
                name: 'cuenta_destino_ID',
                label: 'Cuenta_destino',
                type: 'reference',
                isPrimary: false,
                required: true,
                sortable: true,
                showInTable: true,
                referenceEntity: 'cuenta'
            }
        ];
    }

    /**
     * Formatea valores específicos para Transaccion
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
     * Validaciones específicas para Transaccion
     */
    validateField(fieldName, value) {
        if (fieldName === 'id_transaccion') {
            const numValue = parseInt(value);
            if (isNaN(numValue) || numValue < 0) {
                return {
                    isValid: false,
                    message: 'Debe ser un número entero positivo'
                };
            }
        }
        if (fieldName === 'monto') {
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
        // Acciones específicas para Transaccion después de cargar datos
        console.log(`Cargados ${entities.length} registros de Transaccion`);
    }

    /**
     * Preparar datos antes de enviar al servidor
     */
    prepareDataForSave(data) {
        // Transformaciones específicas para Transaccion antes de guardar
        if (data.hasOwnProperty('id_transaccion')) {
            data['id_transaccion'] = parseInt(data['id_transaccion']) || 0;
        }
        if (data.hasOwnProperty('monto')) {
            data['monto'] = parseFloat(data['monto']) || 0;
        }
        
        return data;
    }

    /**
     * Obtiene filtros personalizados específicos para Transaccion
     */
    getCustomFilters() {
        return {
            // Filtros específicos para Transaccion
        };
    }

    /**
     * Configuración de exportación para Transaccion
     */
    getExportConfig() {
        return {
            filename: 'transaccion_export',
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
    // Solo inicializar si estamos en una página de Transaccion
    const entityElement = document.querySelector('[data-entity="transaccion"]');
    if (entityElement) {
        window.entityManager = new TransaccionManager();
        window.crudManager = window.entityManager; // Alias para funciones globales
        window.entityManager.init();
    }
});

// Exportar la clase para uso en otros módulos
if (typeof module !== 'undefined' && module.exports) {
    module.exports = TransaccionManager;
}
