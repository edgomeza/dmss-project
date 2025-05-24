/**
 * Gestor específico para la entidad Prestamo
 */

class PrestamoManager {
    constructor() {
        this.entityName = 'prestamo';
        this.init();
    }

    async init() {
        this.db = await this.initDB();
        this.setupEventHandlers();
    }

    async initDB() {
        return new Promise((resolve, reject) => {
            const request = indexedDB.open('DataWeb_DB', 2);
            
            request.onsuccess = () => {
                const db = request.result;
                resolve({
                    db: db,
                    async create(data) {
                        const transaction = db.transaction([[entidad.nombre.toUpperCase()]], 'readwrite');
                        const store = transaction.objectStore('PRESTAMO');
                        return store.add(data);
                    },
                    async getAll() {
                        const transaction = db.transaction([[entidad.nombre.toUpperCase()]], 'readonly');
                        const store = transaction.objectStore('PRESTAMO');
                        return store.getAll();
                    },
                    async update(data) {
                        const transaction = db.transaction([[entidad.nombre.toUpperCase()]], 'readwrite');
                        const store = transaction.objectStore('PRESTAMO');
                        return store.put(data);
                    },
                    async delete(id) {
                        const transaction = db.transaction([[entidad.nombre.toUpperCase()]], 'readwrite');
                        const store = transaction.objectStore('PRESTAMO');
                        return store.delete(id);
                    }
                });
            };
            
            request.onerror = () => reject(request.error);
            
            request.onupgradeneeded = (event) => {
                const db = event.target.result;
                if (!db.objectStoreNames.contains('PRESTAMO')) {
                    db.createObjectStore('PRESTAMO', { 
                        keyPath: 'id_prestamo', 
                        autoIncrement: true 
                    });
                }
            };
        });
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
        
        try {
            await this.db.create(data);
            alert('Prestamo creado correctamente');
            window.location.href = 'list.html';
        } catch (error) {
            console.error('Error creating entity:', error);
            alert('Error al crear Prestamo');
        }
    }

    async updateEntity() {
        const form = document.getElementById('editForm');
        const formData = new FormData(form);
        const data = Object.fromEntries(formData);
        
        try {
            await this.db.update(data);
            alert('Prestamo actualizado correctamente');
            window.location.href = 'list.html';
        } catch (error) {
            console.error('Error updating entity:', error);
            alert('Error al actualizar Prestamo');
        }
    }

    async loadTableData() {
        try {
            const entities = await this.db.getAll();
            const tbody = document.getElementById('tableBody');
            
            tbody.innerHTML = entities.map(entity => `
                <tr>
                    <td>${entity[id_prestamo'] || '-'}</td>
                    <td>${entity[fechaPrestamo'] || '-'}</td>
                    <td>${entity[fechaDevolucion'] || '-'}</td>
                    <td>
                        <a href="detail.html?id=${entity[id_prestamo']}" class="btn btn-info btn-sm">Ver</a>
                        <a href="edit.html?id=${entity[id_prestamo']}" class="btn btn-warning btn-sm">Editar</a>
                        <button onclick="deleteEntity(${entity[id_prestamo']})" class="btn btn-danger btn-sm">Eliminar</button>
                    </td>
                </tr>
            `).join('');
        } catch (error) {
            console.error('Error loading table data:', error);
        }
    }

    async loadEntityForEdit() {
        const urlParams = new URLSearchParams(window.location.search);
        const id = urlParams.get('id');
        
        if (!id) return;
        
        try {
            const entities = await this.db.getAll();
            const entity = entities.find(e => e[id_prestamo'] == id);
            
            if (entity) {
                const field_id_prestamo = document.getElementById('id_prestamo');
                if (field_id_prestamo) {
                    field_id_prestamo.value = entity[id_prestamo'] || '';
                }
                const field_fechaPrestamo = document.getElementById('fechaPrestamo');
                if (field_fechaPrestamo) {
                    field_fechaPrestamo.value = entity[fechaPrestamo'] || '';
                }
                const field_fechaDevolucion = document.getElementById('fechaDevolucion');
                if (field_fechaDevolucion) {
                    field_fechaDevolucion.value = entity[fechaDevolucion'] || '';
                }
                
                document.getElementById('loadingForm').style.display = 'none';
                document.getElementById('editForm').style.display = 'block';
            }
        } catch (error) {
            console.error('Error loading entity for edit:', error);
        }
    }

    async loadEntityDetails() {
        const urlParams = new URLSearchParams(window.location.search);
        const id = urlParams.get('id');
        
        if (!id) return;
        
        try {
            const entities = await this.db.getAll();
            const entity = entities.find(e => e[id_prestamo'] == id);
            
            if (entity) {
                const field_id_prestamo = document.getElementById('field_id_prestamo');
                if (field_id_prestamo) {
                    field_id_prestamo.textContent = entity[id_prestamo'] || '-';
                }
                const field_fechaPrestamo = document.getElementById('field_fechaPrestamo');
                if (field_fechaPrestamo) {
                    field_fechaPrestamo.textContent = entity[fechaPrestamo'] || '-';
                }
                const field_fechaDevolucion = document.getElementById('field_fechaDevolucion');
                if (field_fechaDevolucion) {
                    field_fechaDevolucion.textContent = entity[fechaDevolucion'] || '-';
                }
                
                document.getElementById('editLink').href = `edit.html?id=${id}`;
                document.getElementById('loadingDetails').style.display = 'none';
                document.getElementById('detailContent').style.display = 'block';
            }
        } catch (error) {
            console.error('Error loading entity details:', error);
        }
    }

    async deleteEntity(id) {
        if (!confirm('¿Seguro que deseas eliminar este registro?')) return;
        
        try {
            await this.db.delete(parseInt(id));
            alert('Prestamo eliminado correctamente');
            this.loadTableData();
        } catch (error) {
            console.error('Error deleting entity:', error);
            alert('Error al eliminar Prestamo');
        }
    }
}

// Funciones globales
window.deleteEntity = function(id) {
    if (window.entityManager) {
        window.entityManager.deleteEntity(id);
    }
};

window.confirmDelete = function() {
    document.getElementById('deleteModal').style.display = 'block';
};

window.closeDeleteModal = function() {
    document.getElementById('deleteModal').style.display = 'none';
};

// Inicializar cuando el DOM esté listo
document.addEventListener('DOMContentLoaded', function() {
    window.entityManager = new PrestamoManager();
});
