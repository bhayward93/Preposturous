package dataStructures;
import enums.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Data structure to hold a Patient's Appointment information.
 */
public class Appointment implements Serializable
{
    public static final int NO_ID = -1;

    private int appointmentId;

    private Date date, time;
    private double height;
//    private String date;
//    private String time;

    private AppointmentStatus status;
    private LesserPhotoView[] views;

    /**
     * Constructor to create a blank Appointment object with default values.
     */
    public Appointment()
    {
        this.appointmentId = NO_ID;
        this.date = null;
        this.time = null;
        this.height = 0;
        this.status = AppointmentStatus.DUE;
        this.views = new LesserPhotoView[4];
    }

    /**
     * Constructor to create a new Appointment object with the required values passed into its
     * parameters.
     *
     * @param id    The unique ID number of the Appointment as stored on the database.
     * @param date  The date of the Appointment.
     * @param time  The time of the Appointment.
     * @param stat  The status of the Appointment.
     * @param views An Array holding the four separate views (front, back, left and right).
     */
    public Appointment(int id,
                       Date date,
                       Date time,
                       double height,
                       AppointmentStatus stat,
                       LesserPhotoView[] views)
    {
        this.appointmentId = id;
        this.date = date;
        this.time = time;
        this.height = height;
        this.status = stat;
        this.views = views;
    }

    /**
     * Returns the integer value of the Appointment's unique ID number, as stored on the database.
     *
     * @return An int representing the Appointment's unique ID number.
     */
    public int getAppointmentId()
    {
        return appointmentId;
    }

    /**
     * Sets the Appointment's unique ID number as stored on the database. PLEASE DO NOT USE THIS TO
     * MANUALLY FORCE AN ID.
     *
     * @param id An int value representing the Appointment's unique ID number.
     */
    public void setAppointmentId(int id)
    {
        this.appointmentId = id;
    }

    /**
     * Returns the Appointment's scheduled date.
     *
     * @return An Integer object representing the Height of the patient registered at time of appointment
     */
    public double getHeight()
    {
        return height;
    }

    /**
     * Returns the Appointment's scheduled date.
     *
     * @return A Date object representing the scheduled date of the Appointment.
     */
    public Date getDate()
    {
        return date;
    }

    /**
     * Updates the Appointment's scheduled date.
     *
     * @param date A Date object that will become the newly scheduled date.
     */
    public void setDate(Date date)
    {
        this.date = date;
    }

    /**
     * Returns the Appointment's scheduled time.
     *
     * @return A Time object representing the scheduled time of the Appointment.
     */
    public Date getTime()
    {
        return time;
    }

    /**
     * Updates the Appointment's scheduled time.
     *
     * @param height An Integer object that will become the registered height.
     */
    public void setHeight(double height)
    {
        this.height = height;
    }

    /**
     * Updates the Appointment's scheduled time.
     *
     * @param time A Time object that will become the newly scheduled time.
     */
    public void setTime(Date time)
    {
        this.time = time;
    }

    /**
     * Returns the Appointment's status.
     *
     * @return A byte value representing the Appointment's status.
     */
    public AppointmentStatus getStatus() {
        return status;
    }

    /**
     * Updates the Appointment's status.
     *
     * @param status A byte value representing the Appointment's status.
     */
    public void setStatus(AppointmentStatus status)
    {
        this.status = status;
    }

    /**
     * Adds a PhotoView to the list.
     *
     * @param view The PhotoView to add.
     * @param vAng The ViewAngle enumerator identifying the PhotoView's angle.
     */
    public void addView(LesserPhotoView view, ViewAngle vAng)
    {
        LesserPhotoView selected = views[vAng.getValue()];

        if(selected == null)
        {
            views[vAng.getValue()] = view;
        }

    }

    /**
     * Removes a PhotoView of the specified view angle.
     *
     * @param vAng A ViewAngle enumerator denoting the view to remove by its angle.
     */
    public void removeView(ViewAngle vAng)
    {
        views[vAng.getValue()] = null;
    }

    public LesserPhotoView[] getViews() { return views; }
}