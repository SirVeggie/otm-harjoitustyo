package turtlerace.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database {
    
    private String databaseAddress;
    String[] tables;
    
    public Database(String databaseAddress) {
        this.databaseAddress = databaseAddress;

        //Default tables
        tables = new String[1];
        tables[0] = "Highscore (id integer PRIMARY KEY, name varchar(100), money integer);";
    }
    
    /**
     * Get connection to the driver manager.
     * @return Returns the connection
     */
    public Connection getConnection() {
        try {
            return DriverManager.getConnection(databaseAddress);
        } catch (SQLException ex) { }
        return null;
    }
    
    /**
     * Checks if the database file exists, and if the file has the necessary tables.
     */
    public void checkDatabaseValidity() {

        System.out.println("Checking database validity:");
        
        try {
            Class.forName("org.sqlite.JDBC");
            
            Connection c;
            PreparedStatement stmt;
            try {
                c = getConnection();
                stmt = null;
            } catch (Exception e) {
                resetDatabase();
                return;
            }
            for (String table : tables) {
                String tableName = table.split(" ")[0];
                try {
                    System.out.println("Checking tables");
                    stmt = c.prepareStatement("Select * from " + tableName);
                    stmt.execute();
                    stmt.close();

                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                    System.out.println("Missing table: " + tableName);
                    System.out.println("Database is not valid. Resetting database...");
                    System.out.println("");
                    c.close();
                    resetDatabase();
                    break;
                }
            }

            c.close();
            System.out.println("Database is valid.");
        } catch (Exception e) {
            System.out.println("Validity check failed.");
        }
    }
    
    /**
     * Deletes the old database file if exists, and creates a new one. Then adds the necessary tables.
     */
    public void resetDatabase() {
        System.out.println("Resetting database");
        
        File current = new File("gamedb.db");

        current.delete();
        
        try {
            Class.forName("org.sqlite.JDBC");
            
            Connection c = getConnection();
            PreparedStatement stmt = null;

            //Create new tables
            for (String table : tables) {
                String[] split = table.split(" ");
                System.out.println("Creating table: " + split[0]);
                stmt = c.prepareStatement("CREATE TABLE " + table);
                stmt.execute();
                stmt.close();
            }

            c.close();
        } catch (Exception e) { }
    }
}
