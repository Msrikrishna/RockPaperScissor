package com.sri.Player;

import com.sri.Controller.BasicConsoleController;
import com.sri.Util.GameOption;
import com.sri.Util.Move;
import com.sri.Util.PlayerType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/*
  Copies player's consecutive moves
 */
public class CopyCatComputer  implements Player{
    static Logger logger = LoggerFactory.getLogger(CopyCatComputer.class);
    String name = "Copycat Computer";

    final static Map<GameOption, GameOption> canBeBeatByMap = new HashMap<>() {{
        put(GameOption.ROCK, GameOption.PAPER);
        put(GameOption.PAPER, GameOption.SCISSOR);
        put(GameOption.SCISSOR, GameOption.ROCK);
    }};

    public CopyCatComputer(String name) {
        this.name = name;
    }

    @Override
    public String getPlayerName() {
        return name;
    }

    @Override
    public PlayerType getPlayerType() {
        return PlayerType.COMPUTER;
    }

    @Override
    public GameOption makeChoice() {
        GameOption choice;
        List<Move> last3Moves = BasicConsoleController.getInstance().getLastNMoves(3);
        if (last3Moves.size() > 0 && areAllValuesSame(last3Moves)) {
            choice = canBeBeatByMap.get(last3Moves.get(0).getPlayer1Choice());
        } else {
            choice = GameOption.fromInteger(ThreadLocalRandom.current().nextInt(1, 4));
        }
        System.out.println(name + " chose " + choice);
        return choice;
    }

    private boolean areAllValuesSame(List<Move> moves) {
        for (Move move: moves) {
            if (move.getPlayer1Choice() != move.getPlayer1Choice()) {
                return false;
            }
        }
        return true;
    }


}
