package Server;

import RMI.VolunteerRMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Volunteer extends UnicastRemoteObject implements VolunteerRMI {
    private int ID;
    private String name;
    private Account account;
    private String phoneNumber;
    private String Address;
    private ArrayList<VolunteerTask> tasks;
    
    public Volunteer() throws RemoteException {
    }
    
    public Volunteer(int ID, String name, Account account, String phoneNumber, String address,
                     ArrayList<VolunteerTask> tasks) throws RemoteException {
        this.ID = ID;
        this.name = name;
        this.account = account;
        this.phoneNumber = phoneNumber;
        Address = address;
        this.tasks = tasks;
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
    
    public Account getAccount() {
        return account;
    }
    
    public void setAccount(Account account) {
        this.account = account;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public String getAddress() {
        return Address;
    }
    
    public void setAddress(String address) {
        Address = address;
    }
    
    public ArrayList<VolunteerTask> getTasks() {
        return tasks;
    }
    
    public void setTasks(ArrayList<VolunteerTask> tasks) {
        this.tasks = tasks;
    }
    
    public void assignVolunteer() {
    
    }
    
    public void signUpToVolunteering() throws RemoteException {
    
    }
    
    public void removeVolunteer() throws RemoteException {
    
    }
}
