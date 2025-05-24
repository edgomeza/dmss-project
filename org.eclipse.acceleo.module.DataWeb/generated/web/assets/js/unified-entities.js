/**
 * GESTOR UNIFICADO DE ENTIDADES - Sistema Bancario Digital
 * Maneja CRUD para todas las entidades del sistema
 */

class UnifiedEntityManager {
    constructor(app) {
        this.app = app;
        this.db = app.db;
        this.currentEntity = null;
        this.currentPage = null;
        
        this.entityConfig = {
            'cliente': {
                name: 'Cliente',
                tableName: 'CLIENTES',
                primaryKey: 'id_cliente',
                fields: [
                    {
                        name: 'id_cliente',
                        type: 'INTEGER',
                        isPrimaryKey: true,
                        required: true
                    }
,                    {
                        name: 'dni',
                        type: 'STRING',
                        isPrimaryKey: false,
                        required: true
                    }
,                    {
                        name: 'nombre',
                        type: 'STRING',
                        isPrimaryKey: false,
                        required: true
                    }
,                    {
                        name: 'apellidos',
                        type: 'STRING',
                        isPrimaryKey: false,
                        required: true
                    }
,                    {
                        name: 'email',
                        type: 'STRING',
                        isPrimaryKey: false,
                        required: true
                    }
,                    {
                        name: 'telefono',
                        type: 'STRING',
                        isPrimaryKey: false,
                        required: true
                    }
,                    {
                        name: 'fecha_registro',
                        type: 'STRING',
                        isPrimaryKey: false,
                        required: true
                    }
,                    {
                        name: 'activo',
                        type: 'BOOLEAN',
                        isPrimaryKey: false,
                        required: true
                    }
                ]
            }
,            'cuenta': {
                name: 'Cuenta',
                tableName: 'CUENTAS',
                primaryKey: 'numero_cuenta',
                fields: [
                    {
                        name: 'numero_cuenta',
                        type: 'STRING',
                        isPrimaryKey: true,
                        required: true
                    }
,                    {
                        name: 'tipo_cuenta',
                        type: 'STRING',
                        isPrimaryKey: false,
                        required: true
                    }
,                    {
                        name: 'saldo',
                        type: 'DECIMAL',
                        isPrimaryKey: false,
                        required: true
                    }
,                    {
                        name: 'fecha_apertura',
                        type: 'STRING',
                        isPrimaryKey: false,
                        required: true
                    }
,                    {
                        name: 'activa',
                        type: 'BOOLEAN',
                        isPrimaryKey: false,
                        required: true
                    }
                ]
            }
,            'transaccion': {
                name: 'Transaccion',
                tableName: 'TRANSACCIONES',
                primaryKey: 'id_transaccion',
                fields: [
                    {
                        name: 'id_transaccion',
                        type: 'INTEGER',
                        isPrimaryKey: true,
                        required: true
                    }
,                    {
                        name: 'fecha_transaccion',
                        type: 'STRING',
                        isPrimaryKey: false,
                        required: true
                    }
,                    {
                        name: 'tipo_transaccion',
                        type: 'STRING',
                        isPrimaryKey: false,
                        required: true
                    }
,                    {
                        name: 'monto',
                        type: 'DECIMAL',
                        isPrimaryKey: false,
                        required: true
                    }
,                    {
                        name: 'descripcion',
                        type: 'STRING',
                        isPrimaryKey: false,
                        required: true
                    }
,                    {
                        name: 'estado',
                        type: 'STRING',
                        isPrimaryKey: false,
                        required: true
                    }
                ]
            }
,            'empleado': {
                name: 'Empleado',
                tableName: 'EMPLEADOS',
                primaryKey: 'id_empleado',
                fields: [
                    {
                        name: 'id_empleado',
                        type: 'INTEGER',
                        isPrimaryKey: true,
                        required: true
                    }
,                    {
                        name: 'codigo_empleado',
                        type: 'STRING',
                        isPrimaryKey: false,
                        required: true
                    }
,                    {
                        name: 'nombre',
                        type: 'STRING',
                        isPrimaryKey: false,
                        required: true
                    }
,                    {
                        name: 'puesto',
                        type: 'STRING',
                        isPrimaryKey: false,
                        required: true
                    }
,                    {
                        name: 'departamento',
                        type: 'STRING',
                        isPrimaryKey: false,
                        required: true
                    }
,                    {
                        name: 'email',
                        type: 'STRING',
                        isPrimaryKey: false,
                        required: true
                    }
,                    {
                        name: 'activo',
                        type: 'BOOLEAN',
                        isPrimaryKey: false,
                        required: true
                    }
                ]
            }
,            'prestamo': {
                name: 'Prestamo',
                tableName: 'PRESTAMOS',
                primaryKey: 'id_prestamo',
                fields: [
                    {
                        name: 'id_prestamo',
                        type: 'INTEGER',
                        isPrimaryKey: true,
                        required: true
                    }
,                    {
                        name: 'monto_solicitado',
                        type: 'DECIMAL',
                        isPrimaryKey: false,
                        required: true
                    }
,                    {
                        name: 'tasa_interes',
                        type: 'DECIMAL',
                        isPrimaryKey: false,
                        required: true
                    }
,                    {
                        name: 'plazo_meses',
                        type: 'INTEGER',
                        isPrimaryKey: false,
                        required: true
                    }
,                    {
                        name: 'estado_prestamo',
                        type: 'STRING',
                        isPrimaryKey: false,
                        required: true
                    }
,                    {
                        name: 'fecha_solicitud',
                        type: 'STRING',
                        isPrimaryKey: false,
                        required: true
                    }
,                    {
                        name: 'fecha_aprobacion',
                        type: 'STRING',
                        isPrimaryKey: false,
                        required: true
                    }
                ]
            }
,            'tarjetacredito': {
                name: 'TarjetaCredito',
                tableName: 'TARJETAS_CREDITO',
                primaryKey: 'numero_tarjeta',
                fields: [
                    {
                        name: 'numero_tarjeta',
                        type: 'STRING',
                        isPrimaryKey: true,
                        required: true
                    }
,                    {
                        name: 'limite_credito',
                        type: 'DECIMAL',
                        isPrimaryKey: false,
                        required: true
                    }
,                    {
                        name: 'saldo_actual',
                        type: 'DECIMAL',
                        isPrimaryKey: false,
                        required: true
                    }
,                    {
                        name: 'fecha_vencimiento',
                        type: 'STRING',
                        isPrimaryKey: false,
                        required: true
                    }
,                    {
                        name: 'activa',
                        type: 'BOOLEAN',
                        isPrimaryKey: false,
                        required: true
                    }
                ]
            }
        };
    }

