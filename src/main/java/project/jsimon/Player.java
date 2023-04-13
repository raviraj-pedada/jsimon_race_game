package project.jsimon;



import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
/**
 * The Player class extends the Circle class from the JavaFX library and represents a player in a game. It has four private fields: name, xPosition, yPosition, and missTurn. The name field stores the name of the player as a string. The xPosition and yPosition fields store the x and y coordinates of the player's position on the board, respectively. The missTurn field is a boolean that indicates whether the player misses a turn or not.
 *
 * The Player class has a public constructor that takes three arguments: name, xPosition, and yPosition. It also has getter and setter methods for all of its fields. The setFill() and setStroke() methods from the Circle class are used to set the color and stroke of the player's circle.
 *
 * The Player class represents a player in a game and stores information about the player's name, position, and whether they miss a turn or not. It also provides methods to set and get the player's name, position, and score. The class extends the Circle class from the JavaFX library and uses the setFill() and setStroke() methods to set the color and stroke of the player's circle.
 */
public class Player extends Circle {

    private String name;
    private int xPosition;
    private int yPosition;
    private boolean missTurn;

    private int score = 0;
    /**
    * This constructor creates a new Player object with the specified name, xPosition, and yPosition values. It also sets the radius of the player to 20, sets a random color for the player, sets the stroke color to black, and sets the missTurn attribute to false.
     */
    public  Player(String name, int xPosition, int yPosition){
        setRadius(20);
        this.name = name;
        this.xPosition =xPosition;
        this.yPosition = yPosition;
        setFill(Color.color(Math.random(), Math.random(), Math.random()));
        setStroke(Color.BLACK);
        missTurn = false;
    }
    /**
    
    * This is the default constructor for the Player class. It creates a new Player object with default values for its attributes. It sets the radius of the player to 20, sets a random color for the player, sets the stroke color to black, and sets the missTurn attribute to false.

     */
    public Player() {
        setRadius(20);
        setFill(Color.color(Math.random(), Math.random(), Math.random()));
        setStroke(Color.BLACK);
        missTurn = false;
    }
    /**
    * This method returns the score of the player.

     */
    public int getScore() {
        return score;
    }

    /**
    
    * This method sets the score of the player to the specified score value.

     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
    
    * This method returns a boolean value indicating whether the player has missed their turn.

     */
    public boolean isMissTurn() {
        return missTurn;
    }
    /**
    This method sets the value of the missTurn attribute to the specified missTurn value.
     */
    public void setMissTurn(boolean missTurn) {
        this.missTurn = missTurn;
    }
    /**
    This method returns the name of the player.
     */
    public String getName() {
        return name;
    }
    /**
    * This method sets the name of the player to the specified name value.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
    * This method returns the x-coordinate position of the player.
     */
    public int getxPosition() {
        return xPosition;
    }
    /**
    * This method sets the x-coordinate position of the player to the specified xPosition value.

     */
    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }
    /**
    * This method returns the y-coordinate position of the player.

     */
    public int getyPosition() {
        return yPosition;
    }

    /**
    * This method sets the y-coordinate position of the player to the specified yPosition value.

     */
    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

}
