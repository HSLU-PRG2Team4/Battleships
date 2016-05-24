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
    
    public boolean addShip(Ship ship, int xCoord, int yCoord) {
return false;      
//  return this.getField(xCoord, yCoord).setShip(ship);
    }
}
