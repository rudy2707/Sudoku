package sudoku;

import java.util.*;

class SudokuKillerAdapter implements SudokuSolver {

    public SudokuKillerAdapter () {
        // Constructor
    }

    @Override
    public Sudoku solver(Sudoku sudoku) {
        SudokuBoard sb = new SudokuBoard(sudoku.getBoard());
        CustomKiller ck = new CustomKiller(sb);

        if (ck.guess(0, 0)) {
            return new Sudoku(ck.getBoard());
        }
        return new Sudoku(sudoku);
    }

    class CustomKiller extends SudoKiller {

        private SudokuBoard sb;

        public CustomKiller(SudokuBoard sb) {
            super(sb);
            this.sb = sb;
        }

        public int[][] getBoard() {
            int[][] board = new int[Sudoku.SIZE][Sudoku.SIZE];
            for (int i = 0; i < Sudoku.SIZE; i++) {
                for (int j = 0; j < Sudoku.SIZE; j++) {
                    board[i][j] = sb.getCell(i, j);
                }
            }
            return board;
        }
    }
}
