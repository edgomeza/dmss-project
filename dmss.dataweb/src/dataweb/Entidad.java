/**
 */
package dataweb;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entidad</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dataweb.Entidad#getNombre <em>Nombre</em>}</li>
 *   <li>{@link dataweb.Entidad#getTableName <em>Table Name</em>}</li>
 *   <li>{@link dataweb.Entidad#isHasCRUD <em>Has CRUD</em>}</li>
 *   <li>{@link dataweb.Entidad#isHasIndex <em>Has Index</em>}</li>
 *   <li>{@link dataweb.Entidad#isHasExtendedIndex <em>Has Extended Index</em>}</li>
 *   <li>{@link dataweb.Entidad#isHasDetails <em>Has Details</em>}</li>
 *   <li>{@link dataweb.Entidad#isHasCreate <em>Has Create</em>}</li>
 *   <li>{@link dataweb.Entidad#isHasUpdate <em>Has Update</em>}</li>
 *   <li>{@link dataweb.Entidad#isHasDelete <em>Has Delete</em>}</li>
 *   <li>{@link dataweb.Entidad#getAtributos <em>Atributos</em>}</li>
 *   <li>{@link dataweb.Entidad#getReferencias <em>Referencias</em>}</li>
 * </ul>
 *
 * @see dataweb.DatawebPackage#getEntidad()
 * @model annotation="gmf.node label='nombre' color='200,200,255'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='R02_crud_incompatible R03_indice_requiere_detalle R05_no_autorreferencia R06_no_referencia_circular R08_solo_una_pagina_indice R09_atributos_pertenecen_entidad'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot R02_crud_incompatible='self.hasCRUD implies (not self.hasIndex and not self.hasExtendedIndex and not self.hasDetails and not self.hasCreate and not self.hasUpdate and not self.hasDelete)' R03_indice_requiere_detalle='(self.hasIndex or self.hasExtendedIndex) implies self.hasDetails' R05_no_autorreferencia='self.referencias-&gt;forAll(r | r.target &lt;&gt; self)' R06_no_referencia_circular='self.referencias-&gt;forAll(r | r.target.referencias-&gt;forAll(r2 | r2.target &lt;&gt; self))' R08_solo_una_pagina_indice='Pagina.allInstances()-&gt;select(p | p.oclIsKindOf(PaginaIndice) and p.oclAsType(PaginaCRUD).entidad = self)-&gt;size() &lt;= 1' R09_atributos_pertenecen_entidad='Pagina.allInstances()-&gt;select(p | p.oclIsKindOf(PaginaIndice))-&gt;forAll(pi | pi.oclAsType(PaginaIndice).atributosMostrados-&gt;forAll(a | a.oclContainer() = pi.oclAsType(PaginaCRUD).entidad))'"
 * @generated
 */
public interface Entidad extends EObject {
	/**
	 * Returns the value of the '<em><b>Nombre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nombre</em>' attribute.
	 * @see #setNombre(String)
	 * @see dataweb.DatawebPackage#getEntidad_Nombre()
	 * @model required="true"
	 * @generated
	 */
	String getNombre();

	/**
	 * Sets the value of the '{@link dataweb.Entidad#getNombre <em>Nombre</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nombre</em>' attribute.
	 * @see #getNombre()
	 * @generated
	 */
	void setNombre(String value);

	/**
	 * Returns the value of the '<em><b>Table Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Table Name</em>' attribute.
	 * @see #setTableName(String)
	 * @see dataweb.DatawebPackage#getEntidad_TableName()
	 * @model required="true"
	 * @generated
	 */
	String getTableName();

	/**
	 * Sets the value of the '{@link dataweb.Entidad#getTableName <em>Table Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Table Name</em>' attribute.
	 * @see #getTableName()
	 * @generated
	 */
	void setTableName(String value);

	/**
	 * Returns the value of the '<em><b>Has CRUD</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has CRUD</em>' attribute.
	 * @see #setHasCRUD(boolean)
	 * @see dataweb.DatawebPackage#getEntidad_HasCRUD()
	 * @model required="true"
	 * @generated
	 */
	boolean isHasCRUD();

	/**
	 * Sets the value of the '{@link dataweb.Entidad#isHasCRUD <em>Has CRUD</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Has CRUD</em>' attribute.
	 * @see #isHasCRUD()
	 * @generated
	 */
	void setHasCRUD(boolean value);

	/**
	 * Returns the value of the '<em><b>Has Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Index</em>' attribute.
	 * @see #setHasIndex(boolean)
	 * @see dataweb.DatawebPackage#getEntidad_HasIndex()
	 * @model required="true"
	 * @generated
	 */
	boolean isHasIndex();

	/**
	 * Sets the value of the '{@link dataweb.Entidad#isHasIndex <em>Has Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Has Index</em>' attribute.
	 * @see #isHasIndex()
	 * @generated
	 */
	void setHasIndex(boolean value);

	/**
	 * Returns the value of the '<em><b>Has Extended Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Extended Index</em>' attribute.
	 * @see #setHasExtendedIndex(boolean)
	 * @see dataweb.DatawebPackage#getEntidad_HasExtendedIndex()
	 * @model required="true"
	 * @generated
	 */
	boolean isHasExtendedIndex();

	/**
	 * Sets the value of the '{@link dataweb.Entidad#isHasExtendedIndex <em>Has Extended Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Has Extended Index</em>' attribute.
	 * @see #isHasExtendedIndex()
	 * @generated
	 */
	void setHasExtendedIndex(boolean value);

	/**
	 * Returns the value of the '<em><b>Has Details</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Details</em>' attribute.
	 * @see #setHasDetails(boolean)
	 * @see dataweb.DatawebPackage#getEntidad_HasDetails()
	 * @model required="true"
	 * @generated
	 */
	boolean isHasDetails();

	/**
	 * Sets the value of the '{@link dataweb.Entidad#isHasDetails <em>Has Details</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Has Details</em>' attribute.
	 * @see #isHasDetails()
	 * @generated
	 */
	void setHasDetails(boolean value);

	/**
	 * Returns the value of the '<em><b>Has Create</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Create</em>' attribute.
	 * @see #setHasCreate(boolean)
	 * @see dataweb.DatawebPackage#getEntidad_HasCreate()
	 * @model required="true"
	 * @generated
	 */
	boolean isHasCreate();

	/**
	 * Sets the value of the '{@link dataweb.Entidad#isHasCreate <em>Has Create</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Has Create</em>' attribute.
	 * @see #isHasCreate()
	 * @generated
	 */
	void setHasCreate(boolean value);

	/**
	 * Returns the value of the '<em><b>Has Update</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Update</em>' attribute.
	 * @see #setHasUpdate(boolean)
	 * @see dataweb.DatawebPackage#getEntidad_HasUpdate()
	 * @model required="true"
	 * @generated
	 */
	boolean isHasUpdate();

	/**
	 * Sets the value of the '{@link dataweb.Entidad#isHasUpdate <em>Has Update</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Has Update</em>' attribute.
	 * @see #isHasUpdate()
	 * @generated
	 */
	void setHasUpdate(boolean value);

	/**
	 * Returns the value of the '<em><b>Has Delete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Delete</em>' attribute.
	 * @see #setHasDelete(boolean)
	 * @see dataweb.DatawebPackage#getEntidad_HasDelete()
	 * @model required="true"
	 * @generated
	 */
	boolean isHasDelete();

	/**
	 * Sets the value of the '{@link dataweb.Entidad#isHasDelete <em>Has Delete</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Has Delete</em>' attribute.
	 * @see #isHasDelete()
	 * @generated
	 */
	void setHasDelete(boolean value);

	/**
	 * Returns the value of the '<em><b>Atributos</b></em>' containment reference list.
	 * The list contents are of type {@link dataweb.Atributo}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Atributos</em>' containment reference list.
	 * @see dataweb.DatawebPackage#getEntidad_Atributos()
	 * @model containment="true" required="true"
	 *        annotation="gmf.compartment"
	 * @generated
	 */
	EList<Atributo> getAtributos();

	/**
	 * Returns the value of the '<em><b>Referencias</b></em>' containment reference list.
	 * The list contents are of type {@link dataweb.Referencia}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referencias</em>' containment reference list.
	 * @see dataweb.DatawebPackage#getEntidad_Referencias()
	 * @model containment="true"
	 *        annotation="gmf.compartment"
	 * @generated
	 */
	EList<Referencia> getReferencias();

} // Entidad
