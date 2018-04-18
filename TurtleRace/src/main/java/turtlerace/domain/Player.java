package turtlerace.domain;



public class Player {
    private int money;
    private String name;
    
    public Player(String name) {
        this.money = 200;
        this.name = name;
    }
    
    public int getMoney() {
        return this.money;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void changeMoney(int amount) {
        money += amount;
    }
}
