package project.jsimon;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static project.jsimon.JSimonRace.initialPosition;

class FireHurdleTest {
    @Test
    public void testGetType() {
        // Create a new FireHurdle object
        FireHurdle fire = new FireHurdle();

        // Check that the type of the fire is "Fire"
        assertEquals("Fire", fire.getType());
    }

    @Test
    public void testGetIsAvoidable() {
        // Create a new FireHurdle object
        FireHurdle fire = new FireHurdle();

        // Check that the fire is not avoidable
        assertFalse(fire.getIsAvoidable());
    }

    @Test
    public void testGetPosition() {
        // Create a new FireHurdle object with a specified x and y position
        FireHurdle fire = new FireHurdle(5, 10, "path");

        // Check that the x and y position of the fire are correct
        assertEquals(5, fire.getxPosition());
        assertEquals(10, fire.getyPosition());
    }

    @Test
    public void testSetPosition() {
        // Create a new FireHurdle object with a default x and y position
        FireHurdle fire = new FireHurdle();

        // Set the x and y position of the fire
        fire.setxPosition(5);
        fire.setyPosition(10);

        // Check that the x and y position of the fire were correctly set
        assertEquals(5, fire.getxPosition());
        assertEquals(10, fire.getyPosition());
    }

    @Test
    public void testGetSetPath() {
        // Create a new FireHurdle object with a default path
        FireHurdle fire = new FireHurdle();

        // Set the path of the fire
        fire.setPath("path");

        // Check that the path of the fire was correctly set
        assertEquals("path", fire.getPath());
    }

    @Test
    public void testAction() {
        // Create a new FireHurdle object and a Player object
        FireHurdle fire = new FireHurdle();
        Player player = new Player();

        // Set the initial position of the player
        initialPosition.put(player, new ArrayList<>(Arrays.asList(5, 10)));

        // Call the action method and store the result
        Player result = fire.action(player);

        // Check that the x and y position of the player were correctly set
        assertEquals(5, result.getxPosition());
        assertEquals(10, result.getyPosition());
    }


}