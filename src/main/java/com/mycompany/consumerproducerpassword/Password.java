/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.consumerproducerpassword;

/**
 *
 * @author Richard Hofmeister
 */
public class Password {
    private String password;

    public Password(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
    
    public boolean check(String password)
    {
        if(this.password.equals(password))
        {
            return true;
        }
        return false;
    }
}
