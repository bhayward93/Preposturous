package enums;


import java.util.HashMap;
import java.util.Map;
/**
 * Enumerator for defining and modifying a Appointment's status selections.
 */
public enum AppointmentStatus {
    DUE (0,1), //Second bit in place of string "appointment complete,cancelled or due".
    COMPLETED (1, 0),
    CANCELLED (2, 10);

    private byte value;
    private int label;

    // Create a hashmap of all available literals that can be accessed using the correct byte value.
    private static Map<Byte, AppointmentStatus> map = new HashMap<Byte, AppointmentStatus>();

    static {
        for (AppointmentStatus status: AppointmentStatus.values()) {
            map.put(status.value, status);
        }
    }

    /**
     * Constructor for a new AppointmentStatus enum.
     *
     * @param v The numerical value representing the value given to the specified literal.
     * @param l The numerical value representing the literal's corresponding entry in strings.xml
     */
    AppointmentStatus(int v, int l) {
        this.value = (byte) v;
        this.label = l;
    }

    /**
     * Returns the value representing the chosen status literal.
     *
     * @return A byte value representing the chosen status literal.
     */
    public byte getValue() {
        return value;
    }

    /**
     * Returns the value representing the status literal's corresponding entry in strings.xml
     * (may require casting to int in order to be usable)
     *
     * @return A byre value representing the status literal's corresponding entry in strings.xml
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
    public static AppointmentStatus valueOf(byte value) {
        return map.get(value);
    }
}
