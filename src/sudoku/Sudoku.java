package sudoku;

import java.util.*;

public class Sudoku {

    private int[][] board;
    private int moves;

    // The size of the board is 9x9, it means that sub-boards are 3x3
    public static final int SIZE = 9;

    public Sudoku() {
        this.board = randomBoardGenerator();
        this.moves = 0;
    }

    public Sudoku(Sudoku s) {
        this();
        this.moves = s.moves;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                this.board[i][j] = s.board[i][j];
            }
        }
    }

    public Sudoku(int[][] board) {
        this();
        this.board = board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    public int[][] getBoard() {
        return this.board;
    }

    public int getMoves() {
        return this.moves;
    }

    public void setCell(int x, int y, int num, int moves) {
        if ((num < 10) && (num >= 0)) {
            this.board[y][x] = num;
            this.moves = moves;
        }
    }

    public int getCell(int x, int y) {
        return board[x][y];
    }

    public int[][] randomBoardGenerator() {
        // Should generate a random board based on the size set above

        int[][] board = {{0, 6, 0, 1, 0, 4, 0, 5, 0},
                {0, 0, 8, 3, 0, 5, 6, 0, 0},
                {2, 0, 0, 0, 0, 0, 0, 0, 1},
                {8, 0, 0, 4, 0, 7, 0, 0, 6},
                {0, 0, 6, 0, 0, 0, 3, 0, 0},
                {7, 0, 0, 9, 0, 1, 0, 0, 4},
                {5, 0, 0, 0, 0, 0, 0, 0, 2},
                {0, 0, 7, 2, 0, 6, 9, 0, 0},
                {0, 4, 0, 5, 0, 8, 0, 7, 0}};
        return board;
    }

    public void printBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(this.board[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
