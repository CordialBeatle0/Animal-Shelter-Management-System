package Server;

import RMI.Observer;
import RMI.Payment;
import RMI.UserDTO;
import RMI.UserRMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class User extends UnicastRemoteObject implements Observer, UserRMI {
    private int ID;
    private String name;
    private Account account;
    private String phoneNumber;
    private String address;
    private Payment paymentType;
    private Subscription subscription;
    private TrainingROI trainingVideos;
    private float outstandingFees;
    
    
    public User() throws RemoteException {
    }
    
    public User(int ID, String name, Account account, String phoneNumber, String address, Payment paymentType,
                Subscription subscription, TrainingROI trainingVideos) throws RemoteException {
        this.ID = ID;
        this.name = name;
        this.account = account;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.paymentType = paymentType;
        this.subscription = subscription;
        this.trainingVideos = trainingVideos;
        this.outstandingFees = 0.0f;
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
    
    public Account getAccount() {
        return account;
    }
    
    public void setAccount(Account account) {
        this.account = account;
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
    
    public Payment getPaymentType() {
        return paymentType;
    }
    
    public void setPaymentType(Payment paymentType) {
        this.paymentType = paymentType;
    }
    
    public Subscription getSubscription() {
        return subscription;
    }
    
    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }
    
    public TrainingROI getTrainingVideos() {
        return trainingVideos;
    }
    
    public void setTrainingVideos(TrainingROI trainingVideos) {
        this.trainingVideos = trainingVideos;
    }
    
    public float getOutstandingFees() {
        return outstandingFees;
    }
    
    
    public void setOutstandingFees(float outstandingFees) {
        this.outstandingFees = outstandingFees;
    }
    
    
    public void signUp(UserDTO userDTO) throws RemoteException {
        User user = new User(userDTO.getID(), userDTO.getName(), new Account(userDTO.getAccount().getID(),
                userDTO.getAccount().getUsername(), userDTO.getAccount().getPassword()), userDTO.getPhoneNumber(),
                userDTO.getAddress(), new Cash(), new Subscription(), null);
        Database.signUp(user);
    }
    
    @Override
    public void updateObserver(String message) throws RemoteException {
        Database.addNotification(getID(), message);
    }
    
    @Override
    public void removeNotification(UserDTO user) throws RemoteException {
        Database.removeNotification(user.getID());
    }
    
    @Override
    public ArrayList<String> getNotifications(UserDTO user) throws RemoteException {
        return Database.getNotifications(user.getID());
    }
}
