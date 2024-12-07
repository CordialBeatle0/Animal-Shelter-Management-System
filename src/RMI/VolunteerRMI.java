package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface VolunteerRMI extends Remote {
    void signUpToVolunteering() throws RemoteException;
    
    void removeVolunteer() throws RemoteException;
}
