package com.sri.Util;


import java.util.HashMap;
import java.util.Map;


/*
  A move is defined as a choice from both players resulting in a Win/ Loss/ Draw
 */
public class Move {

    final static Map<GameOption, GameOption> beatsMap = new HashMap<>() {{
        put(GameOption.PAPER, GameOption.ROCK);
        put(GameOption.ROCK, GameOption.SCISSOR);
        put(GameOption.SCISSOR, GameOption.PAPER);
    }};

    GameOption player1Choice;
    GameOption player2Choice;


    public Move(GameOption player1Choice, GameOption player2Choice) {
        this.player1Choice = player1Choice;
        this.player2Choice = player2Choice;
    }

    public MoveStatus decidePlayer1Status() {
        if (player1Choice == GameOption.UNKNOWNOPTION || player2Choice == GameOption.UNKNOWNOPTION) {
            return MoveStatus.INDECISIVE;
        }
        if (player1Choice == player2Choice) {
            return MoveStatus.DRAW;
        }
        if (beatsMap.get(player1Choice).equals(player2Choice)) { //Player 1  beats player 2
            return  MoveStatus.WIN;
        } else {
            return MoveStatus.LOSS;
        }
    }

    public GameOption getPlayer1Choice() {
        return player1Choice;
    }

    public GameOption getPlayer2Choice() {
        return player2Choice;
    }
}

