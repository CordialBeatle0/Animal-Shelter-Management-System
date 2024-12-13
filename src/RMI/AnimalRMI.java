package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface AnimalRMI extends Remote {
    void registerAnimal(AnimalDTO animal) throws RemoteException;
    
    void removeAnimal(int ID) throws RemoteException;
    
    AnimalDTO viewAnimal(AnimalDTO animal) throws RemoteException;
    
    ArrayList<AnimalDTO> viewAllAnimals() throws RemoteException;
    
    ArrayList<AnimalDTO> viewAllConditionedAnimals(String animalStatus) throws RemoteException;
    
    void recordFeeding(AnimalDTO animal) throws RemoteException;
    
    void adoptAnimal(AnimalDTO animal, UserDTO user) throws RemoteException;
    
    void fosterAnimal(AnimalDTO animal, UserDTO user) throws RemoteException;
    
    void sponsorAnimal(AnimalDTO animal, UserDTO user) throws RemoteException;
}
