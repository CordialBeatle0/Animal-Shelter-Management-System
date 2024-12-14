package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Payment extends Remote {
    void makePayment(UserDTO user, float amount) throws RemoteException;
}
