/**
 * Administración de cuestionarios evaluables
 */

class QuizAdmin {
    constructor() {
        this.init();
        this.currentQuizReview = null;
    }

    async init() {
        await this.loadQuizStats();
        await this.loadPendingReviews();
        this.loadQuizRoleAssignments();
        this.setupRoleAssignments();
    }

    async loadQuizStats() {
        try {
            const quizElements = document.querySelectorAll('[data-quiz]');
            const totalElement = document.getElementById('total-quiz-responses');
            const pendingElement = document.getElementById('pending-quiz-reviews');
            const averageElement = document.getElementById('quiz-average-score');
            
            let totalResponses = 0;
            let totalPending = 0;
            let scoreSum = 0;
            let scoreCount = 0;
            
            for (const quizElement of quizElements) {
                const quizName = quizElement.dataset.quiz;
                const responses = await this.getQuizResponses(quizName);
                
                // Estadísticas para este cuestionario
                const pending = responses.filter(r => !r.results.gradeConfirmed).length;
                const avgScore = this.calculateAverageScore(responses);
                
                // Actualizar contadores de este cuestionario
                const pendingElement = document.getElementById(`pending-review-${quizName}`);
                const scoreElement = document.getElementById(`avg-score-${quizName}`);
                
                if (pendingElement) {
                    pendingElement.textContent = pending;
                    pendingElement.style.backgroundColor = pending > 0 ? 'var(--warning-100)' : 'var(--gray-100)';
                    pendingElement.style.color = pending > 0 ? 'var(--warning-700)' : 'var(--gray-600)';
                }
                
                if (scoreElement) {
                    scoreElement.textContent = avgScore !== null ? `${avgScore}%` : 'N/A';
                }
                
                // Actualizar totales
                totalResponses += responses.length;
                totalPending += pending;
                
                // Acumular para media global
                responses.forEach(response => {
                    if (response.results && response.results.porcentaje) {
                        scoreSum += response.results.porcentaje;
                        scoreCount++;
                    }
                });
            }
            
            // Actualizar estadísticas globales
            if (totalElement) totalElement.textContent = totalResponses;
            if (pendingElement) pendingElement.textContent = totalPending;
            
            if (averageElement) {
                const globalAvg = scoreCount > 0 ? Math.round(scoreSum / scoreCount) : 'N/A';
                averageElement.textContent = typeof globalAvg === 'number' ? `${globalAvg}%` : globalAvg;
            }
        } catch (error) {
            console.error('Error cargando estadísticas de cuestionarios:', error);
        }
    }
    
    calculateAverageScore(responses) {
        if (!responses || responses.length === 0) return null;
        
        const validScores = responses.filter(r => r.results && typeof r.results.porcentaje === 'number');
        if (validScores.length === 0) return null;
        
        const sum = validScores.reduce((total, r) => total + r.results.porcentaje, 0);
        return Math.round(sum / validScores.length);
    }

	// Función para inicializar roles administrativos (si no está disponible globalmente)
	async initializeAdminRoles() {
        try {
            // Implementación básica para este archivo
            const adminRoles = ['Admin', 'Administrador'];
            localStorage.setItem('admin_roles', JSON.stringify(adminRoles));
            return adminRoles;
        } catch (error) {
            console.error('Error inicializando roles administrativos:', error);
            return [];
        }
    }

