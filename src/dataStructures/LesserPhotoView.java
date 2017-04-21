package dataStructures;
import enums.*;
import java.io.Serializable;


/**
 * Data structure to hold minimal information about an individual view taken during an appointment.
 * Use this class when you need to select from a collection of views.
 */
public class LesserPhotoView  implements Serializable
{
    public static final int NO_ID = -1;

    protected int viewId;
    protected ViewAngle viewAngle;
    protected ViewType viewType;
    protected String filePath;

    /**
     * Constructor to create a blank LesserPhotoView object with default values.
     */
    public LesserPhotoView()
    {
        this.viewId = NO_ID;
        this.viewAngle = null;
        this.viewType = null;
        this.filePath = null;
    }

    /**
     * Constructor to create a new LesserPhotoView object with the required values passed into its
     * parameters.
     *
     * @param id    An int representing the unique ID of the PhotoView, as stored on the database.
     * @param vAng  An enumerator representing the angle from which the PhotoView was recorded.
     * @param vType An enumerator representing the type of PhotoView recorded.
     * @param fPath The file path of the photo belonging to this PhotoView.
     */
    public LesserPhotoView(int id,
                           ViewAngle vAng,
                           ViewType vType,
                           String fPath)
    {
        this.viewId = id;
        this.viewAngle = vAng;
        this.viewType = vType;
        this.filePath = fPath;
    }

    /**
     * Returns the integer value of the PhotoView's unique ID number, as stored on the database.
     *
     * @return An int representing the PhotoView's unique ID number.
     */
    public int getViewId()
    {
        return viewId;
    }

    /**
     * Sets the PhotoView's unique ID number as stored on the database. PLEASE DO NOT USE THIS TO
     * MANUALLY FORCE AN ID.
     *
     * @param id
     */
    public void setViewId(int id)
    {
        this.viewId = id;
    }

    /**
     * Returns the angle from which the PhotoView was recorded.
     *
     * @return An enumerator representing the PhotoView's angle.
     */
    public ViewAngle getViewAngle()
    {
        return viewAngle;
    }

    /**
     * Returns the int value of the PhotoView's angle.
     *
     * @return An int value representing the PhotoView's angle.
     */
    public int getViewAngleValue()
    {
        return viewAngle.getValue();
    }

    /**
     * Updates the angle from which the PhotoView was recorded.
     *
     * @param vAng An enumerator that will become the PhotoView's angle.
     */
    public void setViewAngle(ViewAngle vAng)
    {
        this.viewAngle = vAng;
    }

    /**
     * Returns the type of PhotoView.
     *
     * @return An enumerator that represents the PhotoView's type.
     */
    public ViewType getViewType()
    {
        return viewType;
    }

    /**
     * Returns the int value of the PhotoView's type.
     *
     * @return An int value representing the PhotoView's type.
     */
    public int getViewTypeValue()
    {
        return viewType.getValue();
    }

    /**
     * Updates the type of PhotoView.
     *
     * @param vType An enumerator that will become the PhotoView's type.
     */
    public void setViewType(ViewType vType)
    {
        this.viewType = vType;
    }

    /**
     * Returns the file path of the photo belonging to the PhotoView.
     *
     * @return A String representing the photo's current location.
     */
    public String getFilePath()
    {
        return filePath;
    }

    /**
     * Updates the file path of the photo belonging to the PhotoView.
     *
     * @param fPath A String that will become the photo's current location.
     */
    public void setFilePath(String fPath)
    {
        this.filePath = fPath;
    }
}