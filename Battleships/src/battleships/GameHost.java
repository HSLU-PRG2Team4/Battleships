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
public class GameHost {

    private Socket clientSocket;
    private ServerSocket serverSocket;
   
    public void waiting(){       
        try {
             serverSocket = new ServerSocket(4444);
             clientSocket = serverSocket.accept();
             JOptionPane.showMessageDialog(null, "Verbindung zu Client hergestellt. Game wird gestartet.");
        } catch (IOException e) {             
             throw new RuntimeException(
                     "Error accepting client connection", e);
        }           
    }    
    
    public void connect(String ip){       
        try {
            clientSocket = new Socket(ip, 4444);
             JOptionPane.showMessageDialog(null, "Verbindung zu Server hergestellt. Game wird gestartet.");
        } catch (IOException e) {             
             throw new RuntimeException(
                     "Error accepting client connection", e);
        }           
    }
}
