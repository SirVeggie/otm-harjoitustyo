
import carrots.TurtleRace.Menu;
import java.util.Scanner;
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
        Menu menu = new Menu(new Scanner(System.in));
        
        assertEquals(menu.getDifficulty(), 2);
    }
    
    
}
