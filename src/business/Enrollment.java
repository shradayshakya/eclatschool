/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.io.Serializable;
/**
 *
 * @author shinigami
 */
public class Enrollment implements Serializable{
    private String studentRollNumber;
    private String courseName;
    private int paidAmount;
    private int dueAmount;
    
    public Enrollment(){
        this.studentRollNumber = "";
        this.courseName = "";
        this.paidAmount = 0;
        this.dueAmount = 0;
    }
    
    public Enrollment(String studentRollNumber, String courseName, int paidAmount, int dueAmount){
        this.studentRollNumber = studentRollNumber;
        this.courseName = courseName;
         this.paidAmount = paidAmount;
        this.dueAmount = dueAmount;
    }
    
    public void setStudentRollNumber(String studentRollNumber){
        this.studentRollNumber = studentRollNumber;
    }
    
    public String getStudentRollNumber(){
        return this.studentRollNumber;
    }
    
    public void setCourseName(String courseName){
        this.courseName = courseName;
    }
    
    public String getCourseName(){
        return this.courseName;
    }
    
    public void setPaidAmount(int paidAmount){
        this.paidAmount = paidAmount;
    }
    
    public int getPaidAmount(){
        return this.paidAmount;
    }
    
    public void setDueAmount(int dueAmount ){
        this.dueAmount = dueAmount;
    }
    
    public int getDueAmount(){
        return this.dueAmount;
    }
}