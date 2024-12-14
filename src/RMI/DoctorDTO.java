package RMI;

import java.io.Serializable;

public class DoctorDTO extends EmployeeDTO implements Serializable {
    public DoctorDTO() {
    }
    
    public DoctorDTO(int ID, String name, int age, char gender, String email, String phoneNumber, String address,
                     String username, String password, float salary, String type) {
        super(ID, name, age, gender, email, phoneNumber, address, username, password, salary, type);
    }
    
    public DoctorDTO(String name, int age, char gender, String email, String phoneNumber, String address,
                     String username, String password, float salary, String type) {
        super(name, age, gender, email, phoneNumber, address, username, password, salary, type);
    }
    
    public DoctorDTO(String name, int age, char gender, String email, String phoneNumber, String address,
                     String username, String password, float salary) {
        super(name, age, gender, email, phoneNumber, address, username, password, salary);
    }
    
    // public DoctorDTO(String name, int age, char gender, String email, String phoneNumber, String address,
    //                  AccountDTO account, float salary) {
    //     super(name, age, gender, email, phoneNumber, address, account, salary);
    // }
    //
    // public DoctorDTO(int ID, String name, int age, char gender, String email, String phoneNumber, String address,
    //                  AccountDTO account, float salary) {
    //     super(ID, name, age, gender, email, phoneNumber, address, account, salary);
    // }
}
