package RMI;

import Server.Animal;
import Server.User;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface AnimalRMI extends Remote {
    void registerAnimal(Animal animal) throws RemoteException;
    
    void removeAnimal(int ID) throws RemoteException;
    
    Animal viewAnimal(Animal animal) throws RemoteException;
    
    ArrayList<Animal> viewAllAnimals() throws RemoteException;

    ArrayList<Animal> viewAllConditionedAnimals(String animalStatus) throws RemoteException;
     
    ArrayList<Animal> viewAllSponsorableAnimals() throws RemoteException;
    
    void recordFeeding(Animal animal) throws RemoteException;
    
    void adoptAnimal(Animal animal, User user) throws RemoteException;
    
    void fosterAnimal(Animal animal, User user) throws RemoteException;
    
    void sponsorAnimal(Animal animal, User user) throws RemoteException;
}
