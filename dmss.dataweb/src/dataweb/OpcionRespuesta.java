/**
 */
package dataweb;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Opcion Respuesta</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dataweb.OpcionRespuesta#getNombre <em>Nombre</em>}</li>
 *   <li>{@link dataweb.OpcionRespuesta#getTexto <em>Texto</em>}</li>
 *   <li>{@link dataweb.OpcionRespuesta#getValor <em>Valor</em>}</li>
 * </ul>
 *
 * @see dataweb.DatawebPackage#getOpcionRespuesta()
 * @model annotation="gmf.node label='nombre' color='220,255,220'"
 * @generated
 */
public interface OpcionRespuesta extends EObject {
	/**
	 * Returns the value of the '<em><b>Nombre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nombre</em>' attribute.
	 * @see #setNombre(String)
	 * @see dataweb.DatawebPackage#getOpcionRespuesta_Nombre()
	 * @model required="true"
	 * @generated
	 */
	String getNombre();

	/**
	 * Sets the value of the '{@link dataweb.OpcionRespuesta#getNombre <em>Nombre</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nombre</em>' attribute.
	 * @see #getNombre()
	 * @generated
	 */
	void setNombre(String value);

	/**
	 * Returns the value of the '<em><b>Texto</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Texto</em>' attribute.
	 * @see #setTexto(String)
	 * @see dataweb.DatawebPackage#getOpcionRespuesta_Texto()
	 * @model required="true"
	 * @generated
	 */
	String getTexto();

	/**
	 * Sets the value of the '{@link dataweb.OpcionRespuesta#getTexto <em>Texto</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Texto</em>' attribute.
	 * @see #getTexto()
	 * @generated
	 */
	void setTexto(String value);

	/**
	 * Returns the value of the '<em><b>Valor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Valor</em>' attribute.
	 * @see #setValor(String)
	 * @see dataweb.DatawebPackage#getOpcionRespuesta_Valor()
	 * @model required="true"
	 * @generated
	 */
	String getValor();

	/**
	 * Sets the value of the '{@link dataweb.OpcionRespuesta#getValor <em>Valor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Valor</em>' attribute.
	 * @see #getValor()
	 * @generated
	 */
	void setValor(String value);

} // OpcionRespuesta
