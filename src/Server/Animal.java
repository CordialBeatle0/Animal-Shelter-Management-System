package Server;

import RMI.AnimalDTO;
import RMI.AnimalRMI;
import RMI.UserDTO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
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
    
    public Animal(String name, String animalType, String breed, int age, String lastFeedingTime, boolean adopted,
                  boolean sponsored, boolean fostered) throws RemoteException {
        this.name = name;
        this.animalType = animalType;
        this.breed = breed;
        this.age = age;
        this.lastFeedingTime = lastFeedingTime;
        this.adopted = adopted;
        this.sponsored = sponsored;
        this.fostered = fostered;
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
    
    public void registerAnimal(AnimalDTO animal) throws RemoteException {
        Database.registerAnimal(animal);
    }
    
    public void removeAnimal(int animalID) throws RemoteException {
        Database.removeAnimal(animalID);
    }
    
    
    public AnimalDTO viewAnimal(int animalID) throws RemoteException {
        return Database.viewAnimal(animalID);
    }
    
    public ArrayList<AnimalDTO> viewAllAnimals() throws RemoteException {
        return Database.viewAllAnimals();
    }
    
    public ArrayList<AnimalDTO> viewAllConditionedAnimals(String animalStatus) throws RemoteException {
        return Database.viewAllConditionedAnimals(animalStatus);
    }
    
    
    public void recordFeeding(AnimalDTO animal) throws RemoteException {
        Database.recordFeeding(animal);
    }
    
    public void adoptAnimal(AnimalDTO animal, UserDTO user) throws RemoteException {
        Database.adoptAnimal(animal, user);
    }
    
    public void fosterAnimal(AnimalDTO animal, UserDTO user) throws RemoteException {
        Database.fosterAnimal(animal, user);
    }
    
    public void sponsorAnimal(AnimalDTO animal, UserDTO user) throws RemoteException {
        Database.sponsorAnimal(animal, user);
    }
    
    @Override
    public String toString() {
        return "Animal [ID=" + ID + ", name=" + name + ", animalType=" + animalType + ", breed=" + breed + ", age="
                + age + ", lastFeedingTime=" + lastFeedingTime + ", adopted=" + adopted + ", sponsored=" + sponsored
                + ", fostered=" + fostered + "]";
    }
    
    
}
