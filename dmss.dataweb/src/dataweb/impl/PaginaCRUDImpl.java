/**
 */
package dataweb.impl;

import dataweb.DatawebPackage;
import dataweb.Entidad;
import dataweb.PaginaCRUD;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pagina CRUD</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dataweb.impl.PaginaCRUDImpl#getEntidad <em>Entidad</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class PaginaCRUDImpl extends PaginaImpl implements PaginaCRUD {
	/**
	 * The cached value of the '{@link #getEntidad() <em>Entidad</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntidad()
	 * @generated
	 * @ordered
	 */
	protected Entidad entidad;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PaginaCRUDImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DatawebPackage.Literals.PAGINA_CRUD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Entidad getEntidad() {
		if (entidad != null && entidad.eIsProxy()) {
			InternalEObject oldEntidad = (InternalEObject)entidad;
			entidad = (Entidad)eResolveProxy(oldEntidad);
			if (entidad != oldEntidad) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DatawebPackage.PAGINA_CRUD__ENTIDAD, oldEntidad, entidad));
			}
		}
		return entidad;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entidad basicGetEntidad() {
		return entidad;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEntidad(Entidad newEntidad) {
		Entidad oldEntidad = entidad;
		entidad = newEntidad;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatawebPackage.PAGINA_CRUD__ENTIDAD, oldEntidad, entidad));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DatawebPackage.PAGINA_CRUD__ENTIDAD:
				if (resolve) return getEntidad();
				return basicGetEntidad();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DatawebPackage.PAGINA_CRUD__ENTIDAD:
				setEntidad((Entidad)newValue);
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
			case DatawebPackage.PAGINA_CRUD__ENTIDAD:
				setEntidad((Entidad)null);
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
			case DatawebPackage.PAGINA_CRUD__ENTIDAD:
				return entidad != null;
		}
		return super.eIsSet(featureID);
	}

} //PaginaCRUDImpl
