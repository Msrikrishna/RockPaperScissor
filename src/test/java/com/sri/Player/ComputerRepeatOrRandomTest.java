package com.sri.Player;

import com.sri.Util.GameOption;
import com.sri.Util.PlayerType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComputerRepeatOrRandomTest {

    static Player player;

    @BeforeAll
    static void setUp() {
        player = new CopyCatComputer("Copycat Computer");
    }

    @Test
    void getPlayerNameTest() {
        assertEquals(player.getPlayerName(), "Copycat Computer");
    }

    @Test
    void getplayerTypeTest() {
        assertEquals(player.getPlayerType(), PlayerType.COMPUTER);
    }

    @Test
    void makeChoiceTest() {
        for (int i = 0; i < 25; i++) {
            GameOption choice = player.makeChoice();
            assertNotNull(choice);
            assertNotEquals(choice.getValue(), -1); //Always makes a known but random choice
        }
    }
}