/**
 * Gestor de Encuestas y Cuestionarios
 * Maneja la lógica de encuestas interactivas y cuestionarios evaluables
 */

class SurveyManager {
    constructor(surveyForm) {
        this.form = surveyForm;
        this.currentQuestion = 1;
        this.totalQuestions = this.form.querySelectorAll('.question-container').length;
        this.answers = new Map();
        this.startTime = Date.now();
        
        this.init();
    }

    init() {
        this.bindEvents();
        this.updateProgress();
        this.setupCharacterCounters();
        
        // Inicializar botones inmediatamente
        setTimeout(() => {
            this.updateNavigationButtons();
        }, 100);
    }

    bindEvents() {
        console.log('Binding events...');
        
        // Event delegation para todos los inputs
        this.form.addEventListener('change', this.handleInputChange.bind(this));
        this.form.addEventListener('input', this.handleTextInputChange.bind(this));
    }

    handleInputChange(event) {
        const input = event.target;
        console.log('Input changed:', input.type, input.name, input.value);
        
        if (input.type === 'radio') {
            this.handleRadioChange(input);
        } else if (input.type === 'checkbox') {
            this.handleCheckboxChange(input);
        }
        
        // Actualizar botones después de cualquier cambio
        setTimeout(() => {
            this.updateNavigationButtons();
        }, 10);
    }
    
    handleTextInputChange(event) {
        if (event.target.tagName === 'TEXTAREA' || event.target.type === 'text') {
            const input = event.target;
            this.answers.set(input.name, input.value);
            this.saveProgress();
            
            // Para inputs de texto, actualizar con un pequeño delay
            clearTimeout(this.textUpdateTimeout);
            this.textUpdateTimeout = setTimeout(() => {
                this.updateNavigationButtons();
            }, 300);
        }
    }

    handleRadioChange(input) {
        this.answers.set(input.name, input.value);
        console.log(`Radio selected: ${input.name} = ${input.value}`);
        this.saveProgress();
    }
    
    handleCheckboxChange(input) {
        const checkboxGroup = this.answers.get(input.name) || [];
        if (input.checked) {
            if (!checkboxGroup.includes(input.value)) {
                checkboxGroup.push(input.value);
            }
        } else {
            const index = checkboxGroup.indexOf(input.value);
            if (index > -1) checkboxGroup.splice(index, 1);
        }
        this.answers.set(input.name, checkboxGroup);
        this.saveProgress();
    }

    navigateToQuestion(questionNumber) {
        console.log('Navigating to question', questionNumber);
        
        // Ocultar todas las preguntas
        const allQuestions = this.form.querySelectorAll('.question-container');
        allQuestions.forEach(q => q.style.display = 'none');
        
        // Mostrar la pregunta específica
        const targetQuestion = this.form.querySelector(`.question-container[data-question="${questionNumber}"]`);
        
        if (targetQuestion) {
            targetQuestion.style.display = 'block';
            this.currentQuestion = questionNumber;
            this.updateProgress();
        } else {
            console.error('Question not found:', questionNumber);
        }
    }

    nextQuestion(currentIndex) {
        // Validar la pregunta actual antes de continuar
        if (!this.validateCurrentQuestion()) {
            return;
        }
        
        // Navegar a la siguiente pregunta
        if (currentIndex < this.totalQuestions) {
            this.navigateToQuestion(currentIndex + 1);
        }
    }

    previousQuestion(currentIndex) {
        // Navegar a la pregunta anterior
        if (currentIndex > 1) {
            this.navigateToQuestion(currentIndex - 1);
        }
    }

