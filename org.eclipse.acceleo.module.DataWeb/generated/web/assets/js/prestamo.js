/**
 * Gestor específico para la entidad Prestamo
 */

class PrestamoManager {
    constructor() {
        this.entityName = 'prestamo';
        this.tableName = 'PRESTAMOS';
        this.primaryKey = 'id_prestamo';
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
                    monto_solicitado: Math.round(Math.random() * 1000 * 100) / 100,
                    tasa_interes: Math.round(Math.random() * 1000 * 100) / 100,
                    plazo_meses: Math.floor(Math.random() * 100) + 1,
                    estado_prestamo: `Prestamo ${i}`,
                    fecha_solicitud: `Prestamo ${i}`,
                    fecha_aprobacion: `Prestamo ${i}`
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
        const table = document.getElementById('prestamoTable');
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
        if (data.monto_solicitado) data.monto_solicitado = parseFloat(data.monto_solicitado) || 0.0;
        if (data.tasa_interes) data.tasa_interes = parseFloat(data.tasa_interes) || 0.0;
        if (data.plazo_meses) data.plazo_meses = parseInt(data.plazo_meses) || 0;
        
        try {
            await this.db.create(data);
            this.showMessage('Prestamo creado correctamente', 'success');
            setTimeout(() => {
                window.location.href = 'list.html';
            }, 1500);
        } catch (error) {
            console.error('Error creating entity:', error);
            this.showMessage('Error al crear Prestamo', 'error');
        }
    }

    async updateEntity() {
        const form = document.getElementById('editForm');
        const formData = new FormData(form);
        const data = Object.fromEntries(formData);
        
        // Convertir tipos de datos
        if (data.id_prestamo) data.id_prestamo = parseInt(data.id_prestamo) || 0;
        if (data.monto_solicitado) data.monto_solicitado = parseFloat(data.monto_solicitado) || 0.0;
        if (data.tasa_interes) data.tasa_interes = parseFloat(data.tasa_interes) || 0.0;
        if (data.plazo_meses) data.plazo_meses = parseInt(data.plazo_meses) || 0;
        
        try {
            await this.db.update(data);
            this.showMessage('Prestamo actualizado correctamente', 'success');
            setTimeout(() => {
                window.location.href = 'list.html';
            }, 1500);
        } catch (error) {
            console.error('Error updating entity:', error);
            this.showMessage('Error al actualizar Prestamo', 'error');
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
                    <td>${this.formatValue(entity.id_prestamo, 'INTEGER')}</td>
                    <td>${this.formatValue(entity.monto_solicitado, 'DECIMAL')}</td>
                    <td>${this.formatValue(entity.tasa_interes, 'DECIMAL')}</td>
                    <td>${this.formatValue(entity.plazo_meses, 'INTEGER')}</td>
                    <td>${this.formatValue(entity.estado_prestamo, 'STRING')}</td>
                    <td>${this.formatValue(entity.fecha_solicitud, 'STRING')}</td>
                    <td>${this.formatValue(entity.fecha_aprobacion, 'STRING')}</td>
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
                const field_id_prestamo = document.getElementById('id_prestamo');
                if (field_id_prestamo) {
                    field_id_prestamo.value = entity.id_prestamo || '';
                }
                const field_monto_solicitado = document.getElementById('monto_solicitado');
                if (field_monto_solicitado) {
                    field_monto_solicitado.value = entity.monto_solicitado || '';
                }
                const field_tasa_interes = document.getElementById('tasa_interes');
                if (field_tasa_interes) {
                    field_tasa_interes.value = entity.tasa_interes || '';
                }
                const field_plazo_meses = document.getElementById('plazo_meses');
                if (field_plazo_meses) {
                    field_plazo_meses.value = entity.plazo_meses || '';
                }
                const field_estado_prestamo = document.getElementById('estado_prestamo');
                if (field_estado_prestamo) {
                    field_estado_prestamo.value = entity.estado_prestamo || '';
                }
                const field_fecha_solicitud = document.getElementById('fecha_solicitud');
                if (field_fecha_solicitud) {
                    field_fecha_solicitud.value = entity.fecha_solicitud || '';
                }
                const field_fecha_aprobacion = document.getElementById('fecha_aprobacion');
                if (field_fecha_aprobacion) {
                    field_fecha_aprobacion.value = entity.fecha_aprobacion || '';
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
                const field_id_prestamo = document.getElementById('field_id_prestamo');
                if (field_id_prestamo) {
                    field_id_prestamo.textContent = this.formatValue(entity.id_prestamo, 'INTEGER');
                }
                const field_monto_solicitado = document.getElementById('field_monto_solicitado');
                if (field_monto_solicitado) {
                    field_monto_solicitado.textContent = this.formatValue(entity.monto_solicitado, 'DECIMAL');
                }
                const field_tasa_interes = document.getElementById('field_tasa_interes');
                if (field_tasa_interes) {
                    field_tasa_interes.textContent = this.formatValue(entity.tasa_interes, 'DECIMAL');
                }
                const field_plazo_meses = document.getElementById('field_plazo_meses');
                if (field_plazo_meses) {
                    field_plazo_meses.textContent = this.formatValue(entity.plazo_meses, 'INTEGER');
                }
                const field_estado_prestamo = document.getElementById('field_estado_prestamo');
                if (field_estado_prestamo) {
                    field_estado_prestamo.textContent = this.formatValue(entity.estado_prestamo, 'STRING');
                }
                const field_fecha_solicitud = document.getElementById('field_fecha_solicitud');
                if (field_fecha_solicitud) {
                    field_fecha_solicitud.textContent = this.formatValue(entity.fecha_solicitud, 'STRING');
                }
                const field_fecha_aprobacion = document.getElementById('field_fecha_aprobacion');
                if (field_fecha_aprobacion) {
                    field_fecha_aprobacion.textContent = this.formatValue(entity.fecha_aprobacion, 'STRING');
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
            this.showMessage('Prestamo eliminado correctamente', 'success');
            this.loadTableData();
        } catch (error) {
            console.error('Error deleting entity:', error);
            this.showMessage('Error al eliminar Prestamo', 'error');
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
    window.entityManager = new PrestamoManager();
});
