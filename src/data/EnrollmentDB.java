/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import business.Enrollment;
import business.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EnrollmentDB {
    public static int insert(Enrollment enroll){
        Connection con = ConnectionPool.getConnection();
        
        PreparedStatement ps = null;
         
        String query = "INSERT INTO enrollments(studentRollNumber, courseName, paidAmount, dueAmount)  VALUES(?,?,?,?)";
        try {
         ps   = con.prepareStatement(query);
        ps.setString(1, enroll.getStudentRollNumber());
        ps.setString(2, enroll.getCourseName());
        ps.setInt(3, enroll.getPaidAmount());
        ps.setInt(4, enroll.getDueAmount());
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
    
public static Enrollment[] getEnrollments(){
        Connection con = ConnectionPool.getConnection();
        Statement stm = null;
        ResultSet res = null;
    
        try{
                String query = "Select * from enrollments";
                stm = con.createStatement();
               res = stm.executeQuery(query);
               int rows = DbTools.getRowCount(res);
                Enrollment enrollments[] = new Enrollment[rows];
                int count = 0;
            while(res.next()){
                Enrollment enrollment = new Enrollment();
               enrollment.setStudentRollNumber(res.getString("studentRollNumber"));
               enrollment.setCourseName(res.getString("courseName"));
               enrollment.setPaidAmount(res.getInt("paidAmount"));
               enrollment.setDueAmount(res.getInt("dueAmount"));
                enrollments[count] = enrollment;
                count++;
            }
            return enrollments;
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

public static int deleteEnrollment(String student, String course){
        Connection con = ConnectionPool.getConnection();
        Statement stm = null;
        try{
                String query = "delete from enrollments where studentRollNumber = '"+student+"' AND courseName = '"+course+"'";
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

public static Enrollment getEnrollment(String student, String course){
        Connection con = ConnectionPool.getConnection();
        PreparedStatement ps = null;
        ResultSet res = null;
        try{
                String query = "Select * from enrollments where studentRollNumber = ? AND courseName = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, student);
            ps.setString(2,course);
            res = ps.executeQuery();
            Enrollment enrollment = new Enrollment();
            while(res.next()){
                enrollment.setCourseName(res.getString("courseName"));
                enrollment.setStudentRollNumber(res.getString("studentRollNumber"));
                enrollment.setPaidAmount(res.getInt("paidAmount"));
                enrollment.setDueAmount(res.getInt("dueAmount"));
            }
            return enrollment;
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

public static int updateEnrollment(String studentIdentifier, String courseIdentifier, String studentRollNumber, String courseName, int paidAmount, int dueAmount){
        Connection con = ConnectionPool.getConnection();
        PreparedStatement ps = null;
        try{
                String query = " UPDATE enrollments SET studentRollNumber = ? , courseName = ? , paidAmount = ? , dueAmount = ?"
                        + " WHERE studentRollNumber = ? AND courseName = ? ";
            ps = con.prepareStatement(query);
            ps.setString(1,studentRollNumber );
            ps.setString(2,courseName);
            ps.setInt(3, paidAmount);
            ps.setInt(4, dueAmount);
            ps.setString(5, studentIdentifier);
            ps.setString(6, courseIdentifier);
            
            
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
