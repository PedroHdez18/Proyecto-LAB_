package poo.pruebas;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import poo.Game;

public class GameTest {

    @Test
    public void testCalculateScore() {
        Game game = new Game();
        int[] points = {10, 20, 30};
        int total = game.calculateScore(points);

        assertEquals(60, total);
    }

    @Test
    public void testIsWinningScore() {
        Game game = new Game();
        assertTrue(game.isWinningScore(100, 50));
        assertFalse(game.isWinningScore(30, 50));
    }

    @Test
    public void testReverseScores() {
        Game game = new Game();
        int[] scores = {1, 2, 3, 4};
        int[] reversed = game.reverseScores(scores);

        assertArrayEquals(new int[]{4, 3, 2, 1}, reversed);
    }
}
