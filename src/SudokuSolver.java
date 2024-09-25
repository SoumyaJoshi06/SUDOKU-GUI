public class SudokuSolver {
    private static final int SIZE = 9;

    public boolean solve(SudokuBoard board) {
        return solve(board, 0, 0);
    }

    private boolean solve(SudokuBoard board, int row, int col) {
        if (row == SIZE) {
            return true;
        }

        if (col == SIZE) {
            return solve(board, row + 1, 0);
        }

        if (!board.isEmpty(row, col)) {
            return solve(board, row, col + 1);
        }

        for (char num = '1'; num <= '9'; num++) {
            if (isValidPlacement(board, row, col, num)) {
                board.set(row, col, num);
                if (solve(board, row, col + 1)) {
                    return true;
                }
                board.set(row, col, '.'); // Backtrack
            }
        }

        return false;
    }

    private boolean isValidPlacement(SudokuBoard board, int row, int col, char num) {
        for (int i = 0; i < SIZE; i++) {
            if (board.get(row, i) == num || board.get(i, col) == num ||
                    board.get(row - row % 3 + i / 3, col - col % 3 + i % 3) == num) {
                return false;
            }
        }
        return true;
    }
}