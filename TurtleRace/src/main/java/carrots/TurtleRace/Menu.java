package carrots.TurtleRace;

/**
 *
 * @author SirVeggie
 */
public class Menu {
    // Difficulty 0-2
    private int difficulty;
    private boolean developerMode;
    
    public Menu() {
        this.difficulty = 1;
        this.developerMode = false;
    }
    
    public int getDifficulty() {
        return this.difficulty;
    }
    
    public boolean getDevMode() {
        return this.developerMode;
    }
}
