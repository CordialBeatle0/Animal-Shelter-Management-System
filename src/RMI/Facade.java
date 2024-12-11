package RMI;

import Server.Employee;

public interface Facade {
    EmployeeDTO getEmployeeDTO();
    
    void setEmployee(String name, String email, String phoneNumber);
}
