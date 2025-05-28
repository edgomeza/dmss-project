/**
 */
package dataweb;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Referencia</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dataweb.Referencia#getNombre <em>Nombre</em>}</li>
 *   <li>{@link dataweb.Referencia#getMultiplicidad <em>Multiplicidad</em>}</li>
 *   <li>{@link dataweb.Referencia#getSource <em>Source</em>}</li>
 *   <li>{@link dataweb.Referencia#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see dataweb.DatawebPackage#getReferencia()
 * @model annotation="gmf.link label='nombre' source='source' target='target' target.decoration='arrow' color='100,100,100'"
 * @generated
 */
public interface Referencia extends EObject {
	/**
	 * Returns the value of the '<em><b>Nombre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nombre</em>' attribute.
	 * @see #setNombre(String)
	 * @see dataweb.DatawebPackage#getReferencia_Nombre()
	 * @model required="true"
	 * @generated
	 */
	String getNombre();

	/**
	 * Sets the value of the '{@link dataweb.Referencia#getNombre <em>Nombre</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nombre</em>' attribute.
	 * @see #getNombre()
	 * @generated
	 */
	void setNombre(String value);

	/**
	 * Returns the value of the '<em><b>Multiplicidad</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Multiplicidad</em>' attribute.
	 * @see #setMultiplicidad(String)
	 * @see dataweb.DatawebPackage#getReferencia_Multiplicidad()
	 * @model required="true"
	 * @generated
	 */
	String getMultiplicidad();

	/**
	 * Sets the value of the '{@link dataweb.Referencia#getMultiplicidad <em>Multiplicidad</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Multiplicidad</em>' attribute.
	 * @see #getMultiplicidad()
	 * @generated
	 */
	void setMultiplicidad(String value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(Entidad)
	 * @see dataweb.DatawebPackage#getReferencia_Source()
	 * @model required="true"
	 * @generated
	 */
	Entidad getSource();

	/**
	 * Sets the value of the '{@link dataweb.Referencia#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Entidad value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Entidad)
	 * @see dataweb.DatawebPackage#getReferencia_Target()
	 * @model required="true"
	 * @generated
	 */
	Entidad getTarget();

	/**
	 * Sets the value of the '{@link dataweb.Referencia#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Entidad value);

} // Referencia
