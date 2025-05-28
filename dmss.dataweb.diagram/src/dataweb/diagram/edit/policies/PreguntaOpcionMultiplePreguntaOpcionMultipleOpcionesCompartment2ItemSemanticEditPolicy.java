/*
* 
*/
package dataweb.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import dataweb.diagram.edit.commands.OpcionRespuestaCreateCommand;
import dataweb.diagram.providers.DatawebElementTypes;

/**
 * @generated
 */
public class PreguntaOpcionMultiplePreguntaOpcionMultipleOpcionesCompartment2ItemSemanticEditPolicy
		extends DatawebBaseItemSemanticEditPolicy {

	/**
	* @generated
	*/
	public PreguntaOpcionMultiplePreguntaOpcionMultipleOpcionesCompartment2ItemSemanticEditPolicy() {
		super(DatawebElementTypes.PreguntaOpcionMultiple_3006);
	}

	/**
	* @generated
	*/
	protected Command getCreateCommand(CreateElementRequest req) {
		if (DatawebElementTypes.OpcionRespuesta_3003 == req.getElementType()) {
			return getGEFWrapper(new OpcionRespuestaCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
