package data;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionPool {

    public static Connection getConnection(){
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentms","root","");
        }catch(Exception se){
           se.printStackTrace();
        }
        return con;
    }
}
