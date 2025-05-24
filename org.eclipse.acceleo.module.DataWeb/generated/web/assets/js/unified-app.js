/**
 * GESTOR PRINCIPAL DE LA APLICACIÓN - Sistema Bancario Digital
 * Coordina todos los módulos del sistema
 */

class UnifiedAppManager {
    constructor() {
        this.config = {
            appName: 'Sistema Bancario Digital',
            debug: true,
            roles: [
                'AdministradorBanco'
,                 'GerenteOperaciones'
,                 'EmpleadoBanco'
,                 'Cliente'
            ],
            currentRole: localStorage.getItem('current_role') || null
        };
        
        this.db = window.UnifiedDB;
        this.ui = null;
        this.entities = null;
        this.surveys = null;
        this.initialized = false;
        
        // No inicializar automáticamente en el constructor
        // Se inicializará cuando se llame explícitamente
    }

    async init() {
        if (this.initialized) return;
        
        try {
            // Esperar a que la base de datos esté lista
            if (!this.db.initialized) {
                await this.db.init();
            }
            
            // Inicializar módulos en orden
            this.ui = new UnifiedUIManager(this);
            this.entities = new UnifiedEntityManager(this);
            this.surveys = new UnifiedSurveyQuizManager(this);
            
            this.setupGlobalEvents();
            await this.initCurrentPage();
            
            this.initialized = true;
            
            if (this.config.debug) {
                console.log(`✅ ${this.config.appName} inicializado correctamente`);
            }
        } catch (error) {
            console.error('❌ Error inicializando aplicación:', error);
        }
    }

    setupGlobalEvents() {
        // Manejo global de formularios
        document.addEventListener('submit', (e) => {
            const form = e.target;
            if (form.classList.contains('ajax-form') || form.classList.contains('unified-form')) {
                e.preventDefault();
                this.handleFormSubmit(form);
            }
        });

        // Manejo global de clics
        document.addEventListener('click', (e) => {
            const btn = e.target.closest('.btn');
            if (!btn) return;

            if (btn.classList.contains('delete-btn')) {
                e.preventDefault();
                this.handleDelete(btn);
            } else if (btn.classList.contains('role-btn')) {
                e.preventDefault();
                this.setRole(btn.dataset.role);
            }
        });

        // Auto-dismiss alerts
        setTimeout(() => {
            document.querySelectorAll('.alert[data-auto-dismiss="true"]').forEach(alert => {
                alert.style.opacity = '0';
                setTimeout(() => alert.remove(), 500);
            });
        }, 5000);
    }

    async handleFormSubmit(form) {
        const formType = form.dataset.type || 'generic';
        const entityType = form.dataset.entity;
        
        try {
            const formData = new FormData(form);
            let result;

            switch (formType) {
                case 'entity-create':
                case 'entity-update':
                    result = await this.entities.handleForm(formType, entityType, formData);
                    break;
                case 'survey-create':
                case 'quiz-create':
                    result = await this.surveys.handleForm(formType, formData);
                    break;
                default:
                    result = await this.handleGenericForm(form, formData);
            }

            if (result.success) {
                this.ui.showAlert(result.message || 'Operación exitosa', 'success');
                if (result.redirect) {
                    setTimeout(() => window.location.href = result.redirect, 1500);
                }
            } else {
                this.ui.showAlert(result.message || 'Error en la operación', 'danger');
            }
        } catch (error) {
            console.error('Error en formulario:', error);
            this.ui.showAlert('Error procesando formulario', 'danger');
        }
    }

    async handleDelete(btn) {
        const entityType = btn.dataset.entity;
        const itemId = btn.dataset.id;
        const confirmMsg = btn.dataset.confirm || '¿Seguro que deseas eliminar este elemento?';

        if (!confirm(confirmMsg)) return;

        try {
            let result;
            if (entityType) {
                result = await this.entities.deleteItem(entityType, itemId);
            } else {
                result = await this.handleGenericDelete(itemId);
            }

            if (result.success) {
                this.ui.showAlert('Elemento eliminado correctamente', 'success');
                if (result.reload) {
                    setTimeout(() => location.reload(), 1000);
                }
            } else {
                this.ui.showAlert(result.message || 'Error al eliminar', 'danger');
            }
        } catch (error) {
            console.error('Error eliminando:', error);
            this.ui.showAlert('Error al eliminar elemento', 'danger');
        }
    }

    setRole(roleName) {
        this.config.currentRole = roleName;
        localStorage.setItem('current_role', roleName);
        
        if (this.config.debug) {
            console.log(`✅ Rol establecido: ${roleName}`);
        }

        // Redirigir al dashboard del rol
        window.location.href = `${roleName.toLowerCase()}/dashboard.html`;
    }

