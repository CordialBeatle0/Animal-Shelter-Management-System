package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface DoctorRMI extends Remote {
    ArrayList<AppointmentDTO> viewDoctorAppointments() throws RemoteException;

    DoctorDTO getDoctorByID(int ID) throws RemoteException;
}
