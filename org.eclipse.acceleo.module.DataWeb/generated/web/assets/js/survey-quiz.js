/**
 * JavaScript unificado para encuestas y cuestionarios
 */

// Configuración global
const CONFIG = {
    SYSTEM_ROLES: [
        'Administrador'
,         'Bibliotecario'
,         'Estudiante'
    ],
    DB_NAME: 'DataWeb_DB',
    DB_VERSION: 2
};

// Base de datos unificada
class UnifiedDB {
    constructor() {
        this.db = null;
    }

    async init() {
        return new Promise((resolve, reject) => {
            const request = indexedDB.open(CONFIG.DB_NAME, CONFIG.DB_VERSION);
            
            request.onsuccess = () => {
                this.db = request.result;
                resolve(this.db);
            };
            
            request.onerror = () => reject(request.error);
            
            request.onupgradeneeded = (event) => {
                const db = event.target.result;
                
                ['ENCUESTAS', 'CUESTIONARIOS', 'PREGUNTAS_ENCUESTA', 'PREGUNTAS_CUESTIONARIO', 
                 'OPCIONES_PREGUNTA', 'OPCIONES_CUESTIONARIO', 'RESPUESTAS_ENCUESTA', 'RESPUESTAS_CUESTIONARIO'].forEach(store => {
                    if (!db.objectStoreNames.contains(store)) {
                        db.createObjectStore(store, { keyPath: 'id', autoIncrement: true });
                    }
                });
            };
        });
    }

    async create(storeName, data) {
        const transaction = this.db.transaction([storeName], 'readwrite');
        const store = transaction.objectStore(storeName);
        return store.add(data);
    }

    async getAll(storeName) {
        const transaction = this.db.transaction([storeName], 'readonly');
        const store = transaction.objectStore(storeName);
        return store.getAll();
    }
    
    async update(storeName, data) {
        const transaction = this.db.transaction([storeName], 'readwrite');
        const store = transaction.objectStore(storeName);
        return store.put(data);
    }
    
    async delete(storeName, id) {
        const transaction = this.db.transaction([storeName], 'readwrite');
        const store = transaction.objectStore(storeName);
        return store.delete(id);
    }
}

// Manager principal
class SurveyQuizManager {
    constructor() {
        this.db = new UnifiedDB();
        this.currentQuestion = 1;
        this.totalQuestions = 0;
        this.answers = new Map();
        this.timer = null;
    }

    async init() {
        await this.db.init();
        window.localDB = this.db;
    }

    // Cargar contenido dinámico
    async loadContent(type) {
        const container = document.getElementById(`${type}-container`);
        if (!container) return;

        try {
            const items = await this.db.getAll(type.toUpperCase());
            const currentRole = localStorage.getItem('current_role') || 'Usuario';
            const assignments = JSON.parse(localStorage.getItem(`${type.slice(0,-1)}_role_assignments`) || '{}');
            
            const filtered = items.filter(item => {
                if (assignments[item.nombre] && assignments[item.nombre].includes(currentRole)) {
                    return true;
                }
                return !assignments[item.nombre];
            });

            if (filtered.length === 0) {
                container.innerHTML = `
                    <div class="empty-state">
                        <h3>No hay ${type} disponibles para tu rol</h3>
                        <a href="../index.html" class="btn btn-primary">Volver al inicio</a>
                    </div>
                `;
            } else {
                container.innerHTML = this.generateItemsHTML(filtered, type);
            }

            if (type === 'quizzes') {
                await this.loadQuizResults();
            }
        } catch (error) {
            console.error(`Error loading ${type}:`, error);
            container.innerHTML = `<div class="error">Error cargando ${type}</div>`;
        }
    }

