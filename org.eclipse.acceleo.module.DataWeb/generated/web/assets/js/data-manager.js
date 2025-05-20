/**
 * DataManager que usa IndexedDB para almacenamiento local
 */
class DataManager {
    constructor(entityName) {
        this.entityName = entityName;
        this.tableName = this.getTableName(entityName);
        this.primaryKey = this.getPrimaryKey();
        this.dbPromise = this.ensureDatabase();
    }
    
    getTableName(entityName) {
        // Mapear nombres de entidades a nombres de tablas
        const tableMap = {
            'libro': 'LIBROS'
,            'categoria': 'CATEGORIAS'
,            'usuario': 'USUARIOS'
,            'prestamo': 'PRESTAMOS'
        };
        return tableMap[entityName] || entityName.toUpperCase();
    }

    getPrimaryKey() {
        const pkMap = {
            'LIBROS': 'id_libro'
,            'CATEGORIAS': 'id_categoria'
,            'USUARIOS': 'id_usuario'
,            'PRESTAMOS': 'id_prestamo'
        };
        return pkMap[this.tableName] || 'id';
    }

    /**
     * Asegura que la base de datos esté inicializada
     */
    async ensureDatabase() {
        try {
            // Si la base de datos global ya existe, la usamos
            if (window.localDB && window.localDB.db) {
                console.log('Using existing database');
                return window.localDB;
            }

            console.log('Initializing new database...');
            
            // Importar o crear LocalDBManager
            const LocalDBManager = window.LocalDBManager || class LocalDBManager {
                constructor() {
                    this.dbName = 'Biblioteca_Universitaria_DB';
                    this.version = 1;
                    this.db = null;
                }

                async init() {
                    return new Promise((resolve, reject) => {
                        console.log(`Opening database: ${this.dbName}`);
                        const request = indexedDB.open(this.dbName, this.version);
                        
                        request.onerror = () => {
                            console.error('Database open error:', request.error);
                            reject(request.error);
                        };
                        
                        request.onsuccess = () => {
                            console.log('Database opened successfully');
                            this.db = request.result;
                            resolve(this.db);
                        };
                        
                        request.onupgradeneeded = (event) => {
                            console.log('Database upgrade needed');
                            const db = event.target.result;
                            
                            // Crear tablas para entidades
                            if (!db.objectStoreNames.contains('LIBROS')) {
                                console.log('Creating object store: LIBROS');
                                const store = db.createObjectStore('LIBROS', {
                                    keyPath: 'id_libro',
                                    autoIncrement: true
                                });
                                
                                // Crear índices para búsquedas
                                store.createIndex('titulo', 'titulo', { unique: false });
                                store.createIndex('autor', 'autor', { unique: false });
                                store.createIndex('añoPublicacion', 'añoPublicacion', { unique: false });
                                store.createIndex('disponible', 'disponible', { unique: false });
                            }
                            if (!db.objectStoreNames.contains('CATEGORIAS')) {
                                console.log('Creating object store: CATEGORIAS');
                                const store = db.createObjectStore('CATEGORIAS', {
                                    keyPath: 'id_categoria',
                                    autoIncrement: true
                                });
                                
                                // Crear índices para búsquedas
                                store.createIndex('nombre_categoria', 'nombre_categoria', { unique: false });
                                store.createIndex('descripcion', 'descripcion', { unique: false });
                            }
                            if (!db.objectStoreNames.contains('USUARIOS')) {
                                console.log('Creating object store: USUARIOS');
                                const store = db.createObjectStore('USUARIOS', {
                                    keyPath: 'id_usuario',
                                    autoIncrement: true
                                });
                                
                                // Crear índices para búsquedas
                                store.createIndex('nombre_usuario', 'nombre_usuario', { unique: false });
                                store.createIndex('email', 'email', { unique: false });
                                store.createIndex('activo', 'activo', { unique: false });
                            }
                            if (!db.objectStoreNames.contains('PRESTAMOS')) {
                                console.log('Creating object store: PRESTAMOS');
                                const store = db.createObjectStore('PRESTAMOS', {
                                    keyPath: 'id_prestamo',
                                    autoIncrement: true
                                });
                                
                                // Crear índices para búsquedas
                                store.createIndex('fechaPrestamo', 'fechaPrestamo', { unique: false });
                                store.createIndex('fechaDevolucion', 'fechaDevolucion', { unique: false });
                            }
                            
                            // Crear tablas para encuestas y cuestionarios
                            if (!db.objectStoreNames.contains('ENCUESTAS')) {
                                console.log('Creating ENCUESTAS object store');
                                const encuestasStore = db.createObjectStore('ENCUESTAS', { 
                                    keyPath: 'id_encuesta', 
                                    autoIncrement: true 
                                });
                                encuestasStore.createIndex('nombre', 'nombre', { unique: false });
                            }
                            
                            if (!db.objectStoreNames.contains('PREGUNTAS_ENCUESTA')) {
                                console.log('Creating PREGUNTAS_ENCUESTA object store');
                                const preguntasStore = db.createObjectStore('PREGUNTAS_ENCUESTA', { 
                                    keyPath: 'id_pregunta', 
                                    autoIncrement: true 
                                });
                                preguntasStore.createIndex('id_encuesta', 'id_encuesta', { unique: false });
                            }
                            
                            if (!db.objectStoreNames.contains('RESPUESTAS_ENCUESTA')) {
                                console.log('Creating RESPUESTAS_ENCUESTA object store');
                                const respuestasStore = db.createObjectStore('RESPUESTAS_ENCUESTA', { 
                                    keyPath: 'id_respuesta', 
                                    autoIncrement: true 
                                });
                                respuestasStore.createIndex('id_pregunta', 'id_pregunta', { unique: false });
                            }
                            
                            if (!db.objectStoreNames.contains('CUESTIONARIOS')) {
                                console.log('Creating CUESTIONARIOS object store');
                                const cuestionariosStore = db.createObjectStore('CUESTIONARIOS', { 
                                    keyPath: 'id_cuestionario', 
                                    autoIncrement: true 
                                });
                            }
                            
                            if (!db.objectStoreNames.contains('PREGUNTAS_CUESTIONARIO')) {
                                console.log('Creating PREGUNTAS_CUESTIONARIO object store');
                                const preguntasCuestionarioStore = db.createObjectStore('PREGUNTAS_CUESTIONARIO', { 
                                    keyPath: 'id_pregunta', 
                                    autoIncrement: true 
                                });
                                preguntasCuestionarioStore.createIndex('id_cuestionario', 'id_cuestionario', { unique: false });
                            }
                            
                            if (!db.objectStoreNames.contains('RESPUESTAS_CUESTIONARIO')) {
                                console.log('Creating RESPUESTAS_CUESTIONARIO object store');
                                const respuestasCuestionarioStore = db.createObjectStore('RESPUESTAS_CUESTIONARIO', { 
                                    keyPath: 'id_respuesta', 
                                    autoIncrement: true 
                                });
                                respuestasCuestionarioStore.createIndex('id_pregunta', 'id_pregunta', { unique: false });
                            }
                        };
                    });
                }

                // Métodos CRUD para IndexedDB
                async create(tableName, data) {
                    return new Promise((resolve, reject) => {
                        console.log(`Creating record in ${tableName}:`, data);
                        const transaction = this.db.transaction([tableName], 'readwrite');
                        const store = transaction.objectStore(tableName);
                        const request = store.add(data);
                        
                        request.onsuccess = () => {
                            console.log('Record created successfully with ID:', request.result);
                            resolve(request.result);
                        };
                        request.onerror = () => {
                            console.error('Error creating record:', request.error);
                            reject(request.error);
                        };
                    });
                }

                async getAll(tableName) {
                    return new Promise((resolve, reject) => {
                        console.log(`Getting all records from ${tableName}`);
                        const transaction = this.db.transaction([tableName], 'readonly');
                        const store = transaction.objectStore(tableName);
                        const request = store.getAll();
                        
                        request.onsuccess = () => {
                            console.log(`Retrieved ${request.result.length} records from ${tableName}`);
                            resolve(request.result);
                        };
                        request.onerror = () => {
                            console.error('Error getting all records:', request.error);
                            reject(request.error);
                        };
                    });
                }

                async getById(tableName, id) {
                    return new Promise((resolve, reject) => {
                        console.log(`Getting record from ${tableName} with ID: ${id}`);
                        const transaction = this.db.transaction([tableName], 'readonly');
                        const store = transaction.objectStore(tableName);
                        
                        // Intentar tanto con el ID como número como string
                        let request = store.get(Number(id));
                        
                        request.onsuccess = () => {
                            let result = request.result;
                            console.log('Query result with number ID:', result);
                            
                            if (!result) {
                                // Si no se encuentra con ID numérico, intentar con string
                                const stringRequest = store.get(String(id));
                                stringRequest.onsuccess = () => {
                                    result = stringRequest.result;
                                    console.log('Query result with string ID:', result);
                                    resolve(result);
                                };
                                stringRequest.onerror = () => {
                                    console.error('Error getting record with string ID:', stringRequest.error);
                                    reject(stringRequest.error);
                                };
                            } else {
                                resolve(result);
                            }
                        };
                        
                        request.onerror = () => {
                            console.error('Error getting record with number ID:', request.error);
                            reject(request.error);
                        };
                    });
                }

                /**
				 * Actualiza un registro existente usando IndexedDB
				 */
				async update(id, data) {
				    try {
				        const db = await this.dbPromise;
				
				        // Asegurar que el ID esté en los datos
				        data[this.primaryKey] = Number(id) || id;
				
				        // Limpiar datos
				        const cleanData = {};
				        Object.keys(data).forEach(key => {
				            if (data[key] !== undefined && data[key] !== null) {
				                cleanData[key] = data[key];
				            }
				        });
				
				        await db.update(this.tableName, cleanData);
				        
				        return { 
				            success: true, 
				            message: 'Registro actualizado correctamente'
				        };
				    } catch (error) {
				        console.error('Error en update:', error);
				        return { error: error.message, success: false };
				    }
				}

                async delete(tableName, id) {
                    return new Promise((resolve, reject) => {
                        console.log(`Deleting record from ${tableName} with ID: ${id}`);
                        const transaction = this.db.transaction([tableName], 'readwrite');
                        const store = transaction.objectStore(tableName);
                        const request = store.delete(Number(id));
                        
                        request.onsuccess = () => {
                            console.log('Record deleted successfully');
                            resolve(request.result);
                        };
                        request.onerror = () => {
                            console.error('Error deleting record:', request.error);
                            reject(request.error);
                        };
                    });
                }

                async count(tableName) {
                    return new Promise((resolve, reject) => {
                        console.log(`Counting records in ${tableName}`);
                        const transaction = this.db.transaction([tableName], 'readonly');
                        const store = transaction.objectStore(tableName);
                        const request = store.count();
                        
                        request.onsuccess = () => {
                            console.log(`Count result: ${request.result}`);
                            resolve(request.result);
                        };
                        request.onerror = () => {
                            console.error('Error counting records:', request.error);
                            reject(request.error);
                        };
                    });
                }

                async query(tableName, filters = {}) {
                    return new Promise((resolve, reject) => {
                        console.log(`Querying ${tableName} with filters:`, filters);
                        const transaction = this.db.transaction([tableName], 'readonly');
                        const store = transaction.objectStore(tableName);
                        const request = store.getAll();
                        
                        request.onsuccess = () => {
                            let results = request.result;
                            console.log(`Retrieved ${results.length} records for filtering`);
                            
                            // Aplicar filtros
                            if (Object.keys(filters).length > 0) {
                                results = results.filter(item => {
                                    return Object.keys(filters).every(key => {
                                        if (!filters[key]) return true;
                                        const itemValue = String(item[key]).toLowerCase();
                                        const filterValue = String(filters[key]).toLowerCase();
                                        return itemValue.includes(filterValue);
                                    });
                                });
                                console.log(`Filtered to ${results.length} records`);
                            }
                            
                            resolve(results);
                        };
                        request.onerror = () => {
                            console.error('Error querying records:', request.error);
                            reject(request.error);
                        };
                    });
                }

                async initSampleData() {
                    try {
                        console.log('Initializing sample data...');
                        
                        // Verificar si Libro ya tiene datos
                        const libroCount = await this.count('LIBROS');
                        if (libroCount === 0) {
                            console.log('Inserting sample data for Libro...');
                            // Crear 5 registros de ejemplo para Libro
                            for (let i = 1; i <= 5; i++) {
                                const data = {
                                    titulo: 'Libro Ejemplo ' + i
,                                    autor: 'Libro Ejemplo ' + i
,                                    añoPublicacion: (i * 10)
,                                    disponible: (i % 2 === 0)
                                };
                                await this.create('LIBROS', data);
                            }
                            console.log('✅ Sample data for Libro inserted');
                        }
                        // Verificar si Categoria ya tiene datos
                        const categoriaCount = await this.count('CATEGORIAS');
                        if (categoriaCount === 0) {
                            console.log('Inserting sample data for Categoria...');
                            // Crear 5 registros de ejemplo para Categoria
                            for (let i = 1; i <= 5; i++) {
                                const data = {
                                    nombre_categoria: 'Categoria Ejemplo ' + i
,                                    descripcion: 'Categoria Ejemplo ' + i
                                };
                                await this.create('CATEGORIAS', data);
                            }
                            console.log('✅ Sample data for Categoria inserted');
                        }
                        // Verificar si Usuario ya tiene datos
                        const usuarioCount = await this.count('USUARIOS');
                        if (usuarioCount === 0) {
                            console.log('Inserting sample data for Usuario...');
                            // Crear 5 registros de ejemplo para Usuario
                            for (let i = 1; i <= 5; i++) {
                                const data = {
                                    nombre_usuario: 'Usuario Ejemplo ' + i
,                                    email: 'Usuario Ejemplo ' + i
,                                    activo: (i % 2 === 0)
                                };
                                await this.create('USUARIOS', data);
                            }
                            console.log('✅ Sample data for Usuario inserted');
                        }
                        // Verificar si Prestamo ya tiene datos
                        const prestamoCount = await this.count('PRESTAMOS');
                        if (prestamoCount === 0) {
                            console.log('Inserting sample data for Prestamo...');
                            // Crear 5 registros de ejemplo para Prestamo
                            for (let i = 1; i <= 5; i++) {
                                const data = {
                                    fechaPrestamo: 'Prestamo Ejemplo ' + i
,                                    fechaDevolucion: 'Prestamo Ejemplo ' + i
                                };
                                await this.create('PRESTAMOS', data);
                            }
                            console.log('✅ Sample data for Prestamo inserted');
                        }
                        
                        // Insertar datos de ejemplo para encuestas
                        const encuestasCount = await this.count('ENCUESTAS');
                        if (encuestasCount === 0) {
                            console.log('Inserting sample surveys...');
                            await this.create('ENCUESTAS', {
                                nombre: 'preferenciasBiblioteca',
                                titulo: 'Encuesta de Preferencias',
                                descripcion: 'Ayúdanos a conocer tus preferencias de lectura',
                                tipo_representacion: 'BARRAS'
                            });
                            console.log('✅ Sample surveys inserted');
                        }
                        
                        // Insertar datos de ejemplo para cuestionarios
                        const cuestionariosCount = await this.count('CUESTIONARIOS');
                        if (cuestionariosCount === 0) {
                            console.log('Inserting sample quizzes...');
                            await this.create('CUESTIONARIOS', {
                                nombre: 'satisfaccionBiblioteca',
                                titulo: 'Cuestionario de Satisfacción',
                                descripcion: 'Evalúa tu experiencia con la biblioteca'
                            });
                            console.log('✅ Sample quizzes inserted');
                        }
                        
                        console.log('Sample data initialization completed');
                    } catch (error) {
                        console.error('Error inserting sample data:', error);
                    }
                }
            };

            // Inicializar base de datos
            const dbManager = new LocalDBManager();
            await dbManager.init();
            await dbManager.initSampleData();
            
            // Guardar globalmente
            window.localDB = dbManager;
            console.log('✅ Database initialized successfully');
            
            return dbManager;
        } catch (error) {
            console.error('❌ Error initializing database:', error);
            throw error;
        }
    }

