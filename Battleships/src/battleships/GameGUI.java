/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleships;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.WindowConstants;

/**
 *
 * @author Damian
 */
public class GameGUI extends JFrame{

    public GameGUI() throws HeadlessException {
        
        super("Battleships");
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1000,500);
        setResizable(false);
        setVisible(true);
        
        setLayout(new BorderLayout());
        GridLayout PlayerGrid = new GridLayout(6,6);
        
        JLabel lStatus = new JLabel("Status");
        
        add(new Button("East"), BorderLayout.EAST);
        add(new Button("West"), BorderLayout.WEST);
        add(new Label("Center"), BorderLayout.CENTER);
        add(lStatus, BorderLayout.SOUTH);
        //add(new JSeparator(), BorderLayout.CENTER);
   
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new GameGUI());
    }
    
}
