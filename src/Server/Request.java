package Server;

import RMI.CourierDTO;
import RMI.RequestDTO;
import RMI.RequestRMI;

import java.io.Serializable;
import java.rmi.RemoteException;

import javax.swing.*;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Request extends UnicastRemoteObject implements RequestRMI {
    private int ID;
    private int userID;
    private String userName;
    private String location;
    private LocalDateTime date;
    
    public Request() throws RemoteException {
    }
    
    public Request(int userID, String userName, String location, LocalDateTime date) throws RemoteException {
        this.userID = userID;
        this.userName = userName;
        this.location = location;
        this.date = date;
    }
    
    public Request(int ID, int userID, String userName, String location, LocalDateTime date) throws RemoteException {
        this.ID = ID;
        this.userID = userID;
        this.userName = userName;
        this.location = location;
        this.date = date;
    }
    
    public Request(int ID, int userID, String location) throws RemoteException {
        this.ID = ID;
        this.userID = userID;
        this.location = location;
    }
    
    public int getID() {
        return ID;
    }
    
    public void setID(int ID) {
        this.ID = ID;
    }
    
    public int getUserID() {
        return userID;
    }
    
    public void setUserID(int userID) {
        this.userID = userID;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public String getLocation() {
        return location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    
    public LocalDateTime getDate() {
        return date;
    }
    
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    
    // DONE
    @Override
    public ArrayList<RequestDTO> viewRequest(CourierDTO courier) throws RemoteException {
        ArrayList<RequestDTO> requests = new ArrayList<>();
        try {
            // viewRequest should all the courier's requests from the database
            requests = Database.viewRequest(courier);
            for (RequestDTO request : requests) {
                System.out.println(request.toString());
            }
        } catch (Exception e) {
            // TODO: send message to controller that an error has occurred
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
            RequestDTO request = new RequestDTO(getID(), getUserID(), getUserName(), getLocation(),
                    getDate().toString());
            Database.addRequest(request);
            System.out.println("Request added to database");
            
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("An Error Occurred");
        }
    }
    
    public void deleteRequest(RequestDTO request) throws RemoteException {
        try {
            Database.deleteRequest(request);
            System.out.println("Request deleted from database");
        } catch (Exception e) {
            return;
        }
    }
    
    public RequestDTO getRequestByID(int ID) throws RemoteException {
        try {
            RequestDTO request = Database.viewRequestByID(ID);
            return request;
        } catch (Exception e) {
            return null;
        }
    }
    
    @Override
    public CourierDTO getAssignedCourier(int ID) throws RemoteException {
        try {
            return Database.viewCourier(ID);
        } catch (Exception e) {
            return null;
        }
    }
    
    @Override
    public String toString() {
        return "Request [ID=" + ID + ", userID=" + userID + ", userName=" + userName + ", location=" + location
                + ", date=" + date + "]";
    }
    
}
