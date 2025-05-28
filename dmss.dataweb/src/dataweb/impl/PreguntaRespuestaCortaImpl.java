/**
 */
package dataweb.impl;

import dataweb.DatawebPackage;
import dataweb.PreguntaRespuestaCorta;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pregunta Respuesta Corta</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dataweb.impl.PreguntaRespuestaCortaImpl#getRespuestaCorta <em>Respuesta Corta</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PreguntaRespuestaCortaImpl extends PreguntaImpl implements PreguntaRespuestaCorta {
	/**
	 * The default value of the '{@link #getRespuestaCorta() <em>Respuesta Corta</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRespuestaCorta()
	 * @generated
	 * @ordered
	 */
	protected static final String RESPUESTA_CORTA_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRespuestaCorta() <em>Respuesta Corta</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRespuestaCorta()
	 * @generated
	 * @ordered
	 */
	protected String respuestaCorta = RESPUESTA_CORTA_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PreguntaRespuestaCortaImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DatawebPackage.Literals.PREGUNTA_RESPUESTA_CORTA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getRespuestaCorta() {
		return respuestaCorta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRespuestaCorta(String newRespuestaCorta) {
		String oldRespuestaCorta = respuestaCorta;
		respuestaCorta = newRespuestaCorta;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatawebPackage.PREGUNTA_RESPUESTA_CORTA__RESPUESTA_CORTA, oldRespuestaCorta, respuestaCorta));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DatawebPackage.PREGUNTA_RESPUESTA_CORTA__RESPUESTA_CORTA:
				return getRespuestaCorta();
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
			case DatawebPackage.PREGUNTA_RESPUESTA_CORTA__RESPUESTA_CORTA:
				setRespuestaCorta((String)newValue);
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
			case DatawebPackage.PREGUNTA_RESPUESTA_CORTA__RESPUESTA_CORTA:
				setRespuestaCorta(RESPUESTA_CORTA_EDEFAULT);
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
			case DatawebPackage.PREGUNTA_RESPUESTA_CORTA__RESPUESTA_CORTA:
				return RESPUESTA_CORTA_EDEFAULT == null ? respuestaCorta != null : !RESPUESTA_CORTA_EDEFAULT.equals(respuestaCorta);
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
		result.append(" (respuestaCorta: ");
		result.append(respuestaCorta);
		result.append(')');
		return result.toString();
	}

} //PreguntaRespuestaCortaImpl
