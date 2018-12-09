/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import business.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author shinigami
 */
public class StudentDB {
    
    public static int insert(Student student){
        Connection con = ConnectionPool.getConnection();
        
        PreparedStatement ps = null;
         
        String query = "INSERT INTO students(rollNumber, name, address, dob, contactNumber)  VALUES(?,?,?,?,?)";
        try {
         ps   = con.prepareStatement(query);
        ps.setString(1, student.getRollNumber());
        ps.setString(2, student.getName());
        ps.setString(3, student.getAddress());
        ps.setString(4, student.getDob());
        ps.setString(5, student.getContactNumber());
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
    
    public static Student[] getStudents(){
        Connection con = ConnectionPool.getConnection();
        Statement stm = null;
        ResultSet res = null;
    
        try{
                String query = "Select * from students";
                stm = con.createStatement();
               res = stm.executeQuery(query);
               int rows = DbTools.getRowCount(res);
                Student students[] = new Student[rows];
                int count = 0;
            while(res.next()){
                Student student = new Student();
                student.setName(res.getString("name"));
                student.setRollNumber(res.getString("rollNumber"));
                student.setAddress(res.getString("address"));
                student.setDob(res.getString("dob"));
                student.setContactNumber(res.getString("contactNumber"));
                students[count] = student;
                count++;
            }
            return students;
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
    
    public static Student getStudent(String rollNumber){
        Connection con = ConnectionPool.getConnection();
        PreparedStatement ps = null;
        ResultSet res = null;
        try{
                String query = "Select * from students where rollNumber = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, rollNumber);
            res = ps.executeQuery();
            Student student = new Student();
            while(res.next()){
                student.setName(res.getString("name"));
                student.setRollNumber(res.getString("rollNumber"));
                student.setAddress(res.getString("address"));
                student.setDob(res.getString("dob"));
                student.setContactNumber(res.getString("contactNumber"));
            }
            return student;
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
    
    public static int deleteStudent(String rollNumber){
        Connection con = ConnectionPool.getConnection();
        Statement stm = null;
        try{
                String query = "delete from students where rollNumber = '"+rollNumber+"'";
            stm = con.createStatement();
            System.out.println(query);
           
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
    
    public static int updateStudent(String roll, String rollNumber, String name, String address, String dob, String contactNumber){
        Connection con = ConnectionPool.getConnection();
        PreparedStatement ps = null;
        try{
                String query = " UPDATE students SET rollNumber = ? , name = ? , address = ? , dob = ? , contactNumber = ?"
                        + " WHERE rollNumber = ? ";
            ps = con.prepareStatement(query);
            ps.setString(1, rollNumber);
            ps.setString(2, name);
            ps.setString(3, address);
            ps.setString(4, dob);
            ps.setString(5, contactNumber);
            ps.setString(6, roll);
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