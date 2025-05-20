/**
 * Funcionalidades para la creación de cuestionarios
 */

let questionCounter = 1;

document.addEventListener('DOMContentLoaded', function() {
    // Agregar eventos para cambio de tipo de pregunta
    document.addEventListener('change', function(e) {
        if (e.target.classList.contains('question-type')) {
            const questionNumber = e.target.dataset.question;
            const selectedType = e.target.value;
            handleQuestionTypeChange(questionNumber, selectedType);
        }
    });
    
    // Agregar pregunta
    const addQuestionBtn = document.getElementById('addQuestionBtn');
    if (addQuestionBtn) {
        addQuestionBtn.addEventListener('click', function() {
            addNewQuestion();
        });
    }
    
    // Enviar formulario
    const createForm = document.getElementById('createQuizForm');
    if (createForm) {
        createForm.addEventListener('submit', function(e) {
            e.preventDefault();
            saveQuiz();
        });
    }
    
    // Inicializar la primera pregunta
    const firstQuestionType = document.querySelector('.question-type');
    if (firstQuestionType) {
        firstQuestionType.addEventListener('change', function() {
            const questionNumber = this.dataset.question;
            const selectedType = this.value;
            handleQuestionTypeChange(questionNumber, selectedType);
        });
    }
});

/**
 * Maneja el cambio de tipo de pregunta
 */
function handleQuestionTypeChange(questionNumber, type) {
    const optionsContainer = document.getElementById(`opciones_${questionNumber}`);
    const correctAnswerContainer = document.querySelector(`.answer-correct-container`);
    const correctAnswerContainerSpecific = document.getElementById(`correct_answer_${questionNumber}_container`);
    
    if (!optionsContainer) return;
    
    // Limpiar opciones anteriores
    optionsContainer.innerHTML = '';
    
    // Mostrar contenedor de opciones
    optionsContainer.style.display = 'block';
    
    // Mostrar contenedor de respuesta correcta
    if (correctAnswerContainer) {
        correctAnswerContainer.style.display = 'block';
    }
    
    switch (type) {
        case 'opcion_multiple':
            // Crear opciones para opción múltiple
            optionsContainer.innerHTML = `
                <div class="form-group">
                    <label class="form-label">Opciones <span class="required">*</span></label>
                    <div class="options-list" id="options_list_${questionNumber}">
                        <div class="option-row">
                            <div class="option-value">
                                <input type="text" name="pregunta_${questionNumber}_opcion_1_valor" class="form-control" value="A" required>
                            </div>
                            <div class="option-text">
                                <input type="text" name="pregunta_${questionNumber}_opcion_1_texto" class="form-control" placeholder="Texto de la opción" required>
                            </div>
                        </div>
                        <div class="option-row">
                            <div class="option-value">
                                <input type="text" name="pregunta_${questionNumber}_opcion_2_valor" class="form-control" value="B" required>
                            </div>
                            <div class="option-text">
                                <input type="text" name="pregunta_${questionNumber}_opcion_2_texto" class="form-control" placeholder="Texto de la opción" required>
                            </div>
                        </div>
                    </div>
                    <button type="button" class="btn btn-outline-primary btn-sm mt-2" onclick="addOption(${questionNumber})">
                        + Agregar Opción
                    </button>
                </div>
            `;
            
            // Selector de respuesta correcta para opción múltiple
            if (correctAnswerContainerSpecific) {
                correctAnswerContainerSpecific.innerHTML = `
                    <select name="pregunta_${questionNumber}_respuesta_correcta" class="form-control" required>
                        <option value="">Seleccionar opción correcta</option>
                        <option value="A">Opción A</option>
                        <option value="B">Opción B</option>
                    </select>
                `;
            }
            break;
            
        case 'verdadero_falso':
            // Opciones de verdadero/falso ya predefinidas
            optionsContainer.innerHTML = `
                <div class="form-group">
                    <label class="form-label">Opciones:</label>
                    <div class="options-list">
                        <div class="option-row">
                            <div class="option-value">
                                <input type="text" class="form-control" value="true" readonly>
                            </div>
                            <div class="option-text">
                                <input type="text" class="form-control" value="Verdadero" readonly>
                            </div>
                        </div>
                        <div class="option-row">
                            <div class="option-value">
                                <input type="text" class="form-control" value="false" readonly>
                            </div>
                            <div class="option-text">
                                <input type="text" class="form-control" value="Falso" readonly>
                            </div>
                        </div>
                    </div>
                </div>
            `;
            
            // Selector de respuesta correcta para verdadero/falso
            if (correctAnswerContainerSpecific) {
                correctAnswerContainerSpecific.innerHTML = `
                    <select name="pregunta_${questionNumber}_respuesta_correcta" class="form-control" required>
                        <option value="">Seleccionar opción correcta</option>
                        <option value="true">Verdadero</option>
                        <option value="false">Falso</option>
                    </select>
                `;
            }
            break;
            
        case 'respuesta_corta':
            // Para respuesta corta, mostrar un campo de texto para la respuesta correcta
            optionsContainer.innerHTML = `
                <div class="form-group">
                    <label class="form-label">Vista previa:</label>
                    <textarea class="form-control" rows="3" placeholder="El usuario ingresará su respuesta aquí" disabled></textarea>
                    <div class="field-help">Los usuarios podrán ingresar texto libre como respuesta</div>
                </div>
            `;
            
            // Campo para la respuesta correcta
            if (correctAnswerContainerSpecific) {
                correctAnswerContainerSpecific.innerHTML = `
                    <input type="text" name="pregunta_${questionNumber}_respuesta_correcta" class="form-control" placeholder="Ingrese la respuesta correcta" required>
                    <div class="field-help">Las respuestas del usuario se compararán con esta respuesta</div>
                `;
            }
            break;
            
        default:
            optionsContainer.style.display = 'none';
            if (correctAnswerContainer) {
                correctAnswerContainer.style.display = 'none';
            }
            break;
    }
}

