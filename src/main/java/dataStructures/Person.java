package dataStructures;
/**
 * Data structure to hold complete information on an individual.
 */
public class Person extends LesserPerson
{
    protected String address2;
    protected String address3;
    protected String town;
    protected String county;
    protected String postCode;


    protected String phone;
    protected String email;

    protected boolean active;

    /**
     * Constructor to create a blank Person object with default values.
     */
    public Person()
    {
        super();

        this.address1 = null;
        this.address2 = null;
        this.address3 = null;
        this.town = null;
        this.county = null;
        this.postCode = null;
        this.phone = null;
        this.email = null;
        this.active = true;
    }

    /**
     * Constructor to create a new Person object with the required values passed into its
     * parameters.
     *
     * @param id    An int representing the PersonID of the Person, as stored on the database.
     * @param fName A String representing the Person's first name.
     * @param mNmes A String representing the Person's middle name(s).
     * @param lName A String representing the Person's last name.
     * @param add1  A String representing the first line of the Person's address.
     * @param add2  A String representing the second line of the Person's address.
     * @param add3  A String representing the third line of the Person's address.
     * @param town  A String representing the town line of the Person's address.
     * @param coun  A String representing the county line of the Person's address.
     * @param pCode A String representing the postcode line pf the Person's address.
     * @param phone A String representing the Person's phone number.
     * @param email A String representing the Person's email address.
     */
    public Person(int id,
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
                  String pKey)
    {
        super(id,
                fName,
                mNmes,
                lName,
                add1,
                pKey);

        this.address2 = add2;
        this.address3 = add3;
        this.town = town;
        this.county = coun;
        this.postCode = pCode;
        this.phone = phone;
        this.email = email;
        this.active = true;
    }

    /**
     * Constructor to create a new Person object with the required values passed into its
     * parameters.
     *
     * @param lPer  A LesserPerson object to convert into a Person.
     * @param add2  A String representing the second line of the Person's address.
     * @param add3  A String representing the third line of the Person's address.
     * @param town  A String representing the town line of the Person's address.
     * @param coun  A String representing the county line of the Person's address.
     * @param pCode A String representing the postcode line pf the Person's address.
     * @param phone A String representing the Person's phone number.
     * @param email A String representing the Person's email address.
     */
    public Person(LesserPerson lPer,
                  String add2,
                  String add3,
                  String town,
                  String coun,
                  String pCode,
                  String phone,
                  String email)
    {
        super(lPer.getPersonId(),
                lPer.getFirstName(),
                lPer.getMiddleNames(),
                lPer.getLastName(),
                lPer.getAddress1(),
                lPer.getPersonKey());

        this.address2 = add2;
        this.address3 = add3;
        this.town = town;
        this.county = coun;
        this.postCode = pCode;
        this.phone = phone;
        this.email = email;
        this.active = true;
    }

    /**
     * Returns the second line of the Person's address.
     *
     * @return A String representing the second line of the Person's address.
     */
    public String getAddress2()
    {
        return address2;
    }

    /**
     * Updates the second line of the Person's address.
     *
     * @param add2 A String that will become the second line of the Person's address.
     */
    public void setAddress2(String add2)
    {
        this.address2 = add2;
    }

    /**
     * Returns the third line of the Person's address.
     *
     * @return A String representing the third line of the Person's address.
     */
    public String getAddress3()
    {
        return address3;
    }

    /**
     * Updates the third line of the Person's address.
     *
     * @param add3 A String that will become the third line of the Person's address.
     */
    public void setAddress3(String add3)
    {
        this.address3 = add3;
    }

    /**
     * Returns the town line of the Person's address.
     *
     * @return A String representing the town line of the Person's address.
     */
    public String getTown()
    {
        return town;
    }

    /**
     * Updates the town line of the Person's address.
     *
     * @param town A String that will become the town line of the Person's address.
     */
    public void setTown(String town)
    {
        this.town = town;
    }

    /**
     * Returns the county line of the Person's address.
     *
     * @return A String representing the county line of the Person's address.
     */
    public String getCounty()
    {
        return county;
    }

    /**
     * Updates the county line of the Person's address.
     *
     * @param coun A String that will become the county line of the Person's address.
     */
    public void setCounty(String coun)
    {
        this.county = coun;
    }

    /**
     * Returns the postcode line of the Person's address.
     *
     * @return A String representing the postcode line of the Person's address.
     */
    public String getPostCode()
    {
        return postCode;
    }

    /**
     * Updates the postcode line of the Person's address.
     *
     * @param pCode A String that will become the postcode line of the Person's address.
     */
    public void setPostCode(String pCode)
    {
        this.postCode = pCode;
    }

    /**
     * Returns the Person's phone number.
     *
     * @return A String representing the Person's phone number.
     */
    public String getPhone()
    {
        return phone;
    }

    /**
     * Updates the Person's phone number.
     *
     * @param phone A String that will become the Person's phone number.
     */
    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    /**
     * Returns the Person's email address.
     *
     * @return A String representing the Person's email address.
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * Updates the Person's email address.
     *
     * @param email A String that will become the Person's email address.
     */
    public void setEmail(String email)
    {
        this.email = email;
    }

    /**
     * Returns a flag that denotes whether an Person's record is active or has been soft-deleted.
     *
     * @return A boolean value representing the Person's active status.
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
