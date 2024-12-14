package RMI;

import java.io.Serializable;

public class SellingItemDTO implements Serializable {
    private int ID;
    private String name;
    private int quantity;
    private String stockStatus;
    private float price;
    
    public SellingItemDTO() {
    }
    
    public SellingItemDTO(String name, int quantity, String stockStatus, float price) {
        this.name = name;
        this.quantity = quantity;
        this.stockStatus = stockStatus;
        this.price = price;
    }
    
    public SellingItemDTO(int ID, String name, int quantity, String stockStatus, float price) {
        this.ID = ID;
        this.name = name;
        this.quantity = quantity;
        this.stockStatus = stockStatus;
        this.price = price;
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
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public String getStockStatus() {
        return stockStatus;
    }
    
    public void setStockStatus(String stockStatus) {
        this.stockStatus = stockStatus;
    }
    
    public float getPrice() {
        return price;
    }
    
    public void setPrice(float price) {
        this.price = price;
    }
}
