package com.sri.Util;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MoveTest {

    @Test
    public void decidePlayer1Status() {
        Move m1 = new Move(GameOption.PAPER, GameOption.SCISSOR);
        assertEquals(m1.decidePlayer1Status(), MoveStatus.LOSS);

        Move m2 = new Move(GameOption.SCISSOR, GameOption.PAPER);
        assertEquals(m2.decidePlayer1Status(), MoveStatus.WIN);

        Move m3 = new Move(GameOption.PAPER, GameOption.PAPER);
        assertEquals(m3.decidePlayer1Status(), MoveStatus.DRAW);

        Move m4 = new Move(GameOption.UNKNOWNOPTION, GameOption.SCISSOR);
        assertEquals(m4.decidePlayer1Status(), MoveStatus.INDECISIVE);

        Move m5 = new Move(GameOption.ROCK, GameOption.UNKNOWNOPTION);
        assertEquals(m5.decidePlayer1Status(), MoveStatus.INDECISIVE);

        Move m6 = new Move(GameOption.UNKNOWNOPTION, GameOption.UNKNOWNOPTION);
        assertEquals(m6.decidePlayer1Status(), MoveStatus.INDECISIVE);
    }
}