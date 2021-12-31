package com.sri;

import com.sri.Controller.BasicConsoleController;
import com.sri.Controller.GameController;
import com.sri.Controller.PlayersNotResigteredException;
import com.sri.Player.ConsolePlayer;
import com.sri.Player.CopyCatComputer;
import com.sri.Player.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class RockPaperScissorGame {
    static Logger logger = LoggerFactory.getLogger(RockPaperScissorGame.class);
    static int TIMES_TO_PLAY_DEFAULT = 10;

    public static void main(String[] args) {
        GameController controller = BasicConsoleController.getInstance();
        System.out.println(BasicConsoleController.welcomeMessage());
        int nMoves = scanTimestoPlay();
        System.out.println("Playing " + nMoves +" games" );
        System.out.println(BasicConsoleController.instructionsMessage());
        controller.setTotalMoves(nMoves);
        //Initialise players
        Player player1 = new ConsolePlayer("Human");
        Player player2 = new CopyCatComputer("Copycat Computer");
        controller.registerPlayers(player1, player2);
        try {
            controller.startGame();
        } catch (PlayersNotResigteredException e) {
            logger.debug("Game start failed with message: {}", e.getLocalizedMessage());
        }
        logger.debug("Game execution started");
    }

    public static int scanTimestoPlay() {
        Scanner scanner = new Scanner(System.in);
        int input = TIMES_TO_PLAY_DEFAULT; //default
        try {
            input = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Expected an integer. Defaulting to" + input + " moves");
        }
        return input;
    }
}
