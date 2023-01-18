package kenny.TicTacToe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static kenny.TicTacToe.Mark.*;
import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {
    private Players player1;
    private Players player2;
    private Board board;
    @BeforeEach
    void setUp(){
        player1 = new Players(X);
        player2 = new Players(O);
        board = new Board();
    }
    @Test
    void testThatPlayerExist(){
        assertNotNull(player1);
        assertNotNull(player2);

    }
    @Test
    void testThatBoardExist(){
        assertNotNull(board);
    }
    @Test
    void testToCheckThatEachPlayerMarkIsValid(){
        assertEquals(X, player1.getMark());
        assertEquals(O, player2.getMark());
    }
    @Test
    void testThatBoardSurfaceCanBeDisplay(){
        board.getBoardSurfaceDisplay();
    }
    @Test
    void testThatXAppearWhenPlayerOnePlayOnTicTacToeBoard(){
        Mark[][] boardSurface = board.getBoardSurface();
        assertEquals(E, boardSurface[0][0]);
        player1.playGame(1,board);
        assertEquals(X, boardSurface[0][0]);
    }
    @Test
    void testThatYAppearsOnThePositionThatPlayerOneSelected(){
        Mark[][] boardSurface = board.getBoardSurface();
        assertEquals(E, boardSurface[1][1]);
        player2.playGame(5, board);
        assertEquals(O,boardSurface[1][1] );
    }
    @Test
    void testThatXAppearsOnThePositionThatPlayerOneSelected(){
        Mark[][] boardSurface = board.getBoardSurface();
        assertEquals(E, boardSurface[2][1]);
        player1.playGame(8, board);
        assertEquals(X, boardSurface[2][1]);
    }
    @Test
    void testThatExceptionsBeThrownIfAPlayerSelectPositionThatDoesntExist(){
        Mark[][] boardSurface = board.getBoardSurface();
        assertThrows(ArrayIndexOutOfBoundsException.class, ()->player1.playGame(0, board));
    }
    @Test
    void testThatAPlayerCanOnlyPlayToAPositionThatIsEmpty(){
        Mark[][] boardSurface = board.getBoardSurface();
        assertEquals(E, boardSurface[0][0]);
        player1.playGame(1, board);
        assertEquals(X, boardSurface[0][0]);
        assertThrows(TicTacToeExceptions.class, ()->player2.playGame(1, board));
        assertEquals(X, boardSurface[0][0]);
    }
    @Test
    void testForWinnerBetweenTheTwoPlayersInTheZeroRow(){
        Mark[][] boardSurface = board.getBoardSurface();
        assertEquals(E, boardSurface[0][0]);
        player1.playGame(1,board);
        player1.playGame(2, board);
        player1.playGame(3, board);
        assertTrue(board.isWinner());
    }
    @Test
    void testForWinnerBetweenTheTwoPlayersInTheFirstRow(){
        Mark[][] boardSurface = board.getBoardSurface();
        assertEquals(E, boardSurface[0][0]);
        player2.playGame(4, board);
        player2.playGame(5, board);
        player2.playGame(6, board);
        assertTrue(board.isWinner());
    }
    @Test
    void testForWinnerBetweenTheTwoPlayersInTheSecondRow(){
        Mark[][] boardSurface = board.getBoardSurface();
        assertEquals(E, boardSurface[0][0]);
        player1.playGame(7, board);
        assertEquals(X, boardSurface[2][0]);
        player1.playGame(8, board);
        assertEquals(X, boardSurface[2][1]);
        player1.playGame(9, board);
        assertTrue(board.isWinner());
    }
    @Test
    void testForWinnerBetweenTheTwoPlayersInTheColumnZero(){
        Mark[][] boardSurface = board.getBoardSurface();
        assertEquals(E, boardSurface[0][0]);
        player2.playGame(1, board);
        player2.playGame(4, board);
        player2.playGame(7, board);
        assertTrue(board.isWinner());

    }
    @Test
    void testForWinnerBetweenTheTwoPlayersInTheColumnOne(){
        Mark[][] boardSurface = board.getBoardSurface();

        player1.playGame(2, board);
        player1.playGame(5, board);
        player1.playGame(8, board);
        assertTrue(board.isWinner());
    }
    @Test
    void testForWinnerBetweenTheTwoPlayersInTheColumnTwo(){
        Mark[][] boardSurface = board.getBoardSurface();
        assertEquals(E, boardSurface[0][0]);
        player2.playGame(3, board);
        player2.playGame(6, board);
        player2.playGame(9, board);
        assertTrue(board.isWinner());
    }
    @Test
    void testForWinnerBetweenTheTwoPlayersInTheDiagonal(){
        Mark[][] boardSurface = board.getBoardSurface();
        assertEquals(E, boardSurface[0][0]);
        player1.playGame(1, board);
        player1.playGame(5, board);
        player1.playGame(9, board);
        assertTrue(board.isWinner());
    }
    @Test
    void testForWinnerBetweenThePlayersInTheSecondDiagonal(){
        Mark[][] boardSurface = board.getBoardSurface();
        assertEquals(E, boardSurface[0][0]);
        player1.playGame(3, board);
        player1.playGame(5, board);
        player1.playGame(7, board);
        assertTrue(board.isWinner());
    }
    @Test
    void testThatReturnsTrueIfThereIsATie(){
        player1.playGame(1,board);
        player1.playGame(2,board);
        player2.playGame(3,board);
        player2.playGame(4,board);
        player2.playGame(5,board);
        player1.playGame(6,board);
        player1.playGame(7,board);
        player2.playGame(8,board);
        player1.playGame(9,board);
        assertTrue(board.isATie());
    }

    @Test
    void testThatReturnsTrueIfThereIsAWinner(){
        player1.playGame(1,board);
        player1.playGame(2,board);
        player2.playGame(3,board);
        player1.playGame(4,board);
        player1.playGame(5,board);
        player2.playGame(6,board);
        player2.playGame(7,board);
        player1.playGame(8,board);
        player1.playGame(9,board);
        assertTrue(board.isWinner());
        //assertTrue(board.isATie());
    }


}