package edu.bsu.cs222;

import edu.bsu.cs222.model.Player;
import org.junit.*;

public class PlayerTest {
    private Player dummyPlayer;

    @Before
    public void setUpPlayerTest() {
        dummyPlayer = new Player();
        dummyPlayer.addNewBall(5);
        dummyPlayer.addNewBall(5);
        dummyPlayer.addNewBall(10);
        dummyPlayer.addNewBall(7);
        dummyPlayer.addNewBall(2);
    }

    @Test
    public void testGetScore() {
        Assert.assertEquals(48, dummyPlayer.getPlayerScore());
    }

    @Test
    public void testGetCurrentPlayerFrame() {
        Assert.assertEquals(4, dummyPlayer.getCurrentPlayerFrame());
    }
}
