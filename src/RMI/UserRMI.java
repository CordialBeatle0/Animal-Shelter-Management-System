package RMI;

import Server.User;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UserRMI extends Remote {
    void signUp(User user) throws RemoteException;
}
