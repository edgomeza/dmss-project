/*
* 
*/
package dataweb.diagram.navigator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.common.ui.services.parser.CommonParserHint;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;

import dataweb.Aplicacion;
import dataweb.diagram.edit.parts.AplicacionEditPart;
import dataweb.diagram.edit.parts.AtributoEditPart;
import dataweb.diagram.edit.parts.AtributoNombreEditPart;
import dataweb.diagram.edit.parts.CuestionarioEditPart;
import dataweb.diagram.edit.parts.CuestionarioNombreEditPart;
import dataweb.diagram.edit.parts.EncuestaEditPart;
import dataweb.diagram.edit.parts.EncuestaNombreEditPart;
import dataweb.diagram.edit.parts.EntidadEditPart;
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
import dataweb.diagram.part.DatawebDiagramEditorPlugin;
import dataweb.diagram.part.DatawebVisualIDRegistry;
import dataweb.diagram.providers.DatawebElementTypes;
import dataweb.diagram.providers.DatawebParserProvider;

/**
 * @generated
 */
public class DatawebNavigatorLabelProvider extends LabelProvider
		implements ICommonLabelProvider, ITreePathLabelProvider {

	/**
	* @generated
	*/
	static {
		DatawebDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?UnknownElement", //$NON-NLS-1$
				ImageDescriptor.getMissingImageDescriptor());
		DatawebDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?ImageNotFound", //$NON-NLS-1$
				ImageDescriptor.getMissingImageDescriptor());
	}

	/**
	* @generated
	*/
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof DatawebNavigatorItem && !isOwnView(((DatawebNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	* @generated
	*/
	public Image getImage(Object element) {
		if (element instanceof DatawebNavigatorGroup) {
			DatawebNavigatorGroup group = (DatawebNavigatorGroup) element;
			return DatawebDiagramEditorPlugin.getInstance().getBundledImage(group.getIcon());
		}

		if (element instanceof DatawebNavigatorItem) {
			DatawebNavigatorItem navigatorItem = (DatawebNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return super.getImage(element);
			}
			return getImage(navigatorItem.getView());
		}

		// Due to plugin.xml content will be called only for "own" views
		if (element instanceof IAdaptable) {
			View view = (View) ((IAdaptable) element).getAdapter(View.class);
			if (view != null && isOwnView(view)) {
				return getImage(view);
			}
		}

		return super.getImage(element);
	}

	/**
	* @generated
	*/
	public Image getImage(View view) {
		switch (DatawebVisualIDRegistry.getVisualID(view)) {
		case AplicacionEditPart.VISUAL_ID:
			return getImage("Navigator?Diagram?http://www.unex.es/dmss/dataweb?Aplicacion", //$NON-NLS-1$
					DatawebElementTypes.Aplicacion_1000);
		case PaginaIndiceDetalleEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.unex.es/dmss/dataweb?PaginaIndiceDetalle", //$NON-NLS-1$
					DatawebElementTypes.PaginaIndiceDetalle_2001);
		case PaginaIndicePaginadaEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.unex.es/dmss/dataweb?PaginaIndicePaginada", //$NON-NLS-1$
					DatawebElementTypes.PaginaIndicePaginada_2002);
		case PaginaIndiceFiltrosEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.unex.es/dmss/dataweb?PaginaIndiceFiltros", //$NON-NLS-1$
					DatawebElementTypes.PaginaIndiceFiltros_2003);
		case PaginaIndicePaginadaFiltradaEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.unex.es/dmss/dataweb?PaginaIndicePaginadaFiltrada", //$NON-NLS-1$
					DatawebElementTypes.PaginaIndicePaginadaFiltrada_2004);
		case PaginaDetalleEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.unex.es/dmss/dataweb?PaginaDetalle", //$NON-NLS-1$
					DatawebElementTypes.PaginaDetalle_2005);
		case PaginaCreacionEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.unex.es/dmss/dataweb?PaginaCreacion", //$NON-NLS-1$
					DatawebElementTypes.PaginaCreacion_2006);
		case PaginaActualizacionEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.unex.es/dmss/dataweb?PaginaActualizacion", //$NON-NLS-1$
					DatawebElementTypes.PaginaActualizacion_2007);
		case PaginaBorradoEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.unex.es/dmss/dataweb?PaginaBorrado", //$NON-NLS-1$
					DatawebElementTypes.PaginaBorrado_2008);
		case PaginaHomeEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.unex.es/dmss/dataweb?PaginaHome", //$NON-NLS-1$
					DatawebElementTypes.PaginaHome_2009);
		case PaginaContenidoEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.unex.es/dmss/dataweb?PaginaContenido", //$NON-NLS-1$
					DatawebElementTypes.PaginaContenido_2010);
		case EntidadEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.unex.es/dmss/dataweb?Entidad", //$NON-NLS-1$
					DatawebElementTypes.Entidad_2011);
		case RolEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.unex.es/dmss/dataweb?Rol", DatawebElementTypes.Rol_2012); //$NON-NLS-1$
		case CuestionarioEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.unex.es/dmss/dataweb?Cuestionario", //$NON-NLS-1$
					DatawebElementTypes.Cuestionario_2013);
		case EncuestaEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.unex.es/dmss/dataweb?Encuesta", //$NON-NLS-1$
					DatawebElementTypes.Encuesta_2014);
		case RedSocialEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.unex.es/dmss/dataweb?RedSocial", //$NON-NLS-1$
					DatawebElementTypes.RedSocial_2015);
		case FuenteRSSEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.unex.es/dmss/dataweb?FuenteRSS", //$NON-NLS-1$
					DatawebElementTypes.FuenteRSS_2016);
		case AtributoEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.unex.es/dmss/dataweb?Atributo", //$NON-NLS-1$
					DatawebElementTypes.Atributo_3001);
		case PreguntaOpcionMultipleEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.unex.es/dmss/dataweb?PreguntaOpcionMultiple", //$NON-NLS-1$
					DatawebElementTypes.PreguntaOpcionMultiple_3002);
		case OpcionRespuestaEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.unex.es/dmss/dataweb?OpcionRespuesta", //$NON-NLS-1$
					DatawebElementTypes.OpcionRespuesta_3003);
		case PreguntaVerdaderoFalsoEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.unex.es/dmss/dataweb?PreguntaVerdaderoFalso", //$NON-NLS-1$
					DatawebElementTypes.PreguntaVerdaderoFalso_3004);
		case PreguntaRespuestaCortaEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.unex.es/dmss/dataweb?PreguntaRespuestaCorta", //$NON-NLS-1$
					DatawebElementTypes.PreguntaRespuestaCorta_3005);
		case PreguntaOpcionMultiple2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.unex.es/dmss/dataweb?PreguntaOpcionMultiple", //$NON-NLS-1$
					DatawebElementTypes.PreguntaOpcionMultiple_3006);
		case PreguntaVerdaderoFalso2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.unex.es/dmss/dataweb?PreguntaVerdaderoFalso", //$NON-NLS-1$
					DatawebElementTypes.PreguntaVerdaderoFalso_3007);
		case PreguntaRespuestaCorta2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.unex.es/dmss/dataweb?PreguntaRespuestaCorta", //$NON-NLS-1$
					DatawebElementTypes.PreguntaRespuestaCorta_3008);
		case ReferenciaEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.unex.es/dmss/dataweb?Referencia", //$NON-NLS-1$
					DatawebElementTypes.Referencia_4001);
		case PaginaEnlacesEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.unex.es/dmss/dataweb?Pagina?enlaces", //$NON-NLS-1$
					DatawebElementTypes.PaginaEnlaces_4002);
		case PaginaRedesSocialesEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.unex.es/dmss/dataweb?Pagina?redesSociales", //$NON-NLS-1$
					DatawebElementTypes.PaginaRedesSociales_4003);
		case PaginaFuentesRSSEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.unex.es/dmss/dataweb?Pagina?fuentesRSS", //$NON-NLS-1$
					DatawebElementTypes.PaginaFuentesRSS_4004);
		case PaginaCRUDEntidadEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.unex.es/dmss/dataweb?PaginaCRUD?entidad", //$NON-NLS-1$
					DatawebElementTypes.PaginaCRUDEntidad_4005);
		case PaginaIndiceAtributosMostradosEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.unex.es/dmss/dataweb?PaginaIndice?atributosMostrados", //$NON-NLS-1$
					DatawebElementTypes.PaginaIndiceAtributosMostrados_4006);
		case PreguntaOpcionMultipleRespuestaCorrectaEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.unex.es/dmss/dataweb?PreguntaOpcionMultiple?respuestaCorrecta", //$NON-NLS-1$
					DatawebElementTypes.PreguntaOpcionMultipleRespuestaCorrecta_4007);
		case RolPaginasAccesiblesEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.unex.es/dmss/dataweb?Rol?paginasAccesibles", //$NON-NLS-1$
					DatawebElementTypes.RolPaginasAccesibles_4008);
		case PaginaIndiceFiltrosAtributosFiltroEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.unex.es/dmss/dataweb?PaginaIndiceFiltros?atributosFiltro", //$NON-NLS-1$
					DatawebElementTypes.PaginaIndiceFiltrosAtributosFiltro_4009);
		case PaginaIndicePaginadaFiltradaAtributosFiltroEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.unex.es/dmss/dataweb?PaginaIndicePaginadaFiltrada?atributosFiltro", //$NON-NLS-1$
					DatawebElementTypes.PaginaIndicePaginadaFiltradaAtributosFiltro_4010);
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = DatawebDiagramEditorPlugin.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null && DatawebElementTypes.isKnownElementType(elementType)) {
			image = DatawebElementTypes.getImage(elementType);
			imageRegistry.put(key, image);
		}

		if (image == null) {
			image = imageRegistry.get("Navigator?ImageNotFound"); //$NON-NLS-1$
			imageRegistry.put(key, image);
		}
		return image;
	}

	/**
	* @generated
	*/
	public String getText(Object element) {
		if (element instanceof DatawebNavigatorGroup) {
			DatawebNavigatorGroup group = (DatawebNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof DatawebNavigatorItem) {
			DatawebNavigatorItem navigatorItem = (DatawebNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return null;
			}
			return getText(navigatorItem.getView());
		}

		// Due to plugin.xml content will be called only for "own" views
		if (element instanceof IAdaptable) {
			View view = (View) ((IAdaptable) element).getAdapter(View.class);
			if (view != null && isOwnView(view)) {
				return getText(view);
			}
		}

		return super.getText(element);
	}

	/**
	* @generated
	*/
	public String getText(View view) {
		if (view.getElement() != null && view.getElement().eIsProxy()) {
			return getUnresolvedDomainElementProxyText(view);
		}
		switch (DatawebVisualIDRegistry.getVisualID(view)) {
		case AplicacionEditPart.VISUAL_ID:
			return getAplicacion_1000Text(view);
		case PaginaIndiceDetalleEditPart.VISUAL_ID:
			return getPaginaIndiceDetalle_2001Text(view);
		case PaginaIndicePaginadaEditPart.VISUAL_ID:
			return getPaginaIndicePaginada_2002Text(view);
		case PaginaIndiceFiltrosEditPart.VISUAL_ID:
			return getPaginaIndiceFiltros_2003Text(view);
		case PaginaIndicePaginadaFiltradaEditPart.VISUAL_ID:
			return getPaginaIndicePaginadaFiltrada_2004Text(view);
		case PaginaDetalleEditPart.VISUAL_ID:
			return getPaginaDetalle_2005Text(view);
		case PaginaCreacionEditPart.VISUAL_ID:
			return getPaginaCreacion_2006Text(view);
		case PaginaActualizacionEditPart.VISUAL_ID:
			return getPaginaActualizacion_2007Text(view);
		case PaginaBorradoEditPart.VISUAL_ID:
			return getPaginaBorrado_2008Text(view);
		case PaginaHomeEditPart.VISUAL_ID:
			return getPaginaHome_2009Text(view);
		case PaginaContenidoEditPart.VISUAL_ID:
			return getPaginaContenido_2010Text(view);
		case EntidadEditPart.VISUAL_ID:
			return getEntidad_2011Text(view);
		case RolEditPart.VISUAL_ID:
			return getRol_2012Text(view);
		case CuestionarioEditPart.VISUAL_ID:
			return getCuestionario_2013Text(view);
		case EncuestaEditPart.VISUAL_ID:
			return getEncuesta_2014Text(view);
		case RedSocialEditPart.VISUAL_ID:
			return getRedSocial_2015Text(view);
		case FuenteRSSEditPart.VISUAL_ID:
			return getFuenteRSS_2016Text(view);
		case AtributoEditPart.VISUAL_ID:
			return getAtributo_3001Text(view);
		case PreguntaOpcionMultipleEditPart.VISUAL_ID:
			return getPreguntaOpcionMultiple_3002Text(view);
		case OpcionRespuestaEditPart.VISUAL_ID:
			return getOpcionRespuesta_3003Text(view);
		case PreguntaVerdaderoFalsoEditPart.VISUAL_ID:
			return getPreguntaVerdaderoFalso_3004Text(view);
		case PreguntaRespuestaCortaEditPart.VISUAL_ID:
			return getPreguntaRespuestaCorta_3005Text(view);
		case PreguntaOpcionMultiple2EditPart.VISUAL_ID:
			return getPreguntaOpcionMultiple_3006Text(view);
		case PreguntaVerdaderoFalso2EditPart.VISUAL_ID:
			return getPreguntaVerdaderoFalso_3007Text(view);
		case PreguntaRespuestaCorta2EditPart.VISUAL_ID:
			return getPreguntaRespuestaCorta_3008Text(view);
		case ReferenciaEditPart.VISUAL_ID:
			return getReferencia_4001Text(view);
		case PaginaEnlacesEditPart.VISUAL_ID:
			return getPaginaEnlaces_4002Text(view);
		case PaginaRedesSocialesEditPart.VISUAL_ID:
			return getPaginaRedesSociales_4003Text(view);
		case PaginaFuentesRSSEditPart.VISUAL_ID:
			return getPaginaFuentesRSS_4004Text(view);
		case PaginaCRUDEntidadEditPart.VISUAL_ID:
			return getPaginaCRUDEntidad_4005Text(view);
		case PaginaIndiceAtributosMostradosEditPart.VISUAL_ID:
			return getPaginaIndiceAtributosMostrados_4006Text(view);
		case PreguntaOpcionMultipleRespuestaCorrectaEditPart.VISUAL_ID:
			return getPreguntaOpcionMultipleRespuestaCorrecta_4007Text(view);
		case RolPaginasAccesiblesEditPart.VISUAL_ID:
			return getRolPaginasAccesibles_4008Text(view);
		case PaginaIndiceFiltrosAtributosFiltroEditPart.VISUAL_ID:
			return getPaginaIndiceFiltrosAtributosFiltro_4009Text(view);
		case PaginaIndicePaginadaFiltradaAtributosFiltroEditPart.VISUAL_ID:
			return getPaginaIndicePaginadaFiltradaAtributosFiltro_4010Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	* @generated
	*/
	private String getAplicacion_1000Text(View view) {
		Aplicacion domainModelElement = (Aplicacion) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getNombre();
		} else {
			DatawebDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 1000); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getPaginaIndiceDetalle_2001Text(View view) {
		IParser parser = DatawebParserProvider.getParser(DatawebElementTypes.PaginaIndiceDetalle_2001,
				view.getElement() != null ? view.getElement() : view,
				DatawebVisualIDRegistry.getType(PaginaIndiceDetalleNombreEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			DatawebDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getPaginaIndicePaginada_2002Text(View view) {
		IParser parser = DatawebParserProvider.getParser(DatawebElementTypes.PaginaIndicePaginada_2002,
				view.getElement() != null ? view.getElement() : view,
				DatawebVisualIDRegistry.getType(PaginaIndicePaginadaNombreEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			DatawebDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getPaginaIndiceFiltros_2003Text(View view) {
		IParser parser = DatawebParserProvider.getParser(DatawebElementTypes.PaginaIndiceFiltros_2003,
				view.getElement() != null ? view.getElement() : view,
				DatawebVisualIDRegistry.getType(PaginaIndiceFiltrosNombreEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			DatawebDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getPaginaIndicePaginadaFiltrada_2004Text(View view) {
		IParser parser = DatawebParserProvider.getParser(DatawebElementTypes.PaginaIndicePaginadaFiltrada_2004,
				view.getElement() != null ? view.getElement() : view,
				DatawebVisualIDRegistry.getType(PaginaIndicePaginadaFiltradaNombreEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			DatawebDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getPaginaDetalle_2005Text(View view) {
		IParser parser = DatawebParserProvider.getParser(DatawebElementTypes.PaginaDetalle_2005,
				view.getElement() != null ? view.getElement() : view,
				DatawebVisualIDRegistry.getType(PaginaDetalleNombreEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			DatawebDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5005); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getPaginaCreacion_2006Text(View view) {
		IParser parser = DatawebParserProvider.getParser(DatawebElementTypes.PaginaCreacion_2006,
				view.getElement() != null ? view.getElement() : view,
				DatawebVisualIDRegistry.getType(PaginaCreacionNombreEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			DatawebDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5006); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getPaginaActualizacion_2007Text(View view) {
		IParser parser = DatawebParserProvider.getParser(DatawebElementTypes.PaginaActualizacion_2007,
				view.getElement() != null ? view.getElement() : view,
				DatawebVisualIDRegistry.getType(PaginaActualizacionNombreEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			DatawebDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5007); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getPaginaBorrado_2008Text(View view) {
		IParser parser = DatawebParserProvider.getParser(DatawebElementTypes.PaginaBorrado_2008,
				view.getElement() != null ? view.getElement() : view,
				DatawebVisualIDRegistry.getType(PaginaBorradoNombreEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			DatawebDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5008); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getPaginaHome_2009Text(View view) {
		IParser parser = DatawebParserProvider.getParser(DatawebElementTypes.PaginaHome_2009,
				view.getElement() != null ? view.getElement() : view,
				DatawebVisualIDRegistry.getType(PaginaHomeNombreEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			DatawebDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5009); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getPaginaContenido_2010Text(View view) {
		IParser parser = DatawebParserProvider.getParser(DatawebElementTypes.PaginaContenido_2010,
				view.getElement() != null ? view.getElement() : view,
				DatawebVisualIDRegistry.getType(PaginaContenidoNombreEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			DatawebDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5010); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getEntidad_2011Text(View view) {
		IParser parser = DatawebParserProvider.getParser(DatawebElementTypes.Entidad_2011,
				view.getElement() != null ? view.getElement() : view,
				DatawebVisualIDRegistry.getType(EntidadNombreEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			DatawebDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5012); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getRol_2012Text(View view) {
		IParser parser = DatawebParserProvider.getParser(DatawebElementTypes.Rol_2012,
				view.getElement() != null ? view.getElement() : view,
				DatawebVisualIDRegistry.getType(RolNombreEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			DatawebDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5013); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getCuestionario_2013Text(View view) {
		IParser parser = DatawebParserProvider.getParser(DatawebElementTypes.Cuestionario_2013,
				view.getElement() != null ? view.getElement() : view,
				DatawebVisualIDRegistry.getType(CuestionarioNombreEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			DatawebDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5018); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getEncuesta_2014Text(View view) {
		IParser parser = DatawebParserProvider.getParser(DatawebElementTypes.Encuesta_2014,
				view.getElement() != null ? view.getElement() : view,
				DatawebVisualIDRegistry.getType(EncuestaNombreEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			DatawebDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5022); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getRedSocial_2015Text(View view) {
		IParser parser = DatawebParserProvider.getParser(DatawebElementTypes.RedSocial_2015,
				view.getElement() != null ? view.getElement() : view,
				DatawebVisualIDRegistry.getType(RedSocialNombreEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			DatawebDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5023); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getFuenteRSS_2016Text(View view) {
		IParser parser = DatawebParserProvider.getParser(DatawebElementTypes.FuenteRSS_2016,
				view.getElement() != null ? view.getElement() : view,
				DatawebVisualIDRegistry.getType(FuenteRSSNombreEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			DatawebDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5024); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getAtributo_3001Text(View view) {
		IParser parser = DatawebParserProvider.getParser(DatawebElementTypes.Atributo_3001,
				view.getElement() != null ? view.getElement() : view,
				DatawebVisualIDRegistry.getType(AtributoNombreEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			DatawebDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5011); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getPreguntaOpcionMultiple_3002Text(View view) {
		IParser parser = DatawebParserProvider.getParser(DatawebElementTypes.PreguntaOpcionMultiple_3002,
				view.getElement() != null ? view.getElement() : view,
				DatawebVisualIDRegistry.getType(PreguntaOpcionMultipleNombreEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			DatawebDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5015); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getOpcionRespuesta_3003Text(View view) {
		IParser parser = DatawebParserProvider.getParser(DatawebElementTypes.OpcionRespuesta_3003,
				view.getElement() != null ? view.getElement() : view,
				DatawebVisualIDRegistry.getType(OpcionRespuestaNombreEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			DatawebDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5014); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getPreguntaVerdaderoFalso_3004Text(View view) {
		IParser parser = DatawebParserProvider.getParser(DatawebElementTypes.PreguntaVerdaderoFalso_3004,
				view.getElement() != null ? view.getElement() : view,
				DatawebVisualIDRegistry.getType(PreguntaVerdaderoFalsoNombreEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			DatawebDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5016); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getPreguntaRespuestaCorta_3005Text(View view) {
		IParser parser = DatawebParserProvider.getParser(DatawebElementTypes.PreguntaRespuestaCorta_3005,
				view.getElement() != null ? view.getElement() : view,
				DatawebVisualIDRegistry.getType(PreguntaRespuestaCortaNombreEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			DatawebDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5017); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getPreguntaOpcionMultiple_3006Text(View view) {
		IParser parser = DatawebParserProvider.getParser(DatawebElementTypes.PreguntaOpcionMultiple_3006,
				view.getElement() != null ? view.getElement() : view,
				DatawebVisualIDRegistry.getType(PreguntaOpcionMultipleNombre2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			DatawebDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5019); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getPreguntaVerdaderoFalso_3007Text(View view) {
		IParser parser = DatawebParserProvider.getParser(DatawebElementTypes.PreguntaVerdaderoFalso_3007,
				view.getElement() != null ? view.getElement() : view,
				DatawebVisualIDRegistry.getType(PreguntaVerdaderoFalsoNombre2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			DatawebDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5020); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getPreguntaRespuestaCorta_3008Text(View view) {
		IParser parser = DatawebParserProvider.getParser(DatawebElementTypes.PreguntaRespuestaCorta_3008,
				view.getElement() != null ? view.getElement() : view,
				DatawebVisualIDRegistry.getType(PreguntaRespuestaCortaNombre2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			DatawebDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5021); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getReferencia_4001Text(View view) {
		IParser parser = DatawebParserProvider.getParser(DatawebElementTypes.Referencia_4001,
				view.getElement() != null ? view.getElement() : view,
				DatawebVisualIDRegistry.getType(ReferenciaNombreEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			DatawebDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getPaginaEnlaces_4002Text(View view) {
		IParser parser = DatawebParserProvider.getParser(DatawebElementTypes.PaginaEnlaces_4002,
				view.getElement() != null ? view.getElement() : view, CommonParserHint.DESCRIPTION);
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			DatawebDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getPaginaRedesSociales_4003Text(View view) {
		IParser parser = DatawebParserProvider.getParser(DatawebElementTypes.PaginaRedesSociales_4003,
				view.getElement() != null ? view.getElement() : view, CommonParserHint.DESCRIPTION);
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			DatawebDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getPaginaFuentesRSS_4004Text(View view) {
		IParser parser = DatawebParserProvider.getParser(DatawebElementTypes.PaginaFuentesRSS_4004,
				view.getElement() != null ? view.getElement() : view, CommonParserHint.DESCRIPTION);
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			DatawebDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getPaginaCRUDEntidad_4005Text(View view) {
		IParser parser = DatawebParserProvider.getParser(DatawebElementTypes.PaginaCRUDEntidad_4005,
				view.getElement() != null ? view.getElement() : view, CommonParserHint.DESCRIPTION);
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			DatawebDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6005); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getPaginaIndiceAtributosMostrados_4006Text(View view) {
		IParser parser = DatawebParserProvider.getParser(DatawebElementTypes.PaginaIndiceAtributosMostrados_4006,
				view.getElement() != null ? view.getElement() : view, CommonParserHint.DESCRIPTION);
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			DatawebDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6006); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getPreguntaOpcionMultipleRespuestaCorrecta_4007Text(View view) {
		IParser parser = DatawebParserProvider.getParser(
				DatawebElementTypes.PreguntaOpcionMultipleRespuestaCorrecta_4007,
				view.getElement() != null ? view.getElement() : view, CommonParserHint.DESCRIPTION);
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			DatawebDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6007); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getRolPaginasAccesibles_4008Text(View view) {
		IParser parser = DatawebParserProvider.getParser(DatawebElementTypes.RolPaginasAccesibles_4008,
				view.getElement() != null ? view.getElement() : view, CommonParserHint.DESCRIPTION);
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			DatawebDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6008); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getPaginaIndiceFiltrosAtributosFiltro_4009Text(View view) {
		IParser parser = DatawebParserProvider.getParser(DatawebElementTypes.PaginaIndiceFiltrosAtributosFiltro_4009,
				view.getElement() != null ? view.getElement() : view, CommonParserHint.DESCRIPTION);
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			DatawebDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6009); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getPaginaIndicePaginadaFiltradaAtributosFiltro_4010Text(View view) {
		IParser parser = DatawebParserProvider.getParser(
				DatawebElementTypes.PaginaIndicePaginadaFiltradaAtributosFiltro_4010,
				view.getElement() != null ? view.getElement() : view, CommonParserHint.DESCRIPTION);
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			DatawebDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6010); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getUnknownElementText(View view) {
		return "<UnknownElement Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	* @generated
	*/
	private String getUnresolvedDomainElementProxyText(View view) {
		return "<Unresolved domain element Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	* @generated
	*/
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	* @generated
	*/
	public void restoreState(IMemento aMemento) {
	}

	/**
	* @generated
	*/
	public void saveState(IMemento aMemento) {
	}

	/**
	* @generated
	*/
	public String getDescription(Object anElement) {
		return null;
	}

	/**
	* @generated
	*/
	private boolean isOwnView(View view) {
		return AplicacionEditPart.MODEL_ID.equals(DatawebVisualIDRegistry.getModelID(view));
	}

}
