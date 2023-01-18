package kenny.TicTacToe;

import static kenny.TicTacToe.Mark.*;

public class Players {
    private Mark mark;


    public Players(Mark mark) {
        this.mark = mark;
    }

    public Mark getMark() {

        return mark;
    }

    public void playGame(int position, Board board) {
        var boardSurface = board.getBoardSurface();
        if (position <= 0 || position > 9) {
            throw new ArrayIndexOutOfBoundsException("Invalid Input");
        } else {
            int row = 0;
            int val = 0;
            int column = position - 1;
            if (position > 3) {
                val = position - 3;
                row = 1;
                column = val - 1;
            }
            if (position > 6) {
                val = position - 6;
                row = 2;
                column = val - 1;
            }
            if (boardSurface[row][column] == E){
                boardSurface[row][column] = mark;
            }else {
                throw new TicTacToeExceptions("Player Can only play on empty board");
            }

        }
    }
}