package Server;

import RMI.Observer;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Publisher extends Remote {
    void addObserver(Observer observer) throws RemoteException;
    
    void removeObserver(Observer observer) throws RemoteException;
    
    void notifySubscriber(String message) throws RemoteException;
}