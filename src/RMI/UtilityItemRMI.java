package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface UtilityItemRMI extends Remote {
    public void addItem(UtilityItemDTO utilityItemDTO) throws RemoteException;
    
    public void removeItem(UtilityItemDTO utilityItemDTO) throws RemoteException;
    
    public ArrayList<UtilityItemDTO> viewAllUtilityItems() throws RemoteException;
    
    public ArrayList<UtilityItemDTO> purchaseInventory() throws RemoteException;
}
