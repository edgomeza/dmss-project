/**
 * JavaScript unificado para encuestas y cuestionarios
 */

// Configuración global
const CONFIG = {
    SYSTEM_ROLES: [
        'AdministradorBanco'
,         'GerenteOperaciones'
,         'EmpleadoBanco'
,         'Cliente'
    ],
    DB_NAME: 'Sistema_Bancario Digital_DB',
    DB_VERSION: 2
};

// Base de datos unificada
class UnifiedDB {
    constructor() {
        this.db = null;
        this.stores = [
            'ENCUESTAS', 'CUESTIONARIOS', 
            'PREGUNTAS_ENCUESTA', 'PREGUNTAS_CUESTIONARIO', 
            'OPCIONES_PREGUNTA', 'OPCIONES_CUESTIONARIO', 
            'RESPUESTAS_ENCUESTA', 'RESPUESTAS_CUESTIONARIO'
        ];
    }

    async init() {
        const self = this;
        return new Promise((resolve, reject) => {
            const request = indexedDB.open(CONFIG.DB_NAME, CONFIG.DB_VERSION);
            
            request.onsuccess = () => {
                self.db = request.result;
                console.log('✅ Base de datos unificada inicializada');
                resolve(self.db);
            };
            
            request.onerror = () => {
                console.error('❌ Error abriendo base de datos:', request.error);
                reject(request.error);
            };
            
            request.onupgradeneeded = (event) => {
                const db = event.target.result;
                console.log('🔄 Actualizando esquema de base de datos...');
                
                // Crear todos los object stores necesarios
                self.stores.forEach(storeName => {
                    if (!db.objectStoreNames.contains(storeName)) {
                        const store = db.createObjectStore(storeName, { 
                            keyPath: 'id', 
                            autoIncrement: true 
                        });
                        console.log(`📁 Object store creado: ${storeName}`);
                        
                        // Crear índices adicionales si es necesario
                        if (storeName.includes('PREGUNTAS_')) {
                            store.createIndex('parentId', storeName === 'PREGUNTAS_ENCUESTA' ? 'id_encuesta' : 'id_cuestionario', { unique: false });
                        }
                        if (storeName.includes('RESPUESTAS_')) {
                            store.createIndex('userId', 'userId', { unique: false });
                        }
                    }
                });
                
                // Inicializar datos de ejemplo después de que se complete la transacción
                request.transaction.oncomplete = () => {
                    console.log('🌱 Inicializando datos de ejemplo...');
                    self.seedExampleData(db);
                };
            };
        });
    }

    async seedExampleData(db) {
        try {
            // Crear datos de ejemplo para encuestas
            const encuestaTransaction = db.transaction('ENCUESTAS', 'readwrite');
            const encuestaStore = encuestaTransaction.objectStore('ENCUESTAS');
            
            const encuestasEjemplo = [
                {
                    nombre: 'encuesta_satisfaccion',
                    titulo: 'Encuesta de Satisfacción',
                    descripcion: 'Evalúa tu experiencia con nuestra aplicación',
                    tipoRepresentacion: 'barras',
                    timestamp: Date.now()
                },
                {
                    nombre: 'encuesta_productos',
                    titulo: 'Encuesta de Productos',
                    descripcion: 'Ayúdanos a mejorar nuestros productos',
                    tipoRepresentacion: 'tarta',
                    timestamp: Date.now()
                }
            ];

            for (const encuesta of encuestasEjemplo) {
                encuestaStore.add(encuesta);
            }

            // Crear datos de ejemplo para cuestionarios
            const cuestionarioTransaction = db.transaction('CUESTIONARIOS', 'readwrite');
            const cuestionarioStore = cuestionarioTransaction.objectStore('CUESTIONARIOS');
            
            const cuestionariosEjemplo = [
                {
                    nombre: 'quiz_conocimientos',
                    titulo: 'Cuestionario de Conocimientos',
                    descripcion: 'Evalúa tus conocimientos sobre el tema',
                    tiempoLimite: 30,
                    timestamp: Date.now()
                },
                {
                    nombre: 'quiz_evaluacion',
                    titulo: 'Cuestionario de Evaluación',
                    descripcion: 'Evaluación final del curso',
                    tiempoLimite: 45,
                    timestamp: Date.now()
                }
            ];

            for (const cuestionario of cuestionariosEjemplo) {
                cuestionarioStore.add(cuestionario);
            }

            console.log('🌱 Datos de ejemplo inicializados correctamente');
        } catch (error) {
            console.error('❌ Error inicializando datos de ejemplo:', error);
        }
    }

