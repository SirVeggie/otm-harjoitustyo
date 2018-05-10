package turtlerace.domain;



public class Turtle {
    private int ID;
    private int distance;
    public int advantage;
    public int support;
    public int neutral;
    public int disadvantage;
    
    public Turtle(int ID) {
        this.ID = ID;
        
        // Randomize attributes
        advantage = (int) (Math.random() * 5);
        support = (int) (Math.random() * 4);
        neutral = (int) (Math.random() * 5);
        disadvantage = (int) (Math.random() * 5);
    }
    
    
    
    public int getID() {
        return ID;
    }
    
    public int getDistance() {
        return distance;
    }
    
    public void setDistance(int value) {
        distance = value;
    }
    
    public void addDistance(int value) {
        distance += value;
    }
    
    
    
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
        
        switch (disadvantage) {
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
                desc += "error, " + disadvantage;
                break;
        }
        
        return desc;
    }
}
