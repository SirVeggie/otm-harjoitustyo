
import carrots.TurtleRace.Menu;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author SirVeggie
 */
public class MainTest {
    
    @Test
    public void test1() {
        Menu menu2 = new Menu();
        
        assertEquals(menu2.getDifficulty(), 1);
    }
}
