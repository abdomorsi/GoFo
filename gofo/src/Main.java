import controllers.PlayerController;
import controllers.PlaygroundController;
import controllers.PlaygroundOwnerController;
import models.Person;
import models.Player;
import models.Playground;
import models.PlaygroundOwner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static HashMap<Integer,ArrayList<String>> Menu = new HashMap<>();
    public static void main(String []args) throws Exception{
        Scanner inStr = new Scanner(System.in);
        Scanner inInt = new Scanner(System.in);
        System.out.println("gofo");
        PlaygroundController pgc = new PlaygroundController();
        while (true){
            System.out.println("please select user type: \n (1) Player \n (2) PlaygroundOwner ");
            System.out.print(">> ");
            int x = inInt.nextInt();
            int userChoice;
            int pageNum = 0;
            String msg = "";
            init();
            Player player = new Player();
            Playground playground = new Playground();
            PlaygroundOwner playgroundOwner = new PlaygroundOwner();
            PlayerController pc = new PlayerController();
            PlaygroundOwnerController poc = new PlaygroundOwnerController();
            ArrayList<Playground> playgrounds = new ArrayList<>();
            while ( x == 1 ){
                // player section
                //x = 0;
                if ( msg != "" )  System.out.println("Alert >> " + msg);
                msg = "";
                userChoice = menu(Menu.get(1));
                System.out.println("test : " + userChoice);
                String func = Menu.get(1).get(--userChoice);
                System.out.println("test : " + func);
                if ( func == "Login" )
                {
                    if ( player.getEmail() != "" )
                    {
                        msg = "You Are already logged";
                        continue;
                    }
                    player = pc.Login();
                }
                else if (func == "Register")
                {
                    if ( player.getEmail() != "" ) {
                        msg = "Logout to complete this";
                        continue;
                    }
                    player = pc.RegisterPlayer();
                }
                else if (func == "Display Playgrounds Near you")
                {
                  //  System.out.println("test : " + "dpny");
                  //  System.out.println(player.getEmail() == "");
                    if ( player.getEmail() == "" )
                    {
                        msg = "please Login to continue";
                        continue;
                    }
                    playgrounds.clear();
                    playgrounds = pgc.searchByArea(player.getLocation().getArea());
                    pgc.showPlaygrounds(playgrounds);
                }
                else if (func == "Display Playgrounds in specific area")
                {
                    if ( player.getEmail() == "" )
                    {
                        msg = "please Login to continue";
                        continue;
                    }
                   // playgrounds.clear();
                    playgrounds = pgc.searchByArea();
                    pgc.showPlaygrounds(playgrounds);
                }
                else if ( func == "Book Slot")
                {
                    if ( player.getEmail() == "" )
                    {
                        msg = "please Login to continue";
                        continue;
                    }
                    if ( playgrounds.size() == 0 )
                    {
                        msg = "please Display playgrounds in area to choose one to book";
                        continue;
                    }
                    System.out.print("Enter Playground Number : ");
                    int pgNum = inInt.nextInt();
                    while ( pageNum >= playgrounds.size() ){
                        System.out.println( "enter playground Num again correctly" );
                        System.out.print("Enter Playground Number : ");
                        pgNum = inInt.nextInt();
                    }
                    playground = playgrounds.get(--pgNum);
                    //pgc.bookSlot();

                }
            }

            while ( x == 2 ){
                // playground section
               // x = 0;
                //preRunningOwner();
                //PlaygroundOwner playgroundOwner;
                if ( msg != "" )  System.out.println("Alert >> " + msg);
                msg = "";
                userChoice = menu(Menu.get(2));
                //System.out.println("test : " + userChoice);
                String func = Menu.get(2).get(--userChoice);
                //System.out.println("test : " + func);
                if ( func == "Login" )
                {
                    if ( player.getEmail() != "" )
                    {
                        msg = "You Are already logged";
                        continue;
                    }
                    playgroundOwner = poc.Login();
                }
                else if (func == "Register")
                {
                    if ( player.getEmail() != "" ) {
                        msg = "Logout to complete this";
                        continue;
                    }
                    playgroundOwner = poc.RegisterPlaygroundOwner();
                }
                else if (func == "Register Playground")
                {
                    if ( player.getEmail() == "" ) {
                        msg = "Login to complete this";
                        continue;
                    }
                    pgc.RegisterPlayground(playgroundOwner.getPlaygroundOwnerID());
                }
                else if (func == "Add Slots")
                {
                    if ( player.getEmail() == "" ) {
                        msg = "login to complete this";
                        continue;
                    }
                    pgc.addSlot(playgroundOwner.getPlaygroundOwnerID());
                }
            }
            if ( !(x == 1 || x == 2) ) continue;

        }


//s.h@gmail.com

    }
    public static void  init(){
        Menu.put(1,new ArrayList<String>());
        Menu.put(2,new ArrayList<String>());
        Menu.get(1).add("Login");
        Menu.get(1).add("Register");
        Menu.get(1).add("Display Playgrounds Near you");
        Menu.get(1).add("Display Playgrounds in specific area");
        Menu.get(1).add("Book Slot");
        Menu.get(1).add("Logout");

        Menu.get(2).add("Login");
        Menu.get(2).add("Register");
        Menu.get(2).add("Register Playground");
        Menu.get(2).add("Add Slots");
        Menu.get(2).add("Book Slot");
        Menu.get(2).add("Logout");
    }
    /*public static void preRunningPlayer(){
        ArrayList<String> menu_0 = new ArrayList<>();
        menu_0.add("Login"); menu_0.add("Register");
        //Menu.put(0,menu_0);

        //ArrayList<String> menu_1 = new ArrayList<>();
        menu_0.add("Select Your Area");
        //menu_1.add("Back");
        //Menu.put(1,menu_0);

        //ArrayList<String> menu_2 = new ArrayList<>();
        menu_0.add("Select Playground");
        //menu_0.add("Back");
        Menu.put(2,menu_0);

        ArrayList<String> menu_3 = new ArrayList<>();
        menu_3.add("Book Slot"); menu_3.add("Back");
        Menu.put(3,menu_3);
    }

    public static void preRunningOwner(){
        ArrayList<String> menu_0 = new ArrayList<>();
        menu_0.add("Login"); menu_0.add("Register");
        Menu.put(0,menu_0);

        ArrayList<String> menu_1 = new ArrayList<>();
        menu_1.add("Display Playground"); menu_1.add("Register Playground");  menu_1.add("Back");
        Menu.put(1,menu_1);

        *//*ArrayList<String> menu_2 = new ArrayList<>();
        menu_1.add("Register Playground"); menu_2.add("Back");
        Menu.put(2,menu_2);*//*

        ArrayList<String> menu_3 = new ArrayList<>();
        menu_3.add("Add Slot"); menu_3.add("Display Requests"); menu_3.add("Back");
        Menu.put(3,menu_3);

        *//*ArrayList<String> menu_4 = new ArrayList<>();
        menu_1.add("Display Requests"); menu_4.add("Back");
        Menu.put(4,menu_4);*//*
    }*/



    public static int menu(ArrayList<String> m){
        //int choice = 0;
        System.out.println("    GO-FOOTBALL   ");
        for ( int i = 0; i < m.size(); i++){
            System.out.println("................");
            System.out.println(i+1 + "." + " " + m.get(i));
        }
        System.out.println("................");
        System.out.print("Enter Choice: ");
        Scanner in = new Scanner(System.in);
        //System.out.println("________________");
        return in.nextInt();
    }

    public static String inputS(String s){
        Scanner inStr = new Scanner(System.in);
        System.out.print(s+": ");
        return inStr.nextLine();
    }

    public static int input(String s){
        Scanner in = new Scanner(System.in);
        System.out.print(s+": ");
        return in.nextInt();
    }



    /**
     *  Player Section
     * */
    /**
     *  playground owners :
     *  *****************
     *  id : 2004
     *  fname : ahmed
     *  lnamed : saeed
     *  address dokki
     *  email : ahmed.s@gmail.com
     *
     *  ID: 2002
     * First-Name: Karim
     * Last-Name: Hany
     * Address: Shuobra
     * Phone Number: 01090098729
     * email: karimhossam@gmail.com
     *
     * Playground-Owner Profile
     * ID: 2005
     * First-Name: Emad
     * Last-Name: Mohamed
     * Address: October
     * Phone Number: 01106199729
     * email: emad.m@gmail.com
     *
     *  Playground-Owner Profile
     * ID: 2001
     * First-Name: Mohamed
     * Last-Name: Ahmed
     * Address: Al-agouza
     * Phone Number: 01250299729
     * email: mohamed@gmail.com
     *
     * Playground-Owner Profile
     * ID: 2003
     * First-Name: Hossam
     * Last-Name: Mohamed
     * Address: Al-haram
     * Phone Number: 01123299729
     * email: hossam.m@gmail.com
     * */
    //public static


}
