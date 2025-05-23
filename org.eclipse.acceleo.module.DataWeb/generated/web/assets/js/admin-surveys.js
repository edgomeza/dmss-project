/**
 * Administración de encuestas
 */

// Roles reales del sistema generados desde el modelo
const SYSTEM_ROLES = [
    'AdministradorBanco'
,     'GerenteOperaciones'
,     'EmpleadoBanco'
,     'Cliente'
];

class SurveyAdmin {
    constructor() {
        this.init();
    }

    async initSystemRoles() {
        try {
            console.log('Inicializando roles del sistema...');
            
            // Usar los roles generados del modelo
            const systemRoles = SYSTEM_ROLES;
            
            // Hacer los roles disponibles globalmente para otros módulos
            window.systemRoles = systemRoles;
            
            console.log('✅ Roles del sistema inicializados:', systemRoles);
            return systemRoles;
            
        } catch (error) {
            console.error('Error inicializando roles del sistema:', error);
            const fallbackRoles = SYSTEM_ROLES.length > 0 ? SYSTEM_ROLES : ['Admin', 'Usuario'];
            window.systemRoles = fallbackRoles;
            return fallbackRoles;
        }
    }

    async init() {
        try {
            console.log("Inicializando SurveyAdmin...");
            
            // Inicializar la base de datos primero
            const db = await this.initDB();
            console.log("Base de datos inicializada:", db);
            
            // Cargar las encuestas
            await this.initSystemRoles();
            await this.loadSurveys();
            await this.loadPendingResponses();
            
            // Configurar los manejadores de eventos
            this.setupEventHandlers();
            
            console.log("SurveyAdmin inicializado correctamente");
        } catch (error) {
            console.error('Error initializing SurveyAdmin:', error);
            
            // Mostrar mensaje de error en el contenedor correcto
            const containers = ['surveysList', 'surveys-container', 'surveys-grid'];
            for (const containerId of containers) {
                const container = document.getElementById(containerId);
                if (container) {
                    container.innerHTML = `<p class="text-center text-danger">Error al cargar las encuestas: ${error.message}</p>`;
                    break;
                }
            }
        }
    }

    async refreshSystemRoles() {
        try {
            console.log('🔄 Actualizando roles del sistema...');
            
            // Los roles ya están definidos en SYSTEM_ROLES
            const roles = SYSTEM_ROLES;
            
            // Actualizar tabla de asignaciones
            await this.updateRoleAssignmentTable();
            
            console.log('✅ Roles actualizados:', roles);
            
            if (window.app && window.app.showAlert) {
                window.app.showAlert(`Roles actualizados: ${roles.join(', ')}`, 'success');
            }
            
            return roles;
        } catch (error) {
            console.error('Error actualizando roles:', error);
            if (window.app && window.app.showAlert) {
                window.app.showAlert('Error actualizando roles del sistema', 'danger');
            }
        }
    }

    async checkDatabaseContent() {
        try {
            console.log("Verificando contenido de la base de datos...");
            
            // Listar contenido de los almacenes principales
            const stores = ['ENCUESTAS', 'PREGUNTAS_ENCUESTA', 'OPCIONES_PREGUNTA', 'RESPUESTAS_ENCUESTA'];
            
            for (const store of stores) {
                try {
                    const items = await window.localDB.getAll(store);
                    console.log(`${store}: ${items.length} elementos`);
                    if (items.length > 0) {
                        console.log(`Muestra de ${store}:`, items[0]);
                    }
                } catch (e) {
                    console.warn(`No se pudo acceder al almacén ${store}:`, e);
                }
            }
        } catch (error) {
            console.error("Error al verificar el contenido de la base de datos:", error);
        }
    }

    closeResultsModal() {
        const modal = document.getElementById('resultsModal');
        if (modal) {
            modal.style.display = 'none';
        }
    }

    setupEventHandlers() {
        console.log("Configurando manejadores de eventos...");
        
        // Botones para eliminar encuestas
        document.addEventListener('click', async (e) => {
            if (e.target.classList.contains('survey-delete-btn')) {
                const surveyId = e.target.dataset.id;
                if (surveyId) {
                    this.deleteSurvey(surveyId);
                }
            }
        });
        
        // Botón para guardar asignaciones de roles
        const saveButton = document.getElementById('saveRoleAssignments');
        if (saveButton) {
            saveButton.addEventListener('click', () => {
                this.saveRoleAssignments();
            });
        }
        
        // Botón para cerrar modales
        const closeButtons = document.querySelectorAll('.close-modal');
        closeButtons.forEach(button => {
            button.addEventListener('click', () => {
                const modal = button.closest('.modal');
                if (modal) modal.style.display = 'none';
            });
        });
        
        // Botón para recargar la página
        const reloadButton = document.getElementById('reloadButton');
        if (reloadButton) {
            reloadButton.addEventListener('click', () => {
                window.location.reload();
            });
        }

        // Botón para guardar asignaciones de roles
        const saveRoleAssignments = document.getElementById('saveRoleAssignments');
        if (saveRoleAssignments) {
            saveRoleAssignments.addEventListener('click', () => {
                this.saveSurveyRoleAssignments();
            });
        }
        
        // Cargar asignaciones de roles al inicializar
        setTimeout(() => {
            this.loadSurveyRoleAssignments();
        }, 1000);
    }

