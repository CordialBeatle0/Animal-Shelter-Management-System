package RMI;

import Server.Payment;
import Server.User;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SubscriptionRMI extends Remote {
    void subscribeToTraining(User user, float amountPaid, Payment paymentType) throws RemoteException;
    
    void unsubscribeFromTraining() throws RemoteException;
    
    void endSubscription() throws RemoteException;
}
