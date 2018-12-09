/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import business.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminDB {
/*
    public static int insert(Admin admin){
        Connection con = ConnectionPool.getConnection();
        
        PreparedStatement ps = null;
         
        String query = "INSERT INTO admins(name, email, password)  VALUES(?,?,?)";
        try {
         ps   = con.prepareStatement(query);
        ps.setString(1, admin.getName());
        ps.setString(2, admin.getEmail());
        ps.setString(3, admin.getPassword());
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
*/


 public static boolean adminExists(String email, String password){
        Connection con = ConnectionPool.getConnection();
        Statement stm = null;
        ResultSet res = null;
        try{
                String query = "Select * from admins WHERE email='" +email+"' AND password = '"+password+"'";
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
 }
