package edu.bsu.cs222.model;

public class Frame {

    private boolean firstRoll = true;
    private int currentFrame = 1;

    public void checkForFrameChange(int pinCount) {
        if (firstRoll) {
            isStrike(pinCount);
        }else{
            firstRoll = true;
            advanceFrame();
        }
    }

    public int getCurrentFrame() {
        return currentFrame;
    }

    private void advanceFrame(){
        currentFrame = Math.min(10, currentFrame + 1);
    }

    private void isStrike(int pinCount){
        if (pinCount == 10)
            advanceFrame();
        else
            firstRoll = false;
    }

}