    /**
     * Obtiene todos los registros usando IndexedDB
     */
    async getAll(filters = null, page = null, pageSize = null) {
        try {
            const db = await this.dbPromise;

            let data = await db.query(this.tableName, filters || {});
            
            // Aplicar paginación si se proporciona
            let total = data.length;
            if (page !== null && pageSize !== null) {
                const start = (page - 1) * pageSize;
                data = data.slice(start, start + pageSize);
            }
            
            // Simular respuesta de API
            const response = {
                entities: data,
                total: total,
                success: true
            };
            
            if (page !== null && pageSize !== null) {
                response.pagination = {
                    page: page,
                    pageSize: pageSize,
                    totalPages: Math.ceil(total / pageSize)
                };
            }
            
            return response;
        } catch (error) {
            console.error('Error en getAll:', error);
            return { error: error.message, success: false };
        }
    }

    /**
     * Obtiene un registro por su ID usando IndexedDB
     */
    async getById(id) {
        try {
            console.log(`Getting entity by ID: ${id} from table: ${this.tableName}`);
            const db = await this.dbPromise;

            if (!db || !db.db) {
                throw new Error('Database not initialized');
            }

            const entity = await db.getById(this.tableName, id);
            
            console.log('Entity retrieved:', entity);
            
            if (entity) {
                return { entity: entity, success: true };
            } else {
                console.warn('Entity not found with ID:', id);
                return { error: 'Registro no encontrado', success: false };
            }
        } catch (error) {
            console.error('Error en getById:', error);
            return { error: error.message, success: false };
        }
    }

