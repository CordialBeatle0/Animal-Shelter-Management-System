package Server;

import RMI.VisaRMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Visa extends UnicastRemoteObject implements Payment, VisaRMI {
    public Visa() throws RemoteException {
    }
    
    @Override
    public void makePayment(User user, float amount) throws RemoteException {
    
    }
}
