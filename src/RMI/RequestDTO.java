package RMI;

import java.io.Serializable;

public class RequestDTO implements Serializable {
    private int ID;
    private int userID;
    private String userName;
    private String location;
    private String date;
    
    public RequestDTO(int userID, String userName, String location, String date) {
        this.userID = userID;
        this.userName = userName;
        this.location = location;
        this.date = date;
    }
    
    public RequestDTO(int ID, int userID, String userName, String location, String date) {
        this.ID = ID;
        this.userID = userID;
        this.userName = userName;
        this.location = location;
        this.date = date;
    }
    
    public RequestDTO(int ID, int userID, String location) {
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
    
    public String getDate() {
        return date;
    }
    
    public void setDate(String date) {
        this.date = date;
    }
}
