/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thogakade.controller;

//import com.sun.jdi.connect.spi.Connection;
import thogakade.model.Customer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import thogakade.db.DBConnection;



/**
 *
 * @author Pasindu
 */
public class CustomerController {
   public static boolean addCustomer(Customer customer) throws ClassNotFoundException, SQLException{
        
       DBConnection dbcon = DBConnection.getInstance();
       Connection connection = dbcon.getConnection();
     
       PreparedStatement stm =  connection.prepareStatement("insert into Customer values(?,?,?,?)");
       stm.setObject(1,customer.getId());
       stm.setObject(2,customer.getName());
       stm.setObject(3,customer.getAddress());
       stm.setObject(4,customer.getSalary());
       
       int res = stm.executeUpdate();
       return res> 0;
   } 
}
