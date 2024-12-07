package RMI;

import Server.Animal;
import Server.User;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface AnimalRMI extends Remote {
    void registerAnimal(Animal animal) throws RemoteException;
    
    void removeAnimal(int ID) throws RemoteException;
    
    void updateAnimal(Animal animal) throws RemoteException;
    
    Animal viewAnimal(Animal animal) throws RemoteException;
    
    ArrayList<Animal> viewAllAnimals() throws RemoteException;
    
    void recordFeeding() throws RemoteException;
    
    void adoptAnimal(User user) throws RemoteException;
    
    void fosterAnimal(User user) throws RemoteException;
    
    void sponsorAnimal(User user) throws RemoteException;
}
