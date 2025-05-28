/*
* 
*/
package dataweb.diagram.navigator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonContentProvider;

import dataweb.diagram.edit.parts.AplicacionEditPart;
import dataweb.diagram.edit.parts.AtributoEditPart;
import dataweb.diagram.edit.parts.CuestionarioCuestionarioPreguntasCompartmentEditPart;
import dataweb.diagram.edit.parts.CuestionarioEditPart;
import dataweb.diagram.edit.parts.EncuestaEditPart;
import dataweb.diagram.edit.parts.EncuestaEncuestaPreguntasCompartmentEditPart;
import dataweb.diagram.edit.parts.EntidadEditPart;
import dataweb.diagram.edit.parts.EntidadEntidadAtributosCompartmentEditPart;
import dataweb.diagram.edit.parts.FuenteRSSEditPart;
import dataweb.diagram.edit.parts.OpcionRespuestaEditPart;
import dataweb.diagram.edit.parts.PaginaActualizacionEditPart;
import dataweb.diagram.edit.parts.PaginaBorradoEditPart;
import dataweb.diagram.edit.parts.PaginaCRUDEntidadEditPart;
import dataweb.diagram.edit.parts.PaginaContenidoEditPart;
import dataweb.diagram.edit.parts.PaginaCreacionEditPart;
import dataweb.diagram.edit.parts.PaginaDetalleEditPart;
import dataweb.diagram.edit.parts.PaginaEnlacesEditPart;
import dataweb.diagram.edit.parts.PaginaFuentesRSSEditPart;
import dataweb.diagram.edit.parts.PaginaHomeEditPart;
import dataweb.diagram.edit.parts.PaginaIndiceAtributosMostradosEditPart;
import dataweb.diagram.edit.parts.PaginaIndiceDetalleEditPart;
import dataweb.diagram.edit.parts.PaginaIndiceFiltrosAtributosFiltroEditPart;
import dataweb.diagram.edit.parts.PaginaIndiceFiltrosEditPart;
import dataweb.diagram.edit.parts.PaginaIndicePaginadaEditPart;
import dataweb.diagram.edit.parts.PaginaIndicePaginadaFiltradaAtributosFiltroEditPart;
import dataweb.diagram.edit.parts.PaginaIndicePaginadaFiltradaEditPart;
import dataweb.diagram.edit.parts.PaginaRedesSocialesEditPart;
import dataweb.diagram.edit.parts.PreguntaOpcionMultiple2EditPart;
import dataweb.diagram.edit.parts.PreguntaOpcionMultipleEditPart;
import dataweb.diagram.edit.parts.PreguntaOpcionMultiplePreguntaOpcionMultipleOpcionesCompartment2EditPart;
import dataweb.diagram.edit.parts.PreguntaOpcionMultiplePreguntaOpcionMultipleOpcionesCompartmentEditPart;
import dataweb.diagram.edit.parts.PreguntaOpcionMultipleRespuestaCorrectaEditPart;
import dataweb.diagram.edit.parts.PreguntaRespuestaCorta2EditPart;
import dataweb.diagram.edit.parts.PreguntaRespuestaCortaEditPart;
import dataweb.diagram.edit.parts.PreguntaVerdaderoFalso2EditPart;
import dataweb.diagram.edit.parts.PreguntaVerdaderoFalsoEditPart;
import dataweb.diagram.edit.parts.RedSocialEditPart;
import dataweb.diagram.edit.parts.ReferenciaEditPart;
import dataweb.diagram.edit.parts.RolEditPart;
import dataweb.diagram.edit.parts.RolPaginasAccesiblesEditPart;
import dataweb.diagram.part.DatawebVisualIDRegistry;
import dataweb.diagram.part.Messages;

/**
 * @generated
 */
public class DatawebNavigatorContentProvider implements ICommonContentProvider {

	/**
	* @generated
	*/
	private static final Object[] EMPTY_ARRAY = new Object[0];

	/**
	* @generated
	*/
	private Viewer myViewer;

	/**
	* @generated
	*/
	private AdapterFactoryEditingDomain myEditingDomain;

