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
    

    //TODO: make it read the doctor from the database
    public ArrayList<Appointment> viewDoctorAppointments() throws RemoteException {
        try {
            ArrayList<Appointment>appointments = new ArrayList<>();
            appointments = Database.viewDoctorAppointments(this);
            return appointments;
        } catch (Exception e) {
            return null;
        }
    }

    

    
}
