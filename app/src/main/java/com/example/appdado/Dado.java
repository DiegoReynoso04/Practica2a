package com.example.appdado;

public class Dado {
    private int scoreRound;

    public int play() {

        int rolledValue = (int) (Math.random() * 6) + 1;
        scoreRound = rolledValue;
        return rolledValue;
    }

    public int getScoreRound() {
        return scoreRound;
    }
}