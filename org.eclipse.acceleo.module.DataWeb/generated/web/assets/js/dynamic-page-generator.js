/**
 * Generador dinámico de páginas HTML para encuestas y cuestionarios
 * Lee de IndexedDB y crea archivos HTML reales
 */

class DynamicPageGenerator {
    constructor() {
        this.baseURL = window.location.origin;
        this.surveysPath = '/web/surveys/';
        this.quizzesPath = '/web/quizzes/';
    }

    async init() {
	    try {
	        console.log('Inicializando generador dinámico de páginas...');
	        
	        // Esperar a que la base de datos esté disponible con timeout
	        const db = await Promise.race([
	            this.waitForDatabase(),
	            new Promise((_, reject) => 
	                setTimeout(() => reject(new Error('Timeout esperando base de datos')), 10000)
	            )
	        ]);
	        
	        if (!db) {
	            throw new Error('Base de datos no disponible después del timeout');
	        }
	        
	        console.log('Base de datos lista, procediendo con la generación...');
	        
	        // Generar páginas para encuestas
	        await this.generateSurveyPages();
	        
	        // Generar páginas para cuestionarios  
	        await this.generateQuizPages();
	        
	        console.log('✅ Generación de páginas dinámicas completada exitosamente');
	    } catch (error) {
	        console.error('❌ Error en la inicialización del generador de páginas:', error);
	        
	        // No lanzar el error para no romper el resto de la aplicación
	        // Solo registrar el problema
	        localStorage.setItem('page_generator_error', JSON.stringify({
	            error: error.message,
	            timestamp: Date.now()
	        }));
	    }
	}

	getGenerationStatus() {
    const surveyPages = JSON.parse(localStorage.getItem('generated_survey_pages') || '[]');
    const quizPages = JSON.parse(localStorage.getItem('generated_quiz_pages') || '[]');
    
    return {
        surveys: {
            total: surveyPages.length,
            pages: surveyPages
        },
        quizzes: {
            total: quizPages.length,
            pages: quizPages
        }
    };
	}

	// Función para forzar regeneración
	async forceRegeneration() {
	    console.log('🔄 Forzando regeneración de todas las páginas...');
	    
	    // Limpiar páginas existentes
	    localStorage.removeItem('generated_survey_pages');
	    localStorage.removeItem('generated_quiz_pages');
	    
	    // Regenerar todo
	    await this.generateSurveyPages();
	    await this.generateQuizPages();
	    
	    console.log('✅ Regeneración forzada completada');
	    
	    return this.getGenerationStatus();
	}