    generateItemsHTML(items, type) {
        const isQuiz = type === 'quizzes';
        return `
            <div class="${type}-grid grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
                ${items.map(item => `
                    <div class="card">
                        <div class="card-header">
                            <h3>${item.titulo}</h3>
                        </div>
                        <div class="card-body">
                            <p>${item.descripcion || ''}</p>
                            ${isQuiz ? `<span class="badge">⏱️ ${item.tiempoLimite || 30} min</span>` : ''}
                        </div>
                        <div class="card-footer">
                            <button class="btn btn-primary btn-block" onclick="openItem('${item.nombre}', '${type}')">
                                ${isQuiz ? 'Realizar Cuestionario' : 'Participar en Encuesta'}
                            </button>
                        </div>
                    </div>
                `).join('')}
            </div>
        `;
    }

    // Administración
    async initAdmin(type) {
        await this.init();
        await this.loadAdminContent(type);
        this.setupAdminEvents(type);
    }

    async loadAdminContent(type) {
        const container = document.getElementById(`${type}-list`);
        if (!container) return;

        try {
            const items = await this.db.getAll(type.toUpperCase());
            container.innerHTML = items.map(item => `
                <div class="admin-item">
                    <h4>${item.titulo}</h4>
                    <p>${item.descripcion || ''}</p>
                    <div class="admin-actions">
                        <button class="btn btn-info btn-sm" onclick="viewResults('${item.nombre}')">Ver Resultados</button>
                        <button class="btn btn-danger btn-sm" onclick="deleteItem('${item.id}', '${type}')">Eliminar</button>
                    </div>
                </div>
            `).join('');

            if (type === 'quizzes') {
                await this.loadPendingReviews();
            }
        } catch (error) {
            console.error(`Error loading admin ${type}:`, error);
        }
    }

    async loadPendingReviews() {
        const container = document.getElementById('pendingReviewsTable');
        if (!container) return;

        try {
            const responses = await this.db.getAll('RESPUESTAS_CUESTIONARIO');
            const pending = responses.filter(r => r.results && !r.results.gradeConfirmed);

            if (pending.length === 0) {
                container.innerHTML = '<p>No hay evaluaciones pendientes</p>';
            } else {
                container.innerHTML = pending.map(response => `
                    <div class="review-row">
                        <div class="review-info">
                            <strong>${response.quizName}</strong>
                            <div class="review-meta">
                                Usuario: ${response.userId} | 
                                Puntuación: ${response.results.porcentaje}%
                            </div>
                        </div>
                        <button class="btn btn-info btn-sm" onclick="reviewQuiz('${response.id}')">
                            Revisar
                        </button>
                    </div>
                `).join('');
            }
        } catch (error) {
            console.error('Error loading pending reviews:', error);
        }
    }

    // Creación de contenido
    initCreator(type) {
        this.init();
        this.questionCount = 0;
        this.addQuestion();
        
        document.getElementById(`create${type.charAt(0).toUpperCase() + type.slice(1)}Form`)
            .addEventListener('submit', (e) => {
                e.preventDefault();
                this.createItem(type);
            });
    }

    addQuestion() {
        this.questionCount++;
        const container = document.getElementById('preguntasContainer');
        const questionDiv = document.createElement('div');
        questionDiv.className = 'question-item card mb-4';
        questionDiv.innerHTML = `
            <div class="card-header">
                <h4>Pregunta ${this.questionCount}</h4>
                ${this.questionCount > 1 ? `<button type="button" onclick="removeQuestion(this)" class="btn btn-danger btn-sm">×</button>` : ''}
            </div>
            <div class="card-body">
                <div class="form-group">
                    <label class="form-label">Texto de la Pregunta</label>
                    <input type="text" name="pregunta_${this.questionCount}_texto" class="form-control" required>
                </div>
                
                <div class="form-group">
                    <label class="form-label">Tipo de Pregunta</label>
                    <select name="pregunta_${this.questionCount}_tipo" class="form-control question-type" 
                            data-question="${this.questionCount}" onchange="updateQuestionType(this)" required>
                        <option value="">Seleccionar...</option>
                        <option value="opcion_multiple">Opción Múltiple</option>
                        <option value="verdadero_falso">Verdadero/Falso</option>
                        <option value="respuesta_corta">Respuesta Corta</option>
                    </select>
                </div>
                
                <div class="options-container" id="opciones_${this.questionCount}" style="display: none;"></div>
            </div>
        `;
        container.appendChild(questionDiv);
    }

