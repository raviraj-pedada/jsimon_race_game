package project.jsimon;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.*;
/**
 * The JSimonRace class represents a game where players race to reach the end of a board by rolling dice and moving their pieces. It extends the Application class and overrides the start() method to create and display the game's user interface.
 *
 * The class has several fields to store GUI elements such as labels, text fields, choice boxes, and buttons. These elements are used to allow the user to enter the number of players, player names, and player positions, and to start the game, reset the game, view the leaderboard, and quit the game.
 *
 * The class has a private static field, players, which is an ArrayList of Player objects that represents the players in the game. It has a public static field, initialPosition, which is a Map that stores the initial position of each player.
 *
 * The class has several methods to handle user input and update the game state. The createContent() method creates the game's user interface and returns it as a Parent object. The reset() method resets the game to its initial state. The startGame() method starts the game and displays the board. The leaderBoard() method displays the leaderboard. The quit() method closes the game.
 *
 * The JSimonRace class allows the user to play a dice-rolling race game and displays the game board and leaderboard. It also provides options to reset, start, and quit the game.
 */

public class JSimonRace extends Application {

    public static Map<Player,ArrayList<Integer>> initialPosition = new HashMap<Player, ArrayList<Integer>>();

    public TextField playerNameTextField;

    public ChoiceBox numberOfPlayersChoiceBox, playerPositionChoiceBox;

    public Label label1, label2, label3, label4, label5;

    public Button submit2, gameStartButton, submit1, resetButton, leaderBoardButton, quitButton;
    public int playersCount =0;

    public String name = "";


    public int playerPosition = 0;

    private static ArrayList<Player> players = new ArrayList<Player>();

    //size of each tile in the Board
    public static final int tileSize = 60;
    //By changing the variable width and height I change the number of rows and columns in the game;
    public static final int width = 10;
    public static final int height = 10;

    private Group tileGroup = new Group();

    private static int numberOfPlayers =0;

    String st[] = {"2","3","4","5","6"};
    static  String st1[] = {"1","2","3","4","5","6","7","8","9","10"};
    // this method will create the scene
    
    /**
    * The createContent method is used to create the content for a graphical user interface (GUI) application built using JavaFX. The method returns a Parent object, which is the root container for the content of the GUI.
    * The method first creates a Pane object called root, which is set to the preferred size of the content area and has the tileGroup object added to it as a child. The tileGroup object is a container for other GUI elements, such as labels, text fields, and buttons.
    * The method then creates a number of labels, text fields, choice boxes, and buttons and adds them to the tileGroup object. These elements are used to prompt the user for input, such as the number of players and the details for each player. 
    * The method also sets up event handlers for the buttons, which are used to trigger certain actions when the buttons are clicked.
    * Finally, the method returns the root object, which contains the entire content of the GUI. 
    
     */
    
