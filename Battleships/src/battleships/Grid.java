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
public abstract class Grid {

    private GridField[][] fields;

    public Grid(int width, int height) {
        fields = new GridField[height][width];
    }
    
    /**
     * Get the value of fields
     *
     * @return the value of fields
     */
    public GridField[][] getFields() {
        return fields;
    }

}
