package edu.bsu.cs222;

import edu.bsu.cs222.model.Player;
import org.junit.*;

public class FrameCounterTest {
    private Player dummyPlayer;

    @Before
    public void setUpFrameCounterTest() {
        dummyPlayer = new Player();
    }

    @Test
    public void testRandomGameFrame() {
        dummyPlayer.addNewBall(0);
        dummyPlayer.addNewBall(7);
        dummyPlayer.addNewBall(7);
        dummyPlayer.addNewBall(3);
        dummyPlayer.addNewBall(6);
        dummyPlayer.addNewBall(4);
        dummyPlayer.addNewBall(10);
        dummyPlayer.addNewBall(10);
        dummyPlayer.addNewBall(10);
        dummyPlayer.addNewBall(1);
        dummyPlayer.addNewBall(9);
        dummyPlayer.addNewBall(10);
        dummyPlayer.addNewBall(9);
        dummyPlayer.addNewBall(1);
        dummyPlayer.addNewBall(10);
        dummyPlayer.addNewBall(10);
        dummyPlayer.addNewBall(10);
        Assert.assertEquals(10, dummyPlayer.getCurrentPlayerFrame());
    }

    @Test
    public void testGetCurrentFrame() {
        dummyPlayer.addNewBall(5);
        dummyPlayer.addNewBall(5);
        dummyPlayer.addNewBall(5);
        dummyPlayer.addNewBall(5);
        Assert.assertEquals(3, dummyPlayer.getCurrentPlayerFrame());
    }

    @Test
    public void testSimpleStrike() {
        dummyPlayer.addNewBall(10);
        dummyPlayer.addNewBall(5);
        dummyPlayer.addNewBall(3);
        Assert.assertEquals(3, dummyPlayer.getCurrentPlayerFrame());
    }

    @Test
    public void testAlmostPerfectGame() {
        for (int i = 0; i < 11; i++)
            dummyPlayer.addNewBall(10);
        dummyPlayer.addNewBall(9);
        Assert.assertEquals(10, dummyPlayer.getCurrentPlayerFrame());
    }
}
