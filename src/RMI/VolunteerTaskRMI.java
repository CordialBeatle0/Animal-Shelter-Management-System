package RMI;

import Server.VolunteerTask;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface VolunteerTaskRMI extends Remote {
    void addVolunteerTask() throws RemoteException;
    
    void removeVolunteerTask() throws RemoteException;
    
    VolunteerTask viewVolunteerTask() throws RemoteException;
    
    void recordTaskCompletion() throws RemoteException;
    
    ArrayList<VolunteerTask> viewAssignedVolunteerTask(int volunteerID) throws RemoteException;
}
