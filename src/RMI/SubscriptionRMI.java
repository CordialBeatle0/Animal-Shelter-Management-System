package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SubscriptionRMI extends Remote {
    void subscribeToTraining(UserDTO user, float amountPaid, String paymentType) throws RemoteException;
    
    void unsubscribeFromTraining(UserDTO user) throws RemoteException;
    
    void endSubscription(UserDTO user) throws RemoteException;

    boolean isSubscribed(UserDTO user) throws RemoteException;
}
