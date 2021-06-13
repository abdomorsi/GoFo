package controllers;

import models.*;

import repositories.*;

import java.util.Scanner;


/**
 * The class Playground-owner controller
 */
public class PlaygroundOwnerController {
    IPlaygroundOwnerRepo playgroundOwnerRepo = new PlaygroundOwnerRepo();


    /**
     *
     * Register playground-owner
     *
     * @return PlaygroundOwner
     */
    public PlaygroundOwner RegisterPlaygroundOwner(){

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
        return RegisterPlaygroundOwner(p);
    }



    /**
     *
     * Register playground-owner
     *
     * @param person  the person
     * @return PlaygroundOwner
     */
    public PlaygroundOwner RegisterPlaygroundOwner(Person person)
    {

        PlaygroundOwner p = playgroundOwnerRepo.AddNewPlaygroundOwner(person);
        System.out.println(playgroundOwnerRepo.getMessage());
        return p;
    }




    /**
     *
     * Login
     *
     * @param email  the email
     * @param password  the password
     * @return PlaygroundOwner
     */
    public PlaygroundOwner Login(String email,String password)
    {


        PlaygroundOwner p = playgroundOwnerRepo.authenticatePlaygroundOwner(email,password);
        System.out.println(playgroundOwnerRepo.getMessage());
        return p;
    }



    /**
     *
     * Login
     *
     * @return PlaygroundOwner
     */
    public PlaygroundOwner Login()
    {

        Scanner in = new Scanner(System.in);
        System.out.print("Email: "); String email = in.next();
        System.out.print("Password: ");String password = in.next();
        PlaygroundOwner p = playgroundOwnerRepo.authenticatePlaygroundOwner(email,password);
        System.out.println(playgroundOwnerRepo.getMessage());
        return p;
    }



    /**
     *
     * Display
     *
     */
    public void display(){

        playgroundOwnerRepo.printPlaygroundOwners();
    }






}
