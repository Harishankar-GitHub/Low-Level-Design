public class TicTacToe_Optimized {

    private final int[][]  board;
    private final int n;
    private final int[] rowSum, colSum;
    private int diagonalSum, reverseDiagonalSum;
    private int winner;

    public TicTacToe_Optimized(final int n) {
        this.n = n;
        this.board = new int[n][n];
        rowSum = new int[n];
        colSum = new int[n];
    }

    // Makes a move on the board and returns the winner if the move is a winning move.
    // Player is either 0 or 1.
    // row and col are the move's row and the move's column index respectively.
    // Returns -1 if first player won, +1 if second player won, and 0 otherwise.
    // Throws IllegalArgumentException if the move is an invalid move.

    public int move(int player, int row, int col) throws IllegalArgumentException {

        // O(1) time | O(n) space
        // We have to check only the row, the column, the diagonal, and the reverse diagonal for each move to find if the move is a winning move,
        // and it is computed and stored at each move.

        if (row < 0 || col < 0 || row >= n || col >= n) {
            throw new IllegalArgumentException("Move out of board boundary!");
        } else if (board[row][col] != 0) {
            throw new IllegalArgumentException("Square is already occupied!");
        } else if (player != 0 && player != 1) {
            throw new IllegalArgumentException("Invalid player!");
        } else if (getWinner() != 0) {
            throw new IllegalArgumentException("Game is already over! Winner is: " + getWinner());
        } else {
            int currentPlayer = player == 0 ? -1 : +1;
            board[row][col] = currentPlayer;
            rowSum[row] += currentPlayer;
            colSum[col] += currentPlayer;

            if (row == col) diagonalSum += currentPlayer;
            if (row == n - 1 - col) reverseDiagonalSum += currentPlayer;

            if (Math.abs(rowSum[row]) == n || Math.abs(colSum[col]) == n || Math.abs(diagonalSum) == n || Math.abs(reverseDiagonalSum) == n) {
                winner = currentPlayer;
            }

            return getWinner();
        }
    }

    private int getWinner() {
        return winner;
    }
}
