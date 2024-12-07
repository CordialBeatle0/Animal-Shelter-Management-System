package Server;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class UtilityItem extends Item { //TODO: Class cant extend Unicast thing what do we do
    private int restockThreshold;
    
    public UtilityItem(int ID, String itemName, int quality, String type, int restockThreshold) throws RemoteException {
        super(ID, itemName, quality, type);
        this.restockThreshold = restockThreshold;
    }
    
    public int getRestockThreshold() {
        return restockThreshold;
    }
    
    public void setRestockThreshold(int restockThreshold) {
        this.restockThreshold = restockThreshold;
    }
    
    public void purchaseInventory() throws RemoteException {
    
    }
    
    public UtilityItem viewUtilityItem() throws RemoteException {
        return null;
    }
    
    public ArrayList<UtilityItem> viewAllUtilityItems() throws RemoteException {
        return null;
    }
    
    public void donateSupplies(Item item) throws RemoteException {
    
    }
    
    public void restockAlert() {
    
    }
}
