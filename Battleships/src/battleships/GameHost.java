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
        gameControl.setMyTurn(true); /* defined that waiting Player has first turn */
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
       gameControl.setMyTurn(false); /* defined has not first turn */
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

    public void sendGridField(GridField[][] gridfield) {
        try {
            this.out.writeObject(gridfield);
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

    public GridField[][] receiveGridField() {
        GridField[][] gridField = null;
        try {
            gridField = (GridField[][]) this.in.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(GameHost.class.getName()).log(Level.SEVERE, null, ex);
        }
        return gridField;
    }

}
