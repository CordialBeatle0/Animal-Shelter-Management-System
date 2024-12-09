package Server;

import RMI.TrainingRMI;

import java.net.URL;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Training extends UnicastRemoteObject implements TrainingROI, Publisher, TrainingRMI {
    private ArrayList<Observer> observers;
    private int ID;
    private URL url;
    private LocalDateTime uploadedDate;
    private float runtime;
    private String description;
    
    public Training() throws RemoteException {
    }
    
    public Training(ArrayList<Observer> observers, int ID, URL url, LocalDateTime uploadedDate, float runtime,
                    String description) throws RemoteException {
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
    
    public void uploadTrainingVideo() throws RemoteException {
    
    }
    
    public void removeTrainingVideo() throws RemoteException {
    
    }
    
    @Override
    public Training viewTrainingVideo() throws RemoteException {
        return null;
    }
    
    @Override
    public void addObserver(Observer observer) throws RemoteException {
    
    }
    
    @Override
    public void removeObserver(Observer observer) throws RemoteException {
    
    }
    
    @Override
    public void notifySubscriber() {
    
    }
}