    async loadSurveys() {
        try {
            console.log("Cargando encuestas desde la base de datos...");
            
            // Buscar el contenedor correcto
            let surveysContainer = document.getElementById('surveysList') || 
                                  document.querySelector('.surveys-grid') || 
                                  document.getElementById('surveys-container');
            
            if (!surveysContainer) {
                console.warn('No surveys container found, creating one');
                const mainContent = document.querySelector('.main-content .container');
                if (mainContent) {
                    const section = document.createElement('section');
                    section.innerHTML = '<div class="card"><div class="card-body"><div id="surveysList"></div></div></div>';
                    mainContent.appendChild(section);
                    surveysContainer = document.getElementById('surveysList');
                } else {
                    console.error('No main content container found');
                    return;
                }
            }
            
            // Mostrar indicador de carga
            surveysContainer.innerHTML = '<p class="text-center">Cargando encuestas...</p>';
            
            // Obtener todas las encuestas de la base de datos
            let surveys = [];
            try {
                surveys = await window.localDB.getAll('ENCUESTAS');
                console.log('Encuestas cargadas desde DB:', surveys.length, surveys);
            } catch (error) {
                console.error('Error al obtener encuestas:', error);
                surveysContainer.innerHTML = `<p class="text-center text-danger">Error al cargar las encuestas: ${error.message}</p>`;
                return;
            }
            
            // Verificar si hay encuestas para mostrar
            if (surveys.length === 0) {
                surveysContainer.innerHTML = `
                    <div class="text-center p-4">
                        <h4>No hay encuestas disponibles</h4>
                        <p>Crea una nueva encuesta para comenzar.</p>
                        <a href="create-survey.html" class="btn btn-primary">
                            <i class="fas fa-plus"></i> Crear Nueva Encuesta
                        </a>
                    </div>
                `;
                return;
            }
            
            // Mostrar las encuestas en el contenedor
            const surveysHTML = surveys.map((survey, index) => {
                const surveyId = survey.id_encuesta;
                const surveyName = survey.nombre || `Encuesta ${index + 1}`;
                const surveyTitle = survey.titulo || surveyName;
                const surveyDesc = survey.descripcion || 'Sin descripción';
                const surveyRepresentation = survey.tipo_representacion || 'Tabla';
                
                let representationIcon = 'fas fa-table';
                if (surveyRepresentation === 'Grafica') {
                    representationIcon = 'fas fa-chart-bar';
                } else if (surveyRepresentation === 'Lista') {
                    representationIcon = 'fas fa-list';
                }
                
                return `
                    <div class="survey-item card mb-3" data-survey="${surveyName}">
                        <div class="card-body">
                            <div class="survey-details">
                                <h5 class="card-title">${surveyTitle}</h5>
                                <p class="card-text">${surveyDesc}</p>
                                <div class="survey-meta">
                                    <small class="text-muted">
                                        <span><i class="fas fa-user"></i> ${surveyName}</span> |
                                        <span><i class="${representationIcon}"></i> ${surveyRepresentation}</span> |
                                        <span><i class="fas fa-question-circle"></i> ID: ${surveyId}</span>
                                    </small>
                                </div>
                            </div>
                            <div class="survey-actions mt-3">
                                <a href="edit-survey.html?id=${surveyId}" class="btn btn-primary btn-sm">
                                    <i class="fas fa-edit"></i> Editar
                                </a>
                                <button class="btn btn-success btn-sm" onclick="viewSurveyResults('${surveyName}')">
                                    <i class="fas fa-chart-line"></i> Estadísticas
                                </button>
                                <button class="btn btn-danger btn-sm survey-delete-btn" data-id="${surveyId}">
                                    <i class="fas fa-trash"></i> Eliminar
                                </button>
                            </div>
                        </div>
                    </div>
                `;
            });
            
            surveysContainer.innerHTML = surveysHTML.join('');
            console.log(`✅ Se han mostrado ${surveys.length} encuestas`);
            await this.updateRoleAssignmentTable();
        } catch (error) {
            console.error('Error loading surveys:', error);
            const surveysContainer = document.getElementById('surveysList') || 
                                    document.querySelector('.surveys-grid');
            if (surveysContainer) {
                surveysContainer.innerHTML = `<p class="text-center text-danger">Error al cargar las encuestas: ${error.message}</p>`;
            }
        }
    }

    async updateRoleAssignmentTable() {
        try {
            const surveys = await window.localDB.getAll('ENCUESTAS');
            const roleAssignmentTable = document.querySelector('.role-assignments tbody');
            
            if (!roleAssignmentTable || surveys.length === 0) {
                console.log('No role assignment table found or no surveys');
                return;
            }
            
            // Usar los roles del sistema generados
            const availableRoles = SYSTEM_ROLES;
            
            console.log('Roles disponibles para encuestas:', availableRoles);
            
            // Generar cabecera de la tabla
            const tableHeader = document.querySelector('.role-assignments thead tr');
            if (tableHeader) {
                tableHeader.innerHTML = `
                    <th>Encuesta</th>
                    ${availableRoles.map(role => `<th>${role}</th>`).join('')}
                `;
            }
            
            // Generar filas de la tabla
            const tableHTML = surveys.map(survey => {
                return `
                    <tr>
                        <td><strong>${survey.titulo || survey.nombre}</strong><br><small class="text-muted">${survey.nombre}</small></td>
                        ${availableRoles.map(role => `
                            <td>
                                <div class="role-toggle">
                                    <input type="checkbox" id="role_${survey.nombre}_${role}" 
                                           class="role-checkbox"
                                           data-survey="${survey.nombre}" 
                                           data-role="${role}">
                                    <label for="role_${survey.nombre}_${role}" class="role-label"></label>
                                </div>
                            </td>
                        `).join('')}
                    </tr>
                `;
            }).join('');
            
            roleAssignmentTable.innerHTML = tableHTML;
            
            // Cargar asignaciones existentes
            await this.loadSurveyRoleAssignments();
            
            console.log('✅ Tabla de asignaciones de encuestas actualizada');
            
        } catch (error) {
            console.error('Error updating role assignment table:', error);
        }
    }

