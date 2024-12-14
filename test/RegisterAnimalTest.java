import RMI.AnimalDTO;
import Server.Database;
import org.junit.jupiter.api.Test;

import java.rmi.RemoteException;

import static org.junit.jupiter.api.Assertions.*;

public class RegisterAnimalTest {
    
    @Test
    public void testRegisterAnimal() {
        Database database = new Database();
        // Create a mock AnimalDTO
        AnimalDTO animal = new AnimalDTO("Buddy", "Dog", "Golden Retriever", 3, "2021-06-15", true, true, false);
        
        // Register the animal in the database
        
        Database.registerAnimal(animal);
        
        
        // Retrieve the animal from the database by its ID
        AnimalDTO registeredAnimal = null;
        
        registeredAnimal = Database.viewAnimal(animal.getID()); // Assuming this method exists
        
        
        // Verify that the animal was registered correctly
        assertNotNull(registeredAnimal, "The animal should be registered in the database.");
    }
}
