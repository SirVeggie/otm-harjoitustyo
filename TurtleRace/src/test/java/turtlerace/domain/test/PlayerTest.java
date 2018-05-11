package turtlerace.domain.test;


import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import turtlerace.domain.Player;

/**
 *
 * @author SirVeggie
 */
public class PlayerTest {
    
    private Player player;
    
    @Before
    public void setUp() {
        player = new Player("test");
    }
    
    @Test
    public void moneyAdd() {
        player.changeMoney(20);
        
        assertEquals(220, player.getMoney());
    }
    
    @Test
    public void moneySubstract() {
        player.changeMoney(-20);
        
        assertEquals(180, player.getMoney());
    }
    
    
    
    @Test
    public void highscoreSavingMore() {
        player.tryHighscore(100);
        
        assertEquals(100, player.getHighscore());
    }
    
    @Test
    public void highscoreSavingLess() {
        player.tryHighscore(100);
        
        player.tryHighscore(5);
        
        assertEquals(100, player.getHighscore());
    }
    
    @Test
    public void highscoreSavingNeg() {
        player.tryHighscore(-200);
        
        assertEquals(0, player.getHighscore());
    }
    
    
    
    @Test
    public void scoreSaving() {
        player.setMoney(100);
        player.saveScore();
        player.setMoney(500);
        player.saveScore();
        
        List<Integer> tempList = player.getScores();
        int tempInt = tempList.get(tempList.size() - 1);
        int tempInt2 = tempList.get(tempList.size() - 2);
        
        assertEquals(500, tempInt);
        assertEquals(100, tempInt2);
    }
    
    @Test
    public void scoreSavingBigList() {
        for (int i = 1; i <= 10; i++) {
            player.setMoney(i * 100);
            player.saveScore();
        }
        
        List<Integer> tempList = player.getScores();
        int tempInt = tempList.get(tempList.size() - 1);
        int tempInt2 = tempList.get(0);
        
        assertEquals(1000, tempInt);
        assertEquals(100, tempInt2);
        assertEquals(10, tempList.size());
    }
    
    @Test
    public void scoreSavingListReset() {
        for (int i = 1; i <= 11; i++) {
            player.setMoney(i * 100);
            player.saveScore();
        }
        
        List<Integer> tempList = player.getScores();
        int tempInt = tempList.get(tempList.size() - 1);
        int tempInt2 = tempList.get(0);
        
        assertEquals(1100, tempInt);
        assertEquals(700, tempInt2);
        assertEquals(5, tempList.size());
    }
}
