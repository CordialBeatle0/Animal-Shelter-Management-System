package RMI;

import java.io.Serializable;
import java.time.LocalDateTime;

public class AnimalDTO extends SpecialisedDTO implements Serializable {
    private int ID;
    private String name;
    private String animalType;
    private String breed;
    private int age;
    private LocalDateTime lastFeedingTime;
    private boolean adopted;
    private boolean sponsored;
    private boolean fostered;
    
    public AnimalDTO() {
    }
    
    public AnimalDTO(int ID, String name, String animalType, String breed, int age, LocalDateTime lastFeedingTime,
                     boolean adopted, boolean sponsored, boolean fostered) {
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
}
