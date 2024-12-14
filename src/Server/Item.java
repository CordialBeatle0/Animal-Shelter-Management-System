package Server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Item extends UnicastRemoteObject {
    private int ID;
    private String itemName;
    private int quantity;
    private String type;
    
    public Item() throws RemoteException {
    }
    
    public Item(int ID, String itemName, int quantity, String type) throws RemoteException {
        this.ID = ID;
        this.itemName = itemName;
        this.quantity = quantity;
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
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
}
