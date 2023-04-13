package project.jsimon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoreCardTest {

    @Test
    public void testParameterizedConstructor() {
        ScoreCard sc = new ScoreCard("Player 1", 100);
        assertEquals("Player 1", sc.getName());
        assertEquals(100, sc.getScore());
    }
    @Test
    public void testSetMethods() {
        ScoreCard sc = new ScoreCard("Player 1", 100);
        sc.setName("Player 2");
        sc.setScore(200);
        assertEquals("Player 2", sc.getName());
        assertEquals(200, sc.getScore());
    }
    @Test
    public void testGetMethods() {
        ScoreCard sc = new ScoreCard("Player 1", 100);
        assertEquals("Player 1", sc.getName());
        assertEquals(100, sc.getScore());
    }


}