package project.jsimon;

/**
 * The ScoreCard class represents a player's score in the game.
 * It has two fields, name and score, which represent the player's name and the player's score, respectively.
 * The ScoreCard class has getter and setter methods for both fields.
 * This class can be used to keep track of the scores of multiple players in the game and to display the scores in a leaderboard.
 */
public class ScoreCard {
    private String name;
    private int score;

    /**
    * This is a constructor that creates a new instance of the ScoreCard class with the given name and score.

     */
    public ScoreCard(String name, int score) {
        this.name = name;
        this.score = score;
    }
    /**
    * This is a getter method that returns the name field of the ScoreCard object.
     */
    public String getName() {
        return name;
    }

    /**
    * This is a setter method that sets the value of the name field of the ScoreCard object to the given name.
    */

    public void setName(String name) {
        this.name = name;
    }
    /**
    * This is a getter method that returns the score field of the ScoreCard object.
    */
    public int getScore() {
        return score;
    }
    /**
    * This is a setter method that sets the value of the score field of the ScoreCard object to the given score.
     */
    public void setScore(int score) {
        this.score = score;
    }
}
