package Server;

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

    public VolunteerTask() throws RemoteException {
    }

    public VolunteerTask(int ID, String taskName, String type, String date, boolean completionStatus) throws RemoteException {
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

    public void addVolunteerTask() throws RemoteException {
        Database.addVolunteerTask(this);
    }

    public void removeVolunteerTask() throws RemoteException {
        Database.removeVolunteerTask(ID);
    }

    public VolunteerTask viewVolunteerTask() throws RemoteException {
        return Database.viewVolunteerTask(ID);
    }

    public ArrayList<VolunteerTask> viewAllVolunteerTask() throws RemoteException {
        return Database.viewAllVolunteerTask();
    }

    public void recordTaskCompletion() throws RemoteException {
        Database.recordTaskCompletion(ID);
    }

    public ArrayList<VolunteerTask> viewAssignedVolunteerTask(int volunteerID) throws RemoteException {
        return Database.viewAssignedVolunteerTask(volunteerID);
    }
}
