package turtlerace.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import turtlerace.domain.Highscore;



public class HighscoreDao implements Dao<Highscore, String> {

    private Database database;
    
    public HighscoreDao(Database database) {
        this.database = database;
    }
    
    /**
     * Finds the highscore of the user.
     * @param name Name of the user
     * @return The found data is compiled into a Highscore type form.
     */
    @Override
    public Highscore findOne(String name) {
        try {
            database.checkDatabaseValidity();
            Class.forName("org.sqlite.JDBC");
        } catch (Exception ex) { }
        
        try {
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
        } catch (Exception e) {
            System.out.println("SQL exception in findOne method");
        }
        
        return null;
    }

    /**
     * Gets all the highscores in the save file in order from highest score to lowest.
     * @return Returns a list of Highscore type objects in descending order based on the score.
     */
    @Override
    public List<Highscore> findAll() {
        try {
            database.checkDatabaseValidity();
            Class.forName("org.sqlite.JDBC");
        } catch (Exception ex) { }
        
        try {
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
        } catch (Exception e) {
            System.out.println("SQL exception in findAll method");
        }
        
        return null;
    }

    /**
     * Saves the score into the save file by the user name if the name isn't already in the database.
     * @param score The Highscore data that is being saved.
     * @return Returns the Highscore that was saved. Null if nothing was saved.
     */
    @Override
    public Highscore saveOrUpdate(Highscore score) {
        if (findOne(score.getName()) != null) {
            System.out.println("QUERY WAS NOT EXECUTED!");;
            return null;
        }
        
        database.checkDatabaseValidity();
        
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (Exception ex) { }
        
        try {
            Connection conn = database.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Highscore (name, money) VALUES (?,?)");
            stmt.setObject(1, score.getName());
            stmt.setObject(2, score.getScore());

            stmt.executeUpdate();
            stmt.close();
            conn.close();

            return score;
        } catch (Exception e) {
            System.out.println("SQL exception in saveOrUpdate method");
        }
        
        return null;
    }

    /**
     * Deletes the score from the database based on the name attached to it.
     * @param name User's name
     */
    @Override
    public void delete(String name) {
        // Does the title exist?
        if (findOne(name) == null) {
            System.out.println("QUERY WAS NOT EXECUTED!");;
        }
        
        database.checkDatabaseValidity();
        
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (Exception ex) { }
        
        try {
            Connection conn = database.getConnection();
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM Highscore WHERE name = ?");
            stmt.setObject(1, name);

            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("SQL exception in delete method");
        }   
    }
}
