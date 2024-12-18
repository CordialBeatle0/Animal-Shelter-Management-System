package Server;

import RMI.SellingItemDTO;
import RMI.SellingItemRMI;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class SellingItem extends Item implements SellingItemRMI {
    private StockStatus stockStatus;
    private float price;
    
    public SellingItem() throws RemoteException {
    }
    
    public SellingItem(String itemName, int quantity, StockStatus stockStatus, float price) throws RemoteException {
        super(itemName, quantity);
        this.stockStatus = stockStatus;
        this.price = price;
    }
    
    public SellingItem(int ID, String itemName, int quality, String type, StockStatus stockStatus, float price)
            throws RemoteException {
        super(ID, itemName, quality);
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
    
    public void addSellingItem(SellingItemDTO sellingItemDTO) throws RemoteException {
        Database.addSellingItem(sellingItemDTO);
    }
    
    public void removeSellingItem(SellingItemDTO sellingItemDTO) throws RemoteException {
        Database.removeSellingItem(sellingItemDTO);
    }
    
    public boolean buyItem(int itemID, int quantityRequired, int userID, String payment) throws RemoteException {
        Payment paymentType = switch (payment) {
            case "Cash" -> new Cash();
            case "Visa" -> new Visa();
            default -> null;
        };
        
        SellingItemDTO sellingItemDTO = Database.viewSellingItem(itemID);
        boolean canBuy = false;
        
        if (sellingItemDTO.getQuantity() < quantityRequired) {
            setStockStatus(new OutOfStock());
        } else {
            setStockStatus(new InStock());
            canBuy = true;
        }
        try {
            stockStatus.buyItem(itemID, quantityRequired, userID, paymentType);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return canBuy;
    }
    
    public SellingItemDTO viewSellingItem(int ID) throws RemoteException {
        return Database.viewSellingItem(ID);
    }
    
    public ArrayList<SellingItemDTO> viewAllSellingItems() throws RemoteException {
        return Database.viewAllSellingItems();
    }
}
