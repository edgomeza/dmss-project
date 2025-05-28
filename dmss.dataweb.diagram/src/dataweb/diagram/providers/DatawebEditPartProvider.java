/*
 * 
 */
package dataweb.diagram.providers;

import org.eclipse.gmf.tooling.runtime.providers.DefaultEditPartProvider;

import dataweb.diagram.edit.parts.AplicacionEditPart;
import dataweb.diagram.edit.parts.DatawebEditPartFactory;
import dataweb.diagram.part.DatawebVisualIDRegistry;

/**
 * @generated
 */
public class DatawebEditPartProvider extends DefaultEditPartProvider {

	/**
	* @generated
	*/
	public DatawebEditPartProvider() {
		super(new DatawebEditPartFactory(), DatawebVisualIDRegistry.TYPED_INSTANCE, AplicacionEditPart.MODEL_ID);
	}

}
