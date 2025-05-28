
/*
 * 
 */
package dataweb.diagram.part;

import java.util.ArrayList;
import java.util.Collections;

import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.tooling.runtime.part.DefaultLinkToolEntry;
import org.eclipse.gmf.tooling.runtime.part.DefaultNodeToolEntry;

import dataweb.diagram.providers.DatawebElementTypes;

/**
 * @generated
 */
public class DatawebPaletteFactory {

	/**
	* @generated
	*/
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createObjects1Group());
		paletteRoot.add(createConnections2Group());
	}

	/**
	* Creates "Objects" palette tool group
	* @generated
	*/
	private PaletteContainer createObjects1Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(Messages.Objects1Group_title);
		paletteContainer.setId("createObjects1Group"); //$NON-NLS-1$
		paletteContainer.add(createAtributo1CreationTool());
		paletteContainer.add(createCuestionario2CreationTool());
		paletteContainer.add(createEncuesta3CreationTool());
		paletteContainer.add(createEntidad4CreationTool());
		paletteContainer.add(createFuenteRSS5CreationTool());
		paletteContainer.add(createOpcionRespuesta6CreationTool());
		paletteContainer.add(createPaginaActualizacion7CreationTool());
		paletteContainer.add(createPaginaBorrado8CreationTool());
		paletteContainer.add(createPaginaContenido9CreationTool());
		paletteContainer.add(createPaginaCreacion10CreationTool());
		paletteContainer.add(createPaginaDetalle11CreationTool());
		paletteContainer.add(createPaginaHome12CreationTool());
		paletteContainer.add(createPaginaIndiceDetalle13CreationTool());
		paletteContainer.add(createPaginaIndiceFiltros14CreationTool());
		paletteContainer.add(createPaginaIndicePaginada15CreationTool());
		paletteContainer.add(createPaginaIndicePaginadaFiltrada16CreationTool());
		paletteContainer.add(createPreguntaOpcionMultiple17CreationTool());
		paletteContainer.add(createPreguntaRespuestaCorta18CreationTool());
		paletteContainer.add(createPreguntaVerdaderoFalso19CreationTool());
		paletteContainer.add(createRedSocial20CreationTool());
		paletteContainer.add(createRol21CreationTool());
		return paletteContainer;
	}

	/**
	* Creates "Connections" palette tool group
	* @generated
	*/
	private PaletteContainer createConnections2Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(Messages.Connections2Group_title);
		paletteContainer.setId("createConnections2Group"); //$NON-NLS-1$
		paletteContainer.add(createAtributosFiltro1CreationTool());
		paletteContainer.add(createAtributosFiltro2CreationTool());
		paletteContainer.add(createAtributosMostrados3CreationTool());
		paletteContainer.add(createEnlaces4CreationTool());
		paletteContainer.add(createEntidad5CreationTool());
		paletteContainer.add(createFuentesRSS6CreationTool());
		paletteContainer.add(createPaginasAccesibles7CreationTool());
		paletteContainer.add(createRedesSociales8CreationTool());
		paletteContainer.add(createReferencia9CreationTool());
		paletteContainer.add(createRespuestaCorrecta10CreationTool());
		return paletteContainer;
	}

	/**
	* @generated
	*/
	private ToolEntry createAtributo1CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.Atributo1CreationTool_title,
				Messages.Atributo1CreationTool_desc, Collections.singletonList(DatawebElementTypes.Atributo_3001));
		entry.setId("createAtributo1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(DatawebElementTypes.getImageDescriptor(DatawebElementTypes.Atributo_3001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createCuestionario2CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.Cuestionario2CreationTool_title,
				Messages.Cuestionario2CreationTool_desc,
				Collections.singletonList(DatawebElementTypes.Cuestionario_2013));
		entry.setId("createCuestionario2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(DatawebElementTypes.getImageDescriptor(DatawebElementTypes.Cuestionario_2013));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createEncuesta3CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.Encuesta3CreationTool_title,
				Messages.Encuesta3CreationTool_desc, Collections.singletonList(DatawebElementTypes.Encuesta_2014));
		entry.setId("createEncuesta3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(DatawebElementTypes.getImageDescriptor(DatawebElementTypes.Encuesta_2014));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createEntidad4CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.Entidad4CreationTool_title,
				Messages.Entidad4CreationTool_desc, Collections.singletonList(DatawebElementTypes.Entidad_2011));
		entry.setId("createEntidad4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(DatawebElementTypes.getImageDescriptor(DatawebElementTypes.Entidad_2011));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createFuenteRSS5CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.FuenteRSS5CreationTool_title,
				Messages.FuenteRSS5CreationTool_desc, Collections.singletonList(DatawebElementTypes.FuenteRSS_2016));
		entry.setId("createFuenteRSS5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(DatawebElementTypes.getImageDescriptor(DatawebElementTypes.FuenteRSS_2016));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createOpcionRespuesta6CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.OpcionRespuesta6CreationTool_title,
				Messages.OpcionRespuesta6CreationTool_desc,
				Collections.singletonList(DatawebElementTypes.OpcionRespuesta_3003));
		entry.setId("createOpcionRespuesta6CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(DatawebElementTypes.getImageDescriptor(DatawebElementTypes.OpcionRespuesta_3003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createPaginaActualizacion7CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.PaginaActualizacion7CreationTool_title,
				Messages.PaginaActualizacion7CreationTool_desc,
				Collections.singletonList(DatawebElementTypes.PaginaActualizacion_2007));
		entry.setId("createPaginaActualizacion7CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(DatawebElementTypes.getImageDescriptor(DatawebElementTypes.PaginaActualizacion_2007));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createPaginaBorrado8CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.PaginaBorrado8CreationTool_title,
				Messages.PaginaBorrado8CreationTool_desc,
				Collections.singletonList(DatawebElementTypes.PaginaBorrado_2008));
		entry.setId("createPaginaBorrado8CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(DatawebElementTypes.getImageDescriptor(DatawebElementTypes.PaginaBorrado_2008));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createPaginaContenido9CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.PaginaContenido9CreationTool_title,
				Messages.PaginaContenido9CreationTool_desc,
				Collections.singletonList(DatawebElementTypes.PaginaContenido_2010));
		entry.setId("createPaginaContenido9CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(DatawebElementTypes.getImageDescriptor(DatawebElementTypes.PaginaContenido_2010));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createPaginaCreacion10CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.PaginaCreacion10CreationTool_title,
				Messages.PaginaCreacion10CreationTool_desc,
				Collections.singletonList(DatawebElementTypes.PaginaCreacion_2006));
		entry.setId("createPaginaCreacion10CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(DatawebElementTypes.getImageDescriptor(DatawebElementTypes.PaginaCreacion_2006));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createPaginaDetalle11CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.PaginaDetalle11CreationTool_title,
				Messages.PaginaDetalle11CreationTool_desc,
				Collections.singletonList(DatawebElementTypes.PaginaDetalle_2005));
		entry.setId("createPaginaDetalle11CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(DatawebElementTypes.getImageDescriptor(DatawebElementTypes.PaginaDetalle_2005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createPaginaHome12CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.PaginaHome12CreationTool_title,
				Messages.PaginaHome12CreationTool_desc, Collections.singletonList(DatawebElementTypes.PaginaHome_2009));
		entry.setId("createPaginaHome12CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(DatawebElementTypes.getImageDescriptor(DatawebElementTypes.PaginaHome_2009));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createPaginaIndiceDetalle13CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.PaginaIndiceDetalle13CreationTool_title,
				Messages.PaginaIndiceDetalle13CreationTool_desc,
				Collections.singletonList(DatawebElementTypes.PaginaIndiceDetalle_2001));
		entry.setId("createPaginaIndiceDetalle13CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(DatawebElementTypes.getImageDescriptor(DatawebElementTypes.PaginaIndiceDetalle_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createPaginaIndiceFiltros14CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.PaginaIndiceFiltros14CreationTool_title,
				Messages.PaginaIndiceFiltros14CreationTool_desc,
				Collections.singletonList(DatawebElementTypes.PaginaIndiceFiltros_2003));
		entry.setId("createPaginaIndiceFiltros14CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(DatawebElementTypes.getImageDescriptor(DatawebElementTypes.PaginaIndiceFiltros_2003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createPaginaIndicePaginada15CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.PaginaIndicePaginada15CreationTool_title,
				Messages.PaginaIndicePaginada15CreationTool_desc,
				Collections.singletonList(DatawebElementTypes.PaginaIndicePaginada_2002));
		entry.setId("createPaginaIndicePaginada15CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(DatawebElementTypes.getImageDescriptor(DatawebElementTypes.PaginaIndicePaginada_2002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createPaginaIndicePaginadaFiltrada16CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.PaginaIndicePaginadaFiltrada16CreationTool_title,
				Messages.PaginaIndicePaginadaFiltrada16CreationTool_desc,
				Collections.singletonList(DatawebElementTypes.PaginaIndicePaginadaFiltrada_2004));
		entry.setId("createPaginaIndicePaginadaFiltrada16CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				DatawebElementTypes.getImageDescriptor(DatawebElementTypes.PaginaIndicePaginadaFiltrada_2004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createPreguntaOpcionMultiple17CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(DatawebElementTypes.PreguntaOpcionMultiple_3002);
		types.add(DatawebElementTypes.PreguntaOpcionMultiple_3006);
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.PreguntaOpcionMultiple17CreationTool_title,
				Messages.PreguntaOpcionMultiple17CreationTool_desc, types);
		entry.setId("createPreguntaOpcionMultiple17CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(DatawebElementTypes.getImageDescriptor(DatawebElementTypes.PreguntaOpcionMultiple_3002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createPreguntaRespuestaCorta18CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(DatawebElementTypes.PreguntaRespuestaCorta_3005);
		types.add(DatawebElementTypes.PreguntaRespuestaCorta_3008);
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.PreguntaRespuestaCorta18CreationTool_title,
				Messages.PreguntaRespuestaCorta18CreationTool_desc, types);
		entry.setId("createPreguntaRespuestaCorta18CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(DatawebElementTypes.getImageDescriptor(DatawebElementTypes.PreguntaRespuestaCorta_3005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createPreguntaVerdaderoFalso19CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(DatawebElementTypes.PreguntaVerdaderoFalso_3004);
		types.add(DatawebElementTypes.PreguntaVerdaderoFalso_3007);
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.PreguntaVerdaderoFalso19CreationTool_title,
				Messages.PreguntaVerdaderoFalso19CreationTool_desc, types);
		entry.setId("createPreguntaVerdaderoFalso19CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(DatawebElementTypes.getImageDescriptor(DatawebElementTypes.PreguntaVerdaderoFalso_3004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createRedSocial20CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.RedSocial20CreationTool_title,
				Messages.RedSocial20CreationTool_desc, Collections.singletonList(DatawebElementTypes.RedSocial_2015));
		entry.setId("createRedSocial20CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(DatawebElementTypes.getImageDescriptor(DatawebElementTypes.RedSocial_2015));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createRol21CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.Rol21CreationTool_title,
				Messages.Rol21CreationTool_desc, Collections.singletonList(DatawebElementTypes.Rol_2012));
		entry.setId("createRol21CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(DatawebElementTypes.getImageDescriptor(DatawebElementTypes.Rol_2012));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createAtributosFiltro1CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(Messages.AtributosFiltro1CreationTool_title,
				Messages.AtributosFiltro1CreationTool_desc,
				Collections.singletonList(DatawebElementTypes.PaginaIndiceFiltrosAtributosFiltro_4009));
		entry.setId("createAtributosFiltro1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				DatawebElementTypes.getImageDescriptor(DatawebElementTypes.PaginaIndiceFiltrosAtributosFiltro_4009));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createAtributosFiltro2CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(Messages.AtributosFiltro2CreationTool_title,
				Messages.AtributosFiltro2CreationTool_desc,
				Collections.singletonList(DatawebElementTypes.PaginaIndicePaginadaFiltradaAtributosFiltro_4010));
		entry.setId("createAtributosFiltro2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(DatawebElementTypes
				.getImageDescriptor(DatawebElementTypes.PaginaIndicePaginadaFiltradaAtributosFiltro_4010));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createAtributosMostrados3CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(Messages.AtributosMostrados3CreationTool_title,
				Messages.AtributosMostrados3CreationTool_desc,
				Collections.singletonList(DatawebElementTypes.PaginaIndiceAtributosMostrados_4006));
		entry.setId("createAtributosMostrados3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				DatawebElementTypes.getImageDescriptor(DatawebElementTypes.PaginaIndiceAtributosMostrados_4006));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createEnlaces4CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(Messages.Enlaces4CreationTool_title,
				Messages.Enlaces4CreationTool_desc, Collections.singletonList(DatawebElementTypes.PaginaEnlaces_4002));
		entry.setId("createEnlaces4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(DatawebElementTypes.getImageDescriptor(DatawebElementTypes.PaginaEnlaces_4002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createEntidad5CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(Messages.Entidad5CreationTool_title,
				Messages.Entidad5CreationTool_desc,
				Collections.singletonList(DatawebElementTypes.PaginaCRUDEntidad_4005));
		entry.setId("createEntidad5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(DatawebElementTypes.getImageDescriptor(DatawebElementTypes.PaginaCRUDEntidad_4005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createFuentesRSS6CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(Messages.FuentesRSS6CreationTool_title,
				Messages.FuentesRSS6CreationTool_desc,
				Collections.singletonList(DatawebElementTypes.PaginaFuentesRSS_4004));
		entry.setId("createFuentesRSS6CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(DatawebElementTypes.getImageDescriptor(DatawebElementTypes.PaginaFuentesRSS_4004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createPaginasAccesibles7CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(Messages.PaginasAccesibles7CreationTool_title,
				Messages.PaginasAccesibles7CreationTool_desc,
				Collections.singletonList(DatawebElementTypes.RolPaginasAccesibles_4008));
		entry.setId("createPaginasAccesibles7CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(DatawebElementTypes.getImageDescriptor(DatawebElementTypes.RolPaginasAccesibles_4008));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createRedesSociales8CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(Messages.RedesSociales8CreationTool_title,
				Messages.RedesSociales8CreationTool_desc,
				Collections.singletonList(DatawebElementTypes.PaginaRedesSociales_4003));
		entry.setId("createRedesSociales8CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(DatawebElementTypes.getImageDescriptor(DatawebElementTypes.PaginaRedesSociales_4003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createReferencia9CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(Messages.Referencia9CreationTool_title,
				Messages.Referencia9CreationTool_desc, Collections.singletonList(DatawebElementTypes.Referencia_4001));
		entry.setId("createReferencia9CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(DatawebElementTypes.getImageDescriptor(DatawebElementTypes.Referencia_4001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createRespuestaCorrecta10CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(Messages.RespuestaCorrecta10CreationTool_title,
				Messages.RespuestaCorrecta10CreationTool_desc,
				Collections.singletonList(DatawebElementTypes.PreguntaOpcionMultipleRespuestaCorrecta_4007));
		entry.setId("createRespuestaCorrecta10CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(DatawebElementTypes
				.getImageDescriptor(DatawebElementTypes.PreguntaOpcionMultipleRespuestaCorrecta_4007));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

}