    async waitForDatabase() {
	    let attempts = 0;
	    const maxAttempts = 100;
	    
	    while (!window.localDB && attempts < maxAttempts) {
	        await new Promise(resolve => setTimeout(resolve, 100));
	        attempts++;
	    }
	    
	    if (!window.localDB) {
	        // Crear nuestra propia instancia de base de datos
	        try {
	            const request = indexedDB.open('DataWeb_DB', 2);
	            const db = await new Promise((resolve, reject) => {
	                request.onsuccess = () => {
	                    const database = request.result;
	                    const dbWrapper = {
	                        db: database,
	                        
	                        async getAll(storeName) {
	                            return new Promise((resolve, reject) => {
	                                if (!database.objectStoreNames.contains(storeName)) {
	                                    console.warn(`Store "${storeName}" does not exist`);
	                                    resolve([]);
	                                    return;
	                                }
	                                
	                                try {
	                                    const transaction = database.transaction([storeName], 'readonly');
	                                    const store = transaction.objectStore(storeName);
	                                    const request = store.getAll();
	                                    
	                                    request.onsuccess = () => {
	                                        resolve(request.result || []);
	                                    };
	                                    
	                                    request.onerror = () => {
	                                        console.error(`Error reading from ${storeName}:`, request.error);
	                                        resolve([]);
	                                    };
	                                } catch (error) {
	                                    console.error(`Transaction error in ${storeName}:`, error);
	                                    resolve([]);
	                                }
	                            });
	                        },
	                        
	                        async query(storeName, condition = {}) {
	                            return new Promise(async (resolve, reject) => {
	                                try {
	                                    // Obtener todos los registros primero
	                                    const allRecords = await this.getAll(storeName);
	                                    
	                                    // Si no hay condición, devolver todos
	                                    if (!condition || Object.keys(condition).length === 0) {
	                                        resolve(allRecords);
	                                        return;
	                                    }
	                                    
	                                    // Filtrar por la condición
	                                    const filteredRecords = allRecords.filter(record => {
	                                        return Object.keys(condition).every(key => {
	                                            // Comparación flexible (string vs number)
	                                            return record[key] == condition[key];
	                                        });
	                                    });
	                                    
	                                    resolve(filteredRecords);
	                                } catch (error) {
	                                    console.error(`Error querying ${storeName}:`, error);
	                                    resolve([]);
	                                }
	                            });
	                        },
	                        
	                        async create(storeName, data) {
	                            return new Promise((resolve, reject) => {
	                                if (!database.objectStoreNames.contains(storeName)) {
	                                    reject(new Error(`Store "${storeName}" does not exist`));
	                                    return;
	                                }
	                                
	                                try {
	                                    const transaction = database.transaction([storeName], 'readwrite');
	                                    const store = transaction.objectStore(storeName);
	                                    const request = store.add(data);
	                                    
	                                    request.onsuccess = () => resolve(request.result);
	                                    request.onerror = () => reject(request.error);
	                                } catch (error) {
	                                    reject(error);
	                                }
	                            });
	                        },
	                        
	                        async update(storeName, data) {
	                            return new Promise((resolve, reject) => {
	                                if (!database.objectStoreNames.contains(storeName)) {
	                                    reject(new Error(`Store "${storeName}" does not exist`));
	                                    return;
	                                }
	                                
	                                try {
	                                    const transaction = database.transaction([storeName], 'readwrite');
	                                    const store = transaction.objectStore(storeName);
	                                    const request = store.put(data);
	                                    
	                                    request.onsuccess = () => resolve(request.result);
	                                    request.onerror = () => reject(request.error);
	                                } catch (error) {
	                                    reject(error);
	                                }
	                            });
	                        },
	                        
	                        async delete(storeName, id) {
	                            return new Promise((resolve, reject) => {
	                                if (!database.objectStoreNames.contains(storeName)) {
	                                    reject(new Error(`Store "${storeName}" does not exist`));
	                                    return;
	                                }
	                                
	                                try {
	                                    const transaction = database.transaction([storeName], 'readwrite');
	                                    const store = transaction.objectStore(storeName);
	                                    const request = store.delete(id);
	                                    
	                                    request.onsuccess = () => resolve(request.result);
	                                    request.onerror = () => reject(request.error);
	                                } catch (error) {
	                                    reject(error);
	                                }
	                            });
	                        }
	                    };
	                    
	                    window.localDB = dbWrapper;
	                    resolve(dbWrapper);
	                };
	                
	                request.onerror = () => {
	                    console.error('Error opening database:', request.error);
	                    resolve(null);
	                };
	            });
	            
	            if (db) return db;
	        } catch (error) {
	            console.error('Error creating database wrapper:', error);
	        }
	    }
	    
	    return window.localDB;
	}

