package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDateTime;

import Server.Animal;
import Server.Doctor;

public interface AppointmentRMI extends Remote {
    void bookAppointment(int ID, String date, DoctorDTO assignedDoctor, int price, String description,
            AnimalDTO animal) throws RemoteException;

    void cancelAppointment(int ID) throws RemoteException;

    AppointmentDTO viewAppointment(int ID) throws RemoteException;

    public AppointmentDTO getAppointment(int ID) throws RemoteException;

    void recordAppointmentDetail(int ID, String details) throws RemoteException;
}
