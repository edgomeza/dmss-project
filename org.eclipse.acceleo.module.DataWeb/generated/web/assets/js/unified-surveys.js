/**
 * GESTOR UNIFICADO DE ENCUESTAS Y CUESTIONARIOS - Biblioteca Universitaria
 * Maneja creación, administración y ejecución
 */

class UnifiedSurveyQuizManager {
    constructor(app) {
        this.app = app;
        this.db = app.db;
        this.questionCounter = 0;
        this.currentTimer = null;
        this.userAnswers = new Map();
    }

    async loadForRole(roleName) {
        try {
            // Cargar encuestas y cuestionarios disponibles para el rol
            const [surveys, quizzes] = await Promise.all([
                this.db.execute('getAll', 'ENCUESTAS'),
                this.db.execute('getAll', 'CUESTIONARIOS')
            ]);

            // Obtener asignaciones de roles
            const surveyAssignments = JSON.parse(localStorage.getItem('survey_role_assignments') || '{}');
            const quizAssignments = JSON.parse(localStorage.getItem('quiz_role_assignments') || '{}');

            // Filtrar por rol
            const availableSurveys = surveys.filter(survey => {
                if (surveyAssignments[survey.nombre]) {
                    return surveyAssignments[survey.nombre].includes(roleName);
                }
                return true; // Si no hay asignación específica, mostrar para todos
            });

            const availableQuizzes = quizzes.filter(quiz => {
                if (quizAssignments[quiz.nombre]) {
                    return quizAssignments[quiz.nombre].includes(roleName);
                }
                return true;
            });

            // Actualizar contenedores en dashboard
            this.updateRoleContent('roleSurveys', availableSurveys, 'survey');
            this.updateRoleContent('roleQuizzes', availableQuizzes, 'quiz');

        } catch (error) {
            console.error('Error cargando contenido para rol:', error);
        }
    }

    updateRoleContent(containerId, items, type) {
        const container = document.getElementById(containerId);
        if (!container) return;

        if (items.length === 0) {
            container.innerHTML = `<p class="empty-message">No hay ${type === 'survey' ? 'encuestas' : 'cuestionarios'} asignados a tu rol.</p>`;
           return;
       }

       container.innerHTML = items.map(item => `
           <div class="assessment-item">
               <div class="assessment-info">
                   <h5>${item.titulo || item.nombre}</h5>
                   <p>${item.descripcion || `${type === 'survey' ? 'Encuesta' : 'Cuestionario'} disponible`}</p>
                   <span class="assessment-badge">
                       ${type === 'survey' ? item.tipo_representacion || 'Encuesta' : `Evaluativo (${item.tiempoLimite || 30} min)`}
                   </span>
               </div>
               <button class="btn btn-primary btn-sm" onclick="DataWebApp.surveys.openItem('${item.nombre}', '${type}')">
                   ${type === 'survey' ? 'Participar' : 'Realizar'}
               </button>
           </div>
       `).join('');
   }

   initPage(path) {
       if (path.includes('surveys/index.html')) {
           this.loadContent('surveys', 'surveys-container');
       } else if (path.includes('quizzes/index.html')) {
           this.loadContent('quizzes', 'quizzes-container');
       } else if (path.includes('create-survey.html')) {
           this.initCreator('survey');
       } else if (path.includes('create-quiz.html')) {
           this.initCreator('quiz');
       }
   }

   async loadContent(type, containerId) {
       const container = document.getElementById(containerId);
       if (!container) return;

       const loadingHtml = '<div class="loading">Cargando...</div>';
       container.innerHTML = loadingHtml;

       try {
           const storeName = type === 'surveys' ? 'ENCUESTAS' : 'CUESTIONARIOS';
           const items = await this.db.execute('getAll', storeName);
           
           if (items.length === 0) {
               container.innerHTML = `
                   <div class="empty-state">
                       <h3>No hay ${type === 'surveys' ? 'encuestas' : 'cuestionarios'} disponibles</h3>
                       <a href="../index.html" class="btn btn-primary">Volver al inicio</a>
                   </div>
               `;
               return;
           }

           container.innerHTML = this.generateItemsGrid(items, type);
       } catch (error) {
           console.error(`Error cargando ${type}:`, error);
           container.innerHTML = `<div class="error-message">Error cargando contenido</div>`;
       }
   }

