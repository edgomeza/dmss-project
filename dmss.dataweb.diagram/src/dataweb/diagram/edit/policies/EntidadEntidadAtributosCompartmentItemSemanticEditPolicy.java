/*
* 
*/
package dataweb.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import dataweb.diagram.edit.commands.AtributoCreateCommand;
import dataweb.diagram.providers.DatawebElementTypes;

/**
 * @generated
 */
public class EntidadEntidadAtributosCompartmentItemSemanticEditPolicy extends DatawebBaseItemSemanticEditPolicy {

	/**
	* @generated
	*/
	public EntidadEntidadAtributosCompartmentItemSemanticEditPolicy() {
		super(DatawebElementTypes.Entidad_2011);
	}

	/**
	* @generated
	*/
	protected Command getCreateCommand(CreateElementRequest req) {
		if (DatawebElementTypes.Atributo_3001 == req.getElementType()) {
			return getGEFWrapper(new AtributoCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
