package Server;

import java.time.LocalDateTime;

public class VolunteerTask {
    private int ID;
    private String taskName;
    private String type;
    private LocalDateTime date;
    private boolean completionStatus;
    
    public VolunteerTask(int ID, String taskName, String type, LocalDateTime date, boolean completionStatus) {
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
    
    public void addVolunteerTask() {
    
    }
    
    public void removeVolunteerTask() {
    
    }
    
    public VolunteerTask viewVolunteerTask() {
        return null;
    }
    
    public void recordTaskCompletion() {
    
    }
}
