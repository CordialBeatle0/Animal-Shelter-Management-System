package Server;

import RMI.SubscriptionRMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;

public class Subscription extends UnicastRemoteObject implements SubscriptionRMI {
    private int ID;
    private boolean status;
    private float price;
    private LocalDateTime date;
    
    public Subscription() throws RemoteException {
    }
    
    public Subscription(int ID, boolean status, float price, LocalDateTime date) throws RemoteException {
        this.ID = ID;
        this.status = status;
        this.price = price;
        this.date = date;
    }
    
    public int getID() {
        return ID;
    }
    
    public void setID(int ID) {
        this.ID = ID;
    }
    
    public boolean isStatus() {
        return status;
    }
    
    public void setStatus(boolean status) {
        this.status = status;
    }
    
    public float getPrice() {
        return price;
    }
    
    public void setPrice(float price) {
        this.price = price;
    }
    
    public LocalDateTime getDate() {
        return date;
    }
    
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    
    public void subscribeToTraining(User user, float amountPaid, Payment paymentType) throws RemoteException {
    
    }
    
    public void unsubscribeFromTraining() throws RemoteException {
    
    }
    
    public void endSubscription() throws RemoteException {
    
    }
}
