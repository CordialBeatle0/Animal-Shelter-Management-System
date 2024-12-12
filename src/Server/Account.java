package Server;

import RMI.AccountRMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Account extends UnicastRemoteObject implements AccountRMI {
    private int ID;
    private String username;
    private String password;
    
    public Account() throws RemoteException {
    }
    
    public Account(int ID, String username, String password) throws RemoteException {
        this.ID = ID;
        this.username = username;
        this.password = password;
    }
    
    public int getID() {
        return ID;
    }
    
    public void setID(int ID) {
        this.ID = ID;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public User userLogin(String username, String password) throws RemoteException {
        return Database.userLogin(username, password);
    }
    
    public Employee empLogin(String username, String password) throws RemoteException {
        return Database.empLogin(username, password);
    }
    
    public Volunteer volunteerLogin(String username, String password) throws RemoteException {
        return Database.volunteerLogin(username, password);
    }
    
    public void updateUserAccount(User user, String username, String password) throws RemoteException {
        Database.updateUserAccount(user, username, password);
    }
    
    public void updateSpecialisedAccount(Specialised specialised, String username, String password) throws RemoteException {
        Database.updateSpecialisedAccount(specialised, username, password);
    }
}
