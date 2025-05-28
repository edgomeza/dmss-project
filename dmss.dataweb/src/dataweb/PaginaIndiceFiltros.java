/**
 */
package dataweb;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pagina Indice Filtros</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dataweb.PaginaIndiceFiltros#getAtributosFiltro <em>Atributos Filtro</em>}</li>
 * </ul>
 *
 * @see dataweb.DatawebPackage#getPaginaIndiceFiltros()
 * @model annotation="gmf.node label='nombre' color='180,255,120'"
 * @generated
 */
public interface PaginaIndiceFiltros extends PaginaIndice {
	/**
	 * Returns the value of the '<em><b>Atributos Filtro</b></em>' reference list.
	 * The list contents are of type {@link dataweb.Atributo}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Atributos Filtro</em>' reference list.
	 * @see dataweb.DatawebPackage#getPaginaIndiceFiltros_AtributosFiltro()
	 * @model annotation="gmf.link target.decoration='arrow' color='100,200,0'"
	 * @generated
	 */
	EList<Atributo> getAtributosFiltro();

} // PaginaIndiceFiltros