	async loadSurveyRoleAssignments() {
        try {
            // Obtener roles administrativos
            let adminRoles = JSON.parse(localStorage.getItem('admin_roles') || '[]');
            if (adminRoles.length === 0) {
                adminRoles = await this.initializeAdminRoles();
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

	/**
	 * Función para guardar asignaciones de roles para cuestionarios
	 */
	async saveQuizRoleAssignments() {
	    try {
	        // Recopilar todas las asignaciones
	        const checkboxes = document.querySelectorAll('.role-checkbox[data-quiz]');
	        const assignments = {};
	        
	        checkboxes.forEach(checkbox => {
	            const quizName = checkbox.dataset.quiz;
	            const roleName = checkbox.dataset.role;
	            
	            if (!assignments[quizName]) {
	                assignments[quizName] = [];
	            }
	            
	            if (checkbox.checked) {
	                assignments[quizName].push(roleName);
	            }
	        });
	        
	        // Guardar en localStorage
	        localStorage.setItem('quiz_role_assignments', JSON.stringify(assignments));
	        
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

    async getQuizResponses(quizName) {
        try {
            // Buscar en IndexedDB
            const db = window.localDB || await this.initDB();
            const responses = await db.query('RESPUESTAS_CUESTIONARIO', { quizName });
            
            // Si no hay respuestas, crear algunas de ejemplo para demostración
            if (responses.length === 0) {
                const sampleResponses = [
                    {
                        id: `quiz_${Date.now()}_1`,
                        quizName: quizName,
                        userId: 'usuario1@email.com',
                        timestamp: Date.now() - 86400000, // Ayer
                        reviewed: false,
                        results: {
                            totalPreguntas: 5,
                            totalCorrectas: 3,
                            porcentaje: 60,
                            gradeConfirmed: false,
                            preguntas: [
                                {
                                    texto: "Pregunta 1",
                                    respuesta: "Opción A",
                                    esCorrecta: true,
                                    respuestaCorrecta: "Opción A",
                                    correctionReviewed: false
                                },
                                {
                                    texto: "Pregunta 2",
                                    respuesta: "Opción B",
                                    esCorrecta: false,
                                    respuestaCorrecta: "Opción C",
                                    correctionReviewed: false
                                }
                            ]
                        }
                    },
                    {
                        id: `quiz_${Date.now()}_2`,
                        quizName: quizName,
                        userId: 'usuario2@email.com',
                        timestamp: Date.now() - 172800000, // Hace 2 días
                        reviewed: true,
                        results: {
                            totalPreguntas: 5,
                            totalCorrectas: 4,
                            porcentaje: 80,
                            gradeConfirmed: true,
                            preguntas: [
                                {
                                    texto: "Pregunta 1",
                                    respuesta: "Opción A",
                                    esCorrecta: true,
                                    respuestaCorrecta: "Opción A",
                                    correctionReviewed: true
                                },
                                {
                                    texto: "Pregunta 2",
                                    respuesta: "Opción C",
                                    esCorrecta: true,
                                    respuestaCorrecta: "Opción C",
                                    correctionReviewed: true
                                }
                            ]
                        }
                    }
                ];

                // Guardar respuestas de ejemplo
                for (const response of sampleResponses) {
                    await db.create('RESPUESTAS_CUESTIONARIO', response);
                }

                return sampleResponses;
            }

            return responses;
        } catch (error) {
            console.error('Error obteniendo respuestas de cuestionario:', error);
            return [];
        }
    }

    async loadPendingReviews() {
	    try {
	        const pendingTable = document.getElementById('pendingReviewsTable');
	        if (!pendingTable) return;
	
	        const allPending = [];
	        const processedIds = new Set(); // Track processed IDs
	        const quizElements = document.querySelectorAll('[data-quiz]');
	        
	        for (const quizElement of quizElements) {
	            const quizName = quizElement.dataset.quiz;
	            const responses = await this.getQuizResponses(quizName);
	            const pending = responses.filter(r => !r.results.gradeConfirmed);
	            
	            pending.forEach(response => {
	                if (!processedIds.has(response.id)) { // Only add if not already processed
	                    processedIds.add(response.id);
	                    response.quizName = quizName;
	                    allPending.push(response);
	                }
	            });
	        }
	
	        if (allPending.length === 0) {
	            pendingTable.innerHTML = '<p class="text-center">No hay evaluaciones pendientes de revisión</p>';
	            return;
	        }
	
	        pendingTable.innerHTML = allPending.map(response => `
	            <div class="review-row">
	                <div class="review-info">
	                    <strong>${response.quizName}</strong> - ${response.userId}
	                    <div class="review-meta">
	                        Fecha: ${new Date(response.timestamp).toLocaleDateString('es-ES')}
	                        <span class="review-score">${response.results.porcentaje}%</span>
	                    </div>
	                </div>
	                <div class="review-actions">
	                    <button class="btn btn-primary btn-sm" onclick="quizAdmin.reviewQuiz('${response.id}', '${response.quizName}')">
	                        👁️ Revisar Evaluación
	                    </button>
	                </div>
	            </div>
	        `).join('');
	
	    } catch (error) {
	        console.error('Error loading evaluations pending:', error);
	    }
	}
    
    async reviewQuiz(responseId, quizName) {
        try {
            const db = window.localDB || await this.initDB();
            const responses = await this.getQuizResponses(quizName);
            const response = responses.find(r => r.id === responseId);
            
            if (!response) {
                alert('Evaluación no encontrada');
                return;
            }
            
            this.currentQuizReview = response;
            
            const modal = document.getElementById('reviewModal');
            const modalBody = document.getElementById('reviewModalBody');
            
            if (!modal || !modalBody) return;
            
            modalBody.innerHTML = `
                <div class="student-info">
                    <h4>${response.userId}</h4>
                    <div class="student-meta">
                        <div>Cuestionario: <strong>${quizName}</strong></div>
                        <div>Fecha: <strong>${new Date(response.timestamp).toLocaleString('es-ES')}</strong></div>
                    </div>
                </div>
                
                <div class="quiz-score">
                    <div class="score-circle">${response.results.porcentaje}%</div>
                    <p>${response.results.totalCorrectas} de ${response.results.totalPreguntas} respuestas correctas</p>
                    <p class="note">${response.results.gradeConfirmed ? 
                        '<span class="badge status-correct">Calificación Confirmada</span>' : 
                        '<span class="badge status-incorrect">Pendiente de Confirmación</span>'}</p>
                </div>
                
                <div class="questions-review">
                    <h4>Revisión de Preguntas</h4>
                    
                     ${response.results.preguntas.map((pregunta, index) => `
	                    <div class="question-review-item">
	                        <div class="question-review-header">
	                            <h5 class="question-review-title">Pregunta ${index + 1}: ${pregunta.texto}</h5>
	                            <span class="question-status ${pregunta.esCorrecta ? 'status-correct' : 'status-incorrect'}">
	                                ${pregunta.esCorrecta ? 'Correcta' : 'Incorrecta'}
	                            </span>
	                        </div>
	                        <div class="question-review-body">
                                <div class="answers-comparison">
                                    <div class="student-answer">
                                        <div class="answer-label">Respuesta del estudiante:</div>
                                        <div class="answer-value">${pregunta.respuesta}</div>
                                    </div>
                                    <div class="correct-answer">
                                        <div class="answer-label">Respuesta correcta:</div>
                                        <div class="answer-value">${pregunta.respuestaCorrecta}</div>
                                    </div>
                                </div>
                                
                                <div class="correction-toggle">
	                                <div class="toggle-label">¿Modificar corrección?</div>
	                                <div class="role-toggle">
	                                    <input type="checkbox" id="toggle_correction_${index}" 
	                                           class="role-checkbox correction-checkbox"
	                                           data-question-index="${index}" 
	                                           ${pregunta.esCorrecta ? 'checked' : ''}>
	                                    <label for="toggle_correction_${index}" class="role-label"></label>
	                                </div>
                                    <div class="toggle-status">
                                        <span class="status-${pregunta.esCorrecta ? 'correct' : 'incorrect'}">
                                            ${pregunta.esCorrecta ? 'Correcta' : 'Incorrecta'}
                                        </span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    `).join('')}
                </div>
                
                <div class="score-actions">
                    <button class="btn btn-success" id="recalculateScoreBtn" onclick="quizAdmin.recalculateScore()">
                        Recalcular Puntuación
                    </button>
                </div>
            `;
            
            // Agregar eventos para los checkboxes de corrección
            const correctionCheckboxes = modalBody.querySelectorAll('.correction-checkbox');
            correctionCheckboxes.forEach(checkbox => {
                checkbox.addEventListener('change', this.handleCorrectionToggle.bind(this));
            });
            
            // Habilitar/deshabilitar botón de confirmar según estado
            const confirmBtn = document.getElementById('confirmGradeBtn');
            if (confirmBtn) {
                confirmBtn.disabled = response.results.gradeConfirmed;
                if (response.results.gradeConfirmed) {
                    confirmBtn.textContent = 'Calificación ya confirmada';
                }
            }
            
            modal.style.display = 'flex';
        } catch (error) {
            console.error('Error revisando cuestionario:', error);
            alert('Error al cargar la revisión del cuestionario');
        }
    }

	evaluateQuiz() {
	    // Evaluación de cuestionario
	    const totalPreguntas = this.totalQuestions;
	    let totalCorrectas = 0;
	    
	    const preguntas = [];
	    for (let i = 1; i <= totalPreguntas; i++) {
	        const container = this.form.querySelector(`[data-question="${i}"]`);
	        const questionText = container?.querySelector('.question-text')?.textContent || `Pregunta ${i}`;
	        
	        // Determine if correct randomly (50% chance) to simulate user answers
	        const isCorrect = Math.random() > 0.5;
	        if (isCorrect) totalCorrectas++;
	        
	        preguntas.push({
	            texto: questionText,
	            respuesta: this.answers.get(`question_${i}`) || 'No respondida',
	            esCorrecta: isCorrect,
	            respuestaCorrecta: 'Respuesta correcta simulada',
	            correctionReviewed: false // Indica si un admin ha revisado la corrección
	        });
	    }
	    
	    const porcentaje = Math.round((totalCorrectas / totalPreguntas) * 100);
	
	    return {
	        totalPreguntas,
	        totalCorrectas,
	        porcentaje,
	        preguntas,
	        gradeConfirmed: false // El administrador debe confirmar la calificación
	    };
	}
    
    handleCorrectionToggle(event) {
        const checkbox = event.target;
        const questionIndex = parseInt(checkbox.dataset.questionIndex, 10);
        const isCorrect = checkbox.checked;
        
        if (!this.currentQuizReview || !this.currentQuizReview.results.preguntas[questionIndex]) {
            return;
        }
        
        // Actualizar estado de corrección
        this.currentQuizReview.results.preguntas[questionIndex].esCorrecta = isCorrect;
        this.currentQuizReview.results.preguntas[questionIndex].correctionReviewed = true;
        
        // Actualizar elemento de estado en la interfaz
        const toggleStatus = checkbox.closest('.correction-toggle').querySelector('.toggle-status span');
        if (toggleStatus) {
            toggleStatus.className = `status-${isCorrect ? 'correct' : 'incorrect'}`;
            toggleStatus.textContent = isCorrect ? 'Correcta' : 'Incorrecta';
        }
        
        // Actualizar cabecera de pregunta
        const questionHeader = checkbox.closest('.question-review-item').querySelector('.question-status');
        if (questionHeader) {
            questionHeader.className = `question-status ${isCorrect ? 'status-correct' : 'status-incorrect'}`;
            questionHeader.textContent = isCorrect ? 'Correcta' : 'Incorrecta';
        }
    }
    
    recalculateScore() {
        if (!this.currentQuizReview) return;
        
        // Contar preguntas correctas
        const totalPreguntas = this.currentQuizReview.results.preguntas.length;
        const totalCorrectas = this.currentQuizReview.results.preguntas.filter(p => p.esCorrecta).length;
        const porcentaje = Math.round((totalCorrectas / totalPreguntas) * 100);
        
        // Actualizar resultados
        this.currentQuizReview.results.totalCorrectas = totalCorrectas;
        this.currentQuizReview.results.porcentaje = porcentaje;
        
        // Actualizar puntuación en la interfaz
        const scoreCircle = document.querySelector('.score-circle');
        if (scoreCircle) {
            scoreCircle.textContent = `${porcentaje}%`;
        }
        
        const scoreText = document.querySelector('.quiz-score p');
        if (scoreText) {
            scoreText.textContent = `${totalCorrectas} de ${totalPreguntas} respuestas correctas`;
        }
        
        // Mostrar mensaje
        window.app.showAlert('Puntuación recalculada correctamente', 'success');
    }
    
    async confirmGrade() {
        if (!this.currentQuizReview) return;
        
        try {
            // Marcar como confirmada
            this.currentQuizReview.results.gradeConfirmed = true;
            this.currentQuizReview.reviewedAt = Date.now();
            
            // Guardar en la base de datos
            const db = window.localDB || await this.initDB();
            await db.update('RESPUESTAS_CUESTIONARIO', this.currentQuizReview);
            
            // Actualizar interfaz
            const confirmBtn = document.getElementById('confirmGradeBtn');
            if (confirmBtn) {
                confirmBtn.disabled = true;
                confirmBtn.textContent = 'Calificación confirmada';
            }
            
            const noteElement = document.querySelector('.quiz-score .note');
            if (noteElement) {
                noteElement.innerHTML = '<span class="badge status-correct">Calificación Confirmada</span>';
            }
            
            // Recargar estadísticas
            await this.loadQuizStats();
            await this.loadPendingReviews();
            
            window.app.showAlert('Calificación confirmada. El estudiante ya puede ver los resultados.', 'success');
        } catch (error) {
            console.error('Error al confirmar calificación:', error);
            window.app.showAlert('Error al confirmar la calificación', 'danger');
        }
    }
    
    async viewQuizResults(quizName) {
        try {
            const responses = await this.getQuizResponses(quizName);
            
            const modal = document.getElementById('resultsModal');
            const modalBody = document.getElementById('resultsModalBody');
            
            if (!modal || !modalBody) return;
            
            // Filtrar por respuestas válidas (con resultados)
            const validResponses = responses.filter(r => r.results);
            
            if (validResponses.length === 0) {
                modalBody.innerHTML = `
                    <div class="text-center">
                        <p>No hay resultados disponibles para este cuestionario.</p>
                    </div>
                `;
                modal.style.display = 'flex';
                return;
            }
            
            // Calcular estadísticas
            const totalResponses = validResponses.length;
            const confirmedResponses = validResponses.filter(r => r.results.gradeConfirmed).length;
            const totalScore = validResponses.reduce((sum, r) => sum + r.results.porcentaje, 0);
            const averageScore = Math.round(totalScore / totalResponses);
            
            // Construir distribución de puntuaciones
            const scoreDistribution = {
                '0-20': 0,
                '21-40': 0,
                '41-60': 0,
                '61-80': 0,
                '81-100': 0
            };
            
            validResponses.forEach(r => {
                const score = r.results.porcentaje;
                if (score <= 20) scoreDistribution['0-20']++;
                else if (score <= 40) scoreDistribution['21-40']++;
                else if (score <= 60) scoreDistribution['41-60']++;
                else if (score <= 80) scoreDistribution['61-80']++;
                else scoreDistribution['81-100']++;
            });
            
            // Construir HTML
            modalBody.innerHTML = `
                <div class="quiz-results-summary">
                    <h4>${quizName} - Resumen de Resultados</h4>
                    
                    <div class="results-overview">
                        <div class="result-stat">
                            <div class="result-stat-number">${totalResponses}</div>
                            <div class="result-stat-label">Evaluaciones</div>
                        </div>
                        <div class="result-stat">
                            <div class="result-stat-number">${confirmedResponses}</div>
                            <div class="result-stat-label">Confirmadas</div>
                        </div>
                        <div class="result-stat">
                            <div class="result-stat-number">${totalResponses - confirmedResponses}</div>
                            <div class="result-stat-label">Pendientes</div>
                        </div>
                        <div class="result-stat">
                            <div class="result-stat-number">${averageScore}%</div>
                            <div class="result-stat-label">Nota Media</div>
                        </div>
                    </div>
                    
                    <div class="score-distribution">
                        <h5>Distribución de Puntuaciones</h5>
                        <div class="distribution-bars">
                            ${Object.entries(scoreDistribution).map(([range, count]) => {
                                const percentage = Math.round((count / totalResponses) * 100) || 0;
                                return `
                                    <div class="distribution-item">
                                        <div class="distribution-label">${range}%</div>
                                        <div class="distribution-bar-container">
                                            <div class="distribution-bar" style="width: ${percentage}%"></div>
                                            <div class="distribution-value">${count} (${percentage}%)</div>
                                        </div>
                                    </div>
                                `;
                            }).join('')}
                        </div>
                    </div>
                    
                    <div class="student-results">
                        <h5>Resultados por Estudiante</h5>
                        <div class="student-results-list">
                            ${validResponses.map(r => `
                                <div class="student-result-item ${r.results.gradeConfirmed ? 'confirmed' : 'pending'}">
                                    <div class="student-info">
                                        <div class="student-name">${r.userId}</div>
                                        <div class="student-meta">
                                            Fecha: ${new Date(r.timestamp).toLocaleDateString('es-ES')}
                                        </div>
                                    </div>
                                    <div class="student-score">
                                        <div class="score-badge">${r.results.porcentaje}%</div>
                                        <div class="score-status">
                                            ${r.results.gradeConfirmed ? 
                                                '<span class="badge status-correct">Confirmado</span>' : 
                                                '<span class="badge status-incorrect">Pendiente</span>'}
                                        </div>
                                    </div>
                                    <div class="student-actions">
                                        <button class="btn btn-primary btn-sm" onclick="quizAdmin.reviewQuiz('${r.id}', '${quizName}')">
                                            Ver Detalles
                                        </button>
                                    </div>
                                </div>
                            `).join('')}
                        </div>
                    </div>
                </div>
            `;
            
            // Agregar estilos específicos
            const style = document.createElement('style');
            style.textContent = `
                .distribution-bars {
                    margin-top: 1rem;
                }
                
                .distribution-item {
                    margin-bottom: 0.75rem;
                }
                
                .distribution-label {
                    font-size: 0.875rem;
                    font-weight: 500;
                    margin-bottom: 0.25rem;
                }
                
                .distribution-bar-container {
                    height: 24px;
                    background: var(--gray-100);
                    border-radius: var(--radius);
                    position: relative;
                    overflow: hidden;
                }
                
                .distribution-bar {
                    height: 100%;
                    background: var(--primary-500);
                    transition: width 0.5s ease;
                }
                
                .distribution-value {
                    position: absolute;
                    top: 0;
                    left: 0.5rem;
                    height: 100%;
                    display: flex;
                    align-items: center;
                    font-size: 0.75rem;
                    color: white;
                    text-shadow: 0 1px 2px rgba(0,0,0,0.3);
                }
                
                .student-results-list {
                    margin-top: 1rem;
                    max-height: 300px;
                    overflow-y: auto;
                }
                
                .student-result-item {
                    display: flex;
                    justify-content: space-between;
                    align-items: center;
                    padding: 0.75rem;
                    border: 1px solid var(--gray-200);
                    border-radius: var(--radius);
                    margin-bottom: 0.5rem;
                }
                
                .student-result-item.confirmed {
                    border-left: 4px solid var(--success-500);
                }
                
                .student-result-item.pending {
                    border-left: 4px solid var(--warning-500);
                }
                
                .student-name {
                    font-weight: 500;
                }
                
                .student-meta {
                    font-size: 0.75rem;
                    color: var(--gray-600);
                }
                
                .score-badge {
                    background: var(--blue-100);
                    color: var(--blue-700);
                    padding: 0.25rem 0.5rem;
                    border-radius: var(--radius);
                    font-weight: 600;
                }
                
                .score-status {
                    font-size: 0.75rem;
                    margin-top: 0.25rem;
                    text-align: center;
                }
            `;
            modalBody.appendChild(style);
            
            modal.style.display = 'flex';
        } catch (error) {
            console.error('Error al mostrar resultados del cuestionario:', error);
            window.app.showAlert('Error al cargar los resultados', 'danger');
        }
    }
    
    setupRoleAssignments() {
        // Manejar guardado de asignaciones
        const saveButton = document.getElementById('saveQuizRoleAssignments');
        if (saveButton) {
            saveButton.addEventListener('click', this.saveRoleAssignments.bind(this));
        }
    }
    
    async saveRoleAssignments() {
        try {
            // Recopilar todas las asignaciones
            const checkboxes = document.querySelectorAll('.role-checkbox[data-quiz]');
            const assignments = {};
            
            checkboxes.forEach(checkbox => {
                const quizName = checkbox.dataset.quiz;
                const roleName = checkbox.dataset.role;
                
                if (!assignments[quizName]) {
                    assignments[quizName] = [];
                }
                
                if (checkbox.checked) {
                    assignments[quizName].push(roleName);
                }
            });
            
            // Guardar en localStorage (o podría guardarse en IndexedDB)
            localStorage.setItem('quiz_role_assignments', JSON.stringify(assignments));
            
            window.app.showAlert('Asignaciones guardadas correctamente', 'success');
        } catch (error) {
            console.error('Error al guardar asignaciones:', error);
            window.app.showAlert('Error al guardar las asignaciones', 'danger');
        }
    }
    
    async deleteQuiz(quizName) {
        if (!confirm(`¿Está seguro de que desea eliminar el cuestionario "${quizName}"? Esta acción eliminará también todas las respuestas asociadas.`)) {
            return;
        }

        try {
            const db = window.localDB || await this.initDB();
            
            // Eliminar respuestas asociadas
            const responses = await this.getQuizResponses(quizName);
            for (const response of responses) {
                await db.delete('RESPUESTAS_CUESTIONARIO', response.id);
            }
            
            window.app.showAlert('Cuestionario eliminado correctamente', 'success');
            
            // Recargar estadísticas
            await this.loadQuizStats();
            await this.loadPendingReviews();
        } catch (error) {
            console.error('Error eliminando cuestionario:', error);
            window.app.showAlert('Error al eliminar el cuestionario', 'danger');
        }
    }

    editQuiz(quizName) {
        // Redirigir a página de edición (en una implementación real)
        window.app.showAlert(`Función de edición para "${quizName}" - Por implementar`, 'info');
    }

    closeReviewModal() {
        const modal = document.getElementById('reviewModal');
        if (modal) {
            modal.style.display = 'none';
        }
    }

    closeResultsModal() {
        const modal = document.getElementById('resultsModal');
        if (modal) {
            modal.style.display = 'none';
        }
    }

    async initDB() {
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

// Crear instancia global para usar en onclick
window.quizAdmin = new QuizAdmin();

// Funciones globales para los onclick
window.viewQuizResults = function(quizName) {
    window.quizAdmin.viewQuizResults(quizName);
};

window.editQuiz = function(quizName) {
    window.quizAdmin.editQuiz(quizName);
};

window.deleteQuiz = function(quizName) {
    window.quizAdmin.deleteQuiz(quizName);
};

window.closeReviewModal = function() {
    window.quizAdmin.closeReviewModal();
};

window.closeResultsModal = function() {
    window.quizAdmin.closeResultsModal();
};

window.confirmGrade = function() {
    window.quizAdmin.confirmGrade();
};

window.initializeAdminRoles = function() {
	window.quizAdmin.initializeAdminRoles();
};

document.addEventListener('DOMContentLoaded', function() {
    const saveButton = document.getElementById('saveQuizRoleAssignments');
    if (saveButton) {
        saveButton.addEventListener('click', function() {
            quizAdmin.saveQuizRoleAssignments();
        });
    }
});
