/**
 * Funcionalidades para la edición de encuestas
 */

let questionCounter = 0;
let originalEncuesta = null;
let originalPreguntas = [];

document.addEventListener('DOMContentLoaded', function() {
    // Cargar datos de la encuesta a editar
    loadSurveyData();
    
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
    const editForm = document.getElementById('editSurveyForm');
    if (editForm) {
        editForm.addEventListener('submit', function(e) {
            e.preventDefault();
            updateSurvey();
        });
    }
});

/**
 * Carga los datos de la encuesta a editar
 */
async function loadSurveyData() {
    try {
        // Obtener el ID de la encuesta de la URL
        const urlParams = new URLSearchParams(window.location.search);
        const surveyId = urlParams.get('id');
        
        if (!surveyId) {
            throw new Error('ID de encuesta no especificado en la URL');
        }
        
        console.log('Cargando encuesta con ID:', surveyId);
        
        // Mostrar indicador de carga
        const loadingIndicator = document.getElementById('loadingIndicator');
        const editCard = document.getElementById('editCard');
        
        if (loadingIndicator) loadingIndicator.style.display = 'block';
        if (editCard) editCard.style.display = 'none';
        
        // Inicializar la base de datos
        const db = await ensureDatabaseInitialized();
        
        // Buscar la encuesta por ID
        const encuestas = await db.getAll('ENCUESTAS');
        const encuesta = encuestas.find(e => e.id_encuesta == parseInt(surveyId));
        
        if (!encuesta) {
            console.error('Encuesta no encontrada, encuestas disponibles:', encuestas);
            throw new Error(`Encuesta con ID ${surveyId} no encontrada`);
        }
        
        console.log('Encuesta encontrada:', encuesta);
        
        // Guardar encuesta original
        originalEncuesta = encuesta;
        
        // Cargar preguntas de la encuesta
        const allPreguntas = await db.getAll('PREGUNTAS_ENCUESTA');
        const preguntas = allPreguntas.filter(p => p.id_encuesta == surveyId);
        
        // Guardar preguntas originales
        originalPreguntas = preguntas;
        
        // Cargar opciones de cada pregunta
        for (const pregunta of preguntas) {
            const allOpciones = await db.getAll('OPCIONES_PREGUNTA');
            pregunta.opciones = allOpciones.filter(o => o.id_pregunta == pregunta.id_pregunta);
        }
        
        // Rellenar el formulario con los datos
		document.getElementById('encuestaId').value = encuesta.id_encuesta;
		document.getElementById('nombre').value = encuesta.nombre;
		document.getElementById('titulo').value = encuesta.titulo;
		document.getElementById('descripcion').value = encuesta.descripcion || '';
		
		const tipoRepresentacion = document.getElementById('tipoRepresentacion');
		if (tipoRepresentacion) {
		    for (let i = 0; i < tipoRepresentacion.options.length; i++) {
		        if (tipoRepresentacion.options[i].value === encuesta.tipo_representacion) {
		            tipoRepresentacion.selectedIndex = i;
		            break;
		        }
		    }
		}
		
		// Renderizar preguntas
		renderPreguntas(preguntas);
		
		// Ocultar cargando y mostrar formulario
		if (loadingIndicator) loadingIndicator.style.display = 'none';
		if (editCard) editCard.style.display = 'block';
		
		    } catch (error) {
		        console.error('Error cargando datos de la encuesta:', error);
		        alert('Error: ' + error.message);
		        window.location.href = 'surveys-admin.html';
		    }
		}

/**
 * Renderiza las preguntas de la encuesta
 */
