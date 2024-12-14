package Server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.io.Serializable;

public interface StockStatus extends Remote, Serializable {
    void buyItem(int ID, int quantityNeeded, int userID, Payment payment) throws RemoteException;
}
