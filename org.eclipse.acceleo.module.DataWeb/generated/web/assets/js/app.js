/**
 * Biblioteca Universitaria - Aplicación JavaScript Principal
 * Sistema de gestión de datos moderno y responsivo
 */

/**
 * Función para inicializar roles administrativos
 * Determina qué roles tienen acceso a más entidades (roles administrativos)
 */
async function initializeAdminRoles() {
    try {
        // Obtener todos los roles del sistema
        const rolesInfo = [
            {
                name: 'Administrador',
                entidadesAccesibles: 4
            }
,            {
                name: 'Bibliotecario',
                entidadesAccesibles: 3
            }
,            {
                name: 'Estudiante',
                entidadesAccesibles: 2
            }
        ];
        
        // Si no hay datos, usar un valor por defecto
        if (!rolesInfo || rolesInfo.length === 0) {
            console.warn('No se encontraron datos de roles. Usando valores por defecto.');
            return ['Admin', 'Administrador'];
        }
        
        // Determinar el número máximo de entidades accesibles
        const maxEntidades = Math.max(...rolesInfo.map(r => r.entidadesAccesibles));
        
        // Identificar roles administrativos (con acceso al máximo de entidades)
        const adminRoles = rolesInfo
            .filter(r => r.entidadesAccesibles === maxEntidades)
            .map(r => r.name);
            
        console.log('Roles administrativos detectados:', adminRoles);
            
        // Guardar roles administrativos en localStorage para referencia
        localStorage.setItem('admin_roles', JSON.stringify(adminRoles));
        
        return adminRoles;
    } catch (error) {
        console.error('Error inicializando roles administrativos:', error);
        return [];
    }
}

// Exponer función globalmente
window.initializeAdminRoles = initializeAdminRoles;

// Modificar la función de carga de asignaciones de roles para cuestionarios
async function loadQuizRoleAssignments() {
    try {
        // Obtener roles administrativos
        const adminRoles = JSON.parse(localStorage.getItem('admin_roles') || '[]');
        if (adminRoles.length === 0) {
            adminRoles = await initializeAdminRoles();
        }
        
        // Obtener asignaciones guardadas
        const assignments = JSON.parse(localStorage.getItem('quiz_role_assignments') || '{}');
        
        // Actualizar estado de los checkboxes
        const checkboxes = document.querySelectorAll('.role-checkbox[data-quiz]');
        checkboxes.forEach(checkbox => {
            const quizName = checkbox.dataset.quiz;
            const roleName = checkbox.dataset.role;
            
            // Si hay asignaciones guardadas para este cuestionario
            if (assignments[quizName] && assignments[quizName].includes(roleName)) {
                checkbox.checked = true;
            } 
            // Asignaciones por defecto para roles administrativos si no hay asignación explícita
            else if (!assignments[quizName] && adminRoles.includes(roleName)) {
                checkbox.checked = true;
            }
        });
    } catch (error) {
        console.error('Error cargando asignaciones de roles para cuestionarios:', error);
    }
}

// Configuración global de la aplicación
const AppConfig = {
    name: 'Biblioteca Universitaria',
    version: '1.0.0',
    debug: false,
    apiBaseUrl: '/api',
    defaultTimeout: 30000,
    animationDuration: 300
};

// Clase principal de la aplicación
class DataWebApp {
    constructor() {
        this.init();
        this.bindEvents();
        this.setupAnimations();
    }

    /**
     * Inicializa la aplicación
     */
    init() {
        // Verificar soporte del navegador
        this.checkBrowserSupport();
        
        // Configurar tema
        this.initTheme();
        
        // Configurar navegación móvil
        this.initMobileNavigation();
        
        // Configurar alertas auto-dismissible
        this.initAutoAlerts();
        
        // Configurar tooltips y componentes
        this.initComponents();
        
        // Mostrar mensaje de bienvenida en desarrollo
        if (AppConfig.debug) {
            console.log(`✅ Biblioteca Universitaria Application initialized successfully`);
        }
    }

