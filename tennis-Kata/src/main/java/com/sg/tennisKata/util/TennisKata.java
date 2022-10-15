package com.sg.tennisKata.util;

import java.util.HashMap;
import java.util.Map;

import static com.sg.tennisKata.constant.TennisKataConstant.*;

public class TennisKata {

    private static final Map<Integer, String> POINTS = new HashMap<>();

    static {
        POINTS.put(0, LOVE);
        POINTS.put(1, FIFTEEN);
        POINTS.put(2, THIRTY);
        POINTS.put(3, FORTY);
    }

    private final String firstPlayerName;
    private final String secondPlayerName;
    private int firstPlayerScore;
    private int secondPlayerScore;

    public TennisKata(String firstPlayerName, String secondPlayerName) {
        this.firstPlayerName = firstPlayerName;
        this.secondPlayerName = secondPlayerName;
    }

    public String getScore() {
        if (firstPlayerScore == secondPlayerScore) {
            return firstPlayerScore > 2 ? DEUCE : POINTS.get(firstPlayerScore) + ALL;
        } else {
            if (Math.max(firstPlayerScore, secondPlayerScore) > 3) {
                int diff = Math.abs(firstPlayerScore - secondPlayerScore);
                return (diff == 1 ?  ADVANTAGE : GAME) + getHighScorerPlayerName();
            } else {
                return POINTS.get(firstPlayerScore) + " " + POINTS.get(secondPlayerScore);
            }
        }
    }

    private String getHighScorerPlayerName() {
        return firstPlayerScore > secondPlayerScore ? firstPlayerName : secondPlayerName;
    }

    public void firstPlayerScore() {
        firstPlayerScore++;
    }

    public void secondPlayerScored() {
        secondPlayerScore++;
    }

}
