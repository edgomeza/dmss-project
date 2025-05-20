/**
 * Gestor CRUD genérico para entidades
 */
class CRUDManager {
    constructor(entityName) {
        this.entityName = entityName;
        this.dataManager = new DataManager(entityName);
        this.currentPage = 1;
        this.pageSize = 10;
        this.totalRecords = 0;
        this.currentSort = null;
        this.currentFilters = {};
        this.selectedItems = new Set();
    }

    /**
     * Inicializa el gestor CRUD
     */
    init() {
        this.setupEventListeners();
        if (document.getElementById('tableBody')) {
            this.loadTableData();
        }
    }

    /**
     * Configura los event listeners
     */
    setupEventListeners() {
        // Selección masiva
        const selectAllCheckbox = document.getElementById('selectAll');
        if (selectAllCheckbox) {
            selectAllCheckbox.addEventListener('change', this.handleSelectAll.bind(this));
        }

        // Filtros
        const filtersForm = document.getElementById('filtersForm');
        if (filtersForm) {
            filtersForm.addEventListener('submit', this.handleFilter.bind(this));
            filtersForm.addEventListener('reset', this.handleResetFilters.bind(this));
        }

        // Ordenamiento
        const sortableHeaders = document.querySelectorAll('[data-sortable="true"]');
        sortableHeaders.forEach(header => {
            header.addEventListener('click', this.handleSort.bind(this));
            header.style.cursor = 'pointer';
        });
    }

    /**
     * Carga los datos de la tabla
     */
    async loadTableData() {
        const loadingIndicator = document.getElementById('loadingIndicator');
        const tableBody = document.getElementById('tableBody');
        
        if (loadingIndicator) {
            loadingIndicator.style.display = 'block';
        }
        
        try {
            const response = await this.dataManager.getAll(this.currentFilters, this.currentPage, this.pageSize);
            
            if (loadingIndicator) {
                loadingIndicator.style.display = 'none';
            }

            if (response && response.entities) {
                this.renderTableData(response.entities);
                this.totalRecords = response.total || response.entities.length;
                this.renderPagination();
            } else {
                this.showError('Error al cargar los datos: ' + (response?.error || 'Error desconocido'));
            }
        } catch (error) {
            if (loadingIndicator) {
                loadingIndicator.style.display = 'none';
            }
            this.showError('Error al cargar los datos: ' + error.message);
        }
    }

    /**
     * Renderiza los datos en la tabla
     */
    renderTableData(entities) {
        const tableBody = document.getElementById('tableBody');
        if (!tableBody) return;

        const fields = this.getEntityFields();
        
        tableBody.innerHTML = '';

        entities.forEach(entity => {
            const row = document.createElement('tr');
            
            // Checkbox de selección
            const checkboxCell = document.createElement('td');
            const checkbox = document.createElement('input');
            checkbox.type = 'checkbox';
            checkbox.value = entity[this.getPrimaryKeyField()];
            checkbox.addEventListener('change', this.handleRowSelect.bind(this));
            checkboxCell.appendChild(checkbox);
            row.appendChild(checkboxCell);

            // Campos de datos
            fields.forEach(field => {
                if (field.showInTable !== false) {
                    const cell = document.createElement('td');
                    const value = entity[field.name];
                    cell.innerHTML = this.formatFieldValue(value, field);
                    row.appendChild(cell);
                }
            });

            // Acciones
            const actionsCell = document.createElement('td');
            actionsCell.innerHTML = this.generateActionButtons(entity[this.getPrimaryKeyField()]);
            row.appendChild(actionsCell);

            tableBody.appendChild(row);
        });
    }

    /**
     * Genera los botones de acción para cada fila
     */
    generateActionButtons(id) {
        return `
            <div class="crud-actions">
                <a href="detail.html?id=${id}" class="btn btn-info btn-sm" title="Ver detalles">
                    👁
                </a>
                <a href="edit.html?id=${id}" class="btn btn-warning btn-sm" title="Editar">
                    ✏️
                </a>
                <button class="btn btn-danger btn-sm" onclick="window.crudManager.confirmDelete('${id}')" title="Eliminar">
                    🗑
                </button>
            </div>
        `;
    }

    /**
     * Formatea el valor de un campo para mostrar en la tabla
     */
    formatFieldValue(value, field) {
        if (value === null || value === undefined) {
            return '<span class="text-muted">-</span>';
        }

        switch (field.type) {
            case 'boolean':
                return value ? 
                    '<span class="badge badge-success">Sí</span>' : 
                    '<span class="badge badge-danger">No</span>';
            case 'date':
                return new Date(value).toLocaleDateString('es-ES');
            case 'email':
                return `<a href="mailto:${value}">${value}</a>`;
            case 'url':
                return `<a href="${value}" target="_blank">${value}</a>`;
            default:
                return String(value);
        }
    }