    /**
     * Vincula eventos globales
     */
    bindEvents() {
        // Eventos de navegación
        document.addEventListener('click', this.handleNavigation.bind(this));
        
        // Eventos de formularios
        document.addEventListener('submit', this.handleFormSubmit.bind(this));
        
        // Eventos de alertas
        document.addEventListener('click', this.handleAlertClose.bind(this));
        
        // Eventos de navegación móvil
        document.addEventListener('click', this.handleNavToggle.bind(this));
        
        // Eventos de redimensionamiento
        window.addEventListener('resize', this.debounce(this.handleResize.bind(this), 250));
        
        // Eventos de scroll
        window.addEventListener('scroll', this.throttle(this.handleScroll.bind(this), 100));
    }

    /**
     * Configura las animaciones
     */
    setupAnimations() {
        // Intersección observer para animaciones
        if ('IntersectionObserver' in window) {
            const observer = new IntersectionObserver((entries) => {
                entries.forEach(entry => {
                    if (entry.isIntersecting) {
                        entry.target.style.animationDelay = `${entry.target.dataset.delay || 0}ms`;
                        entry.target.classList.add('animate');
                        observer.unobserve(entry.target);
                    }
                });
            }, {
                threshold: 0.1,
                rootMargin: '0px 0px -50px 0px'
            });

            // Observar elementos con clase animate-target
            document.querySelectorAll('.animate-target').forEach((el, index) => {
                el.dataset.delay = index * 100;
                observer.observe(el);
            });
        }
    }

    /**
     * Verifica soporte del navegador
     */
    checkBrowserSupport() {
        const requiredFeatures = [
            'fetch',
            'Promise',
            'classList',
            'addEventListener'
        ];

        const unsupported = requiredFeatures.filter(feature => !(feature in window));
        
        if (unsupported.length > 0) {
            console.warn('⚠️ Algunas características pueden no funcionar en este navegador');
            this.showBrowserWarning();
        }
    }

    /**
     * Muestra advertencia de navegador no soportado
     */
    showBrowserWarning() {
        const warning = document.createElement('div');
        warning.className = 'alert alert-warning browser-warning';
        warning.innerHTML = `
            <strong>Navegador no completamente soportado</strong>
            Para una mejor experiencia, considera actualizar tu navegador.
        `;
        document.body.insertBefore(warning, document.body.firstChild);
    }

    /**
     * Inicializa el sistema de temas
     */
    initTheme() {
        const savedTheme = localStorage.getItem('theme') || 'auto';
        this.setTheme(savedTheme);
        
        // Escuchar cambios en la preferencia del sistema
        if (window.matchMedia) {
            window.matchMedia('(prefers-color-scheme: dark)').addEventListener('change', () => {
                if (localStorage.getItem('theme') === 'auto') {
                    this.applyTheme();
                }
            });
        }
    }

    /**
     * Establece el tema de la aplicación
     * @param {string} theme - 'light', 'dark', o 'auto'
     */
    setTheme(theme) {
        localStorage.setItem('theme', theme);
        this.applyTheme(theme);
    }

    /**
     * Aplica el tema actual
     * @param {string} theme - Tema a aplicar
     */
    applyTheme(theme = localStorage.getItem('theme')) {
        const root = document.documentElement;
        
        if (theme === 'dark' || (theme === 'auto' && window.matchMedia('(prefers-color-scheme: dark)').matches)) {
            root.classList.add('dark');
        } else {
            root.classList.remove('dark');
        }
    }

    /**
     * Inicializa la navegación móvil
     */
    initMobileNavigation() {
        const navToggle = document.querySelector('.nav-toggle');
        const navMenu = document.querySelector('.nav-menu');
        
        if (navToggle && navMenu) {
            // Estado inicial
            navMenu.style.display = 'none';
            
            // Configurar en dispositivos móviles
            if (window.innerWidth <= 767) {
                navMenu.style.display = '';
            }
        }
    }

    /**
     * Maneja el toggle de navegación móvil
     * @param {Event} event - Evento de click
     */
    handleNavToggle(event) {
        if (event.target.closest('.nav-toggle')) {
            event.preventDefault();
            const navMenu = document.querySelector('.nav-menu');
            const navToggle = event.target.closest('.nav-toggle');
            
            if (navMenu) {
                navMenu.classList.toggle('show');
                navToggle.classList.toggle('active');
                
                // Accesibilidad
                const isExpanded = navMenu.classList.contains('show');
                navToggle.setAttribute('aria-expanded', isExpanded);
                
                // Cerrar al hacer click fuera
                if (isExpanded) {
                    const closeNav = (e) => {
                        if (!navMenu.contains(e.target) && !navToggle.contains(e.target)) {
                            navMenu.classList.remove('show');
                            navToggle.classList.remove('active');
                            navToggle.setAttribute('aria-expanded', 'false');
                            document.removeEventListener('click', closeNav);
                        }
                    };
                    setTimeout(() => document.addEventListener('click', closeNav), 100);
                }
            }
        }
    }

