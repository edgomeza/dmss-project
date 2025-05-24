/**
* ARCHIVO PRINCIPAL DE APLICACIÓN - Sistema Bancario Digital
* Este archivo inicializa todo el sistema unificado
*/

// Configuración global de la aplicación
window.AppGlobalConfig = {
   name: 'Sistema Bancario Digital',
   version: '1.0.0',
   debug: true,
   entities: [
       {
           name: 'Cliente',
           tableName: 'CLIENTES',
           primaryKey: 'id_cliente'
       }
,       {
           name: 'Cuenta',
           tableName: 'CUENTAS',
           primaryKey: 'numero_cuenta'
       }
,       {
           name: 'Transaccion',
           tableName: 'TRANSACCIONES',
           primaryKey: 'id_transaccion'
       }
,       {
           name: 'Empleado',
           tableName: 'EMPLEADOS',
           primaryKey: 'id_empleado'
       }
,       {
           name: 'Prestamo',
           tableName: 'PRESTAMOS',
           primaryKey: 'id_prestamo'
       }
,       {
           name: 'TarjetaCredito',
           tableName: 'TARJETAS_CREDITO',
           primaryKey: 'numero_tarjeta'
       }
   ],
   roles: [
       'AdministradorBanco'
,        'GerenteOperaciones'
,        'EmpleadoBanco'
,        'Cliente'
   ],
   surveys: [
       {
           name: 'preferenciasBancarias',
           title: 'Encuesta de Servicios Preferidos',
           type: 'survey'
       }
   ],
   quizzes: [
       {
           name: 'satisfaccionCliente',
           title: 'Encuesta de Satisfacción Bancaria',
           type: 'quiz'
       }
   ]
};

// Función de inicialización administrativa
function initializeAdminRoles() {
   const adminRoles = [
       'AdministradorBanco', 
       'GerenteOperaciones', 
       
       
   ];
   
   localStorage.setItem('admin_roles', JSON.stringify(adminRoles));
   
   if (window.AppGlobalConfig.debug) {
       console.log('✅ Roles administrativos inicializados:', adminRoles);
   }
}

// Funciones de compatibilidad global (mantener para no romper código existente)
window.selectRole = function(roleName) {
   if (window.DataWebApp) {
       window.DataWebApp.setRole(roleName);
       return false;
   }
   
   // Fallback si la app no está lista
   localStorage.setItem('current_role', roleName);
   window.location.href = `${roleName.toLowerCase()}/dashboard.html`;
   return false;
};

window.openSurveyPage = function(surveyName) {
   if (window.DataWebApp && window.DataWebApp.surveys) {
       window.DataWebApp.surveys.openItem(surveyName, 'survey');
   } else {
       console.warn('Sistema de encuestas no disponible');
   }
};

window.openQuizPage = function(quizName) {
   if (window.DataWebApp && window.DataWebApp.surveys) {
       window.DataWebApp.surveys.openItem(quizName, 'quiz');
   } else {
       console.warn('Sistema de cuestionarios no disponible');
   }
};

// Funciones de utilidad global
window.DataWebUtils = {
   formatDate: function(date, options = {}) {
       if (!date) return '-';
       const defaultOptions = {
           year: 'numeric',
           month: 'short',
           day: 'numeric'
       };
       return new Date(date).toLocaleDateString('es-ES', { ...defaultOptions, ...options });
   },
   
   formatNumber: function(number, decimals = 0) {
       if (typeof number !== 'number') return '-';
       return number.toLocaleString('es-ES', { 
           minimumFractionDigits: decimals, 
           maximumFractionDigits: decimals 
       });
   },
   
   showNotification: function(message, type = 'info') {
       if (window.DataWebApp && window.DataWebApp.ui) {
           window.DataWebApp.ui.showAlert(message, type);
       } else {
           // Fallback básico
           alert(message);
       }
   },
   
   confirmAction: function(message, callback) {
       if (window.DataWebApp && window.DataWebApp.ui) {
           window.DataWebApp.ui.confirmAction(message, callback);
       } else {
           // Fallback básico
           if (confirm(message) && callback) {
               callback();
           }
       }
   },
   
   getCurrentRole: function() {
       return localStorage.getItem('current_role') || null;
   },
   
   isAdmin: function() {
       const currentRole = this.getCurrentRole();
       const adminRoles = JSON.parse(localStorage.getItem('admin_roles') || '[]');
       return adminRoles.includes(currentRole);
   }
};

