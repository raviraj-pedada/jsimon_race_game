package project.jsimon;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/**

 * The Board class is a JavaFX application that represents a board game with players and various types of hurdles.
 * The class has methods for creating the board and its tiles, plotting players and hurdles on the board, rolling a dice
 and moving the players, and handling actions when players encounter hurdles. It also has variables for storing information
 about the game state, such as the number of players, the current player, and the dice roll. The class includes UI elements
 such as buttons for rolling the dice, moving the players, and labels for displaying information about the game.
 * The Board class has an ArrayList of Hurdles objects to store the hurdles in the game and a Move object to handle player movement.
 * It has a Label for displaying the dice roll, a boolean variable to indicate whether the game has started, and a Position
 object to store updated player positions.
 * It has a JSimonRace object to represent the game and a Dice object
 to handle dice rolling. The Board class has variables for the size of each tile on the board, the width and height
 of the board, and the player currently playing. It has a Group object to store the tiles and an ArrayList of Player
 objects to store the players in the game.
 * The Board class has a method called createBoard that creates the board, hurdles,
 and players and adds them to the tileGroup Group object. It also has buttons for rolling the dice and moving the players,
 and a missTurnButton for skipping a player's turn. The Board class has a diceValueControl variable to control the value of the
 dice roll and a direction variable to store the direction in which the player should move. It has a hurdleFlag variable to
 indicate whether the player has encountered a hurdle.
 */

public class Board {


    public static ArrayList<Hurdles> hurdles = new ArrayList<Hurdles>();

    public Move m = new Move();

    public Label diceLabel, textLabel, noteLabel;


    public boolean gameStart = false;

    public Position updatedPosition;

    JSimonRace race = new JSimonRace();

    Dice d = new Dice();

    //size of each tile in the Board
    public static final int tileSize = 60;
    //By changing the variable width and height I change the number of rows and columns in the game;
    public static final int width = 10;
    public static final int height = 10;

    public Button roll, moveLeft, moveRight, missTurnButton;

    private Group tileGroup = new Group();

    private int playerPlaying = 0;

    private int diceRolled = 0;

    private int numberOfPlayers;

    private boolean gameOngoing = false;

    private boolean hurdleFlag = true;
    public Player currentPlayer;

    public ArrayList<Player> players = new ArrayList<Player>();

    public int diceValueControl =1;

