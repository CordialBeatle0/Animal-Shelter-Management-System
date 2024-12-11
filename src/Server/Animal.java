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
    private String lastFeedingTime;
    private boolean adopted;
    private boolean sponsored;
    private boolean fostered;
    
    public Animal() throws RemoteException {
    }
    
    public Animal(int ID, String name, String animalType, String breed, int age, String lastFeedingTime,
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
    
    public String getLastFeedingTime() {
        return lastFeedingTime;
    }
    
    public void setLastFeedingTime(String lastFeedingTime) {
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
        Database.registerAnimal(animal);   
    }
    
    public void removeAnimal(int animalID) throws RemoteException {
    Database.removeAnimal(animalID);
    }
    
    
    public Animal viewAnimal(Animal animal) throws RemoteException {
         return Database.viewAnimal(animal);
        
    }
    
    public ArrayList<Animal> viewAllAnimals() throws RemoteException {
        return Database.viewAllAnimals();
    }

    public ArrayList<Animal> viewAllConditionedAnimals(String animalStatus) throws RemoteException {
        return Database.viewAllConditionedAnimals(animalStatus);
    }

    public ArrayList<Animal> viewAllSponsorableAnimals() throws RemoteException {
        return Database.viewAllSponsorableAnimals();
    }

    public void recordFeeding(Animal animal) throws RemoteException {
        Database.recordFeeding(animal);
    }
    
    public void adoptAnimal(Animal animal, User user) throws RemoteException {
        Database.adoptAnimal(animal, user);
    }
    
    public void fosterAnimal(Animal animal,User user) throws RemoteException {
        Database.fosterAnimal(animal, user);
    }
    
    public void sponsorAnimal( Animal animal, User user) throws RemoteException {
        Database.sponsorAnimal(animal, user);
    }
}
