/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleships;

import java.util.HashSet;

/**
 *
 * @author Rafael Stalder, Damian Schilter, Lucas Schnüriger, Dominik Zgraggen
 */
public class GameControl {
    private  GameModel gameModel;
    private  GameView gameView;
    private  GameHost gameHost;
    private boolean shipsPlaced = false;
    private boolean myTurn = false; /* whos turn is it? */
    private boolean gameOver = false;
    
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
    
    public void setMyTurn(boolean pole){
        this.myTurn = pole;
    }
    
    public boolean getMyTurn() {
        return this.myTurn;
    }
    
    public boolean getShipsPlaced() {
        return this.shipsPlaced;
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
    public void sendShot(int xCoord, int yCoord) {     
       String coordinates = xCoord + ":" + yCoord;
       gameHost.sendShot(coordinates);  
    }
    
    public boolean requestShot() {
       String coords = gameHost.receiveShot();
       
       /* string coord split to integers */
       String[] parts = coords.split(":");
       int xCoord =  Integer.parseInt(parts[0]);
       int yCoord = Integer.parseInt(parts[1]);
       
       /* update OwnGrid */
       boolean hit = this.gameModel.getOwnGrid().getField(xCoord, yCoord).shot(); 
       
       return hit;
    }

    public void runGame(){       
        /* exchange Grids */
        gameHost.sendGridField(gameModel.getOwnGrid().getFields());
        gameModel.getOpponentGrid().setFields(gameHost.receiveGridField());
        if(!this.myTurn) {
            this.opponentTurn();
        }
    }
    
    public boolean myTurn(int xCoord, int yCoord){
        /* set shot to OpponentGrid */
        boolean hit = this.gameModel.getOpponentGrid().getField(xCoord, yCoord).shot();  

        /* when shot hit ship myTurn again */
        myTurn = hit;
        this.sendShot(xCoord, yCoord);

        GameGUI gui = this.gameView.getPlayWindow();
        GridField[][] fields = this.gameModel.getOpponentGrid().getFields();
        gui.repaintBtnsPlayerTwo(fields);

        return hit;
    }
    
    public void opponentTurn(){
        boolean hit = this.requestShot();  

        /* update GameView */
        GameGUI gui = this.gameView.getPlayWindow();
        GridField[][] fields = this.gameModel.getOwnGrid().getFields();
        gui.repaintBtnsPlayerOne(fields);

        /* when shot hit ship hisTurn again */
        myTurn = !hit;       
    }
    
    public boolean placeShip(int xCoord, int yCoord) {
        Ship[] ships = this.gameModel.getOwnShips();
        for(int i = 0; i < ships.length; i++) {
            if(!ships[i].isPlaced()) {
                boolean placed = this.gameModel.getOwnGrid().placeShip(ships[i], xCoord, yCoord);
                if(placed)
                {
                    GameGUI gui = this.gameView.getPlayWindow();
                    GridField[][] fields = this.gameModel.getOwnGrid().getFields();
                    gui.repaintBtnsPlayerOne(fields);
                    if(i == ships.length - 1) {
                        this.shipsPlaced = true;
                        this.runGame();
                    }
                }
                return placed;
            }
        }
        return false;        
    }
}
