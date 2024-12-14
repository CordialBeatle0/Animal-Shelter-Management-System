package Server;

import RMI.*;

import java.awt.print.Book;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        try {
            // Registry
            Registry registry = LocateRegistry.createRegistry(1099);
            
            // Objects to be bound
            AccountRMI accountRMI = new Account();
            AdminRMI adminRMI = new Admin();
            AnimalRMI animalRMI = new Animal();
            AppointmentRMI appointmentRMI = new Appointment();
            CashRMI cashRMI = new Cash();
            DoctorRMI doctorRMI = new Doctor();
            SubscriptionRMI subscriptionRMI = new Subscription();
            TrainingRMI trainingRMI = new Training();
            UserRMI userRMI = new User();
            VisaRMI visaRMI = new Visa();
            VolunteerRMI volunteerRMI = new Volunteer();
            VolunteerTaskRMI volunteerTaskRMI = new VolunteerTask();
            UtilityItemRMI utilityItemRMI = new UtilityItem();
            SellingItemRMI sellingItemRMI = new SellingItem();
            BookingRMI bookingRMI = new Booking();
            
            // Binding the objects
            registry.rebind("Account", accountRMI);
            registry.rebind("Admin", adminRMI);
            registry.rebind("Animal", animalRMI);
            registry.rebind("Appointment", appointmentRMI);
            registry.rebind("Cash", cashRMI);
            registry.rebind("Doctor", doctorRMI);
            registry.rebind("Subscription", subscriptionRMI);
            registry.rebind("Training", trainingRMI);
            registry.rebind("User", userRMI);
            registry.rebind("Visa", visaRMI);
            registry.rebind("Volunteer", volunteerRMI);
            registry.rebind("VolunteerTask", volunteerTaskRMI);
            registry.rebind("UtilityItem", utilityItemRMI);
            registry.rebind("SellingItem", sellingItemRMI);
            registry.rebind("Booking", bookingRMI);
            
            Database database = new Database();
            
            UserDTO user1 = new UserDTO("johndoe", "johndoe", "John Doe", "1234567890", "1234 Main St", 0.0f);
            Database.signUp(user1);
            UserDTO user2 = new UserDTO("janedoe", "janedoe", "0987654321", "Jane Doe", "5678 Elm St", 10f);
            Database.signUp(user2);
            UserDTO user3 = new UserDTO("johnsmith", "johnsmith", "John Smith", "1234567890", "1234 Main" +
                    " St", 12f);
            Database.signUp(user3);
            UserDTO user4 = new UserDTO("janesmith", "janesmith", "Jane Smith", "0987654321", "5678 Elm " +
                    "St", 2f);
            Database.signUp(user4);
            
            Caretaker caretaker1 = new Caretaker("John Doe", 21, 'M', "amir@test.com", "0987654321", "1234 Main " +
                    "St", new Account("amir", "2121"), 2345.0f, "Night shift");
            Database.addEmployee(caretaker1);
            Caretaker caretaker2 = new Caretaker("Jane Doe", 23, 'F', "amir2@test.com", "0987231321", "1234 Main " +
                    "St", new Account("amir21", "2121"), 2345.0f, "Night shift");
            Database.addEmployee(caretaker2);
            
            Courier courier1 = new Courier("Loli Doe", 21, 'F', "loli@test.com", "0987654321", "1234 Main St",
                    new Account("loli", "2121"), 235678, "Nasr City", 2);
            Database.addEmployee(courier1);
            Courier courier2 = new Courier("Laila Doe", 23, 'F', "laila@test.com", "0987654321", "1234 Main St",
                    new Account("laila", "2121"), 235678, "Heliopolis", 10);
            Database.addEmployee(courier2);
            
            Doctor doctor1 = new Doctor("Amira Doe", 23, 'F', "amira@test.com", "0987654321", "1234 Main St",
                    new Account("amira", "2121"), 235678);
            Database.addEmployee(doctor1);
            // DoctorDTO doctorDTO = new DoctorDTO(88, "Amira Doe", 23, 'F', "amira@test.com", "0987654321", "1234
            // Main " +
            //         "St", new AccountDTO(77, "amira", "2121"), 235678);
            
            
            Admin admin1 = new Admin("John Smith", 21, 'M', "john@test.com", "0987654321", "1234 Main St",
                    new Account("jane", "2121"), 2345.0f);
            Database.addEmployee(admin1);
            Admin admin2 = new Admin("Janna Smith", 21, 'F', "Janna@test.com", "098761284321", "1234 Main St",
                    new Account("janna", "2121"), 2345.0f);
            Database.addEmployee(admin2);
            
            // Animal animal1 = new Animal("Felfel", "Dog", "Golden Retriever", 2, "Yesterday", true, true, false);
            AnimalDTO animalDTO = new AnimalDTO("Felfel", "Dog", "Golden Retriever", 2, "Yesterday", true, true,
                    false);
            Database.registerAnimal(animalDTO);
            
            SellingItemDTO sellingItem1DTO = new SellingItemDTO("Fotaa", 2, "InStock", 200);
            Database.addSellingItem(sellingItem1DTO);
            SellingItemDTO sellingItem2 = new SellingItemDTO("Tooo2", 4, "InStock", 200);
            Database.addSellingItem(sellingItem2);
            
            UtilityItemDTO utilityItem1 = new UtilityItemDTO("Dry Food", 5, 2, 6);
            Database.addUtilityItem(utilityItem1);
            UtilityItemDTO utilityItem2 = new UtilityItemDTO("Ball", 5, 2, 10);
            Database.addUtilityItem(utilityItem2);
            
            TrainingDTO training1 = new TrainingDTO("<URL_HERE>", LocalDateTime.now().toString(), 2.5f, "Training " +
                    "1");
            Database.uploadTrainingVideo(training1);
            
            VolunteerDTO volunteer1 = new VolunteerDTO("Pito Wameh", "01234568", "Nasr City", new AccountDTO(
                    "pito", "2121"));
            Database.signUpToVolunteering(volunteer1);
            
            VolunteerTaskDTO volunteerTask1 = new VolunteerTaskDTO("Clean the cages", "Clean the cages",
                    LocalDateTime.now().toString(), false, "Clean the cages");
            Database.addVolunteerTask(volunteerTask1);
            
            DoctorDTO doctorDTO = new DoctorDTO("Amira Doe", 23, 'F', "Amira@email.com", "0123456789", "Nasr City",
                    new AccountDTO("amira", "2121"), 2310);
            Appointment appointment1 = new Appointment(LocalDateTime.now().toString(), doctorDTO, 2300, "Checking " +
                    "up on an animal", animalDTO);
            Database.addAppointment(appointment1);
            
            ArrayList<BookingDTO> bookings = Database.viewAllBookings();
            for (BookingDTO booking : bookings) {
                System.out.println(booking.toString());
            }
            
            System.out.println("Server is running...");
        } catch (Exception e) {
            System.out.println(e.getCause().toString());
        }
    }
}