    async loadSurveyRoleAssignments() {
        try {
            console.log("Cargando asignaciones de roles para encuestas...");
            
            // Obtener asignaciones guardadas
            const assignments = JSON.parse(localStorage.getItem('survey_role_assignments') || '{}');
            
            // Actualizar estado de los checkboxes
            const checkboxes = document.querySelectorAll('.role-checkbox[data-survey]');
            checkboxes.forEach(checkbox => {
                const surveyName = checkbox.dataset.survey;
                const roleName = checkbox.dataset.role;
                
                // Si hay asignaciones guardadas para esta encuesta
                if (assignments[surveyName] && assignments[surveyName].includes(roleName)) {
                    checkbox.checked = true;
                } 
                // Asignaciones por defecto para roles administrativos si no hay asignación explícita
                else if (!assignments[surveyName] && this.isAdminRole(roleName)) {
                    checkbox.checked = true;
                }
            });
        } catch (error) {
            console.error('Error cargando asignaciones de roles para encuestas:', error);
        }
    }

    isAdminRole(roleName) {
        // Detectar roles administrativos basándose en el nombre
        const adminKeywords = ['admin', 'administrador', 'director', 'coordinador'];
        return adminKeywords.some(keyword => roleName.toLowerCase().includes(keyword));
    }

    // Función simplificada para obtener roles del sistema
    getSystemRolesFromTemplate() {
        return SYSTEM_ROLES;
    }
    
    // Función mejorada para sincronizar roles entre módulos
    async syncSystemRoles() {
        try {
            return SYSTEM_ROLES;
        } catch (error) {
            console.error('Error sincronizando roles del sistema:', error);
            return SYSTEM_ROLES.length > 0 ? SYSTEM_ROLES : ['Admin', 'Usuario'];
        }
    }
        
    async saveSurveyRoleAssignments() {
        try {
            console.log("Guardando asignaciones de roles para encuestas...");
            
            // Recopilar todas las asignaciones
            const checkboxes = document.querySelectorAll('.role-checkbox[data-survey]');
            const assignments = {};
            
            checkboxes.forEach(checkbox => {
                const surveyName = checkbox.dataset.survey;
                const roleName = checkbox.dataset.role;
                
                if (!assignments[surveyName]) {
                    assignments[surveyName] = [];
                }
                
                if (checkbox.checked) {
                    assignments[surveyName].push(roleName);
                }
            });
            
            // Guardar en localStorage
            localStorage.setItem('survey_role_assignments', JSON.stringify(assignments));
            
            if (window.app && window.app.showAlert) {
                window.app.showAlert('Asignaciones de encuestas guardadas correctamente', 'success');
            } else {
                alert('Asignaciones de encuestas guardadas correctamente');
            }
        } catch (error) {
            console.error('Error al guardar asignaciones de encuestas:', error);
            if (window.app && window.app.showAlert) {
                window.app.showAlert('Error al guardar las asignaciones de encuestas', 'danger');
            } else {
                alert('Error al guardar las asignaciones de encuestas');
            }
        }
    }

    async loadSurveyStats() {
        try {
            console.log("Cargando estadísticas de encuestas...");
            
            // Actualizar estadísticas globales
            const totalResponsesEl = document.getElementById('total-responses');
            const pendingResponsesEl = document.getElementById('pending-responses');
            const approvedResponsesEl = document.getElementById('approved-responses');
            
            if (totalResponsesEl) totalResponsesEl.textContent = '0';
            if (pendingResponsesEl) pendingResponsesEl.textContent = '0';
            if (approvedResponsesEl) approvedResponsesEl.textContent = '0';
            
            const surveys = document.querySelectorAll('[data-survey]');
            
            if (surveys.length === 0) {
                console.log("No hay encuestas para cargar estadísticas");
                return;
            }
            
            let totalResponses = 0;
            let totalPending = 0;
            let totalApproved = 0;
            
            for (const surveyElement of surveys) {
                const surveyName = surveyElement.dataset.survey;
                const responses = await this.getSurveyResponses(surveyName);
                const pending = responses.filter(r => !r.approved).length;
                const approved = responses.filter(r => r.approved).length;
                
                totalResponses += responses.length;
                totalPending += pending;
                totalApproved += approved;
                
                const responsesElement = document.getElementById(`responses-${surveyName}`);
                const pendingElement = document.getElementById(`pending-${surveyName}`);
                
                if (responsesElement) {
                    responsesElement.textContent = responses.length;
                }
                
                if (pendingElement) {
                    pendingElement.textContent = pending;
                    pendingElement.style.backgroundColor = pending > 0 ? 'var(--warning-100)' : 'var(--gray-100)';
                    pendingElement.style.color = pending > 0 ? 'var(--warning-700)' : 'var(--gray-600)';
                }
            }
            
            // Actualizar estadísticas globales
            if (totalResponsesEl) totalResponsesEl.textContent = totalResponses;
            if (pendingResponsesEl) pendingResponsesEl.textContent = totalPending;
            if (approvedResponsesEl) approvedResponsesEl.textContent = totalApproved;
            
        } catch (error) {
            console.error('Error cargando estadísticas:', error);
            
            // Mostrar mensaje de error en lugar de loading infinito
            const statsElements = document.querySelectorAll('[id*="total-"], [id*="pending-"], [id*="approved-"]');
            statsElements.forEach(el => {
                if (el.textContent === '--') {
                    el.textContent = 'Error';
                    el.style.color = 'var(--danger-600)';
                }
            });
        }
    }
    
