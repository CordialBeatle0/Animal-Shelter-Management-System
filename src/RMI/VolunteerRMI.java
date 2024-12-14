package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface VolunteerRMI extends Remote {
    void signUpToVolunteering(VolunteerDTO vol) throws RemoteException;

    void assignVolunteer(int taskID, int volunteerID) throws RemoteException;

    void removeVolunteer(int volunteerID) throws RemoteException;
}
