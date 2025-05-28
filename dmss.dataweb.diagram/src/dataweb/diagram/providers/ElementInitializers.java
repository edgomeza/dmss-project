/*
 * 
 */
package dataweb.diagram.providers;

import dataweb.diagram.part.DatawebDiagramEditorPlugin;

/**
 * @generated
 */
public class ElementInitializers {

	protected ElementInitializers() {
		// use #getInstance to access cached instance
	}

	/**
	* @generated
	*/
	public static ElementInitializers getInstance() {
		ElementInitializers cached = DatawebDiagramEditorPlugin.getInstance().getElementInitializers();
		if (cached == null) {
			DatawebDiagramEditorPlugin.getInstance().setElementInitializers(cached = new ElementInitializers());
		}
		return cached;
	}
}