    async generateSurveyPages() {
	    try {
	        console.log('Generando páginas HTML para encuestas...');
	        
	        const surveys = await window.localDB.getAll('ENCUESTAS');
	        console.log('Encuestas obtenidas:', surveys.length);
	        
	        for (const survey of surveys) {
	            console.log(`Procesando encuesta: ${survey.nombre} (ID: ${survey.id_encuesta})`);
	            
	            // Obtener preguntas de la encuesta
	            let questions = [];
	            try {
	                questions = await window.localDB.query('PREGUNTAS_ENCUESTA', { 
	                    id_encuesta: survey.id_encuesta 
	                });
	                console.log(`Preguntas encontradas para ${survey.nombre}:`, questions.length);
	            } catch (error) {
	                console.warn(`Error obteniendo preguntas para ${survey.nombre}:`, error);
	                questions = [];
	            }
	            
	            // Obtener opciones para cada pregunta
	            for (const question of questions) {
	                try {
	                    const options = await window.localDB.query('OPCIONES_PREGUNTA', { 
	                        id_pregunta: question.id_pregunta 
	                    });
	                    question.opciones = options || [s];
	                    console.log(`Opciones para pregunta ${question.id_pregunta}:`, options.length);
	                } catch (error) {
	                    console.warn(`Error obteniendo opciones para pregunta ${question.id_pregunta}:`, error);
	                    question.opciones = [];
	                }
	            }
	            
	            // Generar HTML de la encuesta
	            const surveyHTML = this.generateSurveyHTML(survey, questions);
	            
	            // Guardar la página generada
	            this.saveSurveyPage(survey.nombre, surveyHTML);
	            
	            console.log(`✅ Página generada para encuesta: ${survey.nombre}`);
	        }
	        
	        console.log(`✅ Generación completada para ${surveys.length} encuestas`);
	    } catch (error) {
	        console.error('Error generando páginas de encuestas:', error);
	    }
	}

    async generateQuizPages() {
	    try {
	        console.log('Generando páginas HTML para cuestionarios...');
	        
	        const quizzes = await window.localDB.getAll('CUESTIONARIOS');
	        console.log('Cuestionarios obtenidos:', quizzes.length);
	        
	        for (const quiz of quizzes) {
	            console.log(`Procesando cuestionario: ${quiz.nombre} (ID: ${quiz.id_cuestionario})`);
	            
	            // Obtener preguntas del cuestionario
	            let questions = [];
	            try {
	                questions = await window.localDB.query('PREGUNTAS_CUESTIONARIO', { 
	                    id_cuestionario: quiz.id_cuestionario 
	                });
	                console.log(`Preguntas encontradas para ${quiz.nombre}:`, questions.length);
	            } catch (error) {
	                console.warn(`Error obteniendo preguntas para ${quiz.nombre}:`, error);
	                questions = [];
	            }
	            
	            // Obtener opciones para cada pregunta
	            for (const question of questions) {
	                try {
	                    const options = await window.localDB.query('OPCIONES_CUESTIONARIO', { 
	                        id_pregunta: question.id_pregunta 
	                    });
	                    question.opciones = options || [];
	                    console.log(`Opciones para pregunta ${question.id_pregunta}:`, options.length);
	                } catch (error) {
	                    console.warn(`Error obteniendo opciones para pregunta ${question.id_pregunta}:`, error);
	                    question.opciones = [];
	                }
	            }
	            
	            // Generar HTML del cuestionario
	            const quizHTML = this.generateQuizHTML(quiz, questions);
	            
	            // Guardar la página generada
	            this.saveQuizPage(quiz.nombre, quizHTML);
	            
	            console.log(`✅ Página generada para cuestionario: ${quiz.nombre}`);
	        }
	        
	        console.log(`✅ Generación completada para ${quizzes.length} cuestionarios`);
	    } catch (error) {
	        console.error('Error generando páginas de cuestionarios:', error);
	    }
	}

