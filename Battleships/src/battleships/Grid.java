/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleships;

import java.io.Serializable;

/**
 *
 * @author Rafael Stalder, Damian Schilter, Lucas Schnüriger, Dominik Zgraggen
 */
public abstract class Grid implements Serializable {

    private GridField[][] fields;

    public Grid(int width, int height) {
        fields = new GridField[height][width];
        for(int x = 0; x < height; x++) {
            for(int y = 0; y < width; y++) {
                fields[x][y] = new GridField();
            }
        }
    }
    
    /**
     * Get the value of fields
     *
     * @return the value of fields
     */
    public GridField[][] getFields() {
        return fields;
    }
    
    /**
     * Sert the value of fields
     * @param fields new 2-dimensional Array of GridFields
     */
    public void setFields(GridField[][] fields) {
        this.fields = fields;
    }
    
    /**
     * Get a Field specified by its x and y coordinates
     * @param xCoord
     * @param yCoord
     * @return Field at specified position
     */
    public GridField getField(int xCoord, int yCoord) {
        return fields[xCoord][yCoord];
    }
}
