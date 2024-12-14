package Server;

import RMI.AdminRMI;

import java.rmi.RemoteException;

public class Admin extends Specialised implements AdminRMI {
    public Admin() throws RemoteException {
    }
    
    public Admin(int ID, String name, int age, char gender, String email, String phoneNumber, String address,
                 Account account, float salary) throws RemoteException {
        super(ID, name, age, gender, email, phoneNumber, address, account, salary);
    }
    
    public void calculateSalary(int hours, float workingRate) throws RemoteException {
        float employeeSalary = hours * workingRate;
        setSalary(employeeSalary);
        
    }
}
