/**
 */
package dataweb;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pagina Indice Paginada Filtrada</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dataweb.PaginaIndicePaginadaFiltrada#getPageSize <em>Page Size</em>}</li>
 *   <li>{@link dataweb.PaginaIndicePaginadaFiltrada#getAtributosFiltro <em>Atributos Filtro</em>}</li>
 * </ul>
 *
 * @see dataweb.DatawebPackage#getPaginaIndicePaginadaFiltrada()
 * @model annotation="gmf.node label='nombre' color='120,180,255'"
 * @generated
 */
public interface PaginaIndicePaginadaFiltrada extends PaginaIndice {
	/**
	 * Returns the value of the '<em><b>Page Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Page Size</em>' attribute.
	 * @see #setPageSize(int)
	 * @see dataweb.DatawebPackage#getPaginaIndicePaginadaFiltrada_PageSize()
	 * @model required="true"
	 * @generated
	 */
	int getPageSize();

	/**
	 * Sets the value of the '{@link dataweb.PaginaIndicePaginadaFiltrada#getPageSize <em>Page Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Page Size</em>' attribute.
	 * @see #getPageSize()
	 * @generated
	 */
	void setPageSize(int value);

	/**
	 * Returns the value of the '<em><b>Atributos Filtro</b></em>' reference list.
	 * The list contents are of type {@link dataweb.Atributo}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Atributos Filtro</em>' reference list.
	 * @see dataweb.DatawebPackage#getPaginaIndicePaginadaFiltrada_AtributosFiltro()
	 * @model annotation="gmf.link target.decoration='arrow' color='0,100,200'"
	 * @generated
	 */
	EList<Atributo> getAtributosFiltro();

} // PaginaIndicePaginadaFiltrada
