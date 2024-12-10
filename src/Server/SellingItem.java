package Server;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class SellingItem extends Item {
    private StockStatus stockStatus;
    private float price;
    
    public SellingItem(int ID, String itemName, int quality, String type, StockStatus stockStatus, float price) throws RemoteException {
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
    
    @Override
    public void addItem() throws RemoteException {
        Database.addSellingItem(this);
    }
    
    @Override
    public boolean removeItem() throws RemoteException {
        return Database.removeSellingItem(this);
    }
    
    public void buyItem(int quantityRequired) throws RemoteException, Exception {
        if (getQuantity() < quantityRequired) {
            setStockStatus(new OutOfStock());
        } else {
            setStockStatus(new InStock());
        }
        try {
            stockStatus.buyItem(getID(), quantityRequired);
        } catch (Exception e) {
            throw new Exception(getItemName() + e.getMessage());
        }
    }
    
    public SellingItem viewSellingItem() throws RemoteException {
        return Database.viewSellingItem(getID());
    }
    
    public ArrayList<SellingItem> viewAllSellingItems() throws RemoteException {
        return Database.viewAllSellingItems();
    }
}
