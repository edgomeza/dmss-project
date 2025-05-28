/*
 * 
 */
package dataweb.diagram.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypeImages;
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypes;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

import dataweb.DatawebPackage;
import dataweb.diagram.edit.parts.AplicacionEditPart;
import dataweb.diagram.edit.parts.AtributoEditPart;
import dataweb.diagram.edit.parts.CuestionarioEditPart;
import dataweb.diagram.edit.parts.EncuestaEditPart;
import dataweb.diagram.edit.parts.EntidadEditPart;
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
import dataweb.diagram.edit.parts.PreguntaOpcionMultipleRespuestaCorrectaEditPart;
import dataweb.diagram.edit.parts.PreguntaRespuestaCorta2EditPart;
import dataweb.diagram.edit.parts.PreguntaRespuestaCortaEditPart;
import dataweb.diagram.edit.parts.PreguntaVerdaderoFalso2EditPart;
import dataweb.diagram.edit.parts.PreguntaVerdaderoFalsoEditPart;
import dataweb.diagram.edit.parts.RedSocialEditPart;
import dataweb.diagram.edit.parts.ReferenciaEditPart;
import dataweb.diagram.edit.parts.RolEditPart;
import dataweb.diagram.edit.parts.RolPaginasAccesiblesEditPart;
import dataweb.diagram.part.DatawebDiagramEditorPlugin;

/**
 * @generated
 */
public class DatawebElementTypes {

	/**
	* @generated
	*/
	private DatawebElementTypes() {
	}

	/**
	* @generated
	*/
	private static Map<IElementType, ENamedElement> elements;

	/**
	* @generated
	*/
	private static DiagramElementTypeImages elementTypeImages = new DiagramElementTypeImages(
			DatawebDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory());

	/**
	* @generated
	*/
	private static Set<IElementType> KNOWN_ELEMENT_TYPES;

