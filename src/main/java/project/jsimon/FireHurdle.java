package project.jsimon;


import java.util.*;

import static project.jsimon.JSimonRace.initialPosition;
/**
 * The FireHurdle class represents a fire obstacle in a game.
 * It implements the Hurdles interface, which requires it to implement the action(), getxPosition(), getyPosition(), getType(), getPath(), and getIsAvoidable() methods.
 *
 * The FireHurdle class allows the game to represent and manipulate fire obstacles in a uniform manner.
 *
 * If the users enter the fire they will again start from their respective initial positions
 */

public class FireHurdle implements Hurdles{

    public static final  String type ="Fire";

    private int xPosition;
    private int yPosition;

    private String path;

    public final static Boolean isAvoidable = false;

    public FireHurdle(){

    }

    /**
    * The FireHurdle constructor takes in three arguments: an int value for xPosition, an int value for yPosition, and a String value for path. These values are used to initialize the corresponding fields of the FireHurdle object.
     */
    
    public FireHurdle(int xPosition, int yPosition, String path){
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.path = path;
    }

    /**
    
    * The setxPosition method takes in an int value for xPosition and sets the xPosition field of the FireHurdle object on which the method is called to this value.
    
     */
    public void setxPosition(int xPosition){
        this.xPosition =xPosition;
    }

    /**
    
    * The setyPosition method takes in an int value for yPosition and sets the yPosition field of the FireHurdle object on which the method is called to this value.

     */
    
    public void setyPosition(int yPosition){
        this.yPosition = yPosition;
    }

    /**
    
    * The setPath method takes in a String value for path and sets the path field of the FireHurdle object on which the method is called to this value.
     
     */
    public void setPath(String path){
        this.path = path;
    }
    /**
    
    * The getxPosition method returns type of int and returns the value of the xPosition field for the FireHurdle object on which the method is called.

     */

    public int getxPosition(){
        return  this.xPosition;
    }

    /**
    
    * The getyPosition method returns type of int and returns the value of the yPosition field for the FireHurdle object on which the method is called.

     */

    public  int getyPosition(){
        return  this.yPosition;
    }

    /**
    
    * It returns the value of the type field for the FireHurdle object on which the method is called.

     */
    @Override
    public String getType() {
        return type;
    }

    /**

    * The getPath method returns type of String and returns the value of the path field for the FireHurdle object on which the method is called.
     
     */

    public String getPath(){
        return this.path;
    }

    /**
    
    The getIsAvoidable method returns type of boolean and returns the value of the isAvoidable field for the FireHurdle   

     */
    public boolean getIsAvoidable(){
        return isAvoidable;
    }


/**

* The method takes in a single argument of type Player, which represents the player on which the action will be performed. 
* The method contains a for loop that iterates over the entries in the initialPosition field, which is a Map that maps Player objects to lists of Integer values representing positions on some kind of grid.
* For each entry in the initialPosition map, the method checks if the key (the Player object) is equal to the Player object passed as an argument to the method. If the keys are equal, 
  the method retrieves the list of Integer values for that entry and sets the xPosition and yPosition fields of the Player object to the first and second values in the list, respectively. The method then returns the modified Player object.
* If the Player object passed as an argument does not have an entry in the initialPosition map, the method returns null.

 */
    @Override
    public Player action(Player p) {

        for (Map.Entry<Player, ArrayList<Integer>> set : initialPosition.entrySet()) {
            if(set.getKey() == p){
                ArrayList<Integer> position = set.getValue();
                p.setxPosition(position.get(0));
                p.setyPosition(position.get(1));
                return p;
            }
        }

        return null;
    }
}
