package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface VolunteerTaskRMI extends Remote {
    void addVolunteerTask() throws RemoteException;
    
    void removeVolunteerTask() throws RemoteException;
    
    VolunteerTaskDTO viewVolunteerTask() throws RemoteException;
    
    void recordTaskCompletion() throws RemoteException;
    
    ArrayList<VolunteerTaskDTO> viewAssignedVolunteerTask(int volunteerID) throws RemoteException;
}
