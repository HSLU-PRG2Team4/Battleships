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
public class GridField {

    private Ship ship;
    private boolean shot;

    public GridField() {
        this.shot = false;
    }
    
   /**
     * Get the value of ship
     *
     * @return the value of ship
     */
    public Ship getShip() {
        return ship;
    }

    /**
     * Set the value of ship
     *
     * @param ship new value of ship
     */
    public void setShip(Ship ship) {
        this.ship = ship;
    }
    
    /**
     * Get the value of shot
     *
     * @return the value of shot
     */
    public boolean isShot() {
        return shot;
    }

    /**
     * Set the value of shot
     *
     * @param isShot new value of shot
     */
    public void setShot(boolean shot) {
        this.shot = shot;
    }

    /**
     * Execute a shot on this field and get true if a ship is hit
     * @return true if ship is hit, false if no ship on this field
     */
    public boolean shot() {
        this.setShot(true);
        if(getShip() != null) {
            this.getShip().hit(); 
            return true;
        } else {
            return false;
        }
    }
}
