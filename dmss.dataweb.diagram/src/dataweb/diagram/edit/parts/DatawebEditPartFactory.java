/*
 * 
 */
package dataweb.diagram.edit.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.directedit.locator.CellEditorLocatorAccess;

import dataweb.diagram.part.DatawebVisualIDRegistry;

/**
 * @generated
 */
public class DatawebEditPartFactory implements EditPartFactory {

	/**
	* @generated
	*/
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (DatawebVisualIDRegistry.getVisualID(view)) {

			case AplicacionEditPart.VISUAL_ID:
				return new AplicacionEditPart(view);

			case PaginaIndiceDetalleEditPart.VISUAL_ID:
				return new PaginaIndiceDetalleEditPart(view);

			case PaginaIndiceDetalleNombreEditPart.VISUAL_ID:
				return new PaginaIndiceDetalleNombreEditPart(view);

			case PaginaIndicePaginadaEditPart.VISUAL_ID:
				return new PaginaIndicePaginadaEditPart(view);

			case PaginaIndicePaginadaNombreEditPart.VISUAL_ID:
				return new PaginaIndicePaginadaNombreEditPart(view);

			case PaginaIndiceFiltrosEditPart.VISUAL_ID:
				return new PaginaIndiceFiltrosEditPart(view);

			case PaginaIndiceFiltrosNombreEditPart.VISUAL_ID:
				return new PaginaIndiceFiltrosNombreEditPart(view);

			case PaginaIndicePaginadaFiltradaEditPart.VISUAL_ID:
				return new PaginaIndicePaginadaFiltradaEditPart(view);

			case PaginaIndicePaginadaFiltradaNombreEditPart.VISUAL_ID:
				return new PaginaIndicePaginadaFiltradaNombreEditPart(view);

			case PaginaDetalleEditPart.VISUAL_ID:
				return new PaginaDetalleEditPart(view);

			case PaginaDetalleNombreEditPart.VISUAL_ID:
				return new PaginaDetalleNombreEditPart(view);

			case PaginaCreacionEditPart.VISUAL_ID:
				return new PaginaCreacionEditPart(view);

			case PaginaCreacionNombreEditPart.VISUAL_ID:
				return new PaginaCreacionNombreEditPart(view);

			case PaginaActualizacionEditPart.VISUAL_ID:
				return new PaginaActualizacionEditPart(view);

			case PaginaActualizacionNombreEditPart.VISUAL_ID:
				return new PaginaActualizacionNombreEditPart(view);

			case PaginaBorradoEditPart.VISUAL_ID:
				return new PaginaBorradoEditPart(view);

			case PaginaBorradoNombreEditPart.VISUAL_ID:
				return new PaginaBorradoNombreEditPart(view);

			case PaginaHomeEditPart.VISUAL_ID:
				return new PaginaHomeEditPart(view);

			case PaginaHomeNombreEditPart.VISUAL_ID:
				return new PaginaHomeNombreEditPart(view);

			case PaginaContenidoEditPart.VISUAL_ID:
				return new PaginaContenidoEditPart(view);

			case PaginaContenidoNombreEditPart.VISUAL_ID:
				return new PaginaContenidoNombreEditPart(view);

			case EntidadEditPart.VISUAL_ID:
				return new EntidadEditPart(view);

			case EntidadNombreEditPart.VISUAL_ID:
				return new EntidadNombreEditPart(view);

			case RolEditPart.VISUAL_ID:
				return new RolEditPart(view);

			case RolNombreEditPart.VISUAL_ID:
				return new RolNombreEditPart(view);

			case CuestionarioEditPart.VISUAL_ID:
				return new CuestionarioEditPart(view);

			case CuestionarioNombreEditPart.VISUAL_ID:
				return new CuestionarioNombreEditPart(view);

			case EncuestaEditPart.VISUAL_ID:
				return new EncuestaEditPart(view);

			case EncuestaNombreEditPart.VISUAL_ID:
				return new EncuestaNombreEditPart(view);

			case RedSocialEditPart.VISUAL_ID:
				return new RedSocialEditPart(view);

			case RedSocialNombreEditPart.VISUAL_ID:
				return new RedSocialNombreEditPart(view);

			case FuenteRSSEditPart.VISUAL_ID:
				return new FuenteRSSEditPart(view);

			case FuenteRSSNombreEditPart.VISUAL_ID:
				return new FuenteRSSNombreEditPart(view);

			case AtributoEditPart.VISUAL_ID:
				return new AtributoEditPart(view);

			case AtributoNombreEditPart.VISUAL_ID:
				return new AtributoNombreEditPart(view);

			case PreguntaOpcionMultipleEditPart.VISUAL_ID:
				return new PreguntaOpcionMultipleEditPart(view);

			case PreguntaOpcionMultipleNombreEditPart.VISUAL_ID:
				return new PreguntaOpcionMultipleNombreEditPart(view);

			case OpcionRespuestaEditPart.VISUAL_ID:
				return new OpcionRespuestaEditPart(view);

			case OpcionRespuestaNombreEditPart.VISUAL_ID:
				return new OpcionRespuestaNombreEditPart(view);

			case PreguntaVerdaderoFalsoEditPart.VISUAL_ID:
				return new PreguntaVerdaderoFalsoEditPart(view);

			case PreguntaVerdaderoFalsoNombreEditPart.VISUAL_ID:
				return new PreguntaVerdaderoFalsoNombreEditPart(view);

			case PreguntaRespuestaCortaEditPart.VISUAL_ID:
				return new PreguntaRespuestaCortaEditPart(view);

			case PreguntaRespuestaCortaNombreEditPart.VISUAL_ID:
				return new PreguntaRespuestaCortaNombreEditPart(view);

			case PreguntaOpcionMultiple2EditPart.VISUAL_ID:
				return new PreguntaOpcionMultiple2EditPart(view);

			case PreguntaOpcionMultipleNombre2EditPart.VISUAL_ID:
				return new PreguntaOpcionMultipleNombre2EditPart(view);

			case PreguntaVerdaderoFalso2EditPart.VISUAL_ID:
				return new PreguntaVerdaderoFalso2EditPart(view);

			case PreguntaVerdaderoFalsoNombre2EditPart.VISUAL_ID:
				return new PreguntaVerdaderoFalsoNombre2EditPart(view);

			case PreguntaRespuestaCorta2EditPart.VISUAL_ID:
				return new PreguntaRespuestaCorta2EditPart(view);

			case PreguntaRespuestaCortaNombre2EditPart.VISUAL_ID:
				return new PreguntaRespuestaCortaNombre2EditPart(view);

			case EntidadEntidadAtributosCompartmentEditPart.VISUAL_ID:
				return new EntidadEntidadAtributosCompartmentEditPart(view);

			case EntidadEntidadReferenciasCompartmentEditPart.VISUAL_ID:
				return new EntidadEntidadReferenciasCompartmentEditPart(view);

			case CuestionarioCuestionarioPreguntasCompartmentEditPart.VISUAL_ID:
				return new CuestionarioCuestionarioPreguntasCompartmentEditPart(view);

			case PreguntaOpcionMultiplePreguntaOpcionMultipleOpcionesCompartmentEditPart.VISUAL_ID:
				return new PreguntaOpcionMultiplePreguntaOpcionMultipleOpcionesCompartmentEditPart(view);

			case EncuestaEncuestaPreguntasCompartmentEditPart.VISUAL_ID:
				return new EncuestaEncuestaPreguntasCompartmentEditPart(view);

			case PreguntaOpcionMultiplePreguntaOpcionMultipleOpcionesCompartment2EditPart.VISUAL_ID:
				return new PreguntaOpcionMultiplePreguntaOpcionMultipleOpcionesCompartment2EditPart(view);

			case ReferenciaEditPart.VISUAL_ID:
				return new ReferenciaEditPart(view);

			case ReferenciaNombreEditPart.VISUAL_ID:
				return new ReferenciaNombreEditPart(view);

			case PaginaEnlacesEditPart.VISUAL_ID:
				return new PaginaEnlacesEditPart(view);

			case WrappingLabelEditPart.VISUAL_ID:
				return new WrappingLabelEditPart(view);

			case PaginaRedesSocialesEditPart.VISUAL_ID:
				return new PaginaRedesSocialesEditPart(view);

			case WrappingLabel2EditPart.VISUAL_ID:
				return new WrappingLabel2EditPart(view);

			case PaginaFuentesRSSEditPart.VISUAL_ID:
				return new PaginaFuentesRSSEditPart(view);

			case WrappingLabel3EditPart.VISUAL_ID:
				return new WrappingLabel3EditPart(view);

			case PaginaCRUDEntidadEditPart.VISUAL_ID:
				return new PaginaCRUDEntidadEditPart(view);

			case WrappingLabel4EditPart.VISUAL_ID:
				return new WrappingLabel4EditPart(view);

			case PaginaIndiceAtributosMostradosEditPart.VISUAL_ID:
				return new PaginaIndiceAtributosMostradosEditPart(view);

			case WrappingLabel5EditPart.VISUAL_ID:
				return new WrappingLabel5EditPart(view);

			case PreguntaOpcionMultipleRespuestaCorrectaEditPart.VISUAL_ID:
				return new PreguntaOpcionMultipleRespuestaCorrectaEditPart(view);

			case WrappingLabel6EditPart.VISUAL_ID:
				return new WrappingLabel6EditPart(view);

			case RolPaginasAccesiblesEditPart.VISUAL_ID:
				return new RolPaginasAccesiblesEditPart(view);

			case WrappingLabel7EditPart.VISUAL_ID:
				return new WrappingLabel7EditPart(view);

			case PaginaIndiceFiltrosAtributosFiltroEditPart.VISUAL_ID:
				return new PaginaIndiceFiltrosAtributosFiltroEditPart(view);

			case WrappingLabel8EditPart.VISUAL_ID:
				return new WrappingLabel8EditPart(view);

			case PaginaIndicePaginadaFiltradaAtributosFiltroEditPart.VISUAL_ID:
				return new PaginaIndicePaginadaFiltradaAtributosFiltroEditPart(view);

			case WrappingLabel9EditPart.VISUAL_ID:
				return new WrappingLabel9EditPart(view);

			}
		}
		return createUnrecognizedEditPart(context, model);
	}

	/**
	* @generated
	*/
	private EditPart createUnrecognizedEditPart(EditPart context, Object model) {
		// Handle creation of unrecognized child node EditParts here
		return null;
	}

	/**
	* @generated
	*/
	public static CellEditorLocator getTextCellEditorLocator(ITextAwareEditPart source) {
		return CellEditorLocatorAccess.INSTANCE.getTextCellEditorLocator(source);
	}

}
