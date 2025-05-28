/*
 * 
 */
package dataweb.diagram.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;
import org.eclipse.gmf.runtime.notation.View;

import dataweb.DatawebPackage;
import dataweb.diagram.edit.parts.AtributoNombreEditPart;
import dataweb.diagram.edit.parts.CuestionarioNombreEditPart;
import dataweb.diagram.edit.parts.EncuestaNombreEditPart;
import dataweb.diagram.edit.parts.EntidadNombreEditPart;
import dataweb.diagram.edit.parts.FuenteRSSNombreEditPart;
import dataweb.diagram.edit.parts.OpcionRespuestaNombreEditPart;
import dataweb.diagram.edit.parts.PaginaActualizacionNombreEditPart;
import dataweb.diagram.edit.parts.PaginaBorradoNombreEditPart;
import dataweb.diagram.edit.parts.PaginaContenidoNombreEditPart;
import dataweb.diagram.edit.parts.PaginaCreacionNombreEditPart;
import dataweb.diagram.edit.parts.PaginaDetalleNombreEditPart;
import dataweb.diagram.edit.parts.PaginaHomeNombreEditPart;
import dataweb.diagram.edit.parts.PaginaIndiceDetalleNombreEditPart;
import dataweb.diagram.edit.parts.PaginaIndiceFiltrosNombreEditPart;
import dataweb.diagram.edit.parts.PaginaIndicePaginadaFiltradaNombreEditPart;
import dataweb.diagram.edit.parts.PaginaIndicePaginadaNombreEditPart;
import dataweb.diagram.edit.parts.PreguntaOpcionMultipleNombre2EditPart;
import dataweb.diagram.edit.parts.PreguntaOpcionMultipleNombreEditPart;
import dataweb.diagram.edit.parts.PreguntaRespuestaCortaNombre2EditPart;
import dataweb.diagram.edit.parts.PreguntaRespuestaCortaNombreEditPart;
import dataweb.diagram.edit.parts.PreguntaVerdaderoFalsoNombre2EditPart;
import dataweb.diagram.edit.parts.PreguntaVerdaderoFalsoNombreEditPart;
import dataweb.diagram.edit.parts.RedSocialNombreEditPart;
import dataweb.diagram.edit.parts.ReferenciaNombreEditPart;
import dataweb.diagram.edit.parts.RolNombreEditPart;
import dataweb.diagram.parsers.MessageFormatParser;
import dataweb.diagram.part.DatawebVisualIDRegistry;

/**
 * @generated
 */
public class DatawebParserProvider extends AbstractProvider implements IParserProvider {

	/**
	* @generated
	*/
	private IParser paginaIndiceDetalleNombre_5001Parser;

	/**
	* @generated
	*/
	private IParser getPaginaIndiceDetalleNombre_5001Parser() {
		if (paginaIndiceDetalleNombre_5001Parser == null) {
			EAttribute[] features = new EAttribute[] { DatawebPackage.eINSTANCE.getPagina_Nombre() };
			MessageFormatParser parser = new MessageFormatParser(features);
			paginaIndiceDetalleNombre_5001Parser = parser;
		}
		return paginaIndiceDetalleNombre_5001Parser;
	}

	/**
	* @generated
	*/
	private IParser paginaIndicePaginadaNombre_5002Parser;

	/**
	* @generated
	*/
	private IParser getPaginaIndicePaginadaNombre_5002Parser() {
		if (paginaIndicePaginadaNombre_5002Parser == null) {
			EAttribute[] features = new EAttribute[] { DatawebPackage.eINSTANCE.getPagina_Nombre() };
			MessageFormatParser parser = new MessageFormatParser(features);
			paginaIndicePaginadaNombre_5002Parser = parser;
		}
		return paginaIndicePaginadaNombre_5002Parser;
	}

	/**
	* @generated
	*/
	private IParser paginaIndiceFiltrosNombre_5003Parser;

	/**
	* @generated
	*/
	private IParser getPaginaIndiceFiltrosNombre_5003Parser() {
		if (paginaIndiceFiltrosNombre_5003Parser == null) {
			EAttribute[] features = new EAttribute[] { DatawebPackage.eINSTANCE.getPagina_Nombre() };
			MessageFormatParser parser = new MessageFormatParser(features);
			paginaIndiceFiltrosNombre_5003Parser = parser;
		}
		return paginaIndiceFiltrosNombre_5003Parser;
	}

