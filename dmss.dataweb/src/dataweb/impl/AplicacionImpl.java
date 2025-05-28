/**
 */
package dataweb.impl;

import dataweb.Aplicacion;
import dataweb.Cuestionario;
import dataweb.DatawebPackage;
import dataweb.Encuesta;
import dataweb.Entidad;
import dataweb.FuenteRSS;
import dataweb.Pagina;
import dataweb.RedSocial;
import dataweb.Rol;

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
 * An implementation of the model object '<em><b>Aplicacion</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dataweb.impl.AplicacionImpl#getNombre <em>Nombre</em>}</li>
 *   <li>{@link dataweb.impl.AplicacionImpl#getDescripcion <em>Descripcion</em>}</li>
 *   <li>{@link dataweb.impl.AplicacionImpl#getEntidades <em>Entidades</em>}</li>
 *   <li>{@link dataweb.impl.AplicacionImpl#getPaginas <em>Paginas</em>}</li>
 *   <li>{@link dataweb.impl.AplicacionImpl#getRoles <em>Roles</em>}</li>
 *   <li>{@link dataweb.impl.AplicacionImpl#getCuestionarios <em>Cuestionarios</em>}</li>
 *   <li>{@link dataweb.impl.AplicacionImpl#getEncuestas <em>Encuestas</em>}</li>
 *   <li>{@link dataweb.impl.AplicacionImpl#getRedesSociales <em>Redes Sociales</em>}</li>
 *   <li>{@link dataweb.impl.AplicacionImpl#getFuentesRSS <em>Fuentes RSS</em>}</li>
 *   <li>{@link dataweb.impl.AplicacionImpl#getPaginasMediasAccesibles <em>Paginas Medias Accesibles</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AplicacionImpl extends EObjectImpl implements Aplicacion {
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
	 * The cached value of the '{@link #getEntidades() <em>Entidades</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntidades()
	 * @generated
	 * @ordered
	 */
	protected EList<Entidad> entidades;

	/**
	 * The cached value of the '{@link #getPaginas() <em>Paginas</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPaginas()
	 * @generated
	 * @ordered
	 */
	protected EList<Pagina> paginas;

	/**
	 * The cached value of the '{@link #getRoles() <em>Roles</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoles()
	 * @generated
	 * @ordered
	 */
	protected EList<Rol> roles;

	/**
	 * The cached value of the '{@link #getCuestionarios() <em>Cuestionarios</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCuestionarios()
	 * @generated
	 * @ordered
	 */
	protected EList<Cuestionario> cuestionarios;

	/**
	 * The cached value of the '{@link #getEncuestas() <em>Encuestas</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEncuestas()
	 * @generated
	 * @ordered
	 */
	protected EList<Encuesta> encuestas;

	/**
	 * The cached value of the '{@link #getRedesSociales() <em>Redes Sociales</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRedesSociales()
	 * @generated
	 * @ordered
	 */
	protected EList<RedSocial> redesSociales;

	/**
	 * The cached value of the '{@link #getFuentesRSS() <em>Fuentes RSS</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFuentesRSS()
	 * @generated
	 * @ordered
	 */
	protected EList<FuenteRSS> fuentesRSS;

	/**
	 * The default value of the '{@link #getPaginasMediasAccesibles() <em>Paginas Medias Accesibles</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPaginasMediasAccesibles()
	 * @generated
	 * @ordered
	 */
	protected static final double PAGINAS_MEDIAS_ACCESIBLES_EDEFAULT = 0.0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AplicacionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DatawebPackage.Literals.APLICACION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, DatawebPackage.APLICACION__NOMBRE, oldNombre, nombre));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DatawebPackage.APLICACION__DESCRIPCION, oldDescripcion, descripcion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Entidad> getEntidades() {
		if (entidades == null) {
			entidades = new EObjectContainmentEList<Entidad>(Entidad.class, this, DatawebPackage.APLICACION__ENTIDADES);
		}
		return entidades;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Pagina> getPaginas() {
		if (paginas == null) {
			paginas = new EObjectContainmentEList<Pagina>(Pagina.class, this, DatawebPackage.APLICACION__PAGINAS);
		}
		return paginas;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Rol> getRoles() {
		if (roles == null) {
			roles = new EObjectContainmentEList<Rol>(Rol.class, this, DatawebPackage.APLICACION__ROLES);
		}
		return roles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Cuestionario> getCuestionarios() {
		if (cuestionarios == null) {
			cuestionarios = new EObjectContainmentEList<Cuestionario>(Cuestionario.class, this, DatawebPackage.APLICACION__CUESTIONARIOS);
		}
		return cuestionarios;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Encuesta> getEncuestas() {
		if (encuestas == null) {
			encuestas = new EObjectContainmentEList<Encuesta>(Encuesta.class, this, DatawebPackage.APLICACION__ENCUESTAS);
		}
		return encuestas;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<RedSocial> getRedesSociales() {
		if (redesSociales == null) {
			redesSociales = new EObjectContainmentEList<RedSocial>(RedSocial.class, this, DatawebPackage.APLICACION__REDES_SOCIALES);
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
			fuentesRSS = new EObjectContainmentEList<FuenteRSS>(FuenteRSS.class, this, DatawebPackage.APLICACION__FUENTES_RSS);
		}
		return fuentesRSS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getPaginasMediasAccesibles() {
		// TODO: implement this method to return the 'Paginas Medias Accesibles' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPaginasMediasAccesibles(double newPaginasMediasAccesibles) {
		// TODO: implement this method to set the 'Paginas Medias Accesibles' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DatawebPackage.APLICACION__ENTIDADES:
				return ((InternalEList<?>)getEntidades()).basicRemove(otherEnd, msgs);
			case DatawebPackage.APLICACION__PAGINAS:
				return ((InternalEList<?>)getPaginas()).basicRemove(otherEnd, msgs);
			case DatawebPackage.APLICACION__ROLES:
				return ((InternalEList<?>)getRoles()).basicRemove(otherEnd, msgs);
			case DatawebPackage.APLICACION__CUESTIONARIOS:
				return ((InternalEList<?>)getCuestionarios()).basicRemove(otherEnd, msgs);
			case DatawebPackage.APLICACION__ENCUESTAS:
				return ((InternalEList<?>)getEncuestas()).basicRemove(otherEnd, msgs);
			case DatawebPackage.APLICACION__REDES_SOCIALES:
				return ((InternalEList<?>)getRedesSociales()).basicRemove(otherEnd, msgs);
			case DatawebPackage.APLICACION__FUENTES_RSS:
				return ((InternalEList<?>)getFuentesRSS()).basicRemove(otherEnd, msgs);
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
			case DatawebPackage.APLICACION__NOMBRE:
				return getNombre();
			case DatawebPackage.APLICACION__DESCRIPCION:
				return getDescripcion();
			case DatawebPackage.APLICACION__ENTIDADES:
				return getEntidades();
			case DatawebPackage.APLICACION__PAGINAS:
				return getPaginas();
			case DatawebPackage.APLICACION__ROLES:
				return getRoles();
			case DatawebPackage.APLICACION__CUESTIONARIOS:
				return getCuestionarios();
			case DatawebPackage.APLICACION__ENCUESTAS:
				return getEncuestas();
			case DatawebPackage.APLICACION__REDES_SOCIALES:
				return getRedesSociales();
			case DatawebPackage.APLICACION__FUENTES_RSS:
				return getFuentesRSS();
			case DatawebPackage.APLICACION__PAGINAS_MEDIAS_ACCESIBLES:
				return getPaginasMediasAccesibles();
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
			case DatawebPackage.APLICACION__NOMBRE:
				setNombre((String)newValue);
				return;
			case DatawebPackage.APLICACION__DESCRIPCION:
				setDescripcion((String)newValue);
				return;
			case DatawebPackage.APLICACION__ENTIDADES:
				getEntidades().clear();
				getEntidades().addAll((Collection<? extends Entidad>)newValue);
				return;
			case DatawebPackage.APLICACION__PAGINAS:
				getPaginas().clear();
				getPaginas().addAll((Collection<? extends Pagina>)newValue);
				return;
			case DatawebPackage.APLICACION__ROLES:
				getRoles().clear();
				getRoles().addAll((Collection<? extends Rol>)newValue);
				return;
			case DatawebPackage.APLICACION__CUESTIONARIOS:
				getCuestionarios().clear();
				getCuestionarios().addAll((Collection<? extends Cuestionario>)newValue);
				return;
			case DatawebPackage.APLICACION__ENCUESTAS:
				getEncuestas().clear();
				getEncuestas().addAll((Collection<? extends Encuesta>)newValue);
				return;
			case DatawebPackage.APLICACION__REDES_SOCIALES:
				getRedesSociales().clear();
				getRedesSociales().addAll((Collection<? extends RedSocial>)newValue);
				return;
			case DatawebPackage.APLICACION__FUENTES_RSS:
				getFuentesRSS().clear();
				getFuentesRSS().addAll((Collection<? extends FuenteRSS>)newValue);
				return;
			case DatawebPackage.APLICACION__PAGINAS_MEDIAS_ACCESIBLES:
				setPaginasMediasAccesibles((Double)newValue);
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
			case DatawebPackage.APLICACION__NOMBRE:
				setNombre(NOMBRE_EDEFAULT);
				return;
			case DatawebPackage.APLICACION__DESCRIPCION:
				setDescripcion(DESCRIPCION_EDEFAULT);
				return;
			case DatawebPackage.APLICACION__ENTIDADES:
				getEntidades().clear();
				return;
			case DatawebPackage.APLICACION__PAGINAS:
				getPaginas().clear();
				return;
			case DatawebPackage.APLICACION__ROLES:
				getRoles().clear();
				return;
			case DatawebPackage.APLICACION__CUESTIONARIOS:
				getCuestionarios().clear();
				return;
			case DatawebPackage.APLICACION__ENCUESTAS:
				getEncuestas().clear();
				return;
			case DatawebPackage.APLICACION__REDES_SOCIALES:
				getRedesSociales().clear();
				return;
			case DatawebPackage.APLICACION__FUENTES_RSS:
				getFuentesRSS().clear();
				return;
			case DatawebPackage.APLICACION__PAGINAS_MEDIAS_ACCESIBLES:
				setPaginasMediasAccesibles(PAGINAS_MEDIAS_ACCESIBLES_EDEFAULT);
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
			case DatawebPackage.APLICACION__NOMBRE:
				return NOMBRE_EDEFAULT == null ? nombre != null : !NOMBRE_EDEFAULT.equals(nombre);
			case DatawebPackage.APLICACION__DESCRIPCION:
				return DESCRIPCION_EDEFAULT == null ? descripcion != null : !DESCRIPCION_EDEFAULT.equals(descripcion);
			case DatawebPackage.APLICACION__ENTIDADES:
				return entidades != null && !entidades.isEmpty();
			case DatawebPackage.APLICACION__PAGINAS:
				return paginas != null && !paginas.isEmpty();
			case DatawebPackage.APLICACION__ROLES:
				return roles != null && !roles.isEmpty();
			case DatawebPackage.APLICACION__CUESTIONARIOS:
				return cuestionarios != null && !cuestionarios.isEmpty();
			case DatawebPackage.APLICACION__ENCUESTAS:
				return encuestas != null && !encuestas.isEmpty();
			case DatawebPackage.APLICACION__REDES_SOCIALES:
				return redesSociales != null && !redesSociales.isEmpty();
			case DatawebPackage.APLICACION__FUENTES_RSS:
				return fuentesRSS != null && !fuentesRSS.isEmpty();
			case DatawebPackage.APLICACION__PAGINAS_MEDIAS_ACCESIBLES:
				return getPaginasMediasAccesibles() != PAGINAS_MEDIAS_ACCESIBLES_EDEFAULT;
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

} //AplicacionImpl
