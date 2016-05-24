/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleships;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Rafael
 */
public class ConnectionGUI extends JDialog implements ActionListener {

    private JButton buttonServer;
    private JButton buttonClient;
    private JLabel connectionLabel;
    private JPanel panelTop;
    private JPanel panelBottom;
    private GameView gameView;

    public ConnectionGUI(GameView gameView) {
        this.gameView = gameView;
        initUI();        
    }

    private void initUI() {
        this.setTitle("Battleship - Choose Connection");        
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setModal(true);
        this.setPreferredSize(new Dimension(400,120));
        panelTop = new JPanel();
        panelBottom = new JPanel();
        connectionLabel = new JLabel("Please choose your connection");
        buttonServer = new JButton("Server");
        buttonClient = new JButton("Client");

        buttonServer.addActionListener(this);
        buttonClient.addActionListener(this);

        panelTop.add(buttonServer);
        panelTop.add(buttonClient);
        panelBottom.add(connectionLabel);
        
        this.add(panelTop, BorderLayout.NORTH);
        this.add(panelBottom, BorderLayout.SOUTH);
        
        pack();
        setVisible(true);
    }        

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.buttonServer) {
            gameView.getGameControl().waitForConnection();
            dispose();
        } else if (e.getSource() == this.buttonClient) {
            JFrame frame = new JFrame("IP-Adresse des Servers");
            String ip = JOptionPane.showInputDialog(frame, "IP-Adresse des Servers");
            gameView.getGameControl().requestConnection(ip);
            dispose();
        }
    }
}