	/**
	* @generated
	*/
	private IParser paginaIndicePaginadaFiltradaNombre_5004Parser;

	/**
	* @generated
	*/
	private IParser getPaginaIndicePaginadaFiltradaNombre_5004Parser() {
		if (paginaIndicePaginadaFiltradaNombre_5004Parser == null) {
			EAttribute[] features = new EAttribute[] { DatawebPackage.eINSTANCE.getPagina_Nombre() };
			MessageFormatParser parser = new MessageFormatParser(features);
			paginaIndicePaginadaFiltradaNombre_5004Parser = parser;
		}
		return paginaIndicePaginadaFiltradaNombre_5004Parser;
	}

	/**
	* @generated
	*/
	private IParser paginaDetalleNombre_5005Parser;

	/**
	* @generated
	*/
	private IParser getPaginaDetalleNombre_5005Parser() {
		if (paginaDetalleNombre_5005Parser == null) {
			EAttribute[] features = new EAttribute[] { DatawebPackage.eINSTANCE.getPagina_Nombre() };
			MessageFormatParser parser = new MessageFormatParser(features);
			paginaDetalleNombre_5005Parser = parser;
		}
		return paginaDetalleNombre_5005Parser;
	}

	/**
	* @generated
	*/
	private IParser paginaCreacionNombre_5006Parser;

	/**
	* @generated
	*/
	private IParser getPaginaCreacionNombre_5006Parser() {
		if (paginaCreacionNombre_5006Parser == null) {
			EAttribute[] features = new EAttribute[] { DatawebPackage.eINSTANCE.getPagina_Nombre() };
			MessageFormatParser parser = new MessageFormatParser(features);
			paginaCreacionNombre_5006Parser = parser;
		}
		return paginaCreacionNombre_5006Parser;
	}

	/**
	* @generated
	*/
	private IParser paginaActualizacionNombre_5007Parser;

	/**
	* @generated
	*/
	private IParser getPaginaActualizacionNombre_5007Parser() {
		if (paginaActualizacionNombre_5007Parser == null) {
			EAttribute[] features = new EAttribute[] { DatawebPackage.eINSTANCE.getPagina_Nombre() };
			MessageFormatParser parser = new MessageFormatParser(features);
			paginaActualizacionNombre_5007Parser = parser;
		}
		return paginaActualizacionNombre_5007Parser;
	}

	/**
	* @generated
	*/
	private IParser paginaBorradoNombre_5008Parser;

	/**
	* @generated
	*/
	private IParser getPaginaBorradoNombre_5008Parser() {
		if (paginaBorradoNombre_5008Parser == null) {
			EAttribute[] features = new EAttribute[] { DatawebPackage.eINSTANCE.getPagina_Nombre() };
			MessageFormatParser parser = new MessageFormatParser(features);
			paginaBorradoNombre_5008Parser = parser;
		}
		return paginaBorradoNombre_5008Parser;
	}

	/**
	* @generated
	*/
	private IParser paginaHomeNombre_5009Parser;

	/**
	* @generated
	*/
	private IParser getPaginaHomeNombre_5009Parser() {
		if (paginaHomeNombre_5009Parser == null) {
			EAttribute[] features = new EAttribute[] { DatawebPackage.eINSTANCE.getPagina_Nombre() };
			MessageFormatParser parser = new MessageFormatParser(features);
			paginaHomeNombre_5009Parser = parser;
		}
		return paginaHomeNombre_5009Parser;
	}

	/**
	* @generated
	*/
	private IParser paginaContenidoNombre_5010Parser;

	/**
	* @generated
	*/
	private IParser getPaginaContenidoNombre_5010Parser() {
		if (paginaContenidoNombre_5010Parser == null) {
			EAttribute[] features = new EAttribute[] { DatawebPackage.eINSTANCE.getPagina_Nombre() };
			MessageFormatParser parser = new MessageFormatParser(features);
			paginaContenidoNombre_5010Parser = parser;
		}
		return paginaContenidoNombre_5010Parser;
	}

	/**
	* @generated
	*/
	private IParser entidadNombre_5012Parser;

