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
        gameControl.init();  /* connectionGUI waits until connection is made */
                
        /* temporary TEST */
        gameControl.requestShot();
        
        
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
       System.out.println(xCoord + " " + yCoord);
    }

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
