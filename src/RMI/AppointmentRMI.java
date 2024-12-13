package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AppointmentRMI extends Remote {
    void bookAppointment() throws RemoteException;
    
    void cancelAppointment() throws RemoteException;
    
    AppointmentDTO viewAppointment() throws RemoteException;
    
    void recordAppointmentDetail(String details) throws RemoteException;
}
