package kenny.TicTacToe;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import static java.lang.System.exit;
import static kenny.TicTacToe.Mark.O;
import static kenny.TicTacToe.Mark.X;

public class Main {
    private static Random random = new Random();
    private static Scanner scanner = new Scanner(System.in);
    private static Board board = new Board();
    private static Players player1 = new Players(X);
    private static Players player2 = new Players(O);

    public static void main(String[] args) {
        startTicTacToe();
    }

    private static void startTicTacToe() {
        startGame();
    }

    private static void startGame() {
        boardSurfaceUpdate();
        prompt("""
                1.Play with Human
                2.Play with Computer
                3.Exit
                """);
        prompt("Select an Option");

        int option = 0;
        try {

            prompt("Enter a valid number");
             option += scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.nextLine();
            startGame();

        }
        switch (option){
            case 1: playWithHuman();
            case 2: playWithComputer();
            case 3: exit(3);
        }
    }

    private static void playWithComputer() {
        prompt("Player 1, Enter Position");
        playerOneMove();
        prompt("Player 2, Enter Position");
        computerMove();
        playWithComputer();
    }



    private static void playWithHuman() {
        prompt("Player 1 Enter Game position");
        playerOneMove();
        prompt("Player 2, Enter Game Position");
        playerTwoMove();
        playWithHuman();

    }

    private static void playerTwoMove() {
        try{
            int playerOnePosition = scanner.nextInt();
            player2.playGame(playerOnePosition, board);
            boardSurfaceUpdate();
            if (board.isWinner()){
                prompt("Player 2 is the winner");
                exit(3);
            }
            if (board.isATie()){
                prompt("It is a Tie, Restart Game");
                exit(3);
            }
        } catch (ArrayIndexOutOfBoundsException | TicTacToeExceptions | InputMismatchException e) {
            prompt(e.getMessage());
            prompt("Enter a valid number");
            scanner.nextLine();
            playerTwoMove();
        }
    }

    private static void playerOneMove() {
        try{
            int playerTwoPosition = scanner.nextInt();
            player1.playGame(playerTwoPosition, board);
            boardSurfaceUpdate();
            if (board.isWinner()) {
                prompt("Player 1 is the winner");
                exit(3);
            }
            if (board.isATie()){
                prompt("It is a Tie, Restart Game");
                exit(3);
            }
        } catch (ArrayIndexOutOfBoundsException | TicTacToeExceptions | InputMismatchException e) {
            prompt(e.getMessage());
            prompt("Enter a valid number");
            scanner.nextLine();
            playerOneMove();
        }
    }
    private static void computerMove() {
        try{
            int computerPosition = (1 + random.nextInt(8));
            player2.playGame(computerPosition, board);
            boardSurfaceUpdate();
            if (board.isWinner()){
                prompt("Computer is the winner");
                exit(3);
            }
            if (board.isATie()){
                prompt("It is a Tie, Restart Game");
                exit(3);
            }
        } catch (TicTacToeExceptions  e) {
            prompt(e.getMessage());
            prompt("Enter a valid number");
            computerMove();
        }

    }
    private static void boardSurfaceUpdate(){
        board.getBoardSurfaceDisplay();
    }

    private static void prompt(String promptMessage){
        System.out.println(promptMessage);
    }
    private static int userInput(){
        prompt("user position");
        return scanner.nextInt();
    }

}
