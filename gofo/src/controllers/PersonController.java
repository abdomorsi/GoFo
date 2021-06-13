package controllers;

import models.Person;
import models.Player;

import repositories.*;

public class PersonController {
    PlayerRepo playerRepo = new PlayerRepo();
    public Player RegisterPlayer(Person person)
    {
        Player p = playerRepo.AddNewPlayer(person);
        System.out.println(playerRepo.msg);
        return p;
    }


    public Player Login(String email,String password)
    {
       // initDB();
        Player p = playerRepo.authenticatePlayer(email,password);
        System.out.println(playerRepo.msg);
        return p;
    }







}
