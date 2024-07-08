package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TicTacToeTest {
    @Test
    void testSwitchCurrentPlayerPositive() {
        TicTacToe game = new TicTacToe();
        Player initialPlayer = game.currentPlayer;
        game.switchCurrentPlayer();
        assertNotEquals(initialPlayer, game.currentPlayer);
    }

    @Test
    void testSwitchCurrentPlayerNegative() {
        TicTacToe game = new TicTacToe();
        Player initialPlayer = game.currentPlayer;
        game.switchCurrentPlayer();
        game.switchCurrentPlayer();
        assertEquals(initialPlayer, game.currentPlayer);
    }

    @Test
    void testHasWinnerPositive() {
        TicTacToe game = new TicTacToe();
        game.board.clear();
        game.board.place(0, 0, 'X');
        game.board.place(0, 1, 'X');
        game.board.place(0, 2, 'X');
        assertTrue(game.hasWinner());
    }

    @Test
    void testHasWinnerNegative() {
        TicTacToe game = new TicTacToe();
        game.board.clear();
        game.board.place(0, 0, 'X');
        game.board.place(0, 1, 'O');
        game.board.place(0, 2, 'X');
        assertFalse(game.hasWinner());
    }
}
