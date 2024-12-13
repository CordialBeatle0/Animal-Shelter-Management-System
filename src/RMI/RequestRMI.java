package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface RequestRMI extends Remote {
    ArrayList<RequestDTO> viewRequest(CourierDTO courier) throws RemoteException;
    
    void requestHomeService() throws RemoteException;
}
