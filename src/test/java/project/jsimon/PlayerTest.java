package project.jsimon;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    @Test
    public void testDefaultConstructor() {
        Player player = new Player();
        assertNotNull(player);
        assertEquals(0, player.getScore());
        assertFalse(player.isMissTurn());
        assertNull(player.getName());
        assertEquals(0, player.getxPosition());
        assertEquals(0, player.getyPosition());
        assertEquals(20, player.getRadius(), 0);
        assertNotNull(player.getFill());
        assertEquals(Color.BLACK, player.getStroke());
    }

    @Test
    public void testParameterizedConstructor() {
        Player player = new Player("Player 1", 5, 10);
        assertNotNull(player);
        assertEquals(0, player.getScore());
        assertFalse(player.isMissTurn());
        assertEquals("Player 1", player.getName());
        assertEquals(5, player.getxPosition());
        assertEquals(10, player.getyPosition());
        assertEquals(20, player.getRadius(), 0);
        assertNotNull(player.getFill());
        assertEquals(Color.BLACK, player.getStroke());
    }

    @Test
    public void testSetGetScore() {
        Player player = new Player();
        player.setScore(100);
        assertEquals(100, player.getScore());
    }

    @Test
    public void testIsSetMissTurn() {
        Player player = new Player();
        player.setMissTurn(true);
        assertTrue(player.isMissTurn());
    }

    @Test
    public void testSetGetName() {
        Player player = new Player();
        player.setName("Player 1");
        assertEquals("Player 1", player.getName());
    }

    @Test
    public void testSetGetXPosition() {
        Player player = new Player();
        player.setxPosition(10);
        assertEquals(10, player.getxPosition());
    }

    @Test
    public void testSetGetYPosition() {
        Player player = new Player();
        player.setyPosition(20);
        assertEquals(20, player.getyPosition());
    }



}