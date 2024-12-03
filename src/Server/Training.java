package Server;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Training implements TrainingROI, Publisher {
    private ArrayList<Observer> observers;
    private int ID;
    private URL url;
    private LocalDateTime uploadedDate;
    private float runtime;
    private String description;
    
    public Training(ArrayList<Observer> observers, int ID, URL url, LocalDateTime uploadedDate, float runtime,
                    String description) {
        this.observers = observers;
        this.ID = ID;
        this.url = url;
        this.uploadedDate = uploadedDate;
        this.runtime = runtime;
        this.description = description;
    }
    
    public ArrayList<Observer> getObservers() {
        return observers;
    }
    
    public void setObservers(ArrayList<Observer> observers) {
        this.observers = observers;
    }
    
    public int getID() {
        return ID;
    }
    
    public void setID(int ID) {
        this.ID = ID;
    }
    
    public URL getUrl() {
        return url;
    }
    
    public void setUrl(URL url) {
        this.url = url;
    }
    
    public LocalDateTime getUploadedDate() {
        return uploadedDate;
    }
    
    public void setUploadedDate(LocalDateTime uploadedDate) {
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
    
    public void uploadTrainingVideo() {
    
    }
    
    public void removeTrainingVideo() {
    
    }
    
    @Override
    public Training viewTrainingVideo() {
        return null;
    }
    
    @Override
    public void addObserver(Observer observer) {
    
    }
    
    @Override
    public void removeObserver(Observer observer) {
    
    }
    
    @Override
    public void notifySubscriber() {
    
    }
}
