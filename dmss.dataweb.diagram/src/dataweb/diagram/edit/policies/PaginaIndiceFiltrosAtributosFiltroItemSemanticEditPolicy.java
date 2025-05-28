/*
* 
*/
package dataweb.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;

import dataweb.diagram.providers.DatawebElementTypes;

/**
 * @generated
 */
public class PaginaIndiceFiltrosAtributosFiltroItemSemanticEditPolicy extends DatawebBaseItemSemanticEditPolicy {

	/**
	* @generated
	*/
	public PaginaIndiceFiltrosAtributosFiltroItemSemanticEditPolicy() {
		super(DatawebElementTypes.PaginaIndiceFiltrosAtributosFiltro_4009);
	}

	/**
	* @generated
	*/
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		return getGEFWrapper(new DestroyReferenceCommand(req));
	}

}
