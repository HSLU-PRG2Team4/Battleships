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
        gameControl.newGame();
        
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
    public void newGame() {
        this.gameView.setPlayWindow(this.gameModel.getOwnGrid(), this.gameModel.getOpponentGrid());
    }
    
   // public void newGame(String IP){
   //     connection = new Opponent(IP);    
        
   // }    

    public boolean placeShip(int xCoord, int yCoord) {
        Ship[] ships = gameModel.getOwnShips();
        OwnGrid ownGrid = gameModel.getOwnGrid();
        for(Ship ship : ships) {
            if(!ship.isPlaced()) {
                if(xCoord + ship.getHealth() <= ownGrid.getFields().length) {
                    for(int i = 0; i < ship.getHealth(); i++) {
                        if(ownGrid.getField(xCoord + i, yCoord).getShip() != null) {
                            return false;
                        }
                    }
                    for(int i = 0; i < ship.getHealth(); i++) {
                        ownGrid.getField(xCoord + i, yCoord).setShip(ship);                        
                    }
                    return true;
                }
                return false;
            }
        }
        return false;
    }
}
