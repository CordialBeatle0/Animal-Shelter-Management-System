package Server;

import RMI.VolunteerDTO;
import RMI.VolunteerRMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Volunteer extends UnicastRemoteObject implements VolunteerRMI {

    private int ID;
    private String name;
    private Account account;
    private String phoneNumber;
    private String Address;

    public Volunteer() throws RemoteException {
    }

    public Volunteer(int ID, String name, Account account, String phoneNumber, String address) throws RemoteException {
        this.ID = ID;
        this.name = name;
        this.account = account;
        this.phoneNumber = phoneNumber;
        Address = address;
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

    public void assignVolunteer(int taskID, int volunteerID) throws RemoteException {
        Database.assignVolunteer(taskID, volunteerID);
    }

    public void signUpToVolunteering(VolunteerDTO vol) throws RemoteException {
        Database.signUpToVolunteering(vol);
    }

    public void removeVolunteer(int volunteerID) throws RemoteException {
        Database.removeVolunteer(volunteerID);
    }
}
