package Server;

import RMI.AccountDTO;
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
    public void setEmployee(int ID, String name, int age, char gender, String email, String phoneNumber,
                            String address, float salary) {
        employee.setID(ID);
        employee.setName(name);
        employee.setAge(age);
        employee.setGender(gender);
        employee.setEmail(email);
        employee.setPhoneNumber(phoneNumber);
        employee.setAddress(address);
        employee.setSalary(salary);
    }
    
    @Override
    public EmployeeDTO getEmployeeDTO() {
        return new EmployeeDTO(employee.getID(), employee.getName(), employee.getAge(), employee.getGender(),
                employee.getEmail(), employee.getPhoneNumber(), employee.getAddress(),
                employee.getUsername(), employee.getPassword(), employee.getSalary(), employee.getClass().getName());
    }
}
