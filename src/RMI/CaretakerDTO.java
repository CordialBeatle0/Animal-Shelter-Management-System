package RMI;

import java.io.Serializable;

public class CaretakerDTO extends SpecialisedDTO implements Serializable {
    private String shift;
    
    public CaretakerDTO() {
    }
    
    public CaretakerDTO(String name, int age, char gender, String email, String phoneNumber, String address,
                        AccountDTO account, float salary, String shift) {
        super(name, age, gender, email, phoneNumber, address, account, salary);
        this.shift = shift;
    }
    
    public CaretakerDTO(int ID, String name, int age, char gender, String email, String phoneNumber, String address,
                        AccountDTO account, float salary, String shift) {
        super(ID, name, age, gender, email, phoneNumber, address, account, salary);
        this.shift = shift;
    }
    
    public String getShift() {
        return shift;
    }
    
    public void setShift(String shift) {
        this.shift = shift;
    }
}
