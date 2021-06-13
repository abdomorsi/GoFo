package models;

import java.sql.Time;


/**
 * The class Time slot
 */
public class TimeSlot {
    private static int ID = 5001;
    private int id;
    private String slot;
    public enum Status  {Pending, Booked, Closed, Free}
    private Status status;


    /**
     *
     * It is a constructor.
     *
     * @param _slot  the _slot
     * @param _date  the _date
     */
    public TimeSlot(String _slot, String _date){

        this.id = ID++;
        setSlot(_slot);
        //setDate(_date);
        setStatus(Status.Free);
    }


    /**
     *
     * Sets the slot
     *
     * @param slot  the slot
     */
    public void setSlot(String slot) {

        this.slot = slot;
    }


    /**
     *
     * Sets the status
     *
     * @param status  the status
     */
    public void setStatus(Status status) {

        this.status = status;
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
     * Getslot
     *
     * @return the slot
     */
    public String getslot() {

        return slot;
    }


    /**
     *
     * Gets the status
     *
     * @return the status
     */
    public Status getStatus() {

        return status;
    }


    @Override

/**
 *
 * To string
 *
 * @return String
 */
    public String toString() {

        return String.format(
                "-----------------------------------------------------------\n"+
                 "| " + this.slot + " | " + this.getStatus().toString() + " |\n" +
                 "-----------------------------------------------------------\n"
        );
    }

}
