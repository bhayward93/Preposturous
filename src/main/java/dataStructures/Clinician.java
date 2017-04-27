package dataStructures;
import java.util.ArrayList;

/**
 * Data structure to hold a Clinician's information, and a list of their patients.
 */
public class Clinician extends AuthedPerson
{
    public static final int NO_ID = -1;

    private int clinicianId;
    private Centre centre;
    private ArrayList<LesserPerson> patients;

    /**
     * Constructor to create a blank Clinician object with default values.
     */
    public Clinician()
    {
        super();
        this.clinicianId = NO_ID;
        this.centre = null;
        this.patients = new ArrayList<LesserPerson>();
    }

    /**
     * Constructor to create a new Clinician object with the required values passed into its
     * parameters.
     *
     * @param perId An int representing the PersonID of the Clinician, as stored on the database.
     * @param fName A String representing the Clinician's first name.
     * @param mNmes A String representing the Clinician's middle name(s).
     * @param lName A String representing the Clinician's last name.
     * @param add1  A String representing the first line of the Clinician's address.
     * @param add2  A String representing the second line of the Clinician's address.
     * @param add3  A String representing the third line of the Clinician's address.
     * @param town  A String representing the town line of the Clinician's address.
     * @param coun  A String representing the county line of the Clinician's address.
     * @param pCode A String representing the postcode line pf the Clinician's address.
     * @param phone A String representing the Clinician's phone number.
     * @param email A String representing the Clinician's email address.
     * @param pHash An int representing the Clinician's password hash.
     * @param clnId An int representing the ClinicianID of the Clinician, as stored on the database.
     * @param cent  A Centre object representing the Clinician's Centre.
     * @param pats  An ArrayList representing a list of the Clinician's Patients.
     */
    public Clinician(int perId,
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
                     int pHash,
                     int clnId,
                     Centre cent,
                     ArrayList<LesserPerson> pats)
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
                pKey,
                pHash);

        this.clinicianId = clnId;
        this.centre = cent;
        this.patients = pats;
    }

    /**
     * Constructor to create a new Clinician object with the required values passed into its
     * parameters.
     *
     * @param aPer  An AuthedPerson object to convert into a Clinician.
     * @param clnId An int representing the ClinicianID of the Clinician, as stored on the database.
     * @param cent  A Centre object representing the Clinician's Centre.
     * @param pats  An ArrayList representing a list of the Clinician's Patients.
     */
    public Clinician(AuthedPerson aPer,
                     int clnId,
                     Centre cent,
                     ArrayList<LesserPerson> pats)
    {
        super(aPer.getPersonId(),
                aPer.getFirstName(),
                aPer.getMiddleNames(),
                aPer.getLastName(),
                aPer.getAddress1(),
                aPer.getAddress2(),
                aPer.getAddress3(),
                aPer.getTown(),
                aPer.getCounty(),
                aPer.getPostCode(),
                aPer.getPhone(),
                aPer.getEmail(),
                aPer.getPersonKey(),
                aPer.getPasswordHash());

        this.clinicianId = clnId;
        this.centre = cent;
        this.patients = pats;
    }

    /**
     * Returns the integer value of the Clinician's unique ID number, as stored on the database.
     *
     * @return An int representing the Clinician's unique ID number.
     */
    public int getClinicianId()
    {
        return clinicianId;
    }

    /**
     * Sets the Clinician's unique ID number as stored on the database. PLEASE DO NOT USE THIS TO
     * MANUALLY FORCE AN ID.
     *
     * @param clinicianId An int value representing the Clinician's unique ID number.
     */
    public void setClinicianId(int clinicianId)
    {
        this.clinicianId = clinicianId;
    }

    /**
     * Returns the Clinician's current Centre.
     *
     * @return A Centre object representing the Clinician's Centre.
     */
    public Centre getCentre()
    {
        return centre;
    }

    /**
     * Updates the Clinician's current Centre.
     *
     * @param centre A Centre object that will become the Clinician's Centre.
     */
    public void setCentre(Centre centre)
    {
        this.centre = centre;
    }

    /**
     * Return the Clinician's list of Patients.
     *
     * @return An ArrayList representing the Clinician's list of Patients.
     */
    public ArrayList<LesserPerson> getPatients()
    {
        return patients;
    }

    /**
     * Adds a Patient to the Clinician's list.
     *
     * @param ptnt The Patient to be added to the Clinician's list.
     * @return     A boolean denoting success or failure.
     */
    public boolean addPatient(Patient ptnt)
    {
        return patients.add(ptnt);
    }

    /**
     * Removes a Patient from the Clinician's list.
     *
     * @param ptnt The Patient to be removed from the Clinician's list.
     * @return     A boolean denoting success or failure.
     */
    public boolean removePatient(Patient ptnt)
    {
        return patients.remove(ptnt);
    }

    /**
     * Soft-deletes a record by setting its active flag as false.
     */
    public void deleteRecord()
    {
        if(patients.isEmpty())
        {
            this.active=false;
        }
        else
        {
            System.out.println("Cannot delete!"); //change return type?
        }
    }
}
