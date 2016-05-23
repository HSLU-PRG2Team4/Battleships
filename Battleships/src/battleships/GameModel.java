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

    public GameModel() {
        this.ownGrid = new OwnGrid();
        this.opponentGrid = new OpponentGrid();
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

}
