package com.sri.Util;


public enum GameOption {
    ROCK(1),
    PAPER(2),
    SCISSOR(3),
    UNKNOWNOPTION(-1);
    private final int value;

    GameOption(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static GameOption fromInteger(int x) {
        switch(x) {
            case 1:
                return GameOption.ROCK;
            case 2:
                return GameOption.PAPER;
            case 3:
                return GameOption.SCISSOR;
            default:
                return GameOption.UNKNOWNOPTION;
        }
    }
}


