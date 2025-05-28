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
import dataweb.diagram.edit.parts.RolEditPart;
import dataweb.diagram.providers.DatawebElementTypes;
import dataweb.diagram.providers.DatawebModelingAssistantProvider;

/**
 * @generated
 */
public class DatawebModelingAssistantProviderOfRolEditPart extends DatawebModelingAssistantProvider {

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSource((RolEditPart) sourceEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnSource(RolEditPart source) {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(DatawebElementTypes.RolPaginasAccesibles_4008);
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSourceAndTarget((RolEditPart) sourceEditPart, targetEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnSourceAndTarget(RolEditPart source, IGraphicalEditPart targetEditPart) {
		List<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof PaginaIndiceDetalleEditPart) {
			types.add(DatawebElementTypes.RolPaginasAccesibles_4008);
		}
		if (targetEditPart instanceof PaginaIndicePaginadaEditPart) {
			types.add(DatawebElementTypes.RolPaginasAccesibles_4008);
		}
		if (targetEditPart instanceof PaginaIndiceFiltrosEditPart) {
			types.add(DatawebElementTypes.RolPaginasAccesibles_4008);
		}
		if (targetEditPart instanceof PaginaIndicePaginadaFiltradaEditPart) {
			types.add(DatawebElementTypes.RolPaginasAccesibles_4008);
		}
		if (targetEditPart instanceof PaginaDetalleEditPart) {
			types.add(DatawebElementTypes.RolPaginasAccesibles_4008);
		}
		if (targetEditPart instanceof PaginaCreacionEditPart) {
			types.add(DatawebElementTypes.RolPaginasAccesibles_4008);
		}
		if (targetEditPart instanceof PaginaActualizacionEditPart) {
			types.add(DatawebElementTypes.RolPaginasAccesibles_4008);
		}
		if (targetEditPart instanceof PaginaBorradoEditPart) {
			types.add(DatawebElementTypes.RolPaginasAccesibles_4008);
		}
		if (targetEditPart instanceof PaginaHomeEditPart) {
			types.add(DatawebElementTypes.RolPaginasAccesibles_4008);
		}
		if (targetEditPart instanceof PaginaContenidoEditPart) {
			types.add(DatawebElementTypes.RolPaginasAccesibles_4008);
		}
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getTypesForTarget(IAdaptable source, IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForTarget((RolEditPart) sourceEditPart, relationshipType);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetTypesForTarget(RolEditPart source, IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == DatawebElementTypes.RolPaginasAccesibles_4008) {
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
		}
		return types;
	}

}
