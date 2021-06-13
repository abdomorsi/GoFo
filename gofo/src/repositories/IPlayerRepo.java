package repositories;

import models.Person;
import models.Player;
import models.Playground;

import java.util.ArrayList;

public interface IPlayerRepo {

    public Player authenticatePlayer(String email, String password);

    public Player AddNewPlayer(Person person);

    public Player findPlayerByEmail(String email);

    public void printPlayers();

    public String getMessage();

}
