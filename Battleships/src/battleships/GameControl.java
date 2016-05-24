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
    private  GameModel gameModel;
    private  GameView gameView;
    private  GameHost gameHost;
    private static boolean shipsPlaced = false;
    private static boolean polePosition = false; /* whos turn is it? true -> myTurn */
    private static boolean gameOver = false;
    
    public static void main(String args[]){
        GameControl gameControl = new GameControl();
        gameControl.init();  /* connectionGUI waits until connection is made */
        
        gameControl.newGame();               
    }
    
    public void init(){
        gameModel = new GameModel();
        gameHost = new GameHost(this);
        gameView = new GameView(this);
       
    }
    
    public void setPolePosition(boolean pole){
        this.polePosition = pole;
    };
    
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
       String coordinates = xCoord + ";" + yCoord;
       gameHost.sendShot(coordinates);  
    }
    
    public boolean requestShot() {
       String coords = gameHost.receiveShot();
       
       /* string coord split to integers */
       String[] parts = coords.split(";");
       int xCoord =  Integer.parseInt(parts[0]);
       int yCoord = Integer.parseInt(parts[1]);
       
       /* update OpponentGrid */
       boolean hit = this.gameModel.getOpponentGrid().getField(xCoord, yCoord).shot(); 
       
       System.out.println(xCoord + " " + yCoord);
       return hit;
    }

    public void runGame(){       
        /* exchange Grids */
        gameHost.sendGrid(gameModel.getOwnGrid());
        gameHost.receiveGrid();        
    }
    
    public void myTurn(int xCoord, int yCoord){
        /* set shot to OwnGrid */
        boolean hit = this.gameModel.getOwnGrid().getField(xCoord, yCoord).shot();  

        if(!hit){ /* when shot hit ship myTurn again */
            polePosition = !polePosition;
        }
        this.shot(xCoord, yCoord);                   
    }
    
    public void opponentTurn(){
        boolean hit = this.requestShot();  

        /* update GameView */

        if(!hit){ /* when shot hit ship hisTurn again */
            polePosition = !polePosition;
        }        
    }
    
    public boolean placeShip(int xCoord, int yCoord) {
        Ship[] ships = this.gameModel.getOwnShips();
        for(Ship ship : ships) {
            if(!ship.isPlaced()) {
                return this.gameModel.getOwnGrid().placeShip(ship, xCoord, yCoord);
            }
        }
        this.runGame();
        return false;        
    }
}
