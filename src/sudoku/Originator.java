package sudoku;

import java.util.*;

class Originator {
    private Sudoku state;
   /* lots of memory consumptive private data that is not necessary to define the
    * state and should thus not be saved. Hence the small memento object. */

    public Originator() {
        // this.state = new int[9][9];
    }

    public void set(Sudoku stateToSave) {
        System.out.println("Originator: Setting state to ");
    //    this.state = state;
    //    Collections.copy(state, this.state);
        // System.arraycopy( stateToSave, 0, this.state, 0, stateToSave.length );
        // state = (Sudoku)Util.deepClone(stateToSave);
        state = stateToSave;
    }

    public Memento saveToMemento() {
        System.out.println("Originator: Saving to Memento.");
        return new Memento(this.state);
    }

    // Previous version
    // public void restoreFromMemento(Memento m) {
    public Sudoku restoreFromMemento(Memento m) {
        state = m.getSavedState();
        System.out.println("Originator: State after restoring from Memento: ");
        return state;
    }

    public static class Memento {
        private final Sudoku state;

        public Memento(Sudoku state) {
            this.state = state;
        }

        public Sudoku getSavedState() {
            return state;
        }
    }
}
