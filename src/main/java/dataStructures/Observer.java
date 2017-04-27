package dataStructures;

/**
 * Data structure to hold complete information about an observer (one who can view anonymised data
 * without being allowed to edit.
 */
public class Observer extends AuthedPerson
{
    private int observerId;

    /**
     * Constructor to create a blank Observer object with default values.
     */
    public Observer()
    {
        super();
        this.observerId = NO_ID;
    }

    /**
     * Constructor to create a new Observer object with the required values passed into its
     * parameters.
     *
     * @param perId An int representing the PersonID of the Observer, as stored on the database.
     * @param fName A String representing the Observer's first name.
     * @param mNmes A String representing the Observer's middle name(s).
     * @param lName A String representing the Observer's last name.
     * @param add1  A String representing the first line of the Observer's address.
     * @param add2  A String representing the second line of the Observer's address.
     * @param add3  A String representing the third line of the Observer's address.
     * @param town  A String representing the town line of the Observer's address.
     * @param coun  A String representing the county line of the Observer's address.
     * @param pCode A String representing the postcode line pf the Observer's address.
     * @param phone A String representing the Observer's phone number.
     * @param email A String representing the Observer's email address.
     * @param pHash A String representing the Observer's password hash.
     * @param obsId An int representing the ObserverID of the Observer, as stored on the database.
     */
    public Observer(int perId,
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
                    int obsId)
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

        this.observerId = obsId;
    }

    /**
     * Constructor to create a new Observer object with the required values passed into its
     * parameters.
     *
     * @param aPer  An AuthedPerson object to convert into an Observer.
     * @param obsId An int representing the ObserverID of the Observer, as stored on the database.
     */
    public Observer(AuthedPerson aPer, int obsId)
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

        this.observerId = obsId;
    }

    /**
     * Returns the integer value of the Observer's unique ID number, as stored on the database.
     *
     * @return An int representing the Observer's unique ID number.
     */
    public int getObserverId()
    {
        return observerId;
    }

    /**
     * Sets the Observer's unique ID number as stored on the database. PLEASE DO NOT USE THIS TO
     * MANUALLY FORCE AN ID.
     *
     * @param id An int value representing the Observer's unique ID number.
     */
    public void setObserverId(int id)
    {
        this.observerId = id;
    }
}
