package Server;

import RMI.CashRMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Cash extends UnicastRemoteObject implements Payment, CashRMI {
    public Cash() throws RemoteException {
    }
    
    @Override
    public void makePayment(User user, float amount) throws RemoteException {
    
    }
    
    public void confirmCashPayment(Courier courier, float amount) throws RemoteException {
    
    }
}
