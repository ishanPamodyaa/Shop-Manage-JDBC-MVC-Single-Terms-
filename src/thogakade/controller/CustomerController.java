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
import java.util.ArrayList;
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

    public static Customer searchCustomer(String id) throws ClassNotFoundException ,SQLException {
        
        DBConnection dbcon = DBConnection.getInstance();
       Connection connection = dbcon.getConnection();
       
       Statement stm = connection.createStatement();
       ResultSet rst = stm.executeQuery("select * from Customer where id='"+id+"'");
       
       if(rst.next()){
           return new Customer(rst.getString("id"), rst.getString("name"), rst.getString("address"), rst.getDouble("salary") );
       }
       return null;
    }
    
     public static boolean updateCustomer(Customer customer) throws ClassNotFoundException, SQLException{
        
       DBConnection dbcon = DBConnection.getInstance();
       Connection connection = dbcon.getConnection();
     
       PreparedStatement stm =  connection.prepareStatement("update Customer set name=?, address=?,salary=? where id=?");
       stm.setObject(4,customer.getId());
       stm.setObject(1,customer.getName());
       stm.setObject(2,customer.getAddress());
       stm.setObject(3,customer.getSalary());
       
       int res = stm.executeUpdate();
       return res> 0;
   } 
    public static boolean deleteCustomer(String  id) throws ClassNotFoundException, SQLException{
        
        DBConnection dbcon = DBConnection.getInstance();
       Connection connection = dbcon.getConnection();
       
       Statement stm = connection.createStatement();
       int res = stm.executeUpdate("Delete from Customer where id='"+id+"' ");
       
       return res>0;
    }
    
    public static ArrayList<Customer> getAllCustomers() throws ClassNotFoundException, SQLException{
    
        ArrayList <Customer> customerList = new ArrayList<>();
   
          DBConnection dbcon = DBConnection.getInstance();
       Connection connection = dbcon.getConnection();
       
       Statement stm = connection.createStatement();
       
       ResultSet rst = stm.executeQuery("select * from Customer");
    
       while(rst.next()){
           Customer customer =  new Customer(rst.getString("id"), rst.getString("name"), rst.getString("address"), rst.getDouble("salary") );
           
           customerList.add(customer);
       }
       return customerList;
       
    
    }
      public static ArrayList<String> getAllCustomerIds() throws ClassNotFoundException, SQLException{
        
         ResultSet rst  = DBConnection.getInstance().getConnection()
                .prepareStatement("SELECT id FROM Customer")
                .executeQuery();
         ArrayList<String> idSet= new ArrayList<>();
          System.out.println();
         while (rst.next()) {            
            idSet.add(rst.getString(1));
        }
         return idSet;
    }
    
    
}
