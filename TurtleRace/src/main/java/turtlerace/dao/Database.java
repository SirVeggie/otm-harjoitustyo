package turtlerace.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database {
    
    private String databaseAddress;
    private String fileAddress;
    String[] tables;
    
    public Database(String databaseAddress) {
        this.databaseAddress = "jdbc:sqlite:" + databaseAddress;
        this.fileAddress = databaseAddress;

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
                    stmt = c.prepareStatement("Select * from " + tableName);
                    stmt.execute();
                    stmt.close();

                } catch (Exception e) {
                    System.out.println("Missing table: " + tableName);
                    System.out.println("Database is not valid");
                    c.close();
                    resetDatabase();
                    break;
                }
            }

            c.close();
        } catch (Exception e) {
            System.out.println("Validity check failed");
        }
    }
    
    /**
     * Deletes the old database file if exists, and creates a new one. Then adds the necessary tables.
     */
    public void resetDatabase() {
        System.out.println("Resetting database");
        
        File current = new File(fileAddress);

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
