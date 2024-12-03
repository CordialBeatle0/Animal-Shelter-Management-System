package RMI;

import Server.Employee;
import Server.Specialised;
import Server.User;
import Server.Volunteer;

import java.rmi.RemoteException;

public interface AccountRMI {
    public User userLogin(String username, String password) throws RemoteException;
    
    public Employee empLogin(String username, String password) throws RemoteException;
    
    public Volunteer volunteerLogin(String username, String password) throws RemoteException;
    
    public void updateUserAccount(User user, String username, String password) throws RemoteException;
    
    public void updateSpecialisedAccount(Specialised specialised, String username, String password) throws RemoteException;
}
