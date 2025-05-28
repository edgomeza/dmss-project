/*
* 
*/
package dataweb.diagram.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;

import dataweb.diagram.edit.commands.CuestionarioCreateCommand;
import dataweb.diagram.edit.commands.EncuestaCreateCommand;
import dataweb.diagram.edit.commands.EntidadCreateCommand;
import dataweb.diagram.edit.commands.FuenteRSSCreateCommand;
import dataweb.diagram.edit.commands.PaginaActualizacionCreateCommand;
import dataweb.diagram.edit.commands.PaginaBorradoCreateCommand;
import dataweb.diagram.edit.commands.PaginaContenidoCreateCommand;
import dataweb.diagram.edit.commands.PaginaCreacionCreateCommand;
import dataweb.diagram.edit.commands.PaginaDetalleCreateCommand;
import dataweb.diagram.edit.commands.PaginaHomeCreateCommand;
import dataweb.diagram.edit.commands.PaginaIndiceDetalleCreateCommand;
import dataweb.diagram.edit.commands.PaginaIndiceFiltrosCreateCommand;
import dataweb.diagram.edit.commands.PaginaIndicePaginadaCreateCommand;
import dataweb.diagram.edit.commands.PaginaIndicePaginadaFiltradaCreateCommand;
import dataweb.diagram.edit.commands.RedSocialCreateCommand;
import dataweb.diagram.edit.commands.RolCreateCommand;
import dataweb.diagram.providers.DatawebElementTypes;

/**
 * @generated
 */
public class AplicacionItemSemanticEditPolicy extends DatawebBaseItemSemanticEditPolicy {

	/**
	* @generated
	*/
	public AplicacionItemSemanticEditPolicy() {
		super(DatawebElementTypes.Aplicacion_1000);
	}

	/**
	* @generated
	*/
	protected Command getCreateCommand(CreateElementRequest req) {
		if (DatawebElementTypes.PaginaIndiceDetalle_2001 == req.getElementType()) {
			return getGEFWrapper(new PaginaIndiceDetalleCreateCommand(req));
		}
		if (DatawebElementTypes.PaginaIndicePaginada_2002 == req.getElementType()) {
			return getGEFWrapper(new PaginaIndicePaginadaCreateCommand(req));
		}
		if (DatawebElementTypes.PaginaIndiceFiltros_2003 == req.getElementType()) {
			return getGEFWrapper(new PaginaIndiceFiltrosCreateCommand(req));
		}
		if (DatawebElementTypes.PaginaIndicePaginadaFiltrada_2004 == req.getElementType()) {
			return getGEFWrapper(new PaginaIndicePaginadaFiltradaCreateCommand(req));
		}
		if (DatawebElementTypes.PaginaDetalle_2005 == req.getElementType()) {
			return getGEFWrapper(new PaginaDetalleCreateCommand(req));
		}
		if (DatawebElementTypes.PaginaCreacion_2006 == req.getElementType()) {
			return getGEFWrapper(new PaginaCreacionCreateCommand(req));
		}
		if (DatawebElementTypes.PaginaActualizacion_2007 == req.getElementType()) {
			return getGEFWrapper(new PaginaActualizacionCreateCommand(req));
		}
		if (DatawebElementTypes.PaginaBorrado_2008 == req.getElementType()) {
			return getGEFWrapper(new PaginaBorradoCreateCommand(req));
		}
		if (DatawebElementTypes.PaginaHome_2009 == req.getElementType()) {
			return getGEFWrapper(new PaginaHomeCreateCommand(req));
		}
		if (DatawebElementTypes.PaginaContenido_2010 == req.getElementType()) {
			return getGEFWrapper(new PaginaContenidoCreateCommand(req));
		}
		if (DatawebElementTypes.Entidad_2011 == req.getElementType()) {
			return getGEFWrapper(new EntidadCreateCommand(req));
		}
		if (DatawebElementTypes.Rol_2012 == req.getElementType()) {
			return getGEFWrapper(new RolCreateCommand(req));
		}
		if (DatawebElementTypes.Cuestionario_2013 == req.getElementType()) {
			return getGEFWrapper(new CuestionarioCreateCommand(req));
		}
		if (DatawebElementTypes.Encuesta_2014 == req.getElementType()) {
			return getGEFWrapper(new EncuestaCreateCommand(req));
		}
		if (DatawebElementTypes.RedSocial_2015 == req.getElementType()) {
			return getGEFWrapper(new RedSocialCreateCommand(req));
		}
		if (DatawebElementTypes.FuenteRSS_2016 == req.getElementType()) {
			return getGEFWrapper(new FuenteRSSCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

	/**
	* @generated
	*/
	protected Command getDuplicateCommand(DuplicateElementsRequest req) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
		return getGEFWrapper(new DuplicateAnythingCommand(editingDomain, req));
	}

	/**
	* @generated
	*/
	private static class DuplicateAnythingCommand extends DuplicateEObjectsCommand {

		/**
		* @generated
		*/
		public DuplicateAnythingCommand(TransactionalEditingDomain editingDomain, DuplicateElementsRequest req) {
			super(editingDomain, req.getLabel(), req.getElementsToBeDuplicated(), req.getAllDuplicatedElementsMap());
		}

	}

}
