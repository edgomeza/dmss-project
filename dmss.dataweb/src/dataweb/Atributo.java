/**
 */
package dataweb;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Atributo</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dataweb.Atributo#getNombre <em>Nombre</em>}</li>
 *   <li>{@link dataweb.Atributo#isIsPrimaryKey <em>Is Primary Key</em>}</li>
 *   <li>{@link dataweb.Atributo#getTipo <em>Tipo</em>}</li>
 * </ul>
 *
 * @see dataweb.DatawebPackage#getAtributo()
 * @model annotation="gmf.node label='nombre' color='255,255,200'"
 * @generated
 */
public interface Atributo extends EObject {
	/**
	 * Returns the value of the '<em><b>Nombre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nombre</em>' attribute.
	 * @see #setNombre(String)
	 * @see dataweb.DatawebPackage#getAtributo_Nombre()
	 * @model required="true"
	 * @generated
	 */
	String getNombre();

	/**
	 * Sets the value of the '{@link dataweb.Atributo#getNombre <em>Nombre</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nombre</em>' attribute.
	 * @see #getNombre()
	 * @generated
	 */
	void setNombre(String value);

	/**
	 * Returns the value of the '<em><b>Is Primary Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Primary Key</em>' attribute.
	 * @see #setIsPrimaryKey(boolean)
	 * @see dataweb.DatawebPackage#getAtributo_IsPrimaryKey()
	 * @model required="true"
	 * @generated
	 */
	boolean isIsPrimaryKey();

	/**
	 * Sets the value of the '{@link dataweb.Atributo#isIsPrimaryKey <em>Is Primary Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Primary Key</em>' attribute.
	 * @see #isIsPrimaryKey()
	 * @generated
	 */
	void setIsPrimaryKey(boolean value);

	/**
	 * Returns the value of the '<em><b>Tipo</b></em>' attribute.
	 * The literals are from the enumeration {@link dataweb.TipoAtributo}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tipo</em>' attribute.
	 * @see dataweb.TipoAtributo
	 * @see #setTipo(TipoAtributo)
	 * @see dataweb.DatawebPackage#getAtributo_Tipo()
	 * @model required="true"
	 * @generated
	 */
	TipoAtributo getTipo();

	/**
	 * Sets the value of the '{@link dataweb.Atributo#getTipo <em>Tipo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tipo</em>' attribute.
	 * @see dataweb.TipoAtributo
	 * @see #getTipo()
	 * @generated
	 */
	void setTipo(TipoAtributo value);

} // Atributo
