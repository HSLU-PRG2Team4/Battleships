/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleships;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.Border;

/**
 *
 * @author Rafael
 */
public class ConnectionGUI extends JFrame implements ActionListener {

    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem menuItem;
    private boolean isServer;
    private ServerSocket serverSocket = null;
    private Socket clientSocket = null;

    public ConnectionGUI() {
        initUI();
        this.setJMenuBar(createMenu());
        setVisible(true);
        createServerSocket();
    }

    public JMenuBar createMenu() {
        // Create MenuBar and Menu
        menuBar = new JMenuBar();;
        menu = new JMenu("Game");
        menuBar.add(menu);

        // Add Menu Item to Menu
        menuItem = new JMenuItem("Join existing game");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        return menuBar;
    }

    private void initUI() {
        setTitle("Battleship - Initialize Connection");
        setSize(600, 120);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container content = getContentPane();

        JLabel waitingLabel = new JLabel("Waiting for Connection...");
        content.add(waitingLabel);

        // Set Border for progress bar
        Border border = BorderFactory.createTitledBorder("");
        waitingLabel.setBorder(border);
        content.add(waitingLabel, BorderLayout.CENTER);
    }

    public void createServerSocket() {
        try {
            // Create new Server Socket
            isServer = true;
            // Open Server Socket
            serverSocket = new ServerSocket(4444);
            clientSocket = serverSocket.accept();
            JOptionPane.showMessageDialog(null, "Verbinung zu Client hergestellt");
        } catch (IOException ex) {
            Logger.getLogger(ConnectionGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void createClientSocket() {
        try {
            //Dialog für Verbindungsauswahl mit Server
            JFrame frame = new JFrame();
            frame = new JFrame("IP-Adresse des Servers");
            String ip = JOptionPane.showInputDialog(frame, "IP-Adresse des Servers");

            serverSocket = null;
            clientSocket = null;

            //Aufruf Connection
            clientSocket = new Socket(ip, 4444);
            JOptionPane.showMessageDialog(null, "Verbindung zu Host hergestellt");
        } catch (IOException ex) {
            Logger.getLogger(ConnectionGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menuItem) {
            createClientSocket();
        }
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                ConnectionGUI ex = new ConnectionGUI();
            }
        });
    }
}
