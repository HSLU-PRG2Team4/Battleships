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
public class GameModel {
    
    private OwnGrid ownGrid;
    private OpponentGrid opponentGrid;
    private final Ship[] ownShips;

    public GameModel() {
        this.ownGrid = new OwnGrid(6, 6);
        this.opponentGrid = new OpponentGrid(6, 6);
        
        this.ownShips = new Ship[3];
        this.ownShips[0] = new Ship(3, "Kreuzer");
        this.ownShips[1] = new Ship(2, "Zerstörer");
        this.ownShips[2] = new Ship(1, "Gumelboot");
    }
    
    /**
     * Get the value of ownGrid
     *
     * @return the value of ownGrid
     */
    public OwnGrid getOwnGrid() {
        return ownGrid;
    }

    /**
     * Set the value of ownGrid
     *
     * @param ownGrid new value of ownGrid
     */
    public void setOwnGrid(OwnGrid ownGrid) {
        this.ownGrid = ownGrid;
    }

    /**
     * Get the value of opponentGrid
     *
     * @return the value of opponentGrid
     */
    public OpponentGrid getOpponentGrid() {
        return opponentGrid;
    }

    /**
     * Set the value of opponentGrid
     *
     * @param opponentGrid new value of opponentGrid
     */
    public void setOpponentGrid(OpponentGrid opponentGrid) {
        this.opponentGrid = opponentGrid;
    }

    /**
     * Get the value of ownShips
     * @return the value of ownShips
     */
    public Ship[] getOwnShips() {
        return ownShips;
    }
}
