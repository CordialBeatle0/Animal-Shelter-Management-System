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
            
            System.out.println("Server is running...");
        } catch (Exception e) {
            System.out.println(e.getCause().toString());
        }
    }
}
