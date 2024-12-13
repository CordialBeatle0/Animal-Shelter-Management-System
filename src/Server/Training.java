package Server;

import RMI.Observer;
import RMI.TrainingDTO;
import RMI.TrainingRMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Training extends UnicastRemoteObject implements TrainingROI, Publisher, TrainingRMI {
    private static ArrayList<Observer> observers;
    private int ID;
    private String url;
    private LocalDateTime uploadedDate; // TODO: Maybe change to string
    private float runtime;
    private String description;
    
    public Training() throws RemoteException {
    }
    
    public Training(int ID, String url, LocalDateTime uploadedDate, float runtime, String description) throws RemoteException {
        this.ID = ID;
        this.url = url;
        this.uploadedDate = uploadedDate;
        this.runtime = runtime;
        this.description = description;
    }
    
    public static ArrayList<Observer> getObservers() {
        return observers;
    }
    
    public static void setObservers(ArrayList<Observer> observers) {
        Training.observers = observers;
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
        Database.uploadTrainingVideo(this);
        notifySubscriber("A new video has been uploaded");
    }
    
    public void removeTrainingVideo() throws RemoteException {
        Database.removeTrainingVideo(this);
    }
    
    @Override
    public TrainingDTO viewTrainingVideo() throws RemoteException {
        return Database.viewTrainingVideo(this.ID);
    }
    
    @Override
    public ArrayList<TrainingDTO> viewAllTrainingVideos() throws RemoteException {
        return Database.getAllTrainingVideos();
    }
    
    @Override
    public void addObserver(Observer observer) {
        Database.addObserver(observer);
    }
    
    @Override
    public void removeObserver(Observer observer) {
        Database.removeObserver(observer);
    }
    
    @Override
    public void notifySubscriber(String message) throws RemoteException {
        observers = Database.getAllObservers();
        for (Observer observer : observers) {
            observer.updateObserver(message);
        }
    }
}
