package controllers;

import models.Location;
import models.Playground;
import repositories.IPlaygroundRepo;
import repositories.PlaygroundRepo;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * The class Playground controller
 */
public class PlaygroundController {
    IPlaygroundRepo repo = new PlaygroundRepo();


    /**
     *
     * Register playground
     *
     * @param ownerID  the owner identifier
     */
    public void RegisterPlayground(int ownerID){

        Scanner ini = new Scanner(System.in);
        Scanner in = new Scanner(System.in);

        System.out.println(">> Enter the following information to complete registering ");
        System.out.print("Name: "); String name = in.next();
        System.out.println();
        System.out.print("Area: "); String area = in.next();
        System.out.println();
        System.out.print("Address: "); String address = in.next();
        System.out.println();

        System.out.print("Price: "); int price = ini.nextInt();
        System.out.println();
        Location location = new Location(area,address);
        Playground pg = repo.AddNewPlayground(new Playground(name,location,price,ownerID));
        System.out.println(pg.toString());
    }


    /**
     *
     * Add slot
     *
     * @param ownerID  the owner identifier
     */
    public void addSlot(int ownerID){

        Playground pg = repo.getPlayground(ownerID);
        Scanner in = new Scanner(System.in);

        System.out.println(">> Enter the following information to complete adding slot ");
        System.out.print("Time Slot: "); String time = in.next();
        System.out.println();
        System.out.print("Date: "); String date = in.next();
        System.out.println();
        repo.addSlot(pg,time,date);
    }


    /**
     *
     * Show playgrounds
     *
     * @param pgs  the pgs
     */
    public void showPlaygrounds(ArrayList<Playground> pgs){

        int i = 1;

        if ( pgs.isEmpty() ) {
            System.out.println("Nothing here");
            return;
        }
        for ( Playground pg : pgs ){
            System.out.println( i + ". " + pg.toString());
            i++;
        }
    }


    /**
     *
     * Search by area
     *
     * @param area  the area
     * @return ArrayList<Playground>
     */
    public ArrayList<Playground> searchByArea(String area){

        ArrayList result;
        result = repo.getPlaygroundsByArea(area);
        System.out.println("test : " + result.size());
        return result;
    }


    /**
     *
     * Search by area
     *
     * @return ArrayList<Playground>
     */
    public ArrayList<Playground> searchByArea(){

        System.out.print("Enter Area: ");
        Scanner str = new Scanner(System.in);
        String area = str.next();
        Location loc = new Location("area","");
        ArrayList result;
        result = repo.getPlaygroundsByArea(loc.getArea());
        System.out.println("test : " + result.size());
        return result;
    }



    /**
     *
     * Book slot
     *
     * @param pg  the pg
     * @param date  the date
     * @param time  the time
     */
    public void bookSlot(Playground pg,String date, String time){

        repo.printSlots(pg.getId());
        boolean result = repo.bookSlot(pg.getId(), date, time);
        if ( result ){
            System.out.println("successful booking ");
            //repo.
        } else {
            System.out.println( repo.getMessage() );
        }
    }

}
