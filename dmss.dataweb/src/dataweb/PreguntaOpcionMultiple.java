/**
 */
package dataweb;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pregunta Opcion Multiple</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dataweb.PreguntaOpcionMultiple#getOpciones <em>Opciones</em>}</li>
 *   <li>{@link dataweb.PreguntaOpcionMultiple#getRespuestaCorrecta <em>Respuesta Correcta</em>}</li>
 * </ul>
 *
 * @see dataweb.DatawebPackage#getPreguntaOpcionMultiple()
 * @model annotation="gmf.node label='nombre' color='255,220,220'"
 * @generated
 */
public interface PreguntaOpcionMultiple extends Pregunta {
	/**
	 * Returns the value of the '<em><b>Opciones</b></em>' containment reference list.
	 * The list contents are of type {@link dataweb.OpcionRespuesta}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Opciones</em>' containment reference list.
	 * @see dataweb.DatawebPackage#getPreguntaOpcionMultiple_Opciones()
	 * @model containment="true" lower="2"
	 *        annotation="gmf.compartment"
	 * @generated
	 */
	EList<OpcionRespuesta> getOpciones();

	/**
	 * Returns the value of the '<em><b>Respuesta Correcta</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Respuesta Correcta</em>' reference.
	 * @see #setRespuestaCorrecta(OpcionRespuesta)
	 * @see dataweb.DatawebPackage#getPreguntaOpcionMultiple_RespuestaCorrecta()
	 * @model annotation="gmf.link target.decoration='arrow' color='255,0,0'"
	 * @generated
	 */
	OpcionRespuesta getRespuestaCorrecta();

	/**
	 * Sets the value of the '{@link dataweb.PreguntaOpcionMultiple#getRespuestaCorrecta <em>Respuesta Correcta</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Respuesta Correcta</em>' reference.
	 * @see #getRespuestaCorrecta()
	 * @generated
	 */
	void setRespuestaCorrecta(OpcionRespuesta value);

} // PreguntaOpcionMultiple
