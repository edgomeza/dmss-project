/**
 */
package dataweb;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cuestionario</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dataweb.Cuestionario#getPreguntas <em>Preguntas</em>}</li>
 *   <li>{@link dataweb.Cuestionario#getNombre <em>Nombre</em>}</li>
 *   <li>{@link dataweb.Cuestionario#getDescripcion <em>Descripcion</em>}</li>
 *   <li>{@link dataweb.Cuestionario#getTitulo <em>Titulo</em>}</li>
 *   <li>{@link dataweb.Cuestionario#getNumeroPregVF <em>Numero Preg VF</em>}</li>
 *   <li>{@link dataweb.Cuestionario#getNumeroPregSelect <em>Numero Preg Select</em>}</li>
 * </ul>
 *
 * @see dataweb.DatawebPackage#getCuestionario()
 * @model annotation="gmf.node label='nombre' color='255,200,100'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='R07_cuestionarios_con_respuesta'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot R07_cuestionarios_con_respuesta='self.preguntas-&gt;forAll(p | p.oclIsTypeOf(PreguntaOpcionMultiple) implies p.oclAsType(PreguntaOpcionMultiple).respuestaCorrecta &lt;&gt; null)'"
 * @generated
 */
public interface Cuestionario extends EObject {
	/**
	 * Returns the value of the '<em><b>Preguntas</b></em>' containment reference list.
	 * The list contents are of type {@link dataweb.Pregunta}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Preguntas</em>' containment reference list.
	 * @see dataweb.DatawebPackage#getCuestionario_Preguntas()
	 * @model containment="true" required="true"
	 *        annotation="gmf.compartment"
	 * @generated
	 */
	EList<Pregunta> getPreguntas();

	/**
	 * Returns the value of the '<em><b>Nombre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nombre</em>' attribute.
	 * @see #setNombre(String)
	 * @see dataweb.DatawebPackage#getCuestionario_Nombre()
	 * @model required="true"
	 * @generated
	 */
	String getNombre();

	/**
	 * Sets the value of the '{@link dataweb.Cuestionario#getNombre <em>Nombre</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nombre</em>' attribute.
	 * @see #getNombre()
	 * @generated
	 */
	void setNombre(String value);

	/**
	 * Returns the value of the '<em><b>Descripcion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Descripcion</em>' attribute.
	 * @see #setDescripcion(String)
	 * @see dataweb.DatawebPackage#getCuestionario_Descripcion()
	 * @model
	 * @generated
	 */
	String getDescripcion();

	/**
	 * Sets the value of the '{@link dataweb.Cuestionario#getDescripcion <em>Descripcion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Descripcion</em>' attribute.
	 * @see #getDescripcion()
	 * @generated
	 */
	void setDescripcion(String value);

	/**
	 * Returns the value of the '<em><b>Titulo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Titulo</em>' attribute.
	 * @see #setTitulo(String)
	 * @see dataweb.DatawebPackage#getCuestionario_Titulo()
	 * @model required="true"
	 * @generated
	 */
	String getTitulo();

	/**
	 * Sets the value of the '{@link dataweb.Cuestionario#getTitulo <em>Titulo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Titulo</em>' attribute.
	 * @see #getTitulo()
	 * @generated
	 */
	void setTitulo(String value);

	/**
	 * Returns the value of the '<em><b>Numero Preg VF</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Numero Preg VF</em>' attribute.
	 * @see #setNumeroPregVF(int)
	 * @see dataweb.DatawebPackage#getCuestionario_NumeroPregVF()
	 * @model required="true" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	int getNumeroPregVF();

	/**
	 * Sets the value of the '{@link dataweb.Cuestionario#getNumeroPregVF <em>Numero Preg VF</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Numero Preg VF</em>' attribute.
	 * @see #getNumeroPregVF()
	 * @generated
	 */
	void setNumeroPregVF(int value);

	/**
	 * Returns the value of the '<em><b>Numero Preg Select</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Numero Preg Select</em>' attribute.
	 * @see #setNumeroPregSelect(int)
	 * @see dataweb.DatawebPackage#getCuestionario_NumeroPregSelect()
	 * @model required="true" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	int getNumeroPregSelect();

	/**
	 * Sets the value of the '{@link dataweb.Cuestionario#getNumeroPregSelect <em>Numero Preg Select</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Numero Preg Select</em>' attribute.
	 * @see #getNumeroPregSelect()
	 * @generated
	 */
	void setNumeroPregSelect(int value);

} // Cuestionario
