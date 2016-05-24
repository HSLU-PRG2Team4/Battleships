/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleships;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class GameGUI extends JFrame {
    
    private GameView gameView;
    private final JLabel lblStatus = new JLabel("Status");
    private final JPanel pnlPlayerOne = new JPanel();
    private final JPanel pnlPlayerTwo = new JPanel();
    private final JButton[][] btnsPlayerOne;
    private final JButton[][] btnsPlayerTwo;

    public GameGUI(GameView gameView, OwnGrid grid1, OpponentGrid grid2) throws HeadlessException {
        
        super("Battleships");
        this.gameView = gameView;
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1000, 500);
        setResizable(false);
        setVisible(true);
        
        setLayout(new BorderLayout());
        
        this.btnsPlayerOne = new JButton[grid1.getFields().length][grid1.getFields()[0].length];
        for(int x1 = 0; x1 < grid1.getFields().length; x1++)
        {
            for (int y1 = 0; y1 < grid1.getFields()[x1].length; y1++)
            {
                this.btnsPlayerOne[x1][y1] = new JButton(x1 + ":" + y1);
                this.btnsPlayerOne[x1][y1].addActionListener(new PlayerOneAL());
                pnlPlayerOne.add(this.btnsPlayerOne[x1][y1]);
            }
        }
        
        this.btnsPlayerTwo = new JButton[grid2.getFields().length][grid2.getFields()[0].length];
        for(int x2 = 0; x2 < grid2.getFields().length; x2++)
        {
            for (int y2 = 0; y2 < grid2.getFields()[x2].length; y2++)
            {
                this.btnsPlayerTwo[x2][y2] = new JButton(x2 + ":" + y2);
                this.btnsPlayerTwo[x2][y2].addActionListener(new PlayerOneAL());
                pnlPlayerTwo.add(this.btnsPlayerTwo[x2][y2]);
            }
        }
        
        GridLayout grdPlayer = new GridLayout(6,6);        
        pnlPlayerOne.setLayout(grdPlayer);
        pnlPlayerTwo.setLayout(grdPlayer);
                
        add(pnlPlayerOne, BorderLayout.WEST);
        add(pnlPlayerTwo, BorderLayout.EAST);
        add(lblStatus, BorderLayout.SOUTH);
   
    }
    
    private class PlayerOneAL implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String coords = e.getActionCommand();
            String[] split = coords.split(":");
            int xCoord = Integer.parseInt(split[0]);
            int yCoord = Integer.parseInt(split[1]);
            boolean isPlaced = gameView.getGameControl().placeShip(xCoord, yCoord);
            if(isPlaced) {
                lblStatus.setText("Ship placed!");
                btnsPlayerOne[xCoord][yCoord].setBackground(Color.red);
            } else {
                lblStatus.setText("Ship not placed, try another field!");
            }
        }   
    }   
}
