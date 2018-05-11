package turtlerace.domain;



public class Turtle {
    private int id;
    private int advantage;
    private int support;
    private int neutral;
    private int handicap;
    
    public Turtle(int id) {
        this.id = id;
        
        // Randomize attributes
        advantage = (int) (Math.random() * 5);
        support = (int) (Math.random() * 4);
        neutral = (int) (Math.random() * 5);
        handicap = (int) (Math.random() * 5);
    }
    
    
    
    public int getID() {
        return id;
    }
    
    public int getAdvantage() {
        return advantage;
    }
    
    public int getSupport() {
        return support;
    }
    
    public int getNeutral() {
        return neutral;
    }
    
    public int getHandicap() {
        return handicap;
    }
    
    
    /**
     * Compiles the turtle's attributes/info into a single string.
     * @return Returns the turtle's attributes/information as a string.
     */
    public String getDescription() {
        String desc = "";
        
        desc += applyAdvantageDesc();
        
        desc += applySupportDesc();
        
        desc += applyNeutralDesc();
        
        desc += applyDisadvantageDesc();
        
        return desc;
    }
    
    private String applyAdvantageDesc() {
        String desc = "Ability: ";
        
        switch (advantage) {
            case 0:
                desc += "Speed \n";
                break;
            case 1:
                desc += "Explosiveness \n";
                break;
            case 2:
                desc += "Impatience \n";
                break;
            case 3:
                desc += "Acceleration \n";
                break;
            case 4:
                desc += "Teleport \n";
                break;
            default:
                desc += "error, " + advantage + " \n";
                break;
        }
        
        return desc;
    }
    
    private String applySupportDesc() {
        String desc = "Item: ";
        
        switch (support) {
            case 0:
                desc += "Booster \n";
                break;
            case 1:
                desc += "Jumper \n";
                break;
            case 2:
                desc += "Stabilizer \n";
                break;
            case 3:
                desc += "Nothing \n";
                break;
            default:
                desc += "error, " + support + " \n";
                break;
        }
        
        return desc;
    }
    
    private String applyNeutralDesc() {
        String desc = "Temper: ";
        
        switch (neutral) {
            case 0:
                desc += "Stable \n";
                break;
            case 1:
                desc += "Volatile \n";
                break;
            default:
                desc += "Normal \n";
                break;
        }
        
        return desc;
    }
    
    private String applyDisadvantageDesc() {
        String desc = "Handicap: ";
        
        switch (handicap) {
            case 0:
                desc += "Slow";
                break;
            case 1:
                desc += "Absent minded";
                break;
            case 2:
                desc += "Crippled";
                break;
            case 3:
                desc += "Weak";
                break;
            case 4:
                desc += "Unstable";
                break;
            default:
                desc += "error, " + handicap;
                break;
        }
        
        return desc;
    }
}