    /**
     * Inicializa alertas auto-dismissible
     */
    initAutoAlerts() {
        const autoAlerts = document.querySelectorAll('.alert[data-auto-dismiss="true"]');
        
        autoAlerts.forEach(alert => {
            const delay = parseInt(alert.dataset.dismissDelay) || 5000;
            
            setTimeout(() => {
                this.dismissAlert(alert);
            }, delay);
        });
    }

    /**
     * Maneja el cierre de alertas
     * @param {Event} event - Evento de click
     */
    handleAlertClose(event) {
        if (event.target.closest('.btn-close')) {
            event.preventDefault();
            const alert = event.target.closest('.alert');
            if (alert) {
                this.dismissAlert(alert);
            }
        }
    }

    /**
     * Cierra una alerta con animación
     * @param {Element} alert - Elemento de alerta a cerrar
     */
    dismissAlert(alert) {
        alert.style.opacity = '0';
        alert.style.transform = 'translateY(-20px)';
        
        setTimeout(() => {
            if (alert.parentNode) {
                alert.parentNode.removeChild(alert);
            }
        }, AppConfig.animationDuration);
    }

    /**
     * Inicializa componentes de la interfaz
     */
    initComponents() {
        // Configurar tooltips si existe la librería
        if (typeof bootstrap !== 'undefined' && bootstrap.Tooltip) {
            const tooltipTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="tooltip"]'));
            tooltipTriggerList.map(tooltipTriggerEl => new bootstrap.Tooltip(tooltipTriggerEl));
        }

