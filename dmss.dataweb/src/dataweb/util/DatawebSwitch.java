/**
 */
package dataweb.util;

import dataweb.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see dataweb.DatawebPackage
 * @generated
 */
public class DatawebSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DatawebPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DatawebSwitch() {
		if (modelPackage == null) {
			modelPackage = DatawebPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case DatawebPackage.APLICACION: {
				Aplicacion aplicacion = (Aplicacion)theEObject;
				T result = caseAplicacion(aplicacion);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DatawebPackage.ENTIDAD: {
				Entidad entidad = (Entidad)theEObject;
				T result = caseEntidad(entidad);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DatawebPackage.ATRIBUTO: {
				Atributo atributo = (Atributo)theEObject;
				T result = caseAtributo(atributo);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DatawebPackage.REFERENCIA: {
				Referencia referencia = (Referencia)theEObject;
				T result = caseReferencia(referencia);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DatawebPackage.PAGINA: {
				Pagina pagina = (Pagina)theEObject;
				T result = casePagina(pagina);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DatawebPackage.PAGINA_HOME: {
				PaginaHome paginaHome = (PaginaHome)theEObject;
				T result = casePaginaHome(paginaHome);
				if (result == null) result = casePagina(paginaHome);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DatawebPackage.PAGINA_CONTENIDO: {
				PaginaContenido paginaContenido = (PaginaContenido)theEObject;
				T result = casePaginaContenido(paginaContenido);
				if (result == null) result = casePagina(paginaContenido);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DatawebPackage.PAGINA_CRUD: {
				PaginaCRUD paginaCRUD = (PaginaCRUD)theEObject;
				T result = casePaginaCRUD(paginaCRUD);
				if (result == null) result = casePagina(paginaCRUD);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DatawebPackage.PAGINA_INDICE: {
				PaginaIndice paginaIndice = (PaginaIndice)theEObject;
				T result = casePaginaIndice(paginaIndice);
				if (result == null) result = casePaginaCRUD(paginaIndice);
				if (result == null) result = casePagina(paginaIndice);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DatawebPackage.PAGINA_DETALLE: {
				PaginaDetalle paginaDetalle = (PaginaDetalle)theEObject;
				T result = casePaginaDetalle(paginaDetalle);
				if (result == null) result = casePaginaCRUD(paginaDetalle);
				if (result == null) result = casePagina(paginaDetalle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DatawebPackage.PAGINA_CREACION: {
				PaginaCreacion paginaCreacion = (PaginaCreacion)theEObject;
				T result = casePaginaCreacion(paginaCreacion);
				if (result == null) result = casePaginaCRUD(paginaCreacion);
				if (result == null) result = casePagina(paginaCreacion);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DatawebPackage.PAGINA_ACTUALIZACION: {
				PaginaActualizacion paginaActualizacion = (PaginaActualizacion)theEObject;
				T result = casePaginaActualizacion(paginaActualizacion);
				if (result == null) result = casePaginaCRUD(paginaActualizacion);
				if (result == null) result = casePagina(paginaActualizacion);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DatawebPackage.PAGINA_BORRADO: {
				PaginaBorrado paginaBorrado = (PaginaBorrado)theEObject;
				T result = casePaginaBorrado(paginaBorrado);
				if (result == null) result = casePaginaCRUD(paginaBorrado);
				if (result == null) result = casePagina(paginaBorrado);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DatawebPackage.PAGINA_INDICE_DETALLE: {
				PaginaIndiceDetalle paginaIndiceDetalle = (PaginaIndiceDetalle)theEObject;
				T result = casePaginaIndiceDetalle(paginaIndiceDetalle);
				if (result == null) result = casePaginaIndice(paginaIndiceDetalle);
				if (result == null) result = casePaginaCRUD(paginaIndiceDetalle);
				if (result == null) result = casePagina(paginaIndiceDetalle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DatawebPackage.ENCUESTA: {
				Encuesta encuesta = (Encuesta)theEObject;
				T result = caseEncuesta(encuesta);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DatawebPackage.CUESTIONARIO: {
				Cuestionario cuestionario = (Cuestionario)theEObject;
				T result = caseCuestionario(cuestionario);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DatawebPackage.PREGUNTA: {
				Pregunta pregunta = (Pregunta)theEObject;
				T result = casePregunta(pregunta);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DatawebPackage.PREGUNTA_OPCION_MULTIPLE: {
				PreguntaOpcionMultiple preguntaOpcionMultiple = (PreguntaOpcionMultiple)theEObject;
				T result = casePreguntaOpcionMultiple(preguntaOpcionMultiple);
				if (result == null) result = casePregunta(preguntaOpcionMultiple);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DatawebPackage.OPCION_RESPUESTA: {
				OpcionRespuesta opcionRespuesta = (OpcionRespuesta)theEObject;
				T result = caseOpcionRespuesta(opcionRespuesta);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DatawebPackage.PREGUNTA_VERDADERO_FALSO: {
				PreguntaVerdaderoFalso preguntaVerdaderoFalso = (PreguntaVerdaderoFalso)theEObject;
				T result = casePreguntaVerdaderoFalso(preguntaVerdaderoFalso);
				if (result == null) result = casePregunta(preguntaVerdaderoFalso);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DatawebPackage.PREGUNTA_RESPUESTA_CORTA: {
				PreguntaRespuestaCorta preguntaRespuestaCorta = (PreguntaRespuestaCorta)theEObject;
				T result = casePreguntaRespuestaCorta(preguntaRespuestaCorta);
				if (result == null) result = casePregunta(preguntaRespuestaCorta);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DatawebPackage.RED_SOCIAL: {
				RedSocial redSocial = (RedSocial)theEObject;
				T result = caseRedSocial(redSocial);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DatawebPackage.ROL: {
				Rol rol = (Rol)theEObject;
				T result = caseRol(rol);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DatawebPackage.FUENTE_RSS: {
				FuenteRSS fuenteRSS = (FuenteRSS)theEObject;
				T result = caseFuenteRSS(fuenteRSS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DatawebPackage.PAGINA_INDICE_PAGINADA: {
				PaginaIndicePaginada paginaIndicePaginada = (PaginaIndicePaginada)theEObject;
				T result = casePaginaIndicePaginada(paginaIndicePaginada);
				if (result == null) result = casePaginaIndice(paginaIndicePaginada);
				if (result == null) result = casePaginaCRUD(paginaIndicePaginada);
				if (result == null) result = casePagina(paginaIndicePaginada);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DatawebPackage.PAGINA_INDICE_FILTROS: {
				PaginaIndiceFiltros paginaIndiceFiltros = (PaginaIndiceFiltros)theEObject;
				T result = casePaginaIndiceFiltros(paginaIndiceFiltros);
				if (result == null) result = casePaginaIndice(paginaIndiceFiltros);
				if (result == null) result = casePaginaCRUD(paginaIndiceFiltros);
				if (result == null) result = casePagina(paginaIndiceFiltros);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DatawebPackage.PAGINA_INDICE_PAGINADA_FILTRADA: {
				PaginaIndicePaginadaFiltrada paginaIndicePaginadaFiltrada = (PaginaIndicePaginadaFiltrada)theEObject;
				T result = casePaginaIndicePaginadaFiltrada(paginaIndicePaginadaFiltrada);
				if (result == null) result = casePaginaIndice(paginaIndicePaginadaFiltrada);
				if (result == null) result = casePaginaCRUD(paginaIndicePaginadaFiltrada);
				if (result == null) result = casePagina(paginaIndicePaginadaFiltrada);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Aplicacion</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Aplicacion</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAplicacion(Aplicacion object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entidad</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entidad</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntidad(Entidad object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Atributo</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Atributo</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAtributo(Atributo object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Referencia</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Referencia</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReferencia(Referencia object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pagina</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pagina</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePagina(Pagina object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pagina Home</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pagina Home</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePaginaHome(PaginaHome object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pagina Contenido</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pagina Contenido</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePaginaContenido(PaginaContenido object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pagina CRUD</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pagina CRUD</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePaginaCRUD(PaginaCRUD object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pagina Indice</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pagina Indice</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePaginaIndice(PaginaIndice object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pagina Detalle</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pagina Detalle</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePaginaDetalle(PaginaDetalle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pagina Creacion</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pagina Creacion</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePaginaCreacion(PaginaCreacion object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pagina Actualizacion</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pagina Actualizacion</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePaginaActualizacion(PaginaActualizacion object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pagina Borrado</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pagina Borrado</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePaginaBorrado(PaginaBorrado object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pagina Indice Detalle</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pagina Indice Detalle</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePaginaIndiceDetalle(PaginaIndiceDetalle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Encuesta</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Encuesta</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEncuesta(Encuesta object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cuestionario</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cuestionario</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCuestionario(Cuestionario object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pregunta</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pregunta</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePregunta(Pregunta object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pregunta Opcion Multiple</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pregunta Opcion Multiple</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePreguntaOpcionMultiple(PreguntaOpcionMultiple object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Opcion Respuesta</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Opcion Respuesta</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOpcionRespuesta(OpcionRespuesta object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pregunta Verdadero Falso</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pregunta Verdadero Falso</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePreguntaVerdaderoFalso(PreguntaVerdaderoFalso object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pregunta Respuesta Corta</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pregunta Respuesta Corta</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePreguntaRespuestaCorta(PreguntaRespuestaCorta object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Red Social</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Red Social</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRedSocial(RedSocial object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rol</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rol</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRol(Rol object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fuente RSS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fuente RSS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFuenteRSS(FuenteRSS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pagina Indice Paginada</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pagina Indice Paginada</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePaginaIndicePaginada(PaginaIndicePaginada object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pagina Indice Filtros</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pagina Indice Filtros</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePaginaIndiceFiltros(PaginaIndiceFiltros object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pagina Indice Paginada Filtrada</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pagina Indice Paginada Filtrada</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePaginaIndicePaginadaFiltrada(PaginaIndicePaginadaFiltrada object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //DatawebSwitch
