/**
* GESTOR UNIFICADO DE INTERFAZ - Sistema Bancario Digital
* Maneja alertas, modales y elementos de UI
*/

class UnifiedUIManager {
   constructor(app) {
       this.app = app;
       this.alertContainer = null;
       this.initUI();
   }

   initUI() {
       this.createAlertContainer();
       this.setupGlobalUIEvents();
   }

   createAlertContainer() {
       if (document.getElementById('unified-alerts')) return;
       
       const container = document.createElement('div');
       container.id = 'unified-alerts';
       container.className = 'alerts-container';
       container.style.cssText = `
           position: fixed;
           top: 20px;
           right: 20px;
           z-index: 9999;
           max-width: 400px;
       `;
       
       document.body.appendChild(container);
       this.alertContainer = container;
   }

   setupGlobalUIEvents() {
       // Manejo de navegación móvil
       document.addEventListener('click', (e) => {
           if (e.target.classList.contains('nav-toggle')) {
               e.preventDefault();
               this.toggleMobileNav();
           }
       });

       // Manejo de modales
       document.addEventListener('click', (e) => {
           if (e.target.classList.contains('modal') || e.target.classList.contains('modal-close')) {
               this.closeModal(e.target.closest('.modal') || e.target);
           }
       });

       // Auto-hide alerts
       document.addEventListener('click', (e) => {
           if (e.target.classList.contains('alert-close')) {
               e.target.closest('.alert').remove();
           }
       });
   }

   showAlert(message, type = 'info', duration = 5000) {
       const alert = document.createElement('div');
       alert.className = `alert alert-${type} alert-dismissible`;
       alert.innerHTML = `
           <div class="alert-content">
               <strong>${this.getAlertIcon(type)}</strong>
               <span>${message}</span>
           </div>
           <button type="button" class="alert-close" aria-label="Cerrar">×</button>
       `;
       
       // Estilos inline para asegurar que funcione
       alert.style.cssText = `
           display: flex;
           align-items: center;
           justify-content: space-between;
           padding: 12px 16px;
           margin-bottom: 10px;
           border-radius: 4px;
           box-shadow: 0 2px 8px rgba(0,0,0,0.1);
           animation: slideIn 0.3s ease;
           background: ${this.getAlertColor(type)};
           color: white;
       `;
       
       this.alertContainer.appendChild(alert);
       
       // Auto-remove después del tiempo especificado
       if (duration > 0) {
           setTimeout(() => {
               if (alert.parentNode) {
                   alert.style.animation = 'slideOut 0.3s ease';
                   setTimeout(() => alert.remove(), 300);
               }
           }, duration);
       }
       
       return alert;
   }

   getAlertIcon(type) {
       const icons = {
           success: '✓',
           danger: '✗',
           warning: '⚠',
           info: 'ℹ'
       };
       return icons[type] || icons.info;
   }

   getAlertColor(type) {
       const colors = {
           success: '#16a34a',
           danger: '#dc2626',
           warning: '#d97706',
           info: '#2563eb'
       };
       return colors[type] || colors.info;
   }

   showModal(title, content, actions = []) {
       const modal = document.createElement('div');
       modal.className = 'modal';
       modal.style.cssText = `
           position: fixed;
           top: 0;
           left: 0;
           width: 100%;
           height: 100%;
           background: rgba(0,0,0,0.5);
           display: flex;
           align-items: center;
           justify-content: center;
           z-index: 10000;
       `;
       
       modal.innerHTML = `
           <div class="modal-content" style="
               background: white;
               border-radius: 8px;
               max-width: 500px;
               width: 90%;
               max-height: 80vh;
               overflow-y: auto;
           ">
               <div class="modal-header" style="
                   display: flex;
                   justify-content: space-between;
                   align-items: center;
                   padding: 16px 20px;
                   border-bottom: 1px solid #e5e7eb;
               ">
                   <h3 style="margin: 0;">${title}</h3>
                   <button class="modal-close" style="
                       background: none;
                       border: none;
                       font-size: 24px;
                       cursor: pointer;
                       color: #6b7280;
                   ">×</button>
               </div>
               <div class="modal-body" style="padding: 20px;">
                   ${content}
               </div>
               ${actions.length > 0 ? `
               <div class="modal-footer" style="
                   display: flex;
                   gap: 10px;
                   padding: 16px 20px;
                   border-top: 1px solid #e5e7eb;
                   justify-content: flex-end;
               ">
                   ${actions.join('')}
               </div>
               ` : ''}
           </div>
       `;
       
       document.body.appendChild(modal);
       return modal;
   }

   closeModal(modal) {
       if (modal && modal.parentNode) {
           modal.remove();
       }
   }

