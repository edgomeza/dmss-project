/**
 * GESTOR DE BASE DE DATOS UNIFICADO - Biblioteca Universitaria
 * Centraliza toda la gestión de IndexedDB
 */

class UnifiedDatabaseManager {
    constructor() {
        this.dbName = 'Biblioteca_Universitaria_DB';
        this.version = 2;
        this.db = null;
        this.initialized = false;
    }

    async init() {
        if (this.initialized && this.db) return this.db;
        
        return new Promise((resolve, reject) => {
            const request = indexedDB.open(this.dbName, this.version);
            
            request.onerror = () => reject(request.error);
            
            request.onsuccess = () => {
                this.db = request.result;
                this.initialized = true;
                resolve(this.db);
            };
            
            request.onupgradeneeded = (event) => {
                const db = event.target.result;
                
                // Stores de entidades
                const entityStores = {
                    'LIBROS': 'id_libro'
,                    'CATEGORIAS': 'id_categoria'
,                    'USUARIOS': 'id_usuario'
,                    'PRESTAMOS': 'id_prestamo'
                };
                
                // Stores del sistema
                const systemStores = {
                    'ENCUESTAS': 'id_encuesta',
                    'CUESTIONARIOS': 'id_cuestionario',
                    'PREGUNTAS_ENCUESTA': 'id_pregunta',
                    'PREGUNTAS_CUESTIONARIO': 'id_pregunta',
                    'OPCIONES_PREGUNTA': 'id_opcion',
                    'OPCIONES_CUESTIONARIO': 'id_opcion',
                    'RESPUESTAS_ENCUESTA': 'id',
                    'RESPUESTAS_CUESTIONARIO': 'id'
                };
                
                const allStores = { ...entityStores, ...systemStores };
                
                Object.entries(allStores).forEach(([storeName, keyPath]) => {
                    if (!db.objectStoreNames.contains(storeName)) {
                        db.createObjectStore(storeName, { keyPath, autoIncrement: true });
                    }
                });
                
                this.seedInitialData(db);
            };
        });
    }

    seedInitialData(db) {
        // Datos iniciales para entidades
        if (db.objectStoreNames.contains('LIBROS')) {
            const libroStore = db.transaction([[entidad.tableName/]'], 'readwrite').objectStore('LIBROS');
            for (let i = 1; i <= 3; i++) {
                libroStore.add({
                    titulo: `Libro ${i}`
,                    autor: `Libro ${i}`
,                    añoPublicacion: (Math.floor(Math.random() * 100))
,                    disponible: (Math.random() > 0.5)
                });
            }
        }
        if (db.objectStoreNames.contains('CATEGORIAS')) {
            const categoriaStore = db.transaction([[entidad.tableName/]'], 'readwrite').objectStore('CATEGORIAS');
            for (let i = 1; i <= 3; i++) {
                categoriaStore.add({
                    nombre_categoria: `Categoria ${i}`
,                    descripcion: `Categoria ${i}`
                });
            }
        }
        if (db.objectStoreNames.contains('USUARIOS')) {
            const usuarioStore = db.transaction([[entidad.tableName/]'], 'readwrite').objectStore('USUARIOS');
            for (let i = 1; i <= 3; i++) {
                usuarioStore.add({
                    nombre_usuario: `Usuario ${i}`
,                    email: `Usuario ${i}`
,                    activo: (Math.random() > 0.5)
                });
            }
        }
        if (db.objectStoreNames.contains('PRESTAMOS')) {
            const prestamoStore = db.transaction([[entidad.tableName/]'], 'readwrite').objectStore('PRESTAMOS');
            for (let i = 1; i <= 3; i++) {
                prestamoStore.add({
                    fechaPrestamo: `Prestamo ${i}`
,                    fechaDevolucion: `Prestamo ${i}`
                });
            }
        }
        
        // Datos iniciales para encuestas y cuestionarios
        if (db.objectStoreNames.contains('ENCUESTAS')) {
            const encuestasStore = db.transaction(['ENCUESTAS'], 'readwrite').objectStore('ENCUESTAS');
            encuestasStore.add({
                nombre: 'preferenciasBiblioteca',
                titulo: 'Encuesta de Preferencias',
                descripcion: 'Ayúdanos a conocer tus preferencias de lectura',
                tipo_representacion: 'BARRAS'
            });
        }
        
        if (db.objectStoreNames.contains('CUESTIONARIOS')) {
            const cuestionariosStore = db.transaction(['CUESTIONARIOS'], 'readwrite').objectStore('CUESTIONARIOS');
            cuestionariosStore.add({
                nombre: 'satisfaccionBiblioteca',
                titulo: 'Cuestionario de Satisfacción',
                descripcion: 'Evalúa tu experiencia con la biblioteca',
                tiempoLimite: 30
            });
        }
    }

    async execute(operation, storeName, data = null, id = null) {
        await this.init();
        
        return new Promise((resolve, reject) => {
            if (!this.db.objectStoreNames.contains(storeName)) {
                console.warn(`Store ${storeName} no existe`);
                resolve(operation === 'getAll' ? [] : null);
                return;
            }
            
            const mode = operation === 'get' || operation === 'getAll' ? 'readonly' : 'readwrite';
            const transaction = this.db.transaction([storeName], mode);
            const store = transaction.objectStore(storeName);
            
            let request;
            switch(operation) {
                case 'create': request = store.add(data); break;
                case 'getAll': request = store.getAll(); break;
                case 'get': request = store.get(id); break;
                case 'update': request = store.put(data); break;
                case 'delete': request = store.delete(id); break;
                default: reject(new Error(`Operación ${operation} no válida`)); return;
            }
            
            request.onsuccess = () => resolve(request.result || (operation === 'getAll' ? [] : null));
            request.onerror = () => reject(request.error);
        });
    }

    async query(storeName, filters = {}) {
        const all = await this.execute('getAll', storeName);
        if (!Object.keys(filters).length) return all;
        
        return all.filter(item => 
            Object.entries(filters).every(([key, value]) => 
                item[key] == value
            )
        );
    }
}

// Singleton global
window.UnifiedDB = new UnifiedDatabaseManager();