        // Configurar popovers si existe la librería
        if (typeof bootstrap !== 'undefined' && bootstrap.Popover) {
            const popoverTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="popover"]'));
            popoverTriggerList.map(popoverTriggerEl => new bootstrap.Popover(popoverTriggerEl));
        }
        
        // Configurar contadores de caracteres en textareas
        this.initCharacterCounters();
        
        // Configurar validación de formularios en tiempo real
        this.initRealTimeValidation();
    }

    /**
     * Inicializa contadores de caracteres
     */
    initCharacterCounters() {
        const textareas = document.querySelectorAll('textarea[maxlength]');
        
        textareas.forEach(textarea => {
            const maxLength = parseInt(textarea.getAttribute('maxlength'));
            let counter = textarea.parentNode.querySelector('.textarea-counter span');
            
            if (!counter) {
                // Crear contador si no existe
                const counterDiv = document.createElement('div');
                counterDiv.className = 'textarea-counter';
                counterDiv.innerHTML = `<span>0</span>/${maxLength}`;
                textarea.parentNode.appendChild(counterDiv);
                counter = counterDiv.querySelector('span');
            }
            
            // Función para actualizar contador
            const updateCounter = () => {
                const currentLength = textarea.value.length;
                counter.textContent = currentLength;
                
                // Cambiar color si se acerca al límite
                const parentDiv = counter.parentNode;
                if (currentLength > maxLength * 0.9) {
                    parentDiv.style.color = 'var(--warning-600)';
                } else if (currentLength === maxLength) {
                    parentDiv.style.color = 'var(--danger-600)';
                } else {
                    parentDiv.style.color = 'var(--gray-500)';
                }
            };
            
            // Eventos para actualizar contador
            textarea.addEventListener('input', updateCounter);
            textarea.addEventListener('paste', () => setTimeout(updateCounter, 10));
            
            // Inicializar contador
            updateCounter();
        });
    }

    /**
     * Inicializa validación en tiempo real
     */
    initRealTimeValidation() {
        const forms = document.querySelectorAll('form[data-validate]');
        
        forms.forEach(form => {
            const inputs = form.querySelectorAll('input, textarea, select');
            
            inputs.forEach(input => {
                input.addEventListener('blur', () => this.validateField(input));
                input.addEventListener('input', this.debounce(() => this.validateField(input), 500));
            });
        });
    }

    /**
     * Valida un campo individual
     * @param {Element} field - Campo a validar
     */
    validateField(field) {
        const formGroup = field.closest('.form-group');
        if (!formGroup) return;
        
        // Limpiar validaciones anteriores
        field.classList.remove('is-valid', 'is-invalid');
        const feedback = formGroup.querySelector('.feedback');
        if (feedback) feedback.remove();
        
        // Validaciones básicas
        let isValid = true;
        let message = '';
        
        // Campo requerido
        if (field.hasAttribute('required') && !field.value.trim()) {
            isValid = false;
            message = 'Este campo es obligatorio';
        }
        
        // Validación de email
        if (field.type === 'email' && field.value) {
            const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
            if (!emailRegex.test(field.value)) {
                isValid = false;
                message = 'Introduce un email válido';
            }
        }
        
        // Longitud mínima
        if (field.hasAttribute('minlength')) {
            const minLength = parseInt(field.getAttribute('minlength'));
            if (field.value.length > 0 && field.value.length < minLength) {
                isValid = false;
                message = `Debe tener al menos ${minLength} caracteres`;
            }
        }
        
        // Aplicar resultado de validación
        field.classList.add(isValid ? 'is-valid' : 'is-invalid');
        
        if (!isValid) {
            const feedbackDiv = document.createElement('div');
            feedbackDiv.className = 'feedback invalid-feedback';
            feedbackDiv.textContent = message;
            formGroup.appendChild(feedbackDiv);
        }
        
        return isValid;
    }

    /**
     * Maneja envío de formularios
     * @param {Event} event - Evento de submit
     */
    handleFormSubmit(event) {
        const form = event.target;
        
        // Solo procesar formularios con validación
        if (!form.hasAttribute('data-validate')) return;
        
        const isValid = this.validateForm(form);
        
        if (!isValid) {
            event.preventDefault();
            
            // Scroll al primer campo con error
            const firstError = form.querySelector('.is-invalid');
            if (firstError) {
                firstError.scrollIntoView({ behavior: 'smooth', block: 'center' });
                firstError.focus();
            }
            
            // Mostrar mensaje de error general
            this.showAlert('Por favor, corrige los errores en el formulario', 'danger');
        }
    }

    /**
     * Valida un formulario completo
     * @param {Element} form - Formulario a validar
     * @returns {boolean} - True si es válido
     */
    validateForm(form) {
        const inputs = form.querySelectorAll('input, textarea, select');
        let isValid = true;
        
        inputs.forEach(input => {
            if (!this.validateField(input)) {
                isValid = false;
            }
        });
        
        return isValid;
    }

    /**
     * Maneja navegación con animaciones
     * @param {Event} event - Evento de click
     */
    handleNavigation(event) {
        const link = event.target.closest('a[href^="#"]');
        
        if (link) {
            event.preventDefault();
            const targetId = link.getAttribute('href').substring(1);
            const target = document.getElementById(targetId);
            
            if (target) {
                target.scrollIntoView({
                    behavior: 'smooth',
                    block: 'start'
                });
                
                // Actualizar URL sin saltar
                history.pushState(null, null, `#${targetId}`);
            }
        }
    }

    /**
     * Maneja eventos de resize
     */
    handleResize() {
        // Ajustar navegación móvil
        const navMenu = document.querySelector('.nav-menu');
        const navToggle = document.querySelector('.nav-toggle');
        
        if (navMenu && navToggle) {
            if (window.innerWidth > 767) {
                navMenu.classList.remove('show');
                navToggle.classList.remove('active');
                navToggle.setAttribute('aria-expanded', 'false');
            }
        }
        
        // Emitir evento personalizado para otros componentes
        window.dispatchEvent(new CustomEvent('app:resize'));
    }

    /**
     * Maneja eventos de scroll
     */
    handleScroll() {
        const scrollTop = window.pageYOffset;
        
        // Navegación sticky
        const nav = document.querySelector('.main-nav');
        if (nav) {
            nav.classList.toggle('scrolled', scrollTop > 50);
        }
        
        // Emitir evento personalizado
        window.dispatchEvent(new CustomEvent('app:scroll', { detail: { scrollTop } }));
    }

    /**
     * Muestra una alerta temporal
     * @param {string} message - Mensaje a mostrar
     * @param {string} type - Tipo de alerta (success, warning, danger, info)
     * @param {number} duration - Duración en ms
     */
    showAlert(message, type = 'info', duration = 5000) {
        const alertContainer = document.getElementById('alert-container') || this.createAlertContainer();
        
        const alert = document.createElement('div');
        alert.className = `alert alert-${type} alert-dismissible fade-in`;
        alert.setAttribute('role', 'alert');
        alert.innerHTML = `
            ${message}
            <button type="button" class="btn-close" aria-label="Cerrar"></button>
        `;
        
        alertContainer.appendChild(alert);
        
        // Auto-cerrar
        if (duration > 0) {
            setTimeout(() => this.dismissAlert(alert), duration);
        }
        
        return alert;
    }

    /**
     * Crea contenedor de alertas si no existe
     * @returns {Element} - Contenedor de alertas
     */
    createAlertContainer() {
        let container = document.getElementById('alert-container');
        
        if (!container) {
            container = document.createElement('div');
            container.id = 'alert-container';
            container.style.cssText = `
                position: fixed;
                top: 20px;
                right: 20px;
                z-index: 1055;
                max-width: 400px;
            `;
            document.body.appendChild(container);
        }
        
        return container;
    }

    /**
     * Hace una petición AJAX con manejo de errores
     * @param {string} url - URL de la petición
     * @param {Object} options - Opciones de fetch
     * @returns {Promise} - Promise con la respuesta
     */
    async ajax(url, options = {}) {
        const defaultOptions = {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
                'X-Requested-With': 'XMLHttpRequest'
            },
            timeout: AppConfig.defaultTimeout
        };
        
        const config = { ...defaultOptions, ...options };
        
        try {
            const controller = new AbortController();
            const timeoutId = setTimeout(() => controller.abort(), config.timeout);
            
            const response = await fetch(url, {
                ...config,
                signal: controller.signal
            });
            
            clearTimeout(timeoutId);
            
            if (!response.ok) {
                throw new Error(`HTTP ${response.status}: ${response.statusText}`);
            }
            
            const contentType = response.headers.get('content-type');
            if (contentType && contentType.includes('application/json')) {
                return await response.json();
            } else {
                return await response.text();
            }
            
        } catch (error) {
            if (error.name === 'AbortError') {
                throw new Error('La petición ha expirado');
            }
            throw error;
        }
    }

    /**
     * Función debounce para limitar ejecuciones
     * @param {Function} func - Función a ejecutar
     * @param {number} wait - Tiempo de espera en ms
     * @returns {Function} - Función debounced
     */
    debounce(func, wait) {
        let timeout;
        return function executedFunction(...args) {
            const later = () => {
                clearTimeout(timeout);
                func(...args);
            };
            clearTimeout(timeout);
            timeout = setTimeout(later, wait);
        };
    }

    /**
     * Función throttle para limitar ejecuciones
     * @param {Function} func - Función a ejecutar
     * @param {number} limit - Límite de tiempo en ms
     * @returns {Function} - Función throttled
     */
    throttle(func, limit) {
        let inThrottle;
        return function(...args) {
            if (!inThrottle) {
                func.apply(this, args);
                inThrottle = true;
                setTimeout(() => inThrottle = false, limit);
            }
        };
    }

    /**
     * Obtiene datos del localStorage de forma segura
     * @param {string} key - Clave a obtener
     * @param {*} defaultValue - Valor por defecto
     * @returns {*} - Valor almacenado o valor por defecto
     */
    getStorageItem(key, defaultValue = null) {
        try {
            const item = localStorage.getItem(key);
            return item ? JSON.parse(item) : defaultValue;
        } catch (error) {
            console.warn(`Error al leer localStorage[${key}]:`, error);
            return defaultValue;
        }
    }

    /**
     * Guarda datos en localStorage de forma segura
     * @param {string} key - Clave a guardar
     * @param {*} value - Valor a guardar
     * @returns {boolean} - True si se guardó correctamente
     */
    setStorageItem(key, value) {
        try {
            localStorage.setItem(key, JSON.stringify(value));
            return true;
        } catch (error) {
            console.warn(`Error al escribir localStorage[${key}]:`, error);
            return false;
        }
    }

    /**
     * Formatea fechas de forma localizada
     * @param {Date|string} date - Fecha a formatear
     * @param {Object} options - Opciones de formato
     * @returns {string} - Fecha formateada
     */
    formatDate(date, options = {}) {
        const defaultOptions = {
            year: 'numeric',
            month: 'long',
            day: 'numeric'
        };
        
        const formatOptions = { ...defaultOptions, ...options };
        const dateObj = typeof date === 'string' ? new Date(date) : date;
        
        return dateObj.toLocaleDateString('es-ES', formatOptions);
    }

    /**
     * Copia texto al portapapeles
     * @param {string} text - Texto a copiar
     * @returns {Promise<boolean>} - True si se copió correctamente
     */
    async copyToClipboard(text) {
        try {
            if (navigator.clipboard && window.isSecureContext) {
                await navigator.clipboard.writeText(text);
                return true;
            } else {
                // Fallback para navegadores más antiguos
                const textArea = document.createElement('textarea');
                textArea.value = text;
                textArea.style.position = 'fixed';
                textArea.style.left = '-999999px';
                textArea.style.top = '-999999px';
                document.body.appendChild(textArea);
                textArea.focus();
                textArea.select();
                
                const result = document.execCommand('copy');
                document.body.removeChild(textArea);
                return result;
            }
        } catch (error) {
            console.error('Error al copiar al portapapeles:', error);
            return false;
        }
    }

    /**
     * Registra métricas de rendimiento
     */
    trackPerformance() {
        if ('performance' in window && 'getEntriesByType' in performance) {
            window.addEventListener('load', () => {
                setTimeout(() => {
                    const perfData = performance.getEntriesByType('navigation')[0];
                    
                    if (AppConfig.debug) {
                        console.group(`📊 Biblioteca Universitaria Performance Metrics`);
                        console.log(`DOM Content Loaded: ${Math.round(perfData.domContentLoadedEventEnd - perfData.navigationStart)}ms`);
                        console.log(`Load Complete: ${Math.round(perfData.loadEventEnd - perfData.navigationStart)}ms`);
                        console.log(`First Paint: ${Math.round(perfData.fetchStart - perfData.navigationStart)}ms`);
                        console.groupEnd();
                    }
                }, 0);
            });
        }
    }
}

