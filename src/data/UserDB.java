package data;

import java.sql.*;

import business.User;


public class UserDB {
    public static int insert(User user){
        Connection con = ConnectionPool.getConnection();

        PreparedStatement ps = null;

        String query = "INSERT INTO users(rollNumber,email, password)  VALUES(?,?,?)";
        try {
            ps   = con.prepareStatement(query);
            ps.setString(1, user.getRollNumber());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            return ps.executeUpdate();
        } catch (SQLException se) {
            System.out.println(se);
            return 0;
        }finally{
            if(ps != null){
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getErrorCode());
                }
            }
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean userExists(String email, String password){
        Connection con = ConnectionPool.getConnection();
        Statement stm = null;
        ResultSet res = null;
        try{
            String query = "Select * from users WHERE email='" +email+"' AND password = '"+password+"'";
            stm = con.createStatement();
            res = stm.executeQuery(query);
            int rows = DbTools.getRowCount(res);
            if (rows != 0 ){
                return  true;
            }
        }catch(SQLException se){
            System.out.println(se);
            return false;
        }finally{
            if(stm != null){
                try {
                    stm.close();
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }
            if(res != null){
                try {
                    res.close();
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static String getRollNumber(String email){
        String rollNumber = "";
        Connection con = ConnectionPool.getConnection();
        Statement stm = null;
        ResultSet res = null;
        try{
            String query = "Select * from users WHERE email='" +email+"'";
            stm = con.createStatement();
            res = stm.executeQuery(query);
            if (res.next()){
                rollNumber = res.getString("rollNumber");
            }
        }catch(SQLException se){
            System.out.println(se);
        }finally{
            if(stm != null){
                try {
                    stm.close();
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }
            if(res != null){
                try {
                    res.close();
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rollNumber;
    }
}
