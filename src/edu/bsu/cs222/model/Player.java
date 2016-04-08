package edu.bsu.cs222.model;


public class Player {

    public ScoreKeeper score = new ScoreKeeper();
    public Frame frame = new Frame();
    private int currentRoll = 0;

    public int getScore() {
        return score.getFrameScore((frame.getCurrentFrame()));
    }

    public int getCurrentFrame(){
        return frame.getCurrentFrame();
    }

    public void addRoll(int pinCount) {
        score.rollKeeper[currentRoll++] = pinCount;
        frame.checkForFrameChange(pinCount);
    }

}
