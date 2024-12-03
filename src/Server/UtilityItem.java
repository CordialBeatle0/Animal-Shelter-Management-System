package Server;

import java.util.ArrayList;

public class UtilityItem extends Item {
    private int restockThreshold;
    
    public UtilityItem(int ID, String itemName, int quality, String type, int restockThreshold) {
        super(ID, itemName, quality, type);
        this.restockThreshold = restockThreshold;
    }
    
    public int getRestockThreshold() {
        return restockThreshold;
    }
    
    public void setRestockThreshold(int restockThreshold) {
        this.restockThreshold = restockThreshold;
    }
    
    public void purchaseInventory() {
    
    }
    
    public UtilityItem viewUtilityItem() {
        return null;
    }
    
    public ArrayList<UtilityItem> viewAllUtilityItems() {
        return null;
    }
    
    public void donateSupplies(Item item) {
    
    }
    
    public void restockAlert() {
    
    }
}