    generateSurveyQuestionOptions(question, questionIndex) {
        if (question.tipo === 'opcion_multiple') {
            return question.opciones.map((option) => `
                <div class="option-card">
                    <input type="radio" id="q${questionIndex}_${option.valor}" name="question_${questionIndex}" value="${option.valor}" class="option-input" required>
                    <label for="q${questionIndex}_${option.valor}" class="option-label">
                        <div class="option-check"></div>
                        <div class="option-content">
                            <span class="option-text">${option.texto}</span>
                        </div>
                    </label>
                </div>
            `).join('');
        } else if (question.tipo === 'verdadero_falso') {
            return `
                <div class="option-card">
                    <input type="radio" id="q${questionIndex}_true" name="question_${questionIndex}" value="true" class="option-input" required>
                    <label for="q${questionIndex}_true" class="option-label">
                        <div class="option-check"></div>
                        <div class="option-content">
                            <span class="option-text">Verdadero</span>
                        </div>
                    </label>
                </div>
                <div class="option-card">
                    <input type="radio" id="q${questionIndex}_false" name="question_${questionIndex}" value="false" class="option-input" required>
                    <label for="q${questionIndex}_false" class="option-label">
                        <div class="option-check"></div>
                        <div class="option-content">
                            <span class="option-text">Falso</span>
                        </div>
                    </label>
                </div>
            `;
        } else if (question.tipo === 'respuesta_corta') {
            return `
                <div class="textarea-container">
                    <textarea id="q${questionIndex}_text" name="question_${questionIndex}" rows="4" class="form-textarea" placeholder="Escribe tu respuesta aquí..." required maxlength="500"></textarea>
                    <div class="textarea-counter">
                        <span id="q${questionIndex}_counter">0</span>/500 caracteres
                    </div>
                </div>
            `;
        }
        return '';
    }

    async loadPendingResponses() {
        try {
            console.log("Cargando respuestas pendientes...");
            const pendingTable = document.getElementById('pendingResponsesTable');
            if (!pendingTable) {
                console.warn('Pending responses table not found');
                return;
            }
    
            // Mostrar loading inicial
            pendingTable.innerHTML = `
                <div class="text-center p-3">
                    <div class="loading-spinner"></div>
                    <span>Cargando respuestas pendientes...</span>
                </div>
            `;
    
            const allPending = [];
            const processedIds = new Set();
            
            // Obtener todas las encuestas primero
            const surveys = await window.localDB.getAll('ENCUESTAS');
            console.log('Encuestas encontradas:', surveys.length);
            
            if (surveys.length === 0) {
                pendingTable.innerHTML = `
                    <div class="text-center p-4">
                        <div class="text-muted mb-2">
                            <i class="fas fa-poll fa-2x"></i>
                        </div>
                        <p class="text-muted">No hay encuestas disponibles para revisar</p>
                    </div>
                `;
                return;
            }
            
            // Buscar respuestas pendientes para cada encuesta
            for (const survey of surveys) {
                try {
                    const responses = await this.getSurveyResponses(survey.nombre);
                    console.log(`Respuestas para ${survey.nombre}:`, responses.length);
                    
                    const pending = responses.filter(r => !r.approved);
                    console.log(`Pendientes para ${survey.nombre}:`, pending.length);
                    
                    pending.forEach(response => {
                        if (!processedIds.has(response.id)) {
                            processedIds.add(response.id);
                            response.surveyName = survey.nombre;
                            response.surveyTitle = survey.titulo;
                            allPending.push(response);
                        }
                    });
                } catch (error) {
                    console.warn(`Error cargando respuestas para ${survey.nombre}:`, error);
                }
            }
    
            console.log('Total de respuestas pendientes:', allPending.length);
    
            if (allPending.length === 0) {
                pendingTable.innerHTML = `
                    <div class="text-center p-4">
                        <div class="text-success mb-2">
                            <i class="fas fa-check-circle fa-2x"></i>
                        </div>
                        <p class="text-muted">No hay respuestas pendientes de aprobación</p>
                        <small class="text-muted">Todas las respuestas han sido revisadas</small>
                    </div>
                `;
                return;
            }
    
            pendingTable.innerHTML = allPending.map(response => `
                <div class="response-row">
                    <div class="response-info">
                        <strong>${response.surveyTitle || response.surveyName}</strong>
                        <div class="response-meta">
                            Usuario: ${response.userId || 'Anónimo'} | 
                            Fecha: ${new Date(response.timestamp).toLocaleDateString('es-ES')}
                        </div>
                    </div>
                    <div class="response-actions">
                        <button class="btn btn-info btn-sm" onclick="window.adminSurvey.viewResponse('${response.id}', '${response.surveyName}')">
                            👁️ Ver
                        </button>
                        <button class="btn btn-success btn-sm" onclick="window.adminSurvey.approveResponse('${response.id}', '${response.surveyName}')">
                            ✅ Aprobar
                        </button>
                        <button class="btn btn-danger btn-sm" onclick="window.adminSurvey.rejectResponse('${response.id}', '${response.surveyName}')">
                            ❌ Rechazar
                        </button>
                    </div>
                </div>
            `).join('');
    
            // Actualizar contador en estadísticas
            const pendingCounter = document.getElementById('pending-responses');
            if (pendingCounter) {
                pendingCounter.textContent = allPending.length;
            }
    
        } catch (error) {
            console.error('Error loading pending responses:', error);
            const pendingTable = document.getElementById('pendingResponsesTable');
            if (pendingTable) {
                pendingTable.innerHTML = `
                    <div class="text-center p-4">
                        <div class="text-danger mb-2">
                            <i class="fas fa-exclamation-triangle fa-2x"></i>
                        </div>
                        <p class="text-danger">Error al cargar las respuestas pendientes</p>
                        <button class="btn btn-outline-primary btn-sm" onclick="window.location.reload()">
                            Reintentar
                        </button>
                    </div>
                `;
            }
        }
    }

    async initializeAdminRoles() {
        try {
            console.log("Inicializando roles administrativos...");
            // Usar roles del sistema
            const adminRoles = SYSTEM_ROLES.filter(role => this.isAdminRole(role));
            localStorage.setItem('admin_roles', JSON.stringify(adminRoles));
            return adminRoles;
        } catch (error) {
            console.error('Error inicializando roles administrativos:', error);
            return [];
        }
    }

