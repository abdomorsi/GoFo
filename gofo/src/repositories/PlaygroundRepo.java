package repositories;

import models.Location;
import models.Playground;
import models.TimeSlot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;


/**
 * The class Playground repo implements I playground repo
 */
public class PlaygroundRepo implements IPlaygroundRepo {

    public HashMap<Integer, Playground> playgrounds = new HashMap<>();
    private  String msg;

    /**
     *
     * Playground repo
     *
     * Defalut Constructor
     */
    public PlaygroundRepo(){

        initDB();
    }
    @Override

/**
 *
 * Gets the playgrounds by area
 *
 * @param area  the area
 * @return the playgrounds by area
 */
    public ArrayList<Playground> getPlaygroundsByArea(String area) {

        // initDB();
        ArrayList<Playground> result = new ArrayList<>();
        for ( Playground pg : playgrounds.values() )
        {
            System.out.println("test : " +  pg.getLocation().getArea() );
            //System.out.println(pg.toString());
            System.out.println( area + " ? ");
            if ( Objects.equals(pg.getLocation().getArea(), area) )
            {
                System.out.println("found: " + area);
                result.add(pg);
            }

        }
        //System.out.println(result.size() + " <> ");
        return result;
    }

    @Override

/**
 *
 * Add new playground
 *
 * @param pg  the pg
 * @return Playground
 */
    public Playground AddNewPlayground(Playground pg) {

        // System.out.println(pg.toString());
        // System.out.println(pg.getId());
        playgrounds.put(pg.getId(),pg);
        //System.out.println(playgrounds.get(pg.getId()));
        //System.out.println("Successfully added");
        return pg;
    }

    @Override

/**
 *
 * Gets the playground
 *
 * @param ownerID  the owner identifier
 * @return the playground
 */
    public Playground getPlayground(int ownerID) {

        for ( Playground pg : playgrounds.values() )
        {
            if ( pg.getOwner() == ownerID )
            {
                return pg;
            }

        }
        return null;
    }

    @Override

/**
 *
 * Add slot
 *
 * @param pg  the pg
 * @param time  the time
 * @param date  the date
 * @return boolean
 */
    public boolean addSlot(Playground pg, String time, String date) {

        //printSlots(pg.getId());
        TimeSlot timeSlot = new TimeSlot(time, date);
        HashMap<String,ArrayList<TimeSlot>> updatedSlots = pg.getSlots();
        if ( updatedSlots.get(date) == null ) {
            updatedSlots.put(date , new ArrayList<TimeSlot>());
        }
        /*if ( slots.get(date).contains(timeSlot) ) {
            System.out.println("exists");
        }*/
        updatedSlots.get(date).add(timeSlot);
        pg.setSlots(updatedSlots);
        //System.out.println("updated slots ????????????????????");
        // printSlots(pg.getId());
        return true;
    }

    @Override

/**
 *
 * Update slots
 *
 * @return boolean
 */
    public boolean updateSlots() {

        return false;
    }

    @Override

/**
 *
 * Book slot
 *
 * @param playgroundID  the playground identifier
 * @param date  the date
 * @param time  the time
 * @return boolean
 */
    public boolean bookSlot(int playgroundID,String date, String time) {

        Playground pg = playgrounds.get(playgroundID);
        //printSlots(pg.getId());
        //TimeSlot timeSlot = new TimeSlot(time, date);
        HashMap<String,ArrayList<TimeSlot>> updatedSlots = pg.getSlots();
        ArrayList<TimeSlot> timeSlots =  updatedSlots.get(date);
        if ( timeSlots == null ){
            msg = "You enter wrong date";
            return false;
        }
        if ( timeSlots.indexOf(time) < timeSlots.size()  ){
            TimeSlot ts = timeSlots.get(timeSlots.indexOf(time));
            if ( ts.getStatus() != TimeSlot.Status.Free  ){
                msg = "sorry this slot is already booked";
                return false;
            }
            ts.setStatus(TimeSlot.Status.Booked);
        }
        /*if ( slots.get(date).contains(timeSlot) ) {
            System.out.println("exists");
        }*/
        //updatedSlots.get(date).add(timeSlot);
        pg.setSlots(updatedSlots);
        //System.out.println("updated slots");
        //printSlots(pg.getId());
        return true;
    }

    @Override

/**
 *
 * Display playgrounds
 *
 */
    public void displayPlaygrounds() {

        //initDB();
        for (Playground pg : playgrounds.values()){
            System.out.println(pg.toString());
        }
    }

    @Override

/**
 *
 * Gets the message
 *
 * @return the message
 */
    public String getMessage() {

        return msg;
    }

    @Override

/**
 *
 * Print slots
 *
 * @param playgroundID  the playground identifier
 */
    public void printSlots(int playgroundID){

        Playground pg = playgrounds.get(playgroundID);
        if ( pg.getSlots().size() == 0 ) {
            System.out.println(" nothing to display ");
            return;
        }
        int i = 1,j = 1;
        for ( String day : pg.getSlots().keySet() )
        {
            System.out.println(">> " + i++ + " >>" + day );
            for (TimeSlot timeSlot : pg.getSlots().get(day) ){
                System.out.println(" " + j + ".  " + timeSlot.toString());
            }
        }
    }


    /**
     *
     * Init DataBase
     *
     */
    private void initDB(){

        //System.out.println();
        Playground pg1 = new Playground("playground1",new Location("dokki","28 street"),120,2004);
        Playground pg2 = new Playground("playground2",new Location("Shuobra","28 street"),100,2002);
        Playground pg3 = new Playground("playground3",new Location("October","28 street"),320,2005);
        Playground pg4 = new Playground("playground4",new Location("agouza","28 street"),150,2001);
        Playground pg5 = new Playground("playground5",new Location("haram","28 street"),80,2003);
        playgrounds.put(pg1.getId(),pg1);
        playgrounds.put(pg2.getId(),pg2);
        playgrounds.put(pg3.getId(),pg3);
        playgrounds.put(pg4.getId(),pg4);
        playgrounds.put(pg5.getId(),pg5);
        addSlot(pg1,"12:00","11/6/2021");
        addSlot(pg1,"13:00","11/6/2021");
        addSlot(pg1,"14:00","11/6/2021");
        addSlot(pg1,"15:00","11/6/2021");
        addSlot(pg1,"16:00","11/6/2021");
        addSlot(pg1,"17:00","11/6/2021");
        addSlot(pg1,"18:00","11/6/2021");

        addSlot(pg2,"15:00","11/6/2021");
        addSlot(pg2,"16:00","11/6/2021");
        addSlot(pg2,"17:00","11/6/2021");
        addSlot(pg2,"18:00","11/6/2021");

        addSlot(pg3,"15:00","11/6/2021");
        addSlot(pg3,"16:00","11/6/2021");
        addSlot(pg3,"17:00","11/6/2021");
        addSlot(pg3,"18:00","11/6/2021");

        addSlot(pg4,"12:00","11/6/2021");
        addSlot(pg4,"13:00","11/6/2021");
        addSlot(pg4,"14:00","11/6/2021");
        addSlot(pg4,"15:00","11/6/2021");
        addSlot(pg4,"16:00","11/6/2021");
        addSlot(pg4,"17:00","11/6/2021");

        addSlot(pg5,"12:00","11/6/2021");
        addSlot(pg5,"13:00","11/6/2021");
        addSlot(pg5,"14:00","11/6/2021");
        addSlot(pg5,"15:00","11/6/2021");
        addSlot(pg5,"16:00","11/6/2021");
        addSlot(pg5,"17:00","11/6/2021");


    }


}