    /**
     * Renderiza la paginación
     */
    renderPagination() {
        const paginationWrapper = document.getElementById('paginationWrapper');
        if (!paginationWrapper) return;

        const totalPages = Math.ceil(this.totalRecords / this.pageSize);
        
        if (totalPages <= 1) {
            paginationWrapper.innerHTML = '';
            return;
        }

        let paginationHTML = '<ul class="pagination">';

        // Botón anterior
        if (this.currentPage > 1) {
            paginationHTML += `
                <li class="pagination-item">
                    <a href="#" class="pagination-link" data-page="${this.currentPage - 1}">Anterior</a>
                </li>
            `;
        }

        // Números de página
        const startPage = Math.max(1, this.currentPage - 2);
        const endPage = Math.min(totalPages, this.currentPage + 2);

        for (let i = startPage; i <= endPage; i++) {
            const isActive = i === this.currentPage ? 'active' : '';
            paginationHTML += `
                <li class="pagination-item">
                    <a href="#" class="pagination-link ${isActive}" data-page="${i}">${i}</a>
                </li>
            `;
        }

        // Botón siguiente
        if (this.currentPage < totalPages) {
            paginationHTML += `
                <li class="pagination-item">
                    <a href="#" class="pagination-link" data-page="${this.currentPage + 1}">Siguiente</a>
                </li>
            `;
        }

        paginationHTML += '</ul>';
        paginationWrapper.innerHTML = paginationHTML;

        // Agregar event listeners a los enlaces de paginación
        const paginationLinks = paginationWrapper.querySelectorAll('.pagination-link');
        paginationLinks.forEach(link => {
            link.addEventListener('click', (e) => {
                e.preventDefault();
                const page = parseInt(e.target.dataset.page);
                if (page && page !== this.currentPage) {
                    this.currentPage = page;
                    this.loadTableData();
                }
            });
        });
    }

    /**
     * Maneja la selección de todas las filas
     */
    handleSelectAll(event) {
        const isChecked = event.target.checked;
        const rowCheckboxes = document.querySelectorAll('#tableBody input[type="checkbox"]');
        
        rowCheckboxes.forEach(checkbox => {
            checkbox.checked = isChecked;
            if (isChecked) {
                this.selectedItems.add(checkbox.value);
            } else {
                this.selectedItems.delete(checkbox.value);
            }
        });

        this.updateBulkActionsVisibility();
    }

    /**
     * Maneja la selección de una fila
     */
    handleRowSelect(event) {
        const checkbox = event.target;
        const value = checkbox.value;

        if (checkbox.checked) {
            this.selectedItems.add(value);
        } else {
            this.selectedItems.delete(value);
        }

        // Actualizar el checkbox de "seleccionar todo"
        const selectAllCheckbox = document.getElementById('selectAll');
        const rowCheckboxes = document.querySelectorAll('#tableBody input[type="checkbox"]');
        const checkedCheckboxes = document.querySelectorAll('#tableBody input[type="checkbox"]:checked');
        
        if (selectAllCheckbox) {
            selectAllCheckbox.checked = rowCheckboxes.length === checkedCheckboxes.length;
            selectAllCheckbox.indeterminate = checkedCheckboxes.length > 0 && checkedCheckboxes.length < rowCheckboxes.length;
        }

        this.updateBulkActionsVisibility();
    }

    /**
     * Actualiza la visibilidad de las acciones masivas
     */
    updateBulkActionsVisibility() {
        const bulkActions = document.getElementById('bulkActions');
        const selectedCount = document.getElementById('selectedCount');

        if (bulkActions && selectedCount) {
            if (this.selectedItems.size > 0) {
                bulkActions.style.display = 'flex';
                selectedCount.textContent = this.selectedItems.size;
            } else {
                bulkActions.style.display = 'none';
            }
        }
    }

    /**
     * Maneja el filtrado
     */
    handleFilter(event) {
        event.preventDefault();
        
        const formData = new FormData(event.target);
        this.currentFilters = {};

        for (let [key, value] of formData.entries()) {
            if (value.trim()) {
                // Remover el prefijo 'filter_' del nombre del campo
                const fieldName = key.replace('filter_', '');
                this.currentFilters[fieldName] = value;
            }
        }

        this.currentPage = 1; // Resetear a la primera página
        this.loadTableData();
    }

