/**
 */
package dataweb.impl;

import dataweb.DatawebPackage;
import dataweb.Pagina;
import dataweb.Rol;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rol</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dataweb.impl.RolImpl#getNombre <em>Nombre</em>}</li>
 *   <li>{@link dataweb.impl.RolImpl#getDescripcion <em>Descripcion</em>}</li>
 *   <li>{@link dataweb.impl.RolImpl#getPaginasAccesibles <em>Paginas Accesibles</em>}</li>
 *   <li>{@link dataweb.impl.RolImpl#getNumeroEntidadesAccesibles <em>Numero Entidades Accesibles</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RolImpl extends EObjectImpl implements Rol {
	/**
	 * The default value of the '{@link #getNombre() <em>Nombre</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNombre()
	 * @generated
	 * @ordered
	 */
	protected static final String NOMBRE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNombre() <em>Nombre</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNombre()
	 * @generated
	 * @ordered
	 */
	protected String nombre = NOMBRE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescripcion() <em>Descripcion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescripcion()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPCION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescripcion() <em>Descripcion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescripcion()
	 * @generated
	 * @ordered
	 */
	protected String descripcion = DESCRIPCION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPaginasAccesibles() <em>Paginas Accesibles</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPaginasAccesibles()
	 * @generated
	 * @ordered
	 */
	protected EList<Pagina> paginasAccesibles;

	/**
	 * The default value of the '{@link #getNumeroEntidadesAccesibles() <em>Numero Entidades Accesibles</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumeroEntidadesAccesibles()
	 * @generated
	 * @ordered
	 */
	protected static final int NUMERO_ENTIDADES_ACCESIBLES_EDEFAULT = 0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RolImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DatawebPackage.Literals.ROL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getNombre() {
		return nombre;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNombre(String newNombre) {
		String oldNombre = nombre;
		nombre = newNombre;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatawebPackage.ROL__NOMBRE, oldNombre, nombre));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescripcion(String newDescripcion) {
		String oldDescripcion = descripcion;
		descripcion = newDescripcion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatawebPackage.ROL__DESCRIPCION, oldDescripcion, descripcion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Pagina> getPaginasAccesibles() {
		if (paginasAccesibles == null) {
			paginasAccesibles = new EObjectResolvingEList<Pagina>(Pagina.class, this, DatawebPackage.ROL__PAGINAS_ACCESIBLES);
		}
		return paginasAccesibles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getNumeroEntidadesAccesibles() {
		// TODO: implement this method to return the 'Numero Entidades Accesibles' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNumeroEntidadesAccesibles(int newNumeroEntidadesAccesibles) {
		// TODO: implement this method to set the 'Numero Entidades Accesibles' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DatawebPackage.ROL__NOMBRE:
				return getNombre();
			case DatawebPackage.ROL__DESCRIPCION:
				return getDescripcion();
			case DatawebPackage.ROL__PAGINAS_ACCESIBLES:
				return getPaginasAccesibles();
			case DatawebPackage.ROL__NUMERO_ENTIDADES_ACCESIBLES:
				return getNumeroEntidadesAccesibles();
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
			case DatawebPackage.ROL__NOMBRE:
				setNombre((String)newValue);
				return;
			case DatawebPackage.ROL__DESCRIPCION:
				setDescripcion((String)newValue);
				return;
			case DatawebPackage.ROL__PAGINAS_ACCESIBLES:
				getPaginasAccesibles().clear();
				getPaginasAccesibles().addAll((Collection<? extends Pagina>)newValue);
				return;
			case DatawebPackage.ROL__NUMERO_ENTIDADES_ACCESIBLES:
				setNumeroEntidadesAccesibles((Integer)newValue);
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
			case DatawebPackage.ROL__NOMBRE:
				setNombre(NOMBRE_EDEFAULT);
				return;
			case DatawebPackage.ROL__DESCRIPCION:
				setDescripcion(DESCRIPCION_EDEFAULT);
				return;
			case DatawebPackage.ROL__PAGINAS_ACCESIBLES:
				getPaginasAccesibles().clear();
				return;
			case DatawebPackage.ROL__NUMERO_ENTIDADES_ACCESIBLES:
				setNumeroEntidadesAccesibles(NUMERO_ENTIDADES_ACCESIBLES_EDEFAULT);
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
			case DatawebPackage.ROL__NOMBRE:
				return NOMBRE_EDEFAULT == null ? nombre != null : !NOMBRE_EDEFAULT.equals(nombre);
			case DatawebPackage.ROL__DESCRIPCION:
				return DESCRIPCION_EDEFAULT == null ? descripcion != null : !DESCRIPCION_EDEFAULT.equals(descripcion);
			case DatawebPackage.ROL__PAGINAS_ACCESIBLES:
				return paginasAccesibles != null && !paginasAccesibles.isEmpty();
			case DatawebPackage.ROL__NUMERO_ENTIDADES_ACCESIBLES:
				return getNumeroEntidadesAccesibles() != NUMERO_ENTIDADES_ACCESIBLES_EDEFAULT;
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
		result.append(" (nombre: ");
		result.append(nombre);
		result.append(", descripcion: ");
		result.append(descripcion);
		result.append(')');
		return result.toString();
	}

} //RolImpl
