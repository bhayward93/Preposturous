package dataStructures;
import java.io.Serializable;

/**
 * Data structure to hold information about a Clinician's Centre.
 */
public class Centre implements Serializable
{
    public static final int NO_ID = -1;

    private int centreId;

    private String name;
    private String address1;
    private String address2;
    private String address3;
    private String town;
    private String postCode;
    private String county;

    private String phone;
    private String email;

    private boolean active;

    /**
     * Constructor to create a blank Centre object with default values.
     */
    public Centre()
    {
        this.centreId = NO_ID;
        this.name = null;
        this.address1 = null;
        this.address2 = null;
        this.address3 = null;
        this.town = null;
        this.postCode = null;
        this.county = null;
        this.phone = null;
        this.email = null;
        this.active = true;
    }

    /**
     * Constructor to create a new PointAnnotation object with the required values passed into its
     * parameters.
     *
     * @param id    An int representing the ID of the Centre, as stored on the database.
     * @param name  A String representing the Centre's first name.
     * @param add1  A String representing the first line of the Centre's address.
     * @param add2  A String representing the second line of the Centre's address.
     * @param add3  A String representing the third line of the Centre's address.
     * @param town  A String representing the town line of the Centre's address.
     * @param coun  A String representing the county line of the Centre's address.
     * @param pCode A String representing the postcode line pf the Centre's address.
     * @param phone A String representing the Centre's phone number.
     * @param email A String representing the Centre's email address.
     */
    public Centre(int id,
                  String name,
                  String add1,
                  String add2,
                  String add3,
                  String town,
                  String pCode,
                  String coun,
                  String phone,
                  String email)
    {
        this.centreId = id;
        this.name = name;
        this.address1 = add1;
        this.address2 = add2;
        this.address3 = add3;
        this.town = town;
        this.postCode = pCode;
        this.county = coun;
        this.phone = phone;
        this.email = email;
        this.active = true;
    }

    /**
     * Returns the integer value of the Centre's unique ID number, as stored on the database.
     *
     * @return An int representing the Centre's unique ID number.
     */
    public int getCentreId()
    {
        return centreId;
    }

    /**
     * Sets the Centre's unique ID number as stored on the database. PLEASE DO NOT USE THIS TO
     * MANUALLY FORCE AN ID.
     *
     * @param id An int value representing the Centre's unique ID number.
     */
    public void setCentreId(int id)
    {
        this.centreId = id;
    }

    /**
     * Returns the Centre's name.
     *
     * @return A String representing the Centre's name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Updates the Centre's name.
     *
     * @param name A String that will become the Centre's name.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Returns the first line of the Centre's address.
     *
     * @return A String representing the first line of the Centre's address.
     */
    public String getAddress1()
    {
        return address1;
    }

    /**
     * Updates the first line of the Centre's address.
     *
     * @param add1 A String that will become the line of the Centre's address.
     */
    public void setAddress1(String add1)
    {
        this.address1 = add1;
    }

    /**
     * Returns the second line of the Centre's address.
     *
     * @return A String representing the second line of the Centre's address.
     */
    public String getAddress2()
    {
        return address2;
    }

    /**
     * Updates the second line of the Centre's address.
     *
     * @param add2 A String that will become the second line of the Centre's address.
     */
    public void setAddress2(String add2)
    {
        this.address2 = add2;
    }

    /**
     * Returns the third line of the Centre's address.
     *
     * @return A String representing the third line of the Centre's address.
     */
    public String getAddress3()
    {
        return address3;
    }

    /**
     * Updates the third line of the Centre's address.
     *
     * @param add3 A String that will become the third line of the Centre's address.
     */
    public void setAddress3(String add3)
    {
        this.address3 = add3;
    }

    /**
     * Returns the town line of the Centre's address.
     *
     * @return A String representing the town line of the Centre's address.
     */
    public String getTown()
    {
        return town;
    }

    /**
     * Updates the town line of the Centre's address.
     *
     * @param town A String that will become the town line of the Centre's address.
     */
    public void setTown(String town)
    {
        this.town = town;
    }

    /**
     * Returns the county line of the Centre's address.
     *
     * @return A String representing the county line of the Centre's address.
     */
    public String getCounty()
    {
        return county;
    }

    /**
     * Updates the county line of the Centre's address.
     *
     * @param coun A String that will become the county line of the Centre's address.
     */
    public void setCounty(String coun)
    {
        this.county = coun;
    }

    /**
     * Returns the postcode line of the Centre's address.
     *
     * @return A String representing the postcode line of the Centre's address.
     */
    public String getPostCode()
    {
        return postCode;
    }

    /**
     * Updates the postcode line of the Centre's address.
     *
     * @param pCode A String that will become the postcode line of the Centre's address.
     */
    public void setPostCode(String pCode)
    {
        this.postCode = pCode;
    }

    /**
     * Returns the Centre's phone number.
     *
     * @return A String representing the Centre's phone number.
     */
    public String getPhone()
    {
        return phone;
    }

    /**
     * Updates the Centre's phone number.
     *
     * @param phone A String that will become the Centre's phone number.
     */
    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    /**
     * Returns the Centre's email address.
     *
     * @return A String representing the Centre's email address.
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * Updates the Centre's email address.
     *
     * @param email A String that will become the Centre's email address.
     */
    public void setEmail(String email)
    {
        this.email = email;
    }

    /**
     * Returns a flag that denotes whether an Centre's record is active or has been soft-deleted.
     *
     * @return A boolean value representing the Centre's active status.
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
        this.active=false;
    }
}
