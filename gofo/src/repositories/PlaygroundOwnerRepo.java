package repositories;

import models.Location;
import models.Person;
import models.PlaygroundOwner;

import java.util.HashMap;


/**
 * The class Playground owner repo implements I playground owner repo
 */
public class PlaygroundOwnerRepo implements IPlaygroundOwnerRepo {

    public HashMap<String, PlaygroundOwner> PlaygroundOwners = new HashMap<>();
    public String msg = "";


    @Override

/**
 *
 * Authenticate playground owner
 *
 * @param email  the email
 * @param password  the password
 * @return PlaygroundOwner
 */
    public PlaygroundOwner authenticatePlaygroundOwner(String email, String password) {

        if (PlaygroundOwners.size() == 0) initDB();
        System.out.println("a");
        PlaygroundOwner pObj = findPlaygroundOwnerByEmail(email);
        if ( pObj == null )
        {
            msg = "This email is not exist \n ";
            return null;
        } else if ( pObj.getPassword() != password  ) {
            msg = "This password is wrong";
            return null;
        }
        msg = "Successfully Authentication";

        System.out.println(pObj.toString());

        return pObj;
    }


    @Override


/**
 *
 * Add new playground owner
 *
 * @param person  the person
 * @return PlaygroundOwner
 */
    public PlaygroundOwner AddNewPlaygroundOwner(Person person)
    {

        if ( findPlaygroundOwnerByEmail(person.getEmail()) != null ) {
            msg = "This email is already exist";
            return null;
        }
        PlaygroundOwner p = new PlaygroundOwner(person);
        PlaygroundOwners.put(person.getEmail(), p);
        msg = "Successfully done";

        return p;
    }

    @Override
/**
 *
 * Find playground owner by email
 *
 * @param email  the email
 * @return PlaygroundOwner
 */
    public PlaygroundOwner findPlaygroundOwnerByEmail(String email)
    {

        return PlaygroundOwners.get(email);
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


    /**
     *
     * Init DataBase
     *
     */
    public void initDB() {

        if ( PlaygroundOwners.size() > 1 ) return;
        System.out.println("i");
        PlaygroundOwner p1 = new PlaygroundOwner("Mohamed","Ahmed",new Location("Al-agouza","28 street"),"01250299729","mohamed@gmail.com","0000");
        PlaygroundOwner p2 = new PlaygroundOwner("Karim","Hany",new Location("October",""),"01090098729","karimhossam@gmail.com","1234");
        PlaygroundOwner p3 = new PlaygroundOwner("Hossam","Mohamed",new Location("Shuobra","12 street"),"01123299729","hossam.m@gmail.com","1212");
        PlaygroundOwner p4 = new PlaygroundOwner("Ahmed","Saeed",new Location("Dokki",""),"01555552229","ahmed.s@gmail.com","5858");
        PlaygroundOwner p5 = new PlaygroundOwner("Emad","Mohamed",new Location("Al-haram",""),"01106199729","emad.m@gmail.com","9999");
        PlaygroundOwners.put(p1.getEmail(),p1);
        PlaygroundOwners.put(p2.getEmail(),p2);
        PlaygroundOwners.put(p3.getEmail(),p3);
        PlaygroundOwners.put(p4.getEmail(),p4);
        PlaygroundOwners.put(p5.getEmail(),p5);
    }

    @Override


/**
 *
 * Print playground owners
 *
 */
    public void printPlaygroundOwners()
    {

        initDB();
        for ( String email : PlaygroundOwners.keySet()) {
            System.out.println(PlaygroundOwners.get(email).toString());
        }
    }


}
