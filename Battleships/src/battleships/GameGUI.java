/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleships;

import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;

/**
 *
 * @author Damian
 */
public class GameGUI extends JFrame{
    
    private final JMenuBar menuBar = new JMenuBar();
    private final JMenu menuFile = new JMenu("File");
    private final JMenuItem mNew = new JMenuItem("New");
    private final JMenuItem mExit = new JMenuItem("Exit");

    public GameGUI() throws HeadlessException {
        
        super("Battleships");
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500,500);
        setResizable(false);
        
        menuBar.add(menuFile);
        menuFile.add(mNew);
        menuFile.addSeparator();
        menuFile.add(mExit);
        
        setJMenuBar(menuBar);
        setVisible(true);
        
        //
        mExit.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
        
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    }
    
}
