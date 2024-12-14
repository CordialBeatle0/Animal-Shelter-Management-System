package Server;

import RMI.UtilityItemDTO;
import RMI.UtilityItemRMI;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class UtilityItem extends Item implements UtilityItemRMI {
    private int restockThreshold;
    
    public UtilityItem() throws RemoteException {
    }
    
    public UtilityItem(String itemName, int quantity, int restockThreshold) throws RemoteException {
        super(itemName, quantity);
        this.restockThreshold = restockThreshold;
    }
    
    public UtilityItem(int ID, String itemName, int quantity, int restockThreshold) throws RemoteException {
        super(ID, itemName, quantity);
        this.restockThreshold = restockThreshold;
    }
    
    public int getRestockThreshold() {
        return restockThreshold;
    }
    
    public void setRestockThreshold(int restockThreshold) {
        this.restockThreshold = restockThreshold;
    }
    
    public void addItem(UtilityItemDTO utilityItemDTO) throws RemoteException {
        Database.addUtilityItem(utilityItemDTO);
    }
    
    public void removeItem(UtilityItemDTO utilityItemDTO) throws RemoteException {
        Database.removeUtilityItem(utilityItemDTO);
    }
    
    public ArrayList<UtilityItemDTO> purchaseInventory() throws RemoteException {
        ArrayList<UtilityItemDTO> itemsThatNeedRestocking = new ArrayList<>();
        viewAllUtilityItems().forEach(item -> {
            if (item.getQuantity() < item.getRestockThreshold()) {
                itemsThatNeedRestocking.add(item);
            }
        });
        return itemsThatNeedRestocking;
    }
    
    public UtilityItemDTO viewUtilityItem() throws RemoteException {
        return Database.viewUtilityItem(getID());
    }
    
    public ArrayList<UtilityItemDTO> viewAllUtilityItems() throws RemoteException {
        return Database.viewAllUtilityItems();
    }
    
    public String restockAlert() throws RemoteException {
        // StringBuilder is better for concatenating strings
        StringBuilder message = new StringBuilder("The following items need to be restocked: ");
        for (UtilityItemDTO item : viewAllUtilityItems()) {
            if (item.getQuantity() < item.getRestockThreshold()) {
                message.append(item.getName()).append(", ");
            }
        }
        return message.toString();
    }
}
