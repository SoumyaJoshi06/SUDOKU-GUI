public class SudokuBoard {
    private static final int SIZE = 9;
    private char[][] board;

    public SudokuBoard() {
        board = new char[SIZE][SIZE];
        clear(); // Initialize with empty cells
    }

    public char get(int row, int col) {
        return board[row][col];
    }

    public void set(int row, int col, char value) {
        board[row][col] = value;
    }

    public boolean isEmpty(int row, int col) {
        return board[row][col] == '.';
    }

    public char[][] getBoard() {
        return board;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }

    public void clear() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = '.'; // Use '.' to represent empty cells
            }
        }
    }
}