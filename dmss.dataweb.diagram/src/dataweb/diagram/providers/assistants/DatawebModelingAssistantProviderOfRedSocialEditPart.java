/*
 * 
 */
package dataweb.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import dataweb.diagram.edit.parts.RedSocialEditPart;
import dataweb.diagram.providers.DatawebElementTypes;
import dataweb.diagram.providers.DatawebModelingAssistantProvider;

/**
 * @generated
 */
public class DatawebModelingAssistantProviderOfRedSocialEditPart extends DatawebModelingAssistantProvider {

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnTarget((RedSocialEditPart) targetEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnTarget(RedSocialEditPart target) {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(DatawebElementTypes.PaginaRedesSociales_4003);
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getTypesForSource(IAdaptable target, IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForSource((RedSocialEditPart) targetEditPart, relationshipType);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetTypesForSource(RedSocialEditPart target, IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == DatawebElementTypes.PaginaRedesSociales_4003) {
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
