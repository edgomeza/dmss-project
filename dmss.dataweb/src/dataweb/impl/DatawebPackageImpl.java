/**
 */
package dataweb.impl;

import dataweb.Aplicacion;
import dataweb.Atributo;
import dataweb.Cuestionario;
import dataweb.DatawebFactory;
import dataweb.DatawebPackage;
import dataweb.Encuesta;
import dataweb.Entidad;
import dataweb.FuenteRSS;
import dataweb.OpcionRespuesta;
import dataweb.Pagina;
import dataweb.PaginaActualizacion;
import dataweb.PaginaBorrado;
import dataweb.PaginaCRUD;
import dataweb.PaginaContenido;
import dataweb.PaginaCreacion;
import dataweb.PaginaDetalle;
import dataweb.PaginaHome;
import dataweb.PaginaIndice;
import dataweb.PaginaIndiceDetalle;
import dataweb.PaginaIndiceFiltros;
import dataweb.PaginaIndicePaginada;
import dataweb.PaginaIndicePaginadaFiltrada;
import dataweb.Pregunta;
import dataweb.PreguntaOpcionMultiple;
import dataweb.PreguntaRespuestaCorta;
import dataweb.PreguntaVerdaderoFalso;
import dataweb.RedSocial;
import dataweb.Referencia;
import dataweb.Rol;
import dataweb.TipoAtributo;
import dataweb.TipoRedSocial;
import dataweb.TipoRepresentacion;

