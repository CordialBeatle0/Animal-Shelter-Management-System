package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Observer extends Remote {
    void updateObserver(String message) throws RemoteException;
}
