package Server;

import RMI.InStockRMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class InStock extends UnicastRemoteObject implements StockStatus, InStockRMI {
    public InStock() throws RemoteException {
    }
    
    @Override
    public void buyItem(int ID, int quantityNeeded) throws RemoteException {
        Database.buyItem(ID, quantityNeeded);
    }
}
