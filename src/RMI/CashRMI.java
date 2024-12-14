package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CashRMI extends Remote {
    void makePayment(UserDTO user, float amount) throws RemoteException;
    
    String confirmCashPayment(CourierDTO courier, RequestDTO request, float amount) throws RemoteException;
}
