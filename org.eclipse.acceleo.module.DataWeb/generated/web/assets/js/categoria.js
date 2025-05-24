/**
 * Gestor específico para la entidad Categoria
 */

class CategoriaManager {
    constructor() {
        this.entityName = 'categoria';
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
                        const store = transaction.objectStore('CATEGORIA');
                        return store.add(data);
                    },
                    async getAll() {
                        const transaction = db.transaction([[entidad.nombre.toUpperCase()]], 'readonly');
                        const store = transaction.objectStore('CATEGORIA');
                        return store.getAll();
                    },
                    async update(data) {
                        const transaction = db.transaction([[entidad.nombre.toUpperCase()]], 'readwrite');
                        const store = transaction.objectStore('CATEGORIA');
                        return store.put(data);
                    },
                    async delete(id) {
                        const transaction = db.transaction([[entidad.nombre.toUpperCase()]], 'readwrite');
                        const store = transaction.objectStore('CATEGORIA');
                        return store.delete(id);
                    }
                });
            };
            
            request.onerror = () => reject(request.error);
            
            request.onupgradeneeded = (event) => {
                const db = event.target.result;
                if (!db.objectStoreNames.contains('CATEGORIA')) {
                    db.createObjectStore('CATEGORIA', { 
                        keyPath: 'id_categoria', 
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
        const table = document.getElementById('categoriaTable');
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
            alert('Categoria creado correctamente');
            window.location.href = 'list.html';
        } catch (error) {
            console.error('Error creating entity:', error);
            alert('Error al crear Categoria');
        }
    }

    async updateEntity() {
        const form = document.getElementById('editForm');
        const formData = new FormData(form);
        const data = Object.fromEntries(formData);
        
        try {
            await this.db.update(data);
            alert('Categoria actualizado correctamente');
            window.location.href = 'list.html';
        } catch (error) {
            console.error('Error updating entity:', error);
            alert('Error al actualizar Categoria');
        }
    }

    async loadTableData() {
        try {
            const entities = await this.db.getAll();
            const tbody = document.getElementById('tableBody');
            
            tbody.innerHTML = entities.map(entity => `
                <tr>
                    <td>${entity[id_categoria'] || '-'}</td>
                    <td>${entity[nombre_categoria'] || '-'}</td>
                    <td>${entity[descripcion'] || '-'}</td>
                    <td>
                        <a href="detail.html?id=${entity[id_categoria']}" class="btn btn-info btn-sm">Ver</a>
                        <a href="edit.html?id=${entity[id_categoria']}" class="btn btn-warning btn-sm">Editar</a>
                        <button onclick="deleteEntity(${entity[id_categoria']})" class="btn btn-danger btn-sm">Eliminar</button>
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
            const entity = entities.find(e => e[id_categoria'] == id);
            
            if (entity) {
                const field_id_categoria = document.getElementById('id_categoria');
                if (field_id_categoria) {
                    field_id_categoria.value = entity[id_categoria'] || '';
                }
                const field_nombre_categoria = document.getElementById('nombre_categoria');
                if (field_nombre_categoria) {
                    field_nombre_categoria.value = entity[nombre_categoria'] || '';
                }
                const field_descripcion = document.getElementById('descripcion');
                if (field_descripcion) {
                    field_descripcion.value = entity[descripcion'] || '';
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
            const entity = entities.find(e => e[id_categoria'] == id);
            
            if (entity) {
                const field_id_categoria = document.getElementById('field_id_categoria');
                if (field_id_categoria) {
                    field_id_categoria.textContent = entity[id_categoria'] || '-';
                }
                const field_nombre_categoria = document.getElementById('field_nombre_categoria');
                if (field_nombre_categoria) {
                    field_nombre_categoria.textContent = entity[nombre_categoria'] || '-';
                }
                const field_descripcion = document.getElementById('field_descripcion');
                if (field_descripcion) {
                    field_descripcion.textContent = entity[descripcion'] || '-';
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
            alert('Categoria eliminado correctamente');
            this.loadTableData();
        } catch (error) {
            console.error('Error deleting entity:', error);
            alert('Error al eliminar Categoria');
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
    window.entityManager = new CategoriaManager();
});
