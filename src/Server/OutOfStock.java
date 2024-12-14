package Server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class OutOfStock extends UnicastRemoteObject implements StockStatus {
    public OutOfStock() throws RemoteException {
    }
    
    @Override
    public void buyItem(int ID, int quantityNeeded, int userID, Payment payment) throws RemoteException{
        System.out.println("Out of stock");
    }
}
