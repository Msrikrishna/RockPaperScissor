package com.sri.Controller;

public class PlayersNotResigteredException extends Exception {
    public PlayersNotResigteredException() {
        super("Players need to be registered before starting the game");
    }
}
