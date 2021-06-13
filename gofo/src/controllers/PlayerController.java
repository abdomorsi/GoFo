package controllers;

import models.Location;
import models.Person;
import models.Player;

import repositories.*;

import java.util.Scanner;


/**
 * The class Player controller
 */
public class PlayerController {
    IPlayerRepo playerRepo = new PlayerRepo();


    /**
     *
     * Register player
     *
     * @return Player
     */
    public Player RegisterPlayer(){

        Scanner in = new Scanner(System.in);
        System.out.println(">> Enter the following information to complete registering ");
        System.out.print("First Name: "); String fname = in.next();
        System.out.println();
        System.out.print("Last Name: "); String lname = in.next();
        System.out.println();
        System.out.print("Area: "); String area = in.nextLine();
        System.out.println();
        System.out.print("Address: "); String address = in.nextLine();
        System.out.println();
        System.out.print("Phone Number: "); String phone = in.next();
        System.out.println();
        System.out.print("Email: "); String email = in.next();
        System.out.println();
        System.out.print("Set Your Password: "); String password = in.next();
        System.out.println();
        Person p = new Person(fname,lname,new Location(area,address),phone,email,password);
        return RegisterPlayer(p);
    }



    /**
     *
     * Register player
     *
     * @param person  the person
     * @return Player
     */
    private Player RegisterPlayer(Person person)
    {

        Player p = playerRepo.AddNewPlayer(person);
        System.out.println(playerRepo.getMessage());
        return p;
    }



    /**
     *
     * Login
     *
     * @return Player
     */
    public Player Login()
    {

        Scanner in = new Scanner(System.in);
        System.out.print("Email: "); String email = in.next();
        System.out.print("Password: "); String password = in.next();
        Player p = Login(email,password);
        //System.out.println(playerRepo.getMessage());
        return p;
    }



    /**
     *
     * Login
     *
     * @param email  the email
     * @param password  the password
     * @return Player
     */
    public Player Login(String email,String password)
    {

        //initDB();
        Player p = playerRepo.authenticatePlayer(email,password);
        System.out.println(playerRepo.getMessage());
        return p;
    }




}
