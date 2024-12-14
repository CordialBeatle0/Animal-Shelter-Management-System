package Server;

import RMI.*;

import javax.xml.crypto.Data;
import java.net.URL;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        try {
            // Registry
            Registry registry = LocateRegistry.createRegistry(500);
            
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
            
            User user1 = new User(1, "John Doe", new Account(), "1234567890", "1234 Main St", new Cash(), new Subscription(1, true, 100.0f, LocalDateTime.now()), new Training());
            User user2 = new User(2, "Jane Doe", new Account(), "0987654321", "5678 Elm St", new Visa(), new Subscription(2, false, 200.0f, LocalDateTime.now()), new Training());
            User user3 = new User(3, "John Smith", new Account(), "1234567890", "1234 Main St", new Cash(), new Subscription(3, true, 300.0f, LocalDateTime.now()), new Training());
            User user4 = new User(4, "Jane Smith", new Account(), "0987654321", "5678 Elm St", new Visa(), new Subscription(4, false, 400.0f, LocalDateTime.now()), new Training());
            
            Caretaker caretaker1 = new Caretaker(1, "John Doe", 21, 'M', "amir@test.com", "0987654321", "1234 Main St", new Account(1, "amir", "2121"), 2345.0f, "Night shift");
            Caretaker caretaker2 = new Caretaker(2, "Jane Doe", 23, 'F', "amir2@test.com", "0987231321", "1234 Main St", new Account(2, "amir21", "2121"), 2345.0f, "Night shift");
            
            Courier courier1 = new Courier(67, "Loli Doe", 21, 'F', "loli@test.com", "0987654321", "1234 Main St", new Account(67, "loli", "2121"), 235678, "Nasr City");
            Courier courier2 = new Courier(77, "Laila Doe", 23, 'F', "laila@test.com", "0987654321", "1234 Main St", new Account(77, "laila", "2121"), 235678, "Heliopolis");
            
            Doctor doctor1 = new Doctor(88, "Amira Doe", 23, 'F', "amira@test.com", "0987654321", "1234 Main St", new Account(77, "amira", "2121"), 235678);
            
            Admin admin1 = new Admin(22, "John Smith", 21, 'M', "john@test.com", "0987654321", "1234 Main St", new Account(3, "jane", "2121"), 2345.0f);
            Admin admin2 = new Admin(23, "Janna Smith", 21, 'F', "Janna@test.com", "098761284321", "1234 Main St", new Account(4, "janna", "2121"), 2345.0f);
            
            Animal animal1 = new Animal(1, "Felfel", "Dog", "Golden Retriever", 2, "Yesterday", true, true, false);
            
            SellingItem sellingItem1 = new SellingItem(1, "Fotaa", 2, "Tools", new InStock(), 200);
            SellingItem sellingItem2 = new SellingItem(2, "Tooo2", 4, "Tools", new InStock(), 200);
            
            UtilityItem utilityItem1 = new UtilityItem(4, "Dry Food", 5, "Food", 2);
            UtilityItem utilityItem2 = new UtilityItem(5, "Ball", 5, "Toys", 2);
            
            Training training1 = new Training(1, "<URL_HERE>", LocalDateTime.now(), 2.5f, "Training 1");
            
            Volunteer volunteer1 = new Volunteer(89, "Pito Wameh", new Account(89, "pito", "2121"), "123123123123", "3, Nasr City");
            
            VolunteerTask volunteerTask1 = new VolunteerTask(1, "Clean the cages", "Clean the cages", LocalDateTime.now().toString(), false);
            
            Appointment appointment1 = new Appointment(1, LocalDateTime.now(), doctor1, 2300, "Checking up on an animal", animal1);
            
            
            System.out.println("Server is running...");
        } catch (Exception e) {
            System.out.println(e.getCause().toString());
        }
    }
}