	/**
	* @generated
	*/
	private IParser getEntidadNombre_5012Parser() {
		if (entidadNombre_5012Parser == null) {
			EAttribute[] features = new EAttribute[] { DatawebPackage.eINSTANCE.getEntidad_Nombre() };
			MessageFormatParser parser = new MessageFormatParser(features);
			entidadNombre_5012Parser = parser;
		}
		return entidadNombre_5012Parser;
	}

	/**
	* @generated
	*/
	private IParser rolNombre_5013Parser;

	/**
	* @generated
	*/
	private IParser getRolNombre_5013Parser() {
		if (rolNombre_5013Parser == null) {
			EAttribute[] features = new EAttribute[] { DatawebPackage.eINSTANCE.getRol_Nombre() };
			MessageFormatParser parser = new MessageFormatParser(features);
			rolNombre_5013Parser = parser;
		}
		return rolNombre_5013Parser;
	}

	/**
	* @generated
	*/
	private IParser cuestionarioNombre_5018Parser;

	/**
	* @generated
	*/
	private IParser getCuestionarioNombre_5018Parser() {
		if (cuestionarioNombre_5018Parser == null) {
			EAttribute[] features = new EAttribute[] { DatawebPackage.eINSTANCE.getCuestionario_Nombre() };
			MessageFormatParser parser = new MessageFormatParser(features);
			cuestionarioNombre_5018Parser = parser;
		}
		return cuestionarioNombre_5018Parser;
	}

	/**
	* @generated
	*/
	private IParser encuestaNombre_5022Parser;

	/**
	* @generated
	*/
	private IParser getEncuestaNombre_5022Parser() {
		if (encuestaNombre_5022Parser == null) {
			EAttribute[] features = new EAttribute[] { DatawebPackage.eINSTANCE.getEncuesta_Nombre() };
			MessageFormatParser parser = new MessageFormatParser(features);
			encuestaNombre_5022Parser = parser;
		}
		return encuestaNombre_5022Parser;
	}

	/**
	* @generated
	*/
	private IParser redSocialNombre_5023Parser;

	/**
	* @generated
	*/
	private IParser getRedSocialNombre_5023Parser() {
		if (redSocialNombre_5023Parser == null) {
			EAttribute[] features = new EAttribute[] { DatawebPackage.eINSTANCE.getRedSocial_Nombre() };
			MessageFormatParser parser = new MessageFormatParser(features);
			redSocialNombre_5023Parser = parser;
		}
		return redSocialNombre_5023Parser;
	}

	/**
	* @generated
	*/
	private IParser fuenteRSSNombre_5024Parser;

	/**
	* @generated
	*/
	private IParser getFuenteRSSNombre_5024Parser() {
		if (fuenteRSSNombre_5024Parser == null) {
			EAttribute[] features = new EAttribute[] { DatawebPackage.eINSTANCE.getFuenteRSS_Nombre() };
			MessageFormatParser parser = new MessageFormatParser(features);
			fuenteRSSNombre_5024Parser = parser;
		}
		return fuenteRSSNombre_5024Parser;
	}

	/**
	* @generated
	*/
	private IParser atributoNombre_5011Parser;

	/**
	* @generated
	*/
	private IParser getAtributoNombre_5011Parser() {
		if (atributoNombre_5011Parser == null) {
			EAttribute[] features = new EAttribute[] { DatawebPackage.eINSTANCE.getAtributo_Nombre() };
			MessageFormatParser parser = new MessageFormatParser(features);
			atributoNombre_5011Parser = parser;
		}
		return atributoNombre_5011Parser;
	}

	/**
	* @generated
	*/
	private IParser preguntaOpcionMultipleNombre_5015Parser;

	/**
	* @generated
	*/
	private IParser getPreguntaOpcionMultipleNombre_5015Parser() {
		if (preguntaOpcionMultipleNombre_5015Parser == null) {
			EAttribute[] features = new EAttribute[] { DatawebPackage.eINSTANCE.getPregunta_Nombre() };
			MessageFormatParser parser = new MessageFormatParser(features);
			preguntaOpcionMultipleNombre_5015Parser = parser;
		}
		return preguntaOpcionMultipleNombre_5015Parser;
	}

	/**
	* @generated
	*/
	private IParser opcionRespuestaNombre_5014Parser;

