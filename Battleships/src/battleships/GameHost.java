/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleships;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private GameControl gameControl;

    public GameHost(GameControl gameControl) {
        this.gameControl = gameControl;
    }

    public void waiting() {
        gameControl.setPolePosition(true); /* defined that waiting Player has pole */
        try {
            this.serverSocket = new ServerSocket(4444);
            this.clientSocket = serverSocket.accept();
            this.out = new ObjectOutputStream(clientSocket.getOutputStream());
            this.in = new ObjectInputStream(clientSocket.getInputStream());
            JOptionPane.showMessageDialog(null, "Verbindung zu Client hergestellt. Game wird gestartet.");
        } catch (IOException e) {
            throw new RuntimeException(
                    "Error accepting client connection", e);
        }
    }

    public void connect(String ip) {
       gameControl.setPolePosition(true); /* defined that waiting Player has pole */
        try {
            this.clientSocket = new Socket(ip, 4444);
            this.out = new ObjectOutputStream(clientSocket.getOutputStream());
            this.in = new ObjectInputStream(clientSocket.getInputStream());
            JOptionPane.showMessageDialog(null, "Verbindung zu Server hergestellt. Game wird gestartet.");
        } catch (IOException e) {
            throw new RuntimeException(
                    "Error accepting client connection", e);
        }
    }

    public void sendShot(String coordinates) {
        try {
            this.out.writeObject(coordinates);
        } catch (IOException ex) {
            Logger.getLogger(GameHost.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void sendGrid(Grid grid) {
        try {
            this.out.writeObject(grid);
        } catch (IOException ex) {
            Logger.getLogger(GameHost.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String receiveShot() {
        String coordinates = "";
        try {
            coordinates = (String) this.in.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(GameHost.class.getName()).log(Level.SEVERE, null, ex);
        }

        return coordinates;
    }

    public Grid receiveGrid() {
        Grid opponentGrid = null;
        try {
            opponentGrid = (Grid) this.in.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(GameHost.class.getName()).log(Level.SEVERE, null, ex);
        }
        return opponentGrid;
    }

}
