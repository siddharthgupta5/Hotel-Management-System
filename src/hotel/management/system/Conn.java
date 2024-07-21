package hotel.management.system;

import java.sql.*; //for Connection

public class Conn {
    
    Connection c;
    Statement s;
    
    //JDBC connectivity have 5 steps.
    Conn(){
        //Step 1 : Register Your Driver.
        //Registering mySql driver.
        
        
        //Step 2 : Creating a Connection.
        
        //Step 3 : Create a statement.
        
        //step 4 : executing mysql queries.
        
        //step 5 : closing the connection.
        
        try{ //Adding into try catch block as it can give error.
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagementsystem", "root", "Zaraksats1");
//          s = c.createStatement();//For forward only resultSet
            s = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);//For Forward and 
            //backword both resultSet.
            
        } catch (Exception e){
            e.printStackTrace();
        }
        
        
    }
    
    public static void main(){
        new Conn();
    }
    
}