	/**
	* @generated
	*/
	private IParser getOpcionRespuestaNombre_5014Parser() {
		if (opcionRespuestaNombre_5014Parser == null) {
			EAttribute[] features = new EAttribute[] { DatawebPackage.eINSTANCE.getOpcionRespuesta_Nombre() };
			MessageFormatParser parser = new MessageFormatParser(features);
			opcionRespuestaNombre_5014Parser = parser;
		}
		return opcionRespuestaNombre_5014Parser;
	}

	/**
	* @generated
	*/
	private IParser preguntaVerdaderoFalsoNombre_5016Parser;

	/**
	* @generated
	*/
	private IParser getPreguntaVerdaderoFalsoNombre_5016Parser() {
		if (preguntaVerdaderoFalsoNombre_5016Parser == null) {
			EAttribute[] features = new EAttribute[] { DatawebPackage.eINSTANCE.getPregunta_Nombre() };
			MessageFormatParser parser = new MessageFormatParser(features);
			preguntaVerdaderoFalsoNombre_5016Parser = parser;
		}
		return preguntaVerdaderoFalsoNombre_5016Parser;
	}

	/**
	* @generated
	*/
	private IParser preguntaRespuestaCortaNombre_5017Parser;

	/**
	* @generated
	*/
	private IParser getPreguntaRespuestaCortaNombre_5017Parser() {
		if (preguntaRespuestaCortaNombre_5017Parser == null) {
			EAttribute[] features = new EAttribute[] { DatawebPackage.eINSTANCE.getPregunta_Nombre() };
			MessageFormatParser parser = new MessageFormatParser(features);
			preguntaRespuestaCortaNombre_5017Parser = parser;
		}
		return preguntaRespuestaCortaNombre_5017Parser;
	}

	/**
	* @generated
	*/
	private IParser preguntaOpcionMultipleNombre_5019Parser;

	/**
	* @generated
	*/
	private IParser getPreguntaOpcionMultipleNombre_5019Parser() {
		if (preguntaOpcionMultipleNombre_5019Parser == null) {
			EAttribute[] features = new EAttribute[] { DatawebPackage.eINSTANCE.getPregunta_Nombre() };
			MessageFormatParser parser = new MessageFormatParser(features);
			preguntaOpcionMultipleNombre_5019Parser = parser;
		}
		return preguntaOpcionMultipleNombre_5019Parser;
	}

	/**
	* @generated
	*/
	private IParser preguntaVerdaderoFalsoNombre_5020Parser;

	/**
	* @generated
	*/
	private IParser getPreguntaVerdaderoFalsoNombre_5020Parser() {
		if (preguntaVerdaderoFalsoNombre_5020Parser == null) {
			EAttribute[] features = new EAttribute[] { DatawebPackage.eINSTANCE.getPregunta_Nombre() };
			MessageFormatParser parser = new MessageFormatParser(features);
			preguntaVerdaderoFalsoNombre_5020Parser = parser;
		}
		return preguntaVerdaderoFalsoNombre_5020Parser;
	}

	/**
	* @generated
	*/
	private IParser preguntaRespuestaCortaNombre_5021Parser;

	/**
	* @generated
	*/
	private IParser getPreguntaRespuestaCortaNombre_5021Parser() {
		if (preguntaRespuestaCortaNombre_5021Parser == null) {
			EAttribute[] features = new EAttribute[] { DatawebPackage.eINSTANCE.getPregunta_Nombre() };
			MessageFormatParser parser = new MessageFormatParser(features);
			preguntaRespuestaCortaNombre_5021Parser = parser;
		}
		return preguntaRespuestaCortaNombre_5021Parser;
	}

	/**
	* @generated
	*/
	private IParser referenciaNombre_6001Parser;

	/**
	* @generated
	*/
	private IParser getReferenciaNombre_6001Parser() {
		if (referenciaNombre_6001Parser == null) {
			EAttribute[] features = new EAttribute[] { DatawebPackage.eINSTANCE.getReferencia_Nombre() };
			MessageFormatParser parser = new MessageFormatParser(features);
			referenciaNombre_6001Parser = parser;
		}
		return referenciaNombre_6001Parser;
	}

