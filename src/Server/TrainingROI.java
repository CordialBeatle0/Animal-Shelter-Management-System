package Server;

import RMI.TrainingDTO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface TrainingROI extends Remote {
    static ArrayList<TrainingDTO> viewAllTrainingVideos() throws RemoteException {
        return null;
    }
    
    TrainingDTO viewTrainingVideo() throws RemoteException;
}
