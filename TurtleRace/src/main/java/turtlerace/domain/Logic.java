package turtlerace.domain;

import java.util.List;
import turtlerace.dao.*;

public class Logic {
    private Race race;
    private Player player;
    
    private int maxRounds;
    private int maxTurtles;
    
    private boolean animate;
    private boolean raceReady;
    private int round;
    private int bet;
    private int betTurtle;
    
    private int counter;
    
    private Database database;
    private ConfigDao config;
    private HighscoreDao scoreDao;
    
    
    public Logic() {
        database = new Database("jdbc:sqlite:gamedb.db");
        database.checkDatabaseValidity();
        scoreDao = new HighscoreDao(database);
        config = new ConfigDao("config.txt");
        
        raceReady = false;
        
        maxRounds = config.getRounds();
        maxTurtles = config.getTurtles();
    }
    
    
    
    /**
     * Start a new session if the provided name is valid, otherwise does nothing.
     * @param name Player's name
     * @return Returns true if it succeeded and false if it failed.
     */
    public boolean newSession(String name) {
        if (name.length() > 0 && name.length() < 100) {
            if (scoreDao.findOne(name) == null) {
                player = new Player(name);
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Saves the current highscore of the player to the database, if the name isn't taken yet.
     */
    public void exitSession() {
        scoreDao.saveOrUpdate(new Highscore(-1, player.getName(), player.getHighscore()));
    }
    
    
    
    // Race specific methods
    
    /**
     * Creates a new race and increases round count. Enables race buttons.
     */
    public void newRound() {
        race = new Race(maxTurtles);
        raceReady = true;
        round++;
    }
    
    /**
     * Tries to advance to the next round by creating a new race.
     * @return Return true if the next race was created, and false if the current round is already the last round.
     */
    public boolean nextRound() {
        
        // Checks if it should continue to the next round
        if (round < maxRounds) {
            newRound();
            return true;
        }
        
        return false;
    }
    
    /**
     * Saves the player's score into the player's score list. Resets player's money and round count.
     */
    public void endRound() {
        player.saveScore();
        player.setMoney(200);
        round = 0;
    }
    
    /**
     * Subtracts the betted amount from player's money, enables animation, disables race buttons and resets the animation counter.
     */
    public void startRace() {
        animate = true;
        raceReady = false;
        player.changeMoney(-bet);
        counter = 0;
    }
    
    /**
     * Checks if the bet was correct by comparing it to the winner, and gives player the award. Resets the bet.
     * @param turtle Winner turtle
     */
    public void endRace(Turtle turtle) {
        
        if (betTurtle == turtle.getID()) {
            player.changeMoney(bet * 3);
        }
        
        bet = 0;
    }
    
    /**
     * Checks if the player's money is more than 0.
     * @return Returns true if player has money, and false if he doesn't.
     */
    public boolean playerHasMoney() {
        if (player.getMoney() > 0) {
            return true;
        }
        
        return false;
    }
    
    /**
     * Calculates the new positions of the turtles and checks if any of them won the race.
     * @return Returns false if the race continues, and true if the race ended.
     */
    public boolean raceStep() {
        
        Turtle turtle = race.step();
        if (turtle != null) {
            endRace(turtle);
            return true;
        }
        
        return false;
    }
    
    
    
    // Getters and Setters
    public int getMaxRounds() {
        return maxRounds;
    }
    
    public int getMaxTurtles() {
        return maxTurtles;
    }
    
    public List<Turtle> getTurtles() {
        return race.getTurtles();
    }
    
    public List<Integer> getDistances() {
        return race.getDistances();
    }
    
    public void setBet(Integer bet, int turtle) {
        this.betTurtle = turtle - 1;
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
    
    public List<Highscore> getHighscores() {
        return scoreDao.findAll();
    }
    
    
    
    // Other logic tools
    
    /**
     * Deletes the old database and creates a new one with the necessary tables.
     */
    public void resetDatabase() {
        database.resetDatabase();
    }
    
    /**
     * Adds one to the counter, then returns the counter value.
     * @return Returns the current counter value.
     */
    public int counter() {
        counter++;
        
        return counter;
    }
}