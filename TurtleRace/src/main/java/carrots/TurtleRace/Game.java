package carrots.TurtleRace;

import java.util.Scanner;



public class Game {
    private Scanner scanner;
    
    public Game(Scanner scanner) {
        this.scanner = scanner;
    }
    
    
    
    public void play() {
        while (true) {
            System.out.println("");
            System.out.println("----");
            System.out.println("Work in progress...");
            System.out.println("----");
            System.out.println("");
            System.out.println("Return to Main menu? [yes/no]");
            System.out.println("");
            System.out.print("> ");
            String input = scanner.nextLine();
            
            System.out.println("");
            System.out.println("");

            if (input.equals("yes") || input.equals("y")) {
                break;
            }
        }
    }
}
