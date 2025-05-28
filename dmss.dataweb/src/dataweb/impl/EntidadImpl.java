/**
 */
package dataweb.impl;

import dataweb.Atributo;
import dataweb.DatawebPackage;
import dataweb.Entidad;
import dataweb.Referencia;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entidad</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dataweb.impl.EntidadImpl#getNombre <em>Nombre</em>}</li>
 *   <li>{@link dataweb.impl.EntidadImpl#getTableName <em>Table Name</em>}</li>
 *   <li>{@link dataweb.impl.EntidadImpl#isHasCRUD <em>Has CRUD</em>}</li>
 *   <li>{@link dataweb.impl.EntidadImpl#isHasIndex <em>Has Index</em>}</li>
 *   <li>{@link dataweb.impl.EntidadImpl#isHasExtendedIndex <em>Has Extended Index</em>}</li>
 *   <li>{@link dataweb.impl.EntidadImpl#isHasDetails <em>Has Details</em>}</li>
 *   <li>{@link dataweb.impl.EntidadImpl#isHasCreate <em>Has Create</em>}</li>
 *   <li>{@link dataweb.impl.EntidadImpl#isHasUpdate <em>Has Update</em>}</li>
 *   <li>{@link dataweb.impl.EntidadImpl#isHasDelete <em>Has Delete</em>}</li>
 *   <li>{@link dataweb.impl.EntidadImpl#getAtributos <em>Atributos</em>}</li>
 *   <li>{@link dataweb.impl.EntidadImpl#getReferencias <em>Referencias</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EntidadImpl extends EObjectImpl implements Entidad {
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
	 * The default value of the '{@link #getTableName() <em>Table Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTableName()
	 * @generated
	 * @ordered
	 */
	protected static final String TABLE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTableName() <em>Table Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTableName()
	 * @generated
	 * @ordered
	 */
	protected String tableName = TABLE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isHasCRUD() <em>Has CRUD</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasCRUD()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HAS_CRUD_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHasCRUD() <em>Has CRUD</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasCRUD()
	 * @generated
	 * @ordered
	 */
	protected boolean hasCRUD = HAS_CRUD_EDEFAULT;

	/**
	 * The default value of the '{@link #isHasIndex() <em>Has Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasIndex()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HAS_INDEX_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHasIndex() <em>Has Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasIndex()
	 * @generated
	 * @ordered
	 */
	protected boolean hasIndex = HAS_INDEX_EDEFAULT;

	/**
	 * The default value of the '{@link #isHasExtendedIndex() <em>Has Extended Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasExtendedIndex()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HAS_EXTENDED_INDEX_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHasExtendedIndex() <em>Has Extended Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasExtendedIndex()
	 * @generated
	 * @ordered
	 */
	protected boolean hasExtendedIndex = HAS_EXTENDED_INDEX_EDEFAULT;

	/**
	 * The default value of the '{@link #isHasDetails() <em>Has Details</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasDetails()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HAS_DETAILS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHasDetails() <em>Has Details</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasDetails()
	 * @generated
	 * @ordered
	 */
	protected boolean hasDetails = HAS_DETAILS_EDEFAULT;

	/**
	 * The default value of the '{@link #isHasCreate() <em>Has Create</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasCreate()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HAS_CREATE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHasCreate() <em>Has Create</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasCreate()
	 * @generated
	 * @ordered
	 */
	protected boolean hasCreate = HAS_CREATE_EDEFAULT;

	/**
	 * The default value of the '{@link #isHasUpdate() <em>Has Update</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasUpdate()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HAS_UPDATE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHasUpdate() <em>Has Update</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasUpdate()
	 * @generated
	 * @ordered
	 */
	protected boolean hasUpdate = HAS_UPDATE_EDEFAULT;

	/**
	 * The default value of the '{@link #isHasDelete() <em>Has Delete</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasDelete()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HAS_DELETE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHasDelete() <em>Has Delete</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasDelete()
	 * @generated
	 * @ordered
	 */
	protected boolean hasDelete = HAS_DELETE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAtributos() <em>Atributos</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtributos()
	 * @generated
	 * @ordered
	 */
	protected EList<Atributo> atributos;

	/**
	 * The cached value of the '{@link #getReferencias() <em>Referencias</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferencias()
	 * @generated
	 * @ordered
	 */
	protected EList<Referencia> referencias;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EntidadImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DatawebPackage.Literals.ENTIDAD;
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
			eNotify(new ENotificationImpl(this, Notification.SET, DatawebPackage.ENTIDAD__NOMBRE, oldNombre, nombre));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTableName() {
		return tableName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTableName(String newTableName) {
		String oldTableName = tableName;
		tableName = newTableName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatawebPackage.ENTIDAD__TABLE_NAME, oldTableName, tableName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isHasCRUD() {
		return hasCRUD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHasCRUD(boolean newHasCRUD) {
		boolean oldHasCRUD = hasCRUD;
		hasCRUD = newHasCRUD;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatawebPackage.ENTIDAD__HAS_CRUD, oldHasCRUD, hasCRUD));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isHasIndex() {
		return hasIndex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHasIndex(boolean newHasIndex) {
		boolean oldHasIndex = hasIndex;
		hasIndex = newHasIndex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatawebPackage.ENTIDAD__HAS_INDEX, oldHasIndex, hasIndex));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isHasExtendedIndex() {
		return hasExtendedIndex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHasExtendedIndex(boolean newHasExtendedIndex) {
		boolean oldHasExtendedIndex = hasExtendedIndex;
		hasExtendedIndex = newHasExtendedIndex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatawebPackage.ENTIDAD__HAS_EXTENDED_INDEX, oldHasExtendedIndex, hasExtendedIndex));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isHasDetails() {
		return hasDetails;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHasDetails(boolean newHasDetails) {
		boolean oldHasDetails = hasDetails;
		hasDetails = newHasDetails;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatawebPackage.ENTIDAD__HAS_DETAILS, oldHasDetails, hasDetails));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isHasCreate() {
		return hasCreate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHasCreate(boolean newHasCreate) {
		boolean oldHasCreate = hasCreate;
		hasCreate = newHasCreate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatawebPackage.ENTIDAD__HAS_CREATE, oldHasCreate, hasCreate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isHasUpdate() {
		return hasUpdate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHasUpdate(boolean newHasUpdate) {
		boolean oldHasUpdate = hasUpdate;
		hasUpdate = newHasUpdate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatawebPackage.ENTIDAD__HAS_UPDATE, oldHasUpdate, hasUpdate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isHasDelete() {
		return hasDelete;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHasDelete(boolean newHasDelete) {
		boolean oldHasDelete = hasDelete;
		hasDelete = newHasDelete;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatawebPackage.ENTIDAD__HAS_DELETE, oldHasDelete, hasDelete));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Atributo> getAtributos() {
		if (atributos == null) {
			atributos = new EObjectContainmentEList<Atributo>(Atributo.class, this, DatawebPackage.ENTIDAD__ATRIBUTOS);
		}
		return atributos;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Referencia> getReferencias() {
		if (referencias == null) {
			referencias = new EObjectContainmentEList<Referencia>(Referencia.class, this, DatawebPackage.ENTIDAD__REFERENCIAS);
		}
		return referencias;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DatawebPackage.ENTIDAD__ATRIBUTOS:
				return ((InternalEList<?>)getAtributos()).basicRemove(otherEnd, msgs);
			case DatawebPackage.ENTIDAD__REFERENCIAS:
				return ((InternalEList<?>)getReferencias()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DatawebPackage.ENTIDAD__NOMBRE:
				return getNombre();
			case DatawebPackage.ENTIDAD__TABLE_NAME:
				return getTableName();
			case DatawebPackage.ENTIDAD__HAS_CRUD:
				return isHasCRUD();
			case DatawebPackage.ENTIDAD__HAS_INDEX:
				return isHasIndex();
			case DatawebPackage.ENTIDAD__HAS_EXTENDED_INDEX:
				return isHasExtendedIndex();
			case DatawebPackage.ENTIDAD__HAS_DETAILS:
				return isHasDetails();
			case DatawebPackage.ENTIDAD__HAS_CREATE:
				return isHasCreate();
			case DatawebPackage.ENTIDAD__HAS_UPDATE:
				return isHasUpdate();
			case DatawebPackage.ENTIDAD__HAS_DELETE:
				return isHasDelete();
			case DatawebPackage.ENTIDAD__ATRIBUTOS:
				return getAtributos();
			case DatawebPackage.ENTIDAD__REFERENCIAS:
				return getReferencias();
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
			case DatawebPackage.ENTIDAD__NOMBRE:
				setNombre((String)newValue);
				return;
			case DatawebPackage.ENTIDAD__TABLE_NAME:
				setTableName((String)newValue);
				return;
			case DatawebPackage.ENTIDAD__HAS_CRUD:
				setHasCRUD((Boolean)newValue);
				return;
			case DatawebPackage.ENTIDAD__HAS_INDEX:
				setHasIndex((Boolean)newValue);
				return;
			case DatawebPackage.ENTIDAD__HAS_EXTENDED_INDEX:
				setHasExtendedIndex((Boolean)newValue);
				return;
			case DatawebPackage.ENTIDAD__HAS_DETAILS:
				setHasDetails((Boolean)newValue);
				return;
			case DatawebPackage.ENTIDAD__HAS_CREATE:
				setHasCreate((Boolean)newValue);
				return;
			case DatawebPackage.ENTIDAD__HAS_UPDATE:
				setHasUpdate((Boolean)newValue);
				return;
			case DatawebPackage.ENTIDAD__HAS_DELETE:
				setHasDelete((Boolean)newValue);
				return;
			case DatawebPackage.ENTIDAD__ATRIBUTOS:
				getAtributos().clear();
				getAtributos().addAll((Collection<? extends Atributo>)newValue);
				return;
			case DatawebPackage.ENTIDAD__REFERENCIAS:
				getReferencias().clear();
				getReferencias().addAll((Collection<? extends Referencia>)newValue);
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
			case DatawebPackage.ENTIDAD__NOMBRE:
				setNombre(NOMBRE_EDEFAULT);
				return;
			case DatawebPackage.ENTIDAD__TABLE_NAME:
				setTableName(TABLE_NAME_EDEFAULT);
				return;
			case DatawebPackage.ENTIDAD__HAS_CRUD:
				setHasCRUD(HAS_CRUD_EDEFAULT);
				return;
			case DatawebPackage.ENTIDAD__HAS_INDEX:
				setHasIndex(HAS_INDEX_EDEFAULT);
				return;
			case DatawebPackage.ENTIDAD__HAS_EXTENDED_INDEX:
				setHasExtendedIndex(HAS_EXTENDED_INDEX_EDEFAULT);
				return;
			case DatawebPackage.ENTIDAD__HAS_DETAILS:
				setHasDetails(HAS_DETAILS_EDEFAULT);
				return;
			case DatawebPackage.ENTIDAD__HAS_CREATE:
				setHasCreate(HAS_CREATE_EDEFAULT);
				return;
			case DatawebPackage.ENTIDAD__HAS_UPDATE:
				setHasUpdate(HAS_UPDATE_EDEFAULT);
				return;
			case DatawebPackage.ENTIDAD__HAS_DELETE:
				setHasDelete(HAS_DELETE_EDEFAULT);
				return;
			case DatawebPackage.ENTIDAD__ATRIBUTOS:
				getAtributos().clear();
				return;
			case DatawebPackage.ENTIDAD__REFERENCIAS:
				getReferencias().clear();
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
			case DatawebPackage.ENTIDAD__NOMBRE:
				return NOMBRE_EDEFAULT == null ? nombre != null : !NOMBRE_EDEFAULT.equals(nombre);
			case DatawebPackage.ENTIDAD__TABLE_NAME:
				return TABLE_NAME_EDEFAULT == null ? tableName != null : !TABLE_NAME_EDEFAULT.equals(tableName);
			case DatawebPackage.ENTIDAD__HAS_CRUD:
				return hasCRUD != HAS_CRUD_EDEFAULT;
			case DatawebPackage.ENTIDAD__HAS_INDEX:
				return hasIndex != HAS_INDEX_EDEFAULT;
			case DatawebPackage.ENTIDAD__HAS_EXTENDED_INDEX:
				return hasExtendedIndex != HAS_EXTENDED_INDEX_EDEFAULT;
			case DatawebPackage.ENTIDAD__HAS_DETAILS:
				return hasDetails != HAS_DETAILS_EDEFAULT;
			case DatawebPackage.ENTIDAD__HAS_CREATE:
				return hasCreate != HAS_CREATE_EDEFAULT;
			case DatawebPackage.ENTIDAD__HAS_UPDATE:
				return hasUpdate != HAS_UPDATE_EDEFAULT;
			case DatawebPackage.ENTIDAD__HAS_DELETE:
				return hasDelete != HAS_DELETE_EDEFAULT;
			case DatawebPackage.ENTIDAD__ATRIBUTOS:
				return atributos != null && !atributos.isEmpty();
			case DatawebPackage.ENTIDAD__REFERENCIAS:
				return referencias != null && !referencias.isEmpty();
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
		result.append(", tableName: ");
		result.append(tableName);
		result.append(", hasCRUD: ");
		result.append(hasCRUD);
		result.append(", hasIndex: ");
		result.append(hasIndex);
		result.append(", hasExtendedIndex: ");
		result.append(hasExtendedIndex);
		result.append(", hasDetails: ");
		result.append(hasDetails);
		result.append(", hasCreate: ");
		result.append(hasCreate);
		result.append(", hasUpdate: ");
		result.append(hasUpdate);
		result.append(", hasDelete: ");
		result.append(hasDelete);
		result.append(')');
		return result.toString();
	}

} //EntidadImpl
