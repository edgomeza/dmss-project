/**
 */
package dataweb;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pregunta Verdadero Falso</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dataweb.PreguntaVerdaderoFalso#getRespuestaCorrecta <em>Respuesta Correcta</em>}</li>
 * </ul>
 *
 * @see dataweb.DatawebPackage#getPreguntaVerdaderoFalso()
 * @model annotation="gmf.node label='nombre' color='220,220,255'"
 * @generated
 */
public interface PreguntaVerdaderoFalso extends Pregunta {
	/**
	 * Returns the value of the '<em><b>Respuesta Correcta</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Respuesta Correcta</em>' attribute.
	 * @see #setRespuestaCorrecta(Boolean)
	 * @see dataweb.DatawebPackage#getPreguntaVerdaderoFalso_RespuestaCorrecta()
	 * @model
	 * @generated
	 */
	Boolean getRespuestaCorrecta();

	/**
	 * Sets the value of the '{@link dataweb.PreguntaVerdaderoFalso#getRespuestaCorrecta <em>Respuesta Correcta</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Respuesta Correcta</em>' attribute.
	 * @see #getRespuestaCorrecta()
	 * @generated
	 */
	void setRespuestaCorrecta(Boolean value);

} // PreguntaVerdaderoFalso
