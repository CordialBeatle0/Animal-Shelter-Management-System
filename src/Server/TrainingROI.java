package Server;

import RMI.TrainingDTO;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface TrainingROI extends Remote, Serializable {
    static ArrayList<TrainingDTO> viewAllTrainingVideos() throws RemoteException {
        return null;
    }
    
    TrainingDTO viewTrainingVideo() throws RemoteException;
}
