package models;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * The class Playground
 */
public class Playground {
    private static int ID = 4001;
    private class Size {
        private int height;
        private int width;
    }

    private int id;
    private String name;
    private Location location;
    private Size size;
    private int price;
    private int ownerID;
    private HashMap<String, ArrayList<TimeSlot>> slots;


    /**
     *
     * It is a constructor.
     *
     */
    public Playground(){

    }


    /**
     *
     * It is a constructor.
     *
     * @param _name  the _name
     * @param _location  the _location
     * @param _price  the _price
     * @param _ownerID  the _owner identifier
     */
    public Playground(String _name, Location _location,int _price, int _ownerID){

        this.id = ++ID;
        //System.out.println(this.id);
        setName(_name);
        setLocation(_location);
        //setSize(_size);
        setOwnerID(_ownerID);
        setPrice(_price);
        slots = new HashMap<>();
    }


    /**
     *
     * Sets the name
     *
     * @param name  the name
     */
    public void setName(String name) {

        this.name = name;
    }



    /**
     *
     * Sets the owner identifier
     *
     * @param ownerID  the owner identifier
     */
    public void setOwnerID(int ownerID) {

        this.ownerID = ownerID;
    }


    /**
     *
     * Sets the price
     *
     * @param price  the price
     */
    public void setPrice(int price) {

        this.price = price;
    }


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
     * Sets the size
     *
     * @param size  the size
     */
    public void setSize(Size size) {

        this.size = size;
    }


    /**
     *
     * Sets the slots
     *
     * @param slots  the slots (Time Slots)
     */
    public void setSlots(HashMap<String, ArrayList<TimeSlot>> slots) {

        this.slots = slots;
    }


    /**
     *
     * Gets the name
     *
     * @return the name
     */
    public String getName() {

        return name;
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
     * Gets the size
     *
     * @return the size
     */
    public Size getSize() {

        return size;
    }


    /**
     *
     * Gets the owner
     *
     * @return the owner
     */
    public int getOwner() {

        return ownerID;
    }


    /**
     *
     * Gets the price
     *
     * @return the price
     */
    public int getPrice() {

        return price;
    }


    /**
     *
     * Gets the identifier
     *
     * @return the identifier
     */
    public int getId() {

        return id;
    }


    /**
     *
     * Gets the slots
     *
     * @return the slots
     */
    public HashMap<String, ArrayList<TimeSlot>> getSlots() {

        return slots;
    }



    /**
     *
     * To string
     *
     * @return String
     */
    public String toString(){

        return String.format(
                "Playground Profile \n" +
                        "Name: " + this.getName() + "\n" +
                        "Address: " + this.getLocation().getAddress() + "\n" +
                        "Area: " + this.getLocation().getArea() + "\n" +
                        "Price: " + this.getPrice() + "\n"
        );
    }
}