/**
 * Agrega una nueva opción a una pregunta de opción múltiple
 */
function addOption(questionNumber) {
    const optionsList = document.getElementById(`options_list_${questionNumber}`);
    if (!optionsList) return;
    
    const optionsCount = optionsList.querySelectorAll('.option-row').length;
    const nextOption = optionsCount + 1;
    
    // Valores posibles para las opciones (A, B, C, etc.)
    const optionValues = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'];
    
    const optionRow = document.createElement('div');
    optionRow.className = 'option-row';
    optionRow.innerHTML = `
        <div class="option-value">
            <input type="text" name="pregunta_${questionNumber}_opcion_${nextOption}_valor" class="form-control" value="${optionValues[optionsCount % optionValues.length]}" required>
        </div>
        <div class="option-text">
            <input type="text" name="pregunta_${questionNumber}_opcion_${nextOption}_texto" class="form-control" placeholder="Texto de la opción" required>
        </div>
        <button type="button" class="option-delete" onclick="removeOption(this)">
            &times;
        </button>
    `;
    
    optionsList.appendChild(optionRow);
    
    // Actualizar selector de respuesta correcta
    const correctAnswerSelector = document.querySelector(`select[name="pregunta_${questionNumber}_respuesta_correcta"]`);
    if (correctAnswerSelector) {
        const newOption = document.createElement('option');
        newOption.value = optionValues[optionsCount % optionValues.length];
        newOption.textContent = `Opción ${optionValues[optionsCount % optionValues.length]}`;
        correctAnswerSelector.appendChild(newOption);
    }
}

/**
 * Elimina una opción de la lista
 */
function removeOption(button) {
    const optionRow = button.closest('.option-row');
    if (optionRow) {
        optionRow.remove();
    }
}

/**
 * Agrega una nueva pregunta al formulario
 */
