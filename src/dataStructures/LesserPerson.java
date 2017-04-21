package dataStructures;
import java.io.Serializable;

/**
 * Data structure to hold minimal information on an individual.
 * Use this class when you need to select a person from a list.
 */
public class LesserPerson implements Serializable
{
    public static final int NO_ID = -1;

    protected int personId;
    protected String firstName;
    protected String middleNames;
    protected String lastName;
protected String personKey;
    protected String address1;

    /**
     * Constructor to create a blank LesserPerson object with default values.
     */
    public LesserPerson()
    {
        this.personId = NO_ID;
        this.firstName = null;
        this.middleNames = null;
        this.lastName = null;
        this.address1 = null;

        this.personKey = null;
    }

    /**
     * Constructor to create a new LesserPerson object with the required values passed into its
     * parameters.
     *
     * @param id    An int representing the PersonID of the Person, as stored on the database.
     * @param fName A String representing the Person's first name.
     * @param mNmes A String representing the Person's middle name(s).
     * @param lName A String representing the Person's last name.
     * @param add1  A String representing the first line of the Person's address.
     */
    public LesserPerson(int id,
                        String fName,
                        String mNmes,
                        String lName,
                        String add1,
                        String pKey)
    {
        this.personId = id;
        this.firstName = fName;
        this.middleNames = mNmes;
        this.lastName = lName;
        this.address1 = add1;
        this.personKey = pKey;
    }

    /**
     * Returns the integer value of the Person's unique ID number, as stored on the database.
     *
     * @return An int representing the Person's unique ID number.
     */
    public int getPersonId()
    {
        return personId;
    }

    /**
     * Sets the Person's unique ID number as stored on the database. PLEASE DO NOT USE THIS TO
     * MANUALLY FORCE AN ID.
     *
     * @param id An int value representing the Person's unique ID number.
     */
    public void setPersonId(int id)
    {
        this.personId = id;
    }

    /**
     * Returns the Person's first name.
     *
     * @return A String representing the Person's first name.
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * Update's the Person's first name.
     *
     * @param fName A String that will become the Person's first name.
     */
    public void setFirstName(String fName)
    {
        this.firstName = fName;
    }

    /**
     * Returns the Person's middle name(s).
     *
     * @return A String representing the Person's middle name(s).
     */
    public String getMiddleNames()
    {
        return middleNames;
    }

    /**
     * Updates the Person's middle name(s).
     *
     * @param mNmes A String that will become the Person's middle name(s).
     */
    public void setMiddleNames(String mNmes)
    {
        this.middleNames = mNmes;
    }

    /**
     * Returns the Person's last name.
     *
     * @return A String that represents the Person's last name.
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * Updates a Person's last name.
     *
     * @param lName A string that will become the Person's last name.
     */
    public void setLastName(String lName)
    {
        this.lastName = lName;
    }

    /**
     * Returns the first line of the Person's address.
     *
     * @return A String representing the first line of the Person's address.
     */
    public String getAddress1()
    {
        return address1;
    }

    /**
     * Updates the first line of the Person's address.
     *
     * @param add1 A String that will become the first line of the Person's address.
     */
    public void setAddress1(String add1)
    {
        this.address1 = add1;
    }

    public String getPersonKey()
    {
        return personKey;
    }

    public void setPersonKey(String pKey)
    {
        this.personKey = pKey;
    }
}