    public static String direction;

/**
The createBoard method is used to create the board game, including the board itself, the players,and the various types of hurdles.
It starts by retrieving the players and the number of players from a JSimonRace object using the getPlayers and 
getNumberOfPlayers methods, respectively. It then creates a Pane object called root and sets its size based on the 
width and height of the board and the size of each tile. It adds the tileGroup Group object to the root Pane. 
It sets the gameOngoing variable to true and creates the board by creating a Tile object for each tile on the board and adding 
it to the tileGroup Group. It then calls the createHurdles method to create the hurdles and adds them to the tileGroup Group.
It plots the players on the board by setting their positions based on their x and y coordinates and adding them to the tileGroup
Group. It then plots the hurdles on the board by creating an ImageView object for each hurdle and setting its image, position, 
and size based on the type of hurdle and adding it to the tileGroup Group. Finally, it creates buttons for rolling the dice, 
moving the players, and skipping a player's turn and adds them to the root Pane.

 */

/**

* This method creates and returns a JavaFX Parent object representing a game board with players and hurdles placed on it. The board has a specified width and height, and each tile on the board has a specified size.
* The method first initializes the 'players' field by calling the getPlayers() method on the 'race' object and the 'numberOfPlayers' field by calling the getNumberOfPlayers() method on the 'race' object. Then, it loops through the 'players' list and prints the name of each player to the console.
* Next, the method creates a Pane object called 'root' and sets its size to the width and height of the board multiplied by the tile size. It adds the 'tileGroup' object, which is a Group of Tile objects, to the 'root' object.
* The method then creates a nested loop to create Tile objects for each position on the board and adds them to the 'tileGroup' object. It also calls the createHurdles() method to create a list of hurdles.
* The method then loops through the 'players' list and adds each player to the 'tileGroup' object at their specified x and y positions. It also loops through the 'hurdles' list and adds an image for each hurdle to the 'tileGroup' object at its specified x and y position. 
* The image for each hurdle is chosen based on the type of hurdle it is (e.g. a FireHurdle, a PitHurdle, a FenceHurdle, or a TeleportationHurdle).
* Finally, the method creates a button called 'roll' and adds it to the 'tileGroup' object. It then returns the 'root' object as the parent object representing the game board.

 */
    public Parent createBoard() {

        players = race.getPlayers();
        numberOfPlayers = race.getNumberOfPlayers();
        for (Player p : players) {
            System.out.println(p.getName());
        }

        Pane root = new Pane();
        root.setPrefSize(width * tileSize, (height * tileSize) + 120);
        root.getChildren().addAll(tileGroup);

        gameOngoing = true;// change the name of the variable
        //creating the Board

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Tile tile = new Tile(tileSize, tileSize);
                tile.setTranslateX(j * tileSize);
                tile.setTranslateY(i * tileSize);
                tileGroup.getChildren().addAll(tile);

            }
        }

        //creating the hurdles
        createHurdles();

        //Plotting Players
        for (Player p : players) {
            p.getName();
            p.setTranslateX(p.getxPosition());
            p.setTranslateY(p.getyPosition());
            tileGroup.getChildren().add(p);
        }
        for(Hurdles h :hurdles){
            System.out.println("Name "+ h.getType());
            System.out.println("xpos "+ h.getxPosition());
            System.out.println("ypos "+ h.getyPosition());
        }
        //plotting Hurdles
        for (Hurdles h : hurdles) {

            if (h instanceof FireHurdle) {
                Image img = new Image(new File(((FireHurdle) h).getPath()).toURI().toString());
                ImageView fireImage = new ImageView();
                fireImage.setImage(img);

                fireImage.setX(((FireHurdle) h).getxPosition());
                fireImage.setY(((FireHurdle) h).getyPosition());

                fireImage.setFitHeight(58);
                fireImage.setFitWidth(58);
                tileGroup.getChildren().add(fireImage);
            } else if (h instanceof PitHurdle) {//System.out.println(((PitHurdle)h).getPath());
                Image img = new Image(new File(((PitHurdle) h).getPath()).toURI().toString());

                ImageView pitImage = new ImageView();
                pitImage.setImage(img);

                pitImage.setX(((PitHurdle) h).getxPosition());
                pitImage.setY(((PitHurdle) h).getyPosition());

                pitImage.setFitHeight(58);
                pitImage.setFitWidth(58);
                tileGroup.getChildren().add(pitImage);
            } else if (h instanceof FenceHurdle) {
                Image img = new Image(new File(((FenceHurdle) h).getPath()).toURI().toString());

                ImageView fenceImage = new ImageView();
                fenceImage.setImage(img);

                fenceImage.setX(((FenceHurdle) h).getxPosition());
                fenceImage.setY(((FenceHurdle) h).getyPosition());

                fenceImage.setFitHeight(58);
                fenceImage.setFitWidth(58);
                tileGroup.getChildren().add(fenceImage);
            } else {
                Image img = new Image(new File(((TeleportationHurdle) h).getPath()).toURI().toString());

                ImageView teleportationImage = new ImageView();
                teleportationImage.setImage(img);

                teleportationImage.setX(((TeleportationHurdle) h).getxPosition());
                teleportationImage.setY(((TeleportationHurdle) h).getyPosition());

                teleportationImage.setFitHeight(58);
                teleportationImage.setFitWidth(58);
                tileGroup.getChildren().add(teleportationImage);
            }
        }

        //Creating the button to roll the dice;
        roll = new Button("Roll Dice");
        roll.setTranslateX(60);
        roll.setTranslateY(630);

        //playing the Game
        if (gameOngoing) {
            moveRight = new Button("Move Right");
            moveRight.setTranslateX(30);
            moveRight.setTranslateY(690);
            moveRight.setVisible(false);

            moveLeft = new Button("Move Left");
            moveLeft.setTranslateX(150);
            moveLeft.setTranslateY(690);
            moveLeft.setVisible(false);

            missTurnButton = new Button("Skip Turn");
            missTurnButton.setTranslateX(270);
            missTurnButton.setTranslateY(690);
            missTurnButton.setVisible(false);

            noteLabel = new Label("");
            noteLabel.setTranslateX(30);
            noteLabel.setTranslateY(660);

            diceLabel = new Label(" ");
            diceLabel.setTranslateX(150);
            diceLabel.setTranslateY(630);

            textLabel = new Label("");
            textLabel.setTranslateX(30);
            textLabel.setTranslateY(610);

            for (Player p : players) {
                System.out.println(p.getName());
            }

            currentPlayer = players.get(playerPlaying);
            textLabel.setText(currentPlayer.getName() + ": It's your turn. ");

            roll.setOnAction(e -> onClickRollButton());

            moveRight.setOnAction(e -> moveRightAction());
            moveLeft.setOnAction(e -> moveLeftAction());
            missTurnButton.setOnAction(e -> missTurnAction());

        }
        tileGroup.getChildren().addAll(roll, diceLabel, textLabel);

        return root;
    }

