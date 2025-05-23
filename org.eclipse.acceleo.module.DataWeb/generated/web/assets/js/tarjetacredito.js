/**
 * Gestor específico para la entidad TarjetaCredito
 */

class TarjetaCreditoManager extends CRUDManager {
    constructor() {
        super('tarjetacredito');
    }

    /**
     * Obtiene la configuración de campos de la entidad
     */
    getEntityFields() {
        return [
            {
                name: 'numero_tarjeta',
                label: 'Numero_tarjeta',
                type: 'text',
                isPrimary: true,
                required: false,
                sortable: true,
                showInTable: true
            }
,            {
                name: 'limite_credito',
                label: 'Limite_credito',
                type: 'decimal',
                isPrimary: false,
                required: true,
                sortable: true,
                showInTable: true
            }
,            {
                name: 'saldo_actual',
                label: 'Saldo_actual',
                type: 'decimal',
                isPrimary: false,
                required: true,
                sortable: true,
                showInTable: true
            }
,            {
                name: 'fecha_vencimiento',
                label: 'Fecha_vencimiento',
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
                name: 'cliente_propietario_ID',
                label: 'Cliente_propietario',
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
     * Formatea valores específicos para TarjetaCredito
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
     * Validaciones específicas para TarjetaCredito
     */
    validateField(fieldName, value) {
        if (fieldName === 'limite_credito') {
            const numValue = parseFloat(value);
            if (isNaN(numValue) || numValue < 0) {
                return {
                    isValid: false,
                    message: 'Debe ser un número positivo'
                };
            }
        }
        if (fieldName === 'saldo_actual') {
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
        // Acciones específicas para TarjetaCredito después de cargar datos
        console.log(`Cargados ${entities.length} registros de TarjetaCredito`);
    }

    /**
     * Preparar datos antes de enviar al servidor
     */
    prepareDataForSave(data) {
        // Transformaciones específicas para TarjetaCredito antes de guardar
        if (data.hasOwnProperty('limite_credito')) {
            data['limite_credito'] = parseFloat(data['limite_credito']) || 0;
        }
        if (data.hasOwnProperty('saldo_actual')) {
            data['saldo_actual'] = parseFloat(data['saldo_actual']) || 0;
        }
        if (data.hasOwnProperty('activa')) {
            data['activa'] = data['activa'] === 'true' || data['activa'] === true;
        }
        
        return data;
    }

    /**
     * Obtiene filtros personalizados específicos para TarjetaCredito
     */
    getCustomFilters() {
        return {
            // Filtros específicos para TarjetaCredito
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
     * Configuración de exportación para TarjetaCredito
     */
    getExportConfig() {
        return {
            filename: 'tarjetacredito_export',
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
    // Solo inicializar si estamos en una página de TarjetaCredito
    const entityElement = document.querySelector('[data-entity="tarjetacredito"]');
    if (entityElement) {
        window.entityManager = new TarjetaCreditoManager();
        window.crudManager = window.entityManager; // Alias para funciones globales
        window.entityManager.init();
    }
});

// Exportar la clase para uso en otros módulos
if (typeof module !== 'undefined' && module.exports) {
    module.exports = TarjetaCreditoManager;
}
