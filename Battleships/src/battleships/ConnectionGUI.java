/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleships;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Rafael
 */
public class ConnectionGUI extends JDialog implements ActionListener {

    JButton buttonServer;
    JButton buttonClient;
    JLabel connectionLabel;
    JPanel panelTop;
    JPanel panelBottom;

    private GameView gameView;

    public ConnectionGUI(GameView gameView) {
        this.gameView = gameView;
        initUI();        
    }

    private void initUI() {
        this.setTitle("Choose Connection");        
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setModal(true);
        this.setSize(550, 150);
        panelTop = new JPanel();
        panelBottom = new JPanel();

        // Leeres JLabel-Objekt wird erzeugt
        connectionLabel = new JLabel("Please choose your connection");

        //Drei Buttons werden erstellt
        buttonServer = new JButton("Server");
        buttonClient = new JButton("Client");

        //Buttons werden dem Listener zugeordnet
        buttonServer.addActionListener(this);
        buttonClient.addActionListener(this);

        //Buttons werden dem JPanel hinzugefügt
        panelTop.add(buttonServer);
        panelTop.add(buttonClient);

        //JLabel wird dem Panel hinzugefügt
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
