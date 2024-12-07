package RMI;

import Server.Courier;
import Server.User;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CashRMI extends Remote {
    void makePayment(User user, float amount) throws RemoteException;
    
    void confirmCashPayment(Courier courier, float amount) throws RemoteException;
}
