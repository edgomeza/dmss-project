/**
 * Gestor específico para la entidad Prestamo
 */

class PrestamoManager extends CRUDManager {
    constructor() {
        super('prestamo');
    }

    /**
     * Obtiene la configuración de campos de la entidad
     */
    getEntityFields() {
        return [
            {
                name: 'id_prestamo',
                label: 'Id_prestamo',
                type: 'number',
                isPrimary: true,
                required: false,
                sortable: true,
                showInTable: true
            }
,            {
                name: 'monto_solicitado',
                label: 'Monto_solicitado',
                type: 'decimal',
                isPrimary: false,
                required: true,
                sortable: true,
                showInTable: true
            }
,            {
                name: 'tasa_interes',
                label: 'Tasa_interes',
                type: 'decimal',
                isPrimary: false,
                required: true,
                sortable: true,
                showInTable: true
            }
,            {
                name: 'plazo_meses',
                label: 'Plazo_meses',
                type: 'number',
                isPrimary: false,
                required: true,
                sortable: true,
                showInTable: true
            }
,            {
                name: 'estado_prestamo',
                label: 'Estado_prestamo',
                type: 'text',
                isPrimary: false,
                required: true,
                sortable: true,
                showInTable: true
            }
,            {
                name: 'fecha_solicitud',
                label: 'Fecha_solicitud',
                type: 'date',
                isPrimary: false,
                required: true,
                sortable: true,
                showInTable: true
            }
,            {
                name: 'fecha_aprobacion',
                label: 'Fecha_aprobacion',
                type: 'date',
                isPrimary: false,
                required: true,
                sortable: true,
                showInTable: true
            }
,
            {
                name: 'cliente_solicitante_ID',
                label: 'Cliente_solicitante',
                type: 'reference',
                isPrimary: false,
                required: true,
                sortable: true,
                showInTable: true,
                referenceEntity: 'cliente'
            }
,            {
                name: 'empleado_aprobador_ID',
                label: 'Empleado_aprobador',
                type: 'reference',
                isPrimary: false,
                required: true,
                sortable: true,
                showInTable: true,
                referenceEntity: 'empleado'
            }
        ];
    }

    /**
     * Formatea valores específicos para Prestamo
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
     * Validaciones específicas para Prestamo
     */
    validateField(fieldName, value) {
        if (fieldName === 'id_prestamo') {
            const numValue = parseInt(value);
            if (isNaN(numValue) || numValue < 0) {
                return {
                    isValid: false,
                    message: 'Debe ser un número entero positivo'
                };
            }
        }
        if (fieldName === 'monto_solicitado') {
            const numValue = parseFloat(value);
            if (isNaN(numValue) || numValue < 0) {
                return {
                    isValid: false,
                    message: 'Debe ser un número positivo'
                };
            }
        }
        if (fieldName === 'tasa_interes') {
            const numValue = parseFloat(value);
            if (isNaN(numValue) || numValue < 0) {
                return {
                    isValid: false,
                    message: 'Debe ser un número positivo'
                };
            }
        }
        if (fieldName === 'plazo_meses') {
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
        // Acciones específicas para Prestamo después de cargar datos
        console.log(`Cargados ${entities.length} registros de Prestamo`);
    }

    /**
     * Preparar datos antes de enviar al servidor
     */
    prepareDataForSave(data) {
        // Transformaciones específicas para Prestamo antes de guardar
        if (data.hasOwnProperty('id_prestamo')) {
            data['id_prestamo'] = parseInt(data['id_prestamo']) || 0;
        }
        if (data.hasOwnProperty('monto_solicitado')) {
            data['monto_solicitado'] = parseFloat(data['monto_solicitado']) || 0;
        }
        if (data.hasOwnProperty('tasa_interes')) {
            data['tasa_interes'] = parseFloat(data['tasa_interes']) || 0;
        }
        if (data.hasOwnProperty('plazo_meses')) {
            data['plazo_meses'] = parseInt(data['plazo_meses']) || 0;
        }
        
        return data;
    }

    /**
     * Obtiene filtros personalizados específicos para Prestamo
     */
    getCustomFilters() {
        return {
            // Filtros específicos para Prestamo
        };
    }

    /**
     * Configuración de exportación para Prestamo
     */
    getExportConfig() {
        return {
            filename: 'prestamo_export',
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
    // Solo inicializar si estamos en una página de Prestamo
    const entityElement = document.querySelector('[data-entity="prestamo"]');
    if (entityElement) {
        window.entityManager = new PrestamoManager();
        window.crudManager = window.entityManager; // Alias para funciones globales
        window.entityManager.init();
    }
});

// Exportar la clase para uso en otros módulos
if (typeof module !== 'undefined' && module.exports) {
    module.exports = PrestamoManager;
}
