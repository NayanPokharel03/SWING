package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbconnection {

        public static Connection getConnection() throws SQLException {
            Connection connection = null;
            String URL = "jdbc:mysql://localhost:3306/crud";
            String USER = "root";
            String PASSWORD = "";
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            return connection;
        }
}


