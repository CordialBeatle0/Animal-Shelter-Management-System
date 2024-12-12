package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AdminRMI extends Remote {
    void calculateSalary(int hours, float workingRate) throws RemoteException;
}
