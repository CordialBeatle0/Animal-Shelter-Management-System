package Server;

import RMI.BookingRMI;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class Booking implements BookingRMI {
    private int bookingID;
    private String bookingDate;
    private int visitorID;

    public Booking() {
    }

    public Booking(int bookingID, int visitorID, String bookingDate) {
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


    public void createBooking(Booking booking) throws RemoteException {
        Database.createBooking(booking);
    }

   public void cancleBooking(int bookingID) throws RemoteException {
        Database.cancleBooking(bookingID);
    }

    
    public Booking viewBooking(int bookingID) throws RemoteException {
        return Database.viewBooking(bookingID);
    }

    public ArrayList<Booking> viewAllBookings() throws RemoteException {
       return Database.viewAllBookings();
    }


}