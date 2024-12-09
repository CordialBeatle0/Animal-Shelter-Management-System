package Server;

import RMI.VolunteerTaskRMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;

public class VolunteerTask extends UnicastRemoteObject implements VolunteerTaskRMI {
    private int ID;
    private String taskName;
    private String type;
    private LocalDateTime date;
    private boolean completionStatus;
    
    public VolunteerTask() throws RemoteException {
    }
    
    public VolunteerTask(int ID, String taskName, String type, LocalDateTime date, boolean completionStatus) throws RemoteException {
        this.ID = ID;
        this.taskName = taskName;
        this.type = type;
        this.date = date;
        this.completionStatus = completionStatus;
    }
    
    public int getID() {
        return ID;
    }
    
    public void setID(int ID) {
        this.ID = ID;
    }
    
    public String getTaskName() {
        return taskName;
    }
    
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public LocalDateTime getDate() {
        return date;
    }
    
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    
    public boolean isCompletionStatus() {
        return completionStatus;
    }
    
    public void setCompletionStatus(boolean completionStatus) {
        this.completionStatus = completionStatus;
    }
    
    public void addVolunteerTask() throws RemoteException {
    
    }
    
    public void removeVolunteerTask() throws RemoteException {
    
    }
    
    public VolunteerTask viewVolunteerTask() throws RemoteException {
        return null;
    }
    
    public void recordTaskCompletion() throws RemoteException {
    
    }
}
