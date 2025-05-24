/**
 * GESTOR DE DATOS SIMPLIFICADO - Sistema Bancario Digital
 * Funciones auxiliares para compatibilidad con páginas existentes
 */

class DataManager {
    constructor() {
        this.initialized = false;
        this.init();
    }

    async init() {
        // Esperar a que el sistema unificado esté disponible
        let attempts = 0;
        while (!window.DataWebApp && attempts < 50) {
            await new Promise(resolve => setTimeout(resolve, 100));
            attempts++;
        }

        if (window.DataWebApp) {
            this.app = window.DataWebApp;
            this.db = window.DataWebApp.db;
            this.initialized = true;
        } else {
            console.error('❌ Sistema unificado no disponible');
        }
    }

    async waitForInit() {
        while (!this.initialized) {
            await new Promise(resolve => setTimeout(resolve, 100));
        }
    }

    // Funciones de compatibilidad para páginas existentes
    async getAll(storeName) {
        await this.waitForInit();
        return await this.db.execute('getAll', storeName);
    }

    async create(storeName, data) {
        await this.waitForInit();
        return await this.db.execute('create', storeName, data);
    }

    async update(storeName, data) {
        await this.waitForInit();
        return await this.db.execute('update', storeName, data);
    }

    async delete(storeName, id) {
        await this.waitForInit();
        return await this.db.execute('delete', storeName, id);
    }

    async get(storeName, id) {
        await this.waitForInit();
        return await this.db.execute('get', storeName, id);
    }

    async query(storeName, filters) {
        await this.waitForInit();
        return await this.db.query(storeName, filters);
    }

    // Funciones específicas para entidades
    async getClienteAll() {
        return await this.getAll('CLIENTES');
    }

    async createCliente(data) {
        return await this.create('CLIENTES', data);
    }

    async updateCliente(data) {
        return await this.update('CLIENTES', data);
    }

    async deleteCliente(id) {
        return await this.delete('CLIENTES', id);
    }
    async getCuentaAll() {
        return await this.getAll('CUENTAS');
    }

    async createCuenta(data) {
        return await this.create('CUENTAS', data);
    }

    async updateCuenta(data) {
        return await this.update('CUENTAS', data);
    }

    async deleteCuenta(id) {
        return await this.delete('CUENTAS', id);
    }
    async getTransaccionAll() {
        return await this.getAll('TRANSACCIONES');
    }

    async createTransaccion(data) {
        return await this.create('TRANSACCIONES', data);
    }

    async updateTransaccion(data) {
        return await this.update('TRANSACCIONES', data);
    }

    async deleteTransaccion(id) {
        return await this.delete('TRANSACCIONES', id);
    }
    async getEmpleadoAll() {
        return await this.getAll('EMPLEADOS');
    }

    async createEmpleado(data) {
        return await this.create('EMPLEADOS', data);
    }

    async updateEmpleado(data) {
        return await this.update('EMPLEADOS', data);
    }

    async deleteEmpleado(id) {
        return await this.delete('EMPLEADOS', id);
    }
    async getPrestamoAll() {
        return await this.getAll('PRESTAMOS');
    }

    async createPrestamo(data) {
        return await this.create('PRESTAMOS', data);
    }

    async updatePrestamo(data) {
        return await this.update('PRESTAMOS', data);
    }

    async deletePrestamo(id) {
        return await this.delete('PRESTAMOS', id);
    }
    async getTarjetaCreditoAll() {
        return await this.getAll('TARJETAS_CREDITO');
    }

    async createTarjetaCredito(data) {
        return await this.create('TARJETAS_CREDITO', data);
    }

    async updateTarjetaCredito(data) {
        return await this.update('TARJETAS_CREDITO', data);
    }

    async deleteTarjetaCredito(id) {
        return await this.delete('TARJETAS_CREDITO', id);
    }

    // Funciones para encuestas y cuestionarios
    async getSurveys() {
        return await this.getAll('ENCUESTAS');
    }

    async getQuizzes() {
        return await this.getAll('CUESTIONARIOS');
    }

    async createSurvey(data) {
        return await this.create('ENCUESTAS', data);
    }

    async createQuiz(data) {
        return await this.create('CUESTIONARIOS', data);
    }

