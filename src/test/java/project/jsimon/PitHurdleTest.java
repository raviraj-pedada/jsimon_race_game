package project.jsimon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PitHurdleTest {

    @Test
    public void testDefaultConstructor() {
        PitHurdle pitHurdle = new PitHurdle();
        assertNotNull(pitHurdle);
        assertEquals(0, pitHurdle.getxPosition());
        assertEquals(0, pitHurdle.getyPosition());
        assertNull(pitHurdle.getPath());
        assertEquals("Pit", pitHurdle.getType());
        assertTrue(pitHurdle.getIsAvoidable());
    }

    @Test
    public void testParameterizedConstructor() {
        PitHurdle pitHurdle = new PitHurdle(5, 10, "/path/to/pit.png");
        assertNotNull(pitHurdle);
        assertEquals(5, pitHurdle.getxPosition());
        assertEquals(10, pitHurdle.getyPosition());
        assertEquals("/path/to/pit.png", pitHurdle.getPath());
        assertEquals("Pit", pitHurdle.getType());
        assertTrue(pitHurdle.getIsAvoidable());
    }

    public void testGetType() {
        // Create a new PitHurdle object
        PitHurdle pit = new PitHurdle();

        // Check that the type of the pit is "Pit"
        assertEquals("Pit", pit.getType());
    }

    public void testGetIsAvoidable() {
        // Create a new PitHurdle object
        PitHurdle pit = new PitHurdle();

        // Check that the pit is avoidable
        assertTrue(pit.getIsAvoidable());
    }

    public void testGetPosition() {
        // Create a new PitHurdle object with a specified x and y position
        PitHurdle pit = new PitHurdle(5, 10, "path");

        // Check that the x and y position of the pit are correct
        assertEquals(5, pit.getxPosition());
        assertEquals(10, pit.getyPosition());
    }

    public void testSetPosition() {
        // Create a new PitHurdle object with a default x and y position
        PitHurdle pit = new PitHurdle();

        // Set the x and y position of the pit
        pit.setxPosition(5);
        pit.setyPosition(10);

        // Check that the x and y position of the fire were correctly set
        assertEquals(5, pit.getxPosition());
        assertEquals(10, pit.getyPosition());

    }
    @Test
    public void testAction() {
        // Create a new FenceHurdle object and a Player object
        PitHurdle pit = new PitHurdle();
        Player player = new Player();

        // Call the action method and store the result
        Player result = pit.action(player);

        // Check that the result is null
        assertNull(result);
    }


}