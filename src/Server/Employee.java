package Server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Employee extends UnicastRemoteObject {
    private int ID;
    private String name;
    private int age;
    private char gender;
    private String email;
    private String phoneNumber;
    private String address;
    private float salary;
    private int account;
    private String username;
    private String password;
    
    public Employee() throws RemoteException {
    }
    
    public Employee(String name, int age, char gender, String email, String phoneNumber, String address,
                    float salary) throws RemoteException {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        
        this.salary = salary;
    }
    
    public Employee(int ID, String name, int age, char gender, String email, String phoneNumber, String address,
                    float salary) throws RemoteException {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        
        this.salary = salary;
    }
    
    public Employee(String name, int age, char gender, String email, String phoneNumber, String address, float salary, int account, String username, String password) throws RemoteException {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.salary = salary;
        this.account = account;
        this.username = username;
        this.password = password;
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
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public char getGender() {
        return gender;
    }
    
    public void setGender(char gender) {
        this.gender = gender;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
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
    
    
    public float getSalary() {
        return salary;
    }
    
    public void setSalary(float salary) {
        this.salary = salary;
    }
    
    public int getAccount() {
        return account;
    }
    
    public void setAccount(int account) {
        this.account = account;
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
    
    @Override
    public String toString() {
        return "Employee [ID=" + ID + ", name=" + name + ", age=" + age + ", gender=" + gender + ", email=" + email
                + ", phoneNumber=" + phoneNumber + ", address=" + address + ", salary=" + salary + "]";
    }
    
    
}
