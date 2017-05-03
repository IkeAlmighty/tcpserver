/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpserver;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Isaac
 */
public class ServerErrLog {
    
    public static String log;
    
    /**
     * Appends the a message to ServerErrorLog.txt
     * @param error String describing the error.
     */
    public static void append(String error)
    {
        try {
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter("ServerErrorLog.txt", true));

            writer.append(System.currentTimeMillis() + ":\n" + error);
            log += "\n" + error;
            
            System.out.println("Error Logged: " + error);
        } catch (IOException e) {
            System.out.println("ErrorLog write failure.");
        }
    }
}
