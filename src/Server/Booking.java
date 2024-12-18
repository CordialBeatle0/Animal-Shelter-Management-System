package Server;

import RMI.BookingDTO;
import RMI.BookingRMI;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Booking extends UnicastRemoteObject implements BookingRMI, Serializable {
    private int bookingID;
    private String bookingDate;
    private int visitorID;
    
    public Booking() throws RemoteException {
    }
    
    public Booking(int bookingID, int visitorID, String bookingDate) throws RemoteException {
        this.bookingID = bookingID;
        this.visitorID = visitorID;
        this.bookingDate = bookingDate;
    }
    
    public int getBookingID() {
        return bookingID;
    }
    
    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }
    
    public int getVisitorID() {
        return visitorID;
    }
    
    public void setVisitorID(int visitorID) {
        this.visitorID = visitorID;
    }
    
    public String getBookingDate() {
        return bookingDate;
    }
    
    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }
    
    
    public void createBooking(BookingDTO booking) throws RemoteException {
        Database.createBooking(booking);
    }
    
    public void cancelBooking(int bookingID) throws RemoteException {
        Database.cancelBooking(bookingID);
    }
    
    
    public BookingDTO viewBooking(int bookingID) throws RemoteException {
        return Database.viewBooking(bookingID);
    }
    
    public ArrayList<BookingDTO> viewAllBookings() throws RemoteException {
        return Database.viewAllBookings();
    }
    
    
}