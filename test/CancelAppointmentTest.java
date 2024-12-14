import RMI.AccountDTO;
import RMI.AnimalDTO;
import RMI.DoctorDTO;
import Server.Database;
import Server.Appointment;
import org.junit.jupiter.api.Test;

import java.rmi.RemoteException;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class CancelAppointmentTest {
    @Test
    public void testCancelAppointment() throws RemoteException {
        // Create a mock appointment
        DoctorDTO doctor = new DoctorDTO("Amir Doc", 21, 'M', "amirdoc@test.com", "1234567890", "123 Main St", new AccountDTO("amir", "2121"), 123123123);
        AnimalDTO animal = new AnimalDTO("Felfel", "Dog", "Golden Retriever", 2, "Yesterday", true, true,
                false);
        Appointment appointment = new Appointment(LocalDateTime.now().toString(), doctor, 2400, "Checkup on Animal", animal);
        
        // Add the appointment to the database
        Database.addAppointment(appointment);
        
        // Cancel the appointment by its ID
        Database.deleteAppointment(appointment);
        
        // Retrieve the appointment to check if it was deleted
        Appointment canceledAppointment = Database.vAppointment(appointment.getID());
        
        // Verify that the appointment was removed from the database
        assertNull(canceledAppointment, "The appointment should be null after cancellation.");
    }
}
