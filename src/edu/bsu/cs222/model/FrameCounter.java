package edu.bsu.cs222.model;

public class FrameCounter {
    private boolean firstBallInFrame = true;
    private int currentFrame = 1;

    public void checkForEndOfFrame(int pinCount) {
        if (firstBallInFrame) {
            checkForStrike(pinCount);
        } else {
            firstBallInFrame = true;
            advanceFrame();
        }
    }

    public int getCurrentFrame() {
        return currentFrame;
    }

    private void advanceFrame() {
        currentFrame = Math.min(10, currentFrame + 1);
    }

    private void checkForStrike(int pinCount) {
        if (pinCount == 10)
            advanceFrame();
        else
            firstBallInFrame = false;
    }
}
