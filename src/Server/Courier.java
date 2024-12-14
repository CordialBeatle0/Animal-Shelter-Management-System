package Server;

import RMI.CourierDTO;

import java.rmi.RemoteException;

import javax.xml.crypto.Data;

public class Courier extends Employee {
    private static int maxCapacity = 10;
    private String assignedLocation;
    private int numberOfRequests = 0;
    
    public Courier() throws RemoteException {
        
    }

//    public Courier(String name, int age, char gender, String email, String phoneNumber, String address,
//                   Account account, float salary, String assignedLocation, int numberOfRequests) throws RemoteException {
//        super(name, age, gender, email, phoneNumber, address, account, salary);
//        this.assignedLocation = assignedLocation;
//        this.numberOfRequests = numberOfRequests;
//    }
//
//    public Courier(int ID, String name, int age, char gender, String email, String phoneNumber, String address,
//                   Account account, float salary, String assignedLocation) throws RemoteException {
//        super(ID, name, age, gender, email, phoneNumber, address, account, salary);
//        this.assignedLocation = assignedLocation;
//    }
    
    
    public Courier(String name, int age, char gender, String email, String phoneNumber, String address, float salary, String assignedLocation, int numberOfRequests) throws RemoteException {
        super(name, age, gender, email, phoneNumber, address, salary);
        this.assignedLocation = assignedLocation;
        this.numberOfRequests = numberOfRequests;
    }
    
    public static int getMaxCapacity() {
        return maxCapacity;
    }
    
    public static void setMaxCapacity(int maxCapacity) {
        Courier.maxCapacity = maxCapacity;
    }
    
    public String getAssignedLocation() {
        return assignedLocation;
    }
    
    public void setAssignedLocation(String assignedLocation) {
        this.assignedLocation = assignedLocation;
    }
    
    public int getNumberOfRequests() {
        return numberOfRequests;
    }
    
    public void setNumberOfRequests(int numberOfRequests) {
        this.numberOfRequests = numberOfRequests;
    }
    
    // DONE
    public void assignCourier(Request request) {
        try {
            // get courier from DB
            CourierDTO courier = Database.getAssignedCourier(request.getLocation());
            // compare number of requests and max number of requests
            if (courier.getNumberOfRequests() < maxCapacity) {
                request.addRequestToDB();
                courier.setNumberOfRequests(courier.getNumberOfRequests() + 1);
                Database.updateCourierRequestNumber(courier, courier.getNumberOfRequests());
                // TODO: send confirmation message to user instead
                System.out.println("Request processed and courier is assigned");
            } else {
                System.out.println("courier can't take more requests");
            }
            
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Could not assign courier");
        }
    }
    
    @Override
    public String toString() {
        return "Courier [assignedLocation=" + assignedLocation + ", numberOfRequests=" + numberOfRequests + "]";
    }
}
