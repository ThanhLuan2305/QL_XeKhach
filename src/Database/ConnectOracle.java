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
    private static final String CONNECTION_URL = "jdbc:oracle:thin:@localhost:1522:orcl1";
    private static final String ADMIN_USER = "quoc"; 
    private static final String ADMIN_PASSWORD = "123123"; 
    
    public static Connection getConnecOracle() throws ClassNotFoundException {
		Connection c = null;
		try {
                        Class.forName("oracle.jdbc.driver.OracleDriver");
			// Tạo kết n
			c = DriverManager.getConnection(CONNECTION_URL, ADMIN_USER, ADMIN_PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
    }
    
    public static Connection getUserConnection(String username, String password) throws SQLException {
        return DriverManager.getConnection(CONNECTION_URL, username, password);
    }
    
    // CHỈ CẦN ĐĂNG NHẬP 1 LẦN ĐÂU, LẦN  SAU CHỈ CẦN GỌI 'getUserConnected()'
    private static Connection userConnect;
    
    public static Connection login(String username, String password) throws SQLException {
        userConnect = DriverManager.getConnection(CONNECTION_URL, username, password);
        return userConnect;
    }

    public static Connection getUserConnected () {
        return userConnect;
    }
}
