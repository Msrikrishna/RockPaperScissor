package com.sri.Player;

import com.sri.Util.GameOption;
import com.sri.Util.PlayerType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class ConsolePlayer implements Player {
    static Logger logger = LoggerFactory.getLogger(ConsolePlayer.class);
    String name = "Human";

    public ConsolePlayer(String name) {
        this.name = name;
    }

    @Override
    public String getPlayerName() {
        return name;
    }

    @Override
    public PlayerType getPlayerType() { return PlayerType.HUMAN;}

    @Override
    public GameOption makeChoice() {
        Scanner scanner = new Scanner(System.in);
        int curChoice;
        try{
            curChoice = scanner.nextInt();
        } catch (Exception e){
            System.out.println("Incorrect input entered"); //handle incorrect
            logger.debug("Exception occurred while parsing input: {}", e);
            return GameOption.UNKNOWNOPTION;
        }
        logger.debug("Console player chose: " +  GameOption.fromInteger(curChoice));

        GameOption choiceMade = GameOption.fromInteger(curChoice);
        if (choiceMade == GameOption.UNKNOWNOPTION) {
            logger.debug("Incorrect value entered. Please try again");
        }
        return choiceMade;
    }
}
