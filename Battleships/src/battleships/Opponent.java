/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleships;

import java.net.Socket;
import java.

/**
 *
 * @author Rafael Stalder, Damian Schilter, Lucas Schnüriger, Dominik Zgraggen
 */
public class Opponent implements Serializable{
   private GameControl gameControl;
   private Socket clientSocket;
   private GameHost gameHost;
   private Reader in;
   private Writer out;
   
    public Opponent(GameControl gameControl){
        this.gameControl = gameControl;
        this.gameHost = new GameHost();
    }
    
    public GameHost getGameHost(){
        return gameHost;
    }
}