	/**
	* @generated
	*/
	public static final IElementType Aplicacion_1000 = getElementType("dmss.dataweb.diagram.Aplicacion_1000"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType PaginaIndiceDetalle_2001 = getElementType(
			"dmss.dataweb.diagram.PaginaIndiceDetalle_2001"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType PaginaIndicePaginada_2002 = getElementType(
			"dmss.dataweb.diagram.PaginaIndicePaginada_2002"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType PaginaIndiceFiltros_2003 = getElementType(
			"dmss.dataweb.diagram.PaginaIndiceFiltros_2003"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType PaginaIndicePaginadaFiltrada_2004 = getElementType(
			"dmss.dataweb.diagram.PaginaIndicePaginadaFiltrada_2004"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType PaginaDetalle_2005 = getElementType("dmss.dataweb.diagram.PaginaDetalle_2005"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType PaginaCreacion_2006 = getElementType("dmss.dataweb.diagram.PaginaCreacion_2006"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType PaginaActualizacion_2007 = getElementType(
			"dmss.dataweb.diagram.PaginaActualizacion_2007"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType PaginaBorrado_2008 = getElementType("dmss.dataweb.diagram.PaginaBorrado_2008"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType PaginaHome_2009 = getElementType("dmss.dataweb.diagram.PaginaHome_2009"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType PaginaContenido_2010 = getElementType("dmss.dataweb.diagram.PaginaContenido_2010"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Entidad_2011 = getElementType("dmss.dataweb.diagram.Entidad_2011"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Rol_2012 = getElementType("dmss.dataweb.diagram.Rol_2012"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Cuestionario_2013 = getElementType("dmss.dataweb.diagram.Cuestionario_2013"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Encuesta_2014 = getElementType("dmss.dataweb.diagram.Encuesta_2014"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType RedSocial_2015 = getElementType("dmss.dataweb.diagram.RedSocial_2015"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType FuenteRSS_2016 = getElementType("dmss.dataweb.diagram.FuenteRSS_2016"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Atributo_3001 = getElementType("dmss.dataweb.diagram.Atributo_3001"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType PreguntaOpcionMultiple_3002 = getElementType(
			"dmss.dataweb.diagram.PreguntaOpcionMultiple_3002"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType OpcionRespuesta_3003 = getElementType("dmss.dataweb.diagram.OpcionRespuesta_3003"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType PreguntaVerdaderoFalso_3004 = getElementType(
			"dmss.dataweb.diagram.PreguntaVerdaderoFalso_3004"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType PreguntaRespuestaCorta_3005 = getElementType(
			"dmss.dataweb.diagram.PreguntaRespuestaCorta_3005"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType PreguntaOpcionMultiple_3006 = getElementType(
			"dmss.dataweb.diagram.PreguntaOpcionMultiple_3006"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType PreguntaVerdaderoFalso_3007 = getElementType(
			"dmss.dataweb.diagram.PreguntaVerdaderoFalso_3007"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType PreguntaRespuestaCorta_3008 = getElementType(
			"dmss.dataweb.diagram.PreguntaRespuestaCorta_3008"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Referencia_4001 = getElementType("dmss.dataweb.diagram.Referencia_4001"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType PaginaEnlaces_4002 = getElementType("dmss.dataweb.diagram.PaginaEnlaces_4002"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType PaginaRedesSociales_4003 = getElementType(
			"dmss.dataweb.diagram.PaginaRedesSociales_4003"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType PaginaFuentesRSS_4004 = getElementType(
			"dmss.dataweb.diagram.PaginaFuentesRSS_4004"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType PaginaCRUDEntidad_4005 = getElementType(
			"dmss.dataweb.diagram.PaginaCRUDEntidad_4005"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType PaginaIndiceAtributosMostrados_4006 = getElementType(
			"dmss.dataweb.diagram.PaginaIndiceAtributosMostrados_4006"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType PreguntaOpcionMultipleRespuestaCorrecta_4007 = getElementType(
			"dmss.dataweb.diagram.PreguntaOpcionMultipleRespuestaCorrecta_4007"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType RolPaginasAccesibles_4008 = getElementType(
			"dmss.dataweb.diagram.RolPaginasAccesibles_4008"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType PaginaIndiceFiltrosAtributosFiltro_4009 = getElementType(
			"dmss.dataweb.diagram.PaginaIndiceFiltrosAtributosFiltro_4009"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType PaginaIndicePaginadaFiltradaAtributosFiltro_4010 = getElementType(
			"dmss.dataweb.diagram.PaginaIndicePaginadaFiltradaAtributosFiltro_4010"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static ImageDescriptor getImageDescriptor(ENamedElement element) {
		return elementTypeImages.getImageDescriptor(element);
	}

	/**
	* @generated
	*/
	public static Image getImage(ENamedElement element) {
		return elementTypeImages.getImage(element);
	}

	/**
	* @generated
	*/
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		return getImageDescriptor(getElement(hint));
	}

	/**
	* @generated
	*/
	public static Image getImage(IAdaptable hint) {
		return getImage(getElement(hint));
	}

	/**
	* Returns 'type' of the ecore object associated with the hint.
	* 
	* @generated
	*/
	public static ENamedElement getElement(IAdaptable hint) {
		Object type = hint.getAdapter(IElementType.class);
		if (elements == null) {
			elements = new IdentityHashMap<IElementType, ENamedElement>();

			elements.put(Aplicacion_1000, DatawebPackage.eINSTANCE.getAplicacion());

			elements.put(PaginaIndiceDetalle_2001, DatawebPackage.eINSTANCE.getPaginaIndiceDetalle());

			elements.put(PaginaIndicePaginada_2002, DatawebPackage.eINSTANCE.getPaginaIndicePaginada());

			elements.put(PaginaIndiceFiltros_2003, DatawebPackage.eINSTANCE.getPaginaIndiceFiltros());

			elements.put(PaginaIndicePaginadaFiltrada_2004, DatawebPackage.eINSTANCE.getPaginaIndicePaginadaFiltrada());

			elements.put(PaginaDetalle_2005, DatawebPackage.eINSTANCE.getPaginaDetalle());

			elements.put(PaginaCreacion_2006, DatawebPackage.eINSTANCE.getPaginaCreacion());

			elements.put(PaginaActualizacion_2007, DatawebPackage.eINSTANCE.getPaginaActualizacion());

			elements.put(PaginaBorrado_2008, DatawebPackage.eINSTANCE.getPaginaBorrado());

			elements.put(PaginaHome_2009, DatawebPackage.eINSTANCE.getPaginaHome());

			elements.put(PaginaContenido_2010, DatawebPackage.eINSTANCE.getPaginaContenido());

			elements.put(Entidad_2011, DatawebPackage.eINSTANCE.getEntidad());

			elements.put(Rol_2012, DatawebPackage.eINSTANCE.getRol());

			elements.put(Cuestionario_2013, DatawebPackage.eINSTANCE.getCuestionario());

			elements.put(Encuesta_2014, DatawebPackage.eINSTANCE.getEncuesta());

			elements.put(RedSocial_2015, DatawebPackage.eINSTANCE.getRedSocial());

			elements.put(FuenteRSS_2016, DatawebPackage.eINSTANCE.getFuenteRSS());

			elements.put(Atributo_3001, DatawebPackage.eINSTANCE.getAtributo());

			elements.put(PreguntaOpcionMultiple_3002, DatawebPackage.eINSTANCE.getPreguntaOpcionMultiple());

			elements.put(OpcionRespuesta_3003, DatawebPackage.eINSTANCE.getOpcionRespuesta());

			elements.put(PreguntaVerdaderoFalso_3004, DatawebPackage.eINSTANCE.getPreguntaVerdaderoFalso());

			elements.put(PreguntaRespuestaCorta_3005, DatawebPackage.eINSTANCE.getPreguntaRespuestaCorta());

			elements.put(PreguntaOpcionMultiple_3006, DatawebPackage.eINSTANCE.getPreguntaOpcionMultiple());

			elements.put(PreguntaVerdaderoFalso_3007, DatawebPackage.eINSTANCE.getPreguntaVerdaderoFalso());

			elements.put(PreguntaRespuestaCorta_3008, DatawebPackage.eINSTANCE.getPreguntaRespuestaCorta());

			elements.put(Referencia_4001, DatawebPackage.eINSTANCE.getReferencia());

			elements.put(PaginaEnlaces_4002, DatawebPackage.eINSTANCE.getPagina_Enlaces());

			elements.put(PaginaRedesSociales_4003, DatawebPackage.eINSTANCE.getPagina_RedesSociales());

			elements.put(PaginaFuentesRSS_4004, DatawebPackage.eINSTANCE.getPagina_FuentesRSS());

			elements.put(PaginaCRUDEntidad_4005, DatawebPackage.eINSTANCE.getPaginaCRUD_Entidad());

			elements.put(PaginaIndiceAtributosMostrados_4006,
					DatawebPackage.eINSTANCE.getPaginaIndice_AtributosMostrados());

			elements.put(PreguntaOpcionMultipleRespuestaCorrecta_4007,
					DatawebPackage.eINSTANCE.getPreguntaOpcionMultiple_RespuestaCorrecta());

			elements.put(RolPaginasAccesibles_4008, DatawebPackage.eINSTANCE.getRol_PaginasAccesibles());

			elements.put(PaginaIndiceFiltrosAtributosFiltro_4009,
					DatawebPackage.eINSTANCE.getPaginaIndiceFiltros_AtributosFiltro());

			elements.put(PaginaIndicePaginadaFiltradaAtributosFiltro_4010,
					DatawebPackage.eINSTANCE.getPaginaIndicePaginadaFiltrada_AtributosFiltro());
		}
		return (ENamedElement) elements.get(type);
	}

	/**
	* @generated
	*/
	private static IElementType getElementType(String id) {
		return ElementTypeRegistry.getInstance().getType(id);
	}

	/**
	* @generated
	*/
	public static boolean isKnownElementType(IElementType elementType) {
		if (KNOWN_ELEMENT_TYPES == null) {
			KNOWN_ELEMENT_TYPES = new HashSet<IElementType>();
			KNOWN_ELEMENT_TYPES.add(Aplicacion_1000);
			KNOWN_ELEMENT_TYPES.add(PaginaIndiceDetalle_2001);
			KNOWN_ELEMENT_TYPES.add(PaginaIndicePaginada_2002);
			KNOWN_ELEMENT_TYPES.add(PaginaIndiceFiltros_2003);
			KNOWN_ELEMENT_TYPES.add(PaginaIndicePaginadaFiltrada_2004);
			KNOWN_ELEMENT_TYPES.add(PaginaDetalle_2005);
			KNOWN_ELEMENT_TYPES.add(PaginaCreacion_2006);
			KNOWN_ELEMENT_TYPES.add(PaginaActualizacion_2007);
			KNOWN_ELEMENT_TYPES.add(PaginaBorrado_2008);
			KNOWN_ELEMENT_TYPES.add(PaginaHome_2009);
			KNOWN_ELEMENT_TYPES.add(PaginaContenido_2010);
			KNOWN_ELEMENT_TYPES.add(Entidad_2011);
			KNOWN_ELEMENT_TYPES.add(Rol_2012);
			KNOWN_ELEMENT_TYPES.add(Cuestionario_2013);
			KNOWN_ELEMENT_TYPES.add(Encuesta_2014);
			KNOWN_ELEMENT_TYPES.add(RedSocial_2015);
			KNOWN_ELEMENT_TYPES.add(FuenteRSS_2016);
			KNOWN_ELEMENT_TYPES.add(Atributo_3001);
			KNOWN_ELEMENT_TYPES.add(PreguntaOpcionMultiple_3002);
			KNOWN_ELEMENT_TYPES.add(OpcionRespuesta_3003);
			KNOWN_ELEMENT_TYPES.add(PreguntaVerdaderoFalso_3004);
			KNOWN_ELEMENT_TYPES.add(PreguntaRespuestaCorta_3005);
			KNOWN_ELEMENT_TYPES.add(PreguntaOpcionMultiple_3006);
			KNOWN_ELEMENT_TYPES.add(PreguntaVerdaderoFalso_3007);
			KNOWN_ELEMENT_TYPES.add(PreguntaRespuestaCorta_3008);
			KNOWN_ELEMENT_TYPES.add(Referencia_4001);
			KNOWN_ELEMENT_TYPES.add(PaginaEnlaces_4002);
			KNOWN_ELEMENT_TYPES.add(PaginaRedesSociales_4003);
			KNOWN_ELEMENT_TYPES.add(PaginaFuentesRSS_4004);
			KNOWN_ELEMENT_TYPES.add(PaginaCRUDEntidad_4005);
			KNOWN_ELEMENT_TYPES.add(PaginaIndiceAtributosMostrados_4006);
			KNOWN_ELEMENT_TYPES.add(PreguntaOpcionMultipleRespuestaCorrecta_4007);
			KNOWN_ELEMENT_TYPES.add(RolPaginasAccesibles_4008);
			KNOWN_ELEMENT_TYPES.add(PaginaIndiceFiltrosAtributosFiltro_4009);
			KNOWN_ELEMENT_TYPES.add(PaginaIndicePaginadaFiltradaAtributosFiltro_4010);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	* @generated
	*/
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case AplicacionEditPart.VISUAL_ID:
			return Aplicacion_1000;
		case PaginaIndiceDetalleEditPart.VISUAL_ID:
			return PaginaIndiceDetalle_2001;
		case PaginaIndicePaginadaEditPart.VISUAL_ID:
			return PaginaIndicePaginada_2002;
		case PaginaIndiceFiltrosEditPart.VISUAL_ID:
			return PaginaIndiceFiltros_2003;
		case PaginaIndicePaginadaFiltradaEditPart.VISUAL_ID:
			return PaginaIndicePaginadaFiltrada_2004;
		case PaginaDetalleEditPart.VISUAL_ID:
			return PaginaDetalle_2005;
		case PaginaCreacionEditPart.VISUAL_ID:
			return PaginaCreacion_2006;
		case PaginaActualizacionEditPart.VISUAL_ID:
			return PaginaActualizacion_2007;
		case PaginaBorradoEditPart.VISUAL_ID:
			return PaginaBorrado_2008;
		case PaginaHomeEditPart.VISUAL_ID:
			return PaginaHome_2009;
		case PaginaContenidoEditPart.VISUAL_ID:
			return PaginaContenido_2010;
		case EntidadEditPart.VISUAL_ID:
			return Entidad_2011;
		case RolEditPart.VISUAL_ID:
			return Rol_2012;
		case CuestionarioEditPart.VISUAL_ID:
			return Cuestionario_2013;
		case EncuestaEditPart.VISUAL_ID:
			return Encuesta_2014;
		case RedSocialEditPart.VISUAL_ID:
			return RedSocial_2015;
		case FuenteRSSEditPart.VISUAL_ID:
			return FuenteRSS_2016;
		case AtributoEditPart.VISUAL_ID:
			return Atributo_3001;
		case PreguntaOpcionMultipleEditPart.VISUAL_ID:
			return PreguntaOpcionMultiple_3002;
		case OpcionRespuestaEditPart.VISUAL_ID:
			return OpcionRespuesta_3003;
		case PreguntaVerdaderoFalsoEditPart.VISUAL_ID:
			return PreguntaVerdaderoFalso_3004;
		case PreguntaRespuestaCortaEditPart.VISUAL_ID:
			return PreguntaRespuestaCorta_3005;
		case PreguntaOpcionMultiple2EditPart.VISUAL_ID:
			return PreguntaOpcionMultiple_3006;
		case PreguntaVerdaderoFalso2EditPart.VISUAL_ID:
			return PreguntaVerdaderoFalso_3007;
		case PreguntaRespuestaCorta2EditPart.VISUAL_ID:
			return PreguntaRespuestaCorta_3008;
		case ReferenciaEditPart.VISUAL_ID:
			return Referencia_4001;
		case PaginaEnlacesEditPart.VISUAL_ID:
			return PaginaEnlaces_4002;
		case PaginaRedesSocialesEditPart.VISUAL_ID:
			return PaginaRedesSociales_4003;
		case PaginaFuentesRSSEditPart.VISUAL_ID:
			return PaginaFuentesRSS_4004;
		case PaginaCRUDEntidadEditPart.VISUAL_ID:
			return PaginaCRUDEntidad_4005;
		case PaginaIndiceAtributosMostradosEditPart.VISUAL_ID:
			return PaginaIndiceAtributosMostrados_4006;
		case PreguntaOpcionMultipleRespuestaCorrectaEditPart.VISUAL_ID:
			return PreguntaOpcionMultipleRespuestaCorrecta_4007;
		case RolPaginasAccesiblesEditPart.VISUAL_ID:
			return RolPaginasAccesibles_4008;
		case PaginaIndiceFiltrosAtributosFiltroEditPart.VISUAL_ID:
			return PaginaIndiceFiltrosAtributosFiltro_4009;
		case PaginaIndicePaginadaFiltradaAtributosFiltroEditPart.VISUAL_ID:
			return PaginaIndicePaginadaFiltradaAtributosFiltro_4010;
		}
		return null;
	}

	/**
	* @generated
	*/
	public static final DiagramElementTypes TYPED_INSTANCE = new DiagramElementTypes(elementTypeImages) {

		/**
		* @generated
		*/
		@Override

		public boolean isKnownElementType(IElementType elementType) {
			return dataweb.diagram.providers.DatawebElementTypes.isKnownElementType(elementType);
		}

		/**
		* @generated
		*/
		@Override

		public IElementType getElementTypeForVisualId(int visualID) {
			return dataweb.diagram.providers.DatawebElementTypes.getElementType(visualID);
		}

		/**
		* @generated
		*/
		@Override

		public ENamedElement getDefiningNamedElement(IAdaptable elementTypeAdapter) {
			return dataweb.diagram.providers.DatawebElementTypes.getElement(elementTypeAdapter);
		}
	};

}
