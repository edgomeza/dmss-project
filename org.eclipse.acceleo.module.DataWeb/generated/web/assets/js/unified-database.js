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
                console.log(`✅ Base de datos ${this.dbName} inicializada`);
                resolve(this.db);
            };
            
            request.onupgradeneeded = (event) => {
                const db = event.target.result;
                console.log(`🔄 Actualizando base de datos a versión ${this.version}`);
                
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
                        console.log(`📊 Creando store: ${storeName}`);
                        const autoIncrement = storeName === 'LIBROS' ? true : storeName === 'CATEGORIAS' ? true : storeName === 'USUARIOS' ? true : storeName === 'PRESTAMOS' ? true : keyPath.includes('id_');
                        db.createObjectStore(storeName, { keyPath, autoIncrement });
                    }
                });
                
                // Programar la inserción de datos iniciales después de que se complete la transacción
                request.transaction.oncomplete = () => {
                    this.seedInitialData(db);
                };
            };
        });
    }

    async seedInitialData(db) {
        console.log('🌱 Insertando datos iniciales...');
        
        try {
            // Datos iniciales para entidades - métodos específicos
            await this.seedLibroData(db);
            await this.seedCategoriaData(db);
            await this.seedUsuarioData(db);
            await this.seedPrestamoData(db);
            
            // Datos iniciales para encuestas
            await this.seedSurveyData(db);
            
            // Datos iniciales para cuestionarios
            await this.seedQuizData(db);
            
            console.log('✅ Datos iniciales insertados correctamente');
        } catch (error) {
            console.error('❌ Error insertando datos iniciales:', error);
        }
    }
    
    async seedLibroData(db) {
        const tableName = 'LIBROS';
        
        if (!db.objectStoreNames.contains(tableName)) return;
        
        try {
            const transaction = db.transaction([tableName], 'readwrite');
            const store = transaction.objectStore(tableName);
            
            for (let i = 1; i <= 3; i++) {
                const data = {
                    titulo: `Libro ${i}`,
                    autor: `Libro ${i}`,
                    añoPublicacion: (Math.floor(Math.random() * 100) + 1),
                    disponible: (Math.random() > 0.5)
                };
                
                // Añadir clave primaria si no es auto-increment
                
                await new Promise((resolve, reject) => {
                    const request = store.add(data);
                    request.onsuccess = () => resolve();
                    request.onerror = () => reject(request.error);
                });
            }
            
            console.log(`📊 Datos de ejemplo creados para Libro`);
        } catch (error) {
            console.error(`❌ Error creando datos para Libro:`, error);
        }
    }
    
    async seedCategoriaData(db) {
        const tableName = 'CATEGORIAS';
        
        if (!db.objectStoreNames.contains(tableName)) return;
        
        try {
            const transaction = db.transaction([tableName], 'readwrite');
            const store = transaction.objectStore(tableName);
            
            for (let i = 1; i <= 3; i++) {
                const data = {
                    nombre_categoria: `Categoria ${i}`,
                    descripcion: `Categoria ${i}`
                };
                
                // Añadir clave primaria si no es auto-increment
                
                await new Promise((resolve, reject) => {
                    const request = store.add(data);
                    request.onsuccess = () => resolve();
                    request.onerror = () => reject(request.error);
                });
            }
            
            console.log(`📊 Datos de ejemplo creados para Categoria`);
        } catch (error) {
            console.error(`❌ Error creando datos para Categoria:`, error);
        }
    }
    
    async seedUsuarioData(db) {
        const tableName = 'USUARIOS';
        
        if (!db.objectStoreNames.contains(tableName)) return;
        
        try {
            const transaction = db.transaction([tableName], 'readwrite');
            const store = transaction.objectStore(tableName);
            
            for (let i = 1; i <= 3; i++) {
                const data = {
                    nombre_usuario: `Usuario ${i}`,
                    email: `Usuario ${i}`,
                    activo: (Math.random() > 0.5)
                };
                
                // Añadir clave primaria si no es auto-increment
                
                await new Promise((resolve, reject) => {
                    const request = store.add(data);
                    request.onsuccess = () => resolve();
                    request.onerror = () => reject(request.error);
                });
            }
            
            console.log(`📊 Datos de ejemplo creados para Usuario`);
        } catch (error) {
            console.error(`❌ Error creando datos para Usuario:`, error);
        }
    }
    
    async seedPrestamoData(db) {
        const tableName = 'PRESTAMOS';
        
        if (!db.objectStoreNames.contains(tableName)) return;
        
        try {
            const transaction = db.transaction([tableName], 'readwrite');
            const store = transaction.objectStore(tableName);
            
            for (let i = 1; i <= 3; i++) {
                const data = {
                    fechaPrestamo: `Prestamo ${i}`,
                    fechaDevolucion: `Prestamo ${i}`
                };
                
                // Añadir clave primaria si no es auto-increment
                
                await new Promise((resolve, reject) => {
                    const request = store.add(data);
                    request.onsuccess = () => resolve();
                    request.onerror = () => reject(request.error);
                });
            }
            
            console.log(`📊 Datos de ejemplo creados para Prestamo`);
        } catch (error) {
            console.error(`❌ Error creando datos para Prestamo:`, error);
        }
    }
    
    
    async seedSurveyData(db) {
        if (!db.objectStoreNames.contains('ENCUESTAS')) return;
        
        try {
            const transaction = db.transaction(['ENCUESTAS'], 'readwrite');
            const store = transaction.objectStore('ENCUESTAS');
            
            const surveys = [
                {
                    nombre: 'preferenciasBiblioteca',
                    titulo: 'Encuesta de Preferencias',
                    descripcion: 'Ayúdanos a conocer tus preferencias de lectura',
                    tipo_representacion: 'BARRAS',
                    activa: true,
                    fecha_creacion: new Date().toISOString()
                }
            ];
            
            for (const survey of surveys) {
                await new Promise((resolve, reject) => {
                    const request = store.add(survey);
                    request.onsuccess = () => resolve();
                    request.onerror = () => reject(request.error);
                });
            }
            
            console.log('📊 Encuestas iniciales creadas');
        } catch (error) {
            console.error('❌ Error creando encuestas:', error);
        }
    }
    
    async seedQuizData(db) {
        if (!db.objectStoreNames.contains('CUESTIONARIOS')) return;
        
        try {
            const transaction = db.transaction('CUESTIONARIOS', 'readwrite');
            const store = transaction.objectStore('CUESTIONARIOS');
            
            const quizzes = [
                {
                    nombre: 'satisfaccionBiblioteca',
                    titulo: 'Cuestionario de Satisfacción',
                    descripcion: 'Evalúa tu experiencia con la biblioteca',
                    tiempoLimite: 30,
                    puntuacion_minima: 60,
                    activo: true,
                    fecha_creacion: new Date().toISOString()
                }
            ];
            
            for (const quiz of quizzes) {
                await new Promise((resolve, reject) => {
                    const request = store.add(quiz);
                    request.onsuccess = () => resolve();
                    request.onerror = () => reject(request.error);
                });
            }
            
            console.log('📊 Cuestionarios iniciales creados');
        } catch (error) {
            console.error('❌ Error creando cuestionarios:', error);
        }
    }

    async execute(operation, storeName, data = null, id = null) {
        await this.init();
        
        return new Promise((resolve, reject) => {
            if (!this.db.objectStoreNames.contains(storeName)) {
                console.warn(`⚠️ Store ${storeName} no existe`);
                resolve(operation === 'getAll' ? [] : null);
                return;
            }
            
            try {
                const mode = operation === 'get' || operation === 'getAll' ? 'readonly' : 'readwrite';
                const transaction = this.db.transaction([storeName], mode);
                const store = transaction.objectStore(storeName);
                
                let request;
                switch(operation) {
                    case 'create': 
                        request = store.add(data); 
                        break;
                    case 'getAll': 
                        request = store.getAll(); 
                        break;
                    case 'get': 
                        request = store.get(id); 
                        break;
                    case 'update': 
                        request = store.put(data); 
                        break;
                    case 'delete': 
                        request = store.delete(id); 
                        break;
                    default: 
                        reject(new Error(`Operación ${operation} no válida`)); 
                        return;
                }
                
                request.onsuccess = () => {
                    const result = request.result;
                    resolve(result || (operation === 'getAll' ? [] : null));
                };
                
                request.onerror = () => {
                    console.error(`❌ Error en operación ${operation} en ${storeName}:`, request.error);
                    reject(request.error);
                };
                
                transaction.onerror = () => {
                    console.error(`❌ Error en transacción ${operation} en ${storeName}:`, transaction.error);
                    reject(transaction.error);
                };
            } catch (error) {
                console.error(`❌ Error ejecutando ${operation} en ${storeName}:`, error);
                reject(error);
            }
        });
    }

    async query(storeName, filters = {}) {
        try {
            const all = await this.execute('getAll', storeName);
            if (!Object.keys(filters).length) return all;
            
            return all.filter(item => 
                Object.entries(filters).every(([key, value]) => 
                    item[key] == value
                )
            );
        } catch (error) {
            console.error(`❌ Error en query de ${storeName}:`, error);
            return [];
        }
    }
    
    async count(storeName, filters = {}) {
        try {
            const items = await this.query(storeName, filters);
            return items.length;
        } catch (error) {
            console.error(`❌ Error contando ${storeName}:`, error);
            return 0;
        }
    }
    
    async clear(storeName) {
        await this.init();
        
        return new Promise((resolve, reject) => {
            if (!this.db.objectStoreNames.contains(storeName)) {
                console.warn(`⚠️ Store ${storeName} no existe`);
                resolve();
                return;
            }
            
            try {
                const transaction = this.db.transaction(storeName, 'readwrite');
                const store = transaction.objectStore(storeName);
                const request = store.clear();
                
                request.onsuccess = () => {
                    console.log(`🗑️ Store ${storeName} limpiado`);
                    resolve();
                };
                
                request.onerror = () => {
                    console.error(`❌ Error limpiando ${storeName}:`, request.error);
                    reject(request.error);
                };
            } catch (error) {
                console.error(`❌ Error en clear de ${storeName}:`, error);
                reject(error);
            }
        });
    }
}

// Singleton global
window.UnifiedDatabaseManager = UnifiedDatabaseManager;
window.UnifiedDB = new UnifiedDatabaseManager();

// Auto-inicializar cuando se carga el módulo
document.addEventListener('DOMContentLoaded', async () => {
    try {
        await window.UnifiedDB.init();
        console.log('✅ UnifiedDB inicializado automáticamente');
    } catch (error) {
        console.error('❌ Error inicializando UnifiedDB:', error);
    }
});
