package Server;

import java.io.Serializable;

public class UserDTOWithNoAccount implements Serializable { // TODO: I want this to implement Observer so that it can
    // be passed
    // when an Observer needs to be passed, but then I would have to implement the updateObserver method
    private int ID;
    private int account;
    private String name;
    private String phoneNumber;
    private String address;
    private float outstandingFees;
    
    public UserDTOWithNoAccount(int account, String name, String phoneNumber, String address, float outstandingFees) {
        this.account = account;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.outstandingFees = outstandingFees;
    }
    
    public UserDTOWithNoAccount(int ID, int account, String name, String phoneNumber, String address,
                                float outstandingFees) {
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
}
