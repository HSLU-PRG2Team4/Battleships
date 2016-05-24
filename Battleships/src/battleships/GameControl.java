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
public class GameControl {
    private GameModel gameModel;
    private GameView gameView;
    private Opponent opponent;
    
    public static void main(String args[]){
        GameControl gameControl = new GameControl();
        gameControl.init(); 
        
    }
    
    public void init(){
        gameModel = new GameModel();
        gameView = new GameView(this);
        opponent = new Opponent(this);
        
    }
    
    
    /* when player A waits for invitation (called by ConnectionGUI) */
    public void waitForConnection(String ip){
        opponent.getGameHost().connect(ip);
    }
    
    
    /* when Player A sends invitation to player B (called by ConnectionGUI) */
    public void requestConnection(){
        opponent.getGameHost().waiting();
    }
}
