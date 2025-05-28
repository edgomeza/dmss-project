/**
 */
package dataweb.impl;

import dataweb.Atributo;
import dataweb.DatawebPackage;
import dataweb.PaginaIndice;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pagina Indice</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dataweb.impl.PaginaIndiceImpl#getAtributosMostrados <em>Atributos Mostrados</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class PaginaIndiceImpl extends PaginaCRUDImpl implements PaginaIndice {
	/**
	 * The cached value of the '{@link #getAtributosMostrados() <em>Atributos Mostrados</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtributosMostrados()
	 * @generated
	 * @ordered
	 */
	protected EList<Atributo> atributosMostrados;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PaginaIndiceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DatawebPackage.Literals.PAGINA_INDICE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Atributo> getAtributosMostrados() {
		if (atributosMostrados == null) {
			atributosMostrados = new EObjectResolvingEList<Atributo>(Atributo.class, this, DatawebPackage.PAGINA_INDICE__ATRIBUTOS_MOSTRADOS);
		}
		return atributosMostrados;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DatawebPackage.PAGINA_INDICE__ATRIBUTOS_MOSTRADOS:
				return getAtributosMostrados();
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
			case DatawebPackage.PAGINA_INDICE__ATRIBUTOS_MOSTRADOS:
				getAtributosMostrados().clear();
				getAtributosMostrados().addAll((Collection<? extends Atributo>)newValue);
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
			case DatawebPackage.PAGINA_INDICE__ATRIBUTOS_MOSTRADOS:
				getAtributosMostrados().clear();
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
			case DatawebPackage.PAGINA_INDICE__ATRIBUTOS_MOSTRADOS:
				return atributosMostrados != null && !atributosMostrados.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PaginaIndiceImpl
