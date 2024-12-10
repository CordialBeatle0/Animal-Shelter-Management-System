package RMI;

import Server.Observer;
import Server.Training;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface TrainingRMI extends Remote {
    void uploadTrainingVideo() throws RemoteException;
    
    boolean removeTrainingVideo() throws RemoteException;
    
    Training viewTrainingVideo() throws RemoteException;
    
    ArrayList<Training> viewAllTrainingVideos() throws RemoteException;
    
    void addObserver(Observer observer) throws RemoteException;
    
    void removeObserver(Observer observer) throws RemoteException;
}
