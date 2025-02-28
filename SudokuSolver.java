public class SudokuSolver {

    // Size of the Sudoku grid
    private static final int SIZE = 9;

    // Function to print the Sudoku grid
    private static void printGrid(int[][] grid) {
        for (int r = 0; r < SIZE; r++) {
            for (int d = 0; d < SIZE; d++) {
                System.out.print(grid[r][d] + " ");
            }
            System.out.print("\n");
        }
    }

    // Function to check if a number can be placed in a given cell
    private static boolean isSafe(int[][] grid, int row, int col, int num) {
        // Check the row and column
        for (int x = 0; x < SIZE; x++) {
            if (grid[row][x] == num || grid[x][col] == num) {
                return false;
            }
        }
        // Check the 3x3 box
        int startRow = row - row % 3, startCol = col - col % 3;
        for (int r = 0; r < 3; r++) {
            for (int d = 0; d < 3; d++) {
                if (grid[r + startRow][d + startCol] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    // Function to solve the Sudoku using backtracking
    private static boolean solveSudoku(int[][] grid) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                // Find an empty cell
                if (grid[row][col] == 0) {
                    // Try digits from 1 to 9
                    for (int num = 1; num <= SIZE; num++) {
                        if (isSafe(grid, row, col, num)) {
                            grid[row][col] = num; // Place the number
                            // Recursively attempt to fill the grid
                            if (solveSudoku(grid)) {
                                return true;
                            }
                            // If placing num doesn't lead to a solution, reset
                            grid[row][col] = 0;
                        }
                    }
                    return false; // Trigger backtracking
                }
            }
        }
        return true; // Solved
    }

    public static void main(String[] args) {
        // Example Sudoku puzzle (0s represent empty cells)
        int[][] grid = {
                { 5, 3, 0, 0, 7, 0, 0, 0, 0 },
                { 6, 0, 0, 1, 9, 5, 0, 0, 0 },
                { 0, 9, 8, 0, 0, 0, 0, 6, 0 },
                { 8, 0, 0, 0, 6, 0, 0, 0, 3 },
                { 4, 0, 0, 8, 0, 3, 0, 0, 1 },
                { 7, 0, 0, 0, 2, 0, 0, 0, 6 },
                { 0, 6, 0, 0, 0, 0, 2, 8, 0 },
                { 0, 0, 0, 4, 1, 9, 0, 0, 5 },
                { 0, 0, 0, 0, 8, 0, 0, 7, 9 }
        };

        if (solveSudoku(grid)) {
            printGrid(grid);
        } else {
            System.out.println("No solution exists.");
        }
    }
}