    /**
     * Crea un nuevo registro usando IndexedDB
     */
    async create(data) {
        try {
            const db = await this.dbPromise;

            // Limpiar datos (remover campos undefined/null)
            const cleanData = {};
            Object.keys(data).forEach(key => {
                if (data[key] !== undefined && data[key] !== null && data[key] !== '') {
                    cleanData[key] = data[key];
                }
            });

            const newId = await db.create(this.tableName, cleanData);
            
            return { 
                success: true, 
                message: 'Registro creado correctamente',
                id: newId
            };
        } catch (error) {
            console.error('Error en create:', error);
            return { error: error.message, success: false };
        }
    }

    /**
     * Actualiza un registro existente usando IndexedDB
     */
    async update(id, data) {
        try {
            const db = await this.dbPromise;

            // Asegurar que el ID esté en los datos
            data[this.primaryKey] = Number(id);

            // Limpiar datos
            const cleanData = {};
            Object.keys(data).forEach(key => {
                if (data[key] !== undefined && data[key] !== null) {
                    cleanData[key] = data[key];
                }
            });

            await db.update(this.tableName, cleanData);
            
            return { 
                success: true, 
                message: 'Registro actualizado correctamente'
            };
        } catch (error) {
            console.error('Error en update:', error);
            return { error: error.message, success: false };
        }
    }

    /**
     * Elimina un registro usando IndexedDB
     */
    async delete(id) {
        try {
            const db = await this.dbPromise;

            await db.delete(this.tableName, id);
            
            return { 
                success: true, 
                message: 'Registro eliminado correctamente'
            };
        } catch (error) {
            console.error('Error en delete:', error);
            return { error: error.message, success: false };
        }
    }

    /**
     * Obtiene registros relacionados (simulado para IndexedDB)
     */
    async getRelated(id, relationName) {
        try {
            // Para simplificar, retornamos array vacío
            // En una implementación completa, buscaríamos las relaciones
            return { entities: [] };
        } catch (error) {
            console.error('Error en getRelated:', error);
            return { error: error.message, success: false };
        }
    }
}

// Asegurar que DataManager esté disponible globalmente
window.DataManager = DataManager;
