package RMI;

import java.io.Serializable;

public class BookingDTO implements Serializable {
    private int bookingID;
    private String bookingDate;
    private int visitorID;
    
    public BookingDTO() {
    }
    
    public BookingDTO(String bookingDate, int visitorID) {
        this.bookingDate = bookingDate;
        this.visitorID = visitorID;
    }
    
    public BookingDTO(int bookingID, int visitorID, String bookingDate) {
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
}