/**

* The onClickRollButton method handles the logic for a player's turn in some kind of game.
* When the method is called, it sets the gameStart variable to true and enters a loop. Inside the loop, it first checks if certain elements are present in the tileGroup object and removes them if they are.
* Next, it sets the currentPlayer variable to the player at the index specified by the playerPlaying variable in the players list. It then calls the rollDice1 method of a d object to determine the direction the player will move (either "Forward", "Backward", or some other value).
* Depending on the value of the direction variable, the currentPlayer's score is updated. If the direction is "Forward" or "Backward", the rollDice2 method of the d object is called to roll a second dice and determine the number of steps the player will take. The rollAction method is then called with the direction as an argument. 
* If the direction is not "Forward" or "Backward", a label is set with a message indicating that the player has missed their turn.
* The gameStart variable is then set to false and the playerPlaying variable is incremented. If the playerPlaying variable is greater than or equal to the numberOfPlayers, it is reset to 0. The loop will exit if the gameOngoing variable is false.
* If the player whose turn it currently is has a missTurn value of true, their missTurn value is set to false and the playerPlaying variable is incremented (and potentially reset as described above). Finally, a label is updated with the name of the next player whose turn it is.

 */
    public void onClickRollButton() {
        gameStart = true;
        while (gameStart) {
            if (tileGroup.getChildren().contains(moveRight) && tileGroup.getChildren().contains(moveLeft) && tileGroup.getChildren().contains(noteLabel) && tileGroup.getChildren().contains(missTurnButton)) {
                tileGroup.getChildren().removeAll(moveRight, moveLeft, missTurnButton, noteLabel);
            }

            currentPlayer = players.get(playerPlaying);

            direction = d.rollDice1();

            //scoring Mechanism
            if(direction == "Forward"){
                currentPlayer.setScore(currentPlayer.getScore()+10);
            }else if(direction == "Backward"){
                currentPlayer.setScore(currentPlayer.getScore()-3);
            }else{
                currentPlayer.setScore(currentPlayer.getScore()+0);
            }

            //moving the player
            if (direction == "Forward" || direction == "Backward") {

                diceRolled = d.rollDice2();// value of 1 -4
                //                System.out.println("Dice Rolled : " + diceRolled);
                //                System.out.println("Name " + currentPlayer.getName());
                diceValueControl =1;
                //                System.out.println("Dice control:"+diceValueControl);
                rollAction( direction);

            } else {
                diceLabel.setText(currentPlayer.getName() + " : Missed Turn");
            }

            gameStart = false;
            playerPlaying += 1;
            if (playerPlaying >= numberOfPlayers) {
                playerPlaying = 0;
            }

            if (!gameOngoing) {
                tileGroup.getChildren().removeAll(roll);
                break;
            }
            //checking the miss turn variable to miss the turn
            if (players.get(playerPlaying).isMissTurn()) {
                players.get(playerPlaying).setMissTurn(false);
                playerPlaying += 1;
                if (playerPlaying >= numberOfPlayers) {
                    playerPlaying = 0;
                }

                textLabel.setText(players.get(playerPlaying).getName() + ": It's your turn. ");
            }
            textLabel.setText(players.get(playerPlaying).getName() + ": It's your turn. ");
        }
    }

