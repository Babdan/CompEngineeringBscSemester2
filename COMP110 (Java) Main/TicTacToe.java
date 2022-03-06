// By Bogdan Itsam Dorantes-Nikolaev, COMP110, Instructor: Prof. Adem Karahoca (March 6th, 2022)

// importing the Scanner class
import java.util.Scanner;

// TicTacToe class
public class TicTacToe{
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        // Initialize the board
        char[][] board = new char[3][3];
        displayBoard(board);
        // Initialize the players
        while (true) {
            // Prompt the first player
            makeAMove(board, 'X');
        // Display the board
            displayBoard(board);
            // Check if the first player won
            if (hasWon('X', board)) {
                System.out.println("X player won");
                System.exit(1);
            }
            // Check if the game is a draw
            else if (isDraw(board)) {
                System.out.println("Nobody won");
                System.exit(2);
            }
            // Prompt the second player
            makeAMove(board, 'O');
            displayBoard(board);
            // Check if the game is over
            if (hasWon('O', board)) {
                System.out.println("O player won");
                System.exit(3);
            }
            // Check if the game is a draw
            else if (isDraw(board)) {
                System.out.println("Nobody won");
                System.exit(4);
            }
        }
    }
    // Method to prompt the player to make a move
    public static void makeAMove(char[][] board, char player) {
        // Boolean done to check if the player has made a move
        boolean done = false;
        do {
            int row, column;
            try {
                // Prompt the player to enter a column within range
                System.out.print("Enter a row (0, 1, or 2) for player " + player + ": ");
                row = input.nextInt();
                // Catch exception if the row is not in the range or if the row is not an integer
                if (row < 0 || row > 2) throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error: Invalid row!");
                continue;
            }
            try {
            // Prompt the player to enter a column
            System.out.print("Enter a column (0, 1, or 2) for player " + player + ": ");
            column = input.nextInt();
            // Check if the move is valid
            if (board[row][column] == '\u0000') { // an empty cell
                board[row][column] = player;
                done = true;
            }
            // If the move is invalid, prompt the player to enter again
            else
                System.out.println("This cell is already occupied. Please try a different cell");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error: Invalid column!");
            continue;
            }
        }
        // Prompt the player to enter again if the move is invalid
        while (!done);
    }
    // Method to display the board
    static void displayBoard(char[][] board) {
        System.out.println("\n-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++)
                System.out.print(board[i][j] != '\u0000' ?  board[i][j] + " | ": "  | ");
            System.out.println("\n-------------");
        }
    }
    // Method to check if the player has won
    public static boolean hasWon(char ch, char[][] board) {
        // Checks for horizontal wins
        for (int i = 0; i < 3; i++)
            if (ch == board[i][0] && ch == board[i][1] && ch == board[i][2]) return true;
        // Check for vertical wins
        for (int j = 0; j < 3; j++)
            if (ch == board[0][j] && ch == board[1][j] && ch == board[2][j]) return true;
        // Check for diagonal wins
        if (ch == board[0][0] && ch == board[1][1] && ch == board[2][2]) return true;
        // Check for sub-diagonal wins
        return ch == board[0][2] && ch == board[1][1] && ch == board[2][0];
        // If no wins, return false
    }
    // Method to check if the game is a draw
    public static boolean isDraw(char[][] board) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == '\u0000') return false;
        // If all cells are filled, return true
        return true;
    }
}