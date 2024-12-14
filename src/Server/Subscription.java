package Server;

import RMI.SubscriptionRMI;
import RMI.UserDTO;

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
    
    @Override
    public void subscribeToTraining(UserDTO user, float amountPaid, String paymentType) throws RemoteException {
        Payment payment = switch (paymentType) {
            case "Cash" -> new Cash();
            case "Visa" -> new Visa();
            default -> null;
        };
        
        User user1 = Database.getUserByID(user.getID());
        user1.setPaymentType(payment);
        
        user1.getPaymentType().makePayment(user, amountPaid);
        Database.addSubscription(this, user);
    }
    
    // this one is done by the user
    @Override
    public void unsubscribeFromTraining(UserDTO user) throws RemoteException {
        Database.removeSubscription(this, user);
    }
    
    // this one is done by the system
    @Override
    public void endSubscription(UserDTO user) throws RemoteException {
        Database.removeSubscription(this, user);
    }
}
