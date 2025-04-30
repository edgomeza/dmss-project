document.addEventListener('DOMContentLoaded', () => {
    initNavigation();
});

function initNavigation() {
    // Selector de roles
    const roleSelect = document.getElementById('role-select');
    if (roleSelect) {
        // Establecer el rol inicial basado en la URL actual o usar el primer rol
        const currentPath = window.location.pathname;
        const roleFromPath = extractRoleFromPath(currentPath);
        
        if (roleFromPath) {
            roleSelect.value = roleFromPath;
            updateVisibleMenu(roleFromPath);
        } else {
            // Si no se puede extraer un rol, usar el primero de la lista
            const firstRole = roleSelect.options[0].value;
            roleSelect.value = firstRole;
            updateVisibleMenu(firstRole);
        }
        
        // Manejar el cambio de rol
        roleSelect.addEventListener('change', (e) => {
            const selectedRole = e.target.value;
            navigateToRoleHome(selectedRole);
        });
    }
    
    // Enlaces de navegación
    setupNavigationLinks();
}

function extractRoleFromPath(path) {
    // Extraer el rol de la ruta (formato: /rol/pagina.html)
    const matches = path.match(/\/(^+)\//);
    if (matches && matches.length > 1) {
        return matches[1];
    }
    return null;
}

function navigateToRoleHome(role) {
    window.location.href = `/${role}/index_home.html`;
}

function updateVisibleMenu(selectedRole) {
    // Ocultar todos los menús de rol
    const allRoleMenus = document.querySelectorAll('.role-menu');
    allRoleMenus.forEach(menu => {
        menu.style.display = 'none';
    });
    
    // Mostrar solo el menú del rol seleccionado
    const activeMenu = document.getElementById(`menu-${selectedRole}`);
    if (activeMenu) {
        activeMenu.style.display = 'block';
    }
}

function setupNavigationLinks() {
    const navLinks = document.querySelectorAll('.nav-item a');
    
    navLinks.forEach(link => {
        // Marcar enlaces activos
        if (link.href === window.location.href) {
            link.classList.add('active');
        }
        
        // Configurar eventos de clic
        link.addEventListener('click', (e) => {
            console.log(`Navegando a: ${link.href}`);
        });
    });
    
    // Manejar botones de operaciones
    const operationButtons = document.querySelectorAll('.operation-btn');
    operationButtons.forEach(button => {
        button.addEventListener('click', (e) => {
            console.log(`Ejecutando operación: ${button.textContent} en ${button.href}`);
        });
    });
}
