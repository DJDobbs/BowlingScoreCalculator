package edu.bsu.cs222.model;

public class Frame {

    private boolean firstRoll = true;
    private int currentFrame = 1;

    public void adjustCurrentFrame(int pinCount) {
        if (firstRoll) {
            if (isStrike(pinCount)) {
                nextFrame();
            } else {
                firstRoll = false;
            }
        }else{
            firstRoll = true;
            nextFrame();
        }
    }

    private void nextFrame(){
        currentFrame = Math.min(10, currentFrame + 1);
    }

    private boolean isStrike(int pinCount){
        if (pinCount == 10)
            return true;
        else
            return false;
    }

    public int getCurrentFrame() {
        return currentFrame;
    }

}
