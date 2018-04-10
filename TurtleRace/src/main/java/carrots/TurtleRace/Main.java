
package carrots.TurtleRace;

import java.util.Scanner;



public class Main {
    
    
    public static void main(String[] args) {
        System.out.println("Game start");
        
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(scanner);
        Game game = new Game(scanner);
        
        // Game Loop
        while (true) {
            
            // Menu
            if (menu.enterMenu() == 3) {
                // Player chose to exit game
                break;
            }
            
            // Player chose "Play"
            game.play();
        }
        
        System.out.println("Game end");
    }
}
