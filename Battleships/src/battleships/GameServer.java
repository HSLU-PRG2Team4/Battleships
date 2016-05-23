/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleships;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafael
 */
public class GameServer implements Runnable {

    private Socket clientSocket = null;
    private ServerSocket serverSocket = null;
    private Thread runningThread = null;
    private boolean isStopped = false;
    private final int port;

    public GameServer(int port) {
        this.port = port;
    }

    public void run() {
        synchronized (this) {
            this.runningThread = Thread.currentThread();
        }

        try {
            // Open Server Socket
            this.serverSocket = new ServerSocket(this.port);

        } catch (IOException ex) {
            Logger.getLogger(ConnectionGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (!isStopped()) {
            try {
                this.clientSocket = this.serverSocket.accept();

                // Erstelle neues Opponent Objekt
                new Opponent(this.clientSocket);

            } catch (IOException e) {
                if (isStopped()) {
                    System.out.println("Server stopped.");
                    return;
                }
                throw new RuntimeException(
                        "Error accepting client connection", e);
            }
        }
        System.out.println("Server Stopped.");
    }

    private synchronized boolean isStopped() {
        return this.isStopped;
    }

    public synchronized void stop() {
        this.isStopped = true;
        try {
            this.serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException("Error closing server", e);
        }
    }
}
