package project.jsimon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiceTest {

    @Test
    void dice(){
        Dice d = new Dice();
        assertTrue(d instanceof  Dice);
    }

    @Test
    void rollDice2() {
        Dice d = new Dice();
        // Call the rollDice2 method and store the result
        int result = d.rollDice2();

        // Check that the result is within the expected range (1 to 4)
        assertTrue(result >= 1 && result <= 4);

    }

    @Test
    void rollDice1() {
        Dice d = new Dice();
        // Call the rollDice1 method and store the result
        String result = d.rollDice1();

        // Check that the result is either "Forward", "Backward", or "Missed Turn"
        assertTrue(result.equals("Forward") || result.equals("Backward") || result.equals("Missed Turn"));
    }
}