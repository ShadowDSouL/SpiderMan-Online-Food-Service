/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jpassignment;

/**
 *
 * @author zhong
 */
//This is the child class of user
public class Customer extends User{
    Customer()
    {}
    
    //Register 
    Customer(String UName, String Fullname, String Password, String Phone_Number, String Birthday, 
            String Email_Address, String Address, String Cardholder_Name, String Expiry_Date, String CVV_Number)
    {
        username = UName;
        name = Fullname;
        pw = Password;
        pn = Phone_Number;
        dob = Birthday;
        ea = Email_Address;
        ad = Address;
        cn = Cardholder_Name;
        ed = Expiry_Date;
        cvn = CVV_Number;
    }
   
}
