package Server;

import java.util.ArrayList;

public class SellingItem extends Item {
    private StockStatus stockStatus;
    private float price;
    
    public SellingItem(int ID, String itemName, int quality, String type, StockStatus stockStatus, float price) {
        super(ID, itemName, quality, type);
        this.stockStatus = stockStatus;
        this.price = price;
    }
    
    public StockStatus getStockStatus() {
        return stockStatus;
    }
    
    public void setStockStatus(StockStatus stockStatus) {
        this.stockStatus = stockStatus;
    }
    
    public float getPrice() {
        return price;
    }
    
    public void setPrice(float price) {
        this.price = price;
    }
    
    public void buyItem() {
    
    }
    
    public SellingItem viewSellingItem() {
        return null;
    }
    
    public ArrayList<SellingItem> viewAllSellingItems() {
        return null;
    }
}