function renderPreguntas(preguntas) {
    const container = document.getElementById('preguntasContainer');
    if (!container) return;
    
    container.innerHTML = '';
    
    preguntas.forEach((pregunta, index) => {
        questionCounter = Math.max(questionCounter, index + 1);
        
        const questionItem = document.createElement('div');
        questionItem.className = 'question-item card mb-4';
        questionItem.dataset.question = index + 1;
        questionItem.dataset.questionId = pregunta.id_pregunta;
        
        questionItem.innerHTML = `
            <div class="card-header">
                <h4>Pregunta ${index + 1}</h4>
                <button type="button" class="question-delete" onclick="removeQuestion(this)">
                    &times;
                </button>
            </div>
            <div class="card-body">
                <div class="form-group">
                    <label class="form-label">Texto de la Pregunta <span class="required">*</span></label>
                    <input type="text" name="pregunta_${index + 1}_texto" class="form-control" value="${pregunta.texto}" required>
                </div>
                
                <div class="form-group">
                    <label class="form-label">Tipo de Pregunta <span class="required">*</span></label>
                    <select name="pregunta_${index + 1}_tipo" class="form-control question-type" data-question="${index + 1}" required>
                        <option value="">Seleccionar...</option>
                        <option value="opcion_multiple" ${pregunta.tipo === 'opcion_multiple' ? 'selected' : ''}>Opción Múltiple</option>
                        <option value="verdadero_falso" ${pregunta.tipo === 'verdadero_falso' ? 'selected' : ''}>Verdadero/Falso</option>
                        <option value="respuesta_corta" ${pregunta.tipo === 'respuesta_corta' ? 'selected' : ''}>Respuesta Corta</option>
                    </select>
                </div>
                
                <div class="options-container" id="opciones_${index + 1}" style="display: none;">
                    <!-- Las opciones se agregarán dinámicamente aquí -->
                </div>
            </div>
        `;
        
        container.appendChild(questionItem);
        
        // Inicializar tipo de pregunta
        handleQuestionTypeChange(index + 1, pregunta.tipo);
        
        // Si es de opción múltiple, cargar opciones
        if (pregunta.tipo === 'opcion_multiple' && pregunta.opciones && pregunta.opciones.length > 0) {
            const optionsList = document.getElementById(`options_list_${index + 1}`);
            if (optionsList) {
                optionsList.innerHTML = '';
                
                pregunta.opciones.forEach((opcion, opIndex) => {
                    const optionRow = document.createElement('div');
                    optionRow.className = 'option-row';
                    optionRow.innerHTML = `
                        <div class="option-value">
                            <input type="text" name="pregunta_${index + 1}_opcion_${opIndex + 1}_valor" class="form-control" value="${opcion.valor}" required>
                        </div>
                        <div class="option-text">
                            <input type="text" name="pregunta_${index + 1}_opcion_${opIndex + 1}_texto" class="form-control" value="${opcion.texto}" required>
                        </div>
                        ${opIndex > 1 ? `
                            <button type="button" class="option-delete" onclick="removeOption(this)">
                                &times;
                            </button>
                        ` : ''}
                    `;
                    
                    optionsList.appendChild(optionRow);
                });
            }
        }
    });
}

/**
 * Maneja el cambio de tipo de pregunta
 */