// =================================================
// GESTOR DE BASE DE DATOS LOCAL (IndexedDB)
// =================================================
class LocalDBManager {
    constructor() {
        this.dbName = 'Biblioteca_Universitaria_DB';
        this.version = 1;
        this.db = null;
    }

    async init() {
        return new Promise((resolve, reject) => {
            const request = indexedDB.open(this.dbName, this.version);
            
            request.onerror = () => reject(request.error);
            request.onsuccess = () => {
                this.db = request.result;
                this.initSampleData();
                resolve(this.db);
            };
            
            request.onupgradeneeded = (event) => {
                const db = event.target.result;
                
                // Crear tablas para entidades
                if (!db.objectStoreNames.contains('LIBROS')) {
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
                    const store = db.createObjectStore('CATEGORIAS', {
                        keyPath: 'id_categoria',
                        autoIncrement: true
                    });
                    
                    // Crear índices para búsquedas
                    store.createIndex('nombre_categoria', 'nombre_categoria', { unique: false });
                    store.createIndex('descripcion', 'descripcion', { unique: false });
                }
                if (!db.objectStoreNames.contains('USUARIOS')) {
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
                    const encuestasStore = db.createObjectStore('ENCUESTAS', { 
                        keyPath: 'id_encuesta', 
                        autoIncrement: true 
                    });
                    encuestasStore.createIndex('nombre', 'nombre', { unique: false });
                }
                
                if (!db.objectStoreNames.contains('PREGUNTAS_ENCUESTA')) {
                    const preguntasStore = db.createObjectStore('PREGUNTAS_ENCUESTA', { 
                        keyPath: 'id_pregunta', 
                        autoIncrement: true 
                    });
                    preguntasStore.createIndex('id_encuesta', 'id_encuesta', { unique: false });
                }
                
                if (!db.objectStoreNames.contains('RESPUESTAS_ENCUESTA')) {
                    const respuestasStore = db.createObjectStore('RESPUESTAS_ENCUESTA', { 
                        keyPath: 'id_respuesta', 
                        autoIncrement: true 
                    });
                    respuestasStore.createIndex('id_pregunta', 'id_pregunta', { unique: false });
                }
                
                if (!db.objectStoreNames.contains('CUESTIONARIOS')) {
                    const cuestionariosStore = db.createObjectStore('CUESTIONARIOS', { 
                        keyPath: 'id_cuestionario', 
                        autoIncrement: true 
                    });
                }
                
                if (!db.objectStoreNames.contains('PREGUNTAS_CUESTIONARIO')) {
                    const preguntasCuestionarioStore = db.createObjectStore('PREGUNTAS_CUESTIONARIO', { 
                        keyPath: 'id_pregunta', 
                        autoIncrement: true 
                    });
                    preguntasCuestionarioStore.createIndex('id_cuestionario', 'id_cuestionario', { unique: false });
                }
                
                if (!db.objectStoreNames.contains('RESPUESTAS_CUESTIONARIO')) {
                    const respuestasCuestionarioStore = db.createObjectStore('RESPUESTAS_CUESTIONARIO', { 
                        keyPath: 'id_respuesta', 
                        autoIncrement: true 
                    });
                    respuestasCuestionarioStore.createIndex('id_pregunta', 'id_pregunta', { unique: false });
                }
            };
        });
    }

