package upes.techteam.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class App {
    public Connection getConnection() {
        Connection connection = null;
        System.out.println("Connection called");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/Infirmary", "root", "root");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
