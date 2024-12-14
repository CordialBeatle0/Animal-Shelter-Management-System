package RMI;

import java.io.Serializable;

public class DoctorDTO extends EmployeeDTO implements Serializable {
    public DoctorDTO() {
    }
    
    public DoctorDTO(String name, int age, char gender, String email, String phoneNumber, String address,
                     AccountDTO account, float salary) {
        super(name, age, gender, email, phoneNumber, address, account, salary);
    }
    
    public DoctorDTO(int ID, String name, int age, char gender, String email, String phoneNumber, String address,
                     AccountDTO account, float salary) {
        super(ID, name, age, gender, email, phoneNumber, address, account, salary);
    }
}