    async saveRoleAssignments() {
        try {
            console.log("Guardando asignaciones de roles...");
            // Recopilar todas las asignaciones
            const checkboxes = document.querySelectorAll('.role-checkbox[data-survey]');
            const assignments = {};
            
            checkboxes.forEach(checkbox => {
                const surveyName = checkbox.dataset.survey;
                const roleName = checkbox.dataset.role;
                
                if (!assignments[surveyName]) {
                    assignments[surveyName] = [];
                }
                
                if (checkbox.checked) {
                    assignments[surveyName].push(roleName);
                }
            });
            
            // Guardar en localStorage
            localStorage.setItem('survey_role_assignments', JSON.stringify(assignments));
            
            if (window.app && window.app.showAlert) {
                window.app.showAlert('Asignaciones guardadas correctamente', 'success');
            } else {
                alert('Asignaciones guardadas correctamente');
            }
        } catch (error) {
            console.error('Error al guardar asignaciones:', error);
            if (window.app && window.app.showAlert) {
                window.app.showAlert('Error al guardar las asignaciones', 'danger');
            } else {
                alert('Error al guardar las asignaciones');
            }
        }
    }

    async getSurveyResponses(surveyName) {
        try {
            console.log(`Obteniendo respuestas para encuesta: ${surveyName}`);
            
            // Buscar en IndexedDB
            const responses = await window.localDB.query('RESPUESTAS_ENCUESTA', { surveyName });
            console.log(`Respuestas encontradas en BD: ${responses.length}`);
            
            // Si no hay respuestas reales, crear algunas de ejemplo
            if (responses.length === 0) {
                console.log(`Creando respuestas de ejemplo para ${surveyName}...`);
                
                const sampleResponses = [
                    {
                        id: `survey_${Date.now()}_${Math.random().toString(36).substr(2, 9)}`,
                        surveyName: surveyName,
                        userId: 'usuario1@empresa.com',
                        timestamp: Date.now() - (Math.random() * 5 * 24 * 60 * 60 * 1000), // Últimos 5 días
                        approved: false,
                        answers: {
                            question_1: 'Muy satisfecho',
                            question_2: 'Excelente servicio',
                            question_3: 'Recomendaría el producto'
                        }
                    },
                    {
                        id: `survey_${Date.now()}_${Math.random().toString(36).substr(2, 9)}`,
                        surveyName: surveyName,
                        userId: 'usuario2@empresa.com',
                        timestamp: Date.now() - (Math.random() * 2 * 24 * 60 * 60 * 1000), // Últimos 2 días
                        approved: Math.random() > 0.5, // 50% probabilidad de estar aprobada
                        answers: {
                            question_1: 'Satisfecho',
                            question_2: 'Buen servicio',
                            question_3: 'Posiblemente recomendaría'
                        }
                    }
                ];
    
                // Guardar respuestas de ejemplo en la base de datos
                for (const response of sampleResponses) {
                    try {
                        await window.localDB.create('RESPUESTAS_ENCUESTA', response);
                        console.log(`Respuesta de ejemplo creada: ${response.id}`);
                    } catch (error) {
                        console.warn(`Error creando respuesta de ejemplo: ${error.message}`);
                    }
                }
    
                return sampleResponses;
            }
    
            return responses;
        } catch (error) {
            console.error('Error obteniendo respuestas de encuesta:', error);
            return [];
        }
    }

    async viewResponse(responseId, surveyName) {
        try {
            console.log(`Visualizando respuesta ${responseId} de la encuesta ${surveyName}`);
            const responses = await this.getSurveyResponses(surveyName);
            const response = responses.find(r => r.id === responseId);
            
            if (!response) {
                alert('Respuesta no encontrada');
                return;
            }

            const modal = document.getElementById('resultsModal');
            const modalBody = document.getElementById('resultsModalBody');
            
            if (!modal || !modalBody) {
                console.error("Modal o modalBody no encontrados");
                return;
            }
            
            modalBody.innerHTML = `
                <div class="response-detail">
                    <h3>Respuesta de ${response.userId || 'Usuario Anónimo'}</h3>
                    <p><strong>Fecha:</strong> ${new Date(response.timestamp).toLocaleString('es-ES')}</p>
                    <p><strong>Estado:</strong> ${response.approved ? '✅ Aprobada' : '⏳ Pendiente'}</p>
                    
                    <h4>Respuestas:</h4>
                    <div class="answers-list">
                        ${Object.entries(response.answers).map(([question, answer]) => `
                            <div class="answer-item">
                                <strong>${question}:</strong>
                                <div class="answer-value">${answer}</div>
                            </div>
                        `).join('')}
                    </div>
                    
                    ${!response.approved ? `
                        <div class="approval-actions">
                            <button class="btn btn-success" onclick="window.adminSurvey.approveResponse('${responseId}', '${surveyName}')">
                                Aprobar Respuesta
                            </button>
                            <button class="btn btn-danger" onclick="window.adminSurvey.rejectResponse('${responseId}', '${surveyName}')">
                                Rechazar Respuesta
                            </button>
                        </div>
                    ` : ''}
                </div>
            `;
            
            modal.style.display = 'flex';
        } catch (error) {
            console.error('Error viendo respuesta:', error);
            alert('Error al cargar la respuesta: ' + error.message);
        }
    }

    async approveResponse(responseId, surveyName) {
        try {
            console.log(`Aprobando respuesta ${responseId} de encuesta ${surveyName}`);
            
            const responses = await this.getSurveyResponses(surveyName);
            const response = responses.find(r => r.id === responseId);
            
            if (!response) {
                alert('Respuesta no encontrada');
                return;
            }

            response.approved = true;
            response.approvedAt = Date.now();
            response.approvedBy = 'admin'; // En una implementación real, sería el usuario admin actual

            await window.localDB.update('RESPUESTAS_ENCUESTA', response);
            
            // Actualizar la interfaz
            await this.loadSurveyStats();
            await this.loadPendingResponses();
            
            // Cerrar modal si está abierto
            this.closeResultsModal();
           
            if (window.app && window.app.showAlert) {
                window.app.showAlert('Respuesta aprobada correctamente. El usuario ya puede ver sus resultados.', 'success');
            } else {
                alert('Respuesta aprobada correctamente. El usuario ya puede ver sus resultados.');
            }
        } catch (error) {
            console.error('Error aprobando respuesta:', error);
            alert('Error al aprobar la respuesta: ' + error.message);
        }
    }

