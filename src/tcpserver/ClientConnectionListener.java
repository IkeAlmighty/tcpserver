/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpserver;

/**
 * Create a lambda or subclass from this class, then hand it to the TCPServer
 * on creation. ClientConnectionListener is a visitor for ClientHandler, to define 
 * what happens once a client makes a connection to a TCPServer.
 * @author Isaac
 */
public interface ClientConnectionListener {
    
    public void doOnConnection(ConnectionEvent e);
}
