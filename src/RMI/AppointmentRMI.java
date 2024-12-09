package RMI;

import Server.Appointment;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface AppointmentRMI extends Remote {
    void bookAppointment() throws RemoteException;
    
    void cancelAppointment() throws RemoteException;
    
    Appointment viewAppointment() throws RemoteException;
    
    void recordAppointmentDetail(String details) throws RemoteException;
}
