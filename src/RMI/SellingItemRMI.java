package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface SellingItemRMI extends Remote {
    void addSellingItem(SellingItemDTO sellingItemDTO) throws RemoteException;
    
    void removeSellingItem(SellingItemDTO sellingItemDTO) throws RemoteException;
    
    void buyItem(int quantityRequired) throws RemoteException, Exception;
    
    SellingItemDTO viewSellingItem() throws RemoteException;
    
    ArrayList<SellingItemDTO> viewAllSellingItems() throws RemoteException;
}