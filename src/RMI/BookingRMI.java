package RMI;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import Server.Booking;



public interface BookingRMI extends Remote {
    public void createBooking(Booking booking) throws RemoteException;

    public void cancleBooking(int bookingID) throws RemoteException;
 
    public Booking viewBooking(int bookingID) throws RemoteException;

    public ArrayList<Booking> viewAllBookings() throws RemoteException;

}