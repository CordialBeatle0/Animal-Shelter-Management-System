import Server.Admin;
import Server.Database;
import Server.Employee;
import org.junit.jupiter.api.Test;

import java.rmi.RemoteException;

import static org.junit.jupiter.api.Assertions.*;

public class CalculateSalaryTest {
    
    @Test
    public void testCalculateSalary() throws RemoteException {
        
        Database database = new Database();
        
        Admin admin = new Admin();
        // Create a mock employee or a test object
//        Employee employee = new Employee(); // Assuming there is an Employee class
//        employee.setSalary(0); // Initialize the salary to 0
        
        // Define test inputs
        int hoursWorked = 40;
        float hourlyRate = 50.0f;
        float expectedSalary = hoursWorked * hourlyRate;
        
        // Call the calculateSalary method
        try {
            admin.calculateSalary(hoursWorked, hourlyRate);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
        
        // Verify the salary was calculated correctly
        assertEquals(expectedSalary, admin.getSalary(), "The salary calculation should be correct.");
    }
}
