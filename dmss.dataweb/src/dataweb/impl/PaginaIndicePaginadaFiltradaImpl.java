/**
 */
package dataweb.impl;

import dataweb.Atributo;
import dataweb.DatawebPackage;
import dataweb.PaginaIndicePaginadaFiltrada;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pagina Indice Paginada Filtrada</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dataweb.impl.PaginaIndicePaginadaFiltradaImpl#getPageSize <em>Page Size</em>}</li>
 *   <li>{@link dataweb.impl.PaginaIndicePaginadaFiltradaImpl#getAtributosFiltro <em>Atributos Filtro</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PaginaIndicePaginadaFiltradaImpl extends PaginaIndiceImpl implements PaginaIndicePaginadaFiltrada {
	/**
	 * The default value of the '{@link #getPageSize() <em>Page Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPageSize()
	 * @generated
	 * @ordered
	 */
	protected static final int PAGE_SIZE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getPageSize() <em>Page Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPageSize()
	 * @generated
	 * @ordered
	 */
	protected int pageSize = PAGE_SIZE_EDEFAULT;

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
	protected PaginaIndicePaginadaFiltradaImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DatawebPackage.Literals.PAGINA_INDICE_PAGINADA_FILTRADA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPageSize(int newPageSize) {
		int oldPageSize = pageSize;
		pageSize = newPageSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatawebPackage.PAGINA_INDICE_PAGINADA_FILTRADA__PAGE_SIZE, oldPageSize, pageSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Atributo> getAtributosFiltro() {
		if (atributosFiltro == null) {
			atributosFiltro = new EObjectResolvingEList<Atributo>(Atributo.class, this, DatawebPackage.PAGINA_INDICE_PAGINADA_FILTRADA__ATRIBUTOS_FILTRO);
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
			case DatawebPackage.PAGINA_INDICE_PAGINADA_FILTRADA__PAGE_SIZE:
				return getPageSize();
			case DatawebPackage.PAGINA_INDICE_PAGINADA_FILTRADA__ATRIBUTOS_FILTRO:
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
			case DatawebPackage.PAGINA_INDICE_PAGINADA_FILTRADA__PAGE_SIZE:
				setPageSize((Integer)newValue);
				return;
			case DatawebPackage.PAGINA_INDICE_PAGINADA_FILTRADA__ATRIBUTOS_FILTRO:
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
			case DatawebPackage.PAGINA_INDICE_PAGINADA_FILTRADA__PAGE_SIZE:
				setPageSize(PAGE_SIZE_EDEFAULT);
				return;
			case DatawebPackage.PAGINA_INDICE_PAGINADA_FILTRADA__ATRIBUTOS_FILTRO:
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
			case DatawebPackage.PAGINA_INDICE_PAGINADA_FILTRADA__PAGE_SIZE:
				return pageSize != PAGE_SIZE_EDEFAULT;
			case DatawebPackage.PAGINA_INDICE_PAGINADA_FILTRADA__ATRIBUTOS_FILTRO:
				return atributosFiltro != null && !atributosFiltro.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (pageSize: ");
		result.append(pageSize);
		result.append(')');
		return result.toString();
	}

} //PaginaIndicePaginadaFiltradaImpl
