/**
 * Gestor específico para la entidad Libro
 */

class LibroManager {
    constructor() {
        this.entityName = 'libro';
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
                        const store = transaction.objectStore('LIBRO');
                        return store.add(data);
                    },
                    async getAll() {
                        const transaction = db.transaction([[entidad.nombre.toUpperCase()]], 'readonly');
                        const store = transaction.objectStore('LIBRO');
                        return store.getAll();
                    },
                    async update(data) {
                        const transaction = db.transaction([[entidad.nombre.toUpperCase()]], 'readwrite');
                        const store = transaction.objectStore('LIBRO');
                        return store.put(data);
                    },
                    async delete(id) {
                        const transaction = db.transaction([[entidad.nombre.toUpperCase()]], 'readwrite');
                        const store = transaction.objectStore('LIBRO');
                        return store.delete(id);
                    }
                });
            };
            
            request.onerror = () => reject(request.error);
            
            request.onupgradeneeded = (event) => {
                const db = event.target.result;
                if (!db.objectStoreNames.contains('LIBRO')) {
                    db.createObjectStore('LIBRO', { 
                        keyPath: 'id_libro', 
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
        const table = document.getElementById('libroTable');
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
            alert('Libro creado correctamente');
            window.location.href = 'list.html';
        } catch (error) {
            console.error('Error creating entity:', error);
            alert('Error al crear Libro');
        }
    }

    async updateEntity() {
        const form = document.getElementById('editForm');
        const formData = new FormData(form);
        const data = Object.fromEntries(formData);
        
        try {
            await this.db.update(data);
            alert('Libro actualizado correctamente');
            window.location.href = 'list.html';
        } catch (error) {
            console.error('Error updating entity:', error);
            alert('Error al actualizar Libro');
        }
    }

    async loadTableData() {
        try {
            const entities = await this.db.getAll();
            const tbody = document.getElementById('tableBody');
            
            tbody.innerHTML = entities.map(entity => `
                <tr>
                    <td>${entity[id_libro'] || '-'}</td>
                    <td>${entity[titulo'] || '-'}</td>
                    <td>${entity[autor'] || '-'}</td>
                    <td>${entity[añoPublicacion'] || '-'}</td>
                    <td>${entity[disponible'] || '-'}</td>
                    <td>
                        <a href="detail.html?id=${entity[id_libro']}" class="btn btn-info btn-sm">Ver</a>
                        <a href="edit.html?id=${entity[id_libro']}" class="btn btn-warning btn-sm">Editar</a>
                        <button onclick="deleteEntity(${entity[id_libro']})" class="btn btn-danger btn-sm">Eliminar</button>
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
            const entity = entities.find(e => e[id_libro'] == id);
            
            if (entity) {
                const field_id_libro = document.getElementById('id_libro');
                if (field_id_libro) {
                    field_id_libro.value = entity[id_libro'] || '';
                }
                const field_titulo = document.getElementById('titulo');
                if (field_titulo) {
                    field_titulo.value = entity[titulo'] || '';
                }
                const field_autor = document.getElementById('autor');
                if (field_autor) {
                    field_autor.value = entity[autor'] || '';
                }
                const field_añoPublicacion = document.getElementById('añoPublicacion');
                if (field_añoPublicacion) {
                    field_añoPublicacion.value = entity[añoPublicacion'] || '';
                }
                const field_disponible = document.getElementById('disponible');
                if (field_disponible) {
                    field_disponible.value = entity[disponible'] || '';
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
            const entity = entities.find(e => e[id_libro'] == id);
            
            if (entity) {
                const field_id_libro = document.getElementById('field_id_libro');
                if (field_id_libro) {
                    field_id_libro.textContent = entity[id_libro'] || '-';
                }
                const field_titulo = document.getElementById('field_titulo');
                if (field_titulo) {
                    field_titulo.textContent = entity[titulo'] || '-';
                }
                const field_autor = document.getElementById('field_autor');
                if (field_autor) {
                    field_autor.textContent = entity[autor'] || '-';
                }
                const field_añoPublicacion = document.getElementById('field_añoPublicacion');
                if (field_añoPublicacion) {
                    field_añoPublicacion.textContent = entity[añoPublicacion'] || '-';
                }
                const field_disponible = document.getElementById('field_disponible');
                if (field_disponible) {
                    field_disponible.textContent = entity[disponible'] || '-';
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
            alert('Libro eliminado correctamente');
            this.loadTableData();
        } catch (error) {
            console.error('Error deleting entity:', error);
            alert('Error al eliminar Libro');
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
    window.entityManager = new LibroManager();
});
