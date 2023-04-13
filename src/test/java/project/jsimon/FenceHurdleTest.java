package project.jsimon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FenceHurdleTest {
    @Test
    public void testGetSetPath() {
        // Create a new FenceHurdle object with a default path
        FenceHurdle fence = new FenceHurdle();

        // Set the path of the fence
        fence.setPath("path");

        // Check that the path of the fence was correctly set
        assertEquals("path", fence.getPath());
    }

    @Test
    public void testAction() {
        // Create a new FenceHurdle object and a Player object
        FenceHurdle fence = new FenceHurdle();
        Player player = new Player();

        // Call the action method and store the result
        Player result = fence.action(player);

        // Check that the result is null
        assertNull(result);
    }

    @Test
    public void testGetPosition() {
        // Create a new FenceHurdle object with a specified x and y position
        FenceHurdle fence = new FenceHurdle(5, 10, "path");

        // Check that the x and y position of the fence are correct
        assertEquals(5, fence.getxPosition());
        assertEquals(10, fence.getyPosition());
    }

    @Test
    public void testSetPosition() {
        // Create a new FenceHurdle object with a default x and y position
        FenceHurdle fence = new FenceHurdle();

        // Set the x and y position of the fence
        fence.setxPosition(5);
        fence.setyPosition(10);

        // Check that the x and y position of the fence were correctly set
        assertEquals(5, fence.getxPosition());
        assertEquals(10, fence.getyPosition());
    }

    @Test
    void getType() {
        // Create a new FenceHurdle object
        FenceHurdle fence = new FenceHurdle();

        // Check that the type of the fence is "Fence"
        assertEquals("Fence", fence.getType());
    }


    @Test
    void getIsAvoidable() {
        // Create a new FenceHurdle object
        FenceHurdle fence = new FenceHurdle();

        // Check that the fence is avoidable
        assertTrue(fence.getIsAvoidable());
    }

}