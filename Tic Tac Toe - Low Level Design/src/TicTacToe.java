public class TicTacToe {

    private final int[][]  board;
    private final int n;

    public TicTacToe(final int n) {
        this.n = n;
        this.board = new int[n][n];
    }

    // Makes a move on the board and returns the winner if the move is a winning move.
    // Player is either 0 or 1.
    // row and col are the move's row and the move's column index respectively.
    // Returns -1 if first player won, +1 if second player won, and 0 otherwise.
    // Throws IllegalArgumentException if the move is an invalid move.

    public int move(int player, int row, int col) throws IllegalArgumentException {

        // O(n^2) time | O(n) space
        // We have to check all rows and columns on each move to find if the move is a winning move.

        if (row < 0 || col < 0 || row >= n || col >= n) {
            throw new IllegalArgumentException("Move out of board boundary!");
        } else if (board[row][col] != 0) {
            throw new IllegalArgumentException("Square is already occupied!");
        } else if (player != 0 && player != 1) {
            throw new IllegalArgumentException("Invalid player!");
        } else {
            int currentPlayer = player == 0 ? -1 : +1;
            board[row][col] = currentPlayer;
            boolean winRow = true, winCol = true, winDiagonal = true, winReverseDiagonal = true;

            for (int i = 0; i < n; i++) {
                if (board[row][i] != currentPlayer) {
                    winRow = false;
                }
                if (board[i][col] != currentPlayer) {
                    winCol = false;
                }
                if (board[i][i] != currentPlayer) {
                    winDiagonal = false;
                }
                if (board[i][n - 1 - i] != currentPlayer) {
                    winReverseDiagonal = false;
                }
            }

            if (winRow || winCol || winDiagonal || winReverseDiagonal) {
                return currentPlayer;
            } else {
                return 0;
            }
        }
    }
}
