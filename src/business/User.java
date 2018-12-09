package business;

import java.io.Serializable;

public class User implements Serializable{
    protected String rollNumber;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    protected String email;
    protected String password;

    public User() {
        this.rollNumber = null;
        this.password = "";
    }


    public User(String rollNumber, String password,String email) {
        this.rollNumber = rollNumber;
        this.password = password;
        this.email = email;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
