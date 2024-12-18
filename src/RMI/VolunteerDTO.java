package RMI;

import java.io.Serializable;

public class VolunteerDTO implements Serializable {
    private int ID;
    private String name;
    private String phoneNumber;
    private String Address;
    private AccountDTO account;
    
    public VolunteerDTO() {
    }
    
    public VolunteerDTO(int ID, String name, String phoneNumber, String address, AccountDTO account) {
        this.ID = ID;
        this.name = name;
        this.phoneNumber = phoneNumber;
        Address = address;
        this.account = account;
    }
    
    public VolunteerDTO(String name, String phoneNumber, String address, AccountDTO account) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        Address = address;
        this.account = account;
    }
    
    public VolunteerDTO(int ID, String name, String phoneNumber, String address) {
        this.ID = ID;
        this.name = name;
        this.phoneNumber = phoneNumber;
        Address = address;
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
        return Address;
    }
    
    public void setAddress(String address) {
        Address = address;
    }
    
    public AccountDTO getAccount() {
        return account;
    }
    
    public void setAccount(AccountDTO account) {
        this.account = account;
    }
}
