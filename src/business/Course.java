/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.io.Serializable;

public class Course implements Serializable {
    private String name;
    private int amount;
    private int discount;
    
    public Course(){
        name = "";
        amount = 0;
        discount = 0;
    }
    
    public Course(String name, int amount, int discount){
        this.name = name;
        this.amount = amount;
        this.discount = discount;
    }
    
    public String getName(){
       return this.name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public int getAmount(){
        return this.amount;
    }
    
    public void setAmount(int amount){
        this.amount  =amount;
    }
    
    public int getDiscount(){
        return this.discount;
    }
    public void setDiscount(int discount){
        this.discount = discount;
    }
}
