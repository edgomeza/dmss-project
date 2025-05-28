/**
 */
package dataweb;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pagina Indice</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dataweb.PaginaIndice#getAtributosMostrados <em>Atributos Mostrados</em>}</li>
 * </ul>
 *
 * @see dataweb.DatawebPackage#getPaginaIndice()
 * @model abstract="true"
 *        annotation="gmf.node label='nombre' color='255,200,150'"
 * @generated
 */
public interface PaginaIndice extends PaginaCRUD {
	/**
	 * Returns the value of the '<em><b>Atributos Mostrados</b></em>' reference list.
	 * The list contents are of type {@link dataweb.Atributo}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Atributos Mostrados</em>' reference list.
	 * @see dataweb.DatawebPackage#getPaginaIndice_AtributosMostrados()
	 * @model required="true"
	 *        annotation="gmf.link target.decoration='arrow' color='200,100,0'"
	 * @generated
	 */
	EList<Atributo> getAtributosMostrados();

} // PaginaIndice
