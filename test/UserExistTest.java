import RMI.UserDTO;
import Server.Database;
import org.junit.jupiter.api.Test;

import java.rmi.RemoteException;

import static org.junit.jupiter.api.Assertions.*;

public class UserExistTest {
    @Test
    public void testUserExist() {
        Database database = new Database();
        UserDTO user = new UserDTO(212121, 212121, "Amir Test", "1234567890", "1234 Main St", 0);
        
        try {
            Database.signUp(user);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
        
        UserDTO userExist = Database.getUserByID(user.getID());
        
        assertEquals(user, userExist);
    }
}
