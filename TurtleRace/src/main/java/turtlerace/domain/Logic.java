package turtlerace.domain;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import turtlerace.dao.Database;
import turtlerace.dao.HighscoreDao;



public class Logic {
    private Race race;
    private Player player;
    
    private boolean animate;
    private boolean raceReady;
    private int round;
    private int bet;
    private int betTurtle;
    
    private int counter;
    
    private Database database;
    private HighscoreDao scoreDao;
    
    
    
    public Logic() throws ClassNotFoundException {
        database = new Database("jdbc:sqlite:gamedb.db");
        
        try {
            database.checkDatabaseValidity();
        } catch (Exception ex) {
            Logger.getLogger(Logic.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        scoreDao = new HighscoreDao(database);
        
        raceReady = false;
    }
    
    
    
    // Start a new game with a name
    public boolean newSession(String name) {
        if (name.length() > 0 && name.length() < 100) {
            try {
                if (scoreDao.findOne(name) == null) {
                    player = new Player(name);
                    return true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(Logic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return false;
    }
    
    // Exit and save highscore with dao
    public void exitSession() {
        try {
            scoreDao.saveOrUpdate(new Highscore(-1, player.getName(), player.getHighscore()));
        } catch (SQLException ex) {
            Logger.getLogger(Logic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Race specific methods
    public void newRound() {
        race = new Race(5);
        raceReady = true;
        round++;
    }
    
    public boolean nextRound() {
        
        // Checks if it should continue to the next round
        if (round < 5) {
            newRound();
            return true;
        }
        
        return false;
    }
    
    public void endRound() {
        player.saveScore();
        player.setMoney(200);
        round = 0;
    }
    
    public void startRace() {
        animate = true;
        raceReady = false;
        player.changeMoney(-bet);
        counter = 0;
    }
    
    public void endRace(Turtle turtle) {
        //System.out.println("Debug- winner turtle: " + (turtle.getID() + 1));
        //System.out.println("Debug- round: " + round);
        
        if (betTurtle == turtle.getID()) {
            player.changeMoney(bet * 3);
        }
        
        bet = 0;
    }
    
    public boolean checkIfEnoughMoney() {
        if (player.getMoney() > 0) {
            return true;
        }
        
        return false;
    }
    
    public boolean raceStep() {
        //System.out.println("Debug- Step " + race.getStep());
        
        Turtle turtle = race.step();
        if (turtle != null) {
            endRace(turtle);
            return true;
        }
        
        return false;
    }
    
    // Getters and Setters
    public List<Turtle> getTurtles() {
        return race.getTurtles();
    }
    
    public List<Integer> getDistances() {
        return race.getDistances();
    }
    
    public void setBet(Integer bet, int turtle) {
        this.betTurtle = turtle-1;
        this.bet = bet;
    }
    
    public int getBet() {
        return bet;
    }
    
    public int getRound() {
        return round;
    }
    
    public void setRaceReady(boolean value) {
        raceReady = value;
    }
    
    public boolean getRaceReady() {
        return raceReady;
    }
    
    public void setAnimate(boolean value) {
        animate = value;
    }
    
    public boolean getAnimate() {
        return animate;
    }
    
    public Player getPlayer() {
        return player;
    }
    
    // These simplify code a bit
    public List<Integer> getPlayerScores() {
        return player.getScores();
    }
    
    public int getPlayerHighscore() {
        return player.getHighscore();
    }
    
    public String getPlayerName() {
        return player.getName();
    }
    
    public List<Highscore> getHighscores() {
        try {
            return scoreDao.findAll();
        } catch (SQLException ex) {
            Logger.getLogger(Logic.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    // Other logic tools
    public void resetDatabase() {
        try {
            database.resetDatabase();
        } catch (Exception ex) {
            Logger.getLogger(Logic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int counter() {
        counter++;
        
        return counter;
    }
}