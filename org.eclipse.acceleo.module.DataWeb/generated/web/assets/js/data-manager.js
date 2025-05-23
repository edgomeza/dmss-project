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
            'cliente': 'CLIENTES'
,            'cuenta': 'CUENTAS'
,            'transaccion': 'TRANSACCIONES'
,            'empleado': 'EMPLEADOS'
,            'prestamo': 'PRESTAMOS'
,            'tarjetacredito': 'TARJETAS_CREDITO'
        };
        return tableMap[entityName] || entityName.toUpperCase();
    }

    getPrimaryKey() {
        const pkMap = {
            'CLIENTES': 'id_cliente'
,            'CUENTAS': 'numero_cuenta'
,            'TRANSACCIONES': 'id_transaccion'
,            'EMPLEADOS': 'id_empleado'
,            'PRESTAMOS': 'id_prestamo'
,            'TARJETAS_CREDITO': 'numero_tarjeta'
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
                    this.dbName = 'Sistema_Bancario Digital_DB';
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
                            if (!db.objectStoreNames.contains('CLIENTES')) {
                                console.log('Creating object store: CLIENTES');
                                const store = db.createObjectStore('CLIENTES', {
                                    keyPath: 'id_cliente',
                                    autoIncrement: true
                                });
                                
                                // Crear índices para búsquedas
                                store.createIndex('dni', 'dni', { unique: false });
                                store.createIndex('nombre', 'nombre', { unique: false });
                                store.createIndex('apellidos', 'apellidos', { unique: false });
                                store.createIndex('email', 'email', { unique: false });
                                store.createIndex('telefono', 'telefono', { unique: false });
                                store.createIndex('fecha_registro', 'fecha_registro', { unique: false });
                                store.createIndex('activo', 'activo', { unique: false });
                            }
                            if (!db.objectStoreNames.contains('CUENTAS')) {
                                console.log('Creating object store: CUENTAS');
                                const store = db.createObjectStore('CUENTAS', {
                                    keyPath: 'numero_cuenta',
                                    autoIncrement: true
                                });
                                
                                // Crear índices para búsquedas
                                store.createIndex('tipo_cuenta', 'tipo_cuenta', { unique: false });
                                store.createIndex('saldo', 'saldo', { unique: false });
                                store.createIndex('fecha_apertura', 'fecha_apertura', { unique: false });
                                store.createIndex('activa', 'activa', { unique: false });
                            }
                            if (!db.objectStoreNames.contains('TRANSACCIONES')) {
                                console.log('Creating object store: TRANSACCIONES');
                                const store = db.createObjectStore('TRANSACCIONES', {
                                    keyPath: 'id_transaccion',
                                    autoIncrement: true
                                });
                                
                                // Crear índices para búsquedas
                                store.createIndex('fecha_transaccion', 'fecha_transaccion', { unique: false });
                                store.createIndex('tipo_transaccion', 'tipo_transaccion', { unique: false });
                                store.createIndex('monto', 'monto', { unique: false });
                                store.createIndex('descripcion', 'descripcion', { unique: false });
                                store.createIndex('estado', 'estado', { unique: false });
                            }
                            if (!db.objectStoreNames.contains('EMPLEADOS')) {
                                console.log('Creating object store: EMPLEADOS');
                                const store = db.createObjectStore('EMPLEADOS', {
                                    keyPath: 'id_empleado',
                                    autoIncrement: true
                                });
                                
                                // Crear índices para búsquedas
                                store.createIndex('codigo_empleado', 'codigo_empleado', { unique: false });
                                store.createIndex('nombre', 'nombre', { unique: false });
                                store.createIndex('puesto', 'puesto', { unique: false });
                                store.createIndex('departamento', 'departamento', { unique: false });
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
                                store.createIndex('monto_solicitado', 'monto_solicitado', { unique: false });
                                store.createIndex('tasa_interes', 'tasa_interes', { unique: false });
                                store.createIndex('plazo_meses', 'plazo_meses', { unique: false });
                                store.createIndex('estado_prestamo', 'estado_prestamo', { unique: false });
                                store.createIndex('fecha_solicitud', 'fecha_solicitud', { unique: false });
                                store.createIndex('fecha_aprobacion', 'fecha_aprobacion', { unique: false });
                            }
                            if (!db.objectStoreNames.contains('TARJETAS_CREDITO')) {
                                console.log('Creating object store: TARJETAS_CREDITO');
                                const store = db.createObjectStore('TARJETAS_CREDITO', {
                                    keyPath: 'numero_tarjeta',
                                    autoIncrement: true
                                });
                                
                                // Crear índices para búsquedas
                                store.createIndex('limite_credito', 'limite_credito', { unique: false });
                                store.createIndex('saldo_actual', 'saldo_actual', { unique: false });
                                store.createIndex('fecha_vencimiento', 'fecha_vencimiento', { unique: false });
                                store.createIndex('activa', 'activa', { unique: false });
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
                        
                        // Verificar si Cliente ya tiene datos
                        const clienteCount = await this.count('CLIENTES');
                        if (clienteCount === 0) {
                            console.log('Inserting sample data for Cliente...');
                            // Crear 5 registros de ejemplo para Cliente
                            for (let i = 1; i <= 5; i++) {
                                const data = {
                                    dni: 'Cliente Ejemplo ' + i
,                                    nombre: 'Cliente Ejemplo ' + i
,                                    apellidos: 'Cliente Ejemplo ' + i
,                                    email: 'Cliente Ejemplo ' + i
,                                    telefono: 'Cliente Ejemplo ' + i
,                                    fecha_registro: 'Cliente Ejemplo ' + i
,                                    activo: (i % 2 === 0)
                                };
                                await this.create('CLIENTES', data);
                            }
                            console.log('✅ Sample data for Cliente inserted');
                        }
                        // Verificar si Cuenta ya tiene datos
                        const cuentaCount = await this.count('CUENTAS');
                        if (cuentaCount === 0) {
                            console.log('Inserting sample data for Cuenta...');
                            // Crear 5 registros de ejemplo para Cuenta
                            for (let i = 1; i <= 5; i++) {
                                const data = {
                                    tipo_cuenta: 'Cuenta Ejemplo ' + i
,                                    saldo: (i * 10.5)
,                                    fecha_apertura: 'Cuenta Ejemplo ' + i
,                                    activa: (i % 2 === 0)
                                };
                                await this.create('CUENTAS', data);
                            }
                            console.log('✅ Sample data for Cuenta inserted');
                        }
                        // Verificar si Transaccion ya tiene datos
                        const transaccionCount = await this.count('TRANSACCIONES');
                        if (transaccionCount === 0) {
                            console.log('Inserting sample data for Transaccion...');
                            // Crear 5 registros de ejemplo para Transaccion
                            for (let i = 1; i <= 5; i++) {
                                const data = {
                                    fecha_transaccion: 'Transaccion Ejemplo ' + i
,                                    tipo_transaccion: 'Transaccion Ejemplo ' + i
,                                    monto: (i * 10.5)
,                                    descripcion: 'Transaccion Ejemplo ' + i
,                                    estado: 'Transaccion Ejemplo ' + i
                                };
                                await this.create('TRANSACCIONES', data);
                            }
                            console.log('✅ Sample data for Transaccion inserted');
                        }
                        // Verificar si Empleado ya tiene datos
                        const empleadoCount = await this.count('EMPLEADOS');
                        if (empleadoCount === 0) {
                            console.log('Inserting sample data for Empleado...');
                            // Crear 5 registros de ejemplo para Empleado
                            for (let i = 1; i <= 5; i++) {
                                const data = {
                                    codigo_empleado: 'Empleado Ejemplo ' + i
,                                    nombre: 'Empleado Ejemplo ' + i
,                                    puesto: 'Empleado Ejemplo ' + i
,                                    departamento: 'Empleado Ejemplo ' + i
,                                    email: 'Empleado Ejemplo ' + i
,                                    activo: (i % 2 === 0)
                                };
                                await this.create('EMPLEADOS', data);
                            }
                            console.log('✅ Sample data for Empleado inserted');
                        }
                        // Verificar si Prestamo ya tiene datos
                        const prestamoCount = await this.count('PRESTAMOS');
                        if (prestamoCount === 0) {
                            console.log('Inserting sample data for Prestamo...');
                            // Crear 5 registros de ejemplo para Prestamo
                            for (let i = 1; i <= 5; i++) {
                                const data = {
                                    monto_solicitado: (i * 10.5)
,                                    tasa_interes: (i * 10.5)
,                                    plazo_meses: (i * 10)
,                                    estado_prestamo: 'Prestamo Ejemplo ' + i
,                                    fecha_solicitud: 'Prestamo Ejemplo ' + i
,                                    fecha_aprobacion: 'Prestamo Ejemplo ' + i
                                };
                                await this.create('PRESTAMOS', data);
                            }
                            console.log('✅ Sample data for Prestamo inserted');
                        }
                        // Verificar si TarjetaCredito ya tiene datos
                        const tarjetacreditoCount = await this.count('TARJETAS_CREDITO');
                        if (tarjetacreditoCount === 0) {
                            console.log('Inserting sample data for TarjetaCredito...');
                            // Crear 5 registros de ejemplo para TarjetaCredito
                            for (let i = 1; i <= 5; i++) {
                                const data = {
                                    limite_credito: (i * 10.5)
,                                    saldo_actual: (i * 10.5)
,                                    fecha_vencimiento: 'TarjetaCredito Ejemplo ' + i
,                                    activa: (i % 2 === 0)
                                };
                                await this.create('TARJETAS_CREDITO', data);
                            }
                            console.log('✅ Sample data for TarjetaCredito inserted');
                        }
                        
                        // Insertar datos de ejemplo para encuestas
                        const encuestasCount = await this.count('ENCUESTAS');
                        if (encuestasCount === 0) {
                            console.log('Inserting sample surveys...');
                            await this.create('ENCUESTAS', {
                                nombre: 'preferenciasBancarias',
                                titulo: 'Encuesta de Servicios Preferidos',
                                descripcion: 'Ayúdanos a conocer tus preferencias bancarias',
                                tipo_representacion: 'CIRCULAR'
                            });
                            console.log('✅ Sample surveys inserted');
                        }
                        
                        // Insertar datos de ejemplo para cuestionarios
                        const cuestionariosCount = await this.count('CUESTIONARIOS');
                        if (cuestionariosCount === 0) {
                            console.log('Inserting sample quizzes...');
                            await this.create('CUESTIONARIOS', {
                                nombre: 'satisfaccionCliente',
                                titulo: 'Encuesta de Satisfacción Bancaria',
                                descripcion: 'Evalúa tu experiencia con nuestros servicios'
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
