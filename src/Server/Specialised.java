package Server;

import java.rmi.RemoteException;

public abstract class Specialised extends Employee {
    public Specialised(int ID, String name, int age, char gender, String email, String phoneNumber, String address,
                       Account account, float salary) throws RemoteException {
        super(ID, name, age, gender, email, phoneNumber, address, account, salary);
    }
}
