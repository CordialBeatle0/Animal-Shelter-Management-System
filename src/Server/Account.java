package Server;

import RMI.*;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Account extends UnicastRemoteObject implements AccountRMI, Serializable {
    private int ID;
    private String username;
    private String password;
    
    public Account() throws RemoteException {
    }
    
    public Account(String username, String password) throws RemoteException {
        this.username = username;
        this.password = password;
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
    
    public UserDTO userLogin(String username, String password) throws RemoteException {
        // User user = Database.userLogin(username, password);
        // return new UserDTO(user.getID(), user.getName(), user.getPhoneNumber(), user.getAddress(),
        //         user.getOutstandingFees());
        // return null;
        return Database.userLogin(username, password);
    }
    
    public EmployeeDTO empLogin(String username, String password) throws RemoteException {
        return Database.empLogin(username, password);
    }
    
    public VolunteerDTO volunteerLogin(String username, String password) throws RemoteException {
        return Database.volunteerLogin(username, password);
    }
    
    public void updateUserAccount(UserDTO user, String username, String password) throws RemoteException {
        Database.updateUserAccount(user, username, password);
    }
    
    public void updateSpecialisedAccount(int specialisedID, String username, String password) throws RemoteException {
        Database.updateSpecialisedAccount(specialisedID, username, password);
    }
}
