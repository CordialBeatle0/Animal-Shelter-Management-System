package RMI;

import java.io.Serializable;

public class UserDTO implements Serializable { // TODO: I want this to implement Observer so that it can be passed
    // when an Observer needs to be passed, but then I would have to implement the updateObserver method
    private int ID;
    private String name;
    private String phoneNumber;
    private String address;
    
    public UserDTO(int ID, String name, String phoneNumber, String address) {
        this.ID = ID;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
    
    public int getID() {
        return ID;
    }
    
    public void setID(int ID) {
        this.ID = ID;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
}
