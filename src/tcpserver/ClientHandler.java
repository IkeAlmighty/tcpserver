/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpserver;

import java.net.Socket;

/**
 * Creates a Thread for the doOnConnection method to run on, and calls the
 * doOnConnection method.
 * @author Isaac
 */
public class ClientHandler extends Thread{
    
    private Socket client;
    private ClientConnectionListener listener;
    
    public ClientHandler(Socket client, ClientConnectionListener listener)
    {
        this.client = client;
        this.listener = listener;
        if(client == null){
            System.out.println("NULL CLIENT");
        }
    }
    
    @Override
    public void run()
    {
        System.out.println("client: " + client);
        System.out.println("listener: " + listener);
       listener.doOnConnection(new ConnectionEvent(client));
    }
}