    validateCurrentQuestion() {
        // Buscar el contenedor de la pregunta actual
        const currentContainer = this.form.querySelector(`.question-container[data-question="${this.currentQuestion}"]`);
        
        if (!currentContainer) {
            console.log('Current container not found in validation');
            return true;
        }
        
        // Encontrar todos los inputs en esta pregunta
        const inputs = currentContainer.querySelectorAll('input, textarea');
        
        // Si no hay inputs, considerar válido
        if (inputs.length === 0) {
            return true;
        }
        
        // Agrupar radio buttons por nombre para encontrar los grupos únicos
        const radioGroups = {};
        let hasRadios = false;
        
        inputs.forEach(input => {
            if (input.type === 'radio') {
                hasRadios = true;
                if (!radioGroups[input.name]) {
                    radioGroups[input.name] = [];
                }
                radioGroups[input.name].push(input);
            }
        });
        
        // Verificar radio buttons - debe haber AL MENOS UN grupo con una selección
        if (hasRadios) {
            let atLeastOneGroupSelected = false;
            
            Object.keys(radioGroups).forEach(groupName => {
                let groupChecked = false;
                radioGroups[groupName].forEach(radio => {
                    if (radio.checked) {
                        groupChecked = true;
                    }
                });
                
                if (groupChecked) {
                    atLeastOneGroupSelected = true;
                }
            });
            
            if (!atLeastOneGroupSelected) {
                this.showValidationError(currentContainer, 'Por favor, selecciona una opción');
                return false;
            }
        }
        
        // Verificar campos de texto requeridos
        let textValid = true;
        inputs.forEach(input => {
            if ((input.type === 'text' || input.tagName === 'TEXTAREA') && input.hasAttribute('required')) {
                if (!input.value.trim()) {
                    textValid = false;
                    this.showValidationError(currentContainer, 'Este campo es obligatorio');
                }
            }
        });
        
        // Verificar checkboxes requeridos
        let checkboxValid = true;
        const checkboxGroups = {};
        inputs.forEach(input => {
            if (input.type === 'checkbox' && input.hasAttribute('required')) {
                if (!checkboxGroups[input.name]) {
                    checkboxGroups[input.name] = [];
                }
                checkboxGroups[input.name].push(input);
            }
        });
        
        Object.keys(checkboxGroups).forEach(groupName => {
            let groupChecked = false;
            checkboxGroups[groupName].forEach(checkbox => {
                if (checkbox.checked) {
                    groupChecked = true;
                }
            });
            
            if (!groupChecked) {
                checkboxValid = false;
                this.showValidationError(currentContainer, 'Por favor, selecciona al menos una opción');
            }
        });
        
        return textValid && checkboxValid;
    }

    updateProgress() {
        const progressFill = document.getElementById('progress-fill');
        const currentQuestionSpan = document.getElementById('current-question');
        
        if (progressFill) {
            const progress = (this.currentQuestion / this.totalQuestions) * 100;
            progressFill.style.width = `${progress}%`;
        }
        
        if (currentQuestionSpan) {
            currentQuestionSpan.textContent = this.currentQuestion;
        }

        this.updateNavigationButtons();
    }

    updateNavigationButtons() {
        // Buscar el contenedor de la pregunta actual
        const currentContainer = this.form.querySelector(`.question-container[data-question="${this.currentQuestion}"]`);
        
        if (!currentContainer) {
            console.log('Current container not found');
            return;
        }
        
        // Buscar botones en el contenedor actual
        const prevBtn = currentContainer.querySelector('button[onclick*="previousQuestion"]');
        const nextBtn = currentContainer.querySelector('button[onclick*="nextQuestion"], button[onclick*="showSubmitConfirmation"]');
        
        if (!nextBtn) return;
        
        const isAnswered = this.isQuestionAnswered(this.currentQuestion);
        console.log(`Update navigation buttons - Question ${this.currentQuestion} answered: ${isAnswered}`);
        
        // Habilitar/deshabilitar botón siguiente
        nextBtn.disabled = !isAnswered;
        
        if (isAnswered) {
            nextBtn.style.opacity = '1';
            nextBtn.style.cursor = 'pointer';
        } else {
            nextBtn.style.opacity = '0.5';
            nextBtn.style.cursor = 'not-allowed';
        }
        
        // El botón anterior siempre está habilitado si no es la primera pregunta
        if (prevBtn) {
            prevBtn.disabled = this.currentQuestion === 1;
        }
    }

