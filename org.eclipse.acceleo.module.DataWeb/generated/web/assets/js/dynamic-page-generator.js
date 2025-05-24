/**
* GENERADOR DINÁMICO DE PÁGINAS - Sistema Bancario Digital
* Genera páginas HTML en tiempo real para encuestas y cuestionarios
*/

class DynamicPageGenerator {
   constructor() {
       this.templates = {
           survey: this.getSurveyTemplate(),
           quiz: this.getQuizTemplate()
       };
   }

   async generateSurveyPage(surveyName) {
       try {
           if (!window.UnifiedDB) {
               throw new Error('Base de datos no disponible');
           }
           
           await window.UnifiedDB.init();
           const surveys = await window.UnifiedDB.execute('getAll', 'ENCUESTAS');
           const survey = surveys.find(s => s.nombre === surveyName);
           
           if (!survey) {
               return this.getErrorPage('Encuesta no encontrada');
           }
           
           return this.templates.survey
               .replace(/\{\{TITLE\}\}/g, survey.titulo)
               .replace(/\{\{DESCRIPTION\}\}/g, survey.descripcion || '')
               .replace(/\{\{NAME\}\}/g, survey.nombre)
               .replace(/\{\{TYPE\}\}/g, 'survey');
               
       } catch (error) {
           console.error('Error generando página de encuesta:', error);
           return this.getErrorPage('Error cargando encuesta');
       }
   }

   async generateQuizPage(quizName) {
       try {
           if (!window.UnifiedDB) {
               throw new Error('Base de datos no disponible');
           }
           
           await window.UnifiedDB.init();
           const quizzes = await window.UnifiedDB.execute('getAll', 'CUESTIONARIOS');
           const quiz = quizzes.find(q => q.nombre === quizName);
           
           if (!quiz) {
               return this.getErrorPage('Cuestionario no encontrado');
           }
           
           return this.templates.quiz
               .replace(/\{\{TITLE\}\}/g, quiz.titulo)
               .replace(/\{\{DESCRIPTION\}\}/g, quiz.descripcion || '')
               .replace(/\{\{NAME\}\}/g, quiz.nombre)
               .replace(/\{\{TIME_LIMIT\}\}/g, quiz.tiempoLimite || 30)
               .replace(/\{\{TYPE\}\}/g, 'quiz');
               
       } catch (error) {
           console.error('Error generando página de cuestionario:', error);
           return this.getErrorPage('Error cargando cuestionario');
       }
   }

