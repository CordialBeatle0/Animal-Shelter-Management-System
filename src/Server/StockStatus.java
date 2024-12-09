package Server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface StockStatus extends Remote {
    void buyItem(int ID, int quantityNeeded) throws RemoteException, Exception;
}
