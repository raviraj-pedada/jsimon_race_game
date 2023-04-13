package project.jsimon;

/**

 The Position class represents the x and y coordinates of a point in a two-dimensional plane.

 It has two constructors: a default constructor and a constructor that takes in the x and y positions as arguments.

 The class also has setter and getter methods for the x and y positions.
 */

public class Position {
    private int xPosition;
    private int yPosition;
    /**

     Constructs a new Position object with default x and y positions of 0.
     */
    public Position(){

    }
    /**

     Constructs a new Position object with the given x and y positions.
    * param - xPosition, the x position of the point
    * param - yPosition, the y position of the point
     */
    public Position(int xPosition, int yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }
    /**

     Sets the x position of the point.
    * param - xPosition, the new x position of the point
     */
    public void setxPosition(int xPosition){
        this.xPosition = xPosition;
    }
    /**

     Sets the y position of the point.
     * param - yPosition, the new y position of the point
     */
    public void setyPosition(int yPosition){
        this.yPosition = yPosition;
    }
    /**

     Returns the x position of the point.
     */
    public int getxPosition() {
        return xPosition;
    }
    /**

     Returns the y position of the point.
     */
    public int getyPosition() {
        return yPosition;
    }
}
