/**
 */
package dataweb;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Red Social</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dataweb.RedSocial#getTipo <em>Tipo</em>}</li>
 *   <li>{@link dataweb.RedSocial#getNombre <em>Nombre</em>}</li>
 *   <li>{@link dataweb.RedSocial#getCodigoEmbed <em>Codigo Embed</em>}</li>
 *   <li>{@link dataweb.RedSocial#getNombreCuenta <em>Nombre Cuenta</em>}</li>
 * </ul>
 *
 * @see dataweb.DatawebPackage#getRedSocial()
 * @model annotation="gmf.node label='nombre' color='255,150,0'"
 * @generated
 */
public interface RedSocial extends EObject {
	/**
	 * Returns the value of the '<em><b>Tipo</b></em>' attribute.
	 * The literals are from the enumeration {@link dataweb.TipoRedSocial}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tipo</em>' attribute.
	 * @see dataweb.TipoRedSocial
	 * @see #setTipo(TipoRedSocial)
	 * @see dataweb.DatawebPackage#getRedSocial_Tipo()
	 * @model required="true"
	 * @generated
	 */
	TipoRedSocial getTipo();

	/**
	 * Sets the value of the '{@link dataweb.RedSocial#getTipo <em>Tipo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tipo</em>' attribute.
	 * @see dataweb.TipoRedSocial
	 * @see #getTipo()
	 * @generated
	 */
	void setTipo(TipoRedSocial value);

	/**
	 * Returns the value of the '<em><b>Nombre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nombre</em>' attribute.
	 * @see #setNombre(String)
	 * @see dataweb.DatawebPackage#getRedSocial_Nombre()
	 * @model id="true" required="true"
	 * @generated
	 */
	String getNombre();

	/**
	 * Sets the value of the '{@link dataweb.RedSocial#getNombre <em>Nombre</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nombre</em>' attribute.
	 * @see #getNombre()
	 * @generated
	 */
	void setNombre(String value);

	/**
	 * Returns the value of the '<em><b>Codigo Embed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Codigo Embed</em>' attribute.
	 * @see #setCodigoEmbed(String)
	 * @see dataweb.DatawebPackage#getRedSocial_CodigoEmbed()
	 * @model required="true"
	 * @generated
	 */
	String getCodigoEmbed();

	/**
	 * Sets the value of the '{@link dataweb.RedSocial#getCodigoEmbed <em>Codigo Embed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Codigo Embed</em>' attribute.
	 * @see #getCodigoEmbed()
	 * @generated
	 */
	void setCodigoEmbed(String value);

	/**
	 * Returns the value of the '<em><b>Nombre Cuenta</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nombre Cuenta</em>' attribute.
	 * @see #setNombreCuenta(String)
	 * @see dataweb.DatawebPackage#getRedSocial_NombreCuenta()
	 * @model required="true"
	 * @generated
	 */
	String getNombreCuenta();

	/**
	 * Sets the value of the '{@link dataweb.RedSocial#getNombreCuenta <em>Nombre Cuenta</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nombre Cuenta</em>' attribute.
	 * @see #getNombreCuenta()
	 * @generated
	 */
	void setNombreCuenta(String value);

} // RedSocial
