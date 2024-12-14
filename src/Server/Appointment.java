package Server;

import RMI.AnimalDTO;
import RMI.AppointmentDTO;
import RMI.AppointmentRMI;
import RMI.DoctorDTO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;

import javax.xml.crypto.Data;

public class Appointment extends UnicastRemoteObject implements AppointmentRMI {
    private int ID;
    private String date;
    private DoctorDTO doctor;
    private int price;
    private String description = "";
    private AnimalDTO animal;
    
    public Appointment() throws RemoteException {
    }
    
    public Appointment(String date, DoctorDTO doctor, int price, String description, AnimalDTO animal) throws RemoteException {
        this.date = date;
        this.doctor = doctor;
        this.price = price;
        this.description = description;
        this.animal = animal;
    }
    
    public Appointment(int ID, String date, DoctorDTO assignedDoctor, int price, String description,
                       AnimalDTO animal) throws RemoteException {
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
    
    public String getDate() {
        return date;
    }
    
    public void setDate(String date) {
        this.date = date;
    }
    
    public DoctorDTO getDoctor() {
        return doctor;
    }
    
    public void setDoctor(DoctorDTO assignedDoctor) {
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
    
    public AnimalDTO getAnimal() {
        return animal;
    }
    
    public void setAnimal(AnimalDTO animal) {
        this.animal = animal;
    }
    
    public void bookAppointment(int ID, String date, DoctorDTO assignedDoctor, int price, String description,
                                AnimalDTO animal) throws RemoteException {
        Appointment appointment = new Appointment(ID, date, assignedDoctor, price, description, animal);
        try {
            Database.addAppointment(appointment);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
    public void cancelAppointment(int ID) throws RemoteException {
        try {
            Appointment appointment = Database.vAppointment(ID);
            Database.deleteAppointment(appointment);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
    public AppointmentDTO viewAppointment(int ID) throws RemoteException {
        try {
            AppointmentDTO appointment = Database.viewAppointmentById(ID);
            return appointment;
        } catch (Exception e) {
            System.out.println("Could not view appointment");
            return null;
        }
        
    }
    
    public void recordAppointmentDetail(int ID, String details) throws RemoteException {
        try {
            Appointment appointment = Database.vAppointment(ID);
            Database.updateAppointmentDescription(appointment, details);
            appointment.setDescription(details);
        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }
    
    public AppointmentDTO getAppointment(int ID) throws RemoteException {
        try {
            return Database.viewAppointmentById(ID);
        } catch (Exception e) {
            System.out.println("Could not view appointment");
            return null;
        }
    }
    
    @Override
    public String toString() {
        return "Appointment [ID=" + ID + ", date=" + date + ", assignedDoctor=" + doctor + ", price=" + price
                + ", description=" + description + ", animal=" + animal + "]";
    }
    
}
