package Server;

import RMI.AppointmentDTO;
import RMI.AppointmentRMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;

public class Appointment extends UnicastRemoteObject implements AppointmentRMI {
    private int ID;
    private LocalDateTime date;
    private Doctor doctor;
    private int price;
    private String description = "";
    private Animal animal;
    
    public Appointment() throws RemoteException {
    }
    
    public Appointment(int ID, LocalDateTime date, Doctor assignedDoctor, int price, String description,
                       Animal animal) throws RemoteException {
        this.ID = ID;
        this.date = date;
        this.doctor = assignedDoctor;
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
    
    public Doctor getDoctor() {
        return doctor;
    }
    
    public void setDoctor(Doctor assignedDoctor) {
        this.doctor = assignedDoctor;
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
        try {
            Database.addAppointment(this);
        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }
    
    public void cancelAppointment() throws RemoteException {
        try {
            Database.deleteAppointment(this);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
    // TODO: make it read the doctor from the database
    public AppointmentDTO viewAppointment() throws RemoteException {
        try {
            Appointment appointment = Database.viewAppointmentById(this.getID());
            System.out.println(appointment.toString());
            return appointment;
        } catch (Exception e) {
            System.out.println("Could not view appointment");
            return null;
        }
        
    }
    
    public void recordAppointmentDetail(String details) throws RemoteException {
        try {
            Database.updateAppointmentDescription(this, details);
            setDescription(details);
        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }
    
    @Override
    public String toString() {
        return "Appointment [ID=" + ID + ", date=" + date + ", assignedDoctor=" + doctor + ", price=" + price
                + ", description=" + description + ", animal=" + animal + "]";
    }
    
    
}
