/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.lang.NullPointerException;

/**
 * Encapsulates the client socket and adds some extra getters for the event. 
 * This event is passed to ClientConnectionListenerr.doOnConnection(event) 
 * method.
 * @author Isaac
 */
public class ConnectionEvent {
    
    private final Socket client;
    private final long tStamp;
    
    protected ConnectionEvent(Socket client)
    {
        this.client = client;
        tStamp = System.currentTimeMillis();
    }
    
    public Socket getSource()
    {
        return client;
    }
    
    /**
     * 
     * @return time stamp from when the connection was made.
     */
    public long getCreationTStamp()
    {
        return tStamp;
    }
    
    
    /**
     * @throws NullPointerException
     * @return BufferedReader a reader for the client that created this event.
     */
    public BufferedReader getClientReader() throws NullPointerException
    {
        BufferedReader in = null;
        try
        {
            in = new BufferedReader(
                    new InputStreamReader(client.getInputStream()));
        } catch(IOException e)
        {
            e.printStackTrace();
        }
        
        if(in == null)
        {
            System.out.println("IN IS NULL");
            throw new NullPointerException();
        }
        
        return in;
    }
    
    public OutputStreamWriter getClientWriter() throws NullPointerException
    {
     
        OutputStreamWriter out = null;
        try
        {
            out = new OutputStreamWriter(client.getOutputStream());
        } catch(IOException e)
        {
            e.printStackTrace();
        }
        
        if(out == null)
        {
            System.out.println("OUT IS NULL");
            throw new NullPointerException();
        }
        
        return out;
    }
}