    initPage(entityName, pageName, roleName) {
        this.currentEntity = entityName;
        this.currentPage = pageName;
        
        const config = this.entityConfig[entityName];
        if (!config) {
            console.error(`Entidad ${entityName} no encontrada`);
            return;
        }

        switch (pageName) {
            case 'index':
                this.initIndexPage(config);
                break;
            case 'list':
                this.initListPage(config);
                break;
            case 'create':
                this.initCreatePage(config);
                break;
            case 'edit':
                this.initEditPage(config);
                break;
            case 'detail':
                this.initDetailPage(config);
                break;
        }
    }

    async initIndexPage(config) {
        // Actualizar estadísticas si hay contenedores
        const statsContainer = document.querySelector('.stats-grid');
        if (statsContainer) {
            try {
                const data = await this.db.execute('getAll', config.tableName);
                const countElement = document.querySelector('.stat-number');
                if (countElement) {
                    countElement.textContent = data.length;
                }
            } catch (error) {
                console.error('Error cargando estadísticas:', error);
            }
        }
    }

    async initListPage(config) {
        const tableBody = document.getElementById('tableBody');
        if (!tableBody) return;

        try {
            const data = await this.db.execute('getAll', config.tableName);
            
            if (data.length === 0) {
                tableBody.innerHTML = '<tr><td colspan="100%" class="text-center">No hay datos disponibles</td></tr>';
                return;
            }

            tableBody.innerHTML = data.map(item => `
                <tr>
                    ${config.fields.map(field => 
                        `<td>${this.formatFieldValue(item[field.name], field.type)}</td>`
                    ).join('')}
                    <td>
                        <a href="detail.html?id=${item[config.primaryKey]}" class="btn btn-info btn-sm">Ver</a>
                        <a href="edit.html?id=${item[config.primaryKey]}" class="btn btn-warning btn-sm">Editar</a>
                        <button class="btn btn-danger btn-sm delete-btn" 
                                data-entity="${config.tableName}" 
                                data-id="${item[config.primaryKey]}"
                                data-confirm="¿Seguro que deseas eliminar este ${config.name}?">
                            Eliminar
                        </button>
                    </td>
                </tr>
            `).join('');
        } catch (error) {
            console.error('Error cargando lista:', error);
            tableBody.innerHTML = '<tr><td colspan="100%" class="text-center error">Error cargando datos</td></tr>';
        }
    }

