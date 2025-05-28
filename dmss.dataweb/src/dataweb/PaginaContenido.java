/**
 */
package dataweb;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pagina Contenido</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dataweb.PaginaContenido#getContenido <em>Contenido</em>}</li>
 * </ul>
 *
 * @see dataweb.DatawebPackage#getPaginaContenido()
 * @model annotation="gmf.node label='nombre' color='150,255,200'"
 * @generated
 */
public interface PaginaContenido extends Pagina {
	/**
	 * Returns the value of the '<em><b>Contenido</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contenido</em>' attribute.
	 * @see #setContenido(String)
	 * @see dataweb.DatawebPackage#getPaginaContenido_Contenido()
	 * @model required="true"
	 * @generated
	 */
	String getContenido();

	/**
	 * Sets the value of the '{@link dataweb.PaginaContenido#getContenido <em>Contenido</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Contenido</em>' attribute.
	 * @see #getContenido()
	 * @generated
	 */
	void setContenido(String value);

} // PaginaContenido
