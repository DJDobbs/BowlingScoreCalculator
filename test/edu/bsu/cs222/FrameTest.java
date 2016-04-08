package edu.bsu.cs222;

import edu.bsu.cs222.model.Player;
import org.junit.Test;

import static org.junit.Assert.*;

public class FrameTest {


    private Player g = new Player();


    @Test
    public void TestRandomGameFrame() {
        g.addRoll(0);
        g.addRoll(7);
        g.addRoll(7);
        g.addRoll(3);
        g.addRoll(6);
        g.addRoll(4);
        g.addRoll(10);
        g.addRoll(10);
        g.addRoll(10);
        g.addRoll(1);
        g.addRoll(9);
        g.addRoll(10);
        g.addRoll(9);
        g.addRoll(1);
        g.addRoll(10);
        g.addRoll(10);
        g.addRoll(10);

        int expectedframe = 10;
        int resultframe = g.frame.getCurrentFrame();

        assertEquals(expectedframe, resultframe, .00001);
    }


    @Test
    public void testgetCurrentFrame() {
        g.addRoll(5);
        g.addRoll(5);
        g.addRoll(5);
        g.addRoll(5);

        int expectedframe = 3;
        int resultframe = g.frame.getCurrentFrame();

        assertEquals(expectedframe, resultframe, .0001);
    }

    @Test
    public void testSimpleStrike() {
        g.addRoll(10);
        g.addRoll(5);
        g.addRoll(3);

        int expectedframe=3;
        int resultframe= g.frame.getCurrentFrame();

        assertEquals(expectedframe,resultframe, .00001 );
    }


    @Test
    public void testalmostPerfectGame(){
        for (int i = 0; i < 11; i++)
            g.addRoll(10);
            g.addRoll(9);

        int expectedframe=10;
        int resultframe=g.frame.getCurrentFrame();

        assertEquals(expectedframe,resultframe, .00001 );
    }

}