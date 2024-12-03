package Server;

public class Admin extends Specialised {
    public Admin(int ID, String name, int age, char gender, String email, String phoneNumber, String address,
                 Account account, float salary) {
        super(ID, name, age, gender, email, phoneNumber, address, account, salary);
    }
    
    public float calculateSalary() {
        return 0;
    }
}
