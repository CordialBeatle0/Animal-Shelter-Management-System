package RMI;

import java.io.Serializable;

public class SpecialisedDTO extends EmployeeDTO implements Serializable {
    public SpecialisedDTO() {
    }
    
    public SpecialisedDTO(String name, int age, char gender, String email, String phoneNumber, String address,
                          String username, String password, float salary, String type) {
        super(name, age, gender, email, phoneNumber, address, username, password, salary, type);
    }
    
    public SpecialisedDTO(String name, int age, char gender, String email, String phoneNumber, String address,
                          String username, String password, float salary) {
        super(name, age, gender, email, phoneNumber, address, username, password, salary);
    }
    
    // public SpecialisedDTO(String name, int age, char gender, String email, String phoneNumber, String address,
    //                       AccountDTO account, float salary) {
    //     super(name, age, gender, email, phoneNumber, address, account, salary);
    // }
    //
    // public SpecialisedDTO(int ID, String name, int age, char gender, String email, String phoneNumber, String address
    //         , AccountDTO account, float salary) {
    //     super(ID, name, age, gender, email, phoneNumber, address, account, salary);
    // }
}
