package turtlerace.domain.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import turtlerace.domain.RaceLogic;
import turtlerace.domain.Turtle;

public class RaceLogicTest {
    
    @Before
    public void setUp() {
    }
    
    @Test
    public void testApplyingVolatile() {
        int neutral = 1;
        
        Turtle turtle = new Turtle(0);
        turtle.setAdvantage(0);
        turtle.setSupport(1);
        turtle.setNeutral(neutral);
        turtle.setHandicap(4);
        
        RaceLogic rlogic = new RaceLogic();
        
        int move = rlogic.apply01x4(0, neutral);
        int realMove = rlogic.moveTurtle(0, turtle);
        assertEquals(move, realMove);
        
        move = rlogic.apply01x4(10, neutral);
        realMove = rlogic.moveTurtle(10, turtle);
        assertEquals(move, realMove);
        
        move = rlogic.apply01x4(50, neutral);
        realMove = rlogic.moveTurtle(50, turtle);
        assertEquals(move, realMove);
    }
    
    @Test
    public void testApplyingStable() {
        int neutral = 0;
        
        Turtle turtle = new Turtle(0);
        turtle.setAdvantage(0);
        turtle.setSupport(1);
        turtle.setNeutral(neutral);
        turtle.setHandicap(4);
        
        RaceLogic rlogic = new RaceLogic();
        
        int move = rlogic.apply01x4(0, neutral);
        int realMove = rlogic.moveTurtle(0, turtle);
        assertEquals(move, realMove);
        
        move = rlogic.apply01x4(10, neutral);
        realMove = rlogic.moveTurtle(10, turtle);
        assertEquals(move, realMove);
        
        move = rlogic.apply01x4(50, neutral);
        realMove = rlogic.moveTurtle(50, turtle);
        assertEquals(move, realMove);
    }
    
    @Test
    public void testApplyingNormal() {
        int neutral = 2;
        
        Turtle turtle = new Turtle(0);
        turtle.setAdvantage(0);
        turtle.setSupport(1);
        turtle.setNeutral(neutral);
        turtle.setHandicap(4);
        
        RaceLogic rlogic = new RaceLogic();
        
        int move = rlogic.apply01x4(0, neutral);
        int realMove = rlogic.moveTurtle(0, turtle);
        assertEquals(move, realMove);
        
        move = rlogic.apply01x4(10, neutral);
        realMove = rlogic.moveTurtle(10, turtle);
        assertEquals(move, realMove);
        
        move = rlogic.apply01x4(50, neutral);
        realMove = rlogic.moveTurtle(50, turtle);
        assertEquals(move, realMove);
    }
}
