package edu.bsu.cs222.model;

public class ScoreKeeper {

    public int[] rollKeeper = new int[21];
    private int ball = 0;
    private int score = 0;

    public int getFrameScore(int frame) {
        ball = 0;
        score = 0;
        for (int y = 0; y < frame; y++) {
            int firstRoll = rollKeeper[ball++];
            score += frameScoreCalc(firstRoll);
        }
        return score;
    }

    private int frameScoreCalc(int firstRoll){
        int frameScore = 0;
        if (firstRoll == 10)
            frameScore += strikeCalc();
        else {
            int secondRoll = rollKeeper[ball++];
            int totalPins = firstRoll + secondRoll;
            frameScore = checkSpare(totalPins);
        }
        return frameScore;
    }

    private int strikeCalc() {
        int score = 10 + rollKeeper[ball] + rollKeeper[ball + 1];
        return score;
    }

    private int checkSpare(int totalPins) {
        int frameScore;
        if (totalPins >= 10) {
            frameScore = totalPins + rollKeeper[ball];
        }else {
            frameScore = totalPins;
        }
        return frameScore;
    }

}