// Event listener principal para inicialización
document.addEventListener('DOMContentLoaded', function() {
   if (window.AppGlobalConfig.debug) {
       console.log(`🚀 Iniciando ${window.AppGlobalConfig.name} v${window.AppGlobalConfig.version}`);
   }
   
   // Inicializar roles administrativos
   initializeAdminRoles();
   
   // Esperar a que todos los módulos estén disponibles antes de inicializar
   const checkModules = () => {
       const requiredModules = ['UnifiedDatabaseManager', 'UnifiedAppManager', 'UnifiedEntityManager', 'UnifiedSurveyQuizManager', 'UnifiedUIManager'];
       const availableModules = requiredModules.filter(module => typeof window[module] !== 'undefined');
       
       if (availableModules.length === requiredModules.length) {
           // Todos los módulos están disponibles, inicializar la aplicación
           if (window.AppGlobalConfig.debug) {
               console.log('✅ Todos los módulos cargados, inicializando aplicación...');
           }
           
           // El UnifiedAppManager se inicializa automáticamente mediante su propio DOMContentLoaded
           
       } else {
           // Faltan módulos, mostrar advertencia pero no bloquear
           const missingModules = requiredModules.filter(module => typeof window[module] === 'undefined');
           if (window.AppGlobalConfig.debug) {
               console.warn('⚠️ Módulos faltantes:', missingModules);
               console.warn('Algunas funcionalidades pueden no estar disponibles');
           }
       }
   };
   
   // Verificar módulos después de un breve delay para permitir que se carguen
   setTimeout(checkModules, 500);
   
   // Verificar si todos los scripts se cargaron correctamente después de más tiempo
   setTimeout(() => {
       if (window.DataWebApp) {
           if (window.AppGlobalConfig.debug) {
               console.log('✅ Sistema DataWeb inicializado correctamente');
               console.log('- Base de datos:', window.DataWebApp.db ? '✅' : '❌');
               console.log('- UI Manager:', window.DataWebApp.ui ? '✅' : '❌');
               console.log('- Entity Manager:', window.DataWebApp.entities ? '✅' : '❌');
               console.log('- Survey Manager:', window.DataWebApp.surveys ? '✅' : '❌');
           }
       } else {
           if (window.AppGlobalConfig.debug) {
               console.warn('⚠️ DataWebApp no se inicializó completamente');
               console.warn('Algunas funcionalidades avanzadas pueden no estar disponibles');
           }
       }
   }, 2000);
});

// Manejo de errores globales
window.addEventListener('error', function(event) {
   if (window.AppGlobalConfig.debug) {
       console.error('❌ Error global capturado:', event.error);
   }
   
   // En producción, podrías enviar estos errores a un servicio de logging
});

window.addEventListener('unhandledrejection', function(event) {
   if (window.AppGlobalConfig.debug) {
       console.error('❌ Promise rechazada no manejada:', event.reason);
   }
   
   // Prevenir que el error se muestre en consola del navegador
   event.preventDefault();
});

// Funciones de desarrollo y debugging
if (window.AppGlobalConfig.debug) {
   window.DataWebDebug = {
       showConfig: () => console.table(window.AppGlobalConfig),
       showDB: async () => {
           if (window.DataWebApp && window.DataWebApp.db) {
               const stores = window.AppGlobalConfig.entities.map(e => e.tableName);
               stores.push('ENCUESTAS', 'CUESTIONARIOS');
               
               for (const store of stores) {
                   try {
                       const data = await window.DataWebApp.db.execute('getAll', store);
                       console.log(`📊 ${store}:`, data);
                   } catch (error) {
                       console.log(`❌ ${store}: Error cargando`);
                   }
               }
           } else {
               console.warn('Base de datos no disponible');
           }
       },
       clearDB: async () => {
           if (confirm('¿Seguro que quieres limpiar toda la base de datos?')) {
               localStorage.clear();
               const databases = await indexedDB.databases();
               for (const db of databases) {
                   indexedDB.deleteDatabase(db.name);
               }
               location.reload();
           }
       },
       testAlert: (type = 'info') => {
           window.DataWebUtils.showNotification(`Prueba de alerta ${type}`, type);
       }
   };
   
   console.log('🔧 Herramientas de debug disponibles en window.DataWebDebug');
}