   getSurveyTemplate() {
       return `<!DOCTYPE html>
<html lang="es">
<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <title>{{TITLE}} - Sistema Bancario Digital</title>
   <link rel="stylesheet" href="../assets/css/style.css">
</head>
<body>
   <header class="app-header">
       <div class="container">
           <h1>{{TITLE}}</h1>
           <p>{{DESCRIPTION}}</p>
       </div>
   </header>
   
   <nav class="main-nav">
       <div class="container nav-container">
           <div class="nav-brand">
               <a href="../index.html" class="nav-logo">Sistema Bancario Digital</a>
           </div>
           <ul class="nav-menu">
               <li class="nav-item"><a href="../index.html" class="nav-link">Inicio</a></li>
               <li class="nav-item"><a href="index.html" class="nav-link">Encuestas</a></li>
           </ul>
       </div>
   </nav>
   
   <main class="main-content">
       <div class="container">
           <div class="card">
               <div class="card-header">
                   <h2>Participar en Encuesta</h2>
               </div>
               <div class="card-body">
                   <div class="progress-bar mb-4">
                       <div class="progress-fill" id="progress-fill" style="width: 0%"></div>
                   </div>
                   
                   <form id="survey-form" data-survey="{{NAME}}">
                       <div id="questions-container">
                           <!-- Pregunta de ejemplo -->
                           <div class="question-item active" data-question="1">
                               <h3>Pregunta de ejemplo</h3>
                               <p class="question-description">Esta es una pregunta de demostración. En una implementación completa, las preguntas se cargarían desde la base de datos.</p>
                               
                               <div class="form-group">
                                   <label class="form-label">¿Cómo calificarías tu experiencia?</label>
                                   <div class="radio-group">
                                       <label class="radio-label">
                                           <input type="radio" name="question_1" value="excelente" required>
                                           <span>Excelente</span>
                                       </label>
                                       <label class="radio-label">
                                           <input type="radio" name="question_1" value="buena" required>
                                           <span>Buena</span>
                                       </label>
                                       <label class="radio-label">
                                           <input type="radio" name="question_1" value="regular" required>
                                           <span>Regular</span>
                                       </label>
                                       <label class="radio-label">
                                           <input type="radio" name="question_1" value="mala" required>
                                           <span>Mala</span>
                                       </label>
                                   </div>
                               </div>
                           </div>
                           
                           <div class="question-item" data-question="2">
                               <h3>Comentarios adicionales</h3>
                               <div class="form-group">
                                   <label class="form-label">¿Tienes algún comentario o sugerencia?</label>
                                   <textarea name="question_2" class="form-control" rows="4" placeholder="Escribe tus comentarios aquí (opcional)"></textarea>
                               </div>
                           </div>
                       </div>
                       
                       <div class="form-navigation">
                           <button type="button" id="prev-btn" class="btn btn-secondary" disabled>Anterior</button>
                           <button type="button" id="next-btn" class="btn btn-primary">Siguiente</button>
                           <button type="submit" id="submit-btn" class="btn btn-success" style="display: none;">Enviar Encuesta</button>
                       </div>
                   </form>
               </div>
           </div>
       </div>
   </main>
   
   <script>
       class SurveyHandler {
           constructor() {
               this.currentQuestion = 1;
               this.totalQuestions = 2;
               this.answers = {};
               this.init();
           }
           
           init() {
               this.updateUI();
               this.bindEvents();
           }
           
           bindEvents() {
               document.getElementById('next-btn').addEventListener('click', () => this.nextQuestion());
               document.getElementById('prev-btn').addEventListener('click', () => this.prevQuestion());
               document.getElementById('survey-form').addEventListener('submit', (e) => this.handleSubmit(e));
               
               // Actualizar progreso cuando cambian las respuestas
               document.addEventListener('change', () => this.updateProgress());
           }
           
           nextQuestion() {
               if (this.currentQuestion < this.totalQuestions) {
                   this.hideQuestion(this.currentQuestion);
                   this.currentQuestion++;
                   this.showQuestion(this.currentQuestion);
                   this.updateUI();
               }
           }
           
           prevQuestion() {
               if (this.currentQuestion > 1) {
                   this.hideQuestion(this.currentQuestion);
                   this.currentQuestion--;
                   this.showQuestion(this.currentQuestion);
                   this.updateUI();
               }
           }
           
           showQuestion(num) {
               const question = document.querySelector(\`[data-question="\${num}"]\`);
               if (question) {
                   question.classList.add('active');
                   question.style.display = 'block';
               }
           }
           
           hideQuestion(num) {
               const question = document.querySelector(\`[data-question="\${num}"]\`);
               if (question) {
                   question.classList.remove('active');
                   question.style.display = 'none';
               }
           }
           
           updateUI() {
               const prevBtn = document.getElementById('prev-btn');
               const nextBtn = document.getElementById('next-btn');
               const submitBtn = document.getElementById('submit-btn');
               
               prevBtn.disabled = this.currentQuestion === 1;
               
               if (this.currentQuestion === this.totalQuestions) {
                   nextBtn.style.display = 'none';
                   submitBtn.style.display = 'inline-block';
               } else {
                   nextBtn.style.display = 'inline-block';
                   submitBtn.style.display = 'none';
               }
               
               this.updateProgress();
           }
           
           updateProgress() {
               const progress = (this.currentQuestion / this.totalQuestions) * 100;
               const progressFill = document.getElementById('progress-fill');
               if (progressFill) {
                   progressFill.style.width = progress + '%';
               }
           }
           
           async handleSubmit(e) {
               e.preventDefault();
               
               const formData = new FormData(e.target);
               const surveyName = e.target.dataset.survey;
               
               const response = {
                   id: 'resp_' + Date.now(),
                   surveyName: surveyName,
                   userId: 'usuario@example.com',
                   timestamp: Date.now(),
                   answers: Object.fromEntries(formData),
                   approved: false
               };
               
               try {
                   // En una implementación real, esto se guardaría en la base de datos
                   console.log('Respuesta de encuesta:', response);
                   
                   this.showSuccessMessage();
               } catch (error) {
                   console.error('Error enviando encuesta:', error);
                   alert('Error al enviar la encuesta. Por favor, inténtalo de nuevo.');
               }
           }
           
           showSuccessMessage() {
               document.querySelector('.main-content').innerHTML = \`
                   <div class="container">
                       <div class="card">
                           <div class="card-body text-center">
                               <div style="font-size: 4rem; color: var(--success-500); margin-bottom: 1rem;">✓</div>
                               <h2>¡Encuesta enviada!</h2>
                               <p>Gracias por tu participación. Tu respuesta ha sido registrada correctamente.</p>
                               <div class="mt-4">
                                   <button onclick="window.close()" class="btn btn-primary">Cerrar</button>
                                   <a href="../surveys/index.html" class="btn btn-secondary">Ver más encuestas</a>
                               </div>
                           </div>
                       </div>
                   </div>
               \`;
           }
       }
       
       // Inicializar cuando el DOM esté listo
       document.addEventListener('DOMContentLoaded', () => {
           new SurveyHandler();
       });
   </script>
   
   <style>
       .question-item {
           display: none;
       }
       
       .question-item.active {
           display: block;
       }
       
       .question-item h3 {
           margin-bottom: 1rem;
           color: var(--gray-800);
       }
       
       .question-description {
           margin-bottom: 1.5rem;
           color: var(--gray-600);
       }
       
       .radio-group {
           display: flex;
           flex-direction: column;
           gap: 0.75rem;
       }
       
       .radio-label {
           display: flex;
           align-items: center;
           gap: 0.5rem;
           padding: 0.75rem;
           border: 1px solid var(--gray-200);
           border-radius: var(--radius);
           cursor: pointer;
           transition: var(--transition);
       }
       
       .radio-label:hover {
           background: var(--gray-50);
           border-color: var(--primary-300);
       }
       
       .radio-label input:checked + span {
           color: var(--primary-600);
           font-weight: 500;
       }
       
       .progress-bar {
           width: 100%;
           height: 8px;
           background: var(--gray-200);
           border-radius: var(--radius);
           overflow: hidden;
       }
       
       .progress-fill {
           height: 100%;
           background: var(--primary-500);
           transition: width 0.3s ease;
       }
       
       .form-navigation {
           display: flex;
           justify-content: space-between;
           margin-top: 2rem;
           padding-top: 2rem;
           border-top: 1px solid var(--gray-200);
       }
       
       @media (max-width: 768px) {
           .form-navigation {
               flex-direction: column;
               gap: 1rem;
           }
           
           .radio-group {
               gap: 0.5rem;
           }
       }
   </style>
</body>
</html>`;
   }

