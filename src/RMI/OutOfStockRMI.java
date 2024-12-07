package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface OutOfStockRMI extends Remote {
    void buyItem() throws RemoteException;
}
