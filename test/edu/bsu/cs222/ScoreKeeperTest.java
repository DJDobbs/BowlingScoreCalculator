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

        int expectedscore=5;
        int resultscore=g.getScore();

        assertEquals(expectedscore, resultscore, .00001);
    }


    @Test
    public void testTwoRollsNoMark(){
        g.addRoll(5);
        g.addRoll(3);

        int expectedscore=8;
        int resultscore=g.getScore();

        assertEquals(expectedscore, resultscore, .00001);
    }


    @Test
    public void testFourRollsNoMark(){
        g.addRoll(5);
        g.addRoll(3);
        g.addRoll(4);
        g.addRoll(4);

        int expectedscore=16;
        int resultscore=g.getScore();

        assertEquals(expectedscore, resultscore, .00001);

    }


    @Test
    public void testSpare(){
        g.addRoll(5);
        g.addRoll(5);
        g.addRoll(5);
        g.addRoll(4);

        int expectedscore=24;
        int resultscore=g.getScore();

        assertEquals(expectedscore, resultscore, .00001);


    }

    @Test
    public void testTurkeyScore(){
        g.addRoll(6);
        g.addRoll(4);
        g.addRoll(10);
        g.addRoll(10);
        g.addRoll(10);

        int expectedscore=80;
        int resultscore= g.frame.getCurrentFrame();

        assertEquals(expectedscore, resultscore, .00001);
    }


}
