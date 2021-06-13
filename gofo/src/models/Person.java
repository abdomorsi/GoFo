package models;


/**
 * The class Person
 */
public class Person {
    //protected int ID;
    protected String firstName;
    protected String lastName;
    protected Location location;
    protected String phoneNumber;
    protected String email = "";
    protected String password;
    protected enum Type { Player, PlaygroundOwner };
    protected Type type;


    /**
     *
     * It is a constructor.
     *
     */
    public Person(){

    }



    /**
     *
     * It is a constructor.
     *
     * @param _firstName  the _first name
     * @param _lastName  the _last name
     * @param _location  the _location
     * @param _phoneNumber  the _phone number
     * @param _email  the _email
     * @param _password  the _password
     */
    public Person(String _firstName, String _lastName, Location _location, String _phoneNumber, String _email,String _password)
    {

        setFirstName(_firstName);
        setLastName(_lastName);
        setLocation(_location);
        setPhoneNumber(_phoneNumber);
        setEmail(_email);
        setPassword(_password);
    }


    /**
     *
     * To string
     *
     * @return String
     */
    public String toString(){

        return String.format(
                "First-Name: " + this.getFirstName() + "\n" +
                        "Last-Name: " + this.getLastName() + "\n" +
                        "Address: " + this.getLocation().getAddress() + "\n" +
                        "Area: " + this.getLocation().getArea() + "\n" +
                        "Phone Number: " + this.getPhoneNumber() + "\n" +
                        "email: " + this.getEmail() + "\n"
        );
    }


    /**
     *
     * Sets the first name
     *
     * @param firstName  the first name
     */
    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }


    /**
     *
     * Sets the last name
     *
     * @param lastName  the last name
     */
    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    /*public void setAddress(String address) {
        this.address = address;
    }*/


    /**
     *
     * Sets the location
     *
     * @param location  the location
     */
    public void setLocation(Location location) {

        this.location = location;
    }


    /**
     *
     * Sets the phone number
     *
     * @param phoneNumber  the phone number
     */
    public void setPhoneNumber(String phoneNumber) {

        this.phoneNumber = phoneNumber;
    }


    /**
     *
     * Sets the email
     *
     * @param email  the email
     */
    public void setEmail(String email) {

        this.email = email;
    }


    /**
     *
     * Sets the password
     *
     * @param password  the password
     */
    public void setPassword(String password) {

        this.password = password;
    }


    /**
     *
     * Sets the type
     *
     * @param type  the type
     */
    public void setType(Type type) {

        this.type = type;
    }
    /*public int getID() {
        return ID;
    }*/


    /**
     *
     * Gets the first name
     *
     * @return the first name
     */
    public String getFirstName() {

        return firstName;
    }


    /**
     *
     * Gets the last name
     *
     * @return the last name
     */
    public String getLastName() {

        return lastName;
    }

   /* public String getAddress() {
        return address;
    }
*/

    /**
     *
     * Gets the phone number
     *
     * @return the phone number
     */
    public String getPhoneNumber() {

        return phoneNumber;
    }


    /**
     *
     * Gets the email
     *
     * @return the email
     */
    public String getEmail() {

        return email;
    }


    /**
     *
     * Gets the password
     *
     * @return the password
     */
    public String getPassword() {

        return password;
    }


    /**
     *
     * Gets the location
     *
     * @return the location
     */
    public Location getLocation() {

        return location;
    }


    /**
     *
     * Gets the type
     *
     * @return the type
     */
    public Type getType() {

        return type;
    }
}
