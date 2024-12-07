package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AdminRMI extends Remote {
    float calculateSalary() throws RemoteException;
}
