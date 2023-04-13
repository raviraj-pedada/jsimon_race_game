package project.jsimon;

/**
 * The Hurdles interface represents an obstacle that a player may encounter in a game. It has six methods: action(), getxPosition(), getyPosition(), getType(), getPath(), and getIsAvoidable().
 *
 * action() takes a Player object as an argument and returns a modified version of the player based on the effect of the obstacle.
 *
 * getxPosition() and getyPosition() return the x and y coordinates of the obstacle, respectively.
 *
 * getType() returns a string indicating the type of obstacle.
 *
 * getPath() returns a string representing the path of the obstacle.
 *
 * getIsAvoidable() returns a boolean value indicating whether the obstacle can be avoided or not.
 *
 * The Hurdles interface is intended to be implemented by classes that represent different types of obstacles in a game. It allows the game to treat all types of obstacles in a uniform manner.
 */
public interface Hurdles {

    Player action(Player P);

    int  getxPosition();

    int getyPosition();

    String getType();

    String getPath();

    boolean getIsAvoidable();

}
