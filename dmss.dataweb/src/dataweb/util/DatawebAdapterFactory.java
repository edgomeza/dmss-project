/**
 */
package dataweb.util;

import dataweb.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see dataweb.DatawebPackage
 * @generated
 */
public class DatawebAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DatawebPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DatawebAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = DatawebPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DatawebSwitch<Adapter> modelSwitch =
		new DatawebSwitch<Adapter>() {
			@Override
			public Adapter caseAplicacion(Aplicacion object) {
				return createAplicacionAdapter();
			}
			@Override
			public Adapter caseEntidad(Entidad object) {
				return createEntidadAdapter();
			}
			@Override
			public Adapter caseAtributo(Atributo object) {
				return createAtributoAdapter();
			}
			@Override
			public Adapter caseReferencia(Referencia object) {
				return createReferenciaAdapter();
			}
			@Override
			public Adapter casePagina(Pagina object) {
				return createPaginaAdapter();
			}
			@Override
			public Adapter casePaginaHome(PaginaHome object) {
				return createPaginaHomeAdapter();
			}
			@Override
			public Adapter casePaginaContenido(PaginaContenido object) {
				return createPaginaContenidoAdapter();
			}
			@Override
			public Adapter casePaginaCRUD(PaginaCRUD object) {
				return createPaginaCRUDAdapter();
			}
			@Override
			public Adapter casePaginaIndice(PaginaIndice object) {
				return createPaginaIndiceAdapter();
			}
			@Override
			public Adapter casePaginaDetalle(PaginaDetalle object) {
				return createPaginaDetalleAdapter();
			}
			@Override
			public Adapter casePaginaCreacion(PaginaCreacion object) {
				return createPaginaCreacionAdapter();
			}
			@Override
			public Adapter casePaginaActualizacion(PaginaActualizacion object) {
				return createPaginaActualizacionAdapter();
			}
			@Override
			public Adapter casePaginaBorrado(PaginaBorrado object) {
				return createPaginaBorradoAdapter();
			}
			@Override
			public Adapter casePaginaIndiceDetalle(PaginaIndiceDetalle object) {
				return createPaginaIndiceDetalleAdapter();
			}
			@Override
			public Adapter caseEncuesta(Encuesta object) {
				return createEncuestaAdapter();
			}
			@Override
			public Adapter caseCuestionario(Cuestionario object) {
				return createCuestionarioAdapter();
			}
			@Override
			public Adapter casePregunta(Pregunta object) {
				return createPreguntaAdapter();
			}
			@Override
			public Adapter casePreguntaOpcionMultiple(PreguntaOpcionMultiple object) {
				return createPreguntaOpcionMultipleAdapter();
			}
			@Override
			public Adapter caseOpcionRespuesta(OpcionRespuesta object) {
				return createOpcionRespuestaAdapter();
			}
			@Override
			public Adapter casePreguntaVerdaderoFalso(PreguntaVerdaderoFalso object) {
				return createPreguntaVerdaderoFalsoAdapter();
			}
			@Override
			public Adapter casePreguntaRespuestaCorta(PreguntaRespuestaCorta object) {
				return createPreguntaRespuestaCortaAdapter();
			}
			@Override
			public Adapter caseRedSocial(RedSocial object) {
				return createRedSocialAdapter();
			}
			@Override
			public Adapter caseRol(Rol object) {
				return createRolAdapter();
			}
			@Override
			public Adapter caseFuenteRSS(FuenteRSS object) {
				return createFuenteRSSAdapter();
			}
			@Override
			public Adapter casePaginaIndicePaginada(PaginaIndicePaginada object) {
				return createPaginaIndicePaginadaAdapter();
			}
			@Override
			public Adapter casePaginaIndiceFiltros(PaginaIndiceFiltros object) {
				return createPaginaIndiceFiltrosAdapter();
			}
			@Override
			public Adapter casePaginaIndicePaginadaFiltrada(PaginaIndicePaginadaFiltrada object) {
				return createPaginaIndicePaginadaFiltradaAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link dataweb.Aplicacion <em>Aplicacion</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dataweb.Aplicacion
	 * @generated
	 */
	public Adapter createAplicacionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dataweb.Entidad <em>Entidad</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dataweb.Entidad
	 * @generated
	 */
	public Adapter createEntidadAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dataweb.Atributo <em>Atributo</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dataweb.Atributo
	 * @generated
	 */
	public Adapter createAtributoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dataweb.Referencia <em>Referencia</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dataweb.Referencia
	 * @generated
	 */
	public Adapter createReferenciaAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dataweb.Pagina <em>Pagina</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dataweb.Pagina
	 * @generated
	 */
	public Adapter createPaginaAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dataweb.PaginaHome <em>Pagina Home</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dataweb.PaginaHome
	 * @generated
	 */
	public Adapter createPaginaHomeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dataweb.PaginaContenido <em>Pagina Contenido</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dataweb.PaginaContenido
	 * @generated
	 */
	public Adapter createPaginaContenidoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dataweb.PaginaCRUD <em>Pagina CRUD</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dataweb.PaginaCRUD
	 * @generated
	 */
	public Adapter createPaginaCRUDAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dataweb.PaginaIndice <em>Pagina Indice</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dataweb.PaginaIndice
	 * @generated
	 */
	public Adapter createPaginaIndiceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dataweb.PaginaDetalle <em>Pagina Detalle</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dataweb.PaginaDetalle
	 * @generated
	 */
	public Adapter createPaginaDetalleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dataweb.PaginaCreacion <em>Pagina Creacion</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dataweb.PaginaCreacion
	 * @generated
	 */
	public Adapter createPaginaCreacionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dataweb.PaginaActualizacion <em>Pagina Actualizacion</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dataweb.PaginaActualizacion
	 * @generated
	 */
	public Adapter createPaginaActualizacionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dataweb.PaginaBorrado <em>Pagina Borrado</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dataweb.PaginaBorrado
	 * @generated
	 */
	public Adapter createPaginaBorradoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dataweb.PaginaIndiceDetalle <em>Pagina Indice Detalle</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dataweb.PaginaIndiceDetalle
	 * @generated
	 */
	public Adapter createPaginaIndiceDetalleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dataweb.Encuesta <em>Encuesta</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dataweb.Encuesta
	 * @generated
	 */
	public Adapter createEncuestaAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dataweb.Cuestionario <em>Cuestionario</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dataweb.Cuestionario
	 * @generated
	 */
	public Adapter createCuestionarioAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dataweb.Pregunta <em>Pregunta</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dataweb.Pregunta
	 * @generated
	 */
	public Adapter createPreguntaAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dataweb.PreguntaOpcionMultiple <em>Pregunta Opcion Multiple</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dataweb.PreguntaOpcionMultiple
	 * @generated
	 */
	public Adapter createPreguntaOpcionMultipleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dataweb.OpcionRespuesta <em>Opcion Respuesta</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dataweb.OpcionRespuesta
	 * @generated
	 */
	public Adapter createOpcionRespuestaAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dataweb.PreguntaVerdaderoFalso <em>Pregunta Verdadero Falso</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dataweb.PreguntaVerdaderoFalso
	 * @generated
	 */
	public Adapter createPreguntaVerdaderoFalsoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dataweb.PreguntaRespuestaCorta <em>Pregunta Respuesta Corta</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dataweb.PreguntaRespuestaCorta
	 * @generated
	 */
	public Adapter createPreguntaRespuestaCortaAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dataweb.RedSocial <em>Red Social</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dataweb.RedSocial
	 * @generated
	 */
	public Adapter createRedSocialAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dataweb.Rol <em>Rol</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dataweb.Rol
	 * @generated
	 */
	public Adapter createRolAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dataweb.FuenteRSS <em>Fuente RSS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dataweb.FuenteRSS
	 * @generated
	 */
	public Adapter createFuenteRSSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dataweb.PaginaIndicePaginada <em>Pagina Indice Paginada</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dataweb.PaginaIndicePaginada
	 * @generated
	 */
	public Adapter createPaginaIndicePaginadaAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dataweb.PaginaIndiceFiltros <em>Pagina Indice Filtros</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dataweb.PaginaIndiceFiltros
	 * @generated
	 */
	public Adapter createPaginaIndiceFiltrosAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dataweb.PaginaIndicePaginadaFiltrada <em>Pagina Indice Paginada Filtrada</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dataweb.PaginaIndicePaginadaFiltrada
	 * @generated
	 */
	public Adapter createPaginaIndicePaginadaFiltradaAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //DatawebAdapterFactory