    // Insertar datos de ejemplo automáticamente
    async initSampleData() {
        try {
            // Verificar si Libro ya tiene datos
            const libroCount = await this.count('LIBROS');
            if (libroCount === 0) {
                console.log('Insertando datos de ejemplo para Libro...');
                // Crear 5 registros de ejemplo para Libro
                for (let i = 1; i <= 5; i++) {
                    const data = {
                        titulo: 'Libro Ejemplo ' + i
,                        autor: 'Libro Ejemplo ' + i
,                        añoPublicacion: (i * 10)
,                        disponible: (i % 2 === 0)
                    };
                    await this.create('LIBROS', data);
                }
                console.log('✅ Datos de Libro insertados');
            }
            // Verificar si Categoria ya tiene datos
            const categoriaCount = await this.count('CATEGORIAS');
            if (categoriaCount === 0) {
                console.log('Insertando datos de ejemplo para Categoria...');
                // Crear 5 registros de ejemplo para Categoria
                for (let i = 1; i <= 5; i++) {
                    const data = {
                        nombre_categoria: 'Categoria Ejemplo ' + i
,                        descripcion: 'Categoria Ejemplo ' + i
                    };
                    await this.create('CATEGORIAS', data);
                }
                console.log('✅ Datos de Categoria insertados');
            }
            // Verificar si Usuario ya tiene datos
            const usuarioCount = await this.count('USUARIOS');
            if (usuarioCount === 0) {
                console.log('Insertando datos de ejemplo para Usuario...');
                // Crear 5 registros de ejemplo para Usuario
                for (let i = 1; i <= 5; i++) {
                    const data = {
                        nombre_usuario: 'Usuario Ejemplo ' + i
,                        email: 'Usuario Ejemplo ' + i
,                        activo: (i % 2 === 0)
                    };
                    await this.create('USUARIOS', data);
                }
                console.log('✅ Datos de Usuario insertados');
            }
            // Verificar si Prestamo ya tiene datos
            const prestamoCount = await this.count('PRESTAMOS');
            if (prestamoCount === 0) {
                console.log('Insertando datos de ejemplo para Prestamo...');
                // Crear 5 registros de ejemplo para Prestamo
                for (let i = 1; i <= 5; i++) {
                    const data = {
                        fechaPrestamo: 'Prestamo Ejemplo ' + i
,                        fechaDevolucion: 'Prestamo Ejemplo ' + i
                    };
                    await this.create('PRESTAMOS', data);
                }
                console.log('✅ Datos de Prestamo insertados');
            }
            
            // Insertar datos de ejemplo para encuestas
            const encuestasCount = await this.count('ENCUESTAS');
            if (encuestasCount === 0) {
                await this.create('ENCUESTAS', {
                    nombre: 'preferenciasBiblioteca',
                    titulo: 'Encuesta de Preferencias',
                    descripcion: 'Ayúdanos a conocer tus preferencias de lectura',
                    tipo_representacion: 'BARRAS'
                });
			console.log('✅ Encuestas de ejemplo insertadas');
            }
            
            // Insertar datos de ejemplo para cuestionarios
            const cuestionariosCount = await this.count('CUESTIONARIOS');
            if (cuestionariosCount === 0) {
                await this.create('CUESTIONARIOS', {
                    nombre: 'satisfaccionBiblioteca',
                    titulo: 'Cuestionario de Satisfacción',
                    descripcion: 'Evalúa tu experiencia con la biblioteca'
                });
                console.log('✅ Cuestionarios de ejemplo insertados');
            }
            
        } catch (error) {
            console.error('Error insertando datos de ejemplo:', error);
        }
    }

