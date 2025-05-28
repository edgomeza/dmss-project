/*
* 
*/
package dataweb.diagram.edit.policies;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;

import dataweb.diagram.edit.commands.PaginaCRUDEntidadCreateCommand;
import dataweb.diagram.edit.commands.PaginaCRUDEntidadReorientCommand;
import dataweb.diagram.edit.commands.PaginaEnlacesCreateCommand;
import dataweb.diagram.edit.commands.PaginaEnlacesReorientCommand;
import dataweb.diagram.edit.commands.PaginaFuentesRSSCreateCommand;
import dataweb.diagram.edit.commands.PaginaFuentesRSSReorientCommand;
import dataweb.diagram.edit.commands.PaginaIndiceAtributosMostradosCreateCommand;
import dataweb.diagram.edit.commands.PaginaIndiceAtributosMostradosReorientCommand;
import dataweb.diagram.edit.commands.PaginaRedesSocialesCreateCommand;
import dataweb.diagram.edit.commands.PaginaRedesSocialesReorientCommand;
import dataweb.diagram.edit.commands.RolPaginasAccesiblesCreateCommand;
import dataweb.diagram.edit.commands.RolPaginasAccesiblesReorientCommand;
import dataweb.diagram.edit.parts.PaginaCRUDEntidadEditPart;
import dataweb.diagram.edit.parts.PaginaEnlacesEditPart;
import dataweb.diagram.edit.parts.PaginaFuentesRSSEditPart;
import dataweb.diagram.edit.parts.PaginaIndiceAtributosMostradosEditPart;
import dataweb.diagram.edit.parts.PaginaRedesSocialesEditPart;
import dataweb.diagram.edit.parts.RolPaginasAccesiblesEditPart;
import dataweb.diagram.part.DatawebVisualIDRegistry;
import dataweb.diagram.providers.DatawebElementTypes;

/**
 * @generated
 */
public class PaginaIndiceDetalleItemSemanticEditPolicy extends DatawebBaseItemSemanticEditPolicy {

	/**
	* @generated
	*/
	public PaginaIndiceDetalleItemSemanticEditPolicy() {
		super(DatawebElementTypes.PaginaIndiceDetalle_2001);
	}

	/**
	* @generated
	*/
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		View view = (View) getHost().getModel();
		CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(getEditingDomain(), null);
		cmd.setTransactionNestingEnabled(false);
		for (Iterator<?> it = view.getTargetEdges().iterator(); it.hasNext();) {
			Edge incomingLink = (Edge) it.next();
			if (DatawebVisualIDRegistry.getVisualID(incomingLink) == PaginaEnlacesEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null,
						incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (DatawebVisualIDRegistry.getVisualID(incomingLink) == RolPaginasAccesiblesEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null,
						incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
		}
		for (Iterator<?> it = view.getSourceEdges().iterator(); it.hasNext();) {
			Edge outgoingLink = (Edge) it.next();
			if (DatawebVisualIDRegistry.getVisualID(outgoingLink) == PaginaEnlacesEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null,
						outgoingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (DatawebVisualIDRegistry.getVisualID(outgoingLink) == PaginaRedesSocialesEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null,
						outgoingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (DatawebVisualIDRegistry.getVisualID(outgoingLink) == PaginaFuentesRSSEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null,
						outgoingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (DatawebVisualIDRegistry.getVisualID(outgoingLink) == PaginaCRUDEntidadEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null,
						outgoingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (DatawebVisualIDRegistry.getVisualID(outgoingLink) == PaginaIndiceAtributosMostradosEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null,
						outgoingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
		}
		EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
		if (annotation == null) {
			// there are indirectly referenced children, need extra commands: false
			addDestroyShortcutsCommand(cmd, view);
			// delete host element
			cmd.add(new DestroyElementCommand(req));
		} else {
			cmd.add(new DeleteCommand(getEditingDomain(), view));
		}
		return getGEFWrapper(cmd.reduce());
	}

	/**
	 * @generated
	 */
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		Command command = req.getTarget() == null ? getStartCreateRelationshipCommand(req)
				: getCompleteCreateRelationshipCommand(req);
		return command != null ? command : super.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (DatawebElementTypes.PaginaEnlaces_4002 == req.getElementType()) {
			return getGEFWrapper(new PaginaEnlacesCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (DatawebElementTypes.PaginaRedesSociales_4003 == req.getElementType()) {
			return getGEFWrapper(new PaginaRedesSocialesCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (DatawebElementTypes.PaginaFuentesRSS_4004 == req.getElementType()) {
			return getGEFWrapper(new PaginaFuentesRSSCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (DatawebElementTypes.PaginaCRUDEntidad_4005 == req.getElementType()) {
			return getGEFWrapper(new PaginaCRUDEntidadCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (DatawebElementTypes.PaginaIndiceAtributosMostrados_4006 == req.getElementType()) {
			return getGEFWrapper(
					new PaginaIndiceAtributosMostradosCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (DatawebElementTypes.RolPaginasAccesibles_4008 == req.getElementType()) {
			return null;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (DatawebElementTypes.PaginaEnlaces_4002 == req.getElementType()) {
			return getGEFWrapper(new PaginaEnlacesCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (DatawebElementTypes.PaginaRedesSociales_4003 == req.getElementType()) {
			return null;
		}
		if (DatawebElementTypes.PaginaFuentesRSS_4004 == req.getElementType()) {
			return null;
		}
		if (DatawebElementTypes.PaginaCRUDEntidad_4005 == req.getElementType()) {
			return null;
		}
		if (DatawebElementTypes.PaginaIndiceAtributosMostrados_4006 == req.getElementType()) {
			return null;
		}
		if (DatawebElementTypes.RolPaginasAccesibles_4008 == req.getElementType()) {
			return getGEFWrapper(new RolPaginasAccesiblesCreateCommand(req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * Returns command to reorient EReference based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {
		switch (getVisualID(req)) {
		case PaginaEnlacesEditPart.VISUAL_ID:
			return getGEFWrapper(new PaginaEnlacesReorientCommand(req));
		case PaginaRedesSocialesEditPart.VISUAL_ID:
			return getGEFWrapper(new PaginaRedesSocialesReorientCommand(req));
		case PaginaFuentesRSSEditPart.VISUAL_ID:
			return getGEFWrapper(new PaginaFuentesRSSReorientCommand(req));
		case PaginaCRUDEntidadEditPart.VISUAL_ID:
			return getGEFWrapper(new PaginaCRUDEntidadReorientCommand(req));
		case PaginaIndiceAtributosMostradosEditPart.VISUAL_ID:
			return getGEFWrapper(new PaginaIndiceAtributosMostradosReorientCommand(req));
		case RolPaginasAccesiblesEditPart.VISUAL_ID:
			return getGEFWrapper(new RolPaginasAccesiblesReorientCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
