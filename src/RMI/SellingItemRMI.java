package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface SellingItemRMI extends Remote {
    void addSellingItem(SellingItemDTO sellingItemDTO) throws RemoteException;

    void removeSellingItem(SellingItemDTO sellingItemDTO) throws RemoteException;

    void buyItem(int quantityRequired, int userID, String payment) throws RemoteException, Exception;

    SellingItemDTO viewSellingItem(int ID) throws RemoteException;

    ArrayList<SellingItemDTO> viewAllSellingItems() throws RemoteException;
}
