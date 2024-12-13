package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface BookingRMI extends Remote {
    void createBooking(BookingDTO booking) throws RemoteException;
    
    void cancelBooking(int bookingID) throws RemoteException;
    
    BookingDTO viewBooking(int bookingID) throws RemoteException;
    
    ArrayList<BookingDTO> viewAllBookings() throws RemoteException;
}