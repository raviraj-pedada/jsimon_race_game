package project.jsimon;

/**
 * The FenceHurdle class represents a fence obstacle in a game. It implements the Hurdles interface, which requires it to implement the action(), getxPosition(), getyPosition(), getType(), getPath(), and getIsAvoidable() methods.
 *
 * The FenceHurdle class has four private fields: xPosition, yPosition, type, and isAvoidable.
 * The xPosition and yPosition fields store the x and y coordinates of the fence, respectively.
 * The type field stores a string representing the type of obstacle, which is "Fence" for this class.
 * The isAvoidable field stores a boolean value indicating whether the fence can be avoided or not, which is true for this class.
 *
 * The class has a default constructor that initializes the xPosition, yPosition, and path fields to 0 and the isAvoidable field to true.
 * It also a parameterized constructor that takes the x and y coordinates and path of the fence as arguments and sets the corresponding fields.
 *
 * The FenceHurdle class allows the game to represent and manipulate fence obstacles in a uniform manner.
 */

public class FenceHurdle implements Hurdles {
    private  int xPosition;
    private int yPosition;
    private static final  String type ="Fence";
    private static boolean isAvoidable = true;
    private String path;

    public FenceHurdle(){
    }

/**
* This is a getter method that returns the value of the 'path' field of the object on which it is called. The 'path' field is a string representing the path to an image file.

 */
    public String getPath() {
        return path;
    }

/**

* The FenceHurdle constructor used to create objects of the FenceHurdle class.
* The constructor takes in three arguments: an int value for the xPosition, an int value for the yPosition, and a String value for the path.
* These values are used to initialize the corresponding fields of the FenceHurdle object.
* The xPosition and yPosition fields represent the position of the FenceHurdle object on some kind of grid, while the path field likely 
  refers to a file path for an image that will be used to represent the FenceHurdle visually.

 */

    public FenceHurdle(int xPosition, int yPosition, String path){

        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.path = path;

    }

/**
* This method is intended to be overridden by a subclass to provide a specific implementation of the action on a Player object.
 */
    @Override
    public Player action(Player P) {
        return null;
    }

/**

* It returns the value of the xPosition field for the object on which the method is called.

 */
    @Override
    public int getxPosition() {
        return xPosition;
    }

/**
 * The setxPosition method takes in an int value for xPosition and sets the xPosition field of the object on which the method is called to this value.
 */

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

/**

* The getyPosition method returns type of int. It returns the value of the yPosition field for the object on which the method is called.

 */
    @Override
    public int getyPosition() {
        return yPosition;
    }

/**

* The getType method returns type of String and returns the value of the type field for the object on which the method is called.

 */

    public String getType(){
        return this.type;
    }

/**

The setyPosition method takes in an int value for yPosition and sets the yPosition field of the object on which the method is called to this value.

 */
    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

/**

* The getIsAvoidable method returns type of boolean and returns the value of the isAvoidable field for the object on which the method is called.

 */
    public boolean getIsAvoidable() {
        return isAvoidable;
    }

/**

* The setPath method takes in a String value for path and sets the path field of the object on which the method is called to this value.

 */

    public void setPath(String path) {
        this.path = path;
    }

}
