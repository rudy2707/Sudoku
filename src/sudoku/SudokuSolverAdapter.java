package sudoku;

import java.util.*;

class SudokuSolverAdapter implements SudokuSolver {

    public SudokuSolverAdapter () {
        // Constructor
    }

    @Override
    public Sudoku solverKiller(Sudoku sudoku) {
        SudokuBoard sb = new SudokuBoard(sudoku.getBoard());
        CustomKiller sk = new CustomKiller(sb);

        if (sk.guess(0, 0)) {
            return new Sudoku(sk.getBoard());
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
