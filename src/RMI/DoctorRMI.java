package RMI;

import Server.Appointment;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface DoctorRMI extends Remote {
    ArrayList<Appointment> viewDoctorAppointments() throws RemoteException;
}
