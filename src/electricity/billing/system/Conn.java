
package electricity.billing.system;

import java.sql.*;


public class Conn {
    //creating the connection
    Connection c;
    Statement s;
    Conn(){
        try{
            c=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ebs","root","Abhi2001");
            s=c.createStatement();
        }
        catch(Exception e){
            e.printStackTrace();
        } 
    }
}
