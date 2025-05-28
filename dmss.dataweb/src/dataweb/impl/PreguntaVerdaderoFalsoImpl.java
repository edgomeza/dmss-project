/**
 */
package dataweb.impl;

import dataweb.DatawebPackage;
import dataweb.PreguntaVerdaderoFalso;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pregunta Verdadero Falso</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dataweb.impl.PreguntaVerdaderoFalsoImpl#getRespuestaCorrecta <em>Respuesta Correcta</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PreguntaVerdaderoFalsoImpl extends PreguntaImpl implements PreguntaVerdaderoFalso {
	/**
	 * The default value of the '{@link #getRespuestaCorrecta() <em>Respuesta Correcta</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRespuestaCorrecta()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean RESPUESTA_CORRECTA_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRespuestaCorrecta() <em>Respuesta Correcta</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRespuestaCorrecta()
	 * @generated
	 * @ordered
	 */
	protected Boolean respuestaCorrecta = RESPUESTA_CORRECTA_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PreguntaVerdaderoFalsoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DatawebPackage.Literals.PREGUNTA_VERDADERO_FALSO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Boolean getRespuestaCorrecta() {
		return respuestaCorrecta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRespuestaCorrecta(Boolean newRespuestaCorrecta) {
		Boolean oldRespuestaCorrecta = respuestaCorrecta;
		respuestaCorrecta = newRespuestaCorrecta;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatawebPackage.PREGUNTA_VERDADERO_FALSO__RESPUESTA_CORRECTA, oldRespuestaCorrecta, respuestaCorrecta));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DatawebPackage.PREGUNTA_VERDADERO_FALSO__RESPUESTA_CORRECTA:
				return getRespuestaCorrecta();
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
			case DatawebPackage.PREGUNTA_VERDADERO_FALSO__RESPUESTA_CORRECTA:
				setRespuestaCorrecta((Boolean)newValue);
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
			case DatawebPackage.PREGUNTA_VERDADERO_FALSO__RESPUESTA_CORRECTA:
				setRespuestaCorrecta(RESPUESTA_CORRECTA_EDEFAULT);
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
			case DatawebPackage.PREGUNTA_VERDADERO_FALSO__RESPUESTA_CORRECTA:
				return RESPUESTA_CORRECTA_EDEFAULT == null ? respuestaCorrecta != null : !RESPUESTA_CORRECTA_EDEFAULT.equals(respuestaCorrecta);
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
		result.append(" (respuestaCorrecta: ");
		result.append(respuestaCorrecta);
		result.append(')');
		return result.toString();
	}

} //PreguntaVerdaderoFalsoImpl
