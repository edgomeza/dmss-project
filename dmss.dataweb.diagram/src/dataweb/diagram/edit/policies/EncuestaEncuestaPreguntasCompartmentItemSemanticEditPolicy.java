/*
* 
*/
package dataweb.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import dataweb.diagram.edit.commands.PreguntaOpcionMultiple2CreateCommand;
import dataweb.diagram.edit.commands.PreguntaRespuestaCorta2CreateCommand;
import dataweb.diagram.edit.commands.PreguntaVerdaderoFalso2CreateCommand;
import dataweb.diagram.providers.DatawebElementTypes;

/**
 * @generated
 */
public class EncuestaEncuestaPreguntasCompartmentItemSemanticEditPolicy extends DatawebBaseItemSemanticEditPolicy {

	/**
	* @generated
	*/
	public EncuestaEncuestaPreguntasCompartmentItemSemanticEditPolicy() {
		super(DatawebElementTypes.Encuesta_2014);
	}

	/**
	* @generated
	*/
	protected Command getCreateCommand(CreateElementRequest req) {
		if (DatawebElementTypes.PreguntaOpcionMultiple_3006 == req.getElementType()) {
			return getGEFWrapper(new PreguntaOpcionMultiple2CreateCommand(req));
		}
		if (DatawebElementTypes.PreguntaVerdaderoFalso_3007 == req.getElementType()) {
			return getGEFWrapper(new PreguntaVerdaderoFalso2CreateCommand(req));
		}
		if (DatawebElementTypes.PreguntaRespuestaCorta_3008 == req.getElementType()) {
			return getGEFWrapper(new PreguntaRespuestaCorta2CreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
