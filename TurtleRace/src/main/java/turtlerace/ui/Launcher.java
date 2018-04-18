package turtlerace.ui;

import java.util.Scanner;

/**
 *
 * @author SirVeggie
 */
public class Launcher {
    // Difficulty 1-3
    private int difficulty;
    private boolean developerMode;
    private Scanner scanner;
    
    public Launcher(Scanner scanner) {
        this.difficulty = 2;
        this.developerMode = false;
        this.scanner = scanner;
    }
    
    public int getDifficulty() {
        return this.difficulty;
    }
    
    public boolean getDevMode() {
        return this.developerMode;
    }
    
    
    public int enterLauncher() {
        int input = 0;
        
  menu: while (true) {
            input = -1;
            
            System.out.println("Welcome to the Turtle Race");
            System.out.println("");
            System.out.println("~ Start[1] ~");
            System.out.println("~ Settings[2] ~");
            System.out.println("~ Exit[3] ~");
            System.out.println("");
            System.out.print("> ");
            String rawInput = scanner.nextLine();
            System.out.println("");
            System.out.println("");
            
            try {
                input = Integer.parseInt(rawInput);
            } catch (Exception e) {
                System.out.println("Bad input  :(");
                System.out.println("");
                System.out.println("");
                continue;
            }
            
            if (input == 2) {
                while (true) {
                    String devMode;
                    if (developerMode) {
                        devMode = "on";
                    } else {
                        devMode = "off";
                    }
                    
                    System.out.println("Settings");
                    System.out.println("");
                    System.out.println("~ Difficulty[1]      - " + difficulty + " -");
                    System.out.println("~ Developer Mode[2]  - " + devMode + " -");
                    System.out.println("~ Back[3]");
                    System.out.println("");
                    System.out.print("> ");
                    rawInput = scanner.nextLine();
                    System.out.println("");
                    System.out.println("");

                    try {
                        input = Integer.parseInt(rawInput);
                    } catch (Exception e) {
                        System.out.println("Bad input  :(");
                        System.out.println("");
                        System.out.println("");
                        continue;
                    }

                    if (input == 3) {
                        break;
                    }
                    else if (input == 2) {
                        
                        if (developerMode) {
                            developerMode = false;
                        } else {
                            developerMode = true;
                        }
                    }
                    else if (input == 1) {
                        
                        difficulty++;
                        if (difficulty > 3) {
                            difficulty = 1;
                        }
                    }
                }
            } else {
                break;
            }
        }
        
        return input;
    }
}
