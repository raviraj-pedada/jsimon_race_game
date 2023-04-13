package project.jsimon;

/**
 * TeleportationHurdle is a class that represents a teleportation hurdle in a game. It implements the Hurdles interface and has the following attributes:
 *
 *     xPosition: an integer representing the x-coordinate position of the hurdle
 *     yPosition: an integer representing the y-coordinate position of the hurdle
 *     path: a string representing the path of the hurdle
 *     isAvoidable: a boolean representing whether the hurdle is avoidable or not
 *     type: a string representing the type of hurdle
 *
 * It has the following methods:
 *
 *     action(Player p): a method that teleports the player p to a random position on the board
 *     getxPosition(): a method that returns the x-coordinate position of the hurdle
 *     setxPosition(int xPosition): a method that sets the x-coordinate position of the hurdle
 *     getyPosition(): a method that returns the y-coordinate position of the hurdle
 *     setyPosition(int yPosition): a method that sets the y-coordinate position of the hurdle
 *     getPath(): a method that returns the path of the hurdle
 *     setPath(String path): a method that sets the path of the hurdle
 *     getIsAvoidable(): a method that returns a boolean indicating whether the hurdle is avoidable or not
 *     getType(): a method that returns the type of hurdle
 *
 * It has two constructors: a default constructor and a constructor that takes in the x-coordinate position, y-coordinate position, and path of the hurdle as arguments.
 */
public class TeleportationHurdle implements Hurdles {

    public static final  String type ="Teleportation";

    private int xPosition;
    private int yPosition;

    private String path;

    public final static Boolean isAvoidable = false;

    //Constructors
    public TeleportationHurdle(){

    }
    /**
    * This is a constructor method that initializes a new TeleportationHurdle object with the given xPosition, yPosition, and path.
     */
    public  TeleportationHurdle(int xPosition, int yPosition, String path){
        this.xPosition =xPosition;
        this.yPosition = yPosition;
        this.path = path;
    }

    //getter and setter Methods
    /**
    * This method represents the action that occurs when a player encounters this TeleportationHurdle object. It sets the player's xPosition and yPosition to random values and returns the modified player object.
     */
    @Override
    public Player action(Player p) {
        //have to write the code here for the teleportation
        Board b = new Board();
        do{

            int random =(int)(Math.random()*8) + 1;
            p.setxPosition((random * 60)+30);
            p.setyPosition((random * 60)+30);
        }while(b.hasHurdle(new Position(xPosition,yPosition) )|| b.hasPlayers(new Position(xPosition,yPosition)));

        return p;
    }
    /**
    * This is a getter method that returns the xPosition of this TeleportationHurdle object.
     */
    @Override
    public int getxPosition() {
        return xPosition;
    }
    /**
    * This is a setter method that sets the xPosition of this TeleportationHurdle object to the given value.
     */
    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }
    /**
    * This is a getter method that returns the yPosition of this TeleportationHurdle object.
     */
    @Override
    public int getyPosition() {
        return yPosition;
    }
    /**
    * This is a setter method that sets the yPosition of this TeleportationHurdle object to the given value.
     */
    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }
    /**
    * This is a getter method that returns the path of this TeleportationHurdle object.
     */
    @Override
    public String getPath() {
        return path;
    }
    /**
    * This is a setter method that sets the path of this TeleportationHurdle object to the given value.
     */
    public void setPath(String path) {
        this.path = path;
    }
    /**
    * This is a getter method that returns a boolean value indicating whether this TeleportationHurdle object is avoidable.
     */
    public boolean getIsAvoidable(){
        return this.isAvoidable;
    }
    /**
    * This is a getter method that returns the type of this TeleportationHurdle object.
     */
    public String getType(){
        return this.type;
    }
}