   toggleMobileNav() {
       const navMenu = document.querySelector('.nav-menu');
       const navToggle = document.querySelector('.nav-toggle');
       
       if (navMenu && navToggle) {
           navMenu.classList.toggle('active');
           navToggle.classList.toggle('active');
       }
   }

   showLoading(container, message = 'Cargando...') {
       if (typeof container === 'string') {
           container = document.getElementById(container);
       }
       
       if (container) {
           container.innerHTML = `
               <div class="loading-spinner" style="
                   display: flex;
                   flex-direction: column;
                   align-items: center;
                   justify-content: center;
                   padding: 40px;
                   color: #6b7280;
               ">
                   <div class="spinner" style="
                       width: 32px;
                       height: 32px;
                       border: 3px solid #e5e7eb;
                       border-top: 3px solid #2563eb;
                       border-radius: 50%;
                       animation: spin 1s linear infinite;
                       margin-bottom: 16px;
                   "></div>
                   <p>${message}</p>
               </div>
           `;
       }
   }

   hideLoading(container) {
       if (typeof container === 'string') {
           container = document.getElementById(container);
       }
       
       if (container) {
           const spinner = container.querySelector('.loading-spinner');
           if (spinner) {
               spinner.remove();
           }
       }
   }

   confirmAction(message, callback) {
       const modal = this.showModal(
           'Confirmar Acción',
           `<p>${message}</p>`,
           [
               '<button class="btn btn-secondary" onclick="this.closest(\'.modal\').remove()">Cancelar</button>',
               '<button class="btn btn-danger" id="confirm-action">Confirmar</button>'
           ]
       );
       
       modal.querySelector('#confirm-action').addEventListener('click', () => {
           this.closeModal(modal);
           if (callback) callback();
       });
   }

   updateProgress(percentage, container) {
       if (typeof container === 'string') {
           container = document.getElementById(container);
       }
       
       if (container) {
           let progressBar = container.querySelector('.progress-bar');
           if (!progressBar) {
               progressBar = document.createElement('div');
               progressBar.className = 'progress-bar';
               progressBar.innerHTML = '<div class="progress-fill"></div>';
               progressBar.style.cssText = `
                   width: 100%;
                   height: 8px;
                   background: #e5e7eb;
                   border-radius: 4px;
                   overflow: hidden;
                   margin: 10px 0;
               `;
               
               const fill = progressBar.querySelector('.progress-fill');
               fill.style.cssText = `
                   height: 100%;
                   background: #2563eb;
                   transition: width 0.3s ease;
                   width: 0%;
               `;
               
               container.appendChild(progressBar);
           }
           
           const fill = progressBar.querySelector('.progress-fill');
           fill.style.width = `${Math.min(100, Math.max(0, percentage))}%`;
       }
   }

   formatDate(date, options = {}) {
       if (!date) return '-';
       
       const defaultOptions = {
           year: 'numeric',
           month: 'short',
           day: 'numeric',
           hour: '2-digit',
           minute: '2-digit'
       };
       
       return new Date(date).toLocaleDateString('es-ES', { ...defaultOptions, ...options });
   }

   formatNumber(number, decimals = 0) {
       if (typeof number !== 'number') return '-';
       return number.toLocaleString('es-ES', { minimumFractionDigits: decimals, maximumFractionDigits: decimals });
   }

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
}

// Hacer disponible globalmente
window.UnifiedUIManager = UnifiedUIManager;

// Estilos CSS que se inyectan automáticamente
const unifiedStyles = `
   @keyframes slideIn {
       from { transform: translateX(100%); opacity: 0; }
       to { transform: translateX(0); opacity: 1; }
   }
   
   @keyframes slideOut {
       from { transform: translateX(0); opacity: 1; }
       to { transform: translateX(100%); opacity: 0; }
   }
   
   @keyframes spin {
       0% { transform: rotate(0deg); }
       100% { transform: rotate(360deg); }
   }
   
   .nav-menu.active {
       display: block !important;
   }
   
   .nav-toggle.active span:nth-child(1) {
       transform: rotate(-45deg) translate(-5px, 6px);
   }
   
   .nav-toggle.active span:nth-child(2) {
       opacity: 0;
   }
   
   .nav-toggle.active span:nth-child(3) {
       transform: rotate(45deg) translate(-5px, -6px);
   }
   
   @media (max-width: 768px) {
       .nav-menu {
           display: none;
           position: absolute;
           top: 100%;
           left: 0;
           width: 100%;
           background: white;
           box-shadow: 0 2px 8px rgba(0,0,0,0.1);
       }
       
       .nav-menu.active {
           display: block;
       }
   }
`;

// Inyectar estilos solo una vez
if (!document.getElementById('unified-styles')) {
   const styleElement = document.createElement('style');
   styleElement.id = 'unified-styles';
   styleElement.textContent = unifiedStyles;
   document.head.appendChild(styleElement);
}
