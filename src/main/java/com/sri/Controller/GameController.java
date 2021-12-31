package com.sri.Controller;

import com.sri.Player.Player;
import com.sri.Util.GameOption;
import com.sri.Util.Move;
import com.sri.Util.MoveStatus;

import java.util.List;

/*
    Defines interface for a controller
 */
public interface GameController {

    void registerPlayers(Player p1, Player p2);

    void startGame() throws PlayersNotResigteredException;

    MoveStatus evaluateWinnerForMove(GameOption player1Choice, GameOption player2Choice);

    default int getTotalMoves() {
        return 10;
    }  //Total games to be played

    void setTotalMoves(int totalMoves);

    List<Move> getMovesHistory();

    List<Move> getLastNMoves(int n);

}
