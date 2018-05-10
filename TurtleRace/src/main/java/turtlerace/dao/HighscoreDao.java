package turtlerace.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import turtlerace.domain.Highscore;



public class HighscoreDao implements Dao<Highscore, String> {

    private Database database;
    
    public HighscoreDao(Database database) {
        this.database = database;
    }
    
    @Override
    public Highscore findOne(String name) throws SQLException {
        try {
            database.checkDatabaseValidity();
            Class.forName("org.sqlite.JDBC");
        } catch (Exception ex) {
            //Logger.getLogger(HighscoreDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Connection conn = database.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Highscore WHERE Highscore.name = ?");
        stmt.setObject(1, name);
        ResultSet rs = stmt.executeQuery();

        // If empty
        if (!rs.next()) {
            rs.close();
            stmt.close();
            conn.close();
            return null;
        }

        Highscore score = new Highscore(rs.getInt("id"),
                rs.getString("name"),
                rs.getInt("money"));
        
        rs.close();
        stmt.close();
        conn.close();

        return score;
    }

    @Override
    public List<Highscore> findAll() throws SQLException {
        try {
            database.checkDatabaseValidity();
            Class.forName("org.sqlite.JDBC");
        } catch (Exception ex) {
            //Logger.getLogger(HighscoreDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Connection conn = database.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Highscore Order By Highscore.money DESC");
        ResultSet rs = stmt.executeQuery();

        List<Highscore> scores = new ArrayList<>();

        while (rs.next()) {
            Highscore score = new Highscore(rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("money"));
            
            scores.add(score);
        }

        rs.close();
        stmt.close();
        conn.close();

        return scores;
    }

    @Override
    public Highscore saveOrUpdate(Highscore score) throws SQLException {
        if (findOne(score.getName()) != null) {
            System.out.println("QUERY WAS NOT EXECUTED!");;
            return null;
        }
        
        try {
            database.checkDatabaseValidity();
            Class.forName("org.sqlite.JDBC");
        } catch (Exception ex) {
            //Logger.getLogger(HighscoreDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Connection conn = database.getConnection();
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO Highscore (name, money) VALUES (?,?)");
        stmt.setObject(1, score.getName());
        stmt.setObject(2, score.getScore());
        
        stmt.executeUpdate();
        stmt.close();
        conn.close();
        
        return score;
    }

    @Override
    public void delete(String name) throws SQLException {
        // Does the title exist?
        if (findOne(name) == null) {
            System.out.println("QUERY WAS NOT EXECUTED!");;
        }
        
        try {
            database.checkDatabaseValidity();
            Class.forName("org.sqlite.JDBC");
        } catch (Exception ex) {
            //Logger.getLogger(HighscoreDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Connection conn = database.getConnection();
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM Highscore WHERE Highscore.name = " + name);
        
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }
    
}
