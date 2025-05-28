/**
 */
package dataweb;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Aplicacion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dataweb.Aplicacion#getNombre <em>Nombre</em>}</li>
 *   <li>{@link dataweb.Aplicacion#getDescripcion <em>Descripcion</em>}</li>
 *   <li>{@link dataweb.Aplicacion#getEntidades <em>Entidades</em>}</li>
 *   <li>{@link dataweb.Aplicacion#getPaginas <em>Paginas</em>}</li>
 *   <li>{@link dataweb.Aplicacion#getRoles <em>Roles</em>}</li>
 *   <li>{@link dataweb.Aplicacion#getCuestionarios <em>Cuestionarios</em>}</li>
 *   <li>{@link dataweb.Aplicacion#getEncuestas <em>Encuestas</em>}</li>
 *   <li>{@link dataweb.Aplicacion#getRedesSociales <em>Redes Sociales</em>}</li>
 *   <li>{@link dataweb.Aplicacion#getFuentesRSS <em>Fuentes RSS</em>}</li>
 *   <li>{@link dataweb.Aplicacion#getPaginasMediasAccesibles <em>Paginas Medias Accesibles</em>}</li>
 * </ul>
 *
 * @see dataweb.DatawebPackage#getAplicacion()
 * @model annotation="gmf.diagram"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='R01_una_sola_pagina_home R04_al_menos_una_red_social_y_rss R06b_al_menos_una_encuesta_y_cuestionario'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot R01_una_sola_pagina_home='self.paginas-&gt;select(p | p.oclIsTypeOf(PaginaHome))-&gt;size() = 1' R04_al_menos_una_red_social_y_rss='self.redesSociales-&gt;size() &gt;= 1 and self.fuentesRSS-&gt;size() &gt;= 1' R06b_al_menos_una_encuesta_y_cuestionario='self.encuestas-&gt;size() &gt;= 1 and self.cuestionarios-&gt;size() &gt;= 1'"
 * @generated
 */
public interface Aplicacion extends EObject {
	/**
	 * Returns the value of the '<em><b>Nombre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nombre</em>' attribute.
	 * @see #setNombre(String)
	 * @see dataweb.DatawebPackage#getAplicacion_Nombre()
	 * @model required="true"
	 * @generated
	 */
	String getNombre();

	/**
	 * Sets the value of the '{@link dataweb.Aplicacion#getNombre <em>Nombre</em>}' attribute.
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
	 * @see dataweb.DatawebPackage#getAplicacion_Descripcion()
	 * @model required="true"
	 * @generated
	 */
	String getDescripcion();

	/**
	 * Sets the value of the '{@link dataweb.Aplicacion#getDescripcion <em>Descripcion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Descripcion</em>' attribute.
	 * @see #getDescripcion()
	 * @generated
	 */
	void setDescripcion(String value);

	/**
	 * Returns the value of the '<em><b>Entidades</b></em>' containment reference list.
	 * The list contents are of type {@link dataweb.Entidad}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entidades</em>' containment reference list.
	 * @see dataweb.DatawebPackage#getAplicacion_Entidades()
	 * @model containment="true" required="true"
	 *        annotation="gmf.compartment"
	 * @generated
	 */
	EList<Entidad> getEntidades();

	/**
	 * Returns the value of the '<em><b>Paginas</b></em>' containment reference list.
	 * The list contents are of type {@link dataweb.Pagina}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Paginas</em>' containment reference list.
	 * @see dataweb.DatawebPackage#getAplicacion_Paginas()
	 * @model containment="true" required="true"
	 *        annotation="gmf.compartment"
	 * @generated
	 */
	EList<Pagina> getPaginas();

	/**
	 * Returns the value of the '<em><b>Roles</b></em>' containment reference list.
	 * The list contents are of type {@link dataweb.Rol}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Roles</em>' containment reference list.
	 * @see dataweb.DatawebPackage#getAplicacion_Roles()
	 * @model containment="true" required="true"
	 *        annotation="gmf.compartment"
	 * @generated
	 */
	EList<Rol> getRoles();

	/**
	 * Returns the value of the '<em><b>Cuestionarios</b></em>' containment reference list.
	 * The list contents are of type {@link dataweb.Cuestionario}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cuestionarios</em>' containment reference list.
	 * @see dataweb.DatawebPackage#getAplicacion_Cuestionarios()
	 * @model containment="true"
	 *        annotation="gmf.compartment"
	 * @generated
	 */
	EList<Cuestionario> getCuestionarios();

	/**
	 * Returns the value of the '<em><b>Encuestas</b></em>' containment reference list.
	 * The list contents are of type {@link dataweb.Encuesta}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Encuestas</em>' containment reference list.
	 * @see dataweb.DatawebPackage#getAplicacion_Encuestas()
	 * @model containment="true"
	 *        annotation="gmf.compartment"
	 * @generated
	 */
	EList<Encuesta> getEncuestas();

	/**
	 * Returns the value of the '<em><b>Redes Sociales</b></em>' containment reference list.
	 * The list contents are of type {@link dataweb.RedSocial}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Redes Sociales</em>' containment reference list.
	 * @see dataweb.DatawebPackage#getAplicacion_RedesSociales()
	 * @model containment="true" required="true"
	 *        annotation="gmf.compartment"
	 * @generated
	 */
	EList<RedSocial> getRedesSociales();

	/**
	 * Returns the value of the '<em><b>Fuentes RSS</b></em>' containment reference list.
	 * The list contents are of type {@link dataweb.FuenteRSS}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fuentes RSS</em>' containment reference list.
	 * @see dataweb.DatawebPackage#getAplicacion_FuentesRSS()
	 * @model containment="true" required="true"
	 *        annotation="gmf.compartment"
	 * @generated
	 */
	EList<FuenteRSS> getFuentesRSS();

	/**
	 * Returns the value of the '<em><b>Paginas Medias Accesibles</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Paginas Medias Accesibles</em>' attribute.
	 * @see #setPaginasMediasAccesibles(double)
	 * @see dataweb.DatawebPackage#getAplicacion_PaginasMediasAccesibles()
	 * @model required="true" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	double getPaginasMediasAccesibles();

	/**
	 * Sets the value of the '{@link dataweb.Aplicacion#getPaginasMediasAccesibles <em>Paginas Medias Accesibles</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Paginas Medias Accesibles</em>' attribute.
	 * @see #getPaginasMediasAccesibles()
	 * @generated
	 */
	void setPaginasMediasAccesibles(double value);

} // Aplicacion