    async rejectResponse(responseId, surveyName) {
        try {
            console.log(`Rechazando respuesta ${responseId} de encuesta ${surveyName}`);
            
            if (!confirm('¿Está seguro de que desea rechazar esta respuesta? Esta acción no se puede deshacer.')) {
                return;
            }

            await window.localDB.delete('RESPUESTAS_ENCUESTA', responseId);
            
            // Actualizar la interfaz
            await this.loadSurveyStats();
            await this.loadPendingResponses();
            
            this.closeResultsModal();
            
            if (window.app && window.app.showAlert) {
                window.app.showAlert('Respuesta rechazada y eliminada.', 'warning');
            } else {
                alert('Respuesta rechazada y eliminada.');
            }
        } catch (error) {
            console.error('Error rechazando respuesta:', error);
            alert('Error al rechazar la respuesta: ' + error.message);
        }
    }

    async viewSurveyResults(surveyName) {
        try {
            console.log(`Visualizando resultados de encuesta ${surveyName}`);
            
            const responses = await this.getSurveyResponses(surveyName);
            const approvedResponses = responses.filter(r => r.approved);
            
            const modal = document.getElementById('resultsModal');
            const modalBody = document.getElementById('resultsModalBody');
            
            if (!modal || !modalBody) {
                console.error("Modal o modalBody no encontrados");
                return;
            }
            
            // Analizar respuestas para generar estadísticas
            const stats = this.analyzeResponses(approvedResponses);
            
            modalBody.innerHTML = `
                <div class="survey-results">
                    <h3>Resultados de ${surveyName}</h3>
                    
                    <div class="results-overview">
                        <div class="result-stat">
                            <div class="result-stat-number">${responses.length}</div>
                            <div class="result-stat-label">Total Respuestas</div>
                        </div>
                        <div class="result-stat">
                            <div class="result-stat-number">${approvedResponses.length}</div>
                            <div class="result-stat-label">Aprobadas</div>
                        </div>
                        <div class="result-stat">
                            <div class="result-stat-number">${responses.length - approvedResponses.length}</div>
                            <div class="result-stat-label">Pendientes</div>
                        </div>
                        <div class="result-stat">
                            <div class="result-stat-number">${Math.round((approvedResponses.length / Math.max(responses.length, 1)) * 100)}%</div>
                            <div class="result-stat-label">Tasa Aprobación</div>
                        </div>
                    </div>
                    
                    <div class="question-results">
                        <h4>Distribución de Respuestas por Pregunta</h4>
                        ${this.generateQuestionAnalysis(stats)}
                    </div>
                    
                    <div class="individual-responses">
                        <h4>Respuestas Individuales</h4>
                        <div class="responses-list">
                            ${responses.map(response => `
                                <div class="response-summary ${response.approved ? 'approved' : 'pending'}">
                                    <div class="response-header">
                                        <span class="response-user">${response.userId || 'Anónimo'}</span>
                                        <span class="response-status">
                                            ${response.approved ? '✅ Aprobada' : '⏳ Pendiente'}
                                        </span>
                                        <span class="response-date">
                                            ${new Date(response.timestamp).toLocaleDateString('es-ES')}
                                        </span>
                                    </div>
                                    <button class="btn btn-sm btn-outline-primary" 
                                            onclick="window.adminSurvey.viewResponse('${response.id}', '${surveyName}')">
                                        Ver Detalles
                                    </button>
                                </div>
                            `).join('')}
                        </div>
                    </div>
                </div>
            `;
            
            modal.style.display = 'flex';
        } catch (error) {
            console.error('Error viendo resultados:', error);
            alert('Error al cargar los resultados: ' + error.message);
        }
    }

    analyzeResponses(responses) {
        const stats = {};
        
        responses.forEach(response => {
            Object.entries(response.answers).forEach(([question, answer]) => {
                if (!stats[question]) {
                    stats[question] = {};
                }
                
                if (!stats[question][answer]) {
                    stats[question][answer] = 0;
                }
                
                stats[question][answer]++;
            });
        });
        
        return stats;
    }

    generateQuestionAnalysis(stats) {
        return Object.entries(stats).map(([question, answers]) => {
            const total = Object.values(answers).reduce((sum, count) => sum + count, 0);
            
            return `
                <div class="question-result-item">
                    <div class="question-result-header">${question}</div>
                    <div class="answer-distribution">
                        ${Object.entries(answers).map(([answer, count]) => {
                            const percentage = Math.round((count / total) * 100);
                            return `
                                <div class="answer-option">
                                    <span class="option-text">${answer}</span>
                                    <span class="option-count">${count} respuestas</span>
                                    <span class="option-percentage">${percentage}%</span>
                                </div>
                            `;
                        }).join('')}
                    </div>
                </div>
            `;
        }).join('');
    }