	/**
	* @generated
	*/
	private WorkspaceSynchronizer myWorkspaceSynchronizer;

	/**
	* @generated
	*/
	private Runnable myViewerRefreshRunnable;

	/**
	* @generated
	*/
	@SuppressWarnings({ "unchecked", "serial", "rawtypes" })
	public DatawebNavigatorContentProvider() {
		TransactionalEditingDomain editingDomain = GMFEditingDomainFactory.INSTANCE.createEditingDomain();
		myEditingDomain = (AdapterFactoryEditingDomain) editingDomain;
		myEditingDomain.setResourceToReadOnlyMap(new HashMap() {
			public Object get(Object key) {
				if (!containsKey(key)) {
					put(key, Boolean.TRUE);
				}
				return super.get(key);
			}
		});
		myViewerRefreshRunnable = new Runnable() {
			public void run() {
				if (myViewer != null) {
					myViewer.refresh();
				}
			}
		};
		myWorkspaceSynchronizer = new WorkspaceSynchronizer(editingDomain, new WorkspaceSynchronizer.Delegate() {
			public void dispose() {
			}

			public boolean handleResourceChanged(final Resource resource) {
				unloadAllResources();
				asyncRefresh();
				return true;
			}

			public boolean handleResourceDeleted(Resource resource) {
				unloadAllResources();
				asyncRefresh();
				return true;
			}

			public boolean handleResourceMoved(Resource resource, final URI newURI) {
				unloadAllResources();
				asyncRefresh();
				return true;
			}
		});
	}

	/**
	* @generated
	*/
	public void dispose() {
		myWorkspaceSynchronizer.dispose();
		myWorkspaceSynchronizer = null;
		myViewerRefreshRunnable = null;
		myViewer = null;
		unloadAllResources();
		((TransactionalEditingDomain) myEditingDomain).dispose();
		myEditingDomain = null;
	}

