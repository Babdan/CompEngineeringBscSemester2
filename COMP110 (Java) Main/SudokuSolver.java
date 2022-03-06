// By Bogdan Itsam Dorantes-Nikolaev, COMP110, Instructor: Prof. Adem Karahoca (March 6th, 2022)

// Importing the Scanner class
import java.util.Scanner;

// This program solves Sudoku puzzles using backtracking.
public class SudokuSolver {
    // Main method that takes user sudoku to be solved
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Array size for the 9 by 9 Sudoku
        int[][] board = new int[9][9];
        System.out.println("Enter a Sudoku puzzle: ");
        // Taking input from user
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        int N = board.length;
        if (sudokuSolver(board, N)) {
            // Empty line for better readability
            System.out.println("");
            // Printing the board after solving
            System.out.println("The solution is found: ");
            print(board, N);
        } else {
            // If no solution is possible
            System.out.println("No solution");
        }
    }
    // Method to solve the Sudoku
    public static boolean sudokuSolver(
            int[][] board, int n)
    {
        int row = -1;
        int col = -1;
        boolean isEmpty = true;
        // Looping through the board
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (board[i][j] == 0)
                {
                    row = i;
                    col = j;
                    // Checking if there is an empty cells left
                    isEmpty = false;
                    break;
                }
            }
            // If there is no empty cells left
            if (!isEmpty) {
                break;
            }
        }
        // No empty space left
        if (isEmpty)
        {
            return true;
        }
        // Per row backtracking
        for (int num = 1; num <= n; num++)
        {
            if (isPlacementSafe(board, row, col, num))
            {
                board[row][col] = num;
                if (sudokuSolver(board, n))
                {
                    // If the board is solved print(board, n);
                    return true;
                }
                else
                {
                    // Replacement of the number with 0
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }
    // Check if the number num is safe to be placed at
    public static boolean isPlacementSafe(int[][] board, int row, int col, int num)
    {
        // Row checker
        for (int d = 0; d < board.length; d++)
        {
            // If number is already present in that row returns false
            if (board[row][d] == num) {
                return false;
            }
        }
        // Column checker
        for (int[] ints : board) {
            // If number is already present in that column returns false
            if (ints[col] == num) {
                return false;
            }
        }
        // Box checker
        int sqrt = (int)Math.sqrt(board.length);
        int boxRowStart = row - row % sqrt;
        int boxColStart = col - col % sqrt;
        // Looping through the box
        for (int r = boxRowStart;
             r < boxRowStart + sqrt; r++)
        {
            for (int d = boxColStart;
                 d < boxColStart + sqrt; d++)
            {
                if (board[r][d] == num)
                {// If there is a clash returns false
                    return false;
                }
            }
        }
        // If there is no clash returns true
        return true;
    }
    // Method to print the board
    public static void print(
            int[][] board, int N)
    {
        // Looping through the board to print
        for (int r = 0; r < N; r++)
        {
            for (int d = 0; d < N; d++)
            {
                System.out.print(board[r][d]);
                System.out.print(" ");
            }
            System.out.print("\n");

            if ((r + 1) % (int)Math.sqrt(N) == 0)
            {
                System.out.print("");
            }
        }
    }
}
