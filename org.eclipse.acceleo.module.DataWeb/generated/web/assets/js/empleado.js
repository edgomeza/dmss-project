/**
 * Gestor específico para la entidad Empleado
 */

class EmpleadoManager {
    constructor() {
        this.entityName = 'empleado';
        this.tableName = 'EMPLEADOS';
        this.primaryKey = 'id_empleado';
        this.db = null;
        this.init();
    }

    async init() {
        try {
            this.db = await this.initDB();
            this.setupEventHandlers();
            console.log(`✅ ${this.entityName} Manager inicializado`);
        } catch (error) {
            console.error(`❌ Error inicializando ${this.entityName} Manager:`, error);
        }
    }

    async initDB() {
        // Capturar variables locales para uso en funciones anidadas
        const tableName = this.tableName;
        const primaryKey = this.primaryKey;
        const self = this;
        
        return new Promise((resolve, reject) => {
            const request = indexedDB.open('Sistema_Bancario Digital_DB', 2);
            
            request.onsuccess = () => {
                const db = request.result;
                resolve({
                    db: db,
                    async create(data) {
                        try {
                            const transaction = db.transaction(tableName, 'readwrite');
                            const store = transaction.objectStore(tableName);
                            return new Promise((resolve, reject) => {
                                const request = store.add(data);
                                request.onsuccess = () => resolve(request.result);
                                request.onerror = () => reject(request.error);
                            });
                        } catch (error) {
                            console.error('Error en create:', error);
                            throw error;
                        }
                    },
                    async getAll() {
                        try {
                            const transaction = db.transaction(tableName, 'readonly');
                            const store = transaction.objectStore(tableName);
                            return new Promise((resolve, reject) => {
                                const request = store.getAll();
                                request.onsuccess = () => resolve(request.result || []);
                                request.onerror = () => reject(request.error);
                            });
                        } catch (error) {
                            console.error('Error en getAll:', error);
                            return [];
                        }
                    },
                    async get(id) {
                        try {
                            const transaction = db.transaction(tableName, 'readonly');
                            const store = transaction.objectStore(tableName);
                            return new Promise((resolve, reject) => {
                                const request = store.get(id);
                                request.onsuccess = () => resolve(request.result);
                                request.onerror = () => reject(request.error);
                            });
                        } catch (error) {
                            console.error('Error en get:', error);
                            return null;
                        }
                    },
                    async update(data) {
                        try {
                            const transaction = db.transaction(tableName, 'readwrite');
                            const store = transaction.objectStore(tableName);
                            return new Promise((resolve, reject) => {
                                const request = store.put(data);
                                request.onsuccess = () => resolve(request.result);
                                request.onerror = () => reject(request.error);
                            });
                        } catch (error) {
                            console.error('Error en update:', error);
                            throw error;
                        }
                    },
                    async delete(id) {
                        try {
                            const transaction = db.transaction(tableName, 'readwrite');
                            const store = transaction.objectStore(tableName);
                            return new Promise((resolve, reject) => {
                                const request = store.delete(id);
                                request.onsuccess = () => resolve(request.result);
                                request.onerror = () => reject(request.error);
                            });
                        } catch (error) {
                            console.error('Error en delete:', error);
                            throw error;
                        }
                    }
                });
            };
            
            request.onerror = () => reject(request.error);
            
            request.onupgradeneeded = (event) => {
                const db = event.target.result;
                if (!db.objectStoreNames.contains(tableName)) {
                    const store = db.createObjectStore(tableName, { 
                        keyPath: primaryKey, 
                        autoIncrement: true
                    });
                    
                    // Añadir datos de ejemplo después de crear el store
                    store.transaction.oncomplete = () => {
                        self.seedData(db);
                    };
                }
            };
        });
    }

    seedData(db) {
        try {
            const transaction = db.transaction(this.tableName, 'readwrite');
            const store = transaction.objectStore(this.tableName);
            
            // Crear 3 registros de ejemplo
            for (let i = 1; i <= 3; i++) {
                const data = {
                    codigo_empleado: `Empleado ${i}`,
                    nombre: `Empleado ${i}`,
                    puesto: `Empleado ${i}`,
                    departamento: `Empleado ${i}`,
                    email: `Empleado ${i}`,
                    activo: Math.random() > 0.5
                };
                
                
                store.add(data);
            }
            
            console.log(`📊 Datos de ejemplo creados para ${this.entityName}`);
        } catch (error) {
            console.error(`Error creando datos de ejemplo para ${this.entityName}:`, error);
        }
    }

