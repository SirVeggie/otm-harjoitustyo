
package turtlerace.domain;

import java.util.Scanner;
import turtlerace.ui.GameFX;
import turtlerace.ui.Launcher;



public class Main {
    
    
    public static void main(String[] args) {
        System.out.println("Game start");
        
        Scanner scanner = new Scanner(System.in);
        Launcher menu = new Launcher(scanner);
        GameFX game = new GameFX();
        
        
        // Launcher
        if (menu.enterLauncher() == 1) {
            // Player chose to start game
            game.play(args);
        }
        
        System.out.println("Game end");
    }
}