	/**
	* @generated
	*/
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		myViewer = viewer;
	}

	/**
	* @generated
	*/
	void unloadAllResources() {
		for (Resource nextResource : myEditingDomain.getResourceSet().getResources()) {
			nextResource.unload();
		}
	}

	/**
	* @generated
	*/
	void asyncRefresh() {
		if (myViewer != null && !myViewer.getControl().isDisposed()) {
			myViewer.getControl().getDisplay().asyncExec(myViewerRefreshRunnable);
		}
	}

	/**
	* @generated
	*/
	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	/**
	* @generated
	*/
	public void restoreState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void saveState(IMemento aMemento) {
	}

	/**
	* @generated
	*/
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	* @generated
	*/
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof IFile) {
			IFile file = (IFile) parentElement;
			URI fileURI = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
			Resource resource = myEditingDomain.getResourceSet().getResource(fileURI, true);
			ArrayList<DatawebNavigatorItem> result = new ArrayList<DatawebNavigatorItem>();
			ArrayList<View> topViews = new ArrayList<View>(resource.getContents().size());
			for (EObject o : resource.getContents()) {
				if (o instanceof View) {
					topViews.add((View) o);
				}
			}
			result.addAll(createNavigatorItems(selectViewsByType(topViews, AplicacionEditPart.MODEL_ID), file, false));
			return result.toArray();
		}

		if (parentElement instanceof DatawebNavigatorGroup) {
			DatawebNavigatorGroup group = (DatawebNavigatorGroup) parentElement;
			return group.getChildren();
		}

		if (parentElement instanceof DatawebNavigatorItem) {
			DatawebNavigatorItem navigatorItem = (DatawebNavigatorItem) parentElement;
			if (navigatorItem.isLeaf() || !isOwnView(navigatorItem.getView())) {
				return EMPTY_ARRAY;
			}
			return getViewChildren(navigatorItem.getView(), parentElement);
		}

		/*
		* Due to plugin.xml restrictions this code will be called only for views representing
		* shortcuts to this diagram elements created on other diagrams. 
		*/
		if (parentElement instanceof IAdaptable) {
			View view = (View) ((IAdaptable) parentElement).getAdapter(View.class);
			if (view != null) {
				return getViewChildren(view, parentElement);
			}
		}

		return EMPTY_ARRAY;
	}

	/**
	* @generated
	*/
	private Object[] getViewChildren(View view, Object parentElement) {
		switch (DatawebVisualIDRegistry.getVisualID(view)) {

		case AplicacionEditPart.VISUAL_ID: {
			LinkedList<DatawebAbstractNavigatorItem> result = new LinkedList<DatawebAbstractNavigatorItem>();
			result.addAll(getForeignShortcuts((Diagram) view, parentElement));
			Diagram sv = (Diagram) view;
			DatawebNavigatorGroup links = new DatawebNavigatorGroup(Messages.NavigatorGroupName_Aplicacion_1000_links,
					"icons/linksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaIndiceDetalleEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaIndicePaginadaEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaIndiceFiltrosEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaIndicePaginadaFiltradaEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaDetalleEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaCreacionEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaActualizacionEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaBorradoEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaHomeEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaContenidoEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(EntidadEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(RolEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(CuestionarioEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(EncuestaEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(RedSocialEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(FuenteRSSEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(ReferenciaEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaEnlacesEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaRedesSocialesEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaFuentesRSSEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaCRUDEntidadEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaIndiceAtributosMostradosEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PreguntaOpcionMultipleRespuestaCorrectaEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(RolPaginasAccesiblesEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaIndiceFiltrosAtributosFiltroEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaIndicePaginadaFiltradaAtributosFiltroEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			if (!links.isEmpty()) {
				result.add(links);
			}
			return result.toArray();
		}

		case PaginaIndiceDetalleEditPart.VISUAL_ID: {
			LinkedList<DatawebAbstractNavigatorItem> result = new LinkedList<DatawebAbstractNavigatorItem>();
			Node sv = (Node) view;
			DatawebNavigatorGroup incominglinks = new DatawebNavigatorGroup(
					Messages.NavigatorGroupName_PaginaIndiceDetalle_2001_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			DatawebNavigatorGroup outgoinglinks = new DatawebNavigatorGroup(
					Messages.NavigatorGroupName_PaginaIndiceDetalle_2001_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaEnlacesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaEnlacesEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaRedesSocialesEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaFuentesRSSEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaCRUDEntidadEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaIndiceAtributosMostradosEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(RolPaginasAccesiblesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case PaginaIndicePaginadaEditPart.VISUAL_ID: {
			LinkedList<DatawebAbstractNavigatorItem> result = new LinkedList<DatawebAbstractNavigatorItem>();
			Node sv = (Node) view;
			DatawebNavigatorGroup incominglinks = new DatawebNavigatorGroup(
					Messages.NavigatorGroupName_PaginaIndicePaginada_2002_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			DatawebNavigatorGroup outgoinglinks = new DatawebNavigatorGroup(
					Messages.NavigatorGroupName_PaginaIndicePaginada_2002_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaEnlacesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaEnlacesEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaRedesSocialesEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaFuentesRSSEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaCRUDEntidadEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaIndiceAtributosMostradosEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(RolPaginasAccesiblesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case PaginaIndiceFiltrosEditPart.VISUAL_ID: {
			LinkedList<DatawebAbstractNavigatorItem> result = new LinkedList<DatawebAbstractNavigatorItem>();
			Node sv = (Node) view;
			DatawebNavigatorGroup incominglinks = new DatawebNavigatorGroup(
					Messages.NavigatorGroupName_PaginaIndiceFiltros_2003_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			DatawebNavigatorGroup outgoinglinks = new DatawebNavigatorGroup(
					Messages.NavigatorGroupName_PaginaIndiceFiltros_2003_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaEnlacesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaEnlacesEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaRedesSocialesEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaFuentesRSSEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaCRUDEntidadEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaIndiceAtributosMostradosEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(RolPaginasAccesiblesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaIndiceFiltrosAtributosFiltroEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case PaginaIndicePaginadaFiltradaEditPart.VISUAL_ID: {
			LinkedList<DatawebAbstractNavigatorItem> result = new LinkedList<DatawebAbstractNavigatorItem>();
			Node sv = (Node) view;
			DatawebNavigatorGroup incominglinks = new DatawebNavigatorGroup(
					Messages.NavigatorGroupName_PaginaIndicePaginadaFiltrada_2004_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			DatawebNavigatorGroup outgoinglinks = new DatawebNavigatorGroup(
					Messages.NavigatorGroupName_PaginaIndicePaginadaFiltrada_2004_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaEnlacesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaEnlacesEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaRedesSocialesEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaFuentesRSSEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaCRUDEntidadEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaIndiceAtributosMostradosEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(RolPaginasAccesiblesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaIndicePaginadaFiltradaAtributosFiltroEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case PaginaDetalleEditPart.VISUAL_ID: {
			LinkedList<DatawebAbstractNavigatorItem> result = new LinkedList<DatawebAbstractNavigatorItem>();
			Node sv = (Node) view;
			DatawebNavigatorGroup incominglinks = new DatawebNavigatorGroup(
					Messages.NavigatorGroupName_PaginaDetalle_2005_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			DatawebNavigatorGroup outgoinglinks = new DatawebNavigatorGroup(
					Messages.NavigatorGroupName_PaginaDetalle_2005_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaEnlacesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaEnlacesEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaRedesSocialesEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaFuentesRSSEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaCRUDEntidadEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(RolPaginasAccesiblesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case PaginaCreacionEditPart.VISUAL_ID: {
			LinkedList<DatawebAbstractNavigatorItem> result = new LinkedList<DatawebAbstractNavigatorItem>();
			Node sv = (Node) view;
			DatawebNavigatorGroup incominglinks = new DatawebNavigatorGroup(
					Messages.NavigatorGroupName_PaginaCreacion_2006_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			DatawebNavigatorGroup outgoinglinks = new DatawebNavigatorGroup(
					Messages.NavigatorGroupName_PaginaCreacion_2006_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaEnlacesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaEnlacesEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaRedesSocialesEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaFuentesRSSEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaCRUDEntidadEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(RolPaginasAccesiblesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case PaginaActualizacionEditPart.VISUAL_ID: {
			LinkedList<DatawebAbstractNavigatorItem> result = new LinkedList<DatawebAbstractNavigatorItem>();
			Node sv = (Node) view;
			DatawebNavigatorGroup incominglinks = new DatawebNavigatorGroup(
					Messages.NavigatorGroupName_PaginaActualizacion_2007_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			DatawebNavigatorGroup outgoinglinks = new DatawebNavigatorGroup(
					Messages.NavigatorGroupName_PaginaActualizacion_2007_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaEnlacesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaEnlacesEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaRedesSocialesEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaFuentesRSSEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaCRUDEntidadEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(RolPaginasAccesiblesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case PaginaBorradoEditPart.VISUAL_ID: {
			LinkedList<DatawebAbstractNavigatorItem> result = new LinkedList<DatawebAbstractNavigatorItem>();
			Node sv = (Node) view;
			DatawebNavigatorGroup incominglinks = new DatawebNavigatorGroup(
					Messages.NavigatorGroupName_PaginaBorrado_2008_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			DatawebNavigatorGroup outgoinglinks = new DatawebNavigatorGroup(
					Messages.NavigatorGroupName_PaginaBorrado_2008_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaEnlacesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaEnlacesEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaRedesSocialesEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaFuentesRSSEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaCRUDEntidadEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(RolPaginasAccesiblesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case PaginaHomeEditPart.VISUAL_ID: {
			LinkedList<DatawebAbstractNavigatorItem> result = new LinkedList<DatawebAbstractNavigatorItem>();
			Node sv = (Node) view;
			DatawebNavigatorGroup incominglinks = new DatawebNavigatorGroup(
					Messages.NavigatorGroupName_PaginaHome_2009_incominglinks, "icons/incomingLinksNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			DatawebNavigatorGroup outgoinglinks = new DatawebNavigatorGroup(
					Messages.NavigatorGroupName_PaginaHome_2009_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaEnlacesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaEnlacesEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaRedesSocialesEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaFuentesRSSEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(RolPaginasAccesiblesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case PaginaContenidoEditPart.VISUAL_ID: {
			LinkedList<DatawebAbstractNavigatorItem> result = new LinkedList<DatawebAbstractNavigatorItem>();
			Node sv = (Node) view;
			DatawebNavigatorGroup incominglinks = new DatawebNavigatorGroup(
					Messages.NavigatorGroupName_PaginaContenido_2010_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			DatawebNavigatorGroup outgoinglinks = new DatawebNavigatorGroup(
					Messages.NavigatorGroupName_PaginaContenido_2010_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaEnlacesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaEnlacesEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaRedesSocialesEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaFuentesRSSEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(RolPaginasAccesiblesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case EntidadEditPart.VISUAL_ID: {
			LinkedList<DatawebAbstractNavigatorItem> result = new LinkedList<DatawebAbstractNavigatorItem>();
			Node sv = (Node) view;
			DatawebNavigatorGroup incominglinks = new DatawebNavigatorGroup(
					Messages.NavigatorGroupName_Entidad_2011_incominglinks, "icons/incomingLinksNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			DatawebNavigatorGroup outgoinglinks = new DatawebNavigatorGroup(
					Messages.NavigatorGroupName_Entidad_2011_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(EntidadEntidadAtributosCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					DatawebVisualIDRegistry.getType(AtributoEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(ReferenciaEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(ReferenciaEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaCRUDEntidadEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case RolEditPart.VISUAL_ID: {
			LinkedList<DatawebAbstractNavigatorItem> result = new LinkedList<DatawebAbstractNavigatorItem>();
			Node sv = (Node) view;
			DatawebNavigatorGroup outgoinglinks = new DatawebNavigatorGroup(
					Messages.NavigatorGroupName_Rol_2012_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(RolPaginasAccesiblesEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case CuestionarioEditPart.VISUAL_ID: {
			LinkedList<DatawebAbstractNavigatorItem> result = new LinkedList<DatawebAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(CuestionarioCuestionarioPreguntasCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					DatawebVisualIDRegistry.getType(PreguntaOpcionMultipleEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(CuestionarioCuestionarioPreguntasCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					DatawebVisualIDRegistry.getType(PreguntaVerdaderoFalsoEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(CuestionarioCuestionarioPreguntasCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					DatawebVisualIDRegistry.getType(PreguntaRespuestaCortaEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case EncuestaEditPart.VISUAL_ID: {
			LinkedList<DatawebAbstractNavigatorItem> result = new LinkedList<DatawebAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(EncuestaEncuestaPreguntasCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					DatawebVisualIDRegistry.getType(PreguntaOpcionMultiple2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(EncuestaEncuestaPreguntasCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					DatawebVisualIDRegistry.getType(PreguntaVerdaderoFalso2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(EncuestaEncuestaPreguntasCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					DatawebVisualIDRegistry.getType(PreguntaRespuestaCorta2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case RedSocialEditPart.VISUAL_ID: {
			LinkedList<DatawebAbstractNavigatorItem> result = new LinkedList<DatawebAbstractNavigatorItem>();
			Node sv = (Node) view;
			DatawebNavigatorGroup incominglinks = new DatawebNavigatorGroup(
					Messages.NavigatorGroupName_RedSocial_2015_incominglinks, "icons/incomingLinksNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaRedesSocialesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case FuenteRSSEditPart.VISUAL_ID: {
			LinkedList<DatawebAbstractNavigatorItem> result = new LinkedList<DatawebAbstractNavigatorItem>();
			Node sv = (Node) view;
			DatawebNavigatorGroup incominglinks = new DatawebNavigatorGroup(
					Messages.NavigatorGroupName_FuenteRSS_2016_incominglinks, "icons/incomingLinksNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaFuentesRSSEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case AtributoEditPart.VISUAL_ID: {
			LinkedList<DatawebAbstractNavigatorItem> result = new LinkedList<DatawebAbstractNavigatorItem>();
			Node sv = (Node) view;
			DatawebNavigatorGroup incominglinks = new DatawebNavigatorGroup(
					Messages.NavigatorGroupName_Atributo_3001_incominglinks, "icons/incomingLinksNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaIndiceAtributosMostradosEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaIndiceFiltrosAtributosFiltroEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaIndicePaginadaFiltradaAtributosFiltroEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case PreguntaOpcionMultipleEditPart.VISUAL_ID: {
			LinkedList<DatawebAbstractNavigatorItem> result = new LinkedList<DatawebAbstractNavigatorItem>();
			Node sv = (Node) view;
			DatawebNavigatorGroup outgoinglinks = new DatawebNavigatorGroup(
					Messages.NavigatorGroupName_PreguntaOpcionMultiple_3002_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv), DatawebVisualIDRegistry
					.getType(PreguntaOpcionMultiplePreguntaOpcionMultipleOpcionesCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					DatawebVisualIDRegistry.getType(OpcionRespuestaEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PreguntaOpcionMultipleRespuestaCorrectaEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case OpcionRespuestaEditPart.VISUAL_ID: {
			LinkedList<DatawebAbstractNavigatorItem> result = new LinkedList<DatawebAbstractNavigatorItem>();
			Node sv = (Node) view;
			DatawebNavigatorGroup incominglinks = new DatawebNavigatorGroup(
					Messages.NavigatorGroupName_OpcionRespuesta_3003_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PreguntaOpcionMultipleRespuestaCorrectaEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case PreguntaOpcionMultiple2EditPart.VISUAL_ID: {
			LinkedList<DatawebAbstractNavigatorItem> result = new LinkedList<DatawebAbstractNavigatorItem>();
			Node sv = (Node) view;
			DatawebNavigatorGroup outgoinglinks = new DatawebNavigatorGroup(
					Messages.NavigatorGroupName_PreguntaOpcionMultiple_3006_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv), DatawebVisualIDRegistry
					.getType(PreguntaOpcionMultiplePreguntaOpcionMultipleOpcionesCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					DatawebVisualIDRegistry.getType(OpcionRespuestaEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PreguntaOpcionMultipleRespuestaCorrectaEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case ReferenciaEditPart.VISUAL_ID: {
			LinkedList<DatawebAbstractNavigatorItem> result = new LinkedList<DatawebAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			DatawebNavigatorGroup target = new DatawebNavigatorGroup(Messages.NavigatorGroupName_Referencia_4001_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			DatawebNavigatorGroup source = new DatawebNavigatorGroup(Messages.NavigatorGroupName_Referencia_4001_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(EntidadEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(EntidadEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case PaginaEnlacesEditPart.VISUAL_ID: {
			LinkedList<DatawebAbstractNavigatorItem> result = new LinkedList<DatawebAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			DatawebNavigatorGroup target = new DatawebNavigatorGroup(
					Messages.NavigatorGroupName_PaginaEnlaces_4002_target, "icons/linkTargetNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			DatawebNavigatorGroup source = new DatawebNavigatorGroup(
					Messages.NavigatorGroupName_PaginaEnlaces_4002_source, "icons/linkSourceNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaIndiceDetalleEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaIndicePaginadaEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaIndiceFiltrosEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaIndicePaginadaFiltradaEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaDetalleEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaCreacionEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaActualizacionEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaBorradoEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaHomeEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaContenidoEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaIndiceDetalleEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaIndicePaginadaEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaIndiceFiltrosEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaIndicePaginadaFiltradaEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaDetalleEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaCreacionEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaActualizacionEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaBorradoEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaHomeEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaContenidoEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case PaginaRedesSocialesEditPart.VISUAL_ID: {
			LinkedList<DatawebAbstractNavigatorItem> result = new LinkedList<DatawebAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			DatawebNavigatorGroup target = new DatawebNavigatorGroup(
					Messages.NavigatorGroupName_PaginaRedesSociales_4003_target, "icons/linkTargetNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			DatawebNavigatorGroup source = new DatawebNavigatorGroup(
					Messages.NavigatorGroupName_PaginaRedesSociales_4003_source, "icons/linkSourceNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(RedSocialEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaIndiceDetalleEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaIndicePaginadaEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaIndiceFiltrosEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaIndicePaginadaFiltradaEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaDetalleEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaCreacionEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaActualizacionEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaBorradoEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaHomeEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaContenidoEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case PaginaFuentesRSSEditPart.VISUAL_ID: {
			LinkedList<DatawebAbstractNavigatorItem> result = new LinkedList<DatawebAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			DatawebNavigatorGroup target = new DatawebNavigatorGroup(
					Messages.NavigatorGroupName_PaginaFuentesRSS_4004_target, "icons/linkTargetNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			DatawebNavigatorGroup source = new DatawebNavigatorGroup(
					Messages.NavigatorGroupName_PaginaFuentesRSS_4004_source, "icons/linkSourceNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(FuenteRSSEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaIndiceDetalleEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaIndicePaginadaEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaIndiceFiltrosEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaIndicePaginadaFiltradaEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaDetalleEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaCreacionEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaActualizacionEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaBorradoEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaHomeEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaContenidoEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case PaginaCRUDEntidadEditPart.VISUAL_ID: {
			LinkedList<DatawebAbstractNavigatorItem> result = new LinkedList<DatawebAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			DatawebNavigatorGroup target = new DatawebNavigatorGroup(
					Messages.NavigatorGroupName_PaginaCRUDEntidad_4005_target, "icons/linkTargetNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			DatawebNavigatorGroup source = new DatawebNavigatorGroup(
					Messages.NavigatorGroupName_PaginaCRUDEntidad_4005_source, "icons/linkSourceNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(EntidadEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaIndiceDetalleEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaIndicePaginadaEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaIndiceFiltrosEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaIndicePaginadaFiltradaEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaDetalleEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaCreacionEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaActualizacionEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaBorradoEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case PaginaIndiceAtributosMostradosEditPart.VISUAL_ID: {
			LinkedList<DatawebAbstractNavigatorItem> result = new LinkedList<DatawebAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			DatawebNavigatorGroup target = new DatawebNavigatorGroup(
					Messages.NavigatorGroupName_PaginaIndiceAtributosMostrados_4006_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			DatawebNavigatorGroup source = new DatawebNavigatorGroup(
					Messages.NavigatorGroupName_PaginaIndiceAtributosMostrados_4006_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(AtributoEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaIndiceDetalleEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaIndicePaginadaEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaIndiceFiltrosEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaIndicePaginadaFiltradaEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case PreguntaOpcionMultipleRespuestaCorrectaEditPart.VISUAL_ID: {
			LinkedList<DatawebAbstractNavigatorItem> result = new LinkedList<DatawebAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			DatawebNavigatorGroup target = new DatawebNavigatorGroup(
					Messages.NavigatorGroupName_PreguntaOpcionMultipleRespuestaCorrecta_4007_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			DatawebNavigatorGroup source = new DatawebNavigatorGroup(
					Messages.NavigatorGroupName_PreguntaOpcionMultipleRespuestaCorrecta_4007_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(OpcionRespuestaEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PreguntaOpcionMultipleEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PreguntaOpcionMultiple2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case RolPaginasAccesiblesEditPart.VISUAL_ID: {
			LinkedList<DatawebAbstractNavigatorItem> result = new LinkedList<DatawebAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			DatawebNavigatorGroup target = new DatawebNavigatorGroup(
					Messages.NavigatorGroupName_RolPaginasAccesibles_4008_target, "icons/linkTargetNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			DatawebNavigatorGroup source = new DatawebNavigatorGroup(
					Messages.NavigatorGroupName_RolPaginasAccesibles_4008_source, "icons/linkSourceNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaIndiceDetalleEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaIndicePaginadaEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaIndiceFiltrosEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaIndicePaginadaFiltradaEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaDetalleEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaCreacionEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaActualizacionEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaBorradoEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaHomeEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaContenidoEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(RolEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case PaginaIndiceFiltrosAtributosFiltroEditPart.VISUAL_ID: {
			LinkedList<DatawebAbstractNavigatorItem> result = new LinkedList<DatawebAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			DatawebNavigatorGroup target = new DatawebNavigatorGroup(
					Messages.NavigatorGroupName_PaginaIndiceFiltrosAtributosFiltro_4009_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			DatawebNavigatorGroup source = new DatawebNavigatorGroup(
					Messages.NavigatorGroupName_PaginaIndiceFiltrosAtributosFiltro_4009_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(AtributoEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaIndiceFiltrosEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case PaginaIndicePaginadaFiltradaAtributosFiltroEditPart.VISUAL_ID: {
			LinkedList<DatawebAbstractNavigatorItem> result = new LinkedList<DatawebAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			DatawebNavigatorGroup target = new DatawebNavigatorGroup(
					Messages.NavigatorGroupName_PaginaIndicePaginadaFiltradaAtributosFiltro_4010_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			DatawebNavigatorGroup source = new DatawebNavigatorGroup(
					Messages.NavigatorGroupName_PaginaIndicePaginadaFiltradaAtributosFiltro_4010_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(AtributoEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					DatawebVisualIDRegistry.getType(PaginaIndicePaginadaFiltradaEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}
		}
		return EMPTY_ARRAY;
	}

	/**
	* @generated
	*/
	private Collection<View> getLinksSourceByType(Collection<Edge> edges, String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (Edge nextEdge : edges) {
			View nextEdgeSource = nextEdge.getSource();
			if (type.equals(nextEdgeSource.getType()) && isOwnView(nextEdgeSource)) {
				result.add(nextEdgeSource);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getLinksTargetByType(Collection<Edge> edges, String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (Edge nextEdge : edges) {
			View nextEdgeTarget = nextEdge.getTarget();
			if (type.equals(nextEdgeTarget.getType()) && isOwnView(nextEdgeTarget)) {
				result.add(nextEdgeTarget);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getOutgoingLinksByType(Collection<? extends View> nodes, String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (View nextNode : nodes) {
			result.addAll(selectViewsByType(nextNode.getSourceEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getIncomingLinksByType(Collection<? extends View> nodes, String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (View nextNode : nodes) {
			result.addAll(selectViewsByType(nextNode.getTargetEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getChildrenByType(Collection<? extends View> nodes, String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (View nextNode : nodes) {
			result.addAll(selectViewsByType(nextNode.getChildren(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getDiagramLinksByType(Collection<Diagram> diagrams, String type) {
		ArrayList<View> result = new ArrayList<View>();
		for (Diagram nextDiagram : diagrams) {
			result.addAll(selectViewsByType(nextDiagram.getEdges(), type));
		}
		return result;
	}

	// TODO refactor as static method
	/**
	 * @generated
	 */
	private Collection<View> selectViewsByType(Collection<View> views, String type) {
		ArrayList<View> result = new ArrayList<View>();
		for (View nextView : views) {
			if (type.equals(nextView.getType()) && isOwnView(nextView)) {
				result.add(nextView);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return AplicacionEditPart.MODEL_ID.equals(DatawebVisualIDRegistry.getModelID(view));
	}

	/**
	 * @generated
	 */
	private Collection<DatawebNavigatorItem> createNavigatorItems(Collection<View> views, Object parent,
			boolean isLeafs) {
		ArrayList<DatawebNavigatorItem> result = new ArrayList<DatawebNavigatorItem>(views.size());
		for (View nextView : views) {
			result.add(new DatawebNavigatorItem(nextView, parent, isLeafs));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<DatawebNavigatorItem> getForeignShortcuts(Diagram diagram, Object parent) {
		LinkedList<View> result = new LinkedList<View>();
		for (Iterator<View> it = diagram.getChildren().iterator(); it.hasNext();) {
			View nextView = it.next();
			if (!isOwnView(nextView) && nextView.getEAnnotation("Shortcut") != null) { //$NON-NLS-1$
				result.add(nextView);
			}
		}
		return createNavigatorItems(result, parent, false);
	}

	/**
	* @generated
	*/
	public Object getParent(Object element) {
		if (element instanceof DatawebAbstractNavigatorItem) {
			DatawebAbstractNavigatorItem abstractNavigatorItem = (DatawebAbstractNavigatorItem) element;
			return abstractNavigatorItem.getParent();
		}
		return null;
	}

	/**
	* @generated
	*/
	public boolean hasChildren(Object element) {
		return element instanceof IFile || getChildren(element).length > 0;
	}

}
