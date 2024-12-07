package Server;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class SellingItem extends Item { //TODO: Class cant extend Unicast thing what do we do
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
    
    public void buyItem() throws RemoteException {
    
    }
    
    public SellingItem viewSellingItem() throws RemoteException {
        return null;
    }
    
    public ArrayList<SellingItem> viewAllSellingItems() throws RemoteException {
        return null;
    }
}
