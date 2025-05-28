/**
 */
package dataweb;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Tipo Red Social</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see dataweb.DatawebPackage#getTipoRedSocial()
 * @model
 * @generated
 */
public enum TipoRedSocial implements Enumerator {
	/**
	 * The '<em><b>TWITTER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TWITTER_VALUE
	 * @generated
	 * @ordered
	 */
	TWITTER(0, "TWITTER", "TWITTER"),

	/**
	 * The '<em><b>FACEBOOK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FACEBOOK_VALUE
	 * @generated
	 * @ordered
	 */
	FACEBOOK(1, "FACEBOOK", "FACEBOOK"),

	/**
	 * The '<em><b>INSTAGRAM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INSTAGRAM_VALUE
	 * @generated
	 * @ordered
	 */
	INSTAGRAM(2, "INSTAGRAM", "INSTAGRAM"),

	/**
	 * The '<em><b>LINKEDIN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LINKEDIN_VALUE
	 * @generated
	 * @ordered
	 */
	LINKEDIN(3, "LINKEDIN", "LINKEDIN");

	/**
	 * The '<em><b>TWITTER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TWITTER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TWITTER_VALUE = 0;

	/**
	 * The '<em><b>FACEBOOK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FACEBOOK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FACEBOOK_VALUE = 1;

	/**
	 * The '<em><b>INSTAGRAM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INSTAGRAM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INSTAGRAM_VALUE = 2;

	/**
	 * The '<em><b>LINKEDIN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LINKEDIN
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LINKEDIN_VALUE = 3;

	/**
	 * An array of all the '<em><b>Tipo Red Social</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final TipoRedSocial[] VALUES_ARRAY =
		new TipoRedSocial[] {
			TWITTER,
			FACEBOOK,
			INSTAGRAM,
			LINKEDIN,
		};

	/**
	 * A public read-only list of all the '<em><b>Tipo Red Social</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<TipoRedSocial> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Tipo Red Social</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static TipoRedSocial get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TipoRedSocial result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Tipo Red Social</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static TipoRedSocial getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TipoRedSocial result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Tipo Red Social</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static TipoRedSocial get(int value) {
		switch (value) {
			case TWITTER_VALUE: return TWITTER;
			case FACEBOOK_VALUE: return FACEBOOK;
			case INSTAGRAM_VALUE: return INSTAGRAM;
			case LINKEDIN_VALUE: return LINKEDIN;
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
	private TipoRedSocial(int value, String name, String literal) {
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
	
} //TipoRedSocial
