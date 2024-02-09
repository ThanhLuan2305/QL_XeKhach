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
    public static Connection getConnecOracle() {
		Connection c = null;
		try {
			// Đăng ký MySQL Driver với DriverManager
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String username = "luan";
			String password = "1412";
			
			// Tạo kết n
			c = DriverManager.getConnection(url, username, password);
			
//			String sql = "INSERT INTO KHACHHANG VALUES (2,'JOIN','JOIN@GMAIL.COM','0123456789','kHANH HOA')";
//			Statement statement = c.createStatement();
//			int rows = statement.executeUpdate(sql);
//			if(rows > 0) {
//				System.out.println("Thành công");
//			}
			
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
		
	}
}
