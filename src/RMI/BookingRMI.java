package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import Server.Booking;

public interface BookingRMI extends Remote {
    public void createBooking(BookingDTO booking) throws RemoteException;
    
    public void cancelBooking(int bookingID) throws RemoteException;
    
    public Booking viewBooking(int bookingID) throws RemoteException;
    
    public ArrayList<BookingDTO> viewAllBookings() throws RemoteException;
    
}