package RMI;

import java.rmi.Remote;

public interface Observer extends Remote {
    void updateObserver(String message);
}
