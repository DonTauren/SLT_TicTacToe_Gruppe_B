package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    @Test
    void testIsCellEmptyPositive() {
        Board board = new Board();
        board.clear();
        assertTrue(board.isCellEmpty(0, 0));
    }

    @Test
    void testIsCellEmptyNegative() {
        Board board = new Board();
        board.clear();
        board.place(0, 0, 'X');
        assertFalse(board.isCellEmpty(0, 0));
    }

    @Test
    void testPlacePositive() {
        Board board = new Board();
        board.clear();
        board.place(1, 1, 'O');
        assertEquals('O', board.getCell(1, 1));
    }

    @Test
    void testPlaceNegative() {
        Board board = new Board();
        board.clear();
        board.place(1, 1, 'X');
        assertNotEquals('O', board.getCell(1, 1));
    }

    @Test
    void testIsFullPositive() {
        Board board = new Board();
        board.clear();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.place(i, j, 'X');
            }
        }
        assertTrue(board.isFull());
    }

    @Test
    void testIsFullNegative() {
        Board board = new Board();
        board.clear();
        assertFalse(board.isFull());
    }
}