    // Utilidades
    showAlert(message, type = 'info') {
        if (this.app && this.app.ui) {
            this.app.ui.showAlert(message, type);
        } else {
            alert(message);
        }
    }

    getCurrentRole() {
        return localStorage.getItem('current_role');
    }

    setCurrentRole(roleName) {
        localStorage.setItem('current_role', roleName);
        if (this.app) {
            this.app.config.currentRole = roleName;
        }
    }
}

// Singleton global para compatibilidad
window.dataManager = new DataManager();

// Funciones globales de compatibilidad
window.loadTable = async function(tableId, storeName) {
    try {
        const data = await window.dataManager.getAll(storeName);
        const tbody = document.querySelector(`#${tableId} tbody`);
        
        if (!tbody || !data.length) return;
        
        tbody.innerHTML = data.map(row => {
            const cells = Object.values(row).map(value => `<td>${value || '-'}</td>`).join('');
            const actions = `
                <td>
                    <button class="btn btn-warning btn-sm" onclick="editRecord('${storeName}', '${row.id}')">Editar</button>
                    <button class="btn btn-danger btn-sm delete-btn" data-entity="${storeName}" data-id="${row.id}">Eliminar</button>
                </td>
            `;
            return `<tr>${cells}${actions}</tr>`;
        }).join('');
    } catch (error) {
        console.error('Error cargando tabla:', error);
    }
};

window.editRecord = function(storeName, id) {
    window.location.href = `edit.html?id=${id}`;
};

window.confirmDelete = function() {
    const modal = document.getElementById('deleteModal');
    if (modal) {
        modal.style.display = 'block';
    }
};

window.closeDeleteModal = function() {
    const modal = document.getElementById('deleteModal');
    if (modal) {
        modal.style.display = 'none';
    }
};

// Funciones específicas para formularios
window.validateForm = function(formId, rules = {}) {
    const form = document.getElementById(formId);
    if (!form) return true;
    
    let isValid = true;
    
    // Limpiar errores previos
    form.querySelectorAll('.error-message, .invalid-feedback').forEach(el => el.remove());
    form.querySelectorAll('.is-invalid').forEach(el => el.classList.remove('is-invalid'));
    
    // Validar campos requeridos
    form.querySelectorAll('[required]').forEach(field => {
        if (!field.value.trim()) {
            showFieldError(field, 'Este campo es obligatorio');
            isValid = false;
        }
    });
    
    return isValid;
};

window.showFieldError = function(field, message) {
    field.classList.add('is-invalid');
    const errorElement = document.createElement('div');
    errorElement.className = 'error-message invalid-feedback';
    errorElement.textContent = message;
    field.parentNode.appendChild(errorElement);
};

window.loadFormData = function(formId, data) {
    const form = document.getElementById(formId);
    if (!form || !data) return;
    
    for (const field of form.elements) {
        if (!field.name || data[field.name] === undefined) continue;
        
        if (field.type === 'checkbox') {
            field.checked = Boolean(data[field.name]);
        } else if (field.type === 'radio') {
            field.checked = (field.value == data[field.name]);
        } else if (field.tagName === 'SELECT') {
            for (const option of field.options) {
                if (option.value == data[field.name]) {
                    option.selected = true;
                    break;
                }
            }
        } else {
            field.value = data[field.name] || '';
        }
    }
};

// Funciones de utilidad
window.toggle = function(elementId) {
    const element = document.getElementById(elementId);
    if (element) {
        element.style.display = element.style.display === 'none' ? 'block' : 'none';
    }
};

window.formatDate = function(date, options = {}) {
    if (!date) return '-';
    const defaultOptions = {
        year: 'numeric',
        month: 'short',
        day: 'numeric'
    };
    return new Date(date).toLocaleDateString('es-ES', { ...defaultOptions, ...options });
};

window.formatNumber = function(number, decimals = 0) {
    if (typeof number !== 'number') return '-';
    return number.toLocaleString('es-ES', { 
        minimumFractionDigits: decimals, 
        maximumFractionDigits: decimals 
    });
};

// Inicialización automática
document.addEventListener('DOMContentLoaded', () => {
    // El DataManager se inicializa automáticamente
    console.log('📊 Data Manager inicializado');
});
