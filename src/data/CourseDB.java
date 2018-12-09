package data;

import business.Course;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author shinigami
 */
public class CourseDB {
    public static int insert(Course course){
        Connection con = ConnectionPool.getConnection();
        
        PreparedStatement ps = null;
         
        String query = "INSERT INTO courses(name, amount, discount)  VALUES(?,?,?)";
        try {
         ps   = con.prepareStatement(query);
        ps.setString(1, course.getName());
        ps.setInt(2, course.getAmount());
        ps.setInt(3, course.getDiscount());
        return ps.executeUpdate();
        } catch (SQLException se) {
            System.out.println(se.getErrorCode());
            se.printStackTrace();
            return 0;
        }finally{
            if(ps != null){
                try {
                    ps.close();
                } catch (SQLException ex) {
                   System.out.println(ex.getErrorCode());
                   ex.printStackTrace();
                }
            }
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }   
    }
    
    public static Course[] getCourses(){
        Connection con = ConnectionPool.getConnection();
        Statement stm = null;
        ResultSet res = null;
    
        try{
                String query = "Select * from courses";
                stm = con.createStatement();
               res = stm.executeQuery(query);
               int rows = DbTools.getRowCount(res);
                Course courses[] = new Course[rows];
                int count = 0;
            while(res.next()){
                Course course = new Course();
                course.setName(res.getString("name"));
                course.setAmount(res.getInt("amount"));
                course.setDiscount(res.getInt("discount"));
                courses[count] = course;
                count++;
            }
            return courses;
        }catch(SQLException se){
            System.out.println(se);
            return null;
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
    }
    
    public static Course getCourse(String name){
        Connection con = ConnectionPool.getConnection();
        PreparedStatement ps = null;
        ResultSet res = null;
        try{
                String query = "Select * from courses where name = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, name);
            res = ps.executeQuery();
            Course course = new Course();
            while(res.next()){
               course.setName(res.getString("name"));
               course.setAmount(res.getInt("amount"));
               course.setDiscount(res.getInt("discount"));
            }
            return course;
        }catch(SQLException se){
            se.printStackTrace();
            return null;
        }finally{
            if(ps != null){
                try {
                    ps.close();
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
    }
    
    public static int deleteCourse(String name){;
        Connection con = ConnectionPool.getConnection();
        Statement stm = null;
        try{
                String query = "delete from courses where name = '"+name+"'";
            stm = con.createStatement();
            return stm.executeUpdate(query);
        }catch(SQLException se){
            System.out.println(se.getErrorCode());
            se.printStackTrace();
            return 0;
        }finally{
            if(stm != null){
                try {
                    stm.close();
                } catch (SQLException ex) {
                   System.out.println(ex.getErrorCode());
                   ex.printStackTrace();
                }
            }
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }  
    }
    
    public static int updateCourse(String identifier, String name, int  amount, int discount){
        Connection con = ConnectionPool.getConnection();
        PreparedStatement ps = null;
        try{
                String query = " UPDATE courses SET name = ? , amount = ? , discount = ?"
                        + " WHERE name = ? ";
                System.out.println(","+identifier+","+name+","+amount+","+discount+",");
            ps = con.prepareStatement(query);
            ps.setString(1,name );
            ps.setInt(2, amount);
            ps.setInt(3, discount);
            ps.setString(4, identifier);
            
            
            return  ps.executeUpdate();
        }catch(SQLException se){
            System.out.println(se.getErrorCode());
            se.printStackTrace();
            return 0;
        }finally{
            if(ps != null){
                try {
                    ps.close();
                } catch (SQLException ex) {
                   System.out.println(ex.getErrorCode());
                   ex.printStackTrace();
                }
            }
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }  
    }
}
