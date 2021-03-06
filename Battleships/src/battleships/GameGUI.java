/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleships;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
        
        setLayout(new BorderLayout());
        
        this.btnsPlayerOne = new JButton[grid1.getFields().length][grid1.getFields()[0].length];
        for(int x1 = 0; x1 < grid1.getFields().length; x1++)
        {
            for (int y1 = 0; y1 < grid1.getFields()[x1].length; y1++)
            {
                this.btnsPlayerOne[x1][y1] = new JButton(x1 + ":" + y1);
                this.btnsPlayerOne[x1][y1].addActionListener(new PlayerOneAL());
                this.btnsPlayerOne[x1][y1].setBackground(Color.GRAY);
                this.btnsPlayerOne[x1][y1].setOpaque(true);
                pnlPlayerOne.add(this.btnsPlayerOne[x1][y1]);
            }
        }
        
        this.btnsPlayerTwo = new JButton[grid2.getFields().length][grid2.getFields()[0].length];
        for(int x2 = 0; x2 < grid2.getFields().length; x2++)
        {
            for (int y2 = 0; y2 < grid2.getFields()[x2].length; y2++)
            {
                this.btnsPlayerTwo[x2][y2] = new JButton(x2 + ":" + y2);
                this.btnsPlayerTwo[x2][y2].addActionListener(new PlayerTwoAL());
                this.btnsPlayerTwo[x2][y2].setBackground(Color.GRAY);
                this.btnsPlayerTwo[x2][y2].setOpaque(true);
                pnlPlayerTwo.add(this.btnsPlayerTwo[x2][y2]);
            }
        }
        
        GridLayout grdPlayer = new GridLayout(6,6);        
        pnlPlayerOne.setLayout(grdPlayer);
        pnlPlayerTwo.setLayout(grdPlayer);
                
        add(pnlPlayerOne, BorderLayout.WEST);
        add(pnlPlayerTwo, BorderLayout.EAST);
        add(lblStatus, BorderLayout.SOUTH);
   
        setVisible(true);
        
    }
    
    public void repaintBtnsPlayerOne(GridField[][] grid){
        
        for(int x = 0; x < grid.length; x++){
            for(int y = 0; y < grid[x].length; y++){
                if(grid[x][y].isShot()){
                    if(grid[x][y].getShip()== null){
                        btnsPlayerOne[x][y].setBackground(Color.BLUE);
                    }
                    else
                    {
                        btnsPlayerOne[x][y].setBackground(Color.RED);
                    }
                }
                else{
                    if(grid[x][y].getShip() == null){
                        btnsPlayerOne[x][y].setBackground(Color.GRAY);
                    }
                    else
                    {
                        btnsPlayerOne[x][y].setBackground(Color.BLACK);
                    }
                    
                }
            }
        }
    }
    
    public void repaintBtnsPlayerTwo(GridField[][] grid){
        
        for(int x = 0; x < grid.length; x++){
            for(int y = 0; y < grid[x].length; y++){
                if(grid[x][y].isShot()){
                    if(grid[x][y].getShip()== null){
                        btnsPlayerTwo[x][y].setBackground(Color.BLUE);
                    }
                    else
                    {
                        btnsPlayerTwo[x][y].setBackground(Color.RED);
                    }
                }
                else{
                    btnsPlayerTwo[x][y].setBackground(Color.GRAY);
                }
            }
        }
    }
 
    private class PlayerOneAL implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(gameView.getGameControl().getShipsPlaced()) {
                lblStatus.setText("Ships already placed. Y U DO DIS!?");
            } else {
                String coords = e.getActionCommand();
                String[] split = coords.split(":");
                int xCoord = Integer.parseInt(split[0]);
                int yCoord = Integer.parseInt(split[1]);
                boolean isPlaced = gameView.getGameControl().placeShip(xCoord, yCoord);
                if(isPlaced) {
                    if(gameView.getGameControl().getShipsPlaced()) {
                        lblStatus.setText("Ships placed. Reddy tu römbel!");
                    } else {
                        lblStatus.setText("Ship placed, more to go!");                    
                    }
                } else {
                    if(gameView.getGameControl().getShipsPlaced()) {
                        lblStatus.setText("Ships placed. Reddy tu römbel!");
                    } else {
                        lblStatus.setText("Ship not placed, try another field!");                    
                    }
                }                
            }
        }   
    }   

    private class PlayerTwoAL implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(gameView.getGameControl().getShipsPlaced() && gameView.getGameControl().getMyTurn()) {
                String coords = e.getActionCommand();
                String[] split = coords.split(":");
                int xCoord = Integer.parseInt(split[0]);
                int yCoord = Integer.parseInt(split[1]);
                boolean isHit = gameView.getGameControl().myTurn(xCoord, yCoord);
                if(isHit) {
                    lblStatus.setText("Hit!");
                } else {
                    lblStatus.setText("Miss!");
                }
            } else {
                lblStatus.setText("Not your turn now. Y U DO DIS!?");
            }
        }
    }

}
