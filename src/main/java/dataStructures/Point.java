package dataStructures;

import java.io.Serializable;

/**
 * Data structure to hold information about a point placed on a photo.
 */
public class Point implements Serializable
{
    public static final int NO_ID = -1;

    private int pointId;
    private String name;
    private int x;
    private int y;
    private PointAnnotation annotation;
    private boolean active;

    /**
     * Constructor to create a blank Point object with default values.
     */
    public Point()
    {
        this.pointId = NO_ID;
        this.name = null;
        this.x = 0;
        this.y = 0;
        this.annotation = null;
        this.active = true;
    }

    /**
     * Constructor to create a new PhotoView object with the required values passed into its
     * parameters.
     *
     * @param id   The unique ID number of the Point, as stored on the database.
     * @param name The name of the point, to identify it to users.
     * @param x    The X coordinate of the point.
     * @param y    The Y coordinate of the point.
     * @param anno The popup_annotation of the point.
     */
    public Point(int id,
                 String name,
                 int x,
                 int y,
                 PointAnnotation anno)
    {
        this.pointId = id;
        this.name = name;
        this.x = x;
        this.y = y;
        this.annotation = anno;
        this.active = true;
    }

    /**
     * Returns the integer value of the Point's unique ID number, as stored on the database.
     *
     * @return An int representing the Point's unique ID number.
     */
    public int getPointId()
    {
        return pointId;
    }

    /**
     * Sets the Point's unique ID number as stored on the database. PLEASE DO NOT USE THIS TO
     * MANUALLY FORCE AN ID.
     *
     * @param id An int value representing the Point's unique ID number.
     */
    public void setPointId(int id)
    {
        this.pointId = id;
    }

    /**
     * Returns the Point's name.
     *
     * @return A String representing the Point's name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Updates the Point's name.
     *
     * @param name A String that will become the Point's name.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Returns the Point's X coordinate.
     *
     * @return An int value representing the Point's X coordinate.
     */
    public int getX()
    {
        return x;
    }

    /**
     * Updates the Point's X coordinate.
     *
     * @param x An int value that will become the Point's X coordinate.
     */
    public void setX(int x)
    {
        this.x = x;
    }

    /**
     * Returns the Point's Y coordinate.
     *
     * @return An int value representing the Point's Y coordinate.
     */
    public int getY()
    {
        return y;
    }

    /**
     * Updates the Point's Y coordinate.
     *
     * @param y An int value that will become the Point's Y coordinate.
     */
    public void setY(int y)
    {
        this.y = y;
    }

    /**
     * Returns the Point's PointAnnotation.
     *
     * @return An PointAnnotation object belonging to the Point.
     */
    public PointAnnotation getAnnotation()
    {
        return annotation;
    }

    /**
     * Updates the Point's PointAnnotation.
     *
     * @param anno An PointAnnotation object that will belong to the Point.
     */
    public void setAnnotation(PointAnnotation anno)
    {
        this.annotation = anno;
    }

    /**
     * Returns a flag that denotes whether an Point's record is active or has been soft-deleted.
     *
     * @return A boolean value representing the Point's active status.
     */
    public boolean isActive()
    {
        return active;
    }

    /**
     * Soft-deletes a record by setting its active flag as false.
     */
    public void deleteRecord()
    {
        this.active=false;
    }
}