    generateSurveyHTML(survey, questions) {
        return `<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sistema Bancario Digital - ${survey.titulo}</title>
    <meta name="description" content="${survey.descripcion || 'Participa en la encuesta ' + survey.titulo}">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../assets/css/style.css">
    <link rel="icon" type="image/x-icon" href="../assets/icons/favicon.ico">
</head>
<body>
    <header class="app-header">
        <div class="container">
            <h1>${survey.titulo}</h1>
            <p>${survey.descripcion || 'Tu participación es importante para nosotros'}</p>
        </div>
    </header>
    
    <nav class="main-nav">
        <div class="container nav-container">
            <div class="nav-brand">
                <a href="../index.html" class="nav-logo">Sistema Bancario Digital</a>
            </div>
            <ul class="nav-menu">
                <li class="nav-item">
                    <a href="../index.html" class="nav-link">Inicio</a>
                </li>
                <li class="nav-item">
                    <a href="results_${survey.nombre}.html" class="nav-link">Ver Resultados</a>
                </li>
            </ul>
            <button class="nav-toggle" aria-label="Abrir menú">
                <span></span>
                <span></span>
                <span></span>
            </button>
        </div>
    </nav>
    
    <nav class="breadcrumb">
        <div class="container">
            <ul class="breadcrumb-list">
                <li class="breadcrumb-item">
                    <a href="../index.html" class="breadcrumb-link">Inicio</a>
                </li>
                <li class="breadcrumb-item">
                    <span>Encuestas</span>
                </li>
                <li class="breadcrumb-item">
                    <span>${survey.titulo}</span>
                </li>
            </ul>
        </div>
    </nav>
    
    <main class="main-content">
        <div class="container">
            <div class="survey-container">
                <div class="survey-progress">
                    <div class="progress-bar">
                        <div class="progress-fill" id="progress-fill" style="width: 0%"></div>
                    </div>
                    <div class="progress-text">
                        <span id="current-question">1</span> de <span id="total-questions">${questions.length}</span> preguntas
                    </div>
                </div>
                
                <form id="survey-form" class="survey-form card" data-survey-id="${survey.nombre}">
                    <div class="card-body">
                        ${questions.map((question, index) => `
                            <div class="question-container" data-question="${index + 1}" ${index > 0 ? 'style="display: none;"' : ''}>
                                <div class="question-header">
                                    <div class="question-number">Pregunta ${index + 1}</div>
                                    <h3 class="question-text">${question.texto}</h3>
                                </div>
                                
                                <div class="question-options">
                                    ${this.generateSurveyQuestionOptions(question, index + 1)}
                                </div>
                                
                                <div class="question-navigation">
                                    ${index > 0 ? `
                                        <button type="button" class="btn btn-secondary" onclick="previousQuestion(${index + 1})">
                                            <svg width="16" height="16" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
                                                <polyline points="15,18 9,12 15,6"></polyline>
                                            </svg>
                                            Anterior
                                        </button>
                                    ` : ''}
                                    
                                    ${index < questions.length - 1 ? `
                                        <button type="button" class="btn btn-primary ml-auto" onclick="nextQuestion(${index + 1})" disabled>
                                            Siguiente
                                            <svg width="16" height="16" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
                                                <polyline points="9,18 15,12 9,6"></polyline>
                                            </svg>
                                        </button>
                                    ` : `
                                        <button type="button" class="btn btn-success ml-auto" onclick="showSubmitConfirmation()" disabled>
                                            <svg width="16" height="16" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
                                                <polyline points="9,11 12,14 22,4"></polyline>
                                                <path d="m21 12 v7a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h11"></path>
                                            </svg>
                                            Enviar Encuesta
                                        </button>
                                    `}
                                </div>
                            </div>
                        `).join('')}
                    </div>
                </form>
                
                <!-- Modal de confirmación -->
                <div id="submit-confirmation-modal" class="modal">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4>¿Enviar encuesta?</h4>
                        </div>
                        <div class="modal-body">
                            <p>¿Estás seguro de que quieres enviar tus respuestas? Una vez enviadas no podrás modificarlas.</p>
                            <div id="submission-summary"></div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" onclick="closeModal()">Cancelar</button>
                            <button type="button" class="btn btn-success btn-submit-final" onclick="submitSurvey()">Sí, enviar</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>
    
    <footer class="app-footer">
        <div class="container">
            <div class="footer-bottom">
                <p>&copy; 2025 Sistema Bancario Digital. Todos los derechos reservados.</p>
            </div>
        </div>
    </footer>
    
    <script src="../assets/js/app.js"></script>
    <script src="../assets/js/survey.js"></script>
</body>
</html>`;
    }