    initCreatePage(config) {
        const form = document.getElementById('createForm');
        if (!form) return;

        form.classList.add('unified-form');
        form.dataset.type = 'entity-create';
        form.dataset.entity = config.tableName;
    }

    async initEditPage(config) {
        const form = document.getElementById('editForm');
        const loadingElement = document.getElementById('loadingForm');
        
        if (!form) return;

        const urlParams = new URLSearchParams(window.location.search);
        const id = urlParams.get('id');
        
        if (!id) {
            this.app.ui.showAlert('ID no proporcionado', 'danger');
            return;
        }

        try {
            const parsedId = this.parseIdValue(id, config.fields.find(f => f.isPrimaryKey).type);
            const item = await this.db.execute('get', config.tableName, null, parsedId);
            
            if (!item) {
                this.app.ui.showAlert('Elemento no encontrado', 'danger');
                return;
            }

            // Rellenar formulario
            config.fields.forEach(field => {
                const input = form.querySelector(`[name="${field.name}"]`);
                if (input && item[field.name] !== undefined) {
                    if (input.type === 'checkbox') {
                        input.checked = Boolean(item[field.name]);
                    } else {
                        input.value = item[field.name];
                    }
                }
            });

            form.classList.add('unified-form');
            form.dataset.type = 'entity-update';
            form.dataset.entity = config.tableName;
            form.dataset.id = id;

            if (loadingElement) loadingElement.style.display = 'none';
            form.style.display = 'block';

        } catch (error) {
            console.error('Error cargando datos para edición:', error);
            this.app.ui.showAlert('Error cargando datos', 'danger');
        }
    }

    async initDetailPage(config) {
        const detailContent = document.getElementById('detailContent');
        const loadingElement = document.getElementById('loadingDetails');
        
        if (!detailContent) return;

        const urlParams = new URLSearchParams(window.location.search);
        const id = urlParams.get('id');
        
        if (!id) {
            this.app.ui.showAlert('ID no proporcionado', 'danger');
            return;
        }

        try {
            const parsedId = this.parseIdValue(id, config.fields.find(f => f.isPrimaryKey).type);
            const item = await this.db.execute('get', config.tableName, null, parsedId);
            
            if (!item) {
                this.app.ui.showAlert('Elemento no encontrado', 'danger');
                return;
            }

            // Rellenar campos de detalle
            config.fields.forEach(field => {
                const element = document.getElementById(`field_${field.name}`);
                if (element) {
                    element.textContent = this.formatFieldValue(item[field.name], field.type);
                }
            });

            // Actualizar enlaces
            const editLink = document.getElementById('editLink');
            if (editLink) {
                editLink.href = `edit.html?id=${id}`;
            }

            // Configurar botón de eliminar
            const deleteBtn = document.getElementById('confirmDeleteBtn');
            if (deleteBtn) {
                deleteBtn.classList.add('delete-btn');
                deleteBtn.dataset.entity = config.tableName;
                deleteBtn.dataset.id = id;
                deleteBtn.dataset.confirm = `¿Seguro que deseas eliminar este ${config.name}?`;
            }

            if (loadingElement) loadingElement.style.display = 'none';
            detailContent.style.display = 'block';

        } catch (error) {
            console.error('Error cargando detalles:', error);
            this.app.ui.showAlert('Error cargando detalles', 'danger');
        }
    }

