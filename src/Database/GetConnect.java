/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.sql.Connection;

/**
 *
 * @author PC02
 */
public class GetConnect {
        public static Connection getUserConnected() {
          Connection con = ConnectOracle.getUserConnected();
        return con;
    }
}