    generateQuizHTML(quiz, questions) {
        return `<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sistema Bancario Digital - ${quiz.titulo}</title>
    <meta name="description" content="${quiz.descripcion || 'Evalúa tus conocimientos con el cuestionario ' + quiz.titulo}">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../assets/css/style.css">
    <link rel="icon" type="image/x-icon" href="../assets/icons/favicon.ico">
</head>
<body>
    <header class="app-header">
        <div class="container">
            <h1>${quiz.titulo}</h1>
            <p>${quiz.descripcion || 'Pon a prueba tus conocimientos'}</p>
        </div>
    </header>
    
    <nav class="main-nav">
        <div class="container nav-container">
            <div class="nav-brand">
                <a href="../index.html" class="nav-logo">Sistema Bancario Digital</a>
            </div>
            <ul class="nav-menu">
                <li class="nav-item">
                    <a href="../index.html" class="nav-link">Inicio</a>
                </li>
            </ul>
            <button class="nav-toggle" aria-label="Abrir menú">
                <span></span>
                <span></span>
                <span></span>
            </button>
        </div>
    </nav>
    
    <main class="main-content">
        <div class="container">
            <div class="quiz-container">
                <div class="quiz-info card mb-6">
                    <div class="card-body">
                        <div class="quiz-overview grid grid-cols-1 md:grid-cols-3 gap-6">
                            <div class="overview-item">
                                <div class="overview-icon">📝</div>
                                <div class="overview-content">
                                    <div class="overview-number">${questions.length}</div>
                                    <div class="overview-label">Preguntas</div>
                                </div>
                            </div>
                            <div class="overview-item">
                                <div class="overview-icon">⏱️</div>
                                <div class="overview-content">
                                    <div class="overview-number">${quiz.tiempoLimite || 30}</div>
                                    <div class="overview-label">Minutos</div>
                                </div>
                            </div>
                            <div class="overview-item">
                                <div class="overview-icon">🎯</div>
                                <div class="overview-content">
                                    <div class="overview-number">100</div>
                                    <div class="overview-label">Puntos Máximos</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                
                <div class="quiz-progress">
                    <div class="progress-bar">
                        <div class="progress-fill" id="progress-fill" style="width: 0%"></div>
                    </div>
                    <div class="progress-info">
                        <span class="progress-text">
                            Pregunta <span id="current-question">1</span> de <span id="total-questions">${questions.length}</span>
                        </span>
                        <span class="timer" id="timer-display">${quiz.tiempoLimite || 30}:00</span>
                    </div>
                </div>
                
                <form id="quiz-form" class="quiz-form card" data-quiz-id="${quiz.nombre}" data-time-limit="${quiz.tiempoLimite || 30}">
                    <div class="card-body">
                        ${questions.map((question, index) => `
                            <div class="question-container" data-question="${index + 1}" ${index > 0 ? 'style="display: none;"' : ''}>
                                <div class="question-header">
                                    <h3 class="question-text">${question.texto}</h3>
                                </div>
                                
                                <div class="question-options">
                                    ${this.generateQuizQuestionOptions(question, index + 1)}
                                </div>
                                
                                <div class="question-navigation">
                                    ${index > 0 ? `
                                        <button type="button" class="btn btn-secondary" onclick="previousQuestion(${index + 1})">
                                            Anterior
                                        </button>
                                    ` : ''}
                                    
                                    ${index < questions.length - 1 ? `
                                        <button type="button" class="btn btn-primary ml-auto" onclick="nextQuestion(${index + 1})" disabled>
                                            Siguiente
                                        </button>
                                    ` : `
                                        <button type="button" class="btn btn-success ml-auto" onclick="showSubmitConfirmation()" disabled>
                                            Finalizar Cuestionario
                                        </button>
                                    `}
                                </div>
                            </div>
                        `).join('')}
                    </div>
                </form>

                <!-- Modal de confirmación -->
                <div id="submit-confirmation-modal" class="modal">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4>¿Finalizar cuestionario?</h4>
                        </div>
                        <div class="modal-body">
                            <p>¿Estás seguro de que quieres finalizar? Una vez enviadas tus respuestas no podrás modificarlas.</p>
                            <div id="submission-summary"></div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" onclick="closeModal()">Cancelar</button>
                            <button type="button" class="btn btn-success btn-submit-final" onclick="submitSurvey()">Sí, finalizar</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>
    
    <footer class="app-footer">
        <div class="container">
            <div class="footer-bottom">
                <p>&copy; 2025 Sistema Bancario Digital. Todos los derechos reservados.</p>
            </div>
        </div>
    </footer>
    
    <script src="../assets/js/app.js"></script>
    <script src="../assets/js/survey.js"></script>
</body>
</html>`;
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

    generateQuizQuestionOptions(question, questionIndex) {
        if (question.tipo === 'opcion_multiple') {
            return question.opciones.map((option, optIndex) => {
                const letters = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'];
                const letter = letters[optIndex] || `${optIndex + 1}`;
                return `
                    <div class="option-card">
                        <input type="radio" id="q${questionIndex}_${option.valor}" name="question_${questionIndex}" value="${option.valor}" class="option-input" required>
                        <label for="q${questionIndex}_${option.valor}" class="option-label">
                            <div class="option-indicator">
                                <span class="option-letter">${letter}</span>
                            </div>
                            <div class="option-content">
                                <span class="option-text">${option.texto}</span>
                            </div>
                        </label>
                    </div>
                `;
            }).join('');
        } else if (question.tipo === 'verdadero_falso') {
            return `
                <div class="option-card">
                    <input type="radio" id="q${questionIndex}_true" name="question_${questionIndex}" value="true" class="option-input" required>
                    <label for="q${questionIndex}_true" class="option-label">
                        <div class="option-indicator">
                            <span class="option-letter">V</span>
                        </div>
                        <div class="option-content">
                            <span class="option-text">Verdadero</span>
                        </div>
                    </label>
                </div>
                <div class="option-card">
                    <input type="radio" id="q${questionIndex}_false" name="question_${questionIndex}" value="false" class="option-input" required>
                    <label for="q${questionIndex}_false" class="option-label">
                        <div class="option-indicator">
                            <span class="option-letter">F</span>
                        </div>
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

    saveSurveyPage(surveyName, html) {
        // En un entorno real, esto guardaría el archivo físicamente
        // Por ahora, usamos localStorage para simular
        localStorage.setItem(`generated_survey_${surveyName}`, html);
        
        // También crear una lista de páginas generadas
        const generatedPages = JSON.parse(localStorage.getItem('generated_survey_pages') || '[]');
        if (!generatedPages.includes(surveyName)) {
            generatedPages.push(surveyName);
            localStorage.setItem('generated_survey_pages', JSON.stringify(generatedPages));
        }
    }

    saveQuizPage(quizName, html) {
        // En un entorno real, esto guardaría el archivo físicamente
        // Por ahora, usamos localStorage para simular
        localStorage.setItem(`generated_quiz_${quizName}`, html);
        
        // También crear una lista de páginas generadas
        const generatedPages = JSON.parse(localStorage.getItem('generated_quiz_pages') || '[]');
        if (!generatedPages.includes(quizName)) {
            generatedPages.push(quizName);
            localStorage.setItem('generated_quiz_pages', JSON.stringify(generatedPages));
        }
    }

    // Método para obtener una página generada
    getSurveyPage(surveyName) {
        return localStorage.getItem(`generated_survey_${surveyName}`);
    }

    getQuizPage(quizName) {
        return localStorage.getItem(`generated_quiz_${quizName}`);
    }
}

// Inicializar el generador cuando la página se carga
document.addEventListener('DOMContentLoaded', async () => {
    // Esperar un poco para que otros scripts se inicialicen
    setTimeout(async () => {
        try {
            const generator = new DynamicPageGenerator();
            await generator.init();
            
            // Hacer el generador disponible globalmente
            window.pageGenerator = generator;
        } catch (error) {
            console.error('Error inicializando el generador de páginas:', error);
        }
    }, 2000);
});

// Exportar para uso global
window.DynamicPageGenerator = DynamicPageGenerator;
