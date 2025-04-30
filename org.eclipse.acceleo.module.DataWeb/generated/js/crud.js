function initCRUDForms() {
    const crudForms = document.querySelectorAll('.crud-form');
    crudForms.forEach(form => {
        form.addEventListener('submit', handleCRUDSubmit);
    });
}

function handleCRUDSubmit(event) {
    event.preventDefault();
    const form = event.target;
    const formData = new FormData(form);
    const entityType = form.dataset.entityType;

    fetch(`/api/${entityType}`, {
        method: form.dataset.method || 'POST',
        body: formData
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Error en la solicitud CRUD');
        }
        return response.json();
    })
    .then(data => {
        showNotification(`${entityType} procesado correctamente`);
        updateEntityList(entityType);
    })
    .catch(handleAjaxError);
}

function updateEntityList(entityType) {
    // Actualizar lista de entidades después de operaciones CRUD
    fetch(`/api/${entityType}/list`)
    .then(response => response.json())
    .then(data => {
        const listContainer = document.querySelector(`#${entityType}-list`);
        listContainer.innerHTML = renderEntityList(data);
    })
    .catch(handleAjaxError);
}

function renderEntityList(entities) {
    return entities.map(entity => `
        <tr>
            <td>${entity.id}</td>
            <td>${entity.nombre}</td>
            <td>
                <button onclick="editEntity(${entity.id})">Editar</button>
                <button onclick="deleteEntity(${entity.id})">Eliminar</button>
            </td>
        </tr>
    `).join('');
}
