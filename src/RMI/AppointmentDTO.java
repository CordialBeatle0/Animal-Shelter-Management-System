package RMI;

import java.io.Serializable;
import java.time.LocalDateTime;

public class AppointmentDTO implements Serializable {
    private int ID;
    private LocalDateTime date;
    private String assignedDoctorName;
    private int price;
    private String description;
    private String animalName;
    private String animalType;
    
    public AppointmentDTO() {
    }
    
    public AppointmentDTO(LocalDateTime date, String assignedDoctorName, int price, String description,
                          String animalName, String animalType) {
        this.date = date;
        this.assignedDoctorName = assignedDoctorName;
        this.price = price;
        this.description = description;
        this.animalName = animalName;
        this.animalType = animalType;
    }
    
    public AppointmentDTO(int ID, LocalDateTime date, String assignedDoctorName, int price, String description,
                          String animalName, String animalType) {
        this.ID = ID;
        this.date = date;
        this.assignedDoctorName = assignedDoctorName;
        this.price = price;
        this.description = description;
        this.animalName = animalName;
        this.animalType = animalType;
    }
    
    public int getID() {
        return ID;
    }
    
    public void setID(int ID) {
        this.ID = ID;
    }
    
    public LocalDateTime getDate() {
        return date;
    }
    
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    
    public String getAssignedDoctorName() {
        return assignedDoctorName;
    }
    
    public void setAssignedDoctorName(String assignedDoctorName) {
        this.assignedDoctorName = assignedDoctorName;
    }
    
    public int getPrice() {
        return price;
    }
    
    public void setPrice(int price) {
        this.price = price;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getAnimalName() {
        return animalName;
    }
    
    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }
    
    public String getAnimalType() {
        return animalType;
    }
    
    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }
}
