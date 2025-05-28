/**
 */
package dataweb.util;

import dataweb.*;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see dataweb.DatawebPackage
 * @generated
 */
public class DatawebValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final DatawebValidator INSTANCE = new DatawebValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "dataweb";

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DatawebValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return DatawebPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case DatawebPackage.APLICACION:
				return validateAplicacion((Aplicacion)value, diagnostics, context);
			case DatawebPackage.ENTIDAD:
				return validateEntidad((Entidad)value, diagnostics, context);
			case DatawebPackage.ATRIBUTO:
				return validateAtributo((Atributo)value, diagnostics, context);
			case DatawebPackage.REFERENCIA:
				return validateReferencia((Referencia)value, diagnostics, context);
			case DatawebPackage.PAGINA:
				return validatePagina((Pagina)value, diagnostics, context);
			case DatawebPackage.PAGINA_HOME:
				return validatePaginaHome((PaginaHome)value, diagnostics, context);
			case DatawebPackage.PAGINA_CONTENIDO:
				return validatePaginaContenido((PaginaContenido)value, diagnostics, context);
			case DatawebPackage.PAGINA_CRUD:
				return validatePaginaCRUD((PaginaCRUD)value, diagnostics, context);
			case DatawebPackage.PAGINA_INDICE:
				return validatePaginaIndice((PaginaIndice)value, diagnostics, context);
			case DatawebPackage.PAGINA_DETALLE:
				return validatePaginaDetalle((PaginaDetalle)value, diagnostics, context);
			case DatawebPackage.PAGINA_CREACION:
				return validatePaginaCreacion((PaginaCreacion)value, diagnostics, context);
			case DatawebPackage.PAGINA_ACTUALIZACION:
				return validatePaginaActualizacion((PaginaActualizacion)value, diagnostics, context);
			case DatawebPackage.PAGINA_BORRADO:
				return validatePaginaBorrado((PaginaBorrado)value, diagnostics, context);
			case DatawebPackage.PAGINA_INDICE_DETALLE:
				return validatePaginaIndiceDetalle((PaginaIndiceDetalle)value, diagnostics, context);
			case DatawebPackage.ENCUESTA:
				return validateEncuesta((Encuesta)value, diagnostics, context);
			case DatawebPackage.CUESTIONARIO:
				return validateCuestionario((Cuestionario)value, diagnostics, context);
			case DatawebPackage.PREGUNTA:
				return validatePregunta((Pregunta)value, diagnostics, context);
			case DatawebPackage.PREGUNTA_OPCION_MULTIPLE:
				return validatePreguntaOpcionMultiple((PreguntaOpcionMultiple)value, diagnostics, context);
			case DatawebPackage.OPCION_RESPUESTA:
				return validateOpcionRespuesta((OpcionRespuesta)value, diagnostics, context);
			case DatawebPackage.PREGUNTA_VERDADERO_FALSO:
				return validatePreguntaVerdaderoFalso((PreguntaVerdaderoFalso)value, diagnostics, context);
			case DatawebPackage.PREGUNTA_RESPUESTA_CORTA:
				return validatePreguntaRespuestaCorta((PreguntaRespuestaCorta)value, diagnostics, context);
			case DatawebPackage.RED_SOCIAL:
				return validateRedSocial((RedSocial)value, diagnostics, context);
			case DatawebPackage.ROL:
				return validateRol((Rol)value, diagnostics, context);
			case DatawebPackage.FUENTE_RSS:
				return validateFuenteRSS((FuenteRSS)value, diagnostics, context);
			case DatawebPackage.PAGINA_INDICE_PAGINADA:
				return validatePaginaIndicePaginada((PaginaIndicePaginada)value, diagnostics, context);
			case DatawebPackage.PAGINA_INDICE_FILTROS:
				return validatePaginaIndiceFiltros((PaginaIndiceFiltros)value, diagnostics, context);
			case DatawebPackage.PAGINA_INDICE_PAGINADA_FILTRADA:
				return validatePaginaIndicePaginadaFiltrada((PaginaIndicePaginadaFiltrada)value, diagnostics, context);
			case DatawebPackage.TIPO_ATRIBUTO:
				return validateTipoAtributo((TipoAtributo)value, diagnostics, context);
			case DatawebPackage.TIPO_REPRESENTACION:
				return validateTipoRepresentacion((TipoRepresentacion)value, diagnostics, context);
			case DatawebPackage.TIPO_RED_SOCIAL:
				return validateTipoRedSocial((TipoRedSocial)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAplicacion(Aplicacion aplicacion, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(aplicacion, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(aplicacion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(aplicacion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(aplicacion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(aplicacion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(aplicacion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(aplicacion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(aplicacion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(aplicacion, diagnostics, context);
		if (result || diagnostics != null) result &= validateAplicacion_R01_una_sola_pagina_home(aplicacion, diagnostics, context);
		if (result || diagnostics != null) result &= validateAplicacion_R04_al_menos_una_red_social_y_rss(aplicacion, diagnostics, context);
		if (result || diagnostics != null) result &= validateAplicacion_R06b_al_menos_una_encuesta_y_cuestionario(aplicacion, diagnostics, context);
		return result;
	}

	/**
	 * Validates the R01_una_sola_pagina_home constraint of '<em>Aplicacion</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAplicacion_R01_una_sola_pagina_home(Aplicacion aplicacion, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "R01_una_sola_pagina_home", getObjectLabel(aplicacion, context) },
						 new Object[] { aplicacion },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the R04_al_menos_una_red_social_y_rss constraint of '<em>Aplicacion</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAplicacion_R04_al_menos_una_red_social_y_rss(Aplicacion aplicacion, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "R04_al_menos_una_red_social_y_rss", getObjectLabel(aplicacion, context) },
						 new Object[] { aplicacion },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the R06b_al_menos_una_encuesta_y_cuestionario constraint of '<em>Aplicacion</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAplicacion_R06b_al_menos_una_encuesta_y_cuestionario(Aplicacion aplicacion, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "R06b_al_menos_una_encuesta_y_cuestionario", getObjectLabel(aplicacion, context) },
						 new Object[] { aplicacion },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEntidad(Entidad entidad, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(entidad, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(entidad, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(entidad, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(entidad, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(entidad, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(entidad, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(entidad, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(entidad, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(entidad, diagnostics, context);
		if (result || diagnostics != null) result &= validateEntidad_R02_crud_incompatible(entidad, diagnostics, context);
		if (result || diagnostics != null) result &= validateEntidad_R03_indice_requiere_detalle(entidad, diagnostics, context);
		if (result || diagnostics != null) result &= validateEntidad_R05_no_autorreferencia(entidad, diagnostics, context);
		if (result || diagnostics != null) result &= validateEntidad_R06_no_referencia_circular(entidad, diagnostics, context);
		if (result || diagnostics != null) result &= validateEntidad_R08_solo_una_pagina_indice(entidad, diagnostics, context);
		if (result || diagnostics != null) result &= validateEntidad_R09_atributos_pertenecen_entidad(entidad, diagnostics, context);
		return result;
	}

	/**
	 * Validates the R02_crud_incompatible constraint of '<em>Entidad</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEntidad_R02_crud_incompatible(Entidad entidad, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "R02_crud_incompatible", getObjectLabel(entidad, context) },
						 new Object[] { entidad },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the R03_indice_requiere_detalle constraint of '<em>Entidad</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEntidad_R03_indice_requiere_detalle(Entidad entidad, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "R03_indice_requiere_detalle", getObjectLabel(entidad, context) },
						 new Object[] { entidad },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the R05_no_autorreferencia constraint of '<em>Entidad</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEntidad_R05_no_autorreferencia(Entidad entidad, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "R05_no_autorreferencia", getObjectLabel(entidad, context) },
						 new Object[] { entidad },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the R06_no_referencia_circular constraint of '<em>Entidad</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEntidad_R06_no_referencia_circular(Entidad entidad, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "R06_no_referencia_circular", getObjectLabel(entidad, context) },
						 new Object[] { entidad },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the R08_solo_una_pagina_indice constraint of '<em>Entidad</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEntidad_R08_solo_una_pagina_indice(Entidad entidad, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "R08_solo_una_pagina_indice", getObjectLabel(entidad, context) },
						 new Object[] { entidad },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the R09_atributos_pertenecen_entidad constraint of '<em>Entidad</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEntidad_R09_atributos_pertenecen_entidad(Entidad entidad, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "R09_atributos_pertenecen_entidad", getObjectLabel(entidad, context) },
						 new Object[] { entidad },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAtributo(Atributo atributo, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(atributo, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReferencia(Referencia referencia, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(referencia, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePagina(Pagina pagina, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(pagina, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePaginaHome(PaginaHome paginaHome, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(paginaHome, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePaginaContenido(PaginaContenido paginaContenido, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(paginaContenido, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePaginaCRUD(PaginaCRUD paginaCRUD, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(paginaCRUD, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePaginaIndice(PaginaIndice paginaIndice, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(paginaIndice, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePaginaDetalle(PaginaDetalle paginaDetalle, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(paginaDetalle, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePaginaCreacion(PaginaCreacion paginaCreacion, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(paginaCreacion, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePaginaActualizacion(PaginaActualizacion paginaActualizacion, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(paginaActualizacion, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePaginaBorrado(PaginaBorrado paginaBorrado, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(paginaBorrado, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePaginaIndiceDetalle(PaginaIndiceDetalle paginaIndiceDetalle, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(paginaIndiceDetalle, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEncuesta(Encuesta encuesta, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(encuesta, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCuestionario(Cuestionario cuestionario, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(cuestionario, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(cuestionario, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(cuestionario, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(cuestionario, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(cuestionario, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(cuestionario, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(cuestionario, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(cuestionario, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(cuestionario, diagnostics, context);
		if (result || diagnostics != null) result &= validateCuestionario_R07_cuestionarios_con_respuesta(cuestionario, diagnostics, context);
		return result;
	}

	/**
	 * Validates the R07_cuestionarios_con_respuesta constraint of '<em>Cuestionario</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCuestionario_R07_cuestionarios_con_respuesta(Cuestionario cuestionario, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "R07_cuestionarios_con_respuesta", getObjectLabel(cuestionario, context) },
						 new Object[] { cuestionario },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePregunta(Pregunta pregunta, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(pregunta, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePreguntaOpcionMultiple(PreguntaOpcionMultiple preguntaOpcionMultiple, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(preguntaOpcionMultiple, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOpcionRespuesta(OpcionRespuesta opcionRespuesta, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(opcionRespuesta, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePreguntaVerdaderoFalso(PreguntaVerdaderoFalso preguntaVerdaderoFalso, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(preguntaVerdaderoFalso, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePreguntaRespuestaCorta(PreguntaRespuestaCorta preguntaRespuestaCorta, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(preguntaRespuestaCorta, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRedSocial(RedSocial redSocial, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(redSocial, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRol(Rol rol, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(rol, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFuenteRSS(FuenteRSS fuenteRSS, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(fuenteRSS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePaginaIndicePaginada(PaginaIndicePaginada paginaIndicePaginada, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(paginaIndicePaginada, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePaginaIndiceFiltros(PaginaIndiceFiltros paginaIndiceFiltros, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(paginaIndiceFiltros, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePaginaIndicePaginadaFiltrada(PaginaIndicePaginadaFiltrada paginaIndicePaginadaFiltrada, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(paginaIndicePaginadaFiltrada, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTipoAtributo(TipoAtributo tipoAtributo, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTipoRepresentacion(TipoRepresentacion tipoRepresentacion, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTipoRedSocial(TipoRedSocial tipoRedSocial, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //DatawebValidator
