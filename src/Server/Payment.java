package Server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Payment extends Remote { //TODO: Should this be remote
    void makePayment(User user, float amount) throws RemoteException;
}