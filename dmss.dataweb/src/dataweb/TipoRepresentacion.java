/**
 */
package dataweb;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Tipo Representacion</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see dataweb.DatawebPackage#getTipoRepresentacion()
 * @model
 * @generated
 */
public enum TipoRepresentacion implements Enumerator {
	/**
	 * The '<em><b>TEXTO</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TEXTO_VALUE
	 * @generated
	 * @ordered
	 */
	TEXTO(0, "TEXTO", "TEXTO"),

	/**
	 * The '<em><b>BARRAS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BARRAS_VALUE
	 * @generated
	 * @ordered
	 */
	BARRAS(1, "BARRAS", "BARRAS"),

	/**
	 * The '<em><b>CIRCULAR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CIRCULAR_VALUE
	 * @generated
	 * @ordered
	 */
	CIRCULAR(2, "CIRCULAR", "CIRCULAR"),

	/**
	 * The '<em><b>LINEAS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LINEAS_VALUE
	 * @generated
	 * @ordered
	 */
	LINEAS(3, "LINEAS", "LINEAS");

	/**
	 * The '<em><b>TEXTO</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TEXTO
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TEXTO_VALUE = 0;

	/**
	 * The '<em><b>BARRAS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BARRAS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BARRAS_VALUE = 1;

	/**
	 * The '<em><b>CIRCULAR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CIRCULAR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CIRCULAR_VALUE = 2;

	/**
	 * The '<em><b>LINEAS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LINEAS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LINEAS_VALUE = 3;

	/**
	 * An array of all the '<em><b>Tipo Representacion</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final TipoRepresentacion[] VALUES_ARRAY =
		new TipoRepresentacion[] {
			TEXTO,
			BARRAS,
			CIRCULAR,
			LINEAS,
		};

	/**
	 * A public read-only list of all the '<em><b>Tipo Representacion</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<TipoRepresentacion> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Tipo Representacion</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static TipoRepresentacion get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TipoRepresentacion result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Tipo Representacion</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static TipoRepresentacion getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TipoRepresentacion result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Tipo Representacion</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static TipoRepresentacion get(int value) {
		switch (value) {
			case TEXTO_VALUE: return TEXTO;
			case BARRAS_VALUE: return BARRAS;
			case CIRCULAR_VALUE: return CIRCULAR;
			case LINEAS_VALUE: return LINEAS;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private TipoRepresentacion(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //TipoRepresentacion