    getCurrentRole() {
        return this.config.currentRole;
    }

    isAdmin() {
        const adminRoles = [
            'AdministradorBanco', 
            'GerenteOperaciones', 
            
            
        ];
        return adminRoles.includes(this.config.currentRole);
    }

    async initCurrentPage() {
        const path = window.location.pathname;
        
        // Dashboard pages
        if (path.includes('dashboard.html')) {
            await this.initDashboard();
        }
        // Entity pages
        else if (path.includes('/pages/')) {
            const pathParts = path.split('/');
            const roleName = pathParts[pathParts.indexOf('web') + 1];
            const entityName = pathParts[pathParts.length - 2];
            const pageName = pathParts[pathParts.length - 1].replace('.html', '');
            
            this.entities.initPage(entityName, pageName, roleName);
        }
        // Survey/Quiz pages
        else if (path.includes('surveys') || path.includes('quizzes')) {
            this.surveys.initPage(path);
        }
        // Admin pages
        else if (path.includes('admin')) {
            await this.initAdminPage();
        }
    }

    async initDashboard() {
        const currentRole = this.getCurrentRole();
        if (!currentRole) return;

        try {
            // Cargar encuestas y cuestionarios para el rol actual
            await this.surveys.loadForRole(currentRole);
            
            // Actualizar estadísticas si existen contenedores
            this.updateDashboardStats();
            
        } catch (error) {
            console.error('Error inicializando dashboard:', error);
        }
    }

    updateDashboardStats() {
        // Actualizar hora actual
        const updateTime = () => {
            const timeElement = document.getElementById('current-time');
            if (timeElement) {
                const now = new Date();
                timeElement.textContent = now.toLocaleTimeString('es-ES', { 
                    hour: '2-digit', 
                    minute: '2-digit' 
                });
            }
        };
        
        updateTime();
        setInterval(updateTime, 60000);
    }

    async initAdminPage() {
        if (!this.isAdmin()) {
            this.ui.showAlert('Acceso denegado: Se requieren permisos de administrador', 'danger');
            setTimeout(() => window.location.href = '../index.html', 2000);
            return;
        }

        const path = window.location.pathname;
        if (path.includes('surveys-admin')) {
            await this.surveys.initAdmin('surveys');
        } else if (path.includes('quizzes-admin')) {
            await this.surveys.initAdmin('quizzes');
        }
    }

    async handleGenericForm(form, formData) {
        // Manejo genérico de formularios no específicos
        return { success: true, message: 'Formulario procesado' };
    }

    async handleGenericDelete(itemId) {
        // Manejo genérico de eliminación
        return { success: true, reload: true };
    }
}

// Hacer disponible globalmente
window.UnifiedAppManager = UnifiedAppManager;

// Funciones globales para compatibilidad
window.selectRole = function(roleName) {
    if (window.DataWebApp) {
        window.DataWebApp.setRole(roleName);
    }
    return false;
};

window.openSurveyPage = function(surveyName) {
    if (window.DataWebApp && window.DataWebApp.surveys) {
        window.DataWebApp.surveys.openItem(surveyName, 'survey');
    }
};

window.openQuizPage = function(quizName) {
    if (window.DataWebApp && window.DataWebApp.surveys) {
        window.DataWebApp.surveys.openItem(quizName, 'quiz');
    }
};

// Inicialización global - esperar a que todos los módulos estén disponibles
document.addEventListener('DOMContentLoaded', async () => {
    // Verificar que todos los módulos estén disponibles
    const checkModules = () => {
        return typeof window.UnifiedDatabaseManager !== 'undefined' && 
               typeof window.UnifiedUIManager !== 'undefined' &&
               typeof window.UnifiedEntityManager !== 'undefined' &&
               typeof window.UnifiedSurveyQuizManager !== 'undefined';
    };
    
    // Esperar a que los módulos estén disponibles
    let attempts = 0;
    const maxAttempts = 10;
    
    const waitForModules = () => {
        if (checkModules() || attempts >= maxAttempts) {
            // Inicializar la aplicación
            window.DataWebApp = new UnifiedAppManager();
            window.DataWebApp.init().then(() => {
                console.log('✅ DataWebApp inicializado completamente');
            }).catch(error => {
                console.error('❌ Error inicializando DataWebApp:', error);
            });
        } else {
            attempts++;
            setTimeout(waitForModules, 200);
        }
    };
    
    // Comenzar la verificación
    setTimeout(waitForModules, 100);
});
