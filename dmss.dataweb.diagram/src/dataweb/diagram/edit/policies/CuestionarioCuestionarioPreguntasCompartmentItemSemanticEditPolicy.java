/*
* 
*/
package dataweb.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import dataweb.diagram.edit.commands.PreguntaOpcionMultipleCreateCommand;
import dataweb.diagram.edit.commands.PreguntaRespuestaCortaCreateCommand;
import dataweb.diagram.edit.commands.PreguntaVerdaderoFalsoCreateCommand;
import dataweb.diagram.providers.DatawebElementTypes;

/**
 * @generated
 */
public class CuestionarioCuestionarioPreguntasCompartmentItemSemanticEditPolicy
		extends DatawebBaseItemSemanticEditPolicy {

	/**
	* @generated
	*/
	public CuestionarioCuestionarioPreguntasCompartmentItemSemanticEditPolicy() {
		super(DatawebElementTypes.Cuestionario_2013);
	}

	/**
	* @generated
	*/
	protected Command getCreateCommand(CreateElementRequest req) {
		if (DatawebElementTypes.PreguntaOpcionMultiple_3002 == req.getElementType()) {
			return getGEFWrapper(new PreguntaOpcionMultipleCreateCommand(req));
		}
		if (DatawebElementTypes.PreguntaVerdaderoFalso_3004 == req.getElementType()) {
			return getGEFWrapper(new PreguntaVerdaderoFalsoCreateCommand(req));
		}
		if (DatawebElementTypes.PreguntaRespuestaCorta_3005 == req.getElementType()) {
			return getGEFWrapper(new PreguntaRespuestaCortaCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
