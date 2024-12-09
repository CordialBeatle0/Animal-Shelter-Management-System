package Server;

import RMI.AppointmentRMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;

public class Appointment extends UnicastRemoteObject implements AppointmentRMI {
    private int ID;
    private LocalDateTime date;
    private Doctor assignedDoctor;
    private int price;
    private String description;
    private Animal animal;
    
    public Appointment() throws RemoteException {
    }
    
    public Appointment(int ID, LocalDateTime date, Doctor assignedDoctor, int price, String description,
                       Animal animal) throws RemoteException {
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
    
    public void bookAppointment() throws RemoteException {
    
    }
    
    public void cancelAppointment() throws RemoteException {
    
    }
    
    public Appointment viewAppointment() throws RemoteException {
        return null;
    }
    
    public void recordAppointmentDetail(String details) throws RemoteException {
    
    }
}
