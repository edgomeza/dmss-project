/*
 * 
 */
package dataweb.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import dataweb.diagram.edit.parts.FuenteRSSEditPart;
import dataweb.diagram.providers.DatawebElementTypes;
import dataweb.diagram.providers.DatawebModelingAssistantProvider;

/**
 * @generated
 */
public class DatawebModelingAssistantProviderOfFuenteRSSEditPart extends DatawebModelingAssistantProvider {

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnTarget((FuenteRSSEditPart) targetEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnTarget(FuenteRSSEditPart target) {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(DatawebElementTypes.PaginaFuentesRSS_4004);
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getTypesForSource(IAdaptable target, IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForSource((FuenteRSSEditPart) targetEditPart, relationshipType);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetTypesForSource(FuenteRSSEditPart target, IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == DatawebElementTypes.PaginaFuentesRSS_4004) {
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
