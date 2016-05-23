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
import java.awt.event.ActionEvent;
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
    
    //private final JMenuBar menuBar = new JMenuBar();
    //private final JMenu menuFile = new JMenu("File");
    //private final JMenuItem mNew = new JMenuItem("New Game");
    //private final JMenuItem mExit = new JMenuItem("Exit");
    private JLabel lStatus = new JLabel("Status");

    public GameGUI() throws HeadlessException {
        
        super("Battleships");
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1000,500);
        setResizable(false);
        
        //menuBar.add(menuFile);
        //menuFile.add(mNew);
        //menuFile.addSeparator();
        //menuFile.add(mExit);
        
        GridLayout GUILayout = new GridLayout(0,3);
        
        final JPanel player = new JPanel();
        player.setLayout(GUILayout);
        JPanel pane = new JPanel();
        pane.setLayout(new GridLayout(2,3));
        
        for(int i=1;i<=36;i++){
            add(new Button(""+i));
        }
        
        add(lStatus);
        
        //setJMenuBar(menuBar);
        
        pane.add(player, BorderLayout.NORTH);
        pane.add(new JSeparator(), BorderLayout.CENTER);
        pane.add(player, BorderLayout.SOUTH);
        
        setVisible(true);
        
        //
        /*mExit.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });*/
        
        
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    }
    
}