   generateItemsGrid(items, type) {
       const isQuiz = type === 'quizzes';
       
       return `
           <div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
               ${items.map(item => `
                   <div class="card">
                       <div class="card-header">
                           <h3>${item.titulo || item.nombre}</h3>
                       </div>
                       <div class="card-body">
                           <p>${item.descripcion || 'Sin descripción'}</p>
                           ${isQuiz ? `<span class="badge">⏱️ ${item.tiempoLimite || 30} min</span>` : ''}
                       </div>
                       <div class="card-footer">
                           <button class="btn btn-primary btn-block" onclick="DataWebApp.surveys.openItem('${item.nombre}', '${isQuiz ? 'quiz' : 'survey'}')">
                               ${isQuiz ? 'Realizar Cuestionario' : 'Participar en Encuesta'}
                           </button>
                       </div>
                   </div>
               `).join('')}
           </div>
       `;
   }

   async initAdmin(type) {
       const listContainer = document.getElementById(`${type}-list`);
       if (listContainer) {
           await this.loadAdminItems(type, listContainer);
       }

       if (type === 'quizzes') {
           await this.loadPendingReviews();
       }

       this.setupAdminEvents(type);
   }

   async loadAdminItems(type, container) {
       try {
           const storeName = type === 'surveys' ? 'ENCUESTAS' : 'CUESTIONARIOS';
           const items = await this.db.execute('getAll', storeName);

           if (items.length === 0) {
               container.innerHTML = `
                   <div class="text-center p-4">
                       <h4>No hay ${type === 'surveys' ? 'encuestas' : 'cuestionarios'} disponibles</h4>
                       <a href="create-${type.slice(0, -1)}.html" class="btn btn-primary">Crear Nuevo</a>
                   </div>
               `;
               return;
           }

           container.innerHTML = items.map(item => `
               <div class="admin-item card mb-3">
                   <div class="card-body">
                       <h5>${item.titulo}</h5>
                       <p>${item.descripcion || 'Sin descripción'}</p>
                       <div class="admin-actions">
                           <button class="btn btn-info btn-sm" onclick="DataWebApp.surveys.viewResults('${item.nombre}')">Ver Resultados</button>
                           <button class="btn btn-danger btn-sm delete-btn" 
                                   data-entity="${storeName}" 
                                   data-id="${item[type === 'surveys' ? 'id_encuesta' : 'id_cuestionario']}"
                                   data-confirm="¿Seguro que deseas eliminar este ${type.slice(0, -1)}?">
                               Eliminar
                           </button>
                       </div>
                   </div>
               </div>
           `).join('');
       } catch (error) {
           console.error(`Error cargando ${type} para admin:`, error);
           container.innerHTML = '<div class="error-message">Error cargando contenido</div>';
       }
   }

   async loadPendingReviews() {
       const container = document.getElementById('pendingReviewsTable');
       if (!container) return;

       try {
           const responses = await this.db.execute('getAll', 'RESPUESTAS_CUESTIONARIO');
           const pending = responses.filter(r => r.results && !r.results.gradeConfirmed);

           if (pending.length === 0) {
               container.innerHTML = '<div class="text-center p-4"><p>No hay evaluaciones pendientes</p></div>';
               return;
           }

           container.innerHTML = pending.map(response => `
               <div class="response-row">
                   <div class="response-info">
                       <strong>${response.quizName || 'Cuestionario'}</strong>
                       <div>Usuario: ${response.userId || 'Anónimo'} | Fecha: ${new Date(response.timestamp).toLocaleDateString()}</div>
                       <div>Puntuación: ${response.results.porcentaje}%</div>
                   </div>
                   <div class="response-actions">
                       <button class="btn btn-success btn-sm" onclick="DataWebApp.surveys.confirmGrade('${response.id}')">Confirmar</button>
                   </div>
               </div>
           `).join('');
       } catch (error) {
           console.error('Error cargando revisiones pendientes:', error);
       }
   }

   setupAdminEvents(type) {
       // Eventos específicos de administración si es necesario
       const saveBtn = document.getElementById('saveRoleAssignments');
       if (saveBtn) {
           saveBtn.addEventListener('click', () => this.saveRoleAssignments(type));
       }
   }

