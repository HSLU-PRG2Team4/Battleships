/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleships;

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
        this.startWindow = new ConnectionGUI();
    }
    
    public void setPlayWindow(){
        this.playWindow = new GameGUI();
    }
    
    
}
