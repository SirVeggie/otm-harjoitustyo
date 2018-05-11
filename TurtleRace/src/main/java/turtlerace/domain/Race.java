package turtlerace.domain;

import java.util.ArrayList;
import java.util.List;



public class Race {
    private List<Turtle> turtleList;
    private List<Integer> distances;
    private int step;
    private RaceLogic raceLogic;
    
    public Race(int turtles) {
        this.turtleList = new ArrayList<>();
        for (int i = 0; i < turtles; i++) {
            Turtle turtle = new Turtle(i);
            turtleList.add(turtle);
        }
        
        this.distances = new ArrayList<>();
        for (int i = 0; i < turtles; i++) {
            distances.add(0);
        }
        
        step = 1;
        raceLogic = new RaceLogic();
    }
    
    /**
     * Moves each turtle according to their attributes by changing their progress value (distance). Also checks if the game has ended.
     * @return If the game ends, the winning turtle is returned. Otherwise returns null.
     */
    public Turtle step() {
        for (int i = 0; i < turtleList.size(); i++) {
            int distance = distances.get(i);
            
            distance += raceLogic.moveTurtle(step, turtleList.get(i));
            
            distances.set(i, distance);
        }
        step++;
        
        return end();
    }
    
    /**
     * Checks whether the race has ended or not.
     * @return Returns the winning turtle if race ends, else returns null.
     */
    private Turtle end() {
        for (int i = 0; i < distances.size(); i++) {
            if (distances.get(i) > 400) {
                return turtleList.get(i);
            }
        }
        
        return null;
    }
    
    public List<Turtle> getTurtles() {
        return turtleList;
    }
    
    public List<Integer> getDistances() {
        return distances;
    }
    
    public int getStep() {
        return step;
    }
    
    
    // Test methods
    public void setDistances(List<Integer> distances) {
        this.distances = distances;
    }
}
