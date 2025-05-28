/**
 */
package dataweb;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pagina Indice Paginada</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dataweb.PaginaIndicePaginada#getPageSize <em>Page Size</em>}</li>
 * </ul>
 *
 * @see dataweb.DatawebPackage#getPaginaIndicePaginada()
 * @model annotation="gmf.node label='nombre' color='255,180,120'"
 * @generated
 */
public interface PaginaIndicePaginada extends PaginaIndice {
	/**
	 * Returns the value of the '<em><b>Page Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Page Size</em>' attribute.
	 * @see #setPageSize(int)
	 * @see dataweb.DatawebPackage#getPaginaIndicePaginada_PageSize()
	 * @model required="true"
	 * @generated
	 */
	int getPageSize();

	/**
	 * Sets the value of the '{@link dataweb.PaginaIndicePaginada#getPageSize <em>Page Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Page Size</em>' attribute.
	 * @see #getPageSize()
	 * @generated
	 */
	void setPageSize(int value);

} // PaginaIndicePaginada
