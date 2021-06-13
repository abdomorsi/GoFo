package repositories;

import models.Person;

import models.PlaygroundOwner;

public interface IPlaygroundOwnerRepo {

    public PlaygroundOwner authenticatePlaygroundOwner(String email, String password);

    public PlaygroundOwner AddNewPlaygroundOwner(Person person);

    public PlaygroundOwner findPlaygroundOwnerByEmail(String email);

    public String getMessage();

   // public void initDB();

    public void printPlaygroundOwners();
}
