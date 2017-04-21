package dataStructures;
/**
 * Data structure to hold data that will allow specific users to access Patient data and maintain
 * security of that data.
 */
public class AuthedPerson extends Person
{
    protected Integer passwordHash;

    /**
     * Constructor to create a blank AuthedPerson object with default values.
     */
    public AuthedPerson()
    {
        super();
        this.passwordHash = null;
    }

    /**
     * Constructor to create a new AuthedPerson object with the required values passed into its
     * parameters.
     *
     * @param perId An int representing the PersonID of the AuthedPerson, as stored on the database.
     * @param fName A String representing the AuthedPerson's first name.
     * @param mNmes A String representing the AuthedPerson's middle name(s).
     * @param lName A String representing the AuthedPerson's last name.
     * @param add1  A String representing the first line of the AuthedPerson's address.
     * @param add2  A String representing the second line of the AuthedPerson's address.
     * @param add3  A String representing the third line of the AuthedPerson's address.
     * @param town  A String representing the town line of the AuthedPerson's address.
     * @param coun  A String representing the county line of the AuthedPerson's address.
     * @param pCode A String representing the postcode line pf the AuthedPerson's address.
     * @param phone A String representing the AuthedPerson's phone number.
     * @param email A String representing the AuthedPerson's email address.
     * @param pHash A int representing the AuthedPerson's password hash.
     */
    public AuthedPerson(int perId,
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
                        int pHash)
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

        this.passwordHash = pHash;
    }

    /**
     * Constructor to convert an existing Person object into an AuthedPerson object with the
     * required values passed into its parameters.
     *
     * @param per   A Person object to convert into an AuthedPerson.
     * @param pHash A String representing the AuthedPerson's password hash.
     */
    public AuthedPerson(Person per, int pHash)
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

        this.passwordHash = pHash;
    }

    /**
     * Returns the AuthedPerson's password hash. NOT ACCEPTABLE RIGHT NOW AND WILL BE EVENTUALLY AXED.
     *
     * @return An int value representing the password hash.
     */
    public int getPasswordHash()
    {
        return passwordHash;
    }

    /**
     * Updates the AuthedPerson's password hash.
     *
     * @param pHash An int value to become the password hash.
     */
    public void setPasswordHash(int pHash)
    {
        this.passwordHash = pHash;
    }
}
