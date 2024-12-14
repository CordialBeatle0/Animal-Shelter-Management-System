package Server;

import RMI.UserDTO;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Payment extends Remote, Serializable {
    void makePayment(UserDTO user, float amount) throws RemoteException;
}
