package turtlerace.dao.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import turtlerace.dao.Database;
import turtlerace.dao.HighscoreDao;
import turtlerace.domain.Highscore;

/**
 *
 * @author Carrot
 */
public class HighscoreDaoTest {
    private Database database;
    private HighscoreDao scoreDao;
    
    @AfterClass
    public static void tearDownClass() {
        try {
            File file = new File("Test.txt");
            Files.deleteIfExists(file.toPath());
            
            file = new File("Test.db");
            Files.deleteIfExists(file.toPath());
        } catch (Exception ex) { }
    }
    
    @Before
    public void setUp() {
        database = new Database("Test.db");
        scoreDao = new HighscoreDao(database);
        database.resetDatabase();
    }
    
    @Test
    public void testAdding() {
        scoreDao.saveOrUpdate(new Highscore(0, "Gorgon", 100));
        
        Highscore score = scoreDao.findOne("Gorgon");
        if (score != null) {
            assertEquals(100, score.getScore());
        } else {
            assertNotEquals(null, score);
        }
    }
    
    @Test
    public void testDelete() {
        scoreDao.saveOrUpdate(new Highscore(0, "Hermes", 700));
        scoreDao.delete("Hermes");
        
        Highscore score = scoreDao.findOne("Hermes");
        assertEquals(null, score);
    }
    
    @Test
    public void testList() {
        scoreDao.saveOrUpdate(new Highscore(0, "Yvenne", 700));
        scoreDao.saveOrUpdate(new Highscore(0, "April", 75));
        
        List<Highscore> scores = scoreDao.findAll();
        assertEquals("Yvenne", scores.get(0).getName());
        assertEquals(75, scores.get(1).getScore());
    }
}
