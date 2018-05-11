package turtlerace.domain.test;


import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import turtlerace.domain.Turtle;

/**
 *
 * @author SirVeggie
 */
public class TurtleTest {
    
    private Turtle turtle;
    
    @Before
    public void setUp() {
        turtle = new Turtle(0);
    }
    
    @Test
    public void contructorTest() {
        List<Turtle> turtles = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            turtles.add(new Turtle(i));
        }
        
        for (int i = 0; i < 10; i++) {
            Turtle turtlex = turtles.get(i);
            
            int adv = turtlex.getAdvantage();
            assertEquals(true, adv >= 0 && adv <= 4);
            
            int item = turtlex.getSupport();
            assertEquals(true, item >= 0 && item <= 3);
            
            int neutral = turtlex.getNeutral();
            assertEquals(true, neutral >= 0 && neutral <= 4);
            
            int handicap = turtlex.getHandicap();
            assertEquals(true, handicap >= 0 && handicap <= 4);
        }
    }
    
    @Test
    public void checkDescriptionAdvantage() {
        
        String[] desc = turtle.getDescription().split(" \n");
        
        switch (turtle.getAdvantage()) {
            case 0:
                assertEquals("Ability: Speed", desc[0]);
                break;
            case 1:
                assertEquals("Ability: Explosiveness", desc[0]);
                break;
            case 2:
                assertEquals("Ability: Impatience", desc[0]);
                break;
            case 3:
                assertEquals("Ability: Acceleration", desc[0]);
                break;
            case 4:
                assertEquals("Ability: Teleport", desc[0]);
                break;
            default:
                assertEquals("", desc[0]);
                break;
            
        }
    }
    
    @Test
    public void checkDescriptionItem() {
        
        String[] desc = turtle.getDescription().split(" \n");
        
        switch (turtle.getSupport()) {
            case 0:
                assertEquals("Item: Booster", desc[1]);
                break;
            case 1:
                assertEquals("Item: Jumper", desc[1]);
                break;
            case 2:
                assertEquals("Item: Stabilizer", desc[1]);
                break;
            case 3:
                assertEquals("Item: Nothing", desc[1]);
                break;
            default:
                assertEquals("", desc[1]);
                break;
            
        }
    }
    
    @Test
    public void checkDescriptionNeutral() {
        
        String[] desc = turtle.getDescription().split(" \n");
        
        switch (turtle.getNeutral()) {
            case 0:
                assertEquals("Temper: Stable", desc[2]);
                break;
            case 1:
                assertEquals("Temper: Volatile", desc[2]);
                break;
            default:
                assertEquals("Temper: Normal", desc[2]);
                break;
            
        }
    }
    
    @Test
    public void checkDescriptionHandicap() {
        
        String[] desc = turtle.getDescription().split(" \n");
        
        switch (turtle.getHandicap()) {
            case 0:
                assertEquals("Handicap: Slow", desc[3]);
                break;
            case 1:
                assertEquals("Handicap: Absent minded", desc[3]);
                break;
            case 2:
                assertEquals("Handicap: Crippled", desc[3]);
                break;
            case 3:
                assertEquals("Handicap: Weak", desc[3]);
                break;
            case 4:
                assertEquals("Handicap: Unstable", desc[3]);
                break;
            default:
                assertEquals("", desc[3]);
                break;
            
        }
    }
}
