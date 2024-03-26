import java.util.Objects;
import java.util.Scanner;

/**
 * This class implements a simple Tic Tac Toe game.
 */
public class Main {
    // Constants for board dimensions
    private static final int ROW = 3;
    private static final int COL = 3;

    // The game board
    private static String[][] board = new String[ROW][COL];

    // Counter for the number of moves
    private static int move = 0;

    /**
     * The main method that initiates the game.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String player = "X";
        boolean stillPlay = true;
        boolean cont = false;
        clearBoard(); // Initialize the game board

        while (stillPlay) {
            while (!cont) {
                display(); // Display the current state of the game board
                int row = (SafeInput.getRangedInt(in, "Please enter A row (1-3)", 1, 3) - 1);
                int col = (SafeInput.getRangedInt(in, "Please enter A col(1-3)", 1, 3) - 1);
                if (isValidMove(row, col)) {
                    board[row][col] = player; // Place the player's symbol on the board
                    move += 1; // Increment move count

                    // Check for win or tie conditions
                    if (isWin(player)) {
                        stillPlay = false;
                        System.out.println(player + " won the game!");
                        display();
                    } else if (isTie()) {
                        System.out.println("It was a tie");
                        stillPlay = false;
                        display();
                    }

                    // Switch player after each move
                    player = (Objects.equals(player, "X")) ? "O" : "X";
                    cont = true;
                } else {
                    System.out.println("Please enter an open spot");
                }
            }
            cont = false;
        }
    }

    /**
     * Clears the game board.
     */
    private static void clearBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = " ";
            }
        }
    }

    /**
     * Displays the current state of the game board.
     */
    private static void display() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println("");
        }
    }

    /**
     * Checks if a move is valid (i.e., the spot is empty).
     */
    private static boolean isValidMove(int row, int col) {
        return Objects.equals(board[row][col], " ");
    }

    /**
     * Checks if the specified player has won the game.
     */
    private static boolean isWin(String player) {
        return isRowWin(player) || isColWin(player) || isDiagonalWin(player);
    }

    /**
     * Checks for a row win for the specified player.
     */
    private static boolean isRowWin(String player) {
        for (int i = 0; i < 3; i++) {
            if (Objects.equals(board[i][0], player) && Objects.equals(board[i][1], player) && Objects.equals(board[i][2], player)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks for a column win for the specified player.
     */
    private static boolean isColWin(String player) {
        for (int i = 0; i < 3; i++) {
            if (Objects.equals(board[0][i], player) && Objects.equals(board[1][i], player) && Objects.equals(board[2][i], player)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks for a diagonal win for the specified player.
     */
    private static boolean isDiagonalWin(String player) {
        if (Objects.equals(board[0][0], player) && Objects.equals(board[1][1], player) && Objects.equals(board[2][2], player)) {
            return true;
        } else if (Objects.equals(board[0][2], player) && Objects.equals(board[1][1], player) && Objects.equals(board[2][0], player)) {
            return true;
        }
        return false;
    }

    /**
     * Checks for a tie condition.
     */
    private static boolean isTie() {
        StringBuilder test = new StringBuilder();

        if (move == 9) {
            return true; // All spaces on the board are filled
        } else if (move >= 7) { // Check if a tie is possible (minimum moves required for a tie)

            // Check rows and columns for potential win vectors
            for (int a = 0; a < 2; a++) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (a == 0) {
                            test.append(board[i][j]);
                        } else {
                            test.append(board[j][i]);
                        }
                    }
                    if (!test.toString().contains("X") && test.toString().contains("O")) {
                        return false; // One of the win vectors is blocked by having both X and O
                    } else {
                        test = new StringBuilder();
                    }
                }
            }

            // Check main diagonal
            test.append(board[0][0]);
            test.append(board[1][1]);
            test.append(board[2][2]);
            if (!test.toString().contains("X") && test.toString().contains("O")) {
                return false; // Main diagonal is blocked by both X and O
            } else {
                test = new StringBuilder();
            }

            // Check anti-diagonal
            test.append(board[0][2]);
            test.append(board[1][1]);
            test.append(board[2][0]);
            if (!test.toString().contains("X") && test.toString().contains("O")) {
                return false; // Anti-diagonal is blocked by both X and O
            }
            return true; // No win vectors are blocked by both X and O
        }

        return false;
    }
}