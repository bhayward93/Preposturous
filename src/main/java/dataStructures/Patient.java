package dataStructures;
import enums.*;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Data structure to hold complete information about a patient.
 */
public class Patient extends Person implements Serializable
{
    private int patientId;
    private byte gender;

    private String dob;

    private String note;

    private ArrayList<Appointment> appointments;

    /**
     * Constructor to create a blank Patient object with default values.
     */
    public Patient()
    {
        super();
        this.patientId = NO_ID;
        this.gender = 0;
        this.note = null;
        this.appointments = new ArrayList<Appointment>();
    }

    /**
     * Constructor to create a new Patient object with the required values passed into its
     * parameters.
     *
     * @param perId An int representing the PersonID of the Patient, as stored on the database.
     * @param fName A String representing the Patient's first name.
     * @param mNmes A String representing the Patient's middle name(s).
     * @param lName A String representing the Patient's last name.
     * @param add1  A String representing the first line of the Patient's address.
     * @param add2  A String representing the second line of the Patient's address.
     * @param add3  A String representing the third line of the Patient's address.
     * @param town  A String representing the town line of the Patient's address.
     * @param coun  A String representing the county line of the Patient's address.
     * @param pCode A String representing the postcode line pf the Patient's address.
     * @param phone A String representing the Patient's phone number.
     * @param email A String representing the Patient's email address.
     * @param patId An int representing the PatientID of the Patient, as stored on the database.
     * @param gndr  A byte representing the Patient's gender selections.
     * @param note  A String representing any general notes to be kept about the patient.
     * @param appts An ArrayList representing the Patient's list of Appointments.
     */
    public Patient(Integer perId,
                   String fName,
                   String mNmes,
                   String lName,
                   String add1,
                   String add2,
                   String add3,
                   String town,
                   String coun,
                   String pCode,
                   String phone,
                   String email,
                   String pKey,
                   int patId,
                   byte gndr,
                   String note,
                   ArrayList<Appointment> appts)
    {
        super(perId,
                fName,
                mNmes,
                lName,
                add1,
                add2,
                add3,
                town,
                coun,
                pCode,
                phone,
                email,
                pKey);

        this.patientId = patId;
        this.gender = gndr;
        this.note = note;
        this.appointments = appts;
    }

    /**
     * Constructor to create a new Patient object with the required values passed into its
     * parameters.
     *
     * @param per   A Person object to convert into a Patient.
     * @param patId An int representing the PatientID of the Patient, as stored on the database.
     * @param gndr  A byte representing the Patient's gender selections.
     * @param note  A String representing any general notes to be kept about the patient.
     * @param appts An ArrayList representing the Patient's list of Appointments.
     */
    public Patient(Person per,
                   int patId,
                   byte gndr,
                   String note,
                   ArrayList<Appointment> appts)
    {
        super(per.getPersonId(),
                per.getFirstName(),
                per.getMiddleNames(),
                per.getLastName(),
                per.getAddress1(),
                per.getAddress2(),
                per.getAddress3(),
                per.getTown(),
                per.getCounty(),
                per.getPostCode(),
                per.getPhone(),
                per.getEmail(),
                per.getPersonKey());

        this.patientId = patId;
        this.gender = gndr;
        this.note = note;
        this.appointments = appts;
    }

    /**
     * Returns the integer value of the Patient's unique ID number, as stored on the database.
     *
     * @return An int representing the Patient's unique ID number.
     */
    public int getPatientId()
    {
        return this.patientId;
    }

    /**
     * Sets the Patient's unique ID number as stored on the database. PLEASE DO NOT USE THIS TO
     * MANUALLY FORCE AN ID.
     *
     * @param id An int value representing the Patient's unique ID number.
     */
    public void setPatientId(int id)
    {
        this.patientId = id;
    }

    /**
     * Returns a Patient's Date of Birth.
     *
     * @return A String (why?) representing the Patient's Date of Birth.
     */
    public String getDob()
    {
        return this.dob;
    }

    /**
     * Updates the Patient's Date of Birth.
     *
     * @param dob A String (why?) that will become the Patient's Date of Birth.
     */
    public void setDob(String dob)
    {
        this.dob = dob;
    }

    /**
     * Returns the visible identification number of the Patient.
     *
     * @return A String representing the Patient's visible ID number.
     */
    public String getPersonKey()
    {
        return this.personKey;
    }

    /**
     * Updates the visible identification number of the Patient.
     *
     * @param key A String that will become the Patient's visible ID number.
     */
    public void setPersonKey(String key)
    {
        this.personKey=key;
    }

    /**
     * Return the byte value of the Patient's gender.
     *
     * @return A byte representing the patient's gender selections.
     */
    public byte getGenderValue()
    {
        return gender;
    }

    /**
     * Confirms whether a gender option is active for a patient, by comparing the individual byte
     * flags.
     *
     * @param gndr An enumerator carrying the value to compare.
     * @return     A boolean confirming whether that option is active or not.
     */
    public boolean isGender(Gender gndr)
    {
        return ((gender & gndr.getValue()) == gndr.getValue());
    }

    /**
     * Directly sets the gender value with a new set of gender flags.
     *
     * @param gndr A byte representing a new set of gender flags.
     */
    public void setGender(byte gndr) {
        this.gender = gndr;
    }

    /**
     * Toggles individual gender options by flipping the bits representing those options.
     *
     * @param gndr An enumerator carrying the value to toggle.
     */
    public void toggleGender(Gender gndr)
    {
        gender ^= gndr.getValue();
    }

    /**
     * Enables the bit in the gender flags representing the option to be switched on.
     *
     * @param gndr A Gender enum representing the option to enable.
     */
    private void enableGender(Gender gndr) {
        gender |= gndr.getValue();
    }

    /**
     * Disables the bit in the gender flags representing the option to be switched off.
     *
     * @param gndr A Gender enum representing the option to disable.
     */
    private void disableGender(Gender gndr) {
        gender &= ~gndr.getValue();
    }

    /**
     * Returns the Patient's general notes.
     *
     * @return A String representing the Patient's general notes.
     */
    public String getNote()
    {
        return this.note;
    }

    /**
     * Updates the Patient's general notes.
     *
     * @param note A String that will become the Patient's general notes.
     */
    public void setNote(String note)
    {
        this.note=note;
    }

    /**
     * Returns the Patient's list of Appointments.
     *
     * @return An ArrayList representing the Patient's list of Appointments.
     */
    public ArrayList getAppointments()
    {
        return appointments;
    }

    /**
     * Adds an Appointment to the list.
     *
     * @param appt An Appointment object that will be added to the list.
     * @return     A boolean denoting success or failure.
     */
    public boolean addAppointment(Appointment appt)
    {
        return appointments.add(appt);
    }

    /**
     * Removes an Appointment from the list.
     *
     * @param appt An Appointment object that will be removed to the list.
     * @return     A boolean denoting success or failure.
     */
    public boolean removeAppointment(Appointment appt)
    {
        return appointments.remove(appt);
    }

    /**
     * Returns a flag that denotes whether an Patient's record is active or has been soft-deleted.
     *
     * @return A boolean value representing the Patient's active status.
     */
    public boolean getActive()
    {
        return active;
    }

    /**
     * Soft-deletes a record by setting its active flag as false.
     */
    public void deleteRecord()
    {
        if (appointments.isEmpty())
        {
            this.active=false;
        }
        else
        {
            System.out.println("Cannot delete!"); //change return type??
        }
    }
}