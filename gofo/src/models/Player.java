package models;

import java.util.ArrayList;


/**
 * The class Player extends person
 */
public class Player extends Person {
    private static int ID = 1001;
    private int playerID;
    //private Type type = Type.Player;

    /**
     *
     * It is a constructor.
     *
     */
    public Player(){}

    public Player(String _firstName, String _lastName, Location _location, String _phoneNumber, String _email,String _password){

        super(_firstName, _lastName, _location, _phoneNumber, _email, _password);
        setPlayerID(ID++);
        setType(Type.Player);
    }


    /**
     *
     * Player
     * Copy constructor
     * @param p  the person
     */
    public Player(Person p){

        this(p.getFirstName(),p.getLastName(),p.getLocation(),p.getPhoneNumber(),p.getEmail(),p.getPassword());
    }


    /**
     *
     * Sets the player identifier
     *
     * @param playerID  the player identifier
     */
    private void setPlayerID(int playerID) {

        this.playerID = playerID;
    }


    /**
     *
     * Gets the player identifier
     *
     * @return the player identifier
     */
    public int getPlayerID() {

        return playerID;
    }


    /**
     *
     * To string
     *
     * @return String
     */
    public String toString(){

        return String.format(
                "Player Profile \n" +
                        "First-Name: " + this.getFirstName() + "\n" +
                        "Last-Name: " + this.getLastName() + "\n" +
                        "Address: " + this.getLocation().getAddress() + "\n" +
                        "Area: " + this.getLocation().getArea() + "\n" +
                        "Phone Number: " + this.getPhoneNumber() + "\n" +
                        "email: " + this.getEmail() + "\n"
        );
    }


}
