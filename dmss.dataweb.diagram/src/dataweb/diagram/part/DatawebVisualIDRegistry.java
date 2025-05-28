/*
* 
*/
package dataweb.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.structure.DiagramStructure;

import dataweb.Aplicacion;
import dataweb.DatawebPackage;
import dataweb.diagram.edit.parts.AplicacionEditPart;
import dataweb.diagram.edit.parts.AtributoEditPart;
import dataweb.diagram.edit.parts.AtributoNombreEditPart;
import dataweb.diagram.edit.parts.CuestionarioCuestionarioPreguntasCompartmentEditPart;
import dataweb.diagram.edit.parts.CuestionarioEditPart;
import dataweb.diagram.edit.parts.CuestionarioNombreEditPart;
import dataweb.diagram.edit.parts.EncuestaEditPart;
import dataweb.diagram.edit.parts.EncuestaEncuestaPreguntasCompartmentEditPart;
import dataweb.diagram.edit.parts.EncuestaNombreEditPart;
import dataweb.diagram.edit.parts.EntidadEditPart;
import dataweb.diagram.edit.parts.EntidadEntidadAtributosCompartmentEditPart;
import dataweb.diagram.edit.parts.EntidadEntidadReferenciasCompartmentEditPart;
import dataweb.diagram.edit.parts.EntidadNombreEditPart;
import dataweb.diagram.edit.parts.FuenteRSSEditPart;
import dataweb.diagram.edit.parts.FuenteRSSNombreEditPart;
import dataweb.diagram.edit.parts.OpcionRespuestaEditPart;
import dataweb.diagram.edit.parts.OpcionRespuestaNombreEditPart;
import dataweb.diagram.edit.parts.PaginaActualizacionEditPart;
import dataweb.diagram.edit.parts.PaginaActualizacionNombreEditPart;
import dataweb.diagram.edit.parts.PaginaBorradoEditPart;
import dataweb.diagram.edit.parts.PaginaBorradoNombreEditPart;
import dataweb.diagram.edit.parts.PaginaCRUDEntidadEditPart;
import dataweb.diagram.edit.parts.PaginaContenidoEditPart;
import dataweb.diagram.edit.parts.PaginaContenidoNombreEditPart;
import dataweb.diagram.edit.parts.PaginaCreacionEditPart;
import dataweb.diagram.edit.parts.PaginaCreacionNombreEditPart;
import dataweb.diagram.edit.parts.PaginaDetalleEditPart;
import dataweb.diagram.edit.parts.PaginaDetalleNombreEditPart;
import dataweb.diagram.edit.parts.PaginaEnlacesEditPart;
import dataweb.diagram.edit.parts.PaginaFuentesRSSEditPart;
import dataweb.diagram.edit.parts.PaginaHomeEditPart;
import dataweb.diagram.edit.parts.PaginaHomeNombreEditPart;
import dataweb.diagram.edit.parts.PaginaIndiceAtributosMostradosEditPart;
import dataweb.diagram.edit.parts.PaginaIndiceDetalleEditPart;
import dataweb.diagram.edit.parts.PaginaIndiceDetalleNombreEditPart;
import dataweb.diagram.edit.parts.PaginaIndiceFiltrosAtributosFiltroEditPart;
import dataweb.diagram.edit.parts.PaginaIndiceFiltrosEditPart;
import dataweb.diagram.edit.parts.PaginaIndiceFiltrosNombreEditPart;
import dataweb.diagram.edit.parts.PaginaIndicePaginadaEditPart;
import dataweb.diagram.edit.parts.PaginaIndicePaginadaFiltradaAtributosFiltroEditPart;
import dataweb.diagram.edit.parts.PaginaIndicePaginadaFiltradaEditPart;
import dataweb.diagram.edit.parts.PaginaIndicePaginadaFiltradaNombreEditPart;
import dataweb.diagram.edit.parts.PaginaIndicePaginadaNombreEditPart;
import dataweb.diagram.edit.parts.PaginaRedesSocialesEditPart;
import dataweb.diagram.edit.parts.PreguntaOpcionMultiple2EditPart;
import dataweb.diagram.edit.parts.PreguntaOpcionMultipleEditPart;
import dataweb.diagram.edit.parts.PreguntaOpcionMultipleNombre2EditPart;
import dataweb.diagram.edit.parts.PreguntaOpcionMultipleNombreEditPart;
import dataweb.diagram.edit.parts.PreguntaOpcionMultiplePreguntaOpcionMultipleOpcionesCompartment2EditPart;
import dataweb.diagram.edit.parts.PreguntaOpcionMultiplePreguntaOpcionMultipleOpcionesCompartmentEditPart;
import dataweb.diagram.edit.parts.PreguntaOpcionMultipleRespuestaCorrectaEditPart;
import dataweb.diagram.edit.parts.PreguntaRespuestaCorta2EditPart;
import dataweb.diagram.edit.parts.PreguntaRespuestaCortaEditPart;
import dataweb.diagram.edit.parts.PreguntaRespuestaCortaNombre2EditPart;
import dataweb.diagram.edit.parts.PreguntaRespuestaCortaNombreEditPart;
import dataweb.diagram.edit.parts.PreguntaVerdaderoFalso2EditPart;
import dataweb.diagram.edit.parts.PreguntaVerdaderoFalsoEditPart;
import dataweb.diagram.edit.parts.PreguntaVerdaderoFalsoNombre2EditPart;
import dataweb.diagram.edit.parts.PreguntaVerdaderoFalsoNombreEditPart;
import dataweb.diagram.edit.parts.RedSocialEditPart;
import dataweb.diagram.edit.parts.RedSocialNombreEditPart;
import dataweb.diagram.edit.parts.ReferenciaEditPart;
import dataweb.diagram.edit.parts.ReferenciaNombreEditPart;
import dataweb.diagram.edit.parts.RolEditPart;
import dataweb.diagram.edit.parts.RolNombreEditPart;
import dataweb.diagram.edit.parts.RolPaginasAccesiblesEditPart;
import dataweb.diagram.edit.parts.WrappingLabel2EditPart;
import dataweb.diagram.edit.parts.WrappingLabel3EditPart;
import dataweb.diagram.edit.parts.WrappingLabel4EditPart;
import dataweb.diagram.edit.parts.WrappingLabel5EditPart;
import dataweb.diagram.edit.parts.WrappingLabel6EditPart;
import dataweb.diagram.edit.parts.WrappingLabel7EditPart;
import dataweb.diagram.edit.parts.WrappingLabel8EditPart;
import dataweb.diagram.edit.parts.WrappingLabel9EditPart;
import dataweb.diagram.edit.parts.WrappingLabelEditPart;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class DatawebVisualIDRegistry {

	/**
	* @generated
	*/
	private static final String DEBUG_KEY = "dmss.dataweb.diagram/debug/visualID"; //$NON-NLS-1$

	/**
	* @generated
	*/
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (AplicacionEditPart.MODEL_ID.equals(view.getType())) {
				return AplicacionEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return dataweb.diagram.part.DatawebVisualIDRegistry.getVisualID(view.getType());
	}

	/**
	* @generated
	*/
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while (view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (View) view.eContainer();
		}
		return diagram != null ? diagram.getType() : null;
	}

	/**
	* @generated
	*/
	public static int getVisualID(String type) {
		try {
			return Integer.parseInt(type);
		} catch (NumberFormatException e) {
			if (Boolean.TRUE.toString().equalsIgnoreCase(Platform.getDebugOption(DEBUG_KEY))) {
				DatawebDiagramEditorPlugin.getInstance()
						.logError("Unable to parse view type as a visualID number: " + type);
			}
		}
		return -1;
	}

	/**
	* @generated
	*/
	public static String getType(int visualID) {
		return Integer.toString(visualID);
	}

	/**
	* @generated
	*/
	public static int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (DatawebPackage.eINSTANCE.getAplicacion().isSuperTypeOf(domainElement.eClass())
				&& isDiagram((Aplicacion) domainElement)) {
			return AplicacionEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	* @generated
	*/
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		String containerModelID = dataweb.diagram.part.DatawebVisualIDRegistry.getModelID(containerView);
		if (!AplicacionEditPart.MODEL_ID.equals(containerModelID) && !"dataweb".equals(containerModelID)) { //$NON-NLS-1$
			return -1;
		}
		int containerVisualID;
		if (AplicacionEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = dataweb.diagram.part.DatawebVisualIDRegistry.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = AplicacionEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case AplicacionEditPart.VISUAL_ID:
			if (DatawebPackage.eINSTANCE.getPaginaIndiceDetalle().isSuperTypeOf(domainElement.eClass())) {
				return PaginaIndiceDetalleEditPart.VISUAL_ID;
			}
			if (DatawebPackage.eINSTANCE.getPaginaIndicePaginada().isSuperTypeOf(domainElement.eClass())) {
				return PaginaIndicePaginadaEditPart.VISUAL_ID;
			}
			if (DatawebPackage.eINSTANCE.getPaginaIndiceFiltros().isSuperTypeOf(domainElement.eClass())) {
				return PaginaIndiceFiltrosEditPart.VISUAL_ID;
			}
			if (DatawebPackage.eINSTANCE.getPaginaIndicePaginadaFiltrada().isSuperTypeOf(domainElement.eClass())) {
				return PaginaIndicePaginadaFiltradaEditPart.VISUAL_ID;
			}
			if (DatawebPackage.eINSTANCE.getPaginaDetalle().isSuperTypeOf(domainElement.eClass())) {
				return PaginaDetalleEditPart.VISUAL_ID;
			}
			if (DatawebPackage.eINSTANCE.getPaginaCreacion().isSuperTypeOf(domainElement.eClass())) {
				return PaginaCreacionEditPart.VISUAL_ID;
			}
			if (DatawebPackage.eINSTANCE.getPaginaActualizacion().isSuperTypeOf(domainElement.eClass())) {
				return PaginaActualizacionEditPart.VISUAL_ID;
			}
			if (DatawebPackage.eINSTANCE.getPaginaBorrado().isSuperTypeOf(domainElement.eClass())) {
				return PaginaBorradoEditPart.VISUAL_ID;
			}
			if (DatawebPackage.eINSTANCE.getPaginaHome().isSuperTypeOf(domainElement.eClass())) {
				return PaginaHomeEditPart.VISUAL_ID;
			}
			if (DatawebPackage.eINSTANCE.getPaginaContenido().isSuperTypeOf(domainElement.eClass())) {
				return PaginaContenidoEditPart.VISUAL_ID;
			}
			if (DatawebPackage.eINSTANCE.getEntidad().isSuperTypeOf(domainElement.eClass())) {
				return EntidadEditPart.VISUAL_ID;
			}
			if (DatawebPackage.eINSTANCE.getRol().isSuperTypeOf(domainElement.eClass())) {
				return RolEditPart.VISUAL_ID;
			}
			if (DatawebPackage.eINSTANCE.getCuestionario().isSuperTypeOf(domainElement.eClass())) {
				return CuestionarioEditPart.VISUAL_ID;
			}
			if (DatawebPackage.eINSTANCE.getEncuesta().isSuperTypeOf(domainElement.eClass())) {
				return EncuestaEditPart.VISUAL_ID;
			}
			if (DatawebPackage.eINSTANCE.getRedSocial().isSuperTypeOf(domainElement.eClass())) {
				return RedSocialEditPart.VISUAL_ID;
			}
			if (DatawebPackage.eINSTANCE.getFuenteRSS().isSuperTypeOf(domainElement.eClass())) {
				return FuenteRSSEditPart.VISUAL_ID;
			}
			break;
		case EntidadEntidadAtributosCompartmentEditPart.VISUAL_ID:
			if (DatawebPackage.eINSTANCE.getAtributo().isSuperTypeOf(domainElement.eClass())) {
				return AtributoEditPart.VISUAL_ID;
			}
			break;
		case CuestionarioCuestionarioPreguntasCompartmentEditPart.VISUAL_ID:
			if (DatawebPackage.eINSTANCE.getPreguntaOpcionMultiple().isSuperTypeOf(domainElement.eClass())) {
				return PreguntaOpcionMultipleEditPart.VISUAL_ID;
			}
			if (DatawebPackage.eINSTANCE.getPreguntaVerdaderoFalso().isSuperTypeOf(domainElement.eClass())) {
				return PreguntaVerdaderoFalsoEditPart.VISUAL_ID;
			}
			if (DatawebPackage.eINSTANCE.getPreguntaRespuestaCorta().isSuperTypeOf(domainElement.eClass())) {
				return PreguntaRespuestaCortaEditPart.VISUAL_ID;
			}
			break;
		case PreguntaOpcionMultiplePreguntaOpcionMultipleOpcionesCompartmentEditPart.VISUAL_ID:
			if (DatawebPackage.eINSTANCE.getOpcionRespuesta().isSuperTypeOf(domainElement.eClass())) {
				return OpcionRespuestaEditPart.VISUAL_ID;
			}
			break;
		case EncuestaEncuestaPreguntasCompartmentEditPart.VISUAL_ID:
			if (DatawebPackage.eINSTANCE.getPreguntaOpcionMultiple().isSuperTypeOf(domainElement.eClass())) {
				return PreguntaOpcionMultiple2EditPart.VISUAL_ID;
			}
			if (DatawebPackage.eINSTANCE.getPreguntaVerdaderoFalso().isSuperTypeOf(domainElement.eClass())) {
				return PreguntaVerdaderoFalso2EditPart.VISUAL_ID;
			}
			if (DatawebPackage.eINSTANCE.getPreguntaRespuestaCorta().isSuperTypeOf(domainElement.eClass())) {
				return PreguntaRespuestaCorta2EditPart.VISUAL_ID;
			}
			break;
		case PreguntaOpcionMultiplePreguntaOpcionMultipleOpcionesCompartment2EditPart.VISUAL_ID:
			if (DatawebPackage.eINSTANCE.getOpcionRespuesta().isSuperTypeOf(domainElement.eClass())) {
				return OpcionRespuestaEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	* @generated
	*/
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = dataweb.diagram.part.DatawebVisualIDRegistry.getModelID(containerView);
		if (!AplicacionEditPart.MODEL_ID.equals(containerModelID) && !"dataweb".equals(containerModelID)) { //$NON-NLS-1$
			return false;
		}
		int containerVisualID;
		if (AplicacionEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = dataweb.diagram.part.DatawebVisualIDRegistry.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = AplicacionEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case AplicacionEditPart.VISUAL_ID:
			if (PaginaIndiceDetalleEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PaginaIndicePaginadaEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PaginaIndiceFiltrosEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PaginaIndicePaginadaFiltradaEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PaginaDetalleEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PaginaCreacionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PaginaActualizacionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PaginaBorradoEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PaginaHomeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PaginaContenidoEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EntidadEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RolEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CuestionarioEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EncuestaEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RedSocialEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FuenteRSSEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PaginaIndiceDetalleEditPart.VISUAL_ID:
			if (PaginaIndiceDetalleNombreEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PaginaIndicePaginadaEditPart.VISUAL_ID:
			if (PaginaIndicePaginadaNombreEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PaginaIndiceFiltrosEditPart.VISUAL_ID:
			if (PaginaIndiceFiltrosNombreEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PaginaIndicePaginadaFiltradaEditPart.VISUAL_ID:
			if (PaginaIndicePaginadaFiltradaNombreEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PaginaDetalleEditPart.VISUAL_ID:
			if (PaginaDetalleNombreEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PaginaCreacionEditPart.VISUAL_ID:
			if (PaginaCreacionNombreEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PaginaActualizacionEditPart.VISUAL_ID:
			if (PaginaActualizacionNombreEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PaginaBorradoEditPart.VISUAL_ID:
			if (PaginaBorradoNombreEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PaginaHomeEditPart.VISUAL_ID:
			if (PaginaHomeNombreEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PaginaContenidoEditPart.VISUAL_ID:
			if (PaginaContenidoNombreEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EntidadEditPart.VISUAL_ID:
			if (EntidadNombreEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EntidadEntidadAtributosCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EntidadEntidadReferenciasCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RolEditPart.VISUAL_ID:
			if (RolNombreEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CuestionarioEditPart.VISUAL_ID:
			if (CuestionarioNombreEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CuestionarioCuestionarioPreguntasCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EncuestaEditPart.VISUAL_ID:
			if (EncuestaNombreEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EncuestaEncuestaPreguntasCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RedSocialEditPart.VISUAL_ID:
			if (RedSocialNombreEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case FuenteRSSEditPart.VISUAL_ID:
			if (FuenteRSSNombreEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AtributoEditPart.VISUAL_ID:
			if (AtributoNombreEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PreguntaOpcionMultipleEditPart.VISUAL_ID:
			if (PreguntaOpcionMultipleNombreEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PreguntaOpcionMultiplePreguntaOpcionMultipleOpcionesCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case OpcionRespuestaEditPart.VISUAL_ID:
			if (OpcionRespuestaNombreEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PreguntaVerdaderoFalsoEditPart.VISUAL_ID:
			if (PreguntaVerdaderoFalsoNombreEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PreguntaRespuestaCortaEditPart.VISUAL_ID:
			if (PreguntaRespuestaCortaNombreEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PreguntaOpcionMultiple2EditPart.VISUAL_ID:
			if (PreguntaOpcionMultipleNombre2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PreguntaOpcionMultiplePreguntaOpcionMultipleOpcionesCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PreguntaVerdaderoFalso2EditPart.VISUAL_ID:
			if (PreguntaVerdaderoFalsoNombre2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PreguntaRespuestaCorta2EditPart.VISUAL_ID:
			if (PreguntaRespuestaCortaNombre2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EntidadEntidadAtributosCompartmentEditPart.VISUAL_ID:
			if (AtributoEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CuestionarioCuestionarioPreguntasCompartmentEditPart.VISUAL_ID:
			if (PreguntaOpcionMultipleEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PreguntaVerdaderoFalsoEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PreguntaRespuestaCortaEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PreguntaOpcionMultiplePreguntaOpcionMultipleOpcionesCompartmentEditPart.VISUAL_ID:
			if (OpcionRespuestaEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EncuestaEncuestaPreguntasCompartmentEditPart.VISUAL_ID:
			if (PreguntaOpcionMultiple2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PreguntaVerdaderoFalso2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PreguntaRespuestaCorta2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PreguntaOpcionMultiplePreguntaOpcionMultipleOpcionesCompartment2EditPart.VISUAL_ID:
			if (OpcionRespuestaEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ReferenciaEditPart.VISUAL_ID:
			if (ReferenciaNombreEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PaginaEnlacesEditPart.VISUAL_ID:
			if (WrappingLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PaginaRedesSocialesEditPart.VISUAL_ID:
			if (WrappingLabel2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PaginaFuentesRSSEditPart.VISUAL_ID:
			if (WrappingLabel3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PaginaCRUDEntidadEditPart.VISUAL_ID:
			if (WrappingLabel4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PaginaIndiceAtributosMostradosEditPart.VISUAL_ID:
			if (WrappingLabel5EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PreguntaOpcionMultipleRespuestaCorrectaEditPart.VISUAL_ID:
			if (WrappingLabel6EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RolPaginasAccesiblesEditPart.VISUAL_ID:
			if (WrappingLabel7EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PaginaIndiceFiltrosAtributosFiltroEditPart.VISUAL_ID:
			if (WrappingLabel8EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PaginaIndicePaginadaFiltradaAtributosFiltroEditPart.VISUAL_ID:
			if (WrappingLabel9EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		}
		return false;
	}

	/**
	* @generated
	*/
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (DatawebPackage.eINSTANCE.getReferencia().isSuperTypeOf(domainElement.eClass())) {
			return ReferenciaEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	* User can change implementation of this method to handle some specific
	* situations not covered by default logic.
	* 
	* @generated
	*/
	private static boolean isDiagram(Aplicacion element) {
		return true;
	}

	/**
	* @generated
	*/
	public static boolean checkNodeVisualID(View containerView, EObject domainElement, int candidate) {
		if (candidate == -1) {
			//unrecognized id is always bad
			return false;
		}
		int basic = getNodeVisualID(containerView, domainElement);
		return basic == candidate;
	}

	/**
	* @generated
	*/
	public static boolean isCompartmentVisualID(int visualID) {
		switch (visualID) {
		case EntidadEntidadAtributosCompartmentEditPart.VISUAL_ID:
		case EntidadEntidadReferenciasCompartmentEditPart.VISUAL_ID:
		case CuestionarioCuestionarioPreguntasCompartmentEditPart.VISUAL_ID:
		case PreguntaOpcionMultiplePreguntaOpcionMultipleOpcionesCompartmentEditPart.VISUAL_ID:
		case EncuestaEncuestaPreguntasCompartmentEditPart.VISUAL_ID:
		case PreguntaOpcionMultiplePreguntaOpcionMultipleOpcionesCompartment2EditPart.VISUAL_ID:
			return true;
		default:
			break;
		}
		return false;
	}

	/**
	* @generated
	*/
	public static boolean isSemanticLeafVisualID(int visualID) {
		switch (visualID) {
		case AplicacionEditPart.VISUAL_ID:
			return false;
		case PaginaIndiceDetalleEditPart.VISUAL_ID:
		case PaginaIndicePaginadaEditPart.VISUAL_ID:
		case PaginaIndiceFiltrosEditPart.VISUAL_ID:
		case PaginaIndicePaginadaFiltradaEditPart.VISUAL_ID:
		case PaginaDetalleEditPart.VISUAL_ID:
		case PaginaCreacionEditPart.VISUAL_ID:
		case PaginaActualizacionEditPart.VISUAL_ID:
		case PaginaBorradoEditPart.VISUAL_ID:
		case PaginaHomeEditPart.VISUAL_ID:
		case PaginaContenidoEditPart.VISUAL_ID:
		case RolEditPart.VISUAL_ID:
		case RedSocialEditPart.VISUAL_ID:
		case FuenteRSSEditPart.VISUAL_ID:
		case AtributoEditPart.VISUAL_ID:
		case OpcionRespuestaEditPart.VISUAL_ID:
		case PreguntaVerdaderoFalsoEditPart.VISUAL_ID:
		case PreguntaRespuestaCortaEditPart.VISUAL_ID:
		case PreguntaVerdaderoFalso2EditPart.VISUAL_ID:
		case PreguntaRespuestaCorta2EditPart.VISUAL_ID:
			return true;
		default:
			break;
		}
		return false;
	}

	/**
	* @generated
	*/
	public static final DiagramStructure TYPED_INSTANCE = new DiagramStructure() {
		/**
		* @generated
		*/
		@Override

		public int getVisualID(View view) {
			return dataweb.diagram.part.DatawebVisualIDRegistry.getVisualID(view);
		}

		/**
		* @generated
		*/
		@Override

		public String getModelID(View view) {
			return dataweb.diagram.part.DatawebVisualIDRegistry.getModelID(view);
		}

		/**
		* @generated
		*/
		@Override

		public int getNodeVisualID(View containerView, EObject domainElement) {
			return dataweb.diagram.part.DatawebVisualIDRegistry.getNodeVisualID(containerView, domainElement);
		}

		/**
		* @generated
		*/
		@Override

		public boolean checkNodeVisualID(View containerView, EObject domainElement, int candidate) {
			return dataweb.diagram.part.DatawebVisualIDRegistry.checkNodeVisualID(containerView, domainElement,
					candidate);
		}

		/**
		* @generated
		*/
		@Override

		public boolean isCompartmentVisualID(int visualID) {
			return dataweb.diagram.part.DatawebVisualIDRegistry.isCompartmentVisualID(visualID);
		}

		/**
		* @generated
		*/
		@Override

		public boolean isSemanticLeafVisualID(int visualID) {
			return dataweb.diagram.part.DatawebVisualIDRegistry.isSemanticLeafVisualID(visualID);
		}
	};

}
