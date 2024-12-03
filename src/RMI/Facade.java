package RMI;

import Server.Account;
import Server.Employee;

public interface Facade {
    public EmployeeDTO getEmployeeDTO();
    
    public Employee getEmployee();
    
    public void setEmployee(String name, String email, String phoneNumber);
}
