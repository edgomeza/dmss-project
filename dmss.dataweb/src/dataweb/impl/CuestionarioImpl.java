/**
 */
package dataweb.impl;

import dataweb.Cuestionario;
import dataweb.DatawebPackage;
import dataweb.Pregunta;

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
 * An implementation of the model object '<em><b>Cuestionario</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dataweb.impl.CuestionarioImpl#getPreguntas <em>Preguntas</em>}</li>
 *   <li>{@link dataweb.impl.CuestionarioImpl#getNombre <em>Nombre</em>}</li>
 *   <li>{@link dataweb.impl.CuestionarioImpl#getDescripcion <em>Descripcion</em>}</li>
 *   <li>{@link dataweb.impl.CuestionarioImpl#getTitulo <em>Titulo</em>}</li>
 *   <li>{@link dataweb.impl.CuestionarioImpl#getNumeroPregVF <em>Numero Preg VF</em>}</li>
 *   <li>{@link dataweb.impl.CuestionarioImpl#getNumeroPregSelect <em>Numero Preg Select</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CuestionarioImpl extends EObjectImpl implements Cuestionario {
	/**
	 * The cached value of the '{@link #getPreguntas() <em>Preguntas</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreguntas()
	 * @generated
	 * @ordered
	 */
	protected EList<Pregunta> preguntas;

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
	 * The default value of the '{@link #getNumeroPregVF() <em>Numero Preg VF</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumeroPregVF()
	 * @generated
	 * @ordered
	 */
	protected static final int NUMERO_PREG_VF_EDEFAULT = 0;

	/**
	 * The default value of the '{@link #getNumeroPregSelect() <em>Numero Preg Select</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumeroPregSelect()
	 * @generated
	 * @ordered
	 */
	protected static final int NUMERO_PREG_SELECT_EDEFAULT = 0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CuestionarioImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DatawebPackage.Literals.CUESTIONARIO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Pregunta> getPreguntas() {
		if (preguntas == null) {
			preguntas = new EObjectContainmentEList<Pregunta>(Pregunta.class, this, DatawebPackage.CUESTIONARIO__PREGUNTAS);
		}
		return preguntas;
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
			eNotify(new ENotificationImpl(this, Notification.SET, DatawebPackage.CUESTIONARIO__NOMBRE, oldNombre, nombre));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DatawebPackage.CUESTIONARIO__DESCRIPCION, oldDescripcion, descripcion));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DatawebPackage.CUESTIONARIO__TITULO, oldTitulo, titulo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getNumeroPregVF() {
		// TODO: implement this method to return the 'Numero Preg VF' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNumeroPregVF(int newNumeroPregVF) {
		// TODO: implement this method to set the 'Numero Preg VF' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getNumeroPregSelect() {
		// TODO: implement this method to return the 'Numero Preg Select' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNumeroPregSelect(int newNumeroPregSelect) {
		// TODO: implement this method to set the 'Numero Preg Select' attribute
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
			case DatawebPackage.CUESTIONARIO__PREGUNTAS:
				return ((InternalEList<?>)getPreguntas()).basicRemove(otherEnd, msgs);
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
			case DatawebPackage.CUESTIONARIO__PREGUNTAS:
				return getPreguntas();
			case DatawebPackage.CUESTIONARIO__NOMBRE:
				return getNombre();
			case DatawebPackage.CUESTIONARIO__DESCRIPCION:
				return getDescripcion();
			case DatawebPackage.CUESTIONARIO__TITULO:
				return getTitulo();
			case DatawebPackage.CUESTIONARIO__NUMERO_PREG_VF:
				return getNumeroPregVF();
			case DatawebPackage.CUESTIONARIO__NUMERO_PREG_SELECT:
				return getNumeroPregSelect();
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
			case DatawebPackage.CUESTIONARIO__PREGUNTAS:
				getPreguntas().clear();
				getPreguntas().addAll((Collection<? extends Pregunta>)newValue);
				return;
			case DatawebPackage.CUESTIONARIO__NOMBRE:
				setNombre((String)newValue);
				return;
			case DatawebPackage.CUESTIONARIO__DESCRIPCION:
				setDescripcion((String)newValue);
				return;
			case DatawebPackage.CUESTIONARIO__TITULO:
				setTitulo((String)newValue);
				return;
			case DatawebPackage.CUESTIONARIO__NUMERO_PREG_VF:
				setNumeroPregVF((Integer)newValue);
				return;
			case DatawebPackage.CUESTIONARIO__NUMERO_PREG_SELECT:
				setNumeroPregSelect((Integer)newValue);
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
			case DatawebPackage.CUESTIONARIO__PREGUNTAS:
				getPreguntas().clear();
				return;
			case DatawebPackage.CUESTIONARIO__NOMBRE:
				setNombre(NOMBRE_EDEFAULT);
				return;
			case DatawebPackage.CUESTIONARIO__DESCRIPCION:
				setDescripcion(DESCRIPCION_EDEFAULT);
				return;
			case DatawebPackage.CUESTIONARIO__TITULO:
				setTitulo(TITULO_EDEFAULT);
				return;
			case DatawebPackage.CUESTIONARIO__NUMERO_PREG_VF:
				setNumeroPregVF(NUMERO_PREG_VF_EDEFAULT);
				return;
			case DatawebPackage.CUESTIONARIO__NUMERO_PREG_SELECT:
				setNumeroPregSelect(NUMERO_PREG_SELECT_EDEFAULT);
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
			case DatawebPackage.CUESTIONARIO__PREGUNTAS:
				return preguntas != null && !preguntas.isEmpty();
			case DatawebPackage.CUESTIONARIO__NOMBRE:
				return NOMBRE_EDEFAULT == null ? nombre != null : !NOMBRE_EDEFAULT.equals(nombre);
			case DatawebPackage.CUESTIONARIO__DESCRIPCION:
				return DESCRIPCION_EDEFAULT == null ? descripcion != null : !DESCRIPCION_EDEFAULT.equals(descripcion);
			case DatawebPackage.CUESTIONARIO__TITULO:
				return TITULO_EDEFAULT == null ? titulo != null : !TITULO_EDEFAULT.equals(titulo);
			case DatawebPackage.CUESTIONARIO__NUMERO_PREG_VF:
				return getNumeroPregVF() != NUMERO_PREG_VF_EDEFAULT;
			case DatawebPackage.CUESTIONARIO__NUMERO_PREG_SELECT:
				return getNumeroPregSelect() != NUMERO_PREG_SELECT_EDEFAULT;
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
		result.append(", titulo: ");
		result.append(titulo);
		result.append(')');
		return result.toString();
	}

} //CuestionarioImpl
