/**
 */
package dataweb;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rol</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dataweb.Rol#getNombre <em>Nombre</em>}</li>
 *   <li>{@link dataweb.Rol#getDescripcion <em>Descripcion</em>}</li>
 *   <li>{@link dataweb.Rol#getPaginasAccesibles <em>Paginas Accesibles</em>}</li>
 *   <li>{@link dataweb.Rol#getNumeroEntidadesAccesibles <em>Numero Entidades Accesibles</em>}</li>
 * </ul>
 *
 * @see dataweb.DatawebPackage#getRol()
 * @model annotation="gmf.node label='nombre' color='100,100,255'"
 * @generated
 */
public interface Rol extends EObject {
	/**
	 * Returns the value of the '<em><b>Nombre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nombre</em>' attribute.
	 * @see #setNombre(String)
	 * @see dataweb.DatawebPackage#getRol_Nombre()
	 * @model required="true"
	 * @generated
	 */
	String getNombre();

	/**
	 * Sets the value of the '{@link dataweb.Rol#getNombre <em>Nombre</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nombre</em>' attribute.
	 * @see #getNombre()
	 * @generated
	 */
	void setNombre(String value);

	/**
	 * Returns the value of the '<em><b>Descripcion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Descripcion</em>' attribute.
	 * @see #setDescripcion(String)
	 * @see dataweb.DatawebPackage#getRol_Descripcion()
	 * @model
	 * @generated
	 */
	String getDescripcion();

	/**
	 * Sets the value of the '{@link dataweb.Rol#getDescripcion <em>Descripcion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Descripcion</em>' attribute.
	 * @see #getDescripcion()
	 * @generated
	 */
	void setDescripcion(String value);

	/**
	 * Returns the value of the '<em><b>Paginas Accesibles</b></em>' reference list.
	 * The list contents are of type {@link dataweb.Pagina}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Paginas Accesibles</em>' reference list.
	 * @see dataweb.DatawebPackage#getRol_PaginasAccesibles()
	 * @model required="true"
	 *        annotation="gmf.link target.decoration='arrow' color='0,0,200'"
	 * @generated
	 */
	EList<Pagina> getPaginasAccesibles();

	/**
	 * Returns the value of the '<em><b>Numero Entidades Accesibles</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Numero Entidades Accesibles</em>' attribute.
	 * @see #setNumeroEntidadesAccesibles(int)
	 * @see dataweb.DatawebPackage#getRol_NumeroEntidadesAccesibles()
	 * @model required="true" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	int getNumeroEntidadesAccesibles();

	/**
	 * Sets the value of the '{@link dataweb.Rol#getNumeroEntidadesAccesibles <em>Numero Entidades Accesibles</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Numero Entidades Accesibles</em>' attribute.
	 * @see #getNumeroEntidadesAccesibles()
	 * @generated
	 */
	void setNumeroEntidadesAccesibles(int value);

} // Rol
