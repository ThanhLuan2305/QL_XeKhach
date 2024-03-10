/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ADMIN
 */
public class ConnectOracle {
    private static final String ADMIN_URL = "jdbc:oracle:thin:@localhost:1521:orcl";
    private static final String ADMIN_USER = "luan"; 
    private static final String ADMIN_PASSWORD = "1412"; 
    
    public static Connection getConnecOracle() throws ClassNotFoundException {
		Connection c = null;
		try {
                        Class.forName("oracle.jdbc.driver.OracleDriver");
			// Tạo kết n
			c = DriverManager.getConnection(ADMIN_URL, ADMIN_USER, ADMIN_PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
    public static Connection getUserConnection(String username, String password) throws SQLException {
        return DriverManager.getConnection(ADMIN_URL, username, password);
    }
}
