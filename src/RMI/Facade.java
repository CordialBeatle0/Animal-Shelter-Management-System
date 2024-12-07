package RMI;

import Server.Employee;

public interface Facade {
    EmployeeDTO getEmployeeDTO();
    
    Employee getEmployee();
    
    void setEmployee(String name, String email, String phoneNumber);
}
