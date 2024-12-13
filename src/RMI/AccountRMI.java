package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AccountRMI extends Remote {
    UserDTO userLogin(String username, String password) throws RemoteException;
    
    EmployeeDTO empLogin(String username, String password) throws RemoteException;
    
    VolunteerDTO volunteerLogin(String username, String password) throws RemoteException;
    
    void updateUserAccount(UserDTO user, String username, String password) throws RemoteException;
    
    void updateSpecialisedAccount(int specialisedID, String username, String password) throws RemoteException;
}
