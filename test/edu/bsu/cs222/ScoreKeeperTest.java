package edu.bsu.cs222;

import edu.bsu.cs222.model.Player;
import org.junit.*;

public class ScoreKeeperTest {
    private Player dummyPlayer;

    @Before
    public void setUpScoreKeeperTest() {
        dummyPlayer = new Player();
    }

    @Test
    public void testOneRollNoMark() {
        dummyPlayer.addNewBall(5);
        Assert.assertEquals(5, dummyPlayer.getPlayerScore());
    }

    @Test
    public void testTwoRollsNoMark() {
        dummyPlayer.addNewBall(5);
        dummyPlayer.addNewBall(3);
        Assert.assertEquals(8, dummyPlayer.getPlayerScore());
    }

    @Test
    public void testFourRollsNoMark() {
        dummyPlayer.addNewBall(5);
        dummyPlayer.addNewBall(3);
        dummyPlayer.addNewBall(4);
        dummyPlayer.addNewBall(4);
        Assert.assertEquals(16, dummyPlayer.getPlayerScore());
    }

    @Test
    public void testSpare() {
        dummyPlayer.addNewBall(5);
        dummyPlayer.addNewBall(5);
        dummyPlayer.addNewBall(5);
        dummyPlayer.addNewBall(4);
        Assert.assertEquals(24, dummyPlayer.getPlayerScore());
    }

    @Test
    public void testTurkeyScore() {
        dummyPlayer.addNewBall(6);
        dummyPlayer.addNewBall(4);
        dummyPlayer.addNewBall(10);
        dummyPlayer.addNewBall(10);
        dummyPlayer.addNewBall(10);
        Assert.assertEquals(80, dummyPlayer.getPlayerScore());
    }
}