/**

* This method creates and returns a TranslateTransition object in JavaFX. The TranslateTransition animates the translation of a node from its current position to a new position defined by the xPosition and yPosition parameters. 
* The node being animated is passed as the 'p' parameter. The animation has a duration of 10 milliseconds and does not auto-reverse once it finishes playing. The animation is started by calling the play() method on the TranslateTransition object.
* The TranslateTransition class is part of the JavaFX animation package and can be used to smoothly move a node from one position to another over a specified duration.
* It can be used to create simple animations such as moving an object across the screen or more complex animations by chaining multiple TranslateTransition objects together.

 */

    public TranslateTransition transitionPlayer(int xPosition, int yPosition, Player p) {
        TranslateTransition animatePlayer = new TranslateTransition(Duration.millis(10), p);
        animatePlayer.setToX(xPosition);
        animatePlayer.setToY(yPosition);
        animatePlayer.setAutoReverse(false);
        animatePlayer.play();
        return animatePlayer;
    }

/**

* The moveRightAction method handles the logic for moving a player to the right in some kind of game.
* When the method is called, it first updates the direction of the player to "right" and then calls the updatePlayer method to update the player's position. The player's new position is then set on the current player object using the setxPosition and setyPosition methods.
* Next, a TranslateTransition object is created using the transitionPlayer method, which takes in the current x and y positions of the player and the player object itself as arguments. This transition is then set to execute some code when it is finished using an EventHandler and the setOnFinished method.
* Inside the handle method of the EventHandler, several actions are taken: the ifPlayerWon method is called, the tileGroup object has some children removed, and the diceValueControl variable is incremented. If the diceValueControl variable is less than or equal to the diceRolled variable, the updatePlayer method is called again.
* Finally, the roll object has its setDisable method called with a value of false.

 */
    public void moveRightAction() {
        //call the method to check if there are hurdles or players
        direction = "right";
        updatePlayer();
        System.out.println(
                "called inside move right to check if there is a hurdle"
        );
        currentPlayer.setxPosition(updatedPosition.getxPosition());
        currentPlayer.setyPosition(updatedPosition.getyPosition());
        TranslateTransition translateTransition = transitionPlayer(currentPlayer.getxPosition(), currentPlayer.getyPosition(), currentPlayer);
        translateTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ifPlayerWon();
                tileGroup.getChildren().removeAll(moveRight, moveLeft, missTurnButton, noteLabel);
                //hurdleFlag = true;
                System.out.println(" hurdle, but handled - moving to next step");
                diceValueControl++;
                if(diceValueControl<=diceRolled){
                    System.out.println("Dice control:"+diceValueControl);
                    System.out.println(
                            "called inside move right"
                    );
                    updatePlayer();
                }

            }
        });
        roll.setDisable(false);

    }

