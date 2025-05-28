/*
* 
*/
package dataweb.diagram.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;

import dataweb.Aplicacion;
import dataweb.Atributo;
import dataweb.Cuestionario;
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
import dataweb.RedSocial;
import dataweb.Referencia;
import dataweb.Rol;
import dataweb.diagram.edit.parts.AplicacionEditPart;
import dataweb.diagram.edit.parts.AtributoEditPart;
import dataweb.diagram.edit.parts.CuestionarioCuestionarioPreguntasCompartmentEditPart;
import dataweb.diagram.edit.parts.CuestionarioEditPart;
import dataweb.diagram.edit.parts.EncuestaEditPart;
import dataweb.diagram.edit.parts.EncuestaEncuestaPreguntasCompartmentEditPart;
import dataweb.diagram.edit.parts.EntidadEditPart;
import dataweb.diagram.edit.parts.EntidadEntidadAtributosCompartmentEditPart;
import dataweb.diagram.edit.parts.FuenteRSSEditPart;
import dataweb.diagram.edit.parts.OpcionRespuestaEditPart;
import dataweb.diagram.edit.parts.PaginaActualizacionEditPart;
import dataweb.diagram.edit.parts.PaginaBorradoEditPart;
import dataweb.diagram.edit.parts.PaginaCRUDEntidadEditPart;
import dataweb.diagram.edit.parts.PaginaContenidoEditPart;
import dataweb.diagram.edit.parts.PaginaCreacionEditPart;
import dataweb.diagram.edit.parts.PaginaDetalleEditPart;
import dataweb.diagram.edit.parts.PaginaEnlacesEditPart;
import dataweb.diagram.edit.parts.PaginaFuentesRSSEditPart;
import dataweb.diagram.edit.parts.PaginaHomeEditPart;
import dataweb.diagram.edit.parts.PaginaIndiceAtributosMostradosEditPart;
import dataweb.diagram.edit.parts.PaginaIndiceDetalleEditPart;
import dataweb.diagram.edit.parts.PaginaIndiceFiltrosAtributosFiltroEditPart;
import dataweb.diagram.edit.parts.PaginaIndiceFiltrosEditPart;
import dataweb.diagram.edit.parts.PaginaIndicePaginadaEditPart;
import dataweb.diagram.edit.parts.PaginaIndicePaginadaFiltradaAtributosFiltroEditPart;
import dataweb.diagram.edit.parts.PaginaIndicePaginadaFiltradaEditPart;
import dataweb.diagram.edit.parts.PaginaRedesSocialesEditPart;
import dataweb.diagram.edit.parts.PreguntaOpcionMultiple2EditPart;
import dataweb.diagram.edit.parts.PreguntaOpcionMultipleEditPart;
import dataweb.diagram.edit.parts.PreguntaOpcionMultiplePreguntaOpcionMultipleOpcionesCompartment2EditPart;
import dataweb.diagram.edit.parts.PreguntaOpcionMultiplePreguntaOpcionMultipleOpcionesCompartmentEditPart;
import dataweb.diagram.edit.parts.PreguntaOpcionMultipleRespuestaCorrectaEditPart;
import dataweb.diagram.edit.parts.PreguntaRespuestaCorta2EditPart;
import dataweb.diagram.edit.parts.PreguntaRespuestaCortaEditPart;
import dataweb.diagram.edit.parts.PreguntaVerdaderoFalso2EditPart;
import dataweb.diagram.edit.parts.PreguntaVerdaderoFalsoEditPart;
import dataweb.diagram.edit.parts.RedSocialEditPart;
import dataweb.diagram.edit.parts.ReferenciaEditPart;
import dataweb.diagram.edit.parts.RolEditPart;
import dataweb.diagram.edit.parts.RolPaginasAccesiblesEditPart;
import dataweb.diagram.providers.DatawebElementTypes;

/**
 * @generated
 */
public class DatawebDiagramUpdater {

	/**
	* @generated
	*/
	public static boolean isShortcutOrphaned(View view) {
		return !view.isSetElement() || view.getElement() == null || view.getElement().eIsProxy();
	}

