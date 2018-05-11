package turtlerace.domain.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import turtlerace.domain.Logic;
import turtlerace.domain.Player;
import turtlerace.domain.Turtle;

public class LogicTest {
    private Logic logic;
    
    @AfterClass
    public static void deleteTestFiles() {
        try {
            File file = new File("Test.txt");
            Files.deleteIfExists(file.toPath());
            
            file = new File("Test.db");
            Files.deleteIfExists(file.toPath());
        } catch (Exception ex) { }
    }
    
    @Before
    public void setUp() {
        logic = new Logic("Test");
    }
    
    @Test
    public void testCounter() {
        assertEquals(logic.counter(), 1);
        
        assertEquals(logic.counter(), 2);
        
        assertEquals(logic.counter(), 3);
    }
    
    @Test
    public void testPlayerHasMoney() {
        logic.setPlayer(new Player("jack"));
        
        assertEquals(true, logic.playerHasMoney());
    }
    
    @Test
    public void testPlayerHasMoneyNot() {
        Player temp = new Player("jack");
        temp.setMoney(0);
        logic.setPlayer(temp);
        
        assertEquals(false, logic.playerHasMoney());
    }
    
    @Test
    public void testEndRaceRight() {
        Player temp = new Player("jack");
        temp.setMoney(0);
        logic.setPlayer(temp);
        
        logic.setBet(100, 0);
        
        Turtle turtle = new Turtle(0);
        
        logic.endRace(turtle);
        
        assertEquals(300, logic.getPlayer().getMoney());
        assertEquals(0, logic.getBet());
    }
    
    @Test
    public void testEndRaceWrong() {
        Player temp = new Player("jack");
        temp.setMoney(0);
        logic.setPlayer(temp);
        
        logic.setBet(100, 0);
        
        Turtle turtle = new Turtle(1);
        
        logic.endRace(turtle);
        
        assertEquals(0, logic.getPlayer().getMoney());
        assertEquals(0, logic.getBet());
    }
    
    @Test
    public void testStartRace() {
        logic.setPlayer(new Player("jack"));
        
        for (int i = 0; i < 5; i++) {
            logic.counter();
        }
        logic.setAnimate(false);
        logic.setRaceReady(true);
        logic.setBet(100, 0);
        
        logic.startRace();
        
        assertEquals(true, logic.getAnimate());
        assertEquals(false, logic.getRaceReady());
        assertEquals(1, logic.counter());
        assertEquals(100, logic.getPlayer().getMoney());
    }
    
    @Test
    public void testEndRound() {
        Player tempPlayer = new Player("jack");
        tempPlayer.setMoney(50);
        logic.setPlayer(tempPlayer);
        logic.nextRound();
        
        logic.endRound();
        
        assertEquals(200, logic.getPlayer().getMoney());
        
        List<Integer> scores = logic.getPlayer().getScores();
        
        int tempInt = scores.get(scores.size() - 1);
        assertEquals(50, tempInt);
        
        assertEquals(0, logic.getRound());
    }
    
    @Test
    public void testNewRound() {
        int tempInt = logic.getRound();
        
        logic.newRound();
        
        assertEquals(tempInt + 1, logic.getRound());
        
        List<Integer> tempList = logic.getDistances();
        
        assertEquals(logic.getMaxRounds(), tempList.size());
        for (int i = 0; i < tempList.size(); i++) {
            int tempVal = tempList.get(i);
            assertEquals(0, tempVal);
        }
    }
    
    @Test
    public void testNextRound() {
        assertEquals(true, logic.nextRound());
        assertEquals(true, logic.getRaceReady());
    }
    
    @Test
    public void testNextRoundMax() {
        for (int i = 0; i < logic.getMaxRounds(); i++) {
            logic.nextRound();
        }
        
        assertEquals(false, logic.nextRound());
    }
    
    @Test
    public void testNewSessionShort() {
        assertEquals(false, logic.newSession(""));
    }
    
    @Test
    public void testNewSessionLong() {
        String longAssString = "12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890";
        
        assertEquals(false, logic.newSession(longAssString));
    }
    
    @Test
    public void testSameNameUse() {
        logic.setPlayer(new Player("jack"));
        
        logic.exitSession();
        
        assertEquals(false, logic.newSession("jack"));
    }
    
    @Test
    public void testNewNameUse() {
        logic.deleteScore("bob");
        
        assertEquals(true, logic.newSession("bob"));
    }
}
