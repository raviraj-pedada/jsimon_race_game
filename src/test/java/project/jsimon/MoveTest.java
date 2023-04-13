package project.jsimon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveTest {

    @Test
    public void testMoveForward() {
        // Create a new Move object and a Player object
        Move move = new Move();
        Player player = new Player();

        // Set the position of the player
        player.setxPosition(100);
        player.setyPosition(100);

        // Call the moveForward method and store the result
        Position result = move.moveForward(player.getxPosition(), player.getyPosition());

        // Check that the y position of the player was correctly updated
        assertEquals(40, result.getyPosition());

        // Check that the x position of the player was not changed
        assertEquals(100, result.getxPosition());
    }
    @Test
    public void testMoveBackward() {
        // Create a new Move object and a Player object
        Move move = new Move();
        Player player = new Player();

        // Set the position of the player
        player.setxPosition(100);
        player.setyPosition(100);

        // Call the moveBackward method and store the result
        Position result = move.moveBackward(player.getxPosition(), player.getyPosition());

        // Check that the y position of the player was correctly updated
        assertEquals(160, result.getyPosition());

        // Check that the x position of the player was not changed
        assertEquals(100, result.getxPosition());
    }
    @Test
    public void testMoveSideRight() {
        // Create a new Move object and a Player object
        Move move = new Move();
        Player player = new Player();

        // Set the position of the player
        player.setxPosition(100);
        player.setyPosition(100);

        // Call the moveSideRight method and store the result
        Position result = move.moveSideRight(player.getxPosition(), player.getyPosition());

        // Check that the x position of the player was correctly updated
        assertEquals(160, result.getxPosition());

        // Check that the y position of the player was not changed
        assertEquals(100, result.getyPosition());
    }

    @Test
    public void testMoveSideLeft() {
        // Create a new Move object and a Player object
        Move move = new Move();
        Player player = new Player();

        // Set the position of the player
        player.setxPosition(100);
        player.setyPosition(100);

        // Call the moveSideLeft method and store the result
        Position result = move.moveSideLeft(player.getxPosition(), player.getyPosition());

        // Check that the x position of the player was correctly updated
        assertEquals(40, result.getxPosition());

        // Check that the y position of the player was not changed
        assertEquals(100, result.getyPosition());
    }


}