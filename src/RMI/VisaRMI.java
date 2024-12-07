package RMI;

import Server.User;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface VisaRMI extends Remote {
    void makePayment(User user, float amount) throws RemoteException;
}
