/**
 */
package dataweb.impl;

import dataweb.DatawebPackage;
import dataweb.FuenteRSS;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fuente RSS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dataweb.impl.FuenteRSSImpl#getNombre <em>Nombre</em>}</li>
 *   <li>{@link dataweb.impl.FuenteRSSImpl#getUrl <em>Url</em>}</li>
 *   <li>{@link dataweb.impl.FuenteRSSImpl#getTitulo <em>Titulo</em>}</li>
 *   <li>{@link dataweb.impl.FuenteRSSImpl#getNumItems <em>Num Items</em>}</li>
 *   <li>{@link dataweb.impl.FuenteRSSImpl#isMostrarDescripcion <em>Mostrar Descripcion</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FuenteRSSImpl extends EObjectImpl implements FuenteRSS {
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
	 * The default value of the '{@link #getUrl() <em>Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUrl()
	 * @generated
	 * @ordered
	 */
	protected static final String URL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUrl() <em>Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUrl()
	 * @generated
	 * @ordered
	 */
	protected String url = URL_EDEFAULT;

	/**
	 * The default value of the '{@link #getTitulo() <em>Titulo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitulo()
	 * @generated
	 * @ordered
	 */
	protected static final String TITULO_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTitulo() <em>Titulo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitulo()
	 * @generated
	 * @ordered
	 */
	protected String titulo = TITULO_EDEFAULT;

	/**
	 * The default value of the '{@link #getNumItems() <em>Num Items</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumItems()
	 * @generated
	 * @ordered
	 */
	protected static final int NUM_ITEMS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNumItems() <em>Num Items</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumItems()
	 * @generated
	 * @ordered
	 */
	protected int numItems = NUM_ITEMS_EDEFAULT;

	/**
	 * The default value of the '{@link #isMostrarDescripcion() <em>Mostrar Descripcion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMostrarDescripcion()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MOSTRAR_DESCRIPCION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isMostrarDescripcion() <em>Mostrar Descripcion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMostrarDescripcion()
	 * @generated
	 * @ordered
	 */
	protected boolean mostrarDescripcion = MOSTRAR_DESCRIPCION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FuenteRSSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DatawebPackage.Literals.FUENTE_RSS;
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
			eNotify(new ENotificationImpl(this, Notification.SET, DatawebPackage.FUENTE_RSS__NOMBRE, oldNombre, nombre));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getUrl() {
		return url;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUrl(String newUrl) {
		String oldUrl = url;
		url = newUrl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatawebPackage.FUENTE_RSS__URL, oldUrl, url));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTitulo() {
		return titulo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTitulo(String newTitulo) {
		String oldTitulo = titulo;
		titulo = newTitulo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatawebPackage.FUENTE_RSS__TITULO, oldTitulo, titulo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getNumItems() {
		return numItems;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNumItems(int newNumItems) {
		int oldNumItems = numItems;
		numItems = newNumItems;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatawebPackage.FUENTE_RSS__NUM_ITEMS, oldNumItems, numItems));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isMostrarDescripcion() {
		return mostrarDescripcion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMostrarDescripcion(boolean newMostrarDescripcion) {
		boolean oldMostrarDescripcion = mostrarDescripcion;
		mostrarDescripcion = newMostrarDescripcion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatawebPackage.FUENTE_RSS__MOSTRAR_DESCRIPCION, oldMostrarDescripcion, mostrarDescripcion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DatawebPackage.FUENTE_RSS__NOMBRE:
				return getNombre();
			case DatawebPackage.FUENTE_RSS__URL:
				return getUrl();
			case DatawebPackage.FUENTE_RSS__TITULO:
				return getTitulo();
			case DatawebPackage.FUENTE_RSS__NUM_ITEMS:
				return getNumItems();
			case DatawebPackage.FUENTE_RSS__MOSTRAR_DESCRIPCION:
				return isMostrarDescripcion();
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
			case DatawebPackage.FUENTE_RSS__NOMBRE:
				setNombre((String)newValue);
				return;
			case DatawebPackage.FUENTE_RSS__URL:
				setUrl((String)newValue);
				return;
			case DatawebPackage.FUENTE_RSS__TITULO:
				setTitulo((String)newValue);
				return;
			case DatawebPackage.FUENTE_RSS__NUM_ITEMS:
				setNumItems((Integer)newValue);
				return;
			case DatawebPackage.FUENTE_RSS__MOSTRAR_DESCRIPCION:
				setMostrarDescripcion((Boolean)newValue);
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
			case DatawebPackage.FUENTE_RSS__NOMBRE:
				setNombre(NOMBRE_EDEFAULT);
				return;
			case DatawebPackage.FUENTE_RSS__URL:
				setUrl(URL_EDEFAULT);
				return;
			case DatawebPackage.FUENTE_RSS__TITULO:
				setTitulo(TITULO_EDEFAULT);
				return;
			case DatawebPackage.FUENTE_RSS__NUM_ITEMS:
				setNumItems(NUM_ITEMS_EDEFAULT);
				return;
			case DatawebPackage.FUENTE_RSS__MOSTRAR_DESCRIPCION:
				setMostrarDescripcion(MOSTRAR_DESCRIPCION_EDEFAULT);
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
			case DatawebPackage.FUENTE_RSS__NOMBRE:
				return NOMBRE_EDEFAULT == null ? nombre != null : !NOMBRE_EDEFAULT.equals(nombre);
			case DatawebPackage.FUENTE_RSS__URL:
				return URL_EDEFAULT == null ? url != null : !URL_EDEFAULT.equals(url);
			case DatawebPackage.FUENTE_RSS__TITULO:
				return TITULO_EDEFAULT == null ? titulo != null : !TITULO_EDEFAULT.equals(titulo);
			case DatawebPackage.FUENTE_RSS__NUM_ITEMS:
				return numItems != NUM_ITEMS_EDEFAULT;
			case DatawebPackage.FUENTE_RSS__MOSTRAR_DESCRIPCION:
				return mostrarDescripcion != MOSTRAR_DESCRIPCION_EDEFAULT;
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
		result.append(", url: ");
		result.append(url);
		result.append(", titulo: ");
		result.append(titulo);
		result.append(", numItems: ");
		result.append(numItems);
		result.append(", mostrarDescripcion: ");
		result.append(mostrarDescripcion);
		result.append(')');
		return result.toString();
	}

} //FuenteRSSImpl
