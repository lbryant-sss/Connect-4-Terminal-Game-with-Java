import java.util.Scanner;

public class Main {
    private static final int ROWS = 6;
    private static final int COLS = 7;
    private static final char EMPTY = '-';
    private static char[][] board = new char[ROWS][COLS];
    private static final char HUMAN_PLAYER = 'R';
    private static final char AI_PLAYER = 'Y';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Connect Four!");
        System.out.println("Select the mode of the game:");
        System.out.println("1. 2 Player (2 Human Players)");
        System.out.println("2. 1 Player (Human vs AI)");

        int choice = scanner.nextInt();
        if (choice == 1) {
            playTwoPlayerGame(scanner);
        } else if (choice == 2) {
            playSinglePlayerGame(scanner);
        } else {
            System.out.println("Invalid choice. Exiting...");
        }
    }

    private static void initializeBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    private static void printBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isValidMove(int col) {
        return col >= 0 && col < COLS && board[0][col] == EMPTY;
    }

    private static void dropPiece(char player, int col) {
        for (int i = ROWS - 1; i >= 0; i--) {
            if (board[i][col] == EMPTY) {
                board[i][col] = player;
                break;
            }
        }
    }

    private static boolean checkWin(char player) {
        // Check horizontal
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j <= COLS - 4; j++) {
                if (board[i][j] == player && board[i][j + 1] == player && board[i][j + 2] == player && board[i][j + 3] == player) {
                    return true;
                }
            }
        }

        // Check vertical
        for (int j = 0; j < COLS; j++) {
            for (int i = 0; i <= ROWS - 4; i++) {
                if (board[i][j] == player && board[i + 1][j] == player && board[i + 2][j] == player && board[i + 3][j] == player) {
                    return true;
                }
            }
        }

        // Check diagonal \
        for (int i = 0; i <= ROWS - 4; i++) {
            for (int j = 0; j <= COLS - 4; j++) {
                if (board[i][j] == player && board[i + 1][j + 1] == player && board[i + 2][j + 2] == player && board[i + 3][j + 3] == player) {
                    return true;
                }
            }
        }

        // Check diagonal /
        for (int i = 0; i <= ROWS - 4; i++) {
            for (int j = COLS - 1; j >= 3; j--) {
                if (board[i][j] == player && board[i + 1][j - 1] == player && board[i + 2][j - 2] == player && board[i + 3][j - 3] == player) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean isBoardFull() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (board[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void playTwoPlayerGame(Scanner scanner) {
        initializeBoard();
        char currentPlayer = 'R';

        while (true) {
            printBoard();
            System.out.println("Player " + currentPlayer + "'s turn. Enter column number (0-6):");
            int col = scanner.nextInt();

            if (isValidMove(col)) {
                dropPiece(currentPlayer, col);
                if (checkWin(currentPlayer)) {
                    printBoard();
                    System.out.println("Player " + currentPlayer + " wins!");
                    break;
                }
                if (isBoardFull()) {
                    printBoard();
                    System.out.println("It's a draw!");
                    break;
                }
                currentPlayer = (currentPlayer == 'R') ? 'Y' : 'R';
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }

    private static void playSinglePlayerGame(Scanner scanner) {
        initializeBoard();
        char currentPlayer = HUMAN_PLAYER;

        while (true) {
            printBoard();
            if (currentPlayer == HUMAN_PLAYER) {
                System.out.println("Your turn. Enter column number (0-6):");
                int col = scanner.nextInt();
                if (isValidMove(col)) {
                    dropPiece(currentPlayer, col);
                    if (checkWin(currentPlayer)) {
                        printBoard();
                        System.out.println("Congratulations! You win!");
                        break;
                    }
                    if (isBoardFull()) {
                        printBoard();
                        System.out.println("It's a draw!");
                        break;
                    }
                    currentPlayer = AI_PLAYER;
                } else {
                    System.out.println("Invalid move. Try again.");
                }
            } else {
                // AI's turn
                int aiMove = getAIMove();
                dropPiece(currentPlayer, aiMove);
                if (checkWin(currentPlayer)) {
                    printBoard();
                    System.out.println("The AI wins!");
                    break;
                }
                if (isBoardFull()) {
                    printBoard();
                    System.out.println("It's a draw!");
                    break;
                }
                currentPlayer = HUMAN_PLAYER;
            }
        }
    }

    private static int getAIMove() {
        for (int col = 0; col < COLS; col++) {
            if (isValidMove(col)) {
                return col;
            }
        }
        return -1; // No valid move found (should not happen)
    }
}
