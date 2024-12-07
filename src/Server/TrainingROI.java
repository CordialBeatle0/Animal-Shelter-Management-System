package Server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface TrainingROI extends Remote {
    static ArrayList<Training> viewAllTrainingVideos() throws RemoteException {
        return null;
    }
    
    Training viewTrainingVideo() throws RemoteException;
}
