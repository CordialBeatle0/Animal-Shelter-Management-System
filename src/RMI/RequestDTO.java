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
    
    public int getuserID() {
        return userID;
    }
    
    public String getuserName() {
        return userName;
    }
    
    public String getLocation() {
        return location;
    }
    
    public String getDate() {
        return date;
    }
}
