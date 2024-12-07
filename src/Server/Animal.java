package Server;

import RMI.AnimalRMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Animal extends UnicastRemoteObject implements AnimalRMI {
    private int ID;
    private String name;
    private String animalType;
    private String breed;
    private int age;
    private LocalDateTime lastFeedingTime;
    private boolean adopted;
    private boolean sponsored;
    private boolean fostered;
    
    public Animal(int ID, String name, String animalType, String breed, int age, LocalDateTime lastFeedingTime,
                  boolean adopted, boolean sponsored, boolean fostered) throws RemoteException {
        this.ID = ID;
        this.name = name;
        this.animalType = animalType;
        this.breed = breed;
        this.age = age;
        this.lastFeedingTime = lastFeedingTime;
        this.adopted = adopted;
        this.sponsored = sponsored;
        this.fostered = fostered;
    }
    
    public int getID() {
        return ID;
    }
    
    public void setID(int ID) {
        this.ID = ID;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getAnimalType() {
        return animalType;
    }
    
    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }
    
    public String getBreed() {
        return breed;
    }
    
    public void setBreed(String breed) {
        this.breed = breed;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public LocalDateTime getLastFeedingTime() {
        return lastFeedingTime;
    }
    
    public void setLastFeedingTime(LocalDateTime lastFeedingTime) {
        this.lastFeedingTime = lastFeedingTime;
    }
    
    public boolean isAdopted() {
        return adopted;
    }
    
    public void setAdopted(boolean adopted) {
        this.adopted = adopted;
    }
    
    public boolean isSponsored() {
        return sponsored;
    }
    
    public void setSponsored(boolean sponsored) {
        this.sponsored = sponsored;
    }
    
    public boolean isFostered() {
        return fostered;
    }
    
    public void setFostered(boolean fostered) {
        this.fostered = fostered;
    }
    
    public void registerAnimal(Animal animal) throws RemoteException {
    
    }
    
    public void removeAnimal(int ID) throws RemoteException {
    
    }
    
    public void updateAnimal(Animal animal) throws RemoteException {
    
    }
    
    public Animal viewAnimal(Animal animal) throws RemoteException {
        return null;
    }
    
    public ArrayList<Animal> viewAllAnimals() throws RemoteException {
        return null;
    }
    
    public void recordFeeding() throws RemoteException {
    
    }
    
    public void adoptAnimal(User user) throws RemoteException {
    
    }
    
    public void fosterAnimal(User user) throws RemoteException {
    
    }
    
    public void sponsorAnimal(User user) throws RemoteException {
    
    }
}
