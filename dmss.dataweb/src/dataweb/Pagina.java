/**
 */
package dataweb;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pagina</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dataweb.Pagina#getEnlaces <em>Enlaces</em>}</li>
 *   <li>{@link dataweb.Pagina#getRedesSociales <em>Redes Sociales</em>}</li>
 *   <li>{@link dataweb.Pagina#getFuentesRSS <em>Fuentes RSS</em>}</li>
 *   <li>{@link dataweb.Pagina#getNombre <em>Nombre</em>}</li>
 *   <li>{@link dataweb.Pagina#getTitulo <em>Titulo</em>}</li>
 *   <li>{@link dataweb.Pagina#getDescripcion <em>Descripcion</em>}</li>
 * </ul>
 *
 * @see dataweb.DatawebPackage#getPagina()
 * @model abstract="true"
 *        annotation="gmf.node label='nombre' color='150,255,150'"
 * @generated
 */
public interface Pagina extends EObject {
	/**
	 * Returns the value of the '<em><b>Enlaces</b></em>' reference list.
	 * The list contents are of type {@link dataweb.Pagina}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enlaces</em>' reference list.
	 * @see dataweb.DatawebPackage#getPagina_Enlaces()
	 * @model annotation="gmf.link target.decoration='arrow' color='0,150,0'"
	 * @generated
	 */
	EList<Pagina> getEnlaces();

	/**
	 * Returns the value of the '<em><b>Redes Sociales</b></em>' reference list.
	 * The list contents are of type {@link dataweb.RedSocial}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Redes Sociales</em>' reference list.
	 * @see dataweb.DatawebPackage#getPagina_RedesSociales()
	 * @model annotation="gmf.link target.decoration='arrow' color='255,100,0'"
	 * @generated
	 */
	EList<RedSocial> getRedesSociales();

	/**
	 * Returns the value of the '<em><b>Fuentes RSS</b></em>' reference list.
	 * The list contents are of type {@link dataweb.FuenteRSS}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fuentes RSS</em>' reference list.
	 * @see dataweb.DatawebPackage#getPagina_FuentesRSS()
	 * @model annotation="gmf.link target.decoration='arrow' color='0,100,255'"
	 * @generated
	 */
	EList<FuenteRSS> getFuentesRSS();

	/**
	 * Returns the value of the '<em><b>Nombre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nombre</em>' attribute.
	 * @see #setNombre(String)
	 * @see dataweb.DatawebPackage#getPagina_Nombre()
	 * @model required="true"
	 * @generated
	 */
	String getNombre();

	/**
	 * Sets the value of the '{@link dataweb.Pagina#getNombre <em>Nombre</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nombre</em>' attribute.
	 * @see #getNombre()
	 * @generated
	 */
	void setNombre(String value);

	/**
	 * Returns the value of the '<em><b>Titulo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Titulo</em>' attribute.
	 * @see #setTitulo(String)
	 * @see dataweb.DatawebPackage#getPagina_Titulo()
	 * @model required="true"
	 * @generated
	 */
	String getTitulo();

	/**
	 * Sets the value of the '{@link dataweb.Pagina#getTitulo <em>Titulo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Titulo</em>' attribute.
	 * @see #getTitulo()
	 * @generated
	 */
	void setTitulo(String value);

	/**
	 * Returns the value of the '<em><b>Descripcion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Descripcion</em>' attribute.
	 * @see #setDescripcion(String)
	 * @see dataweb.DatawebPackage#getPagina_Descripcion()
	 * @model
	 * @generated
	 */
	String getDescripcion();

	/**
	 * Sets the value of the '{@link dataweb.Pagina#getDescripcion <em>Descripcion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Descripcion</em>' attribute.
	 * @see #getDescripcion()
	 * @generated
	 */
	void setDescripcion(String value);

} // Pagina
