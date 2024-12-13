package Server;

import RMI.*;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import java.time.LocalDateTime;

public class Cash extends UnicastRemoteObject implements Payment, CashRMI {
    public Cash() throws RemoteException {
    }
    
    // TODO
    @Override
    public void makePayment(UserDTO user, float amount) throws RemoteException {
        Request req = new Request(user.getID(), user.getName(), user.getAddress(), LocalDateTime.now());
        req.requestHomeService();
    }
    
    
    // TODO: TEST
    @Override
    public String confirmCashPayment(CourierDTO courier, RequestDTO request, float amount) throws RemoteException {
        try {
            int userID = request.getUserID();
            // TODO: make DB function return user for this to work
            User user = Database.getUserByID(userID);
            if (user.getOutstandingFees() == 0.0) {
                return ("User has no outstanding fees");
            } else if (amount > user.getOutstandingFees()) {
                return ("Amount greater than outstanding fees");
            } else {
                // update the number of requests of courier
                Database.updateCourierRequestNumber(courier, courier.getNumberOfRequests() - 1);
                courier.setNumberOfRequests(courier.getNumberOfRequests() - 1);
                // update the outstanding fees of user
                Database.updateUserOutstandingFees(user.getID(), user.getOutstandingFees() - amount);
                user.setOutstandingFees(user.getOutstandingFees() - amount);
                Database.deleteRequest(request);
                return ("Payment Processed");
            }
        } catch (Exception e) {
            // TODO: handle exception
            return ("Error Occurred during Payment");
        }
    }
}
