package sudoku;

import java.util.*;

public class SudokuGame {

    public static void main(String[] args) {

        List<Originator.Memento> savedStates = new ArrayList<Originator.Memento>();
        Originator originator = new Originator();

        // Create a sudoku game
        Sudoku sudoku = new Sudoku();

        // Variable to play
        boolean playing = true;

        Scanner playerCmd = new Scanner(System.in);

        int x, y, number;
        int backMoves;

        System.out.println("Welcome in our Sudoku !");
        sudoku.printBoard();

        while (playing) {

            System.out.println(sudoku.getMoves()  + " moves in total");

            // Save the new state to the memento
            originator.set(new Sudoku(sudoku));
            savedStates.add(originator.saveToMemento());
            System.out.println(savedStates.size());

            // Help the user with the Sudokiller algorithm
            System.out.println("Use some cheatcode ? [y][N]");
            if (playerCmd.next().equals("y")) {

                // Use the Adapter to solve one item of the sudoku
                // using SudoKiller
                SudokuSolver sk = new SudokuKillerAdapter();
                sudoku = new Sudoku(sk.solver(sudoku));
                sudoku.printBoard();
                System.exit(0);
            }

            // Use the memento to go back in time
            System.out.println("Move in time ? [y][N]");
            if (playerCmd.next().equals("y")) {
                int cmd = -1;

                while (cmd != 0) {
                    System.out.println("Previous [-1], Save [0], Future [1] ? ");
                    cmd = playerCmd.nextInt();

                    if (cmd == 0) break;
                    else if ((cmd == 1) || (cmd == -1)) {
                        try {
                            sudoku = new Sudoku(originator.restoreFromMemento(savedStates.get(sudoku.getMoves() + cmd)));
                            System.out.println("Setting new state !");
                            sudoku.printBoard();

                        }  catch(Exception e) {
                            System.out.println("State not available");
                        }
                    }
                }
            }

            System.out.println("Position x : ");
            x = playerCmd.nextInt();

            System.out.println("Position y : ");
            y = playerCmd.nextInt();

            System.out.println("Nombre : ");
            number = playerCmd.nextInt();

            sudoku.setCell(x, y, number, savedStates.size());
            sudoku.printBoard();

            System.out.println("Stop the game ? [N][y] ");
            if (playerCmd.next().equals("y")) {
                playing = false;
            }
        }
    }
}
