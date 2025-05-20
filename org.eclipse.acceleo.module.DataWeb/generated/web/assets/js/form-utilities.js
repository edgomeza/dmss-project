/**
 * Utilidades para formularios y validación
 */

// Función para validar un formulario
function validateForm(formId, rules) {
    const form = document.getElementById(formId);
    if (!form) {
        console.error('Formulario no encontrado:', formId);
        return true; // Si no encuentra el formulario, permite continuar
    }
    
    let isValid = true;
    
    // Eliminar mensajes de error previos
    const errorElements = form.querySelectorAll('.error-message, .invalid-feedback');
    errorElements.forEach(el => el.remove());
    
    // Quitar clase de error de todos los campos
    form.querySelectorAll('.is-invalid').forEach(el => el.classList.remove('is-invalid'));
    
    // Si no hay reglas, solo validar campos requeridos básicos
    if (!rules) {
        const requiredFields = form.querySelectorAll('[required]');
        requiredFields.forEach(field => {
            if (!field.value.trim()) {
                showFieldError(field, 'Este campo es obligatorio');
                isValid = false;
            }
        });
        return isValid;
    }
    
    // Validar cada campo según las reglas
    for (const fieldName in rules) {
        const field = form.elements[fieldName];
        if (!field) continue;
        
        const fieldRules = rules[fieldName];
        const value = field.value.trim();
        
        // Verificar si el campo es requerido
        if (fieldRules.required && !value) {
            showFieldError(field, 'Este campo es obligatorio');
            isValid = false;
            continue;
        }
        
        // Si el campo está vacío y no es requerido, saltar validaciones
        if (!value && !fieldRules.required) {
            continue;
        }
        
        // Verificar longitud mínima
        if (fieldRules.minLength && value.length < fieldRules.minLength) {
            showFieldError(field, `Debe tener al menos ${fieldRules.minLength} caracteres`);
            isValid = false;
            continue;
        }
        
        // Verificar longitud máxima
        if (fieldRules.maxLength && value.length > fieldRules.maxLength) {
            showFieldError(field, `No debe exceder los ${fieldRules.maxLength} caracteres`);
            isValid = false;
            continue;
        }
        
        // Verificar si es un número
        if (fieldRules.isNumeric && value && isNaN(Number(value))) {
            showFieldError(field, 'Debe ser un número válido');
            isValid = false;
            continue;
        }
        
        // Verificar si es un entero
        if (fieldRules.isInteger && value && !Number.isInteger(Number(value))) {
            showFieldError(field, 'Debe ser un número entero');
            isValid = false;
            continue;
        }
        
        // Verificar si es un decimal
        if (fieldRules.isDecimal && value) {
            const decimalPattern = /^\d+(.\d+)?$/;
if (!decimalPattern.test(value)) {
showFieldError(field, 'Debe ser un número decimal válido');
isValid = false;
continue;
}
}
    // Verificar si es un email
    if (fieldRules.isEmail && value) {
        const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        if (!emailPattern.test(value)) {
            showFieldError(field, 'Debe ser un email válido');
            isValid = false;
            continue;
        }
    }
    
    // Verificar si es una fecha
    if (fieldRules.isDate && value) {
        const datePattern = /^\d{4}-\d{2}-\d{2}$/;
        if (!datePattern.test(value) || isNaN(Date.parse(value))) {
            showFieldError(field, 'Debe ser una fecha válida en formato YYYY-MM-DD');
            isValid = false;
            continue;
        }
    }
    
    // Verificar valor mínimo (numérico)
    if (fieldRules.min !== undefined && value && Number(value) < fieldRules.min) {
        showFieldError(field, `El valor mínimo es ${fieldRules.min}`);
        isValid = false;
        continue;
    }
    
    // Verificar valor máximo (numérico)
    if (fieldRules.max !== undefined && value && Number(value) > fieldRules.max) {
        showFieldError(field, `El valor máximo es ${fieldRules.max}`);
        isValid = false;
        continue;
    }
    
    // Verificar expresión regular personalizada
    if (fieldRules.pattern && value && !new RegExp(fieldRules.pattern).test(value)) {
        showFieldError(field, fieldRules.patternMessage || 'Formato no válido');
        isValid = false;
        continue;
    }
    
    // Verificar función de validación personalizada
    if (fieldRules.custom && typeof fieldRules.custom === 'function') {
        const customResult = fieldRules.custom(value);
        if (customResult !== true) {
            showFieldError(field, customResult || 'Valor no válido');
            isValid = false;
            continue;
        }
    }
}

return isValid;
}
// Función para mostrar un error en un campo
function showFieldError(field, message) {
field.classList.add('is-invalid');
const errorElement = document.createElement('div');
errorElement.className = 'error-message invalid-feedback';
errorElement.textContent = message;
errorElement.style.color = 'var(--danger-600)';
errorElement.style.fontSize = '0.875rem';
errorElement.style.marginTop = '0.25rem';

// Insertar el error después del campo
if (field.parentNode) {
    field.parentNode.appendChild(errorElement);
}
}
// Función para cargar datos en un formulario
function loadFormData(formId, data) {
const form = document.getElementById(formId);
if (!form || !data) return;
// Recorrer todos los campos del formulario
for (const field of form.elements) {
    if (!field.name) continue;
    
    // Verificar si existe el dato correspondiente
    if (data[field.name] !== undefined) {
        if (field.type === 'checkbox') {
            field.checked = Boolean(data[field.name]);
        } else if (field.type === 'radio') {
            field.checked = (field.value == data[field.name]);
        } else if (field.tagName === 'SELECT') {
            // Para selects, intentamos encontrar la opción correspondiente
            for (const option of field.options) {
                if (option.value == data[field.name]) {
                    option.selected = true;
                    break;
                }
            }
        } else {
            field.value = data[field.name];
        }
    }
}
}
// Función para confirmar una acción
function confirmAction(message, yesCallback, noCallback) {
if (confirm(message)) {
if (yesCallback) yesCallback();
} else {
if (noCallback) noCallback();
}
}
// Función para limpiar errores de formulario
function clearFormErrors(formId) {
const form = document.getElementById(formId);
if (!form) return;
// Eliminar mensajes de error
const errorElements = form.querySelectorAll('.error-message, .invalid-feedback');
errorElements.forEach(el => el.remove());

// Quitar clases de error
form.querySelectorAll('.is-invalid').forEach(el => el.classList.remove('is-invalid'));
}
// Exportar funciones para uso global
if (typeof window !== 'undefined') {
window.validateForm = validateForm;
window.loadFormData = loadFormData;
window.showFieldError = showFieldError;
window.clearFormErrors = clearFormErrors;
window.confirmAction = confirmAction;
}