    /**
     * Maneja el reset de filtros
     */
    handleResetFilters(event) {
        this.currentFilters = {};
        this.currentPage = 1;
        this.loadTableData();
    }

    /**
     * Maneja el ordenamiento
     */
    handleSort(event) {
        const header = event.currentTarget;
        const column = header.dataset.column;
        
        if (!column) return;

        let direction = 'ASC';
        const currentSortIcon = header.querySelector('.sort-icon');
        
        // Remover iconos de ordenamiento de otros headers
        document.querySelectorAll('.sort-icon').forEach(icon => {
            icon.className = 'sort-icon';
        });

        // Determinar dirección del ordenamiento
        if (this.currentSort && this.currentSort.column === column) {
            direction = this.currentSort.direction === 'ASC' ? 'DESC' : 'ASC';
        }

        this.currentSort = { column, direction };
        
        // Actualizar icono
        if (currentSortIcon) {
            currentSortIcon.className = `sort-icon ${direction.toLowerCase()}`;
        }

        this.loadTableData();
    }

    /**
     * Confirma la eliminación de un elemento
     */
    confirmDelete(id) {
        if (confirm('¿Está seguro de que desea eliminar este registro?')) {
            this.deleteEntity(id);
        }
    }

    /**
     * Elimina una entidad
     */
    async deleteEntity(id) {
        try {
            const response = await this.dataManager.delete(id);
            if (response && response.success) {
                this.showSuccess('Registro eliminado correctamente');
                this.loadTableData();
            } else {
                this.showError('Error al eliminar: ' + (response?.error || 'Error desconocido'));
            }
        } catch (error) {
            this.showError('Error al eliminar: ' + error.message);
        }
    }

    /**
     * Elimina los elementos seleccionados
     */
    async deleteSelected() {
        if (this.selectedItems.size === 0) {
            this.showWarning('No hay elementos seleccionados');
            return;
        }

        if (confirm(`¿Está seguro de que desea eliminar ${this.selectedItems.size} registro(s)?`)) {
            const promises = Array.from(this.selectedItems).map(id => {
                return this.dataManager.delete(id);
            });

            try {
                const results = await Promise.all(promises);
                const successCount = results.filter(r => r && r.success).length;
                const errorCount = results.length - successCount;

                if (successCount > 0) {
                    this.showSuccess(`${successCount} registro(s) eliminado(s) correctamente`);
                }
                if (errorCount > 0) {
                    this.showError(`Error al eliminar ${errorCount} registro(s)`);
                }

                this.selectedItems.clear();
                this.loadTableData();
                this.updateBulkActionsVisibility();
            } catch (error) {
                this.showError('Error al eliminar registros: ' + error.message);
            }
        }
    }

    /**
     * Actualiza la tabla
     */
    refreshTable() {
        this.loadTableData();
        this.showSuccess('Tabla actualizada');
    }

    /**
     * Muestra un mensaje de éxito
     */
    showSuccess(message) {
        if (window.app && window.app.showAlert) {
            window.app.showAlert(message, 'success');
        } else {
            alert(message);
        }
    }

    /**
     * Muestra un mensaje de error
     */
    showError(message) {
        if (window.app && window.app.showAlert) {
            window.app.showAlert(message, 'danger');
        } else {
            alert(message);
        }
    }

    /**
     * Muestra un mensaje de advertencia
     */
    showWarning(message) {
        if (window.app && window.app.showAlert) {
            window.app.showAlert(message, 'warning');
        } else {
            alert(message);
        }
    }

    /**
     * Obtiene los campos de la entidad - debe ser sobrescrito por las clases hijas
     */
    getEntityFields() {
        return [];
    }

    /**
     * Obtiene el campo clave primaria - debe ser sobrescrito por las clases hijas
     */
    getPrimaryKeyField() {
        const fields = this.getEntityFields();
        const primaryField = fields.find(f => f.isPrimary);
        return primaryField ? primaryField.name : 'id';
    }
}

// Funciones globales para usar en los onclick de los botones
window.refreshTable = function() {
    if (window.crudManager) {
        window.crudManager.refreshTable();
    }
};

window.deleteSelected = function() {
    if (window.crudManager) {
        window.crudManager.deleteSelected();
    }
};

window.closeDeleteModal = function() {
    const modal = document.getElementById('deleteModal');
    if (modal) {
        modal.style.display = 'none';
    }
};
