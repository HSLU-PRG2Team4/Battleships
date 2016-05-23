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
    private final int serverPort;

    public GameServer(int serverPort) {
        this.serverPort = serverPort;
    }

    public void run() {
        synchronized (this) {
            this.runningThread = Thread.currentThread();
        }
        openServerSocket();

        while (!isStopped()) {
            clientSocket = null;
            try {
                this.clientSocket = this.serverSocket.accept();
                JOptionPane.showMessageDialog(null, "Verbindung zu Client hergestellt. Game wird gestartet.");
            } catch (IOException e) {
                if (isStopped()) {
                    JOptionPane.showMessageDialog(null, "Server gestoppt.");
                    return;
                }
                throw new RuntimeException(
                        "Error accepting client connection", e);
            }           
        }

        JOptionPane.showMessageDialog(null, "Server gestoppt.");
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

    private void openServerSocket() {
        try {
            this.serverSocket = new ServerSocket(this.serverPort);
        } catch (IOException e) {
            throw new RuntimeException("Cannot open port", e);
        }
    }
}