import dataweb.util.DatawebValidator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DatawebPackageImpl extends EPackageImpl implements DatawebPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass aplicacionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entidadEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass atributoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referenciaEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass paginaEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass paginaHomeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass paginaContenidoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass paginaCRUDEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass paginaIndiceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass paginaDetalleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass paginaCreacionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass paginaActualizacionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass paginaBorradoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass paginaIndiceDetalleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass encuestaEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cuestionarioEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass preguntaEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass preguntaOpcionMultipleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass opcionRespuestaEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass preguntaVerdaderoFalsoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass preguntaRespuestaCortaEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass redSocialEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rolEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fuenteRSSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass paginaIndicePaginadaEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass paginaIndiceFiltrosEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass paginaIndicePaginadaFiltradaEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum tipoAtributoEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum tipoRepresentacionEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum tipoRedSocialEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see dataweb.DatawebPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DatawebPackageImpl() {
		super(eNS_URI, DatawebFactory.eINSTANCE);
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link DatawebPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DatawebPackage init() {
		if (isInited) return (DatawebPackage)EPackage.Registry.INSTANCE.getEPackage(DatawebPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredDatawebPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		DatawebPackageImpl theDatawebPackage = registeredDatawebPackage instanceof DatawebPackageImpl ? (DatawebPackageImpl)registeredDatawebPackage : new DatawebPackageImpl();

		isInited = true;

		// Create package meta-data objects
		theDatawebPackage.createPackageContents();

		// Initialize created meta-data
		theDatawebPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theDatawebPackage,
			 new EValidator.Descriptor() {
				 @Override
				 public EValidator getEValidator() {
					 return DatawebValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theDatawebPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DatawebPackage.eNS_URI, theDatawebPackage);
		return theDatawebPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAplicacion() {
		return aplicacionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAplicacion_Nombre() {
		return (EAttribute)aplicacionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAplicacion_Descripcion() {
		return (EAttribute)aplicacionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAplicacion_Entidades() {
		return (EReference)aplicacionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAplicacion_Paginas() {
		return (EReference)aplicacionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAplicacion_Roles() {
		return (EReference)aplicacionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAplicacion_Cuestionarios() {
		return (EReference)aplicacionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAplicacion_Encuestas() {
		return (EReference)aplicacionEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAplicacion_RedesSociales() {
		return (EReference)aplicacionEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAplicacion_FuentesRSS() {
		return (EReference)aplicacionEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAplicacion_PaginasMediasAccesibles() {
		return (EAttribute)aplicacionEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEntidad() {
		return entidadEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEntidad_Nombre() {
		return (EAttribute)entidadEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEntidad_TableName() {
		return (EAttribute)entidadEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEntidad_HasCRUD() {
		return (EAttribute)entidadEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEntidad_HasIndex() {
		return (EAttribute)entidadEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEntidad_HasExtendedIndex() {
		return (EAttribute)entidadEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEntidad_HasDetails() {
		return (EAttribute)entidadEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEntidad_HasCreate() {
		return (EAttribute)entidadEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEntidad_HasUpdate() {
		return (EAttribute)entidadEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEntidad_HasDelete() {
		return (EAttribute)entidadEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEntidad_Atributos() {
		return (EReference)entidadEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEntidad_Referencias() {
		return (EReference)entidadEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAtributo() {
		return atributoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAtributo_Nombre() {
		return (EAttribute)atributoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAtributo_IsPrimaryKey() {
		return (EAttribute)atributoEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAtributo_Tipo() {
		return (EAttribute)atributoEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getReferencia() {
		return referenciaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getReferencia_Nombre() {
		return (EAttribute)referenciaEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getReferencia_Multiplicidad() {
		return (EAttribute)referenciaEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getReferencia_Source() {
		return (EReference)referenciaEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getReferencia_Target() {
		return (EReference)referenciaEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPagina() {
		return paginaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPagina_Enlaces() {
		return (EReference)paginaEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPagina_RedesSociales() {
		return (EReference)paginaEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPagina_FuentesRSS() {
		return (EReference)paginaEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPagina_Nombre() {
		return (EAttribute)paginaEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPagina_Titulo() {
		return (EAttribute)paginaEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPagina_Descripcion() {
		return (EAttribute)paginaEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPaginaHome() {
		return paginaHomeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPaginaContenido() {
		return paginaContenidoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPaginaContenido_Contenido() {
		return (EAttribute)paginaContenidoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPaginaCRUD() {
		return paginaCRUDEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPaginaCRUD_Entidad() {
		return (EReference)paginaCRUDEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPaginaIndice() {
		return paginaIndiceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPaginaIndice_AtributosMostrados() {
		return (EReference)paginaIndiceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPaginaDetalle() {
		return paginaDetalleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPaginaCreacion() {
		return paginaCreacionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPaginaActualizacion() {
		return paginaActualizacionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPaginaBorrado() {
		return paginaBorradoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPaginaIndiceDetalle() {
		return paginaIndiceDetalleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEncuesta() {
		return encuestaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEncuesta_Preguntas() {
		return (EReference)encuestaEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEncuesta_Nombre() {
		return (EAttribute)encuestaEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEncuesta_Descripcion() {
		return (EAttribute)encuestaEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEncuesta_TipoRepresentacion() {
		return (EAttribute)encuestaEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEncuesta_Titulo() {
		return (EAttribute)encuestaEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEncuesta_NumeroPregVF() {
		return (EAttribute)encuestaEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEncuesta_NumeroPregSelect() {
		return (EAttribute)encuestaEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCuestionario() {
		return cuestionarioEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCuestionario_Preguntas() {
		return (EReference)cuestionarioEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCuestionario_Nombre() {
		return (EAttribute)cuestionarioEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCuestionario_Descripcion() {
		return (EAttribute)cuestionarioEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCuestionario_Titulo() {
		return (EAttribute)cuestionarioEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCuestionario_NumeroPregVF() {
		return (EAttribute)cuestionarioEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCuestionario_NumeroPregSelect() {
		return (EAttribute)cuestionarioEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPregunta() {
		return preguntaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPregunta_Nombre() {
		return (EAttribute)preguntaEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPregunta_Texto() {
		return (EAttribute)preguntaEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPreguntaOpcionMultiple() {
		return preguntaOpcionMultipleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPreguntaOpcionMultiple_Opciones() {
		return (EReference)preguntaOpcionMultipleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPreguntaOpcionMultiple_RespuestaCorrecta() {
		return (EReference)preguntaOpcionMultipleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getOpcionRespuesta() {
		return opcionRespuestaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOpcionRespuesta_Nombre() {
		return (EAttribute)opcionRespuestaEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOpcionRespuesta_Texto() {
		return (EAttribute)opcionRespuestaEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOpcionRespuesta_Valor() {
		return (EAttribute)opcionRespuestaEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPreguntaVerdaderoFalso() {
		return preguntaVerdaderoFalsoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPreguntaVerdaderoFalso_RespuestaCorrecta() {
		return (EAttribute)preguntaVerdaderoFalsoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPreguntaRespuestaCorta() {
		return preguntaRespuestaCortaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPreguntaRespuestaCorta_RespuestaCorta() {
		return (EAttribute)preguntaRespuestaCortaEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRedSocial() {
		return redSocialEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRedSocial_Tipo() {
		return (EAttribute)redSocialEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRedSocial_Nombre() {
		return (EAttribute)redSocialEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRedSocial_CodigoEmbed() {
		return (EAttribute)redSocialEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRedSocial_NombreCuenta() {
		return (EAttribute)redSocialEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRol() {
		return rolEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRol_Nombre() {
		return (EAttribute)rolEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRol_Descripcion() {
		return (EAttribute)rolEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRol_PaginasAccesibles() {
		return (EReference)rolEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRol_NumeroEntidadesAccesibles() {
		return (EAttribute)rolEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFuenteRSS() {
		return fuenteRSSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFuenteRSS_Nombre() {
		return (EAttribute)fuenteRSSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFuenteRSS_Url() {
		return (EAttribute)fuenteRSSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFuenteRSS_Titulo() {
		return (EAttribute)fuenteRSSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFuenteRSS_NumItems() {
		return (EAttribute)fuenteRSSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFuenteRSS_MostrarDescripcion() {
		return (EAttribute)fuenteRSSEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPaginaIndicePaginada() {
		return paginaIndicePaginadaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPaginaIndicePaginada_PageSize() {
		return (EAttribute)paginaIndicePaginadaEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPaginaIndiceFiltros() {
		return paginaIndiceFiltrosEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPaginaIndiceFiltros_AtributosFiltro() {
		return (EReference)paginaIndiceFiltrosEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPaginaIndicePaginadaFiltrada() {
		return paginaIndicePaginadaFiltradaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPaginaIndicePaginadaFiltrada_PageSize() {
		return (EAttribute)paginaIndicePaginadaFiltradaEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPaginaIndicePaginadaFiltrada_AtributosFiltro() {
		return (EReference)paginaIndicePaginadaFiltradaEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getTipoAtributo() {
		return tipoAtributoEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getTipoRepresentacion() {
		return tipoRepresentacionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getTipoRedSocial() {
		return tipoRedSocialEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DatawebFactory getDatawebFactory() {
		return (DatawebFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		aplicacionEClass = createEClass(APLICACION);
		createEAttribute(aplicacionEClass, APLICACION__NOMBRE);
		createEAttribute(aplicacionEClass, APLICACION__DESCRIPCION);
		createEReference(aplicacionEClass, APLICACION__ENTIDADES);
		createEReference(aplicacionEClass, APLICACION__PAGINAS);
		createEReference(aplicacionEClass, APLICACION__ROLES);
		createEReference(aplicacionEClass, APLICACION__CUESTIONARIOS);
		createEReference(aplicacionEClass, APLICACION__ENCUESTAS);
		createEReference(aplicacionEClass, APLICACION__REDES_SOCIALES);
		createEReference(aplicacionEClass, APLICACION__FUENTES_RSS);
		createEAttribute(aplicacionEClass, APLICACION__PAGINAS_MEDIAS_ACCESIBLES);

		entidadEClass = createEClass(ENTIDAD);
		createEAttribute(entidadEClass, ENTIDAD__NOMBRE);
		createEAttribute(entidadEClass, ENTIDAD__TABLE_NAME);
		createEAttribute(entidadEClass, ENTIDAD__HAS_CRUD);
		createEAttribute(entidadEClass, ENTIDAD__HAS_INDEX);
		createEAttribute(entidadEClass, ENTIDAD__HAS_EXTENDED_INDEX);
		createEAttribute(entidadEClass, ENTIDAD__HAS_DETAILS);
		createEAttribute(entidadEClass, ENTIDAD__HAS_CREATE);
		createEAttribute(entidadEClass, ENTIDAD__HAS_UPDATE);
		createEAttribute(entidadEClass, ENTIDAD__HAS_DELETE);
		createEReference(entidadEClass, ENTIDAD__ATRIBUTOS);
		createEReference(entidadEClass, ENTIDAD__REFERENCIAS);

		atributoEClass = createEClass(ATRIBUTO);
		createEAttribute(atributoEClass, ATRIBUTO__NOMBRE);
		createEAttribute(atributoEClass, ATRIBUTO__IS_PRIMARY_KEY);
		createEAttribute(atributoEClass, ATRIBUTO__TIPO);

		referenciaEClass = createEClass(REFERENCIA);
		createEAttribute(referenciaEClass, REFERENCIA__NOMBRE);
		createEAttribute(referenciaEClass, REFERENCIA__MULTIPLICIDAD);
		createEReference(referenciaEClass, REFERENCIA__SOURCE);
		createEReference(referenciaEClass, REFERENCIA__TARGET);

		paginaEClass = createEClass(PAGINA);
		createEReference(paginaEClass, PAGINA__ENLACES);
		createEReference(paginaEClass, PAGINA__REDES_SOCIALES);
		createEReference(paginaEClass, PAGINA__FUENTES_RSS);
		createEAttribute(paginaEClass, PAGINA__NOMBRE);
		createEAttribute(paginaEClass, PAGINA__TITULO);
		createEAttribute(paginaEClass, PAGINA__DESCRIPCION);

		paginaHomeEClass = createEClass(PAGINA_HOME);

		paginaContenidoEClass = createEClass(PAGINA_CONTENIDO);
		createEAttribute(paginaContenidoEClass, PAGINA_CONTENIDO__CONTENIDO);

		paginaCRUDEClass = createEClass(PAGINA_CRUD);
		createEReference(paginaCRUDEClass, PAGINA_CRUD__ENTIDAD);

		paginaIndiceEClass = createEClass(PAGINA_INDICE);
		createEReference(paginaIndiceEClass, PAGINA_INDICE__ATRIBUTOS_MOSTRADOS);

		paginaDetalleEClass = createEClass(PAGINA_DETALLE);

		paginaCreacionEClass = createEClass(PAGINA_CREACION);

		paginaActualizacionEClass = createEClass(PAGINA_ACTUALIZACION);

		paginaBorradoEClass = createEClass(PAGINA_BORRADO);

		paginaIndiceDetalleEClass = createEClass(PAGINA_INDICE_DETALLE);

		encuestaEClass = createEClass(ENCUESTA);
		createEReference(encuestaEClass, ENCUESTA__PREGUNTAS);
		createEAttribute(encuestaEClass, ENCUESTA__NOMBRE);
		createEAttribute(encuestaEClass, ENCUESTA__DESCRIPCION);
		createEAttribute(encuestaEClass, ENCUESTA__TIPO_REPRESENTACION);
		createEAttribute(encuestaEClass, ENCUESTA__TITULO);
		createEAttribute(encuestaEClass, ENCUESTA__NUMERO_PREG_VF);
		createEAttribute(encuestaEClass, ENCUESTA__NUMERO_PREG_SELECT);

		cuestionarioEClass = createEClass(CUESTIONARIO);
		createEReference(cuestionarioEClass, CUESTIONARIO__PREGUNTAS);
		createEAttribute(cuestionarioEClass, CUESTIONARIO__NOMBRE);
		createEAttribute(cuestionarioEClass, CUESTIONARIO__DESCRIPCION);
		createEAttribute(cuestionarioEClass, CUESTIONARIO__TITULO);
		createEAttribute(cuestionarioEClass, CUESTIONARIO__NUMERO_PREG_VF);
		createEAttribute(cuestionarioEClass, CUESTIONARIO__NUMERO_PREG_SELECT);

		preguntaEClass = createEClass(PREGUNTA);
		createEAttribute(preguntaEClass, PREGUNTA__NOMBRE);
		createEAttribute(preguntaEClass, PREGUNTA__TEXTO);

		preguntaOpcionMultipleEClass = createEClass(PREGUNTA_OPCION_MULTIPLE);
		createEReference(preguntaOpcionMultipleEClass, PREGUNTA_OPCION_MULTIPLE__OPCIONES);
		createEReference(preguntaOpcionMultipleEClass, PREGUNTA_OPCION_MULTIPLE__RESPUESTA_CORRECTA);

		opcionRespuestaEClass = createEClass(OPCION_RESPUESTA);
		createEAttribute(opcionRespuestaEClass, OPCION_RESPUESTA__NOMBRE);
		createEAttribute(opcionRespuestaEClass, OPCION_RESPUESTA__TEXTO);
		createEAttribute(opcionRespuestaEClass, OPCION_RESPUESTA__VALOR);

		preguntaVerdaderoFalsoEClass = createEClass(PREGUNTA_VERDADERO_FALSO);
		createEAttribute(preguntaVerdaderoFalsoEClass, PREGUNTA_VERDADERO_FALSO__RESPUESTA_CORRECTA);

		preguntaRespuestaCortaEClass = createEClass(PREGUNTA_RESPUESTA_CORTA);
		createEAttribute(preguntaRespuestaCortaEClass, PREGUNTA_RESPUESTA_CORTA__RESPUESTA_CORTA);

		redSocialEClass = createEClass(RED_SOCIAL);
		createEAttribute(redSocialEClass, RED_SOCIAL__TIPO);
		createEAttribute(redSocialEClass, RED_SOCIAL__NOMBRE);
		createEAttribute(redSocialEClass, RED_SOCIAL__CODIGO_EMBED);
		createEAttribute(redSocialEClass, RED_SOCIAL__NOMBRE_CUENTA);

		rolEClass = createEClass(ROL);
		createEAttribute(rolEClass, ROL__NOMBRE);
		createEAttribute(rolEClass, ROL__DESCRIPCION);
		createEReference(rolEClass, ROL__PAGINAS_ACCESIBLES);
		createEAttribute(rolEClass, ROL__NUMERO_ENTIDADES_ACCESIBLES);

		fuenteRSSEClass = createEClass(FUENTE_RSS);
		createEAttribute(fuenteRSSEClass, FUENTE_RSS__NOMBRE);
		createEAttribute(fuenteRSSEClass, FUENTE_RSS__URL);
		createEAttribute(fuenteRSSEClass, FUENTE_RSS__TITULO);
		createEAttribute(fuenteRSSEClass, FUENTE_RSS__NUM_ITEMS);
		createEAttribute(fuenteRSSEClass, FUENTE_RSS__MOSTRAR_DESCRIPCION);

		paginaIndicePaginadaEClass = createEClass(PAGINA_INDICE_PAGINADA);
		createEAttribute(paginaIndicePaginadaEClass, PAGINA_INDICE_PAGINADA__PAGE_SIZE);

		paginaIndiceFiltrosEClass = createEClass(PAGINA_INDICE_FILTROS);
		createEReference(paginaIndiceFiltrosEClass, PAGINA_INDICE_FILTROS__ATRIBUTOS_FILTRO);

		paginaIndicePaginadaFiltradaEClass = createEClass(PAGINA_INDICE_PAGINADA_FILTRADA);
		createEAttribute(paginaIndicePaginadaFiltradaEClass, PAGINA_INDICE_PAGINADA_FILTRADA__PAGE_SIZE);
		createEReference(paginaIndicePaginadaFiltradaEClass, PAGINA_INDICE_PAGINADA_FILTRADA__ATRIBUTOS_FILTRO);

		// Create enums
		tipoAtributoEEnum = createEEnum(TIPO_ATRIBUTO);
		tipoRepresentacionEEnum = createEEnum(TIPO_REPRESENTACION);
		tipoRedSocialEEnum = createEEnum(TIPO_RED_SOCIAL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		paginaHomeEClass.getESuperTypes().add(this.getPagina());
		paginaContenidoEClass.getESuperTypes().add(this.getPagina());
		paginaCRUDEClass.getESuperTypes().add(this.getPagina());
		paginaIndiceEClass.getESuperTypes().add(this.getPaginaCRUD());
		paginaDetalleEClass.getESuperTypes().add(this.getPaginaCRUD());
		paginaCreacionEClass.getESuperTypes().add(this.getPaginaCRUD());
		paginaActualizacionEClass.getESuperTypes().add(this.getPaginaCRUD());
		paginaBorradoEClass.getESuperTypes().add(this.getPaginaCRUD());
		paginaIndiceDetalleEClass.getESuperTypes().add(this.getPaginaIndice());
		preguntaOpcionMultipleEClass.getESuperTypes().add(this.getPregunta());
		preguntaVerdaderoFalsoEClass.getESuperTypes().add(this.getPregunta());
		preguntaRespuestaCortaEClass.getESuperTypes().add(this.getPregunta());
		paginaIndicePaginadaEClass.getESuperTypes().add(this.getPaginaIndice());
		paginaIndiceFiltrosEClass.getESuperTypes().add(this.getPaginaIndice());
		paginaIndicePaginadaFiltradaEClass.getESuperTypes().add(this.getPaginaIndice());

		// Initialize classes, features, and operations; add parameters
		initEClass(aplicacionEClass, Aplicacion.class, "Aplicacion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAplicacion_Nombre(), ecorePackage.getEString(), "nombre", null, 1, 1, Aplicacion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAplicacion_Descripcion(), ecorePackage.getEString(), "descripcion", null, 1, 1, Aplicacion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAplicacion_Entidades(), this.getEntidad(), null, "entidades", null, 1, -1, Aplicacion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAplicacion_Paginas(), this.getPagina(), null, "paginas", null, 1, -1, Aplicacion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAplicacion_Roles(), this.getRol(), null, "roles", null, 1, -1, Aplicacion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAplicacion_Cuestionarios(), this.getCuestionario(), null, "cuestionarios", null, 0, -1, Aplicacion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAplicacion_Encuestas(), this.getEncuesta(), null, "encuestas", null, 0, -1, Aplicacion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAplicacion_RedesSociales(), this.getRedSocial(), null, "redesSociales", null, 1, -1, Aplicacion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAplicacion_FuentesRSS(), this.getFuenteRSS(), null, "fuentesRSS", null, 1, -1, Aplicacion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAplicacion_PaginasMediasAccesibles(), ecorePackage.getEDouble(), "paginasMediasAccesibles", null, 1, 1, Aplicacion.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(entidadEClass, Entidad.class, "Entidad", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEntidad_Nombre(), ecorePackage.getEString(), "nombre", null, 1, 1, Entidad.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEntidad_TableName(), ecorePackage.getEString(), "tableName", null, 1, 1, Entidad.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEntidad_HasCRUD(), ecorePackage.getEBoolean(), "hasCRUD", null, 1, 1, Entidad.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEntidad_HasIndex(), ecorePackage.getEBoolean(), "hasIndex", null, 1, 1, Entidad.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEntidad_HasExtendedIndex(), ecorePackage.getEBoolean(), "hasExtendedIndex", null, 1, 1, Entidad.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEntidad_HasDetails(), ecorePackage.getEBoolean(), "hasDetails", null, 1, 1, Entidad.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEntidad_HasCreate(), ecorePackage.getEBoolean(), "hasCreate", null, 1, 1, Entidad.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEntidad_HasUpdate(), ecorePackage.getEBoolean(), "hasUpdate", null, 1, 1, Entidad.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEntidad_HasDelete(), ecorePackage.getEBoolean(), "hasDelete", null, 1, 1, Entidad.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEntidad_Atributos(), this.getAtributo(), null, "atributos", null, 1, -1, Entidad.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEntidad_Referencias(), this.getReferencia(), null, "referencias", null, 0, -1, Entidad.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(atributoEClass, Atributo.class, "Atributo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAtributo_Nombre(), ecorePackage.getEString(), "nombre", null, 1, 1, Atributo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAtributo_IsPrimaryKey(), ecorePackage.getEBoolean(), "isPrimaryKey", null, 1, 1, Atributo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAtributo_Tipo(), this.getTipoAtributo(), "tipo", null, 1, 1, Atributo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(referenciaEClass, Referencia.class, "Referencia", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getReferencia_Nombre(), ecorePackage.getEString(), "nombre", null, 1, 1, Referencia.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getReferencia_Multiplicidad(), ecorePackage.getEString(), "multiplicidad", null, 1, 1, Referencia.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReferencia_Source(), this.getEntidad(), null, "source", null, 1, 1, Referencia.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReferencia_Target(), this.getEntidad(), null, "target", null, 1, 1, Referencia.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(paginaEClass, Pagina.class, "Pagina", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPagina_Enlaces(), this.getPagina(), null, "enlaces", null, 0, -1, Pagina.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPagina_RedesSociales(), this.getRedSocial(), null, "redesSociales", null, 0, -1, Pagina.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPagina_FuentesRSS(), this.getFuenteRSS(), null, "fuentesRSS", null, 0, -1, Pagina.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPagina_Nombre(), ecorePackage.getEString(), "nombre", null, 1, 1, Pagina.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPagina_Titulo(), ecorePackage.getEString(), "titulo", null, 1, 1, Pagina.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPagina_Descripcion(), ecorePackage.getEString(), "descripcion", null, 0, 1, Pagina.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(paginaHomeEClass, PaginaHome.class, "PaginaHome", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(paginaContenidoEClass, PaginaContenido.class, "PaginaContenido", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPaginaContenido_Contenido(), ecorePackage.getEString(), "contenido", null, 1, 1, PaginaContenido.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(paginaCRUDEClass, PaginaCRUD.class, "PaginaCRUD", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPaginaCRUD_Entidad(), this.getEntidad(), null, "entidad", null, 1, 1, PaginaCRUD.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(paginaIndiceEClass, PaginaIndice.class, "PaginaIndice", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPaginaIndice_AtributosMostrados(), this.getAtributo(), null, "atributosMostrados", null, 1, -1, PaginaIndice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(paginaDetalleEClass, PaginaDetalle.class, "PaginaDetalle", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(paginaCreacionEClass, PaginaCreacion.class, "PaginaCreacion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(paginaActualizacionEClass, PaginaActualizacion.class, "PaginaActualizacion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(paginaBorradoEClass, PaginaBorrado.class, "PaginaBorrado", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(paginaIndiceDetalleEClass, PaginaIndiceDetalle.class, "PaginaIndiceDetalle", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(encuestaEClass, Encuesta.class, "Encuesta", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEncuesta_Preguntas(), this.getPregunta(), null, "preguntas", null, 1, -1, Encuesta.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEncuesta_Nombre(), ecorePackage.getEString(), "nombre", null, 1, 1, Encuesta.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEncuesta_Descripcion(), ecorePackage.getEString(), "descripcion", null, 0, 1, Encuesta.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEncuesta_TipoRepresentacion(), this.getTipoRepresentacion(), "tipoRepresentacion", null, 1, 1, Encuesta.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEncuesta_Titulo(), ecorePackage.getEString(), "titulo", null, 1, 1, Encuesta.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEncuesta_NumeroPregVF(), ecorePackage.getEInt(), "numeroPregVF", null, 1, 1, Encuesta.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getEncuesta_NumeroPregSelect(), ecorePackage.getEInt(), "numeroPregSelect", null, 1, 1, Encuesta.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(cuestionarioEClass, Cuestionario.class, "Cuestionario", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCuestionario_Preguntas(), this.getPregunta(), null, "preguntas", null, 1, -1, Cuestionario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCuestionario_Nombre(), ecorePackage.getEString(), "nombre", null, 1, 1, Cuestionario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCuestionario_Descripcion(), ecorePackage.getEString(), "descripcion", null, 0, 1, Cuestionario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCuestionario_Titulo(), ecorePackage.getEString(), "titulo", null, 1, 1, Cuestionario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCuestionario_NumeroPregVF(), ecorePackage.getEInt(), "numeroPregVF", null, 1, 1, Cuestionario.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getCuestionario_NumeroPregSelect(), ecorePackage.getEInt(), "numeroPregSelect", null, 1, 1, Cuestionario.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(preguntaEClass, Pregunta.class, "Pregunta", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPregunta_Nombre(), ecorePackage.getEString(), "nombre", null, 1, 1, Pregunta.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPregunta_Texto(), ecorePackage.getEString(), "texto", null, 1, 1, Pregunta.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(preguntaOpcionMultipleEClass, PreguntaOpcionMultiple.class, "PreguntaOpcionMultiple", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPreguntaOpcionMultiple_Opciones(), this.getOpcionRespuesta(), null, "opciones", null, 2, -1, PreguntaOpcionMultiple.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPreguntaOpcionMultiple_RespuestaCorrecta(), this.getOpcionRespuesta(), null, "respuestaCorrecta", null, 0, 1, PreguntaOpcionMultiple.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(opcionRespuestaEClass, OpcionRespuesta.class, "OpcionRespuesta", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOpcionRespuesta_Nombre(), ecorePackage.getEString(), "nombre", null, 1, 1, OpcionRespuesta.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOpcionRespuesta_Texto(), ecorePackage.getEString(), "texto", null, 1, 1, OpcionRespuesta.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOpcionRespuesta_Valor(), ecorePackage.getEString(), "valor", null, 1, 1, OpcionRespuesta.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(preguntaVerdaderoFalsoEClass, PreguntaVerdaderoFalso.class, "PreguntaVerdaderoFalso", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPreguntaVerdaderoFalso_RespuestaCorrecta(), ecorePackage.getEBooleanObject(), "respuestaCorrecta", null, 0, 1, PreguntaVerdaderoFalso.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(preguntaRespuestaCortaEClass, PreguntaRespuestaCorta.class, "PreguntaRespuestaCorta", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPreguntaRespuestaCorta_RespuestaCorta(), ecorePackage.getEString(), "respuestaCorta", null, 0, 1, PreguntaRespuestaCorta.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(redSocialEClass, RedSocial.class, "RedSocial", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRedSocial_Tipo(), this.getTipoRedSocial(), "tipo", null, 1, 1, RedSocial.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRedSocial_Nombre(), ecorePackage.getEString(), "nombre", null, 1, 1, RedSocial.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRedSocial_CodigoEmbed(), ecorePackage.getEString(), "codigoEmbed", null, 1, 1, RedSocial.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRedSocial_NombreCuenta(), ecorePackage.getEString(), "nombreCuenta", null, 1, 1, RedSocial.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rolEClass, Rol.class, "Rol", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRol_Nombre(), ecorePackage.getEString(), "nombre", null, 1, 1, Rol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRol_Descripcion(), ecorePackage.getEString(), "descripcion", null, 0, 1, Rol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRol_PaginasAccesibles(), this.getPagina(), null, "paginasAccesibles", null, 1, -1, Rol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRol_NumeroEntidadesAccesibles(), ecorePackage.getEInt(), "numeroEntidadesAccesibles", null, 1, 1, Rol.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(fuenteRSSEClass, FuenteRSS.class, "FuenteRSS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFuenteRSS_Nombre(), ecorePackage.getEString(), "nombre", null, 1, 1, FuenteRSS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFuenteRSS_Url(), ecorePackage.getEString(), "url", null, 1, 1, FuenteRSS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFuenteRSS_Titulo(), ecorePackage.getEString(), "titulo", null, 1, 1, FuenteRSS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFuenteRSS_NumItems(), ecorePackage.getEInt(), "numItems", null, 1, 1, FuenteRSS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFuenteRSS_MostrarDescripcion(), ecorePackage.getEBoolean(), "mostrarDescripcion", null, 1, 1, FuenteRSS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(paginaIndicePaginadaEClass, PaginaIndicePaginada.class, "PaginaIndicePaginada", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPaginaIndicePaginada_PageSize(), ecorePackage.getEInt(), "pageSize", null, 1, 1, PaginaIndicePaginada.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(paginaIndiceFiltrosEClass, PaginaIndiceFiltros.class, "PaginaIndiceFiltros", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPaginaIndiceFiltros_AtributosFiltro(), this.getAtributo(), null, "atributosFiltro", null, 0, -1, PaginaIndiceFiltros.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(paginaIndicePaginadaFiltradaEClass, PaginaIndicePaginadaFiltrada.class, "PaginaIndicePaginadaFiltrada", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPaginaIndicePaginadaFiltrada_PageSize(), ecorePackage.getEInt(), "pageSize", null, 1, 1, PaginaIndicePaginadaFiltrada.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPaginaIndicePaginadaFiltrada_AtributosFiltro(), this.getAtributo(), null, "atributosFiltro", null, 0, -1, PaginaIndicePaginadaFiltrada.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(tipoAtributoEEnum, TipoAtributo.class, "TipoAtributo");
		addEEnumLiteral(tipoAtributoEEnum, TipoAtributo.STRING);
		addEEnumLiteral(tipoAtributoEEnum, TipoAtributo.INTEGER);
		addEEnumLiteral(tipoAtributoEEnum, TipoAtributo.BOOLEAN);
		addEEnumLiteral(tipoAtributoEEnum, TipoAtributo.DECIMAL);

		initEEnum(tipoRepresentacionEEnum, TipoRepresentacion.class, "TipoRepresentacion");
		addEEnumLiteral(tipoRepresentacionEEnum, TipoRepresentacion.TEXTO);
		addEEnumLiteral(tipoRepresentacionEEnum, TipoRepresentacion.BARRAS);
		addEEnumLiteral(tipoRepresentacionEEnum, TipoRepresentacion.CIRCULAR);
		addEEnumLiteral(tipoRepresentacionEEnum, TipoRepresentacion.LINEAS);

		initEEnum(tipoRedSocialEEnum, TipoRedSocial.class, "TipoRedSocial");
		addEEnumLiteral(tipoRedSocialEEnum, TipoRedSocial.TWITTER);
		addEEnumLiteral(tipoRedSocialEEnum, TipoRedSocial.FACEBOOK);
		addEEnumLiteral(tipoRedSocialEEnum, TipoRedSocial.INSTAGRAM);
		addEEnumLiteral(tipoRedSocialEEnum, TipoRedSocial.LINKEDIN);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// gmf
		createGmfAnnotations();
		// gmf.diagram
		createGmf_1Annotations();
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
		// http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot
		createPivotAnnotations();
		// gmf.compartment
		createGmf_2Annotations();
		// gmf.node
		createGmf_3Annotations();
		// gmf.link
		createGmf_4Annotations();
	}

	/**
	 * Initializes the annotations for <b>gmf</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGmfAnnotations() {
		String source = "gmf";
		addAnnotation
		  (this,
		   source,
		   new String[] {
		   });
	}

	/**
	 * Initializes the annotations for <b>gmf.diagram</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGmf_1Annotations() {
		String source = "gmf.diagram";
		addAnnotation
		  (aplicacionEClass,
		   source,
		   new String[] {
		   });
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore";
		addAnnotation
		  (aplicacionEClass,
		   source,
		   new String[] {
			   "constraints", "R01_una_sola_pagina_home R04_al_menos_una_red_social_y_rss R06b_al_menos_una_encuesta_y_cuestionario"
		   });
		addAnnotation
		  (entidadEClass,
		   source,
		   new String[] {
			   "constraints", "R02_crud_incompatible R03_indice_requiere_detalle R05_no_autorreferencia R06_no_referencia_circular R08_solo_una_pagina_indice R09_atributos_pertenecen_entidad"
		   });
		addAnnotation
		  (cuestionarioEClass,
		   source,
		   new String[] {
			   "constraints", "R07_cuestionarios_con_respuesta"
		   });
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createPivotAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot";
		addAnnotation
		  (aplicacionEClass,
		   source,
		   new String[] {
			   "R01_una_sola_pagina_home", "self.paginas->select(p | p.oclIsTypeOf(PaginaHome))->size() = 1",
			   "R04_al_menos_una_red_social_y_rss", "self.redesSociales->size() >= 1 and self.fuentesRSS->size() >= 1",
			   "R06b_al_menos_una_encuesta_y_cuestionario", "self.encuestas->size() >= 1 and self.cuestionarios->size() >= 1"
		   });
		addAnnotation
		  (entidadEClass,
		   source,
		   new String[] {
			   "R02_crud_incompatible", "self.hasCRUD implies (not self.hasIndex and not self.hasExtendedIndex and not self.hasDetails and not self.hasCreate and not self.hasUpdate and not self.hasDelete)",
			   "R03_indice_requiere_detalle", "(self.hasIndex or self.hasExtendedIndex) implies self.hasDetails",
			   "R05_no_autorreferencia", "self.referencias->forAll(r | r.target <> self)",
			   "R06_no_referencia_circular", "self.referencias->forAll(r | r.target.referencias->forAll(r2 | r2.target <> self))",
			   "R08_solo_una_pagina_indice", "Pagina.allInstances()->select(p | p.oclIsKindOf(PaginaIndice) and p.oclAsType(PaginaCRUD).entidad = self)->size() <= 1",
			   "R09_atributos_pertenecen_entidad", "Pagina.allInstances()->select(p | p.oclIsKindOf(PaginaIndice))->forAll(pi | pi.oclAsType(PaginaIndice).atributosMostrados->forAll(a | a.oclContainer() = pi.oclAsType(PaginaCRUD).entidad))"
		   });
		addAnnotation
		  (cuestionarioEClass,
		   source,
		   new String[] {
			   "R07_cuestionarios_con_respuesta", "self.preguntas->forAll(p | p.oclIsTypeOf(PreguntaOpcionMultiple) implies p.oclAsType(PreguntaOpcionMultiple).respuestaCorrecta <> null)"
		   });
	}

	/**
	 * Initializes the annotations for <b>gmf.compartment</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGmf_2Annotations() {
		String source = "gmf.compartment";
		addAnnotation
		  (getAplicacion_Entidades(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getAplicacion_Paginas(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getAplicacion_Roles(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getAplicacion_Cuestionarios(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getAplicacion_Encuestas(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getAplicacion_RedesSociales(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getAplicacion_FuentesRSS(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getEntidad_Atributos(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getEntidad_Referencias(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getEncuesta_Preguntas(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getCuestionario_Preguntas(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getPreguntaOpcionMultiple_Opciones(),
		   source,
		   new String[] {
		   });
	}

	/**
	 * Initializes the annotations for <b>gmf.node</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGmf_3Annotations() {
		String source = "gmf.node";
		addAnnotation
		  (entidadEClass,
		   source,
		   new String[] {
			   "label", "nombre",
			   "color", "200,200,255"
		   });
		addAnnotation
		  (atributoEClass,
		   source,
		   new String[] {
			   "label", "nombre",
			   "color", "255,255,200"
		   });
		addAnnotation
		  (paginaEClass,
		   source,
		   new String[] {
			   "label", "nombre",
			   "color", "150,255,150"
		   });
		addAnnotation
		  (paginaHomeEClass,
		   source,
		   new String[] {
			   "label", "nombre",
			   "color", "100,255,100"
		   });
		addAnnotation
		  (paginaContenidoEClass,
		   source,
		   new String[] {
			   "label", "nombre",
			   "color", "150,255,200"
		   });
		addAnnotation
		  (paginaCRUDEClass,
		   source,
		   new String[] {
			   "label", "nombre",
			   "color", "200,150,255"
		   });
		addAnnotation
		  (paginaIndiceEClass,
		   source,
		   new String[] {
			   "label", "nombre",
			   "color", "255,200,150"
		   });
		addAnnotation
		  (paginaDetalleEClass,
		   source,
		   new String[] {
			   "label", "nombre",
			   "color", "255,150,150"
		   });
		addAnnotation
		  (paginaCreacionEClass,
		   source,
		   new String[] {
			   "label", "nombre",
			   "color", "150,255,255"
		   });
		addAnnotation
		  (paginaActualizacionEClass,
		   source,
		   new String[] {
			   "label", "nombre",
			   "color", "255,255,150"
		   });
		addAnnotation
		  (paginaBorradoEClass,
		   source,
		   new String[] {
			   "label", "nombre",
			   "color", "255,100,100"
		   });
		addAnnotation
		  (paginaIndiceDetalleEClass,
		   source,
		   new String[] {
			   "label", "nombre",
			   "color", "200,255,200"
		   });
		addAnnotation
		  (encuestaEClass,
		   source,
		   new String[] {
			   "label", "nombre",
			   "color", "100,200,255"
		   });
		addAnnotation
		  (cuestionarioEClass,
		   source,
		   new String[] {
			   "label", "nombre",
			   "color", "255,200,100"
		   });
		addAnnotation
		  (preguntaEClass,
		   source,
		   new String[] {
			   "label", "nombre",
			   "color", "200,255,255"
		   });
		addAnnotation
		  (preguntaOpcionMultipleEClass,
		   source,
		   new String[] {
			   "label", "nombre",
			   "color", "255,220,220"
		   });
		addAnnotation
		  (opcionRespuestaEClass,
		   source,
		   new String[] {
			   "label", "nombre",
			   "color", "220,255,220"
		   });
		addAnnotation
		  (preguntaVerdaderoFalsoEClass,
		   source,
		   new String[] {
			   "label", "nombre",
			   "color", "220,220,255"
		   });
		addAnnotation
		  (preguntaRespuestaCortaEClass,
		   source,
		   new String[] {
			   "label", "nombre",
			   "color", "255,255,220"
		   });
		addAnnotation
		  (redSocialEClass,
		   source,
		   new String[] {
			   "label", "nombre",
			   "color", "255,150,0"
		   });
		addAnnotation
		  (rolEClass,
		   source,
		   new String[] {
			   "label", "nombre",
			   "color", "100,100,255"
		   });
		addAnnotation
		  (fuenteRSSEClass,
		   source,
		   new String[] {
			   "label", "nombre",
			   "color", "0,255,255"
		   });
		addAnnotation
		  (paginaIndicePaginadaEClass,
		   source,
		   new String[] {
			   "label", "nombre",
			   "color", "255,180,120"
		   });
		addAnnotation
		  (paginaIndiceFiltrosEClass,
		   source,
		   new String[] {
			   "label", "nombre",
			   "color", "180,255,120"
		   });
		addAnnotation
		  (paginaIndicePaginadaFiltradaEClass,
		   source,
		   new String[] {
			   "label", "nombre",
			   "color", "120,180,255"
		   });
	}

	/**
	 * Initializes the annotations for <b>gmf.link</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGmf_4Annotations() {
		String source = "gmf.link";
		addAnnotation
		  (referenciaEClass,
		   source,
		   new String[] {
			   "label", "nombre",
			   "source", "source",
			   "target", "target",
			   "target.decoration", "arrow",
			   "color", "100,100,100"
		   });
		addAnnotation
		  (getPagina_Enlaces(),
		   source,
		   new String[] {
			   "target.decoration", "arrow",
			   "color", "0,150,0"
		   });
		addAnnotation
		  (getPagina_RedesSociales(),
		   source,
		   new String[] {
			   "target.decoration", "arrow",
			   "color", "255,100,0"
		   });
		addAnnotation
		  (getPagina_FuentesRSS(),
		   source,
		   new String[] {
			   "target.decoration", "arrow",
			   "color", "0,100,255"
		   });
		addAnnotation
		  (getPaginaCRUD_Entidad(),
		   source,
		   new String[] {
			   "target.decoration", "arrow",
			   "color", "150,0,150"
		   });
		addAnnotation
		  (getPaginaIndice_AtributosMostrados(),
		   source,
		   new String[] {
			   "target.decoration", "arrow",
			   "color", "200,100,0"
		   });
		addAnnotation
		  (getPreguntaOpcionMultiple_RespuestaCorrecta(),
		   source,
		   new String[] {
			   "target.decoration", "arrow",
			   "color", "255,0,0"
		   });
		addAnnotation
		  (getRol_PaginasAccesibles(),
		   source,
		   new String[] {
			   "target.decoration", "arrow",
			   "color", "0,0,200"
		   });
		addAnnotation
		  (getPaginaIndiceFiltros_AtributosFiltro(),
		   source,
		   new String[] {
			   "target.decoration", "arrow",
			   "color", "100,200,0"
		   });
		addAnnotation
		  (getPaginaIndicePaginadaFiltrada_AtributosFiltro(),
		   source,
		   new String[] {
			   "target.decoration", "arrow",
			   "color", "0,100,200"
		   });
	}

} //DatawebPackageImpl
