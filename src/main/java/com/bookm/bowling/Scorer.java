package com.bookm.bowling;

public class Scorer {

    private int ball;
    private int[] itsThrows = new int[21];
    private int itsCurrentThrow=0;

    public void addThrow(int pins){
        itsThrows[itsCurrentThrow++] = pins;
    }

    //计算每轮得分
    public int scoreForFrame(int theFrame){
        int score=0;
        ball = 0;
        for(int currentFrame=0; currentFrame<theFrame;currentFrame++){
            if(strike()){
                score+= 10 + nextTwoBalls();
                ball++;
            }else if(spare()){
                score += 10+nextBall();
                ball += 2;
            }else{
                score += twoBallsInFrame();
                ball += 2;
            }
        }
        return score;
    }

    public boolean strike(){
        return itsThrows[ball] == 10;
    }

    private int nextTwoBalls(){
        return itsThrows[ball+1]+itsThrows[ball+2];
    }

    public boolean spare(){
        return (itsThrows[ball]+itsThrows[ball+1] == 10);
    }

    private int nextBall(){
        return itsThrows[ball+2];
    }

    public int twoBallsInFrame(){
        return itsThrows[ball]+ itsThrows[ball+1];
    }
}
