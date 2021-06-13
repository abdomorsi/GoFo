package repositories;

import models.Location;
import models.Person;
import models.Player;

import java.util.HashMap;
import java.util.Objects;


/**
 * The class PlayerRepo implements Interface player-repo
 */
public class PlayerRepo implements IPlayerRepo {

    public HashMap<String, Player> Players = new HashMap<>();
    public String msg = "";



    @Override

/**
 *
 * Authenticate player
 *
 * @param email  the email
 * @param password  the password
 * @return Player
 */
    public Player authenticatePlayer(String email, String password) {

        initDB();
        Player pObj = findPlayerByEmail(email);
        if ( pObj.getEmail() == "" )
        {
            msg = "This email is not exist \n ";
            return new Player();
        } else if (!Objects.equals(pObj.getPassword(),password)) {
            System.out.println(pObj.getPassword() + " <test> " + password );
            msg = "This password is wrong";
            return new Player();
        }
        msg = "Successfully Authentication";

        System.out.println(pObj.toString());

        return pObj;
    }


    @Override


/**
 *
 * Add new player
 *
 * @param person  the person
 * @return Player
 */
    public Player AddNewPlayer(Person person)
    {

        if ( findPlayerByEmail(person.getEmail()) != null ) {
            msg = "This email is already exist";
            return null;
        }

        Player p = new Player(person);
        Players.put(person.getEmail(), p);
        msg = "Successfully done";

        return p;
    }

    @Override


/**
 *
 * Find player by email
 *
 * @param email  the email
 * @return Player
 */
    public Player findPlayerByEmail(String email)
    {

        Player p = new Player();
        if ( Players.containsKey(email) ) p = Players.get(email);
        return p;
    }

    @Override


/**
 *
 * Print players
 *
 */
    public void printPlayers()
    {

        for ( String email : Players.keySet()) {
            System.out.println(Players.get(email).toString());
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


    /**
     *
     * Init DB
     *
     */
    private void initDB(){

        Player p1 = new Player("Abdo","Morsy", new Location("Al-agouza","28 street"),"01140299729","abdomorsy@gmail.com","0000");
        Player p2 = new Player("Suhail","Hany",new Location("Shuobra","12 street"),"01050298729","s.h@gmail.com","1234");
        Player p3 = new Player("Ahmed","Mohamed",new Location("Al-haram",""),"01230299729","a.m@gmail.com","1212");
        Player p4 = new Player("Sara","Saeed",new Location("Dokki",""),"01540222229","s.s@gmail.com","5858");
        Player p5 = new Player("Esraa","Seif",new Location("October",""),"01250299729","esraa@gmail.com","9999");
        Players.put(p1.getEmail(),p1);
        Players.put(p2.getEmail(),p2);
        Players.put(p3.getEmail(),p3);
        Players.put(p4.getEmail(),p4);
        Players.put(p5.getEmail(),p5);
    }


}
