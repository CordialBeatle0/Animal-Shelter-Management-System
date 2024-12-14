package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AppointmentRMI extends Remote {
    void bookAppointment() throws RemoteException;

    void cancelAppointment() throws RemoteException;

    AppointmentDTO viewAppointment(int ID) throws RemoteException;

    public AppointmentDTO getAppointment(int ID) throws RemoteException;

    void recordAppointmentDetail(int ID, String details) throws RemoteException;
}
