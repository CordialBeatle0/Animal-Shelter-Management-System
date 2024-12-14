package Server;

import RMI.AccountDTO;
import RMI.SellingItemDTO;
import RMI.UserDTO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class InStock extends UnicastRemoteObject implements StockStatus {
    public InStock() throws RemoteException {
    }
    
    @Override
    public void buyItem(int ID, int quantityNeeded, int userID, Payment payment) throws RemoteException {
        User user = Database.getUserByID(userID);
        user.setPaymentType(payment);
        
        AccountDTO account = new AccountDTO(userID, user.getAccount().getUsername(), user.getAccount().getPassword());
        UserDTO userDTO = new UserDTO(user.getID(), account, user.getName(), user.getPhoneNumber(), user.getAddress(),
                user.getOutstandingFees());
        
        SellingItemDTO sellingItemDTO = Database.viewSellingItem(ID);
        float price = sellingItemDTO.getPrice() * quantityNeeded;
        
        userDTO.setOutstandingFees(price + userDTO.getOutstandingFees());
        Database.updateUserOutstandingFees(userDTO.getID(), userDTO.getOutstandingFees());
        
        user.getPaymentType().makePayment(userDTO, price);
        
        Database.buyItem(ID, quantityNeeded);
    }
}
