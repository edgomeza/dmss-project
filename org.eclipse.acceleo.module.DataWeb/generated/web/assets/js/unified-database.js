/**
 * GESTOR DE BASE DE DATOS UNIFICADO - Sistema Bancario Digital
 * Centraliza toda la gestión de IndexedDB
 */

class UnifiedDatabaseManager {
    constructor() {
        this.dbName = 'Sistema_Bancario Digital_DB';
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
                    'CLIENTES': 'id_cliente'
,                    'CUENTAS': 'numero_cuenta'
,                    'TRANSACCIONES': 'id_transaccion'
,                    'EMPLEADOS': 'id_empleado'
,                    'PRESTAMOS': 'id_prestamo'
,                    'TARJETAS_CREDITO': 'numero_tarjeta'
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
                        const autoIncrement = storeName === 'CLIENTES' ? true : storeName === 'CUENTAS' ? false : storeName === 'TRANSACCIONES' ? true : storeName === 'EMPLEADOS' ? true : storeName === 'PRESTAMOS' ? true : storeName === 'TARJETAS_CREDITO' ? false : keyPath.includes('id_');
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
            await this.seedClienteData(db);
            await this.seedCuentaData(db);
            await this.seedTransaccionData(db);
            await this.seedEmpleadoData(db);
            await this.seedPrestamoData(db);
            await this.seedTarjetaCreditoData(db);
            
            // Datos iniciales para encuestas
            await this.seedSurveyData(db);
            
            // Datos iniciales para cuestionarios
            await this.seedQuizData(db);
            
            console.log('✅ Datos iniciales insertados correctamente');
        } catch (error) {
            console.error('❌ Error insertando datos iniciales:', error);
        }
    }
    
    async seedClienteData(db) {
        const tableName = 'CLIENTES';
        
        if (!db.objectStoreNames.contains(tableName)) return;
        
        try {
            const transaction = db.transaction([tableName], 'readwrite');
            const store = transaction.objectStore(tableName);
            
            for (let i = 1; i <= 3; i++) {
                const data = {
                    dni: `Cliente ${i}`,
                    nombre: `Cliente ${i}`,
                    apellidos: `Cliente ${i}`,
                    email: `Cliente ${i}`,
                    telefono: `Cliente ${i}`,
                    fecha_registro: `Cliente ${i}`,
                    activo: (Math.random() > 0.5)
                };
                
                // Añadir clave primaria si no es auto-increment
                
                await new Promise((resolve, reject) => {
                    const request = store.add(data);
                    request.onsuccess = () => resolve();
                    request.onerror = () => reject(request.error);
                });
            }
            
            console.log(`📊 Datos de ejemplo creados para Cliente`);
        } catch (error) {
            console.error(`❌ Error creando datos para Cliente:`, error);
        }
    }
    
    async seedCuentaData(db) {
        const tableName = 'CUENTAS';
        
        if (!db.objectStoreNames.contains(tableName)) return;
        
        try {
            const transaction = db.transaction([tableName], 'readwrite');
            const store = transaction.objectStore(tableName);
            
            for (let i = 1; i <= 3; i++) {
                const data = {
                    tipo_cuenta: `Cuenta ${i}`,
                    saldo: (Math.round(Math.random() * 1000 * 100) / 100),
                    fecha_apertura: `Cuenta ${i}`,
                    activa: (Math.random() > 0.5)
                };
                
                // Añadir clave primaria si no es auto-increment
                data.numero_cuenta = `cuenta_${i}`;
                
                await new Promise((resolve, reject) => {
                    const request = store.add(data);
                    request.onsuccess = () => resolve();
                    request.onerror = () => reject(request.error);
                });
            }
            
            console.log(`📊 Datos de ejemplo creados para Cuenta`);
        } catch (error) {
            console.error(`❌ Error creando datos para Cuenta:`, error);
        }
    }
    
    async seedTransaccionData(db) {
        const tableName = 'TRANSACCIONES';
        
        if (!db.objectStoreNames.contains(tableName)) return;
        
        try {
            const transaction = db.transaction([tableName], 'readwrite');
            const store = transaction.objectStore(tableName);
            
            for (let i = 1; i <= 3; i++) {
                const data = {
                    fecha_transaccion: `Transaccion ${i}`,
                    tipo_transaccion: `Transaccion ${i}`,
                    monto: (Math.round(Math.random() * 1000 * 100) / 100),
                    descripcion: `Transaccion ${i}`,
                    estado: `Transaccion ${i}`
                };
                
                // Añadir clave primaria si no es auto-increment
                
                await new Promise((resolve, reject) => {
                    const request = store.add(data);
                    request.onsuccess = () => resolve();
                    request.onerror = () => reject(request.error);
                });
            }
            
            console.log(`📊 Datos de ejemplo creados para Transaccion`);
        } catch (error) {
            console.error(`❌ Error creando datos para Transaccion:`, error);
        }
    }
    
    async seedEmpleadoData(db) {
        const tableName = 'EMPLEADOS';
        
        if (!db.objectStoreNames.contains(tableName)) return;
        
        try {
            const transaction = db.transaction([tableName], 'readwrite');
            const store = transaction.objectStore(tableName);
            
            for (let i = 1; i <= 3; i++) {
                const data = {
                    codigo_empleado: `Empleado ${i}`,
                    nombre: `Empleado ${i}`,
                    puesto: `Empleado ${i}`,
                    departamento: `Empleado ${i}`,
                    email: `Empleado ${i}`,
                    activo: (Math.random() > 0.5)
                };
                
                // Añadir clave primaria si no es auto-increment
                
                await new Promise((resolve, reject) => {
                    const request = store.add(data);
                    request.onsuccess = () => resolve();
                    request.onerror = () => reject(request.error);
                });
            }
            
            console.log(`📊 Datos de ejemplo creados para Empleado`);
        } catch (error) {
            console.error(`❌ Error creando datos para Empleado:`, error);
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
                    monto_solicitado: (Math.round(Math.random() * 1000 * 100) / 100),
                    tasa_interes: (Math.round(Math.random() * 1000 * 100) / 100),
                    plazo_meses: (Math.floor(Math.random() * 100) + 1),
                    estado_prestamo: `Prestamo ${i}`,
                    fecha_solicitud: `Prestamo ${i}`,
                    fecha_aprobacion: `Prestamo ${i}`
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
    
    async seedTarjetaCreditoData(db) {
        const tableName = 'TARJETAS_CREDITO';
        
        if (!db.objectStoreNames.contains(tableName)) return;
        
        try {
            const transaction = db.transaction([tableName], 'readwrite');
            const store = transaction.objectStore(tableName);
            
            for (let i = 1; i <= 3; i++) {
                const data = {
                    limite_credito: (Math.round(Math.random() * 1000 * 100) / 100),
                    saldo_actual: (Math.round(Math.random() * 1000 * 100) / 100),
                    fecha_vencimiento: `TarjetaCredito ${i}`,
                    activa: (Math.random() > 0.5)
                };
                
                // Añadir clave primaria si no es auto-increment
                data.numero_tarjeta = `tarjetacredito_${i}`;
                
                await new Promise((resolve, reject) => {
                    const request = store.add(data);
                    request.onsuccess = () => resolve();
                    request.onerror = () => reject(request.error);
                });
            }
            
            console.log(`📊 Datos de ejemplo creados para TarjetaCredito`);
        } catch (error) {
            console.error(`❌ Error creando datos para TarjetaCredito:`, error);
        }
    }
    
    
    async seedSurveyData(db) {
        if (!db.objectStoreNames.contains('ENCUESTAS')) return;
        
        try {
            const transaction = db.transaction(['ENCUESTAS'], 'readwrite');
            const store = transaction.objectStore('ENCUESTAS');
            
            const surveys = [
                {
                    nombre: 'preferenciasBancarias',
                    titulo: 'Encuesta de Servicios Preferidos',
                    descripcion: 'Ayúdanos a conocer tus preferencias bancarias',
                    tipo_representacion: 'CIRCULAR',
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
                    nombre: 'satisfaccionCliente',
                    titulo: 'Encuesta de Satisfacción Bancaria',
                    descripcion: 'Evalúa tu experiencia con nuestros servicios',
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
