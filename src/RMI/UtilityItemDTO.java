package RMI;

public class UtilityItemDTO {
    private int ID;
    private String name;
    private float price;
    private int quantity;
    private int restockThreshold;
    
    public UtilityItemDTO() {
    }
    
    public UtilityItemDTO(int ID, String name, float price, int quantity, int restockThreshold) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.restockThreshold = restockThreshold;
    }
    
    public UtilityItemDTO(String name, float price, int quantity, int restockThreshold) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.restockThreshold = restockThreshold;
    }
    
    public int getID() {
        return ID;
    }
    
    public void setID(int ID) {
        this.ID = ID;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public float getPrice() {
        return price;
    }
    
    public void setPrice(float price) {
        this.price = price;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public int getRestockThreshold() {
        return restockThreshold;
    }
    
    public void setRestockThreshold(int restockThreshold) {
        this.restockThreshold = restockThreshold;
    }
}
