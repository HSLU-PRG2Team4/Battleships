/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleships;

import java.awt.EventQueue;

/**
 *
 * @author Rafael Stalder, Damian Schilter, Lucas Schnüriger, Dominik Zgraggen
 */
public class GameView {
    private GameControl gameControl;
    private ConnectionGUI startWindow;
    private GameGUI playWindow;
    
    public GameView(GameControl gameControl) {
        this.gameControl = gameControl;
        this.startWindow = new ConnectionGUI(this);
        
    }
    
    public void setPlayWindow(OwnGrid grid1, OpponentGrid grid2){
        //this.playWindow = new GameGUI(grid1, grid2);
        EventQueue.invokeLater(() -> new GameGUI(this, grid1, grid2));
    }
    
    public GameControl getGameControl(){
        return gameControl;
    }
    
}
