/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thogakade.db;

//import com.sun.jdi.connect.spi.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;
/**
 *
 * @author Pasindu
 */
public class DBConnection {
    
    private Connection connection;
    
    private static DBConnection dbConnecton;
    private DBConnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost/ThogaKade","root","root");
    }
    
    public static DBConnection getInstance() throws ClassNotFoundException, SQLException{
        if(dbConnecton == null){
            dbConnecton = new DBConnection();
        }return dbConnecton;
    }
    
    
    public Connection getConnection(){
        return connection;
    }
}
