import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SudokuGUI {
    private static final int SIZE = 9;
    private SudokuBoard board;
    private SudokuSolver solver;
    private SudokuGenerator generator;
    private JTextField[][] cells;
    private boolean[][] isBaseNumber;

    public SudokuGUI() {
        board = new SudokuBoard();
        solver = new SudokuSolver();
        generator = new SudokuGenerator();
        cells = new JTextField[SIZE][SIZE];
        isBaseNumber = new boolean[SIZE][SIZE];
    }

    public void createAndShowGUI() {
        JFrame frame = new JFrame("Sudoku");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);

        JPanel gridPanel = new JPanel(new GridLayout(SIZE, SIZE));

        Border thickBorder = new LineBorder(Color.BLACK, 2);
        Border thinBorder = new LineBorder(Color.GRAY, 1);

        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                cells[row][col] = new JTextField();
                cells[row][col].setHorizontalAlignment(JTextField.CENTER);
                cells[row][col].setFont(new Font("Arial", Font.BOLD, 24));
                cells[row][col].setBorder(thinBorder);

                // Add thick borders to separate 3x3 subgrids
                if (row % 3 == 0 && col % 3 == 0) {
                    cells[row][col].setBorder(BorderFactory.createMatteBorder(2, 2, 1, 1, Color.BLACK));
                } else if (row % 3 == 0) {
                    cells[row][col].setBorder(BorderFactory.createMatteBorder(2, 0, 1, 1, Color.BLACK));
                } else if (col % 3 == 0) {
                    cells[row][col].setBorder(BorderFactory.createMatteBorder(0, 2, 1, 1, Color.BLACK));
                }

                gridPanel.add(cells[row][col]);
            }
        }

        JButton solveButton = new JButton("Solve");
        solveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadBoard();
                if (solver.solve(board)) {
                    updateBoardWithSolution();
                    JOptionPane.showMessageDialog(frame, "Puzzle Solved!");
                } else {
                    JOptionPane.showMessageDialog(frame, "No solution found!");
                }
            }
        });

        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                board.clear();
                clearBoardColors();
                updateBoard();
            }
        });

        JButton generateButton = new JButton("Generate Puzzle");
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                board.clear();
                clearBoardColors();
                generator.generate(board, 40); // Generate a puzzle with 40 empty cells
                markBaseNumbers();
                updateBoard();
            }
        });

        JPanel controlPanel = new JPanel();
        controlPanel.add(solveButton);
        controlPanel.add(clearButton);
        controlPanel.add(generateButton);

        frame.add(gridPanel, BorderLayout.CENTER);
        frame.add(controlPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private void loadBoard() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                String text = cells[row][col].getText();
                if (text.isEmpty()) {
                    board.set(row, col, '.');
                } else {
                    board.set(row, col, text.charAt(0));
                }
            }
        }
    }

    private void updateBoard() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                char value = board.get(row, col);
                JTextField cell = cells[row][col];
                if (value != '.') {
                    cell.setText(String.valueOf(value));
                    cell.setForeground(isBaseNumber[row][col] ? Color.BLACK : Color.RED);
                } else {
                    cell.setText("");
                    cell.setForeground(Color.BLACK);
                }
            }
        }
    }

    private void updateBoardWithSolution() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                char value = board.get(row, col);
                JTextField cell = cells[row][col];
                if (value != '.' && !isBaseNumber[row][col]) {
                    cell.setText(String.valueOf(value));
                    cell.setForeground(Color.RED); // Solved numbers in red
                }
            }
        }
    }

    private void markBaseNumbers() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                isBaseNumber[row][col] = board.get(row, col) != '.';
            }
        }
    }

    private void clearBoardColors() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                cells[row][col].setForeground(Color.BLACK);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SudokuGUI().createAndShowGUI();
            }
        });
    }
}