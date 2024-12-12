
package thogakade;

import com.mysql.cj.xdevapi.PreparableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class ThogaKade {

   
    public static void main(String[] args) {
        
         try {
//            String id = "C100";
//            String name = "Ishan";
//            String address = "Kegalle";
//            double salary = 45000;
             String SQL = "select * from Customer";
            //String SQL = "insert into Customer Values(?,?,?,?)";
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection;
            connection = DriverManager.getConnection("jdbc:mysql://localhost/ThogaKade","root","root");
            
//            PreparedStatement stm =  connection.prepareStatement(SQL);
//            
//            stm.setObject(1,id);
//            stm.setObject(2,name);
//            stm.setObject(3,address);
//            stm.setObject(4,salary);
            
            Statement stm = connection.createStatement();
           // stm.executeUpdate(SQL);
            ResultSet rst = stm.executeQuery(SQL);
            while(rst.next()){
           
            
            String id = rst.getString("id");
            String name = rst.getString("name");
            String address = rst.getString("address");
            double salary = rst.getDouble("salary");
            
            System.out.println(id+"\t" +name+"\t" +address+"\t" +salary);
            }
        }catch(ClassNotFoundException ex){
            System.out.println("Driver s/w not Found");
        }catch(SQLException ex) {
            System.out.println(ex.getMessage());
        } 
        
    }
}
