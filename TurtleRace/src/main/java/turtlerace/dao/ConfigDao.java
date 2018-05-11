package turtlerace.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ConfigDao {
    private String file;
    
    private int rounds;
    private int turtles;
    
    /**
     * If config file doesn't exist, it creates a template file with the default values. If the file exists, it reads the values and stores them.
     * @param file Filename
     */
    public ConfigDao(String file) {
        this.file = file;
        
        try {
            readFile();
        } catch (FileNotFoundException e) {
            System.out.println("Config missing");
            createFile();
            
            rounds = 5;
            turtles = 5;
        } catch (Exception ex) {
            System.out.println("Cannot read the config file");
        }
        
        System.out.println("Done");
    }
    
    
    public int getRounds() {
        return rounds;
    }
    
    public int getTurtles() {
        return turtles;
    }
    
    
    private void readFile() throws FileNotFoundException, IOException {
        System.out.println("Reading config");
        String line = null;

        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        
        for (int i = 0; (line = br.readLine()) != null; i++) {
            if (checkValues(line, i)) {
                return;
            }
        }

        br.close();
        fr.close();
    }
    private boolean checkValues(String line, int i) {
        if (i == 0) {
            int temp = retrieve(line);
            if (temp < 1) {
                System.out.println("Config value out of bounds");
                createFile();
                return true;
            }
            rounds = temp;
        } else if (i == 1) {
            int temp = retrieve(line);
            if (temp < 3 || temp > 12) {
                System.out.println("Config value out of bounds");
                createFile();
                return true;
            }
            turtles = temp;
        }
        
        return false;
    }
    
    
    private void createFile() {
        System.out.println("Creating config");
        try {
            FileWriter fw = new FileWriter(file);
            fw.write("Rounds=5; (1 ->)" + System.getProperty("line.separator"));
            fw.write("Turtles=5; (3-12)");
            fw.close();
        } catch (Exception ex) {
            System.out.println("Cannot create the config file");
        }
    }
    
    
    private int retrieve(String line) {
        try {
            int start = line.indexOf("=") + 1;
            int end = line.indexOf(";");
            return Integer.valueOf(line.substring(start, end));
        } catch (Exception e) {
            System.out.println("Corrupted config");
            createFile();
            return 5;
        }
    }
}
