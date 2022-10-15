package com.sg.tennisKata;

import com.sg.tennisKata.util.TennisKata;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TennisKataTest {
    private final TennisKata tennisObj = new TennisKata("Rahul", "Pooja");

    @ParameterizedTest
    @CsvSource({
            "0,0,Love all",
            "1,1,Fifteen all",
            "2,2,Thirty all",
            "3,3,Deuce",
            "4,3,Advantage Rahul",
            "4,5,Advantage Pooja",
            "4,6,Game Pooja",
            "6,4,Game Rahul",
            "0,1,Love Fifteen",
            "1,2,Fifteen Thirty",
            "4,2,Game Rahul",
    }
    )
    public void testLoveAll(int firstPlayer, int secondPlayer, String scoreAchieved) {
        for (int i = 0; i < firstPlayer; i++) {
            tennisObj.firstPlayerScore();
        }
        for (int i = 0; i < secondPlayer; i++) {
            tennisObj.secondPlayerScored();
        }
        Assertions.assertEquals(scoreAchieved, tennisObj.getScore());
    }

}
