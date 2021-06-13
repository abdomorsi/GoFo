package models;


/**
 * The class Playground owner extends person
 */
public class PlaygroundOwner extends Person {
    private static int ID = 2001;
    private int playgroundOwnerID;
    private Playground playground;


    /**
     *
     * Playground owner
     *
     * Default Constructor
     */
    public PlaygroundOwner(){


    }

    /**
     *
     * Playground owner
     * Constructor
     * @param _firstName  the _first name
     * @param _lastName  the _last name
     * @param _location  the _location
     * @param _phoneNumber  the _phone number
     * @param _email  the _email
     * @param _password  the _password
     *
     */
    public PlaygroundOwner(String _firstName, String _lastName, Location _location, String _phoneNumber, String _email,String _password){

        super(_firstName, _lastName, _location, _phoneNumber, _email, _password);
        setPlaygroundOwnerID(ID++);
        setType(Type.PlaygroundOwner);
    }

    /**
     *
     * Playground owner
     *
     * Copy Constructor
     * @param p  the person
     *
     */
    public PlaygroundOwner(Person p){

        this(p.getFirstName(),p.getLastName(),p.getLocation(),p.getPhoneNumber(),p.getEmail(),p.getPassword());
    }


    /**
     *
     * To string
     *
     * @return String
     */
    public String toString(){

        return String.format(
                "Playground-Owner Profile \n" +
                        "ID: " + this.getPlaygroundOwnerID() + "\n" +
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
     * Sets the playground owner identifier
     *
     * @param playgroundOwnerID  the playground owner identifier
     */
    public void setPlaygroundOwnerID(int playgroundOwnerID) {

        this.playgroundOwnerID = playgroundOwnerID;
    }

    /**
     *
     * Gets the playground owner identifier
     *
     * @return the playground owner identifier
     */
    public int getPlaygroundOwnerID() {

        return playgroundOwnerID;
    }


    /**
     *
     * Sets the playground
     *
     * @param playground  the playground
     */
    public void setPlayground(Playground playground) {

        this.playground = playground;
    }

}
