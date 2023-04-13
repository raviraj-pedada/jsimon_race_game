package project.jsimon;

/**
 * The Move class represents a player's movement on a board in a game. It has two private fields, xPosition and yPosition, which store the x and y coordinates of the player's position, respectively.
 *
 * The Move class has a default constructor and four methods to move the player in different directions: moveForward(), moveBackward(), moveSideRight(), and moveSideLeft(). These methods take the player's current x and y coordinates as arguments and return a new Position object with the updated coordinates after the move.
 *
 * The move() method is a wrapper method that takes a Player object and a string representing the direction of the move as arguments and calls the appropriate move method based on the direction.
 *
 * The Move class allows the game to update a player's position on the board based on the player's dice roll.
 */
public class Move {

    private int xPosition;

    private int yPosition;
    public Move(){

    }
    /**
    * The move method is used to move a player object in a particular direction on a grid. The method takes in two arguments:
    * p: a Player object representing the player that needs to be moved
    * direction: a String value representing the direction in which the player needs to be moved. 
    * The possible values for direction are "Forward", "right", "left", and "backward".
    * The method first initializes a Position object called position and sets its xPosition and yPosition values to the xPosition and yPosition values of the player object passed as an argument.
    * It uses an if-else statement to check the value of the direction argument and calls the appropriate method to update the player's position based on the direction. 
      The methods called are moveForward, moveSideRight, moveSideLeft, and moveBackward, which update the xPosition and yPosition values of the position object based on the direction of movement.
    * Finally, the method returns the updated position object.
    
     */
    public Position move(Player p, String direction ){

        Position position = new Position();

        xPosition = p.getxPosition();
        yPosition = p.getyPosition();
        if(direction == "Forward"){
            position = moveForward(xPosition, yPosition);
        } else if (direction == "right") {
            position = moveSideRight(xPosition, yPosition);
        } else if (direction == "left") {
            position = moveSideLeft(xPosition, yPosition);
        } else {
            position = moveBackward(xPosition,yPosition);
        }

        return position;

    }
    /**
    
    * This method moves the object on which it is called forward by modifying its x and y position coordinates. It takes two integer parameters: 'row' and 'col', which represent the object's current row and column position on a grid.
    * The method sets the object's x position to the value of the 'row' parameter and its y position to the value of the 'col' parameter minus 60. If the resulting y position is less than or equal to 30, the y position is set to 30. 
    * This prevents the object from moving outside of the grid.
    * The method returns a new Position object with the updated x and y position coordinates. The Position class is a custom class that stores an x and y position as integer fields.

     */
    public Position moveForward(int row, int col) {
        this.xPosition = row;
        this.yPosition = col - 60;
        if(yPosition<=30){
            this.yPosition = 30;
        }
        return new Position(xPosition,yPosition);

    }

    /**
    * This method moves a player backward on the game board. It takes in the current row and column position of the player as arguments, 
      and calculates the new position by decreasing the column position by 60. The new position is then returned as a Position object. 
    * If the new column position is greater than or equal to 570, the column position is set to 570 to ensure that the player stays within the bounds of the game board.

     */
    public Position moveBackward(int row, int col){
        this.xPosition = row;
        this.yPosition = col + 60;
        if(yPosition>=570){
            yPosition = 570;
        }

        return new Position(xPosition,yPosition);

    }
    /**
    *This method moves a player to the right by 60 units. If the resulting x-position is greater than 600, the player's x-position is set to 570.
    * param - row, the current x-position of the player
    * param - col, the current y-position of the player
    */

    public Position moveSideRight(int row, int col){
        this.yPosition = col;
        this.xPosition = row + 60;
        if(this.xPosition >600){
            xPosition = 570;
        }

        return new Position(this.xPosition, this.yPosition);
    }
    /**
    *This method moves a player to the left by 60 units. If the resulting x-position is Less than or equals 0, the player's x-position is set to 30.
    * param - row, the current x-position of the player
    * param - col, the current y-position of the player
    */
    public Position moveSideLeft(int row, int col){

        this.yPosition = col;
        this.xPosition = row - 60;
        if(this.xPosition <= 0){
            xPosition = 30;
        }

        return new Position(this.xPosition, this.yPosition);

    }

}

