/*
 * 
 */
package dataweb.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import dataweb.Atributo;
import dataweb.PaginaIndicePaginadaFiltrada;
import dataweb.diagram.edit.policies.DatawebBaseItemSemanticEditPolicy;

/**
 * @generated
 */
public class PaginaIndicePaginadaFiltradaAtributosFiltroReorientCommand extends EditElementCommand {

	/**
	* @generated
	*/
	private final int reorientDirection;

	/**
	* @generated
	*/
	private final EObject referenceOwner;

	/**
	* @generated
	*/
	private final EObject oldEnd;

	/**
	* @generated
	*/
	private final EObject newEnd;

	/**
	* @generated
	*/
	public PaginaIndicePaginadaFiltradaAtributosFiltroReorientCommand(ReorientReferenceRelationshipRequest request) {
		super(request.getLabel(), null, request);
		reorientDirection = request.getDirection();
		referenceOwner = request.getReferenceOwner();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	* @generated
	*/
	public boolean canExecute() {
		if (false == referenceOwner instanceof PaginaIndicePaginadaFiltrada) {
			return false;
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			return canReorientSource();
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			return canReorientTarget();
		}
		return false;
	}

	/**
	* @generated
	*/
	protected boolean canReorientSource() {
		if (!(oldEnd instanceof Atributo && newEnd instanceof PaginaIndicePaginadaFiltrada)) {
			return false;
		}
		return DatawebBaseItemSemanticEditPolicy.getLinkConstraints()
				.canExistPaginaIndicePaginadaFiltradaAtributosFiltro_4010(getNewSource(), getOldTarget());
	}

	/**
	* @generated
	*/
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof Atributo && newEnd instanceof Atributo)) {
			return false;
		}
		return DatawebBaseItemSemanticEditPolicy.getLinkConstraints()
				.canExistPaginaIndicePaginadaFiltradaAtributosFiltro_4010(getOldSource(), getNewTarget());
	}

	/**
	* @generated
	*/
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if (!canExecute()) {
			throw new ExecutionException("Invalid arguments in reorient link command"); //$NON-NLS-1$
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			return reorientSource();
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			return reorientTarget();
		}
		throw new IllegalStateException();
	}

	/**
	* @generated
	*/
	protected CommandResult reorientSource() throws ExecutionException {
		getOldSource().getAtributosFiltro().remove(getOldTarget());
		getNewSource().getAtributosFiltro().add(getOldTarget());
		return CommandResult.newOKCommandResult(referenceOwner);
	}

	/**
	* @generated
	*/
	protected CommandResult reorientTarget() throws ExecutionException {
		getOldSource().getAtributosFiltro().remove(getOldTarget());
		getOldSource().getAtributosFiltro().add(getNewTarget());
		return CommandResult.newOKCommandResult(referenceOwner);
	}

	/**
	* @generated
	*/
	protected PaginaIndicePaginadaFiltrada getOldSource() {
		return (PaginaIndicePaginadaFiltrada) referenceOwner;
	}

	/**
	* @generated
	*/
	protected PaginaIndicePaginadaFiltrada getNewSource() {
		return (PaginaIndicePaginadaFiltrada) newEnd;
	}

	/**
	* @generated
	*/
	protected Atributo getOldTarget() {
		return (Atributo) oldEnd;
	}

	/**
	* @generated
	*/
	protected Atributo getNewTarget() {
		return (Atributo) newEnd;
	}
}
