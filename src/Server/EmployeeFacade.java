package Server;

import RMI.EmployeeDTO;
import RMI.Facade;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class EmployeeFacade extends UnicastRemoteObject implements Facade {
    private Employee employee;
    
    public EmployeeFacade() throws RemoteException {
        employee = new Employee();
    }
    
    @Override
    public void setEmployee(String name, String email, String phoneNumber) {
        employee.setName(name);
        employee.setEmail(email);
        employee.setPhoneNumber(phoneNumber);
    }
    
    @Override
    public EmployeeDTO getEmployeeDTO() {
        return new EmployeeDTO(employee.getName(), employee.getEmail(), employee.getPhoneNumber());
    }
}
