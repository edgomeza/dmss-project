/*
 * 
 */
package dataweb.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import dataweb.diagram.edit.parts.AtributoEditPart;
import dataweb.diagram.providers.DatawebElementTypes;
import dataweb.diagram.providers.DatawebModelingAssistantProvider;

/**
 * @generated
 */
public class DatawebModelingAssistantProviderOfAtributoEditPart extends DatawebModelingAssistantProvider {

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnTarget((AtributoEditPart) targetEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnTarget(AtributoEditPart target) {
		List<IElementType> types = new ArrayList<IElementType>(3);
		types.add(DatawebElementTypes.PaginaIndiceAtributosMostrados_4006);
		types.add(DatawebElementTypes.PaginaIndiceFiltrosAtributosFiltro_4009);
		types.add(DatawebElementTypes.PaginaIndicePaginadaFiltradaAtributosFiltro_4010);
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getTypesForSource(IAdaptable target, IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForSource((AtributoEditPart) targetEditPart, relationshipType);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetTypesForSource(AtributoEditPart target, IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == DatawebElementTypes.PaginaIndiceAtributosMostrados_4006) {
			types.add(DatawebElementTypes.PaginaIndiceDetalle_2001);
			types.add(DatawebElementTypes.PaginaIndicePaginada_2002);
			types.add(DatawebElementTypes.PaginaIndiceFiltros_2003);
			types.add(DatawebElementTypes.PaginaIndicePaginadaFiltrada_2004);
		} else if (relationshipType == DatawebElementTypes.PaginaIndiceFiltrosAtributosFiltro_4009) {
			types.add(DatawebElementTypes.PaginaIndiceFiltros_2003);
		} else if (relationshipType == DatawebElementTypes.PaginaIndicePaginadaFiltradaAtributosFiltro_4010) {
			types.add(DatawebElementTypes.PaginaIndicePaginadaFiltrada_2004);
		}
		return types;
	}

}