/**
* The moveLeftAction method handles the logic for moving a player to the left in some kind of game.
* When the method is called, it first updates the direction of the player to "left" and then calls the updatePlayer method to update the player's position. The player's new position is then set on the current player object using the setxPosition and setyPosition methods.
* Next, a TranslateTransition object is created using the transitionPlayer method, which takes in the current x and y positions of the player and the player object itself as arguments. This transition is then set to execute some code when it is finished using an EventHandler and the setOnFinished method.
* Inside the handle method of the EventHandler, several actions are taken: the tileGroup object has some children removed, the ifPlayerWon method is called, and the diceValueControl variable is incremented. If the diceValueControl variable is less than or equal to the diceRolled variable, the updatePlayer method is called again.
* Finally, the roll object has its setDisable method called with a value of false.

 */
    public void moveLeftAction() {
        direction = "left";
            //        System.out.println(
            //                "called inside move left to check if there is a hurdle"
            //        );
        updatePlayer();

        currentPlayer.setxPosition(updatedPosition.getxPosition());
        currentPlayer.setyPosition(updatedPosition.getyPosition());
        TranslateTransition translateTransition = transitionPlayer(currentPlayer.getxPosition(), currentPlayer.getyPosition(), currentPlayer);
        translateTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                tileGroup.getChildren().removeAll(moveRight, moveLeft, missTurnButton, noteLabel);
               //
                ifPlayerWon();
                //hurdleFlag = true;
                System.out.println(" hurdle, but handles - moving to next step");
                diceValueControl++;
                if(diceValueControl<=diceRolled){
                    System.out.println("Dice control:"+diceValueControl);
                    System.out.println(
                            "called inside move left"
                    );
                    updatePlayer();
                }

            }
        });
        roll.setDisable(false);

    }

/**

* This method updates the game state by setting the current player's miss turn flag to true and reducing their score by 5 points. 
* It also updates the dice label to display that the player has skipped their turn and removes the "miss turn" buttons from the game board.
*/

    public void missTurnAction() {
        currentPlayer.setScore(currentPlayer.getScore()-5); //if a player skips a turn then he will deducted 5 points
        currentPlayer.setMissTurn(true);
       // System.out.println("Missed turn");
        diceLabel.setText(currentPlayer.getName() + " : Skipped Turn");
        tileGroup.getChildren().removeAll(moveRight, moveLeft, missTurnButton, noteLabel);
        //hurdleFlag=true;
        roll.setDisable(false);
    }

/**

* This method updates the game state by moving the current player based on the dice roll and direction. 
* It also updates the dice label to display the player's name, dice roll, and direction.
* param - direction, The direction in which the player should move
*/

    public void rollAction( String direction) {

        if(diceValueControl<=diceRolled){
            System.out.println("Dice control:"+diceValueControl);
            updatePlayer();
        }

        diceLabel.setText(currentPlayer.getName() + " Rolled : " + diceRolled + " Direction : " + direction);
    }

/**

* This method checks if the current player has reached the end of the game board, 
  and if so, displays a message and adds the player to the leaderboard. 
* It also removes the roll button and other elements from the game board and displays the finish area.
*/
    public void ifPlayerWon(){
        if (currentPlayer.getyPosition() == 30) {
            diceLabel.setText(currentPlayer.getName() + " Won the Game. Score: "+currentPlayer.getScore());
            gameOngoing = false;
            tileGroup.getChildren().removeAll(roll,textLabel,moveRight, moveLeft, missTurnButton, noteLabel);
            addPlayerToLeaderBoard(currentPlayer);
            System.out.println("Player Added");
            Stage primaryStage = (Stage) diceLabel.getScene().getWindow();
            primaryStage.close();
            Scene scene2 = new Scene(finishArea());
            Stage finishStage = new Stage();
            finishStage.setScene(scene2);
            finishStage.show();

        }
    }

