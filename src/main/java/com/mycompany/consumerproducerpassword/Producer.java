/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.consumerproducerpassword;

import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Richard Hofmeister
 */
public class Producer implements Runnable {

    private LinkedList<Password> passwords;

    public Producer(LinkedList<Password> passwords) {
        this.passwords = passwords;
    }

    public boolean check(String test) {

        return false;
    }

    @Override
    public void run() {
        while (true) {
            // TODO read String from user
            String pwdS = JOptionPane.showInputDialog("Please enter the password: ");
            Password pwd = new Password(pwdS);

            synchronized (passwords) {
                if (passwords.size() > 5) {
                    try {
                        passwords.wait();
                        continue;
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                passwords.add(pwd);
                passwords.notifyAll();
            }
        }
    }
}
