package dataStructures;

import java.io.Serializable;

/**
 * Data structure to hold popup_annotation of a point, including clinician's notes and a Visual Analog
 * Scale value.
 */
public class PointAnnotation implements Serializable
{
    public static final int NO_ID = -1;

    private int annotationId;
    private String text;
    private int visualAnalogueScale;
    private boolean active;

    /**
     * Constructor to create a blank PointAnnotation object with default values.
     */
    public PointAnnotation()
    {
        this.annotationId = NO_ID;
        this.text = null;
        this.visualAnalogueScale = 0;
        this.active = true;
    }

    /**
     * Constructor to create a new PointAnnotation object with the required values passed into its
     * parameters.
     *
     * @param id   The unique ID number of the PointAnnotation as stored on the database.
     * @param text The text content of the PointAnnotation, representation the clinician's notes.
     * @param vis  A value representing a position on a Visual Analog Scale.
     */
    public PointAnnotation(int id, String text, int vis)
    {
        this.annotationId = id;
        this.visualAnalogueScale = vis;
        this.text = text;
        this.active = true;
    }

    /**
     * Returns the integer value of the PointAnnotation's unique ID number, as stored on the database.
     *
     * @return An int representing the PointAnnotation's unique ID number.
     */
    public int getAnnotationId()
    {
        return annotationId;
    }

    /**
     * Sets the PointAnnotation's unique ID number as stored on the database. PLEASE DO NOT USE THIS TO
     * MANUALLY FORCE AN ID.
     *
     * @param id An int value representing the PointAnnotation's unique ID number.
     */
    public void setAnnotationId(int id)
    {
        this.annotationId = id;
        this.active = true;
    }

    /**
     * Returns the text content of the PointAnnotation note.
     *
     * @return A String representing the PointAnnotation note text.
     */
    public String getText()
    {
        return text;
    }

    /**
     * Updates the text content of the PointAnnotation note.
     *
     * @param text A String value that will become the PointAnnotation's note text.
     */
    public void setText(String text)
    {
        this.text = text;
        this.active = true;
    }

    /**
     * Returns the Visual Analog Scale value representing a patient's discomfort at that Point.
     *
     * @return An int value representing the Visual Analog Scale value at that Point.
     */
    public int getVisualAnalogueScale()
    {
        return visualAnalogueScale;
    }

    /**
     * Updates the Visual Analog Scale value representing a patient's discomfort at that Point.
     *
     * @param vis An int value that will become the Visual Analog Scale value.
     */
    public void setVisualAnalogueScale(int vis)
    {
        this.visualAnalogueScale = vis;
        this.active = true;
    }

    /**
     * Returns a flag that denotes whether an PointAnnotation record is active or has been soft-deleted.
     *
     * @return A boolean value representing the PointAnnotation's active status.
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
        this.active = false;
    }
}
