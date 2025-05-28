/**
 */
package dataweb;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see dataweb.DatawebFactory
 * @model kind="package"
 *        annotation="gmf"
 * @generated
 */
public interface DatawebPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "dataweb";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.unex.es/dmss/dataweb";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "dataweb";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DatawebPackage eINSTANCE = dataweb.impl.DatawebPackageImpl.init();

	/**
	 * The meta object id for the '{@link dataweb.impl.AplicacionImpl <em>Aplicacion</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dataweb.impl.AplicacionImpl
	 * @see dataweb.impl.DatawebPackageImpl#getAplicacion()
	 * @generated
	 */
	int APLICACION = 0;

	/**
	 * The feature id for the '<em><b>Nombre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APLICACION__NOMBRE = 0;

	/**
	 * The feature id for the '<em><b>Descripcion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APLICACION__DESCRIPCION = 1;

	/**
	 * The feature id for the '<em><b>Entidades</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APLICACION__ENTIDADES = 2;

	/**
	 * The feature id for the '<em><b>Paginas</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APLICACION__PAGINAS = 3;

	/**
	 * The feature id for the '<em><b>Roles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APLICACION__ROLES = 4;

	/**
	 * The feature id for the '<em><b>Cuestionarios</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APLICACION__CUESTIONARIOS = 5;

	/**
	 * The feature id for the '<em><b>Encuestas</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APLICACION__ENCUESTAS = 6;

	/**
	 * The feature id for the '<em><b>Redes Sociales</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APLICACION__REDES_SOCIALES = 7;

	/**
	 * The feature id for the '<em><b>Fuentes RSS</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APLICACION__FUENTES_RSS = 8;

	/**
	 * The feature id for the '<em><b>Paginas Medias Accesibles</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APLICACION__PAGINAS_MEDIAS_ACCESIBLES = 9;

	/**
	 * The number of structural features of the '<em>Aplicacion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APLICACION_FEATURE_COUNT = 10;

	/**
	 * The number of operations of the '<em>Aplicacion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APLICACION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dataweb.impl.EntidadImpl <em>Entidad</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dataweb.impl.EntidadImpl
	 * @see dataweb.impl.DatawebPackageImpl#getEntidad()
	 * @generated
	 */
	int ENTIDAD = 1;

	/**
	 * The feature id for the '<em><b>Nombre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTIDAD__NOMBRE = 0;

	/**
	 * The feature id for the '<em><b>Table Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTIDAD__TABLE_NAME = 1;

	/**
	 * The feature id for the '<em><b>Has CRUD</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTIDAD__HAS_CRUD = 2;

	/**
	 * The feature id for the '<em><b>Has Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTIDAD__HAS_INDEX = 3;

	/**
	 * The feature id for the '<em><b>Has Extended Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTIDAD__HAS_EXTENDED_INDEX = 4;

	/**
	 * The feature id for the '<em><b>Has Details</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTIDAD__HAS_DETAILS = 5;

	/**
	 * The feature id for the '<em><b>Has Create</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTIDAD__HAS_CREATE = 6;

	/**
	 * The feature id for the '<em><b>Has Update</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTIDAD__HAS_UPDATE = 7;

	/**
	 * The feature id for the '<em><b>Has Delete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTIDAD__HAS_DELETE = 8;

	/**
	 * The feature id for the '<em><b>Atributos</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTIDAD__ATRIBUTOS = 9;

	/**
	 * The feature id for the '<em><b>Referencias</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTIDAD__REFERENCIAS = 10;

	/**
	 * The number of structural features of the '<em>Entidad</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTIDAD_FEATURE_COUNT = 11;

	/**
	 * The number of operations of the '<em>Entidad</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTIDAD_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dataweb.impl.AtributoImpl <em>Atributo</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dataweb.impl.AtributoImpl
	 * @see dataweb.impl.DatawebPackageImpl#getAtributo()
	 * @generated
	 */
	int ATRIBUTO = 2;

	/**
	 * The feature id for the '<em><b>Nombre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATRIBUTO__NOMBRE = 0;

	/**
	 * The feature id for the '<em><b>Is Primary Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATRIBUTO__IS_PRIMARY_KEY = 1;

	/**
	 * The feature id for the '<em><b>Tipo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATRIBUTO__TIPO = 2;

	/**
	 * The number of structural features of the '<em>Atributo</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATRIBUTO_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Atributo</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATRIBUTO_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dataweb.impl.ReferenciaImpl <em>Referencia</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dataweb.impl.ReferenciaImpl
	 * @see dataweb.impl.DatawebPackageImpl#getReferencia()
	 * @generated
	 */
	int REFERENCIA = 3;

	/**
	 * The feature id for the '<em><b>Nombre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCIA__NOMBRE = 0;

	/**
	 * The feature id for the '<em><b>Multiplicidad</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCIA__MULTIPLICIDAD = 1;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCIA__SOURCE = 2;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCIA__TARGET = 3;

	/**
	 * The number of structural features of the '<em>Referencia</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCIA_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Referencia</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCIA_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dataweb.impl.PaginaImpl <em>Pagina</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dataweb.impl.PaginaImpl
	 * @see dataweb.impl.DatawebPackageImpl#getPagina()
	 * @generated
	 */
	int PAGINA = 4;

	/**
	 * The feature id for the '<em><b>Enlaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA__ENLACES = 0;

	/**
	 * The feature id for the '<em><b>Redes Sociales</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA__REDES_SOCIALES = 1;

	/**
	 * The feature id for the '<em><b>Fuentes RSS</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA__FUENTES_RSS = 2;

	/**
	 * The feature id for the '<em><b>Nombre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA__NOMBRE = 3;

	/**
	 * The feature id for the '<em><b>Titulo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA__TITULO = 4;

	/**
	 * The feature id for the '<em><b>Descripcion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA__DESCRIPCION = 5;

	/**
	 * The number of structural features of the '<em>Pagina</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Pagina</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dataweb.impl.PaginaHomeImpl <em>Pagina Home</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dataweb.impl.PaginaHomeImpl
	 * @see dataweb.impl.DatawebPackageImpl#getPaginaHome()
	 * @generated
	 */
	int PAGINA_HOME = 5;

	/**
	 * The feature id for the '<em><b>Enlaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_HOME__ENLACES = PAGINA__ENLACES;

	/**
	 * The feature id for the '<em><b>Redes Sociales</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_HOME__REDES_SOCIALES = PAGINA__REDES_SOCIALES;

	/**
	 * The feature id for the '<em><b>Fuentes RSS</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_HOME__FUENTES_RSS = PAGINA__FUENTES_RSS;

	/**
	 * The feature id for the '<em><b>Nombre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_HOME__NOMBRE = PAGINA__NOMBRE;

	/**
	 * The feature id for the '<em><b>Titulo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_HOME__TITULO = PAGINA__TITULO;

	/**
	 * The feature id for the '<em><b>Descripcion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_HOME__DESCRIPCION = PAGINA__DESCRIPCION;

	/**
	 * The number of structural features of the '<em>Pagina Home</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_HOME_FEATURE_COUNT = PAGINA_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Pagina Home</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_HOME_OPERATION_COUNT = PAGINA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dataweb.impl.PaginaContenidoImpl <em>Pagina Contenido</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dataweb.impl.PaginaContenidoImpl
	 * @see dataweb.impl.DatawebPackageImpl#getPaginaContenido()
	 * @generated
	 */
	int PAGINA_CONTENIDO = 6;

	/**
	 * The feature id for the '<em><b>Enlaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_CONTENIDO__ENLACES = PAGINA__ENLACES;

	/**
	 * The feature id for the '<em><b>Redes Sociales</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_CONTENIDO__REDES_SOCIALES = PAGINA__REDES_SOCIALES;

	/**
	 * The feature id for the '<em><b>Fuentes RSS</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_CONTENIDO__FUENTES_RSS = PAGINA__FUENTES_RSS;

	/**
	 * The feature id for the '<em><b>Nombre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_CONTENIDO__NOMBRE = PAGINA__NOMBRE;

	/**
	 * The feature id for the '<em><b>Titulo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_CONTENIDO__TITULO = PAGINA__TITULO;

	/**
	 * The feature id for the '<em><b>Descripcion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_CONTENIDO__DESCRIPCION = PAGINA__DESCRIPCION;

	/**
	 * The feature id for the '<em><b>Contenido</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_CONTENIDO__CONTENIDO = PAGINA_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Pagina Contenido</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_CONTENIDO_FEATURE_COUNT = PAGINA_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Pagina Contenido</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_CONTENIDO_OPERATION_COUNT = PAGINA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dataweb.impl.PaginaCRUDImpl <em>Pagina CRUD</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dataweb.impl.PaginaCRUDImpl
	 * @see dataweb.impl.DatawebPackageImpl#getPaginaCRUD()
	 * @generated
	 */
	int PAGINA_CRUD = 7;

	/**
	 * The feature id for the '<em><b>Enlaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_CRUD__ENLACES = PAGINA__ENLACES;

	/**
	 * The feature id for the '<em><b>Redes Sociales</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_CRUD__REDES_SOCIALES = PAGINA__REDES_SOCIALES;

	/**
	 * The feature id for the '<em><b>Fuentes RSS</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_CRUD__FUENTES_RSS = PAGINA__FUENTES_RSS;

	/**
	 * The feature id for the '<em><b>Nombre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_CRUD__NOMBRE = PAGINA__NOMBRE;

	/**
	 * The feature id for the '<em><b>Titulo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_CRUD__TITULO = PAGINA__TITULO;

	/**
	 * The feature id for the '<em><b>Descripcion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_CRUD__DESCRIPCION = PAGINA__DESCRIPCION;

	/**
	 * The feature id for the '<em><b>Entidad</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_CRUD__ENTIDAD = PAGINA_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Pagina CRUD</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_CRUD_FEATURE_COUNT = PAGINA_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Pagina CRUD</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_CRUD_OPERATION_COUNT = PAGINA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dataweb.impl.PaginaIndiceImpl <em>Pagina Indice</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dataweb.impl.PaginaIndiceImpl
	 * @see dataweb.impl.DatawebPackageImpl#getPaginaIndice()
	 * @generated
	 */
	int PAGINA_INDICE = 8;

	/**
	 * The feature id for the '<em><b>Enlaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_INDICE__ENLACES = PAGINA_CRUD__ENLACES;

	/**
	 * The feature id for the '<em><b>Redes Sociales</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_INDICE__REDES_SOCIALES = PAGINA_CRUD__REDES_SOCIALES;

	/**
	 * The feature id for the '<em><b>Fuentes RSS</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_INDICE__FUENTES_RSS = PAGINA_CRUD__FUENTES_RSS;

	/**
	 * The feature id for the '<em><b>Nombre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_INDICE__NOMBRE = PAGINA_CRUD__NOMBRE;

	/**
	 * The feature id for the '<em><b>Titulo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_INDICE__TITULO = PAGINA_CRUD__TITULO;

	/**
	 * The feature id for the '<em><b>Descripcion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_INDICE__DESCRIPCION = PAGINA_CRUD__DESCRIPCION;

	/**
	 * The feature id for the '<em><b>Entidad</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_INDICE__ENTIDAD = PAGINA_CRUD__ENTIDAD;

	/**
	 * The feature id for the '<em><b>Atributos Mostrados</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_INDICE__ATRIBUTOS_MOSTRADOS = PAGINA_CRUD_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Pagina Indice</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_INDICE_FEATURE_COUNT = PAGINA_CRUD_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Pagina Indice</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_INDICE_OPERATION_COUNT = PAGINA_CRUD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dataweb.impl.PaginaDetalleImpl <em>Pagina Detalle</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dataweb.impl.PaginaDetalleImpl
	 * @see dataweb.impl.DatawebPackageImpl#getPaginaDetalle()
	 * @generated
	 */
	int PAGINA_DETALLE = 9;

	/**
	 * The feature id for the '<em><b>Enlaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_DETALLE__ENLACES = PAGINA_CRUD__ENLACES;

	/**
	 * The feature id for the '<em><b>Redes Sociales</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_DETALLE__REDES_SOCIALES = PAGINA_CRUD__REDES_SOCIALES;

	/**
	 * The feature id for the '<em><b>Fuentes RSS</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_DETALLE__FUENTES_RSS = PAGINA_CRUD__FUENTES_RSS;

	/**
	 * The feature id for the '<em><b>Nombre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_DETALLE__NOMBRE = PAGINA_CRUD__NOMBRE;

	/**
	 * The feature id for the '<em><b>Titulo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_DETALLE__TITULO = PAGINA_CRUD__TITULO;

	/**
	 * The feature id for the '<em><b>Descripcion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_DETALLE__DESCRIPCION = PAGINA_CRUD__DESCRIPCION;

	/**
	 * The feature id for the '<em><b>Entidad</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_DETALLE__ENTIDAD = PAGINA_CRUD__ENTIDAD;

	/**
	 * The number of structural features of the '<em>Pagina Detalle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_DETALLE_FEATURE_COUNT = PAGINA_CRUD_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Pagina Detalle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_DETALLE_OPERATION_COUNT = PAGINA_CRUD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dataweb.impl.PaginaCreacionImpl <em>Pagina Creacion</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dataweb.impl.PaginaCreacionImpl
	 * @see dataweb.impl.DatawebPackageImpl#getPaginaCreacion()
	 * @generated
	 */
	int PAGINA_CREACION = 10;

	/**
	 * The feature id for the '<em><b>Enlaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_CREACION__ENLACES = PAGINA_CRUD__ENLACES;

	/**
	 * The feature id for the '<em><b>Redes Sociales</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_CREACION__REDES_SOCIALES = PAGINA_CRUD__REDES_SOCIALES;

	/**
	 * The feature id for the '<em><b>Fuentes RSS</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_CREACION__FUENTES_RSS = PAGINA_CRUD__FUENTES_RSS;

	/**
	 * The feature id for the '<em><b>Nombre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_CREACION__NOMBRE = PAGINA_CRUD__NOMBRE;

	/**
	 * The feature id for the '<em><b>Titulo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_CREACION__TITULO = PAGINA_CRUD__TITULO;

	/**
	 * The feature id for the '<em><b>Descripcion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_CREACION__DESCRIPCION = PAGINA_CRUD__DESCRIPCION;

	/**
	 * The feature id for the '<em><b>Entidad</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_CREACION__ENTIDAD = PAGINA_CRUD__ENTIDAD;

	/**
	 * The number of structural features of the '<em>Pagina Creacion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_CREACION_FEATURE_COUNT = PAGINA_CRUD_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Pagina Creacion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_CREACION_OPERATION_COUNT = PAGINA_CRUD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dataweb.impl.PaginaActualizacionImpl <em>Pagina Actualizacion</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dataweb.impl.PaginaActualizacionImpl
	 * @see dataweb.impl.DatawebPackageImpl#getPaginaActualizacion()
	 * @generated
	 */
	int PAGINA_ACTUALIZACION = 11;

	/**
	 * The feature id for the '<em><b>Enlaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_ACTUALIZACION__ENLACES = PAGINA_CRUD__ENLACES;

	/**
	 * The feature id for the '<em><b>Redes Sociales</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_ACTUALIZACION__REDES_SOCIALES = PAGINA_CRUD__REDES_SOCIALES;

	/**
	 * The feature id for the '<em><b>Fuentes RSS</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_ACTUALIZACION__FUENTES_RSS = PAGINA_CRUD__FUENTES_RSS;

	/**
	 * The feature id for the '<em><b>Nombre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_ACTUALIZACION__NOMBRE = PAGINA_CRUD__NOMBRE;

	/**
	 * The feature id for the '<em><b>Titulo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_ACTUALIZACION__TITULO = PAGINA_CRUD__TITULO;

	/**
	 * The feature id for the '<em><b>Descripcion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_ACTUALIZACION__DESCRIPCION = PAGINA_CRUD__DESCRIPCION;

	/**
	 * The feature id for the '<em><b>Entidad</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_ACTUALIZACION__ENTIDAD = PAGINA_CRUD__ENTIDAD;

	/**
	 * The number of structural features of the '<em>Pagina Actualizacion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_ACTUALIZACION_FEATURE_COUNT = PAGINA_CRUD_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Pagina Actualizacion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_ACTUALIZACION_OPERATION_COUNT = PAGINA_CRUD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dataweb.impl.PaginaBorradoImpl <em>Pagina Borrado</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dataweb.impl.PaginaBorradoImpl
	 * @see dataweb.impl.DatawebPackageImpl#getPaginaBorrado()
	 * @generated
	 */
	int PAGINA_BORRADO = 12;

	/**
	 * The feature id for the '<em><b>Enlaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_BORRADO__ENLACES = PAGINA_CRUD__ENLACES;

	/**
	 * The feature id for the '<em><b>Redes Sociales</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_BORRADO__REDES_SOCIALES = PAGINA_CRUD__REDES_SOCIALES;

	/**
	 * The feature id for the '<em><b>Fuentes RSS</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_BORRADO__FUENTES_RSS = PAGINA_CRUD__FUENTES_RSS;

	/**
	 * The feature id for the '<em><b>Nombre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_BORRADO__NOMBRE = PAGINA_CRUD__NOMBRE;

	/**
	 * The feature id for the '<em><b>Titulo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_BORRADO__TITULO = PAGINA_CRUD__TITULO;

	/**
	 * The feature id for the '<em><b>Descripcion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_BORRADO__DESCRIPCION = PAGINA_CRUD__DESCRIPCION;

	/**
	 * The feature id for the '<em><b>Entidad</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_BORRADO__ENTIDAD = PAGINA_CRUD__ENTIDAD;

	/**
	 * The number of structural features of the '<em>Pagina Borrado</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_BORRADO_FEATURE_COUNT = PAGINA_CRUD_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Pagina Borrado</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_BORRADO_OPERATION_COUNT = PAGINA_CRUD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dataweb.impl.PaginaIndiceDetalleImpl <em>Pagina Indice Detalle</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dataweb.impl.PaginaIndiceDetalleImpl
	 * @see dataweb.impl.DatawebPackageImpl#getPaginaIndiceDetalle()
	 * @generated
	 */
	int PAGINA_INDICE_DETALLE = 13;

	/**
	 * The feature id for the '<em><b>Enlaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_INDICE_DETALLE__ENLACES = PAGINA_INDICE__ENLACES;

	/**
	 * The feature id for the '<em><b>Redes Sociales</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_INDICE_DETALLE__REDES_SOCIALES = PAGINA_INDICE__REDES_SOCIALES;

	/**
	 * The feature id for the '<em><b>Fuentes RSS</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_INDICE_DETALLE__FUENTES_RSS = PAGINA_INDICE__FUENTES_RSS;

	/**
	 * The feature id for the '<em><b>Nombre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_INDICE_DETALLE__NOMBRE = PAGINA_INDICE__NOMBRE;

	/**
	 * The feature id for the '<em><b>Titulo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_INDICE_DETALLE__TITULO = PAGINA_INDICE__TITULO;

	/**
	 * The feature id for the '<em><b>Descripcion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_INDICE_DETALLE__DESCRIPCION = PAGINA_INDICE__DESCRIPCION;

	/**
	 * The feature id for the '<em><b>Entidad</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_INDICE_DETALLE__ENTIDAD = PAGINA_INDICE__ENTIDAD;

	/**
	 * The feature id for the '<em><b>Atributos Mostrados</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_INDICE_DETALLE__ATRIBUTOS_MOSTRADOS = PAGINA_INDICE__ATRIBUTOS_MOSTRADOS;

	/**
	 * The number of structural features of the '<em>Pagina Indice Detalle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_INDICE_DETALLE_FEATURE_COUNT = PAGINA_INDICE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Pagina Indice Detalle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_INDICE_DETALLE_OPERATION_COUNT = PAGINA_INDICE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dataweb.impl.EncuestaImpl <em>Encuesta</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dataweb.impl.EncuestaImpl
	 * @see dataweb.impl.DatawebPackageImpl#getEncuesta()
	 * @generated
	 */
	int ENCUESTA = 14;

	/**
	 * The feature id for the '<em><b>Preguntas</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENCUESTA__PREGUNTAS = 0;

	/**
	 * The feature id for the '<em><b>Nombre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENCUESTA__NOMBRE = 1;

	/**
	 * The feature id for the '<em><b>Descripcion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENCUESTA__DESCRIPCION = 2;

	/**
	 * The feature id for the '<em><b>Tipo Representacion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENCUESTA__TIPO_REPRESENTACION = 3;

	/**
	 * The feature id for the '<em><b>Titulo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENCUESTA__TITULO = 4;

	/**
	 * The feature id for the '<em><b>Numero Preg VF</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENCUESTA__NUMERO_PREG_VF = 5;

	/**
	 * The feature id for the '<em><b>Numero Preg Select</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENCUESTA__NUMERO_PREG_SELECT = 6;

	/**
	 * The number of structural features of the '<em>Encuesta</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENCUESTA_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Encuesta</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENCUESTA_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dataweb.impl.CuestionarioImpl <em>Cuestionario</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dataweb.impl.CuestionarioImpl
	 * @see dataweb.impl.DatawebPackageImpl#getCuestionario()
	 * @generated
	 */
	int CUESTIONARIO = 15;

	/**
	 * The feature id for the '<em><b>Preguntas</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUESTIONARIO__PREGUNTAS = 0;

	/**
	 * The feature id for the '<em><b>Nombre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUESTIONARIO__NOMBRE = 1;

	/**
	 * The feature id for the '<em><b>Descripcion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUESTIONARIO__DESCRIPCION = 2;

	/**
	 * The feature id for the '<em><b>Titulo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUESTIONARIO__TITULO = 3;

	/**
	 * The feature id for the '<em><b>Numero Preg VF</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUESTIONARIO__NUMERO_PREG_VF = 4;

	/**
	 * The feature id for the '<em><b>Numero Preg Select</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUESTIONARIO__NUMERO_PREG_SELECT = 5;

	/**
	 * The number of structural features of the '<em>Cuestionario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUESTIONARIO_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Cuestionario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUESTIONARIO_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dataweb.impl.PreguntaImpl <em>Pregunta</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dataweb.impl.PreguntaImpl
	 * @see dataweb.impl.DatawebPackageImpl#getPregunta()
	 * @generated
	 */
	int PREGUNTA = 16;

	/**
	 * The feature id for the '<em><b>Nombre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREGUNTA__NOMBRE = 0;

	/**
	 * The feature id for the '<em><b>Texto</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREGUNTA__TEXTO = 1;

	/**
	 * The number of structural features of the '<em>Pregunta</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREGUNTA_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Pregunta</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREGUNTA_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dataweb.impl.PreguntaOpcionMultipleImpl <em>Pregunta Opcion Multiple</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dataweb.impl.PreguntaOpcionMultipleImpl
	 * @see dataweb.impl.DatawebPackageImpl#getPreguntaOpcionMultiple()
	 * @generated
	 */
	int PREGUNTA_OPCION_MULTIPLE = 17;

	/**
	 * The feature id for the '<em><b>Nombre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREGUNTA_OPCION_MULTIPLE__NOMBRE = PREGUNTA__NOMBRE;

	/**
	 * The feature id for the '<em><b>Texto</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREGUNTA_OPCION_MULTIPLE__TEXTO = PREGUNTA__TEXTO;

	/**
	 * The feature id for the '<em><b>Opciones</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREGUNTA_OPCION_MULTIPLE__OPCIONES = PREGUNTA_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Respuesta Correcta</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREGUNTA_OPCION_MULTIPLE__RESPUESTA_CORRECTA = PREGUNTA_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Pregunta Opcion Multiple</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREGUNTA_OPCION_MULTIPLE_FEATURE_COUNT = PREGUNTA_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Pregunta Opcion Multiple</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREGUNTA_OPCION_MULTIPLE_OPERATION_COUNT = PREGUNTA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dataweb.impl.OpcionRespuestaImpl <em>Opcion Respuesta</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dataweb.impl.OpcionRespuestaImpl
	 * @see dataweb.impl.DatawebPackageImpl#getOpcionRespuesta()
	 * @generated
	 */
	int OPCION_RESPUESTA = 18;

	/**
	 * The feature id for the '<em><b>Nombre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPCION_RESPUESTA__NOMBRE = 0;

	/**
	 * The feature id for the '<em><b>Texto</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPCION_RESPUESTA__TEXTO = 1;

	/**
	 * The feature id for the '<em><b>Valor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPCION_RESPUESTA__VALOR = 2;

	/**
	 * The number of structural features of the '<em>Opcion Respuesta</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPCION_RESPUESTA_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Opcion Respuesta</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPCION_RESPUESTA_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dataweb.impl.PreguntaVerdaderoFalsoImpl <em>Pregunta Verdadero Falso</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dataweb.impl.PreguntaVerdaderoFalsoImpl
	 * @see dataweb.impl.DatawebPackageImpl#getPreguntaVerdaderoFalso()
	 * @generated
	 */
	int PREGUNTA_VERDADERO_FALSO = 19;

	/**
	 * The feature id for the '<em><b>Nombre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREGUNTA_VERDADERO_FALSO__NOMBRE = PREGUNTA__NOMBRE;

	/**
	 * The feature id for the '<em><b>Texto</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREGUNTA_VERDADERO_FALSO__TEXTO = PREGUNTA__TEXTO;

	/**
	 * The feature id for the '<em><b>Respuesta Correcta</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREGUNTA_VERDADERO_FALSO__RESPUESTA_CORRECTA = PREGUNTA_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Pregunta Verdadero Falso</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREGUNTA_VERDADERO_FALSO_FEATURE_COUNT = PREGUNTA_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Pregunta Verdadero Falso</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREGUNTA_VERDADERO_FALSO_OPERATION_COUNT = PREGUNTA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dataweb.impl.PreguntaRespuestaCortaImpl <em>Pregunta Respuesta Corta</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dataweb.impl.PreguntaRespuestaCortaImpl
	 * @see dataweb.impl.DatawebPackageImpl#getPreguntaRespuestaCorta()
	 * @generated
	 */
	int PREGUNTA_RESPUESTA_CORTA = 20;

	/**
	 * The feature id for the '<em><b>Nombre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREGUNTA_RESPUESTA_CORTA__NOMBRE = PREGUNTA__NOMBRE;

	/**
	 * The feature id for the '<em><b>Texto</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREGUNTA_RESPUESTA_CORTA__TEXTO = PREGUNTA__TEXTO;

	/**
	 * The feature id for the '<em><b>Respuesta Corta</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREGUNTA_RESPUESTA_CORTA__RESPUESTA_CORTA = PREGUNTA_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Pregunta Respuesta Corta</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREGUNTA_RESPUESTA_CORTA_FEATURE_COUNT = PREGUNTA_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Pregunta Respuesta Corta</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREGUNTA_RESPUESTA_CORTA_OPERATION_COUNT = PREGUNTA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dataweb.impl.RedSocialImpl <em>Red Social</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dataweb.impl.RedSocialImpl
	 * @see dataweb.impl.DatawebPackageImpl#getRedSocial()
	 * @generated
	 */
	int RED_SOCIAL = 21;

	/**
	 * The feature id for the '<em><b>Tipo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RED_SOCIAL__TIPO = 0;

	/**
	 * The feature id for the '<em><b>Nombre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RED_SOCIAL__NOMBRE = 1;

	/**
	 * The feature id for the '<em><b>Codigo Embed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RED_SOCIAL__CODIGO_EMBED = 2;

	/**
	 * The feature id for the '<em><b>Nombre Cuenta</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RED_SOCIAL__NOMBRE_CUENTA = 3;

	/**
	 * The number of structural features of the '<em>Red Social</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RED_SOCIAL_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Red Social</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RED_SOCIAL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dataweb.impl.RolImpl <em>Rol</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dataweb.impl.RolImpl
	 * @see dataweb.impl.DatawebPackageImpl#getRol()
	 * @generated
	 */
	int ROL = 22;

	/**
	 * The feature id for the '<em><b>Nombre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROL__NOMBRE = 0;

	/**
	 * The feature id for the '<em><b>Descripcion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROL__DESCRIPCION = 1;

	/**
	 * The feature id for the '<em><b>Paginas Accesibles</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROL__PAGINAS_ACCESIBLES = 2;

	/**
	 * The feature id for the '<em><b>Numero Entidades Accesibles</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROL__NUMERO_ENTIDADES_ACCESIBLES = 3;

	/**
	 * The number of structural features of the '<em>Rol</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROL_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Rol</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dataweb.impl.FuenteRSSImpl <em>Fuente RSS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dataweb.impl.FuenteRSSImpl
	 * @see dataweb.impl.DatawebPackageImpl#getFuenteRSS()
	 * @generated
	 */
	int FUENTE_RSS = 23;

	/**
	 * The feature id for the '<em><b>Nombre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUENTE_RSS__NOMBRE = 0;

	/**
	 * The feature id for the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUENTE_RSS__URL = 1;

	/**
	 * The feature id for the '<em><b>Titulo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUENTE_RSS__TITULO = 2;

	/**
	 * The feature id for the '<em><b>Num Items</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUENTE_RSS__NUM_ITEMS = 3;

	/**
	 * The feature id for the '<em><b>Mostrar Descripcion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUENTE_RSS__MOSTRAR_DESCRIPCION = 4;

	/**
	 * The number of structural features of the '<em>Fuente RSS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUENTE_RSS_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Fuente RSS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUENTE_RSS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dataweb.impl.PaginaIndicePaginadaImpl <em>Pagina Indice Paginada</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dataweb.impl.PaginaIndicePaginadaImpl
	 * @see dataweb.impl.DatawebPackageImpl#getPaginaIndicePaginada()
	 * @generated
	 */
	int PAGINA_INDICE_PAGINADA = 24;

	/**
	 * The feature id for the '<em><b>Enlaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_INDICE_PAGINADA__ENLACES = PAGINA_INDICE__ENLACES;

	/**
	 * The feature id for the '<em><b>Redes Sociales</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_INDICE_PAGINADA__REDES_SOCIALES = PAGINA_INDICE__REDES_SOCIALES;

	/**
	 * The feature id for the '<em><b>Fuentes RSS</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_INDICE_PAGINADA__FUENTES_RSS = PAGINA_INDICE__FUENTES_RSS;

	/**
	 * The feature id for the '<em><b>Nombre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_INDICE_PAGINADA__NOMBRE = PAGINA_INDICE__NOMBRE;

	/**
	 * The feature id for the '<em><b>Titulo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_INDICE_PAGINADA__TITULO = PAGINA_INDICE__TITULO;

	/**
	 * The feature id for the '<em><b>Descripcion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_INDICE_PAGINADA__DESCRIPCION = PAGINA_INDICE__DESCRIPCION;

	/**
	 * The feature id for the '<em><b>Entidad</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_INDICE_PAGINADA__ENTIDAD = PAGINA_INDICE__ENTIDAD;

	/**
	 * The feature id for the '<em><b>Atributos Mostrados</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_INDICE_PAGINADA__ATRIBUTOS_MOSTRADOS = PAGINA_INDICE__ATRIBUTOS_MOSTRADOS;

	/**
	 * The feature id for the '<em><b>Page Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_INDICE_PAGINADA__PAGE_SIZE = PAGINA_INDICE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Pagina Indice Paginada</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_INDICE_PAGINADA_FEATURE_COUNT = PAGINA_INDICE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Pagina Indice Paginada</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_INDICE_PAGINADA_OPERATION_COUNT = PAGINA_INDICE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dataweb.impl.PaginaIndiceFiltrosImpl <em>Pagina Indice Filtros</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dataweb.impl.PaginaIndiceFiltrosImpl
	 * @see dataweb.impl.DatawebPackageImpl#getPaginaIndiceFiltros()
	 * @generated
	 */
	int PAGINA_INDICE_FILTROS = 25;

	/**
	 * The feature id for the '<em><b>Enlaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_INDICE_FILTROS__ENLACES = PAGINA_INDICE__ENLACES;

	/**
	 * The feature id for the '<em><b>Redes Sociales</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_INDICE_FILTROS__REDES_SOCIALES = PAGINA_INDICE__REDES_SOCIALES;

	/**
	 * The feature id for the '<em><b>Fuentes RSS</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_INDICE_FILTROS__FUENTES_RSS = PAGINA_INDICE__FUENTES_RSS;

	/**
	 * The feature id for the '<em><b>Nombre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_INDICE_FILTROS__NOMBRE = PAGINA_INDICE__NOMBRE;

	/**
	 * The feature id for the '<em><b>Titulo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_INDICE_FILTROS__TITULO = PAGINA_INDICE__TITULO;

	/**
	 * The feature id for the '<em><b>Descripcion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_INDICE_FILTROS__DESCRIPCION = PAGINA_INDICE__DESCRIPCION;

	/**
	 * The feature id for the '<em><b>Entidad</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_INDICE_FILTROS__ENTIDAD = PAGINA_INDICE__ENTIDAD;

	/**
	 * The feature id for the '<em><b>Atributos Mostrados</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_INDICE_FILTROS__ATRIBUTOS_MOSTRADOS = PAGINA_INDICE__ATRIBUTOS_MOSTRADOS;

	/**
	 * The feature id for the '<em><b>Atributos Filtro</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_INDICE_FILTROS__ATRIBUTOS_FILTRO = PAGINA_INDICE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Pagina Indice Filtros</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_INDICE_FILTROS_FEATURE_COUNT = PAGINA_INDICE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Pagina Indice Filtros</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_INDICE_FILTROS_OPERATION_COUNT = PAGINA_INDICE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dataweb.impl.PaginaIndicePaginadaFiltradaImpl <em>Pagina Indice Paginada Filtrada</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dataweb.impl.PaginaIndicePaginadaFiltradaImpl
	 * @see dataweb.impl.DatawebPackageImpl#getPaginaIndicePaginadaFiltrada()
	 * @generated
	 */
	int PAGINA_INDICE_PAGINADA_FILTRADA = 26;

	/**
	 * The feature id for the '<em><b>Enlaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_INDICE_PAGINADA_FILTRADA__ENLACES = PAGINA_INDICE__ENLACES;

	/**
	 * The feature id for the '<em><b>Redes Sociales</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_INDICE_PAGINADA_FILTRADA__REDES_SOCIALES = PAGINA_INDICE__REDES_SOCIALES;

	/**
	 * The feature id for the '<em><b>Fuentes RSS</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_INDICE_PAGINADA_FILTRADA__FUENTES_RSS = PAGINA_INDICE__FUENTES_RSS;

	/**
	 * The feature id for the '<em><b>Nombre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_INDICE_PAGINADA_FILTRADA__NOMBRE = PAGINA_INDICE__NOMBRE;

	/**
	 * The feature id for the '<em><b>Titulo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_INDICE_PAGINADA_FILTRADA__TITULO = PAGINA_INDICE__TITULO;

	/**
	 * The feature id for the '<em><b>Descripcion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_INDICE_PAGINADA_FILTRADA__DESCRIPCION = PAGINA_INDICE__DESCRIPCION;

	/**
	 * The feature id for the '<em><b>Entidad</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_INDICE_PAGINADA_FILTRADA__ENTIDAD = PAGINA_INDICE__ENTIDAD;

	/**
	 * The feature id for the '<em><b>Atributos Mostrados</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_INDICE_PAGINADA_FILTRADA__ATRIBUTOS_MOSTRADOS = PAGINA_INDICE__ATRIBUTOS_MOSTRADOS;

	/**
	 * The feature id for the '<em><b>Page Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_INDICE_PAGINADA_FILTRADA__PAGE_SIZE = PAGINA_INDICE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Atributos Filtro</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_INDICE_PAGINADA_FILTRADA__ATRIBUTOS_FILTRO = PAGINA_INDICE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Pagina Indice Paginada Filtrada</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_INDICE_PAGINADA_FILTRADA_FEATURE_COUNT = PAGINA_INDICE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Pagina Indice Paginada Filtrada</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGINA_INDICE_PAGINADA_FILTRADA_OPERATION_COUNT = PAGINA_INDICE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dataweb.TipoAtributo <em>Tipo Atributo</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dataweb.TipoAtributo
	 * @see dataweb.impl.DatawebPackageImpl#getTipoAtributo()
	 * @generated
	 */
	int TIPO_ATRIBUTO = 27;

	/**
	 * The meta object id for the '{@link dataweb.TipoRepresentacion <em>Tipo Representacion</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dataweb.TipoRepresentacion
	 * @see dataweb.impl.DatawebPackageImpl#getTipoRepresentacion()
	 * @generated
	 */
	int TIPO_REPRESENTACION = 28;

	/**
	 * The meta object id for the '{@link dataweb.TipoRedSocial <em>Tipo Red Social</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dataweb.TipoRedSocial
	 * @see dataweb.impl.DatawebPackageImpl#getTipoRedSocial()
	 * @generated
	 */
	int TIPO_RED_SOCIAL = 29;


	/**
	 * Returns the meta object for class '{@link dataweb.Aplicacion <em>Aplicacion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Aplicacion</em>'.
	 * @see dataweb.Aplicacion
	 * @generated
	 */
	EClass getAplicacion();

	/**
	 * Returns the meta object for the attribute '{@link dataweb.Aplicacion#getNombre <em>Nombre</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nombre</em>'.
	 * @see dataweb.Aplicacion#getNombre()
	 * @see #getAplicacion()
	 * @generated
	 */
	EAttribute getAplicacion_Nombre();

	/**
	 * Returns the meta object for the attribute '{@link dataweb.Aplicacion#getDescripcion <em>Descripcion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Descripcion</em>'.
	 * @see dataweb.Aplicacion#getDescripcion()
	 * @see #getAplicacion()
	 * @generated
	 */
	EAttribute getAplicacion_Descripcion();

	/**
	 * Returns the meta object for the containment reference list '{@link dataweb.Aplicacion#getEntidades <em>Entidades</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Entidades</em>'.
	 * @see dataweb.Aplicacion#getEntidades()
	 * @see #getAplicacion()
	 * @generated
	 */
	EReference getAplicacion_Entidades();

	/**
	 * Returns the meta object for the containment reference list '{@link dataweb.Aplicacion#getPaginas <em>Paginas</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Paginas</em>'.
	 * @see dataweb.Aplicacion#getPaginas()
	 * @see #getAplicacion()
	 * @generated
	 */
	EReference getAplicacion_Paginas();

	/**
	 * Returns the meta object for the containment reference list '{@link dataweb.Aplicacion#getRoles <em>Roles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Roles</em>'.
	 * @see dataweb.Aplicacion#getRoles()
	 * @see #getAplicacion()
	 * @generated
	 */
	EReference getAplicacion_Roles();

	/**
	 * Returns the meta object for the containment reference list '{@link dataweb.Aplicacion#getCuestionarios <em>Cuestionarios</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Cuestionarios</em>'.
	 * @see dataweb.Aplicacion#getCuestionarios()
	 * @see #getAplicacion()
	 * @generated
	 */
	EReference getAplicacion_Cuestionarios();

	/**
	 * Returns the meta object for the containment reference list '{@link dataweb.Aplicacion#getEncuestas <em>Encuestas</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Encuestas</em>'.
	 * @see dataweb.Aplicacion#getEncuestas()
	 * @see #getAplicacion()
	 * @generated
	 */
	EReference getAplicacion_Encuestas();

	/**
	 * Returns the meta object for the containment reference list '{@link dataweb.Aplicacion#getRedesSociales <em>Redes Sociales</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Redes Sociales</em>'.
	 * @see dataweb.Aplicacion#getRedesSociales()
	 * @see #getAplicacion()
	 * @generated
	 */
	EReference getAplicacion_RedesSociales();

	/**
	 * Returns the meta object for the containment reference list '{@link dataweb.Aplicacion#getFuentesRSS <em>Fuentes RSS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Fuentes RSS</em>'.
	 * @see dataweb.Aplicacion#getFuentesRSS()
	 * @see #getAplicacion()
	 * @generated
	 */
	EReference getAplicacion_FuentesRSS();

	/**
	 * Returns the meta object for the attribute '{@link dataweb.Aplicacion#getPaginasMediasAccesibles <em>Paginas Medias Accesibles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Paginas Medias Accesibles</em>'.
	 * @see dataweb.Aplicacion#getPaginasMediasAccesibles()
	 * @see #getAplicacion()
	 * @generated
	 */
	EAttribute getAplicacion_PaginasMediasAccesibles();

	/**
	 * Returns the meta object for class '{@link dataweb.Entidad <em>Entidad</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entidad</em>'.
	 * @see dataweb.Entidad
	 * @generated
	 */
	EClass getEntidad();

	/**
	 * Returns the meta object for the attribute '{@link dataweb.Entidad#getNombre <em>Nombre</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nombre</em>'.
	 * @see dataweb.Entidad#getNombre()
	 * @see #getEntidad()
	 * @generated
	 */
	EAttribute getEntidad_Nombre();

	/**
	 * Returns the meta object for the attribute '{@link dataweb.Entidad#getTableName <em>Table Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Table Name</em>'.
	 * @see dataweb.Entidad#getTableName()
	 * @see #getEntidad()
	 * @generated
	 */
	EAttribute getEntidad_TableName();

	/**
	 * Returns the meta object for the attribute '{@link dataweb.Entidad#isHasCRUD <em>Has CRUD</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Has CRUD</em>'.
	 * @see dataweb.Entidad#isHasCRUD()
	 * @see #getEntidad()
	 * @generated
	 */
	EAttribute getEntidad_HasCRUD();

	/**
	 * Returns the meta object for the attribute '{@link dataweb.Entidad#isHasIndex <em>Has Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Has Index</em>'.
	 * @see dataweb.Entidad#isHasIndex()
	 * @see #getEntidad()
	 * @generated
	 */
	EAttribute getEntidad_HasIndex();

	/**
	 * Returns the meta object for the attribute '{@link dataweb.Entidad#isHasExtendedIndex <em>Has Extended Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Has Extended Index</em>'.
	 * @see dataweb.Entidad#isHasExtendedIndex()
	 * @see #getEntidad()
	 * @generated
	 */
	EAttribute getEntidad_HasExtendedIndex();

	/**
	 * Returns the meta object for the attribute '{@link dataweb.Entidad#isHasDetails <em>Has Details</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Has Details</em>'.
	 * @see dataweb.Entidad#isHasDetails()
	 * @see #getEntidad()
	 * @generated
	 */
	EAttribute getEntidad_HasDetails();

	/**
	 * Returns the meta object for the attribute '{@link dataweb.Entidad#isHasCreate <em>Has Create</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Has Create</em>'.
	 * @see dataweb.Entidad#isHasCreate()
	 * @see #getEntidad()
	 * @generated
	 */
	EAttribute getEntidad_HasCreate();

	/**
	 * Returns the meta object for the attribute '{@link dataweb.Entidad#isHasUpdate <em>Has Update</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Has Update</em>'.
	 * @see dataweb.Entidad#isHasUpdate()
	 * @see #getEntidad()
	 * @generated
	 */
	EAttribute getEntidad_HasUpdate();

	/**
	 * Returns the meta object for the attribute '{@link dataweb.Entidad#isHasDelete <em>Has Delete</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Has Delete</em>'.
	 * @see dataweb.Entidad#isHasDelete()
	 * @see #getEntidad()
	 * @generated
	 */
	EAttribute getEntidad_HasDelete();

	/**
	 * Returns the meta object for the containment reference list '{@link dataweb.Entidad#getAtributos <em>Atributos</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Atributos</em>'.
	 * @see dataweb.Entidad#getAtributos()
	 * @see #getEntidad()
	 * @generated
	 */
	EReference getEntidad_Atributos();

	/**
	 * Returns the meta object for the containment reference list '{@link dataweb.Entidad#getReferencias <em>Referencias</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Referencias</em>'.
	 * @see dataweb.Entidad#getReferencias()
	 * @see #getEntidad()
	 * @generated
	 */
	EReference getEntidad_Referencias();

	/**
	 * Returns the meta object for class '{@link dataweb.Atributo <em>Atributo</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Atributo</em>'.
	 * @see dataweb.Atributo
	 * @generated
	 */
	EClass getAtributo();

	/**
	 * Returns the meta object for the attribute '{@link dataweb.Atributo#getNombre <em>Nombre</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nombre</em>'.
	 * @see dataweb.Atributo#getNombre()
	 * @see #getAtributo()
	 * @generated
	 */
	EAttribute getAtributo_Nombre();

	/**
	 * Returns the meta object for the attribute '{@link dataweb.Atributo#isIsPrimaryKey <em>Is Primary Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Primary Key</em>'.
	 * @see dataweb.Atributo#isIsPrimaryKey()
	 * @see #getAtributo()
	 * @generated
	 */
	EAttribute getAtributo_IsPrimaryKey();

	/**
	 * Returns the meta object for the attribute '{@link dataweb.Atributo#getTipo <em>Tipo</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tipo</em>'.
	 * @see dataweb.Atributo#getTipo()
	 * @see #getAtributo()
	 * @generated
	 */
	EAttribute getAtributo_Tipo();

	/**
	 * Returns the meta object for class '{@link dataweb.Referencia <em>Referencia</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Referencia</em>'.
	 * @see dataweb.Referencia
	 * @generated
	 */
	EClass getReferencia();

	/**
	 * Returns the meta object for the attribute '{@link dataweb.Referencia#getNombre <em>Nombre</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nombre</em>'.
	 * @see dataweb.Referencia#getNombre()
	 * @see #getReferencia()
	 * @generated
	 */
	EAttribute getReferencia_Nombre();

	/**
	 * Returns the meta object for the attribute '{@link dataweb.Referencia#getMultiplicidad <em>Multiplicidad</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Multiplicidad</em>'.
	 * @see dataweb.Referencia#getMultiplicidad()
	 * @see #getReferencia()
	 * @generated
	 */
	EAttribute getReferencia_Multiplicidad();

	/**
	 * Returns the meta object for the reference '{@link dataweb.Referencia#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see dataweb.Referencia#getSource()
	 * @see #getReferencia()
	 * @generated
	 */
	EReference getReferencia_Source();

	/**
	 * Returns the meta object for the reference '{@link dataweb.Referencia#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see dataweb.Referencia#getTarget()
	 * @see #getReferencia()
	 * @generated
	 */
	EReference getReferencia_Target();

	/**
	 * Returns the meta object for class '{@link dataweb.Pagina <em>Pagina</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pagina</em>'.
	 * @see dataweb.Pagina
	 * @generated
	 */
	EClass getPagina();

	/**
	 * Returns the meta object for the reference list '{@link dataweb.Pagina#getEnlaces <em>Enlaces</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Enlaces</em>'.
	 * @see dataweb.Pagina#getEnlaces()
	 * @see #getPagina()
	 * @generated
	 */
	EReference getPagina_Enlaces();

	/**
	 * Returns the meta object for the reference list '{@link dataweb.Pagina#getRedesSociales <em>Redes Sociales</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Redes Sociales</em>'.
	 * @see dataweb.Pagina#getRedesSociales()
	 * @see #getPagina()
	 * @generated
	 */
	EReference getPagina_RedesSociales();

	/**
	 * Returns the meta object for the reference list '{@link dataweb.Pagina#getFuentesRSS <em>Fuentes RSS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Fuentes RSS</em>'.
	 * @see dataweb.Pagina#getFuentesRSS()
	 * @see #getPagina()
	 * @generated
	 */
	EReference getPagina_FuentesRSS();

	/**
	 * Returns the meta object for the attribute '{@link dataweb.Pagina#getNombre <em>Nombre</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nombre</em>'.
	 * @see dataweb.Pagina#getNombre()
	 * @see #getPagina()
	 * @generated
	 */
	EAttribute getPagina_Nombre();

	/**
	 * Returns the meta object for the attribute '{@link dataweb.Pagina#getTitulo <em>Titulo</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Titulo</em>'.
	 * @see dataweb.Pagina#getTitulo()
	 * @see #getPagina()
	 * @generated
	 */
	EAttribute getPagina_Titulo();

	/**
	 * Returns the meta object for the attribute '{@link dataweb.Pagina#getDescripcion <em>Descripcion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Descripcion</em>'.
	 * @see dataweb.Pagina#getDescripcion()
	 * @see #getPagina()
	 * @generated
	 */
	EAttribute getPagina_Descripcion();

	/**
	 * Returns the meta object for class '{@link dataweb.PaginaHome <em>Pagina Home</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pagina Home</em>'.
	 * @see dataweb.PaginaHome
	 * @generated
	 */
	EClass getPaginaHome();

	/**
	 * Returns the meta object for class '{@link dataweb.PaginaContenido <em>Pagina Contenido</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pagina Contenido</em>'.
	 * @see dataweb.PaginaContenido
	 * @generated
	 */
	EClass getPaginaContenido();

	/**
	 * Returns the meta object for the attribute '{@link dataweb.PaginaContenido#getContenido <em>Contenido</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Contenido</em>'.
	 * @see dataweb.PaginaContenido#getContenido()
	 * @see #getPaginaContenido()
	 * @generated
	 */
	EAttribute getPaginaContenido_Contenido();

	/**
	 * Returns the meta object for class '{@link dataweb.PaginaCRUD <em>Pagina CRUD</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pagina CRUD</em>'.
	 * @see dataweb.PaginaCRUD
	 * @generated
	 */
	EClass getPaginaCRUD();

	/**
	 * Returns the meta object for the reference '{@link dataweb.PaginaCRUD#getEntidad <em>Entidad</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Entidad</em>'.
	 * @see dataweb.PaginaCRUD#getEntidad()
	 * @see #getPaginaCRUD()
	 * @generated
	 */
	EReference getPaginaCRUD_Entidad();

	/**
	 * Returns the meta object for class '{@link dataweb.PaginaIndice <em>Pagina Indice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pagina Indice</em>'.
	 * @see dataweb.PaginaIndice
	 * @generated
	 */
	EClass getPaginaIndice();

	/**
	 * Returns the meta object for the reference list '{@link dataweb.PaginaIndice#getAtributosMostrados <em>Atributos Mostrados</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Atributos Mostrados</em>'.
	 * @see dataweb.PaginaIndice#getAtributosMostrados()
	 * @see #getPaginaIndice()
	 * @generated
	 */
	EReference getPaginaIndice_AtributosMostrados();

	/**
	 * Returns the meta object for class '{@link dataweb.PaginaDetalle <em>Pagina Detalle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pagina Detalle</em>'.
	 * @see dataweb.PaginaDetalle
	 * @generated
	 */
	EClass getPaginaDetalle();

	/**
	 * Returns the meta object for class '{@link dataweb.PaginaCreacion <em>Pagina Creacion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pagina Creacion</em>'.
	 * @see dataweb.PaginaCreacion
	 * @generated
	 */
	EClass getPaginaCreacion();

	/**
	 * Returns the meta object for class '{@link dataweb.PaginaActualizacion <em>Pagina Actualizacion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pagina Actualizacion</em>'.
	 * @see dataweb.PaginaActualizacion
	 * @generated
	 */
	EClass getPaginaActualizacion();

	/**
	 * Returns the meta object for class '{@link dataweb.PaginaBorrado <em>Pagina Borrado</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pagina Borrado</em>'.
	 * @see dataweb.PaginaBorrado
	 * @generated
	 */
	EClass getPaginaBorrado();

	/**
	 * Returns the meta object for class '{@link dataweb.PaginaIndiceDetalle <em>Pagina Indice Detalle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pagina Indice Detalle</em>'.
	 * @see dataweb.PaginaIndiceDetalle
	 * @generated
	 */
	EClass getPaginaIndiceDetalle();

	/**
	 * Returns the meta object for class '{@link dataweb.Encuesta <em>Encuesta</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Encuesta</em>'.
	 * @see dataweb.Encuesta
	 * @generated
	 */
	EClass getEncuesta();

	/**
	 * Returns the meta object for the containment reference list '{@link dataweb.Encuesta#getPreguntas <em>Preguntas</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Preguntas</em>'.
	 * @see dataweb.Encuesta#getPreguntas()
	 * @see #getEncuesta()
	 * @generated
	 */
	EReference getEncuesta_Preguntas();

	/**
	 * Returns the meta object for the attribute '{@link dataweb.Encuesta#getNombre <em>Nombre</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nombre</em>'.
	 * @see dataweb.Encuesta#getNombre()
	 * @see #getEncuesta()
	 * @generated
	 */
	EAttribute getEncuesta_Nombre();

	/**
	 * Returns the meta object for the attribute '{@link dataweb.Encuesta#getDescripcion <em>Descripcion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Descripcion</em>'.
	 * @see dataweb.Encuesta#getDescripcion()
	 * @see #getEncuesta()
	 * @generated
	 */
	EAttribute getEncuesta_Descripcion();

	/**
	 * Returns the meta object for the attribute '{@link dataweb.Encuesta#getTipoRepresentacion <em>Tipo Representacion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tipo Representacion</em>'.
	 * @see dataweb.Encuesta#getTipoRepresentacion()
	 * @see #getEncuesta()
	 * @generated
	 */
	EAttribute getEncuesta_TipoRepresentacion();

	/**
	 * Returns the meta object for the attribute '{@link dataweb.Encuesta#getTitulo <em>Titulo</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Titulo</em>'.
	 * @see dataweb.Encuesta#getTitulo()
	 * @see #getEncuesta()
	 * @generated
	 */
	EAttribute getEncuesta_Titulo();

	/**
	 * Returns the meta object for the attribute '{@link dataweb.Encuesta#getNumeroPregVF <em>Numero Preg VF</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Numero Preg VF</em>'.
	 * @see dataweb.Encuesta#getNumeroPregVF()
	 * @see #getEncuesta()
	 * @generated
	 */
	EAttribute getEncuesta_NumeroPregVF();

	/**
	 * Returns the meta object for the attribute '{@link dataweb.Encuesta#getNumeroPregSelect <em>Numero Preg Select</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Numero Preg Select</em>'.
	 * @see dataweb.Encuesta#getNumeroPregSelect()
	 * @see #getEncuesta()
	 * @generated
	 */
	EAttribute getEncuesta_NumeroPregSelect();

	/**
	 * Returns the meta object for class '{@link dataweb.Cuestionario <em>Cuestionario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cuestionario</em>'.
	 * @see dataweb.Cuestionario
	 * @generated
	 */
	EClass getCuestionario();

	/**
	 * Returns the meta object for the containment reference list '{@link dataweb.Cuestionario#getPreguntas <em>Preguntas</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Preguntas</em>'.
	 * @see dataweb.Cuestionario#getPreguntas()
	 * @see #getCuestionario()
	 * @generated
	 */
	EReference getCuestionario_Preguntas();

	/**
	 * Returns the meta object for the attribute '{@link dataweb.Cuestionario#getNombre <em>Nombre</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nombre</em>'.
	 * @see dataweb.Cuestionario#getNombre()
	 * @see #getCuestionario()
	 * @generated
	 */
	EAttribute getCuestionario_Nombre();

	/**
	 * Returns the meta object for the attribute '{@link dataweb.Cuestionario#getDescripcion <em>Descripcion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Descripcion</em>'.
	 * @see dataweb.Cuestionario#getDescripcion()
	 * @see #getCuestionario()
	 * @generated
	 */
	EAttribute getCuestionario_Descripcion();

	/**
	 * Returns the meta object for the attribute '{@link dataweb.Cuestionario#getTitulo <em>Titulo</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Titulo</em>'.
	 * @see dataweb.Cuestionario#getTitulo()
	 * @see #getCuestionario()
	 * @generated
	 */
	EAttribute getCuestionario_Titulo();

	/**
	 * Returns the meta object for the attribute '{@link dataweb.Cuestionario#getNumeroPregVF <em>Numero Preg VF</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Numero Preg VF</em>'.
	 * @see dataweb.Cuestionario#getNumeroPregVF()
	 * @see #getCuestionario()
	 * @generated
	 */
	EAttribute getCuestionario_NumeroPregVF();

	/**
	 * Returns the meta object for the attribute '{@link dataweb.Cuestionario#getNumeroPregSelect <em>Numero Preg Select</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Numero Preg Select</em>'.
	 * @see dataweb.Cuestionario#getNumeroPregSelect()
	 * @see #getCuestionario()
	 * @generated
	 */
	EAttribute getCuestionario_NumeroPregSelect();

	/**
	 * Returns the meta object for class '{@link dataweb.Pregunta <em>Pregunta</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pregunta</em>'.
	 * @see dataweb.Pregunta
	 * @generated
	 */
	EClass getPregunta();

	/**
	 * Returns the meta object for the attribute '{@link dataweb.Pregunta#getNombre <em>Nombre</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nombre</em>'.
	 * @see dataweb.Pregunta#getNombre()
	 * @see #getPregunta()
	 * @generated
	 */
	EAttribute getPregunta_Nombre();

	/**
	 * Returns the meta object for the attribute '{@link dataweb.Pregunta#getTexto <em>Texto</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Texto</em>'.
	 * @see dataweb.Pregunta#getTexto()
	 * @see #getPregunta()
	 * @generated
	 */
	EAttribute getPregunta_Texto();

	/**
	 * Returns the meta object for class '{@link dataweb.PreguntaOpcionMultiple <em>Pregunta Opcion Multiple</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pregunta Opcion Multiple</em>'.
	 * @see dataweb.PreguntaOpcionMultiple
	 * @generated
	 */
	EClass getPreguntaOpcionMultiple();

	/**
	 * Returns the meta object for the containment reference list '{@link dataweb.PreguntaOpcionMultiple#getOpciones <em>Opciones</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Opciones</em>'.
	 * @see dataweb.PreguntaOpcionMultiple#getOpciones()
	 * @see #getPreguntaOpcionMultiple()
	 * @generated
	 */
	EReference getPreguntaOpcionMultiple_Opciones();

	/**
	 * Returns the meta object for the reference '{@link dataweb.PreguntaOpcionMultiple#getRespuestaCorrecta <em>Respuesta Correcta</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Respuesta Correcta</em>'.
	 * @see dataweb.PreguntaOpcionMultiple#getRespuestaCorrecta()
	 * @see #getPreguntaOpcionMultiple()
	 * @generated
	 */
	EReference getPreguntaOpcionMultiple_RespuestaCorrecta();

	/**
	 * Returns the meta object for class '{@link dataweb.OpcionRespuesta <em>Opcion Respuesta</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Opcion Respuesta</em>'.
	 * @see dataweb.OpcionRespuesta
	 * @generated
	 */
	EClass getOpcionRespuesta();

	/**
	 * Returns the meta object for the attribute '{@link dataweb.OpcionRespuesta#getNombre <em>Nombre</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nombre</em>'.
	 * @see dataweb.OpcionRespuesta#getNombre()
	 * @see #getOpcionRespuesta()
	 * @generated
	 */
	EAttribute getOpcionRespuesta_Nombre();

	/**
	 * Returns the meta object for the attribute '{@link dataweb.OpcionRespuesta#getTexto <em>Texto</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Texto</em>'.
	 * @see dataweb.OpcionRespuesta#getTexto()
	 * @see #getOpcionRespuesta()
	 * @generated
	 */
	EAttribute getOpcionRespuesta_Texto();

	/**
	 * Returns the meta object for the attribute '{@link dataweb.OpcionRespuesta#getValor <em>Valor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Valor</em>'.
	 * @see dataweb.OpcionRespuesta#getValor()
	 * @see #getOpcionRespuesta()
	 * @generated
	 */
	EAttribute getOpcionRespuesta_Valor();

	/**
	 * Returns the meta object for class '{@link dataweb.PreguntaVerdaderoFalso <em>Pregunta Verdadero Falso</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pregunta Verdadero Falso</em>'.
	 * @see dataweb.PreguntaVerdaderoFalso
	 * @generated
	 */
	EClass getPreguntaVerdaderoFalso();

	/**
	 * Returns the meta object for the attribute '{@link dataweb.PreguntaVerdaderoFalso#getRespuestaCorrecta <em>Respuesta Correcta</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Respuesta Correcta</em>'.
	 * @see dataweb.PreguntaVerdaderoFalso#getRespuestaCorrecta()
	 * @see #getPreguntaVerdaderoFalso()
	 * @generated
	 */
	EAttribute getPreguntaVerdaderoFalso_RespuestaCorrecta();

	/**
	 * Returns the meta object for class '{@link dataweb.PreguntaRespuestaCorta <em>Pregunta Respuesta Corta</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pregunta Respuesta Corta</em>'.
	 * @see dataweb.PreguntaRespuestaCorta
	 * @generated
	 */
	EClass getPreguntaRespuestaCorta();

	/**
	 * Returns the meta object for the attribute '{@link dataweb.PreguntaRespuestaCorta#getRespuestaCorta <em>Respuesta Corta</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Respuesta Corta</em>'.
	 * @see dataweb.PreguntaRespuestaCorta#getRespuestaCorta()
	 * @see #getPreguntaRespuestaCorta()
	 * @generated
	 */
	EAttribute getPreguntaRespuestaCorta_RespuestaCorta();

	/**
	 * Returns the meta object for class '{@link dataweb.RedSocial <em>Red Social</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Red Social</em>'.
	 * @see dataweb.RedSocial
	 * @generated
	 */
	EClass getRedSocial();

	/**
	 * Returns the meta object for the attribute '{@link dataweb.RedSocial#getTipo <em>Tipo</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tipo</em>'.
	 * @see dataweb.RedSocial#getTipo()
	 * @see #getRedSocial()
	 * @generated
	 */
	EAttribute getRedSocial_Tipo();

	/**
	 * Returns the meta object for the attribute '{@link dataweb.RedSocial#getNombre <em>Nombre</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nombre</em>'.
	 * @see dataweb.RedSocial#getNombre()
	 * @see #getRedSocial()
	 * @generated
	 */
	EAttribute getRedSocial_Nombre();

	/**
	 * Returns the meta object for the attribute '{@link dataweb.RedSocial#getCodigoEmbed <em>Codigo Embed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Codigo Embed</em>'.
	 * @see dataweb.RedSocial#getCodigoEmbed()
	 * @see #getRedSocial()
	 * @generated
	 */
	EAttribute getRedSocial_CodigoEmbed();

	/**
	 * Returns the meta object for the attribute '{@link dataweb.RedSocial#getNombreCuenta <em>Nombre Cuenta</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nombre Cuenta</em>'.
	 * @see dataweb.RedSocial#getNombreCuenta()
	 * @see #getRedSocial()
	 * @generated
	 */
	EAttribute getRedSocial_NombreCuenta();

	/**
	 * Returns the meta object for class '{@link dataweb.Rol <em>Rol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rol</em>'.
	 * @see dataweb.Rol
	 * @generated
	 */
	EClass getRol();

	/**
	 * Returns the meta object for the attribute '{@link dataweb.Rol#getNombre <em>Nombre</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nombre</em>'.
	 * @see dataweb.Rol#getNombre()
	 * @see #getRol()
	 * @generated
	 */
	EAttribute getRol_Nombre();

	/**
	 * Returns the meta object for the attribute '{@link dataweb.Rol#getDescripcion <em>Descripcion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Descripcion</em>'.
	 * @see dataweb.Rol#getDescripcion()
	 * @see #getRol()
	 * @generated
	 */
	EAttribute getRol_Descripcion();

	/**
	 * Returns the meta object for the reference list '{@link dataweb.Rol#getPaginasAccesibles <em>Paginas Accesibles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Paginas Accesibles</em>'.
	 * @see dataweb.Rol#getPaginasAccesibles()
	 * @see #getRol()
	 * @generated
	 */
	EReference getRol_PaginasAccesibles();

	/**
	 * Returns the meta object for the attribute '{@link dataweb.Rol#getNumeroEntidadesAccesibles <em>Numero Entidades Accesibles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Numero Entidades Accesibles</em>'.
	 * @see dataweb.Rol#getNumeroEntidadesAccesibles()
	 * @see #getRol()
	 * @generated
	 */
	EAttribute getRol_NumeroEntidadesAccesibles();

	/**
	 * Returns the meta object for class '{@link dataweb.FuenteRSS <em>Fuente RSS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fuente RSS</em>'.
	 * @see dataweb.FuenteRSS
	 * @generated
	 */
	EClass getFuenteRSS();

	/**
	 * Returns the meta object for the attribute '{@link dataweb.FuenteRSS#getNombre <em>Nombre</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nombre</em>'.
	 * @see dataweb.FuenteRSS#getNombre()
	 * @see #getFuenteRSS()
	 * @generated
	 */
	EAttribute getFuenteRSS_Nombre();

	/**
	 * Returns the meta object for the attribute '{@link dataweb.FuenteRSS#getUrl <em>Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Url</em>'.
	 * @see dataweb.FuenteRSS#getUrl()
	 * @see #getFuenteRSS()
	 * @generated
	 */
	EAttribute getFuenteRSS_Url();

	/**
	 * Returns the meta object for the attribute '{@link dataweb.FuenteRSS#getTitulo <em>Titulo</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Titulo</em>'.
	 * @see dataweb.FuenteRSS#getTitulo()
	 * @see #getFuenteRSS()
	 * @generated
	 */
	EAttribute getFuenteRSS_Titulo();

	/**
	 * Returns the meta object for the attribute '{@link dataweb.FuenteRSS#getNumItems <em>Num Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Num Items</em>'.
	 * @see dataweb.FuenteRSS#getNumItems()
	 * @see #getFuenteRSS()
	 * @generated
	 */
	EAttribute getFuenteRSS_NumItems();

	/**
	 * Returns the meta object for the attribute '{@link dataweb.FuenteRSS#isMostrarDescripcion <em>Mostrar Descripcion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mostrar Descripcion</em>'.
	 * @see dataweb.FuenteRSS#isMostrarDescripcion()
	 * @see #getFuenteRSS()
	 * @generated
	 */
	EAttribute getFuenteRSS_MostrarDescripcion();

	/**
	 * Returns the meta object for class '{@link dataweb.PaginaIndicePaginada <em>Pagina Indice Paginada</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pagina Indice Paginada</em>'.
	 * @see dataweb.PaginaIndicePaginada
	 * @generated
	 */
	EClass getPaginaIndicePaginada();

	/**
	 * Returns the meta object for the attribute '{@link dataweb.PaginaIndicePaginada#getPageSize <em>Page Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Page Size</em>'.
	 * @see dataweb.PaginaIndicePaginada#getPageSize()
	 * @see #getPaginaIndicePaginada()
	 * @generated
	 */
	EAttribute getPaginaIndicePaginada_PageSize();

	/**
	 * Returns the meta object for class '{@link dataweb.PaginaIndiceFiltros <em>Pagina Indice Filtros</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pagina Indice Filtros</em>'.
	 * @see dataweb.PaginaIndiceFiltros
	 * @generated
	 */
	EClass getPaginaIndiceFiltros();

	/**
	 * Returns the meta object for the reference list '{@link dataweb.PaginaIndiceFiltros#getAtributosFiltro <em>Atributos Filtro</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Atributos Filtro</em>'.
	 * @see dataweb.PaginaIndiceFiltros#getAtributosFiltro()
	 * @see #getPaginaIndiceFiltros()
	 * @generated
	 */
	EReference getPaginaIndiceFiltros_AtributosFiltro();

	/**
	 * Returns the meta object for class '{@link dataweb.PaginaIndicePaginadaFiltrada <em>Pagina Indice Paginada Filtrada</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pagina Indice Paginada Filtrada</em>'.
	 * @see dataweb.PaginaIndicePaginadaFiltrada
	 * @generated
	 */
	EClass getPaginaIndicePaginadaFiltrada();

	/**
	 * Returns the meta object for the attribute '{@link dataweb.PaginaIndicePaginadaFiltrada#getPageSize <em>Page Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Page Size</em>'.
	 * @see dataweb.PaginaIndicePaginadaFiltrada#getPageSize()
	 * @see #getPaginaIndicePaginadaFiltrada()
	 * @generated
	 */
	EAttribute getPaginaIndicePaginadaFiltrada_PageSize();

	/**
	 * Returns the meta object for the reference list '{@link dataweb.PaginaIndicePaginadaFiltrada#getAtributosFiltro <em>Atributos Filtro</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Atributos Filtro</em>'.
	 * @see dataweb.PaginaIndicePaginadaFiltrada#getAtributosFiltro()
	 * @see #getPaginaIndicePaginadaFiltrada()
	 * @generated
	 */
	EReference getPaginaIndicePaginadaFiltrada_AtributosFiltro();

	/**
	 * Returns the meta object for enum '{@link dataweb.TipoAtributo <em>Tipo Atributo</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Tipo Atributo</em>'.
	 * @see dataweb.TipoAtributo
	 * @generated
	 */
	EEnum getTipoAtributo();

	/**
	 * Returns the meta object for enum '{@link dataweb.TipoRepresentacion <em>Tipo Representacion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Tipo Representacion</em>'.
	 * @see dataweb.TipoRepresentacion
	 * @generated
	 */
	EEnum getTipoRepresentacion();

	/**
	 * Returns the meta object for enum '{@link dataweb.TipoRedSocial <em>Tipo Red Social</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Tipo Red Social</em>'.
	 * @see dataweb.TipoRedSocial
	 * @generated
	 */
	EEnum getTipoRedSocial();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DatawebFactory getDatawebFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link dataweb.impl.AplicacionImpl <em>Aplicacion</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dataweb.impl.AplicacionImpl
		 * @see dataweb.impl.DatawebPackageImpl#getAplicacion()
		 * @generated
		 */
		EClass APLICACION = eINSTANCE.getAplicacion();

		/**
		 * The meta object literal for the '<em><b>Nombre</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APLICACION__NOMBRE = eINSTANCE.getAplicacion_Nombre();

		/**
		 * The meta object literal for the '<em><b>Descripcion</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APLICACION__DESCRIPCION = eINSTANCE.getAplicacion_Descripcion();

		/**
		 * The meta object literal for the '<em><b>Entidades</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APLICACION__ENTIDADES = eINSTANCE.getAplicacion_Entidades();

		/**
		 * The meta object literal for the '<em><b>Paginas</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APLICACION__PAGINAS = eINSTANCE.getAplicacion_Paginas();

		/**
		 * The meta object literal for the '<em><b>Roles</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APLICACION__ROLES = eINSTANCE.getAplicacion_Roles();

		/**
		 * The meta object literal for the '<em><b>Cuestionarios</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APLICACION__CUESTIONARIOS = eINSTANCE.getAplicacion_Cuestionarios();

		/**
		 * The meta object literal for the '<em><b>Encuestas</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APLICACION__ENCUESTAS = eINSTANCE.getAplicacion_Encuestas();

		/**
		 * The meta object literal for the '<em><b>Redes Sociales</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APLICACION__REDES_SOCIALES = eINSTANCE.getAplicacion_RedesSociales();

		/**
		 * The meta object literal for the '<em><b>Fuentes RSS</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APLICACION__FUENTES_RSS = eINSTANCE.getAplicacion_FuentesRSS();

		/**
		 * The meta object literal for the '<em><b>Paginas Medias Accesibles</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APLICACION__PAGINAS_MEDIAS_ACCESIBLES = eINSTANCE.getAplicacion_PaginasMediasAccesibles();

		/**
		 * The meta object literal for the '{@link dataweb.impl.EntidadImpl <em>Entidad</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dataweb.impl.EntidadImpl
		 * @see dataweb.impl.DatawebPackageImpl#getEntidad()
		 * @generated
		 */
		EClass ENTIDAD = eINSTANCE.getEntidad();

		/**
		 * The meta object literal for the '<em><b>Nombre</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTIDAD__NOMBRE = eINSTANCE.getEntidad_Nombre();

		/**
		 * The meta object literal for the '<em><b>Table Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTIDAD__TABLE_NAME = eINSTANCE.getEntidad_TableName();

		/**
		 * The meta object literal for the '<em><b>Has CRUD</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTIDAD__HAS_CRUD = eINSTANCE.getEntidad_HasCRUD();

		/**
		 * The meta object literal for the '<em><b>Has Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTIDAD__HAS_INDEX = eINSTANCE.getEntidad_HasIndex();

		/**
		 * The meta object literal for the '<em><b>Has Extended Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTIDAD__HAS_EXTENDED_INDEX = eINSTANCE.getEntidad_HasExtendedIndex();

		/**
		 * The meta object literal for the '<em><b>Has Details</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTIDAD__HAS_DETAILS = eINSTANCE.getEntidad_HasDetails();

		/**
		 * The meta object literal for the '<em><b>Has Create</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTIDAD__HAS_CREATE = eINSTANCE.getEntidad_HasCreate();

		/**
		 * The meta object literal for the '<em><b>Has Update</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTIDAD__HAS_UPDATE = eINSTANCE.getEntidad_HasUpdate();

		/**
		 * The meta object literal for the '<em><b>Has Delete</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTIDAD__HAS_DELETE = eINSTANCE.getEntidad_HasDelete();

		/**
		 * The meta object literal for the '<em><b>Atributos</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTIDAD__ATRIBUTOS = eINSTANCE.getEntidad_Atributos();

		/**
		 * The meta object literal for the '<em><b>Referencias</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTIDAD__REFERENCIAS = eINSTANCE.getEntidad_Referencias();

		/**
		 * The meta object literal for the '{@link dataweb.impl.AtributoImpl <em>Atributo</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dataweb.impl.AtributoImpl
		 * @see dataweb.impl.DatawebPackageImpl#getAtributo()
		 * @generated
		 */
		EClass ATRIBUTO = eINSTANCE.getAtributo();

		/**
		 * The meta object literal for the '<em><b>Nombre</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATRIBUTO__NOMBRE = eINSTANCE.getAtributo_Nombre();

		/**
		 * The meta object literal for the '<em><b>Is Primary Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATRIBUTO__IS_PRIMARY_KEY = eINSTANCE.getAtributo_IsPrimaryKey();

		/**
		 * The meta object literal for the '<em><b>Tipo</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATRIBUTO__TIPO = eINSTANCE.getAtributo_Tipo();

		/**
		 * The meta object literal for the '{@link dataweb.impl.ReferenciaImpl <em>Referencia</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dataweb.impl.ReferenciaImpl
		 * @see dataweb.impl.DatawebPackageImpl#getReferencia()
		 * @generated
		 */
		EClass REFERENCIA = eINSTANCE.getReferencia();

		/**
		 * The meta object literal for the '<em><b>Nombre</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCIA__NOMBRE = eINSTANCE.getReferencia_Nombre();

		/**
		 * The meta object literal for the '<em><b>Multiplicidad</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCIA__MULTIPLICIDAD = eINSTANCE.getReferencia_Multiplicidad();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCIA__SOURCE = eINSTANCE.getReferencia_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCIA__TARGET = eINSTANCE.getReferencia_Target();

		/**
		 * The meta object literal for the '{@link dataweb.impl.PaginaImpl <em>Pagina</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dataweb.impl.PaginaImpl
		 * @see dataweb.impl.DatawebPackageImpl#getPagina()
		 * @generated
		 */
		EClass PAGINA = eINSTANCE.getPagina();

		/**
		 * The meta object literal for the '<em><b>Enlaces</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAGINA__ENLACES = eINSTANCE.getPagina_Enlaces();

		/**
		 * The meta object literal for the '<em><b>Redes Sociales</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAGINA__REDES_SOCIALES = eINSTANCE.getPagina_RedesSociales();

		/**
		 * The meta object literal for the '<em><b>Fuentes RSS</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAGINA__FUENTES_RSS = eINSTANCE.getPagina_FuentesRSS();

		/**
		 * The meta object literal for the '<em><b>Nombre</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAGINA__NOMBRE = eINSTANCE.getPagina_Nombre();

		/**
		 * The meta object literal for the '<em><b>Titulo</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAGINA__TITULO = eINSTANCE.getPagina_Titulo();

		/**
		 * The meta object literal for the '<em><b>Descripcion</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAGINA__DESCRIPCION = eINSTANCE.getPagina_Descripcion();

		/**
		 * The meta object literal for the '{@link dataweb.impl.PaginaHomeImpl <em>Pagina Home</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dataweb.impl.PaginaHomeImpl
		 * @see dataweb.impl.DatawebPackageImpl#getPaginaHome()
		 * @generated
		 */
		EClass PAGINA_HOME = eINSTANCE.getPaginaHome();

		/**
		 * The meta object literal for the '{@link dataweb.impl.PaginaContenidoImpl <em>Pagina Contenido</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dataweb.impl.PaginaContenidoImpl
		 * @see dataweb.impl.DatawebPackageImpl#getPaginaContenido()
		 * @generated
		 */
		EClass PAGINA_CONTENIDO = eINSTANCE.getPaginaContenido();

		/**
		 * The meta object literal for the '<em><b>Contenido</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAGINA_CONTENIDO__CONTENIDO = eINSTANCE.getPaginaContenido_Contenido();

		/**
		 * The meta object literal for the '{@link dataweb.impl.PaginaCRUDImpl <em>Pagina CRUD</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dataweb.impl.PaginaCRUDImpl
		 * @see dataweb.impl.DatawebPackageImpl#getPaginaCRUD()
		 * @generated
		 */
		EClass PAGINA_CRUD = eINSTANCE.getPaginaCRUD();

		/**
		 * The meta object literal for the '<em><b>Entidad</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAGINA_CRUD__ENTIDAD = eINSTANCE.getPaginaCRUD_Entidad();

		/**
		 * The meta object literal for the '{@link dataweb.impl.PaginaIndiceImpl <em>Pagina Indice</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dataweb.impl.PaginaIndiceImpl
		 * @see dataweb.impl.DatawebPackageImpl#getPaginaIndice()
		 * @generated
		 */
		EClass PAGINA_INDICE = eINSTANCE.getPaginaIndice();

		/**
		 * The meta object literal for the '<em><b>Atributos Mostrados</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAGINA_INDICE__ATRIBUTOS_MOSTRADOS = eINSTANCE.getPaginaIndice_AtributosMostrados();

		/**
		 * The meta object literal for the '{@link dataweb.impl.PaginaDetalleImpl <em>Pagina Detalle</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dataweb.impl.PaginaDetalleImpl
		 * @see dataweb.impl.DatawebPackageImpl#getPaginaDetalle()
		 * @generated
		 */
		EClass PAGINA_DETALLE = eINSTANCE.getPaginaDetalle();

		/**
		 * The meta object literal for the '{@link dataweb.impl.PaginaCreacionImpl <em>Pagina Creacion</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dataweb.impl.PaginaCreacionImpl
		 * @see dataweb.impl.DatawebPackageImpl#getPaginaCreacion()
		 * @generated
		 */
		EClass PAGINA_CREACION = eINSTANCE.getPaginaCreacion();

		/**
		 * The meta object literal for the '{@link dataweb.impl.PaginaActualizacionImpl <em>Pagina Actualizacion</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dataweb.impl.PaginaActualizacionImpl
		 * @see dataweb.impl.DatawebPackageImpl#getPaginaActualizacion()
		 * @generated
		 */
		EClass PAGINA_ACTUALIZACION = eINSTANCE.getPaginaActualizacion();

		/**
		 * The meta object literal for the '{@link dataweb.impl.PaginaBorradoImpl <em>Pagina Borrado</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dataweb.impl.PaginaBorradoImpl
		 * @see dataweb.impl.DatawebPackageImpl#getPaginaBorrado()
		 * @generated
		 */
		EClass PAGINA_BORRADO = eINSTANCE.getPaginaBorrado();

		/**
		 * The meta object literal for the '{@link dataweb.impl.PaginaIndiceDetalleImpl <em>Pagina Indice Detalle</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dataweb.impl.PaginaIndiceDetalleImpl
		 * @see dataweb.impl.DatawebPackageImpl#getPaginaIndiceDetalle()
		 * @generated
		 */
		EClass PAGINA_INDICE_DETALLE = eINSTANCE.getPaginaIndiceDetalle();

		/**
		 * The meta object literal for the '{@link dataweb.impl.EncuestaImpl <em>Encuesta</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dataweb.impl.EncuestaImpl
		 * @see dataweb.impl.DatawebPackageImpl#getEncuesta()
		 * @generated
		 */
		EClass ENCUESTA = eINSTANCE.getEncuesta();

		/**
		 * The meta object literal for the '<em><b>Preguntas</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENCUESTA__PREGUNTAS = eINSTANCE.getEncuesta_Preguntas();

		/**
		 * The meta object literal for the '<em><b>Nombre</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENCUESTA__NOMBRE = eINSTANCE.getEncuesta_Nombre();

		/**
		 * The meta object literal for the '<em><b>Descripcion</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENCUESTA__DESCRIPCION = eINSTANCE.getEncuesta_Descripcion();

		/**
		 * The meta object literal for the '<em><b>Tipo Representacion</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENCUESTA__TIPO_REPRESENTACION = eINSTANCE.getEncuesta_TipoRepresentacion();

		/**
		 * The meta object literal for the '<em><b>Titulo</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENCUESTA__TITULO = eINSTANCE.getEncuesta_Titulo();

		/**
		 * The meta object literal for the '<em><b>Numero Preg VF</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENCUESTA__NUMERO_PREG_VF = eINSTANCE.getEncuesta_NumeroPregVF();

		/**
		 * The meta object literal for the '<em><b>Numero Preg Select</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENCUESTA__NUMERO_PREG_SELECT = eINSTANCE.getEncuesta_NumeroPregSelect();

		/**
		 * The meta object literal for the '{@link dataweb.impl.CuestionarioImpl <em>Cuestionario</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dataweb.impl.CuestionarioImpl
		 * @see dataweb.impl.DatawebPackageImpl#getCuestionario()
		 * @generated
		 */
		EClass CUESTIONARIO = eINSTANCE.getCuestionario();

		/**
		 * The meta object literal for the '<em><b>Preguntas</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CUESTIONARIO__PREGUNTAS = eINSTANCE.getCuestionario_Preguntas();

		/**
		 * The meta object literal for the '<em><b>Nombre</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CUESTIONARIO__NOMBRE = eINSTANCE.getCuestionario_Nombre();

		/**
		 * The meta object literal for the '<em><b>Descripcion</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CUESTIONARIO__DESCRIPCION = eINSTANCE.getCuestionario_Descripcion();

		/**
		 * The meta object literal for the '<em><b>Titulo</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CUESTIONARIO__TITULO = eINSTANCE.getCuestionario_Titulo();

		/**
		 * The meta object literal for the '<em><b>Numero Preg VF</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CUESTIONARIO__NUMERO_PREG_VF = eINSTANCE.getCuestionario_NumeroPregVF();

		/**
		 * The meta object literal for the '<em><b>Numero Preg Select</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CUESTIONARIO__NUMERO_PREG_SELECT = eINSTANCE.getCuestionario_NumeroPregSelect();

		/**
		 * The meta object literal for the '{@link dataweb.impl.PreguntaImpl <em>Pregunta</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dataweb.impl.PreguntaImpl
		 * @see dataweb.impl.DatawebPackageImpl#getPregunta()
		 * @generated
		 */
		EClass PREGUNTA = eINSTANCE.getPregunta();

		/**
		 * The meta object literal for the '<em><b>Nombre</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREGUNTA__NOMBRE = eINSTANCE.getPregunta_Nombre();

		/**
		 * The meta object literal for the '<em><b>Texto</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREGUNTA__TEXTO = eINSTANCE.getPregunta_Texto();

		/**
		 * The meta object literal for the '{@link dataweb.impl.PreguntaOpcionMultipleImpl <em>Pregunta Opcion Multiple</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dataweb.impl.PreguntaOpcionMultipleImpl
		 * @see dataweb.impl.DatawebPackageImpl#getPreguntaOpcionMultiple()
		 * @generated
		 */
		EClass PREGUNTA_OPCION_MULTIPLE = eINSTANCE.getPreguntaOpcionMultiple();

		/**
		 * The meta object literal for the '<em><b>Opciones</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PREGUNTA_OPCION_MULTIPLE__OPCIONES = eINSTANCE.getPreguntaOpcionMultiple_Opciones();

		/**
		 * The meta object literal for the '<em><b>Respuesta Correcta</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PREGUNTA_OPCION_MULTIPLE__RESPUESTA_CORRECTA = eINSTANCE.getPreguntaOpcionMultiple_RespuestaCorrecta();

		/**
		 * The meta object literal for the '{@link dataweb.impl.OpcionRespuestaImpl <em>Opcion Respuesta</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dataweb.impl.OpcionRespuestaImpl
		 * @see dataweb.impl.DatawebPackageImpl#getOpcionRespuesta()
		 * @generated
		 */
		EClass OPCION_RESPUESTA = eINSTANCE.getOpcionRespuesta();

		/**
		 * The meta object literal for the '<em><b>Nombre</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPCION_RESPUESTA__NOMBRE = eINSTANCE.getOpcionRespuesta_Nombre();

		/**
		 * The meta object literal for the '<em><b>Texto</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPCION_RESPUESTA__TEXTO = eINSTANCE.getOpcionRespuesta_Texto();

		/**
		 * The meta object literal for the '<em><b>Valor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPCION_RESPUESTA__VALOR = eINSTANCE.getOpcionRespuesta_Valor();

		/**
		 * The meta object literal for the '{@link dataweb.impl.PreguntaVerdaderoFalsoImpl <em>Pregunta Verdadero Falso</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dataweb.impl.PreguntaVerdaderoFalsoImpl
		 * @see dataweb.impl.DatawebPackageImpl#getPreguntaVerdaderoFalso()
		 * @generated
		 */
		EClass PREGUNTA_VERDADERO_FALSO = eINSTANCE.getPreguntaVerdaderoFalso();

		/**
		 * The meta object literal for the '<em><b>Respuesta Correcta</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREGUNTA_VERDADERO_FALSO__RESPUESTA_CORRECTA = eINSTANCE.getPreguntaVerdaderoFalso_RespuestaCorrecta();

		/**
		 * The meta object literal for the '{@link dataweb.impl.PreguntaRespuestaCortaImpl <em>Pregunta Respuesta Corta</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dataweb.impl.PreguntaRespuestaCortaImpl
		 * @see dataweb.impl.DatawebPackageImpl#getPreguntaRespuestaCorta()
		 * @generated
		 */
		EClass PREGUNTA_RESPUESTA_CORTA = eINSTANCE.getPreguntaRespuestaCorta();

		/**
		 * The meta object literal for the '<em><b>Respuesta Corta</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREGUNTA_RESPUESTA_CORTA__RESPUESTA_CORTA = eINSTANCE.getPreguntaRespuestaCorta_RespuestaCorta();

		/**
		 * The meta object literal for the '{@link dataweb.impl.RedSocialImpl <em>Red Social</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dataweb.impl.RedSocialImpl
		 * @see dataweb.impl.DatawebPackageImpl#getRedSocial()
		 * @generated
		 */
		EClass RED_SOCIAL = eINSTANCE.getRedSocial();

		/**
		 * The meta object literal for the '<em><b>Tipo</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RED_SOCIAL__TIPO = eINSTANCE.getRedSocial_Tipo();

		/**
		 * The meta object literal for the '<em><b>Nombre</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RED_SOCIAL__NOMBRE = eINSTANCE.getRedSocial_Nombre();

		/**
		 * The meta object literal for the '<em><b>Codigo Embed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RED_SOCIAL__CODIGO_EMBED = eINSTANCE.getRedSocial_CodigoEmbed();

		/**
		 * The meta object literal for the '<em><b>Nombre Cuenta</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RED_SOCIAL__NOMBRE_CUENTA = eINSTANCE.getRedSocial_NombreCuenta();

		/**
		 * The meta object literal for the '{@link dataweb.impl.RolImpl <em>Rol</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dataweb.impl.RolImpl
		 * @see dataweb.impl.DatawebPackageImpl#getRol()
		 * @generated
		 */
		EClass ROL = eINSTANCE.getRol();

		/**
		 * The meta object literal for the '<em><b>Nombre</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROL__NOMBRE = eINSTANCE.getRol_Nombre();

		/**
		 * The meta object literal for the '<em><b>Descripcion</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROL__DESCRIPCION = eINSTANCE.getRol_Descripcion();

		/**
		 * The meta object literal for the '<em><b>Paginas Accesibles</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROL__PAGINAS_ACCESIBLES = eINSTANCE.getRol_PaginasAccesibles();

		/**
		 * The meta object literal for the '<em><b>Numero Entidades Accesibles</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROL__NUMERO_ENTIDADES_ACCESIBLES = eINSTANCE.getRol_NumeroEntidadesAccesibles();

		/**
		 * The meta object literal for the '{@link dataweb.impl.FuenteRSSImpl <em>Fuente RSS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dataweb.impl.FuenteRSSImpl
		 * @see dataweb.impl.DatawebPackageImpl#getFuenteRSS()
		 * @generated
		 */
		EClass FUENTE_RSS = eINSTANCE.getFuenteRSS();

		/**
		 * The meta object literal for the '<em><b>Nombre</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUENTE_RSS__NOMBRE = eINSTANCE.getFuenteRSS_Nombre();

		/**
		 * The meta object literal for the '<em><b>Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUENTE_RSS__URL = eINSTANCE.getFuenteRSS_Url();

		/**
		 * The meta object literal for the '<em><b>Titulo</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUENTE_RSS__TITULO = eINSTANCE.getFuenteRSS_Titulo();

		/**
		 * The meta object literal for the '<em><b>Num Items</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUENTE_RSS__NUM_ITEMS = eINSTANCE.getFuenteRSS_NumItems();

		/**
		 * The meta object literal for the '<em><b>Mostrar Descripcion</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUENTE_RSS__MOSTRAR_DESCRIPCION = eINSTANCE.getFuenteRSS_MostrarDescripcion();

		/**
		 * The meta object literal for the '{@link dataweb.impl.PaginaIndicePaginadaImpl <em>Pagina Indice Paginada</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dataweb.impl.PaginaIndicePaginadaImpl
		 * @see dataweb.impl.DatawebPackageImpl#getPaginaIndicePaginada()
		 * @generated
		 */
		EClass PAGINA_INDICE_PAGINADA = eINSTANCE.getPaginaIndicePaginada();

		/**
		 * The meta object literal for the '<em><b>Page Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAGINA_INDICE_PAGINADA__PAGE_SIZE = eINSTANCE.getPaginaIndicePaginada_PageSize();

		/**
		 * The meta object literal for the '{@link dataweb.impl.PaginaIndiceFiltrosImpl <em>Pagina Indice Filtros</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dataweb.impl.PaginaIndiceFiltrosImpl
		 * @see dataweb.impl.DatawebPackageImpl#getPaginaIndiceFiltros()
		 * @generated
		 */
		EClass PAGINA_INDICE_FILTROS = eINSTANCE.getPaginaIndiceFiltros();

		/**
		 * The meta object literal for the '<em><b>Atributos Filtro</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAGINA_INDICE_FILTROS__ATRIBUTOS_FILTRO = eINSTANCE.getPaginaIndiceFiltros_AtributosFiltro();

		/**
		 * The meta object literal for the '{@link dataweb.impl.PaginaIndicePaginadaFiltradaImpl <em>Pagina Indice Paginada Filtrada</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dataweb.impl.PaginaIndicePaginadaFiltradaImpl
		 * @see dataweb.impl.DatawebPackageImpl#getPaginaIndicePaginadaFiltrada()
		 * @generated
		 */
		EClass PAGINA_INDICE_PAGINADA_FILTRADA = eINSTANCE.getPaginaIndicePaginadaFiltrada();

		/**
		 * The meta object literal for the '<em><b>Page Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAGINA_INDICE_PAGINADA_FILTRADA__PAGE_SIZE = eINSTANCE.getPaginaIndicePaginadaFiltrada_PageSize();

		/**
		 * The meta object literal for the '<em><b>Atributos Filtro</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAGINA_INDICE_PAGINADA_FILTRADA__ATRIBUTOS_FILTRO = eINSTANCE.getPaginaIndicePaginadaFiltrada_AtributosFiltro();

		/**
		 * The meta object literal for the '{@link dataweb.TipoAtributo <em>Tipo Atributo</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dataweb.TipoAtributo
		 * @see dataweb.impl.DatawebPackageImpl#getTipoAtributo()
		 * @generated
		 */
		EEnum TIPO_ATRIBUTO = eINSTANCE.getTipoAtributo();

		/**
		 * The meta object literal for the '{@link dataweb.TipoRepresentacion <em>Tipo Representacion</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dataweb.TipoRepresentacion
		 * @see dataweb.impl.DatawebPackageImpl#getTipoRepresentacion()
		 * @generated
		 */
		EEnum TIPO_REPRESENTACION = eINSTANCE.getTipoRepresentacion();

		/**
		 * The meta object literal for the '{@link dataweb.TipoRedSocial <em>Tipo Red Social</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dataweb.TipoRedSocial
		 * @see dataweb.impl.DatawebPackageImpl#getTipoRedSocial()
		 * @generated
		 */
		EEnum TIPO_RED_SOCIAL = eINSTANCE.getTipoRedSocial();

	}

} //DatawebPackage
