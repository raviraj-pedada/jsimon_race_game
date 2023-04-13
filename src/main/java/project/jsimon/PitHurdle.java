package project.jsimon;

/**
 * The PitHurdle class represents a pit obstacle in a game. It implements the Hurdles interface and has a public static final field, type, which stores the string "Pit" as the type of the hurdle. The PitHurdle class has a public static final field, isAvoidable, which is a boolean that indicates whether the pit can be avoided or not.
 *
 * The PitHurdle class has four private fields: xPosition, yPosition, path, and isAvoidable. The xPosition and yPosition fields store the x and y coordinates of the pit's position on the board, respectively. The path field stores the path that leads to the pit. The isAvoidable field stores a boolean value indicating whether the pit can be avoided or not.
 *
 * The PitHurdle class has a default constructor and a constructor that takes three arguments: xPosition, yPosition, and path. It also has getter and setter methods for the xPosition, yPosition, path, and isAvoidable fields.
 *
 * The PitHurdle class has an implementation of the action() method from the Hurdles interface that returns null. It has an implementation of the getType() method from the Hurdles interface that returns the value of the type field.
 *
 * The PitHurdle class represents a pit obstacle in a game and has information about its position and path on the board, as well as whether it can be avoided or not. It also provides an implementation of the action() and getType() methods from the Hurdles interface.
 */

public class PitHurdle implements Hurdles{

    public static final String type = "Pit";
    private int xPosition;
    private int yPosition;
    private String path;

    public final static Boolean isAvoidable = true;

    /**
    * default constructor for PitHurdle class
     */
    public PitHurdle(){

    }
    /**
    * constructor that initializes the object with given x and y position and the path to the image file
     */
    public PitHurdle(int xPosition, int yPosition, String path){
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.path = path;
    }

    /**
    returns the x position of the pit
     */
    public int getxPosition() {
        return xPosition;
    }
    /**
    * sets the x position of the pit
     */
    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }
    /**
    * returns the y position of the pit
     */
    public int getyPosition() {
        return yPosition;
    }
    /**
    * returns the type of hurdle which is "Pit" in this case
     */
    @Override
    public String getType() {
        return type;
    }
    /**
    * sets the y position of the pit
     */
    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }
    /**
    * returns the path to the image file for the pit hurdle
     */
    public String getPath() {
        return path;
    }
    /**
    * sets the path to the image file of the pit
     */
    public void setPath(String path) {
        this.path = path;
    }
    /**
    * returns a boolean indicating whether the pit hurdle is avoidable or not
     */

    public boolean getIsAvoidable(){
        return isAvoidable;
    }

    /**
    * returns the Player object after taking necessary action on the player based on interaction with the pit hurdle
     */
    @Override
    public Player action(Player P) {
        return null;
    }
}