    // Interacción con elementos
    async openItem(name, type) {
        // Generar página dinámica
        const html = await this.generateDynamicPage(name, type);
        const newWindow = window.open('', '_blank');
        newWindow.document.write(html);
        newWindow.document.close();
    }

    async generateDynamicPage(name, type) {
        const isQuiz = type === 'quizzes';
        const storeName = isQuiz ? 'CUESTIONARIOS' : 'ENCUESTAS';
       const items = await this.db.getAll(storeName);
       const item = items.find(i => i.nombre === name);
       
       if (!item) return '<html><body><h1>Elemento no encontrado</h1></body></html>';
       
       const questionsStore = isQuiz ? 'PREGUNTAS_CUESTIONARIO' : 'PREGUNTAS_ENCUESTA';
       const questions = await this.db.getAll(questionsStore);
       const itemQuestions = questions.filter(q => q[isQuiz ? 'id_cuestionario' : 'id_encuesta'] === item.id);
       
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
           <div class="quiz-info">
               <div class="timer" id="timer">${item.tiempoLimite || 30}:00</div>
           </div>
           ` : ''}
           
           <div class="progress-bar">
               <div class="progress-fill" id="progress-fill"></div>
           </div>
           
           <form id="item-form" data-type="${isQuiz ? 'quiz' : 'survey'}" data-name="${name}">
               ${itemQuestions.map((q, i) => `
                   <div class="question-container" data-question="${i + 1}" ${i > 0 ? 'style="display:none"' : ''}>
                       <h3>${q.texto}</h3>
                       <div class="question-options">
                           ${this.generateQuestionOptions(q, i + 1)}
                       </div>
                       <div class="question-nav">
                           ${i > 0 ? `<button type="button" onclick="previousQuestion(${i + 1})">Anterior</button>` : ''}
                           ${i < itemQuestions.length - 1 ? 
                               `<button type="button" onclick="nextQuestion(${i + 1})" disabled>Siguiente</button>` : 
                               `<button type="button" onclick="submitForm()" disabled>Enviar</button>`
                           }
                       </div>
                   </div>
               `).join('')}
           </form>
       </div>
   </main>
   
   <script>
       let currentQuestion = 1;
       let totalQuestions = ${itemQuestions.length};
       let answers = new Map();
       ${isQuiz ? `let timeLeft = ${(item.tiempoLimite || 30) * 60}; startTimer();` : ''}
       
       function nextQuestion(current) {
           if (!validateQuestion(current)) return;
           showQuestion(current + 1);
       }
       
       function previousQuestion(current) {
           showQuestion(current - 1);
       }
       
       function showQuestion(num) {
           document.querySelectorAll('.question-container').forEach((q, i) => {
               q.style.display = i === num - 1 ? 'block' : 'none';
           });
           currentQuestion = num;
           updateProgress();
       }
       
       function validateQuestion(num) {
           const container = document.querySelector(\`[data-question="\${num}"]\`);
           const inputs = container.querySelectorAll('input, textarea');
           return Array.from(inputs).some(input => 
               input.type === 'radio' ? input.checked : input.value.trim()
           );
       }
       
       function updateProgress() {
           const progress = (currentQuestion / totalQuestions) * 100;
           document.getElementById('progress-fill').style.width = progress + '%';
       }
       
       ${isQuiz ? `
       function startTimer() {
           const timer = document.getElementById('timer');
           setInterval(() => {
               if (timeLeft <= 0) {
                   submitForm();
                   return;
               }
               const minutes = Math.floor(timeLeft / 60);
               const seconds = timeLeft % 60;
               timer.textContent = \`\${minutes}:\${seconds.toString().padStart(2, '0')}\`;
               timeLeft--;
           }, 1000);
       }
       ` : ''}
       
       function submitForm() {
           const formData = new FormData(document.getElementById('item-form'));
           const data = {
               id: 'resp_' + Date.now(),
               ${isQuiz ? 'quizName' : 'surveyName'}: '${name}',
               userId: 'usuario@example.com',
               timestamp: Date.now(),
               ${isQuiz ? 'results: evaluateQuiz(formData),' : 'approved: false,'}
               answers: Object.fromEntries(formData)
           };
           
           // Simular guardado
           console.log('Guardando:', data);
           
           document.body.innerHTML = \`
               <div style="text-align: center; padding: 2rem;">
                   <h2>¡${isQuiz ? 'Cuestionario' : 'Encuesta'} enviado!</h2>
                   <p>Gracias por tu participación</p>
                   <button onclick="window.close()">Cerrar</button>
               </div>
           \`;
       }
       
       ${isQuiz ? `
       function evaluateQuiz(formData) {
           const total = totalQuestions;
           const correct = Math.floor(Math.random() * total);
           return {
               totalPreguntas: total,
               totalCorrectas: correct,
               porcentaje: Math.round((correct / total) * 100),
               gradeConfirmed: false
           };
       }
       ` : ''}
       
       // Event listeners
       document.addEventListener('change', function(e) {
           if (e.target.type === 'radio' || e.target.tagName === 'TEXTAREA') {
               const questionNum = parseInt(e.target.closest('.question-container').dataset.question);
               const nextBtn = document.querySelector(\`[data-question="\${questionNum}"] button[onclick*="next"], [data-question="\${questionNum}"] button[onclick*="submit"]\`);
               if (nextBtn) nextBtn.disabled = false;
           }
       });
   </script>
</body>
</html>`;
   }

   generateQuestionOptions(question, index) {
       if (question.tipo === 'verdadero_falso') {
           return `
               <label><input type="radio" name="question_${index}" value="true" required> Verdadero</label>
               <label><input type="radio" name="question_${index}" value="false" required> Falso</label>
           `;
       } else if (question.tipo === 'respuesta_corta') {
           return `<textarea name="question_${index}" required></textarea>`;
       } else {
           // opcion_multiple - simplificado
           return `
               <label><input type="radio" name="question_${index}" value="A" required> Opción A</label>
               <label><input type="radio" name="question_${index}" value="B" required> Opción B</label>
               <label><input type="radio" name="question_${index}" value="C" required> Opción C</label>
           `;
       }
   }

   async loadQuizResults() {
       const section = document.getElementById('quiz-results-section');
       if (!section) return;

       try {
           const responses = await this.db.getAll('RESPUESTAS_CUESTIONARIO');
           const confirmed = responses.filter(r => r.results && r.results.gradeConfirmed);

           if (confirmed.length === 0) {
               section.innerHTML = `
                   <div class="card">
                       <div class="card-body">
                           <p>No tienes resultados confirmados aún.</p>
                       </div>
                   </div>
               `;
           } else {
               section.innerHTML = `
                   <div class="card">
                       <div class="card-header">
                           <h2>Tus Resultados (${confirmed.length})</h2>
                       </div>
                       <div class="card-body">
                           <a href="results.html" class="btn btn-primary">Ver detalles</a>
                       </div>
                   </div>
               `;
           }
           section.style.display = 'block';
       } catch (error) {
           console.error('Error loading quiz results:', error);
       }
   }

   setupAdminEvents(type) {
       const saveBtn = document.getElementById('saveRoleAssignments');
       if (saveBtn) {
           saveBtn.addEventListener('click', () => this.saveRoleAssignments(type));
       }
   }

   async saveRoleAssignments(type) {
       const assignments = {};
       const checkboxes = document.querySelectorAll('.role-checkbox');
       
       checkboxes.forEach(checkbox => {
           const itemName = checkbox.dataset[type.slice(0, -1)];
           const roleName = checkbox.dataset.role;
           
           if (!assignments[itemName]) assignments[itemName] = [];
           if (checkbox.checked) assignments[itemName].push(roleName);
       });
       
       localStorage.setItem(`${type.slice(0, -1)}_role_assignments`, JSON.stringify(assignments));
       alert('Asignaciones guardadas correctamente');
   }

   async createItem(type) {
       const form = document.getElementById(`create${type.charAt(0).toUpperCase() + type.slice(1)}Form`);
       const formData = new FormData(form);
       
       const item = {
           id: Date.now(),
           nombre: formData.get('nombre'),
           titulo: formData.get('titulo'),
           descripcion: formData.get('descripcion'),
           timestamp: Date.now()
       };

       if (type === 'survey') {
           item.tipoRepresentacion = formData.get('tipoRepresentacion');
       } else {
           item.tiempoLimite = parseInt(formData.get('timeLimit'));
       }

       try {
           await this.db.create(type === 'survey' ? 'ENCUESTAS' : 'CUESTIONARIOS', item);
           alert(`${type === 'survey' ? 'Encuesta' : 'Cuestionario'} creado correctamente`);
           window.location.href = `${type === 'survey' ? 'surveys' : 'quizzes'}-admin.html`;
       } catch (error) {
           console.error('Error creating item:', error);
           alert('Error al crear el elemento');
       }
   }

   async deleteItem(id, type) {
       if (!confirm('¿Seguro que deseas eliminar este elemento?')) return;
       
       try {
           await this.db.delete(type.toUpperCase(), parseInt(id));
           await this.loadAdminContent(type);
           alert('Elemento eliminado correctamente');
       } catch (error) {
           console.error('Error deleting item:', error);
           alert('Error al eliminar el elemento');
       }
   }

   async reviewQuiz(responseId) {
       // Simplificada - solo confirmar calificación
       try {
           const responses = await this.db.getAll('RESPUESTAS_CUESTIONARIO');
           const response = responses.find(r => r.id === responseId);
           
           if (response) {
               response.results.gradeConfirmed = true;
               await this.db.update('RESPUESTAS_CUESTIONARIO', response);
               await this.loadPendingReviews();
               alert('Calificación confirmada');
           }
       } catch (error) {
           console.error('Error reviewing quiz:', error);
       }
   }
}

// Funciones globales
let manager = new SurveyQuizManager();

window.loadContent = async (type) => {
   await manager.init();
   await manager.loadContent(type);
};

window.initAdmin = async (type) => {
   await manager.initAdmin(type);
};

window.initCreator = (type) => {
   manager.initCreator(type);
};

window.openItem = (name, type) => {
   manager.openItem(name, type);
};

window.addQuestion = () => {
   manager.addQuestion();
};

window.removeQuestion = (btn) => {
   btn.closest('.question-item').remove();
};

window.updateQuestionType = (select) => {
   const questionNum = select.dataset.question;
   const container = document.getElementById(`opciones_${questionNum}`);
   
   if (select.value === 'opcion_multiple') {
       container.style.display = 'block';
       container.innerHTML = `
           <div class="form-group">
               <label>Opciones (una por línea)</label>
               <textarea name="pregunta_${questionNum}_opciones" class="form-control" rows="4" 
                        placeholder="Opción A&#10;Opción B&#10;Opción C"></textarea>
           </div>
       `;
   } else {
       container.style.display = 'none';
   }
};

window.deleteItem = (id, type) => {
   manager.deleteItem(id, type);
};

window.reviewQuiz = (id) => {
   manager.reviewQuiz(id);
};

window.viewResults = (name) => {
   alert(`Ver resultados de: ${name}`);
};

window.closeModal = () => {
   document.getElementById('reviewModal').style.display = 'none';
};

window.confirmGrade = () => {
   alert('Calificación confirmada');
   closeModal();
};

// Inicialización
document.addEventListener('DOMContentLoaded', () => {
   manager.init();
});
