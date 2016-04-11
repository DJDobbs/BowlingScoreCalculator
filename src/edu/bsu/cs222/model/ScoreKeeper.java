package edu.bsu.cs222.model;

public class ScoreKeeper {
    public int[] pinTracker = new int[21];
    private int ballNumber = 0;
    private int frameScore = 0;

    public int getFrameScore(int frameNumber) {
        ballNumber = 0;
        frameScore = 0;
        for (int i = 0; i < frameNumber; i++) {
            int firstRoll = pinTracker[ballNumber++];
            frameScore += calculateFrameScore(firstRoll);
        }
        return frameScore;
    }

    private int calculateFrameScore(int firstRoll) {
        int frameScore = 0;
        if (firstRoll == 10)
            frameScore += calculateStrikeValue();
        else {
            int secondRoll = pinTracker[ballNumber++];
            int totalPins = firstRoll + secondRoll;
            frameScore = checkForSpare(totalPins);
        }
        return frameScore;
    }

    private int calculateStrikeValue() {
        int strikeValue = 10 + pinTracker[ballNumber] + pinTracker[ballNumber + 1];
        return strikeValue;
    }

    private int checkForSpare(int totalPins) {
        int frameScore;
        if (totalPins >= 10) {
            frameScore = totalPins + pinTracker[ballNumber];
        } else {
            frameScore = totalPins;
        }
        return frameScore;
    }
}
