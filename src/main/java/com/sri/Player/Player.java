package com.sri.Player;
import com.sri.Util.GameOption;
import com.sri.Util.PlayerType;

/*
    Defines the interface of a player. Can be human, computer or hybrid
 */
public interface Player {
     int score = 0;

     String getPlayerName();
     PlayerType getPlayerType();

     //A blocking call till the player makes a move
     GameOption makeChoice();
}
