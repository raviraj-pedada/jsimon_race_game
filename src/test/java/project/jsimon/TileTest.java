package project.jsimon;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TileTest {

    @Test
    public void testConstructor() {
        Tile t = new Tile(1, 2);
        assertEquals(JSimonRace.tileSize, t.getWidth(), 0);
        assertEquals(JSimonRace.tileSize, t.getHeight(), 0);
        assertEquals(Color.WHITE, t.getFill());
        assertEquals(Color.BLACK, t.getStroke());
    }

    @Test
    public void testSetSizeMethods() {
        Tile t = new Tile(1, 2);
        t.setWidth(50);
        t.setHeight(100);
        assertEquals(50, t.getWidth(), 0);
        assertEquals(100, t.getHeight(), 0);
    }

    @Test
    public void testSetColorMethods() {
        Tile t = new Tile(1, 2);
        t.setFill(Color.RED);
        t.setStroke(Color.GREEN);
        assertEquals(Color.RED, t.getFill());
        assertEquals(Color.GREEN, t.getStroke());
    }

    @Test
    public void testGetMethods() {
        Tile t = new Tile(1, 2);
        assertEquals(JSimonRace.tileSize, t.getWidth(), 0);
        assertEquals(JSimonRace.tileSize, t.getHeight(), 0);
        assertEquals(Color.WHITE, t.getFill());
        assertEquals(Color.BLACK, t.getStroke());
    }



}