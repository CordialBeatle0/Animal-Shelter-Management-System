package RMI;

public interface Facade {
    EmployeeDTO getEmployeeDTO();
    
    void setEmployee(int ID, String name, int age, char gender, String email, String phoneNumber, String address,
                     float salary);
}
