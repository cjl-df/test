package com.books.mjkf.bowling.testbowling;

import com.books.mjkf.bowling.Game;
import junit.framework.TestCase;

public class TestGame extends TestCase{
    public TestGame(String name){
        super(name);
    }

    private Game g;

    public void setUp(){
        g = new Game();
    }

    public void testOneThrows(){
        g.add(5);
//        assertEquals(1,g.getCurrentFrame());
        assertEquals(5,g.score());
    }

    public void testTwoThrow(){
        g.add(5);
        g.add(4);
        assertEquals(9,g.score());
//        assertEquals(2,g.getCurrentFrame());
    }

    //投掷3次
    public void testFourThrows(){
        g.add(5);
        g.add(4);
        g.add(7);
        g.add(2);
        assertEquals(18,g.score());
        assertEquals(9,g.scoreForFrame(1));
        assertEquals(18,g.scoreForFrame(2));
//        assertEquals(3,g.getCurrentFrame());
    }

    //补中的测试用例
    public void testSimpleSpare(){
        g.add(7);
        g.add(3);
        g.add(3);
        assertEquals(13,g.scoreForFrame(1));
//        assertEquals(2,g.getCurrentFrame());
    }

    public void testSimpleFrameAfterSpare(){
        g.add(7);
        g.add(3);
        g.add(3);
        g.add(2);
        assertEquals(13,g.scoreForFrame(1));
        assertEquals(18,g.score());
    }

    //全中
    public void test(){
        g.add(10);
        g.add(3);
        g.add(6);
        assertEquals(19,g.scoreForFrame(1));
        assertEquals(28,g.score());
    }

    public void testPerfectGame(){
        for(int i =0;i<12;i++){
            g.add(10);
        }
        assertEquals(300,g.score());
    }

    public void testTenthFrameSpare(){
        for (int i=0;i<9;i++)
            g.add(10);
        g.add(9);
        g.add(1);
        g.add(1);
        assertEquals(270,g.score());
    }

}
