package com.sri.Player;

import com.sri.Util.GameOption;
import com.sri.Util.PlayerType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ComputerRandom implements Player {
    static Logger logger = LoggerFactory.getLogger(ComputerRandom.class);

    String name = "Computer";

    //Caching for random retrieval
    private static final List<GameOption> VALUES =
            Collections.unmodifiableList(Arrays.asList(GameOption.values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();


    public ComputerRandom(String name) {
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
        GameOption randomOpt = getRandomOption();
        System.out.println(name + " chose " + randomOpt);
        return randomOpt;
    }

    //Returns a deterministic random choice
    public static GameOption getRandomOption()  {
        GameOption opt = GameOption.UNKNOWNOPTION;
        while (opt == GameOption.UNKNOWNOPTION) {
            opt = VALUES.get(RANDOM.nextInt(SIZE));
        }
        return opt;
    }
}
