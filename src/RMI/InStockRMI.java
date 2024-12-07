package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InStockRMI extends Remote {
    void buyItem() throws RemoteException;
}
