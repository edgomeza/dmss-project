/**
 */
package dataweb.impl;

import dataweb.DatawebPackage;
import dataweb.FuenteRSS;
import dataweb.Pagina;
import dataweb.RedSocial;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pagina</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dataweb.impl.PaginaImpl#getEnlaces <em>Enlaces</em>}</li>
 *   <li>{@link dataweb.impl.PaginaImpl#getRedesSociales <em>Redes Sociales</em>}</li>
 *   <li>{@link dataweb.impl.PaginaImpl#getFuentesRSS <em>Fuentes RSS</em>}</li>
 *   <li>{@link dataweb.impl.PaginaImpl#getNombre <em>Nombre</em>}</li>
 *   <li>{@link dataweb.impl.PaginaImpl#getTitulo <em>Titulo</em>}</li>
 *   <li>{@link dataweb.impl.PaginaImpl#getDescripcion <em>Descripcion</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class PaginaImpl extends EObjectImpl implements Pagina {
	/**
	 * The cached value of the '{@link #getEnlaces() <em>Enlaces</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnlaces()
	 * @generated
	 * @ordered
	 */
	protected EList<Pagina> enlaces;

	/**
	 * The cached value of the '{@link #getRedesSociales() <em>Redes Sociales</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRedesSociales()
	 * @generated
	 * @ordered
	 */
	protected EList<RedSocial> redesSociales;

	/**
	 * The cached value of the '{@link #getFuentesRSS() <em>Fuentes RSS</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFuentesRSS()
	 * @generated
	 * @ordered
	 */
	protected EList<FuenteRSS> fuentesRSS;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PaginaImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DatawebPackage.Literals.PAGINA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Pagina> getEnlaces() {
		if (enlaces == null) {
			enlaces = new EObjectResolvingEList<Pagina>(Pagina.class, this, DatawebPackage.PAGINA__ENLACES);
		}
		return enlaces;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<RedSocial> getRedesSociales() {
		if (redesSociales == null) {
			redesSociales = new EObjectResolvingEList<RedSocial>(RedSocial.class, this, DatawebPackage.PAGINA__REDES_SOCIALES);
		}
		return redesSociales;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<FuenteRSS> getFuentesRSS() {
		if (fuentesRSS == null) {
			fuentesRSS = new EObjectResolvingEList<FuenteRSS>(FuenteRSS.class, this, DatawebPackage.PAGINA__FUENTES_RSS);
		}
		return fuentesRSS;
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
			eNotify(new ENotificationImpl(this, Notification.SET, DatawebPackage.PAGINA__NOMBRE, oldNombre, nombre));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DatawebPackage.PAGINA__TITULO, oldTitulo, titulo));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DatawebPackage.PAGINA__DESCRIPCION, oldDescripcion, descripcion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DatawebPackage.PAGINA__ENLACES:
				return getEnlaces();
			case DatawebPackage.PAGINA__REDES_SOCIALES:
				return getRedesSociales();
			case DatawebPackage.PAGINA__FUENTES_RSS:
				return getFuentesRSS();
			case DatawebPackage.PAGINA__NOMBRE:
				return getNombre();
			case DatawebPackage.PAGINA__TITULO:
				return getTitulo();
			case DatawebPackage.PAGINA__DESCRIPCION:
				return getDescripcion();
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
			case DatawebPackage.PAGINA__ENLACES:
				getEnlaces().clear();
				getEnlaces().addAll((Collection<? extends Pagina>)newValue);
				return;
			case DatawebPackage.PAGINA__REDES_SOCIALES:
				getRedesSociales().clear();
				getRedesSociales().addAll((Collection<? extends RedSocial>)newValue);
				return;
			case DatawebPackage.PAGINA__FUENTES_RSS:
				getFuentesRSS().clear();
				getFuentesRSS().addAll((Collection<? extends FuenteRSS>)newValue);
				return;
			case DatawebPackage.PAGINA__NOMBRE:
				setNombre((String)newValue);
				return;
			case DatawebPackage.PAGINA__TITULO:
				setTitulo((String)newValue);
				return;
			case DatawebPackage.PAGINA__DESCRIPCION:
				setDescripcion((String)newValue);
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
			case DatawebPackage.PAGINA__ENLACES:
				getEnlaces().clear();
				return;
			case DatawebPackage.PAGINA__REDES_SOCIALES:
				getRedesSociales().clear();
				return;
			case DatawebPackage.PAGINA__FUENTES_RSS:
				getFuentesRSS().clear();
				return;
			case DatawebPackage.PAGINA__NOMBRE:
				setNombre(NOMBRE_EDEFAULT);
				return;
			case DatawebPackage.PAGINA__TITULO:
				setTitulo(TITULO_EDEFAULT);
				return;
			case DatawebPackage.PAGINA__DESCRIPCION:
				setDescripcion(DESCRIPCION_EDEFAULT);
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
			case DatawebPackage.PAGINA__ENLACES:
				return enlaces != null && !enlaces.isEmpty();
			case DatawebPackage.PAGINA__REDES_SOCIALES:
				return redesSociales != null && !redesSociales.isEmpty();
			case DatawebPackage.PAGINA__FUENTES_RSS:
				return fuentesRSS != null && !fuentesRSS.isEmpty();
			case DatawebPackage.PAGINA__NOMBRE:
				return NOMBRE_EDEFAULT == null ? nombre != null : !NOMBRE_EDEFAULT.equals(nombre);
			case DatawebPackage.PAGINA__TITULO:
				return TITULO_EDEFAULT == null ? titulo != null : !TITULO_EDEFAULT.equals(titulo);
			case DatawebPackage.PAGINA__DESCRIPCION:
				return DESCRIPCION_EDEFAULT == null ? descripcion != null : !DESCRIPCION_EDEFAULT.equals(descripcion);
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
		result.append(", titulo: ");
		result.append(titulo);
		result.append(", descripcion: ");
		result.append(descripcion);
		result.append(')');
		return result.toString();
	}

} //PaginaImpl