   initCreator(type) {
       this.questionCounter = 0;
       this.addQuestion();

       const form = document.getElementById(`create${type.charAt(0).toUpperCase() + type.slice(1)}Form`);
       if (form) {
           form.classList.add('unified-form');
           form.dataset.type = `${type}-create`;
       }
   }

   addQuestion() {
       this.questionCounter++;
       const container = document.getElementById('preguntasContainer');
       if (!container) return;

       const questionDiv = document.createElement('div');
       questionDiv.className = 'question-item card mb-4';
       questionDiv.dataset.question = this.questionCounter;
       
       questionDiv.innerHTML = `
           <div class="card-header">
               <h4>Pregunta ${this.questionCounter}</h4>
               ${this.questionCounter > 1 ? `<button type="button" onclick="DataWebApp.surveys.removeQuestion(this)" class="btn btn-danger btn-sm">×</button>` : ''}
           </div>
           <div class="card-body">
               <div class="form-group">
                   <label class="form-label">Texto de la Pregunta <span class="required">*</span></label>
                   <input type="text" name="pregunta_${this.questionCounter}_texto" class="form-control" required>
               </div>
               
               <div class="form-group">
                   <label class="form-label">Tipo de Pregunta <span class="required">*</span></label>
                   <select name="pregunta_${this.questionCounter}_tipo" class="form-control question-type" 
                           data-question="${this.questionCounter}" onchange="DataWebApp.surveys.updateQuestionType(this)" required>
                       <option value="">Seleccionar...</option>
                       <option value="opcion_multiple">Opción Múltiple</option>
                       <option value="verdadero_falso">Verdadero/Falso</option>
                       <option value="respuesta_corta">Respuesta Corta</option>
                   </select>
               </div>
               
               <div class="options-container" id="opciones_${this.questionCounter}" style="display: none;"></div>
           </div>
       `;
       
       container.appendChild(questionDiv);
   }

   removeQuestion(button) {
       button.closest('.question-item').remove();
   }

   updateQuestionType(select) {
       const questionNum = select.dataset.question;
       const container = document.getElementById(`opciones_${questionNum}`);
       
       if (!container) return;

       container.innerHTML = '';
       container.style.display = select.value ? 'block' : 'none';

       if (select.value === 'opcion_multiple') {
           container.innerHTML = `
               <div class="form-group">
                   <label class="form-label">Opciones (una por línea)</label>
                   <textarea name="pregunta_${questionNum}_opciones" class="form-control" rows="4" 
                           placeholder="Opción A&#10;Opción B&#10;Opción C"></textarea>
               </div>
           `;
       } else if (select.value === 'verdadero_falso') {
           container.innerHTML = `
               <div class="form-group">
                   <label class="form-label">Opciones:</label>
                   <div class="options-preview">
                       <span class="badge badge-secondary">Verdadero</span>
                       <span class="badge badge-secondary">Falso</span>
                   </div>
               </div>
           `;
       } else if (select.value === 'respuesta_corta') {
           container.innerHTML = `
               <div class="form-group">
                   <label class="form-label">Vista previa:</label>
                   <textarea class="form-control" rows="3" placeholder="El usuario ingresará su respuesta aquí" disabled></textarea>
               </div>
           `;
       }
   }

   async handleForm(formType, formData) {
       try {
           const item = {
               nombre: formData.get('nombre'),
               titulo: formData.get('titulo'),
               descripcion: formData.get('descripcion') || '',
               timestamp: Date.now()
           };

           if (formType === 'survey-create') {
               item.tipo_representacion = formData.get('tipoRepresentacion');
               await this.db.execute('create', 'ENCUESTAS', item);
               return {
                   success: true,
                   message: 'Encuesta creada correctamente',
                   redirect: '../admin/surveys-admin.html'
               };
           } else if (formType === 'quiz-create') {
               item.tiempoLimite = parseInt(formData.get('timeLimit')) || 30;
               await this.db.execute('create', 'CUESTIONARIOS', item);
               return {
                   success: true,
                   message: 'Cuestionario creado correctamente',
                   redirect: '../admin/quizzes-admin.html'
               };
           }
       } catch (error) {
           console.error('Error creando item:', error);
           return {
               success: false,
               message: 'Error al crear el elemento'
           };
       }
   }