    async deleteSurvey(surveyId) {
        try {
            console.log(`Eliminando encuesta con ID: ${surveyId}`);
            
            if (!confirm('¿Está seguro de que desea eliminar esta encuesta? Esta acción no se puede deshacer.')) {
                return;
            }
            
            // 1. Obtener la encuesta para obtener su nombre
            const surveys = await window.localDB.query('ENCUESTAS', { id_encuesta: parseInt(surveyId) });
            
            if (surveys.length === 0) {
                throw new Error('Encuesta no encontrada.');
            }
            
            const surveyName = surveys[0].nombre;
            console.log(`Eliminando encuesta "${surveyName}" (ID: ${surveyId})`);
            
            // 2. Obtener las preguntas asociadas
            const questions = await window.localDB.query('PREGUNTAS_ENCUESTA', { id_encuesta: parseInt(surveyId) });
            console.log(`Encontradas ${questions.length} preguntas para eliminar`);
            
            // 3. Eliminar las opciones de cada pregunta
            for (const question of questions) {
                const options = await window.localDB.query('OPCIONES_PREGUNTA', { id_pregunta: question.id_pregunta });
                
                for (const option of options) {
                    await window.localDB.delete('OPCIONES_PREGUNTA', option.id_opcion);
                }
                
                // Eliminar la pregunta
                await window.localDB.delete('PREGUNTAS_ENCUESTA', question.id_pregunta);
            }
            
            // 4. Eliminar las respuestas asociadas por nombre de encuesta
            const responses = await window.localDB.query('RESPUESTAS_ENCUESTA', { surveyName: surveyName });
            for (const response of responses) {
                await window.localDB.delete('RESPUESTAS_ENCUESTA', response.id);
            }
            
            // 5. Eliminar la encuesta
            await window.localDB.delete('ENCUESTAS', parseInt(surveyId));
            
            console.log(`Encuesta eliminada correctamente: ${surveyName}`);

            // Eliminar página generada
            localStorage.removeItem(`generated_survey_${surveyName}`);
            const generatedPages = JSON.parse(localStorage.getItem('generated_survey_pages') || '[]');
            const updatedPages = generatedPages.filter(page => page !== surveyName);
            localStorage.setItem('generated_survey_pages', JSON.stringify(updatedPages));
            
            if (window.app && window.app.showAlert) {
                window.app.showAlert('Encuesta eliminada correctamente.', 'success');
            } else {
                alert('Encuesta eliminada correctamente.');
            }
            
            // Recargar la lista de encuestas
            await this.loadSurveys();
        } catch (error) {
            console.error('Error deleting survey:', error);
            if (window.app && window.app.showAlert) {
                window.app.showAlert('Error al eliminar la encuesta: ' + error.message, 'danger');
            } else {
                alert('Error al eliminar la encuesta: ' + error.message);
            }
        }
    }

    closeResultsModal() {
        const modal = document.getElementById('resultsModal');
        if (modal) {
            modal.style.display = 'none';
        }
    }

    closeApproveModal() {
        const modal = document.getElementById('approveModal');
        if (modal) {
            modal.style.display = 'none';
        }
    }

    async initDB() {
        try {
            console.log('Inicializando base de datos...');
            console.log('Window localDB exists:', !!window.localDB);
            
            if (!window.localDB) {
                console.log('LocalDB no existe, creando una nueva instancia...');
                
                // Usar la versión 2 para resolver problemas de versión
                const request = indexedDB.open('DataWeb_DB', 2);
                
                await new Promise((resolve, reject) => {
                    request.onerror = (event) => {
                        console.error('Error initializing database:', event.target.error);
                        reject(event.target.error);
                    };
                    
                    request.onsuccess = (event) => {
                        const db = event.target.result;
                        console.log('Database opened successfully, version:', db.version);
                        window.localDB = this.createDBWrapper(db);
                        resolve();
                    };
                    
                    request.onupgradeneeded = (event) => {
                        console.log('Upgrading database to version:', event.newVersion);
                        const db = event.target.result;
                        
                        // Crear almacenes de objetos si no existen
                        if (!db.objectStoreNames.contains('ENCUESTAS')) {
                            console.log('Creando almacén ENCUESTAS');
                            db.createObjectStore('ENCUESTAS', { keyPath: 'id_encuesta', autoIncrement: true });
                        }
                        
                        if (!db.objectStoreNames.contains('PREGUNTAS_ENCUESTA')) {
                            console.log('Creando almacén PREGUNTAS_ENCUESTA');
                            db.createObjectStore('PREGUNTAS_ENCUESTA', { keyPath: 'id_pregunta', autoIncrement: true });
                        }
                        
                        if (!db.objectStoreNames.contains('OPCIONES_PREGUNTA')) {
                            console.log('Creando almacén OPCIONES_PREGUNTA');
                            db.createObjectStore('OPCIONES_PREGUNTA', { keyPath: 'id_opcion', autoIncrement: true });
                        }
                        
                        if (!db.objectStoreNames.contains('RESPUESTAS_ENCUESTA')) {
                            console.log('Creando almacén RESPUESTAS_ENCUESTA');
                            db.createObjectStore('RESPUESTAS_ENCUESTA', { keyPath: 'id', autoIncrement: true });
                        }
                        
                        if (!db.objectStoreNames.contains('CUESTIONARIOS')) {
                            console.log('Creando almacén CUESTIONARIOS');
                            db.createObjectStore('CUESTIONARIOS', { keyPath: 'id_cuestionario', autoIncrement: true });
                        }
                        
                        if (!db.objectStoreNames.contains('PREGUNTAS_CUESTIONARIO')) {
                            console.log('Creando almacén PREGUNTAS_CUESTIONARIO');
                            db.createObjectStore('PREGUNTAS_CUESTIONARIO', { keyPath: 'id_pregunta', autoIncrement: true });
                        }
                        
                        if (!db.objectStoreNames.contains('OPCIONES_CUESTIONARIO')) {
                            console.log('Creando almacén OPCIONES_CUESTIONARIO');
                            db.createObjectStore('OPCIONES_CUESTIONARIO', { keyPath: 'id_opcion', autoIncrement: true });
                        }
                        
                        if (!db.objectStoreNames.contains('RESPUESTAS_CUESTIONARIO')) {
                            console.log('Creando almacén RESPUESTAS_CUESTIONARIO');
                            db.createObjectStore('RESPUESTAS_CUESTIONARIO', { keyPath: 'id', autoIncrement: true });
                        }
                    };
                });
                
                console.log('Base de datos inicializada correctamente');
            } else {
                console.log('Utilizando instancia existente de localDB');
            }
            
            return window.localDB;
        } catch (error) {
            console.error('Error initializing database:', error);
            throw error;
        }
    }