    public Parent createContent() {

        Pane root = new Pane();
        root.setPrefSize(width * tileSize, (height * tileSize) + 120);
        root.getChildren().addAll(tileGroup);
        // anything that is added to the tile group will be added to the Pane which has an object of root.
        //taking input from the user

        label1 = new Label("Enter the Number of Players : ");
        label1.setTranslateX(100);
        label1.setTranslateY(100);


        numberOfPlayersChoiceBox = new ChoiceBox(FXCollections.observableArrayList(st));
        numberOfPlayersChoiceBox.setTranslateX(300);
        numberOfPlayersChoiceBox.setTranslateY(100);


        resetButton = new Button("Reset");
        resetButton.setTranslateX(260);
        resetButton.setTranslateY(300);
        resetButton.setOnAction(e -> reset());

        label5 = new Label("");
        //board.add(label5)
        label5.setTranslateX(240);
        label5.setTranslateY(220);

        submit1 = new Button("Submit");
        submit1.setTranslateX(500);
        submit1.setTranslateY(100);
        submit1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                if(numberOfPlayersChoiceBox.getValue() == null){
                    label5.setVisible(true);
                    label5.setText("Error: please choose one of them");
                    System.out.println();
                }else {
                    label5.setVisible(false);
                    numberOfPlayers = Integer.parseInt((String) numberOfPlayersChoiceBox.getValue());
                    numberOfPlayersChoiceBox.setDisable(true);
                    submit1.setDisable(true);
                    label2 = new Label("Enter the Player Details :    Name -");
                    label2.setTranslateX(100);
                    label2.setTranslateY(140);

                    playerNameTextField = new TextField();
                    playerNameTextField.setTranslateX(300);
                    playerNameTextField.setTranslateY(140);

                    label3 = new Label("Position - ");
                    label3.setTranslateX(240);
                    label3.setTranslateY(180);

                    label4 = new Label("");
                    label4.setTranslateX(100);
                    label4.setTranslateY(180);

                    playerPositionChoiceBox = new ChoiceBox(FXCollections.observableArrayList(st1));
                    playerPositionChoiceBox.setTranslateX(300);
                    playerPositionChoiceBox.setTranslateY(180);

                    submit2 = new Button("Next");
                    submit2.setTranslateX(500);
                    submit2.setTranslateY(180);
                    submit2.setOnAction(e -> getPlayerInfo());


                    tileGroup.getChildren().addAll(label2,label3,label4,playerNameTextField,playerPositionChoiceBox,submit2);

                }

            }
        });

        tileGroup.getChildren().addAll(label1,numberOfPlayersChoiceBox,submit1,label5);

        //start the game - create the button
        //once the button is created then make the game start variable to true and set the players and create board and hurdles
        //then play the game

        gameStartButton = new Button("Start Game");
        gameStartButton.setTranslateX(260);
        gameStartButton.setTranslateY(340);
        gameStartButton.setDisable(true);
        gameStartButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                Stage primaryStage = (Stage) gameStartButton.getScene().getWindow();
                primaryStage.close();
                Board board = new Board();
                Scene scene2 = new Scene(board.createBoard());
                Stage boardStage = new Stage();
                boardStage.setScene(scene2);
                boardStage.show();

            }
        });

        leaderBoardButton = new Button("Score Card");
        leaderBoardButton.setTranslateX(260);
        leaderBoardButton.setTranslateY(380);
        leaderBoardButton.setOnAction(e -> showLeaderBoard());

        quitButton = new Button("Quit");
        quitButton.setTranslateX(265);
        quitButton.setTranslateY(420);
        quitButton.setOnAction(e -> quitGame());


        tileGroup.getChildren().addAll(gameStartButton,resetButton,leaderBoardButton, quitButton);

        return root;
    }

    /**
     * The method takes no arguments and returns nothing. It first retrieves the current stage (the top-level container for the scene graph of a JavaFX application) using the getScene().getWindow() method of the quitButton field, which is a Button object. The method then closes the stage using the close method.
     * This method is a handler for the quitButton object, so that when the button is clicked, the current window will be closed. 
     */
    public void quitGame(){
        Stage primaryStage = (Stage) quitButton.getScene().getWindow();
        primaryStage.close();
    }

    /**
    
    * The method takes no arguments and returns nothing. It clears the players list, which is a list of Player objects, and disables the submit1 and numberOfPlayersChoiceBox buttons. 
    * The playersCount variable is also reset to 0. If the playerNameTextField object is present in the tileGroup object, a container for GUI elements, the method removes the label2, label3, label4, playerNameTextField, playerPositionChoiceBox, submit2, and label5 objects from the tileGroup object.

     */

    public void reset(){
        players.clear();
       // numberOfPlayersChoiceBox.clear();
        submit1.setDisable(false);
        numberOfPlayersChoiceBox.setDisable(false);
        playersCount =0;
        if(tileGroup.getChildren().contains(playerNameTextField)){
            tileGroup.getChildren().removeAll(label2,label3,label4,playerNameTextField,playerPositionChoiceBox,submit2,label5);
        }
    }
    /**

     Returns the list of players in the game.
     */
    public ArrayList<Player> getPlayers(){
        return players;
    }
    /**

    * Creates a new player object with the specified name and initial position.
    * param - name, the name of the player
    * param - pos, the initial position of the player on the game board (1-based index)
    * returns a new player object with the specified name and initial position
     */
    public Player createPlayer(String name,int pos ) {
        ArrayList<Integer> position = new ArrayList<Integer>();
        int xPosition = ((pos-1) *tileSize) + 30;
        int yPosition = 570;//if I am changing the tile size I need to play with the numbers here along with the height and the width
        Player p = new Player(name, xPosition, yPosition);
        position.add(xPosition);
        position.add(yPosition);
        initialPosition.put(p, position);
        return p;
    }

    /**
    
    * The getPlayerInfo method is used to get the player information from the user and create a player object. It takes input from a TextField and a ChoiceBox, both of which are used to get the player's name and position, respectively.
    * If either of these fields are empty, an error message is displayed. Once the required information is entered, a player object is created using the createPlayer method and added to a list of players. The player count is incremented and the ChoiceBox and TextField are cleared.
    * If the player count is equal to the number of players, the "Start Game" button is enabled and the user is prompted to start the game.
    
     */
    public void getPlayerInfo(){

            if((playerNameTextField.getText().length() == 0) || (playerPositionChoiceBox.getValue() ==  null)){
                label5.setVisible(true);
                label5.setText("Error: Please enter the required details");
            } else{
                label5.setVisible(false);
                playersCount ++;
                name = playerNameTextField.getText();
               // name = name.toUpperCase();
                playerPosition = Integer.parseInt((String) playerPositionChoiceBox.getValue());
                players.add(createPlayer(name,playerPosition));
                playerNameTextField.clear();
                playerPositionChoiceBox.getItems().remove(playerPositionChoiceBox.getValue());
                label5.setText("Player " + playersCount + " information is Entered.");
                if(playersCount==numberOfPlayers){
                    label5.setText("Player " + playersCount + " information is Entered. Please Click on Start Game");
                    submit2.setDisable(true);
                    gameStartButton.setDisable(false);
                }
            }
    }

    /**
    * This method returns the number of players in the game
    */

    public int getNumberOfPlayers(){
        return numberOfPlayers;
    }

    /**
    * This method returns the position of a player in the game

     */
    public int getPlayerPosition() {
        return playerPosition;
    }

    /**
    * The showLeaderBoard() method is used to display a leaderboard for a game. It reads the scores from a CSV file named "LeaderBoard.csv" and creates a dialog with a scrollable table to display the top 10 scores. 
    * The scores are sorted in descending order and the table includes the player's name and score. The method includes a Rectangle and Label for each player's name and score, which are added to an HBox and then to a VBox. 
    * The VBox is then added to a ScrollPane and displayed in the dialog. The dialog includes a cancel button to close it.
    */
    public void showLeaderBoard(){
        String line="";
        Dialog leaderboard = new Dialog();
        leaderboard.getDialogPane().setMinHeight(tileSize*height);
        leaderboard.getDialogPane().setMinWidth(tileSize*width/2);
        leaderboard.setTitle("JSimon Race Game - LeaderBoard");
        ScrollPane scrollPane = new ScrollPane();
        VBox table = new VBox();
        ArrayList<ScoreCard> winnerList = new ArrayList<>();
        try {
            BufferedReader bf = new BufferedReader(new FileReader("src/main/resources/LeaderBoard.csv"));
            while((line=bf.readLine())!=null){
                String [] winners = line.split(",");
                winnerList.add(new ScoreCard(winners[0],Integer.parseInt(winners[1])));
            }
            Collections.sort(winnerList, new Comparator<ScoreCard>() {
                @Override
                public int compare(ScoreCard o1, ScoreCard o2) {
                    if(o1.getScore()==o2.getScore()){
                        return 0;
                    } else if (o1.getScore()<o2.getScore()) {
                        return 1;
                    }else {
                        return -1;
                    }
                }
            });
            Rectangle scoreHeader = new Rectangle(100,50);
            scoreHeader.setFill(Color.GOLD);
            Label sHeaderLabel = new Label("SCORE");
            StackPane sHeaderSP = new StackPane(scoreHeader,sHeaderLabel);
            Rectangle playerHeader = new Rectangle(100,50);
            playerHeader.setFill(Color.GOLD);
            Label pHeaderLabel = new Label("WINNER NAME");
            StackPane pHeaderSP = new StackPane(playerHeader,pHeaderLabel);
            HBox header = new HBox(sHeaderSP,pHeaderSP);
            table.getChildren().add(header);
            if(winnerList.size()<10) {
                winnerList.subList(0, winnerList.size()).stream().forEach(x -> {
                    Rectangle score = new Rectangle(100, 50);
                    score.setFill(Color.TRANSPARENT);
                    Label scoreLabel = new Label(Integer.toString(x.getScore()));
                    StackPane scoreSP = new StackPane(score, scoreLabel);
                    Rectangle playerName = new Rectangle(100, 50);
                    playerName.setFill(Color.TRANSPARENT);
                    Label playerNameLabel = new Label(x.getName());
                    StackPane playerNameSP = new StackPane(playerName, playerNameLabel);
                    HBox entries = new HBox(scoreSP, playerNameSP);
                    table.getChildren().addAll(entries);
                });
            }else{
                winnerList.subList(0,10).stream().forEach(x->{
                    Rectangle score = new Rectangle(100,50);
                    score.setFill(Color.TRANSPARENT);
                    Label scoreLabel = new Label(Integer.toString(x.getScore()));
                    StackPane scoreSP = new StackPane(score,scoreLabel);
                    Rectangle playerName = new Rectangle(100,50);
                    playerName.setFill(Color.TRANSPARENT);
                    Label playerNameLabel = new Label(x.getName());
                    StackPane playerNameSP = new StackPane(playerName,playerNameLabel);
                    HBox entries = new HBox(scoreSP,playerNameSP);
                    table.getChildren().addAll(entries);
                });

            }
            bf.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        scrollPane.setContent(table);
        leaderboard.getDialogPane().setContent(scrollPane);
        leaderboard.getDialogPane().getButtonTypes().addAll(ButtonType.CANCEL);

        leaderboard.showAndWait();
    }

    /**
    * The start method is the entry point of the JavaFX application. It sets up the scene and displays it on the given stage.
    
     */
    @Override
    public void start(Stage stage) throws IOException {

        Scene scene = new Scene(createContent());

        stage.setTitle("Simon's Race Game");
        stage.setScene(scene);
        stage.show();
    }

    /**
    
    * The main method calls the launch method, which creates an instance of the class and calls the start method with a new stage.
     */
    public static void main(String[] args) {
        launch();
    }
}