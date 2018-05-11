
package turtlerace.ui;

import turtlerace.ui.GameFX;

public class Main {
    
    public static void main(String[] args) throws ClassNotFoundException {
        
        System.out.println("Game start");
        
        GameFX game = new GameFX();
        
        game.play(args);
        
        System.out.println("");
        System.out.println("Game end");
    }
}
