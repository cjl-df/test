package com.bookm.bowling;

public class Frame {

    public int getScore(){
        return itsScore;
    }

    public void add(int pins){
        itsScore+=pins;
    }

    private int itsScore = 0;
}