/**

* This method creates a pane that displays the name and score of the player who won the game, 
  as well as buttons to return to the home screen, view the leaderboard, or quit the game.
* returns The pane containing the finish area elements
*/
    public Parent finishArea(){

        Pane root = new Pane();
        root.setPrefSize((width * tileSize)/2, (height * tileSize)/2);


        Label finishLabel = new Label();
        finishLabel.setTranslateX(50);
        finishLabel.setTranslateY(50);

        Button homeButton = new Button("Home");
        homeButton.setTranslateX(50);
        homeButton.setTranslateY(80);

        Button scorecard  = new Button("Leadership Board");
        scorecard.setTranslateX(100);
        scorecard.setTranslateY(80);

        Button quit = new Button("Quit");
        quit.setTranslateX(80);
        quit.setTranslateY(120);

        finishLabel.setText(currentPlayer.getName() + " Won the Game. Score: "+currentPlayer.getScore());
        homeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                Stage primaryStage = (Stage) scorecard.getScene().getWindow();
                primaryStage.close();
                Stage primaryStage1 = (Stage) diceLabel.getScene().getWindow();
                primaryStage1.close();
                JSimonRace raceBoard = new JSimonRace();
                Scene scene2 = new Scene(raceBoard.createContent());
                Stage boardStage = new Stage();
                boardStage.setScene(scene2);
                boardStage.show();
            }
        });

        quit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage primaryStage1 = (Stage) diceLabel.getScene().getWindow();
                primaryStage1.close();
                Stage primaryStage = (Stage) quit.getScene().getWindow();
                primaryStage.close();
            }
        });

        scorecard.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                JSimonRace race = new JSimonRace();
                race.showLeaderBoard();
            }
        });


        root.getChildren().addAll(scorecard,quit,homeButton,finishLabel);
        return  root;

    }
    /**

* This method checks if there is a hurdle at a given position on the game board.
* param - position, The position on the game board to check
* returns true if there is a hurdle at the given position, or false if there is no hurdle at the position
*/
    public boolean hasHurdle(Position position) {
        int xPosition = position.getxPosition();
        int yPosition = position.getyPosition();
        if(hurdles.isEmpty()){
            return false;
        }
        for (Hurdles h : hurdles) {
            if ((h.getxPosition() + 30) == xPosition && (h.getyPosition() + 30) == yPosition) {
               // System.out.println("has Hurdle. Cant move");
                return true;
            }
        }
        return false;
    }

/**

* This method updates the position of the current player based on the direction they are moving.
* If there is a hurdle at the updated position, the player's action is determined by the hurdle's "isAvoidable" flag. 
* If the hurdle is avoidable, the player is given the option to select a new direction or miss a turn. 
* If the hurdle is not avoidable, the player's position is updated based on the hurdle's action.
* If there are no hurdles at the updated position, the player's position is simply updated.
* param - m, The object that determines the player's updated position
* param - direction, The direction the player is moving
* param - updatedPosition, The player's updated position
* param - currentPlayer, The current player
* param - noteLabel, A label to display a message to the player
* param - moveRight, A button to allow the player to move right
* param - moveLeft, A button to allow the player to move left
* param - missTurnButton, A button to allow the player to miss a turn
* param - roll, A button to roll the dice
* param - tileGroup, The group of tiles on the game board
*/
    public void updatePlayer() {
        updatedPosition = m.move(currentPlayer,direction);
        System.out.println(direction);
        if (hasHurdle(updatedPosition) || hasPlayers(updatedPosition)) {
            if (isHurdleAvoidable(updatedPosition)) {

                //if hurdle is avoidable then we will ask the user to select the direction he want to move

                noteLabel.setText("You have an Hurdle in-front of you. Select the direction or miss a turn");
                moveRight.setVisible(true);
                moveLeft.setVisible(true);
                missTurnButton.setVisible(true);
                roll.setDisable(true);
                hurdleFlag = false;
                if (!(tileGroup.getChildren().contains(moveRight) && tileGroup.getChildren().contains(moveLeft) && tileGroup.getChildren().contains(noteLabel) && tileGroup.getChildren().contains(missTurnButton))) {
                    tileGroup.getChildren().addAll(noteLabel, moveRight, moveLeft, missTurnButton);
                }

            } else {
                //hurdle is unavoidable;
                Hurdles h = getHurdle(updatedPosition);
                Player cPlayer = h.action(currentPlayer);
            // updatedPosition = new Position(cPlayer.getxPosition(), cPlayer.getyPosition());
            //  updatePlayer();
                //transitionPlayer(currentPlayer.getxPosition(), currentPlayer.getyPosition(), currentPlayer);
                transitionPlayer(cPlayer.getxPosition(), cPlayer.getyPosition(), cPlayer);
            }
        } else {
            //no hurdles
            currentPlayer.setxPosition(updatedPosition.getxPosition());
            currentPlayer.setyPosition(updatedPosition.getyPosition());
            System.out.println("Position : " + currentPlayer.getxPosition() + " " + currentPlayer.getyPosition());
            TranslateTransition translateTransition = transitionPlayer(currentPlayer.getxPosition(), currentPlayer.getyPosition(), currentPlayer);
            translateTransition.setOnFinished(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    if(tileGroup.getChildren().contains((moveRight))){
                        tileGroup.getChildren().removeAll(moveRight, moveLeft, missTurnButton, noteLabel);
                    }

                   ifPlayerWon();
                    System.out.println("Noo hurdle - moving to next step");
                    //tileGroup.getChildren().removeAll(moveRight, moveLeft, missTurnButton, noteLabel);
                    //hurdleFlag = true;
                    diceValueControl++;
                    if(diceValueControl<=diceRolled){
                        System.out.println("Dice control:"+diceValueControl);
                        System.out.println(
                                "called inside if no hurdles"
                        );
                        updatePlayer();
                    }

                }
            });
        }

    }
