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
            Database db = new Database();


            //-------REMOVE BEFORE PUSHING-------//
            Account acc1 = new Account(1, "sherouk195649", "August2000");
            Account acc2 = new Account(1, "anne123", "123");
            
            

            Courier cour1 = new Courier(1, "Sherouk", 24, 'f', "sheroukhesham2000@hotmail.com", "01158221868", "Shorouk", acc1, 1400, "Shorouk");
            Doctor doc1 = new Doctor(1, "Sherouk", 24, 'f', "sheroukhesham2000@hotmail.com", "01158221868", "Shorouk", acc1, 1400);
            Request req1 = new Request(1,1, "Allam", "Shorouk", LocalDateTime.now());
            Payment cash=new Cash();
           
            User user1 = new User(7, "Anne",acc2 , "010058796641", "Shorouk" , cash, null, null);
           
            Animal animal1 = new Animal(1, "Rodric", "Dog", "Golden Retriever", 2, LocalDateTime.now().toString(), false, false, false);
            Appointment app1 = new Appointment(1, LocalDateTime.now(), doc1, 100, "Checkup", animal1);
           
            //app1.bookAppointment();	
            //app1.viewAppointment();
            //app1.recordAppointmentDetail("New description now");
          //app1.cancelAppointment();
          //System.out.println(app1.viewAppointment().toString());
            //Database.addAppointment(app1);
            //  for (Appointment appointment : doc1.viewDoctorAppointments()) {
            //      System.out.println(appointment.toString());
            // }
            // ArrayList<Appointment> app =  doc1.viewDoctorAppointments();
            // System.out.println(app.toString());
           // Database.addDoctor(doc1);
           //Database.deleteAppointment(app1);
           // req1.addRequestToDB();
           // req1.requestHomeService();
            //Request.viewRequest(cour1);
           //Database.addCourier(cour1);
           //System.out.println(Database.getAssignedCourier("Shorouk").toString());
           //Database.updateCourierRequestNumber(cour1, 100);
            //Database.deleteRequest(req1);
            //System.out.println(Database.getAssignedCourier("Shorouk").toString());
            //Database.updateUserOutstandingFees(user1, 100);

        } catch (Exception e) {
            System.out.println(e.getCause().toString());
        }
        


    }
}
