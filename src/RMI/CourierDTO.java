package RMI;

import java.io.Serializable;

public class CourierDTO extends EmployeeDTO implements Serializable {
    private static int maxCapacity = 10;
    private String assignedLocation;
    private int numberOfRequests = 0;
    
    public CourierDTO() {
    }
    
    public CourierDTO(String name, int age, char gender, String email, String phoneNumber, String address,
                      String username, String password, float salary, String type, String assignedLocation,
                      int numberOfRequests) {
        super(name, age, gender, email, phoneNumber, address, username, password, salary, type);
        this.assignedLocation = assignedLocation;
        this.numberOfRequests = numberOfRequests;
    }
    
    //    public CourierDTO(String name, int age, char gender, String email, String phoneNumber, String address,
    //                      AccountDTO account, float salary, String assignedLocation, int numberOfRequests) {
    //        super(name, age, gender, email, phoneNumber, address, account, salary);
    //        this.assignedLocation = assignedLocation;
    //        this.numberOfRequests = numberOfRequests;
    //    }
    //
    //    public CourierDTO(int ID, String name, int age, char gender, String email, String phoneNumber, String address,
    //                      AccountDTO account, float salary, String assignedLocation, int numberOfRequests) {
    //        super(ID, name, age, gender, email, phoneNumber, address, account, salary);
    //        this.assignedLocation = assignedLocation;
    //        this.numberOfRequests = numberOfRequests;
    //    }
    
    
    public CourierDTO(String name, int age, char gender, String email, String phoneNumber, String address,
                      String username, String password, float salary, String assignedLocation, int numberOfRequests) {
        super(name, age, gender, email, phoneNumber, address, username, password, salary);
        this.assignedLocation = assignedLocation;
        this.numberOfRequests = numberOfRequests;
    }
    
    public static int getMaxCapacity() {
        return maxCapacity;
    }
    
    public static void setMaxCapacity(int maxCapacity) {
        CourierDTO.maxCapacity = maxCapacity;
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
}
