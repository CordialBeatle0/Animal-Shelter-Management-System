package RMI;

import Server.Observer;
import Server.Training;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TrainingRMI extends Remote {
    void uploadTrainingVideo() throws RemoteException;
    
    void removeTrainingVideo() throws RemoteException;
    
    Training viewTrainingVideo() throws RemoteException;
    
    void addObserver(Observer observer) throws RemoteException;
    
    void removeObserver(Observer observer) throws RemoteException;
}
