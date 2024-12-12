package Server;

import java.rmi.RemoteException;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class Request {
    private int ID;
    private int userID;
    private String userName;
    // private String requestType;
    private String location;
    private LocalDateTime date;
    
    public Request(int userID, String userName, String location, LocalDateTime date) {
        this.userID = userID;
        this.userName = userName;
        this.location = location;
        this.date = date;
    }
    
    public Request(int ID, int userID, String userName, String location, LocalDateTime date) {
        this.ID = ID;
        this.userID = userID;
        this.userName = userName;
        // this.requestType = requestType;
        this.location = location;
        this.date = date;
    }
    
    public Request(int ID, int userID, String location) {
        this.ID = ID;
        this.userID = userID;
        this.location = location;
        // this.requestType = requestType;
    }
    
    public int getID() {
        return ID;
    }
    
    public int getuserID() {
        return userID;
    }
    
    public String getuserName() {
        return userName;
    }
    
    
    public String getLocation() {
        return location;
    }
    
    public LocalDateTime getDate() {
        return date;
    }
    
    // DONE
    public static ArrayList<Request> viewRequest(Courier courier) throws RemoteException {
        ArrayList<Request> requests = new ArrayList<>();
        try {
            // viewRequest should all the courier's requests from the database
            requests = Database.viewRequest(courier);
            for (Request request : requests) {
                System.out.println(request.toString());
            }
        } catch (Exception e) {
            // TODO: send message to controller that an error has occured
            System.out.println("An Error has occurred");
        }
        return requests;
    }
    
    // TODO: TEST
    public void requestHomeService() throws RemoteException {
        Courier cour = new Courier();
        cour.assignCourier(this);
    }
    
    // DONE
    public void addRequestToDB() {
        try {
            Database.addRequest(this);
            System.out.println("Request added to database");
            
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("An Error Occurred");
            
        }
    }
    
    @Override
    public String toString() {
        return "Request [ID=" + ID + ", userID=" + userID + ", userName=" + userName + ", location=" + location
                + ", date=" + date + "]";
    }
    
    
}
