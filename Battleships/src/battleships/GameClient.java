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
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafael
 */
public class GameClient {

    private Socket clientSocket = null;
    private int port;
    private String ip;

    public GameClient(String ip, int port) {
        this.ip = ip;
        this.port = port;

        try {
            this.clientSocket = new Socket(this.ip, this.port);
        } catch (IOException ex) {
            Logger.getLogger(GameClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Verbindung zu Server hergestellt. Game wird gestartet.");

        // Erstelle neues Opponent Objekt
        new Opponent(this.clientSocket);
    }

}
