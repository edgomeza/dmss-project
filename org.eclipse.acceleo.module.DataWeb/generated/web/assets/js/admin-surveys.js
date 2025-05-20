/**
 * Administración de encuestas y cuestionarios
 */

class SurveyAdmin {
    constructor() {
        this.init();
    }

    async init() {
        await this.loadSurveyStats();
        await this.loadPendingResponses();
		this.loadSurveyRoleAssignments();
    }

    async loadSurveyStats() {
        try {
            const surveys = document.querySelectorAll('[data-survey]');
            
            for (const surveyElement of surveys) {
                const surveyName = surveyElement.dataset.survey;
                const responses = await this.getSurveyResponses(surveyName);
                const pending = responses.filter(r => !r.approved).length;
                
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
        } catch (error) {
            console.error('Error cargando estadísticas:', error);
        }
    }

    async loadPendingResponses() {
	    try {
	        const pendingTable = document.getElementById('pendingResponsesTable');
	        if (!pendingTable) return;
	
	        const allPending = [];
	        const processedIds = new Set(); // Track processed IDs
	        const surveys = document.querySelectorAll('[data-survey]');
	        
	        for (const surveyElement of surveys) {
	            const surveyName = surveyElement.dataset.survey;
	            const responses = await this.getSurveyResponses(surveyName);
	            const pending = responses.filter(r => !r.approved);
	            
	            pending.forEach(response => {
	                if (!processedIds.has(response.id)) { // Only add if not already processed
	                    processedIds.add(response.id);
	                    response.surveyName = surveyName;
	                    allPending.push(response);
	                }
	            });
	        }
	
	        if (allPending.length === 0) {
	            pendingTable.innerHTML = '<p class="text-center">No hay respuestas pendientes de aprobación</p>';
	            return;
	        }
	
	        pendingTable.innerHTML = allPending.map(response => `
	            <div class="response-row">
	                <div class="response-info">
	                    <strong>${response.surveyName}</strong>
	                    <div class="response-meta">
	                        Usuario: ${response.userId || 'Anónimo'} | 
	                        Fecha: ${new Date(response.timestamp).toLocaleDateString('es-ES')}
	                    </div>
	                </div>
	                <div class="response-actions">
	                    <button class="btn btn-info btn-sm" onclick="adminSurvey.viewResponse('${response.id}', '${response.surveyName}')">
	                        👁️ Ver
	                    </button>
	                    <button class="btn btn-success btn-sm" onclick="adminSurvey.approveResponse('${response.id}', '${response.surveyName}')">
	                        ✅ Aprobar
	                    </button>
	                    <button class="btn btn-danger btn-sm" onclick="adminSurvey.rejectResponse('${response.id}', '${response.surveyName}')">
	                        ❌ Rechazar
	                    </button>
	                </div>
	            </div>
	        `).join('');
	
	    } catch (error) {
	        console.error('Error loading pending responses:', error);
	    }
	}

	async loadSurveyRoleAssignments() {
	    try {
	        // Obtener roles administrativos
	        let adminRoles = JSON.parse(localStorage.getItem('admin_roles') || '[]');
	        if (adminRoles.length === 0) {
	            adminRoles = await initializeAdminRoles();
	        }
	        
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
	            else if (!assignments[surveyName] && adminRoles.includes(roleName)) {
	                checkbox.checked = true;
	            }
	        });
	    } catch (error) {
	        console.error('Error cargando asignaciones de roles para encuestas:', error);
	    }
	}

	async saveRoleAssignments() {
	    try {
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
            // Buscar en IndexedDB
            const db = window.localDB || await this.initDB();
            const responses = await db.query('RESPUESTAS_ENCUESTA', { surveyName });
            
            // Si no hay respuestas, crear algunas de ejemplo para demostración
            if (responses.length === 0) {
                const sampleResponses = [
                    {
                        id: `resp_${Date.now()}_1`,
                        surveyName: surveyName,
                        userId: 'usuario1@email.com',
                        timestamp: Date.now() - 86400000, // Ayer
                        approved: false,
                        answers: {
                            question_1: 'Opción A',
                            question_2: 'Texto de respuesta'
                        }
                    },
                    {
                        id: `resp_${Date.now()}_2`,
                        surveyName: surveyName,
                        userId: 'usuario2@email.com',
                        timestamp: Date.now() - 172800000, // Hace 2 días
                        approved: true,
                        answers: {
                            question_1: 'Opción B',
                            question_2: 'Otra respuesta'
                        }
                    }
                ];

                // Guardar respuestas de ejemplo
                for (const response of sampleResponses) {
                    await db.create('RESPUESTAS_ENCUESTA', response);
                }

                return sampleResponses;
            }

            return responses;
        } catch (error) {
            console.error('Error obteniendo respuestas:', error);
            return [];
        }
    }

    async viewResponse(responseId, surveyName) {
        try {
            const responses = await this.getSurveyResponses(surveyName);
            const response = responses.find(r => r.id === responseId);
            
            if (!response) {
                alert('Respuesta no encontrada');
                return;
            }

            const modal = document.getElementById('resultsModal');
            const modalBody = document.getElementById('resultsModalBody');
            
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
                            <button class="btn btn-success" onclick="adminSurvey.approveResponse('${responseId}', '${surveyName}')">
                                Aprobar Respuesta
                            </button>
                            <button class="btn btn-danger" onclick="adminSurvey.rejectResponse('${responseId}', '${surveyName}')">
                                Rechazar Respuesta
                            </button>
                        </div>
                    ` : ''}
                </div>
            `;
            
            modal.style.display = 'flex';
        } catch (error) {
            console.error('Error viendo respuesta:', error);
            alert('Error al cargar la respuesta');
        }
    }

    async approveResponse(responseId, surveyName) {
        try {
            const db = window.localDB || await this.initDB();
            const responses = await this.getSurveyResponses(surveyName);
            const response = responses.find(r => r.id === responseId);
            
            if (!response) {
                alert('Respuesta no encontrada');
                return;
            }

            response.approved = true;
            response.approvedAt = Date.now();
            response.approvedBy = 'admin'; // En una implementación real, sería el usuario admin actual

            await db.update('RESPUESTAS_ENCUESTA', response);
            
            // Actualizar la interfaz
            await this.loadSurveyStats();
            await this.loadPendingResponses();
            
            // Cerrar modal si está abierto
			this.closeResultsModal();
           
           if (window.app && window.app.showAlert) {
               window.app.showAlert('Respuesta aprobada correctamente. El usuario ya puede ver sus resultados.', 'success');
           }
       } catch (error) {
           console.error('Error aprobando respuesta:', error);
           alert('Error al aprobar la respuesta');
       }
   }

   async rejectResponse(responseId, surveyName) {
       try {
           if (!confirm('¿Está seguro de que desea rechazar esta respuesta? Esta acción no se puede deshacer.')) {
               return;
           }

           const db = window.localDB || await this.initDB();
           await db.delete('RESPUESTAS_ENCUESTA', responseId);
           
           // Actualizar la interfaz
           await this.loadSurveyStats();
           await this.loadPendingResponses();
           
           this.closeResultsModal();
           
           if (window.app && window.app.showAlert) {
               window.app.showAlert('Respuesta rechazada y eliminada.', 'warning');
           }
       } catch (error) {
           console.error('Error rechazando respuesta:', error);
           alert('Error al rechazar la respuesta');
       }
   }

   async viewSurveyResults(surveyName) {
       try {
           const responses = await this.getSurveyResponses(surveyName);
           const approvedResponses = responses.filter(r => r.approved);
           
           const modal = document.getElementById('resultsModal');
           const modalBody = document.getElementById('resultsModalBody');
           
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
                                           onclick="adminSurvey.viewResponse('${response.id}', '${surveyName}')">
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
           alert('Error al cargar los resultados');
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

   async deleteSurvey(surveyName) {
       if (!confirm(`¿Está seguro de que desea eliminar la encuesta "${surveyName}"? Esta acción eliminará también todas las respuestas asociadas.`)) {
           return;
       }

       try {
           const db = window.localDB || await this.initDB();
           
           // Eliminar todas las respuestas de la encuesta
           const responses = await this.getSurveyResponses(surveyName);
           for (const response of responses) {
               await db.delete('RESPUESTAS_ENCUESTA', response.id);
           }
           
           // En una implementación real, también eliminarías la encuesta de la base de datos
           
           if (window.app && window.app.showAlert) {
               window.app.showAlert('Encuesta eliminada correctamente', 'success');
           }
           
           // Recargar estadísticas
           await this.loadSurveyStats();
           await this.loadPendingResponses();
       } catch (error) {
           console.error('Error eliminando encuesta:', error);
           alert('Error al eliminar la encuesta');
       }
   }

   editSurvey(surveyName) {
       // Redirigir a página de edición o mostrar modal de edición
       alert(`Función de edición para "${surveyName}" - Por implementar`);
   }

   async initDB() {
       // Si no existe la BD global, inicializarla
       if (!window.localDB) {
           const LocalDBManager = window.LocalDBManager || class LocalDBManager {
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
                           resolve(this.db);
                       };
                       request.onupgradeneeded = (event) => {
                           const db = event.target.result;
                           if (!db.objectStoreNames.contains('RESPUESTAS_ENCUESTA')) {
                               const store = db.createObjectStore('RESPUESTAS_ENCUESTA', { 
                                   keyPath: 'id', 
                                   autoIncrement: false 
                               });
                               store.createIndex('surveyName', 'surveyName', { unique: false });
                               store.createIndex('userId', 'userId', { unique: false });
                               store.createIndex('approved', 'approved', { unique: false });
                           }
                       };
                   });
               }

               async query(tableName, filters = {}) {
                   return new Promise((resolve, reject) => {
                       const transaction = this.db.transaction([tableName], 'readonly');
                       const store = transaction.objectStore(tableName);
                       const request = store.getAll();
                       
                       request.onsuccess = () => {
                           let results = request.result;
                           
                           if (Object.keys(filters).length > 0) {
                               results = results.filter(item => {
                                   return Object.keys(filters).every(key => {
                                       if (!filters[key]) return true;
                                       return item[key] === filters[key];
                                   });
                               });
                           }
                           
                           resolve(results);
                       };
                       request.onerror = () => reject(request.error);
                   });
               }

               async create(tableName, data) {
                   return new Promise((resolve, reject) => {
                       const transaction = this.db.transaction([tableName], 'readwrite');
                       const store = transaction.objectStore(tableName);
                       const request = store.add(data);
                       
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
                       const request = store.delete(id);
                       
                       request.onsuccess = () => resolve(request.result);
                       request.onerror = () => reject(request.error);
                   });
               }
           };

           const dbManager = new LocalDBManager();
           await dbManager.init();
           window.localDB = dbManager;
       }

       return window.localDB;
   }
}

// Crear instancia global para usar en onclick
window.adminSurvey = new SurveyAdmin();

// Funciones globales para los onclick
window.viewSurveyResults = function(surveyName) {
   window.adminSurvey.viewSurveyResults(surveyName);
};

window.editSurvey = function(surveyName) {
   window.adminSurvey.editSurvey(surveyName);
};

window.deleteSurvey = function(surveyName) {
   window.adminSurvey.deleteSurvey(surveyName);
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

document.addEventListener('DOMContentLoaded', function() {
    const saveButton = document.getElementById('saveRoleAssignments');
    if (saveButton) {
        saveButton.addEventListener('click', function() {
            adminSurvey.saveRoleAssignments();
        });
    }
});
