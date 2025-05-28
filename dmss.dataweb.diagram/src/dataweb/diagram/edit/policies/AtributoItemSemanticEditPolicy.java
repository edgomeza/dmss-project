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

import dataweb.diagram.edit.commands.PaginaIndiceAtributosMostradosCreateCommand;
import dataweb.diagram.edit.commands.PaginaIndiceAtributosMostradosReorientCommand;
import dataweb.diagram.edit.commands.PaginaIndiceFiltrosAtributosFiltroCreateCommand;
import dataweb.diagram.edit.commands.PaginaIndiceFiltrosAtributosFiltroReorientCommand;
import dataweb.diagram.edit.commands.PaginaIndicePaginadaFiltradaAtributosFiltroCreateCommand;
import dataweb.diagram.edit.commands.PaginaIndicePaginadaFiltradaAtributosFiltroReorientCommand;
import dataweb.diagram.edit.parts.PaginaIndiceAtributosMostradosEditPart;
import dataweb.diagram.edit.parts.PaginaIndiceFiltrosAtributosFiltroEditPart;
import dataweb.diagram.edit.parts.PaginaIndicePaginadaFiltradaAtributosFiltroEditPart;
import dataweb.diagram.part.DatawebVisualIDRegistry;
import dataweb.diagram.providers.DatawebElementTypes;

/**
 * @generated
 */
public class AtributoItemSemanticEditPolicy extends DatawebBaseItemSemanticEditPolicy {

	/**
	* @generated
	*/
	public AtributoItemSemanticEditPolicy() {
		super(DatawebElementTypes.Atributo_3001);
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
			if (DatawebVisualIDRegistry.getVisualID(incomingLink) == PaginaIndiceAtributosMostradosEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null,
						incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (DatawebVisualIDRegistry
					.getVisualID(incomingLink) == PaginaIndiceFiltrosAtributosFiltroEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null,
						incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (DatawebVisualIDRegistry
					.getVisualID(incomingLink) == PaginaIndicePaginadaFiltradaAtributosFiltroEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null,
						incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
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
		if (DatawebElementTypes.PaginaIndiceAtributosMostrados_4006 == req.getElementType()) {
			return null;
		}
		if (DatawebElementTypes.PaginaIndiceFiltrosAtributosFiltro_4009 == req.getElementType()) {
			return null;
		}
		if (DatawebElementTypes.PaginaIndicePaginadaFiltradaAtributosFiltro_4010 == req.getElementType()) {
			return null;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (DatawebElementTypes.PaginaIndiceAtributosMostrados_4006 == req.getElementType()) {
			return getGEFWrapper(
					new PaginaIndiceAtributosMostradosCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (DatawebElementTypes.PaginaIndiceFiltrosAtributosFiltro_4009 == req.getElementType()) {
			return getGEFWrapper(
					new PaginaIndiceFiltrosAtributosFiltroCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (DatawebElementTypes.PaginaIndicePaginadaFiltradaAtributosFiltro_4010 == req.getElementType()) {
			return getGEFWrapper(new PaginaIndicePaginadaFiltradaAtributosFiltroCreateCommand(req, req.getSource(),
					req.getTarget()));
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
		case PaginaIndiceAtributosMostradosEditPart.VISUAL_ID:
			return getGEFWrapper(new PaginaIndiceAtributosMostradosReorientCommand(req));
		case PaginaIndiceFiltrosAtributosFiltroEditPart.VISUAL_ID:
			return getGEFWrapper(new PaginaIndiceFiltrosAtributosFiltroReorientCommand(req));
		case PaginaIndicePaginadaFiltradaAtributosFiltroEditPart.VISUAL_ID:
			return getGEFWrapper(new PaginaIndicePaginadaFiltradaAtributosFiltroReorientCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