function addNewQuestion() {
    questionCounter++;
    
    const questionsContainer = document.getElementById('preguntasContainer');
    if (!questionsContainer) return;
    
    const questionItem = document.createElement('div');
    questionItem.className = 'question-item card mb-4';
    questionItem.innerHTML = `
        <div class="card-header">
            <h4>Pregunta ${questionCounter}</h4>
            <button type="button" class="question-delete" onclick="removeQuestion(this)">
                &times;
            </button>
        </div>
        <div class="card-body">
            <div class="form-group">
                <label class="form-label">Texto de la Pregunta <span class="required">*</span></label>
                <input type="text" name="pregunta_${questionCounter}_texto" class="form-control" required>
            </div>
            
            <div class="form-group">
                <label class="form-label">Tipo de Pregunta <span class="required">*</span></label>
                <select name="pregunta_${questionCounter}_tipo" class="form-control question-type" data-question="${questionCounter}" required>
                    <option value="">Seleccionar...</option>
                    <option value="opcion_multiple">Opción Múltiple</option>
                    <option value="verdadero_falso">Verdadero/Falso</option>
                    <option value="respuesta_corta">Respuesta Corta</option>
                </select>
            </div>
            
            <div class="options-container" id="opciones_${questionCounter}" style="display: none;">
                <!-- Las opciones se agregarán dinámicamente aquí -->
            </div>
            
            <div class="form-group answer-correct-container" style="display: none;">
                <label class="form-label">Respuesta Correcta <span class="required">*</span></label>
                <div id="correct_answer_${questionCounter}_container">
                    <!-- El selector de respuesta correcta se agregará aquí -->
                </div>
            </div>
        </div>
    `;
    
    questionsContainer.appendChild(questionItem);
}

/**
 * Elimina una pregunta del formulario
 */
function removeQuestion(button) {
    const questionItem = button.closest('.question-item');
    if (questionItem) {
        questionItem.remove();
    }
}

/**
 * Guarda el cuestionario en la base de datos
 */
async function saveQuiz() {
    try {
        const form = document.getElementById('createQuizForm');
        if (!form) return;
        
        // Validar formulario antes de enviar
        if (!validateQuizForm()) {
            if (window.app && window.app.showAlert) {
                window.app.showAlert('Por favor, complete todos los campos requeridos.', 'warning');
            }
            return;
        }
        
        const formData = new FormData(form);
        
        // Estructurar datos del cuestionario
        const quizData = {
            nombre: formData.get('nombre'),
            titulo: formData.get('titulo'),
            descripcion: formData.get('descripcion') || '',
            timeLimit: formData.get('timeLimit') || 30,
            preguntas: []
        };
        
        // Organizar preguntas
        for (let i = 1; i <= questionCounter; i++) {
            const preguntaTexto = formData.get(`pregunta_${i}_texto`);
            const preguntaTipo = formData.get(`pregunta_${i}_tipo`);
            const respuestaCorrecta = formData.get(`pregunta_${i}_respuesta_correcta`);
            
            // Si no existe esta pregunta (puede haber sido eliminada), continuamos
            if (!preguntaTexto || !preguntaTipo || !respuestaCorrecta) continue;
            
            const pregunta = {
                texto: preguntaTexto,
                tipo: preguntaTipo,
                respuestaCorrecta: respuestaCorrecta,
                opciones: []
            };
            
            // Si es de opción múltiple, recopilamos las opciones
            if (preguntaTipo === 'opcion_multiple') {
                let j = 1;
                while (formData.has(`pregunta_${i}_opcion_${j}_valor`)) {
                    pregunta.opciones.push({
                        valor: formData.get(`pregunta_${i}_opcion_${j}_valor`),
                        texto: formData.get(`pregunta_${i}_opcion_${j}_texto`),
                        esCorrecta: formData.get(`pregunta_${i}_opcion_${j}_valor`) === respuestaCorrecta
                    });
                    j++;
                }
            } else if (preguntaTipo === 'verdadero_falso') {
                pregunta.opciones = [
                    {
                        valor: 'true',
                        texto: 'Verdadero',
                        esCorrecta: respuestaCorrecta === 'true'
                    },
                    {
						valor: 'false',
                        texto: 'Falso',
                        esCorrecta: respuestaCorrecta === 'false'
                    }
                ];
            }
            
            quizData.preguntas.push(pregunta);
        }
        
        // Guardar datos en IndexedDB
        const db = await ensureDatabase();
        
        // Crear el cuestionario
        const cuestionarioId = await db.create('CUESTIONARIOS', {
            nombre: quizData.nombre,
            titulo: quizData.titulo,
            descripcion: quizData.descripcion,
            tiempoLimite: quizData.timeLimit
        });
        
        // Crear las preguntas asociadas
        for (const pregunta of quizData.preguntas) {
            const preguntaId = await db.create('PREGUNTAS_CUESTIONARIO', {
                id_cuestionario: cuestionarioId,
                tipo: pregunta.tipo,
                texto: pregunta.texto,
                respuesta_correcta: pregunta.respuestaCorrecta
            });
            
            // Crear las opciones de respuesta para esta pregunta
            for (const opcion of pregunta.opciones) {
                await db.create('OPCIONES_CUESTIONARIO', {
                    id_pregunta: preguntaId,
                    texto: opcion.texto,
                    valor: opcion.valor,
                    es_correcta: opcion.esCorrecta
                });
            }
        }
        
        if (window.app && window.app.showAlert) {
            window.app.showAlert('Cuestionario creado exitosamente.', 'success');
        }
        
        // Redirigir a la página de administración de cuestionarios
        setTimeout(() => {
            window.location.href = 'quizzes-admin.html';
        }, 1500);
        
    } catch (error) {
        console.error('Error guardando cuestionario:', error);
        if (window.app && window.app.showAlert) {
            window.app.showAlert('Error al guardar el cuestionario: ' + error.message, 'danger');
        }
    }
}

