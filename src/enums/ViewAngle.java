package enums;

import java.util.HashMap;
import java.util.Map;


/**
 * Enumerator for specifying and denoting a PhotoView's angle.
 */
public enum ViewAngle
{
    FRONT (0, 1),
    BACK  (1, 2),
    LEFT  (2, 3),
    RIGHT (3, 4);

    private byte value;
    private int label;

    // Create a hashmap of all available literals that can be accessed using the correct byte value.
    private static Map<Byte, ViewAngle> map = new HashMap<Byte, ViewAngle>();

    static {
        for (ViewAngle status: ViewAngle.values()) {
            map.put(status.value, status);
        }
    }

    /**
     * Constructor for a new ViewAngle enum.
     *
     * @param v The numerical value representing the value given to the specified literal.
     * @param l The numerical value representing the literal's corresponding entry in strings.xml
     */
    ViewAngle(int v, int l)
    {
        this.value = (byte) v;
        this.label = l;
    }

    /**
     * Returns the value representing the chosen angle literal.
     *
     * @return A byte value representing the chosen angle literal.
     */
    public byte getValue()
    {
        return value;
    }

    /**
     * Returns the value representing the angle literal's corresponding entry in strings.xml
     * (may require casting to int in order to be usable)
     *
     * @return A byre value representing the angle literal's corresponding entry in strings.xml
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
    public static ViewAngle valueOf(byte value) {
        return map.get(value);
    }

    /**
     * Ocassionally in the code there will be a string value that really represents a view angle,
     * this method is a simple solution to converting that string into a ViewAngle, saving repetition
     * of this switch throughout the code.
     * @param viewAngleString The string variable representing the name of the view angle
     * @return The view angle based off of the string.
     */
    public static ViewAngle getViewAngleFromString(String viewAngleString){
        viewAngleString = viewAngleString.toUpperCase(); //Pushing into upper case.
        switch(viewAngleString){
            case "FRONT":
                return FRONT;
            case "BACK":
                return BACK;
            case "REAR":
                return BACK; //Sometimes "Rear" is used instead of  "Back".
            case "LEFT":
                return LEFT;
            case "RIGHT":
                return RIGHT;
        }   return null; //else
    }
}