    // Métodos CRUD para IndexedDB
    async create(tableName, data) {
        return new Promise((resolve, reject) => {
            const transaction = this.db.transaction([tableName], 'readwrite');
            const store = transaction.objectStore(tableName);
            const request = store.add(data);
            
            request.onsuccess = () => resolve(request.result);
            request.onerror = () => reject(request.error);
        });
    }

    async getAll(tableName) {
        return new Promise((resolve, reject) => {
            const transaction = this.db.transaction([tableName], 'readonly');
            const store = transaction.objectStore(tableName);
            const request = store.getAll();
            
            request.onsuccess = () => resolve(request.result);
            request.onerror = () => reject(request.error);
        });
    }

    async getById(tableName, id) {
        return new Promise((resolve, reject) => {
            const transaction = this.db.transaction([tableName], 'readonly');
            const store = transaction.objectStore(tableName);
            const request = store.get(Number(id));
            
            request.onsuccess = () => resolve(request.result);
            request.onerror = () => reject(request.error);
        });
    }

    async update(tableName, data) {
        return new Promise((resolve, reject) => {
            const transaction = this.db.transaction([tableName], 'readwrite');
            const store = transaction.objectStore(tableName);
            const request = store.put(data);
            
            request.onsuccess = () => resolve(request.result);
            request.onerror = () => reject(request.error);
        });
    }

