package turtlerace.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private int money;
    private String name;
    private int highscore;
    private List<Integer> scores;
    
    public Player(String name) {
        this.money = 200;
        this.name = name;
        this.highscore = 0;
        this.scores = new ArrayList<>();
    }
    
    
    
    public int getMoney() {
        return this.money;
    }
    
    public void setMoney(int value) {
        money = value;
    }
    
    public void changeMoney(int amount) {
        money += amount;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getHighscore() {
        return highscore;
    }
    
    public void tryHighscore(int highscore) {
        if (highscore > this.highscore) {
            this.highscore = highscore;
        }
    }
    
    public void saveScore() {
        scores.add(money);
        tryHighscore(money);
        
        if (scores.size() > 10) {
            ArrayList<Integer> temp = new ArrayList<>();
            
            for (int i = 1; i <= 5; i++) {
                temp.add(scores.get(scores.size() - i));
            }
            
            scores = temp;
        }
    }
    
    public List<Integer> getScores() {
        return scores;
    }
}
