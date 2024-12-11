package RMI;

import Server.Training;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface TrainingRMI extends Remote {
    void uploadTrainingVideo() throws RemoteException;
    
    void removeTrainingVideo() throws RemoteException;
    
    Training viewTrainingVideo() throws RemoteException;
    
    ArrayList<Training> viewAllTrainingVideos() throws RemoteException;
}
