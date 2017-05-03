/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * A TCP server is an extension of a Thread. Therefore it must be started using
 * the start() method.
 * @author Isaac
 */
public class TCPServer extends Thread{
    
    private int port;
    private ArrayList<ClientConnectionListener> listeners;
    
    /**
     * Creates a TCP server on a given port with a given connection operation.
     * A TCPServer will not do anything on client connection until a listener is
     * added via addClientConnectionListener(ClientConnnectionListener)
     * @param port The port number to open the TCP connection at.
     */
    public TCPServer(int port)
    {
        this.port = port;
        listeners = new ArrayList<>();
    }
    
    /**
     * Adds a listener to define a doOnConnection method.
     * @param listener 
     */
    public void addClientConnectionListener(ClientConnectionListener listener)
    {
        listeners.add(listener);
    }
    
    @Override
    public void run() {
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            try{
                Socket client = server.accept();
                
                for(ClientConnectionListener listener: listeners)
                {
                    ClientHandler handle = new ClientHandler(client, listener);
                    handle.start();
                }
                
            } catch(IOException | NullPointerException e)
            {
                e.printStackTrace();
            }
        }

    }
}