    async create(storeName, data) {
        try {
            if (!this.db.objectStoreNames.contains(storeName)) {
                throw new Error(`Object store ${storeName} no existe`);
            }
            
            const transaction = this.db.transaction(storeName, 'readwrite');
            const store = transaction.objectStore(storeName);
            
            return new Promise((resolve, reject) => {
                const request = store.add(data);
                request.onsuccess = () => resolve(request.result);
                request.onerror = () => reject(request.error);
            });
        } catch (error) {
            console.error(`Error en create (${storeName}):`, error);
            throw error;
        }
    }

    async getAll(storeName) {
        try {
            if (!this.db.objectStoreNames.contains(storeName)) {
                console.warn(`Object store ${storeName} no existe, retornando array vacío`);
                return [];
            }
            
            const transaction = this.db.transaction(storeName, 'readonly');
            const store = transaction.objectStore(storeName);
            
            return new Promise((resolve, reject) => {
                const request = store.getAll();
                request.onsuccess = () => resolve(request.result || []);
                request.onerror = () => reject(request.error);
            });
        } catch (error) {
            console.error(`Error en getAll (${storeName}):`, error);
            return [];
        }
    }
    
    async get(storeName, id) {
        try {
            if (!this.db.objectStoreNames.contains(storeName)) {
                return null;
            }
            
            const transaction = this.db.transaction(storeName, 'readonly');
            const store = transaction.objectStore(storeName);
            
            return new Promise((resolve, reject) => {
                const request = store.get(id);
                request.onsuccess = () => resolve(request.result);
                request.onerror = () => reject(request.error);
            });
        } catch (error) {
            console.error(`Error en get (${storeName}):`, error);
            return null;
        }
    }
    
    async update(storeName, data) {
        try {
            if (!this.db.objectStoreNames.contains(storeName)) {
                throw new Error(`Object store ${storeName} no existe`);
            }
            
            const transaction = this.db.transaction(storeName, 'readwrite');
            const store = transaction.objectStore(storeName);
            
            return new Promise((resolve, reject) => {
                const request = store.put(data);
                request.onsuccess = () => resolve(request.result);
                request.onerror = () => reject(request.error);
            });
        } catch (error) {
            console.error(`Error en update (${storeName}):`, error);
            throw error;
        }
    }
    
    async delete(storeName, id) {
        try {
            if (!this.db.objectStoreNames.contains(storeName)) {
                throw new Error(`Object store ${storeName} no existe`);
            }
            
            const transaction = this.db.transaction(storeName, 'readwrite');
            const store = transaction.objectStore(storeName);
            
            return new Promise((resolve, reject) => {
                const request = store.delete(id);
                request.onsuccess = () => resolve(request.result);
                request.onerror = () => reject(request.error);
            });
        } catch (error) {
            console.error(`Error en delete (${storeName}):`, error);
            throw error;
        }
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
        this.initialized = false;
    }

    async init() {
        if (this.initialized) return;
        
        try {
            await this.db.init();
            this.initialized = true;
            window.localDB = this.db;
            console.log('✅ SurveyQuizManager inicializado correctamente');
        } catch (error) {
            console.error('❌ Error inicializando SurveyQuizManager:', error);
        }
    }

