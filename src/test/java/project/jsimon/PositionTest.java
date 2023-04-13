package project.jsimon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {
    @Test
    public void testDefaultConstructor() {
        Position p = new Position();
        assertEquals(0, p.getxPosition());
        assertEquals(0, p.getyPosition());
    }

    @Test
    public void testParameterizedConstructor() {
        Position p = new Position(1, 2);
        assertEquals(1, p.getxPosition());
        assertEquals(2, p.getyPosition());
    }
    @Test
    public void testSetMethods() {
        Position p = new Position();
        p.setxPosition(1);
        p.setyPosition(2);
        assertEquals(1, p.getxPosition());
        assertEquals(2, p.getyPosition());
    }
    @Test
    public void testGetMethods() {
        Position p = new Position(1, 2);
        assertEquals(1, p.getxPosition());
        assertEquals(2, p.getyPosition());
    }


}