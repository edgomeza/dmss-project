/**
 * Funcionalidades para la creación de encuestas
 */

let questionCounter = 1;

document.addEventListener('DOMContentLoaded', function() {
    console.log('DOM loaded for survey creator');
    
    // Asignar data-question=1 a la primera pregunta si no lo tiene
    const firstQuestion = document.querySelector('.question-item');
    if (firstQuestion && !firstQuestion.dataset.question) {
        firstQuestion.dataset.question = "1";
        console.log('Assigned data-question="1" to first question item');
    }
    
    // Añadir atributos data-question a cualquier elemento que no lo tenga
    const questionItems = document.querySelectorAll('.question-item');
    questionItems.forEach((item, index) => {
        if (!item.dataset.question) {
            item.dataset.question = (index + 1).toString();
            console.log(`Added data-question="${index + 1}" to question item`);
        }
    });
    
    // Agregar eventos para cambio de tipo de pregunta
    document.addEventListener('change', function(e) {
        if (e.target.classList.contains('question-type')) {
            const questionNumber = e.target.dataset.question;
            const selectedType = e.target.value;
            console.log(`Question type changed for question ${questionNumber}: ${selectedType}`);
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
    const createForm = document.getElementById('createSurveyForm');
    if (createForm) {
        createForm.addEventListener('submit', function(e) {
            e.preventDefault();
            saveSurvey();
        });
    }
    
    // Initialize all question types immediately
    const questionTypes = document.querySelectorAll('.question-type');
    questionTypes.forEach(select => {
        if (select.value) {
            console.log('Initializing question with selected type:', select.value);
            handleQuestionTypeChange(select.dataset.question, select.value);
        }
    });
});

/**
 * Maneja el cambio de tipo de pregunta
 */
function handleQuestionTypeChange(questionNumber, type) {
    console.log(`Handling question type change for question ${questionNumber}: ${type}`);
    
    const optionsContainer = document.getElementById(`opciones_${questionNumber}`);
    if (!optionsContainer) {
        console.error(`Options container not found for question ${questionNumber}`);
        return;
    }
    
    // Clear previous options
    optionsContainer.innerHTML = '';
    
    // Hide options container by default
    optionsContainer.style.display = 'none';
    
    // Show options container since we have a valid type
    if (type) {
        optionsContainer.style.display = 'block';
    } else {
        return;
    }
    
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
                                <input type="hidden" name="pregunta_${questionNumber}_opcion_1_valor" value="true">
                                <input type="hidden" name="pregunta_${questionNumber}_opcion_1_texto" value="Verdadero">
                            </div>
                            <div class="option-text">
                                <input type="text" class="form-control" value="Verdadero" readonly>
                            </div>
                        </div>
                        <div class="option-row">
                            <div class="option-value">
                                <input type="text" class="form-control" value="false" readonly>
                                <input type="hidden" name="pregunta_${questionNumber}_opcion_2_valor" value="false">
                                <input type="hidden" name="pregunta_${questionNumber}_opcion_2_texto" value="Falso">
                            </div>
                            <div class="option-text">
                                <input type="text" class="form-control" value="Falso" readonly>
                            </div>
                        </div>
                    </div>
                </div>
            `;
            break;
            
        case 'respuesta_corta':
            console.log(`Setting up short answer options for question ${questionNumber}`);
            // Para respuesta corta, mostrar un campo de texto para la respuesta correcta
            optionsContainer.innerHTML = `
                <div class="form-group">
                    <label class="form-label">Vista previa:</label>
                    <textarea class="form-control" rows="3" placeholder="El usuario ingresará su respuesta aquí" disabled></textarea>
                    <div class="field-help">Los usuarios podrán ingresar texto libre como respuesta</div>
                    <input type="hidden" name="pregunta_${questionNumber}_opcion_1_valor" value="text">
                    <input type="hidden" name="pregunta_${questionNumber}_opcion_1_texto" value="Respuesta de texto">
                </div>
            `;
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
        // Usar versión 2 para resolver problemas de versión
        const dbVersion = 2;
        const request = indexedDB.open(dbName, dbVersion);
        
        request.onerror = (event) => {
            console.error('Database error:', event.target.error);
            reject(event.target.error);
        };
        
        request.onsuccess = (event) => {
            console.log('Database opened successfully!');
            const db = event.target.result;
            
            // Make sure all the object stores exist
            const storeNames = ['ENCUESTAS', 'PREGUNTAS_ENCUESTA', 'OPCIONES_PREGUNTA', 
                               'CUESTIONARIOS', 'PREGUNTAS_CUESTIONARIO', 'OPCIONES_CUESTIONARIO',
                               'RESPUESTAS_ENCUESTA', 'RESPUESTAS_CUESTIONARIO'];
            
            const existingStoreNames = Array.from(db.objectStoreNames);
            console.log('Existing stores:', existingStoreNames);
            
            const missingStores = storeNames.filter(name => !existingStoreNames.includes(name));
            if (missingStores.length > 0) {
                console.warn('Missing store(s):', missingStores);
                
                // Close the database and reopen with a higher version to trigger upgrade
                db.close();
                const newVersion = dbVersion + 1;
                console.log(`Reopening database with version ${newVersion} to create missing stores`);
                const newRequest = indexedDB.open(dbName, newVersion);
                
                newRequest.onupgradeneeded = createStores;
                
                newRequest.onsuccess = (event) => {
                    console.log('Database upgraded and reopened successfully');
                    const newDb = event.target.result;
                    setupLocalDB(newDb, resolve);
                };
                
                newRequest.onerror = (event) => {
                    console.error('Database upgrade error:', event.target.error);
                    reject(event.target.error);
                };
            } else {
                console.log('All required stores exist');
                setupLocalDB(db, resolve);
            }
        };
        
        request.onupgradeneeded = createStores;
        
        function createStores(event) {
            console.log('Creating/upgrading database schema...');
            const db = event.target.result;
            
            // Create all required object stores if they don't exist
            if (!db.objectStoreNames.contains('ENCUESTAS')) {
                console.log('Creating ENCUESTAS store');
                db.createObjectStore('ENCUESTAS', { keyPath: 'id_encuesta', autoIncrement: true });
            }
            
            if (!db.objectStoreNames.contains('PREGUNTAS_ENCUESTA')) {
                console.log('Creating PREGUNTAS_ENCUESTA store');
                db.createObjectStore('PREGUNTAS_ENCUESTA', { keyPath: 'id_pregunta', autoIncrement: true });
            }
            
            if (!db.objectStoreNames.contains('OPCIONES_PREGUNTA')) {
                console.log('Creating OPCIONES_PREGUNTA store');
                db.createObjectStore('OPCIONES_PREGUNTA', { keyPath: 'id_opcion', autoIncrement: true });
            }
            
            if (!db.objectStoreNames.contains('CUESTIONARIOS')) {
                console.log('Creating CUESTIONARIOS store');
                db.createObjectStore('CUESTIONARIOS', { keyPath: 'id_cuestionario', autoIncrement: true });
            }
            
            if (!db.objectStoreNames.contains('PREGUNTAS_CUESTIONARIO')) {
                console.log('Creating PREGUNTAS_CUESTIONARIO store');
                db.createObjectStore('PREGUNTAS_CUESTIONARIO', { keyPath: 'id_pregunta', autoIncrement: true });
            }
            
            if (!db.objectStoreNames.contains('OPCIONES_CUESTIONARIO')) {
                console.log('Creating OPCIONES_CUESTIONARIO store');
                db.createObjectStore('OPCIONES_CUESTIONARIO', { keyPath: 'id_opcion', autoIncrement: true });
            }
            
            if (!db.objectStoreNames.contains('RESPUESTAS_ENCUESTA')) {
                console.log('Creating RESPUESTAS_ENCUESTA store');
                db.createObjectStore('RESPUESTAS_ENCUESTA', { keyPath: 'id', autoIncrement: true });
            }
            
            if (!db.objectStoreNames.contains('RESPUESTAS_CUESTIONARIO')) {
                console.log('Creating RESPUESTAS_CUESTIONARIO store');
                db.createObjectStore('RESPUESTAS_CUESTIONARIO', { keyPath: 'id', autoIncrement: true });
            }
            
            console.log('Database schema created/upgraded successfully');
        }
        
        function setupLocalDB(db, resolveCallback) {
            window.localDB = {
                db: db,
                
                // Database methods
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
                
                async getAll(storeName) {
                    console.log(`Getting all records from ${storeName}`);
                    return new Promise((resolve, reject) => {
                        if (!db.objectStoreNames.contains(storeName)) {
                            console.error(`Store "${storeName}" does not exist!`);
                            reject(new Error(`Object store "${storeName}" does not exist`));
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
                                reject(request.error);
                            };
                        } catch (error) {
                            console.error(`Transaction error:`, error);
                            reject(error);
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
                        if (!db.objectStoreNames.contains(storeName)) {
                            console.error(`Store "${storeName}" does not exist!`);
                            throw new Error(`Object store "${storeName}" does not exist`);
                        }
                        
                        const all = await this.getAll(storeName);
                        
                        if (!condition || Object.keys(condition).length === 0) {
                            return all;
                        }
                        
                        return all.filter(item => {
                            return Object.keys(condition).every(key => {
                                return item[key] == condition[key]; // Loose equality for number vs string
                            });
                        });
                    } catch (error) {
                        console.error(`Query error:`, error);
                        throw error;
                    }
                }
            };
            
            console.log('LocalDB setup complete');
            resolveCallback(window.localDB);
        }
    });
}

/**
 * Guarda la encuesta en la base de datos
 */
/**
 * Guarda la encuesta en la base de datos
 */
async function saveSurvey() {
    try {
        const form = document.getElementById('createSurveyForm');
        if (!form) {
            console.error('Survey form not found');
            return;
        }
        
        console.log('Starting survey save process');
        
        // Verificar y actualizar los atributos data-question si es necesario
        const formQuestionItems = document.querySelectorAll('.question-item');
        formQuestionItems.forEach((item, index) => {
            if (!item.dataset.question) {
                const questionNumber = index + 1;
                item.dataset.question = questionNumber.toString();
                console.log(`Added missing data-question="${questionNumber}" to question item`);
            }
        });
        
        // Validar formulario antes de enviar
        if (!validateSurveyForm()) {
            console.warn('Form validation failed');
            if (window.app && window.app.showAlert) {
                window.app.showAlert('Por favor, complete todos los campos requeridos.', 'warning');
            } else {
                alert('Por favor, complete todos los campos requeridos.');
            }
            return;
        }
        
        const formData = new FormData(form);
        
        // Estructurar datos de la encuesta
        const surveyData = {
            nombre: formData.get('nombre'),
            titulo: formData.get('titulo'),
            descripcion: formData.get('descripcion') || '',
            tipo_representacion: formData.get('tipoRepresentacion'),
            preguntas: []
        };
        
        console.log('Processing survey data:', surveyData);
        
        // Organizar preguntas - IMPROVED TECHNIQUE
        // Usamos una variable con nombre diferente para evitar redeclaración
        const surveyQuestionItems = document.querySelectorAll('.question-item');
        console.log(`Found ${surveyQuestionItems.length} question items`);
        
        for (let i = 0; i < surveyQuestionItems.length; i++) {
            const questionItem = surveyQuestionItems[i];
            const questionNumber = questionItem.dataset.question || (i + 1).toString();
            
            const preguntaTexto = formData.get(`pregunta_${questionNumber}_texto`);
            const preguntaTipo = formData.get(`pregunta_${questionNumber}_tipo`);
            
            console.log(`Processing question ${questionNumber}: ${preguntaTexto} (${preguntaTipo})`);
            
            // Si no existe esta pregunta (puede haber sido eliminada), continuamos
            if (!preguntaTexto || !preguntaTipo) {
                console.log(`Skipping question ${questionNumber} - incomplete data`);
                continue;
            }
            
            const pregunta = {
                texto: preguntaTexto,
                tipo: preguntaTipo,
                opciones: []
            };
            
            // Recopilamos las opciones basadas en el tipo de pregunta
            if (preguntaTipo === 'opcion_multiple') {
                let j = 1;
                while (formData.has(`pregunta_${questionNumber}_opcion_${j}_valor`)) {
                    const optionValue = formData.get(`pregunta_${questionNumber}_opcion_${j}_valor`);
                    const optionText = formData.get(`pregunta_${questionNumber}_opcion_${j}_texto`);
                    
                    console.log(`Option ${j}: ${optionValue} - ${optionText}`);
                    
                    pregunta.opciones.push({
                        valor: optionValue,
                        texto: optionText
                    });
                    j++;
                }
            } else if (preguntaTipo === 'verdadero_falso') {
                // Add default true/false options
                pregunta.opciones = [
                    { valor: 'true', texto: 'Verdadero' },
                    { valor: 'false', texto: 'Falso' }
                ];
            } else if (preguntaTipo === 'respuesta_corta') {
                // Add a placeholder option for text questions
                pregunta.opciones = [
                    { valor: 'text', texto: 'Respuesta de texto' }
                ];
            }
            
            surveyData.preguntas.push(pregunta);
        }
        
        console.log(`Processed ${surveyData.preguntas.length} questions`);
        console.log('Final survey data:', surveyData);
        
        // Inicializar la base de datos
        console.log('Initializing database...');
        const db = await ensureDatabaseInitialized();
        console.log('Database initialized, creating survey');
        
        // Crear la encuesta
        const encuestaId = await db.create('ENCUESTAS', {
            nombre: surveyData.nombre,
            titulo: surveyData.titulo,
            descripcion: surveyData.descripcion,
            tipo_representacion: surveyData.tipo_representacion
        });
        
        console.log('Survey created with ID:', encuestaId);
        
        // Crear las preguntas asociadas
        for (const pregunta of surveyData.preguntas) {
            console.log('Creating question:', pregunta);
            const preguntaId = await db.create('PREGUNTAS_ENCUESTA', {
                id_encuesta: encuestaId,
                tipo: pregunta.tipo,
                texto: pregunta.texto
            });
            
            // Crear las opciones de respuesta para esta pregunta
            for (const opcion of pregunta.opciones) {
                console.log('Creating option:', opcion);
                await db.create('OPCIONES_PREGUNTA', {
                    id_pregunta: preguntaId,
                    texto: opcion.texto,
                    valor: opcion.valor
                });
            }
        }
        
        console.log('Survey saved successfully!');

		// Regenerar páginas dinámicas
		if (window.pageGenerator) {
		    await window.pageGenerator.generateSurveyPages();
		} else if (window.DynamicPageGenerator) {
		    const generator = new window.DynamicPageGenerator();
		    await generator.generateSurveyPages();
		}
		
		if (window.app && window.app.showAlert) {
		    window.app.showAlert('Encuesta creada exitosamente.', 'success');
		} else {
		    alert('Encuesta creada exitosamente.');
		}
		
		// Redirigir a la página de administración de encuestas
		setTimeout(() => {
		    window.location.href = 'surveys-admin.html';
		}, 1500);
        
    } catch (error) {
        console.error('Error guardando encuesta:', error);
        if (window.app && window.app.showAlert) {
            window.app.showAlert('Error al guardar la encuesta: ' + error.message, 'danger');
        } else {
            alert('Error al guardar la encuesta: ' + error.message);
        }
    }
}

/**
 * Valida el formulario de creación de encuesta
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
            field.scrollIntoView({ behavior: 'smooth', block: 'center' });
            field.focus();
            isValid = false;
            return false;
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
        return false;
    }
    
    return isValid;
}


// Exportar funciones a window para uso global
window.addOption = addOption;
window.removeOption = removeOption;
window.removeQuestion = removeQuestion;
window.saveSurvey = saveSurvey;
window.ensureDatabaseInitialized = ensureDatabaseInitialized;
