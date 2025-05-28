/*
 * 
 */
package dataweb.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import dataweb.diagram.edit.parts.EntidadEditPart;
import dataweb.diagram.edit.parts.FuenteRSSEditPart;
import dataweb.diagram.edit.parts.PaginaActualizacionEditPart;
import dataweb.diagram.edit.parts.PaginaBorradoEditPart;
import dataweb.diagram.edit.parts.PaginaContenidoEditPart;
import dataweb.diagram.edit.parts.PaginaCreacionEditPart;
import dataweb.diagram.edit.parts.PaginaDetalleEditPart;
import dataweb.diagram.edit.parts.PaginaHomeEditPart;
import dataweb.diagram.edit.parts.PaginaIndiceDetalleEditPart;
import dataweb.diagram.edit.parts.PaginaIndiceFiltrosEditPart;
import dataweb.diagram.edit.parts.PaginaIndicePaginadaEditPart;
import dataweb.diagram.edit.parts.PaginaIndicePaginadaFiltradaEditPart;
import dataweb.diagram.edit.parts.RedSocialEditPart;
import dataweb.diagram.providers.DatawebElementTypes;
import dataweb.diagram.providers.DatawebModelingAssistantProvider;

/**
 * @generated
 */
public class DatawebModelingAssistantProviderOfPaginaDetalleEditPart extends DatawebModelingAssistantProvider {

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSource((PaginaDetalleEditPart) sourceEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnSource(PaginaDetalleEditPart source) {
		List<IElementType> types = new ArrayList<IElementType>(4);
		types.add(DatawebElementTypes.PaginaEnlaces_4002);
		types.add(DatawebElementTypes.PaginaRedesSociales_4003);
		types.add(DatawebElementTypes.PaginaFuentesRSS_4004);
		types.add(DatawebElementTypes.PaginaCRUDEntidad_4005);
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSourceAndTarget((PaginaDetalleEditPart) sourceEditPart, targetEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnSourceAndTarget(PaginaDetalleEditPart source,
			IGraphicalEditPart targetEditPart) {
		List<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof PaginaIndiceDetalleEditPart) {
			types.add(DatawebElementTypes.PaginaEnlaces_4002);
		}
		if (targetEditPart instanceof PaginaIndicePaginadaEditPart) {
			types.add(DatawebElementTypes.PaginaEnlaces_4002);
		}
		if (targetEditPart instanceof PaginaIndiceFiltrosEditPart) {
			types.add(DatawebElementTypes.PaginaEnlaces_4002);
		}
		if (targetEditPart instanceof PaginaIndicePaginadaFiltradaEditPart) {
			types.add(DatawebElementTypes.PaginaEnlaces_4002);
		}
		if (targetEditPart instanceof PaginaDetalleEditPart) {
			types.add(DatawebElementTypes.PaginaEnlaces_4002);
		}
		if (targetEditPart instanceof PaginaCreacionEditPart) {
			types.add(DatawebElementTypes.PaginaEnlaces_4002);
		}
		if (targetEditPart instanceof PaginaActualizacionEditPart) {
			types.add(DatawebElementTypes.PaginaEnlaces_4002);
		}
		if (targetEditPart instanceof PaginaBorradoEditPart) {
			types.add(DatawebElementTypes.PaginaEnlaces_4002);
		}
		if (targetEditPart instanceof PaginaHomeEditPart) {
			types.add(DatawebElementTypes.PaginaEnlaces_4002);
		}
		if (targetEditPart instanceof PaginaContenidoEditPart) {
			types.add(DatawebElementTypes.PaginaEnlaces_4002);
		}
		if (targetEditPart instanceof RedSocialEditPart) {
			types.add(DatawebElementTypes.PaginaRedesSociales_4003);
		}
		if (targetEditPart instanceof FuenteRSSEditPart) {
			types.add(DatawebElementTypes.PaginaFuentesRSS_4004);
		}
		if (targetEditPart instanceof EntidadEditPart) {
			types.add(DatawebElementTypes.PaginaCRUDEntidad_4005);
		}
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getTypesForTarget(IAdaptable source, IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForTarget((PaginaDetalleEditPart) sourceEditPart, relationshipType);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetTypesForTarget(PaginaDetalleEditPart source, IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == DatawebElementTypes.PaginaEnlaces_4002) {
			types.add(DatawebElementTypes.PaginaIndiceDetalle_2001);
			types.add(DatawebElementTypes.PaginaIndicePaginada_2002);
			types.add(DatawebElementTypes.PaginaIndiceFiltros_2003);
			types.add(DatawebElementTypes.PaginaIndicePaginadaFiltrada_2004);
			types.add(DatawebElementTypes.PaginaDetalle_2005);
			types.add(DatawebElementTypes.PaginaCreacion_2006);
			types.add(DatawebElementTypes.PaginaActualizacion_2007);
			types.add(DatawebElementTypes.PaginaBorrado_2008);
			types.add(DatawebElementTypes.PaginaHome_2009);
			types.add(DatawebElementTypes.PaginaContenido_2010);
		} else if (relationshipType == DatawebElementTypes.PaginaRedesSociales_4003) {
			types.add(DatawebElementTypes.RedSocial_2015);
		} else if (relationshipType == DatawebElementTypes.PaginaFuentesRSS_4004) {
			types.add(DatawebElementTypes.FuenteRSS_2016);
		} else if (relationshipType == DatawebElementTypes.PaginaCRUDEntidad_4005) {
			types.add(DatawebElementTypes.Entidad_2011);
		}
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnTarget((PaginaDetalleEditPart) targetEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnTarget(PaginaDetalleEditPart target) {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(DatawebElementTypes.PaginaEnlaces_4002);
		types.add(DatawebElementTypes.RolPaginasAccesibles_4008);
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getTypesForSource(IAdaptable target, IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForSource((PaginaDetalleEditPart) targetEditPart, relationshipType);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetTypesForSource(PaginaDetalleEditPart target, IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == DatawebElementTypes.PaginaEnlaces_4002) {
			types.add(DatawebElementTypes.PaginaIndiceDetalle_2001);
			types.add(DatawebElementTypes.PaginaIndicePaginada_2002);
			types.add(DatawebElementTypes.PaginaIndiceFiltros_2003);
			types.add(DatawebElementTypes.PaginaIndicePaginadaFiltrada_2004);
			types.add(DatawebElementTypes.PaginaDetalle_2005);
			types.add(DatawebElementTypes.PaginaCreacion_2006);
			types.add(DatawebElementTypes.PaginaActualizacion_2007);
			types.add(DatawebElementTypes.PaginaBorrado_2008);
			types.add(DatawebElementTypes.PaginaHome_2009);
			types.add(DatawebElementTypes.PaginaContenido_2010);
		} else if (relationshipType == DatawebElementTypes.RolPaginasAccesibles_4008) {
			types.add(DatawebElementTypes.Rol_2012);
		}
		return types;
	}

}
