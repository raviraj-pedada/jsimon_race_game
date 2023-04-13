package project.jsimon;


import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


/**
 * The Tile class represents a single tile on the board in the JSimonRace game.
 * It extends the Rectangle class and has a width and height equal to the tileSize constant defined in the JSimonRace class.
 */
public class Tile extends Rectangle {

    //here we have extended the tile to Rectangle as the tile in the board are rectangles
    // all the properties of the Rectangle are available here

    /**
     *The Tile class has a single constructor, which takes two integer arguments: x and y.
     *These arguments are not used within the constructor body, so it is not clear what their purpose is.
     *It is possible that they are intended to be used to specify the position of the Tile on the game board, or to distinguish between different types of Tile objects.
     * param x
     * param y
     */
    public Tile(int x, int y){
        setWidth(JSimonRace.tileSize);
        setHeight(JSimonRace.tileSize);
        setFill(Color.WHITE);
        setStroke(Color.BLACK);
    }
}
