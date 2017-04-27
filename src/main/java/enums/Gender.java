package enums;

import java.util.HashMap;
import java.util.Map;


/**
 * Enumerator for defining and modifying a Patient's gender selections.
 */
public enum Gender
{
    MALE (1, 1),
    FEMALE (2, 2),
    TRANSGENDER (4, 3),
    NON_BINARY (8, 4);

    private byte value;
    private int label;

    // Create a hashmap of all available literals that can be accessed using the correct byte value.
    private static Map<Byte, Gender> map = new HashMap<Byte, Gender>();

    static {
        for (Gender status: Gender.values()) {
            map.put(status.value, status);
        }
    }

    /**
     * Constructor for a new Gender enum.
     *
     * @param v The numerical value representing the value given to the specified literal.
     * @param l The numerical value representing the literal's corresponding entry in strings.xml
     */
    Gender(int v, int l)
    {
        this.value = (byte) v;
        this.label = l;
    }

    /**
     * Returns the value representing the chosen gender literal.
     *
     * @return A byte value representing the chosen gender literal.
     */
    public byte getValue()
    {
        return value;
    }

    /**
     * Returns the value representing the gender literal's corresponding entry in strings.xml
     * (may require casting to int in order to be usable)
     *
     * @return A byre value representing the gender literal's corresponding entry in strings.xml
     */
    public int getLabel() {
        return label;
    }

    /**
     * Returns the literal corresponding to the byte value to which that literal corresponds.
     * Allows for extracted byte data to be converted to a literal.
     *
     * @param value The byte value representing the intended literal.
     * @return      The literal to which the provided value corresponds, if it exists.
     */
    public static Gender valueOf(byte value) {
        return map.get(value);
    }
}