   getQuizTemplate() {
       return `<!DOCTYPE html>
<html lang="es">
<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <title>{{TITLE}} - Sistema Bancario Digital</title>
   <link rel="stylesheet" href="../assets/css/style.css">
</head>
<body>
   <header class="app-header">
       <div class="container">
           <h1>{{TITLE}}</h1>
           <p>{{DESCRIPTION}}</p>
       </div>
   </header>
   
   <nav class="main-nav">
       <div class="container nav-container">
           <div class="nav-brand">
               <a href="../index.html" class="nav-logo">Sistema Bancario Digital</a>
           </div>
           <ul class="nav-menu">
               <li class="nav-item"><a href="../index.html" class="nav-link">Inicio</a></li>
               <li class="nav-item"><a href="index.html" class="nav-link">Cuestionarios</a></li>
           </ul>
       </div>
   </nav>
   
   <main class="main-content">
       <div class="container">
           <div class="quiz-info-bar">
               <div class="card">
                   <div class="card-body">
                       <div class="quiz-meta">
                           <div class="quiz-timer">
                               <span class="timer-label">Tiempo restante:</span>
                               <span class="timer-display" id="timer">{{TIME_LIMIT}}:00</span>
                           </div>
                           <div class="quiz-progress">
                               <span class="progress-label">Progreso:</span>
                               <div class="progress-bar">
                                   <div class="progress-fill" id="progress-fill"></div>
                               </div>
                               <span class="progress-text" id="progress-text">0 / 3</span>
                           </div>
                       </div>
                   </div>
               </div>
           </div>
           
           <div class="card">
               <div class="card-body">
                   <form id="quiz-form" data-quiz="{{NAME}}">
                       <div id="questions-container">
                           <!-- Pregunta 1 -->
                           <div class="question-item active" data-question="1">
                               <div class="question-header">
                                   <span class="question-number">Pregunta 1 de 3</span>
                                   <span class="question-type badge badge-primary">Opción Múltiple</span>
                               </div>
                               <h3>¿Cuál es la capital de España?</h3>
                               
                               <div class="form-group">
                                   <div class="radio-group">
                                       <label class="radio-label">
                                           <input type="radio" name="question_1" value="madrid" required>
                                           <span>Madrid</span>
                                       </label>
                                       <label class="radio-label">
                                           <input type="radio" name="question_1" value="barcelona" required>
                                           <span>Barcelona</span>
                                       </label>
                                       <label class="radio-label">
                                           <input type="radio" name="question_1" value="sevilla" required>
                                           <span>Sevilla</span>
                                       </label>
                                       <label class="radio-label">
                                           <input type="radio" name="question_1" value="valencia" required>
                                           <span>Valencia</span>
                                       </label>
                                   </div>
                               </div>
                           </div>
                           
                           <!-- Pregunta 2 -->
                           <div class="question-item" data-question="2">
                               <div class="question-header">
                                   <span class="question-number">Pregunta 2 de 3</span>
                                   <span class="question-type badge badge-primary">Verdadero/Falso</span>
                               </div>
                               <h3>El Sol es una estrella</h3>
                               
                               <div class="form-group">
                                   <div class="radio-group">
                                       <label class="radio-label">
                                           <input type="radio" name="question_2" value="true" required>
                                           <span>Verdadero</span>
                                       </label>
                                       <label class="radio-label">
                                           <input type="radio" name="question_2" value="false" required>
                                           <span>Falso</span>
                                       </label>
                                   </div>
                               </div>
                           </div>
                           
                           <!-- Pregunta 3 -->
                           <div class="question-item" data-question="3">
                               <div class="question-header">
                                   <span class="question-number">Pregunta 3 de 3</span>
                                   <span class="question-type badge badge-primary">Respuesta Corta</span>
                               </div>
                               <h3>¿En qué año se descubrió América?</h3>
                               
                               <div class="form-group">
                                   <input type="text" name="question_3" class="form-control" placeholder="Ingresa tu respuesta" required>
                               </div>
                           </div>
                       </div>
                       
                       <div class="form-navigation">
                           <button type="button" id="prev-btn" class="btn btn-secondary" disabled>Anterior</button>
                           <button type="button" id="next-btn" class="btn btn-primary">Siguiente</button>
                           <button type="submit" id="submit-btn" class="btn btn-success" style="display: none;">Finalizar Cuestionario</button>
                       </div>
                   </form>
               </div>
           </div>
       </div>
   </main>
   
   <script>
       class QuizHandler {
           constructor() {
               this.currentQuestion = 1;
               this.totalQuestions = 3;
               this.timeLimit = {{TIME_LIMIT}} * 60; // en segundos
               this.timeLeft = this.timeLimit;
               this.answers = {};
               this.timer = null;
               this.init();
           }
           
           init() {
               this.startTimer();
               this.updateUI();
               this.bindEvents();
           }
           
           bindEvents() {
               document.getElementById('next-btn').addEventListener('click', () => this.nextQuestion());
               document.getElementById('prev-btn').addEventListener('click', () => this.prevQuestion());
               document.getElementById('quiz-form').addEventListener('submit', (e) => this.handleSubmit(e));
               
               // Actualizar progreso cuando cambian las respuestas
               document.addEventListener('change', () => this.updateProgress());
           }
           
           startTimer() {
               this.timer = setInterval(() => {
                   this.timeLeft--;
                   this.updateTimerDisplay();
                   
                   if (this.timeLeft <= 0) {
                       this.timeUp();
                   }
               }, 1000);
           }
           
           updateTimerDisplay() {
               const minutes = Math.floor(this.timeLeft / 60);
               const seconds = this.timeLeft % 60;
               const display = \`\${minutes}:\${seconds.toString().padStart(2, '0')}\`;
               
               const timerElement = document.getElementById('timer');
               if (timerElement) {
                   timerElement.textContent = display;
                   
                   // Cambiar color cuando queda poco tiempo
                   if (this.timeLeft <= 60) {
                       timerElement.style.color = 'var(--danger-500)';
                   } else if (this.timeLeft <= 300) {
                       timerElement.style.color = 'var(--warning-500)';
                   }
               }
           }
           
           timeUp() {
               clearInterval(this.timer);
               alert('¡Se acabó el tiempo! El cuestionario se enviará automáticamente.');
               document.getElementById('quiz-form').dispatchEvent(new Event('submit'));
           }
           
           nextQuestion() {
               if (this.currentQuestion < this.totalQuestions) {
                   this.hideQuestion(this.currentQuestion);
                   this.currentQuestion++;
                   this.showQuestion(this.currentQuestion);
                   this.updateUI();
               }
           }
           
           prevQuestion() {
               if (this.currentQuestion > 1) {
                   this.hideQuestion(this.currentQuestion);
                   this.currentQuestion--;
                   this.showQuestion(this.currentQuestion);
                   this.updateUI();
               }
           }
           
           showQuestion(num) {
               const question = document.querySelector(\`[data-question="\${num}"]\`);
               if (question) {
                   question.classList.add('active');
                   question.style.display = 'block';
               }
           }
           
           hideQuestion(num) {
               const question = document.querySelector(\`[data-question="\${num}"]\`);
               if (question) {
                   question.classList.remove('active');
                   question.style.display = 'none';
               }
           }
           
           updateUI() {
               const prevBtn = document.getElementById('prev-btn');
               const nextBtn = document.getElementById('next-btn');
               const submitBtn = document.getElementById('submit-btn');
               
               prevBtn.disabled = this.currentQuestion === 1;
               
               if (this.currentQuestion === this.totalQuestions) {
                   nextBtn.style.display = 'none';
                   submitBtn.style.display = 'inline-block';
               } else {
                   nextBtn.style.display = 'inline-block';
                   submitBtn.style.display = 'none';
               }
               
               this.updateProgress();
           }
           
           updateProgress() {
               const progress = (this.currentQuestion / this.totalQuestions) * 100;
               const progressFill = document.getElementById('progress-fill');
               const progressText = document.getElementById('progress-text');
               
               if (progressFill) {
                   progressFill.style.width = progress + '%';
               }
               
               if (progressText) {
                   progressText.textContent = \`\${this.currentQuestion} / \${this.totalQuestions}\`;
               }
           }
           
           async handleSubmit(e) {
               e.preventDefault();
               
               clearInterval(this.timer);
               
               const formData = new FormData(e.target);
               const quizName = e.target.dataset.quiz;
               
               // Calcular puntuación (simulada)
               const correctAnswers = {
                   'question_1': 'madrid',
                   'question_2': 'true',
                   'question_3': '1492'
               };
               
               let score = 0;
               let totalAnswered = 0;
               
               for (const [key, value] of formData.entries()) {
                   totalAnswered++;
                   if (correctAnswers[key] && correctAnswers[key].toLowerCase() === value.toLowerCase()) {
                       score++;
                   }
               }
               
               const percentage = Math.round((score / this.totalQuestions) * 100);
               
               const response = {
                   id: 'resp_' + Date.now(),
                   quizName: quizName,
                   userId: 'usuario@example.com',
                   timestamp: Date.now(),
                   timeUsed: this.timeLimit - this.timeLeft,
                   answers: Object.fromEntries(formData),
                   results: {
                       totalPreguntas: this.totalQuestions,
                       totalCorrectas: score,
                       porcentaje: percentage,
                       gradeConfirmed: false
                   }
               };
               
               try {
                   // En una implementación real, esto se guardaría en la base de datos
                   console.log('Respuesta de cuestionario:', response);
                   
                   this.showResults(response.results);
               } catch (error) {
                   console.error('Error enviando cuestionario:', error);
                   alert('Error al enviar el cuestionario. Por favor, inténtalo de nuevo.');
               }
           }
           
           showResults(results) {
               let resultClass = 'success';
               let resultIcon = '✓';
               let resultMessage = '¡Excelente trabajo!';
               
               if (results.porcentaje < 60) {
                   resultClass = 'danger';
                   resultIcon = '✗';
                   resultMessage = 'Necesitas mejorar';
               } else if (results.porcentaje < 80) {
                   resultClass = 'warning';
                   resultIcon = '⚠';
                   resultMessage = '¡Buen trabajo!';
               }
               
               document.querySelector('.main-content').innerHTML = \`
                   <div class="container">
                       <div class="card">
                           <div class="card-body text-center">
                               <div style="font-size: 4rem; color: var(--\${resultClass}-500); margin-bottom: 1rem;">\${resultIcon}</div>
                               <h2>¡Cuestionario completado!</h2>
                               <p class="mb-4">\${resultMessage}</p>
                               
                               <div class="results-summary">
                                   <div class="result-item">
                                       <div class="result-number" style="color: var(--\${resultClass}-500)">\${results.porcentaje}%</div>
                                       <div class="result-label">Puntuación</div>
                                   </div>
                                   <div class="result-item">
                                       <div class="result-number">\${results.totalCorrectas}</div>
                                       <div class="result-label">Respuestas Correctas</div>
                                   </div>
                                   <div class="result-item">
                                       <div class="result-number">\${results.totalPreguntas}</div>
                                       <div class="result-label">Total de Preguntas</div>
                                   </div>
                               </div>
                               
                               <div class="mt-4">
                                   <button onclick="window.close()" class="btn btn-primary">Cerrar</button>
                                   <a href="../quizzes/index.html" class="btn btn-secondary">Ver más cuestionarios</a>
                               </div>
                           </div>
                       </div>
                   </div>
               \`;
           }
       }
       
       // Inicializar cuando el DOM esté listo
       document.addEventListener('DOMContentLoaded', () => {
           new QuizHandler();
       });
   </script>
   
   <style>
       .quiz-info-bar {
           margin-bottom: 1.5rem;
       }
       
       .quiz-meta {
           display: flex;
           justify-content: space-between;
           align-items: center;
           gap: 2rem;
       }
       
       .quiz-timer,
       .quiz-progress {
           display: flex;
           align-items: center;
           gap: 0.5rem;
       }
       
       .timer-display {
           font-weight: bold;
           font-size: 1.25rem;
           color: var(--primary-600);
           min-width: 60px;
       }
       
       .progress-bar {
           width: 120px;
           height: 8px;
           background: var(--gray-200);
           border-radius: var(--radius);
           overflow: hidden;
       }
       
       .progress-fill {
           height: 100%;
           background: var(--primary-500);
           transition: width 0.3s ease;
       }
       
       .progress-text {
			font-weight: 500;
           min-width: 40px;
       }
       
       .question-item {
           display: none;
       }
       
       .question-item.active {
           display: block;
       }
       
       .question-header {
           display: flex;
           justify-content: space-between;
           align-items: center;
           margin-bottom: 1rem;
           padding-bottom: 0.5rem;
           border-bottom: 1px solid var(--gray-200);
       }
       
       .question-number {
           font-size: 0.875rem;
           color: var(--gray-600);
           font-weight: 500;
       }
       
       .question-item h3 {
           margin-bottom: 1.5rem;
           color: var(--gray-800);
           font-size: 1.25rem;
       }
       
       .radio-group {
           display: flex;
           flex-direction: column;
           gap: 0.75rem;
       }
       
       .radio-label {
           display: flex;
           align-items: center;
           gap: 0.75rem;
           padding: 1rem;
           border: 2px solid var(--gray-200);
           border-radius: var(--radius);
           cursor: pointer;
           transition: var(--transition);
           background: white;
       }
       
       .radio-label:hover {
           background: var(--gray-50);
           border-color: var(--primary-300);
       }
       
       .radio-label input {
           margin: 0;
       }
       
       .radio-label input:checked + span {
           color: var(--primary-600);
           font-weight: 600;
       }
       
       .radio-label:has(input:checked) {
           border-color: var(--primary-500);
           background: var(--primary-50);
       }
       
       .form-navigation {
           display: flex;
           justify-content: space-between;
           margin-top: 2rem;
           padding-top: 2rem;
           border-top: 1px solid var(--gray-200);
       }
       
       .results-summary {
           display: flex;
           justify-content: center;
           gap: 2rem;
           margin: 2rem 0;
       }
       
       .result-item {
           text-align: center;
       }
       
       .result-number {
           font-size: 2rem;
           font-weight: bold;
           margin-bottom: 0.5rem;
       }
       
       .result-label {
           font-size: 0.875rem;
           color: var(--gray-600);
       }
       
       @media (max-width: 768px) {
           .quiz-meta {
               flex-direction: column;
               gap: 1rem;
           }
           
           .quiz-timer,
           .quiz-progress {
               width: 100%;
               justify-content: space-between;
           }
           
           .progress-bar {
               flex: 1;
               margin: 0 1rem;
           }
           
           .form-navigation {
               flex-direction: column;
               gap: 1rem;
           }
           
           .results-summary {
               flex-direction: column;
               gap: 1rem;
           }
           
           .radio-group {
               gap: 0.5rem;
           }
           
           .radio-label {
               padding: 0.75rem;
           }
       }
   </style>
</body>
</html>`;
   }

