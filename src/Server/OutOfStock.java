package Server;

import RMI.OutOfStockRMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class OutOfStock extends UnicastRemoteObject implements StockStatus, OutOfStockRMI {
    public OutOfStock() throws RemoteException {
    }
    
    @Override
    public void buyItem(int ID, int quantityNeeded) throws RemoteException, Exception {
        throw new Exception(" is out of stock");
    }
}