    isQuestionAnswered(questionIndex) {
        const container = this.form.querySelector(`.question-container[data-question="${questionIndex}"]`);
        
        if (!container) {
            return false;
        }
        
        // Buscar inputs en el contenedor
        const inputs = container.querySelectorAll('input, textarea');
        
        // Verificar si hay radio buttons seleccionados
        const radioInputs = Array.from(inputs).filter(input => input.type === 'radio');
        if (radioInputs.length > 0) {
            return radioInputs.some(radio => radio.checked);
        }
        
        // Verificar si hay checkboxes requeridos seleccionados
        const checkboxInputs = Array.from(inputs).filter(input => input.type === 'checkbox' && input.hasAttribute('required'));
        if (checkboxInputs.length > 0) {
            // Agrupar por nombre
            const groups = {};
            checkboxInputs.forEach(checkbox => {
                if (!groups[checkbox.name]) {
                    groups[checkbox.name] = [];
                }
                groups[checkbox.name].push(checkbox);
            });
            
            // Verificar que cada grupo tenga al menos uno seleccionado
            return Object.values(groups).every(group => 
                group.some(checkbox => checkbox.checked)
            );
        }
        
        // Verificar si hay campos de texto requeridos con contenido
        const textInputs = Array.from(inputs).filter(input => 
            (input.type === 'text' || input.tagName === 'TEXTAREA') && 
            input.hasAttribute('required')
        );
        
        if (textInputs.length > 0) {
            return textInputs.every(input => input.value.trim() !== '');
        }
        
        // Si no hay campos requeridos, se considera contestada
        return true;
    }

    showValidationError(container, message) {
        // Remover errores previos
        const existingErrors = container.querySelectorAll('.validation-error');
        existingErrors.forEach(error => error.remove());
        
        const errorDiv = document.createElement('div');
        errorDiv.className = 'validation-error';
        errorDiv.style.cssText = `
            background: var(--danger-50);
            border: 1px solid var(--danger-200);
            color: var(--danger-700);
            padding: 1rem;
            border-radius: var(--radius);
            margin-top: 1rem;
            font-size: 0.875rem;
        `;
        errorDiv.textContent = message;
        
        // Buscar donde insertar el error
        const navigation = container.querySelector('.question-navigation');
        
        if (navigation) {
            navigation.parentNode.insertBefore(errorDiv, navigation);
        } else {
            container.appendChild(errorDiv);
        }
        
        // Auto-eliminar después de un tiempo
        setTimeout(() => {
            if (errorDiv.parentNode) {
                errorDiv.remove();
            }
        }, 5000);
    }

    setupCharacterCounters() {
        const textareas = this.form.querySelectorAll('textarea[maxlength]');
        
        textareas.forEach(textarea => {
            const maxLength = parseInt(textarea.getAttribute('maxlength'));
            const wrapper = textarea.parentNode;
            
            // Función para actualizar contador
            const updateCounter = () => {
                const counterElement = wrapper.querySelector('.textarea-counter span');
                if (counterElement) {
                    const currentLength = textarea.value.length;
                    counterElement.textContent = currentLength;
                    
                    // Cambiar color si se acerca al límite
                    const parentDiv = counterElement.parentNode;
                    if (currentLength > maxLength * 0.9) {
                        parentDiv.style.color = 'var(--warning-600)';
                    } else if (currentLength === maxLength) {
                        parentDiv.style.color = 'var(--danger-600)';
                    } else {
                        parentDiv.style.color = 'var(--gray-500)';
                    }
                }
            };
            
            // Eventos para actualizar contador
            textarea.addEventListener('input', updateCounter);
            textarea.addEventListener('paste', () => setTimeout(updateCounter, 10));
            
            // Inicializar contador
            updateCounter();
        });
    }

    showSubmitConfirmation() {
        if (!this.validateAllQuestions()) {
            if (window.app && window.app.showAlert) {
                window.app.showAlert('Por favor, completa todas las preguntas requeridas antes de enviar', 'warning');
            }
            return;
        }
        
        const modal = document.getElementById('submit-confirmation-modal');
        if (modal) {
            modal.style.display = 'flex';
            modal.classList.add('show');
            this.updateSubmissionSummary();
        }
    }

