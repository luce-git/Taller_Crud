
package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexionDB {
    
private static final String URL = "jdbc:mysql://localhost:3306/kd_electronics";
    private static final String USER = "root"; // tu usuario de MySQL
    private static final String PASSWORD = ""; // tu contraseña de MySQL

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        }
        return connection;
    }
}