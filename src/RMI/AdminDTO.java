package RMI;

import java.io.Serializable;

public class AdminDTO extends SpecialisedDTO implements Serializable {
    public AdminDTO() {
    }
    
    public AdminDTO(String name, int age, char gender, String email, String phoneNumber, String address,
                    AccountDTO account, float salary) {
        super(name, age, gender, email, phoneNumber, address, account, salary);
    }
    
    public AdminDTO(int ID, String name, int age, char gender, String email, String phoneNumber, String address,
                    AccountDTO account, float salary) {
        super(ID, name, age, gender, email, phoneNumber, address, account, salary);
    }
}
