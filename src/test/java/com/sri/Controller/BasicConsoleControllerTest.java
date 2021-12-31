package com.sri.Controller;

import com.sri.Player.ComputerRandom;
import com.sri.Player.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasicConsoleControllerTest {

    GameController controller;

    @BeforeEach
    void setUp() {
        controller = BasicConsoleController.getInstance();
    }

    @Test
    void setTotalMoves() {
        controller.setTotalMoves(50);
        assertEquals(controller.getTotalMoves(), 50);
    }

    @Test
    void playersNotRegisteredTest() {
        Player p1 = new ComputerRandom("Computer-1");
        Player p2 = new ComputerRandom("Computer-2");
        controller.setTotalMoves(20);
        controller.registerPlayers(null, null); //Mocking singleton
        assertThrows(PlayersNotResigteredException.class,
                () -> controller.startGame(), "Players need to be registered before starting the game");
    }

    @Test
    void getMovesHistory() {
        //Init players
        Player p1 = new ComputerRandom("Computer-1");
        Player p2 = new ComputerRandom("Computer-2");
        controller.registerPlayers(p1, p2);
        controller.setTotalMoves(20);
        try {
            controller.startGame();
            for(int i = 0; i < 20; i++) { //Performing moves 20 times
                controller.evaluateWinnerForMove(p1.makeChoice(), p2.makeChoice());
            }
        } catch (PlayersNotResigteredException e) {
            e.printStackTrace();
        }
        assertEquals(controller.getTotalMoves(), 20);
    }

    @Test
    void getLastNMoves() {
        //Init players
        Player p1 = new ComputerRandom("Computer-1");
        Player p2 = new ComputerRandom("Computer-2");
        controller.registerPlayers(p1, p2);
        controller.setTotalMoves(100);
        try {
            controller.startGame();
            for(int i = 0; i < 8; i++) { //Performing moves 20 times
                controller.evaluateWinnerForMove(p1.makeChoice(), p2.makeChoice());
            }
        } catch (PlayersNotResigteredException e) {
            e.printStackTrace();
        }
        assertEquals(controller.getLastNMoves(8).size(), 8);
    }
}