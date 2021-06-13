package repositories;

import models.Playground;

import java.util.ArrayList;

public interface IPlaygroundRepo {

    public ArrayList<Playground> getPlaygroundsByArea(String area);

    public Playground AddNewPlayground(Playground pg);

    public Playground getPlayground(int ownerID);

    public boolean addSlot(Playground pg,String slot, String date);

    public boolean updateSlots();

    //public boolean addSlot(Playground pg, String time, String date);

    public boolean bookSlot(int playgroundID,String date, String time);

    public void displayPlaygrounds();

    public String getMessage();

    public  void  printSlots(int playgoundID);
}
