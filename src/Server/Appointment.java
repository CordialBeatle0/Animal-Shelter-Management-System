package Server;

import java.time.LocalDateTime;

public class Appointment {
    private int ID;
    private LocalDateTime date;
    private Doctor assignedDoctor;
    private int price;
    private String description;
    private Animal animal;
    
    public Appointment(int ID, LocalDateTime date, Doctor assignedDoctor, int price, String description,
                       Animal animal) {
        this.ID = ID;
        this.date = date;
        this.assignedDoctor = assignedDoctor;
        this.price = price;
        this.description = description;
        this.animal = animal;
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
    
    public Doctor getAssignedDoctor() {
        return assignedDoctor;
    }
    
    public void setAssignedDoctor(Doctor assignedDoctor) {
        this.assignedDoctor = assignedDoctor;
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
    
    public Animal getAnimal() {
        return animal;
    }
    
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
    
    public void bookAppointment() {
    
    }
    
    public void cancelAppointment() {
    
    }
    
    public Appointment viewAppointment() {
        return null;
    }
    
    public void recordAppointmentDetail(String details) {
    
    }
}
