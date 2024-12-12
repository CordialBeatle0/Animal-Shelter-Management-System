package Server;

import RMI.UserRMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class User extends UnicastRemoteObject implements Observer, UserRMI {
    private int ID;
    private String name;
    private Account account;
    private String phoneNumber;
    private String address;
    private Payment paymentType;
    private Subscription subscription;
    private TrainingROI trainingVideos;
    //SH added outstandingfees
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
    
    
    
    public void signUp(User user) throws RemoteException {
    
    }
    
    @Override
    public void updateObserver(String message) {
    
    }
}
