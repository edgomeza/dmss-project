function initSurveys() {
    const surveys = document.querySelectorAll('.survey-container');
    surveys.forEach(survey => {
        const surveyId = survey.dataset.surveyId;
        survey.addEventListener('submit', (e) => handleSurveySubmit(e, surveyId));
    });
}

function handleSurveySubmit(event, surveyId) {
    event.preventDefault();
    const formData = new FormData(event.target);
    
    fetch(`/api/surveys/${surveyId}/submit`, {
        method: 'POST',
        body: formData
    })
    .then(response => response.json())
    .then(results => {
        displaySurveyResults(results);
    })
    .catch(handleAjaxError);
}

function displaySurveyResults(results) {
    const resultsContainer = document.querySelector('.survey-results');
    resultsContainer.innerHTML = `
        <h3>Resultados de la Encuesta</h3>
        ${renderResultsChart(results)}
    `;
}

function renderResultsChart(results) {
    // Implementación básica de gráfico de resultados
    return `
        <div class="results-chart">
            ${results.map(result => `
                <div class="result-bar">
                    <span>${result.label}</span>
                    <div style="width: ${result.percentage}%"></div>
                </div>
            `).join('')}
        </div>
    `;
}
