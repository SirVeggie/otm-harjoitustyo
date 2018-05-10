package turtlerace.domain;



public class Highscore {
    private int id;
    private String name;
    // score/score
    private int score;
    
    public Highscore(int id, String name, int money) {
        this.id = id;
        this.name = name;
        this.score = money;
    }
    
    
    
    public void setID(int id) {
        this.id = id;
    }
    
    public int getID() {
        return id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setScore(int money) {
        this.score = money;
    }
    
    public int getScore() {
        return score;
    }
}
