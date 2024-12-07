package Server;

import java.rmi.RemoteException;

public class Courier extends Employee {
    private static int maxCapacity;
    private String assignedLocation;
    
    public Courier(int ID, String name, int age, char gender, String email, String phoneNumber, String address,
                   Account account, float salary, String assignedLocation) throws RemoteException {
        super(ID, name, age, gender, email, phoneNumber, address, account, salary);
        this.assignedLocation = assignedLocation;
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
    
    public void assignCourier() {
    }
}
