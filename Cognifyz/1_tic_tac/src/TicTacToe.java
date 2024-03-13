import java.util.Scanner;

public class TicTacToe {
    private static final int ROWS = 3;
    private static final int COLS = 3;
    private static final char EMPTY = ' ';
    private static char[][] board = new char[ROWS][COLS];
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            initializeBoard();
            boolean gameWon = false;
            boolean draw = false;

            while (!gameWon && !draw) {
                displayBoard();
                System.out.println("Player " + currentPlayer + "'s turn. Enter row (0-2) and column (0-2):");
                int row = scanner.nextInt();
                int col = scanner.nextInt();

                if (isValidMove(row, col)) {
                    board[row][col] = currentPlayer;
                    if (checkWin(row, col)) {
                        gameWon = true;
                        displayBoard();
                        System.out.println("Player " + currentPlayer + " wins!");
                    } else if (checkDraw()) {
                        draw = true;
                        displayBoard();
                        System.out.println("It's a draw!");
                    } else {
                        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                    }
                } else {
                    System.out.println("Invalid move. Try again.");
                }
            }

            System.out.println("Do you want to play again? (yes/no)");
            String playAgainInput = scanner.next();
            playAgain = playAgainInput.equalsIgnoreCase("yes");
        }
        scanner.close();
    }

    private static void initializeBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    private static void displayBoard() {
        System.out.println("  0 1 2");
        for (int i = 0; i < ROWS; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < COLS; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isValidMove(int row, int col) {
        return row >= 0 && row < ROWS && col >= 0 && col < COLS && board[row][col] == EMPTY;
    }

    private static boolean checkWin(int row, int col) {
        return (board[row][0] == currentPlayer && board[row][1] == currentPlayer && board[row][2] == currentPlayer) ||
               (board[0][col] == currentPlayer && board[1][col] == currentPlayer && board[2][col] == currentPlayer) ||
               (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
               (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer);
    }

    private static boolean checkDraw() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (board[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
}