/**

* This method checks if there is a player at a given position on the game board.
* param - position, The position on the game board to check
* returns true if there is a player at the given position, or false if there is no player at the position
*/

    public Boolean hasPlayers(Position position) {
        int xPosition = position.getxPosition();
        int yPosition = position.getyPosition();
        if (yPosition == 570) {
            return false;
        }

        for (Player p : players) {
            if (p.getxPosition() == xPosition && p.getyPosition() == yPosition) {
                return true;
            }
        }
        return false;
    }

/**

* This method determines whether a hurdle at a given position on the game board can be avoided by the player.
* param - position, The position on the game board to check
* returns true if the hurdle at the given position can be avoided, or false if it cannot be avoided or if there is no hurdle at the position
*/


    public boolean isHurdleAvoidable(Position position) {
        int xPosition = position.getxPosition();
        int yPosition = position.getyPosition();
        for (Hurdles h : hurdles) {
            if ((h.getxPosition() + 30) == xPosition && (h.getyPosition() + 30) == yPosition) {
                return h.getIsAvoidable();
            }
        }
        for (Player p : players) {
            if (p.getxPosition() == xPosition && p.getyPosition() == yPosition) {
                return true;
            }
        }
        return false;
    }
/**

* This method retrieves a hurdle at a given position on the game board.
* param - position, The position on the game board where the hurdle is located
* returns The hurdle at the given position, or null if there is no hurdle at the position
*/
    public Hurdles getHurdle(Position position) {
        int xPosition = position.getxPosition();
        int yPosition = position.getyPosition();
        for (Hurdles h : hurdles) {
            if ((h.getxPosition() + 30) == xPosition && (h.getyPosition() + 30) == yPosition) {
                return h;
            }
        }
        return null;
    }

