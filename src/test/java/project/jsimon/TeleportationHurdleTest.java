package project.jsimon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeleportationHurdleTest {

    @Test
    public void testDefaultConstructor() {
        TeleportationHurdle th = new TeleportationHurdle();
        assertEquals(0, th.getxPosition());
        assertEquals(0, th.getyPosition());
        assertNull(th.getPath());
    }

    @Test
    public void testParameterizedConstructor() {
        TeleportationHurdle th = new TeleportationHurdle(1, 2, "path");
        assertEquals(1, th.getxPosition());
        assertEquals(2, th.getyPosition());
        assertEquals("path", th.getPath());
    }

    @Test
    public void testActionMethod() {
        TeleportationHurdle th = new TeleportationHurdle();
        Player p = new Player();
        p.setxPosition(10);
        p.setyPosition(10);
        p = th.action(p);
        assertNotEquals(10, p.getxPosition());
        assertNotEquals(10, p.getyPosition());
    }

    @Test
    public void testGetMethods() {
        TeleportationHurdle th = new TeleportationHurdle();
        assertEquals("Teleportation", th.getType());
        assertFalse(th.getIsAvoidable());
    }

    @Test
    public void testSetMethods() {
        TeleportationHurdle th = new TeleportationHurdle();
        th.setxPosition(1);
        th.setyPosition(2);
        th.setPath("path");
        assertEquals(1, th.getxPosition());
        assertEquals(2, th.getyPosition());
        assertEquals("path", th.getPath());
    }


}