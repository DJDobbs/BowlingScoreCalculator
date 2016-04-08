package edu.bsu.cs222;

import edu.bsu.cs222.model.Player;
import org.junit.Test;

import static org.junit.Assert.*;


public class ScoreKeeperTest {


    private Player g = new Player();

    @Test
    public void TestScoreKeeper(){

    }

    @Test
    public void testOneRollNoMark() {
        g.addRoll(5);

        int expectedScore=5;
        int resultScore=g.getScore();

        assertEquals(expectedScore, resultScore);
    }


    @Test
    public void testTwoRollsNoMark(){
        g.addRoll(5);
        g.addRoll(3);

        int expectedScore=8;
        int resultScore=g.getScore();

        assertEquals(expectedScore, resultScore);
    }


    @Test
    public void testFourRollsNoMark(){
        g.addRoll(5);
        g.addRoll(3);
        g.addRoll(4);
        g.addRoll(4);

        int expectedScore=16;
        int resultScore=g.getScore();

        assertEquals(expectedScore, resultScore);

    }


    @Test
    public void testSpare(){
        g.addRoll(5);
        g.addRoll(5);
        g.addRoll(5);
        g.addRoll(4);

        int expectedScore=24;
        int resultScore=g.getScore();

        assertEquals(expectedScore, resultScore);


    }

    @Test
    public void testTurkeyScore(){
        g.addRoll(6);
        g.addRoll(4);
        g.addRoll(10);
        g.addRoll(10);
        g.addRoll(10);

        int expectedScore=80;
        int resultScore= g.frame.getCurrentFrame();

        assertEquals(expectedScore, resultScore);
    }


}
