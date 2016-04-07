package edu.bsu.cs222.model;


public class Player {

    Frame frame = new Frame();
    ScoreKeeper scoreKeeper = new ScoreKeeper();
    private int currentRoll = 0;

    public int getScore() {
        return scoreKeeper.scoreForFrame((frame.getCurrentFrame()));
    }

    public void addRoll(int pinCount) {
        scoreKeeper.rollKeeper[currentRoll++] = pinCount;
        frame.adjustCurrentFrame(pinCount);
    }

}
