/*
 * 
 */
package dataweb.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import dataweb.diagram.providers.DatawebElementTypes;
import dataweb.diagram.providers.DatawebModelingAssistantProvider;

/**
 * @generated
 */
public class DatawebModelingAssistantProviderOfAplicacionEditPart extends DatawebModelingAssistantProvider {

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getTypesForPopupBar(IAdaptable host) {
		List<IElementType> types = new ArrayList<IElementType>(16);
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
		types.add(DatawebElementTypes.Entidad_2011);
		types.add(DatawebElementTypes.Rol_2012);
		types.add(DatawebElementTypes.Cuestionario_2013);
		types.add(DatawebElementTypes.Encuesta_2014);
		types.add(DatawebElementTypes.RedSocial_2015);
		types.add(DatawebElementTypes.FuenteRSS_2016);
		return types;
	}

}
