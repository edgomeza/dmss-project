/**
 */
package dataweb.impl;

import dataweb.DatawebPackage;
import dataweb.RedSocial;
import dataweb.TipoRedSocial;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Red Social</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dataweb.impl.RedSocialImpl#getTipo <em>Tipo</em>}</li>
 *   <li>{@link dataweb.impl.RedSocialImpl#getNombre <em>Nombre</em>}</li>
 *   <li>{@link dataweb.impl.RedSocialImpl#getCodigoEmbed <em>Codigo Embed</em>}</li>
 *   <li>{@link dataweb.impl.RedSocialImpl#getNombreCuenta <em>Nombre Cuenta</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RedSocialImpl extends EObjectImpl implements RedSocial {
	/**
	 * The default value of the '{@link #getTipo() <em>Tipo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTipo()
	 * @generated
	 * @ordered
	 */
	protected static final TipoRedSocial TIPO_EDEFAULT = TipoRedSocial.TWITTER;

	/**
	 * The cached value of the '{@link #getTipo() <em>Tipo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTipo()
	 * @generated
	 * @ordered
	 */
	protected TipoRedSocial tipo = TIPO_EDEFAULT;

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
	 * The default value of the '{@link #getCodigoEmbed() <em>Codigo Embed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCodigoEmbed()
	 * @generated
	 * @ordered
	 */
	protected static final String CODIGO_EMBED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCodigoEmbed() <em>Codigo Embed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCodigoEmbed()
	 * @generated
	 * @ordered
	 */
	protected String codigoEmbed = CODIGO_EMBED_EDEFAULT;

	/**
	 * The default value of the '{@link #getNombreCuenta() <em>Nombre Cuenta</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNombreCuenta()
	 * @generated
	 * @ordered
	 */
	protected static final String NOMBRE_CUENTA_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNombreCuenta() <em>Nombre Cuenta</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNombreCuenta()
	 * @generated
	 * @ordered
	 */
	protected String nombreCuenta = NOMBRE_CUENTA_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RedSocialImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DatawebPackage.Literals.RED_SOCIAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TipoRedSocial getTipo() {
		return tipo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTipo(TipoRedSocial newTipo) {
		TipoRedSocial oldTipo = tipo;
		tipo = newTipo == null ? TIPO_EDEFAULT : newTipo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatawebPackage.RED_SOCIAL__TIPO, oldTipo, tipo));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DatawebPackage.RED_SOCIAL__NOMBRE, oldNombre, nombre));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCodigoEmbed() {
		return codigoEmbed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCodigoEmbed(String newCodigoEmbed) {
		String oldCodigoEmbed = codigoEmbed;
		codigoEmbed = newCodigoEmbed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatawebPackage.RED_SOCIAL__CODIGO_EMBED, oldCodigoEmbed, codigoEmbed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getNombreCuenta() {
		return nombreCuenta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNombreCuenta(String newNombreCuenta) {
		String oldNombreCuenta = nombreCuenta;
		nombreCuenta = newNombreCuenta;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatawebPackage.RED_SOCIAL__NOMBRE_CUENTA, oldNombreCuenta, nombreCuenta));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DatawebPackage.RED_SOCIAL__TIPO:
				return getTipo();
			case DatawebPackage.RED_SOCIAL__NOMBRE:
				return getNombre();
			case DatawebPackage.RED_SOCIAL__CODIGO_EMBED:
				return getCodigoEmbed();
			case DatawebPackage.RED_SOCIAL__NOMBRE_CUENTA:
				return getNombreCuenta();
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
			case DatawebPackage.RED_SOCIAL__TIPO:
				setTipo((TipoRedSocial)newValue);
				return;
			case DatawebPackage.RED_SOCIAL__NOMBRE:
				setNombre((String)newValue);
				return;
			case DatawebPackage.RED_SOCIAL__CODIGO_EMBED:
				setCodigoEmbed((String)newValue);
				return;
			case DatawebPackage.RED_SOCIAL__NOMBRE_CUENTA:
				setNombreCuenta((String)newValue);
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
			case DatawebPackage.RED_SOCIAL__TIPO:
				setTipo(TIPO_EDEFAULT);
				return;
			case DatawebPackage.RED_SOCIAL__NOMBRE:
				setNombre(NOMBRE_EDEFAULT);
				return;
			case DatawebPackage.RED_SOCIAL__CODIGO_EMBED:
				setCodigoEmbed(CODIGO_EMBED_EDEFAULT);
				return;
			case DatawebPackage.RED_SOCIAL__NOMBRE_CUENTA:
				setNombreCuenta(NOMBRE_CUENTA_EDEFAULT);
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
			case DatawebPackage.RED_SOCIAL__TIPO:
				return tipo != TIPO_EDEFAULT;
			case DatawebPackage.RED_SOCIAL__NOMBRE:
				return NOMBRE_EDEFAULT == null ? nombre != null : !NOMBRE_EDEFAULT.equals(nombre);
			case DatawebPackage.RED_SOCIAL__CODIGO_EMBED:
				return CODIGO_EMBED_EDEFAULT == null ? codigoEmbed != null : !CODIGO_EMBED_EDEFAULT.equals(codigoEmbed);
			case DatawebPackage.RED_SOCIAL__NOMBRE_CUENTA:
				return NOMBRE_CUENTA_EDEFAULT == null ? nombreCuenta != null : !NOMBRE_CUENTA_EDEFAULT.equals(nombreCuenta);
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
		result.append(" (tipo: ");
		result.append(tipo);
		result.append(", nombre: ");
		result.append(nombre);
		result.append(", codigoEmbed: ");
		result.append(codigoEmbed);
		result.append(", nombreCuenta: ");
		result.append(nombreCuenta);
		result.append(')');
		return result.toString();
	}

} //RedSocialImpl
