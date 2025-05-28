/**
 */
package dataweb.impl;

import dataweb.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DatawebFactoryImpl extends EFactoryImpl implements DatawebFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DatawebFactory init() {
		try {
			DatawebFactory theDatawebFactory = (DatawebFactory)EPackage.Registry.INSTANCE.getEFactory(DatawebPackage.eNS_URI);
			if (theDatawebFactory != null) {
				return theDatawebFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DatawebFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DatawebFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case DatawebPackage.APLICACION: return createAplicacion();
			case DatawebPackage.ENTIDAD: return createEntidad();
			case DatawebPackage.ATRIBUTO: return createAtributo();
			case DatawebPackage.REFERENCIA: return createReferencia();
			case DatawebPackage.PAGINA_HOME: return createPaginaHome();
			case DatawebPackage.PAGINA_CONTENIDO: return createPaginaContenido();
			case DatawebPackage.PAGINA_DETALLE: return createPaginaDetalle();
			case DatawebPackage.PAGINA_CREACION: return createPaginaCreacion();
			case DatawebPackage.PAGINA_ACTUALIZACION: return createPaginaActualizacion();
			case DatawebPackage.PAGINA_BORRADO: return createPaginaBorrado();
			case DatawebPackage.PAGINA_INDICE_DETALLE: return createPaginaIndiceDetalle();
			case DatawebPackage.ENCUESTA: return createEncuesta();
			case DatawebPackage.CUESTIONARIO: return createCuestionario();
			case DatawebPackage.PREGUNTA_OPCION_MULTIPLE: return createPreguntaOpcionMultiple();
			case DatawebPackage.OPCION_RESPUESTA: return createOpcionRespuesta();
			case DatawebPackage.PREGUNTA_VERDADERO_FALSO: return createPreguntaVerdaderoFalso();
			case DatawebPackage.PREGUNTA_RESPUESTA_CORTA: return createPreguntaRespuestaCorta();
			case DatawebPackage.RED_SOCIAL: return createRedSocial();
			case DatawebPackage.ROL: return createRol();
			case DatawebPackage.FUENTE_RSS: return createFuenteRSS();
			case DatawebPackage.PAGINA_INDICE_PAGINADA: return createPaginaIndicePaginada();
			case DatawebPackage.PAGINA_INDICE_FILTROS: return createPaginaIndiceFiltros();
			case DatawebPackage.PAGINA_INDICE_PAGINADA_FILTRADA: return createPaginaIndicePaginadaFiltrada();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case DatawebPackage.TIPO_ATRIBUTO:
				return createTipoAtributoFromString(eDataType, initialValue);
			case DatawebPackage.TIPO_REPRESENTACION:
				return createTipoRepresentacionFromString(eDataType, initialValue);
			case DatawebPackage.TIPO_RED_SOCIAL:
				return createTipoRedSocialFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case DatawebPackage.TIPO_ATRIBUTO:
				return convertTipoAtributoToString(eDataType, instanceValue);
			case DatawebPackage.TIPO_REPRESENTACION:
				return convertTipoRepresentacionToString(eDataType, instanceValue);
			case DatawebPackage.TIPO_RED_SOCIAL:
				return convertTipoRedSocialToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Aplicacion createAplicacion() {
		AplicacionImpl aplicacion = new AplicacionImpl();
		return aplicacion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Entidad createEntidad() {
		EntidadImpl entidad = new EntidadImpl();
		return entidad;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Atributo createAtributo() {
		AtributoImpl atributo = new AtributoImpl();
		return atributo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Referencia createReferencia() {
		ReferenciaImpl referencia = new ReferenciaImpl();
		return referencia;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PaginaHome createPaginaHome() {
		PaginaHomeImpl paginaHome = new PaginaHomeImpl();
		return paginaHome;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PaginaContenido createPaginaContenido() {
		PaginaContenidoImpl paginaContenido = new PaginaContenidoImpl();
		return paginaContenido;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PaginaDetalle createPaginaDetalle() {
		PaginaDetalleImpl paginaDetalle = new PaginaDetalleImpl();
		return paginaDetalle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PaginaCreacion createPaginaCreacion() {
		PaginaCreacionImpl paginaCreacion = new PaginaCreacionImpl();
		return paginaCreacion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PaginaActualizacion createPaginaActualizacion() {
		PaginaActualizacionImpl paginaActualizacion = new PaginaActualizacionImpl();
		return paginaActualizacion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PaginaBorrado createPaginaBorrado() {
		PaginaBorradoImpl paginaBorrado = new PaginaBorradoImpl();
		return paginaBorrado;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PaginaIndiceDetalle createPaginaIndiceDetalle() {
		PaginaIndiceDetalleImpl paginaIndiceDetalle = new PaginaIndiceDetalleImpl();
		return paginaIndiceDetalle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Encuesta createEncuesta() {
		EncuestaImpl encuesta = new EncuestaImpl();
		return encuesta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Cuestionario createCuestionario() {
		CuestionarioImpl cuestionario = new CuestionarioImpl();
		return cuestionario;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PreguntaOpcionMultiple createPreguntaOpcionMultiple() {
		PreguntaOpcionMultipleImpl preguntaOpcionMultiple = new PreguntaOpcionMultipleImpl();
		return preguntaOpcionMultiple;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OpcionRespuesta createOpcionRespuesta() {
		OpcionRespuestaImpl opcionRespuesta = new OpcionRespuestaImpl();
		return opcionRespuesta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PreguntaVerdaderoFalso createPreguntaVerdaderoFalso() {
		PreguntaVerdaderoFalsoImpl preguntaVerdaderoFalso = new PreguntaVerdaderoFalsoImpl();
		return preguntaVerdaderoFalso;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PreguntaRespuestaCorta createPreguntaRespuestaCorta() {
		PreguntaRespuestaCortaImpl preguntaRespuestaCorta = new PreguntaRespuestaCortaImpl();
		return preguntaRespuestaCorta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RedSocial createRedSocial() {
		RedSocialImpl redSocial = new RedSocialImpl();
		return redSocial;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Rol createRol() {
		RolImpl rol = new RolImpl();
		return rol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FuenteRSS createFuenteRSS() {
		FuenteRSSImpl fuenteRSS = new FuenteRSSImpl();
		return fuenteRSS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PaginaIndicePaginada createPaginaIndicePaginada() {
		PaginaIndicePaginadaImpl paginaIndicePaginada = new PaginaIndicePaginadaImpl();
		return paginaIndicePaginada;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PaginaIndiceFiltros createPaginaIndiceFiltros() {
		PaginaIndiceFiltrosImpl paginaIndiceFiltros = new PaginaIndiceFiltrosImpl();
		return paginaIndiceFiltros;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PaginaIndicePaginadaFiltrada createPaginaIndicePaginadaFiltrada() {
		PaginaIndicePaginadaFiltradaImpl paginaIndicePaginadaFiltrada = new PaginaIndicePaginadaFiltradaImpl();
		return paginaIndicePaginadaFiltrada;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TipoAtributo createTipoAtributoFromString(EDataType eDataType, String initialValue) {
		TipoAtributo result = TipoAtributo.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTipoAtributoToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TipoRepresentacion createTipoRepresentacionFromString(EDataType eDataType, String initialValue) {
		TipoRepresentacion result = TipoRepresentacion.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTipoRepresentacionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TipoRedSocial createTipoRedSocialFromString(EDataType eDataType, String initialValue) {
		TipoRedSocial result = TipoRedSocial.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTipoRedSocialToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DatawebPackage getDatawebPackage() {
		return (DatawebPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DatawebPackage getPackage() {
		return DatawebPackage.eINSTANCE;
	}

} //DatawebFactoryImpl