    setupEventHandlers() {
        // Formulario de creación
        const createForm = document.getElementById('createForm');
        if (createForm) {
            createForm.addEventListener('submit', (e) => {
                e.preventDefault();
                this.createEntity();
            });
        }

        // Formulario de edición
        const editForm = document.getElementById('editForm');
        if (editForm) {
            editForm.addEventListener('submit', (e) => {
                e.preventDefault();
                this.updateEntity();
            });
            this.loadEntityForEdit();
        }

        // Tabla de listado
        const table = document.getElementById('empleadoTable');
        if (table) {
            this.loadTableData();
        }

        // Página de detalles
        const detailContent = document.getElementById('detailContent');
        if (detailContent) {
            this.loadEntityDetails();
        }
    }

    async createEntity() {
        const form = document.getElementById('createForm');
        const formData = new FormData(form);
        const data = Object.fromEntries(formData);
        
        // Convertir tipos de datos
        data.activo = data.activo === 'true' || data.activo === true;
        
        try {
            await this.db.create(data);
            this.showMessage('Empleado creado correctamente', 'success');
            setTimeout(() => {
                window.location.href = 'list.html';
            }, 1500);
        } catch (error) {
            console.error('Error creating entity:', error);
            this.showMessage('Error al crear Empleado', 'error');
        }
    }

    async updateEntity() {
        const form = document.getElementById('editForm');
        const formData = new FormData(form);
        const data = Object.fromEntries(formData);
        
        // Convertir tipos de datos
        if (data.id_empleado) data.id_empleado = parseInt(data.id_empleado) || 0;
        data.activo = data.activo === 'true' || data.activo === true;
        
        try {
            await this.db.update(data);
            this.showMessage('Empleado actualizado correctamente', 'success');
            setTimeout(() => {
                window.location.href = 'list.html';
            }, 1500);
        } catch (error) {
            console.error('Error updating entity:', error);
            this.showMessage('Error al actualizar Empleado', 'error');
        }
    }

    async loadTableData() {
        try {
            const entities = await this.db.getAll();
            const tbody = document.getElementById('tableBody');
            
            if (!tbody) {
                console.warn('No se encontró elemento tableBody');
                return;
            }
            
            if (entities.length === 0) {
                tbody.innerHTML = '<tr><td colspan="8" class="text-center">No hay datos disponibles</td></tr>';
                return;
            }
            
            tbody.innerHTML = entities.map(entity => `
                <tr>
                    <td>${this.formatValue(entity.id_empleado, 'INTEGER')}</td>
                    <td>${this.formatValue(entity.codigo_empleado, 'STRING')}</td>
                    <td>${this.formatValue(entity.nombre, 'STRING')}</td>
                    <td>${this.formatValue(entity.puesto, 'STRING')}</td>
                    <td>${this.formatValue(entity.departamento, 'STRING')}</td>
                    <td>${this.formatValue(entity.email, 'STRING')}</td>
                    <td>${this.formatValue(entity.activo, 'BOOLEAN')}</td>
                    <td>
                        <a href="detail.html?id=${entity[this.primaryKey]}" class="btn btn-info btn-sm">Ver</a>
                        <a href="edit.html?id=${entity[this.primaryKey]}" class="btn btn-warning btn-sm">Editar</a>
                        <button onclick="window.entityManager.deleteEntity('${entity[this.primaryKey]}')" class="btn btn-danger btn-sm">Eliminar</button>
                    </td>
                </tr>
            `).join('');
        } catch (error) {
            console.error('Error loading table data:', error);
            const tbody = document.getElementById('tableBody');
            if (tbody) {
                tbody.innerHTML = '<tr><td colspan="8" class="text-center error-message">Error cargando datos</td></tr>';
            }
        }
    }

    async loadEntityForEdit() {
        const urlParams = new URLSearchParams(window.location.search);
        const id = urlParams.get('id');
        
        if (!id) return;
        
        try {
            const entity = await this.db.get(parseInt(id));
            
            if (entity) {
                const field_id_empleado = document.getElementById('id_empleado');
                if (field_id_empleado) {
                    field_id_empleado.value = entity.id_empleado || '';
                }
                const field_codigo_empleado = document.getElementById('codigo_empleado');
                if (field_codigo_empleado) {
                    field_codigo_empleado.value = entity.codigo_empleado || '';
                }
                const field_nombre = document.getElementById('nombre');
                if (field_nombre) {
                    field_nombre.value = entity.nombre || '';
                }
                const field_puesto = document.getElementById('puesto');
                if (field_puesto) {
                    field_puesto.value = entity.puesto || '';
                }
                const field_departamento = document.getElementById('departamento');
                if (field_departamento) {
                    field_departamento.value = entity.departamento || '';
                }
                const field_email = document.getElementById('email');
                if (field_email) {
                    field_email.value = entity.email || '';
                }
                const field_activo = document.getElementById('activo');
                if (field_activo) {
                    field_activo.checked = Boolean(entity.activo);
                }
                
                const loadingForm = document.getElementById('loadingForm');
                const editForm = document.getElementById('editForm');
                
                if (loadingForm) loadingForm.style.display = 'none';
                if (editForm) editForm.style.display = 'block';
            } else {
                this.showMessage('Elemento no encontrado', 'error');
            }
        } catch (error) {
            console.error('Error loading entity for edit:', error);
            this.showMessage('Error cargando datos para edición', 'error');
        }
    }

