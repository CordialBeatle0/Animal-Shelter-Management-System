package RMI;

import java.io.Serializable;

public class CourierDTO extends EmployeeDTO implements Serializable {
    private String assignedLocation;
    
    public CourierDTO() {
    }
    
    public CourierDTO(String name, String email, String phoneNumber, String assignedLocation) {
        super(name, email, phoneNumber);
        this.assignedLocation = assignedLocation;
    }
    
    public String getAssignedLocation() {
        return assignedLocation;
    }
    
    public void setAssignedLocation(String assignedLocation) {
        this.assignedLocation = assignedLocation;
    }
}
