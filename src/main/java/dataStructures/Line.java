package dataStructures;

import java.io.Serializable;

/**
 * Data structure to hold information about a line between two points.
 */
public class Line implements Serializable
{
    private String name;
    private Point start;
    private Point end;

    /**
     * Constructor to create a blank Point object with default values.
     */
    public Line()
    {
        this.name = null;
        this.start = null;
        this.end = null;
    }

    /**
     * Constructor to create a new PhotoView object with the required values passed into its
     * parameters.
     *
     * @param name  The name of the Line.
     * @param start The start Point for the Line.
     * @param end   The end Point for the Line.
     */
    public Line(String name,
                Point start,
                Point end)
    {
        this.name = name;
        this.start = start;
        this.end = end;
    }

    /**
     * Returns the Line's name.
     *
     * @return A String representing the Line's name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Updates the Line's name.
     *
     * @param name A String that will become the Line's name.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Returns the Line's start Point.
     *
     * @return A Point object forming the start of the Line.
     */
    public Point getStart()
    {
        return start;
    }

    /**
     * Updates the Line's start Point.
     *
     * @param start A Point object that will form the start of the Line.
     */
    public void setStart(Point start)
    {
        this.start = start;
    }

    /**
     * Returns the Line's end Point.
     *
     * @return A Point object forming the end of the Line.
     */
    public Point getEnd()
    {
        return end;
    }

    /**
     * Updates the Line's end Point.
     *
     * @param end A Point object that will form the end of the Line.
     */
    public void setEnd(Point end)
    {
        this.end = end;
    }
}