function handleQuestionTypeChange(questionNumber, type) {
    console.log(`Handling question type change for question ${questionNumber}: ${type}`);
    
    const optionsContainer = document.getElementById(`opciones_${questionNumber}`);
    const correctAnswerContainer = document.querySelector(`.question-item[data-question="${questionNumber}"] .answer-correct-container`);
    const correctAnswerContainerSpecific = document.getElementById(`correct_answer_${questionNumber}_container`);
    
    if (!optionsContainer) {
        console.error(`Options container not found for question ${questionNumber}`);
        return;
    }
    
    // Clear previous options
    optionsContainer.innerHTML = '';
    
    // Hide options container by default
    optionsContainer.style.display = 'none';
    
    // Determine if we're in a quiz or survey
    const isQuiz = window.location.href.includes('quiz') || 
                  document.getElementById('createQuizForm') !== null || 
                  document.getElementById('editQuizForm') !== null;
    
    console.log(`Is this a quiz? ${isQuiz ? 'Yes' : 'No'}`);
    
    // For surveys, always hide correct answer container
    // For quizzes, show it if the question has a type selected
    if (correctAnswerContainer) {
        if (isQuiz && type) {
            console.log(`Showing correct answer container for question ${questionNumber}`);
            correctAnswerContainer.style.display = 'block';
        } else {
            console.log(`Hiding correct answer container for question ${questionNumber}`);
            correctAnswerContainer.style.display = 'none';
        }
    }
    
    if (!type) {
        console.log('No question type selected, skipping further setup');
        return;
    }
    
    // Show options container since we have a valid type
    optionsContainer.style.display = 'block';
    
    switch (type) {
        case 'opcion_multiple':
            console.log(`Setting up multiple choice options for question ${questionNumber}`);
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
            
            // Add correct answer selector only for quizzes
            if (isQuiz && correctAnswerContainerSpecific) {
                console.log(`Setting up correct answer selector for multiple choice question ${questionNumber}`);
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
            console.log(`Setting up true/false options for question ${questionNumber}`);
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
            
            // Add correct answer selector only for quizzes
            if (isQuiz && correctAnswerContainerSpecific) {
                console.log(`Setting up correct answer selector for true/false question ${questionNumber}`);
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
            console.log(`Setting up short answer options for question ${questionNumber}`);
            // Para respuesta corta, mostrar un campo de texto para la respuesta correcta
            optionsContainer.innerHTML = `
                <div class="form-group">
                    <label class="form-label">Vista previa:</label>
                    <textarea class="form-control" rows="3" placeholder="El usuario ingresará su respuesta aquí" disabled></textarea>
                    <div class="field-help">Los usuarios podrán ingresar texto libre como respuesta</div>
                </div>
            `;
            
            // Add correct answer field only for quizzes
            if (isQuiz && correctAnswerContainerSpecific) {
                console.log(`Setting up correct answer field for short answer question ${questionNumber}`);
                correctAnswerContainerSpecific.innerHTML = `
                    <input type="text" name="pregunta_${questionNumber}_respuesta_correcta" class="form-control" placeholder="Ingrese la respuesta correcta" required>
                    <div class="field-help">Las respuestas del usuario se compararán con esta respuesta</div>
                `;
            }
            break;
            
        default:
            console.log(`Unknown question type: ${type}`);
            optionsContainer.style.display = 'none';
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
    const nextOptionValue = optionValues[optionsCount % optionValues.length];
    
    const optionRow = document.createElement('div');
    optionRow.className = 'option-row';
    optionRow.innerHTML = `
        <div class="option-value">
            <input type="text" name="pregunta_${questionNumber}_opcion_${nextOption}_valor" class="form-control" value="${nextOptionValue}" required>
        </div>
        <div class="option-text">
            <input type="text" name="pregunta_${questionNumber}_opcion_${nextOption}_texto" class="form-control" placeholder="Texto de la opción" required>
        </div>
        <button type="button" class="option-delete" onclick="removeOption(this)">
            &times;
        </button>
    `;
    
    optionsList.appendChild(optionRow);
}

/**
 * Elimina una opción de la lista
 */
function removeOption(button) {
    const optionRow = button.closest('.option-row');
    if (!optionRow) return;
    
    optionRow.remove();
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
    questionItem.dataset.question = questionCounter;
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
        </div>
    `;
    
    questionsContainer.appendChild(questionItem);
    
    // Añadir event listener para el cambio de tipo de pregunta
    const typeSelector = questionItem.querySelector('.question-type');
    if (typeSelector) {
        typeSelector.addEventListener('change', function() {
            handleQuestionTypeChange(this.dataset.question, this.value);
        });
    }
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
 * Asegura que la base de datos esté inicializada
 */
async function ensureDatabaseInitialized() {
    console.log('Ensuring database is initialized...');
    
    if (window.localDB && window.localDB.db) {
        console.log('Using existing database instance');
        return window.localDB;
    }
    
    return new Promise((resolve, reject) => {
        console.log('Opening database...');
        const dbName = 'DataWeb_DB';
        // Usar la misma versión que el sistema principal
        const dbVersion = 2;
        const request = indexedDB.open(dbName, dbVersion);
        
        request.onerror = (event) => {
            console.error('Database error:', event.target.error);
            reject(event.target.error);
        };
        
        request.onsuccess = (event) => {
            console.log('Database opened successfully!');
            const db = event.target.result;
            setupLocalDB(db, resolve);
        };
        
        request.onupgradeneeded = (event) => {
            console.log('Database upgrade needed, but using existing structure');
            const db = event.target.result;
            
            // No crear stores aquí, usar los existentes
            console.log('Existing stores:', Array.from(db.objectStoreNames));
        };
        
        function setupLocalDB(db, resolveCallback) {
            window.localDB = {
                db: db,
                
                async getAll(storeName) {
                    console.log(`Getting all records from ${storeName}`);
                    return new Promise((resolve, reject) => {
                        if (!db.objectStoreNames.contains(storeName)) {
                            console.error(`Store "${storeName}" does not exist!`);
                            resolve([]); // Devolver array vacío en lugar de error
                            return;
                        }
                        
                        try {
                            const transaction = db.transaction([storeName], 'readonly');
                            const store = transaction.objectStore(storeName);
                            const request = store.getAll();
                            
                            request.onsuccess = () => {
                                console.log(`Retrieved ${request.result.length} records`);
                                resolve(request.result);
                            };
                            request.onerror = () => {
                                console.error(`Error getting records:`, request.error);
                                resolve([]); // Devolver array vacío en lugar de error
                            };
                        } catch (error) {
                            console.error(`Transaction error:`, error);
                            resolve([]); // Devolver array vacío en lugar de error
                        }
                    });
                },
                
                async update(storeName, data) {
                    console.log(`Updating record in ${storeName}:`, data);
                    return new Promise((resolve, reject) => {
                        if (!db.objectStoreNames.contains(storeName)) {
                            console.error(`Store "${storeName}" does not exist!`);
                            reject(new Error(`Object store "${storeName}" does not exist`));
                            return;
                        }
                        
                        try {
                            const transaction = db.transaction([storeName], 'readwrite');
                            const store = transaction.objectStore(storeName);
                            const request = store.put(data);
                            
                            request.onsuccess = () => {
                                console.log(`Record updated successfully`);
                                resolve(request.result);
                            };
                            request.onerror = () => {
                                console.error(`Error updating record:`, request.error);
                                reject(request.error);
                            };
                        } catch (error) {
                            console.error(`Transaction error:`, error);
                            reject(error);
                        }
                    });
                },
                
                async create(storeName, data) {
                    console.log(`Creating record in ${storeName}:`, data);
                    return new Promise((resolve, reject) => {
                        if (!db.objectStoreNames.contains(storeName)) {
                            console.error(`Store "${storeName}" does not exist!`);
                            reject(new Error(`Object store "${storeName}" does not exist`));
                            return;
                        }
                        
                        try {
                            const transaction = db.transaction([storeName], 'readwrite');
                            const store = transaction.objectStore(storeName);
                            const request = store.add(data);
                            
                            request.onsuccess = () => {
                                console.log(`Record created with ID: ${request.result}`);
                                resolve(request.result);
                            };
                            request.onerror = () => {
                                console.error(`Error creating record:`, request.error);
                                reject(request.error);
                            };
                        } catch (error) {
                            console.error(`Transaction error:`, error);
                            reject(error);
                        }
                    });
                },
                
                async delete(storeName, id) {
                    console.log(`Deleting record from ${storeName} with ID ${id}`);
                    return new Promise((resolve, reject) => {
                        if (!db.objectStoreNames.contains(storeName)) {
                            console.error(`Store "${storeName}" does not exist!`);
                            reject(new Error(`Object store "${storeName}" does not exist`));
                            return;
                        }
                        
                        try {
                            const transaction = db.transaction([storeName], 'readwrite');
                            const store = transaction.objectStore(storeName);
                            const request = store.delete(id);
                            
                            request.onsuccess = () => {
                                console.log(`Record deleted successfully`);
                                resolve(request.result);
                            };
                            request.onerror = () => {
                                console.error(`Error deleting record:`, request.error);
                                reject(request.error);
                            };
                        } catch (error) {
                            console.error(`Transaction error:`, error);
                            reject(error);
                        }
                    });
                },
                
                async query(storeName, condition) {
                    console.log(`Querying ${storeName} with:`, condition);
                    try {
                        const all = await this.getAll(storeName);
                        
                        if (!condition || Object.keys(condition).length === 0) {
                            return all;
                        }
                        
                        return all.filter(item => {
                            return Object.keys(condition).every(key => {
                                return item[key] == condition[key];
                            });
                        });
                    } catch (error) {
                        console.error(`Query error:`, error);
                        return [];
                    }
                }
            };
            
            console.log('LocalDB setup complete');
            resolveCallback(window.localDB);
        }
    });
}

/**
 * Actualiza la encuesta en la base de datos
 */
async function updateSurvey() {
    try {
        const form = document.getElementById('editSurveyForm');
        if (!form) return;
        
        // Validar formulario antes de enviar
        if (!validateSurveyForm()) {
            if (window.app && window.app.showAlert) {
                window.app.showAlert('Por favor, complete todos los campos requeridos.', 'warning');
            } else {
                alert('Por favor, complete todos los campos requeridos.');
            }
            return;
        }
        
        const formData = new FormData(form);
        
        // Obtener datos básicos
        const encuestaId = formData.get('encuestaId');
        const encuestaData = {
            id_encuesta: Number(encuestaId),
            nombre: formData.get('nombre'),
            titulo: formData.get('titulo'),
            descripcion: formData.get('descripcion') || '',
            tipo_representacion: formData.get('tipoRepresentacion')
        };
        
        // Verificar si existe la encuesta
        if (!encuestaId) {
            throw new Error('ID de encuesta no especificado');
        }
        
        // Inicializar la base de datos
        const db = window.localDB;
        if (!db) {
            throw new Error('La base de datos no está inicializada');
        }
        
        // Actualizar datos de la encuesta
        await db.update('ENCUESTAS', encuestaData);
        
        // Recopilar preguntas actuales
        const questionItems = document.querySelectorAll('.question-item');
        const preguntas = [];
        
        for (let i = 0; i < questionItems.length; i++) {
            const questionItem = questionItems[i];
            const questionNumber = questionItem.dataset.question;
            const questionId = questionItem.dataset.questionId || null;
            
            const preguntaTexto = formData.get(`pregunta_${questionNumber}_texto`);
            const preguntaTipo = formData.get(`pregunta_${questionNumber}_tipo`);
            
            // Si no existe esta pregunta (datos inválidos), continuamos
            if (!preguntaTexto || !preguntaTipo) continue;
            
            const pregunta = {
                texto: preguntaTexto,
                tipo: preguntaTipo,
                opciones: []
            };
            
            // Si la pregunta ya existía, mantener su ID
            if (questionId) {
                pregunta.id_pregunta = Number(questionId);
            }
            
            // Si es de opción múltiple, recopilamos las opciones
            if (preguntaTipo === 'opcion_multiple') {
                let j = 1;
                while (formData.has(`pregunta_${questionNumber}_opcion_${j}_valor`)) {
                    pregunta.opciones.push({
                        valor: formData.get(`pregunta_${questionNumber}_opcion_${j}_valor`),
                        texto: formData.get(`pregunta_${questionNumber}_opcion_${j}_texto`)
                    });
                    j++;
                }
            }
            
            preguntas.push(pregunta);
        }
        
        // Actualizar preguntas
        // 1. Eliminar preguntas y opciones antiguas
        for (const pregunta of originalPreguntas) {
            // Eliminar opciones de la pregunta
            const opciones = await db.query('OPCIONES_PREGUNTA', { id_pregunta: pregunta.id_pregunta });
            for (const opcion of opciones) {
                await db.delete('OPCIONES_PREGUNTA', opcion.id_opcion);
            }
            
            // Eliminar la pregunta
            await db.delete('PREGUNTAS_ENCUESTA', pregunta.id_pregunta);
        }
        
        // 2. Crear nuevas preguntas y opciones
        for (const pregunta of preguntas) {
            const preguntaData = {
                id_encuesta: Number(encuestaId),
                tipo: pregunta.tipo,
                texto: pregunta.texto
            };
            
            // Si la pregunta tenía ID, mantenerlo
            if (pregunta.id_pregunta) {
                preguntaData.id_pregunta = pregunta.id_pregunta;
            }
            
            // Crear pregunta
            const preguntaId = await db.create('PREGUNTAS_ENCUESTA', preguntaData);
            
            // Crear opciones
            for (const opcion of pregunta.opciones) {
                await db.create('OPCIONES_PREGUNTA', {
                    id_pregunta: preguntaId,
                    texto: opcion.texto,
                    valor: opcion.valor
                });
            }
        }
        
        // Mostrar mensaje de éxito
        if (window.app && window.app.showAlert) {
            window.app.showAlert('Encuesta actualizada correctamente', 'success');
        } else {
            alert('Encuesta actualizada correctamente');
        }
        
        // Redirigir a la página de administración
        setTimeout(() => {
            window.location.href = 'surveys-admin.html';
        }, 1500);
        
    } catch (error) {
        console.error('Error actualizando encuesta:', error);
        
        if (window.app && window.app.showAlert) {
            window.app.showAlert('Error: ' + error.message, 'danger');
        } else {
            alert('Error: ' + error.message);
        }
    }
}

/**
 * Valida el formulario de edición de encuesta
 */
function validateSurveyForm() {
    const form = document.getElementById('createSurveyForm') || document.getElementById('editSurveyForm');
    if (!form) {
        console.error('Survey form not found');
        return false;
    }
    
    console.log('Validating survey form');
    
    // Verificar campos requeridos del formulario principal
    const requiredFields = form.querySelectorAll('[required]');
    let isValid = true;
    
    for (const field of requiredFields) {
        if (!field.value.trim()) {
            console.warn(`Empty required field: ${field.name}`);
            field.focus();
            isValid = false;
            break;
        }
    }
    
    // Verificar que haya al menos una pregunta
    const questions = document.querySelectorAll('.question-item');
    if (questions.length === 0) {
        console.warn('No questions added to the survey');
        isValid = false;
        
        if (window.app && window.app.showAlert) {
            window.app.showAlert('Debe agregar al menos una pregunta a la encuesta.', 'warning');
        } else {
            alert('Debe agregar al menos una pregunta a la encuesta.');
        }
    }
    
    return isValid;
}


// Exportar funciones a window para uso global
window.addOption = addOption;
window.removeOption = removeOption;
window.removeQuestion = removeQuestion;
window.updateSurvey = updateSurvey;
window.ensureDatabaseInitialized = ensureDatabaseInitialized;
