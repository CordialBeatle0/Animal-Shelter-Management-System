package Server;

public class Item {
    private int ID;
    private String itemName;
    private int quality;
    private String type;
    
    public Item(int ID, String itemName, int quality, String type) {
        this.ID = ID;
        this.itemName = itemName;
        this.quality = quality;
        this.type = type;
    }
    
    public int getID() {
        return ID;
    }
    
    public void setID(int ID) {
        this.ID = ID;
    }
    
    public String getItemName() {
        return itemName;
    }
    
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    
    public int getQuality() {
        return quality;
    }
    
    public void setQuality(int quality) {
        this.quality = quality;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public void addItem() {
        // how no parameters
    }
    
    public void removeItem() {
        // how no parameters
    }
}
