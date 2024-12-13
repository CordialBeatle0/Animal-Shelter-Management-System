package Server;

import RMI.Payment;
import RMI.UserDTO;
import RMI.VisaRMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Visa extends UnicastRemoteObject implements Payment, VisaRMI {
    public Visa() throws RemoteException {
    }
    
    // TODO: TEST
    @Override
    public void makePayment(UserDTO user, float amount) throws RemoteException {
        try {
            Database.updateUserOutstandingFees(user.getID(), user.getOutstandingFees() - amount);
            user.setOutstandingFees(user.getOutstandingFees() - amount);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Can't make visa payment");
        }
    }
}
