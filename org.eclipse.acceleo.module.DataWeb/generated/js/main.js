document.addEventListener('DOMContentLoaded', () => {
    // Inicialización de componentes principales
    initNavigation();
    initCRUDForms();
    initSurveys();
    initQuestionnaires();
});

function initNavigation() {
    const roleMenus = document.querySelectorAll('.role-menu');
	
    roleMenus.forEach(menu => {
        menu.addEventListener('click', (e) => {
            const roleName = e.currentTarget.dataset.role;
            console.log(`Navegando como rol: ${roleName}`);
            // Lógica de control de acceso basado en roles
            updateUIForRole(roleName);
        });
    });
}

function updateUIForRole(roleName) {
    // Ocultar/mostrar elementos según el rol
    const allRoleSpecificElements = document.querySelectorAll('&#91;data-role-access&#93;');
    allRoleSpecificElements.forEach(el => {
        const allowedRoles = (el.dataset.roleAccess || '').split(',').map(r => r.trim());
        el.style.display = allowedRoles.includes(roleName) ? 'block' : 'none';
    });
}

function handleAjaxError(error) {
    console.error('Error en solicitud AJAX:', error);
    showNotification('Error al procesar la solicitud', 'error');
}

function showNotification(message, type = 'info') {
    const notification = document.createElement('div');
    notification.classList.add('notification', `notification-${type}`);
    notification.textContent = message;
    document.body.appendChild(notification);
    
    setTimeout(() => {
        notification.remove();
    }, 3000);
}