    validateAllQuestions() {
        for (let i = 1; i <= this.totalQuestions; i++) {
            if (!this.isQuestionAnswered(i)) {
                const container = this.form.querySelector(`[data-question="${i}"]`);
                if (container) {
                    const requiredInputs = container.querySelectorAll('[required]');
                    if (requiredInputs.length > 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    updateSubmissionSummary() {
        const summaryContainer = document.getElementById('submission-summary');
        if (!summaryContainer) return;

        let summary = `<h4>Resumen de respuestas</h4>`;
        summary += `<p>Total de preguntas respondidas: ${this.answers.size}</p>`;
        summary += `<p>Tiempo empleado: ${this.getElapsedTime()}</p>`;
        
        summaryContainer.innerHTML = summary;
    }

    getElapsedTime() {
        const elapsed = Math.floor((Date.now() - this.startTime) / 1000);
        const minutes = Math.floor(elapsed / 60);
        const seconds = elapsed % 60;
        
        return `${minutes}m ${seconds}s`;
    }

    async submitSurvey() {
        const submitBtn = document.querySelector('.btn-submit-final');
        const originalText = submitBtn ? submitBtn.textContent : '';
        
        try {
            if (submitBtn) {
                submitBtn.disabled = true;
                submitBtn.innerHTML = '<span class="spinner"></span> Enviando...';
            }

            // Guardar respuesta en indexedDB
            const response = {
                id: `resp_${Date.now()}`,
                surveyName: this.form.dataset.surveyId,
                userId: 'usuario@example.com', // En una implementación real, sería el usuario actual
                timestamp: Date.now(),
                approved: false, // Las respuestas de encuestas requieren aprobación del administrador
                answers: Object.fromEntries(this.answers)
            };
            
            // Intentar guardar en IndexedDB
            try {
                const db = await this.ensureDatabase();
                await db.create('RESPUESTAS_ENCUESTA', response);
                console.log('Respuesta guardada con éxito:', response);
            } catch (dbError) {
                console.error('Error al guardar en IndexedDB:', dbError);
                // Seguir con el flujo incluso si falla el guardado
            }

            setTimeout(() => {
                this.clearProgress();
                this.showSuccessPage();
                this.closeModal();
            }, 1000);

        } catch (error) {
            console.error('Error al enviar encuesta:', error);
            if (window.app && window.app.showAlert) {
                window.app.showAlert('Error al enviar la encuesta. Por favor, inténtalo de nuevo.', 'danger');
            }
            
            if (submitBtn) {
                submitBtn.disabled = false;
                submitBtn.textContent = originalText;
            }
        }
    }

    showSuccessPage() {
        this.form.style.display = 'none';
        
        const successDiv = document.createElement('div');
        successDiv.className = 'survey-success';
        successDiv.innerHTML = `
            <div class="text-center">
                <div class="success-icon">
                    <svg width="64" height="64" fill="var(--success-600)" viewBox="0 0 20 20">
                        <path fill-rule="evenodd" d="M10 18a8 8 0 100-16 8 8 0 000 16zm3.707-9.293a1 1 0 00-1.414-1.414L9 10.586 7.707 9.293a1 1 0 00-1.414 1.414l2 2a1 1 0 001.414 0l4-4z" clip-rule="evenodd"/>
                    </svg>
                </div>
                <h2>¡Encuesta enviada correctamente!</h2>
                <p>Gracias por tu participación. Tus respuestas han sido registradas y están pendientes de revisión.</p>
                <a href="../index.html" class="btn btn-primary">Volver al inicio</a>
            </div>
        `;
        
        this.form.parentNode.appendChild(successDiv);
    }

    closeModal() {
        const modal = document.getElementById('submit-confirmation-modal');
        if (modal) {
            modal.classList.remove('show');
            setTimeout(() => {
                modal.style.display = 'none';
            }, 300);
        }
    }

    saveProgress() {
        const progress = {
            surveyId: this.form.dataset.surveyId,
            currentQuestion: this.currentQuestion,
            answers: Object.fromEntries(this.answers),
            startTime: this.startTime,
            lastSaved: Date.now()
        };
        
        try {
            localStorage.setItem(`survey_progress_${this.form.dataset.surveyId}`, JSON.stringify(progress));
        } catch (error) {
            console.error('Error saving progress:', error);
        }
    }

    loadProgress() {
        try {
            const progressData = localStorage.getItem(`survey_progress_${this.form.dataset.surveyId}`);
            if (!progressData) return false;

            const progress = JSON.parse(progressData);
            console.log('Loading progress:', progress);
            
            // Cargar respuestas previas
            this.answers = new Map();
            if (progress.answers) {
                Object.entries(progress.answers).forEach(([key, value]) => {
                    this.answers.set(key, value);
                });
            }
            
            this.startTime = progress.startTime || Date.now();
            
            // Restaurar estado de los inputs
            this.answers.forEach((value, name) => {
                const inputs = this.form.querySelectorAll(`input[name="${name}"], textarea[name="${name}"]`);
                inputs.forEach(input => {
                    if (input.type === 'radio' || input.type === 'checkbox') {
                        if (Array.isArray(value)) {
                            input.checked = value.includes(input.value);
                        } else {
                            input.checked = input.value === value;
                        }
                    } else {
                        input.value = value;
                    }
                });
            });
            
            // Navegar a la pregunta guardada
            this.navigateToQuestion(progress.currentQuestion || 1);
            
            return true;
        } catch (error) {
            console.error('Error loading progress:', error);
            return false;
        }
    }

    clearProgress() {
        try {
            localStorage.removeItem(`survey_progress_${this.form.dataset.surveyId}`);
        } catch (error) {
            console.error('Error clearing progress:', error);
        }
    }

    async ensureDatabase() {
        try {
            // Si la base de datos global ya existe, la usamos
            if (window.localDB && window.localDB.db) {
                return window.localDB;
            }

            // Importar o crear LocalDBManager
            const LocalDBManager = window.LocalDBManager || class LocalDBManager {
                constructor() {
                    this.dbName = 'DataWeb_DB';
                    this.version = 1;
                    this.db = null;
                }

                async init() {
                    return new Promise((resolve, reject) => {
                        const request = indexedDB.open(this.dbName, this.version);
                        
                        request.onerror = () => {
                            reject(request.error);
                        };
                        
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

                            if (!db.objectStoreNames.contains('RESPUESTAS_CUESTIONARIO')) {
                                const store = db.createObjectStore('RESPUESTAS_CUESTIONARIO', { 
                                    keyPath: 'id', 
                                    autoIncrement: false 
                                });
                                store.createIndex('quizName', 'quizName', { unique: false });
                                store.createIndex('userId', 'userId', { unique: false });
                                store.createIndex('reviewed', 'reviewed', { unique: false });
                            }
                        };
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

                async getAll(tableName) {
                    return new Promise((resolve, reject) => {
                        const transaction = this.db.transaction([tableName], 'readonly');
                        const store = transaction.objectStore(tableName);
                        const request = store.getAll();
                        
                        request.onsuccess = () => resolve(request.result);
                        request.onerror = () => reject(request.error);
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

            // Inicializar base de datos
            const dbManager = new LocalDBManager();
            await dbManager.init();
            
            // Guardar globalmente
            window.localDB = dbManager;
            
            return dbManager;
        } catch (error) {
            console.error('Error initializing database:', error);
            throw error;
        }
    }
}

// Clase para gestión de cuestionarios (con evaluación)
class QuizManager extends SurveyManager {
    constructor(quizForm) {
        super(quizForm);
        this.isQuiz = true;
        this.timeLimit = quizForm.dataset.timeLimit ? parseInt(quizForm.dataset.timeLimit) : 30; // Por defecto 30 minutos
        this.timer = null;
        this.timeRemaining = this.timeLimit * 60; // Convertir a segundos
        
        this.initTimer();
    }

    initTimer() {
        const timerDisplay = document.getElementById('timer-display');
        if (!timerDisplay) return;

        // Configurar tiempo inicial
        this.updateTimerDisplay();
        
        // Iniciar temporizador
        this.timer = setInterval(() => {
            this.timeRemaining--;
            
            this.updateTimerDisplay();
            
            // Tiempo agotado
            if (this.timeRemaining <= 0) {
                clearInterval(this.timer);
                this.submitQuiz(true); // Auto-envío
            }
        }, 1000);
    }
    
    updateTimerDisplay() {
        const timerDisplay = document.getElementById('timer-display');
        if (!timerDisplay) return;
        
        const minutes = Math.floor(this.timeRemaining / 60);
        const seconds = this.timeRemaining % 60;
        
        timerDisplay.textContent = `${minutes.toString().padStart(2, '0')}:${seconds.toString().padStart(2, '0')}`;
        
        // Cambiar color cuando quede poco tiempo
        if (this.timeRemaining <= 300) { // 5 minutos
            timerDisplay.style.color = 'var(--warning-600)';
        }
        if (this.timeRemaining <= 60) { // 1 minuto
            timerDisplay.style.color = 'var(--danger-600)';
        }
    }

    async submitQuiz(autoSubmit = false) {
        if (this.timer) {
            clearInterval(this.timer);
        }

        const submitBtn = document.querySelector('.btn-submit-final');
        const originalText = submitBtn ? submitBtn.textContent : '';
        
        try {
            // Mostrar estado de carga
            if (submitBtn) {
                submitBtn.disabled = true;
                submitBtn.innerHTML = '<span class="spinner"></span> Evaluando...';
            }

            // Simular evaluación
            const resultados = this.evaluateQuiz();

            // Guardar resultados en IndexedDB
            const response = {
                id: `quiz_${Date.now()}`,
                quizName: this.form.dataset.quizId,
                userId: 'usuario@example.com', // En una implementación real, sería el usuario actual
                timestamp: Date.now(),
                reviewed: false, // Los cuestionarios requieren revisión por un administrador
                results: resultados,
                answers: Object.fromEntries(this.answers),
                timeUsed: this.timeLimit * 60 - this.timeRemaining
            };
            
            // Intentar guardar en IndexedDB
            try {
                const db = await this.ensureDatabase();
                await db.create('RESPUESTAS_CUESTIONARIO', response);
                console.log('Resultados del cuestionario guardados con éxito:', response);
            } catch (dbError) {
                console.error('Error al guardar en IndexedDB:', dbError);
                // Seguir con el flujo incluso si falla el guardado
            }

            setTimeout(() => {
                // Limpiar progreso guardado
                this.clearProgress();
                
                // Mostrar resultados preliminares
                this.showQuizResults(resultados);
                
                // Cerrar modal si existe
                this.closeModal();
            }, 1500);

        } catch (error) {
            console.error('Error al enviar cuestionario:', error);
            if (window.app && window.app.showAlert) {
                window.app.showAlert('Error al enviar el cuestionario. Por favor, inténtalo de nuevo.', 'danger');
            }
            
            // Restaurar botón
            if (submitBtn) {
                submitBtn.disabled = false;
                submitBtn.textContent = originalText;
            }
        }
    }

    evaluateQuiz() {
        // Evaluación de cuestionario
        const totalPreguntas = this.totalQuestions;
        const totalCorrectas = Math.floor(Math.random() * (totalPreguntas + 1)); // Entre 0 y total
        const porcentaje = Math.round((totalCorrectas / totalPreguntas) * 100);
        
        const preguntas = [];
        for (let i = 1; i <= totalPreguntas; i++) {
            const container = this.form.querySelector(`[data-question="${i}"]`);
            const questionText = container.querySelector('.question-text')?.textContent || `Pregunta ${i}`;
            
            // Alternamos respuestas correctas e incorrectas para simular
            const isCorrect = Math.random() > 0.3; // 70% probabilidad de estar correcta
            
            preguntas.push({
                texto: questionText,
                respuesta: this.answers.get(`question_${i}`) || 'No respondida',
                esCorrecta: isCorrect,
                respuestaCorrecta: 'Respuesta correcta simulada',
                correctionReviewed: false // Indica si un admin ha revisado la corrección
            });
        }

        return {
            totalPreguntas,
            totalCorrectas,
            porcentaje,
            preguntas,
            gradeConfirmed: false // El administrador debe confirmar la calificación
        };
    }

    showQuizResults(resultados) {
	    // Ocultar formulario
	    this.form.style.display = 'none';
	    
	    // Crear página de resultados preliminares
	    const resultsDiv = document.createElement('div');
	    resultsDiv.className = 'quiz-results';
	    resultsDiv.innerHTML = `
	        <div class="results-header text-center">
	            <h2>Resultados Preliminares del Cuestionario</h2>
	            <div class="alert alert-info">
	                <strong>Nota:</strong> Estos resultados son preliminares y están pendientes de revisión por un profesor o administrador.
	                Una vez que sean revisados y confirmados, podrás ver el detalle completo.
	            </div>
	            
	            <div class="score-display">
	                <div class="score-circle">
	                    <span class="score-value">${resultados.porcentaje}%</span>
	                </div>
	                <p class="score-details">
	                    ${resultados.totalCorrectas} de ${resultados.totalPreguntas} respuestas correctas (preliminar)
	                </p>
	            </div>
	            
	            <div class="results-actions mt-6">
	                <a href="results.html" class="btn btn-primary">Ver mis resultados confirmados</a>
	                <a href="../index.html" class="btn btn-secondary">Volver al inicio</a>
	            </div>
	        </div>
	    `;
	    
	    this.form.parentNode.appendChild(resultsDiv);
	    
	    // Animar la puntuación
	    this.animateScore(resultados.porcentaje);
	}

    animateScore(targetScore) {
        const scoreElement = document.querySelector('.score-value');
        if (!scoreElement) return;

        let currentScore = 0;
        const increment = targetScore / 50; // 50 frames de animación
        
        const animateFrame = () => {
            currentScore += increment;
            
            if (currentScore >= targetScore) {
                scoreElement.textContent = `${targetScore}%`;
                return;
            }
            
            scoreElement.textContent = `${Math.round(currentScore)}%`;
            requestAnimationFrame(animateFrame);
        };
        
        requestAnimationFrame(animateFrame);
    }
}

// Funciones globales para los onclick
window.nextQuestion = function(currentIndex) {
    console.log('nextQuestion called with:', currentIndex);
    
    // Intentar con QuizManager primero, luego con SurveyManager
    if (window.quizManager) {
        console.log('Using quizManager');
        window.quizManager.nextQuestion(currentIndex);
    } else if (window.surveyManager) {
        console.log('Using surveyManager');
        window.surveyManager.nextQuestion(currentIndex);
    } else {
        console.error('Neither quizManager nor surveyManager found');
    }
};

window.previousQuestion = function(currentIndex) {
    console.log('previousQuestion called with:', currentIndex);
    
    if (window.quizManager) {
        console.log('Using quizManager');
        window.quizManager.previousQuestion(currentIndex);
    } else if (window.surveyManager) {
        console.log('Using surveyManager');
        window.surveyManager.previousQuestion(currentIndex);
    } else {
        console.error('Neither quizManager nor surveyManager found');
    }
};

window.showSubmitConfirmation = function() {
    console.log('showSubmitConfirmation called');
    
    if (window.quizManager) {
        console.log('Using quizManager');
        window.quizManager.showSubmitConfirmation();
    } else if (window.surveyManager) {
        console.log('Using surveyManager');
        window.surveyManager.showSubmitConfirmation();
    } else {
        console.error('Neither quizManager nor surveyManager found');
    }
};

window.submitSurvey = function() {
    console.log('submitSurvey called');
    
    if (window.quizManager) {
        console.log('Using quizManager submitQuiz');
        window.quizManager.submitQuiz();
    } else if (window.surveyManager) {
        console.log('Using surveyManager submitSurvey');
        window.surveyManager.submitSurvey();
    } else {
        console.error('Neither quizManager nor surveyManager found');
    }
};

window.closeModal = function() {
    console.log('closeModal called');
    
    if (window.quizManager) {
        window.quizManager.closeModal();
    } else if (window.surveyManager) {
        window.surveyManager.closeModal();
    } else {
        console.error('Neither quizManager nor surveyManager found');
    }
};

// Inicialización automática
document.addEventListener('DOMContentLoaded', () => {
    console.log('DOM loaded, initializing surveys and quizzes...');
    
    const surveyForm = document.querySelector('.survey-form');
    const quizForm = document.querySelector('.quiz-form');
    
    if (quizForm) {
        console.log('Found quiz form, creating QuizManager...');
        window.quizManager = new QuizManager(quizForm);
        
        // Para cuestionarios, siempre empezar desde el principio
        window.quizManager.navigateToQuestion(1);
    } else if (surveyForm) {
        console.log('Found survey form, creating SurveyManager...');
        window.surveyManager = new SurveyManager(surveyForm);
        
        // Intentar cargar progreso previo
        if (!window.surveyManager.loadProgress()) {
            // Si no hay progreso previo, mostrar primera pregunta
            console.log('No previous progress, starting from question 1');
            window.surveyManager.navigateToQuestion(1);
        }
    } else {
        console.log('No survey or quiz form found');
    }
});
