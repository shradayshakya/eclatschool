package business;

import java.io.Serializable;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author shinigami
 */
public class Admin implements Serializable{
    private String name;
    private String email;
    private String password;

    public Admin(){
        name = "";
        email = "";
        password = "";
    }
    
    public Admin(String name, String email, String password, String role){
        this.name = name;
        this.email = email;
        this.password = password;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return this.password;
    }
}
