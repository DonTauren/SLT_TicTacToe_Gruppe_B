package org.example;

import java.util.Scanner;

public class TicTacToe {
    private Player player1;
    private Player player2;
    protected Player currentPlayer;
    protected Board board;

    public TicTacToe() {
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
        board = new Board();
    }

    public void start(Scanner sc) {
        board.clear();
        board.print();
        while (!board.isFull() && !hasWinner()) {
            System.out.print("Player " + currentPlayer.getMarker() + ", enter your move (row, 1-3): ");
            int x = sc.nextInt() - 1;
            System.out.print("Player " + currentPlayer.getMarker() + ", enter your move (column, 1-3): ");
            int y = sc.nextInt() - 1;

            if (x < 0 || x >= 3 || y < 0 || y >= 3) {
                System.out.println("This move is out of bounds!");
            } else if (!board.isCellEmpty(x, y)) {
                System.out.println("This cell is already occupied!");
            } else {
                board.place(x, y, currentPlayer.getMarker());
                board.print();
                if (!board.isFull() && hasWinner()) {
                    System.out.println("Player " + currentPlayer.getMarker() + " wins!");
                    return;
                }
                switchCurrentPlayer();
            }
        }
        if (board.isFull() && !hasWinner()) {
            System.out.println("It's a draw!");
        }
    }

    protected void switchCurrentPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    protected boolean hasWinner() {
        for (int i = 0; i < 3; i++) {
            if (board.getCell(i, 0) != ' ' && board.getCell(i, 0) == board.getCell(i, 1) && board.getCell(i, 1) == board.getCell(i, 2)) {
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (board.getCell(0, i) != ' ' && board.getCell(0, i) == board.getCell(1, i) && board.getCell(1, i) == board.getCell(2, i)) {
                return true;
            }
        }
        if (board.getCell(0, 0) != ' ' && board.getCell(0, 0) == board.getCell(1, 1) && board.getCell(1, 1) == board.getCell(2, 2)) {
            return true;
        }
        if (board.getCell(0, 2) != ' ' && board.getCell(0, 2) == board.getCell(1, 1) && board.getCell(1, 1) == board.getCell(2, 0)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean playAgain;
        do {
            TicTacToe game = new TicTacToe();
            game.start(sc);
            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = sc.next().equalsIgnoreCase("yes");
        } while (playAgain);
        sc.close();
    }
}