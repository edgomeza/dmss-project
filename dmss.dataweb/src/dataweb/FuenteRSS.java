/**
 */
package dataweb;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fuente RSS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dataweb.FuenteRSS#getNombre <em>Nombre</em>}</li>
 *   <li>{@link dataweb.FuenteRSS#getUrl <em>Url</em>}</li>
 *   <li>{@link dataweb.FuenteRSS#getTitulo <em>Titulo</em>}</li>
 *   <li>{@link dataweb.FuenteRSS#getNumItems <em>Num Items</em>}</li>
 *   <li>{@link dataweb.FuenteRSS#isMostrarDescripcion <em>Mostrar Descripcion</em>}</li>
 * </ul>
 *
 * @see dataweb.DatawebPackage#getFuenteRSS()
 * @model annotation="gmf.node label='nombre' color='0,255,255'"
 * @generated
 */
public interface FuenteRSS extends EObject {
	/**
	 * Returns the value of the '<em><b>Nombre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nombre</em>' attribute.
	 * @see #setNombre(String)
	 * @see dataweb.DatawebPackage#getFuenteRSS_Nombre()
	 * @model required="true"
	 * @generated
	 */
	String getNombre();

	/**
	 * Sets the value of the '{@link dataweb.FuenteRSS#getNombre <em>Nombre</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nombre</em>' attribute.
	 * @see #getNombre()
	 * @generated
	 */
	void setNombre(String value);

	/**
	 * Returns the value of the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Url</em>' attribute.
	 * @see #setUrl(String)
	 * @see dataweb.DatawebPackage#getFuenteRSS_Url()
	 * @model required="true"
	 * @generated
	 */
	String getUrl();

	/**
	 * Sets the value of the '{@link dataweb.FuenteRSS#getUrl <em>Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Url</em>' attribute.
	 * @see #getUrl()
	 * @generated
	 */
	void setUrl(String value);

	/**
	 * Returns the value of the '<em><b>Titulo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Titulo</em>' attribute.
	 * @see #setTitulo(String)
	 * @see dataweb.DatawebPackage#getFuenteRSS_Titulo()
	 * @model required="true"
	 * @generated
	 */
	String getTitulo();

	/**
	 * Sets the value of the '{@link dataweb.FuenteRSS#getTitulo <em>Titulo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Titulo</em>' attribute.
	 * @see #getTitulo()
	 * @generated
	 */
	void setTitulo(String value);

	/**
	 * Returns the value of the '<em><b>Num Items</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Num Items</em>' attribute.
	 * @see #setNumItems(int)
	 * @see dataweb.DatawebPackage#getFuenteRSS_NumItems()
	 * @model required="true"
	 * @generated
	 */
	int getNumItems();

	/**
	 * Sets the value of the '{@link dataweb.FuenteRSS#getNumItems <em>Num Items</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Num Items</em>' attribute.
	 * @see #getNumItems()
	 * @generated
	 */
	void setNumItems(int value);

	/**
	 * Returns the value of the '<em><b>Mostrar Descripcion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mostrar Descripcion</em>' attribute.
	 * @see #setMostrarDescripcion(boolean)
	 * @see dataweb.DatawebPackage#getFuenteRSS_MostrarDescripcion()
	 * @model required="true"
	 * @generated
	 */
	boolean isMostrarDescripcion();

	/**
	 * Sets the value of the '{@link dataweb.FuenteRSS#isMostrarDescripcion <em>Mostrar Descripcion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mostrar Descripcion</em>' attribute.
	 * @see #isMostrarDescripcion()
	 * @generated
	 */
	void setMostrarDescripcion(boolean value);

} // FuenteRSS
