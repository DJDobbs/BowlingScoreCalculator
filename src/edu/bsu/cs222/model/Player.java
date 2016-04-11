package edu.bsu.cs222.model;

public class Player {
    private ScoreKeeper playerScore = new ScoreKeeper();
    private FrameCounter playerFrame = new FrameCounter();
    private int ballCount = 0;

    public int getPlayerScore() {
        return playerScore.getFrameScore((playerFrame.getCurrentFrame()));
    }

    public int getCurrentPlayerFrame() {
        return playerFrame.getCurrentFrame();
    }

    public void addNewBall(int pinCount) {
        playerScore.pinTracker[ballCount++] = pinCount;
        playerFrame.checkForEndOfFrame(pinCount);
    }
}
