package Server;

import RMI.VolunteerTaskDTO;
import RMI.VolunteerTaskRMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class VolunteerTask extends UnicastRemoteObject implements VolunteerTaskRMI {

    private int ID;
    private String taskName;
    private String type;
    private String date;
    private boolean completionStatus;
    private int assignedVolunteer;

    public VolunteerTask() throws RemoteException {
    }

    public VolunteerTask(int ID, String taskName, String type, String date, boolean completionStatus, int assignedVolunteer)
            throws RemoteException {
        this.ID = ID;
        this.taskName = taskName;
        this.type = type;
        this.date = date;
        this.completionStatus = completionStatus;
        this.assignedVolunteer= assignedVolunteer;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isCompletionStatus() {
        return completionStatus;
    }

    public void setCompletionStatus(boolean completionStatus) {
        this.completionStatus = completionStatus;
    }

    public int getAssignedVolunteer() {
        return assignedVolunteer;
    }

    public void setAssignedVolunteer(int assignedVolunteer) {
        this.assignedVolunteer = assignedVolunteer;
    }

  
    
    

    public void addVolunteerTask(VolunteerTaskDTO task) throws RemoteException {
        Database.addVolunteerTask(task);
    }

    public void removeVolunteerTask(int taskID) throws RemoteException {
        Database.removeVolunteerTask(taskID);
    }

    public VolunteerTaskDTO viewVolunteerTask(int taskID) throws RemoteException {
        return Database.viewVolunteerTask(taskID);
    }

    public ArrayList<VolunteerTaskDTO> viewAllVolunteerTask() throws RemoteException {
        return Database.viewAllVolunteerTask();
    }

    public void recordTaskCompletion(int taskID) throws RemoteException {
        Database.recordTaskCompletion(taskID);
    }

    public ArrayList<VolunteerTaskDTO> viewAssignedVolunteerTask(int volunteerID) throws RemoteException {
        return Database.viewAssignedVolunteerTask(volunteerID);
    }
}
