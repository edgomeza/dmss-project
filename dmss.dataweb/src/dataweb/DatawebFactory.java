/**
 */
package dataweb;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see dataweb.DatawebPackage
 * @generated
 */
public interface DatawebFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DatawebFactory eINSTANCE = dataweb.impl.DatawebFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Aplicacion</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Aplicacion</em>'.
	 * @generated
	 */
	Aplicacion createAplicacion();

	/**
	 * Returns a new object of class '<em>Entidad</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entidad</em>'.
	 * @generated
	 */
	Entidad createEntidad();

	/**
	 * Returns a new object of class '<em>Atributo</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Atributo</em>'.
	 * @generated
	 */
	Atributo createAtributo();

	/**
	 * Returns a new object of class '<em>Referencia</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Referencia</em>'.
	 * @generated
	 */
	Referencia createReferencia();

	/**
	 * Returns a new object of class '<em>Pagina Home</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pagina Home</em>'.
	 * @generated
	 */
	PaginaHome createPaginaHome();

	/**
	 * Returns a new object of class '<em>Pagina Contenido</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pagina Contenido</em>'.
	 * @generated
	 */
	PaginaContenido createPaginaContenido();

	/**
	 * Returns a new object of class '<em>Pagina Detalle</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pagina Detalle</em>'.
	 * @generated
	 */
	PaginaDetalle createPaginaDetalle();

	/**
	 * Returns a new object of class '<em>Pagina Creacion</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pagina Creacion</em>'.
	 * @generated
	 */
	PaginaCreacion createPaginaCreacion();

	/**
	 * Returns a new object of class '<em>Pagina Actualizacion</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pagina Actualizacion</em>'.
	 * @generated
	 */
	PaginaActualizacion createPaginaActualizacion();

	/**
	 * Returns a new object of class '<em>Pagina Borrado</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pagina Borrado</em>'.
	 * @generated
	 */
	PaginaBorrado createPaginaBorrado();

	/**
	 * Returns a new object of class '<em>Pagina Indice Detalle</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pagina Indice Detalle</em>'.
	 * @generated
	 */
	PaginaIndiceDetalle createPaginaIndiceDetalle();

	/**
	 * Returns a new object of class '<em>Encuesta</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Encuesta</em>'.
	 * @generated
	 */
	Encuesta createEncuesta();

	/**
	 * Returns a new object of class '<em>Cuestionario</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cuestionario</em>'.
	 * @generated
	 */
	Cuestionario createCuestionario();

	/**
	 * Returns a new object of class '<em>Pregunta Opcion Multiple</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pregunta Opcion Multiple</em>'.
	 * @generated
	 */
	PreguntaOpcionMultiple createPreguntaOpcionMultiple();

	/**
	 * Returns a new object of class '<em>Opcion Respuesta</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Opcion Respuesta</em>'.
	 * @generated
	 */
	OpcionRespuesta createOpcionRespuesta();

	/**
	 * Returns a new object of class '<em>Pregunta Verdadero Falso</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pregunta Verdadero Falso</em>'.
	 * @generated
	 */
	PreguntaVerdaderoFalso createPreguntaVerdaderoFalso();

	/**
	 * Returns a new object of class '<em>Pregunta Respuesta Corta</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pregunta Respuesta Corta</em>'.
	 * @generated
	 */
	PreguntaRespuestaCorta createPreguntaRespuestaCorta();

	/**
	 * Returns a new object of class '<em>Red Social</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Red Social</em>'.
	 * @generated
	 */
	RedSocial createRedSocial();

	/**
	 * Returns a new object of class '<em>Rol</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rol</em>'.
	 * @generated
	 */
	Rol createRol();

	/**
	 * Returns a new object of class '<em>Fuente RSS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fuente RSS</em>'.
	 * @generated
	 */
	FuenteRSS createFuenteRSS();

	/**
	 * Returns a new object of class '<em>Pagina Indice Paginada</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pagina Indice Paginada</em>'.
	 * @generated
	 */
	PaginaIndicePaginada createPaginaIndicePaginada();

	/**
	 * Returns a new object of class '<em>Pagina Indice Filtros</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pagina Indice Filtros</em>'.
	 * @generated
	 */
	PaginaIndiceFiltros createPaginaIndiceFiltros();

	/**
	 * Returns a new object of class '<em>Pagina Indice Paginada Filtrada</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pagina Indice Paginada Filtrada</em>'.
	 * @generated
	 */
	PaginaIndicePaginadaFiltrada createPaginaIndicePaginadaFiltrada();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DatawebPackage getDatawebPackage();

} //DatawebFactory
