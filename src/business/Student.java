package business;

import java.io.Serializable;
 
public class Student  implements Serializable{
    private String rollNumber;
    private String name;
    private String address;
    private String dob;
    private String contactNumber;
    
    public Student(){
        rollNumber ="";
        name = "";
        address = "";
        dob = "";
        contactNumber = "";
    }
    
    public Student(String rollNumber, String name, String address, String dob, String contactNumber){
        this.rollNumber = rollNumber;
        this.name = name;
        this.address = address;
        this.dob = dob;
        this.contactNumber = contactNumber;
    }
    
    public void setRollNumber(String rollNumber){
        this.rollNumber = rollNumber;
    }
    
    public String getRollNumber(){
        return this.rollNumber;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setAddress(String address){
        this.address = address;
    }
    
    public String getAddress(){
        return this.address;
    }
    
    public void setDob(String dob){
        this.dob = dob;
    }
    
    public String getDob(){
        return this.dob;
    }
    public void setContactNumber(String contactNumber){
        this.contactNumber = contactNumber;
    }
    
    public String getContactNumber(){
        return this.contactNumber;
    }
}
