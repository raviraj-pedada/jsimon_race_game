package project.jsimon;

import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Pane;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static project.jsimon.JSimonRace.initialPosition;


class JSimonRaceTest {
    @Test
    public void testCreatePlayer() {
        // Test with valid input
        String name = "Player 1";
        JSimonRace race = new JSimonRace();
        int pos = 1;
        Player player = race.createPlayer(name, pos);
        assertEquals(name, player.getName());
        assertEquals(30, player.getxPosition());
        assertEquals(570, player.getyPosition());
        assertTrue(initialPosition.containsKey(player));
        assertEquals(Arrays.asList(30, 570), initialPosition.get(player));


    }


}