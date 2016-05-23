/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleships;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Rafael
 */
public class ConnectionGUI extends JFrame implements ActionListener {
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem menuItem;
    
    public ConnectionGUI() {
        initUI();
        createMenu();
    }

    public JMenuBar createMenu() {
        // Create MenuBar and Menu
        menuBar = new JMenuBar();;
        menu = new JMenu("Connection");        
        menuBar.add(menu);

        // Add Menu Item to Menu
        menuItem = new JMenuItem("Join Game");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        return menuBar;
    }

    private void initUI() {
        setTitle("Waiting for Connection");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == menuItem){
            
        }
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                ConnectionGUI ex = new ConnectionGUI();
                ex.setVisible(true);
            }
        });
    }
}
