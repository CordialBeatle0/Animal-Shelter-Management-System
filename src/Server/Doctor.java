package Server;

import RMI.AppointmentDTO;
import RMI.DoctorDTO;
import RMI.DoctorRMI;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class Doctor extends Employee implements DoctorRMI {
    public Doctor() throws RemoteException {
    }
    
    // public Doctor(String name, int age, char gender, String email, String phoneNumber, String address,
    //               Account account, float salary) throws RemoteException {
    //     super(name, age, gender, email, phoneNumber, address, account, salary);
    // }
    //
    // public Doctor(int ID, String name, int age, char gender, String email, String phoneNumber, String address,
    //               Account account, float salary) throws RemoteException {
    //     super(ID, name, age, gender, email, phoneNumber, address, account, salary);
    // }
    
    // TODO: make it read the doctor from the database
    public ArrayList<AppointmentDTO> viewDoctorAppointments(int doctorID) throws RemoteException {
        try {
            return Database.viewDoctorAppointments(doctorID);
        } catch (Exception e) {
            return null;
        }
    }
    
    public DoctorDTO getDoctorByID(int ID) throws RemoteException {
        try {
            return Database.getDoctorByID(ID);
        } catch (Exception e) {
            return null;
        }
    }
}