    // Cargar contenido dinámico
    async loadContent(type) {
        await this.init(); // Asegurar inicialización
        
        const container = document.getElementById(`${type}-container`);
        if (!container) {
            console.warn(`Contenedor ${type}-container no encontrado`);
            return;
        }

        try {
            const storeName = type === 'surveys' ? 'ENCUESTAS' : 'CUESTIONARIOS';
            const items = await this.db.getAll(storeName);
            const currentRole = localStorage.getItem('current_role') || 'Usuario';
            const assignments = JSON.parse(localStorage.getItem(`${type.slice(0,-1)}_role_assignments`) || '{}');
            
            console.log(`📊 Cargados ${items.length} elementos de ${storeName}`);
            
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
            container.innerHTML = `<div class="error">Error cargando ${type}: ${error.message}</div>`;
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
            const storeName = type === 'surveys' ? 'ENCUESTAS' : 'CUESTIONARIOS';
            const items = await this.db.getAll(storeName);
            
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
    async initCreator(type) {
        await this.init();
        this.questionCount = 0;
        this.addQuestion();
        
        const formId = `create${type.charAt(0).toUpperCase() + type.slice(1)}Form`;
        const form = document.getElementById(formId);
        if (form) {
            form.addEventListener('submit', (e) => {
                e.preventDefault();
                this.createItem(type);
            });
        }
    }

    addQuestion() {
        this.questionCount++;
        const container = document.getElementById('preguntasContainer');
        if (!container) return;
        
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
        await this.init();
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
        
        // Generar preguntas de ejemplo para demostración
        const exampleQuestions = [
            {
                texto: `¿Cuál es tu opinión sobre ${item.titulo}?`,
                tipo: 'opcion_multiple'
            },
            {
                texto: `¿Recomendarías ${item.titulo}?`,
                tipo: 'verdadero_falso'
            },
            {
                texto: `Describe tu experiencia con ${item.titulo}`,
                tipo: 'respuesta_corta'
            }
        ];
        
        return `
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${item.titulo}</title>
    <link rel="stylesheet" href="../assets/css/style.css">
    <style>
        .container { max-width: 800px; margin: 0 auto; padding: 20px; }
        .question-container { margin-bottom: 30px; padding: 20px; border: 1px solid #ddd; border-radius: 8px; }
        .question-options label { display: block; margin: 10px 0; }
        .question-nav { margin-top: 20px; text-align: center; }
        .question-nav button { margin: 0 10px; padding: 10px 20px; }
        .progress-bar { height: 4px; background: #f0f0f0; margin: 20px 0; }
        .progress-fill { height: 100%; background: #007bff; transition: width 0.3s; }
        .timer { font-size: 18px; font-weight: bold; color: #dc3545; }
        textarea { width: 100%; min-height: 100px; }
    </style>
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
                ${exampleQuestions.map((q, i) => `
                    <div class="question-container" data-question="${i + 1}" ${i > 0 ? 'style="display:none"' : ''}>
                        <h3>Pregunta ${i + 1}: ${q.texto}</h3>
                        <div class="question-options">
                            ${this.generateQuestionOptions(q, i + 1)}
                        </div>
                        <div class="question-nav">
                            ${i > 0 ? `<button type="button" onclick="previousQuestion(${i + 1})">Anterior</button>` : ''}
                            ${i < exampleQuestions.length - 1 ? 
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
        let totalQuestions = ${exampleQuestions.length};
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
            const countdown = setInterval(() => {
                if (timeLeft <= 0) {
                    clearInterval(countdown);
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
            
            console.log('Enviando:', data);
            
            document.body.innerHTML = \`
                <div style="text-align: center; padding: 2rem;">
                    <h2>¡${isQuiz ? 'Cuestionario' : 'Encuesta'} enviado correctamente!</h2>
                    <p>Gracias por tu participación</p>
                    ${isQuiz ? '<p>Puedes ver tus resultados en la sección correspondiente</p>' : ''}
                    <button onclick="window.close()" style="padding: 10px 20px; margin-top: 20px;">Cerrar</button>
                </div>
            \`;
        }
        
        ${isQuiz ? `
        function evaluateQuiz(formData) {
            const total = totalQuestions;
            const correct = Math.floor(Math.random() * total) + 1;
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
        
        updateProgress();
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
            return `<textarea name="question_${index}" placeholder="Escribe tu respuesta aquí..." required></textarea>`;
        } else {
            // opcion_multiple
            return `
                <label><input type="radio" name="question_${index}" value="A" required> Muy satisfecho</label>
                <label><input type="radio" name="question_${index}" value="B" required> Satisfecho</label>
                <label><input type="radio" name="question_${index}" value="C" required> Neutral</label>
                <label><input type="radio" name="question_${index}" value="D" required> Insatisfecho</label>
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

    showMessage(message, type = 'info') {
        let messageContainer = document.getElementById('messageContainer');
        if (!messageContainer) {
            messageContainer = document.createElement('div');
            messageContainer.id = 'messageContainer';
            messageContainer.style.cssText = `
                position: fixed;
                top: 20px;
                right: 20px;
                z-index: 9999;
                max-width: 400px;
            `;
            document.body.appendChild(messageContainer);
        }
        
        const alertDiv = document.createElement('div');
        alertDiv.className = `alert alert-${type === 'error' ? 'danger' : type}`;
        alertDiv.style.cssText = `
            padding: 12px 16px;
            margin-bottom: 10px;
            border-radius: 4px;
            color: white;
            background-color: ${type === 'success' ? '#16a34a' : type === 'error' ? '#dc2626' : '#2563eb'};
        `;
        alertDiv.textContent = message;
        
        messageContainer.appendChild(alertDiv);
        
        setTimeout(() => {
            if (alertDiv.parentNode) {
                alertDiv.remove();
            }
        }, 3000);
    }

    async createItem(type) {
        const form = document.getElementById(`create${type.charAt(0).toUpperCase() + type.slice(1)}Form`);
        const formData = new FormData(form);
        
        const item = {
            nombre: formData.get('nombre'),
            titulo: formData.get('titulo'),
            descripcion: formData.get('descripcion'),
            timestamp: Date.now()
        };

        if (type === 'survey') {
            item.tipoRepresentacion = formData.get('tipoRepresentacion');
        } else {
            item.tiempoLimite = parseInt(formData.get('timeLimit')) || 30;
        }

        try {
            const storeName = type === 'survey' ? 'ENCUESTAS' : 'CUESTIONARIOS';
            await this.db.create(storeName, item);
            this.showMessage(`${type === 'survey' ? 'Encuesta' : 'Cuestionario'} creado correctamente`, 'success');
            setTimeout(() => {
                window.location.href = `${type === 'survey' ? 'surveys' : 'quizzes'}-admin.html`;
            }, 1500);
        } catch (error) {
            console.error('Error creating item:', error);
            this.showMessage('Error al crear el elemento', 'error');
        }
    }

    async deleteItem(id, type) {
        if (!confirm('¿Seguro que deseas eliminar este elemento?')) return;
        
        try {
            const storeName = type === 'surveys' ? 'ENCUESTAS' : 'CUESTIONARIOS';
            await this.db.delete(storeName, parseInt(id));
            await this.loadAdminContent(type);
            this.showMessage('Elemento eliminado correctamente', 'success');
        } catch (error) {
            console.error('Error deleting item:', error);
            this.showMessage('Error al eliminar el elemento', 'error');
        }
    }

    async reviewQuiz(responseId) {
        try {
            const responses = await this.db.getAll('RESPUESTAS_CUESTIONARIO');
            const response = responses.find(r => r.id === responseId);
            
            if (response) {
                response.results.gradeConfirmed = true;
                await this.db.update('RESPUESTAS_CUESTIONARIO', response);
                await this.loadPendingReviews();
                this.showMessage('Calificación confirmada', 'success');
            }
        } catch (error) {
            console.error('Error reviewing quiz:', error);
            this.showMessage('Error al revisar cuestionario', 'error');
        }
    }
}

// Instancia global del manager
let manager = new SurveyQuizManager();

// Funciones globales para compatibilidad con HTML
window.loadContent = async (type) => {
    await manager.loadContent(type);
};

window.initAdmin = async (type) => {
    await manager.initAdmin(type);
};

window.initCreator = async (type) => {
    await manager.initCreator(type);
};

window.openItem = async (name, type) => {
    await manager.openItem(name, type);
};

window.addQuestion = () => {
    manager.addQuestion();
};

window.removeQuestion = (btn) => {
    if (manager.questionCount > 1) {
        btn.closest('.question-item').remove();
        manager.questionCount--;
    }
};

window.updateQuestionType = (select) => {
    const questionNum = select.dataset.question;
    const container = document.getElementById(`opciones_${questionNum}`);
    
    if (select.value === 'opcion_multiple') {
        container.style.display = 'block';
        container.innerHTML = `
            <div class="form-group">
                <label class="form-label">Opciones (una por línea)</label>
                <textarea name="pregunta_${questionNum}_opciones" class="form-control" rows="4" 
                         placeholder="Opción A&#10;Opción B&#10;Opción C&#10;Opción D" required></textarea>
            </div>
            <div class="form-group">
                <label class="form-label">Respuesta Correcta (solo para cuestionarios)</label>
                <select name="pregunta_${questionNum}_correcta" class="form-control">
                    <option value="">Seleccionar...</option>
                    <option value="A">Opción A</option>
                    <option value="B">Opción B</option>
                    <option value="C">Opción C</option>
                    <option value="D">Opción D</option>
                </select>
            </div>
        `;
    } else if (select.value === 'verdadero_falso') {
        container.style.display = 'block';
        container.innerHTML = `
            <div class="form-group">
                <label class="form-label">Respuesta Correcta (solo para cuestionarios)</label>
                <select name="pregunta_${questionNum}_correcta" class="form-control">
                    <option value="">Seleccionar...</option>
                    <option value="true">Verdadero</option>
                    <option value="false">Falso</option>
                </select>
            </div>
        `;
    } else {
        container.style.display = 'none';
        container.innerHTML = '';
    }
};

window.deleteItem = async (id, type) => {
    await manager.deleteItem(id, type);
};

window.reviewQuiz = async (id) => {
    await manager.reviewQuiz(id);
};

window.viewResults = (name) => {
    alert(`Funcionalidad de resultados para: ${name}\n\nEsta función mostraría estadísticas detalladas y gráficos de los resultados.`);
};

window.closeModal = () => {
    const modal = document.getElementById('reviewModal');
    if (modal) {
        modal.style.display = 'none';
    }
};

window.confirmGrade = () => {
    alert('Calificación confirmada correctamente');
    closeModal();
};

// Inicialización automática cuando se carga el DOM
document.addEventListener('DOMContentLoaded', async () => {
    try {
        await manager.init();
        
        // Auto-detectar tipo de página y cargar contenido apropiado
        const path = window.location.pathname;
        
        if (path.includes('surveys') && !path.includes('admin') && !path.includes('create')) {
            await manager.loadContent('surveys');
        } else if (path.includes('quizzes') && !path.includes('admin') && !path.includes('create')) {
            await manager.loadContent('quizzes');
        }
        
        console.log('✅ Inicialización automática completada');
    } catch (error) {
        console.error('❌ Error en inicialización automática:', error);
    }
});

// Exportar manager para uso externo si es necesario
if (typeof module !== 'undefined' && module.exports) {
    module.exports = { SurveyQuizManager, UnifiedDB };
}
