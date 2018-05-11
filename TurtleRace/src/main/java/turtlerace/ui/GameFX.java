package turtlerace.ui;

import java.util.ArrayList;
import java.util.List;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import turtlerace.domain.Highscore;
import turtlerace.domain.Logic;
import turtlerace.domain.Player;
import turtlerace.domain.Turtle;

public class GameFX extends Application {
    
    public void play(String[] args) throws ClassNotFoundException {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws ClassNotFoundException {
        stage.setTitle("Turtle Race");
        
        Logic logic = new Logic();
        
        // Scenes
        HBox mainPane = new HBox();
        HBox gamePane = new HBox();
        HBox namePane = new HBox();
        HBox racePane = new HBox();
        HBox scorePane = new HBox();
        VBox statsPane = new VBox();
        HBox endPane = new HBox();
        
        
        
        // Main menu
        VBox mainButtons = new VBox();
        
        Button new_btn = new Button("New session");
        Button score_btn = new Button("Highscores");
        Button exit_btn = new Button("Exit");
        
        
        new_btn.setMaxWidth(120);
        score_btn.setMaxWidth(120);
        exit_btn.setMaxWidth(120);
        
        
        mainButtons.getChildren().add(new_btn);
        mainButtons.getChildren().add(score_btn);
        mainButtons.getChildren().add(exit_btn);
        mainButtons.setAlignment(Pos.CENTER);
        
        mainPane.getChildren().add(mainButtons);
        mainPane.setAlignment(Pos.CENTER);
        
        
        
        // Game menu
        VBox gameButtons = new VBox();
        
        Button play_btn = new Button("Play a game");
        Button statistics_btn = new Button("Statistics");
        Button mainmenu_btn = new Button("Exit and save score");
        
        play_btn.setMaxWidth(120);
        statistics_btn.setMaxWidth(120);
        mainmenu_btn.setMaxWidth(120);
        
        gameButtons.getChildren().add(play_btn);
        gameButtons.getChildren().add(statistics_btn);
        gameButtons.getChildren().add(mainmenu_btn);
        gameButtons.setAlignment(Pos.CENTER);
        
        gamePane.getChildren().add(gameButtons);
        gamePane.setAlignment(Pos.CENTER);
        
        
        
        // Set name screen
        VBox nameButtons = new VBox();
        
        Label name_lbl = new Label("Name:");
        TextField name_fld = new TextField();
        Button nameDone_btn = new Button("Done");
        Button nameBack_btn = new Button("Back");
        
        nameDone_btn.setMaxWidth(120);
        nameBack_btn.setMaxWidth(120);
        
        nameButtons.getChildren().add(name_lbl);
        nameButtons.getChildren().add(name_fld);
        nameButtons.getChildren().add(nameDone_btn);
        nameButtons.getChildren().add(nameBack_btn);
        nameButtons.setAlignment(Pos.CENTER);
        
        namePane.getChildren().add(nameButtons);
        namePane.setAlignment(Pos.CENTER);
        
        
        
        // Score screen
        VBox scoreButtons = new VBox();
        
        VBox scoreList = new VBox();
        
        Button scoreReset_btn = new Button("Reset highscores");
        Button scoreBack_btn = new Button("Back");
        
        scoreReset_btn.setMaxWidth(120);
        scoreBack_btn.setMaxWidth(120);
        
        scoreButtons.getChildren().add(scoreList);
        scoreButtons.getChildren().add(scoreReset_btn);
        scoreButtons.getChildren().add(scoreBack_btn);
        scoreButtons.setAlignment(Pos.CENTER);
        
        scorePane.getChildren().add(scoreButtons);
        scorePane.setAlignment(Pos.CENTER);
        
        
        
        // Statistics screen
        HBox statsElements = new HBox();
        VBox statsLabels = new VBox();
        VBox statsLabels2 = new VBox();
        VBox statsScores = new VBox();
        
        Label playerName_lbl = new Label("Player name");
        Label playerHighscore_lbl = new Label("Player highscore");
        
        statsLabels.getChildren().add(playerName_lbl);
        statsLabels.getChildren().add(playerHighscore_lbl);
        statsLabels.getChildren().add(statsScores);
        
        Label playerName2_lbl = new Label("Name: ");
        Label playerHighscore2_lbl = new Label("Highscore: ");
        Label playerScore2_lbl = new Label("Previous scores: ");
        
        statsLabels2.getChildren().add(playerName2_lbl);
        statsLabels2.getChildren().add(playerHighscore2_lbl);
        statsLabels2.getChildren().add(playerScore2_lbl);
        
        Button statsBack_btn = new Button("Back");
        
        statsElements.getChildren().add(statsLabels2);
        statsElements.getChildren().add(statsLabels);
        statsElements.setAlignment(Pos.CENTER);
        
        statsPane.getChildren().add(statsElements);
        statsPane.getChildren().add(statsBack_btn);
        statsPane.setAlignment(Pos.CENTER);
        
        
        
        // Race
        VBox raceInformation = new VBox();
        
        int width = 10 + (logic.getMaxTurtles() * 100);
        
        Pane gameWindow = new Pane();
        gameWindow.setPrefSize(width + 80, 500);
        
        List<Polygon> turtlePolys = new ArrayList<>();
        for (int i = 0; i < logic.getMaxTurtles(); i++) {
            Polygon turtle = new Polygon(0, 0, 30, 0, 30, 30, 0, 30);
            turtle.setTranslateX(50 + i*100);
            turtle.setTranslateY(450);
            
            turtlePolys.add(turtle);
            gameWindow.getChildren().add(turtle);
        }
        
        Polygon finishLine = new Polygon(0, 0, width, 0, width, 5, 0, 5);
        finishLine.setTranslateX(10);
        finishLine.setTranslateY(50);
        gameWindow.getChildren().add(finishLine);
        
        
        Label round_lbl = new Label("round");
        Label space_lbl = new Label("--------");
        Label money_lbl = new Label("money");
        Label betDesc_lbl = new Label("Enter your bet here:");
        TextField betAmount_fld = new TextField();
        betAmount_fld.maxWidth(100);
        Label space2_lbl = new Label("--------");
        
        
        List<Button> turtleButtons = new ArrayList<>();
        List<Label> turtleLabels = new ArrayList<>();
        for (int i = 0; i < logic.getMaxTurtles(); i++) {
            Button turtle_btn = new Button("Turtle " + (i + 1));
            Label turtle_desc = new Label("turtle1 desc");
            
            turtleButtons.add(turtle_btn);
            turtleLabels.add(turtle_desc);
        }
        
        
        Button startRace = new Button("Start race");
        Label betReady = new Label("Bet not set yet");
        Button continueGame = new Button("Continue");
        
        raceInformation.getChildren().add(round_lbl);
        raceInformation.getChildren().add(space_lbl);
        raceInformation.getChildren().add(money_lbl);
        raceInformation.getChildren().add(betDesc_lbl);
        raceInformation.getChildren().add(betAmount_fld);
        raceInformation.getChildren().add(space2_lbl);
        
        for (int i = 0; i < logic.getMaxTurtles(); i++) {
            raceInformation.getChildren().add(turtleButtons.get(i));
            raceInformation.getChildren().add(turtleLabels.get(i));
        }
        
        raceInformation.getChildren().add(startRace);
        raceInformation.getChildren().add(betReady);
        raceInformation.setAlignment(Pos.CENTER);
        
        VBox alignment = new VBox();
        alignment.getChildren().add(gameWindow);
        alignment.setAlignment(Pos.CENTER);
        
        racePane.getChildren().add(alignment);
        racePane.getChildren().add(raceInformation);
        racePane.setAlignment(Pos.CENTER);
        
        
        
        // Score screen
        VBox endButtons = new VBox();
        
        Label finalScore_lbl = new Label("Final score");
        Button finalContinue_btn = new Button("Continue");
        
        endButtons.getChildren().add(finalScore_lbl);
        endButtons.getChildren().add(finalContinue_btn);
        endButtons.setAlignment(Pos.CENTER);
        
        endPane.getChildren().add(endButtons);
        endPane.setAlignment(Pos.CENTER);
        
        
        
        
        // Set scenes
        Scene mainMenu = new Scene(mainPane, 1280, 720);
        Scene gameMenu = new Scene(gamePane, 1280, 720);
        Scene nameScreen = new Scene(namePane, 1280, 720);
        Scene raceScreen = new Scene(racePane);
        Scene scoreScreen = new Scene(scorePane, 1280, 720);
        Scene statisticsScreen = new Scene(statsPane, 1280, 720);
        Scene endScreen = new Scene(endPane, 1280, 720);
        
        stage.setScene(mainMenu);
        stage.show();
        
        
        
        // Racing animation that plays after betting
        new AnimationTimer() {

            @Override
            public void handle(long nykyhetki) {
                if (logic.counter() % 15 == 0 && logic.getAnimate()) {
                    
                    if (logic.raceStep()) {
                        logic.setAnimate(false);
                        
                        money_lbl.setText("Your money: " + logic.getPlayer().getMoney());
                        raceInformation.getChildren().add(continueGame);
                    }
                    
                    
                    List<Integer> distances = logic.getDistances();
                    
                    for (int i = 0; i < logic.getMaxTurtles(); i++) {
                        turtlePolys.get(i).setTranslateY(450 - distances.get(i));
                    }
                }
            }
        }.start();
        
        
        
        
        
        
        
        
        
        // Main menu actions
        // ---------------------------------------------------------------------
        new_btn.setOnAction((ActionEvent event) -> {
            name_lbl.setText("Name:");
            
            stage.setScene(nameScreen);
        });
        
        score_btn.setOnAction((ActionEvent event) -> {
            List<Highscore> scores = logic.getHighscores();
            
            scoreList.getChildren().clear();
            
            for (int i = 0; i < Math.min(10, scores.size()); i++) {
                HBox element = new HBox();
                Label name = new Label(scores.get(i).getName());
                Label score = new Label("" + scores.get(i).getScore());

                element.getChildren().add(name);
                element.getChildren().add(score);

                element.setAlignment(Pos.CENTER);
                element.setSpacing(20);

                scoreList.getChildren().add(element);
            }
            
            stage.setScene(scoreScreen);
        });
        
        exit_btn.setOnAction((ActionEvent event) -> {
            Platform.exit();
        });
        
        
        
        
        // Name screen actions
        // ---------------------------------------------------------------------
        nameDone_btn.setOnAction((ActionEvent event) -> {
            String newName = name_fld.getText();
            //System.out.println("Debug- Name button");
            if (logic.newSession(newName)) {
                stage.setScene(gameMenu);
            } else {
                name_lbl.setText("Name taken or not valid");
            }
        });
        
        nameBack_btn.setOnAction((ActionEvent event) -> {
            stage.setScene(mainMenu);
        });
        
        
        
        
        // Game menu actions
        // ---------------------------------------------------------------------
        play_btn.setOnAction((ActionEvent event) -> {
            // New game and new race
            
            logic.newRound();
            
            // Reset race screen
            
            List<Turtle> turtles = logic.getTurtles();
            Player player = logic.getPlayer();

            round_lbl.setText("Round: 1/" + logic.getMaxRounds());
            money_lbl.setText("Your money: " + player.getMoney());
            betAmount_fld.setText("");

            for (int i = 0; i < logic.getMaxTurtles(); i++) {
                turtleLabels.get(i).setText(turtles.get(i).getDescription());
            }
            
            for (int i = 0; i < logic.getMaxTurtles(); i++) {
                turtlePolys.get(i).setTranslateY(450);
            }

            betReady.setText("Bet not set yet");

            raceInformation.getChildren().remove(continueGame);
                
            
            stage.setScene(raceScreen);
        });
        
        statistics_btn.setOnAction((ActionEvent event) -> {
            playerName_lbl.setText(logic.getPlayer().getName());
            playerHighscore_lbl.setText("" + logic.getPlayer().getHighscore());
            
            statsScores.getChildren().clear();
            
            List<Integer> oldScores = logic.getPlayer().getScores();
            
            for (int i = 0; i < oldScores.size(); i++) {
                Label score_lbl = new Label("" + oldScores.get(i));
                
                statsScores.getChildren().add(score_lbl);
            }
            
            stage.setScene(statisticsScreen);
        });
        
        mainmenu_btn.setOnAction((ActionEvent event) -> {
            logic.exitSession();
            
            stage.setScene(mainMenu);
        });
        
        
        
        
        // Score screen actions
        // ---------------------------------------------------------------------
        scoreReset_btn.setOnAction((ActionEvent event) -> {
            logic.resetDatabase();
            scoreList.getChildren().clear();
        });
        
        scoreBack_btn.setOnAction((ActionEvent event) -> {
            stage.setScene(mainMenu);
        });
        
        
        
        
        // Stats screen actions
        // ---------------------------------------------------------------------
        statsBack_btn.setOnAction((ActionEvent event) -> {
            stage.setScene(gameMenu);
        });
        
        
        
        
        // Race screen actions
        // ---------------------------------------------------------------------
        for (int i = 0; i < logic.getMaxTurtles(); i++) {
            turtleButtons.get(i).setOnAction((ActionEvent event) -> {
                if (!logic.getRaceReady()) {
                    return;
                }

                int bet;
                try {
                    bet = Integer.valueOf(betAmount_fld.getText());
                } catch (Exception e) {
                    bet = 0;
                }
                
                Button button = (Button) event.getSource();
                String index = button.getText().substring(7);
                
                // If player has enough money
                if (bet <= logic.getPlayer().getMoney() && bet > 0) {
                    logic.setBet(bet, Integer.valueOf(index) - 1);
                    betReady.setText("Bet is ready");
                } else {
                    betAmount_fld.setText("Bet not valid");
                }
            });
        }
        
        startRace.setOnAction((ActionEvent event) -> {
            if (!logic.getRaceReady()) {
                return;
            }
            else if (logic.getBet() > 0) {
                logic.startRace();
                money_lbl.setText("Your money: " + logic.getPlayer().getMoney());
            } else {
                betReady.setText("You need to set a bet");
            }
        });
        
        continueGame.setOnAction((ActionEvent event) -> {
            if (!logic.playerHasMoney()) {
                finalScore_lbl.setText("Player ran out of money: Score 0");
                
                stage.setScene(endScreen);
            } else if (logic.nextRound()) {
                
                List<Turtle> turtles = logic.getTurtles();
                Player player = logic.getPlayer();
                
                round_lbl.setText("Round: " + logic.getRound() + "/" + logic.getMaxRounds());
                money_lbl.setText("Your money: " + player.getMoney());
                betAmount_fld.setText("");
                
                for (int i = 0; i < logic.getMaxTurtles(); i++) {
                    turtleLabels.get(i).setText(turtles.get(i).getDescription());
                }
                
                for (int i = 0; i < logic.getMaxTurtles(); i++) {
                    turtlePolys.get(i).setTranslateY(450);
                }
                
                betReady.setText("Bet not set yet");
                
                raceInformation.getChildren().remove(continueGame);
                
                
            } else {
                finalScore_lbl.setText("Final score: " + logic.getPlayer().getMoney());
                
                stage.setScene(endScreen);
            }
        });
        
        
        
        
        // End screen actions
        // ---------------------------------------------------------------------
        finalContinue_btn.setOnAction((ActionEvent event) -> {
            logic.endRound();
            
            stage.setScene(gameMenu);
        });
    }
}