    createDBWrapper(db) {
        return {
            db: db,
            
            async create(storeName, data) {
                console.log(`Creando registro en ${storeName}:`, data);
                return new Promise((resolve, reject) => {
                    try {
                        const transaction = db.transaction([storeName], 'readwrite');
                        const store = transaction.objectStore(storeName);
                        const request = store.add(data);
                        
                        request.onsuccess = (event) => {
                            console.log(`Registro creado con ID: ${request.result}`);
                            resolve(request.result);
                        };
                        
                        request.onerror = (event) => {
                            console.error(`Error al crear registro en ${storeName}:`, request.error);
                            reject(request.error);
                        };
                    } catch (error) {
                        console.error(`Error de transacción en ${storeName}:`, error);
                        reject(error);
                    }
                });
            },
            
            async getAll(storeName) {
                console.log(`Obteniendo todos los registros de ${storeName}`);
                return new Promise((resolve, reject) => {
                    try {
                        const transaction = db.transaction([storeName], 'readonly');
                        const store = transaction.objectStore(storeName);
                        const request = store.getAll();
                        
                        request.onsuccess = (event) => {
                            console.log(`Recuperados ${request.result.length} registros de ${storeName}`);
                            resolve(request.result);
                        };
                        
                        request.onerror = (event) => {
                            console.error(`Error al obtener registros de ${storeName}:`, request.error);
                            reject(request.error);
                        };
                    } catch (error) {
                        console.error(`Error de transacción en ${storeName}:`, error);
                        reject(error);
                    }
                });
            },
            
            async get(storeName, id) {
                console.log(`Obteniendo registro con ID ${id} de ${storeName}`);
                return new Promise((resolve, reject) => {
                    try {
                        const transaction = db.transaction([storeName], 'readonly');
                        const store = transaction.objectStore(storeName);
                        const request = store.get(id);
                        
                        request.onsuccess = (event) => {
                            console.log(`Registro recuperado de ${storeName}:`, request.result);
                            resolve(request.result);
                        };
                        
                        request.onerror = (event) => {
                            console.error(`Error al obtener registro de ${storeName}:`, request.error);
                            reject(request.error);
                        };
                    } catch (error) {
                        console.error(`Error de transacción en ${storeName}:`, error);
                        reject(error);
                    }
                });
            },
            
            async query(storeName, condition) {
                console.log(`Consultando ${storeName} con condición:`, condition);
                try {
                    const all = await this.getAll(storeName);
                    
                    if (!condition || Object.keys(condition).length === 0) {
                        return all;
                    }
                    
                    const filtered = all.filter(item => {
                        return Object.keys(condition).every(key => {
                            return item[key] == condition[key]; // Loose equality for number vs string
                        });
                    });
                    
                    console.log(`Filtro aplicado en ${storeName}, resultados:`, filtered.length);
                    return filtered;
                } catch (error) {
                    console.error(`Error en consulta a ${storeName}:`, error);
                    throw error;
                }
            },
            
            async update(storeName, data) {
                console.log(`Actualizando registro en ${storeName}:`, data);
                return new Promise((resolve, reject) => {
                    try {
                        const transaction = db.transaction([storeName], 'readwrite');
                        const store = transaction.objectStore(storeName);
                        const request = store.put(data);
                        
                        request.onsuccess = (event) => {
                            console.log(`Registro actualizado en ${storeName}`);
                            resolve(request.result);
                        };
                        
                        request.onerror = (event) => {
                            console.error(`Error al actualizar registro en ${storeName}:`, request.error);
                            reject(request.error);
                        };
                    } catch (error) {
                        console.error(`Error de transacción en ${storeName}:`, error);
                        reject(error);
                    }
                });
            },
            
            async delete(storeName, id) {
                console.log(`Eliminando registro con ID ${id} de ${storeName}`);
                return new Promise((resolve, reject) => {
                    try {
                        const transaction = db.transaction([storeName], 'readwrite');
                        const store = transaction.objectStore(storeName);
                        const request = store.delete(id);
                        
                        request.onsuccess = (event) => {
                            console.log(`Registro eliminado de ${storeName}`);
                            resolve(request.result);
                        };
                        
                        request.onerror = (event) => {
                            console.error(`Error al eliminar registro de ${storeName}:`, request.error);
                            reject(request.error);
                        };
                    } catch (error) {
                        console.error(`Error de transacción en ${storeName}:`, error);
                        reject(error);
                    }
                });
            }
            
        };
    }
}

// Crear instancia global para usar en onclick
console.log("Creando instancia de SurveyAdmin...");
const adminSurvey = new SurveyAdmin();

// Hacer accesible globalmente
window.adminSurvey = adminSurvey;

// Funciones globales para los onclick
window.viewSurveyResults = function(surveyName) {
    window.adminSurvey.viewSurveyResults(surveyName);
};

window.editSurvey = function(surveyName) {
    window.location.href = `survey-edit.html?name=${encodeURIComponent(surveyName)}`;
};

window.deleteSurvey = function(surveyId) {
    window.adminSurvey.deleteSurvey(surveyId);
};

window.closeResultsModal = function() {
    window.adminSurvey.closeResultsModal();
};

window.closeApproveModal = function() {
    window.adminSurvey.closeApproveModal();
};

window.loadSurveyRoleAssignments = function() {
    window.adminSurvey.loadSurveyRoleAssignments();
};

window.closeResultsModal = function() {
    if (window.adminSurvey) {
        window.adminSurvey.closeResultsModal();
    }
};
window.refreshSystemRoles = function() {
    if (window.adminSurvey) {
        return window.adminSurvey.refreshSystemRoles();
    } else if (window.quizAdmin) {
        return window.quizAdmin.refreshSystemRoles();
    }
};
