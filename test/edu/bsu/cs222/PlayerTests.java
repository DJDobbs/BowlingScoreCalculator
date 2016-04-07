package edu.bsu.cs222;

import edu.bsu.cs222.model.Player;
import junit.framework.TestCase;


public class PlayerTests extends TestCase {

    public PlayerTests(String name){
        super(name);
    }

    private Player g;

    public void setUp(){
        g = new Player();
    }

    public void testOneRollNoMark() {
        g.addRoll(5);
        assertEquals(5, g.getScore());
    }

    public void testTwoRollsNoMark(){
        g.addRoll(5);
        g.addRoll(3);
        assertEquals(8, g.getScore());
    }

    public void testFourRollsNoMark(){
        g.addRoll(5);
        g.addRoll(3);
        g.addRoll(4);
        g.addRoll(4);
        assertEquals(16, g.getScore());

    }

    public void testSpare(){
        g.addRoll(5);
        g.addRoll(5);
        g.addRoll(5);
        g.addRoll(4);
        assertEquals(24, g.getScore());


    }

    public void testgetCurrentFrame(){
        g.addRoll(5);
        g.addRoll(5);
        g.addRoll(5);
        g.addRoll(5);
        assertEquals(3, g.frame.getCurrentFrame());
    }

    public void testSimpleStrike(){
        g.addRoll(10);
        g.addRoll(5);
        g.addRoll(3);
        assertEquals(3, g.frame.getCurrentFrame());
    }

    public void testPerfectGame(){
        for (int i = 0; i < 12; i++){
            g.addRoll(10);
        }
        assertEquals(300, g.getScore());
        assertEquals(10, g.frame.getCurrentFrame());
    }

    public void testRandomGame(){
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
        assertEquals(10, g.frame.getCurrentFrame());

    }

    public void testalmostPerfectGame(){
        for (int i = 0; i < 11; i++)
            g.addRoll(10);
        g.addRoll(9);
        assertEquals(10, g.frame.getCurrentFrame());
    }

    public void testTurkeyScore(){
        g.addRoll(6);
        g.addRoll(4);
        g.addRoll(10);
        g.addRoll(10);
        g.addRoll(10);
        assertEquals(80, g.getScore());
    }
}