    async loadEntityDetails() {
        const urlParams = new URLSearchParams(window.location.search);
        const id = urlParams.get('id');
        
        if (!id) return;
        
        try {
            const entity = await this.db.get(parseInt(id));
            
            if (entity) {
                const field_id_empleado = document.getElementById('field_id_empleado');
                if (field_id_empleado) {
                    field_id_empleado.textContent = this.formatValue(entity.id_empleado, 'INTEGER');
                }
                const field_codigo_empleado = document.getElementById('field_codigo_empleado');
                if (field_codigo_empleado) {
                    field_codigo_empleado.textContent = this.formatValue(entity.codigo_empleado, 'STRING');
                }
                const field_nombre = document.getElementById('field_nombre');
                if (field_nombre) {
                    field_nombre.textContent = this.formatValue(entity.nombre, 'STRING');
                }
                const field_puesto = document.getElementById('field_puesto');
                if (field_puesto) {
                    field_puesto.textContent = this.formatValue(entity.puesto, 'STRING');
                }
                const field_departamento = document.getElementById('field_departamento');
                if (field_departamento) {
                    field_departamento.textContent = this.formatValue(entity.departamento, 'STRING');
                }
                const field_email = document.getElementById('field_email');
                if (field_email) {
                    field_email.textContent = this.formatValue(entity.email, 'STRING');
                }
                const field_activo = document.getElementById('field_activo');
                if (field_activo) {
                    field_activo.textContent = this.formatValue(entity.activo, 'BOOLEAN');
                }
                
                const editLink = document.getElementById('editLink');
                if (editLink) {
                    editLink.href = `edit.html?id=${id}`;
                }
                
                const loadingDetails = document.getElementById('loadingDetails');
                const detailContent = document.getElementById('detailContent');
                
                if (loadingDetails) loadingDetails.style.display = 'none';
                if (detailContent) detailContent.style.display = 'block';
            } else {
                this.showMessage('Elemento no encontrado', 'error');
            }
        } catch (error) {
            console.error('Error loading entity details:', error);
            this.showMessage('Error cargando detalles', 'error');
        }
    }

    async deleteEntity(id) {
        if (!confirm('¿Seguro que deseas eliminar este registro?')) return;
        
        try {
            await this.db.delete(parseInt(id));
            this.showMessage('Empleado eliminado correctamente', 'success');
            this.loadTableData();
        } catch (error) {
            console.error('Error deleting entity:', error);
            this.showMessage('Error al eliminar Empleado', 'error');
        }
    }
    
    formatValue(value, type) {
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
    
    showMessage(message, type = 'info') {
        // Crear o actualizar el contenedor de mensajes
        let messageContainer = document.getElementById('messageContainer');
        if (!messageContainer) {
            messageContainer = document.createElement('div');
            messageContainer.id = 'messageContainer';
            messageContainer.style.cssText = `
                position: fixed;
                top: 20px;
                right: 20px;
                z-index: 9999;
                max-width: 400px;
            `;
            document.body.appendChild(messageContainer);
        }
        
        const alertDiv = document.createElement('div');
        alertDiv.className = `alert alert-${type === 'error' ? 'danger' : type}`;
        alertDiv.style.cssText = `
            padding: 12px 16px;
            margin-bottom: 10px;
            border-radius: 4px;
            color: white;
            background-color: ${type === 'success' ? '#16a34a' : type === 'error' ? '#dc2626' : '#2563eb'};
        `;
        alertDiv.textContent = message;
        
        messageContainer.appendChild(alertDiv);
        
        // Auto-remove después de 3 segundos
        setTimeout(() => {
            if (alertDiv.parentNode) {
                alertDiv.remove();
            }
        }, 3000);
    }
}

// Funciones globales para compatibilidad
window.deleteEntity = function(id) {
    if (window.entityManager) {
        window.entityManager.deleteEntity(id);
    }
};

window.confirmDelete = function() {
    const modal = document.getElementById('deleteModal');
    if (modal) {
        modal.style.display = 'block';
    }
};

window.closeDeleteModal = function() {
    const modal = document.getElementById('deleteModal');
    if (modal) {
        modal.style.display = 'none';
    }
};

// Inicializar cuando el DOM esté listo
document.addEventListener('DOMContentLoaded', function() {
    window.entityManager = new EmpleadoManager();
});
