package Server;

import RMI.Specialised;

import java.rmi.RemoteException;

public class Caretaker extends Specialised {
    private String shift;
    
    public Caretaker(int ID, String name, int age, char gender, String email, String phoneNumber, String address,
                     Account account, float salary, String shift) throws RemoteException {
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
