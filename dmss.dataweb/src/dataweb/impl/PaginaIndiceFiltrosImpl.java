/**
 */
package dataweb.impl;

import dataweb.Atributo;
import dataweb.DatawebPackage;
import dataweb.PaginaIndiceFiltros;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pagina Indice Filtros</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dataweb.impl.PaginaIndiceFiltrosImpl#getAtributosFiltro <em>Atributos Filtro</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PaginaIndiceFiltrosImpl extends PaginaIndiceImpl implements PaginaIndiceFiltros {
	/**
	 * The cached value of the '{@link #getAtributosFiltro() <em>Atributos Filtro</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtributosFiltro()
	 * @generated
	 * @ordered
	 */
	protected EList<Atributo> atributosFiltro;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PaginaIndiceFiltrosImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DatawebPackage.Literals.PAGINA_INDICE_FILTROS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Atributo> getAtributosFiltro() {
		if (atributosFiltro == null) {
			atributosFiltro = new EObjectResolvingEList<Atributo>(Atributo.class, this, DatawebPackage.PAGINA_INDICE_FILTROS__ATRIBUTOS_FILTRO);
		}
		return atributosFiltro;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DatawebPackage.PAGINA_INDICE_FILTROS__ATRIBUTOS_FILTRO:
				return getAtributosFiltro();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DatawebPackage.PAGINA_INDICE_FILTROS__ATRIBUTOS_FILTRO:
				getAtributosFiltro().clear();
				getAtributosFiltro().addAll((Collection<? extends Atributo>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case DatawebPackage.PAGINA_INDICE_FILTROS__ATRIBUTOS_FILTRO:
				getAtributosFiltro().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case DatawebPackage.PAGINA_INDICE_FILTROS__ATRIBUTOS_FILTRO:
				return atributosFiltro != null && !atributosFiltro.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PaginaIndiceFiltrosImpl
