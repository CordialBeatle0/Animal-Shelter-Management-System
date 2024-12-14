package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface VolunteerTaskRMI extends Remote {
    void addVolunteerTask(VolunteerTaskDTO task) throws RemoteException;
    
    void removeVolunteerTask(int taskID) throws RemoteException;
    
    VolunteerTaskDTO viewVolunteerTask(int taskID) throws RemoteException;
    
    void recordTaskCompletion(int taskID) throws RemoteException;
    
    public ArrayList<VolunteerTaskDTO> viewAllVolunteerTask() throws RemoteException;
    
    ArrayList<VolunteerTaskDTO> viewAssignedVolunteerTask(int volunteerID) throws RemoteException;
}
