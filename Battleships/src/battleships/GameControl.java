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
    private GameHost gameHost;
    
    public static void main(String args[]){
        GameControl gameControl = new GameControl();
        gameControl.init();
        gameControl.newGame();
        
        /* while with shot and requestShot */
        
    }
    
    public void init(){
        gameModel = new GameModel();
        gameView = new GameView(this);
        gameHost = new GameHost(this);
    }
    
    /* when player A waits for invitation (called by ConnectionGUI) */
    public void waitForConnection(){
        gameHost.waiting();
    }
    
    
    /* when Player A sends invitation to player B (called by ConnectionGUI) */
    public void requestConnection(String ip){
        gameHost.connect(ip);
    }
    
    
    
    
    public void newGame() {
        this.gameView.setPlayWindow(this.gameModel.getOwnGrid(), this.gameModel.getOpponentGrid());
    }
    
    /* send coords from ownGrid to opponent */
    public void shot(int xCoord, int yCoord) {
       /* update GameView */
       /* update owngrid => GameModel*/
       
       String coordinates = xCoord + ";" + yCoord;
       gameHost.sendShot(coordinates);  
    }
    
    public void requestShot() {
       String coords = gameHost.receiveShot();
       /* string coord split to integers */
       String[] parts = coords.split(";");
       int xCoord =  Integer.parseInt(parts[0]);
       int yCoord = Integer.parseInt(parts[1]);
       /* update OpponentGrid */
    }

    public boolean placeShip(int xCoord, int yCoord) {
        Ship[] ships = this.gameModel.getOwnShips();
        for(Ship ship : ships) {
            if(!ship.isPlaced()) {
                return this.gameModel.getOwnGrid().placeShip(ship, xCoord, yCoord);
            }
        }
        return false;              
    }
}