    async delete(tableName, id) {
        return new Promise((resolve, reject) => {
            const transaction = this.db.transaction([tableName], 'readwrite');
            const store = transaction.objectStore(tableName);
            const request = store.delete(Number(id));
            
            request.onsuccess = () => resolve(request.result);
            request.onerror = () => reject(request.error);
        });
    }

    async count(tableName) {
        return new Promise((resolve, reject) => {
            const transaction = this.db.transaction([tableName], 'readonly');
            const store = transaction.objectStore(tableName);
            const request = store.count();
            
            request.onsuccess = () => resolve(request.result);
            request.onerror = () => reject(request.error);
        });
    }

    async query(tableName, filters = {}) {
        return new Promise((resolve, reject) => {
            const transaction = this.db.transaction([tableName], 'readonly');
            const store = transaction.objectStore(tableName);
            const request = store.getAll();
            
            request.onsuccess = () => {
                let results = request.result;
                
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
                }
                
                resolve(results);
            };
            request.onerror = () => reject(request.error);
        });
    }
}

// Variable global para la base de datos
let localDB = null;

// Inicializar aplicación cuando el DOM esté listo
document.addEventListener('DOMContentLoaded', async () => {
    // PRIMERO: Inicializar base de datos local
    localDB = new LocalDBManager();
    try {
        await localDB.init();
        console.log('✅ Base de datos local inicializada correctamente');
    } catch (error) {
        console.error('❌ Error inicializando base de datos:', error);
    }
    
    // SEGUNDO: Instanciar aplicación principal  
    window.app = new DataWebApp();
    
    // Métricas de rendimiento en desarrollo
    if (AppConfig.debug) {
        window.app.trackPerformance();
    }
    
    // Exponer utilidades globalmente (para depuración)
    if (AppConfig.debug) {
        window.AppUtils = {
            showAlert: window.app.showAlert.bind(window.app),
            ajax: window.app.ajax.bind(window.app),
            copyToClipboard: window.app.copyToClipboard.bind(window.app),
            formatDate: window.app.formatDate.bind(window.app)
        };
    }
});

// Exportar para uso en módulos
if (typeof module !== 'undefined' && module.exports) {
    module.exports = { DataWebApp, LocalDBManager, AppConfig };
}