	/**
	* @generated
	*/
	public static List<DatawebNodeDescriptor> getSemanticChildren(View view) {
		switch (DatawebVisualIDRegistry.getVisualID(view)) {
		case AplicacionEditPart.VISUAL_ID:
			return getAplicacion_1000SemanticChildren(view);
		case EntidadEntidadAtributosCompartmentEditPart.VISUAL_ID:
			return getEntidadEntidadAtributosCompartment_7001SemanticChildren(view);
		case CuestionarioCuestionarioPreguntasCompartmentEditPart.VISUAL_ID:
			return getCuestionarioCuestionarioPreguntasCompartment_7003SemanticChildren(view);
		case PreguntaOpcionMultiplePreguntaOpcionMultipleOpcionesCompartmentEditPart.VISUAL_ID:
			return getPreguntaOpcionMultiplePreguntaOpcionMultipleOpcionesCompartment_7004SemanticChildren(view);
		case EncuestaEncuestaPreguntasCompartmentEditPart.VISUAL_ID:
			return getEncuestaEncuestaPreguntasCompartment_7005SemanticChildren(view);
		case PreguntaOpcionMultiplePreguntaOpcionMultipleOpcionesCompartment2EditPart.VISUAL_ID:
			return getPreguntaOpcionMultiplePreguntaOpcionMultipleOpcionesCompartment_7006SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DatawebNodeDescriptor> getAplicacion_1000SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Aplicacion modelElement = (Aplicacion) view.getElement();
		LinkedList<DatawebNodeDescriptor> result = new LinkedList<DatawebNodeDescriptor>();
		for (Iterator<?> it = modelElement.getPaginas().iterator(); it.hasNext();) {
			Pagina childElement = (Pagina) it.next();
			int visualID = DatawebVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == PaginaIndiceDetalleEditPart.VISUAL_ID) {
				result.add(new DatawebNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PaginaIndicePaginadaEditPart.VISUAL_ID) {
				result.add(new DatawebNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PaginaIndiceFiltrosEditPart.VISUAL_ID) {
				result.add(new DatawebNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PaginaIndicePaginadaFiltradaEditPart.VISUAL_ID) {
				result.add(new DatawebNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PaginaDetalleEditPart.VISUAL_ID) {
				result.add(new DatawebNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PaginaCreacionEditPart.VISUAL_ID) {
				result.add(new DatawebNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PaginaActualizacionEditPart.VISUAL_ID) {
				result.add(new DatawebNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PaginaBorradoEditPart.VISUAL_ID) {
				result.add(new DatawebNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PaginaHomeEditPart.VISUAL_ID) {
				result.add(new DatawebNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PaginaContenidoEditPart.VISUAL_ID) {
				result.add(new DatawebNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getEntidades().iterator(); it.hasNext();) {
			Entidad childElement = (Entidad) it.next();
			int visualID = DatawebVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == EntidadEditPart.VISUAL_ID) {
				result.add(new DatawebNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getRoles().iterator(); it.hasNext();) {
			Rol childElement = (Rol) it.next();
			int visualID = DatawebVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == RolEditPart.VISUAL_ID) {
				result.add(new DatawebNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getCuestionarios().iterator(); it.hasNext();) {
			Cuestionario childElement = (Cuestionario) it.next();
			int visualID = DatawebVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == CuestionarioEditPart.VISUAL_ID) {
				result.add(new DatawebNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getEncuestas().iterator(); it.hasNext();) {
			Encuesta childElement = (Encuesta) it.next();
			int visualID = DatawebVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == EncuestaEditPart.VISUAL_ID) {
				result.add(new DatawebNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getRedesSociales().iterator(); it.hasNext();) {
			RedSocial childElement = (RedSocial) it.next();
			int visualID = DatawebVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == RedSocialEditPart.VISUAL_ID) {
				result.add(new DatawebNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getFuentesRSS().iterator(); it.hasNext();) {
			FuenteRSS childElement = (FuenteRSS) it.next();
			int visualID = DatawebVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == FuenteRSSEditPart.VISUAL_ID) {
				result.add(new DatawebNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<DatawebNodeDescriptor> getEntidadEntidadAtributosCompartment_7001SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Entidad modelElement = (Entidad) containerView.getElement();
		LinkedList<DatawebNodeDescriptor> result = new LinkedList<DatawebNodeDescriptor>();
		for (Iterator<?> it = modelElement.getAtributos().iterator(); it.hasNext();) {
			Atributo childElement = (Atributo) it.next();
			int visualID = DatawebVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == AtributoEditPart.VISUAL_ID) {
				result.add(new DatawebNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<DatawebNodeDescriptor> getCuestionarioCuestionarioPreguntasCompartment_7003SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Cuestionario modelElement = (Cuestionario) containerView.getElement();
		LinkedList<DatawebNodeDescriptor> result = new LinkedList<DatawebNodeDescriptor>();
		for (Iterator<?> it = modelElement.getPreguntas().iterator(); it.hasNext();) {
			Pregunta childElement = (Pregunta) it.next();
			int visualID = DatawebVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == PreguntaOpcionMultipleEditPart.VISUAL_ID) {
				result.add(new DatawebNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PreguntaVerdaderoFalsoEditPart.VISUAL_ID) {
				result.add(new DatawebNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PreguntaRespuestaCortaEditPart.VISUAL_ID) {
				result.add(new DatawebNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<DatawebNodeDescriptor> getPreguntaOpcionMultiplePreguntaOpcionMultipleOpcionesCompartment_7004SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		PreguntaOpcionMultiple modelElement = (PreguntaOpcionMultiple) containerView.getElement();
		LinkedList<DatawebNodeDescriptor> result = new LinkedList<DatawebNodeDescriptor>();
		for (Iterator<?> it = modelElement.getOpciones().iterator(); it.hasNext();) {
			OpcionRespuesta childElement = (OpcionRespuesta) it.next();
			int visualID = DatawebVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == OpcionRespuestaEditPart.VISUAL_ID) {
				result.add(new DatawebNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<DatawebNodeDescriptor> getEncuestaEncuestaPreguntasCompartment_7005SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Encuesta modelElement = (Encuesta) containerView.getElement();
		LinkedList<DatawebNodeDescriptor> result = new LinkedList<DatawebNodeDescriptor>();
		for (Iterator<?> it = modelElement.getPreguntas().iterator(); it.hasNext();) {
			Pregunta childElement = (Pregunta) it.next();
			int visualID = DatawebVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == PreguntaOpcionMultiple2EditPart.VISUAL_ID) {
				result.add(new DatawebNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PreguntaVerdaderoFalso2EditPart.VISUAL_ID) {
				result.add(new DatawebNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PreguntaRespuestaCorta2EditPart.VISUAL_ID) {
				result.add(new DatawebNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<DatawebNodeDescriptor> getPreguntaOpcionMultiplePreguntaOpcionMultipleOpcionesCompartment_7006SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		PreguntaOpcionMultiple modelElement = (PreguntaOpcionMultiple) containerView.getElement();
		LinkedList<DatawebNodeDescriptor> result = new LinkedList<DatawebNodeDescriptor>();
		for (Iterator<?> it = modelElement.getOpciones().iterator(); it.hasNext();) {
			OpcionRespuesta childElement = (OpcionRespuesta) it.next();
			int visualID = DatawebVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == OpcionRespuestaEditPart.VISUAL_ID) {
				result.add(new DatawebNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<DatawebLinkDescriptor> getContainedLinks(View view) {
		switch (DatawebVisualIDRegistry.getVisualID(view)) {
		case AplicacionEditPart.VISUAL_ID:
			return getAplicacion_1000ContainedLinks(view);
		case PaginaIndiceDetalleEditPart.VISUAL_ID:
			return getPaginaIndiceDetalle_2001ContainedLinks(view);
		case PaginaIndicePaginadaEditPart.VISUAL_ID:
			return getPaginaIndicePaginada_2002ContainedLinks(view);
		case PaginaIndiceFiltrosEditPart.VISUAL_ID:
			return getPaginaIndiceFiltros_2003ContainedLinks(view);
		case PaginaIndicePaginadaFiltradaEditPart.VISUAL_ID:
			return getPaginaIndicePaginadaFiltrada_2004ContainedLinks(view);
		case PaginaDetalleEditPart.VISUAL_ID:
			return getPaginaDetalle_2005ContainedLinks(view);
		case PaginaCreacionEditPart.VISUAL_ID:
			return getPaginaCreacion_2006ContainedLinks(view);
		case PaginaActualizacionEditPart.VISUAL_ID:
			return getPaginaActualizacion_2007ContainedLinks(view);
		case PaginaBorradoEditPart.VISUAL_ID:
			return getPaginaBorrado_2008ContainedLinks(view);
		case PaginaHomeEditPart.VISUAL_ID:
			return getPaginaHome_2009ContainedLinks(view);
		case PaginaContenidoEditPart.VISUAL_ID:
			return getPaginaContenido_2010ContainedLinks(view);
		case EntidadEditPart.VISUAL_ID:
			return getEntidad_2011ContainedLinks(view);
		case RolEditPart.VISUAL_ID:
			return getRol_2012ContainedLinks(view);
		case CuestionarioEditPart.VISUAL_ID:
			return getCuestionario_2013ContainedLinks(view);
		case EncuestaEditPart.VISUAL_ID:
			return getEncuesta_2014ContainedLinks(view);
		case RedSocialEditPart.VISUAL_ID:
			return getRedSocial_2015ContainedLinks(view);
		case FuenteRSSEditPart.VISUAL_ID:
			return getFuenteRSS_2016ContainedLinks(view);
		case AtributoEditPart.VISUAL_ID:
			return getAtributo_3001ContainedLinks(view);
		case PreguntaOpcionMultipleEditPart.VISUAL_ID:
			return getPreguntaOpcionMultiple_3002ContainedLinks(view);
		case OpcionRespuestaEditPart.VISUAL_ID:
			return getOpcionRespuesta_3003ContainedLinks(view);
		case PreguntaVerdaderoFalsoEditPart.VISUAL_ID:
			return getPreguntaVerdaderoFalso_3004ContainedLinks(view);
		case PreguntaRespuestaCortaEditPart.VISUAL_ID:
			return getPreguntaRespuestaCorta_3005ContainedLinks(view);
		case PreguntaOpcionMultiple2EditPart.VISUAL_ID:
			return getPreguntaOpcionMultiple_3006ContainedLinks(view);
		case PreguntaVerdaderoFalso2EditPart.VISUAL_ID:
			return getPreguntaVerdaderoFalso_3007ContainedLinks(view);
		case PreguntaRespuestaCorta2EditPart.VISUAL_ID:
			return getPreguntaRespuestaCorta_3008ContainedLinks(view);
		case ReferenciaEditPart.VISUAL_ID:
			return getReferencia_4001ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DatawebLinkDescriptor> getIncomingLinks(View view) {
		switch (DatawebVisualIDRegistry.getVisualID(view)) {
		case PaginaIndiceDetalleEditPart.VISUAL_ID:
			return getPaginaIndiceDetalle_2001IncomingLinks(view);
		case PaginaIndicePaginadaEditPart.VISUAL_ID:
			return getPaginaIndicePaginada_2002IncomingLinks(view);
		case PaginaIndiceFiltrosEditPart.VISUAL_ID:
			return getPaginaIndiceFiltros_2003IncomingLinks(view);
		case PaginaIndicePaginadaFiltradaEditPart.VISUAL_ID:
			return getPaginaIndicePaginadaFiltrada_2004IncomingLinks(view);
		case PaginaDetalleEditPart.VISUAL_ID:
			return getPaginaDetalle_2005IncomingLinks(view);
		case PaginaCreacionEditPart.VISUAL_ID:
			return getPaginaCreacion_2006IncomingLinks(view);
		case PaginaActualizacionEditPart.VISUAL_ID:
			return getPaginaActualizacion_2007IncomingLinks(view);
		case PaginaBorradoEditPart.VISUAL_ID:
			return getPaginaBorrado_2008IncomingLinks(view);
		case PaginaHomeEditPart.VISUAL_ID:
			return getPaginaHome_2009IncomingLinks(view);
		case PaginaContenidoEditPart.VISUAL_ID:
			return getPaginaContenido_2010IncomingLinks(view);
		case EntidadEditPart.VISUAL_ID:
			return getEntidad_2011IncomingLinks(view);
		case RolEditPart.VISUAL_ID:
			return getRol_2012IncomingLinks(view);
		case CuestionarioEditPart.VISUAL_ID:
			return getCuestionario_2013IncomingLinks(view);
		case EncuestaEditPart.VISUAL_ID:
			return getEncuesta_2014IncomingLinks(view);
		case RedSocialEditPart.VISUAL_ID:
			return getRedSocial_2015IncomingLinks(view);
		case FuenteRSSEditPart.VISUAL_ID:
			return getFuenteRSS_2016IncomingLinks(view);
		case AtributoEditPart.VISUAL_ID:
			return getAtributo_3001IncomingLinks(view);
		case PreguntaOpcionMultipleEditPart.VISUAL_ID:
			return getPreguntaOpcionMultiple_3002IncomingLinks(view);
		case OpcionRespuestaEditPart.VISUAL_ID:
			return getOpcionRespuesta_3003IncomingLinks(view);
		case PreguntaVerdaderoFalsoEditPart.VISUAL_ID:
			return getPreguntaVerdaderoFalso_3004IncomingLinks(view);
		case PreguntaRespuestaCortaEditPart.VISUAL_ID:
			return getPreguntaRespuestaCorta_3005IncomingLinks(view);
		case PreguntaOpcionMultiple2EditPart.VISUAL_ID:
			return getPreguntaOpcionMultiple_3006IncomingLinks(view);
		case PreguntaVerdaderoFalso2EditPart.VISUAL_ID:
			return getPreguntaVerdaderoFalso_3007IncomingLinks(view);
		case PreguntaRespuestaCorta2EditPart.VISUAL_ID:
			return getPreguntaRespuestaCorta_3008IncomingLinks(view);
		case ReferenciaEditPart.VISUAL_ID:
			return getReferencia_4001IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DatawebLinkDescriptor> getOutgoingLinks(View view) {
		switch (DatawebVisualIDRegistry.getVisualID(view)) {
		case PaginaIndiceDetalleEditPart.VISUAL_ID:
			return getPaginaIndiceDetalle_2001OutgoingLinks(view);
		case PaginaIndicePaginadaEditPart.VISUAL_ID:
			return getPaginaIndicePaginada_2002OutgoingLinks(view);
		case PaginaIndiceFiltrosEditPart.VISUAL_ID:
			return getPaginaIndiceFiltros_2003OutgoingLinks(view);
		case PaginaIndicePaginadaFiltradaEditPart.VISUAL_ID:
			return getPaginaIndicePaginadaFiltrada_2004OutgoingLinks(view);
		case PaginaDetalleEditPart.VISUAL_ID:
			return getPaginaDetalle_2005OutgoingLinks(view);
		case PaginaCreacionEditPart.VISUAL_ID:
			return getPaginaCreacion_2006OutgoingLinks(view);
		case PaginaActualizacionEditPart.VISUAL_ID:
			return getPaginaActualizacion_2007OutgoingLinks(view);
		case PaginaBorradoEditPart.VISUAL_ID:
			return getPaginaBorrado_2008OutgoingLinks(view);
		case PaginaHomeEditPart.VISUAL_ID:
			return getPaginaHome_2009OutgoingLinks(view);
		case PaginaContenidoEditPart.VISUAL_ID:
			return getPaginaContenido_2010OutgoingLinks(view);
		case EntidadEditPart.VISUAL_ID:
			return getEntidad_2011OutgoingLinks(view);
		case RolEditPart.VISUAL_ID:
			return getRol_2012OutgoingLinks(view);
		case CuestionarioEditPart.VISUAL_ID:
			return getCuestionario_2013OutgoingLinks(view);
		case EncuestaEditPart.VISUAL_ID:
			return getEncuesta_2014OutgoingLinks(view);
		case RedSocialEditPart.VISUAL_ID:
			return getRedSocial_2015OutgoingLinks(view);
		case FuenteRSSEditPart.VISUAL_ID:
			return getFuenteRSS_2016OutgoingLinks(view);
		case AtributoEditPart.VISUAL_ID:
			return getAtributo_3001OutgoingLinks(view);
		case PreguntaOpcionMultipleEditPart.VISUAL_ID:
			return getPreguntaOpcionMultiple_3002OutgoingLinks(view);
		case OpcionRespuestaEditPart.VISUAL_ID:
			return getOpcionRespuesta_3003OutgoingLinks(view);
		case PreguntaVerdaderoFalsoEditPart.VISUAL_ID:
			return getPreguntaVerdaderoFalso_3004OutgoingLinks(view);
		case PreguntaRespuestaCortaEditPart.VISUAL_ID:
			return getPreguntaRespuestaCorta_3005OutgoingLinks(view);
		case PreguntaOpcionMultiple2EditPart.VISUAL_ID:
			return getPreguntaOpcionMultiple_3006OutgoingLinks(view);
		case PreguntaVerdaderoFalso2EditPart.VISUAL_ID:
			return getPreguntaVerdaderoFalso_3007OutgoingLinks(view);
		case PreguntaRespuestaCorta2EditPart.VISUAL_ID:
			return getPreguntaRespuestaCorta_3008OutgoingLinks(view);
		case ReferenciaEditPart.VISUAL_ID:
			return getReferencia_4001OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getAplicacion_1000ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getPaginaIndiceDetalle_2001ContainedLinks(View view) {
		PaginaIndiceDetalle modelElement = (PaginaIndiceDetalle) view.getElement();
		LinkedList<DatawebLinkDescriptor> result = new LinkedList<DatawebLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Pagina_Enlaces_4002(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Pagina_RedesSociales_4003(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Pagina_FuentesRSS_4004(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_PaginaCRUD_Entidad_4005(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_PaginaIndice_AtributosMostrados_4006(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getPaginaIndicePaginada_2002ContainedLinks(View view) {
		PaginaIndicePaginada modelElement = (PaginaIndicePaginada) view.getElement();
		LinkedList<DatawebLinkDescriptor> result = new LinkedList<DatawebLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Pagina_Enlaces_4002(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Pagina_RedesSociales_4003(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Pagina_FuentesRSS_4004(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_PaginaCRUD_Entidad_4005(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_PaginaIndice_AtributosMostrados_4006(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getPaginaIndiceFiltros_2003ContainedLinks(View view) {
		PaginaIndiceFiltros modelElement = (PaginaIndiceFiltros) view.getElement();
		LinkedList<DatawebLinkDescriptor> result = new LinkedList<DatawebLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Pagina_Enlaces_4002(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Pagina_RedesSociales_4003(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Pagina_FuentesRSS_4004(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_PaginaCRUD_Entidad_4005(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_PaginaIndice_AtributosMostrados_4006(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_PaginaIndiceFiltros_AtributosFiltro_4009(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getPaginaIndicePaginadaFiltrada_2004ContainedLinks(View view) {
		PaginaIndicePaginadaFiltrada modelElement = (PaginaIndicePaginadaFiltrada) view.getElement();
		LinkedList<DatawebLinkDescriptor> result = new LinkedList<DatawebLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Pagina_Enlaces_4002(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Pagina_RedesSociales_4003(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Pagina_FuentesRSS_4004(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_PaginaCRUD_Entidad_4005(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_PaginaIndice_AtributosMostrados_4006(modelElement));
		result.addAll(
				getOutgoingFeatureModelFacetLinks_PaginaIndicePaginadaFiltrada_AtributosFiltro_4010(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getPaginaDetalle_2005ContainedLinks(View view) {
		PaginaDetalle modelElement = (PaginaDetalle) view.getElement();
		LinkedList<DatawebLinkDescriptor> result = new LinkedList<DatawebLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Pagina_Enlaces_4002(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Pagina_RedesSociales_4003(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Pagina_FuentesRSS_4004(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_PaginaCRUD_Entidad_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getPaginaCreacion_2006ContainedLinks(View view) {
		PaginaCreacion modelElement = (PaginaCreacion) view.getElement();
		LinkedList<DatawebLinkDescriptor> result = new LinkedList<DatawebLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Pagina_Enlaces_4002(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Pagina_RedesSociales_4003(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Pagina_FuentesRSS_4004(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_PaginaCRUD_Entidad_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getPaginaActualizacion_2007ContainedLinks(View view) {
		PaginaActualizacion modelElement = (PaginaActualizacion) view.getElement();
		LinkedList<DatawebLinkDescriptor> result = new LinkedList<DatawebLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Pagina_Enlaces_4002(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Pagina_RedesSociales_4003(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Pagina_FuentesRSS_4004(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_PaginaCRUD_Entidad_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getPaginaBorrado_2008ContainedLinks(View view) {
		PaginaBorrado modelElement = (PaginaBorrado) view.getElement();
		LinkedList<DatawebLinkDescriptor> result = new LinkedList<DatawebLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Pagina_Enlaces_4002(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Pagina_RedesSociales_4003(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Pagina_FuentesRSS_4004(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_PaginaCRUD_Entidad_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getPaginaHome_2009ContainedLinks(View view) {
		PaginaHome modelElement = (PaginaHome) view.getElement();
		LinkedList<DatawebLinkDescriptor> result = new LinkedList<DatawebLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Pagina_Enlaces_4002(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Pagina_RedesSociales_4003(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Pagina_FuentesRSS_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getPaginaContenido_2010ContainedLinks(View view) {
		PaginaContenido modelElement = (PaginaContenido) view.getElement();
		LinkedList<DatawebLinkDescriptor> result = new LinkedList<DatawebLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Pagina_Enlaces_4002(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Pagina_RedesSociales_4003(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Pagina_FuentesRSS_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getEntidad_2011ContainedLinks(View view) {
		Entidad modelElement = (Entidad) view.getElement();
		LinkedList<DatawebLinkDescriptor> result = new LinkedList<DatawebLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Referencia_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getRol_2012ContainedLinks(View view) {
		Rol modelElement = (Rol) view.getElement();
		LinkedList<DatawebLinkDescriptor> result = new LinkedList<DatawebLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Rol_PaginasAccesibles_4008(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getCuestionario_2013ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getEncuesta_2014ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getRedSocial_2015ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getFuenteRSS_2016ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getAtributo_3001ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getPreguntaOpcionMultiple_3002ContainedLinks(View view) {
		PreguntaOpcionMultiple modelElement = (PreguntaOpcionMultiple) view.getElement();
		LinkedList<DatawebLinkDescriptor> result = new LinkedList<DatawebLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_PreguntaOpcionMultiple_RespuestaCorrecta_4007(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getOpcionRespuesta_3003ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getPreguntaVerdaderoFalso_3004ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getPreguntaRespuestaCorta_3005ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getPreguntaOpcionMultiple_3006ContainedLinks(View view) {
		PreguntaOpcionMultiple modelElement = (PreguntaOpcionMultiple) view.getElement();
		LinkedList<DatawebLinkDescriptor> result = new LinkedList<DatawebLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_PreguntaOpcionMultiple_RespuestaCorrecta_4007(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getPreguntaVerdaderoFalso_3007ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getPreguntaRespuestaCorta_3008ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getReferencia_4001ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getPaginaIndiceDetalle_2001IncomingLinks(View view) {
		PaginaIndiceDetalle modelElement = (PaginaIndiceDetalle) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<DatawebLinkDescriptor> result = new LinkedList<DatawebLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Pagina_Enlaces_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Rol_PaginasAccesibles_4008(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getPaginaIndicePaginada_2002IncomingLinks(View view) {
		PaginaIndicePaginada modelElement = (PaginaIndicePaginada) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<DatawebLinkDescriptor> result = new LinkedList<DatawebLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Pagina_Enlaces_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Rol_PaginasAccesibles_4008(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getPaginaIndiceFiltros_2003IncomingLinks(View view) {
		PaginaIndiceFiltros modelElement = (PaginaIndiceFiltros) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<DatawebLinkDescriptor> result = new LinkedList<DatawebLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Pagina_Enlaces_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Rol_PaginasAccesibles_4008(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getPaginaIndicePaginadaFiltrada_2004IncomingLinks(View view) {
		PaginaIndicePaginadaFiltrada modelElement = (PaginaIndicePaginadaFiltrada) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<DatawebLinkDescriptor> result = new LinkedList<DatawebLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Pagina_Enlaces_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Rol_PaginasAccesibles_4008(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getPaginaDetalle_2005IncomingLinks(View view) {
		PaginaDetalle modelElement = (PaginaDetalle) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<DatawebLinkDescriptor> result = new LinkedList<DatawebLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Pagina_Enlaces_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Rol_PaginasAccesibles_4008(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getPaginaCreacion_2006IncomingLinks(View view) {
		PaginaCreacion modelElement = (PaginaCreacion) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<DatawebLinkDescriptor> result = new LinkedList<DatawebLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Pagina_Enlaces_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Rol_PaginasAccesibles_4008(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getPaginaActualizacion_2007IncomingLinks(View view) {
		PaginaActualizacion modelElement = (PaginaActualizacion) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<DatawebLinkDescriptor> result = new LinkedList<DatawebLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Pagina_Enlaces_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Rol_PaginasAccesibles_4008(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getPaginaBorrado_2008IncomingLinks(View view) {
		PaginaBorrado modelElement = (PaginaBorrado) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<DatawebLinkDescriptor> result = new LinkedList<DatawebLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Pagina_Enlaces_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Rol_PaginasAccesibles_4008(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getPaginaHome_2009IncomingLinks(View view) {
		PaginaHome modelElement = (PaginaHome) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<DatawebLinkDescriptor> result = new LinkedList<DatawebLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Pagina_Enlaces_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Rol_PaginasAccesibles_4008(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getPaginaContenido_2010IncomingLinks(View view) {
		PaginaContenido modelElement = (PaginaContenido) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<DatawebLinkDescriptor> result = new LinkedList<DatawebLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Pagina_Enlaces_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Rol_PaginasAccesibles_4008(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getEntidad_2011IncomingLinks(View view) {
		Entidad modelElement = (Entidad) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<DatawebLinkDescriptor> result = new LinkedList<DatawebLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Referencia_4001(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_PaginaCRUD_Entidad_4005(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getRol_2012IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getCuestionario_2013IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getEncuesta_2014IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getRedSocial_2015IncomingLinks(View view) {
		RedSocial modelElement = (RedSocial) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<DatawebLinkDescriptor> result = new LinkedList<DatawebLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Pagina_RedesSociales_4003(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getFuenteRSS_2016IncomingLinks(View view) {
		FuenteRSS modelElement = (FuenteRSS) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<DatawebLinkDescriptor> result = new LinkedList<DatawebLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Pagina_FuentesRSS_4004(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getAtributo_3001IncomingLinks(View view) {
		Atributo modelElement = (Atributo) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<DatawebLinkDescriptor> result = new LinkedList<DatawebLinkDescriptor>();
		result.addAll(
				getIncomingFeatureModelFacetLinks_PaginaIndice_AtributosMostrados_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_PaginaIndiceFiltros_AtributosFiltro_4009(modelElement,
				crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_PaginaIndicePaginadaFiltrada_AtributosFiltro_4010(modelElement,
				crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getPreguntaOpcionMultiple_3002IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getOpcionRespuesta_3003IncomingLinks(View view) {
		OpcionRespuesta modelElement = (OpcionRespuesta) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<DatawebLinkDescriptor> result = new LinkedList<DatawebLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_PreguntaOpcionMultiple_RespuestaCorrecta_4007(modelElement,
				crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getPreguntaVerdaderoFalso_3004IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getPreguntaRespuestaCorta_3005IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getPreguntaOpcionMultiple_3006IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getPreguntaVerdaderoFalso_3007IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getPreguntaRespuestaCorta_3008IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getReferencia_4001IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getPaginaIndiceDetalle_2001OutgoingLinks(View view) {
		PaginaIndiceDetalle modelElement = (PaginaIndiceDetalle) view.getElement();
		LinkedList<DatawebLinkDescriptor> result = new LinkedList<DatawebLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Pagina_Enlaces_4002(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Pagina_RedesSociales_4003(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Pagina_FuentesRSS_4004(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_PaginaCRUD_Entidad_4005(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_PaginaIndice_AtributosMostrados_4006(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getPaginaIndicePaginada_2002OutgoingLinks(View view) {
		PaginaIndicePaginada modelElement = (PaginaIndicePaginada) view.getElement();
		LinkedList<DatawebLinkDescriptor> result = new LinkedList<DatawebLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Pagina_Enlaces_4002(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Pagina_RedesSociales_4003(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Pagina_FuentesRSS_4004(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_PaginaCRUD_Entidad_4005(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_PaginaIndice_AtributosMostrados_4006(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getPaginaIndiceFiltros_2003OutgoingLinks(View view) {
		PaginaIndiceFiltros modelElement = (PaginaIndiceFiltros) view.getElement();
		LinkedList<DatawebLinkDescriptor> result = new LinkedList<DatawebLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Pagina_Enlaces_4002(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Pagina_RedesSociales_4003(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Pagina_FuentesRSS_4004(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_PaginaCRUD_Entidad_4005(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_PaginaIndice_AtributosMostrados_4006(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_PaginaIndiceFiltros_AtributosFiltro_4009(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getPaginaIndicePaginadaFiltrada_2004OutgoingLinks(View view) {
		PaginaIndicePaginadaFiltrada modelElement = (PaginaIndicePaginadaFiltrada) view.getElement();
		LinkedList<DatawebLinkDescriptor> result = new LinkedList<DatawebLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Pagina_Enlaces_4002(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Pagina_RedesSociales_4003(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Pagina_FuentesRSS_4004(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_PaginaCRUD_Entidad_4005(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_PaginaIndice_AtributosMostrados_4006(modelElement));
		result.addAll(
				getOutgoingFeatureModelFacetLinks_PaginaIndicePaginadaFiltrada_AtributosFiltro_4010(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getPaginaDetalle_2005OutgoingLinks(View view) {
		PaginaDetalle modelElement = (PaginaDetalle) view.getElement();
		LinkedList<DatawebLinkDescriptor> result = new LinkedList<DatawebLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Pagina_Enlaces_4002(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Pagina_RedesSociales_4003(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Pagina_FuentesRSS_4004(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_PaginaCRUD_Entidad_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getPaginaCreacion_2006OutgoingLinks(View view) {
		PaginaCreacion modelElement = (PaginaCreacion) view.getElement();
		LinkedList<DatawebLinkDescriptor> result = new LinkedList<DatawebLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Pagina_Enlaces_4002(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Pagina_RedesSociales_4003(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Pagina_FuentesRSS_4004(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_PaginaCRUD_Entidad_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getPaginaActualizacion_2007OutgoingLinks(View view) {
		PaginaActualizacion modelElement = (PaginaActualizacion) view.getElement();
		LinkedList<DatawebLinkDescriptor> result = new LinkedList<DatawebLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Pagina_Enlaces_4002(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Pagina_RedesSociales_4003(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Pagina_FuentesRSS_4004(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_PaginaCRUD_Entidad_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getPaginaBorrado_2008OutgoingLinks(View view) {
		PaginaBorrado modelElement = (PaginaBorrado) view.getElement();
		LinkedList<DatawebLinkDescriptor> result = new LinkedList<DatawebLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Pagina_Enlaces_4002(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Pagina_RedesSociales_4003(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Pagina_FuentesRSS_4004(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_PaginaCRUD_Entidad_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getPaginaHome_2009OutgoingLinks(View view) {
		PaginaHome modelElement = (PaginaHome) view.getElement();
		LinkedList<DatawebLinkDescriptor> result = new LinkedList<DatawebLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Pagina_Enlaces_4002(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Pagina_RedesSociales_4003(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Pagina_FuentesRSS_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getPaginaContenido_2010OutgoingLinks(View view) {
		PaginaContenido modelElement = (PaginaContenido) view.getElement();
		LinkedList<DatawebLinkDescriptor> result = new LinkedList<DatawebLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Pagina_Enlaces_4002(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Pagina_RedesSociales_4003(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Pagina_FuentesRSS_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getEntidad_2011OutgoingLinks(View view) {
		Entidad modelElement = (Entidad) view.getElement();
		LinkedList<DatawebLinkDescriptor> result = new LinkedList<DatawebLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Referencia_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getRol_2012OutgoingLinks(View view) {
		Rol modelElement = (Rol) view.getElement();
		LinkedList<DatawebLinkDescriptor> result = new LinkedList<DatawebLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Rol_PaginasAccesibles_4008(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getCuestionario_2013OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getEncuesta_2014OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getRedSocial_2015OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getFuenteRSS_2016OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getAtributo_3001OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getPreguntaOpcionMultiple_3002OutgoingLinks(View view) {
		PreguntaOpcionMultiple modelElement = (PreguntaOpcionMultiple) view.getElement();
		LinkedList<DatawebLinkDescriptor> result = new LinkedList<DatawebLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_PreguntaOpcionMultiple_RespuestaCorrecta_4007(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getOpcionRespuesta_3003OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getPreguntaVerdaderoFalso_3004OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getPreguntaRespuestaCorta_3005OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getPreguntaOpcionMultiple_3006OutgoingLinks(View view) {
		PreguntaOpcionMultiple modelElement = (PreguntaOpcionMultiple) view.getElement();
		LinkedList<DatawebLinkDescriptor> result = new LinkedList<DatawebLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_PreguntaOpcionMultiple_RespuestaCorrecta_4007(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getPreguntaVerdaderoFalso_3007OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getPreguntaRespuestaCorta_3008OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DatawebLinkDescriptor> getReferencia_4001OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	private static Collection<DatawebLinkDescriptor> getContainedTypeModelFacetLinks_Referencia_4001(
			Entidad container) {
		LinkedList<DatawebLinkDescriptor> result = new LinkedList<DatawebLinkDescriptor>();
		for (Iterator<?> links = container.getReferencias().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Referencia) {
				continue;
			}
			Referencia link = (Referencia) linkObject;
			if (ReferenciaEditPart.VISUAL_ID != DatawebVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Entidad dst = link.getTarget();
			Entidad src = link.getSource();
			result.add(new DatawebLinkDescriptor(src, dst, link, DatawebElementTypes.Referencia_4001,
					ReferenciaEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<DatawebLinkDescriptor> getIncomingTypeModelFacetLinks_Referencia_4001(Entidad target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<DatawebLinkDescriptor> result = new LinkedList<DatawebLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != DatawebPackage.eINSTANCE.getReferencia_Target()
					|| false == setting.getEObject() instanceof Referencia) {
				continue;
			}
			Referencia link = (Referencia) setting.getEObject();
			if (ReferenciaEditPart.VISUAL_ID != DatawebVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Entidad src = link.getSource();
			result.add(new DatawebLinkDescriptor(src, target, link, DatawebElementTypes.Referencia_4001,
					ReferenciaEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<DatawebLinkDescriptor> getIncomingFeatureModelFacetLinks_Pagina_Enlaces_4002(
			Pagina target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<DatawebLinkDescriptor> result = new LinkedList<DatawebLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == DatawebPackage.eINSTANCE.getPagina_Enlaces()) {
				result.add(new DatawebLinkDescriptor(setting.getEObject(), target,
						DatawebElementTypes.PaginaEnlaces_4002, PaginaEnlacesEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<DatawebLinkDescriptor> getIncomingFeatureModelFacetLinks_Pagina_RedesSociales_4003(
			RedSocial target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<DatawebLinkDescriptor> result = new LinkedList<DatawebLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == DatawebPackage.eINSTANCE.getPagina_RedesSociales()) {
				result.add(new DatawebLinkDescriptor(setting.getEObject(), target,
						DatawebElementTypes.PaginaRedesSociales_4003, PaginaRedesSocialesEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<DatawebLinkDescriptor> getIncomingFeatureModelFacetLinks_Pagina_FuentesRSS_4004(
			FuenteRSS target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<DatawebLinkDescriptor> result = new LinkedList<DatawebLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == DatawebPackage.eINSTANCE.getPagina_FuentesRSS()) {
				result.add(new DatawebLinkDescriptor(setting.getEObject(), target,
						DatawebElementTypes.PaginaFuentesRSS_4004, PaginaFuentesRSSEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<DatawebLinkDescriptor> getIncomingFeatureModelFacetLinks_PaginaCRUD_Entidad_4005(
			Entidad target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<DatawebLinkDescriptor> result = new LinkedList<DatawebLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == DatawebPackage.eINSTANCE.getPaginaCRUD_Entidad()) {
				result.add(new DatawebLinkDescriptor(setting.getEObject(), target,
						DatawebElementTypes.PaginaCRUDEntidad_4005, PaginaCRUDEntidadEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<DatawebLinkDescriptor> getIncomingFeatureModelFacetLinks_PaginaIndice_AtributosMostrados_4006(
			Atributo target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<DatawebLinkDescriptor> result = new LinkedList<DatawebLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == DatawebPackage.eINSTANCE.getPaginaIndice_AtributosMostrados()) {
				result.add(new DatawebLinkDescriptor(setting.getEObject(), target,
						DatawebElementTypes.PaginaIndiceAtributosMostrados_4006,
						PaginaIndiceAtributosMostradosEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<DatawebLinkDescriptor> getIncomingFeatureModelFacetLinks_PreguntaOpcionMultiple_RespuestaCorrecta_4007(
			OpcionRespuesta target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<DatawebLinkDescriptor> result = new LinkedList<DatawebLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == DatawebPackage.eINSTANCE
					.getPreguntaOpcionMultiple_RespuestaCorrecta()) {
				result.add(new DatawebLinkDescriptor(setting.getEObject(), target,
						DatawebElementTypes.PreguntaOpcionMultipleRespuestaCorrecta_4007,
						PreguntaOpcionMultipleRespuestaCorrectaEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<DatawebLinkDescriptor> getIncomingFeatureModelFacetLinks_Rol_PaginasAccesibles_4008(
			Pagina target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<DatawebLinkDescriptor> result = new LinkedList<DatawebLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == DatawebPackage.eINSTANCE.getRol_PaginasAccesibles()) {
				result.add(new DatawebLinkDescriptor(setting.getEObject(), target,
						DatawebElementTypes.RolPaginasAccesibles_4008, RolPaginasAccesiblesEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<DatawebLinkDescriptor> getIncomingFeatureModelFacetLinks_PaginaIndiceFiltros_AtributosFiltro_4009(
			Atributo target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<DatawebLinkDescriptor> result = new LinkedList<DatawebLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == DatawebPackage.eINSTANCE.getPaginaIndiceFiltros_AtributosFiltro()) {
				result.add(new DatawebLinkDescriptor(setting.getEObject(), target,
						DatawebElementTypes.PaginaIndiceFiltrosAtributosFiltro_4009,
						PaginaIndiceFiltrosAtributosFiltroEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<DatawebLinkDescriptor> getIncomingFeatureModelFacetLinks_PaginaIndicePaginadaFiltrada_AtributosFiltro_4010(
			Atributo target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<DatawebLinkDescriptor> result = new LinkedList<DatawebLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == DatawebPackage.eINSTANCE
					.getPaginaIndicePaginadaFiltrada_AtributosFiltro()) {
				result.add(new DatawebLinkDescriptor(setting.getEObject(), target,
						DatawebElementTypes.PaginaIndicePaginadaFiltradaAtributosFiltro_4010,
						PaginaIndicePaginadaFiltradaAtributosFiltroEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<DatawebLinkDescriptor> getOutgoingTypeModelFacetLinks_Referencia_4001(Entidad source) {
		Entidad container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof Entidad) {
				container = (Entidad) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<DatawebLinkDescriptor> result = new LinkedList<DatawebLinkDescriptor>();
		for (Iterator<?> links = container.getReferencias().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Referencia) {
				continue;
			}
			Referencia link = (Referencia) linkObject;
			if (ReferenciaEditPart.VISUAL_ID != DatawebVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Entidad dst = link.getTarget();
			Entidad src = link.getSource();
			if (src != source) {
				continue;
			}
			result.add(new DatawebLinkDescriptor(src, dst, link, DatawebElementTypes.Referencia_4001,
					ReferenciaEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<DatawebLinkDescriptor> getOutgoingFeatureModelFacetLinks_Pagina_Enlaces_4002(
			Pagina source) {
		LinkedList<DatawebLinkDescriptor> result = new LinkedList<DatawebLinkDescriptor>();
		for (Iterator<?> destinations = source.getEnlaces().iterator(); destinations.hasNext();) {
			Pagina destination = (Pagina) destinations.next();
			result.add(new DatawebLinkDescriptor(source, destination, DatawebElementTypes.PaginaEnlaces_4002,
					PaginaEnlacesEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<DatawebLinkDescriptor> getOutgoingFeatureModelFacetLinks_Pagina_RedesSociales_4003(
			Pagina source) {
		LinkedList<DatawebLinkDescriptor> result = new LinkedList<DatawebLinkDescriptor>();
		for (Iterator<?> destinations = source.getRedesSociales().iterator(); destinations.hasNext();) {
			RedSocial destination = (RedSocial) destinations.next();
			result.add(new DatawebLinkDescriptor(source, destination, DatawebElementTypes.PaginaRedesSociales_4003,
					PaginaRedesSocialesEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<DatawebLinkDescriptor> getOutgoingFeatureModelFacetLinks_Pagina_FuentesRSS_4004(
			Pagina source) {
		LinkedList<DatawebLinkDescriptor> result = new LinkedList<DatawebLinkDescriptor>();
		for (Iterator<?> destinations = source.getFuentesRSS().iterator(); destinations.hasNext();) {
			FuenteRSS destination = (FuenteRSS) destinations.next();
			result.add(new DatawebLinkDescriptor(source, destination, DatawebElementTypes.PaginaFuentesRSS_4004,
					PaginaFuentesRSSEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<DatawebLinkDescriptor> getOutgoingFeatureModelFacetLinks_PaginaCRUD_Entidad_4005(
			PaginaCRUD source) {
		LinkedList<DatawebLinkDescriptor> result = new LinkedList<DatawebLinkDescriptor>();
		Entidad destination = source.getEntidad();
		if (destination == null) {
			return result;
		}
		result.add(new DatawebLinkDescriptor(source, destination, DatawebElementTypes.PaginaCRUDEntidad_4005,
				PaginaCRUDEntidadEditPart.VISUAL_ID));
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<DatawebLinkDescriptor> getOutgoingFeatureModelFacetLinks_PaginaIndice_AtributosMostrados_4006(
			PaginaIndice source) {
		LinkedList<DatawebLinkDescriptor> result = new LinkedList<DatawebLinkDescriptor>();
		for (Iterator<?> destinations = source.getAtributosMostrados().iterator(); destinations.hasNext();) {
			Atributo destination = (Atributo) destinations.next();
			result.add(new DatawebLinkDescriptor(source, destination,
					DatawebElementTypes.PaginaIndiceAtributosMostrados_4006,
					PaginaIndiceAtributosMostradosEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<DatawebLinkDescriptor> getOutgoingFeatureModelFacetLinks_PreguntaOpcionMultiple_RespuestaCorrecta_4007(
			PreguntaOpcionMultiple source) {
		LinkedList<DatawebLinkDescriptor> result = new LinkedList<DatawebLinkDescriptor>();
		OpcionRespuesta destination = source.getRespuestaCorrecta();
		if (destination == null) {
			return result;
		}
		result.add(new DatawebLinkDescriptor(source, destination,
				DatawebElementTypes.PreguntaOpcionMultipleRespuestaCorrecta_4007,
				PreguntaOpcionMultipleRespuestaCorrectaEditPart.VISUAL_ID));
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<DatawebLinkDescriptor> getOutgoingFeatureModelFacetLinks_Rol_PaginasAccesibles_4008(
			Rol source) {
		LinkedList<DatawebLinkDescriptor> result = new LinkedList<DatawebLinkDescriptor>();
		for (Iterator<?> destinations = source.getPaginasAccesibles().iterator(); destinations.hasNext();) {
			Pagina destination = (Pagina) destinations.next();
			result.add(new DatawebLinkDescriptor(source, destination, DatawebElementTypes.RolPaginasAccesibles_4008,
					RolPaginasAccesiblesEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<DatawebLinkDescriptor> getOutgoingFeatureModelFacetLinks_PaginaIndiceFiltros_AtributosFiltro_4009(
			PaginaIndiceFiltros source) {
		LinkedList<DatawebLinkDescriptor> result = new LinkedList<DatawebLinkDescriptor>();
		for (Iterator<?> destinations = source.getAtributosFiltro().iterator(); destinations.hasNext();) {
			Atributo destination = (Atributo) destinations.next();
			result.add(new DatawebLinkDescriptor(source, destination,
					DatawebElementTypes.PaginaIndiceFiltrosAtributosFiltro_4009,
					PaginaIndiceFiltrosAtributosFiltroEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<DatawebLinkDescriptor> getOutgoingFeatureModelFacetLinks_PaginaIndicePaginadaFiltrada_AtributosFiltro_4010(
			PaginaIndicePaginadaFiltrada source) {
		LinkedList<DatawebLinkDescriptor> result = new LinkedList<DatawebLinkDescriptor>();
		for (Iterator<?> destinations = source.getAtributosFiltro().iterator(); destinations.hasNext();) {
			Atributo destination = (Atributo) destinations.next();
			result.add(new DatawebLinkDescriptor(source, destination,
					DatawebElementTypes.PaginaIndicePaginadaFiltradaAtributosFiltro_4010,
					PaginaIndicePaginadaFiltradaAtributosFiltroEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	public static final DiagramUpdater TYPED_INSTANCE = new DiagramUpdater() {
		/**
		* @generated
		*/
		@Override

		public List<DatawebNodeDescriptor> getSemanticChildren(View view) {
			return DatawebDiagramUpdater.getSemanticChildren(view);
		}

		/**
		* @generated
		*/
		@Override

		public List<DatawebLinkDescriptor> getContainedLinks(View view) {
			return DatawebDiagramUpdater.getContainedLinks(view);
		}

		/**
		* @generated
		*/
		@Override

		public List<DatawebLinkDescriptor> getIncomingLinks(View view) {
			return DatawebDiagramUpdater.getIncomingLinks(view);
		}

		/**
		* @generated
		*/
		@Override

		public List<DatawebLinkDescriptor> getOutgoingLinks(View view) {
			return DatawebDiagramUpdater.getOutgoingLinks(view);
		}
	};

}