	/**
	* @generated
	*/
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case PaginaIndiceDetalleNombreEditPart.VISUAL_ID:
			return getPaginaIndiceDetalleNombre_5001Parser();
		case PaginaIndicePaginadaNombreEditPart.VISUAL_ID:
			return getPaginaIndicePaginadaNombre_5002Parser();
		case PaginaIndiceFiltrosNombreEditPart.VISUAL_ID:
			return getPaginaIndiceFiltrosNombre_5003Parser();
		case PaginaIndicePaginadaFiltradaNombreEditPart.VISUAL_ID:
			return getPaginaIndicePaginadaFiltradaNombre_5004Parser();
		case PaginaDetalleNombreEditPart.VISUAL_ID:
			return getPaginaDetalleNombre_5005Parser();
		case PaginaCreacionNombreEditPart.VISUAL_ID:
			return getPaginaCreacionNombre_5006Parser();
		case PaginaActualizacionNombreEditPart.VISUAL_ID:
			return getPaginaActualizacionNombre_5007Parser();
		case PaginaBorradoNombreEditPart.VISUAL_ID:
			return getPaginaBorradoNombre_5008Parser();
		case PaginaHomeNombreEditPart.VISUAL_ID:
			return getPaginaHomeNombre_5009Parser();
		case PaginaContenidoNombreEditPart.VISUAL_ID:
			return getPaginaContenidoNombre_5010Parser();
		case EntidadNombreEditPart.VISUAL_ID:
			return getEntidadNombre_5012Parser();
		case RolNombreEditPart.VISUAL_ID:
			return getRolNombre_5013Parser();
		case CuestionarioNombreEditPart.VISUAL_ID:
			return getCuestionarioNombre_5018Parser();
		case EncuestaNombreEditPart.VISUAL_ID:
			return getEncuestaNombre_5022Parser();
		case RedSocialNombreEditPart.VISUAL_ID:
			return getRedSocialNombre_5023Parser();
		case FuenteRSSNombreEditPart.VISUAL_ID:
			return getFuenteRSSNombre_5024Parser();
		case AtributoNombreEditPart.VISUAL_ID:
			return getAtributoNombre_5011Parser();
		case PreguntaOpcionMultipleNombreEditPart.VISUAL_ID:
			return getPreguntaOpcionMultipleNombre_5015Parser();
		case OpcionRespuestaNombreEditPart.VISUAL_ID:
			return getOpcionRespuestaNombre_5014Parser();
		case PreguntaVerdaderoFalsoNombreEditPart.VISUAL_ID:
			return getPreguntaVerdaderoFalsoNombre_5016Parser();
		case PreguntaRespuestaCortaNombreEditPart.VISUAL_ID:
			return getPreguntaRespuestaCortaNombre_5017Parser();
		case PreguntaOpcionMultipleNombre2EditPart.VISUAL_ID:
			return getPreguntaOpcionMultipleNombre_5019Parser();
		case PreguntaVerdaderoFalsoNombre2EditPart.VISUAL_ID:
			return getPreguntaVerdaderoFalsoNombre_5020Parser();
		case PreguntaRespuestaCortaNombre2EditPart.VISUAL_ID:
			return getPreguntaRespuestaCortaNombre_5021Parser();
		case ReferenciaNombreEditPart.VISUAL_ID:
			return getReferenciaNombre_6001Parser();
		}
		return null;
	}

	/**
	* Utility method that consults ParserService
	* @generated
	*/
	public static IParser getParser(IElementType type, EObject object, String parserHint) {
		return ParserService.getInstance().getParser(new HintAdapter(type, object, parserHint));
	}

	/**
	* @generated
	*/
	public IParser getParser(IAdaptable hint) {
		String vid = (String) hint.getAdapter(String.class);
		if (vid != null) {
			return getParser(DatawebVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(DatawebVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	* @generated
	*/
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (DatawebElementTypes.getElement(hint) == null) {
				return false;
			}
			return getParser(hint) != null;
		}
		return false;
	}

	/**
	* @generated
	*/
	private static class HintAdapter extends ParserHintAdapter {

		/**
		* @generated
		*/
		private final IElementType elementType;

		/**
		* @generated
		*/
		public HintAdapter(IElementType type, EObject object, String parserHint) {
			super(object, parserHint);
			assert type != null;
			elementType = type;
		}

		/**
		* @generated
		*/
		public Object getAdapter(Class adapter) {
			if (IElementType.class.equals(adapter)) {
				return elementType;
			}
			return super.getAdapter(adapter);
		}
	}

}
