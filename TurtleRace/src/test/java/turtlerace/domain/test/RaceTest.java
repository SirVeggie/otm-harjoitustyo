package turtlerace.domain.test;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import turtlerace.domain.Race;
import turtlerace.domain.Turtle;

/**
 *
 * @author Carrot
 */
public class RaceTest {
    
    private Race race;
    
    @Before
    public void setUp() {
        race = new Race(5);
    }
    
    @Test
    public void testConstructorDistance() {
        List<Integer> dist = race.getDistances();
        
        for (int i = 0; i < dist.size(); i++) {
            int temp = dist.get(i);
            assertEquals(0, temp);
        }
    }
    
    @Test
    public void testConstructorTurtles() {
        List<Turtle> dist = race.getTurtles();
        
        for (int i = 0; i < dist.size(); i++) {
            Turtle temp = dist.get(i);
            assertEquals(i, temp.getID());
        }
    }
    
    
    
    @Test
    public void testEndNoWin() {
        assertEquals(null, race.step());
    }
    
    @Test
    public void testEndWin() {
        List<Integer> distances = race.getDistances();
        distances.set(0, 100);
        distances.set(1, 600);
        
        race.setDistances(distances);
        
        assertEquals(1, race.step().getID());
    }
    
    @Test
    public void testEndWin2() {
        List<Integer> distances = race.getDistances();
        distances.set(0, 700);
        distances.set(1, 0);
        
        race.setDistances(distances);
        
        assertEquals(0, race.step().getID());
    }
}
