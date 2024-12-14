package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface VisaRMI extends Remote {
    void makePayment(UserDTO user, float amount) throws RemoteException;
}
