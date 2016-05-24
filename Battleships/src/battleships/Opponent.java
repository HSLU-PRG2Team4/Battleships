/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleships;

import java.net.Socket;

/**
 *
 * @author Rafael Stalder, Damian Schilter, Lucas Schnüriger, Dominik Zgraggen
 */
public class Opponent {
   private GameControl gameControl;
   private Socket clientSocket;
   private GameHost gameHost;
   
    public Opponent(GameControl gameControl){
        this.gameControl = gameControl;
        this.gameHost = new GameHost();
    }
    
    public GameHost getGameHost(){
        return gameHost;
    }
}
