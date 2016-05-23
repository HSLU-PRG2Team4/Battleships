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
        setSize(750,500);
        setResizable(false);
        setVisible(true);
        
        setLayout(new BorderLayout());
        
        GridLayout grdPlayer = new GridLayout(6,6);
        
        JLabel lblStatus = new JLabel("Status");
        JPanel pnlPlayerOne = new JPanel();
        JPanel pnlPlayerTwo = new JPanel();
        
        add(pnlPlayerOne, BorderLayout.WEST);
        
        for(int i=1;i<=36;i++)
        {
            pnlPlayerOne.add(new JButton(""+i));
        }
        
        for(int j=1;j<=36;j++)
        {
            pnlPlayerTwo.add(new JButton(""+j));
        }
        
        pnlPlayerOne.setLayout(grdPlayer);
        pnlPlayerTwo.setLayout(grdPlayer);
        
        add(pnlPlayerOne, BorderLayout.WEST);
        add(pnlPlayerTwo, BorderLayout.EAST);
        add(lblStatus, BorderLayout.SOUTH);
   
    }
    
    public static void main(final String[]args){
        EventQueue.invokeLater(() -> new GameGUI());
    }
    
}
