package Server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
    // Static instance variable to hold the single instance of the class
    private static DataBase instance;
    
    // Database connection variables
    private Connection connection;
    
    private DataBase() {
        String url = "mongodb://localhost:27017/animal-shelter"; // change the dbName to ours
        String username = "root"; // Change to your MySQL username
        String password = "1234"; // Change to your MySQL password
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static DataBase getInstance() {
        return instance;
    }
}
