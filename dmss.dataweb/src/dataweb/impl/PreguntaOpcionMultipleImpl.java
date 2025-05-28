/**
 */
package dataweb.impl;

import dataweb.DatawebPackage;
import dataweb.OpcionRespuesta;
import dataweb.PreguntaOpcionMultiple;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pregunta Opcion Multiple</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dataweb.impl.PreguntaOpcionMultipleImpl#getOpciones <em>Opciones</em>}</li>
 *   <li>{@link dataweb.impl.PreguntaOpcionMultipleImpl#getRespuestaCorrecta <em>Respuesta Correcta</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PreguntaOpcionMultipleImpl extends PreguntaImpl implements PreguntaOpcionMultiple {
	/**
	 * The cached value of the '{@link #getOpciones() <em>Opciones</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOpciones()
	 * @generated
	 * @ordered
	 */
	protected EList<OpcionRespuesta> opciones;

	/**
	 * The cached value of the '{@link #getRespuestaCorrecta() <em>Respuesta Correcta</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRespuestaCorrecta()
	 * @generated
	 * @ordered
	 */
	protected OpcionRespuesta respuestaCorrecta;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PreguntaOpcionMultipleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DatawebPackage.Literals.PREGUNTA_OPCION_MULTIPLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<OpcionRespuesta> getOpciones() {
		if (opciones == null) {
			opciones = new EObjectContainmentEList<OpcionRespuesta>(OpcionRespuesta.class, this, DatawebPackage.PREGUNTA_OPCION_MULTIPLE__OPCIONES);
		}
		return opciones;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OpcionRespuesta getRespuestaCorrecta() {
		if (respuestaCorrecta != null && respuestaCorrecta.eIsProxy()) {
			InternalEObject oldRespuestaCorrecta = (InternalEObject)respuestaCorrecta;
			respuestaCorrecta = (OpcionRespuesta)eResolveProxy(oldRespuestaCorrecta);
			if (respuestaCorrecta != oldRespuestaCorrecta) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DatawebPackage.PREGUNTA_OPCION_MULTIPLE__RESPUESTA_CORRECTA, oldRespuestaCorrecta, respuestaCorrecta));
			}
		}
		return respuestaCorrecta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OpcionRespuesta basicGetRespuestaCorrecta() {
		return respuestaCorrecta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRespuestaCorrecta(OpcionRespuesta newRespuestaCorrecta) {
		OpcionRespuesta oldRespuestaCorrecta = respuestaCorrecta;
		respuestaCorrecta = newRespuestaCorrecta;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatawebPackage.PREGUNTA_OPCION_MULTIPLE__RESPUESTA_CORRECTA, oldRespuestaCorrecta, respuestaCorrecta));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DatawebPackage.PREGUNTA_OPCION_MULTIPLE__OPCIONES:
				return ((InternalEList<?>)getOpciones()).basicRemove(otherEnd, msgs);
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
			case DatawebPackage.PREGUNTA_OPCION_MULTIPLE__OPCIONES:
				return getOpciones();
			case DatawebPackage.PREGUNTA_OPCION_MULTIPLE__RESPUESTA_CORRECTA:
				if (resolve) return getRespuestaCorrecta();
				return basicGetRespuestaCorrecta();
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
			case DatawebPackage.PREGUNTA_OPCION_MULTIPLE__OPCIONES:
				getOpciones().clear();
				getOpciones().addAll((Collection<? extends OpcionRespuesta>)newValue);
				return;
			case DatawebPackage.PREGUNTA_OPCION_MULTIPLE__RESPUESTA_CORRECTA:
				setRespuestaCorrecta((OpcionRespuesta)newValue);
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
			case DatawebPackage.PREGUNTA_OPCION_MULTIPLE__OPCIONES:
				getOpciones().clear();
				return;
			case DatawebPackage.PREGUNTA_OPCION_MULTIPLE__RESPUESTA_CORRECTA:
				setRespuestaCorrecta((OpcionRespuesta)null);
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
			case DatawebPackage.PREGUNTA_OPCION_MULTIPLE__OPCIONES:
				return opciones != null && !opciones.isEmpty();
			case DatawebPackage.PREGUNTA_OPCION_MULTIPLE__RESPUESTA_CORRECTA:
				return respuestaCorrecta != null;
		}
		return super.eIsSet(featureID);
	}

} //PreguntaOpcionMultipleImpl
