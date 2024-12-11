package RMI;

import java.io.Serializable;

public class TrainingDTO implements Serializable {
    private int ID;
    private String url;
    private String uploadedDate;
    private float runtime;
    private String description;
    
    public TrainingDTO() {
    }
    
    public TrainingDTO(int ID, String url, String uploadedDate, float runtime, String description) {
        this.ID = ID;
        this.url = url;
        this.uploadedDate = uploadedDate;
        this.runtime = runtime;
        this.description = description;
    }
    
    public int getID() {
        return ID;
    }
    
    public void setID(int ID) {
        this.ID = ID;
    }
    
    public String getUrl() {
        return url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    
    public String getUploadedDate() {
        return uploadedDate;
    }
    
    public void setUploadedDate(String uploadedDate) {
        this.uploadedDate = uploadedDate;
    }
    
    public float getRuntime() {
        return runtime;
    }
    
    public void setRuntime(float runtime) {
        this.runtime = runtime;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
}
