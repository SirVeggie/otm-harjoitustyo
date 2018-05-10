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
    
    public Turtle step() {
        for (int i = 0; i < turtleList.size(); i++) {
            int distance = distances.get(i);
            
            distance += raceLogic.moveTurtle(step, turtleList.get(i));
            
            distances.set(i, distance);
        }
        step++;
        
        return end();
    }
    
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
}
