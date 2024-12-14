package RMI;

import java.io.Serializable;

public class UserDTO implements Serializable { // TODO: I want this to implement Observer so that it can be passed
    private int ID;
    private int account;
    private String username;
    private String password;
    private String name;
    private String phoneNumber;
    private String address;
    private float outstandingFees;
    private boolean isSubscribed;
    
    public UserDTO(String username, String password, String name, String phoneNumber, String address,
                   float outstandingFees) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.outstandingFees = outstandingFees;
    }
    
    public UserDTO(int ID, int account, String name, String phoneNumber, String address, float outstandingFees) {
        this.ID = ID;
        this.account = account;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.outstandingFees = outstandingFees;
    }
    
    public int getID() {
        return ID;
    }
    
    public void setID(int ID) {
        this.ID = ID;
    }
    
    public int getAccount() {
        return account;
    }
    
    public void setAccount(int account) {
        this.account = account;
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
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
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
    
    public float getOutstandingFees() {
        return outstandingFees;
    }
    
    public void setOutstandingFees(float outstandingFees) {
        this.outstandingFees = outstandingFees;
    }

    public boolean isSubscribed() {
        return isSubscribed;
    }
    
    public void setSubscribed(boolean subscribed) {
        isSubscribed = subscribed;
    }   
    
    @Override
    public String toString() {
        return "UserDTO{" +
                "ID=" + ID +
                ", account=" + account +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", outstandingFees=" + outstandingFees +
                '}';
    }
}