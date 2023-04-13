package project.jsimon;

/**
 * The Dice class represents a dice with a value that can be rolled. It has two methods: rollDice1() and rollDice2().
 * rollDice1() generates a random integer within the range 1 to 4 and returns a string based on the value. If the value is 1 or 2, it returns "Forward". If the value is 3, it returns "Backward". If the value is 4, it returns "Missed Turn".
 * rollDice2() generates a random integer within the range 1 to 4 and returns the value as an integer.
 * The class has a private field, value, that stores the current value of the dice. The value is set in both rollDice1() and rollDice2().
 * The Dice class has a default constructor that initializes the value to 0.
 */

public class Dice{
    private int value;

    //constructor
    public Dice(){
    }

/**
    
* The rollDice2 method generates a random integer between 1 and 4 (inclusive) using the Math.random method.
* The method first declares the variables max and min and sets them to 4 and 1, respectively. 
* It then calculates the range between these two values using the range variable.
* The method then generates a random number within this range by multiplying the result of Math.random by the range and adding the minimum value (min).
* The random number is cast to an int data type and returned as the result of the method. The value variable is also set to this result before it is returned.
     */

    public int rollDice2(){
        // define the range
        int max = 4;
        int min = 1;
        int range = max - min + 1;
        // generate random numbers within 1 to 4
        value= (int)(Math.random() * range) + min;
        return value;
    }

/**

* This method generates a random number between 1 and 4 (inclusive) and returns a string value based on the generated number. If the generated number is 1 or 2, the method returns the string "Forward". 
* If the generated number is 3, the method returns the string "Backward". If the generated number is 4, the method returns the string "Missed Turn".
* The method uses the Math.random() method to generate a random double value between 0 (inclusive) and 1 (exclusive). 
* It then multiplies this value by the range of possible values (4 - 1 + 1) and adds the minimum value (1) to get a random integer value within the desired range. 
* It then uses a switch statement to return the corresponding string value based on the generated number.
 */

    public String rollDice1(){

        // define the range
        int max = 4;
        int min = 1;
        int range = max - min + 1;

        // generate random numbers within 1 to 4
        value= (int)(Math.random() * range) + min;
        String s = "";
        switch(value){
            case 1:
            case 2:
                s ="Forward";
                break;
            case 3: s = "Backward";
                break;
            case 4: s = "Missed Turn";
                break;
        }
        return s;
    }
}
