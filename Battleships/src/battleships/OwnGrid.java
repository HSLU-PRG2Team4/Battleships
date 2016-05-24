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
public class OwnGrid extends Grid {
    
    public OwnGrid(int width, int height) {
        super(width, height);
    }
    
    public boolean placeShip(Ship ship, int xCoord, int yCoord) {
        if(xCoord + ship.getHealth() < this.getFields().length) {
            for(int i = 0; i < ship.getHealth(); i++) {
                if(this.getField(xCoord + i, yCoord).getShip() != null) {
                    return false;
                }
            }
            for(int i = 0; i < ship.getHealth(); i++) {
                this.getField(xCoord + i, yCoord).setShip(ship);                        
            }
            return true;
        }
        return false;
    }
}
