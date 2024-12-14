package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface TrainingRMI extends Remote {
    void uploadTrainingVideo() throws RemoteException;
    
    void removeTrainingVideo(int trainingID) throws RemoteException;
    
    TrainingDTO viewTrainingVideo() throws RemoteException;
    
    ArrayList<TrainingDTO> viewAllTrainingVideos() throws RemoteException;
}
