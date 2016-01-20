class Caretaker {
    public static void main(String[] args) {
        List<Originator.Memento> savedStates = new ArrayList<Originator.Memento>();
        Originator originator = new Originator();

        // Save the new state to the memento
        originator.set(new Sudoku(sudoku));
        savedStates.add(originator.saveToMemento());

        // if the user wants to do back
        sudoku = new Sudoku(originator.restoreFromMemento(savedStates.get(3)));
    }
}
