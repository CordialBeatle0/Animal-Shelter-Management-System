package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface UserRMI extends Remote {
    void signUp(UserDTO user) throws RemoteException;
    
    void removeNotification(UserDTO user) throws RemoteException;
    
    ArrayList<String> getNotifications(UserDTO user) throws RemoteException;
}
