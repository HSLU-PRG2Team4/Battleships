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
public class Ship {

    private int health;
    private String name;

    public Ship(int health, String name) {
        this.health = health;
        this.name = name;
    }

   /**
     * Get the value of health
     *
     * @return the value of health
     */
    public int getHealth() {
        return health;
    }

    /**
     * Set the value of health
     *
     * @param health new value of health
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Execute a hit, decrease health and return new health
     * @return int of new health
     */
    public int hit() {
        if(this.health > 0) {
            this.health -= 1;            
        }
        return this.health;
    }
     
}
