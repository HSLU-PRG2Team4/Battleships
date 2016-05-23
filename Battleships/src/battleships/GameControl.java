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
    private Opponent connection;
    
    public static void main(String args[]){
        GameControl gameControl = new GameControl();
        gameControl.init(); 
        
    }
    
    public void init(){
        gameModel = new GameModel();
        gameView = new GameView();
        
    }
    
    public void newGame(String IP){
        connection = new Opponent(IP);
    
    }
    
}
