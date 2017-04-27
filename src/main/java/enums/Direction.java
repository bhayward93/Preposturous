package enums;

/**
 * Enumerator for the four possible directions a point can be moved.
 */
public enum Direction {
    UP    (0, -5),
    DOWN  (0, 5),
    LEFT  (-5, 0),
    RIGHT (5, 0);

    private int x;
    private int y;

    /**
     * Constructor for a new Direction enum literal.
     *
     * @param x The distance to move along the X-axis, in pixels.
     * @param y The distance to move along the Y-axis, in pixels.
     */
    Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Get the distance along the X-axis.
     *
     * @return The distance to move along the X-axis, in pixels.
     */
    public int getX() {
        return x;
    }

    /**
     * Get the distance along the Y-axis.
     *
     * @return The distance to move along the Y-axis, in pixels.
     */
    public int getY() {
        return y;
    }
}
