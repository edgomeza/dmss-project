/**
 * Gestor específico para la entidad Usuario
 */

class UsuarioManager {
    constructor() {
        this.entityName = 'usuario';
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
                        const store = transaction.objectStore('USUARIO');
                        return store.add(data);
                    },
                    async getAll() {
                        const transaction = db.transaction([[entidad.nombre.toUpperCase()]], 'readonly');
                        const store = transaction.objectStore('USUARIO');
                        return store.getAll();
                    },
                    async update(data) {
                        const transaction = db.transaction([[entidad.nombre.toUpperCase()]], 'readwrite');
                        const store = transaction.objectStore('USUARIO');
                        return store.put(data);
                    },
                    async delete(id) {
                        const transaction = db.transaction([[entidad.nombre.toUpperCase()]], 'readwrite');
                        const store = transaction.objectStore('USUARIO');
                        return store.delete(id);
                    }
                });
            };
            
            request.onerror = () => reject(request.error);
            
            request.onupgradeneeded = (event) => {
                const db = event.target.result;
                if (!db.objectStoreNames.contains('USUARIO')) {
                    db.createObjectStore('USUARIO', { 
                        keyPath: 'id_usuario', 
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
        const table = document.getElementById('usuarioTable');
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
            alert('Usuario creado correctamente');
            window.location.href = 'list.html';
        } catch (error) {
            console.error('Error creating entity:', error);
            alert('Error al crear Usuario');
        }
    }

    async updateEntity() {
        const form = document.getElementById('editForm');
        const formData = new FormData(form);
        const data = Object.fromEntries(formData);
        
        try {
            await this.db.update(data);
            alert('Usuario actualizado correctamente');
            window.location.href = 'list.html';
        } catch (error) {
            console.error('Error updating entity:', error);
            alert('Error al actualizar Usuario');
        }
    }

    async loadTableData() {
        try {
            const entities = await this.db.getAll();
            const tbody = document.getElementById('tableBody');
            
            tbody.innerHTML = entities.map(entity => `
                <tr>
                    <td>${entity[id_usuario'] || '-'}</td>
                    <td>${entity[nombre_usuario'] || '-'}</td>
                    <td>${entity[email'] || '-'}</td>
                    <td>${entity[activo'] || '-'}</td>
                    <td>
                        <a href="detail.html?id=${entity[id_usuario']}" class="btn btn-info btn-sm">Ver</a>
                        <a href="edit.html?id=${entity[id_usuario']}" class="btn btn-warning btn-sm">Editar</a>
                        <button onclick="deleteEntity(${entity[id_usuario']})" class="btn btn-danger btn-sm">Eliminar</button>
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
            const entity = entities.find(e => e[id_usuario'] == id);
            
            if (entity) {
                const field_id_usuario = document.getElementById('id_usuario');
                if (field_id_usuario) {
                    field_id_usuario.value = entity[id_usuario'] || '';
                }
                const field_nombre_usuario = document.getElementById('nombre_usuario');
                if (field_nombre_usuario) {
                    field_nombre_usuario.value = entity[nombre_usuario'] || '';
                }
                const field_email = document.getElementById('email');
                if (field_email) {
                    field_email.value = entity[email'] || '';
                }
                const field_activo = document.getElementById('activo');
                if (field_activo) {
                    field_activo.value = entity[activo'] || '';
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
            const entity = entities.find(e => e[id_usuario'] == id);
            
            if (entity) {
                const field_id_usuario = document.getElementById('field_id_usuario');
                if (field_id_usuario) {
                    field_id_usuario.textContent = entity[id_usuario'] || '-';
                }
                const field_nombre_usuario = document.getElementById('field_nombre_usuario');
                if (field_nombre_usuario) {
                    field_nombre_usuario.textContent = entity[nombre_usuario'] || '-';
                }
                const field_email = document.getElementById('field_email');
                if (field_email) {
                    field_email.textContent = entity[email'] || '-';
                }
                const field_activo = document.getElementById('field_activo');
                if (field_activo) {
                    field_activo.textContent = entity[activo'] || '-';
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
            alert('Usuario eliminado correctamente');
            this.loadTableData();
        } catch (error) {
            console.error('Error deleting entity:', error);
            alert('Error al eliminar Usuario');
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
    window.entityManager = new UsuarioManager();
});
