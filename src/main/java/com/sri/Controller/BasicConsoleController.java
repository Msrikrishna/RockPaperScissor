package com.sri.Controller;

import com.sri.Player.Player;
import com.sri.Util.GameOption;
import com.sri.Util.Move;
import com.sri.Util.MoveStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class BasicConsoleController implements GameController{
    static Logger logger = LoggerFactory.getLogger(BasicConsoleController.class);
    static List<Move> movesHistory;
    Player player1;
    Player player2;
    int player1Score = 0;
    int player2Score = 0;
    int totalMoves = 10; //default

    private BasicConsoleController() {
        movesHistory = new ArrayList<>();
    }

    private static BasicConsoleController instance = new BasicConsoleController();

    public static BasicConsoleController getInstance()
    {
        return instance;
    }

    @Override
    public int getTotalMoves() {
        return this.totalMoves;
    }
    @Override
    public void setTotalMoves(int totalMoves) {
        this.totalMoves = totalMoves;
    }



    public static String welcomeMessage() {
        String welcome =  "           Welcome to          \n"+
                "   Rock Paper Scissor Game    \n"+
                "                               \n" +
                "   Please enter total games you would like to play";
        return welcome;
    }

    public static String instructionsMessage() {
        String instructionsMessage =  "   Enter the following digits to select option :         \n"+
                "            1. ROCK            \n"+
                "            2. PAPER           \n"+
                "            3. SCISSOR         \n"+
                "                               \n";
        return instructionsMessage;
    }


    @Override
    public void registerPlayers(Player p1, Player p2) {
            this.player1 = p1;
            this.player2 = p2;
    }

    @Override
    public void startGame() throws PlayersNotResigteredException {
        if (player1 == null || player2 == null) throw new PlayersNotResigteredException();
        //Facilitate moves
        for (int move = 0; move < getTotalMoves(); move++) {
            MoveStatus player1Status = evaluateWinnerForMove(player1.makeChoice(), player2.makeChoice());
            switch (player1Status) {
                case WIN:   System.out.println(player1.getPlayerName() + " wins");
                            player1Score++;
                            break;
                case LOSS:  System.out.println(player2.getPlayerName() + " wins" );
                            player2Score++;
                            break;
                case DRAW:  System.out.println("Draw");
                            break;
                case INDECISIVE:  System.out.println("Skipping current move. Please enter only 1, 2 or 3");
                                  break;
                default:          logger.debug("Unknown Move status encountered");
            }
        }
        System.out.format("Game ended. Wins for %s: %d. Wins for %s: %d"
                , player1.getPlayerName()
                , player1Score
                , player2.getPlayerName()
                , player2Score);
    }

    @Override
    public MoveStatus evaluateWinnerForMove(GameOption player1Choice, GameOption player2Choice) {
        Move currMove = new Move(player1Choice, player2Choice);
        movesHistory.add(currMove);
        return currMove.decidePlayer1Status();
    }

     public List<Move> getMovesHistory() {
        return movesHistory;
    }

    @Override
    public List<Move> getLastNMoves(int n) {
        int listSize = movesHistory.size();
        return movesHistory.subList(Math.max(listSize - n, 0), listSize);
    }



}
