/**
 */
package dataweb;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pagina CRUD</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dataweb.PaginaCRUD#getEntidad <em>Entidad</em>}</li>
 * </ul>
 *
 * @see dataweb.DatawebPackage#getPaginaCRUD()
 * @model abstract="true"
 *        annotation="gmf.node label='nombre' color='200,150,255'"
 * @generated
 */
public interface PaginaCRUD extends Pagina {
	/**
	 * Returns the value of the '<em><b>Entidad</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entidad</em>' reference.
	 * @see #setEntidad(Entidad)
	 * @see dataweb.DatawebPackage#getPaginaCRUD_Entidad()
	 * @model required="true"
	 *        annotation="gmf.link target.decoration='arrow' color='150,0,150'"
	 * @generated
	 */
	Entidad getEntidad();

	/**
	 * Sets the value of the '{@link dataweb.PaginaCRUD#getEntidad <em>Entidad</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Entidad</em>' reference.
	 * @see #getEntidad()
	 * @generated
	 */
	void setEntidad(Entidad value);

} // PaginaCRUD
