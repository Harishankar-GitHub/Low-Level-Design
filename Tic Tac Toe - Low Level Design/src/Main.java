public class Main {

    public static void main(String[] args) {

        System.out.println("-----Tic Tac Toe - Draw Game - Start-----");
        TicTacToe drawGame = new TicTacToe(3);  // Returns 0 because it is a draw game.
        System.out.println(drawGame.move(0, 0, 0));
        System.out.println(drawGame.move(1, 1, 1));
        System.out.println(drawGame.move(0, 2, 0));
        System.out.println(drawGame.move(1, 1, 0));
        System.out.println(drawGame.move(0, 1, 2));
        System.out.println(drawGame.move(1, 2, 1));
        System.out.println(drawGame.move(0, 0, 1));
        System.out.println(drawGame.move(1, 0, 2));
        System.out.println(drawGame.move(0, 2, 2));
        System.out.println("-----Tic Tac Toe - Draw Game - End-----");

        System.out.println("-----Tic Tac Toe - First Player Wins Game - Start-----");
        TicTacToe firstPlayerWinsGame = new TicTacToe(3);   // Returns -1 because player 1 wins the game.
        System.out.println(firstPlayerWinsGame.move(0, 0, 0));
        System.out.println(firstPlayerWinsGame.move(1, 0, 2));
        System.out.println(firstPlayerWinsGame.move(0, 1, 0));
        System.out.println(firstPlayerWinsGame.move(1, 2, 2));
        System.out.println(firstPlayerWinsGame.move(0, 2, 0));
        System.out.println("-----Tic Tac Toe - First Player Wins Game - End-----");

        System.out.println("-----Tic Tac Toe - Optimized - Draw Game - Start-----");
        TicTacToe_Optimized drawGame_Optimized = new TicTacToe_Optimized(3);    // Returns 0 because it is a draw game.
        System.out.println(drawGame_Optimized.move(0, 0, 0));
        System.out.println(drawGame_Optimized.move(1, 1, 1));
        System.out.println(drawGame_Optimized.move(0, 2, 0));
        System.out.println(drawGame_Optimized.move(1, 1, 0));
        System.out.println(drawGame_Optimized.move(0, 1, 2));
        System.out.println(drawGame_Optimized.move(1, 2, 1));
        System.out.println(drawGame_Optimized.move(0, 0, 1));
        System.out.println(drawGame_Optimized.move(1, 0, 2));
        System.out.println(drawGame_Optimized.move(0, 2, 2));
        System.out.println("-----Tic Tac Toe - Optimized - Draw Game - End-----");

        System.out.println("-----Tic Tac Toe - Optimized - First Player Wins Game - Start-----");
        TicTacToe_Optimized firstPlayerWinsGame_Optimized = new TicTacToe_Optimized(3); // Returns -1 because player 1 wins the game.
        System.out.println(firstPlayerWinsGame_Optimized.move(0, 0, 0));
        System.out.println(firstPlayerWinsGame_Optimized.move(1, 0, 2));
        System.out.println(firstPlayerWinsGame_Optimized.move(0, 1, 0));
        System.out.println(firstPlayerWinsGame_Optimized.move(1, 2, 2));
        System.out.println(firstPlayerWinsGame_Optimized.move(0, 2, 0));
        System.out.println("-----Tic Tac Toe - Optimized - First Player Wins Game - End-----");
    }
}
