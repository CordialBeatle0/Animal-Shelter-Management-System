package Server;

import RMI.DoctorRMI;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class Doctor extends Employee implements DoctorRMI {
    public Doctor() throws RemoteException {
    }
    
    public Doctor(int ID, String name, int age, char gender, String email, String phoneNumber, String address,
                  Account account, float salary) throws RemoteException {
        super(ID, name, age, gender, email, phoneNumber, address, account, salary);
    }
    
    public ArrayList<Appointment> viewDoctorAppointments() throws RemoteException {
        return null;
    }
}