    async handleForm(formType, entityTableName, formData) {
        const config = Object.values(this.entityConfig).find(c => c.tableName === entityTableName);
        if (!config) {
            throw new Error(`Configuración no encontrada para ${entityTableName}`);
        }

        const data = {};
        
        // Extraer datos del formulario
        config.fields.forEach(field => {
            if (!field.isPrimaryKey || formType === 'entity-update') {
                const value = formData.get(field.name);
                if (value !== null) {
                    data[field.name] = this.parseFieldValue(value, field.type);
                }
            }
        });

        try {
            let result;
            
            if (formType === 'entity-create') {
                result = await this.db.execute('create', config.tableName, data);
                return {
                    success: true,
                    message: `${config.name} creado correctamente`,
                    redirect: 'list.html'
                };
            } else if (formType === 'entity-update') {
                const form = document.querySelector(`[data-entity="${entityTableName}"]`);
                const id = form.dataset.id;
                const parsedId = this.parseIdValue(id, config.fields.find(f => f.isPrimaryKey).type);
                data[config.primaryKey] = parsedId;
                
                result = await this.db.execute('update', config.tableName, data);
                return {
                    success: true,
                    message: `${config.name} actualizado correctamente`,
                    redirect: 'list.html'
                };
            }
        } catch (error) {
            console.error('Error en operación de entidad:', error);
            return {
                success: false,
                message: `Error al ${formType === 'entity-create' ? 'crear' : 'actualizar'} ${config.name}`
            };
        }
    }

    async deleteItem(entityTableName, itemId) {
        const config = Object.values(this.entityConfig).find(c => c.tableName === entityTableName);
        if (!config) {
            throw new Error(`Configuración no encontrada para ${entityTableName}`);
        }

        try {
            const parsedId = this.parseIdValue(itemId, config.fields.find(f => f.isPrimaryKey).type);
            await this.db.execute('delete', config.tableName, null, parsedId);
            return {
                success: true,
                message: `${config.name} eliminado correctamente`,
                reload: true
            };
        } catch (error) {
            console.error('Error eliminando entidad:', error);
            return {
                success: false,
                message: `Error al eliminar ${config.name}`
            };
        }
    }

    formatFieldValue(value, type) {
        if (value === null || value === undefined) return '-';
        
        switch (type) {
            case 'BOOLEAN':
                return value ? 'Sí' : 'No';
            case 'DECIMAL':
                return parseFloat(value).toFixed(2);
            case 'INTEGER':
                return parseInt(value).toLocaleString();
            default:
                return String(value);
        }
    }

    parseFieldValue(value, type) {
        switch (type) {
            case 'BOOLEAN':
                return value === 'true' || value === true;
            case 'INTEGER':
                return parseInt(value) || 0;
            case 'DECIMAL':
                return parseFloat(value) || 0.0;
            default:
                return String(value);
        }
    }
    
    parseIdValue(value, type) {
        switch (type) {
            case 'INTEGER':
                return parseInt(value);
            case 'DECIMAL':
                return parseFloat(value);
            case 'BOOLEAN':
                return value === 'true' || value === true;
            default:
                return String(value);
        }
    }
}

// Hacer disponible globalmente
window.UnifiedEntityManager = UnifiedEntityManager;
