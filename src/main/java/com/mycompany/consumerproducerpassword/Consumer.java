/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.consumerproducerpassword;

import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Richard Hofmeister
 */
public class Consumer implements Runnable {

    private LinkedList<Password> passwords;

    public Consumer() {
    }

    @Override
    public void run() {
        while (true) {
            synchronized (passwords) {
                if (passwords.isEmpty()) {
                    try {
                        passwords.wait();
                        continue;
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                Password pwd = passwords.poll();
                passwords.notifyAll();
            }

            //TODO check
            passwords.getFirst().check(password);
        }

    }
}
