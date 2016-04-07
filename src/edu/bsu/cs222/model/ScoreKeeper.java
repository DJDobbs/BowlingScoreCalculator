package edu.bsu.cs222.model;

public class ScoreKeeper {

    public int[] rollKeeper = new int[21];

    public int scoreForFrame(int frame) {
        int ball = 0;
        int score = 0;
        for (int y = 0; y < frame; y++) {
            int firstRoll = rollKeeper[ball++];
            if (firstRoll == 10)
                score += strikeCalc(ball);
            else {
                int secondRoll = rollKeeper[ball++];
                int frameScore = firstRoll + secondRoll;
                score += checkSpare(frameScore, ball);
            }

        }
        return score;
    }

    public int strikeCalc(int ball) {
        int score = 10 + rollKeeper[ball] + rollKeeper[ball + 1];
        return score;
    }

    public int checkSpare(int frameScore, int ball) {
        int score;
        if (frameScore >= 10) {
            score = frameScore + rollKeeper[ball];
        }else {
            score = frameScore;
        }
        return score;
    }

}
