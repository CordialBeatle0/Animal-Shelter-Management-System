package Server;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class UtilityItem extends Item {
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
    
    @Override
    public void addItem() throws RemoteException {
        Database.addUtilityItem(this);
    }
    
    @Override
    public boolean removeItem() throws RemoteException {
        return Database.removeUtilityItem(this);
    }
    
    public ArrayList<UtilityItem> purchaseInventory() throws RemoteException {
        ArrayList<UtilityItem> itemsThatNeedRestocking = new ArrayList<>();
        viewAllUtilityItems().forEach(item -> {
            if (item.getQuantity() < item.getRestockThreshold()) {
                itemsThatNeedRestocking.add(item);
            }
        });
        return itemsThatNeedRestocking;
    }
    
    public UtilityItem viewUtilityItem() throws RemoteException {
        return Database.viewUtilityItem(getID());
    }
    
    public ArrayList<UtilityItem> viewAllUtilityItems() throws RemoteException {
        return Database.viewAllUtilityItems();
    }
    
    // TODO: We can remove this function
    public void donateSupplies() throws RemoteException {
        addItem();
    }
    
    public String restockAlert() throws RemoteException {
        // StringBuilder is better for concatenating strings
        StringBuilder message = new StringBuilder("The following items need to be restocked: ");
        for (UtilityItem item : viewAllUtilityItems()) {
            if (item.getQuantity() < item.getRestockThreshold()) {
                message.append(item.getItemName()).append(", ");
            }
        }
        return message.toString();
    }
}