   async openItem(name, type) {
       try {
           const storeName = type === 'survey' ? 'ENCUESTAS' : 'CUESTIONARIOS';
           const items = await this.db.execute('getAll', storeName);
           const item = items.find(i => i.nombre === name);
           
           if (!item) {
               this.app.ui.showAlert('Elemento no encontrado', 'danger');
               return;
           }

           const html = await this.generateDynamicPage(item, type);
           const newWindow = window.open('', '_blank');
           newWindow.document.write(html);
           newWindow.document.close();
       } catch (error) {
           console.error('Error abriendo elemento:', error);
           this.app.ui.showAlert('Error abriendo elemento', 'danger');
       }
   }

   async generateDynamicPage(item, type) {
       const isQuiz = type === 'quiz';
       
       return `
<!DOCTYPE html>
<html lang="es">
<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <title>${item.titulo}</title>
   <link rel="stylesheet" href="../assets/css/style.css">
</head>
<body>
   <header class="app-header">
       <div class="container">
           <h1>${item.titulo}</h1>
           <p>${item.descripcion || ''}</p>
       </div>
   </header>
   
   <main class="main-content">
       <div class="container">
           ${isQuiz ? `
           <div class="quiz-info mb-4">
               <div class="timer text-center" id="timer">${item.tiempoLimite || 30}:00</div>
           </div>
           ` : ''}
           
           <div class="card">
               <div class="card-body">
                   <form id="item-form">
                       <div class="form-group">
                           <label class="form-label">Ejemplo de pregunta:</label>
                           <div class="question-example">
                               <p>Esta es una pregunta de ejemplo. En una implementación completa, aquí se cargarían las preguntas reales desde la base de datos.</p>
                               <div class="form-group">
                                   <label><input type="radio" name="ejemplo" value="A" required> Opción A</label><br>
                                   <label><input type="radio" name="ejemplo" value="B" required> Opción B</label><br>
                                   <label><input type="radio" name="ejemplo" value="C" required> Opción C</label>
                               </div>
                           </div>
                       </div>
                       
                       <div class="form-actions">
                           <button type="button" onclick="submitDemo()" class="btn btn-primary">
                               ${isQuiz ? 'Enviar Respuestas' : 'Enviar Encuesta'}
                           </button>
                           <button type="button" onclick="window.close()" class="btn btn-secondary">Cerrar</button>
                       </div>
                   </form>
               </div>
           </div>
       </div>
   </main>
   
   <script>
       ${isQuiz ? `
       let timeLeft = ${(item.tiempoLimite || 30) * 60};
       const timer = document.getElementById('timer');
       
       const countdown = setInterval(() => {
           const minutes = Math.floor(timeLeft / 60);
           const seconds = timeLeft % 60;
           timer.textContent = minutes + ':' + (seconds < 10 ? '0' : '') + seconds;
           
           if (timeLeft <= 0) {
               clearInterval(countdown);
               submitDemo();
           }
           timeLeft--;
       }, 1000);
       ` : ''}
       
       function submitDemo() {
           alert('${isQuiz ? 'Cuestionario' : 'Encuesta'} enviado correctamente. Esta es una versión de demostración.');
           window.close();
       }
   </script>
</body>
</html>`;
   }

   async confirmGrade(responseId) {
       try {
           const responses = await this.db.execute('getAll', 'RESPUESTAS_CUESTIONARIO');
           const response = responses.find(r => r.id === responseId);
           
           if (response && response.results) {
               response.results.gradeConfirmed = true;
               await this.db.execute('update', 'RESPUESTAS_CUESTIONARIO', response);
               await this.loadPendingReviews();
               this.app.ui.showAlert('Calificación confirmada', 'success');
           }
       } catch (error) {
           console.error('Error confirmando calificación:', error);
           this.app.ui.showAlert('Error confirmando calificación', 'danger');
       }
   }

   saveRoleAssignments(type) {
       // Implementación simplificada - en una versión completa se manejarían checkboxes reales
       this.app.ui.showAlert('Asignaciones guardadas correctamente', 'success');
   }

   viewResults(itemName) {
       this.app.ui.showAlert(`Ver resultados de: ${itemName}`, 'info');
   }
}
