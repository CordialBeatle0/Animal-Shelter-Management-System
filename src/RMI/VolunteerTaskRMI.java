package RMI;

import Server.VolunteerTask;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface VolunteerTaskRMI extends Remote {
    void addVolunteerTask() throws RemoteException;
    
    void removeVolunteerTask() throws RemoteException;
    
    VolunteerTask viewVolunteerTask() throws RemoteException;
    
    void recordTaskCompletion() throws RemoteException;
}
