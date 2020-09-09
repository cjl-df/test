package com.books.mjkf.bowling;

public class Game {

    private int itsCurrentFrame = 1;
    private boolean firstThrowInFrame = true;

    Scorer scorer = new Scorer();

    public int score(){
        return scorer.scoreForFrame(itsCurrentFrame);
    }

    public void add(int pins){
        scorer.addThrow(pins);
        adjustCurrentFrame(pins);
    }

    //调整当前是第几轮
    private void adjustCurrentFrame(int pins){
        if(firstThrowInFrame == true){
            if(adjustFrameForStrike(pins)== false)
                firstThrowInFrame = false;
        }else{
            firstThrowInFrame = true;
            advanceFrame();
        }
    }

    private boolean adjustFrameForStrike(int pins){
        if(pins == 10){
            advanceFrame();
            return true;
        }else
            return false;
    }


    public void advanceFrame(){
        itsCurrentFrame = Math.min(10,itsCurrentFrame+1);
    }

    public int scoreForFrame(int theFrame){
        return scorer.scoreForFrame(theFrame);
    }

}
