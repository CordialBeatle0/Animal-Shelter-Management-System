package RMI;

import Server.Employee;
import Server.Specialised;
import Server.User;
import Server.Volunteer;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AccountRMI extends Remote {
    User userLogin(String username, String password) throws RemoteException;
    
    Employee empLogin(String username, String password) throws RemoteException;
    
    Volunteer volunteerLogin(String username, String password) throws RemoteException;
    
    void updateUserAccount(User user, String username, String password) throws RemoteException;
    
    void updateSpecialisedAccount(Specialised specialised, String username, String password) throws RemoteException;
}
