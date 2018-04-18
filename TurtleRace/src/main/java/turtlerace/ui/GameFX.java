package turtlerace.ui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameFX extends Application {
    private int random;
    
    public void play(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) {
        stage.setTitle("Turtle Race");
        
        // Scenes
        BorderPane mainpane = new BorderPane();
        BorderPane gamepane = new BorderPane();
        
        // Main menu
        VBox button_list_main = new VBox();
        
        Button new_btn = new Button("New game");
        Button continue_btn = new Button("Continue");
        Button exit_btn = new Button("Exit");
        
        new_btn.setMaxWidth(120);
        continue_btn.setMaxWidth(120);
        exit_btn.setMaxWidth(120);
        
        button_list_main.getChildren().add(new_btn);
        button_list_main.getChildren().add(continue_btn);
        button_list_main.getChildren().add(exit_btn);
        
        mainpane.setCenter(button_list_main);
        
        // Game menu
        VBox button_list_game = new VBox();
        
        Button play_btn = new Button("Play a round");
        Button save_btn = new Button("Save");
        Button load_btn = new Button("Load");
        Button statistics_btn = new Button("Statistics");
        Button mainmenu_btn = new Button("Exit to main menu");
        
        play_btn.setMaxWidth(120);
        save_btn.setMaxWidth(120);
        load_btn.setMaxWidth(120);
        statistics_btn.setMaxWidth(120);
        mainmenu_btn.setMaxWidth(120);
        
        button_list_game.getChildren().add(play_btn);
        button_list_game.getChildren().add(save_btn);
        button_list_game.getChildren().add(load_btn);
        button_list_game.getChildren().add(statistics_btn);
        button_list_game.getChildren().add(mainmenu_btn);
        
        gamepane.setCenter(button_list_game);
        
        
        
        Scene main_menu = new Scene(mainpane, 1280, 720);
        Scene game_menu = new Scene(gamepane, 1280, 720);
        
        stage.setScene(main_menu);
        stage.show();
        
        
        
        
        // Main menu actions
        new_btn.setOnAction((ActionEvent event) -> {
            // Start fresh with dao commands
            stage.setScene(game_menu);
        });
        
        continue_btn.setOnAction((ActionEvent event) -> {
            // Load a saved game with dao
        });
        
        exit_btn.setOnAction((ActionEvent event) -> {
            Platform.exit();
        });
        
        
        
        // Game menu actions
        play_btn.setOnAction((ActionEvent event) -> {
            // start some actual gameplay
        });
        
        save_btn.setOnAction((ActionEvent event) -> {
            // Save the game with dao
        });
        
        load_btn.setOnAction((ActionEvent event) -> {
            // Load a saved game with dao
        });
        
        statistics_btn.setOnAction((ActionEvent event) -> {
            // Show stats of the current game
        });
        
        mainmenu_btn.setOnAction((ActionEvent event) -> {
            // Save the game with dao
            stage.setScene(main_menu);
        });
    }
}
