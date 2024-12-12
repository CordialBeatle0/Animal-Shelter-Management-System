package RMI;

import Server.Courier;
import Server.User;
import Server.Request;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CashRMI extends Remote {
    void makePayment(User user, float amount) throws RemoteException;
    
    String confirmCashPayment(Courier courier, Request request, float amount) throws RemoteException;
}
