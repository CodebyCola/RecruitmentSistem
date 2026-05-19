/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package latihan.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Pongo
 */
public class Connector {
    public static Connection conn;
    public static Connection connect() {
        try{
            String url = "JDBC:mysql://localhost:3306/recruit_db";
            String username = "root";
            String password = "";
            
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Database Connected");
        }catch(SQLException e) {
            System.out.println("fail connect to database " + e.getMessage());
        }
        
        return conn;
    }
}
