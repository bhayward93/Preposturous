package enums;
import java.util.HashMap;
import java.util.Map;


/**
 * Enumerator for specifying and denoting a PhotoView's type.
 */
public enum ViewType
{
    PRESET (0, 1),
    CUSTOM (1, 2),
    CONFIG (2, 3);

    private byte value;
    private int label;

    // Create a hashmap of all available literals that can be accessed using the correct byte value.
    private static Map<Byte, ViewType> map = new HashMap<Byte, ViewType>();

    static {
        for (ViewType status: ViewType.values()) {
            map.put(status.value, status);
        }
    }

    /**
     * Constructor for a new ViewType enum.
     *
     * @param v The numerical value representing the value given to the specified literal.
     * @param l The numerical value representing the literal's corresponding entry in strings.xml
     */
    ViewType(int v, int l)
    {
        this.value = (byte) v;
        this.label = l;
    }

    /**
     * Returns the value representing the chosen type literal.
     *
     * @return A byte value representing the chosen type literal.
     */
    public byte getValue()
    {
        return value;
    }

    /**
     * Returns the value representing the type literal's corresponding entry in strings.xml
     * (may require casting to int in order to be usable)
     *
     * @return A byre value representing the type literal's corresponding entry in strings.xml
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
    public static ViewType valueOf(byte value) {
        return map.get(value);
    }
}