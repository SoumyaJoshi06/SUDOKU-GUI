# Sudoku Solver and Generator

This project is a Java-based Sudoku solver and generator, providing a user-friendly graphical interface to interact with Sudoku puzzles. The application allows users to generate new puzzles, solve existing ones, and clear the board for new challenges.

![image](https://github.com/user-attachments/assets/1be336ad-c34b-46a9-a144-f71c0037c2d8)


## Features

- **Sudoku Generation**: Generate new Sudoku puzzles with a customizable number of empty cells.
- **Sudoku Solving**: Solve any valid Sudoku puzzle using a backtracking algorithm.
- **Graphical User Interface (GUI)**: Intuitive interface built with Swing, making it easy to input numbers and visualize the board.
- **Highlighting**: Base numbers (given numbers) are displayed in black, while user-inputted solutions are highlighted in red.

## Object-Oriented Programming Features Used

- **Encapsulation**: The `SudokuBoard`, `SudokuGenerator`, `SudokuSolver`, and `SudokuGUI` classes encapsulate their respective functionalities and data.
- **Composition**: The `SudokuGUI` class uses instances of `SudokuBoard`, `SudokuSolver`, and `SudokuGenerator` to perform its operations.
- **Separation of Concerns**: Different classes handle different responsibilities, ensuring clean and maintainable code.
- **Inheritance and Polymorphism**: Not used, but can be extended to add difficulty levels and custom solvers.

## Tech Stack

- **Programming Language**: Java
- **Frameworks**: Swing (for GUI)
- **Algorithms**: Backtracking for solving Sudoku puzzles
- **IDE**: Any Java IDE (e.g., IntelliJ IDEA, Eclipse)
- **Build Tools**: Maven or Gradle (optional)

## What's Special About This Project?

This Sudoku project not only implements a classic game but also emphasizes clean code principles and user experience. The graphical interface is designed to be simple yet effective, providing immediate feedback on user actions. The project can serve as a solid base for further enhancements, such as implementing different difficulty levels or improving the solving algorithm for performance.
