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

    public SellingItem(int ID, String itemName, int quality, String type, StockStatus stockStatus, float price)
            throws RemoteException {
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

    public void addSellingItem(SellingItemDTO sellingItemDTO) throws RemoteException {
        Database.addSellingItem(sellingItemDTO);
    }

    public void removeSellingItem(SellingItemDTO sellingItemDTO) throws RemoteException {
        Database.removeSellingItem(sellingItemDTO);
    }

    public void buyItem(int quantityRequired, int userID, String payment) throws RemoteException, Exception {
        Payment paymentType = switch (payment) {
            case "Cash" -> new Cash();
            case "Visa" -> new Visa();
            default -> null;
        };

        if (getQuantity() < quantityRequired) {
            setStockStatus(new OutOfStock());
        } else {
            setStockStatus(new InStock());
        }
        try {
            stockStatus.buyItem(getID(), quantityRequired, userID, paymentType);
        } catch (Exception e) {
            throw new Exception(getItemName() + e.getMessage());
        }
    }

    public SellingItemDTO viewSellingItem(int ID) throws RemoteException {
        return Database.viewSellingItem(ID);
    }

    public ArrayList<SellingItemDTO> viewAllSellingItems() throws RemoteException {
        return Database.viewAllSellingItems();
    }
}
