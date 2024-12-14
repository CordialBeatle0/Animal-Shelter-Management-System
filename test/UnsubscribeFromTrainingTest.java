import RMI.UserDTO;
import Server.Database;
import Server.Subscription;
import org.junit.jupiter.api.Test;

import java.rmi.RemoteException;

import static org.junit.jupiter.api.Assertions.*;

public class UnsubscribeFromTrainingTest {
    
    @Test
    public void testUnsubscribeFromTraining() throws RemoteException {
        // Create a mock UserDTO
//        UserDTO user = new UserDTO(12345, 12345, "Test User", "9876543210", "456 Another St", 0);
        Database db = new Database();
        Subscription subscription;
        try {
            subscription = new Subscription(12345, true, 100.0f, null);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
        
        UserDTO user = Database.getUserByID(2);
        
        // Simulate user subscription to training (you can set up this part based on your logic)
        Database.addSubscription(subscription, user);  // Assuming this method exists to add a user to training
        
        
        // Unsubscribe the user from the training
        Database.removeSubscription(subscription, user);
        
        
        // Verify that the user is unsubscribed (you can check the database to see if user is removed)
//        boolean isUnsubscribed = Database.isUserSubscribed(user); // Assuming this method exists to check subscription status

//        UserDTO user1 = Database.getUserByID(user.getID());
        
        // Verify that the user is no longer subscribed
        assertFalse(user.isSubscribed(), "The user should be unsubscribed after the operation.");
    }
}
