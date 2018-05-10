
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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
    public void executedBeforeEach() {
        player = new Player("test");
    }
    
    @Test
    public void moneyAdd() {
        player.changeMoney(20);
        
        assertEquals(player.getMoney(), 220);
    }
    
    @Test
    public void moneySubstract() {
        player.changeMoney(-20);
        
        assertEquals(player.getMoney(), 180);
    }
}