   getErrorPage(message) {
       return `<!DOCTYPE html>
<html lang="es">
<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <title>Error - Sistema Bancario Digital</title>
   <link rel="stylesheet" href="../assets/css/style.css">
</head>
<body>
   <header class="app-header">
       <div class="container">
           <h1>Error</h1>
       </div>
   </header>
   
   <main class="main-content">
       <div class="container">
           <div class="card">
               <div class="card-body text-center">
                   <div style="font-size: 4rem; color: var(--danger-500); margin-bottom: 1rem;">⚠</div>
                   <h2>Oops! Algo salió mal</h2>
                   <p>${message}</p>
                   <div class="mt-4">
                       <button onclick="window.close()" class="btn btn-primary">Cerrar</button>
                       <a href="../index.html" class="btn btn-secondary">Volver al inicio</a>
                   </div>
               </div>
           </div>
       </div>
   </main>
</body>
</html>`;
   }

   // Método público para generar páginas
   async getSurveyPage(surveyName) {
       return await this.generateSurveyPage(surveyName);
   }

   async getQuizPage(quizName) {
       return await this.generateQuizPage(quizName);
   }
}

// Hacer disponible globalmente
window.pageGenerator = new DynamicPageGenerator();

// Funciones de compatibilidad
window.generateSurveyPage = async function(surveyName) {
   return await window.pageGenerator.getSurveyPage(surveyName);
};

window.generateQuizPage = async function(quizName) {
   return await window.pageGenerator.getQuizPage(quizName);
};