/**
 * Valida el formulario de creación de cuestionario
 */
function validateQuizForm() {
    const form = document.getElementById('createQuizForm');
    if (!form) return false;
    
    // Verificar campos requeridos del formulario principal
    const requiredFields = form.querySelectorAll('[required]');
    for (const field of requiredFields) {
        if (!field.value.trim()) {
            field.focus();
            return false;
        }
    }
    
    return true;
}

/**
 * Asegura que la base de datos esté inicializada
 */
async function ensureDatabase() {
    try {
        if (window.localDB && window.localDB.db) {
            return window.localDB;
        }
        
        // Si la base de datos global no está disponible, inicializamos una temporal
        const LocalDBManager = window.LocalDBManager || class LocalDBManager {
            constructor() {
                this.dbName = 'DataWeb_DB';
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
                        
                        if (!db.objectStoreNames.contains('CUESTIONARIOS')) {
                            const store = db.createObjectStore('CUESTIONARIOS', { 
                                keyPath: 'id_cuestionario', 
                                autoIncrement: true 
                            });
                            store.createIndex('nombre', 'nombre', { unique: false });
                        }
                        
                        if (!db.objectStoreNames.contains('PREGUNTAS_CUESTIONARIO')) {
                            const store = db.createObjectStore('PREGUNTAS_CUESTIONARIO', { 
                                keyPath: 'id_pregunta', 
                                autoIncrement: true 
                            });
                            store.createIndex('id_cuestionario', 'id_cuestionario', { unique: false });
                        }
                        
                        if (!db.objectStoreNames.contains('OPCIONES_CUESTIONARIO')) {
                            const store = db.createObjectStore('OPCIONES_CUESTIONARIO', { 
                                keyPath: 'id_opcion', 
                                autoIncrement: true 
                            });
                            store.createIndex('id_pregunta', 'id_pregunta', { unique: false });
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
        };
        
        const dbManager = new LocalDBManager();
        await dbManager.init();
        return dbManager;
    } catch (error) {
        console.error('Error initializing database:', error);
        throw error;
    }
}

// Exportar funciones a window para uso global
window.addOption = addOption;
window.removeOption = removeOption;
window.removeQuestion = removeQuestion;
window.saveQuiz = saveQuiz;