/**

* This method creates hurdles for a game and adds them to a list of hurdles.
* The hurdles are randomly placed on the game board and can be one of four types: FireHurdle, PitHurdle, FenceHurdle, or TeleportationHurdle. 
* Each type of hurdle has a specific image associated with it and is placed at a random x and y position on the game board. 
* If a hurdle is placed at a position where there is already a hurdle, the loop iterates and tries again until a valid position is found.
* param - hurdles, The list of hurdles to which the newly created hurdles will be added

*/
    public void createHurdles() {

        for(int i =0; i<2; i++){
            int rand1,rand2,xPosition,yPosition;
            do{
                rand1 = (int) (Math.random() * 9) + 1;
                rand2 = (int) (Math.random() * 6) + 1;
                xPosition = (rand1 * 60);
                yPosition = (rand2 * 60);
            }while(hasHurdle(new Position(xPosition,yPosition)));

            Hurdles hurdle = new FireHurdle();
                ((FireHurdle) hurdle).setxPosition(xPosition);
                ((FireHurdle) hurdle).setyPosition(yPosition);
                ((FireHurdle) hurdle).setPath("src/main/resources/images/fire.jpg");
                hurdles.add(hurdle);
        }

        for(int i =0; i<3; i++){
            int rand1,rand2,xPosition,yPosition;
            do{
                rand1 = (int) (Math.random() * 9) + 1;
                rand2 = (int) (Math.random() * 6) + 3;
                xPosition = (rand1 * 60);
                yPosition = (rand2 * 60);
            }while(hasHurdle(new Position(xPosition,yPosition)));
                Hurdles hurdle1 = new PitHurdle();
                ((PitHurdle) hurdle1).setxPosition(xPosition);
                ((PitHurdle) hurdle1).setyPosition(yPosition);
                ((PitHurdle) hurdle1).setPath("src/main/resources/images/pit.jpg");
                hurdles.add(hurdle1);

        }

        for(int i =0; i<3; i++){

            int rand1,rand2,xPosition,yPosition;
            do{
                rand1 = (int) (Math.random() * 9) + 1;
                rand2 = (int) (Math.random() * 2) + 1;
                xPosition = (rand1 * 60);
                yPosition = (rand2 * 60);
            }while(hasHurdle(new Position(xPosition,yPosition)));
                Hurdles hurdle2 = new FenceHurdle();
                ((FenceHurdle) hurdle2).setxPosition(xPosition);
                ((FenceHurdle) hurdle2).setyPosition(yPosition);
                ((FenceHurdle) hurdle2).setPath("src/main/resources/images/fence.jpg");
                hurdles.add(hurdle2);

        }

        for(int i =0; i<3; i++){
            int rand1,rand2,xPosition,yPosition;
            do{
                rand1 = (int) (Math.random() * 9) + 1;
                rand2 = (int) (Math.random() * 6) + 1;
                xPosition = (rand1 * 60);
                yPosition = (rand2 * 60);
            }while(hasHurdle(new Position(xPosition,yPosition)));
                Hurdles hurdle3 = new TeleportationHurdle();
                ((TeleportationHurdle) hurdle3).setxPosition(xPosition);
                ((TeleportationHurdle) hurdle3).setyPosition(yPosition);
                ((TeleportationHurdle) hurdle3).setPath("src/main/resources/images/teleportation.jpg");
                hurdles.add(hurdle3);

        }
    }
/**

* This method adds a player's name and score to a CSV file called "LeaderBoard.csv".
* If the file does not exist, it creates a new file and writes the player's name and score to it.
* If an IOException is thrown, the stack trace is printed.
* param - name, The player's name
* param - score, The player's score
*/
    public void addPlayerToLeaderBoard(Player player) {
        try {
            File leaderBoard = new File("src/main/resources/LeaderBoard.csv");
            if (leaderBoard.isFile()) {
                FileWriter writer = new FileWriter(leaderBoard,true);
                writer.append(String.join(",", player.getName(), Integer.toString(player.getScore())));
                writer.append("\n");
                writer.flush();
                writer.close();
            } else {
                FileWriter newCSV = new FileWriter("src/main/resources/LeaderBoard.csv");
                newCSV.append(String.join(",", player.getName(), Integer.toString(player.getScore())));
                newCSV.append("\n");
                newCSV.flush();
                newCSV.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}