package Server;

import java.util.ArrayList;

public class Doctor extends Employee {
    public Doctor(int ID, String name, int age, char gender, String email, String phoneNumber, String address,
                  Account account, float salary) {
        super(ID, name, age, gender, email, phoneNumber, address, account, salary);
    }
    
    public ArrayList<Appointment> viewDoctorAppointments() {
        return null;
    }
}
